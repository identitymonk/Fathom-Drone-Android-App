package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnTouchListener;

public final class ListPopupWindowCompat
{
  static final ListPopupWindowImpl IMPL;

  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new KitKatListPopupWindowImpl();
      return;
    }
    IMPL = new BaseListPopupWindowImpl();
  }

  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
  {
    return IMPL.createDragToOpenListener(paramObject, paramView);
  }

  static class BaseListPopupWindowImpl
    implements ListPopupWindowCompat.ListPopupWindowImpl
  {
    public View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
    {
      return null;
    }
  }

  static class KitKatListPopupWindowImpl extends ListPopupWindowCompat.BaseListPopupWindowImpl
  {
    public View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
    {
      return ListPopupWindowCompatKitKat.createDragToOpenListener(paramObject, paramView);
    }
  }

  static abstract interface ListPopupWindowImpl
  {
    public abstract View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ListPopupWindowCompat
 * JD-Core Version:    0.6.0
 */