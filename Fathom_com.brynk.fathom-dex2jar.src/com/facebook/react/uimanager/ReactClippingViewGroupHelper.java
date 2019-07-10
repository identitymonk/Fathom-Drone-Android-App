package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.View;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class ReactClippingViewGroupHelper
{
  public static final String PROP_REMOVE_CLIPPED_SUBVIEWS = "removeClippedSubviews";
  private static final Rect sHelperRect = new Rect();

  public static void calculateClippingRect(View paramView, Rect paramRect)
  {
    Object localObject = paramView.getParent();
    if (localObject == null)
    {
      paramRect.setEmpty();
      return;
    }
    if ((localObject instanceof ReactClippingViewGroup))
    {
      localObject = (ReactClippingViewGroup)localObject;
      if (((ReactClippingViewGroup)localObject).getRemoveClippedSubviews())
      {
        ((ReactClippingViewGroup)localObject).getClippingRect(sHelperRect);
        if (!sHelperRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))
        {
          paramRect.setEmpty();
          return;
        }
        sHelperRect.offset(-paramView.getLeft(), -paramView.getTop());
        sHelperRect.offset(paramView.getScrollX(), paramView.getScrollY());
        paramRect.set(sHelperRect);
        return;
      }
    }
    paramView.getDrawingRect(paramRect);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactClippingViewGroupHelper
 * JD-Core Version:    0.6.0
 */