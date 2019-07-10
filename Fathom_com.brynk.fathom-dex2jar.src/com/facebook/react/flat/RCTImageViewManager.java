package com.facebook.react.flat;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.views.image.GlobalImageLoadListener;
import javax.annotation.Nullable;

public final class RCTImageViewManager extends FlatViewManager
{
  static final String REACT_CLASS = "RCTImageView";

  @Nullable
  private final Object mCallerContext;

  @Nullable
  private AbstractDraweeControllerBuilder mDraweeControllerBuilder;

  @Nullable
  private GlobalImageLoadListener mGlobalImageLoadListener;

  public RCTImageViewManager()
  {
    this(null, null);
  }

  public RCTImageViewManager(AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable GlobalImageLoadListener paramGlobalImageLoadListener, Object paramObject)
  {
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mGlobalImageLoadListener = paramGlobalImageLoadListener;
    this.mCallerContext = paramObject;
  }

  public RCTImageViewManager(AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, Object paramObject)
  {
    this(paramAbstractDraweeControllerBuilder, null, paramObject);
  }

  public RCTImageView createShadowNodeInstance()
  {
    return new RCTImageView(new DrawImageWithDrawee(this.mGlobalImageLoadListener));
  }

  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  public AbstractDraweeControllerBuilder getDraweeControllerBuilder()
  {
    if (this.mDraweeControllerBuilder == null)
      this.mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
    return this.mDraweeControllerBuilder;
  }

  public String getName()
  {
    return "RCTImageView";
  }

  public Class<RCTImageView> getShadowNodeClass()
  {
    return RCTImageView.class;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTImageViewManager
 * JD-Core Version:    0.6.0
 */