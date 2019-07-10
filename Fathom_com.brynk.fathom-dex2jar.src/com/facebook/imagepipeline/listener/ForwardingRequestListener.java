package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class ForwardingRequestListener
  implements RequestListener
{
  private static final String TAG = "ForwardingRequestListener";
  private final List<RequestListener> mRequestListeners;

  public ForwardingRequestListener(Set<RequestListener> paramSet)
  {
    this.mRequestListeners = new ArrayList(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      RequestListener localRequestListener = (RequestListener)paramSet.next();
      if (localRequestListener == null)
        continue;
      this.mRequestListeners.add(localRequestListener);
    }
  }

  public ForwardingRequestListener(RequestListener[] paramArrayOfRequestListener)
  {
    this.mRequestListeners = new ArrayList(paramArrayOfRequestListener.length);
    int j = paramArrayOfRequestListener.length;
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = paramArrayOfRequestListener[i];
      if (localRequestListener != null)
        this.mRequestListeners.add(localRequestListener);
      i += 1;
    }
  }

  private void onException(String paramString, Throwable paramThrowable)
  {
    FLog.e("ForwardingRequestListener", paramString, paramThrowable);
  }

  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onProducerEvent(paramString1, paramString2, paramString3);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onIntermediateChunkStart", localException);
        }
      }
  }

  public void onProducerFinishWithCancellation(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onProducerFinishWithCancellation(paramString1, paramString2, paramMap);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerFinishWithCancellation", localException);
        }
      }
  }

  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, @Nullable Map<String, String> paramMap)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onProducerFinishWithFailure(paramString1, paramString2, paramThrowable, paramMap);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerFinishWithFailure", localException);
        }
      }
  }

  public void onProducerFinishWithSuccess(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onProducerFinishWithSuccess(paramString1, paramString2, paramMap);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerFinishWithSuccess", localException);
        }
      }
  }

  public void onProducerStart(String paramString1, String paramString2)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onProducerStart(paramString1, paramString2);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerStart", localException);
        }
      }
  }

  public void onRequestCancellation(String paramString)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onRequestCancellation(paramString);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onRequestCancellation", localException);
        }
      }
  }

  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onRequestFailure(paramImageRequest, paramString, paramThrowable, paramBoolean);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onRequestFailure", localException);
        }
      }
  }

  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onRequestStart(paramImageRequest, paramObject, paramString, paramBoolean);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onRequestStart", localException);
        }
      }
  }

  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onRequestSuccess(paramImageRequest, paramString, paramBoolean);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onRequestSuccess", localException);
        }
      }
  }

  public void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (true)
      if (i < j)
      {
        RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
        try
        {
          localRequestListener.onUltimateProducerReached(paramString1, paramString2, paramBoolean);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onProducerFinishWithSuccess", localException);
        }
      }
  }

  public boolean requiresExtraMap(String paramString)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      if (((RequestListener)this.mRequestListeners.get(i)).requiresExtraMap(paramString))
        return true;
      i += 1;
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.listener.ForwardingRequestListener
 * JD-Core Version:    0.6.0
 */