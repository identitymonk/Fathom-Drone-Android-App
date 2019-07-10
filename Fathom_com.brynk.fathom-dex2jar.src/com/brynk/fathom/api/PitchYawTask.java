package com.brynk.fathom.api;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PitchYawTask extends AsyncTask<String, Void, String>
{
  private String DRONE_IP = null;
  private String messageStr = null;
  private DatagramSocket roll_socket = null;

  protected String doInBackground(String[] paramArrayOfString)
  {
    this.messageStr = paramArrayOfString[0];
    paramArrayOfString = null;
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(this.DRONE_IP);
      paramArrayOfString = localInetAddress;
      int i = this.messageStr.length();
      paramArrayOfString = new DatagramPacket(this.messageStr.getBytes(), i, paramArrayOfString, 8001);
    }
    catch (UnknownHostException localUnknownHostException)
    {
      try
      {
        this.roll_socket.send(paramArrayOfString);
        return "TODO";
        localUnknownHostException = localUnknownHostException;
        localUnknownHostException.printStackTrace();
      }
      catch (IOException paramArrayOfString)
      {
        while (true)
          paramArrayOfString.printStackTrace();
      }
    }
  }

  public String getDRONE_IP()
  {
    return this.DRONE_IP;
  }

  public String getMessageStr()
  {
    return this.messageStr;
  }

  public DatagramSocket getRoll_socket()
  {
    return this.roll_socket;
  }

  protected void onPostExecute(String paramString)
  {
  }

  public void setDRONE_IP(String paramString)
  {
    this.DRONE_IP = paramString;
  }

  public void setMessageStr(String paramString)
  {
    this.messageStr = paramString;
  }

  public void setRoll_socket(DatagramSocket paramDatagramSocket)
  {
    this.roll_socket = paramDatagramSocket;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.PitchYawTask
 * JD-Core Version:    0.6.0
 */