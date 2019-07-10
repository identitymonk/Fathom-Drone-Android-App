package com.brynk.fathom.controllers;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.brynk.fathom.helpers.Constants;
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

public class FirmwareActivity extends AppCompatActivity
{
  private String DRONE_IP;
  private ScheduledExecutorService exec = null;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968604);
    this.DRONE_IP = new Constants().getDroneIp(getApplicationContext());
    new UpdateFirmwareTask(null).execute(new String[] { "" });
    this.exec = Executors.newSingleThreadScheduledExecutor();
    this.exec.scheduleAtFixedRate(new Runnable()
    {
      public void run()
      {
        new FirmwareActivity.UpdateStatusTask(FirmwareActivity.this, FirmwareActivity.this.DRONE_IP).execute(new String[] { "" });
      }
    }
    , 0L, 3L, TimeUnit.SECONDS);
  }

  private class UpdateFirmwareTask extends AsyncTask<String, Void, String>
  {
    private UpdateFirmwareTask()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject1 = new URL("http://" + FirmwareActivity.this.DRONE_IP + "/update");
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
            label60: Object localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
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
              break label60;
              paramArrayOfString.disconnect();
              System.out.println(localStringBuilder.toString());
            }
          }
          finally
          {
            paramArrayOfString.disconnect();
            System.out.println(localStringBuilder.toString());
          }
        }
      }
      throw localObject2;
    }

    protected void onPostExecute(String paramString)
    {
      TextView localTextView = (TextView)FirmwareActivity.this.findViewById(2131689630);
      if (Boolean.parseBoolean(paramString))
      {
        localTextView.setTextColor(17170452);
        return;
      }
      localTextView.setTextColor(17170454);
    }
  }

  public class UpdateStatusTask extends AsyncTask<String, Void, String>
  {
    private int COLOR_CONNECTED = -16711936;
    private int COLOR_NOT_CONNECTED = -65536;
    private String DRONE_IP;
    private String MESSAGE_NOT_UPDATED = "Fathom One failed to update";
    private String MESSAGE_UPDATED = "Fathom One is updated";
    private String MESSAGE_UPDATING = "Fathom One is updating";
    private String MESSAGE_WRONG_WIFI = "Please connect to the Fathom wifi network";
    private Boolean isUpdated = Boolean.valueOf(false);
    private String statusMessageForUser = "";

    public UpdateStatusTask(String arg2)
    {
      Object localObject;
      this.DRONE_IP = localObject;
    }

    private void reportStatus(String paramString, Boolean paramBoolean)
    {
      this.isUpdated = paramBoolean;
      this.statusMessageForUser = paramString;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = null;
      try
      {
        paramArrayOfString = new URL("http://" + this.DRONE_IP + "/system/status");
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
            localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
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
            while (true)
            {
              Log.e("FATHOM1", "Error reading input from URL");
              localIOException1.printStackTrace();
              reportStatus(this.MESSAGE_NOT_UPDATED, Boolean.valueOf(false));
              return this.statusMessageForUser;
              paramArrayOfString = paramArrayOfString;
              paramArrayOfString.printStackTrace();
              reportStatus(this.MESSAGE_NOT_UPDATED, Boolean.valueOf(false));
              continue;
              localIOException2 = localIOException2;
              Log.e("FATHOM1", "Error establishing URL connection");
              localIOException2.printStackTrace();
              reportStatus(this.MESSAGE_NOT_UPDATED, Boolean.valueOf(false));
            }
            if (localStringBuilder.toString().equals("UPDATING"))
            {
              reportStatus(this.MESSAGE_UPDATING, Boolean.valueOf(false));
              Log.d("FATHOM1", "Still updating...");
            }
            while (true)
            {
              paramArrayOfString.disconnect();
              break;
              reportStatus(this.MESSAGE_UPDATED, Boolean.valueOf(true));
              Log.d("FATHOM1", "Updated...");
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
      paramString = (TextView)FirmwareActivity.this.findViewById(2131689630);
      paramString.setText(this.statusMessageForUser);
      paramString.setVisibility(0);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.FirmwareActivity
 * JD-Core Version:    0.6.0
 */