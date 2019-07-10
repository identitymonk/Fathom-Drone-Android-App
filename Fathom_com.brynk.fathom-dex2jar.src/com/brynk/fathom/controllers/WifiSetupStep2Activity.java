package com.brynk.fathom.controllers;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.brynk.fathom.helpers.Constants;
import com.brynk.fathom.helpers.WiFiHelper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;

public class WifiSetupStep2Activity extends AppCompatActivity
{
  private String DRONE_IP;
  private Boolean connectedToFathomNetwork = Boolean.valueOf(false);
  private Boolean isConnected;

  private void checkWifiStatus()
  {
    if (new WiFiHelper().isConnectedToFathomNetwork(getApplicationContext()))
      this.connectedToFathomNetwork = Boolean.valueOf(true);
  }

  public void goToNextStep(View paramView)
  {
    startActivity(new Intent(this, WifiSetupStep3Activity.class));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968613);
    this.DRONE_IP = new Constants().getDroneIp(getApplicationContext());
    Executors.newSingleThreadScheduledExecutor();
    getWindow().getDecorView().getRootView();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        ((ProgressBar)WifiSetupStep2Activity.this.findViewById(2131689628)).setVisibility(4);
        ((TextView)WifiSetupStep2Activity.this.findViewById(2131689684)).setVisibility(0);
        ((Button)WifiSetupStep2Activity.this.findViewById(2131689685)).setVisibility(0);
      }
    }
    , 1000L);
  }

  public class ConnectionStatusTask extends AsyncTask<String, Void, String>
  {
    private int COLOR_CONNECTED = -16711936;
    private int COLOR_NOT_CONNECTED = -65536;
    private String DRONE_IP;
    private String MESSAGE_CONNECTED = "Fathom One is connected";
    private String MESSAGE_NOT_CONNECTED = "Fathom One is offline";
    private String MESSAGE_WRONG_WIFI = "Please connect to the Fathom wifi network";
    private String statusMessageForUser = "";

    public ConnectionStatusTask(String arg2)
    {
      Object localObject;
      this.DRONE_IP = localObject;
    }

    private void reportStatus(String paramString, Boolean paramBoolean)
    {
      WifiSetupStep2Activity.access$202(WifiSetupStep2Activity.this, paramBoolean);
      this.statusMessageForUser = paramString;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      WifiSetupStep2Activity.this.checkWifiStatus();
      if (!WifiSetupStep2Activity.this.connectedToFathomNetwork.booleanValue())
      {
        reportStatus(this.MESSAGE_WRONG_WIFI, Boolean.valueOf(false));
        return this.statusMessageForUser;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = null;
      try
      {
        paramArrayOfString = new URL("http://" + this.DRONE_IP + "/");
        localObject1 = paramArrayOfString;
        paramArrayOfString = null;
      }
      catch (IOException localObject2)
      {
        try
        {
          localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
          paramArrayOfString = (String)localObject1;
          ((HttpURLConnection)localObject1).setConnectTimeout(3000);
          paramArrayOfString = (String)localObject1;
        }
        catch (IOException localObject2)
        {
          try
          {
            label105: localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
            while (true)
            {
              String str = ((BufferedReader)localObject1).readLine();
              if (str == null)
                break;
              localStringBuilder.append(str);
            }
          }
          catch (IOException localIOException2)
          {
            Log.e("FATHOM1", "Error reading input from URL");
            localIOException1.printStackTrace();
            reportStatus(this.MESSAGE_NOT_CONNECTED, Boolean.valueOf(false));
            while (true)
            {
              return this.statusMessageForUser;
              paramArrayOfString = paramArrayOfString;
              paramArrayOfString.printStackTrace();
              reportStatus(this.MESSAGE_NOT_CONNECTED, Boolean.valueOf(false));
              break;
              localIOException2 = localIOException2;
              Log.e("FATHOM1", "Error establishing URL connection");
              localIOException2.printStackTrace();
              reportStatus(this.MESSAGE_NOT_CONNECTED, Boolean.valueOf(false));
              break label105;
              reportStatus(this.MESSAGE_CONNECTED, Boolean.valueOf(true));
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
      if (WifiSetupStep2Activity.this.isConnected.booleanValue())
      {
        ((TextView)WifiSetupStep2Activity.this.findViewById(2131689684)).setVisibility(0);
        ((Button)WifiSetupStep2Activity.this.findViewById(2131689685)).setVisibility(0);
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.WifiSetupStep2Activity
 * JD-Core Version:    0.6.0
 */