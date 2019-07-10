package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;

public final class DefaultStyleValuesUtil
{
  private DefaultStyleValuesUtil()
  {
    throw new AssertionError("Never invoke this for an Utility class!");
  }

  private static ColorStateList getDefaultTextAttribute(Context paramContext, int paramInt)
  {
    Object localObject1 = paramContext.getTheme();
    paramContext = null;
    try
    {
      localObject1 = ((Resources.Theme)localObject1).obtainStyledAttributes(new int[] { paramInt });
      paramContext = (Context)localObject1;
      ColorStateList localColorStateList = ((TypedArray)localObject1).getColorStateList(0);
      if (localObject1 != null)
        ((TypedArray)localObject1).recycle();
      return localColorStateList;
    }
    finally
    {
      if (paramContext != null)
        paramContext.recycle();
    }
    throw localObject2;
  }

  public static ColorStateList getDefaultTextColor(Context paramContext)
  {
    return getDefaultTextAttribute(paramContext, 16842904);
  }

  public static int getDefaultTextColorHighlight(Context paramContext)
  {
    return getDefaultTextAttribute(paramContext, 16842905).getDefaultColor();
  }

  public static ColorStateList getDefaultTextColorHint(Context paramContext)
  {
    return getDefaultTextAttribute(paramContext, 16842906);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.DefaultStyleValuesUtil
 * JD-Core Version:    0.6.0
 */