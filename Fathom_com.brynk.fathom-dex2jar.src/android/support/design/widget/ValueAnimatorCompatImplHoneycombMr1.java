package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;

class ValueAnimatorCompatImplHoneycombMr1 extends ValueAnimatorCompat.Impl
{
  final ValueAnimator mValueAnimator = new ValueAnimator();

  public void cancel()
  {
    this.mValueAnimator.cancel();
  }

  public void end()
  {
    this.mValueAnimator.end();
  }

  public float getAnimatedFloatValue()
  {
    return ((Float)this.mValueAnimator.getAnimatedValue()).floatValue();
  }

  public float getAnimatedFraction()
  {
    return this.mValueAnimator.getAnimatedFraction();
  }

  public int getAnimatedIntValue()
  {
    return ((Integer)this.mValueAnimator.getAnimatedValue()).intValue();
  }

  public long getDuration()
  {
    return this.mValueAnimator.getDuration();
  }

  public boolean isRunning()
  {
    return this.mValueAnimator.isRunning();
  }

  public void setDuration(int paramInt)
  {
    this.mValueAnimator.setDuration(paramInt);
  }

  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    this.mValueAnimator.setFloatValues(new float[] { paramFloat1, paramFloat2 });
  }

  public void setIntValues(int paramInt1, int paramInt2)
  {
    this.mValueAnimator.setIntValues(new int[] { paramInt1, paramInt2 });
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mValueAnimator.setInterpolator(paramInterpolator);
  }

  public void setListener(ValueAnimatorCompat.Impl.AnimatorListenerProxy paramAnimatorListenerProxy)
  {
    this.mValueAnimator.addListener(new AnimatorListenerAdapter(paramAnimatorListenerProxy)
    {
      public void onAnimationCancel(Animator paramAnimator)
      {
        this.val$listener.onAnimationCancel();
      }

      public void onAnimationEnd(Animator paramAnimator)
      {
        this.val$listener.onAnimationEnd();
      }

      public void onAnimationStart(Animator paramAnimator)
      {
        this.val$listener.onAnimationStart();
      }
    });
  }

  public void setUpdateListener(ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy paramAnimatorUpdateListenerProxy)
  {
    this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(paramAnimatorUpdateListenerProxy)
    {
      public void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        this.val$updateListener.onAnimationUpdate();
      }
    });
  }

  public void start()
  {
    this.mValueAnimator.start();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1
 * JD-Core Version:    0.6.0
 */