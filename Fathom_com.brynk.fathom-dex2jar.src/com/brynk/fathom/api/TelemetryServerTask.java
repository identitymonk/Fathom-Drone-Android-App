package com.brynk.fathom.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class TelemetryServerTask extends AsyncTask<String, Float, String>
{
  private Context mContext;
  private View rootView;

  public TelemetryServerTask(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.rootView = paramView;
  }

  protected String doInBackground(String[] paramArrayOfString)
  {
    byte[] arrayOfByte = new byte[1500];
    String[] arrayOfString1 = null;
    try
    {
      paramArrayOfString = new MulticastSocket(9876);
      arrayOfString1 = paramArrayOfString;
    }
    catch (IOException paramArrayOfString)
    {
      try
      {
        arrayOfString1.joinGroup(InetAddress.getByName("224.1.1.1"));
        paramArrayOfString = new DatagramPacket(arrayOfByte, arrayOfByte.length);
      }
      catch (IOException paramArrayOfString)
      {
        try
        {
          while (true)
          {
            arrayOfString1.receive(paramArrayOfString);
            String[] arrayOfString2 = new String(arrayOfByte, 0, paramArrayOfString.getLength()).split(",");
            publishProgress(new Float[] { Float.valueOf(Float.parseFloat(arrayOfString2[0])), Float.valueOf(Float.parseFloat(arrayOfString2[1])), Float.valueOf(Float.parseFloat(arrayOfString2[2])), Float.valueOf(Float.parseFloat(arrayOfString2[3])) });
          }
        }
        catch (java.lang.NullPointerException paramArrayOfString)
        {
          while (true)
          {
            paramArrayOfString.printStackTrace();
            arrayOfString1.close();
            return null;
            paramArrayOfString = paramArrayOfString;
            paramArrayOfString.printStackTrace();
          }
          paramArrayOfString = paramArrayOfString;
          paramArrayOfString.printStackTrace();
        }
        catch (java.lang.IndexOutOfBoundsException paramArrayOfString)
        {
          break label130;
        }
        catch (java.lang.NumberFormatException paramArrayOfString)
        {
          break label130;
        }
        catch (IOException paramArrayOfString)
        {
          label130: break label130;
        }
      }
    }
  }

  protected void onProgressUpdate(Float[] paramArrayOfFloat)
  {
    super.onProgressUpdate(paramArrayOfFloat);
    Object localObject = (ImageView)this.rootView.findViewById(2131689655);
    ImageView localImageView = (ImageView)this.rootView.findViewById(2131689639);
    TextView localTextView = (TextView)this.rootView.findViewById(2131689653);
    localObject = (TextView)this.rootView.findViewById(2131689652);
    float f = ((ImageView)this.rootView.findViewById(2131689640)).getY();
    Float localFloat1 = paramArrayOfFloat[0];
    Float localFloat2 = paramArrayOfFloat[2];
    Float localFloat3 = paramArrayOfFloat[3];
    localImageView.setRotation(paramArrayOfFloat[1].floatValue());
    localImageView.setY(f - 130.0F - 2.0F * localFloat1.floatValue());
    double d = localFloat2.floatValue();
    localTextView.setText(String.format("%.1f", new Object[] { Double.valueOf(d * 0.3048D) }) + "m");
    int i = 0;
    try
    {
      int j = Math.round(localFloat3.floatValue() % 360.0F / 45.0F);
      i = j;
      j = i;
      if (i > 7)
        j = 7;
      ((TextView)localObject).setText(new String[] { "N", "NW", "W", "SW", "S", "SE", "E", "NE" }[j]);
      return;
    }
    catch (java.lang.NumberFormatException paramArrayOfFloat)
    {
      while (true)
        Log.d("FATHOM1", "Unable to read heading as a number");
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.TelemetryServerTask
 * JD-Core Version:    0.6.0
 */