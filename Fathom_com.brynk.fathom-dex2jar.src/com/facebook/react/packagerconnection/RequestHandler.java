package com.facebook.react.packagerconnection;

import javax.annotation.Nullable;

public abstract interface RequestHandler
{
  public abstract void onNotification(@Nullable Object paramObject);

  public abstract void onRequest(@Nullable Object paramObject, Responder paramResponder);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.RequestHandler
 * JD-Core Version:    0.6.0
 */