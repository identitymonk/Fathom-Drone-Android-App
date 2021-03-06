package com.google.android.gms.internal;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class zzaoy
{
  public Number aT()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public String aU()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public boolean aV()
  {
    return this instanceof zzaov;
  }

  public boolean aW()
  {
    return this instanceof zzapb;
  }

  public boolean aX()
  {
    return this instanceof zzape;
  }

  public boolean aY()
  {
    return this instanceof zzapa;
  }

  public zzapb aZ()
  {
    if (aW())
      return (zzapb)this;
    String str = String.valueOf(this);
    throw new IllegalStateException(String.valueOf(str).length() + 19 + "Not a JSON Object: " + str);
  }

  public zzaov ba()
  {
    if (aV())
      return (zzaov)this;
    throw new IllegalStateException("This is not a JSON Array.");
  }

  public zzape bb()
  {
    if (aX())
      return (zzape)this;
    throw new IllegalStateException("This is not a JSON Primitive.");
  }

  Boolean bc()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public boolean getAsBoolean()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public double getAsDouble()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public int getAsInt()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public long getAsLong()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      zzaqr localzzaqr = new zzaqr((Writer)localObject);
      localzzaqr.setLenient(true);
      zzapz.zzb(this, localzzaqr);
      localObject = ((StringWriter)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
    }
    throw new AssertionError(localIOException);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaoy
 * JD-Core Version:    0.6.0
 */