package com.brynk.fathom.api;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RecordingTask extends AsyncTask<String, Void, String>
{
  private String DRONE_IP;

  public RecordingTask(String paramString)
  {
    this.DRONE_IP = paramString;
  }

  protected String doInBackground(String[] paramArrayOfString)
  {
    String str1 = paramArrayOfString[0];
    if ((str1 != null) && (str1.equals("start")) && (!str1.equals("stop")));
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayOfString = null;
    try
    {
      localObject1 = new URL("http://" + this.DRONE_IP + ":9001/record/" + str1);
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
          label88: Object localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
          while (true)
          {
            String str2 = ((BufferedReader)localObject1).readLine();
            if (str2 == null)
              break;
            localStringBuilder.append(str2);
          }
        }
        catch (IOException localMalformedURLException)
        {
          Log.e("FATHOM1", "Error reading input from URL");
          localIOException.printStackTrace();
          while (true)
          {
            return "TODO";
            localMalformedURLException = localMalformedURLException;
            localMalformedURLException.printStackTrace();
            break;
            paramArrayOfString = paramArrayOfString;
            Log.e("FATHOM1", "Error establishing URL connection");
            paramArrayOfString.printStackTrace();
            paramArrayOfString = localMalformedURLException;
            break label88;
            Log.v("FATHOM1", "Recording " + str1);
            paramArrayOfString.disconnect();
            System.out.println(localStringBuilder.toString());
          }
        }
        finally
        {
          Log.v("FATHOM1", "Recording " + str1);
          paramArrayOfString.disconnect();
          System.out.println(localStringBuilder.toString());
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
 * Qualified Name:     com.brynk.fathom.api.RecordingTask
 * JD-Core Version:    0.6.0
 */