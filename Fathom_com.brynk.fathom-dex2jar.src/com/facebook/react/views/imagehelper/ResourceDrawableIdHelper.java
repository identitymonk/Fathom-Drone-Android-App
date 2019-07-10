package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ResourceDrawableIdHelper
{
  private static final String LOCAL_RESOURCE_SCHEME = "res";
  private static volatile ResourceDrawableIdHelper sResourceDrawableIdHelper;
  private Map<String, Integer> mResourceDrawableIdMap = new HashMap();

  public static ResourceDrawableIdHelper getInstance()
  {
    if (sResourceDrawableIdHelper == null)
      monitorenter;
    try
    {
      if (sResourceDrawableIdHelper == null)
        sResourceDrawableIdHelper = new ResourceDrawableIdHelper();
      return sResourceDrawableIdHelper;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void clear()
  {
    monitorenter;
    try
    {
      this.mResourceDrawableIdMap.clear();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  @Nullable
  public Drawable getResourceDrawable(Context paramContext, @Nullable String paramString)
  {
    int i = getResourceDrawableId(paramContext, paramString);
    if (i > 0)
      return paramContext.getResources().getDrawable(i);
    return null;
  }

  public int getResourceDrawableId(Context paramContext, @Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return 0;
    paramString = paramString.toLowerCase().replace("-", "_");
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      monitorenter;
      try
      {
        if (this.mResourceDrawableIdMap.containsKey(paramString))
        {
          i = ((Integer)this.mResourceDrawableIdMap.get(paramString)).intValue();
          return i;
        }
      }
      finally
      {
        monitorexit;
      }
      i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
      this.mResourceDrawableIdMap.put(paramString, Integer.valueOf(i));
      monitorexit;
    }
    return i;
  }

  public Uri getResourceDrawableUri(Context paramContext, @Nullable String paramString)
  {
    int i = getResourceDrawableId(paramContext, paramString);
    if (i > 0)
      return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    return Uri.EMPTY;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.imagehelper.ResourceDrawableIdHelper
 * JD-Core Version:    0.6.0
 */