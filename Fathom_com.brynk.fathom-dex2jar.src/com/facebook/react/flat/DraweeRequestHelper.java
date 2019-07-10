package com.facebook.react.flat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

final class DraweeRequestHelper
{
  private static AbstractDraweeControllerBuilder sControllerBuilder;
  private static GenericDraweeHierarchyBuilder sHierarchyBuilder;
  private int mAttachCounter;
  private final DraweeController mDraweeController;

  DraweeRequestHelper(ImageRequest paramImageRequest1, @Nullable ImageRequest paramImageRequest2, ControllerListener paramControllerListener)
  {
    paramImageRequest1 = sControllerBuilder.setImageRequest(paramImageRequest1).setCallerContext(RCTImageView.getCallerContext()).setControllerListener(paramControllerListener);
    if (paramImageRequest2 != null)
      paramImageRequest1.setLowResImageRequest(paramImageRequest2);
    paramImageRequest1 = paramImageRequest1.build();
    paramImageRequest1.setHierarchy(sHierarchyBuilder.build());
    this.mDraweeController = paramImageRequest1;
  }

  static void setDraweeControllerBuilder(AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder)
  {
    sControllerBuilder = paramAbstractDraweeControllerBuilder;
  }

  static void setResources(Resources paramResources)
  {
    sHierarchyBuilder = new GenericDraweeHierarchyBuilder(paramResources);
  }

  void attach(FlatViewGroup.InvalidateCallback paramInvalidateCallback)
  {
    this.mAttachCounter += 1;
    if (this.mAttachCounter == 1)
    {
      getDrawable().setCallback((Drawable.Callback)paramInvalidateCallback.get());
      this.mDraweeController.onAttach();
    }
  }

  void detach()
  {
    this.mAttachCounter -= 1;
    if (this.mAttachCounter == 0)
      this.mDraweeController.onDetach();
  }

  Drawable getDrawable()
  {
    return getHierarchy().getTopLevelDrawable();
  }

  GenericDraweeHierarchy getHierarchy()
  {
    return (GenericDraweeHierarchy)Assertions.assumeNotNull(this.mDraweeController.getHierarchy());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.DraweeRequestHelper
 * JD-Core Version:    0.6.0
 */