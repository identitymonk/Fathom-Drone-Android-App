package android.support.v4.media.session;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;

class MediaSessionCompatApi8
{
  public static void registerMediaButtonEventReceiver(Context paramContext, ComponentName paramComponentName)
  {
    ((AudioManager)paramContext.getSystemService("audio")).registerMediaButtonEventReceiver(paramComponentName);
  }

  public static void unregisterMediaButtonEventReceiver(Context paramContext, ComponentName paramComponentName)
  {
    ((AudioManager)paramContext.getSystemService("audio")).unregisterMediaButtonEventReceiver(paramComponentName);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompatApi8
 * JD-Core Version:    0.6.0
 */