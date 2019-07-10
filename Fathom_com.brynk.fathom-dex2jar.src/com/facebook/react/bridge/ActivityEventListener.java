package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Intent;

public abstract interface ActivityEventListener
{
  public abstract void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);

  public abstract void onNewIntent(Intent paramIntent);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ActivityEventListener
 * JD-Core Version:    0.6.0
 */