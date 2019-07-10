package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.View;

public class ActivityOptionsCompat
{
  public static ActivityOptionsCompat makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    return new ActivityOptionsCompat();
  }

  public static ActivityOptionsCompat makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    return new ActivityOptionsCompat();
  }

  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
    return new ActivityOptionsCompat();
  }

  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, Pair<View, String>[] paramArrayOfPair)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      if (paramArrayOfPair != null)
      {
        View[] arrayOfView = new View[paramArrayOfPair.length];
        String[] arrayOfString = new String[paramArrayOfPair.length];
        int i = 0;
        while (true)
        {
          localObject1 = arrayOfString;
          localObject2 = arrayOfView;
          if (i >= paramArrayOfPair.length)
            break;
          arrayOfView[i] = ((View)paramArrayOfPair[i].first);
          arrayOfString[i] = ((String)paramArrayOfPair[i].second);
          i += 1;
        }
      }
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, localObject2, localObject1));
    }
    return new ActivityOptionsCompat();
  }

  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    return new ActivityOptionsCompat();
  }

  public Bundle toBundle()
  {
    return null;
  }

  public void update(ActivityOptionsCompat paramActivityOptionsCompat)
  {
  }

  private static class ActivityOptionsImpl21 extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompat21 mImpl;

    ActivityOptionsImpl21(ActivityOptionsCompat21 paramActivityOptionsCompat21)
    {
      this.mImpl = paramActivityOptionsCompat21;
    }

    public Bundle toBundle()
    {
      return this.mImpl.toBundle();
    }

    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImpl21))
      {
        paramActivityOptionsCompat = (ActivityOptionsImpl21)paramActivityOptionsCompat;
        this.mImpl.update(paramActivityOptionsCompat.mImpl);
      }
    }
  }

  private static class ActivityOptionsImplJB extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompatJB mImpl;

    ActivityOptionsImplJB(ActivityOptionsCompatJB paramActivityOptionsCompatJB)
    {
      this.mImpl = paramActivityOptionsCompatJB;
    }

    public Bundle toBundle()
    {
      return this.mImpl.toBundle();
    }

    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImplJB))
      {
        paramActivityOptionsCompat = (ActivityOptionsImplJB)paramActivityOptionsCompat;
        this.mImpl.update(paramActivityOptionsCompat.mImpl);
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat
 * JD-Core Version:    0.6.0
 */