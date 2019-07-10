package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupUtils
{
  private static final ViewGroupUtilsImpl IMPL;

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new ViewGroupUtilsImplHoneycomb(null);
      return;
    }
    IMPL = new ViewGroupUtilsImplBase(null);
  }

  static void getDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    offsetDescendantRect(paramViewGroup, paramView, paramRect);
  }

  static void offsetDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    IMPL.offsetDescendantRect(paramViewGroup, paramView, paramRect);
  }

  private static abstract interface ViewGroupUtilsImpl
  {
    public abstract void offsetDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect);
  }

  private static class ViewGroupUtilsImplBase
    implements ViewGroupUtils.ViewGroupUtilsImpl
  {
    public void offsetDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
    {
      paramViewGroup.offsetDescendantRectToMyCoords(paramView, paramRect);
      paramRect.offset(paramView.getScrollX(), paramView.getScrollY());
    }
  }

  private static class ViewGroupUtilsImplHoneycomb
    implements ViewGroupUtils.ViewGroupUtilsImpl
  {
    public void offsetDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
    {
      ViewGroupUtilsHoneycomb.offsetDescendantRect(paramViewGroup, paramView, paramRect);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.ViewGroupUtils
 * JD-Core Version:    0.6.0
 */