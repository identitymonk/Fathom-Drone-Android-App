package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import okhttp3.OkHttpClient;

public class OkHttpImagePipelineConfigFactory
{
  public static ImagePipelineConfig.Builder newBuilder(Context paramContext, OkHttpClient paramOkHttpClient)
  {
    return ImagePipelineConfig.newBuilder(paramContext).setNetworkFetcher(new OkHttpNetworkFetcher(paramOkHttpClient));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
 * JD-Core Version:    0.6.0
 */