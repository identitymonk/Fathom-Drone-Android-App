package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;

class DrawerLayoutCompatApi21
{
  private static final int[] THEME_ATTRS = { 16843828 };

  public static void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt)
  {
    WindowInsets localWindowInsets = (WindowInsets)paramObject;
    if (paramInt == 3)
      paramObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
    while (true)
    {
      paramMarginLayoutParams.leftMargin = paramObject.getSystemWindowInsetLeft();
      paramMarginLayoutParams.topMargin = paramObject.getSystemWindowInsetTop();
      paramMarginLayoutParams.rightMargin = paramObject.getSystemWindowInsetRight();
      paramMarginLayoutParams.bottomMargin = paramObject.getSystemWindowInsetBottom();
      return;
      paramObject = localWindowInsets;
      if (paramInt != 5)
        continue;
      paramObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
    }
  }

  public static void configureApplyInsets(View paramView)
  {
    if ((paramView instanceof DrawerLayoutImpl))
    {
      paramView.setOnApplyWindowInsetsListener(new InsetsListener());
      paramView.setSystemUiVisibility(1280);
    }
  }

  public static void dispatchChildInsets(View paramView, Object paramObject, int paramInt)
  {
    WindowInsets localWindowInsets = (WindowInsets)paramObject;
    if (paramInt == 3)
      paramObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
    while (true)
    {
      paramView.dispatchApplyWindowInsets(paramObject);
      return;
      paramObject = localWindowInsets;
      if (paramInt != 5)
        continue;
      paramObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
    }
  }

  public static Drawable getDefaultStatusBarBackground(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(THEME_ATTRS);
    try
    {
      Drawable localDrawable = paramContext.getDrawable(0);
      return localDrawable;
    }
    finally
    {
      paramContext.recycle();
    }
    throw localObject;
  }

  public static int getTopInset(Object paramObject)
  {
    if (paramObject != null)
      return ((WindowInsets)paramObject).getSystemWindowInsetTop();
    return 0;
  }

  static class InsetsListener
    implements View.OnApplyWindowInsetsListener
  {
    public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
    {
      paramView = (DrawerLayoutImpl)paramView;
      if (paramWindowInsets.getSystemWindowInsetTop() > 0);
      for (boolean bool = true; ; bool = false)
      {
        paramView.setChildInsets(paramWindowInsets, bool);
        return paramWindowInsets.consumeSystemWindowInsets();
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayoutCompatApi21
 * JD-Core Version:    0.6.0
 */