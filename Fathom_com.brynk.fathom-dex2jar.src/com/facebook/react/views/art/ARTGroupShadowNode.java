package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public class ARTGroupShadowNode extends ARTVirtualNode
{

  @Nullable
  protected RectF mClipping;

  private static RectF createClipping(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 4)
      throw new JSApplicationIllegalArgumentException("Clipping should be array of length 4 (e.g. [x, y, width, height])");
    return new RectF(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[0] + paramArrayOfFloat[2], paramArrayOfFloat[1] + paramArrayOfFloat[3]);
  }

  public void draw(Canvas paramCanvas, Paint paramPaint, float paramFloat)
  {
    paramFloat *= this.mOpacity;
    if (paramFloat > 0.01F)
    {
      saveAndSetupCanvas(paramCanvas);
      if (this.mClipping != null)
      {
        float f1 = this.mClipping.left;
        float f2 = this.mScale;
        float f3 = this.mClipping.top;
        float f4 = this.mScale;
        float f5 = this.mClipping.right;
        float f6 = this.mScale;
        float f7 = this.mClipping.bottom;
        paramCanvas.clipRect(f2 * f1, f4 * f3, f6 * f5, this.mScale * f7, Region.Op.REPLACE);
      }
      int i = 0;
      while (i < getChildCount())
      {
        ARTVirtualNode localARTVirtualNode = (ARTVirtualNode)getChildAt(i);
        localARTVirtualNode.draw(paramCanvas, paramPaint, paramFloat);
        localARTVirtualNode.markUpdateSeen();
        i += 1;
      }
      restoreCanvas(paramCanvas);
    }
  }

  public boolean isVirtual()
  {
    return true;
  }

  @ReactProp(name="clipping")
  public void setClipping(@Nullable ReadableArray paramReadableArray)
  {
    paramReadableArray = PropHelper.toFloatArray(paramReadableArray);
    if (paramReadableArray != null)
    {
      this.mClipping = createClipping(paramReadableArray);
      markUpdated();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTGroupShadowNode
 * JD-Core Version:    0.6.0
 */