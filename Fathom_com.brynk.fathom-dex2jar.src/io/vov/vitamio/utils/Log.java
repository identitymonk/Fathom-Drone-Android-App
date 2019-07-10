package io.vov.vitamio.utils;

public class Log
{
  public static final String TAG = "Vitamio[Player]";

  public static void d(String paramString, Object[] paramArrayOfObject)
  {
  }

  public static void e(String paramString, Throwable paramThrowable)
  {
    android.util.Log.e("Vitamio[Player]", paramString, paramThrowable);
  }

  public static void e(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      android.util.Log.e("Vitamio[Player]", String.format(paramString, paramArrayOfObject));
      return;
    }
    catch (java.util.MissingFormatArgumentException paramArrayOfObject)
    {
      android.util.Log.e("Vitamio[Player]", "vitamio.Log", paramArrayOfObject);
      android.util.Log.e("Vitamio[Player]", paramString);
    }
  }

  public static void i(String paramString, Object[] paramArrayOfObject)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.utils.Log
 * JD-Core Version:    0.6.0
 */