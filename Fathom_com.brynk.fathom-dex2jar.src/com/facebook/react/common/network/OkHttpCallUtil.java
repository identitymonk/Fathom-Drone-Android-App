package com.facebook.react.common.network;

import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpCallUtil
{
  public static void cancelTag(OkHttpClient paramOkHttpClient, Object paramObject)
  {
    Object localObject = paramOkHttpClient.dispatcher().queuedCalls().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Call localCall = (Call)((Iterator)localObject).next();
      if (!paramObject.equals(localCall.request().tag()))
        continue;
      localCall.cancel();
    }
    do
    {
      return;
      while (!paramOkHttpClient.hasNext())
        paramOkHttpClient = paramOkHttpClient.dispatcher().runningCalls().iterator();
      localObject = (Call)paramOkHttpClient.next();
    }
    while (!paramObject.equals(((Call)localObject).request().tag()));
    ((Call)localObject).cancel();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.common.network.OkHttpCallUtil
 * JD-Core Version:    0.6.0
 */