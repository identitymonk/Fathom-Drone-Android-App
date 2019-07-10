package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import java.util.List;

class MediaBrowserCompatApi24
{
  public static Object createSubscriptionCallback(SubscriptionCallback paramSubscriptionCallback)
  {
    return new SubscriptionCallbackProxy(paramSubscriptionCallback);
  }

  public static void subscribe(Object paramObject1, String paramString, Bundle paramBundle, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).subscribe(paramString, paramBundle, (MediaBrowser.SubscriptionCallback)paramObject2);
  }

  public static void unsubscribe(Object paramObject1, String paramString, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).unsubscribe(paramString, (MediaBrowser.SubscriptionCallback)paramObject2);
  }

  static abstract interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback
  {
    public abstract void onChildrenLoaded(@NonNull String paramString, List<Parcel> paramList, @NonNull Bundle paramBundle);

    public abstract void onError(@NonNull String paramString, @NonNull Bundle paramBundle);
  }

  static class SubscriptionCallbackProxy<T extends MediaBrowserCompatApi24.SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T>
  {
    public SubscriptionCallbackProxy(T paramT)
    {
      super();
    }

    public void onChildrenLoaded(@NonNull String paramString, List<MediaBrowser.MediaItem> paramList, @NonNull Bundle paramBundle)
    {
      ((MediaBrowserCompatApi24.SubscriptionCallback)this.mSubscriptionCallback).onChildrenLoaded(paramString, itemListToParcelList(paramList), paramBundle);
    }

    public void onError(@NonNull String paramString, @NonNull Bundle paramBundle)
    {
      ((MediaBrowserCompatApi24.SubscriptionCallback)this.mSubscriptionCallback).onError(paramString, paramBundle);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompatApi24
 * JD-Core Version:    0.6.0
 */