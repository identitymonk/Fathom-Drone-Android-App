package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Method;

class MediaSessionCompatApi24
{
  private static final String TAG = "MediaSessionCompatApi24";

  public static Object createCallback(Callback paramCallback)
  {
    return new CallbackProxy(paramCallback);
  }

  public static String getCallingPackage(Object paramObject)
  {
    paramObject = (MediaSession)paramObject;
    try
    {
      paramObject = (String)paramObject.getClass().getMethod("getCallingPackage", new Class[0]).invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (java.lang.IllegalAccessException paramObject)
    {
      Log.e("MediaSessionCompatApi24", "Cannot execute MediaSession.getCallingPackage()", paramObject);
      return null;
    }
    catch (java.lang.NoSuchMethodException paramObject)
    {
      break label33;
    }
    catch (java.lang.reflect.InvocationTargetException paramObject)
    {
      label33: break label33;
    }
  }

  public static abstract interface Callback extends MediaSessionCompatApi23.Callback
  {
    public abstract void onPrepare();

    public abstract void onPrepareFromMediaId(String paramString, Bundle paramBundle);

    public abstract void onPrepareFromSearch(String paramString, Bundle paramBundle);

    public abstract void onPrepareFromUri(Uri paramUri, Bundle paramBundle);
  }

  static class CallbackProxy<T extends MediaSessionCompatApi24.Callback> extends MediaSessionCompatApi23.CallbackProxy<T>
  {
    public CallbackProxy(T paramT)
    {
      super();
    }

    public void onPrepare()
    {
      ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepare();
    }

    public void onPrepareFromMediaId(String paramString, Bundle paramBundle)
    {
      ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepareFromMediaId(paramString, paramBundle);
    }

    public void onPrepareFromSearch(String paramString, Bundle paramBundle)
    {
      ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepareFromSearch(paramString, paramBundle);
    }

    public void onPrepareFromUri(Uri paramUri, Bundle paramBundle)
    {
      ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepareFromUri(paramUri, paramBundle);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompatApi24
 * JD-Core Version:    0.6.0
 */