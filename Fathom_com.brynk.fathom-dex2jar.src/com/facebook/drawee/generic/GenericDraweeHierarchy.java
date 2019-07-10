package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class GenericDraweeHierarchy
  implements SettableDraweeHierarchy
{
  private static final int ACTUAL_IMAGE_INDEX = 2;
  private static final int BACKGROUND_IMAGE_INDEX = 0;
  private static final int FAILURE_IMAGE_INDEX = 5;
  private static final int OVERLAY_IMAGES_INDEX = 6;
  private static final int PLACEHOLDER_IMAGE_INDEX = 1;
  private static final int PROGRESS_BAR_IMAGE_INDEX = 3;
  private static final int RETRY_IMAGE_INDEX = 4;
  private final ForwardingDrawable mActualImageWrapper;
  private final Drawable mEmptyActualImageDrawable = new ColorDrawable(0);
  private final FadeDrawable mFadeDrawable;
  private final Resources mResources;

  @Nullable
  private RoundingParams mRoundingParams;
  private final RootDrawable mTopLevelDrawable;

  GenericDraweeHierarchy(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder)
  {
    this.mResources = paramGenericDraweeHierarchyBuilder.getResources();
    this.mRoundingParams = paramGenericDraweeHierarchyBuilder.getRoundingParams();
    this.mActualImageWrapper = new ForwardingDrawable(this.mEmptyActualImageDrawable);
    int i;
    if (paramGenericDraweeHierarchyBuilder.getOverlays() != null)
    {
      i = paramGenericDraweeHierarchyBuilder.getOverlays().size();
      if (paramGenericDraweeHierarchyBuilder.getPressedStateOverlay() == null)
        break label261;
    }
    Drawable[] arrayOfDrawable;
    label261: for (int j = 1; ; j = 0)
    {
      i += j;
      arrayOfDrawable = new Drawable[i + 6];
      arrayOfDrawable[0] = buildBranch(paramGenericDraweeHierarchyBuilder.getBackground(), null);
      arrayOfDrawable[1] = buildBranch(paramGenericDraweeHierarchyBuilder.getPlaceholderImage(), paramGenericDraweeHierarchyBuilder.getPlaceholderImageScaleType());
      arrayOfDrawable[2] = buildActualImageBranch(this.mActualImageWrapper, paramGenericDraweeHierarchyBuilder.getActualImageScaleType(), paramGenericDraweeHierarchyBuilder.getActualImageFocusPoint(), paramGenericDraweeHierarchyBuilder.getActualImageMatrix(), paramGenericDraweeHierarchyBuilder.getActualImageColorFilter());
      arrayOfDrawable[3] = buildBranch(paramGenericDraweeHierarchyBuilder.getProgressBarImage(), paramGenericDraweeHierarchyBuilder.getProgressBarImageScaleType());
      arrayOfDrawable[4] = buildBranch(paramGenericDraweeHierarchyBuilder.getRetryImage(), paramGenericDraweeHierarchyBuilder.getRetryImageScaleType());
      arrayOfDrawable[5] = buildBranch(paramGenericDraweeHierarchyBuilder.getFailureImage(), paramGenericDraweeHierarchyBuilder.getFailureImageScaleType());
      if (i <= 0)
        break label291;
      i = 0;
      if (paramGenericDraweeHierarchyBuilder.getOverlays() == null)
        break label266;
      Iterator localIterator = paramGenericDraweeHierarchyBuilder.getOverlays().iterator();
      while (true)
      {
        j = i;
        if (!localIterator.hasNext())
          break;
        arrayOfDrawable[(i + 6)] = buildBranch((Drawable)localIterator.next(), null);
        i += 1;
      }
      i = 1;
      break;
    }
    label266: j = 1;
    if (paramGenericDraweeHierarchyBuilder.getPressedStateOverlay() != null)
      arrayOfDrawable[(j + 6)] = buildBranch(paramGenericDraweeHierarchyBuilder.getPressedStateOverlay(), null);
    label291: this.mFadeDrawable = new FadeDrawable(arrayOfDrawable);
    this.mFadeDrawable.setTransitionDuration(paramGenericDraweeHierarchyBuilder.getFadeDuration());
    this.mTopLevelDrawable = new RootDrawable(WrappingUtils.maybeWrapWithRoundedOverlayColor(this.mFadeDrawable, this.mRoundingParams));
    this.mTopLevelDrawable.mutate();
    resetFade();
  }

  @Nullable
  private Drawable buildActualImageBranch(Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType, @Nullable PointF paramPointF, @Nullable Matrix paramMatrix, @Nullable ColorFilter paramColorFilter)
  {
    paramDrawable.setColorFilter(paramColorFilter);
    return WrappingUtils.maybeWrapWithMatrix(WrappingUtils.maybeWrapWithScaleType(paramDrawable, paramScaleType, paramPointF), paramMatrix);
  }

  @Nullable
  private Drawable buildBranch(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    return WrappingUtils.maybeWrapWithScaleType(WrappingUtils.maybeApplyLeafRounding(paramDrawable, this.mRoundingParams, this.mResources), paramScaleType);
  }

  private void fadeInLayer(int paramInt)
  {
    if (paramInt >= 0)
      this.mFadeDrawable.fadeInLayer(paramInt);
  }

  private void fadeOutBranches()
  {
    fadeOutLayer(1);
    fadeOutLayer(2);
    fadeOutLayer(3);
    fadeOutLayer(4);
    fadeOutLayer(5);
  }

  private void fadeOutLayer(int paramInt)
  {
    if (paramInt >= 0)
      this.mFadeDrawable.fadeOutLayer(paramInt);
  }

  private DrawableParent getParentDrawableAtIndex(int paramInt)
  {
    Object localObject2 = this.mFadeDrawable.getDrawableParentForIndex(paramInt);
    Object localObject1 = localObject2;
    if ((((DrawableParent)localObject2).getDrawable() instanceof MatrixDrawable))
      localObject1 = (MatrixDrawable)((DrawableParent)localObject2).getDrawable();
    localObject2 = localObject1;
    if ((((DrawableParent)localObject1).getDrawable() instanceof ScaleTypeDrawable))
      localObject2 = (ScaleTypeDrawable)((DrawableParent)localObject1).getDrawable();
    return (DrawableParent)(DrawableParent)localObject2;
  }

  private ScaleTypeDrawable getScaleTypeDrawableAtIndex(int paramInt)
  {
    DrawableParent localDrawableParent = getParentDrawableAtIndex(paramInt);
    if ((localDrawableParent instanceof ScaleTypeDrawable))
      return (ScaleTypeDrawable)localDrawableParent;
    return WrappingUtils.wrapChildWithScaleType(localDrawableParent, ScalingUtils.ScaleType.FIT_XY);
  }

  private boolean hasScaleTypeDrawableAtIndex(int paramInt)
  {
    return getParentDrawableAtIndex(paramInt) instanceof ScaleTypeDrawable;
  }

  private void resetActualImages()
  {
    this.mActualImageWrapper.setDrawable(this.mEmptyActualImageDrawable);
  }

  private void resetFade()
  {
    if (this.mFadeDrawable != null)
    {
      this.mFadeDrawable.beginBatchMode();
      this.mFadeDrawable.fadeInAllLayers();
      fadeOutBranches();
      fadeInLayer(1);
      this.mFadeDrawable.finishTransitionImmediately();
      this.mFadeDrawable.endBatchMode();
    }
  }

  private void setChildDrawableAtIndex(int paramInt, @Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.mFadeDrawable.setDrawable(paramInt, null);
      return;
    }
    paramDrawable = WrappingUtils.maybeApplyLeafRounding(paramDrawable, this.mRoundingParams, this.mResources);
    getParentDrawableAtIndex(paramInt).setDrawable(paramDrawable);
  }

  private void setProgress(float paramFloat)
  {
    Drawable localDrawable = this.mFadeDrawable.getDrawable(3);
    if (localDrawable == null)
      return;
    if (paramFloat >= 0.999F)
    {
      if ((localDrawable instanceof Animatable))
        ((Animatable)localDrawable).stop();
      fadeOutLayer(3);
    }
    while (true)
    {
      localDrawable.setLevel(Math.round(10000.0F * paramFloat));
      return;
      if ((localDrawable instanceof Animatable))
        ((Animatable)localDrawable).start();
      fadeInLayer(3);
    }
  }

  public void getActualImageBounds(RectF paramRectF)
  {
    this.mActualImageWrapper.getTransformedBounds(paramRectF);
  }

  @Nullable
  public ScalingUtils.ScaleType getActualImageScaleType()
  {
    if (!hasScaleTypeDrawableAtIndex(2))
      return null;
    return getScaleTypeDrawableAtIndex(2).getScaleType();
  }

  public int getFadeDuration()
  {
    return this.mFadeDrawable.getTransitionDuration();
  }

  @Nullable
  public RoundingParams getRoundingParams()
  {
    return this.mRoundingParams;
  }

  public Drawable getTopLevelDrawable()
  {
    return this.mTopLevelDrawable;
  }

  public boolean hasPlaceholderImage()
  {
    return this.mFadeDrawable.getDrawable(1) != null;
  }

  public void reset()
  {
    resetActualImages();
    resetFade();
  }

  public void setActualImageColorFilter(ColorFilter paramColorFilter)
  {
    this.mActualImageWrapper.setColorFilter(paramColorFilter);
  }

  public void setActualImageFocusPoint(PointF paramPointF)
  {
    Preconditions.checkNotNull(paramPointF);
    getScaleTypeDrawableAtIndex(2).setFocusPoint(paramPointF);
  }

  public void setActualImageScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    Preconditions.checkNotNull(paramScaleType);
    getScaleTypeDrawableAtIndex(2).setScaleType(paramScaleType);
  }

  public void setBackgroundImage(@Nullable Drawable paramDrawable)
  {
    setChildDrawableAtIndex(0, paramDrawable);
  }

  public void setControllerOverlay(@Nullable Drawable paramDrawable)
  {
    this.mTopLevelDrawable.setControllerOverlay(paramDrawable);
  }

  public void setFadeDuration(int paramInt)
  {
    this.mFadeDrawable.setTransitionDuration(paramInt);
  }

  public void setFailure(Throwable paramThrowable)
  {
    this.mFadeDrawable.beginBatchMode();
    fadeOutBranches();
    if (this.mFadeDrawable.getDrawable(5) != null)
      fadeInLayer(5);
    while (true)
    {
      this.mFadeDrawable.endBatchMode();
      return;
      fadeInLayer(1);
    }
  }

  public void setFailureImage(int paramInt)
  {
    setFailureImage(this.mResources.getDrawable(paramInt));
  }

  public void setFailureImage(int paramInt, ScalingUtils.ScaleType paramScaleType)
  {
    setFailureImage(this.mResources.getDrawable(paramInt), paramScaleType);
  }

  public void setFailureImage(@Nullable Drawable paramDrawable)
  {
    setChildDrawableAtIndex(5, paramDrawable);
  }

  public void setFailureImage(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    setChildDrawableAtIndex(5, paramDrawable);
    getScaleTypeDrawableAtIndex(5).setScaleType(paramScaleType);
  }

  public void setImage(Drawable paramDrawable, float paramFloat, boolean paramBoolean)
  {
    paramDrawable = WrappingUtils.maybeApplyLeafRounding(paramDrawable, this.mRoundingParams, this.mResources);
    paramDrawable.mutate();
    this.mActualImageWrapper.setDrawable(paramDrawable);
    this.mFadeDrawable.beginBatchMode();
    fadeOutBranches();
    fadeInLayer(2);
    setProgress(paramFloat);
    if (paramBoolean)
      this.mFadeDrawable.finishTransitionImmediately();
    this.mFadeDrawable.endBatchMode();
  }

  public void setOverlayImage(int paramInt, @Nullable Drawable paramDrawable)
  {
    if ((paramInt >= 0) && (paramInt + 6 < this.mFadeDrawable.getNumberOfLayers()));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "The given index does not correspond to an overlay image.");
      setChildDrawableAtIndex(paramInt + 6, paramDrawable);
      return;
    }
  }

  public void setOverlayImage(@Nullable Drawable paramDrawable)
  {
    setOverlayImage(0, paramDrawable);
  }

  public void setPlaceholderImage(int paramInt)
  {
    setPlaceholderImage(this.mResources.getDrawable(paramInt));
  }

  public void setPlaceholderImage(int paramInt, ScalingUtils.ScaleType paramScaleType)
  {
    setPlaceholderImage(this.mResources.getDrawable(paramInt), paramScaleType);
  }

  public void setPlaceholderImage(@Nullable Drawable paramDrawable)
  {
    setChildDrawableAtIndex(1, paramDrawable);
  }

  public void setPlaceholderImage(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    setChildDrawableAtIndex(1, paramDrawable);
    getScaleTypeDrawableAtIndex(1).setScaleType(paramScaleType);
  }

  public void setPlaceholderImageFocusPoint(PointF paramPointF)
  {
    Preconditions.checkNotNull(paramPointF);
    getScaleTypeDrawableAtIndex(1).setFocusPoint(paramPointF);
  }

  public void setProgress(float paramFloat, boolean paramBoolean)
  {
    if (this.mFadeDrawable.getDrawable(3) == null)
      return;
    this.mFadeDrawable.beginBatchMode();
    setProgress(paramFloat);
    if (paramBoolean)
      this.mFadeDrawable.finishTransitionImmediately();
    this.mFadeDrawable.endBatchMode();
  }

  public void setProgressBarImage(int paramInt)
  {
    setProgressBarImage(this.mResources.getDrawable(paramInt));
  }

  public void setProgressBarImage(int paramInt, ScalingUtils.ScaleType paramScaleType)
  {
    setProgressBarImage(this.mResources.getDrawable(paramInt), paramScaleType);
  }

  public void setProgressBarImage(@Nullable Drawable paramDrawable)
  {
    setChildDrawableAtIndex(3, paramDrawable);
  }

  public void setProgressBarImage(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    setChildDrawableAtIndex(3, paramDrawable);
    getScaleTypeDrawableAtIndex(3).setScaleType(paramScaleType);
  }

  public void setRetry(Throwable paramThrowable)
  {
    this.mFadeDrawable.beginBatchMode();
    fadeOutBranches();
    if (this.mFadeDrawable.getDrawable(4) != null)
      fadeInLayer(4);
    while (true)
    {
      this.mFadeDrawable.endBatchMode();
      return;
      fadeInLayer(1);
    }
  }

  public void setRetryImage(int paramInt)
  {
    setRetryImage(this.mResources.getDrawable(paramInt));
  }

  public void setRetryImage(int paramInt, ScalingUtils.ScaleType paramScaleType)
  {
    setRetryImage(this.mResources.getDrawable(paramInt), paramScaleType);
  }

  public void setRetryImage(@Nullable Drawable paramDrawable)
  {
    setChildDrawableAtIndex(4, paramDrawable);
  }

  public void setRetryImage(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    setChildDrawableAtIndex(4, paramDrawable);
    getScaleTypeDrawableAtIndex(4).setScaleType(paramScaleType);
  }

  public void setRoundingParams(@Nullable RoundingParams paramRoundingParams)
  {
    this.mRoundingParams = paramRoundingParams;
    WrappingUtils.updateOverlayColorRounding(this.mTopLevelDrawable, this.mRoundingParams);
    int i = 0;
    while (i < this.mFadeDrawable.getNumberOfLayers())
    {
      WrappingUtils.updateLeafRounding(getParentDrawableAtIndex(i), this.mRoundingParams, this.mResources);
      i += 1;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.generic.GenericDraweeHierarchy
 * JD-Core Version:    0.6.0
 */