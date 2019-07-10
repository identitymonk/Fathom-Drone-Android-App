package com.facebook.react.views.art;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;

@ReactModule(name="ARTSurfaceView")
public class ARTSurfaceViewManager extends BaseViewManager<ARTSurfaceView, ARTSurfaceViewShadowNode>
{
  private static final YogaMeasureFunction MEASURE_FUNCTION = new YogaMeasureFunction()
  {
    public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
    {
      throw new IllegalStateException("SurfaceView should have explicit width and height set");
    }
  };
  protected static final String REACT_CLASS = "ARTSurfaceView";

  public ARTSurfaceViewShadowNode createShadowNodeInstance()
  {
    ARTSurfaceViewShadowNode localARTSurfaceViewShadowNode = new ARTSurfaceViewShadowNode();
    localARTSurfaceViewShadowNode.setMeasureFunction(MEASURE_FUNCTION);
    return localARTSurfaceViewShadowNode;
  }

  protected ARTSurfaceView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ARTSurfaceView(paramThemedReactContext);
  }

  public String getName()
  {
    return "ARTSurfaceView";
  }

  public Class<ARTSurfaceViewShadowNode> getShadowNodeClass()
  {
    return ARTSurfaceViewShadowNode.class;
  }

  public void setBackgroundColor(ARTSurfaceView paramARTSurfaceView, int paramInt)
  {
  }

  public void updateExtraData(ARTSurfaceView paramARTSurfaceView, Object paramObject)
  {
    paramARTSurfaceView.setSurfaceTextureListener((ARTSurfaceViewShadowNode)paramObject);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTSurfaceViewManager
 * JD-Core Version:    0.6.0
 */