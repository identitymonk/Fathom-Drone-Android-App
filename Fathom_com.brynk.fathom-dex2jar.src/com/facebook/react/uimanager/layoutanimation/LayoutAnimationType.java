package com.facebook.react.uimanager.layoutanimation;

 enum LayoutAnimationType
{
  private final String mName;

  static
  {
    DELETE = new LayoutAnimationType("DELETE", 2, "delete");
    $VALUES = new LayoutAnimationType[] { CREATE, UPDATE, DELETE };
  }

  private LayoutAnimationType(String paramString)
  {
    this.mName = paramString;
  }

  public String toString()
  {
    return this.mName;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.LayoutAnimationType
 * JD-Core Version:    0.6.0
 */