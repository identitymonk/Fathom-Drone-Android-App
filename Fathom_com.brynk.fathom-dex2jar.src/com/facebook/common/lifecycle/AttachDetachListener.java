package com.facebook.common.lifecycle;

import android.view.View;

public abstract interface AttachDetachListener
{
  public abstract void onAttachToView(View paramView);

  public abstract void onDetachFromView(View paramView);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.lifecycle.AttachDetachListener
 * JD-Core Version:    0.6.0
 */