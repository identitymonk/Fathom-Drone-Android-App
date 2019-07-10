package com.brynk.fathom.api;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ThrusterTask extends AsyncTask<String, Void, String>
{
  private String DRONE_IP = null;
  private String messageStr = null;
  private DatagramSocket thruster_socket = null;

  protected String doInBackground(String[] paramArrayOfString)
  {
    this.messageStr = paramArrayOfString[0];
    paramArrayOfString = null;
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(this.DRONE_IP);
      paramArrayOfString = localInetAddress;
      int i = this.messageStr.length();
      paramArrayOfString = new DatagramPacket(this.messageStr.getBytes(), i, paramArrayOfString, 8002);
    }
    catch (UnknownHostException localUnknownHostException)
    {
      try
      {
        this.thruster_socket.send(paramArrayOfString);
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

  public DatagramSocket getThruster_socket()
  {
    return this.thruster_socket;
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

  public void setThruster_socket(DatagramSocket paramDatagramSocket)
  {
    this.thruster_socket = paramDatagramSocket;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.ThrusterTask
 * JD-Core Version:    0.6.0
 */