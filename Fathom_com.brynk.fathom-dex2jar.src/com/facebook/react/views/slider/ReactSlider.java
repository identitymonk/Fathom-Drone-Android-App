package com.facebook.react.views.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import javax.annotation.Nullable;

public class ReactSlider extends SeekBar
{
  private static int DEFAULT_TOTAL_STEPS = 128;
  private double mMaxValue = 0.0D;
  private double mMinValue = 0.0D;
  private double mStep = 0.0D;
  private double mStepCalculated = 0.0D;
  private double mValue = 0.0D;

  public ReactSlider(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private double getStepValue()
  {
    if (this.mStep > 0.0D)
      return this.mStep;
    return this.mStepCalculated;
  }

  private int getTotalSteps()
  {
    return (int)Math.ceil((this.mMaxValue - this.mMinValue) / getStepValue());
  }

  private void updateAll()
  {
    if (this.mStep == 0.0D)
      this.mStepCalculated = ((this.mMaxValue - this.mMinValue) / DEFAULT_TOTAL_STEPS);
    setMax(getTotalSteps());
    updateValue();
  }

  private void updateValue()
  {
    setProgress((int)Math.round((this.mValue - this.mMinValue) / (this.mMaxValue - this.mMinValue) * getTotalSteps()));
  }

  void setMaxValue(double paramDouble)
  {
    this.mMaxValue = paramDouble;
    updateAll();
  }

  void setMinValue(double paramDouble)
  {
    this.mMinValue = paramDouble;
    updateAll();
  }

  void setStep(double paramDouble)
  {
    this.mStep = paramDouble;
    updateAll();
  }

  void setValue(double paramDouble)
  {
    this.mValue = paramDouble;
    updateValue();
  }

  public double toRealProgress(int paramInt)
  {
    if (paramInt == getMax())
      return this.mMaxValue;
    return paramInt * getStepValue() + this.mMinValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.slider.ReactSlider
 * JD-Core Version:    0.6.0
 */