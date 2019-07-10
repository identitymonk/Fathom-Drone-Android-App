package android.support.v4.text;

import android.os.Build.VERSION;
import java.util.Locale;

public final class ICUCompat
{
  private static final ICUCompatImpl IMPL;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      IMPL = new ICUCompatImplLollipop();
      return;
    }
    if (i >= 14)
    {
      IMPL = new ICUCompatImplIcs();
      return;
    }
    IMPL = new ICUCompatImplBase();
  }

  public static String maximizeAndGetScript(Locale paramLocale)
  {
    return IMPL.maximizeAndGetScript(paramLocale);
  }

  static abstract interface ICUCompatImpl
  {
    public abstract String maximizeAndGetScript(Locale paramLocale);
  }

  static class ICUCompatImplBase
    implements ICUCompat.ICUCompatImpl
  {
    public String maximizeAndGetScript(Locale paramLocale)
    {
      return null;
    }
  }

  static class ICUCompatImplIcs
    implements ICUCompat.ICUCompatImpl
  {
    public String maximizeAndGetScript(Locale paramLocale)
    {
      return ICUCompatIcs.maximizeAndGetScript(paramLocale);
    }
  }

  static class ICUCompatImplLollipop
    implements ICUCompat.ICUCompatImpl
  {
    public String maximizeAndGetScript(Locale paramLocale)
    {
      return ICUCompatApi23.maximizeAndGetScript(paramLocale);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompat
 * JD-Core Version:    0.6.0
 */