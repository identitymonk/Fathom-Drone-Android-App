package com.facebook.react.views.modal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R.style;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import javax.annotation.Nullable;

public class ReactModalHostView extends ViewGroup
  implements LifecycleEventListener
{
  private String mAnimationType;

  @Nullable
  private Dialog mDialog;
  private boolean mHardwareAccelerated;
  private DialogRootViewGroup mHostView;

  @Nullable
  private OnRequestCloseListener mOnRequestCloseListener;

  @Nullable
  private DialogInterface.OnShowListener mOnShowListener;
  private boolean mPropertyRequiresNewDialog;
  private boolean mTransparent;

  public ReactModalHostView(Context paramContext)
  {
    super(paramContext);
    ((ReactContext)paramContext).addLifecycleEventListener(this);
    this.mHostView = new DialogRootViewGroup(paramContext);
  }

  private void dismiss()
  {
    if (this.mDialog != null)
    {
      this.mDialog.dismiss();
      this.mDialog = null;
      ((ViewGroup)this.mHostView.getParent()).removeViewAt(0);
    }
  }

  private View getContentView()
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.addView(this.mHostView);
    localFrameLayout.setFitsSystemWindows(true);
    return localFrameLayout;
  }

  private void updateProperties()
  {
    Assertions.assertNotNull(this.mDialog, "mDialog must exist when we call updateProperties");
    if (this.mTransparent)
    {
      this.mDialog.getWindow().clearFlags(2);
      return;
    }
    this.mDialog.getWindow().setDimAmount(0.5F);
    this.mDialog.getWindow().setFlags(2, 2);
  }

  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
  }

  public void addView(View paramView, int paramInt)
  {
    this.mHostView.addView(paramView, paramInt);
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }

  public View getChildAt(int paramInt)
  {
    return this.mHostView.getChildAt(paramInt);
  }

  public int getChildCount()
  {
    return this.mHostView.getChildCount();
  }

  @Nullable
  @VisibleForTesting
  public Dialog getDialog()
  {
    return this.mDialog;
  }

  public void onDropInstance()
  {
    ((ReactContext)getContext()).removeLifecycleEventListener(this);
    dismiss();
  }

  public void onHostDestroy()
  {
    onDropInstance();
  }

  public void onHostPause()
  {
    dismiss();
  }

  public void onHostResume()
  {
    showOrUpdate();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public void removeView(View paramView)
  {
    this.mHostView.removeView(paramView);
  }

  public void removeViewAt(int paramInt)
  {
    View localView = getChildAt(paramInt);
    this.mHostView.removeView(localView);
  }

  protected void setAnimationType(String paramString)
  {
    this.mAnimationType = paramString;
    this.mPropertyRequiresNewDialog = true;
  }

  protected void setHardwareAccelerated(boolean paramBoolean)
  {
    this.mHardwareAccelerated = paramBoolean;
    this.mPropertyRequiresNewDialog = true;
  }

  protected void setOnRequestCloseListener(OnRequestCloseListener paramOnRequestCloseListener)
  {
    this.mOnRequestCloseListener = paramOnRequestCloseListener;
  }

  protected void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.mOnShowListener = paramOnShowListener;
  }

  protected void setTransparent(boolean paramBoolean)
  {
    this.mTransparent = paramBoolean;
  }

  protected void showOrUpdate()
  {
    int i;
    if (this.mDialog != null)
    {
      if (this.mPropertyRequiresNewDialog)
        dismiss();
    }
    else
    {
      this.mPropertyRequiresNewDialog = false;
      i = R.style.Theme_FullScreenDialog;
      if (!this.mAnimationType.equals("fade"))
        break label144;
      i = R.style.Theme_FullScreenDialogAnimatedFade;
    }
    while (true)
    {
      this.mDialog = new Dialog(getContext(), i);
      this.mDialog.setContentView(getContentView());
      updateProperties();
      this.mDialog.setOnShowListener(this.mOnShowListener);
      this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
        {
          if (paramKeyEvent.getAction() == 1)
          {
            if (paramInt == 4)
            {
              Assertions.assertNotNull(ReactModalHostView.this.mOnRequestCloseListener, "setOnRequestCloseListener must be called by the manager");
              ReactModalHostView.this.mOnRequestCloseListener.onRequestClose(paramDialogInterface);
              return true;
            }
            paramDialogInterface = ((ReactContext)ReactModalHostView.this.getContext()).getCurrentActivity();
            if (paramDialogInterface != null)
              return paramDialogInterface.onKeyUp(paramInt, paramKeyEvent);
          }
          return false;
        }
      });
      this.mDialog.getWindow().setSoftInputMode(16);
      if (this.mHardwareAccelerated)
        this.mDialog.getWindow().addFlags(16777216);
      this.mDialog.show();
      return;
      updateProperties();
      return;
      label144: if (!this.mAnimationType.equals("slide"))
        continue;
      i = R.style.Theme_FullScreenDialogAnimatedSlide;
    }
  }

  static class DialogRootViewGroup extends ReactViewGroup
    implements RootView
  {
    private final JSTouchDispatcher mJSTouchDispatcher = new JSTouchDispatcher(this);

    public DialogRootViewGroup(Context paramContext)
    {
      super();
    }

    private EventDispatcher getEventDispatcher()
    {
      return ((UIManagerModule)((ReactContext)getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void onChildStartedNativeGesture(MotionEvent paramMotionEvent)
    {
      this.mJSTouchDispatcher.onChildStartedNativeGesture(paramMotionEvent, getEventDispatcher());
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.mJSTouchDispatcher.handleTouchEvent(paramMotionEvent, getEventDispatcher());
      return super.onInterceptTouchEvent(paramMotionEvent);
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (getChildCount() > 0)
      {
        paramInt3 = getChildAt(0).getId();
        ReactContext localReactContext = (ReactContext)getContext();
        localReactContext.runUIBackgroundRunnable(new GuardedRunnable(localReactContext, paramInt3, paramInt1, paramInt2)
        {
          public void runGuarded()
          {
            ((UIManagerModule)((ReactContext)ReactModalHostView.DialogRootViewGroup.this.getContext()).getNativeModule(UIManagerModule.class)).updateNodeSize(this.val$viewTag, this.val$w, this.val$h);
          }
        });
      }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      this.mJSTouchDispatcher.handleTouchEvent(paramMotionEvent, getEventDispatcher());
      super.onTouchEvent(paramMotionEvent);
      return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
    {
    }
  }

  public static abstract interface OnRequestCloseListener
  {
    public abstract void onRequestClose(DialogInterface paramDialogInterface);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.modal.ReactModalHostView
 * JD-Core Version:    0.6.0
 */