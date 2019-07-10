package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class DrawableWrapperKitKat extends DrawableWrapperHoneycomb
{
  DrawableWrapperKitKat(Drawable paramDrawable)
  {
    super(paramDrawable);
  }

  DrawableWrapperKitKat(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }

  public boolean isAutoMirrored()
  {
    return this.mDrawable.isAutoMirrored();
  }

  @NonNull
  DrawableWrapperDonut.DrawableWrapperState mutateConstantState()
  {
    return new DrawableWrapperStateKitKat(this.mState, null);
  }

  public void setAutoMirrored(boolean paramBoolean)
  {
    this.mDrawable.setAutoMirrored(paramBoolean);
  }

  private static class DrawableWrapperStateKitKat extends DrawableWrapperDonut.DrawableWrapperState
  {
    DrawableWrapperStateKitKat(@Nullable DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, @Nullable Resources paramResources)
    {
      super(paramResources);
    }

    public Drawable newDrawable(@Nullable Resources paramResources)
    {
      return new DrawableWrapperKitKat(this, paramResources);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableWrapperKitKat
 * JD-Core Version:    0.6.0
 */