package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

public class DraweeView<DH extends DraweeHierarchy> extends ImageView
{
  private float mAspectRatio = 0.0F;
  private DraweeHolder<DH> mDraweeHolder;
  private boolean mInitialised = false;
  private final AspectRatioMeasure.Spec mMeasureSpec = new AspectRatioMeasure.Spec();

  public DraweeView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }

  public DraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }

  public DraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }

  @TargetApi(21)
  public DraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext);
  }

  private void init(Context paramContext)
  {
    if (this.mInitialised);
    do
    {
      do
      {
        return;
        this.mInitialised = true;
        this.mDraweeHolder = DraweeHolder.create(null, paramContext);
      }
      while (Build.VERSION.SDK_INT < 21);
      paramContext = getImageTintList();
    }
    while (paramContext == null);
    setColorFilter(paramContext.getDefaultColor());
  }

  protected void doAttach()
  {
    this.mDraweeHolder.onAttach();
  }

  protected void doDetach()
  {
    this.mDraweeHolder.onDetach();
  }

  public float getAspectRatio()
  {
    return this.mAspectRatio;
  }

  @Nullable
  public DraweeController getController()
  {
    return this.mDraweeHolder.getController();
  }

  public DH getHierarchy()
  {
    return this.mDraweeHolder.getHierarchy();
  }

  @Nullable
  public Drawable getTopLevelDrawable()
  {
    return this.mDraweeHolder.getTopLevelDrawable();
  }

  public boolean hasController()
  {
    return this.mDraweeHolder.getController() != null;
  }

  public boolean hasHierarchy()
  {
    return this.mDraweeHolder.hasHierarchy();
  }

  protected void onAttach()
  {
    doAttach();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    onAttach();
  }

  protected void onDetach()
  {
    doDetach();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    onDetach();
  }

  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    onAttach();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mMeasureSpec.width = paramInt1;
    this.mMeasureSpec.height = paramInt2;
    AspectRatioMeasure.updateMeasureSpec(this.mMeasureSpec, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
    super.onMeasure(this.mMeasureSpec.width, this.mMeasureSpec.height);
  }

  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    onDetach();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mDraweeHolder.onTouchEvent(paramMotionEvent))
      return true;
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setAspectRatio(float paramFloat)
  {
    if (paramFloat == this.mAspectRatio)
      return;
    this.mAspectRatio = paramFloat;
    requestLayout();
  }

  public void setController(@Nullable DraweeController paramDraweeController)
  {
    this.mDraweeHolder.setController(paramDraweeController);
    super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
  }

  public void setHierarchy(DH paramDH)
  {
    this.mDraweeHolder.setHierarchy(paramDH);
    super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
  }

  @Deprecated
  public void setImageBitmap(Bitmap paramBitmap)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageBitmap(paramBitmap);
  }

  @Deprecated
  public void setImageDrawable(Drawable paramDrawable)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageDrawable(paramDrawable);
  }

  @Deprecated
  public void setImageResource(int paramInt)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageResource(paramInt);
  }

  @Deprecated
  public void setImageURI(Uri paramUri)
  {
    init(getContext());
    this.mDraweeHolder.setController(null);
    super.setImageURI(paramUri);
  }

  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    if (this.mDraweeHolder != null);
    for (String str = this.mDraweeHolder.toString(); ; str = "<no holder set>")
      return localToStringHelper.add("holder", str).toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.view.DraweeView
 * JD-Core Version:    0.6.0
 */