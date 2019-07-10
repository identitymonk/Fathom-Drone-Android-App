package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
class FloatingActionButtonLollipop extends FloatingActionButtonIcs
{
  private InsetDrawable mInsetDrawable;
  private final Interpolator mInterpolator;

  FloatingActionButtonLollipop(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate);
    if (paramVisibilityAwareImageButton.isInEditMode());
    for (paramVisibilityAwareImageButton = null; ; paramVisibilityAwareImageButton = AnimationUtils.loadInterpolator(this.mView.getContext(), 17563661))
    {
      this.mInterpolator = paramVisibilityAwareImageButton;
      return;
    }
  }

  private Animator setupAnimator(Animator paramAnimator)
  {
    paramAnimator.setInterpolator(this.mInterpolator);
    return paramAnimator;
  }

  public float getElevation()
  {
    return this.mView.getElevation();
  }

  void getPadding(Rect paramRect)
  {
    if (this.mShadowViewDelegate.isCompatPaddingEnabled())
    {
      float f1 = this.mShadowViewDelegate.getRadius();
      float f2 = getElevation() + this.mPressedTranslationZ;
      int i = (int)Math.ceil(ShadowDrawableWrapper.calculateHorizontalPadding(f2, f1, false));
      int j = (int)Math.ceil(ShadowDrawableWrapper.calculateVerticalPadding(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }

  void jumpDrawableToCurrentState()
  {
  }

  CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawableLollipop();
  }

  void onCompatShadowChanged()
  {
    updatePadding();
  }

  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
  }

  public void onElevationChanged(float paramFloat)
  {
    this.mView.setElevation(paramFloat);
    if (this.mShadowViewDelegate.isCompatPaddingEnabled())
      updatePadding();
  }

  void onPaddingUpdated(Rect paramRect)
  {
    if (this.mShadowViewDelegate.isCompatPaddingEnabled())
    {
      this.mInsetDrawable = new InsetDrawable(this.mRippleDrawable, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.mShadowViewDelegate.setBackgroundDrawable(this.mInsetDrawable);
      return;
    }
    this.mShadowViewDelegate.setBackgroundDrawable(this.mRippleDrawable);
  }

  void onTranslationZChanged(float paramFloat)
  {
    StateListAnimator localStateListAnimator = new StateListAnimator();
    localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, setupAnimator(ObjectAnimator.ofFloat(this.mView, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, setupAnimator(ObjectAnimator.ofFloat(this.mView, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(EMPTY_STATE_SET, setupAnimator(ObjectAnimator.ofFloat(this.mView, "translationZ", new float[] { 0.0F })));
    this.mView.setStateListAnimator(localStateListAnimator);
    if (this.mShadowViewDelegate.isCompatPaddingEnabled())
      updatePadding();
  }

  boolean requirePreDrawListener()
  {
    return false;
  }

  void setBackgroundDrawable(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    this.mShapeDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(this.mShapeDrawable, paramColorStateList);
    if (paramMode != null)
      DrawableCompat.setTintMode(this.mShapeDrawable, paramMode);
    if (paramInt2 > 0)
      this.mBorderDrawable = createBorderDrawable(paramInt2, paramColorStateList);
    for (paramColorStateList = new LayerDrawable(new Drawable[] { this.mBorderDrawable, this.mShapeDrawable }); ; paramColorStateList = this.mShapeDrawable)
    {
      this.mRippleDrawable = new RippleDrawable(ColorStateList.valueOf(paramInt1), paramColorStateList, null);
      this.mContentBackground = this.mRippleDrawable;
      this.mShadowViewDelegate.setBackgroundDrawable(this.mRippleDrawable);
      return;
      this.mBorderDrawable = null;
    }
  }

  void setRippleColor(int paramInt)
  {
    if ((this.mRippleDrawable instanceof RippleDrawable))
    {
      ((RippleDrawable)this.mRippleDrawable).setColor(ColorStateList.valueOf(paramInt));
      return;
    }
    super.setRippleColor(paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButtonLollipop
 * JD-Core Version:    0.6.0
 */