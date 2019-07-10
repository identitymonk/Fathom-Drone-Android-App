package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

public class DraweeHolder<DH extends DraweeHierarchy>
  implements VisibilityCallback
{
  private DraweeController mController = null;
  private final DraweeEventTracker mEventTracker = DraweeEventTracker.newInstance();
  private DH mHierarchy;
  private boolean mIsControllerAttached = false;
  private boolean mIsHolderAttached = false;
  private boolean mIsVisible = true;

  public DraweeHolder(@Nullable DH paramDH)
  {
    if (paramDH != null)
      setHierarchy(paramDH);
  }

  private void attachController()
  {
    if (this.mIsControllerAttached);
    do
    {
      return;
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
      this.mIsControllerAttached = true;
    }
    while ((this.mController == null) || (this.mController.getHierarchy() == null));
    this.mController.onAttach();
  }

  private void attachOrDetachController()
  {
    if ((this.mIsHolderAttached) && (this.mIsVisible))
    {
      attachController();
      return;
    }
    detachController();
  }

  public static <DH extends DraweeHierarchy> DraweeHolder<DH> create(@Nullable DH paramDH, Context paramContext)
  {
    paramDH = new DraweeHolder(paramDH);
    paramDH.registerWithContext(paramContext);
    return paramDH;
  }

  private void detachController()
  {
    if (!this.mIsControllerAttached);
    do
    {
      return;
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
      this.mIsControllerAttached = false;
    }
    while (!isControllerValid());
    this.mController.onDetach();
  }

  private boolean isControllerValid()
  {
    return (this.mController != null) && (this.mController.getHierarchy() == this.mHierarchy);
  }

  private void setVisibilityCallback(@Nullable VisibilityCallback paramVisibilityCallback)
  {
    Drawable localDrawable = getTopLevelDrawable();
    if ((localDrawable instanceof VisibilityAwareDrawable))
      ((VisibilityAwareDrawable)localDrawable).setVisibilityCallback(paramVisibilityCallback);
  }

  @Nullable
  public DraweeController getController()
  {
    return this.mController;
  }

  protected DraweeEventTracker getDraweeEventTracker()
  {
    return this.mEventTracker;
  }

  public DH getHierarchy()
  {
    return (DraweeHierarchy)Preconditions.checkNotNull(this.mHierarchy);
  }

  public Drawable getTopLevelDrawable()
  {
    if (this.mHierarchy == null)
      return null;
    return this.mHierarchy.getTopLevelDrawable();
  }

  public boolean hasHierarchy()
  {
    return this.mHierarchy != null;
  }

  public boolean isAttached()
  {
    return this.mIsHolderAttached;
  }

  public void onAttach()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
    this.mIsHolderAttached = true;
    attachOrDetachController();
  }

  public void onDetach()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_DETACH);
    this.mIsHolderAttached = false;
    attachOrDetachController();
  }

  public void onDraw()
  {
    if (this.mIsControllerAttached)
      return;
    FLog.wtf(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", new Object[] { Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mController)), toString() });
    this.mIsHolderAttached = true;
    this.mIsVisible = true;
    attachOrDetachController();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isControllerValid())
      return false;
    return this.mController.onTouchEvent(paramMotionEvent);
  }

  public void onVisibilityChange(boolean paramBoolean)
  {
    if (this.mIsVisible == paramBoolean)
      return;
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    if (paramBoolean);
    for (DraweeEventTracker.Event localEvent = DraweeEventTracker.Event.ON_DRAWABLE_SHOW; ; localEvent = DraweeEventTracker.Event.ON_DRAWABLE_HIDE)
    {
      localDraweeEventTracker.recordEvent(localEvent);
      this.mIsVisible = paramBoolean;
      attachOrDetachController();
      return;
    }
  }

  public void registerWithContext(Context paramContext)
  {
  }

  public void setController(@Nullable DraweeController paramDraweeController)
  {
    boolean bool = this.mIsControllerAttached;
    if (bool)
      detachController();
    if (isControllerValid())
    {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
      this.mController.setHierarchy(null);
    }
    this.mController = paramDraweeController;
    if (this.mController != null)
    {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_CONTROLLER);
      this.mController.setHierarchy(this.mHierarchy);
    }
    while (true)
    {
      if (bool)
        attachController();
      return;
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
    }
  }

  public void setHierarchy(DH paramDH)
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_HIERARCHY);
    boolean bool2 = isControllerValid();
    setVisibilityCallback(null);
    this.mHierarchy = ((DraweeHierarchy)Preconditions.checkNotNull(paramDH));
    Drawable localDrawable = this.mHierarchy.getTopLevelDrawable();
    if ((localDrawable == null) || (localDrawable.isVisible()));
    for (boolean bool1 = true; ; bool1 = false)
    {
      onVisibilityChange(bool1);
      setVisibilityCallback(this);
      if (bool2)
        this.mController.setHierarchy(paramDH);
      return;
    }
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("controllerAttached", this.mIsControllerAttached).add("holderAttached", this.mIsHolderAttached).add("drawableVisible", this.mIsVisible).add("events", this.mEventTracker.toString()).toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.view.DraweeHolder
 * JD-Core Version:    0.6.0
 */