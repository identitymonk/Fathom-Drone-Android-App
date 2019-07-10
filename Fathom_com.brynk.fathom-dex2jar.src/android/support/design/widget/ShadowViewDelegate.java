package android.support.design.widget;

import android.graphics.drawable.Drawable;

abstract interface ShadowViewDelegate
{
  public abstract float getRadius();

  public abstract boolean isCompatPaddingEnabled();

  public abstract void setBackgroundDrawable(Drawable paramDrawable);

  public abstract void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.ShadowViewDelegate
 * JD-Core Version:    0.6.0
 */