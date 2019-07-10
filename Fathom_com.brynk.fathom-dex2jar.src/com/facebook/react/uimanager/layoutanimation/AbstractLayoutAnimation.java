package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.Map;
import javax.annotation.Nullable;

abstract class AbstractLayoutAnimation
{
  private static final Map<InterpolatorType, Interpolator> INTERPOLATOR = MapBuilder.of(InterpolatorType.LINEAR, new LinearInterpolator(), InterpolatorType.EASE_IN, new AccelerateInterpolator(), InterpolatorType.EASE_OUT, new DecelerateInterpolator(), InterpolatorType.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator(), InterpolatorType.SPRING, new SimpleSpringInterpolator());
  private static final boolean SLOWDOWN_ANIMATION_MODE = false;

  @Nullable
  protected AnimatedPropertyType mAnimatedProperty;
  private int mDelayMs;
  protected int mDurationMs;

  @Nullable
  private Interpolator mInterpolator;

  private static Interpolator getInterpolator(InterpolatorType paramInterpolatorType)
  {
    Interpolator localInterpolator = (Interpolator)INTERPOLATOR.get(paramInterpolatorType);
    if (localInterpolator == null)
      throw new IllegalArgumentException("Missing interpolator for type : " + paramInterpolatorType);
    return localInterpolator;
  }

  @Nullable
  public final Animation createAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!isValid())
      paramView = null;
    Animation localAnimation;
    do
    {
      return paramView;
      localAnimation = createAnimationImpl(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      paramView = localAnimation;
    }
    while (localAnimation == null);
    localAnimation.setDuration(this.mDurationMs * 1);
    localAnimation.setStartOffset(this.mDelayMs * 1);
    localAnimation.setInterpolator(this.mInterpolator);
    return localAnimation;
  }

  @Nullable
  abstract Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public void initializeFromConfig(ReadableMap paramReadableMap, int paramInt)
  {
    AnimatedPropertyType localAnimatedPropertyType;
    if (paramReadableMap.hasKey("property"))
    {
      localAnimatedPropertyType = AnimatedPropertyType.fromString(paramReadableMap.getString("property"));
      this.mAnimatedProperty = localAnimatedPropertyType;
      if (paramReadableMap.hasKey("duration"))
        paramInt = paramReadableMap.getInt("duration");
      this.mDurationMs = paramInt;
      if (!paramReadableMap.hasKey("delay"))
        break label104;
    }
    label104: for (paramInt = paramReadableMap.getInt("delay"); ; paramInt = 0)
    {
      this.mDelayMs = paramInt;
      if (paramReadableMap.hasKey("type"))
        break label109;
      throw new IllegalArgumentException("Missing interpolation type.");
      localAnimatedPropertyType = null;
      break;
    }
    label109: this.mInterpolator = getInterpolator(InterpolatorType.fromString(paramReadableMap.getString("type")));
    if (!isValid())
      throw new IllegalViewOperationException("Invalid layout animation : " + paramReadableMap);
  }

  abstract boolean isValid();

  public void reset()
  {
    this.mAnimatedProperty = null;
    this.mDurationMs = 0;
    this.mDelayMs = 0;
    this.mInterpolator = null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
 * JD-Core Version:    0.6.0
 */