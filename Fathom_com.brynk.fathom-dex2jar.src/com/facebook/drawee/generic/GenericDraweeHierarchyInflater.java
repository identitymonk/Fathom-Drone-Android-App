package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.R.styleable;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.infer.annotation.ReturnsOwnership;
import javax.annotation.Nullable;

public class GenericDraweeHierarchyInflater
{
  @Nullable
  private static Drawable getDrawable(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    paramInt = paramTypedArray.getResourceId(paramInt, 0);
    if (paramInt == 0)
      return null;
    return paramContext.getResources().getDrawable(paramInt);
  }

  @ReturnsOwnership
  private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder)
  {
    if (paramGenericDraweeHierarchyBuilder.getRoundingParams() == null)
      paramGenericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
    return paramGenericDraweeHierarchyBuilder.getRoundingParams();
  }

  @Nullable
  private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray paramTypedArray, int paramInt)
  {
    switch (paramTypedArray.getInt(paramInt, -2))
    {
    default:
      throw new RuntimeException("XML attribute not specified!");
    case -1:
      return null;
    case 0:
      return ScalingUtils.ScaleType.FIT_XY;
    case 1:
      return ScalingUtils.ScaleType.FIT_START;
    case 2:
      return ScalingUtils.ScaleType.FIT_CENTER;
    case 3:
      return ScalingUtils.ScaleType.FIT_END;
    case 4:
      return ScalingUtils.ScaleType.CENTER;
    case 5:
      return ScalingUtils.ScaleType.CENTER_INSIDE;
    case 6:
      return ScalingUtils.ScaleType.CENTER_CROP;
    case 7:
    }
    return ScalingUtils.ScaleType.FOCUS_CROP;
  }

  public static GenericDraweeHierarchyBuilder inflateBuilder(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return updateBuilder(new GenericDraweeHierarchyBuilder(paramContext.getResources()), paramContext, paramAttributeSet);
  }

  public static GenericDraweeHierarchy inflateHierarchy(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return inflateBuilder(paramContext, paramAttributeSet).build();
  }

  public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder paramGenericDraweeHierarchyBuilder, Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    int i = 0;
    int k = 0;
    int j = 0;
    int m = 0;
    boolean bool3 = true;
    boolean bool7 = true;
    boolean bool4 = true;
    boolean bool8 = true;
    boolean bool1 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool6 = true;
    if (paramAttributeSet != null)
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GenericDraweeHierarchy);
    while (true)
    {
      int n;
      int i2;
      try
      {
        int i1 = paramAttributeSet.getIndexCount();
        n = 0;
        j = m;
        bool4 = bool8;
        bool3 = bool7;
        bool2 = bool6;
        bool1 = bool5;
        i = k;
        k = n;
        if (k >= i1)
          break label1283;
        i2 = paramAttributeSet.getIndex(k);
        if (i2 != R.styleable.GenericDraweeHierarchy_actualImageScaleType)
          continue;
        paramGenericDraweeHierarchyBuilder.setActualImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
        break label1403;
        if (i2 == R.styleable.GenericDraweeHierarchy_placeholderImage)
        {
          paramGenericDraweeHierarchyBuilder.setPlaceholderImage(getDrawable(paramContext, paramAttributeSet, i2));
          m = i;
          bool5 = bool1;
          bool6 = bool2;
          bool7 = bool3;
          bool8 = bool4;
          n = j;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      if (i2 == R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage)
      {
        paramGenericDraweeHierarchyBuilder.setPressedStateOverlay(getDrawable(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_progressBarImage)
      {
        paramGenericDraweeHierarchyBuilder.setProgressBarImage(getDrawable(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_fadeDuration)
      {
        paramGenericDraweeHierarchyBuilder.setFadeDuration(paramAttributeSet.getInt(i2, 0));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_viewAspectRatio)
      {
        paramGenericDraweeHierarchyBuilder.setDesiredAspectRatio(paramAttributeSet.getFloat(i2, 0.0F));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_placeholderImageScaleType)
      {
        paramGenericDraweeHierarchyBuilder.setPlaceholderImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_retryImage)
      {
        paramGenericDraweeHierarchyBuilder.setRetryImage(getDrawable(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_retryImageScaleType)
      {
        paramGenericDraweeHierarchyBuilder.setRetryImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_failureImage)
      {
        paramGenericDraweeHierarchyBuilder.setFailureImage(getDrawable(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_failureImageScaleType)
      {
        paramGenericDraweeHierarchyBuilder.setFailureImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_progressBarImageScaleType)
      {
        paramGenericDraweeHierarchyBuilder.setProgressBarImageScaleType(getScaleTypeFromXml(paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval)
      {
        m = paramAttributeSet.getInteger(i2, i);
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_backgroundImage)
      {
        paramGenericDraweeHierarchyBuilder.setBackground(getDrawable(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_overlayImage)
      {
        paramGenericDraweeHierarchyBuilder.setOverlay(getDrawable(paramContext, paramAttributeSet, i2));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundAsCircle)
      {
        getRoundingParams(paramGenericDraweeHierarchyBuilder).setRoundAsCircle(paramAttributeSet.getBoolean(i2, false));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundedCornerRadius)
      {
        n = paramAttributeSet.getDimensionPixelSize(i2, j);
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundTopLeft)
      {
        bool7 = paramAttributeSet.getBoolean(i2, bool3);
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundTopRight)
      {
        bool8 = paramAttributeSet.getBoolean(i2, bool4);
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundBottomLeft)
      {
        bool5 = paramAttributeSet.getBoolean(i2, bool1);
        m = i;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundBottomRight)
      {
        bool6 = paramAttributeSet.getBoolean(i2, bool2);
        m = i;
        bool5 = bool1;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundWithOverlayColor)
      {
        getRoundingParams(paramGenericDraweeHierarchyBuilder).setOverlayColor(paramAttributeSet.getColor(i2, 0));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundingBorderWidth)
      {
        getRoundingParams(paramGenericDraweeHierarchyBuilder).setBorderWidth(paramAttributeSet.getDimensionPixelSize(i2, 0));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else if (i2 == R.styleable.GenericDraweeHierarchy_roundingBorderColor)
      {
        getRoundingParams(paramGenericDraweeHierarchyBuilder).setBorderColor(paramAttributeSet.getColor(i2, 0));
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
      }
      else
      {
        m = i;
        bool5 = bool1;
        bool6 = bool2;
        bool7 = bool3;
        bool8 = bool4;
        n = j;
        if (i2 == R.styleable.GenericDraweeHierarchy_roundingBorderPadding)
        {
          getRoundingParams(paramGenericDraweeHierarchyBuilder).setPadding(paramAttributeSet.getDimensionPixelSize(i2, 0));
          m = i;
          bool5 = bool1;
          bool6 = bool2;
          bool7 = bool3;
          bool8 = bool4;
          n = j;
          break label1403;
          label1283: paramAttributeSet.recycle();
          if ((paramGenericDraweeHierarchyBuilder.getProgressBarImage() != null) && (i > 0))
            paramGenericDraweeHierarchyBuilder.setProgressBarImage(new AutoRotateDrawable(paramGenericDraweeHierarchyBuilder.getProgressBarImage(), i));
          float f1;
          float f2;
          label1346: float f3;
          label1356: float f4;
          if (j > 0)
          {
            paramContext = getRoundingParams(paramGenericDraweeHierarchyBuilder);
            if (!bool3)
              break label1380;
            f1 = j;
            if (!bool4)
              break label1385;
            f2 = j;
            if (!bool2)
              break label1391;
            f3 = j;
            if (!bool1)
              break label1397;
            f4 = j;
          }
          while (true)
          {
            paramContext.setCornersRadii(f1, f2, f3, f4);
            return paramGenericDraweeHierarchyBuilder;
            label1380: f1 = 0.0F;
            break;
            label1385: f2 = 0.0F;
            break label1346;
            label1391: f3 = 0.0F;
            break label1356;
            label1397: f4 = 0.0F;
          }
        }
      }
      label1403: k += 1;
      i = m;
      bool1 = bool5;
      bool2 = bool6;
      bool3 = bool7;
      bool4 = bool8;
      j = n;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.generic.GenericDraweeHierarchyInflater
 * JD-Core Version:    0.6.0
 */