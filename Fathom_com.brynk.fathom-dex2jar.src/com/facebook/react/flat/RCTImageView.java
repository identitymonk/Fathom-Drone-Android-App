package com.facebook.react.flat;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ImageResizeMode;
import javax.annotation.Nullable;

class RCTImageView<T extends AbstractDrawCommand,  extends DrawImage> extends FlatShadowNode
{
  static Object sCallerContext = RCTImageView.class;
  private T mDrawImage;

  RCTImageView(T paramT)
  {
    this.mDrawImage = paramT;
  }

  static Object getCallerContext()
  {
    return sCallerContext;
  }

  private T getMutableDrawImage()
  {
    if (this.mDrawImage.isFrozen())
    {
      this.mDrawImage = this.mDrawImage.mutableCopy();
      invalidate();
    }
    return this.mDrawImage;
  }

  static void setCallerContext(Object paramObject)
  {
    sCallerContext = paramObject;
  }

  protected void collectState(StateBuilder paramStateBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    super.collectState(paramStateBuilder, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    if (((DrawImage)this.mDrawImage).hasImageRequest())
    {
      this.mDrawImage = this.mDrawImage.updateBoundsAndFreeze(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
      paramStateBuilder.addDrawCommand(this.mDrawImage);
      paramStateBuilder.addAttachDetachListener((AttachDetachListener)this.mDrawImage);
    }
  }

  boolean doesDraw()
  {
    return (((DrawImage)this.mDrawImage).hasImageRequest()) || (super.doesDraw());
  }

  public void setBorder(int paramInt, float paramFloat)
  {
    super.setBorder(paramInt, paramFloat);
    if ((paramInt == 8) && (((DrawImage)this.mDrawImage).getBorderWidth() != paramFloat))
      ((DrawImage)getMutableDrawImage()).setBorderWidth(paramFloat);
  }

  @ReactProp(customType="Color", name="borderColor")
  public void setBorderColor(int paramInt)
  {
    if (((DrawImage)this.mDrawImage).getBorderColor() != paramInt)
      ((DrawImage)getMutableDrawImage()).setBorderColor(paramInt);
  }

  @ReactProp(name="borderRadius")
  public void setBorderRadius(float paramFloat)
  {
    if (((DrawImage)this.mDrawImage).getBorderRadius() != paramFloat)
      ((DrawImage)getMutableDrawImage()).setBorderRadius(PixelUtil.toPixelFromDIP(paramFloat));
  }

  @ReactProp(name="fadeDuration")
  public void setFadeDuration(int paramInt)
  {
    ((DrawImage)getMutableDrawImage()).setFadeDuration(paramInt);
  }

  @ReactProp(name="progressiveRenderingEnabled")
  public void setProgressiveRenderingEnabled(boolean paramBoolean)
  {
    ((DrawImage)getMutableDrawImage()).setProgressiveRenderingEnabled(paramBoolean);
  }

  @ReactProp(name="resizeMode")
  public void setResizeMode(@Nullable String paramString)
  {
    paramString = ImageResizeMode.toScaleType(paramString);
    if (((DrawImage)this.mDrawImage).getScaleType() != paramString)
      ((DrawImage)getMutableDrawImage()).setScaleType(paramString);
  }

  @ReactProp(name="shouldNotifyLoadEvents")
  public void setShouldNotifyLoadEvents(boolean paramBoolean)
  {
    DrawImage localDrawImage = (DrawImage)getMutableDrawImage();
    if (paramBoolean);
    for (int i = getReactTag(); ; i = 0)
    {
      localDrawImage.setReactTag(i);
      return;
    }
  }

  @ReactProp(name="src")
  public void setSource(@Nullable ReadableArray paramReadableArray)
  {
    ((DrawImage)getMutableDrawImage()).setSource(getThemedContext(), paramReadableArray);
  }

  @ReactProp(name="tintColor")
  public void setTintColor(int paramInt)
  {
    ((DrawImage)getMutableDrawImage()).setTintColor(paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTImageView
 * JD-Core Version:    0.6.0
 */