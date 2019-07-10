package com.facebook.react.bridge;

import android.content.Context;

public abstract class ContextBaseJavaModule extends BaseJavaModule
{
  private final Context mContext;

  public ContextBaseJavaModule(Context paramContext)
  {
    this.mContext = paramContext;
  }

  protected final Context getContext()
  {
    return this.mContext;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ContextBaseJavaModule
 * JD-Core Version:    0.6.0
 */