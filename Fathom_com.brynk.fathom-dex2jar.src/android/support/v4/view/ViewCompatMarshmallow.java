package android.support.v4.view;

import android.view.View;

class ViewCompatMarshmallow
{
  public static int getScrollIndicators(View paramView)
  {
    return paramView.getScrollIndicators();
  }

  static void offsetLeftAndRight(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
  }

  static void offsetTopAndBottom(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
  }

  public static void setScrollIndicators(View paramView, int paramInt)
  {
    paramView.setScrollIndicators(paramInt);
  }

  public static void setScrollIndicators(View paramView, int paramInt1, int paramInt2)
  {
    paramView.setScrollIndicators(paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompatMarshmallow
 * JD-Core Version:    0.6.0
 */