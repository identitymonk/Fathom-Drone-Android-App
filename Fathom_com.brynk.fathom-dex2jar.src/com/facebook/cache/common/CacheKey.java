package com.facebook.cache.common;

import android.net.Uri;

public abstract interface CacheKey
{
  public abstract boolean containsUri(Uri paramUri);

  public abstract boolean equals(Object paramObject);

  public abstract String getUriString();

  public abstract int hashCode();

  public abstract String toString();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.CacheKey
 * JD-Core Version:    0.6.0
 */