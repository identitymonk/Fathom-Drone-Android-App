package com.brynk.fathom.controllers;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.brynk.fathom.helpers.Constants;
import com.brynk.fathom.helpers.WiFiHelper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LobbyActivity extends AppCompatActivity
{
  private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;
  private String DRONE_IP;
  private Boolean connectedToFathomNetwork = Boolean.valueOf(false);
  private ScheduledExecutorService exec = null;
  private Boolean isConnected = Boolean.valueOf(false);
  private double phone_latitude = -1.0D;
  private double phone_longitude = -1.0D;

  private void checkWifiStatus()
  {
    if (new WiFiHelper().isConnectedToFathomNetwork(getApplicationContext()))
      this.connectedToFathomNetwork = Boolean.valueOf(true);
  }

  private void setLocation(Location paramLocation)
  {
    if (paramLocation != null)
    {
      this.phone_longitude = paramLocation.getLongitude();
      this.phone_latitude = paramLocation.getLatitude();
      return;
    }
    this.phone_longitude = -1.0D;
    this.phone_latitude = -1.0D;
  }

  public void goToCalibrateScreen(View paramView)
  {
    startActivity(new Intent(this, SettingsActivity.class));
  }

  public void goToFlightRecordScreen(View paramView)
  {
    startActivity(new Intent(this, DivelogActivity.class));
  }

  public void goToObserverScreen(View paramView)
  {
    if (!this.isConnected.booleanValue())
    {
      Toast.makeText(getApplicationContext(), "Fathom One is offline.", 1).show();
      return;
    }
    startActivity(new Intent(this, ReactObserverActivity.class));
  }

  public void goToPilotScreen(View paramView)
  {
    if (!this.isConnected.booleanValue())
      Toast.makeText(getApplicationContext(), "Fathom One is offline.", 1).show();
    paramView = new LatLongTask(this.DRONE_IP, getApplicationContext());
    paramView.setPhone_longitude(this.phone_longitude);
    paramView.setPhone_latitude(this.phone_latitude);
    paramView.execute(new String[0]);
    paramView = new Intent(this, ReactActivity.class);
    paramView.putExtra("PHONE_LATITUDE", "" + this.phone_latitude);
    paramView.putExtra("PHONE_LONGITUDE", "" + this.phone_longitude);
    startActivity(paramView);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968605);
    setSupportActionBar((Toolbar)findViewById(2131689681));
    this.DRONE_IP = new Constants().getDroneIp(getApplicationContext());
    new Constants().getMockDroneIp(getApplicationContext());
    Log.v("FATHOM1", this.DRONE_IP);
    ((FloatingActionButton)findViewById(2131689635)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        Snackbar.make(paramView, "Have a question? Contact hello@fathomdrone.com", 0).setAction("Action", null).show();
      }
    });
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
      {
        ActivityCompat.requestPermissions(this, new String[] { "android.permission.ACCESS_COARSE_LOCATION" }, 1);
        return;
      }
      getApplicationContext();
      setLocation(((LocationManager)getSystemService("location")).getLastKnownLocation("gps"));
      return;
    }
    getApplicationContext();
    setLocation(((LocationManager)getSystemService("location")).getLastKnownLocation("gps"));
  }

  public void onPause()
  {
    super.onPause();
    this.exec.shutdownNow();
  }

  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
    }
    if ((paramArrayOfInt[0] == 0) && (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0))
    {
      Log.d("FATHOM1", "coarse location permission granted");
      getApplicationContext();
      setLocation(((LocationManager)getSystemService("location")).getLastKnownLocation("gps"));
      return;
    }
    paramArrayOfString = new AlertDialog.Builder(this);
    paramArrayOfString.setTitle("Functionality limited");
    paramArrayOfString.setMessage("Since location access has not been granted, this app will not be able to discover beacons when in the background.");
    paramArrayOfString.setPositiveButton(17039370, null);
    paramArrayOfString.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramDialogInterface)
      {
      }
    });
    paramArrayOfString.show();
  }

  public void onStart()
  {
    super.onStart();
    this.exec = Executors.newSingleThreadScheduledExecutor();
    getWindow().getDecorView().getRootView();
    this.exec.scheduleAtFixedRate(new Runnable()
    {
      public void run()
      {
        new LobbyActivity.ConnectionStatusTask(LobbyActivity.this, LobbyActivity.this.DRONE_IP).execute(new String[] { "" });
      }
    }
    , 0L, 3L, TimeUnit.SECONDS);
  }

  private class CameraTask extends AsyncTask<String, Void, String>
  {
    private String DRONE_IP;
    private Context mContext;
    private double phone_latitude = -1.0D;
    private double phone_longitude = -1.0D;

    public CameraTask(String paramContext, Context arg3)
    {
      this.DRONE_IP = paramContext;
      Object localObject;
      this.mContext = localObject;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      paramArrayOfString = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      Object localObject = new DisplayMetrics();
      paramArrayOfString.getMetrics((DisplayMetrics)localObject);
      int m = ((DisplayMetrics)localObject).widthPixels;
      int k = ((DisplayMetrics)localObject).heightPixels;
      int i = m;
      int j = k;
      if (m > k)
      {
        j = m;
        i = k;
      }
      double d = j / i;
      k = i;
      if (i > 360)
      {
        k = 360;
        j = Double.valueOf(360 * d).intValue();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject = new WiFiHelper().getIPAddress(LobbyActivity.this.getApplicationContext());
        localObject = new URL("http://" + this.DRONE_IP + "/camera/start?ip=" + (String)localObject + "&lat=" + this.phone_latitude + "&longitude=" + this.phone_longitude + "&h=" + k + "&w=" + j);
        paramArrayOfString = (String)localObject;
        try
        {
          paramArrayOfString = (HttpURLConnection)paramArrayOfString.openConnection();
          localObject = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
          while (true)
          {
            String str = ((BufferedReader)localObject).readLine();
            if (str == null)
              break;
            localStringBuilder.append(str);
          }
        }
        catch (IOException paramArrayOfString)
        {
          Log.e("FATHOM1", "Error establishing URL connection");
          paramArrayOfString.printStackTrace();
        }
        return "TODO";
      }
      catch (MalformedURLException localMalformedURLException)
      {
        while (true)
        {
          localMalformedURLException.printStackTrace();
          continue;
          paramArrayOfString.disconnect();
          System.out.println(localStringBuilder.toString());
          Log.v("FATHOM1", "Pilot stream started");
        }
      }
    }

    public double getPhone_latitude()
    {
      return this.phone_latitude;
    }

    public double getPhone_longitude()
    {
      return this.phone_longitude;
    }

    protected void onPostExecute(String paramString)
    {
    }

    public void setPhone_latitude(double paramDouble)
    {
      this.phone_latitude = paramDouble;
    }

    public void setPhone_longitude(double paramDouble)
    {
      this.phone_longitude = paramDouble;
    }
  }

  public class ConnectionStatusTask extends AsyncTask<String, Void, String>
  {
    private int COLOR_CONNECTED = -16711936;
    private int COLOR_NOT_CONNECTED = -65536;
    private String DRONE_IP;
    private String MESSAGE_CONNECTED = "Fathom One is connected";
    private String MESSAGE_NOT_CONNECTED = "Fathom One is offline";
    private String MESSAGE_WRONG_WIFI = "Please connect to the Fathom wifi network";
    private int VOLTAGE_MAX = 2500;
    private int VOLTAGE_MIN = 2100;
    private String statusMessageForUser = "";

    public ConnectionStatusTask(String arg2)
    {
      Object localObject;
      this.DRONE_IP = localObject;
    }

    private void reportStatus(String paramString, Boolean paramBoolean)
    {
      LobbyActivity.access$302(LobbyActivity.this, paramBoolean);
      this.statusMessageForUser = paramString;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      LobbyActivity.this.checkWifiStatus();
      if (!LobbyActivity.this.connectedToFathomNetwork.booleanValue())
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
      paramString = (TextView)LobbyActivity.this.findViewById(2131689632);
      Button localButton1 = (Button)LobbyActivity.this.findViewById(2131689633);
      Button localButton2 = (Button)LobbyActivity.this.findViewById(2131689634);
      paramString.setText(this.statusMessageForUser);
      paramString.setVisibility(0);
      if (LobbyActivity.this.isConnected.booleanValue())
      {
        paramString.setBackgroundColor(this.COLOR_CONNECTED);
        localButton1.setBackgroundResource(2130837612);
        localButton2.setBackgroundResource(2130837637);
        return;
      }
      paramString.setBackgroundColor(this.COLOR_NOT_CONNECTED);
      localButton1.setBackgroundResource(2130837611);
      localButton2.setBackgroundResource(2130837638);
    }
  }

  private class LatLongTask extends AsyncTask<String, Void, String>
  {
    private String DRONE_IP;
    private Context mContext;
    private double phone_latitude = -1.0D;
    private double phone_longitude = -1.0D;

    public LatLongTask(String paramContext, Context arg3)
    {
      this.DRONE_IP = paramContext;
      Object localObject;
      this.mContext = localObject;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      paramArrayOfString = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      Object localObject = new DisplayMetrics();
      paramArrayOfString.getMetrics((DisplayMetrics)localObject);
      int m = ((DisplayMetrics)localObject).widthPixels;
      int k = ((DisplayMetrics)localObject).heightPixels;
      int i = m;
      int j = k;
      if (m > k)
      {
        j = m;
        i = k;
      }
      double d = j / i;
      k = i;
      if (i > 360)
      {
        k = 360;
        j = Double.valueOf(360 * d).intValue();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject = new WiFiHelper().getIPAddress(LobbyActivity.this.getApplicationContext());
        localObject = new URL("http://" + this.DRONE_IP + "/camera/start?ip=" + (String)localObject + "&lat=" + this.phone_latitude + "&longitude=" + this.phone_longitude + "&h=" + k + "&w=" + j);
        paramArrayOfString = (String)localObject;
        try
        {
          paramArrayOfString = (HttpURLConnection)paramArrayOfString.openConnection();
          localObject = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
          while (true)
          {
            String str = ((BufferedReader)localObject).readLine();
            if (str == null)
              break;
            localStringBuilder.append(str);
          }
        }
        catch (IOException paramArrayOfString)
        {
          Log.e("FATHOM1", "Error establishing URL connection");
          paramArrayOfString.printStackTrace();
        }
        return "TODO";
      }
      catch (MalformedURLException localMalformedURLException)
      {
        while (true)
        {
          localMalformedURLException.printStackTrace();
          continue;
          paramArrayOfString.disconnect();
          System.out.println(localStringBuilder.toString());
          Log.v("FATHOM1", "Pilot stream started");
        }
      }
    }

    public double getPhone_latitude()
    {
      return this.phone_latitude;
    }

    public double getPhone_longitude()
    {
      return this.phone_longitude;
    }

    protected void onPostExecute(String paramString)
    {
    }

    public void setPhone_latitude(double paramDouble)
    {
      this.phone_latitude = paramDouble;
    }

    public void setPhone_longitude(double paramDouble)
    {
      this.phone_longitude = paramDouble;
    }
  }

  private class ObserverTask extends AsyncTask<String, Void, String>
  {
    private String DRONE_IP;
    private Context mContext;
    private double phone_latitude = -1.0D;
    private double phone_longitude = -1.0D;

    public ObserverTask(String paramContext, Context arg3)
    {
      this.DRONE_IP = paramContext;
      Object localObject;
      this.mContext = localObject;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      paramArrayOfString = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      Object localObject = new DisplayMetrics();
      paramArrayOfString.getMetrics((DisplayMetrics)localObject);
      int m = ((DisplayMetrics)localObject).widthPixels;
      int k = ((DisplayMetrics)localObject).heightPixels;
      int i = m;
      int j = k;
      if (m > k)
      {
        j = m;
        i = k;
      }
      double d = j / i;
      k = i;
      if (i > 360)
      {
        k = 360;
        j = Double.valueOf(360 * d).intValue();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject = new WiFiHelper().getIPAddress(LobbyActivity.this.getApplicationContext());
        localObject = new URL("http://" + this.DRONE_IP + "/observer/start?ip=" + (String)localObject + "&lat=" + this.phone_latitude + "&longitude=" + this.phone_longitude + "&h=" + k + "&w=" + j);
        paramArrayOfString = (String)localObject;
        try
        {
          paramArrayOfString = (HttpURLConnection)paramArrayOfString.openConnection();
          localObject = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
          while (true)
          {
            String str = ((BufferedReader)localObject).readLine();
            if (str == null)
              break;
            localStringBuilder.append(str);
          }
        }
        catch (IOException paramArrayOfString)
        {
          Log.e("FATHOM1", "Error establishing URL connection");
          paramArrayOfString.printStackTrace();
        }
        return "TODO";
      }
      catch (MalformedURLException localMalformedURLException)
      {
        while (true)
        {
          localMalformedURLException.printStackTrace();
          continue;
          paramArrayOfString.disconnect();
          System.out.println(localStringBuilder.toString());
          Log.v("FATHOM1", "Observer stream started");
        }
      }
    }

    public double getPhone_latitude()
    {
      return this.phone_latitude;
    }

    public double getPhone_longitude()
    {
      return this.phone_longitude;
    }

    protected void onPostExecute(String paramString)
    {
    }

    public void setPhone_latitude(double paramDouble)
    {
      this.phone_latitude = paramDouble;
    }

    public void setPhone_longitude(double paramDouble)
    {
      this.phone_longitude = paramDouble;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.LobbyActivity
 * JD-Core Version:    0.6.0
 */