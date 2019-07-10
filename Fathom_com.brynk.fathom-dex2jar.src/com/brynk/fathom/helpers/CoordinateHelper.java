package com.brynk.fathom.helpers;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class CoordinateHelper
{
  private Float EXTERNAL_NEUTRAL = Float.valueOf(0.00392163F);
  private Context context;
  private Float pitch_max;
  private Float pitch_min;
  private Float throttle_max;
  private Float throttle_min;

  public CoordinateHelper(Context paramContext)
  {
    this.context = paramContext;
    setupMaxAndMinThrottle(paramContext);
  }

  private void setupMaxAndMinThrottle(Context paramContext)
  {
    Float localFloat = Float.valueOf(Float.valueOf((Constants.SERVO_MAX.floatValue() - Constants.SERVO_MIN.floatValue()) * new Constants().getTHROTTLE_MOD_PERCENT(paramContext).floatValue()).floatValue() / 2.0F);
    this.throttle_max = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() + localFloat.floatValue());
    this.throttle_min = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - localFloat.floatValue());
    paramContext = Float.valueOf(Float.valueOf((Constants.SERVO_MAX.floatValue() - Constants.SERVO_MIN.floatValue()) * new Constants().getPITCH_MOD_PERCENT(paramContext).floatValue()).floatValue() / 2.0F);
    this.pitch_max = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() + paramContext.floatValue());
    this.pitch_min = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - paramContext.floatValue());
  }

  public ArrayList boundCoord(MotionEvent paramMotionEvent, TextView paramTextView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Float.valueOf(paramMotionEvent.getRawX()));
    localArrayList.add(Float.valueOf(paramMotionEvent.getRawY()));
    Float localFloat1 = Float.valueOf(paramTextView.getX() + paramTextView.getWidth());
    Float localFloat2 = Float.valueOf(paramTextView.getX());
    Float localFloat3 = Float.valueOf(paramTextView.getY());
    paramTextView = Float.valueOf(paramTextView.getY() + paramTextView.getHeight());
    if (paramMotionEvent.getRawX() > localFloat1.floatValue())
      localArrayList.set(0, localFloat1);
    if (paramMotionEvent.getRawX() < localFloat2.floatValue())
      localArrayList.set(0, localFloat2);
    if (paramMotionEvent.getRawY() < localFloat3.floatValue())
      localArrayList.set(1, localFloat3);
    if (paramMotionEvent.getRawY() > paramTextView.floatValue())
      localArrayList.set(1, paramTextView);
    return localArrayList;
  }

  public ArrayList boundCoordInRelativeLayout(MotionEvent paramMotionEvent, RelativeLayout paramRelativeLayout)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Float.valueOf(paramMotionEvent.getRawX()));
    localArrayList.add(Float.valueOf(paramMotionEvent.getRawY()));
    Float localFloat1 = Float.valueOf(paramRelativeLayout.getX() + paramRelativeLayout.getWidth());
    Float localFloat2 = Float.valueOf(paramRelativeLayout.getX());
    Float localFloat3 = Float.valueOf(paramRelativeLayout.getY());
    paramRelativeLayout = Float.valueOf(paramRelativeLayout.getY() + paramRelativeLayout.getHeight());
    if (paramMotionEvent.getRawX() > localFloat1.floatValue())
      localArrayList.set(0, localFloat1);
    if (paramMotionEvent.getRawX() < localFloat2.floatValue())
      localArrayList.set(0, localFloat2);
    if (paramMotionEvent.getRawY() < localFloat3.floatValue())
      localArrayList.set(1, localFloat3);
    if (paramMotionEvent.getRawY() > paramRelativeLayout.floatValue())
      localArrayList.set(1, paramRelativeLayout);
    return localArrayList;
  }

  public ArrayList boundCoordInTextView(MotionEvent paramMotionEvent, TextView paramTextView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Float.valueOf(paramMotionEvent.getRawX()));
    localArrayList.add(Float.valueOf(paramMotionEvent.getRawY()));
    Float localFloat1 = Float.valueOf(paramTextView.getX() + paramTextView.getWidth());
    Float localFloat2 = Float.valueOf(paramTextView.getX());
    Float localFloat3 = Float.valueOf(paramTextView.getY());
    paramTextView = Float.valueOf(paramTextView.getY() + paramTextView.getHeight());
    if (paramMotionEvent.getRawX() > localFloat1.floatValue())
      localArrayList.set(0, localFloat1);
    if (paramMotionEvent.getRawX() < localFloat2.floatValue())
      localArrayList.set(0, localFloat2);
    if (paramMotionEvent.getRawY() < localFloat3.floatValue())
      localArrayList.set(1, localFloat3);
    if (paramMotionEvent.getRawY() > paramTextView.floatValue())
      localArrayList.set(1, paramTextView);
    return localArrayList;
  }

  public Float boundPitch(MotionEvent paramMotionEvent, TextView paramTextView, Boolean paramBoolean, float paramFloat)
  {
    Float localFloat2 = Float.valueOf(paramMotionEvent.getRawY());
    Float localFloat3 = Float.valueOf(paramTextView.getY());
    Float localFloat1 = Float.valueOf(paramTextView.getY() + paramTextView.getHeight());
    float f1 = localFloat1.floatValue();
    float f2 = paramTextView.getHeight() / 2;
    if (Math.abs(Float.valueOf(paramMotionEvent.getRawY() - Float.valueOf(f1 - f2).floatValue()).floatValue()) < paramFloat)
    {
      paramTextView = Constants.SERVO_NEUTRAL;
      return paramTextView;
    }
    paramMotionEvent = localFloat2;
    if (localFloat2.floatValue() > localFloat1.floatValue())
      paramMotionEvent = localFloat1;
    if (localFloat2.floatValue() < localFloat3.floatValue())
      paramMotionEvent = localFloat3;
    paramFloat = Float.valueOf(localFloat1.floatValue() - paramMotionEvent.floatValue()).floatValue() / paramTextView.getHeight();
    paramTextView = Float.valueOf((this.pitch_max.floatValue() - this.pitch_min.floatValue()) * Float.valueOf(paramFloat).floatValue() + this.pitch_min.floatValue());
    paramMotionEvent = paramTextView;
    if (paramBoolean.booleanValue())
    {
      paramMotionEvent = Float.valueOf(Math.abs(paramTextView.floatValue() - Constants.SERVO_NEUTRAL.floatValue()));
      if (paramTextView.floatValue() <= Constants.SERVO_NEUTRAL.floatValue())
        break label267;
    }
    label267: for (paramMotionEvent = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - paramMotionEvent.floatValue()); ; paramMotionEvent = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() + paramMotionEvent.floatValue()))
    {
      paramTextView = paramMotionEvent;
      if (paramMotionEvent.floatValue() <= 365.0F)
        break;
      paramTextView = paramMotionEvent;
      if (paramMotionEvent.floatValue() >= 385.0F)
        break;
      return Constants.SERVO_NEUTRAL;
    }
  }

  public Float boundThruster(MotionEvent paramMotionEvent, TextView paramTextView, Boolean paramBoolean, float paramFloat)
  {
    Float localFloat2 = Float.valueOf(paramMotionEvent.getRawY());
    Float localFloat3 = Float.valueOf(paramTextView.getY());
    Float localFloat1 = Float.valueOf(paramTextView.getY() + paramTextView.getHeight());
    float f1 = localFloat1.floatValue();
    float f2 = paramTextView.getHeight() / 2;
    if (Math.abs(Float.valueOf(paramMotionEvent.getRawY() - Float.valueOf(f1 - f2).floatValue()).floatValue()) < paramFloat)
    {
      paramTextView = Constants.SERVO_NEUTRAL;
      return paramTextView;
    }
    paramMotionEvent = localFloat2;
    if (localFloat2.floatValue() > localFloat1.floatValue())
      paramMotionEvent = localFloat1;
    if (localFloat2.floatValue() < localFloat3.floatValue())
      paramMotionEvent = localFloat3;
    paramFloat = Float.valueOf(localFloat1.floatValue() - paramMotionEvent.floatValue()).floatValue() / paramTextView.getHeight();
    paramTextView = Float.valueOf((this.throttle_max.floatValue() - this.throttle_min.floatValue()) * Float.valueOf(paramFloat).floatValue() + this.throttle_min.floatValue());
    paramMotionEvent = paramTextView;
    if (paramBoolean.booleanValue())
    {
      paramMotionEvent = Float.valueOf(Math.abs(paramTextView.floatValue() - Constants.SERVO_NEUTRAL.floatValue()));
      if (paramTextView.floatValue() <= Constants.SERVO_NEUTRAL.floatValue())
        break label267;
    }
    label267: for (paramMotionEvent = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - paramMotionEvent.floatValue()); ; paramMotionEvent = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() + paramMotionEvent.floatValue()))
    {
      paramTextView = paramMotionEvent;
      if (paramMotionEvent.floatValue() <= 365.0F)
        break;
      paramTextView = paramMotionEvent;
      if (paramMotionEvent.floatValue() >= 385.0F)
        break;
      return Constants.SERVO_NEUTRAL;
    }
  }

  public Float boundThrusterTick(Float paramFloat, TextView paramTextView)
  {
    Float localFloat1 = Float.valueOf(paramTextView.getY());
    Float localFloat2 = Float.valueOf(paramTextView.getY() + paramTextView.getHeight());
    paramTextView = paramFloat;
    if (paramFloat.floatValue() > localFloat2.floatValue())
      paramTextView = localFloat2;
    if (paramFloat.floatValue() < localFloat1.floatValue())
      paramTextView = localFloat1;
    return paramTextView;
  }

  public void changePitchMinAndMax(Float paramFloat)
  {
    paramFloat = Float.valueOf(Float.valueOf((Constants.SERVO_MAX.floatValue() - Constants.SERVO_MIN.floatValue()) * paramFloat.floatValue()).floatValue() / 2.0F);
    this.pitch_max = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() + paramFloat.floatValue());
    this.pitch_min = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - paramFloat.floatValue());
    Log.d("FATHOM1", "MAX:" + this.pitch_max + ",MIN:" + this.pitch_min);
  }

  public void changeThrottleMinAndMax(Float paramFloat)
  {
    paramFloat = Float.valueOf(Float.valueOf((Constants.SERVO_MAX.floatValue() - Constants.SERVO_MIN.floatValue()) * paramFloat.floatValue()).floatValue() / 2.0F);
    this.throttle_max = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() + paramFloat.floatValue());
    this.throttle_min = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - paramFloat.floatValue());
  }

  public Float getThrusterNeutral()
  {
    return Constants.SERVO_NEUTRAL;
  }

  public int mapExternalControllerPitch(Float paramFloat)
  {
    Float localFloat2 = Float.valueOf(0.00392163F);
    float f1 = this.pitch_max.floatValue();
    float f2 = Constants.SERVO_NEUTRAL.floatValue();
    float f3 = Constants.SERVO_NEUTRAL.floatValue();
    float f4 = this.pitch_min.floatValue();
    Float localFloat1 = Constants.SERVO_NEUTRAL;
    if (Math.abs(paramFloat.floatValue() - localFloat2.floatValue()) < 1.E-005D)
      localFloat1 = Constants.SERVO_NEUTRAL;
    while (true)
    {
      return Math.round(localFloat1.floatValue());
      if (paramFloat.floatValue() < localFloat2.floatValue())
      {
        localFloat1 = Float.valueOf(Math.abs(paramFloat.floatValue()) * Float.valueOf(f1 - f2).floatValue() + Constants.SERVO_NEUTRAL.floatValue());
        continue;
      }
      if (paramFloat.floatValue() <= localFloat2.floatValue())
        continue;
      localFloat1 = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - Math.abs(paramFloat.floatValue()) * Float.valueOf(f3 - f4).floatValue());
    }
  }

  public int mapExternalControllerThruster(Float paramFloat)
  {
    Float localFloat2 = Float.valueOf(0.00392163F);
    float f1 = this.throttle_max.floatValue();
    float f2 = Constants.SERVO_NEUTRAL.floatValue();
    float f3 = Constants.SERVO_NEUTRAL.floatValue();
    float f4 = this.throttle_min.floatValue();
    Float localFloat1 = Constants.SERVO_NEUTRAL;
    if (Math.abs(paramFloat.floatValue() - localFloat2.floatValue()) < 1.E-005D)
      localFloat1 = Constants.SERVO_NEUTRAL;
    while (true)
    {
      return Math.round(localFloat1.floatValue());
      if (paramFloat.floatValue() < localFloat2.floatValue())
      {
        localFloat1 = Float.valueOf(Math.abs(paramFloat.floatValue()) * Float.valueOf(f1 - f2).floatValue() + Constants.SERVO_NEUTRAL.floatValue());
        continue;
      }
      if (paramFloat.floatValue() <= localFloat2.floatValue())
        continue;
      localFloat1 = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - Math.abs(paramFloat.floatValue()) * Float.valueOf(f3 - f4).floatValue());
    }
  }

  public String mapExternalYawToServo(Float paramFloat, Boolean paramBoolean, float paramFloat1)
  {
    Float localFloat1 = Float.valueOf(1.0F);
    Object localObject2 = Float.valueOf(1.0F);
    Float localFloat2 = Float.valueOf(Math.abs(paramFloat.floatValue()));
    Object localObject1;
    if (paramFloat.floatValue() > this.EXTERNAL_NEUTRAL.floatValue())
      localObject1 = Float.valueOf(Math.abs(1.0F - localFloat2.floatValue()));
    while (true)
    {
      localObject2 = localFloat1;
      paramFloat = (Float)localObject1;
      if (paramBoolean.booleanValue())
      {
        paramBoolean = localFloat1;
        if (localFloat1.floatValue() < 1.0F)
          paramBoolean = Float.valueOf(0.0F - ((Float)localObject1).floatValue());
        paramFloat = (Float)localObject1;
        if (((Float)localObject1).floatValue() < 1.0F)
          paramFloat = Float.valueOf(0.0F - paramBoolean.floatValue());
        Log.d("FATHOM1", "PANNING");
        localObject2 = paramBoolean;
      }
      if (localFloat2.floatValue() < paramFloat1)
      {
        localObject2 = Float.valueOf(1.0F);
        paramFloat = Float.valueOf(1.0F);
      }
      return localObject2 + "," + paramFloat;
      localObject1 = localObject2;
      if (paramFloat.floatValue() >= this.EXTERNAL_NEUTRAL.floatValue())
        continue;
      localFloat1 = Float.valueOf(Math.abs(1.0F - localFloat2.floatValue()));
      localObject1 = localObject2;
    }
  }

  public String mapYawToServo(Float paramFloat, TextView paramTextView, Boolean paramBoolean, float paramFloat1)
  {
    Float localFloat1 = Float.valueOf(1.0F);
    Object localObject = Float.valueOf(1.0F);
    Float localFloat4 = Float.valueOf(paramTextView.getX() + paramTextView.getWidth());
    float f1 = paramTextView.getX();
    Float localFloat2 = Float.valueOf(paramTextView.getX() + paramTextView.getWidth() / 2);
    Float localFloat3 = Float.valueOf(localFloat4.floatValue() - localFloat2.floatValue());
    float f2 = paramFloat.floatValue();
    float f3 = localFloat2.floatValue();
    if (paramFloat.floatValue() > localFloat2.floatValue())
      paramTextView = Float.valueOf((localFloat4.floatValue() - paramFloat.floatValue()) / localFloat3.floatValue());
    while (true)
    {
      localObject = localFloat1;
      paramFloat = paramTextView;
      if (paramBoolean.booleanValue())
      {
        paramBoolean = localFloat1;
        if (localFloat1.floatValue() < 1.0F)
          paramBoolean = Float.valueOf(0.0F - paramTextView.floatValue());
        paramFloat = paramTextView;
        if (paramTextView.floatValue() < 1.0F)
          paramFloat = Float.valueOf(0.0F - paramBoolean.floatValue());
        Log.d("FATHOM1", "PANNING");
        localObject = paramBoolean;
      }
      if (Math.abs(Float.valueOf(f2 - f3).floatValue()) < paramFloat1)
      {
        localObject = Float.valueOf(1.0F);
        paramFloat = Float.valueOf(1.0F);
      }
      return localObject + "," + paramFloat;
      paramTextView = (TextView)localObject;
      if (paramFloat.floatValue() >= localFloat2.floatValue())
        continue;
      localFloat1 = Float.valueOf((paramFloat.floatValue() - Float.valueOf(f1).floatValue()) / localFloat3.floatValue());
      paramTextView = (TextView)localObject;
    }
  }

  public void setThrottle_max(Float paramFloat)
  {
    this.throttle_min = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - paramFloat.floatValue());
  }

  public void setThrottle_min(Float paramFloat)
  {
    this.throttle_max = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() + paramFloat.floatValue());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.helpers.CoordinateHelper
 * JD-Core Version:    0.6.0
 */