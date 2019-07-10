package com.facebook.react.module.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface ReactModule
{
  public abstract boolean canOverrideExistingModule();

  public abstract boolean hasConstants();

  public abstract String name();

  public abstract boolean needsEagerInit();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.module.annotations.ReactModule
 * JD-Core Version:    0.6.0
 */