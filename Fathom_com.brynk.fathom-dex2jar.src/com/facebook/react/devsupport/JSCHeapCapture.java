package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;
import javax.annotation.Nullable;

@ReactModule(name="JSCHeapCapture", needsEagerInit=true)
public class JSCHeapCapture extends ReactContextBaseJavaModule
{

  @Nullable
  private CaptureCallback mCaptureInProgress = null;

  public JSCHeapCapture(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @ReactMethod
  public void captureComplete(String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      if (this.mCaptureInProgress != null)
      {
        if (paramString2 != null)
          break label38;
        this.mCaptureInProgress.onSuccess(new File(paramString1));
      }
      while (true)
      {
        this.mCaptureInProgress = null;
        return;
        label38: this.mCaptureInProgress.onFailure(new CaptureException(paramString2));
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramString1;
  }

  public void captureHeap(String paramString, CaptureCallback paramCaptureCallback)
  {
    monitorenter;
    while (true)
    {
      HeapCapture localHeapCapture;
      try
      {
        if (this.mCaptureInProgress == null)
          continue;
        paramCaptureCallback.onFailure(new CaptureException("Heap capture already in progress."));
        return;
        paramString = new File(paramString + "/capture.json");
        paramString.delete();
        localHeapCapture = (HeapCapture)getReactApplicationContext().getJSModule(HeapCapture.class);
        if (localHeapCapture == null)
        {
          paramCaptureCallback.onFailure(new CaptureException("Heap capture js module not registered."));
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      this.mCaptureInProgress = paramCaptureCallback;
      localHeapCapture.captureHeap(paramString.getPath());
    }
  }

  public String getName()
  {
    return "JSCHeapCapture";
  }

  public static abstract interface CaptureCallback
  {
    public abstract void onFailure(JSCHeapCapture.CaptureException paramCaptureException);

    public abstract void onSuccess(File paramFile);
  }

  public static class CaptureException extends Exception
  {
    CaptureException(String paramString)
    {
      super();
    }

    CaptureException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }

  public static abstract interface HeapCapture extends JavaScriptModule
  {
    public abstract void captureHeap(String paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.JSCHeapCapture
 * JD-Core Version:    0.6.0
 */