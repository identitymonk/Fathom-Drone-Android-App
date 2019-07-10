package android.support.design.widget;

import android.view.animation.Interpolator;

class ValueAnimatorCompat
{
  private final Impl mImpl;

  ValueAnimatorCompat(Impl paramImpl)
  {
    this.mImpl = paramImpl;
  }

  public void cancel()
  {
    this.mImpl.cancel();
  }

  public void end()
  {
    this.mImpl.end();
  }

  public float getAnimatedFloatValue()
  {
    return this.mImpl.getAnimatedFloatValue();
  }

  public float getAnimatedFraction()
  {
    return this.mImpl.getAnimatedFraction();
  }

  public int getAnimatedIntValue()
  {
    return this.mImpl.getAnimatedIntValue();
  }

  public long getDuration()
  {
    return this.mImpl.getDuration();
  }

  public boolean isRunning()
  {
    return this.mImpl.isRunning();
  }

  public void setDuration(int paramInt)
  {
    this.mImpl.setDuration(paramInt);
  }

  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    this.mImpl.setFloatValues(paramFloat1, paramFloat2);
  }

  public void setIntValues(int paramInt1, int paramInt2)
  {
    this.mImpl.setIntValues(paramInt1, paramInt2);
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mImpl.setInterpolator(paramInterpolator);
  }

  public void setListener(AnimatorListener paramAnimatorListener)
  {
    if (paramAnimatorListener != null)
    {
      this.mImpl.setListener(new ValueAnimatorCompat.Impl.AnimatorListenerProxy(paramAnimatorListener)
      {
        public void onAnimationCancel()
        {
          this.val$listener.onAnimationCancel(ValueAnimatorCompat.this);
        }

        public void onAnimationEnd()
        {
          this.val$listener.onAnimationEnd(ValueAnimatorCompat.this);
        }

        public void onAnimationStart()
        {
          this.val$listener.onAnimationStart(ValueAnimatorCompat.this);
        }
      });
      return;
    }
    this.mImpl.setListener(null);
  }

  public void setUpdateListener(AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (paramAnimatorUpdateListener != null)
    {
      this.mImpl.setUpdateListener(new ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy(paramAnimatorUpdateListener)
      {
        public void onAnimationUpdate()
        {
          this.val$updateListener.onAnimationUpdate(ValueAnimatorCompat.this);
        }
      });
      return;
    }
    this.mImpl.setUpdateListener(null);
  }

  public void start()
  {
    this.mImpl.start();
  }

  static abstract interface AnimatorListener
  {
    public abstract void onAnimationCancel(ValueAnimatorCompat paramValueAnimatorCompat);

    public abstract void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat);

    public abstract void onAnimationStart(ValueAnimatorCompat paramValueAnimatorCompat);
  }

  static class AnimatorListenerAdapter
    implements ValueAnimatorCompat.AnimatorListener
  {
    public void onAnimationCancel(ValueAnimatorCompat paramValueAnimatorCompat)
    {
    }

    public void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat)
    {
    }

    public void onAnimationStart(ValueAnimatorCompat paramValueAnimatorCompat)
    {
    }
  }

  static abstract interface AnimatorUpdateListener
  {
    public abstract void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat);
  }

  static abstract interface Creator
  {
    public abstract ValueAnimatorCompat createAnimator();
  }

  static abstract class Impl
  {
    abstract void cancel();

    abstract void end();

    abstract float getAnimatedFloatValue();

    abstract float getAnimatedFraction();

    abstract int getAnimatedIntValue();

    abstract long getDuration();

    abstract boolean isRunning();

    abstract void setDuration(int paramInt);

    abstract void setFloatValues(float paramFloat1, float paramFloat2);

    abstract void setIntValues(int paramInt1, int paramInt2);

    abstract void setInterpolator(Interpolator paramInterpolator);

    abstract void setListener(AnimatorListenerProxy paramAnimatorListenerProxy);

    abstract void setUpdateListener(AnimatorUpdateListenerProxy paramAnimatorUpdateListenerProxy);

    abstract void start();

    static abstract interface AnimatorListenerProxy
    {
      public abstract void onAnimationCancel();

      public abstract void onAnimationEnd();

      public abstract void onAnimationStart();
    }

    static abstract interface AnimatorUpdateListenerProxy
    {
      public abstract void onAnimationUpdate();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.ValueAnimatorCompat
 * JD-Core Version:    0.6.0
 */