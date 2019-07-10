package com.facebook.react.flat;

import android.view.ViewGroup;
import com.facebook.react.uimanager.RootViewManager;

class FlatRootViewManager extends RootViewManager
{
  public void removeAllViews(ViewGroup paramViewGroup)
  {
    paramViewGroup.removeAllViewsInLayout();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatRootViewManager
 * JD-Core Version:    0.6.0
 */