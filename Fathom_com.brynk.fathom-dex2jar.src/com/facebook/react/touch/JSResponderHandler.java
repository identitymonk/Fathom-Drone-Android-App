package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import javax.annotation.Nullable;

public class JSResponderHandler
  implements OnInterceptTouchEventListener
{
  private static final int JS_RESPONDER_UNSET = -1;
  private volatile int mCurrentJSResponder = -1;

  @Nullable
  private ViewParent mViewParentBlockingNativeResponder;

  private void maybeUnblockNativeResponder()
  {
    if (this.mViewParentBlockingNativeResponder != null)
    {
      this.mViewParentBlockingNativeResponder.requestDisallowInterceptTouchEvent(false);
      this.mViewParentBlockingNativeResponder = null;
    }
  }

  public void clearJSResponder()
  {
    this.mCurrentJSResponder = -1;
    maybeUnblockNativeResponder();
  }

  public boolean onInterceptTouchEvent(ViewGroup paramViewGroup, MotionEvent paramMotionEvent)
  {
    int i = this.mCurrentJSResponder;
    if ((i != -1) && (paramMotionEvent.getAction() != 1))
      return paramViewGroup.getId() == i;
    return false;
  }

  public void setJSResponder(int paramInt, @Nullable ViewParent paramViewParent)
  {
    this.mCurrentJSResponder = paramInt;
    maybeUnblockNativeResponder();
    if (paramViewParent != null)
    {
      paramViewParent.requestDisallowInterceptTouchEvent(true);
      this.mViewParentBlockingNativeResponder = paramViewParent;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.touch.JSResponderHandler
 * JD-Core Version:    0.6.0
 */