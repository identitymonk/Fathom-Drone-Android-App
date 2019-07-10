package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.Nullable;
import android.support.design.R.anim;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class FloatingActionButtonEclairMr1 extends FloatingActionButtonImpl
{
  private int mAnimationDuration;
  private boolean mIsHiding;
  ShadowDrawableWrapper mShadowDrawable;
  private StateListAnimator mStateListAnimator;

  FloatingActionButtonEclairMr1(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate);
    this.mAnimationDuration = paramVisibilityAwareImageButton.getResources().getInteger(17694720);
    this.mStateListAnimator = new StateListAnimator();
    this.mStateListAnimator.setTarget(paramVisibilityAwareImageButton);
    this.mStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, setupAnimation(new ElevateToTranslationZAnimation(null)));
    this.mStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, setupAnimation(new ElevateToTranslationZAnimation(null)));
    this.mStateListAnimator.addState(EMPTY_STATE_SET, setupAnimation(new ResetElevationAnimation(null)));
  }

  private static ColorStateList createColorStateList(int paramInt)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    arrayOfInt[0] = FOCUSED_ENABLED_STATE_SET;
    arrayOfInt1[0] = paramInt;
    int i = 0 + 1;
    arrayOfInt[i] = PRESSED_ENABLED_STATE_SET;
    arrayOfInt1[i] = paramInt;
    paramInt = i + 1;
    arrayOfInt[paramInt] = new int[0];
    arrayOfInt1[paramInt] = 0;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private Animation setupAnimation(Animation paramAnimation)
  {
    paramAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    paramAnimation.setDuration(this.mAnimationDuration);
    return paramAnimation;
  }

  float getElevation()
  {
    return this.mElevation;
  }

  void getPadding(Rect paramRect)
  {
    this.mShadowDrawable.getPadding(paramRect);
  }

  void hide(@Nullable FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if ((this.mIsHiding) || (this.mView.getVisibility() != 0))
    {
      if (paramInternalVisibilityChangedListener != null)
        paramInternalVisibilityChangedListener.onHidden();
      return;
    }
    Animation localAnimation = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_fab_out);
    localAnimation.setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new AnimationUtils.AnimationListenerAdapter(paramBoolean, paramInternalVisibilityChangedListener)
    {
      public void onAnimationEnd(Animation paramAnimation)
      {
        FloatingActionButtonEclairMr1.access$202(FloatingActionButtonEclairMr1.this, false);
        FloatingActionButtonEclairMr1.this.mView.internalSetVisibility(8, this.val$fromUser);
        if (this.val$listener != null)
          this.val$listener.onHidden();
      }

      public void onAnimationStart(Animation paramAnimation)
      {
        FloatingActionButtonEclairMr1.access$202(FloatingActionButtonEclairMr1.this, true);
      }
    });
    this.mView.startAnimation(localAnimation);
  }

  void jumpDrawableToCurrentState()
  {
    this.mStateListAnimator.jumpToCurrentState();
  }

  void onCompatShadowChanged()
  {
  }

  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
    this.mStateListAnimator.setState(paramArrayOfInt);
  }

  void onElevationChanged(float paramFloat)
  {
    if (this.mShadowDrawable != null)
    {
      this.mShadowDrawable.setShadowSize(paramFloat, this.mPressedTranslationZ + paramFloat);
      updatePadding();
    }
  }

  void onTranslationZChanged(float paramFloat)
  {
    if (this.mShadowDrawable != null)
    {
      this.mShadowDrawable.setMaxShadowSize(this.mElevation + paramFloat);
      updatePadding();
    }
  }

  void setBackgroundDrawable(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    this.mShapeDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(this.mShapeDrawable, paramColorStateList);
    if (paramMode != null)
      DrawableCompat.setTintMode(this.mShapeDrawable, paramMode);
    this.mRippleDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(this.mRippleDrawable, createColorStateList(paramInt1));
    if (paramInt2 > 0)
    {
      this.mBorderDrawable = createBorderDrawable(paramInt2, paramColorStateList);
      paramColorStateList = new Drawable[3];
      paramColorStateList[0] = this.mBorderDrawable;
      paramColorStateList[1] = this.mShapeDrawable;
      paramColorStateList[2] = this.mRippleDrawable;
    }
    while (true)
    {
      this.mContentBackground = new LayerDrawable(paramColorStateList);
      this.mShadowDrawable = new ShadowDrawableWrapper(this.mView.getResources(), this.mContentBackground, this.mShadowViewDelegate.getRadius(), this.mElevation, this.mElevation + this.mPressedTranslationZ);
      this.mShadowDrawable.setAddPaddingForCorners(false);
      this.mShadowViewDelegate.setBackgroundDrawable(this.mShadowDrawable);
      return;
      this.mBorderDrawable = null;
      paramColorStateList = new Drawable[2];
      paramColorStateList[0] = this.mShapeDrawable;
      paramColorStateList[1] = this.mRippleDrawable;
    }
  }

  void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.mShapeDrawable != null)
      DrawableCompat.setTintList(this.mShapeDrawable, paramColorStateList);
    if (this.mBorderDrawable != null)
      this.mBorderDrawable.setBorderTint(paramColorStateList);
  }

  void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mShapeDrawable != null)
      DrawableCompat.setTintMode(this.mShapeDrawable, paramMode);
  }

  void setRippleColor(int paramInt)
  {
    if (this.mRippleDrawable != null)
      DrawableCompat.setTintList(this.mRippleDrawable, createColorStateList(paramInt));
  }

  void show(@Nullable FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if ((this.mView.getVisibility() != 0) || (this.mIsHiding))
    {
      this.mView.clearAnimation();
      this.mView.internalSetVisibility(0, paramBoolean);
      Animation localAnimation = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_fab_in);
      localAnimation.setDuration(200L);
      localAnimation.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
      localAnimation.setAnimationListener(new AnimationUtils.AnimationListenerAdapter(paramInternalVisibilityChangedListener)
      {
        public void onAnimationEnd(Animation paramAnimation)
        {
          if (this.val$listener != null)
            this.val$listener.onShown();
        }
      });
      this.mView.startAnimation(localAnimation);
    }
    do
      return;
    while (paramInternalVisibilityChangedListener == null);
    paramInternalVisibilityChangedListener.onShown();
  }

  private abstract class BaseShadowAnimation extends Animation
  {
    private float mShadowSizeDiff;
    private float mShadowSizeStart;

    private BaseShadowAnimation()
    {
    }

    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      FloatingActionButtonEclairMr1.this.mShadowDrawable.setShadowSize(this.mShadowSizeStart + this.mShadowSizeDiff * paramFloat);
    }

    protected abstract float getTargetShadowSize();

    public void reset()
    {
      super.reset();
      this.mShadowSizeStart = FloatingActionButtonEclairMr1.this.mShadowDrawable.getShadowSize();
      this.mShadowSizeDiff = (getTargetShadowSize() - this.mShadowSizeStart);
    }
  }

  private class ElevateToTranslationZAnimation extends FloatingActionButtonEclairMr1.BaseShadowAnimation
  {
    private ElevateToTranslationZAnimation()
    {
      super(null);
    }

    protected float getTargetShadowSize()
    {
      return FloatingActionButtonEclairMr1.this.mElevation + FloatingActionButtonEclairMr1.this.mPressedTranslationZ;
    }
  }

  private class ResetElevationAnimation extends FloatingActionButtonEclairMr1.BaseShadowAnimation
  {
    private ResetElevationAnimation()
    {
      super(null);
    }

    protected float getTargetShadowSize()
    {
      return FloatingActionButtonEclairMr1.this.mElevation;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButtonEclairMr1
 * JD-Core Version:    0.6.0
 */