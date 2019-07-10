package com.facebook.react.flat;

import android.text.Layout;
import android.text.Spanned;
import javax.annotation.Nullable;

final class TextNodeRegion extends NodeRegion
{

  @Nullable
  private Layout mLayout;

  TextNodeRegion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, boolean paramBoolean, @Nullable Layout paramLayout)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramBoolean);
    this.mLayout = paramLayout;
  }

  @Nullable
  Layout getLayout()
  {
    return this.mLayout;
  }

  int getReactTag(float paramFloat1, float paramFloat2)
  {
    if (this.mLayout != null)
    {
      Object localObject = this.mLayout.getText();
      if ((localObject instanceof Spanned))
      {
        int i = Math.round(paramFloat2 - getTop());
        if ((i >= this.mLayout.getLineTop(0)) && (i < this.mLayout.getLineBottom(this.mLayout.getLineCount() - 1)))
        {
          float f = Math.round(paramFloat1 - getLeft());
          i = this.mLayout.getLineForVertical(i);
          if ((this.mLayout.getLineLeft(i) <= f) && (f <= this.mLayout.getLineRight(i)))
          {
            i = this.mLayout.getOffsetForHorizontal(i, f);
            localObject = (RCTRawText[])((Spanned)localObject).getSpans(i, i, RCTRawText.class);
            if (localObject.length != 0)
              return localObject[0].getReactTag();
          }
        }
      }
    }
    return super.getReactTag(paramFloat1, paramFloat2);
  }

  boolean matchesTag(int paramInt)
  {
    if (super.matchesTag(paramInt))
      return true;
    if (this.mLayout != null)
    {
      Object localObject = (Spanned)this.mLayout.getText();
      localObject = (RCTRawText[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), RCTRawText.class);
      int j = localObject.length;
      int i = 0;
      while (true)
      {
        if (i >= j)
          break label80;
        if (localObject[i].getReactTag() == paramInt)
          break;
        i += 1;
      }
    }
    label80: return false;
  }

  public void setLayout(Layout paramLayout)
  {
    this.mLayout = paramLayout;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.TextNodeRegion
 * JD-Core Version:    0.6.0
 */