package com.facebook.react.views.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;

public class ReactDrawableHelper
{
  private static final TypedValue sResolveOutValue = new TypedValue();

  public static Drawable createDrawableFromJSDescription(Context paramContext, ReadableMap paramReadableMap)
  {
    String str = paramReadableMap.getString("type");
    int i;
    if ("ThemeAttrAndroid".equals(str))
    {
      paramReadableMap = paramReadableMap.getString("attribute");
      SoftAssertions.assertNotNull(paramReadableMap);
      i = paramContext.getResources().getIdentifier(paramReadableMap, "attr", "android");
      if (i == 0)
        throw new JSApplicationIllegalArgumentException("Attribute " + paramReadableMap + " couldn't be found in the resource list");
      if (paramContext.getTheme().resolveAttribute(i, sResolveOutValue, true))
      {
        if (Build.VERSION.SDK_INT >= 21)
          return paramContext.getResources().getDrawable(sResolveOutValue.resourceId, paramContext.getTheme());
        return paramContext.getResources().getDrawable(sResolveOutValue.resourceId);
      }
      throw new JSApplicationIllegalArgumentException("Attribute " + paramReadableMap + " couldn't be resolved into a drawable");
    }
    if ("RippleAndroid".equals(str))
    {
      if (Build.VERSION.SDK_INT < 21)
        throw new JSApplicationIllegalArgumentException("Ripple drawable is not available on android API <21");
      if ((paramReadableMap.hasKey("color")) && (!paramReadableMap.isNull("color")));
      for (i = paramReadableMap.getInt("color"); ; i = paramContext.getResources().getColor(sResolveOutValue.resourceId))
      {
        paramContext = null;
        if ((!paramReadableMap.hasKey("borderless")) || (paramReadableMap.isNull("borderless")) || (!paramReadableMap.getBoolean("borderless")))
          paramContext = new ColorDrawable(-1);
        return new RippleDrawable(new ColorStateList(new int[][] { new int[0] }, new int[] { i }), null, paramContext);
        if (!paramContext.getTheme().resolveAttribute(16843820, sResolveOutValue, true))
          break;
      }
      throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
    }
    throw new JSApplicationIllegalArgumentException("Invalid type for android drawable: " + str);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactDrawableHelper
 * JD-Core Version:    0.6.0
 */