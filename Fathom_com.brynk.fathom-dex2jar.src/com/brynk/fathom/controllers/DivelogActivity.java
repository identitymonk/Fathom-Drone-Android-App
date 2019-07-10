package com.brynk.fathom.controllers;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.brynk.fathom.helpers.Constants;
import com.brynk.fathom.helpers.DivelogAdapter;
import com.brynk.fathom.helpers.DivelogEntry;
import com.brynk.fathom.helpers.WiFiHelper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DivelogActivity extends AppCompatActivity
{
  static final String[] FRUITS = { "Apple", "Avocado", "Banana", "Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit", "Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };
  private String DRONE_IP;
  private DivelogEntry[] entries;

  private String formatUptime(int paramInt)
  {
    if (paramInt < 60)
      return paramInt + "m";
    int i = paramInt / 60;
    return i + "h" + paramInt % 60 + "m";
  }

  private String tryToConnect(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = null;
    try
    {
      localObject3 = new URL(paramString);
      localObject1 = localObject3;
      localObject3 = null;
    }
    catch (IOException localObject2)
    {
      try
      {
        localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
      }
      catch (IOException localObject2)
      {
        try
        {
          label32: Object localObject3 = new BufferedReader(new InputStreamReader(new BufferedInputStream(((HttpURLConnection)localObject1).getInputStream())));
          while (true)
          {
            String str = ((BufferedReader)localObject3).readLine();
            if (str == null)
              break;
            localStringBuilder.append(str);
          }
        }
        catch (IOException localMalformedURLException)
        {
          Log.e("FATHOM1", "Error reading input from URL:" + paramString);
          localIOException2.printStackTrace();
          ((HttpURLConnection)localObject1).disconnect();
          while (true)
          {
            return localStringBuilder.toString();
            localMalformedURLException = localMalformedURLException;
            localMalformedURLException.printStackTrace();
            break;
            localIOException1 = localIOException1;
            Log.e("FATHOM1", "Error establishing URL connection");
            localIOException1.printStackTrace();
            localObject2 = localMalformedURLException;
            break label32;
            localObject2.disconnect();
          }
        }
        finally
        {
          Object localObject2;
          localObject2.disconnect();
        }
      }
    }
    throw paramString;
  }

  public void convertVideos(View paramView)
  {
    ((RelativeLayout)findViewById(2131689627)).setVisibility(0);
    new ConvertVideosTask().execute(new String[] { "http://" + this.DRONE_IP + "/convert/all" });
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968603);
    setSupportActionBar((Toolbar)findViewById(2131689681));
    this.DRONE_IP = new Constants().getDroneIp(getApplicationContext());
    if (new WiFiHelper().isConnectedToFathomNetwork(getApplicationContext()))
    {
      new DiveRecordingTask(this.DRONE_IP).execute(new String[] { "" });
      new DroneInfoTask().execute(new String[] { "http://" + this.DRONE_IP + "/drone/info" });
      return;
    }
    Toast.makeText(getApplicationContext(), "Connect to Fathom network", 1).show();
  }

  private class ConvertVideosTask extends AsyncTask<String, Void, String>
  {
    public ConvertVideosTask()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      return DivelogActivity.this.tryToConnect(paramArrayOfString[0]);
    }

    protected void onPostExecute(String paramString)
    {
      ((RelativeLayout)DivelogActivity.this.findViewById(2131689627)).setVisibility(4);
      new DivelogActivity.DiveRecordingTask(DivelogActivity.this, DivelogActivity.this.DRONE_IP).execute(new String[] { "" });
    }
  }

  private class DiveRecordingTask extends AsyncTask<String, Void, String>
  {
    private String DRONE_IP;

    public DiveRecordingTask(String arg2)
    {
      Object localObject;
      this.DRONE_IP = localObject;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      return DivelogActivity.this.tryToConnect("http://" + this.DRONE_IP + "/flights/recordings");
    }

    protected void onPostExecute(String paramString)
    {
      ListView localListView = (ListView)DivelogActivity.this.findViewById(2131689625);
      Object localObject1 = null;
      Object localObject2;
      DivelogEntry[] arrayOfDivelogEntry;
      String str1;
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        localObject2 = null;
        if (paramString == null)
        {
          localObject1 = "No records found";
          Log.d("FATHOM1", (String)localObject1);
          if (localObject2 != null)
            localListView.setAdapter(new DivelogAdapter(DivelogActivity.this.getApplicationContext(), localObject2));
          return;
        }
      }
      catch (JSONException paramString)
      {
        while (true)
        {
          paramString.printStackTrace();
          try
          {
            paramString = new JSONArray("");
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            paramString = (String)localObject1;
          }
        }
        arrayOfDivelogEntry = new DivelogEntry[paramString.length()];
        str1 = paramString.toString();
        i = 0;
      }
      while (true)
      {
        localObject2 = arrayOfDivelogEntry;
        localObject1 = str1;
        if (i >= paramString.length())
          break;
        try
        {
          Object localObject3 = paramString.getJSONObject(i);
          localObject1 = ((JSONObject)localObject3).getString("name");
          localObject2 = ((JSONObject)localObject3).getString("latitude");
          String str2 = ((JSONObject)localObject3).getString("longitude");
          String str3 = ((JSONObject)localObject3).getString("start_time");
          String str4 = ((JSONObject)localObject3).getString("when");
          localObject3 = ((JSONObject)localObject3).getString("converted");
          arrayOfDivelogEntry[i] = new DivelogEntry((String)localObject1, str4, str3, "", (String)localObject2 + "," + str2, (String)localObject3);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            localJSONException.printStackTrace();
        }
      }
    }
  }

  private class DroneInfoTask extends AsyncTask<String, Void, String>
  {
    public DroneInfoTask()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      return DivelogActivity.this.tryToConnect(paramArrayOfString[0]);
    }

    protected void onPostExecute(String paramString)
    {
      TextView localTextView1 = (TextView)DivelogActivity.this.findViewById(2131689622);
      TextView localTextView2 = (TextView)DivelogActivity.this.findViewById(2131689623);
      TextView localTextView3 = (TextView)DivelogActivity.this.findViewById(2131689624);
      Object localObject = null;
      try
      {
        paramString = new JSONObject(paramString);
      }
      catch (JSONException paramString)
      {
        try
        {
          while (true)
          {
            localTextView1.setText(DivelogActivity.this.formatUptime(paramString.getInt("uptime")));
            localTextView2.setText(DivelogActivity.this.formatUptime(paramString.getInt("flighttime")));
            localTextView3.setText("" + paramString.getInt("flightcount"));
            return;
            paramString = paramString;
            paramString.printStackTrace();
            try
            {
              paramString = new JSONObject("");
            }
            catch (JSONException paramString)
            {
              paramString.printStackTrace();
              paramString = localObject;
            }
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.DivelogActivity
 * JD-Core Version:    0.6.0
 */