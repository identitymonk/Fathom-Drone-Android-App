package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.lang.reflect.Field;

public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  private static final Object DQ = new Object();
  private static ClassLoader DR = null;
  private static Integer DS = null;
  private boolean DT = false;

  protected static ClassLoader zzavy()
  {
    synchronized (DQ)
    {
      return null;
    }
  }

  protected static Integer zzavz()
  {
    synchronized (DQ)
    {
      return null;
    }
  }

  private static boolean zzd(Class<?> paramClass)
  {
    try
    {
      boolean bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      return bool;
    }
    catch (java.lang.IllegalAccessException paramClass)
    {
      return false;
    }
    catch (java.lang.NoSuchFieldException paramClass)
    {
    }
    return false;
  }

  protected static boolean zzhu(String paramString)
  {
    ClassLoader localClassLoader = zzavy();
    if (localClassLoader == null)
      return true;
    try
    {
      boolean bool = zzd(localClassLoader.loadClass(paramString));
      return bool;
    }
    catch (java.lang.Exception paramString)
    {
    }
    return false;
  }

  protected boolean zzawa()
  {
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.DowngradeableSafeParcel
 * JD-Core Version:    0.6.0
 */