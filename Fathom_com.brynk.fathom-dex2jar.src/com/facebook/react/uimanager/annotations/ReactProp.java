package com.facebook.react.uimanager.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nullable;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface ReactProp
{
  public static final String USE_DEFAULT_TYPE = "__default_type__";

  @Nullable
  public abstract String customType();

  public abstract boolean defaultBoolean();

  public abstract double defaultDouble();

  public abstract float defaultFloat();

  public abstract int defaultInt();

  public abstract String name();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.annotations.ReactProp
 * JD-Core Version:    0.6.0
 */