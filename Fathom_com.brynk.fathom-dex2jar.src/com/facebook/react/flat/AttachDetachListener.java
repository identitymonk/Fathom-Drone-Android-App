package com.facebook.react.flat;

abstract interface AttachDetachListener
{
  public static final AttachDetachListener[] EMPTY_ARRAY = new AttachDetachListener[0];

  public abstract void onAttached(FlatViewGroup.InvalidateCallback paramInvalidateCallback);

  public abstract void onDetached();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.AttachDetachListener
 * JD-Core Version:    0.6.0
 */