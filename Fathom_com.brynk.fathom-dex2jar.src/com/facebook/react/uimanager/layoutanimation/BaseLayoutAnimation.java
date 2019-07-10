package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;

abstract class BaseLayoutAnimation extends AbstractLayoutAnimation
{
  Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mAnimatedProperty != null)
    {
      float f1;
      float f2;
      switch (1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[this.mAnimatedProperty.ordinal()])
      {
      default:
        throw new IllegalViewOperationException("Missing animation for property : " + this.mAnimatedProperty);
      case 1:
        if (isReverse())
        {
          f1 = paramView.getAlpha();
          if (!isReverse())
            break label112;
          f2 = 0.0F;
        }
        while (true)
        {
          return new OpacityAnimation(paramView, f1, f2);
          f1 = 0.0F;
          break;
          label112: f2 = paramView.getAlpha();
        }
      case 2:
      }
      if (isReverse())
      {
        f1 = 1.0F;
        if (!isReverse())
          break label169;
        f2 = 0.0F;
      }
      while (true)
      {
        return new ScaleAnimation(f1, f2, f1, f2, 1, 0.5F, 1, 0.5F);
        f1 = 0.0F;
        break;
        label169: f2 = 1.0F;
      }
    }
    throw new IllegalViewOperationException("Missing animated property from animation config");
  }

  abstract boolean isReverse();

  boolean isValid()
  {
    return (this.mDurationMs > 0) && (this.mAnimatedProperty != null);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.BaseLayoutAnimation
 * JD-Core Version:    0.6.0
 */