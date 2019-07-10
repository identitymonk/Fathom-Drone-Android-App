package com.facebook.react.uimanager;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.react.R.id;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.util.ReactFindViewUtil;

public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode> extends ViewManager<T, C>
{
  private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 5.0F;
  private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
  private static final String PROP_ACCESSIBILITY_COMPONENT_TYPE = "accessibilityComponentType";
  private static final String PROP_ACCESSIBILITY_LABEL = "accessibilityLabel";
  private static final String PROP_ACCESSIBILITY_LIVE_REGION = "accessibilityLiveRegion";
  private static final String PROP_BACKGROUND_COLOR = "backgroundColor";
  private static final String PROP_ELEVATION = "elevation";
  private static final String PROP_IMPORTANT_FOR_ACCESSIBILITY = "importantForAccessibility";
  public static final String PROP_NATIVE_ID = "nativeID";
  private static final String PROP_RENDER_TO_HARDWARE_TEXTURE = "renderToHardwareTextureAndroid";
  private static final String PROP_ROTATION = "rotation";
  private static final String PROP_SCALE_X = "scaleX";
  private static final String PROP_SCALE_Y = "scaleY";
  public static final String PROP_TEST_ID = "testID";
  private static final String PROP_TRANSFORM = "transform";
  private static final String PROP_TRANSLATE_X = "translateX";
  private static final String PROP_TRANSLATE_Y = "translateY";
  private static final String PROP_Z_INDEX = "zIndex";
  private static MatrixMathHelper.MatrixDecompositionContext sMatrixDecompositionContext = new MatrixMathHelper.MatrixDecompositionContext();
  private static double[] sTransformDecompositionArray = new double[16];

  private static void resetTransformProperty(View paramView)
  {
    paramView.setTranslationX(PixelUtil.toPixelFromDIP(0.0F));
    paramView.setTranslationY(PixelUtil.toPixelFromDIP(0.0F));
    paramView.setRotation(0.0F);
    paramView.setRotationX(0.0F);
    paramView.setRotationY(0.0F);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setCameraDistance(0.0F);
  }

  private static void setTransformProperty(View paramView, ReadableArray paramReadableArray)
  {
    TransformHelper.processTransform(paramReadableArray, sTransformDecompositionArray);
    MatrixMathHelper.decomposeMatrix(sTransformDecompositionArray, sMatrixDecompositionContext);
    paramView.setTranslationX(PixelUtil.toPixelFromDIP((float)sMatrixDecompositionContext.translation[0]));
    paramView.setTranslationY(PixelUtil.toPixelFromDIP((float)sMatrixDecompositionContext.translation[1]));
    paramView.setRotation((float)sMatrixDecompositionContext.rotationDegrees[2]);
    paramView.setRotationX((float)sMatrixDecompositionContext.rotationDegrees[0]);
    paramView.setRotationY((float)sMatrixDecompositionContext.rotationDegrees[1]);
    paramView.setScaleX((float)sMatrixDecompositionContext.scale[0]);
    paramView.setScaleY((float)sMatrixDecompositionContext.scale[1]);
    paramReadableArray = sMatrixDecompositionContext.perspective;
    if (paramReadableArray.length > 2)
    {
      float f2 = (float)paramReadableArray[2];
      float f1 = f2;
      if (f2 == 0.0F)
        f1 = 0.00078125F;
      f1 = -1.0F / f1;
      paramView.setCameraDistance(DisplayMetricsHolder.getScreenDisplayMetrics().density * f1 * 5.0F);
    }
  }

  @ReactProp(name="accessibilityComponentType")
  public void setAccessibilityComponentType(T paramT, String paramString)
  {
    AccessibilityHelper.updateAccessibilityComponentType(paramT, paramString);
  }

  @ReactProp(name="accessibilityLabel")
  public void setAccessibilityLabel(T paramT, String paramString)
  {
    paramT.setContentDescription(paramString);
  }

  @ReactProp(name="accessibilityLiveRegion")
  public void setAccessibilityLiveRegion(T paramT, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if ((paramString != null) && (!paramString.equals("none")))
        break label27;
      paramT.setAccessibilityLiveRegion(0);
    }
    label27: 
    do
    {
      return;
      if (!paramString.equals("polite"))
        continue;
      paramT.setAccessibilityLiveRegion(1);
      return;
    }
    while (!paramString.equals("assertive"));
    paramT.setAccessibilityLiveRegion(2);
  }

  @ReactProp(customType="Color", defaultInt=0, name="backgroundColor")
  public void setBackgroundColor(T paramT, int paramInt)
  {
    paramT.setBackgroundColor(paramInt);
  }

  @ReactProp(name="elevation")
  public void setElevation(T paramT, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramT.setElevation(PixelUtil.toPixelFromDIP(paramFloat));
  }

  @ReactProp(name="importantForAccessibility")
  public void setImportantForAccessibility(T paramT, String paramString)
  {
    if ((paramString == null) || (paramString.equals("auto")))
      paramT.setImportantForAccessibility(0);
    do
    {
      return;
      if (paramString.equals("yes"))
      {
        paramT.setImportantForAccessibility(1);
        return;
      }
      if (!paramString.equals("no"))
        continue;
      paramT.setImportantForAccessibility(2);
      return;
    }
    while (!paramString.equals("no-hide-descendants"));
    paramT.setImportantForAccessibility(4);
  }

  @ReactProp(name="nativeID")
  public void setNativeId(T paramT, String paramString)
  {
    paramT.setTag(R.id.view_tag_native_id, paramString);
    ReactFindViewUtil.notifyViewRendered(paramT);
  }

  @ReactProp(defaultFloat=1.0F, name="opacity")
  public void setOpacity(T paramT, float paramFloat)
  {
    paramT.setAlpha(paramFloat);
  }

  @ReactProp(name="renderToHardwareTextureAndroid")
  public void setRenderToHardwareTexture(T paramT, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 2; ; i = 0)
    {
      paramT.setLayerType(i, null);
      return;
    }
  }

  @ReactProp(name="rotation")
  @Deprecated
  public void setRotation(T paramT, float paramFloat)
  {
    paramT.setRotation(paramFloat);
  }

  @ReactProp(defaultFloat=1.0F, name="scaleX")
  @Deprecated
  public void setScaleX(T paramT, float paramFloat)
  {
    paramT.setScaleX(paramFloat);
  }

  @ReactProp(defaultFloat=1.0F, name="scaleY")
  @Deprecated
  public void setScaleY(T paramT, float paramFloat)
  {
    paramT.setScaleY(paramFloat);
  }

  @ReactProp(name="testID")
  public void setTestId(T paramT, String paramString)
  {
    paramT.setTag(R.id.react_test_id, paramString);
    paramT.setTag(paramString);
  }

  @ReactProp(name="transform")
  public void setTransform(T paramT, ReadableArray paramReadableArray)
  {
    if (paramReadableArray == null)
    {
      resetTransformProperty(paramT);
      return;
    }
    setTransformProperty(paramT, paramReadableArray);
  }

  @ReactProp(defaultFloat=0.0F, name="translateX")
  @Deprecated
  public void setTranslateX(T paramT, float paramFloat)
  {
    paramT.setTranslationX(PixelUtil.toPixelFromDIP(paramFloat));
  }

  @ReactProp(defaultFloat=0.0F, name="translateY")
  @Deprecated
  public void setTranslateY(T paramT, float paramFloat)
  {
    paramT.setTranslationY(PixelUtil.toPixelFromDIP(paramFloat));
  }

  @ReactProp(name="zIndex")
  public void setZIndex(T paramT, float paramFloat)
  {
    ViewGroupManager.setViewZIndex(paramT, Math.round(paramFloat));
    paramT = paramT.getParent();
    if ((paramT != null) && ((paramT instanceof ReactZIndexedViewGroup)))
      ((ReactZIndexedViewGroup)paramT).updateDrawingOrder();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.BaseViewManager
 * JD-Core Version:    0.6.0
 */