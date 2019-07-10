package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

class DrawableWrapperEclair extends DrawableWrapperDonut
{
  DrawableWrapperEclair(Drawable paramDrawable)
  {
    super(paramDrawable);
  }

  DrawableWrapperEclair(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }

  DrawableWrapperDonut.DrawableWrapperState mutateConstantState()
  {
    return new DrawableWrapperStateEclair(this.mState, null);
  }

  protected Drawable newDrawableFromState(Drawable.ConstantState paramConstantState, Resources paramResources)
  {
    return paramConstantState.newDrawable(paramResources);
  }

  private static class DrawableWrapperStateEclair extends DrawableWrapperDonut.DrawableWrapperState
  {
    DrawableWrapperStateEclair(@Nullable DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, @Nullable Resources paramResources)
    {
      super(paramResources);
    }

    public Drawable newDrawable(@Nullable Resources paramResources)
    {
      return new DrawableWrapperEclair(this, paramResources);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableWrapperEclair
 * JD-Core Version:    0.6.0
 */