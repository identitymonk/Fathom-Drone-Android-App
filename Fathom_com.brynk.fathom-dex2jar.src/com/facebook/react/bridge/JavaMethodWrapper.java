package com.facebook.react.bridge;

import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class JavaMethodWrapper
  implements NativeModule.NativeMethod
{
  private static final ArgumentExtractor<ReadableNativeArray> ARGUMENT_EXTRACTOR_ARRAY;
  private static final ArgumentExtractor<Boolean> ARGUMENT_EXTRACTOR_BOOLEAN = new ArgumentExtractor()
  {
    public Boolean extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
    {
      return Boolean.valueOf(paramReadableNativeArray.getBoolean(paramInt));
    }
  };
  private static final ArgumentExtractor<Callback> ARGUMENT_EXTRACTOR_CALLBACK;
  private static final ArgumentExtractor<Double> ARGUMENT_EXTRACTOR_DOUBLE = new ArgumentExtractor()
  {
    public Double extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
    {
      return Double.valueOf(paramReadableNativeArray.getDouble(paramInt));
    }
  };
  private static final ArgumentExtractor<Dynamic> ARGUMENT_EXTRACTOR_DYNAMIC;
  private static final ArgumentExtractor<Float> ARGUMENT_EXTRACTOR_FLOAT = new ArgumentExtractor()
  {
    public Float extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
    {
      return Float.valueOf((float)paramReadableNativeArray.getDouble(paramInt));
    }
  };
  private static final ArgumentExtractor<Integer> ARGUMENT_EXTRACTOR_INTEGER = new ArgumentExtractor()
  {
    public Integer extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
    {
      return Integer.valueOf((int)paramReadableNativeArray.getDouble(paramInt));
    }
  };
  private static final ArgumentExtractor<ReadableMap> ARGUMENT_EXTRACTOR_MAP;
  private static final ArgumentExtractor<Promise> ARGUMENT_EXTRACTOR_PROMISE;
  private static final ArgumentExtractor<String> ARGUMENT_EXTRACTOR_STRING = new ArgumentExtractor()
  {
    public String extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
    {
      return paramReadableNativeArray.getString(paramInt);
    }
  };
  private static final boolean DEBUG;

  @Nullable
  private ArgumentExtractor[] mArgumentExtractors;

  @Nullable
  private Object[] mArguments;
  private boolean mArgumentsProcessed = false;

  @Nullable
  private int mJSArgumentsNeeded;
  private final Method mMethod;
  private final JavaModuleWrapper mModuleWrapper;
  private final int mParamLength;
  private final Class[] mParameterTypes;

  @Nullable
  private String mSignature;
  private String mType = "async";

  static
  {
    ARGUMENT_EXTRACTOR_ARRAY = new ArgumentExtractor()
    {
      public ReadableNativeArray extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
      {
        return paramReadableNativeArray.getArray(paramInt);
      }
    };
    ARGUMENT_EXTRACTOR_DYNAMIC = new ArgumentExtractor()
    {
      public Dynamic extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
      {
        return DynamicFromArray.create(paramReadableNativeArray, paramInt);
      }
    };
    ARGUMENT_EXTRACTOR_MAP = new ArgumentExtractor()
    {
      public ReadableMap extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
      {
        return paramReadableNativeArray.getMap(paramInt);
      }
    };
    ARGUMENT_EXTRACTOR_CALLBACK = new ArgumentExtractor()
    {
      @Nullable
      public Callback extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
      {
        if (paramReadableNativeArray.isNull(paramInt))
          return null;
        return new CallbackImpl(paramJSInstance, (int)paramReadableNativeArray.getDouble(paramInt));
      }
    };
    ARGUMENT_EXTRACTOR_PROMISE = new ArgumentExtractor()
    {
      public Promise extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt)
      {
        return new PromiseImpl((Callback)JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(paramJSInstance, paramReadableNativeArray, paramInt), (Callback)JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(paramJSInstance, paramReadableNativeArray, paramInt + 1));
      }

      public int getJSArgumentsNeeded()
      {
        return 2;
      }
    };
    DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.BRIDGE_CALLS);
  }

  public JavaMethodWrapper(JavaModuleWrapper paramJavaModuleWrapper, Method paramMethod, boolean paramBoolean)
  {
    this.mModuleWrapper = paramJavaModuleWrapper;
    this.mMethod = paramMethod;
    this.mMethod.setAccessible(true);
    this.mParameterTypes = this.mMethod.getParameterTypes();
    this.mParamLength = this.mParameterTypes.length;
    if (paramBoolean)
      this.mType = "sync";
    do
      return;
    while ((this.mParamLength <= 0) || (this.mParameterTypes[(this.mParamLength - 1)] != Promise.class));
    this.mType = "promise";
  }

  private ArgumentExtractor[] buildArgumentExtractors(Class[] paramArrayOfClass)
  {
    ArgumentExtractor[] arrayOfArgumentExtractor = new ArgumentExtractor[paramArrayOfClass.length];
    int i = 0;
    if (i < paramArrayOfClass.length)
    {
      Class localClass = paramArrayOfClass[i];
      if ((localClass == Boolean.class) || (localClass == Boolean.TYPE))
        arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_BOOLEAN;
      while (true)
      {
        i += arrayOfArgumentExtractor[i].getJSArgumentsNeeded();
        break;
        if ((localClass == Integer.class) || (localClass == Integer.TYPE))
        {
          arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_INTEGER;
          continue;
        }
        if ((localClass == Double.class) || (localClass == Double.TYPE))
        {
          arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_DOUBLE;
          continue;
        }
        if ((localClass == Float.class) || (localClass == Float.TYPE))
        {
          arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_FLOAT;
          continue;
        }
        if (localClass == String.class)
        {
          arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_STRING;
          continue;
        }
        if (localClass == Callback.class)
        {
          arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_CALLBACK;
          continue;
        }
        if (localClass == Promise.class)
        {
          arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_PROMISE;
          if (i == paramArrayOfClass.length - 1);
          for (boolean bool = true; ; bool = false)
          {
            Assertions.assertCondition(bool, "Promise must be used as last parameter only");
            break;
          }
        }
        if (localClass == ReadableMap.class)
        {
          arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_MAP;
          continue;
        }
        if (localClass == ReadableArray.class)
        {
          arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_ARRAY;
          continue;
        }
        if (localClass != Dynamic.class)
          break label253;
        arrayOfArgumentExtractor[i] = ARGUMENT_EXTRACTOR_DYNAMIC;
      }
      label253: throw new RuntimeException("Got unknown argument class: " + localClass.getSimpleName());
    }
    return arrayOfArgumentExtractor;
  }

  private String buildSignature(Method paramMethod, Class[] paramArrayOfClass, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfClass.length + 2);
    int i;
    if (paramBoolean)
    {
      localStringBuilder.append(returnTypeToChar(paramMethod.getReturnType()));
      localStringBuilder.append('.');
      i = 0;
      label41: if (i >= paramArrayOfClass.length)
        break label111;
      paramMethod = paramArrayOfClass[i];
      if (paramMethod == Promise.class)
        if (i != paramArrayOfClass.length - 1)
          break label106;
    }
    label106: for (paramBoolean = true; ; paramBoolean = false)
    {
      Assertions.assertCondition(paramBoolean, "Promise must be used as last parameter only");
      localStringBuilder.append(paramTypeToChar(paramMethod));
      i += 1;
      break label41;
      localStringBuilder.append("v.");
      break;
    }
    label111: return localStringBuilder.toString();
  }

  private int calculateJSArgumentsNeeded()
  {
    int j = 0;
    ArgumentExtractor[] arrayOfArgumentExtractor = (ArgumentExtractor[])Assertions.assertNotNull(this.mArgumentExtractors);
    int k = arrayOfArgumentExtractor.length;
    int i = 0;
    while (i < k)
    {
      j += arrayOfArgumentExtractor[i].getJSArgumentsNeeded();
      i += 1;
    }
    return j;
  }

  private static char commonTypeToChar(Class paramClass)
  {
    if (paramClass == Boolean.TYPE)
      return 'z';
    if (paramClass == Boolean.class)
      return 'Z';
    if (paramClass == Integer.TYPE)
      return 'i';
    if (paramClass == Integer.class)
      return 'I';
    if (paramClass == Double.TYPE)
      return 'd';
    if (paramClass == Double.class)
      return 'D';
    if (paramClass == Float.TYPE)
      return 'f';
    if (paramClass == Float.class)
      return 'F';
    if (paramClass == String.class)
      return 'S';
    return '\000';
  }

  private String getAffectedRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 1)
      return "" + paramInt1 + "-" + (paramInt1 + paramInt2 - 1);
    return "" + paramInt1;
  }

  private static char paramTypeToChar(Class paramClass)
  {
    int i = commonTypeToChar(paramClass);
    if (i != 0)
      return i;
    if (paramClass == Callback.class)
      return 'X';
    if (paramClass == Promise.class)
      return 'P';
    if (paramClass == ReadableMap.class)
      return 'M';
    if (paramClass == ReadableArray.class)
      return 'A';
    if (paramClass == Dynamic.class)
      return 'Y';
    throw new RuntimeException("Got unknown param class: " + paramClass.getSimpleName());
  }

  private void processArguments()
  {
    if (this.mArgumentsProcessed)
      return;
    SystraceMessage.beginSection(0L, "processArguments").arg("method", this.mModuleWrapper.getName() + "." + this.mMethod.getName()).flush();
    try
    {
      this.mArgumentsProcessed = true;
      this.mArgumentExtractors = buildArgumentExtractors(this.mParameterTypes);
      this.mSignature = buildSignature(this.mMethod, this.mParameterTypes, this.mType.equals("sync"));
      this.mArguments = new Object[this.mParameterTypes.length];
      this.mJSArgumentsNeeded = calculateJSArgumentsNeeded();
      return;
    }
    finally
    {
      SystraceMessage.endSection(0L).flush();
    }
    throw localObject;
  }

  private static char returnTypeToChar(Class paramClass)
  {
    int i = commonTypeToChar(paramClass);
    if (i != 0)
      return i;
    if (paramClass == Void.TYPE)
      return 'v';
    if (paramClass == WritableMap.class)
      return 'M';
    if (paramClass == WritableArray.class)
      return 'A';
    throw new RuntimeException("Got unknown return class: " + paramClass.getSimpleName());
  }

  public Method getMethod()
  {
    return this.mMethod;
  }

  public String getSignature()
  {
    if (!this.mArgumentsProcessed)
      processArguments();
    return (String)Assertions.assertNotNull(this.mSignature);
  }

  public String getType()
  {
    return this.mType;
  }

  public void invoke(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray)
  {
    String str = this.mModuleWrapper.getName() + "." + this.mMethod.getName();
    SystraceMessage.beginSection(0L, "callJavaModuleMethod").arg("method", str).flush();
    if (DEBUG)
      PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.BRIDGE_CALLS, "JS->Java: %s.%s()", new Object[] { this.mModuleWrapper.getName(), this.mMethod.getName() });
    try
    {
      if (!this.mArgumentsProcessed)
        processArguments();
      if ((this.mArguments == null) || (this.mArgumentExtractors == null))
        throw new Error("processArguments failed");
    }
    finally
    {
      SystraceMessage.endSection(0L).flush();
    }
    if (this.mJSArgumentsNeeded != paramReadableNativeArray.size())
      throw new NativeArgumentsParseException(str + " got " + paramReadableNativeArray.size() + " arguments, expected " + this.mJSArgumentsNeeded);
    int i = 0;
    int j = 0;
    try
    {
      while (i < this.mArgumentExtractors.length)
      {
        this.mArguments[i] = this.mArgumentExtractors[i].extractArgument(paramJSInstance, paramReadableNativeArray, j);
        int k = this.mArgumentExtractors[i].getJSArgumentsNeeded();
        j += k;
        i += 1;
      }
    }
    catch (UnexpectedNativeTypeException paramJSInstance)
    {
      throw new NativeArgumentsParseException(paramJSInstance.getMessage() + " (constructing arguments for " + str + " at argument index " + getAffectedRange(j, this.mArgumentExtractors[i].getJSArgumentsNeeded()) + ")", paramJSInstance);
    }
    try
    {
      this.mMethod.invoke(this.mModuleWrapper.getModule(), this.mArguments);
      SystraceMessage.endSection(0L).flush();
      return;
    }
    catch (java.lang.IllegalArgumentException paramJSInstance)
    {
      throw new RuntimeException("Could not invoke " + str, paramJSInstance);
    }
    catch (java.lang.IllegalAccessException paramJSInstance)
    {
      throw new RuntimeException("Could not invoke " + str, paramJSInstance);
    }
    catch (InvocationTargetException paramJSInstance)
    {
      if ((paramJSInstance.getCause() instanceof RuntimeException))
        throw ((RuntimeException)paramJSInstance.getCause());
    }
    throw new RuntimeException("Could not invoke " + str, paramJSInstance);
  }

  private static abstract class ArgumentExtractor<T>
  {
    @Nullable
    public abstract T extractArgument(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray, int paramInt);

    public int getJSArgumentsNeeded()
    {
      return 1;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaMethodWrapper
 * JD-Core Version:    0.6.0
 */