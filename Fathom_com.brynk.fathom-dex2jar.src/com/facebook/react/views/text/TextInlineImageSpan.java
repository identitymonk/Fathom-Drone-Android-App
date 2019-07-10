package com.facebook.react.views.text;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import javax.annotation.Nullable;

public abstract class TextInlineImageSpan extends ReplacementSpan
{
  public static void possiblyUpdateInlineImageSpans(Spannable paramSpannable, TextView paramTextView)
  {
    int i = 0;
    paramSpannable = (TextInlineImageSpan[])paramSpannable.getSpans(0, paramSpannable.length(), TextInlineImageSpan.class);
    int j = paramSpannable.length;
    while (i < j)
    {
      Object localObject = paramSpannable[i];
      localObject.onAttachedToWindow();
      localObject.setTextView(paramTextView);
      i += 1;
    }
  }

  @Nullable
  public abstract Drawable getDrawable();

  public abstract int getHeight();

  public abstract int getWidth();

  public abstract void onAttachedToWindow();

  public abstract void onDetachedFromWindow();

  public abstract void onFinishTemporaryDetach();

  public abstract void onStartTemporaryDetach();

  public abstract void setTextView(TextView paramTextView);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.TextInlineImageSpan
 * JD-Core Version:    0.6.0
 */