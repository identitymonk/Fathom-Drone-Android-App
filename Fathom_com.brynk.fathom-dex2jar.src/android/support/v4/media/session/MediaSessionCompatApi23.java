package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaSessionCompatApi23
{
  public static Object createCallback(Callback paramCallback)
  {
    return new CallbackProxy(paramCallback);
  }

  public static abstract interface Callback extends MediaSessionCompatApi21.Callback
  {
    public abstract void onPlayFromUri(Uri paramUri, Bundle paramBundle);
  }

  static class CallbackProxy<T extends MediaSessionCompatApi23.Callback> extends MediaSessionCompatApi21.CallbackProxy<T>
  {
    public CallbackProxy(T paramT)
    {
      super();
    }

    public void onPlayFromUri(Uri paramUri, Bundle paramBundle)
    {
      ((MediaSessionCompatApi23.Callback)this.mCallback).onPlayFromUri(paramUri, paramBundle);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompatApi23
 * JD-Core Version:    0.6.0
 */