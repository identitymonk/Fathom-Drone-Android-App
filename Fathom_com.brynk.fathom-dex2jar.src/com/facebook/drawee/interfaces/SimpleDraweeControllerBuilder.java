package com.facebook.drawee.interfaces;

import android.net.Uri;
import javax.annotation.Nullable;

public abstract interface SimpleDraweeControllerBuilder
{
  public abstract DraweeController build();

  public abstract SimpleDraweeControllerBuilder setCallerContext(Object paramObject);

  public abstract SimpleDraweeControllerBuilder setOldController(@Nullable DraweeController paramDraweeController);

  public abstract SimpleDraweeControllerBuilder setUri(Uri paramUri);

  public abstract SimpleDraweeControllerBuilder setUri(@Nullable String paramString);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
 * JD-Core Version:    0.6.0
 */