package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzo;

public class zzsu
{
  private final String ED;
  private final zzo EX;
  private final int ee;
  private final String mTag;

  private zzsu(String paramString1, String paramString2)
  {
    this.ED = paramString2;
    this.mTag = paramString1;
    this.EX = new zzo(paramString1);
    this.ee = getLogLevel();
  }

  public zzsu(String paramString, String[] paramArrayOfString)
  {
    this(paramString, zzd(paramArrayOfString));
  }

  private int getLogLevel()
  {
    int i = 2;
    while ((7 >= i) && (!Log.isLoggable(this.mTag, i)))
      i += 1;
    return i;
  }

  private static String zzd(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length == 0)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (localStringBuilder.length() > 1)
        localStringBuilder.append(",");
      localStringBuilder.append(str);
      i += 1;
    }
    localStringBuilder.append(']').append(' ');
    return localStringBuilder.toString();
  }

  protected String format(String paramString, Object[] paramArrayOfObject)
  {
    String str = paramString;
    if (paramArrayOfObject != null)
    {
      str = paramString;
      if (paramArrayOfObject.length > 0)
        str = String.format(paramString, paramArrayOfObject);
    }
    return this.ED.concat(str);
  }

  public void zza(String paramString, Object[] paramArrayOfObject)
  {
    if (zzbi(2))
      Log.v(this.mTag, format(paramString, paramArrayOfObject));
  }

  public boolean zzbi(int paramInt)
  {
    return this.ee <= paramInt;
  }

  public void zze(String paramString, Object[] paramArrayOfObject)
  {
    Log.i(this.mTag, format(paramString, paramArrayOfObject));
  }

  public void zzf(String paramString, Object[] paramArrayOfObject)
  {
    Log.w(this.mTag, format(paramString, paramArrayOfObject));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzsu
 * JD-Core Version:    0.6.0
 */