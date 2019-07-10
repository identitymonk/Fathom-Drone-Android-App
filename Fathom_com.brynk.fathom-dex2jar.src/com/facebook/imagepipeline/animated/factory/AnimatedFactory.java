package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract interface AnimatedFactory
{
  public abstract AnimatedDrawableFactory getAnimatedDrawableFactory(Context paramContext);

  public abstract AnimatedImageFactory getAnimatedImageFactory();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.animated.factory.AnimatedFactory
 * JD-Core Version:    0.6.0
 */