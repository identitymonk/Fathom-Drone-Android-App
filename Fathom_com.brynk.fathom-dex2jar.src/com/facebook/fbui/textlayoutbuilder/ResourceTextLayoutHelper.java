package com.facebook.fbui.textlayoutbuilder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.AttrRes;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;

public class ResourceTextLayoutHelper
{
  private static final int DEFAULT_TEXT_SIZE_PX = 15;

  public static void setTextAppearance(TextLayoutBuilder paramTextLayoutBuilder, Context paramContext, @StyleRes int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearance);
    ColorStateList localColorStateList = paramContext.getColorStateList(R.styleable.TextAppearance_android_textColor);
    paramInt = paramContext.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
    int i = paramContext.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
    if (i != 0)
    {
      float f1 = paramContext.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
      float f2 = paramContext.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
      paramTextLayoutBuilder.setShadowLayer(paramContext.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F), f1, f2, i);
    }
    i = paramContext.getInt(R.styleable.TextAppearance_android_textStyle, -1);
    paramContext.recycle();
    if (localColorStateList != null)
      paramTextLayoutBuilder.setTextColor(localColorStateList);
    if (paramInt != 0)
      paramTextLayoutBuilder.setTextSize(paramInt);
    if (i != -1)
      paramTextLayoutBuilder.setTypeface(Typeface.defaultFromStyle(i));
  }

  public static void updateFromStyleResource(TextLayoutBuilder paramTextLayoutBuilder, Context paramContext, @StyleRes int paramInt)
  {
    updateFromStyleResource(paramTextLayoutBuilder, paramContext, 0, paramInt);
  }

  public static void updateFromStyleResource(TextLayoutBuilder paramTextLayoutBuilder, Context paramContext, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    updateFromStyleResource(paramTextLayoutBuilder, paramContext, null, paramInt1, paramInt2);
  }

  public static void updateFromStyleResource(TextLayoutBuilder paramTextLayoutBuilder, Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextStyle, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.getResourceId(R.styleable.TextStyle_android_textAppearance, -1);
    if (paramInt1 > 0)
      setTextAppearance(paramTextLayoutBuilder, paramContext, paramInt1);
    paramContext = paramAttributeSet.getColorStateList(R.styleable.TextStyle_android_textColor);
    paramInt1 = paramAttributeSet.getDimensionPixelSize(R.styleable.TextStyle_android_textSize, 15);
    paramInt2 = paramAttributeSet.getInt(R.styleable.TextStyle_android_shadowColor, 0);
    float f1 = paramAttributeSet.getFloat(R.styleable.TextStyle_android_shadowDx, 0.0F);
    float f2 = paramAttributeSet.getFloat(R.styleable.TextStyle_android_shadowDy, 0.0F);
    float f3 = paramAttributeSet.getFloat(R.styleable.TextStyle_android_shadowRadius, 0.0F);
    int i = paramAttributeSet.getInt(R.styleable.TextStyle_android_textStyle, -1);
    int j = paramAttributeSet.getInt(R.styleable.TextStyle_android_ellipsize, 0);
    boolean bool = paramAttributeSet.getBoolean(R.styleable.TextStyle_android_singleLine, false);
    int k = paramAttributeSet.getInt(R.styleable.TextStyle_android_maxLines, 2147483647);
    paramAttributeSet.recycle();
    paramTextLayoutBuilder.setTextColor(paramContext);
    paramTextLayoutBuilder.setTextSize(paramInt1);
    paramTextLayoutBuilder.setShadowLayer(f3, f1, f2, paramInt2);
    if (i != -1)
    {
      paramTextLayoutBuilder.setTypeface(Typeface.defaultFromStyle(i));
      if ((j <= 0) || (j >= 4))
        break label223;
      paramTextLayoutBuilder.setEllipsize(android.text.TextUtils.TruncateAt.values()[(j - 1)]);
    }
    while (true)
    {
      paramTextLayoutBuilder.setSingleLine(bool);
      paramTextLayoutBuilder.setMaxLines(k);
      return;
      paramTextLayoutBuilder.setTypeface(null);
      break;
      label223: paramTextLayoutBuilder.setEllipsize(null);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.fbui.textlayoutbuilder.ResourceTextLayoutHelper
 * JD-Core Version:    0.6.0
 */