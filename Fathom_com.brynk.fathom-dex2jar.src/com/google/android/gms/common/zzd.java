package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzr.zza;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.common.util.zzm;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zztl;
import com.google.android.gms.internal.zztl.zza;
import java.lang.ref.WeakReference;
import java.util.Arrays;

class zzd
{
  private static zzu wU;
  private static Context wV;

  static boolean zza(String paramString, zza paramzza)
  {
    if ((wU == null) && (!zzaqm()))
      return false;
    try
    {
      boolean bool = wU.zzd(paramString, paramzza.zzaqn());
      return bool;
    }
    catch (android.os.RemoteException paramzza)
    {
      Log.e("GoogleCertificates", String.valueOf(paramString).length() + 44 + "Error checking if " + paramString + " is Google release signed.");
    }
    return false;
  }

  private static boolean zzaqm()
  {
    int j = 1;
    monitorenter;
    try
    {
      Object localObject1 = wU;
      int i;
      if (localObject1 != null)
        i = j;
      while (true)
      {
        return i;
        zzaa.zzy(wV);
        localObject1 = wU;
        i = j;
        if (localObject1 != null)
          continue;
        try
        {
          localObject1 = zztl.zza(wV, zztl.Qq, "com.google.android.gms.googlecertificates");
          Log.d("GoogleCertificates", "com.google.android.gms.googlecertificates module is loaded");
          wU = zzu.zza.zzdv(((zztl)localObject1).zzjd("com.google.android.gms.common.GoogleCertificatesImpl"));
          i = j;
        }
        catch (zztl.zza str)
        {
          localObject1 = String.valueOf("Failed to load com.google.android.gms.googlecertificates: ");
          String str = String.valueOf(localzza.getMessage());
          if (str.length() != 0);
          for (localObject1 = ((String)localObject1).concat(str); ; localObject1 = new String((String)localObject1))
          {
            Log.e("GoogleCertificates", (String)localObject1);
            i = 0;
            break;
          }
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  static boolean zzb(String paramString, zza paramzza)
  {
    if ((wU == null) && (!zzaqm()))
      return false;
    try
    {
      boolean bool = wU.zze(paramString, paramzza.zzaqn());
      return bool;
    }
    catch (android.os.RemoteException paramzza)
    {
      Log.e("GoogleCertificates", String.valueOf(paramString).length() + 36 + "Error checking if " + paramString + " is Google signed.");
    }
    return false;
  }

  static void zzbo(Context paramContext)
  {
    monitorenter;
    try
    {
      if (wV == null)
        if (paramContext != null)
          wV = paramContext.getApplicationContext();
      while (true)
      {
        return;
        Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramContext;
  }

  static abstract class zza extends zzr.zza
  {
    private int wW;

    protected zza(byte[] paramArrayOfByte)
    {
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte.length != 25)
      {
        int i = paramArrayOfByte.length;
        localObject = String.valueOf(zzm.zza(paramArrayOfByte, 0, paramArrayOfByte.length, false));
        Log.wtf("GoogleCertificates", String.valueOf(localObject).length() + 51 + "Cert hash data has incorrect length (" + i + "):\n" + (String)localObject, new Exception());
        localObject = Arrays.copyOfRange(paramArrayOfByte, 0, 25);
        if (localObject.length == 25)
          bool = true;
        i = localObject.length;
        zzaa.zzb(bool, 55 + "cert hash data has incorrect length. length=" + i);
      }
      this.wW = Arrays.hashCode(localObject);
    }

    protected static byte[] zzhg(String paramString)
    {
      try
      {
        paramString = paramString.getBytes("ISO-8859-1");
        return paramString;
      }
      catch (java.io.UnsupportedEncodingException paramString)
      {
      }
      throw new AssertionError(paramString);
    }

    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof zzr)))
        return false;
      try
      {
        paramObject = (zzr)paramObject;
        if (paramObject.zzaqo() != hashCode())
          return false;
        paramObject = paramObject.zzaqn();
        if (paramObject == null)
          return false;
        paramObject = (byte[])zze.zzae(paramObject);
        boolean bool = Arrays.equals(getBytes(), paramObject);
        return bool;
      }
      catch (android.os.RemoteException paramObject)
      {
        Log.e("GoogleCertificates", "iCertData failed to retrive data from remote");
      }
      return false;
    }

    abstract byte[] getBytes();

    public int hashCode()
    {
      return this.wW;
    }

    public com.google.android.gms.dynamic.zzd zzaqn()
    {
      return zze.zzac(getBytes());
    }

    public int zzaqo()
    {
      return hashCode();
    }
  }

  static class zzb extends zzd.zza
  {
    private final byte[] wX;

    zzb(byte[] paramArrayOfByte)
    {
      super();
      this.wX = paramArrayOfByte;
    }

    byte[] getBytes()
    {
      return this.wX;
    }
  }

  static abstract class zzc extends zzd.zza
  {
    private static final WeakReference<byte[]> wZ = new WeakReference(null);
    private WeakReference<byte[]> wY = wZ;

    zzc(byte[] paramArrayOfByte)
    {
      super();
    }

    byte[] getBytes()
    {
      monitorenter;
      try
      {
        byte[] arrayOfByte2 = (byte[])this.wY.get();
        byte[] arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null)
        {
          arrayOfByte1 = zzaqp();
          this.wY = new WeakReference(arrayOfByte1);
        }
        return arrayOfByte1;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    protected abstract byte[] zzaqp();
  }

  static final class zzd
  {
    static final zzd.zza[] xa = { new zzd.zzc()
    {
      protected byte[] zzaqp()
      {
        return zzd.zza.zzhg("");
      }
    }
    , new zzd.zzc()
    {
      protected byte[] zzaqp()
      {
        return zzd.zza.zzhg("");
      }
    }
     };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.zzd
 * JD-Core Version:    0.6.0
 */