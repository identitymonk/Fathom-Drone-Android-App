package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper
{
  private ColorStateList mButtonTintList = null;
  private PorterDuff.Mode mButtonTintMode = null;
  private final AppCompatDrawableManager mDrawableManager;
  private boolean mHasButtonTint = false;
  private boolean mHasButtonTintMode = false;
  private boolean mSkipNextApply;
  private final CompoundButton mView;

  AppCompatCompoundButtonHelper(CompoundButton paramCompoundButton, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    this.mView = paramCompoundButton;
    this.mDrawableManager = paramAppCompatDrawableManager;
  }

  void applyButtonTint()
  {
    Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
    if ((localDrawable != null) && ((this.mHasButtonTint) || (this.mHasButtonTintMode)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      if (this.mHasButtonTint)
        DrawableCompat.setTintList(localDrawable, this.mButtonTintList);
      if (this.mHasButtonTintMode)
        DrawableCompat.setTintMode(localDrawable, this.mButtonTintMode);
      if (localDrawable.isStateful())
        localDrawable.setState(this.mView.getDrawableState());
      this.mView.setButtonDrawable(localDrawable);
    }
  }

  int getCompoundPaddingLeft(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
      i = paramInt;
      if (localDrawable != null)
        i = paramInt + localDrawable.getIntrinsicWidth();
    }
    return i;
  }

  ColorStateList getSupportButtonTintList()
  {
    return this.mButtonTintList;
  }

  PorterDuff.Mode getSupportButtonTintMode()
  {
    return this.mButtonTintMode;
  }

  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(R.styleable.CompoundButton_android_button, 0);
        if (paramInt != 0)
          this.mView.setButtonDrawable(this.mDrawableManager.getDrawable(this.mView.getContext(), paramInt));
      }
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTint))
        CompoundButtonCompat.setButtonTintList(this.mView, paramAttributeSet.getColorStateList(R.styleable.CompoundButton_buttonTint));
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTintMode))
        CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(paramAttributeSet.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    throw localObject;
  }

  void onSetButtonDrawable()
  {
    if (this.mSkipNextApply)
    {
      this.mSkipNextApply = false;
      return;
    }
    this.mSkipNextApply = true;
    applyButtonTint();
  }

  void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.mButtonTintList = paramColorStateList;
    this.mHasButtonTint = true;
    applyButtonTint();
  }

  void setSupportButtonTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.mButtonTintMode = paramMode;
    this.mHasButtonTintMode = true;
    applyButtonTint();
  }

  static abstract interface DirectSetButtonDrawableInterface
  {
    public abstract void setButtonDrawable(Drawable paramDrawable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCompoundButtonHelper
 * JD-Core Version:    0.6.0
 */