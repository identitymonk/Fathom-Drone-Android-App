package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import javax.annotation.Nullable;

public abstract interface DraweeController
{
  public abstract Animatable getAnimatable();

  public abstract String getContentDescription();

  @Nullable
  public abstract DraweeHierarchy getHierarchy();

  public abstract void onAttach();

  public abstract void onDetach();

  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);

  public abstract void onViewportVisibilityHint(boolean paramBoolean);

  public abstract void setContentDescription(String paramString);

  public abstract void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.interfaces.DraweeController
 * JD-Core Version:    0.6.0
 */