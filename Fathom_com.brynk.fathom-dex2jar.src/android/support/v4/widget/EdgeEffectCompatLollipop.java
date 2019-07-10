package android.support.v4.widget;

import android.widget.EdgeEffect;

class EdgeEffectCompatLollipop
{
  public static boolean onPull(Object paramObject, float paramFloat1, float paramFloat2)
  {
    ((EdgeEffect)paramObject).onPull(paramFloat1, paramFloat2);
    return true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.EdgeEffectCompatLollipop
 * JD-Core Version:    0.6.0
 */