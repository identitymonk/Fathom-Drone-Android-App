package com.brynk.fathom.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class Constants
{
  public static final String DEBUG_TAG = "FATHOM1";
  public static final Float DEFAULT_PITCH_MOD_PERCENT;
  public static final Float DEFAULT_THROTTLE_MOD_PERCENT;
  public static final String HOME_NETWORK_NAME = "ATT7DJQpi2";
  public static final String NETWORK_NAME = "Fathom";
  public static final String PREFS = "FATHOM_PREFS";
  public static final String PREFS_DRONE_IP = "drone_ip";
  public static final String PREFS_INVERT = "fathom_should_invert";
  public static final String PREFS_PITCH_MOD = "pitch_mod";
  public static final String PREFS_TEMPERATURE_CUTOFF = "temperature_cutoff";
  public static final String PREFS_THROTTLE_MOD = "throttle_mod";
  public static final Float SERVO_MAX = Float.valueOf(575.0F);
  public static final Float SERVO_MIN = Float.valueOf(175.0F);
  public static final Float SERVO_NEUTRAL = Float.valueOf((SERVO_MAX.floatValue() + SERVO_MIN.floatValue()) / 2.0F);
  public static final String TEST_NETWORK_NAME = "ALFA";
  public static final String TEST_NETWORK_NAME_TWO = "GR Makers";
  private String DEFAULT_DRONE_IP = "192.168.2.10";
  private String DEFAULT_TEMPERATURE_CUTOFF = "37";
  private String MOCK_DRONE_IP = "172.16.50.116";

  static
  {
    DEFAULT_THROTTLE_MOD_PERCENT = Float.valueOf(0.1F);
    DEFAULT_PITCH_MOD_PERCENT = Float.valueOf(0.15F);
  }

  private SharedPreferences.Editor buildEditor(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
  }

  public String getDroneIp(Context paramContext)
  {
    String str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("drone_ip", "-1");
    if (str.equals("-1"))
    {
      setDroneIp(paramContext, this.DEFAULT_DRONE_IP);
      paramContext = this.DEFAULT_DRONE_IP;
    }
    do
    {
      return paramContext;
      paramContext = str;
    }
    while (!str.equals(this.MOCK_DRONE_IP));
    return str;
  }

  public String getMockDroneIp(Context paramContext)
  {
    return this.MOCK_DRONE_IP;
  }

  public Float getPITCH_MOD_PERCENT(Context paramContext)
  {
    Float localFloat2 = Float.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getFloat("pitch_mod", -1.0F));
    Float localFloat1 = localFloat2;
    if (localFloat2.floatValue() == -1.0F)
    {
      setPITCH_MOD_PERCENT(paramContext, DEFAULT_PITCH_MOD_PERCENT);
      localFloat1 = DEFAULT_PITCH_MOD_PERCENT;
    }
    return localFloat1;
  }

  public Boolean getPrefsInvert(Context paramContext)
  {
    if (Float.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getFloat("fathom_should_invert", -1.0F)).floatValue() < 1.0F)
    {
      setPrefsInvert(paramContext, Float.valueOf(0.0F));
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }

  public Float getTHROTTLE_MOD_PERCENT(Context paramContext)
  {
    Float localFloat2 = Float.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getFloat("throttle_mod", -1.0F));
    Float localFloat1 = localFloat2;
    if (localFloat2.floatValue() == -1.0F)
    {
      setTHROTTLE_MOD_PERCENT(paramContext, DEFAULT_THROTTLE_MOD_PERCENT);
      localFloat1 = DEFAULT_THROTTLE_MOD_PERCENT;
    }
    return localFloat1;
  }

  public String getTemperatureCutoff(Context paramContext)
  {
    String str2 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("temperature_cutoff", "-1");
    String str1 = str2;
    if (str2.equals("-1"))
    {
      setTemperatureCutoff(paramContext, this.DEFAULT_TEMPERATURE_CUTOFF);
      str1 = this.DEFAULT_TEMPERATURE_CUTOFF;
    }
    return str1;
  }

  public void setDroneIp(Context paramContext, String paramString)
  {
    paramContext = buildEditor(paramContext);
    paramContext.putString("drone_ip", paramString);
    paramContext.commit();
  }

  public void setPITCH_MOD_PERCENT(Context paramContext, Float paramFloat)
  {
    paramContext = buildEditor(paramContext);
    paramContext.putFloat("pitch_mod", paramFloat.floatValue());
    paramContext.commit();
  }

  public void setPrefsInvert(Context paramContext, Float paramFloat)
  {
    paramContext = buildEditor(paramContext);
    paramContext.putFloat("fathom_should_invert", paramFloat.floatValue());
    paramContext.commit();
  }

  public void setTHROTTLE_MOD_PERCENT(Context paramContext, Float paramFloat)
  {
    paramContext = buildEditor(paramContext);
    paramContext.putFloat("throttle_mod", paramFloat.floatValue());
    paramContext.commit();
  }

  public void setTemperatureCutoff(Context paramContext, String paramString)
  {
    paramContext = buildEditor(paramContext);
    paramContext.putString("temperature_cutoff", paramString);
    paramContext.commit();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.helpers.Constants
 * JD-Core Version:    0.6.0
 */