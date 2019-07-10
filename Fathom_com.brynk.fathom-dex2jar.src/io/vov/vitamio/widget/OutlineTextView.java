package io.vov.vitamio.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;

public class OutlineTextView extends TextView
{
  private int mAscent = 0;
  private int mBorderColor;
  private float mBorderSize;
  private int mColor;
  private boolean mIncludePad = true;
  private float mSpacingAdd = 0.0F;
  private float mSpacingMult = 1.0F;
  private String mText = "";
  private TextPaint mTextPaint;
  private TextPaint mTextPaintOutline;

  public OutlineTextView(Context paramContext)
  {
    super(paramContext);
    initPaint();
  }

  public OutlineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initPaint();
  }

  public OutlineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initPaint();
  }

  private void initPaint()
  {
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setTextSize(getTextSize());
    this.mTextPaint.setColor(this.mColor);
    this.mTextPaint.setStyle(Paint.Style.FILL);
    this.mTextPaint.setTypeface(getTypeface());
    this.mTextPaintOutline = new TextPaint();
    this.mTextPaintOutline.setAntiAlias(true);
    this.mTextPaintOutline.setTextSize(getTextSize());
    this.mTextPaintOutline.setColor(this.mBorderColor);
    this.mTextPaintOutline.setStyle(Paint.Style.STROKE);
    this.mTextPaintOutline.setTypeface(getTypeface());
    this.mTextPaintOutline.setStrokeWidth(this.mBorderSize);
  }

  private int measureHeight(int paramInt)
  {
    int k = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    this.mAscent = (int)this.mTextPaintOutline.ascent();
    if (k == 1073741824)
      paramInt = i;
    int j;
    do
    {
      return paramInt;
      j = (int)(-this.mAscent + this.mTextPaintOutline.descent()) + getPaddingTop() + getPaddingBottom();
      paramInt = j;
    }
    while (k != -2147483648);
    return Math.min(j, i);
  }

  private int measureWidth(int paramInt)
  {
    int k = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    if (k == 1073741824)
      paramInt = i;
    int j;
    do
    {
      return paramInt;
      j = (int)this.mTextPaintOutline.measureText(this.mText) + getPaddingLeft() + getPaddingRight();
      paramInt = j;
    }
    while (k != -2147483648);
    return Math.min(j, i);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    new StaticLayout(getText(), this.mTextPaintOutline, getWidth(), Layout.Alignment.ALIGN_CENTER, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad).draw(paramCanvas);
    new StaticLayout(getText(), this.mTextPaint, getWidth(), Layout.Alignment.ALIGN_CENTER, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad).draw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    StaticLayout localStaticLayout = new StaticLayout(getText(), this.mTextPaintOutline, measureWidth(paramInt1), Layout.Alignment.ALIGN_CENTER, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad);
    int i = (int)(this.mBorderSize * 2.0F + 1.0F);
    setMeasuredDimension(measureWidth(paramInt1) + i, measureHeight(paramInt2) * localStaticLayout.getLineCount() + i);
  }

  public void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    super.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
    this.mBorderSize = paramFloat1;
    this.mBorderColor = paramInt;
    requestLayout();
    invalidate();
    initPaint();
  }

  public void setText(String paramString)
  {
    super.setText(paramString);
    this.mText = paramString.toString();
    requestLayout();
    invalidate();
  }

  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    this.mColor = paramInt;
    invalidate();
    initPaint();
  }

  public void setTextSize(float paramFloat)
  {
    super.setTextSize(paramFloat);
    requestLayout();
    invalidate();
    initPaint();
  }

  public void setTypeface(Typeface paramTypeface)
  {
    super.setTypeface(paramTypeface);
    requestLayout();
    invalidate();
    initPaint();
  }

  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    super.setTypeface(paramTypeface, paramInt);
    requestLayout();
    invalidate();
    initPaint();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.widget.OutlineTextView
 * JD-Core Version:    0.6.0
 */