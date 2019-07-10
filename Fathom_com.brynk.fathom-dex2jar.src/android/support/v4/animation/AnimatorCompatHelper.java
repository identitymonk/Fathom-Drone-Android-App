package android.support.v4.animation;

import android.os.Build.VERSION;
import android.view.View;

public final class AnimatorCompatHelper
{
  private static final AnimatorProvider IMPL;

  static
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      IMPL = new HoneycombMr1AnimatorCompatProvider();
      return;
    }
    IMPL = new DonutAnimatorCompatProvider();
  }

  public static void clearInterpolator(View paramView)
  {
    IMPL.clearInterpolator(paramView);
  }

  public static ValueAnimatorCompat emptyValueAnimator()
  {
    return IMPL.emptyValueAnimator();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.animation.AnimatorCompatHelper
 * JD-Core Version:    0.6.0
 */