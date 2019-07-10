package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import javax.annotation.Nullable;

public class WrappingUtils
{
  private static final Drawable sEmptyDrawable = new ColorDrawable(0);

  private static Drawable applyLeafRounding(Drawable paramDrawable, RoundingParams paramRoundingParams, Resources paramResources)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = (BitmapDrawable)paramDrawable;
      paramDrawable = new RoundedBitmapDrawable(paramResources, paramDrawable.getBitmap(), paramDrawable.getPaint());
      applyRoundingParams(paramDrawable, paramRoundingParams);
      return paramDrawable;
    }
    if (((paramDrawable instanceof ColorDrawable)) && (Build.VERSION.SDK_INT >= 11))
    {
      paramDrawable = RoundedColorDrawable.fromColorDrawable((ColorDrawable)paramDrawable);
      applyRoundingParams(paramDrawable, paramRoundingParams);
      return paramDrawable;
    }
    return paramDrawable;
  }

  static void applyRoundingParams(Rounded paramRounded, RoundingParams paramRoundingParams)
  {
    paramRounded.setCircle(paramRoundingParams.getRoundAsCircle());
    paramRounded.setRadii(paramRoundingParams.getCornersRadii());
    paramRounded.setBorder(paramRoundingParams.getBorderColor(), paramRoundingParams.getBorderWidth());
    paramRounded.setPadding(paramRoundingParams.getPadding());
  }

  static DrawableParent findDrawableParentForLeaf(DrawableParent paramDrawableParent)
  {
    while (true)
    {
      Drawable localDrawable = paramDrawableParent.getDrawable();
      if ((localDrawable == paramDrawableParent) || (!(localDrawable instanceof DrawableParent)))
        return paramDrawableParent;
      paramDrawableParent = (DrawableParent)localDrawable;
    }
  }

  static Drawable maybeApplyLeafRounding(@Nullable Drawable paramDrawable, @Nullable RoundingParams paramRoundingParams, Resources paramResources)
  {
    if ((paramDrawable == null) || (paramRoundingParams == null) || (paramRoundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.BITMAP_ONLY))
      return paramDrawable;
    if ((paramDrawable instanceof ForwardingDrawable))
    {
      DrawableParent localDrawableParent = findDrawableParentForLeaf((ForwardingDrawable)paramDrawable);
      localDrawableParent.setDrawable(applyLeafRounding(localDrawableParent.setDrawable(sEmptyDrawable), paramRoundingParams, paramResources));
      return paramDrawable;
    }
    return applyLeafRounding(paramDrawable, paramRoundingParams, paramResources);
  }

  @Nullable
  static Drawable maybeWrapWithMatrix(@Nullable Drawable paramDrawable, @Nullable Matrix paramMatrix)
  {
    if ((paramDrawable == null) || (paramMatrix == null))
      return paramDrawable;
    return new MatrixDrawable(paramDrawable, paramMatrix);
  }

  static Drawable maybeWrapWithRoundedOverlayColor(@Nullable Drawable paramDrawable, @Nullable RoundingParams paramRoundingParams)
  {
    if ((paramDrawable == null) || (paramRoundingParams == null) || (paramRoundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.OVERLAY_COLOR))
      return paramDrawable;
    paramDrawable = new RoundedCornersDrawable(paramDrawable);
    applyRoundingParams(paramDrawable, paramRoundingParams);
    paramDrawable.setOverlayColor(paramRoundingParams.getOverlayColor());
    return paramDrawable;
  }

  @Nullable
  static Drawable maybeWrapWithScaleType(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    return maybeWrapWithScaleType(paramDrawable, paramScaleType, null);
  }

  @Nullable
  static Drawable maybeWrapWithScaleType(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType, @Nullable PointF paramPointF)
  {
    if ((paramDrawable == null) || (paramScaleType == null));
    do
    {
      return paramDrawable;
      paramScaleType = new ScaleTypeDrawable(paramDrawable, paramScaleType);
      paramDrawable = paramScaleType;
    }
    while (paramPointF == null);
    paramScaleType.setFocusPoint(paramPointF);
    return paramScaleType;
  }

  static void resetRoundingParams(Rounded paramRounded)
  {
    paramRounded.setCircle(false);
    paramRounded.setRadius(0.0F);
    paramRounded.setBorder(0, 0.0F);
    paramRounded.setPadding(0.0F);
  }

  static void updateLeafRounding(DrawableParent paramDrawableParent, @Nullable RoundingParams paramRoundingParams, Resources paramResources)
  {
    paramDrawableParent = findDrawableParentForLeaf(paramDrawableParent);
    Drawable localDrawable = paramDrawableParent.getDrawable();
    if ((paramRoundingParams != null) && (paramRoundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY))
      if ((localDrawable instanceof Rounded))
        applyRoundingParams((Rounded)localDrawable, paramRoundingParams);
    do
    {
      do
        return;
      while (localDrawable == null);
      paramDrawableParent.setDrawable(sEmptyDrawable);
      paramDrawableParent.setDrawable(applyLeafRounding(localDrawable, paramRoundingParams, paramResources));
      return;
    }
    while (!(localDrawable instanceof Rounded));
    resetRoundingParams((Rounded)localDrawable);
  }

  static void updateOverlayColorRounding(DrawableParent paramDrawableParent, @Nullable RoundingParams paramRoundingParams)
  {
    Drawable localDrawable = paramDrawableParent.getDrawable();
    if ((paramRoundingParams != null) && (paramRoundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR))
      if ((localDrawable instanceof RoundedCornersDrawable))
      {
        paramDrawableParent = (RoundedCornersDrawable)localDrawable;
        applyRoundingParams(paramDrawableParent, paramRoundingParams);
        paramDrawableParent.setOverlayColor(paramRoundingParams.getOverlayColor());
      }
    do
    {
      return;
      paramDrawableParent.setDrawable(maybeWrapWithRoundedOverlayColor(paramDrawableParent.setDrawable(sEmptyDrawable), paramRoundingParams));
      return;
    }
    while (!(localDrawable instanceof RoundedCornersDrawable));
    paramDrawableParent.setDrawable(((RoundedCornersDrawable)localDrawable).setCurrent(sEmptyDrawable));
    sEmptyDrawable.setCallback(null);
  }

  static ScaleTypeDrawable wrapChildWithScaleType(DrawableParent paramDrawableParent, ScalingUtils.ScaleType paramScaleType)
  {
    paramScaleType = maybeWrapWithScaleType(paramDrawableParent.setDrawable(sEmptyDrawable), paramScaleType);
    paramDrawableParent.setDrawable(paramScaleType);
    Preconditions.checkNotNull(paramScaleType, "Parent has no child drawable!");
    return (ScaleTypeDrawable)paramScaleType;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.generic.WrappingUtils
 * JD-Core Version:    0.6.0
 */