package com.facebook.react.modules.fresco;

import android.net.Uri;
import android.util.Pair;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.Systrace.EventScope;
import java.util.HashMap;
import java.util.Map;

public class SystraceRequestListener extends BaseRequestListener
{
  int mCurrentID = 0;
  Map<String, Pair<Integer, String>> mProducerID = new HashMap();
  Map<String, Pair<Integer, String>> mRequestsID = new HashMap();

  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    if (!Systrace.isTracing(0L))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRESCO_PRODUCER_EVENT_");
    localStringBuilder.append(paramString1.replace(':', '_'));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2.replace(':', '_'));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3.replace(':', '_'));
    Systrace.traceInstant(0L, localStringBuilder.toString(), Systrace.EventScope.THREAD);
  }

  public void onProducerFinishWithCancellation(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (!Systrace.isTracing(0L));
    do
      return;
    while (!this.mProducerID.containsKey(paramString1));
    paramString2 = (Pair)this.mProducerID.get(paramString1);
    Systrace.endAsyncSection(0L, (String)paramString2.second, ((Integer)paramString2.first).intValue());
    this.mProducerID.remove(paramString1);
  }

  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, Map<String, String> paramMap)
  {
    if (!Systrace.isTracing(0L));
    do
      return;
    while (!this.mProducerID.containsKey(paramString1));
    paramString2 = (Pair)this.mProducerID.get(paramString1);
    Systrace.endAsyncSection(0L, (String)paramString2.second, ((Integer)paramString2.first).intValue());
    this.mProducerID.remove(paramString1);
  }

  public void onProducerFinishWithSuccess(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (!Systrace.isTracing(0L));
    do
      return;
    while (!this.mProducerID.containsKey(paramString1));
    paramString2 = (Pair)this.mProducerID.get(paramString1);
    Systrace.endAsyncSection(0L, (String)paramString2.second, ((Integer)paramString2.first).intValue());
    this.mProducerID.remove(paramString1);
  }

  public void onProducerStart(String paramString1, String paramString2)
  {
    if (!Systrace.isTracing(0L))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRESCO_PRODUCER_");
    localStringBuilder.append(paramString2.replace(':', '_'));
    paramString2 = Pair.create(Integer.valueOf(this.mCurrentID), localStringBuilder.toString());
    Systrace.beginAsyncSection(0L, (String)paramString2.second, this.mCurrentID);
    this.mProducerID.put(paramString1, paramString2);
    this.mCurrentID += 1;
  }

  public void onRequestCancellation(String paramString)
  {
    if (!Systrace.isTracing(0L));
    do
      return;
    while (!this.mRequestsID.containsKey(paramString));
    Pair localPair = (Pair)this.mRequestsID.get(paramString);
    Systrace.endAsyncSection(0L, (String)localPair.second, ((Integer)localPair.first).intValue());
    this.mRequestsID.remove(paramString);
  }

  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L));
    do
      return;
    while (!this.mRequestsID.containsKey(paramString));
    paramImageRequest = (Pair)this.mRequestsID.get(paramString);
    Systrace.endAsyncSection(0L, (String)paramImageRequest.second, ((Integer)paramImageRequest.first).intValue());
    this.mRequestsID.remove(paramString);
  }

  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L))
      return;
    paramObject = new StringBuilder();
    paramObject.append("FRESCO_REQUEST_");
    paramObject.append(paramImageRequest.getSourceUri().toString().replace(':', '_'));
    paramImageRequest = Pair.create(Integer.valueOf(this.mCurrentID), paramObject.toString());
    Systrace.beginAsyncSection(0L, (String)paramImageRequest.second, this.mCurrentID);
    this.mRequestsID.put(paramString, paramImageRequest);
    this.mCurrentID += 1;
  }

  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L));
    do
      return;
    while (!this.mRequestsID.containsKey(paramString));
    paramImageRequest = (Pair)this.mRequestsID.get(paramString);
    Systrace.endAsyncSection(0L, (String)paramImageRequest.second, ((Integer)paramImageRequest.first).intValue());
    this.mRequestsID.remove(paramString);
  }

  public boolean requiresExtraMap(String paramString)
  {
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.fresco.SystraceRequestListener
 * JD-Core Version:    0.6.0
 */