package com.facebook.react.flat;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;

class FlatReactModalShadowNode extends FlatShadowNode
  implements AndroidView
{
  private final Point mMaxPoint = new Point();
  private final Point mMinPoint = new Point();
  private boolean mPaddingChanged;

  FlatReactModalShadowNode()
  {
    forceMountToView();
    forceMountChildrenToView();
  }

  @TargetApi(16)
  public void addChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    super.addChildAt(paramReactShadowNodeImpl, paramInt);
    Display localDisplay = ((WindowManager)getThemedContext().getSystemService("window")).getDefaultDisplay();
    localDisplay.getCurrentSizeRange(this.mMinPoint, this.mMaxPoint);
    paramInt = localDisplay.getRotation();
    int i;
    if ((paramInt == 0) || (paramInt == 2))
      i = this.mMinPoint.x;
    for (paramInt = this.mMaxPoint.y; ; paramInt = this.mMinPoint.y)
    {
      paramReactShadowNodeImpl.setStyleWidth(i);
      paramReactShadowNodeImpl.setStyleHeight(paramInt);
      return;
      int j = this.mMaxPoint.x;
    }
  }

  public boolean isPaddingChanged()
  {
    return this.mPaddingChanged;
  }

  public boolean needsCustomLayoutForChildren()
  {
    return false;
  }

  public void resetPaddingChanged()
  {
    this.mPaddingChanged = false;
  }

  public void setPadding(int paramInt, float paramFloat)
  {
    YogaValue localYogaValue = getStylePadding(paramInt);
    if ((localYogaValue.unit != YogaUnit.POINT) || (localYogaValue.value != paramFloat))
    {
      super.setPadding(paramInt, paramFloat);
      this.mPaddingChanged = true;
      markUpdated();
    }
  }

  public void setPaddingPercent(int paramInt, float paramFloat)
  {
    YogaValue localYogaValue = getStylePadding(paramInt);
    if ((localYogaValue.unit != YogaUnit.PERCENT) || (localYogaValue.value != paramFloat))
    {
      super.setPadding(paramInt, paramFloat);
      this.mPaddingChanged = true;
      markUpdated();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatReactModalShadowNode
 * JD-Core Version:    0.6.0
 */