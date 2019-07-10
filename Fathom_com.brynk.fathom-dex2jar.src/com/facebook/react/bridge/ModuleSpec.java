package com.facebook.react.bridge;

import java.lang.reflect.Constructor;
import javax.annotation.Nullable;
import javax.inject.Provider;

public class ModuleSpec
{
  private static final Class[] CONTEXT_SIGNATURE;
  private static final Class[] EMPTY_SIGNATURE = new Class[0];
  private final Provider<? extends NativeModule> mProvider;
  private final Class<? extends NativeModule> mType;

  static
  {
    CONTEXT_SIGNATURE = new Class[] { ReactApplicationContext.class };
  }

  public ModuleSpec(Class<? extends NativeModule> paramClass, Provider<? extends NativeModule> paramProvider)
  {
    this.mType = paramClass;
    this.mProvider = paramProvider;
  }

  public static ModuleSpec simple(Class<? extends NativeModule> paramClass)
  {
    return new ModuleSpec(paramClass, new ConstructorProvider(paramClass, EMPTY_SIGNATURE, paramClass)
    {
      public NativeModule get()
      {
        try
        {
          NativeModule localNativeModule = (NativeModule)getConstructor(this.val$type, ModuleSpec.EMPTY_SIGNATURE).newInstance(new Object[0]);
          return localNativeModule;
        }
        catch (Exception localException)
        {
        }
        throw new RuntimeException("ModuleSpec with class: " + this.val$type.getName(), localException);
      }
    });
  }

  public static ModuleSpec simple(Class<? extends NativeModule> paramClass, ReactApplicationContext paramReactApplicationContext)
  {
    return new ModuleSpec(paramClass, new ConstructorProvider(paramClass, CONTEXT_SIGNATURE, paramClass, paramReactApplicationContext)
    {
      public NativeModule get()
      {
        try
        {
          NativeModule localNativeModule = (NativeModule)getConstructor(this.val$type, ModuleSpec.CONTEXT_SIGNATURE).newInstance(new Object[] { this.val$context });
          return localNativeModule;
        }
        catch (Exception localException)
        {
        }
        throw new RuntimeException("ModuleSpec with class: " + this.val$type.getName(), localException);
      }
    });
  }

  public Provider<? extends NativeModule> getProvider()
  {
    return this.mProvider;
  }

  public Class<? extends NativeModule> getType()
  {
    return this.mType;
  }

  private static abstract class ConstructorProvider
    implements Provider<NativeModule>
  {

    @Nullable
    protected Constructor<? extends NativeModule> mConstructor;

    public ConstructorProvider(Class<? extends NativeModule> paramClass, Class[] paramArrayOfClass)
    {
    }

    protected Constructor<? extends NativeModule> getConstructor(Class<? extends NativeModule> paramClass, Class[] paramArrayOfClass)
      throws NoSuchMethodException
    {
      if (this.mConstructor != null)
        return this.mConstructor;
      return paramClass.getConstructor(paramArrayOfClass);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ModuleSpec
 * JD-Core Version:    0.6.0
 */