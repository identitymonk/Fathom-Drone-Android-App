package com.google.android.gms.ads.identifier;

import android.support.annotation.WorkerThread;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class zza
{
  @WorkerThread
  public void zzv(String paramString)
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      try
      {
        int i = localHttpURLConnection.getResponseCode();
        if ((i < 200) || (i >= 300))
          Log.w("HttpUrlPinger", String.valueOf(paramString).length() + 65 + "Received non-success response code " + i + " from pinging URL: " + paramString);
        return;
      }
      finally
      {
        localHttpURLConnection.disconnect();
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      str = String.valueOf(localIndexOutOfBoundsException.getMessage());
      Log.w("HttpUrlPinger", String.valueOf(paramString).length() + 32 + String.valueOf(str).length() + "Error while parsing ping URL: " + paramString + ". " + str, localIndexOutOfBoundsException);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      String str = String.valueOf(localRuntimeException.getMessage());
      Log.w("HttpUrlPinger", String.valueOf(paramString).length() + 27 + String.valueOf(str).length() + "Error while pinging URL: " + paramString + ". " + str, localRuntimeException);
      return;
    }
    catch (IOException localIOException)
    {
      label159: break label159;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.zza
 * JD-Core Version:    0.6.0
 */