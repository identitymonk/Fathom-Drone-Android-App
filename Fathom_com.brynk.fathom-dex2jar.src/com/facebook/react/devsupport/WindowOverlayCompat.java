package com.facebook.react.devsupport;

import android.os.Build.VERSION;

class WindowOverlayCompat
{
  private static final int ANDROID_OREO = 26;
  private static final int TYPE_APPLICATION_OVERLAY = 2038;
  static final int TYPE_SYSTEM_ALERT;
  static final int TYPE_SYSTEM_OVERLAY;

  static
  {
    int j = 2038;
    if (Build.VERSION.SDK_INT < 26);
    for (int i = 2003; ; i = 2038)
    {
      TYPE_SYSTEM_ALERT = i;
      i = j;
      if (Build.VERSION.SDK_INT < 26)
        i = 2006;
      TYPE_SYSTEM_OVERLAY = i;
      return;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.WindowOverlayCompat
 * JD-Core Version:    0.6.0
 */