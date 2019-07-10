package com.facebook.react.flat;

import android.graphics.Rect;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import javax.annotation.Nullable;

final class RCTView extends FlatShadowNode
{
  private static final int[] SPACING_TYPES = { 8, 0, 2, 1, 3 };

  @Nullable
  private DrawBorder mDrawBorder;

  @Nullable
  private Rect mHitSlop;
  boolean mHorizontal;
  boolean mRemoveClippedSubviews;

  private DrawBorder getMutableBorder()
  {
    if (this.mDrawBorder == null)
      this.mDrawBorder = new DrawBorder();
    while (true)
    {
      invalidate();
      return this.mDrawBorder;
      if (!this.mDrawBorder.isFrozen())
        continue;
      this.mDrawBorder = ((DrawBorder)this.mDrawBorder.mutableCopy());
    }
  }

  public boolean clipsSubviews()
  {
    return this.mRemoveClippedSubviews;
  }

  protected void collectState(StateBuilder paramStateBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    super.collectState(paramStateBuilder, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    if (this.mDrawBorder != null)
    {
      this.mDrawBorder = ((DrawBorder)this.mDrawBorder.updateBoundsAndFreeze(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8));
      paramStateBuilder.addDrawCommand(this.mDrawBorder);
    }
  }

  boolean doesDraw()
  {
    return (this.mDrawBorder != null) || (super.doesDraw());
  }

  void handleUpdateProperties(ReactStylesDiffMap paramReactStylesDiffMap)
  {
    boolean bool2 = false;
    if ((this.mRemoveClippedSubviews) || ((paramReactStylesDiffMap.hasKey("removeClippedSubviews")) && (paramReactStylesDiffMap.getBoolean("removeClippedSubviews", false))));
    for (boolean bool1 = true; ; bool1 = false)
    {
      this.mRemoveClippedSubviews = bool1;
      if (this.mRemoveClippedSubviews)
      {
        if (!this.mHorizontal)
        {
          bool1 = bool2;
          if (paramReactStylesDiffMap.hasKey("horizontal"))
          {
            bool1 = bool2;
            if (!paramReactStylesDiffMap.getBoolean("horizontal", false));
          }
        }
        else
        {
          bool1 = true;
        }
        this.mHorizontal = bool1;
      }
      super.handleUpdateProperties(paramReactStylesDiffMap);
      return;
    }
  }

  public void setBackgroundColor(int paramInt)
  {
    getMutableBorder().setBackgroundColor(paramInt);
  }

  @ReactPropGroup(customType="Color", defaultDouble=(0.0D / 0.0D), names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
  public void setBorderColor(int paramInt, double paramDouble)
  {
    paramInt = SPACING_TYPES[paramInt];
    if (Double.isNaN(paramDouble))
    {
      getMutableBorder().resetBorderColor(paramInt);
      return;
    }
    getMutableBorder().setBorderColor(paramInt, (int)paramDouble);
  }

  @ReactProp(name="borderRadius")
  public void setBorderRadius(float paramFloat)
  {
    this.mClipRadius = paramFloat;
    if ((this.mClipToBounds) && (paramFloat > 0.5F))
      forceMountToView();
    getMutableBorder().setBorderRadius(PixelUtil.toPixelFromDIP(paramFloat));
  }

  @ReactProp(name="borderStyle")
  public void setBorderStyle(@Nullable String paramString)
  {
    getMutableBorder().setBorderStyle(paramString);
  }

  public void setBorderWidths(int paramInt, float paramFloat)
  {
    super.setBorderWidths(paramInt, paramFloat);
    paramInt = SPACING_TYPES[paramInt];
    getMutableBorder().setBorderWidth(paramInt, PixelUtil.toPixelFromDIP(paramFloat));
  }

  @ReactProp(name="hitSlop")
  public void setHitSlop(@Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null)
    {
      this.mHitSlop = null;
      return;
    }
    this.mHitSlop = new Rect((int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("left")), (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("top")), (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("right")), (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("bottom")));
  }

  @ReactProp(name="nativeBackgroundAndroid")
  public void setHotspot(@Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap != null)
      forceMountToView();
  }

  @ReactProp(name="pointerEvents")
  public void setPointerEvents(@Nullable String paramString)
  {
    forceMountToView();
  }

  void updateNodeRegion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (!getNodeRegion().matches(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean))
      if (this.mHitSlop != null)
        break label51;
    label51: for (Object localObject = new NodeRegion(paramFloat1, paramFloat2, paramFloat3, paramFloat4, getReactTag(), paramBoolean); ; localObject = new HitSlopNodeRegion(this.mHitSlop, paramFloat1, paramFloat2, paramFloat3, paramFloat4, getReactTag(), paramBoolean))
    {
      setNodeRegion((NodeRegion)localObject);
      return;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTView
 * JD-Core Version:    0.6.0
 */