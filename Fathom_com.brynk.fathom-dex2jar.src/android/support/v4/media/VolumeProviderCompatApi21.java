package android.support.v4.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21
{
  public static Object createVolumeProvider(int paramInt1, int paramInt2, int paramInt3, Delegate paramDelegate)
  {
    return new VolumeProvider(paramInt1, paramInt2, paramInt3, paramDelegate)
    {
      public void onAdjustVolume(int paramInt)
      {
        this.val$delegate.onAdjustVolume(paramInt);
      }

      public void onSetVolumeTo(int paramInt)
      {
        this.val$delegate.onSetVolumeTo(paramInt);
      }
    };
  }

  public static void setCurrentVolume(Object paramObject, int paramInt)
  {
    ((VolumeProvider)paramObject).setCurrentVolume(paramInt);
  }

  public static abstract interface Delegate
  {
    public abstract void onAdjustVolume(int paramInt);

    public abstract void onSetVolumeTo(int paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.media.VolumeProviderCompatApi21
 * JD-Core Version:    0.6.0
 */