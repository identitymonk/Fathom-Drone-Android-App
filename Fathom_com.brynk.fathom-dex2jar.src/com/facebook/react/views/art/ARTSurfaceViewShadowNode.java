package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.facebook.common.logging.FLog;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public class ARTSurfaceViewShadowNode extends LayoutShadowNode
  implements TextureView.SurfaceTextureListener
{

  @Nullable
  private Integer mBackgroundColor;

  @Nullable
  private Surface mSurface;

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
        if (this.mBackgroundColor != null)
          localCanvas.drawColor(this.mBackgroundColor.intValue());
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
        FLog.e("ReactNative", localIllegalArgumentException.getClass().getSimpleName() + " in Surface.unlockCanvasAndPost");
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        label123: break label123;
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

  public boolean isVirtual()
  {
    return false;
  }

  public boolean isVirtualAnchor()
  {
    return true;
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

  @ReactProp(customType="Color", name="backgroundColor")
  public void setBackgroundColor(Integer paramInteger)
  {
    this.mBackgroundColor = paramInteger;
    markUpdated();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTSurfaceViewShadowNode
 * JD-Core Version:    0.6.0
 */