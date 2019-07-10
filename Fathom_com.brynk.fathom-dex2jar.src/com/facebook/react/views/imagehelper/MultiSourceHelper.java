package com.facebook.react.views.imagehelper;

import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.facebook.react.views.imagehelper.ImageSource;>;
import javax.annotation.Nullable;

public class MultiSourceHelper
{
  public static MultiSourceResult getBestSourceForSize(int paramInt1, int paramInt2, List<ImageSource> paramList)
  {
    return getBestSourceForSize(paramInt1, paramInt2, paramList, 1.0D);
  }

  public static MultiSourceResult getBestSourceForSize(int paramInt1, int paramInt2, List<ImageSource> paramList, double paramDouble)
  {
    if (paramList.isEmpty())
      return new MultiSourceResult(null, null, null);
    if (paramList.size() == 1)
      return new MultiSourceResult((ImageSource)paramList.get(0), null, null);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      return new MultiSourceResult(null, null, null);
    ImagePipeline localImagePipeline = ImagePipelineFactory.getInstance().getImagePipeline();
    Object localObject1 = null;
    Object localObject2 = null;
    double d5 = paramInt1 * paramInt2;
    double d2 = 1.7976931348623157E+308D;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    paramList = (List<ImageSource>)localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (ImageSource)localIterator.next();
      double d3 = Math.abs(1.0D - ((ImageSource)localObject2).getSize() / (d5 * paramDouble));
      Object localObject3 = localObject1;
      double d4 = d2;
      if (d3 < d2)
      {
        d4 = d3;
        localObject3 = localObject2;
      }
      localObject1 = localObject3;
      d2 = d4;
      if (d3 >= d1)
        continue;
      if (!localImagePipeline.isInBitmapMemoryCache(((ImageSource)localObject2).getUri()))
      {
        localObject1 = localObject3;
        d2 = d4;
        if (!localImagePipeline.isInDiskCacheSync(((ImageSource)localObject2).getUri()))
          continue;
      }
      d1 = d3;
      paramList = (List<ImageSource>)localObject2;
      localObject1 = localObject3;
      d2 = d4;
    }
    localObject2 = paramList;
    if (paramList != null)
    {
      localObject2 = paramList;
      if (localObject1 != null)
      {
        localObject2 = paramList;
        if (paramList.getSource().equals(localObject1.getSource()))
          localObject2 = null;
      }
    }
    return (MultiSourceResult)new MultiSourceResult(localObject1, (ImageSource)localObject2, null);
  }

  public static class MultiSourceResult
  {

    @Nullable
    private final ImageSource bestResult;

    @Nullable
    private final ImageSource bestResultInCache;

    private MultiSourceResult(@Nullable ImageSource paramImageSource1, @Nullable ImageSource paramImageSource2)
    {
      this.bestResult = paramImageSource1;
      this.bestResultInCache = paramImageSource2;
    }

    @Nullable
    public ImageSource getBestResult()
    {
      return this.bestResult;
    }

    @Nullable
    public ImageSource getBestResultInCache()
    {
      return this.bestResultInCache;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.imagehelper.MultiSourceHelper
 * JD-Core Version:    0.6.0
 */