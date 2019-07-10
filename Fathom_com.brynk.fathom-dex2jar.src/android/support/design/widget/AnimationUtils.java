package android.support.design.widget;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class AnimationUtils
{
  static final Interpolator DECELERATE_INTERPOLATOR;
  static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR;
  static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR;
  static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR;

  static
  {
    FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
    DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
  }

  static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }

  static int lerp(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }

  static class AnimationListenerAdapter
    implements Animation.AnimationListener
  {
    public void onAnimationEnd(Animation paramAnimation)
    {
    }

    public void onAnimationRepeat(Animation paramAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnimation)
    {
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.AnimationUtils
 * JD-Core Version:    0.6.0
 */