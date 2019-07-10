package com.facebook.drawee.drawable;

public abstract interface Rounded
{
  public abstract int getBorderColor();

  public abstract float getBorderWidth();

  public abstract float getPadding();

  public abstract float[] getRadii();

  public abstract boolean isCircle();

  public abstract void setBorder(int paramInt, float paramFloat);

  public abstract void setCircle(boolean paramBoolean);

  public abstract void setPadding(float paramFloat);

  public abstract void setRadii(float[] paramArrayOfFloat);

  public abstract void setRadius(float paramFloat);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.Rounded
 * JD-Core Version:    0.6.0
 */