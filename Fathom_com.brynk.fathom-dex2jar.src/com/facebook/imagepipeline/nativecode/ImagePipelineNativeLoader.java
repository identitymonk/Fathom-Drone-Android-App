package com.facebook.imagepipeline.nativecode;

import com.facebook.common.soloader.SoLoaderShim;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImagePipelineNativeLoader
{
  public static final List<String> DEPENDENCIES = Collections.unmodifiableList(new ArrayList());
  public static final String DSO_NAME = "imagepipeline";

  public static void load()
  {
    SoLoaderShim.loadLibrary("imagepipeline");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader
 * JD-Core Version:    0.6.0
 */