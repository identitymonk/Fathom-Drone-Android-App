package com.facebook.react.module.annotations;

import com.facebook.react.bridge.NativeModule;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface ReactModuleList
{
  public abstract Class<? extends NativeModule>[] nativeModules();

  public abstract Class<? extends NativeModule>[] viewManagers();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.module.annotations.ReactModuleList
 * JD-Core Version:    0.6.0
 */