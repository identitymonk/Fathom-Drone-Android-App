package com.facebook.react.shell;

import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class MainPackageConfig
{
  private ImagePipelineConfig mFrescoConfig;

  private MainPackageConfig(Builder paramBuilder)
  {
    this.mFrescoConfig = paramBuilder.mFrescoConfig;
  }

  public ImagePipelineConfig getFrescoConfig()
  {
    return this.mFrescoConfig;
  }

  public static class Builder
  {
    private ImagePipelineConfig mFrescoConfig;

    public MainPackageConfig build()
    {
      return new MainPackageConfig(this, null);
    }

    public Builder setFrescoConfig(ImagePipelineConfig paramImagePipelineConfig)
    {
      this.mFrescoConfig = paramImagePipelineConfig;
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.shell.MainPackageConfig
 * JD-Core Version:    0.6.0
 */