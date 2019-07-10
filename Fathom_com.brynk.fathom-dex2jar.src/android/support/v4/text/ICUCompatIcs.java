package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

class ICUCompatIcs
{
  private static final String TAG = "ICUCompatIcs";
  private static Method sAddLikelySubtagsMethod;
  private static Method sGetScriptMethod;

  static
  {
    try
    {
      Class localClass = Class.forName("libcore.icu.ICU");
      if (localClass != null)
      {
        sGetScriptMethod = localClass.getMethod("getScript", new Class[] { String.class });
        sAddLikelySubtagsMethod = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
      }
      return;
    }
    catch (Exception localException)
    {
      sGetScriptMethod = null;
      sAddLikelySubtagsMethod = null;
      Log.w("ICUCompatIcs", localException);
    }
  }

  private static String addLikelySubtags(Locale paramLocale)
  {
    paramLocale = paramLocale.toString();
    try
    {
      if (sAddLikelySubtagsMethod != null)
      {
        String str = (String)sAddLikelySubtagsMethod.invoke(null, new Object[] { paramLocale });
        return str;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.w("ICUCompatIcs", localIllegalAccessException);
      return paramLocale;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        Log.w("ICUCompatIcs", localInvocationTargetException);
    }
  }

  private static String getScript(String paramString)
  {
    try
    {
      if (sGetScriptMethod != null)
      {
        paramString = (String)sGetScriptMethod.invoke(null, new Object[] { paramString });
        return paramString;
      }
    }
    catch (IllegalAccessException paramString)
    {
      Log.w("ICUCompatIcs", paramString);
      return null;
    }
    catch (InvocationTargetException paramString)
    {
      while (true)
        Log.w("ICUCompatIcs", paramString);
    }
  }

  public static String maximizeAndGetScript(Locale paramLocale)
  {
    paramLocale = addLikelySubtags(paramLocale);
    if (paramLocale != null)
      return getScript(paramLocale);
    return null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompatIcs
 * JD-Core Version:    0.6.0
 */