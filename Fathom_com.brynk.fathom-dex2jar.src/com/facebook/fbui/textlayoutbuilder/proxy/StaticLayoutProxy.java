package com.facebook.fbui.textlayoutbuilder.proxy;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public class StaticLayoutProxy
{
  public static StaticLayout create(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return new StaticLayout(paramCharSequence, paramInt1, paramInt2, paramTextPaint, paramInt3, paramAlignment, fromTextDirectionHeuristicCompat(paramTextDirectionHeuristicCompat), paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4, paramInt5);
  }

  private static TextDirectionHeuristic fromTextDirectionHeuristicCompat(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    if (paramTextDirectionHeuristicCompat == TextDirectionHeuristicsCompat.LTR)
      return TextDirectionHeuristics.LTR;
    if (paramTextDirectionHeuristicCompat == TextDirectionHeuristicsCompat.RTL)
      return TextDirectionHeuristics.RTL;
    if (paramTextDirectionHeuristicCompat == TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR)
      return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    if (paramTextDirectionHeuristicCompat == TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL)
      return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    if (paramTextDirectionHeuristicCompat == TextDirectionHeuristicsCompat.ANYRTL_LTR)
      return TextDirectionHeuristics.ANYRTL_LTR;
    if (paramTextDirectionHeuristicCompat == TextDirectionHeuristicsCompat.LOCALE)
      return TextDirectionHeuristics.LOCALE;
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.fbui.textlayoutbuilder.proxy.StaticLayoutProxy
 * JD-Core Version:    0.6.0
 */