package com.facebook.imagepipeline.producers;

import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalResourceFetchProducer extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalResourceFetchProducer";
  private final Resources mResources;

  public LocalResourceFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, Resources paramResources)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mResources = paramResources;
  }

  // ERROR //
  private int getLength(ImageRequest paramImageRequest)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 17	com/facebook/imagepipeline/producers/LocalResourceFetchProducer:mResources	Landroid/content/res/Resources;
    //   10: aload_1
    //   11: invokestatic 27	com/facebook/imagepipeline/producers/LocalResourceFetchProducer:getResourceId	(Lcom/facebook/imagepipeline/request/ImageRequest;)I
    //   14: invokevirtual 33	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   17: astore_1
    //   18: aload_1
    //   19: astore 6
    //   21: aload_1
    //   22: astore 7
    //   24: aload_1
    //   25: invokevirtual 38	android/content/res/AssetFileDescriptor:getLength	()J
    //   28: lstore 4
    //   30: lload 4
    //   32: l2i
    //   33: istore_3
    //   34: iload_3
    //   35: istore_2
    //   36: aload_1
    //   37: ifnull +9 -> 46
    //   40: aload_1
    //   41: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
    //   44: iload_3
    //   45: istore_2
    //   46: iload_2
    //   47: ireturn
    //   48: astore_1
    //   49: iconst_m1
    //   50: istore_2
    //   51: aload 6
    //   53: ifnull -7 -> 46
    //   56: aload 6
    //   58: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
    //   61: iconst_m1
    //   62: ireturn
    //   63: astore_1
    //   64: iconst_m1
    //   65: ireturn
    //   66: astore_1
    //   67: aload 7
    //   69: ifnull +8 -> 77
    //   72: aload 7
    //   74: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: iload_3
    //   81: ireturn
    //   82: astore 6
    //   84: goto -7 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   6	18	48	android/content/res/Resources$NotFoundException
    //   24	30	48	android/content/res/Resources$NotFoundException
    //   56	61	63	java/io/IOException
    //   6	18	66	finally
    //   24	30	66	finally
    //   40	44	79	java/io/IOException
    //   72	77	82	java/io/IOException
  }

  private static int getResourceId(ImageRequest paramImageRequest)
  {
    return Integer.parseInt(paramImageRequest.getSourceUri().getPath().substring(1));
  }

  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    return getEncodedImage(this.mResources.openRawResource(getResourceId(paramImageRequest)), getLength(paramImageRequest));
  }

  protected String getProducerName()
  {
    return "LocalResourceFetchProducer";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.LocalResourceFetchProducer
 * JD-Core Version:    0.6.0
 */