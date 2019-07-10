package com.facebook.fbui.textlayoutbuilder;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.facebook.fbui.textlayoutbuilder.proxy.StaticLayoutProxy;
import java.lang.reflect.Field;

class StaticLayoutHelper
{
  private static final String SPACE_AND_ELLIPSIS = " …";

  public static boolean fixLayout(StaticLayout paramStaticLayout)
  {
    int j = paramStaticLayout.getLineStart(0);
    int i = 0;
    int m = paramStaticLayout.getLineCount();
    while (true)
    {
      int k;
      if (i < m)
      {
        k = paramStaticLayout.getLineEnd(i);
        if (k >= j)
          break label118;
        try
        {
          Object localObject = StaticLayout.class.getDeclaredField("mLines");
          ((Field)localObject).setAccessible(true);
          Field localField = StaticLayout.class.getDeclaredField("mColumns");
          localField.setAccessible(true);
          localObject = (int[])(int[])((Field)localObject).get(paramStaticLayout);
          k = localField.getInt(paramStaticLayout);
          j = 0;
          while (j < k)
          {
            swap(localObject, k * i + j, k * i + j + k);
            j += 1;
          }
        }
        catch (java.lang.Exception paramStaticLayout)
        {
        }
      }
      else
      {
        return true;
      }
      return false;
      label118: j = k;
      i += 1;
    }
  }

  private static StaticLayout getStaticLayoutMaybeMaxLines(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    try
    {
      paramTextDirectionHeuristicCompat = StaticLayoutProxy.create(paramCharSequence, paramInt1, paramInt2, paramTextPaint, paramInt3, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4, paramInt5, paramTextDirectionHeuristicCompat);
      return paramTextDirectionHeuristicCompat;
    }
    catch (java.lang.LinkageError paramTextDirectionHeuristicCompat)
    {
    }
    return getStaticLayoutNoMaxLines(paramCharSequence, paramInt1, paramInt2, paramTextPaint, paramInt3, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4);
  }

  private static StaticLayout getStaticLayoutNoMaxLines(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4)
  {
    return new StaticLayout(paramCharSequence, paramInt1, paramInt2, paramTextPaint, paramInt3, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4);
  }

  public static StaticLayout make(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    Object localObject1 = getStaticLayoutMaybeMaxLines(paramCharSequence, paramInt1, paramInt2, paramTextPaint, paramInt3, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4, paramInt5, paramTextDirectionHeuristicCompat);
    Object localObject2 = localObject1;
    int i;
    if (paramInt5 > 0)
      i = paramInt2;
    while (true)
    {
      localObject2 = localObject1;
      if (((StaticLayout)localObject1).getLineCount() > paramInt5)
      {
        int j = ((StaticLayout)localObject1).getLineStart(paramInt5);
        paramInt2 = j;
        if (j >= i)
          localObject2 = localObject1;
      }
      else
      {
        while (!fixLayout((StaticLayout)localObject2));
        return localObject2;
      }
      while ((paramInt2 > paramInt1) && (Character.isSpace(paramCharSequence.charAt(paramInt2 - 1))))
        paramInt2 -= 1;
      localObject2 = getStaticLayoutMaybeMaxLines(paramCharSequence, paramInt1, paramInt2, paramTextPaint, paramInt3, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4, paramInt5, paramTextDirectionHeuristicCompat);
      localObject1 = localObject2;
      i = paramInt2;
      if (((StaticLayout)localObject2).getLineCount() < paramInt5)
        continue;
      localObject1 = localObject2;
      i = paramInt2;
      if (((StaticLayout)localObject2).getEllipsisCount(paramInt5 - 1) != 0)
        continue;
      localObject1 = paramCharSequence.subSequence(paramInt1, paramInt2) + " …";
      localObject1 = getStaticLayoutMaybeMaxLines((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), paramTextPaint, paramInt3, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4, paramInt5, paramTextDirectionHeuristicCompat);
      i = paramInt2;
    }
  }

  private static void swap(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfInt[paramInt1];
    paramArrayOfInt[paramInt1] = paramArrayOfInt[paramInt2];
    paramArrayOfInt[paramInt2] = i;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.fbui.textlayoutbuilder.StaticLayoutHelper
 * JD-Core Version:    0.6.0
 */