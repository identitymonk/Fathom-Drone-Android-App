package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import javax.annotation.Nullable;

public class Fresco
{
  private static final Class<?> TAG = Fresco.class;
  private static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier;
  private static volatile boolean sIsInitialized = false;

  public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier()
  {
    return sDraweeControllerBuilderSupplier;
  }

  public static ImagePipeline getImagePipeline()
  {
    return getImagePipelineFactory().getImagePipeline();
  }

  public static ImagePipelineFactory getImagePipelineFactory()
  {
    return ImagePipelineFactory.getInstance();
  }

  public static boolean hasBeenInitialized()
  {
    return sIsInitialized;
  }

  public static void initialize(Context paramContext)
  {
    initialize(paramContext, null, null);
  }

  public static void initialize(Context paramContext, @Nullable ImagePipelineConfig paramImagePipelineConfig)
  {
    initialize(paramContext, paramImagePipelineConfig, null);
  }

  public static void initialize(Context paramContext, @Nullable ImagePipelineConfig paramImagePipelineConfig, @Nullable DraweeConfig paramDraweeConfig)
  {
    if (sIsInitialized)
    {
      FLog.w(TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
      paramContext = paramContext.getApplicationContext();
      if (paramImagePipelineConfig != null)
        break label40;
      ImagePipelineFactory.initialize(paramContext);
    }
    while (true)
    {
      initializeDrawee(paramContext, paramDraweeConfig);
      return;
      sIsInitialized = true;
      break;
      label40: ImagePipelineFactory.initialize(paramImagePipelineConfig);
    }
  }

  private static void initializeDrawee(Context paramContext, @Nullable DraweeConfig paramDraweeConfig)
  {
    sDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(paramContext, paramDraweeConfig);
    SimpleDraweeView.initialize(sDraweeControllerBuilderSupplier);
  }

  public static PipelineDraweeControllerBuilder newDraweeControllerBuilder()
  {
    return sDraweeControllerBuilderSupplier.get();
  }

  public static void shutDown()
  {
    sDraweeControllerBuilderSupplier = null;
    SimpleDraweeView.shutDown();
    ImagePipelineFactory.shutDown();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.Fresco
 * JD-Core Version:    0.6.0
 */