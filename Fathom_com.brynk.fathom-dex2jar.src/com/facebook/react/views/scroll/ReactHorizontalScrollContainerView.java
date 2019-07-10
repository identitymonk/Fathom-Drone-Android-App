package com.facebook.react.views.scroll;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.facebook.react.modules.i18nmanager.I18nUtil;

public class ReactHorizontalScrollContainerView extends ViewGroup
{
  private int mLayoutDirection;

  public ReactHorizontalScrollContainerView(Context paramContext)
  {
    super(paramContext);
    if (I18nUtil.getInstance().isRTL(paramContext));
    for (int i = 1; ; i = 0)
    {
      this.mLayoutDirection = i;
      return;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mLayoutDirection == 1)
    {
      setLeft(0);
      setRight(0 + (paramInt3 - paramInt1));
      paramInt1 = computeHorizontalScrollRange();
      paramInt2 = getScrollX();
      HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)getParent();
      localHorizontalScrollView.scrollTo(paramInt1 - paramInt2, localHorizontalScrollView.getScrollY());
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactHorizontalScrollContainerView
 * JD-Core Version:    0.6.0
 */