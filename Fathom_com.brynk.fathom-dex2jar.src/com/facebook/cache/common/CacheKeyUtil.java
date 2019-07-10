package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class CacheKeyUtil
{
  public static String getFirstResourceId(CacheKey paramCacheKey)
  {
    try
    {
      if ((paramCacheKey instanceof MultiCacheKey))
        return secureHashKey((CacheKey)((MultiCacheKey)paramCacheKey).getCacheKeys().get(0));
      paramCacheKey = secureHashKey(paramCacheKey);
      return paramCacheKey;
    }
    catch (UnsupportedEncodingException paramCacheKey)
    {
    }
    throw new RuntimeException(paramCacheKey);
  }

  public static List<String> getResourceIds(CacheKey paramCacheKey)
  {
    try
    {
      if ((paramCacheKey instanceof MultiCacheKey))
      {
        List localList = ((MultiCacheKey)paramCacheKey).getCacheKeys();
        localArrayList = new ArrayList(localList.size());
        int i = 0;
        while (true)
        {
          paramCacheKey = localArrayList;
          if (i >= localList.size())
            break;
          localArrayList.add(secureHashKey((CacheKey)localList.get(i)));
          i += 1;
        }
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(secureHashKey(paramCacheKey));
      paramCacheKey = localArrayList;
      return paramCacheKey;
    }
    catch (UnsupportedEncodingException paramCacheKey)
    {
    }
    throw new RuntimeException(paramCacheKey);
  }

  private static String secureHashKey(CacheKey paramCacheKey)
    throws UnsupportedEncodingException
  {
    return SecureHashUtil.makeSHA1HashBase64(paramCacheKey.getUriString().getBytes("UTF-8"));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.CacheKeyUtil
 * JD-Core Version:    0.6.0
 */