package com.brynk.fathom.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.brynk.fathom.helpers.WiFiHelper;

public class WifiTask extends AsyncTask<String, Void, String>
{
  private Context mContext;
  private View rootView;

  public WifiTask(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.rootView = paramView;
  }

  protected String doInBackground(String[] paramArrayOfString)
  {
    return "" + new WiFiHelper().calculateSignalStrength(this.mContext);
  }

  protected void onPostExecute(String paramString)
  {
    ImageView localImageView = (ImageView)this.rootView.findViewById(2131689656);
    int j = -1;
    int i = 2130837660;
    try
    {
      int k = Integer.parseInt(paramString);
      j = k;
      if (j > 90)
      {
        i = 2130837656;
        localImageView.setImageResource(i);
        return;
      }
    }
    catch (java.lang.NumberFormatException paramString)
    {
      while (true)
      {
        Log.v("FATHOM1", "Unable to parse wifi result as a number");
        continue;
        if (j > 85)
        {
          i = 2130837659;
          continue;
        }
        if (j > 80)
        {
          i = 2130837658;
          continue;
        }
        if (j <= 70)
          continue;
        i = 2130837657;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.WifiTask
 * JD-Core Version:    0.6.0
 */