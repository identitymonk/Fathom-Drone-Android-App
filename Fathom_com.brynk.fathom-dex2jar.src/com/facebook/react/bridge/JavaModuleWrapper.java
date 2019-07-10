package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@DoNotStrip
public class JavaModuleWrapper
{
  private final ArrayList<MethodDescriptor> mDescs;
  private final JSInstance mJSInstance;
  private final ArrayList<NativeModule.NativeMethod> mMethods;
  private final Class<? extends NativeModule> mModuleClass;
  private final ModuleHolder mModuleHolder;

  public JavaModuleWrapper(JSInstance paramJSInstance, Class<? extends NativeModule> paramClass, ModuleHolder paramModuleHolder)
  {
    this.mJSInstance = paramJSInstance;
    this.mModuleHolder = paramModuleHolder;
    this.mModuleClass = paramClass;
    this.mMethods = new ArrayList();
    this.mDescs = new ArrayList();
  }

  @DoNotStrip
  private void findMethods()
  {
    Systrace.beginSection(0L, "findMethods");
    HashSet localHashSet = new HashSet();
    Object localObject1 = this.mModuleClass;
    Class localClass = this.mModuleClass.getSuperclass();
    if (ReactModuleWithSpec.class.isAssignableFrom(localClass))
      localObject1 = localClass;
    localObject1 = ((Class)localObject1).getDeclaredMethods();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localClass = localObject1[i];
      Object localObject2 = (ReactMethod)localClass.getAnnotation(ReactMethod.class);
      if (localObject2 != null)
      {
        String str = localClass.getName();
        if (localHashSet.contains(str))
          throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + str);
        MethodDescriptor localMethodDescriptor = new MethodDescriptor();
        localObject2 = new JavaMethodWrapper(this, localClass, ((ReactMethod)localObject2).isBlockingSynchronousMethod());
        localMethodDescriptor.name = str;
        localMethodDescriptor.type = ((JavaMethodWrapper)localObject2).getType();
        if (localMethodDescriptor.type == "sync")
        {
          localMethodDescriptor.signature = ((JavaMethodWrapper)localObject2).getSignature();
          localMethodDescriptor.method = localClass;
        }
        this.mMethods.add(localObject2);
        this.mDescs.add(localMethodDescriptor);
      }
      i += 1;
    }
    Systrace.endSection(0L);
  }

  @Nullable
  @DoNotStrip
  public NativeMap getConstants()
  {
    if (!this.mModuleHolder.getHasConstants())
      return null;
    Object localObject1 = getName();
    SystraceMessage.beginSection(0L, "JavaModuleWrapper.getConstants").arg("moduleName", localObject1).flush();
    ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_START, (String)localObject1);
    Object localObject3 = getModule();
    Systrace.beginSection(0L, "module.getConstants");
    localObject3 = ((BaseJavaModule)localObject3).getConstants();
    Systrace.endSection(0L);
    Systrace.beginSection(0L, "create WritableNativeMap");
    ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_START, (String)localObject1);
    try
    {
      localObject1 = Arguments.makeNativeMap((Map)localObject3);
      return localObject1;
    }
    finally
    {
      ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_END);
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_END);
      SystraceMessage.endSection(0L).flush();
    }
    throw localObject2;
  }

  @DoNotStrip
  public List<MethodDescriptor> getMethodDescriptors()
  {
    if (this.mDescs.isEmpty())
      findMethods();
    return this.mDescs;
  }

  @DoNotStrip
  public BaseJavaModule getModule()
  {
    return (BaseJavaModule)this.mModuleHolder.getModule();
  }

  @DoNotStrip
  public String getName()
  {
    return this.mModuleHolder.getName();
  }

  @DoNotStrip
  public void invoke(int paramInt, ReadableNativeArray paramReadableNativeArray)
  {
    if ((this.mMethods == null) || (paramInt >= this.mMethods.size()))
      return;
    ((NativeModule.NativeMethod)this.mMethods.get(paramInt)).invoke(this.mJSInstance, paramReadableNativeArray);
  }

  @DoNotStrip
  public class MethodDescriptor
  {

    @DoNotStrip
    Method method;

    @DoNotStrip
    String name;

    @DoNotStrip
    String signature;

    @DoNotStrip
    String type;

    public MethodDescriptor()
    {
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaModuleWrapper
 * JD-Core Version:    0.6.0
 */