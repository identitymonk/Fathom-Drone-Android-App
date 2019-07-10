package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ItemCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Parcel;
import android.support.annotation.NonNull;

class MediaBrowserCompatApi23
{
  public static Object createItemCallback(ItemCallback paramItemCallback)
  {
    return new ItemCallbackProxy(paramItemCallback);
  }

  public static void getItem(Object paramObject1, String paramString, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).getItem(paramString, (MediaBrowser.ItemCallback)paramObject2);
  }

  static abstract interface ItemCallback
  {
    public abstract void onError(@NonNull String paramString);

    public abstract void onItemLoaded(Parcel paramParcel);
  }

  static class ItemCallbackProxy<T extends MediaBrowserCompatApi23.ItemCallback> extends MediaBrowser.ItemCallback
  {
    protected final T mItemCallback;

    public ItemCallbackProxy(T paramT)
    {
      this.mItemCallback = paramT;
    }

    public void onError(@NonNull String paramString)
    {
      this.mItemCallback.onError(paramString);
    }

    public void onItemLoaded(MediaBrowser.MediaItem paramMediaItem)
    {
      Parcel localParcel = Parcel.obtain();
      paramMediaItem.writeToParcel(localParcel, 0);
      this.mItemCallback.onItemLoaded(localParcel);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompatApi23
 * JD-Core Version:    0.6.0
 */