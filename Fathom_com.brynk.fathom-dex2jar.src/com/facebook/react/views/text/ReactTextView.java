package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import javax.annotation.Nullable;

public class ReactTextView extends TextView
  implements ReactCompoundView
{
  private static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
  private boolean mContainsImages;
  private int mDefaultGravityHorizontal = getGravity() & 0x800007;
  private int mDefaultGravityVertical = getGravity() & 0x70;
  private TextUtils.TruncateAt mEllipsizeLocation = TextUtils.TruncateAt.END;
  private float mLineHeight = (0.0F / 0.0F);
  private int mNumberOfLines = 2147483647;
  private ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
  private int mTextAlign = 0;
  private boolean mTextIsSelectable;

  public ReactTextView(Context paramContext)
  {
    super(paramContext);
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    int i = 0;
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        if (localObject[i].getDrawable() == paramDrawable)
          invalidate();
        i += 1;
      }
    }
    super.invalidateDrawable(paramDrawable);
  }

  public void onAttachedToWindow()
  {
    int i = 0;
    super.onAttachedToWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].onAttachedToWindow();
        i += 1;
      }
    }
  }

  public void onDetachedFromWindow()
  {
    int i = 0;
    super.onDetachedFromWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].onDetachedFromWindow();
        i += 1;
      }
    }
  }

  public void onFinishTemporaryDetach()
  {
    int i = 0;
    super.onFinishTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].onFinishTemporaryDetach();
        i += 1;
      }
    }
  }

  public void onStartTemporaryDetach()
  {
    int i = 0;
    super.onStartTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].onStartTemporaryDetach();
        i += 1;
      }
    }
  }

  public int reactTagForTouch(float paramFloat1, float paramFloat2)
  {
    Spanned localSpanned = (Spanned)getText();
    int i = getId();
    int j = (int)paramFloat1;
    int m = (int)paramFloat2;
    Object localObject = getLayout();
    if (localObject == null)
      return i;
    m = ((Layout)localObject).getLineForVertical(m);
    int i1 = (int)((Layout)localObject).getLineLeft(m);
    int i3 = (int)((Layout)localObject).getLineRight(m);
    int n = i;
    if (j >= i1)
    {
      n = i;
      if (j <= i3)
      {
        int i4 = ((Layout)localObject).getOffsetForHorizontal(m, j);
        localObject = (ReactTagSpan[])localSpanned.getSpans(i4, i4, ReactTagSpan.class);
        n = i;
        if (localObject != null)
        {
          m = localSpanned.length();
          int k = 0;
          while (true)
          {
            n = i;
            if (k >= localObject.length)
              break;
            int i5 = localSpanned.getSpanStart(localObject[k]);
            int i6 = localSpanned.getSpanEnd(localObject[k]);
            i1 = i;
            n = m;
            int i2;
            if (i6 > i4)
            {
              i1 = i;
              n = m;
              if (i6 - i5 <= m)
              {
                i2 = localObject[k].getReactTag();
                n = i6 - i5;
              }
            }
            k += 1;
            i = i2;
            m = n;
          }
        }
      }
    }
    return n;
  }

  public void setBackgroundColor(int paramInt)
  {
    this.mReactBackgroundManager.setBackgroundColor(paramInt);
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mReactBackgroundManager.setBorderColor(paramInt, paramFloat1, paramFloat2);
  }

  public void setBorderRadius(float paramFloat)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat);
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat, paramInt);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    this.mReactBackgroundManager.setBorderStyle(paramString);
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    this.mReactBackgroundManager.setBorderWidth(paramInt, paramFloat);
  }

  public void setEllipsizeLocation(TextUtils.TruncateAt paramTruncateAt)
  {
    this.mEllipsizeLocation = paramTruncateAt;
  }

  void setGravityHorizontal(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
      i = this.mDefaultGravityHorizontal;
    setGravity(getGravity() & 0xFFFFFFF8 & 0xFF7FFFF8 | i);
  }

  void setGravityVertical(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
      i = this.mDefaultGravityVertical;
    setGravity(getGravity() & 0xFFFFFF8F | i);
  }

  public void setNumberOfLines(int paramInt)
  {
    boolean bool = true;
    int i = paramInt;
    if (paramInt == 0)
      i = 2147483647;
    this.mNumberOfLines = i;
    if (this.mNumberOfLines == 1);
    while (true)
    {
      setSingleLine(bool);
      setMaxLines(this.mNumberOfLines);
      return;
      bool = false;
    }
  }

  public void setText(ReactTextUpdate paramReactTextUpdate)
  {
    this.mContainsImages = paramReactTextUpdate.containsImages();
    if (getLayoutParams() == null)
      setLayoutParams(EMPTY_LAYOUT_PARAMS);
    setText(paramReactTextUpdate.getText());
    setPadding((int)Math.floor(paramReactTextUpdate.getPaddingLeft()), (int)Math.floor(paramReactTextUpdate.getPaddingTop()), (int)Math.floor(paramReactTextUpdate.getPaddingRight()), (int)Math.floor(paramReactTextUpdate.getPaddingBottom()));
    int i = paramReactTextUpdate.getTextAlign();
    if (this.mTextAlign != i)
      this.mTextAlign = i;
    setGravityHorizontal(this.mTextAlign);
    if ((Build.VERSION.SDK_INT >= 23) && (getBreakStrategy() != paramReactTextUpdate.getTextBreakStrategy()))
      setBreakStrategy(paramReactTextUpdate.getTextBreakStrategy());
  }

  public void setTextIsSelectable(boolean paramBoolean)
  {
    this.mTextIsSelectable = paramBoolean;
    super.setTextIsSelectable(paramBoolean);
  }

  public void updateView()
  {
    if (this.mNumberOfLines == 2147483647);
    for (TextUtils.TruncateAt localTruncateAt = null; ; localTruncateAt = this.mEllipsizeLocation)
    {
      setEllipsize(localTruncateAt);
      return;
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    int i = 0;
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        if (localObject[i].getDrawable() == paramDrawable)
          return true;
        i += 1;
      }
    }
    return super.verifyDrawable(paramDrawable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactTextView
 * JD-Core Version:    0.6.0
 */