package com.facebook.react.uimanager;

import java.util.Comparator;

class ViewAtIndex
{
  public static Comparator<ViewAtIndex> COMPARATOR = new Comparator()
  {
    public int compare(ViewAtIndex paramViewAtIndex1, ViewAtIndex paramViewAtIndex2)
    {
      return paramViewAtIndex1.mIndex - paramViewAtIndex2.mIndex;
    }
  };
  public final int mIndex;
  public final int mTag;

  public ViewAtIndex(int paramInt1, int paramInt2)
  {
    this.mTag = paramInt1;
    this.mIndex = paramInt2;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewAtIndex
 * JD-Core Version:    0.6.0
 */