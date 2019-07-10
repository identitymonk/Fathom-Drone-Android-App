package com.facebook.react.flat;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.views.art.ARTVirtualNode;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import javax.annotation.Nullable;

class FlatARTSurfaceViewShadowNode extends FlatShadowNode
  implements AndroidView, TextureView.SurfaceTextureListener
{
  private boolean mPaddingChanged = false;

  @Nullable
  private Surface mSurface;

  FlatARTSurfaceViewShadowNode()
  {
    forceMountToView();
    forceMountChildrenToView();
  }

  private void drawOutput()
  {
    if ((this.mSurface == null) || (!this.mSurface.isValid()))
      markChildrenUpdatesSeen(this);
    while (true)
    {
      return;
      try
      {
        Canvas localCanvas = this.mSurface.lockCanvas(null);
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint localPaint = new Paint();
        int i = 0;
        while (i < getChildCount())
        {
          ARTVirtualNode localARTVirtualNode = (ARTVirtualNode)getChildAt(i);
          localARTVirtualNode.draw(localCanvas, localPaint, 1.0F);
          localARTVirtualNode.markUpdateSeen();
          i += 1;
        }
        if (this.mSurface == null)
          continue;
        this.mSurface.unlockCanvasAndPost(localCanvas);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("ReactNative", localIllegalArgumentException.getClass().getSimpleName() + " in Surface.unlockCanvasAndPost");
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        label105: break label105;
      }
    }
  }

  private void markChildrenUpdatesSeen(ReactShadowNode paramReactShadowNode)
  {
    int i = 0;
    while (i < paramReactShadowNode.getChildCount())
    {
      ReactShadowNode localReactShadowNode = paramReactShadowNode.getChildAt(i);
      localReactShadowNode.markUpdateSeen();
      markChildrenUpdatesSeen(localReactShadowNode);
      i += 1;
    }
  }

  public boolean isPaddingChanged()
  {
    return this.mPaddingChanged;
  }

  public boolean isVirtual()
  {
    return false;
  }

  public boolean isVirtualAnchor()
  {
    return true;
  }

  public boolean needsCustomLayoutForChildren()
  {
    return false;
  }

  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
    super.onCollectExtraUpdates(paramUIViewOperationQueue);
    drawOutput();
    paramUIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), this);
  }

  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mSurface = new Surface(paramSurfaceTexture);
    drawOutput();
  }

  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture.release();
    this.mSurface = null;
    return true;
  }

  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
  }

  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
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
 * Qualified Name:     com.facebook.react.flat.FlatARTSurfaceViewShadowNode
 * JD-Core Version:    0.6.0
 */