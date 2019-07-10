package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import java.lang.reflect.Constructor;

public class AnimatedFactoryProvider
{
  private static AnimatedFactory sImpl = null;
  private static boolean sImplLoaded;

  public static AnimatedFactory getAnimatedFactory(PlatformBitmapFactory paramPlatformBitmapFactory, ExecutorSupplier paramExecutorSupplier)
  {
    if (!sImplLoaded);
    try
    {
      sImpl = (AnimatedFactory)Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(new Class[] { PlatformBitmapFactory.class, ExecutorSupplier.class }).newInstance(new Object[] { paramPlatformBitmapFactory, paramExecutorSupplier });
      label49: if (sImpl != null)
      {
        sImplLoaded = true;
        return sImpl;
      }
      try
      {
        sImpl = (AnimatedFactory)Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(new Class[] { PlatformBitmapFactory.class, ExecutorSupplier.class }).newInstance(new Object[] { paramPlatformBitmapFactory, paramExecutorSupplier });
        label106: sImplLoaded = true;
        return sImpl;
      }
      catch (Throwable paramPlatformBitmapFactory)
      {
        break label106;
      }
    }
    catch (Throwable localThrowable)
    {
      break label49;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider
 * JD-Core Version:    0.6.0
 */