package com.facebook.react.views.progressbar;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import javax.annotation.Nullable;

class ProgressBarContainerView extends FrameLayout
{
  private static final int MAX_PROGRESS = 1000;
  private boolean mAnimating = true;

  @Nullable
  private Integer mColor;
  private boolean mIndeterminate = true;
  private double mProgress;

  @Nullable
  private ProgressBar mProgressBar;

  public ProgressBarContainerView(Context paramContext)
  {
    super(paramContext);
  }

  private void setColor(ProgressBar paramProgressBar)
  {
    if (paramProgressBar.isIndeterminate());
    for (paramProgressBar = paramProgressBar.getIndeterminateDrawable(); paramProgressBar == null; paramProgressBar = paramProgressBar.getProgressDrawable())
      return;
    if (this.mColor != null)
    {
      paramProgressBar.setColorFilter(this.mColor.intValue(), PorterDuff.Mode.SRC_IN);
      return;
    }
    paramProgressBar.clearColorFilter();
  }

  public void apply()
  {
    if (this.mProgressBar == null)
      throw new JSApplicationIllegalArgumentException("setStyle() not called");
    this.mProgressBar.setIndeterminate(this.mIndeterminate);
    setColor(this.mProgressBar);
    this.mProgressBar.setProgress((int)(this.mProgress * 1000.0D));
    if (this.mAnimating)
    {
      this.mProgressBar.setVisibility(0);
      return;
    }
    this.mProgressBar.setVisibility(8);
  }

  public void setAnimating(boolean paramBoolean)
  {
    this.mAnimating = paramBoolean;
  }

  public void setColor(@Nullable Integer paramInteger)
  {
    this.mColor = paramInteger;
  }

  public void setIndeterminate(boolean paramBoolean)
  {
    this.mIndeterminate = paramBoolean;
  }

  public void setProgress(double paramDouble)
  {
    this.mProgress = paramDouble;
  }

  public void setStyle(@Nullable String paramString)
  {
    int i = ReactProgressBarViewManager.getStyleFromString(paramString);
    this.mProgressBar = ReactProgressBarViewManager.createProgressBar(getContext(), i);
    this.mProgressBar.setMax(1000);
    removeAllViews();
    addView(this.mProgressBar, new ViewGroup.LayoutParams(-1, -1));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.progressbar.ProgressBarContainerView
 * JD-Core Version:    0.6.0
 */