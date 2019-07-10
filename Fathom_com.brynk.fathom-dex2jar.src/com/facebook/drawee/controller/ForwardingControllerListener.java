package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ForwardingControllerListener<INFO>
  implements ControllerListener<INFO>
{
  private static final String TAG = "FdingControllerListener";
  private final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);

  public static <INFO> ForwardingControllerListener<INFO> create()
  {
    return new ForwardingControllerListener();
  }

  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener);
    return localForwardingControllerListener;
  }

  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener1, ControllerListener<? super INFO> paramControllerListener2)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener1);
    localForwardingControllerListener.addListener(paramControllerListener2);
    return localForwardingControllerListener;
  }

  private void onException(String paramString, Throwable paramThrowable)
  {
    monitorenter;
    try
    {
      Log.e("FdingControllerListener", paramString, paramThrowable);
      monitorexit;
      return;
    }
    finally
    {
      paramString = finally;
      monitorexit;
    }
    throw paramString;
  }

  public void addListener(ControllerListener<? super INFO> paramControllerListener)
  {
    monitorenter;
    try
    {
      this.mListeners.add(paramControllerListener);
      monitorexit;
      return;
    }
    finally
    {
      paramControllerListener = finally;
      monitorexit;
    }
    throw paramControllerListener;
  }

  public void clearListeners()
  {
    monitorenter;
    try
    {
      this.mListeners.clear();
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

  public void onFailure(String paramString, Throwable paramThrowable)
  {
    monitorenter;
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      while (true)
        if (i < j)
          try
          {
            ((ControllerListener)this.mListeners.get(i)).onFailure(paramString, paramThrowable);
            i += 1;
          }
          catch (Exception localException)
          {
            while (true)
              onException("InternalListener exception in onFailure", localException);
          }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public void onFinalImageSet(String paramString, @Nullable INFO paramINFO, @Nullable Animatable paramAnimatable)
  {
    monitorenter;
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      while (true)
        if (i < j)
          try
          {
            ((ControllerListener)this.mListeners.get(i)).onFinalImageSet(paramString, paramINFO, paramAnimatable);
            i += 1;
          }
          catch (Exception localException)
          {
            while (true)
              onException("InternalListener exception in onFinalImageSet", localException);
          }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public void onIntermediateImageFailed(String paramString, Throwable paramThrowable)
  {
    int j = this.mListeners.size();
    int i = 0;
    while (true)
      if (i < j)
        try
        {
          ((ControllerListener)this.mListeners.get(i)).onIntermediateImageFailed(paramString, paramThrowable);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onIntermediateImageFailed", localException);
        }
  }

  public void onIntermediateImageSet(String paramString, @Nullable INFO paramINFO)
  {
    int j = this.mListeners.size();
    int i = 0;
    while (true)
      if (i < j)
        try
        {
          ((ControllerListener)this.mListeners.get(i)).onIntermediateImageSet(paramString, paramINFO);
          i += 1;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onIntermediateImageSet", localException);
        }
  }

  public void onRelease(String paramString)
  {
    monitorenter;
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      while (true)
        if (i < j)
          try
          {
            ((ControllerListener)this.mListeners.get(i)).onRelease(paramString);
            i += 1;
          }
          catch (Exception localException)
          {
            while (true)
              onException("InternalListener exception in onRelease", localException);
          }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public void onSubmit(String paramString, Object paramObject)
  {
    monitorenter;
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      while (true)
        if (i < j)
          try
          {
            ((ControllerListener)this.mListeners.get(i)).onSubmit(paramString, paramObject);
            i += 1;
          }
          catch (Exception localException)
          {
            while (true)
              onException("InternalListener exception in onSubmit", localException);
          }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public void removeListener(ControllerListener<? super INFO> paramControllerListener)
  {
    monitorenter;
    try
    {
      this.mListeners.remove(paramControllerListener);
      monitorexit;
      return;
    }
    finally
    {
      paramControllerListener = finally;
      monitorexit;
    }
    throw paramControllerListener;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.controller.ForwardingControllerListener
 * JD-Core Version:    0.6.0
 */