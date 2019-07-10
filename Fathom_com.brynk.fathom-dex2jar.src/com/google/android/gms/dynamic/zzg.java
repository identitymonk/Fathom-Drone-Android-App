package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zze;

public abstract class zzg<T>
{
  private final String Qe;
  private T Qf;

  protected zzg(String paramString)
  {
    this.Qe = paramString;
  }

  protected abstract T zzc(IBinder paramIBinder);

  protected final T zzcr(Context paramContext)
    throws zzg.zza
  {
    if (this.Qf == null)
    {
      zzaa.zzy(paramContext);
      paramContext = zze.getRemoteContext(paramContext);
      if (paramContext == null)
        throw new zza("Could not get remote context.");
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.Qf = zzc((IBinder)paramContext.loadClass(this.Qe).newInstance());
      return this.Qf;
    }
    catch (java.lang.ClassNotFoundException paramContext)
    {
      throw new zza("Could not load creator class.", paramContext);
    }
    catch (java.lang.InstantiationException paramContext)
    {
      throw new zza("Could not instantiate creator.", paramContext);
    }
    catch (java.lang.IllegalAccessException paramContext)
    {
    }
    throw new zza("Could not access creator.", paramContext);
  }

  public static class zza extends Exception
  {
    public zza(String paramString)
    {
      super();
    }

    public zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzg
 * JD-Core Version:    0.6.0
 */