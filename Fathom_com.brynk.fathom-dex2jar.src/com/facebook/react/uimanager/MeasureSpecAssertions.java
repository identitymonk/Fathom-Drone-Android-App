package com.facebook.react.uimanager;

import android.view.View.MeasureSpec;

public class MeasureSpecAssertions
{
  public static final void assertExplicitMeasureSpec(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    if ((paramInt1 == 0) || (paramInt2 == 0))
      throw new IllegalStateException("A catalyst view must have an explicit width and height given to it. This should normally happen as part of the standard catalyst UI framework.");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.MeasureSpecAssertions
 * JD-Core Version:    0.6.0
 */