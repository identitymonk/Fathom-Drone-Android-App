package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.infer.annotation.Assertions;

public class RootViewUtil
{
  public static RootView getRootView(View paramView)
  {
    while (true)
    {
      if ((paramView instanceof RootView))
        return (RootView)paramView;
      paramView = paramView.getParent();
      if (paramView == null)
        return null;
      Assertions.assertCondition(paramView instanceof View);
      paramView = (View)paramView;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.RootViewUtil
 * JD-Core Version:    0.6.0
 */