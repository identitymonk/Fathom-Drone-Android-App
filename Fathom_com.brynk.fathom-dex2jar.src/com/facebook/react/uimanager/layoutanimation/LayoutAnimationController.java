package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class LayoutAnimationController
{
  private static final boolean ENABLED = true;
  private final AbstractLayoutAnimation mLayoutCreateAnimation = new LayoutCreateAnimation();
  private final AbstractLayoutAnimation mLayoutDeleteAnimation = new LayoutDeleteAnimation();
  private final AbstractLayoutAnimation mLayoutUpdateAnimation = new LayoutUpdateAnimation();
  private boolean mShouldAnimateLayout;

  private void disableUserInteractions(View paramView)
  {
    paramView.setClickable(false);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        disableUserInteractions(paramView.getChildAt(i));
        i += 1;
      }
    }
  }

  public void applyLayoutUpdate(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    UiThreadUtil.assertOnUiThread();
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0));
    for (Object localObject = this.mLayoutCreateAnimation; ; localObject = this.mLayoutUpdateAnimation)
    {
      localObject = ((AbstractLayoutAnimation)localObject).createAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((localObject == null) || (!(localObject instanceof HandleLayout)))
        paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      if (localObject != null)
        paramView.startAnimation((Animation)localObject);
      return;
    }
  }

  public void deleteView(View paramView, LayoutAnimationListener paramLayoutAnimationListener)
  {
    UiThreadUtil.assertOnUiThread();
    Animation localAnimation = this.mLayoutDeleteAnimation.createAnimation(paramView, paramView.getLeft(), paramView.getTop(), paramView.getWidth(), paramView.getHeight());
    if (localAnimation != null)
    {
      disableUserInteractions(paramView);
      localAnimation.setAnimationListener(new Animation.AnimationListener(paramLayoutAnimationListener)
      {
        public void onAnimationEnd(Animation paramAnimation)
        {
          this.val$listener.onAnimationEnd();
        }

        public void onAnimationRepeat(Animation paramAnimation)
        {
        }

        public void onAnimationStart(Animation paramAnimation)
        {
        }
      });
      paramView.startAnimation(localAnimation);
      return;
    }
    paramLayoutAnimationListener.onAnimationEnd();
  }

  public void initializeFromConfig(@Nullable ReadableMap paramReadableMap)
  {
    int i = 0;
    if (paramReadableMap == null)
      reset();
    do
    {
      return;
      this.mShouldAnimateLayout = false;
      if (paramReadableMap.hasKey("duration"))
        i = paramReadableMap.getInt("duration");
      if (paramReadableMap.hasKey(LayoutAnimationType.CREATE.toString()))
      {
        this.mLayoutCreateAnimation.initializeFromConfig(paramReadableMap.getMap(LayoutAnimationType.CREATE.toString()), i);
        this.mShouldAnimateLayout = true;
      }
      if (!paramReadableMap.hasKey(LayoutAnimationType.UPDATE.toString()))
        continue;
      this.mLayoutUpdateAnimation.initializeFromConfig(paramReadableMap.getMap(LayoutAnimationType.UPDATE.toString()), i);
      this.mShouldAnimateLayout = true;
    }
    while (!paramReadableMap.hasKey(LayoutAnimationType.DELETE.toString()));
    this.mLayoutDeleteAnimation.initializeFromConfig(paramReadableMap.getMap(LayoutAnimationType.DELETE.toString()), i);
    this.mShouldAnimateLayout = true;
  }

  public void reset()
  {
    this.mLayoutCreateAnimation.reset();
    this.mLayoutUpdateAnimation.reset();
    this.mLayoutDeleteAnimation.reset();
    this.mShouldAnimateLayout = false;
  }

  public boolean shouldAnimateLayout(View paramView)
  {
    return (this.mShouldAnimateLayout) && (paramView.getParent() != null);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.LayoutAnimationController
 * JD-Core Version:    0.6.0
 */