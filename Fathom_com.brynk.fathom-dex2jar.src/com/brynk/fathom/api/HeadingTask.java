package com.brynk.fathom.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HeadingTask extends AsyncTask<String, Void, String>
{
  private String DRONE_IP;
  private Context mContext;
  private View rootView;

  public HeadingTask(Context paramContext, View paramView, String paramString)
  {
    this.mContext = paramContext;
    this.rootView = paramView;
    this.DRONE_IP = paramString;
  }

  protected String doInBackground(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayOfString = null;
    try
    {
      localObject1 = new URL("http://" + this.DRONE_IP + "/heading");
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
    TextView localTextView = (TextView)this.rootView.findViewById(2131689652);
    int i = 0;
    try
    {
      long l = Math.round(Double.parseDouble(paramString) % 360.0D / 45.0D);
      i = (int)l;
      int j = i;
      if (i > 7)
        j = 7;
      localTextView.setText(new String[] { "N", "NE", "E", "SE", "S", "SW", "W", "NW" }[j]);
      return;
    }
    catch (java.lang.NumberFormatException paramString)
    {
      while (true)
        Log.d("FATHOM1", "Unable to read heading as a number");
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.HeadingTask
 * JD-Core Version:    0.6.0
 */