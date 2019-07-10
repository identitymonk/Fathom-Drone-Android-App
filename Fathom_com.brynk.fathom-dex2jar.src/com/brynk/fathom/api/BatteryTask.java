package com.brynk.fathom.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BatteryTask extends AsyncTask<String, Void, String>
{
  private String DRONE_IP;
  private int VOLTAGE_MAX = 25535;
  private int VOLTAGE_MIN = 21785;
  private Context mContext;
  private View rootView;

  public BatteryTask(Context paramContext, View paramView, String paramString)
  {
    this.mContext = paramContext;
    this.rootView = paramView;
    this.DRONE_IP = paramString;
  }

  private double convertBatteryStatus(int paramInt)
  {
    double d = -1.0D;
    if (paramInt > 25016)
      d = 100.0D;
    do
    {
      return d;
      if (paramInt > 23807)
        return 75.0D;
      if (paramInt > 22819)
        return 50.0D;
      if (paramInt > 22158)
        return 25.0D;
      if (paramInt > 21961)
        return 10.0D;
    }
    while (paramInt <= 0);
    return 0.0D;
  }

  protected String doInBackground(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayOfString = null;
    try
    {
      localObject1 = new URL("http://" + this.DRONE_IP + "/battery?cutoff=21500");
      paramArrayOfString = (String)localObject1;
      localObject1 = null;
    }
    catch (IOException paramArrayOfString)
    {
      try
      {
        paramArrayOfString = (HttpURLConnection)paramArrayOfString.openConnection();
      }
      catch (IOException paramArrayOfString)
      {
        try
        {
          label57: Object localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
          while (true)
          {
            String str = ((BufferedReader)localObject1).readLine();
            if (str == null)
              break;
            localStringBuilder.append(str);
          }
        }
        catch (IOException localMalformedURLException)
        {
          Log.e("FATHOM1", "Error reading input from URL");
          localIOException.printStackTrace();
          while (true)
          {
            return localStringBuilder.toString();
            localMalformedURLException = localMalformedURLException;
            localMalformedURLException.printStackTrace();
            break;
            paramArrayOfString = paramArrayOfString;
            Log.e("FATHOM1", "Error establishing URL connection");
            paramArrayOfString.printStackTrace();
            paramArrayOfString = localMalformedURLException;
            break label57;
            paramArrayOfString.disconnect();
          }
        }
        finally
        {
          paramArrayOfString.disconnect();
        }
      }
    }
    throw localObject2;
  }

  protected void onPostExecute(String paramString)
  {
    int i = -1;
    int j = 2130837583;
    try
    {
      int k = Integer.parseInt(paramString);
      i = k;
      paramString = (ImageView)this.rootView.findViewById(2131689648);
      d = convertBatteryStatus(i);
      Log.d("FATHOM1", "BATTERY_STATUS: " + d);
      if (d > 74.0D)
      {
        i = 2130837584;
        paramString.setImageResource(i);
        return;
      }
    }
    catch (java.lang.NumberFormatException paramString)
    {
      while (true)
      {
        double d;
        Log.d("FATHOM1", "Unable to read battery status as a number");
        continue;
        if (d > 49.0D)
        {
          i = 2130837582;
          continue;
        }
        if (d > 24.0D)
        {
          i = 2130837581;
          continue;
        }
        if (d > 9.0D)
        {
          i = 2130837580;
          continue;
        }
        if (d >= 0.0D)
        {
          i = 2130837583;
          Toast.makeText(this.rootView.getContext(), "Low battery. The unit will shutdown soon.", 1).show();
          continue;
        }
        i = j;
        if (d >= 0.0D)
          continue;
        i = 2130837585;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.BatteryTask
 * JD-Core Version:    0.6.0
 */