package android.support.design.widget;

import android.graphics.Outline;

class CircularBorderDrawableLollipop extends CircularBorderDrawable
{
  public void getOutline(Outline paramOutline)
  {
    copyBounds(this.mRect);
    paramOutline.setOval(this.mRect);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.CircularBorderDrawableLollipop
 * JD-Core Version:    0.6.0
 */