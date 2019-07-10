package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState>
  implements NetworkFetcher<FETCH_STATE>
{
  @Nullable
  public Map<String, String> getExtraMap(FETCH_STATE paramFETCH_STATE, int paramInt)
  {
    return null;
  }

  public void onFetchCompletion(FETCH_STATE paramFETCH_STATE, int paramInt)
  {
  }

  public boolean shouldPropagate(FETCH_STATE paramFETCH_STATE)
  {
    return true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BaseNetworkFetcher
 * JD-Core Version:    0.6.0
 */