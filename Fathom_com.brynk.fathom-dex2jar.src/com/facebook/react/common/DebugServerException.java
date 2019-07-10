package com.facebook.react.common;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class DebugServerException extends RuntimeException
{
  private static final String GENERIC_ERROR_MESSAGE = "\n\nTry the following to fix the issue:\n• Ensure that the packager server is running\n• Ensure that your device/emulator is connected to your machine and has USB debugging enabled - run 'adb devices' to see a list of connected devices\n• Ensure Airplane Mode is disabled\n• If you're on a physical device connected to the same machine, run 'adb reverse tcp:8081 tcp:8081' to forward requests from your device\n• If your device is on the same Wi-Fi network, set 'Debug server host & port for device' in 'Dev settings' to your machine's IP address and the port of the local dev server - e.g. 10.0.1.1:8081\n\n";

  public DebugServerException(String paramString)
  {
    super(paramString);
  }

  private DebugServerException(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramString1 + "\n  at " + paramString2 + ":" + paramInt1 + ":" + paramInt2);
  }

  public DebugServerException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }

  public static DebugServerException makeGeneric(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return new DebugServerException(paramString1 + "\n\nTry the following to fix the issue:\n• Ensure that the packager server is running\n• Ensure that your device/emulator is connected to your machine and has USB debugging enabled - run 'adb devices' to see a list of connected devices\n• Ensure Airplane Mode is disabled\n• If you're on a physical device connected to the same machine, run 'adb reverse tcp:8081 tcp:8081' to forward requests from your device\n• If your device is on the same Wi-Fi network, set 'Debug server host & port for device' in 'Dev settings' to your machine's IP address and the port of the local dev server - e.g. 10.0.1.1:8081\n\n" + paramString2, paramThrowable);
  }

  public static DebugServerException makeGeneric(String paramString, Throwable paramThrowable)
  {
    return makeGeneric(paramString, "", paramThrowable);
  }

  @Nullable
  public static DebugServerException parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      Object localObject = new JSONObject(paramString);
      String str = ((JSONObject)localObject).getString("filename");
      localObject = new DebugServerException(((JSONObject)localObject).getString("description"), shortenFileName(str), ((JSONObject)localObject).getInt("lineNumber"), ((JSONObject)localObject).getInt("column"));
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      FLog.w("ReactNative", "Could not parse DebugServerException from: " + paramString, localJSONException);
    }
    return (DebugServerException)null;
  }

  private static String shortenFileName(String paramString)
  {
    paramString = paramString.split("/");
    return paramString[(paramString.length - 1)];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.common.DebugServerException
 * JD-Core Version:    0.6.0
 */