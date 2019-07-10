package android.support.v4.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;

class PathInterpolatorCompatBase
{
  public static Interpolator create(float paramFloat1, float paramFloat2)
  {
    return new PathInterpolatorDonut(paramFloat1, paramFloat2);
  }

  public static Interpolator create(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new PathInterpolatorDonut(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public static Interpolator create(Path paramPath)
  {
    return new PathInterpolatorDonut(paramPath);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.animation.PathInterpolatorCompatBase
 * JD-Core Version:    0.6.0
 */