package com.brynk.fathom.helpers;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import com.brynk.fathom.api.ThrusterTask;
import java.net.DatagramSocket;

public class ExternalDevice
{
  private String DRONE_IP;
  private CoordinateHelper ch;
  private Float controllerNeutral = Float.valueOf(0.00392163F);

  public ExternalDevice(String paramString, Context paramContext)
  {
    this.DRONE_IP = paramString;
    this.ch = new CoordinateHelper(paramContext);
  }

  private boolean isPanning(MotionEvent paramMotionEvent)
  {
    float f1 = Math.abs(Float.valueOf(paramMotionEvent.getAxisValue(1)).floatValue() - this.controllerNeutral.floatValue());
    float f2 = Math.abs(Float.valueOf(paramMotionEvent.getAxisValue(11)).floatValue() - this.controllerNeutral.floatValue());
    return (Float.valueOf(f1).floatValue() < 0.001D) && (Float.valueOf(f2).floatValue() > 0.001D);
  }

  private ThrusterTask setupThrusterTask(DatagramSocket paramDatagramSocket)
  {
    ThrusterTask localThrusterTask = new ThrusterTask();
    localThrusterTask.setDRONE_IP(this.DRONE_IP);
    localThrusterTask.setThruster_socket(paramDatagramSocket);
    return localThrusterTask;
  }

  public void changePitchMinAndMax(Float paramFloat)
  {
    this.ch.changePitchMinAndMax(paramFloat);
  }

  public void changeThrottleMinAndMax(Float paramFloat)
  {
    this.ch.changeThrottleMinAndMax(paramFloat);
  }

  public int mapExternalControllerThruster(Float paramFloat)
  {
    Float localFloat2 = Float.valueOf(0.00392163F);
    Float localFloat1 = Constants.SERVO_NEUTRAL;
    if (Math.abs(paramFloat.floatValue() - localFloat2.floatValue()) < 1.E-005D)
      localFloat1 = Constants.SERVO_NEUTRAL;
    while (true)
    {
      return Math.round(localFloat1.floatValue());
      if (paramFloat.floatValue() < localFloat2.floatValue())
      {
        localFloat1 = Float.valueOf(Math.abs(paramFloat.floatValue()) * (Constants.SERVO_MAX.floatValue() - Constants.SERVO_NEUTRAL.floatValue()) + Constants.SERVO_NEUTRAL.floatValue());
        continue;
      }
      if (paramFloat.floatValue() <= localFloat2.floatValue())
        continue;
      localFloat1 = Float.valueOf(Constants.SERVO_NEUTRAL.floatValue() - Math.abs(paramFloat.floatValue()) * (Constants.SERVO_NEUTRAL.floatValue() - Constants.SERVO_MIN.floatValue()));
    }
  }

  public void processCurrentEvent(MotionEvent paramMotionEvent, DatagramSocket paramDatagramSocket)
  {
    ThrusterTask localThrusterTask = setupThrusterTask(paramDatagramSocket);
    setupThrusterTask(paramDatagramSocket);
    paramDatagramSocket = this.ch.mapExternalYawToServo(Float.valueOf(paramMotionEvent.getAxisValue(11)), Boolean.valueOf(isPanning(paramMotionEvent)), 0.0F);
    String str = "" + this.ch.mapExternalControllerPitch(Float.valueOf(paramMotionEvent.getAxisValue(14)));
    paramMotionEvent = "EXTERNAL," + this.ch.mapExternalControllerThruster(Float.valueOf(paramMotionEvent.getAxisValue(1))) + "," + paramDatagramSocket + "," + str;
    Log.d("FATHOM1", paramMotionEvent);
    localThrusterTask.execute(new String[] { paramMotionEvent });
  }

  public void processHistoricalEvents(MotionEvent paramMotionEvent, DatagramSocket paramDatagramSocket)
  {
    int j = paramMotionEvent.getHistorySize();
    paramMotionEvent.getDevice();
    int i = 0;
    while (i < j)
    {
      paramDatagramSocket = this.ch.mapExternalYawToServo(Float.valueOf(paramMotionEvent.getAxisValue(11)), Boolean.valueOf(isPanning(paramMotionEvent)), 0.0F);
      String str = "" + this.ch.mapExternalControllerPitch(Float.valueOf(paramMotionEvent.getAxisValue(14)));
      new StringBuilder().append("EXTERNAL,").append(this.ch.mapExternalControllerThruster(Float.valueOf(paramMotionEvent.getAxisValue(1)))).append(",").append(paramDatagramSocket).append(",").append(str).toString();
      i += 1;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.helpers.ExternalDevice
 * JD-Core Version:    0.6.0
 */