package com.facebook.imagepipeline.cache;

import android.net.Uri;
import javax.annotation.Nullable;

public abstract interface MediaIdExtractor
{
  @Nullable
  public abstract String getMediaIdFrom(Uri paramUri);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.MediaIdExtractor
 * JD-Core Version:    0.6.0
 */