package com.facebook.react.modules.core;

public abstract interface PermissionAwareActivity
{
  public abstract int checkPermission(String paramString, int paramInt1, int paramInt2);

  public abstract int checkSelfPermission(String paramString);

  public abstract void requestPermissions(String[] paramArrayOfString, int paramInt, PermissionListener paramPermissionListener);

  public abstract boolean shouldShowRequestPermissionRationale(String paramString);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.PermissionAwareActivity
 * JD-Core Version:    0.6.0
 */