package com.facebook.react.views.image;

import android.graphics.PorterDuff.Mode;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaConstants;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="RCTImageView")
public class ReactImageManager extends SimpleViewManager<ReactImageView>
{
  protected static final String REACT_CLASS = "RCTImageView";

  @Nullable
  private final Object mCallerContext;

  @Nullable
  private AbstractDraweeControllerBuilder mDraweeControllerBuilder;

  @Nullable
  private GlobalImageLoadListener mGlobalImageLoadListener;

  public ReactImageManager()
  {
    this.mDraweeControllerBuilder = null;
    this.mCallerContext = null;
  }

  public ReactImageManager(AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable GlobalImageLoadListener paramGlobalImageLoadListener, Object paramObject)
  {
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mGlobalImageLoadListener = paramGlobalImageLoadListener;
    this.mCallerContext = paramObject;
  }

  public ReactImageManager(AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, Object paramObject)
  {
    this(paramAbstractDraweeControllerBuilder, null, paramObject);
  }

  public ReactImageView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactImageView(paramThemedReactContext, getDraweeControllerBuilder(), this.mGlobalImageLoadListener, getCallerContext());
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

  @Nullable
  public Map getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.of(ImageLoadEvent.eventNameForType(4), MapBuilder.of("registrationName", "onLoadStart"), ImageLoadEvent.eventNameForType(2), MapBuilder.of("registrationName", "onLoad"), ImageLoadEvent.eventNameForType(1), MapBuilder.of("registrationName", "onError"), ImageLoadEvent.eventNameForType(3), MapBuilder.of("registrationName", "onLoadEnd"));
  }

  public String getName()
  {
    return "RCTImageView";
  }

  protected void onAfterUpdateTransaction(ReactImageView paramReactImageView)
  {
    super.onAfterUpdateTransaction(paramReactImageView);
    paramReactImageView.maybeUpdateView();
  }

  @ReactProp(name="blurRadius")
  public void setBlurRadius(ReactImageView paramReactImageView, float paramFloat)
  {
    paramReactImageView.setBlurRadius(paramFloat);
  }

  @ReactProp(customType="Color", name="borderColor")
  public void setBorderColor(ReactImageView paramReactImageView, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactImageView.setBorderColor(0);
      return;
    }
    paramReactImageView.setBorderColor(paramInteger.intValue());
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
  public void setBorderRadius(ReactImageView paramReactImageView, int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (!YogaConstants.isUndefined(paramFloat))
      f = PixelUtil.toPixelFromDIP(paramFloat);
    if (paramInt == 0)
    {
      paramReactImageView.setBorderRadius(f);
      return;
    }
    paramReactImageView.setBorderRadius(f, paramInt - 1);
  }

  @ReactProp(name="borderWidth")
  public void setBorderWidth(ReactImageView paramReactImageView, float paramFloat)
  {
    paramReactImageView.setBorderWidth(paramFloat);
  }

  @ReactProp(name="fadeDuration")
  public void setFadeDuration(ReactImageView paramReactImageView, int paramInt)
  {
    paramReactImageView.setFadeDuration(paramInt);
  }

  @ReactProp(name="headers")
  public void setHeaders(ReactImageView paramReactImageView, ReadableMap paramReadableMap)
  {
    paramReactImageView.setHeaders(paramReadableMap);
  }

  @ReactProp(name="shouldNotifyLoadEvents")
  public void setLoadHandlersRegistered(ReactImageView paramReactImageView, boolean paramBoolean)
  {
    paramReactImageView.setShouldNotifyLoadEvents(paramBoolean);
  }

  @ReactProp(name="loadingIndicatorSrc")
  public void setLoadingIndicatorSource(ReactImageView paramReactImageView, @Nullable String paramString)
  {
    paramReactImageView.setLoadingIndicatorSource(paramString);
  }

  @ReactProp(name="overlayColor")
  public void setOverlayColor(ReactImageView paramReactImageView, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactImageView.setOverlayColor(0);
      return;
    }
    paramReactImageView.setOverlayColor(paramInteger.intValue());
  }

  @ReactProp(name="progressiveRenderingEnabled")
  public void setProgressiveRenderingEnabled(ReactImageView paramReactImageView, boolean paramBoolean)
  {
    paramReactImageView.setProgressiveRenderingEnabled(paramBoolean);
  }

  @ReactProp(name="resizeMethod")
  public void setResizeMethod(ReactImageView paramReactImageView, @Nullable String paramString)
  {
    if ((paramString == null) || ("auto".equals(paramString)))
    {
      paramReactImageView.setResizeMethod(ImageResizeMethod.AUTO);
      return;
    }
    if ("resize".equals(paramString))
    {
      paramReactImageView.setResizeMethod(ImageResizeMethod.RESIZE);
      return;
    }
    if ("scale".equals(paramString))
    {
      paramReactImageView.setResizeMethod(ImageResizeMethod.SCALE);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid resize method: '" + paramString + "'");
  }

  @ReactProp(name="resizeMode")
  public void setResizeMode(ReactImageView paramReactImageView, @Nullable String paramString)
  {
    paramReactImageView.setScaleType(ImageResizeMode.toScaleType(paramString));
  }

  @ReactProp(name="src")
  public void setSource(ReactImageView paramReactImageView, @Nullable ReadableArray paramReadableArray)
  {
    paramReactImageView.setSource(paramReadableArray);
  }

  @ReactProp(customType="Color", name="tintColor")
  public void setTintColor(ReactImageView paramReactImageView, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactImageView.clearColorFilter();
      return;
    }
    paramReactImageView.setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.image.ReactImageManager
 * JD-Core Version:    0.6.0
 */