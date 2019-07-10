package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

public class ImageSource
{
  private boolean isResource;
  private double mSize;
  private String mSource;

  @Nullable
  private Uri mUri;

  public ImageSource(Context paramContext, String paramString)
  {
    this(paramContext, paramString, 0.0D, 0.0D);
  }

  public ImageSource(Context paramContext, String paramString, double paramDouble1, double paramDouble2)
  {
    this.mSource = paramString;
    this.mSize = (paramDouble1 * paramDouble2);
    this.mUri = computeUri(paramContext);
  }

  private Uri computeLocalUri(Context paramContext)
  {
    this.isResource = true;
    return ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(paramContext, this.mSource);
  }

  private Uri computeUri(Context paramContext)
  {
    try
    {
      Uri localUri2 = Uri.parse(this.mSource);
      Uri localUri1 = localUri2;
      if (localUri2.getScheme() == null)
        localUri1 = computeLocalUri(paramContext);
      return localUri1;
    }
    catch (Exception localException)
    {
    }
    return computeLocalUri(paramContext);
  }

  public double getSize()
  {
    return this.mSize;
  }

  public String getSource()
  {
    return this.mSource;
  }

  public Uri getUri()
  {
    return (Uri)Assertions.assertNotNull(this.mUri);
  }

  public boolean isResource()
  {
    return this.isResource;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.imagehelper.ImageSource
 * JD-Core Version:    0.6.0
 */