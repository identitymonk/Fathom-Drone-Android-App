package com.facebook.react.common;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.infer.annotation.Assertions;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class ShakeDetector
  implements SensorEventListener
{
  private static final long MIN_TIME_BETWEEN_SAMPLES_NS = TimeUnit.NANOSECONDS.convert(20L, TimeUnit.MILLISECONDS);
  private static final float REQUIRED_FORCE = 13.042845F;
  private static final float SHAKING_WINDOW_NS = (float)TimeUnit.NANOSECONDS.convert(3L, TimeUnit.SECONDS);
  private float mAccelerationX;
  private float mAccelerationY;
  private float mAccelerationZ;
  private long mLastShakeTimestamp;
  private long mLastTimestamp;
  private int mMinNumShakes;
  private int mNumShakes;

  @Nullable
  private SensorManager mSensorManager;
  private final ShakeListener mShakeListener;

  public ShakeDetector(ShakeListener paramShakeListener)
  {
    this(paramShakeListener, 1);
  }

  public ShakeDetector(ShakeListener paramShakeListener, int paramInt)
  {
    this.mShakeListener = paramShakeListener;
    this.mMinNumShakes = paramInt;
  }

  private boolean atLeastRequiredForce(float paramFloat)
  {
    return Math.abs(paramFloat) > 13.042845F;
  }

  private void maybeDispatchShake(long paramLong)
  {
    if (this.mNumShakes >= this.mMinNumShakes * 8)
    {
      reset();
      this.mShakeListener.onShake();
    }
    if ((float)(paramLong - this.mLastShakeTimestamp) > SHAKING_WINDOW_NS)
      reset();
  }

  private void recordShake(long paramLong)
  {
    this.mLastShakeTimestamp = paramLong;
    this.mNumShakes += 1;
  }

  private void reset()
  {
    this.mNumShakes = 0;
    this.mAccelerationX = 0.0F;
    this.mAccelerationY = 0.0F;
    this.mAccelerationZ = 0.0F;
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.timestamp - this.mLastTimestamp < MIN_TIME_BETWEEN_SAMPLES_NS)
      return;
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2] - 9.80665F;
    this.mLastTimestamp = paramSensorEvent.timestamp;
    if ((atLeastRequiredForce(f1)) && (this.mAccelerationX * f1 <= 0.0F))
    {
      recordShake(paramSensorEvent.timestamp);
      this.mAccelerationX = f1;
    }
    while (true)
    {
      maybeDispatchShake(paramSensorEvent.timestamp);
      return;
      if ((atLeastRequiredForce(f2)) && (this.mAccelerationY * f2 <= 0.0F))
      {
        recordShake(paramSensorEvent.timestamp);
        this.mAccelerationY = f2;
        continue;
      }
      if ((!atLeastRequiredForce(f3)) || (this.mAccelerationZ * f3 > 0.0F))
        continue;
      recordShake(paramSensorEvent.timestamp);
      this.mAccelerationZ = f3;
    }
  }

  public void start(SensorManager paramSensorManager)
  {
    Assertions.assertNotNull(paramSensorManager);
    Sensor localSensor = paramSensorManager.getDefaultSensor(1);
    if (localSensor != null)
    {
      this.mSensorManager = paramSensorManager;
      this.mLastTimestamp = -1L;
      this.mSensorManager.registerListener(this, localSensor, 2);
      this.mLastShakeTimestamp = 0L;
      reset();
    }
  }

  public void stop()
  {
    if (this.mSensorManager != null)
    {
      this.mSensorManager.unregisterListener(this);
      this.mSensorManager = null;
    }
  }

  public static abstract interface ShakeListener
  {
    public abstract void onShake();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.common.ShakeDetector
 * JD-Core Version:    0.6.0
 */