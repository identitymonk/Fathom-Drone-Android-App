package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.ColorInt;

public abstract interface TintAwareDrawable
{
  public abstract void setTint(@ColorInt int paramInt);

  public abstract void setTintList(ColorStateList paramColorStateList);

  public abstract void setTintMode(PorterDuff.Mode paramMode);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.TintAwareDrawable
 * JD-Core Version:    0.6.0
 */