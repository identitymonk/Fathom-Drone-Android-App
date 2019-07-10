package com.brynk.fathom.api;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LightsTask extends AsyncTask<String, Void, String>
{
  private String DRONE_IP;

  public LightsTask(String paramString)
  {
    this.DRONE_IP = paramString;
  }

  protected String doInBackground(String[] paramArrayOfString)
  {
    Object localObject1 = paramArrayOfString[0];
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayOfString = null;
    try
    {
      localObject1 = new URL("http://" + this.DRONE_IP + "/lights/" + (String)localObject1);
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
          label65: localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
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
            break label65;
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
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.LightsTask
 * JD-Core Version:    0.6.0
 */