package com.facebook.react.flat;

import android.view.View;
import com.facebook.react.views.viewpager.ReactViewPager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;
import java.util.List;

public class RCTViewPagerManager extends ReactViewPagerManager
{
  static final String REACT_CLASS = "AndroidViewPager";

  public void addViews(ReactViewPager paramReactViewPager, List<View> paramList)
  {
    paramReactViewPager.setViews(paramList);
  }

  public void removeAllViews(ReactViewPager paramReactViewPager)
  {
    paramReactViewPager.removeAllViewsFromAdapter();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTViewPagerManager
 * JD-Core Version:    0.6.0
 */