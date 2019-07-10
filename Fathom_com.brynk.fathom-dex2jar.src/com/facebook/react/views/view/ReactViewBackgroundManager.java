package com.facebook.react.views.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.facebook.react.views.common.ViewHelper;
import javax.annotation.Nullable;

public class ReactViewBackgroundManager
{

  @Nullable
  private ReactViewBackgroundDrawable mReactBackgroundDrawable;
  private View mView;

  public ReactViewBackgroundManager(View paramView)
  {
    this.mView = paramView;
  }

  private ReactViewBackgroundDrawable getOrCreateReactViewBackground()
  {
    Object localObject;
    if (this.mReactBackgroundDrawable == null)
    {
      this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable();
      localObject = this.mView.getBackground();
      ViewHelper.setBackground(this.mView, null);
      if (localObject != null)
        break label54;
      ViewHelper.setBackground(this.mView, this.mReactBackgroundDrawable);
    }
    while (true)
    {
      return this.mReactBackgroundDrawable;
      label54: localObject = new LayerDrawable(new Drawable[] { this.mReactBackgroundDrawable, localObject });
      ViewHelper.setBackground(this.mView, (Drawable)localObject);
    }
  }

  public void setBackgroundColor(int paramInt)
  {
    if ((paramInt == 0) && (this.mReactBackgroundDrawable == null))
      return;
    getOrCreateReactViewBackground().setColor(paramInt);
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    getOrCreateReactViewBackground().setBorderColor(paramInt, paramFloat1, paramFloat2);
  }

  public void setBorderRadius(float paramFloat)
  {
    getOrCreateReactViewBackground().setRadius(paramFloat);
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    getOrCreateReactViewBackground().setRadius(paramFloat, paramInt);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    getOrCreateReactViewBackground().setBorderStyle(paramString);
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    getOrCreateReactViewBackground().setBorderWidth(paramInt, paramFloat);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactViewBackgroundManager
 * JD-Core Version:    0.6.0
 */