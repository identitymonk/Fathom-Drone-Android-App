package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.Locale;
import javax.annotation.Nullable;

public class IterativeBoxBlurPostProcessor extends BasePostprocessor
{
  private static final int DEFAULT_ITERATIONS = 3;
  private final int mBlurRadius;
  private CacheKey mCacheKey;
  private final int mIterations;

  public IterativeBoxBlurPostProcessor(int paramInt)
  {
    this(3, paramInt);
  }

  public IterativeBoxBlurPostProcessor(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt2 <= 0)
        break label44;
    }
    label44: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.mIterations = paramInt1;
      this.mBlurRadius = paramInt2;
      return;
      bool1 = false;
      break;
    }
  }

  @Nullable
  public CacheKey getPostprocessorCacheKey()
  {
    if (this.mCacheKey == null)
      this.mCacheKey = new SimpleCacheKey(String.format((Locale)null, "i%dr%d", new Object[] { Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius) }));
    return this.mCacheKey;
  }

  public void process(Bitmap paramBitmap)
  {
    NativeBlurFilter.iterativeBoxBlur(paramBitmap, this.mIterations, this.mBlurRadius);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor
 * JD-Core Version:    0.6.0
 */