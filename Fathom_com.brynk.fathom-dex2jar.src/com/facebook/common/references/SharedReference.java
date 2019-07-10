package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
public class SharedReference<T>
{

  @GuardedBy("itself")
  private static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();

  @GuardedBy("this")
  private int mRefCount;
  private final ResourceReleaser<T> mResourceReleaser;

  @GuardedBy("this")
  private T mValue;

  public SharedReference(T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    this.mValue = Preconditions.checkNotNull(paramT);
    this.mResourceReleaser = ((ResourceReleaser)Preconditions.checkNotNull(paramResourceReleaser));
    this.mRefCount = 1;
    addLiveReference(paramT);
  }

  private static void addLiveReference(Object paramObject)
  {
    synchronized (sLiveObjects)
    {
      Integer localInteger = (Integer)sLiveObjects.get(paramObject);
      if (localInteger == null)
      {
        sLiveObjects.put(paramObject, Integer.valueOf(1));
        return;
      }
      sLiveObjects.put(paramObject, Integer.valueOf(localInteger.intValue() + 1));
    }
  }

  private int decreaseRefCount()
  {
    monitorenter;
    try
    {
      ensureValid();
      if (this.mRefCount > 0);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        this.mRefCount -= 1;
        int i = this.mRefCount;
        return i;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void ensureValid()
  {
    if (!isValid(this))
      throw new NullReferenceException();
  }

  public static boolean isValid(SharedReference<?> paramSharedReference)
  {
    return (paramSharedReference != null) && (paramSharedReference.isValid());
  }

  private static void removeLiveReference(Object paramObject)
  {
    while (true)
    {
      Integer localInteger;
      synchronized (sLiveObjects)
      {
        localInteger = (Integer)sLiveObjects.get(paramObject);
        if (localInteger != null)
          continue;
        FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", new Object[] { paramObject.getClass() });
        return;
        if (localInteger.intValue() == 1)
          sLiveObjects.remove(paramObject);
      }
      sLiveObjects.put(paramObject, Integer.valueOf(localInteger.intValue() - 1));
    }
  }

  public void addReference()
  {
    monitorenter;
    try
    {
      ensureValid();
      this.mRefCount += 1;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void deleteReference()
  {
    if (decreaseRefCount() == 0)
      monitorenter;
    try
    {
      Object localObject1 = this.mValue;
      this.mValue = null;
      monitorexit;
      this.mResourceReleaser.release(localObject1);
      removeLiveReference(localObject1);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  public T get()
  {
    monitorenter;
    try
    {
      Object localObject1 = this.mValue;
      monitorexit;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      monitorexit;
    }
    throw localObject2;
  }

  public int getRefCountTestOnly()
  {
    monitorenter;
    try
    {
      int i = this.mRefCount;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean isValid()
  {
    monitorenter;
    try
    {
      int i = this.mRefCount;
      if (i > 0)
      {
        j = 1;
        return j;
      }
      int j = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public static class NullReferenceException extends RuntimeException
  {
    public NullReferenceException()
    {
      super();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.references.SharedReference
 * JD-Core Version:    0.6.0
 */