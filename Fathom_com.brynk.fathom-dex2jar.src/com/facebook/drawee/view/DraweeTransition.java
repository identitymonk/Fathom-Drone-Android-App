package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.drawable.ScalingUtils.InterpolatingScaleType;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.util.Map;

@TargetApi(19)
public class DraweeTransition extends Transition
{
  private static final String PROPNAME_BOUNDS = "draweeTransition:bounds";
  private final ScalingUtils.ScaleType mFromScale;
  private final ScalingUtils.ScaleType mToScale;

  public DraweeTransition(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2)
  {
    this.mFromScale = paramScaleType1;
    this.mToScale = paramScaleType2;
  }

  private void captureValues(TransitionValues paramTransitionValues)
  {
    if ((paramTransitionValues.view instanceof GenericDraweeView))
      paramTransitionValues.values.put("draweeTransition:bounds", new Rect(0, 0, paramTransitionValues.view.getWidth(), paramTransitionValues.view.getHeight()));
  }

  public static TransitionSet createTransitionSet(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition(new ChangeBounds());
    localTransitionSet.addTransition(new DraweeTransition(paramScaleType1, paramScaleType2));
    return localTransitionSet;
  }

  public void captureEndValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }

  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }

  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 == null) || (paramTransitionValues2 == null));
    do
    {
      return null;
      paramViewGroup = (Rect)paramTransitionValues1.values.get("draweeTransition:bounds");
      paramTransitionValues2 = (Rect)paramTransitionValues2.values.get("draweeTransition:bounds");
    }
    while ((paramViewGroup == null) || (paramTransitionValues2 == null) || (this.mFromScale == this.mToScale));
    paramTransitionValues1 = (GenericDraweeView)paramTransitionValues1.view;
    paramViewGroup = new ScalingUtils.InterpolatingScaleType(this.mFromScale, this.mToScale, paramViewGroup, paramTransitionValues2);
    ((GenericDraweeHierarchy)paramTransitionValues1.getHierarchy()).setActualImageScaleType(paramViewGroup);
    paramTransitionValues2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramTransitionValues2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(paramViewGroup)
    {
      public void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
        this.val$scaleType.setValue(f);
      }
    });
    paramTransitionValues2.addListener(new AnimatorListenerAdapter(paramTransitionValues1)
    {
      public void onAnimationEnd(Animator paramAnimator)
      {
        ((GenericDraweeHierarchy)this.val$draweeView.getHierarchy()).setActualImageScaleType(DraweeTransition.this.mToScale);
      }
    });
    return paramTransitionValues2;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.view.DraweeTransition
 * JD-Core Version:    0.6.0
 */