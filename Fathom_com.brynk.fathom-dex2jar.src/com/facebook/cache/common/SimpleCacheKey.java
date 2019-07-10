package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;

public class SimpleCacheKey
  implements CacheKey
{
  final String mKey;

  public SimpleCacheKey(String paramString)
  {
    this.mKey = ((String)Preconditions.checkNotNull(paramString));
  }

  public boolean containsUri(Uri paramUri)
  {
    return this.mKey.contains(paramUri.toString());
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if ((paramObject instanceof SimpleCacheKey))
    {
      paramObject = (SimpleCacheKey)paramObject;
      return this.mKey.equals(paramObject.mKey);
    }
    return false;
  }

  public String getUriString()
  {
    return this.mKey;
  }

  public int hashCode()
  {
    return this.mKey.hashCode();
  }

  public String toString()
  {
    return this.mKey;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.SimpleCacheKey
 * JD-Core Version:    0.6.0
 */