package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class BaseProducerContext
  implements ProducerContext
{

  @GuardedBy("this")
  private final List<ProducerContextCallbacks> mCallbacks;
  private final Object mCallerContext;
  private final String mId;
  private final ImageRequest mImageRequest;

  @GuardedBy("this")
  private boolean mIsCancelled;

  @GuardedBy("this")
  private boolean mIsIntermediateResultExpected;

  @GuardedBy("this")
  private boolean mIsPrefetch;
  private final ImageRequest.RequestLevel mLowestPermittedRequestLevel;

  @GuardedBy("this")
  private Priority mPriority;
  private final ProducerListener mProducerListener;

  public BaseProducerContext(ImageRequest paramImageRequest, String paramString, ProducerListener paramProducerListener, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, boolean paramBoolean1, boolean paramBoolean2, Priority paramPriority)
  {
    this.mImageRequest = paramImageRequest;
    this.mId = paramString;
    this.mProducerListener = paramProducerListener;
    this.mCallerContext = paramObject;
    this.mLowestPermittedRequestLevel = paramRequestLevel;
    this.mIsPrefetch = paramBoolean1;
    this.mPriority = paramPriority;
    this.mIsIntermediateResultExpected = paramBoolean2;
    this.mIsCancelled = false;
    this.mCallbacks = new ArrayList();
  }

  public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null);
    while (true)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
        ((ProducerContextCallbacks)paramList.next()).onCancellationRequested();
    }
  }

  public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null);
    while (true)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
        ((ProducerContextCallbacks)paramList.next()).onIsIntermediateResultExpectedChanged();
    }
  }

  public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null);
    while (true)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
        ((ProducerContextCallbacks)paramList.next()).onIsPrefetchChanged();
    }
  }

  public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null);
    while (true)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
        ((ProducerContextCallbacks)paramList.next()).onPriorityChanged();
    }
  }

  public void addCallbacks(ProducerContextCallbacks paramProducerContextCallbacks)
  {
    int i = 0;
    monitorenter;
    try
    {
      this.mCallbacks.add(paramProducerContextCallbacks);
      if (this.mIsCancelled)
        i = 1;
      monitorexit;
      if (i != 0)
        paramProducerContextCallbacks.onCancellationRequested();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramProducerContextCallbacks;
  }

  public void cancel()
  {
    callOnCancellationRequested(cancelNoCallbacks());
  }

  @Nullable
  public List<ProducerContextCallbacks> cancelNoCallbacks()
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsCancelled;
      if (bool);
      for (ArrayList localArrayList = null; ; localArrayList = new ArrayList(this.mCallbacks))
      {
        return localArrayList;
        this.mIsCancelled = true;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  public String getId()
  {
    return this.mId;
  }

  public ImageRequest getImageRequest()
  {
    return this.mImageRequest;
  }

  public ProducerListener getListener()
  {
    return this.mProducerListener;
  }

  public ImageRequest.RequestLevel getLowestPermittedRequestLevel()
  {
    return this.mLowestPermittedRequestLevel;
  }

  public Priority getPriority()
  {
    monitorenter;
    try
    {
      Priority localPriority = this.mPriority;
      monitorexit;
      return localPriority;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean isCancelled()
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsCancelled;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean isIntermediateResultExpected()
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsIntermediateResultExpected;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean isPrefetch()
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsPrefetch;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  @Nullable
  public List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsIntermediateResultExpected;
      if (paramBoolean == bool);
      for (ArrayList localArrayList = null; ; localArrayList = new ArrayList(this.mCallbacks))
      {
        return localArrayList;
        this.mIsIntermediateResultExpected = paramBoolean;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  @Nullable
  public List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsPrefetch;
      if (paramBoolean == bool);
      for (ArrayList localArrayList = null; ; localArrayList = new ArrayList(this.mCallbacks))
      {
        return localArrayList;
        this.mIsPrefetch = paramBoolean;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  @Nullable
  public List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority paramPriority)
  {
    monitorenter;
    try
    {
      Priority localPriority = this.mPriority;
      if (paramPriority == localPriority);
      for (paramPriority = null; ; paramPriority = new ArrayList(this.mCallbacks))
      {
        return paramPriority;
        this.mPriority = paramPriority;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramPriority;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BaseProducerContext
 * JD-Core Version:    0.6.0
 */