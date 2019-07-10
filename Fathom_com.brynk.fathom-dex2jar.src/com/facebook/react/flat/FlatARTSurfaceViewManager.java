package com.facebook.react.flat;

import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.art.ARTSurfaceView;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;

public class FlatARTSurfaceViewManager extends BaseViewManager<ARTSurfaceView, FlatARTSurfaceViewShadowNode>
{
  private static final YogaMeasureFunction MEASURE_FUNCTION = new YogaMeasureFunction()
  {
    public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
    {
      throw new IllegalStateException("SurfaceView should have explicit width and height set");
    }
  };
  static final String REACT_CLASS = "ARTSurfaceView";

  public FlatARTSurfaceViewShadowNode createShadowNodeInstance()
  {
    FlatARTSurfaceViewShadowNode localFlatARTSurfaceViewShadowNode = new FlatARTSurfaceViewShadowNode();
    localFlatARTSurfaceViewShadowNode.setMeasureFunction(MEASURE_FUNCTION);
    return localFlatARTSurfaceViewShadowNode;
  }

  protected ARTSurfaceView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ARTSurfaceView(paramThemedReactContext);
  }

  public String getName()
  {
    return "ARTSurfaceView";
  }

  public Class<FlatARTSurfaceViewShadowNode> getShadowNodeClass()
  {
    return FlatARTSurfaceViewShadowNode.class;
  }

  public void updateExtraData(ARTSurfaceView paramARTSurfaceView, Object paramObject)
  {
    paramARTSurfaceView.setSurfaceTextureListener((FlatARTSurfaceViewShadowNode)paramObject);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatARTSurfaceViewManager
 * JD-Core Version:    0.6.0
 */