package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

public abstract interface NetworkFetcher<FETCH_STATE extends FetchState>
{
  public abstract FETCH_STATE createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext);

  public abstract void fetch(FETCH_STATE paramFETCH_STATE, Callback paramCallback);

  @Nullable
  public abstract Map<String, String> getExtraMap(FETCH_STATE paramFETCH_STATE, int paramInt);

  public abstract void onFetchCompletion(FETCH_STATE paramFETCH_STATE, int paramInt);

  public abstract boolean shouldPropagate(FETCH_STATE paramFETCH_STATE);

  public static abstract interface Callback
  {
    public abstract void onCancellation();

    public abstract void onFailure(Throwable paramThrowable);

    public abstract void onResponse(InputStream paramInputStream, int paramInt)
      throws IOException;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.NetworkFetcher
 * JD-Core Version:    0.6.0
 */