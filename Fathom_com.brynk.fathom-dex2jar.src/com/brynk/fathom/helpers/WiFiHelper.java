package com.brynk.fathom.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

public class WiFiHelper
{
  private String NETWORK_NAME = "Fathom";
  private String TEST_NETWORK_NAME = "ALFA";
  private String TEST_NETWORK_NAME_TWO = "GR Makers";

  public int calculateSignalStrength(Context paramContext)
  {
    return WifiManager.calculateSignalLevel(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getRssi(), 100);
  }

  public String getIPAddress(Context paramContext)
  {
    return Formatter.formatIpAddress(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getIpAddress());
  }

  public String getWifiName(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1).isConnected())
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      localObject1 = localObject2;
      if (paramContext != null)
      {
        localObject1 = localObject2;
        if (!paramContext.getSSID().equals(""))
          localObject1 = paramContext.getSSID();
      }
    }
    return (String)localObject1;
  }

  public boolean isConnectedToFathomNetwork(Context paramContext)
  {
    paramContext = getWifiName(paramContext);
    if (paramContext == null);
    do
      return false;
    while ((!paramContext.contains(this.NETWORK_NAME)) && (!paramContext.contains(this.TEST_NETWORK_NAME)) && (!paramContext.contains(this.TEST_NETWORK_NAME_TWO)) && (!paramContext.contains("ATT7DJQpi2")));
    return true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.helpers.WiFiHelper
 * JD-Core Version:    0.6.0
 */