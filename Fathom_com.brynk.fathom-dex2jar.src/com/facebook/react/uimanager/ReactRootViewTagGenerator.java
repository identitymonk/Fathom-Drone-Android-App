package com.facebook.react.uimanager;

public class ReactRootViewTagGenerator
{
  private static final int ROOT_VIEW_TAG_INCREMENT = 10;
  private static int sNextRootViewTag = 1;

  public static int getNextRootViewTag()
  {
    monitorenter;
    try
    {
      int i = sNextRootViewTag;
      sNextRootViewTag += 10;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactRootViewTagGenerator
 * JD-Core Version:    0.6.0
 */