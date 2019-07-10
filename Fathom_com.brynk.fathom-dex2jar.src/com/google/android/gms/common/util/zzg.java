package com.google.android.gms.common.util;

import android.database.CharArrayBuffer;
import android.text.TextUtils;

public final class zzg
{
  public static void zzb(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    if (TextUtils.isEmpty(paramString))
      paramCharArrayBuffer.sizeCopied = 0;
    while (true)
    {
      paramCharArrayBuffer.sizeCopied = paramString.length();
      return;
      if ((paramCharArrayBuffer.data == null) || (paramCharArrayBuffer.data.length < paramString.length()))
      {
        paramCharArrayBuffer.data = paramString.toCharArray();
        continue;
      }
      paramString.getChars(0, paramString.length(), paramCharArrayBuffer.data, 0);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzg
 * JD-Core Version:    0.6.0
 */