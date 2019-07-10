package com.google.firebase.appindexing.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.webkit.URLUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.appindexing.FirebaseAppIndexingException;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.FirebaseAppIndexingTooManyArgumentsException;

public class zzl
{
  public static FirebaseAppIndexingException zzb(@NonNull Status paramStatus, String paramString)
  {
    zzaa.zzy(paramStatus);
    String str2 = paramStatus.getStatusMessage();
    String str1 = paramString;
    if (str2 != null)
      if (!str2.isEmpty())
        break label79;
    label79: for (str1 = paramString; ; str1 = str2)
    {
      switch (paramStatus.getStatusCode())
      {
      default:
        return new FirebaseAppIndexingException(str1);
      case 17510:
        return new FirebaseAppIndexingInvalidArgumentException(str1);
      case 17511:
      }
      return new FirebaseAppIndexingTooManyArgumentsException(str1);
    }
  }

  public static void zzrs(@NonNull String paramString)
    throws FirebaseAppIndexingInvalidArgumentException
  {
    zzaa.zzy(paramString);
    Uri localUri = Uri.parse(paramString);
    if ((localUri == null) || (!localUri.isAbsolute()))
      throw new FirebaseAppIndexingInvalidArgumentException(String.valueOf(paramString).length() + 33 + "Invalid String passed as url: '" + paramString + "'.");
  }

  public static void zzrt(@NonNull String paramString)
    throws FirebaseAppIndexingInvalidArgumentException
  {
    zzaa.zzy(paramString);
    if ((!URLUtil.isHttpUrl(paramString)) && (!URLUtil.isHttpsUrl(paramString)))
      throw new FirebaseAppIndexingInvalidArgumentException(String.valueOf(paramString).length() + 46 + "Web url must be with http or https scheme: '" + paramString + "'.");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zzl
 * JD-Core Version:    0.6.0
 */