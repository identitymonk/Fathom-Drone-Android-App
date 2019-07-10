package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

@ReactModule(name="JSCSamplingProfiler", needsEagerInit=true)
public class JSCSamplingProfiler extends ReactContextBaseJavaModule
{
  private static final HashSet<JSCSamplingProfiler> sRegisteredDumpers = new HashSet();

  @Nullable
  private String mOperationError = null;
  private boolean mOperationInProgress = false;
  private int mOperationToken = 0;

  @Nullable
  private SamplingProfiler mSamplingProfiler = null;

  @Nullable
  private String mSamplingProfilerResult = null;

  public JSCSamplingProfiler(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private int getOperationToken()
    throws JSCSamplingProfiler.ProfilerException
  {
    if (this.mOperationInProgress)
      throw new ProfilerException("Another operation already in progress.");
    this.mOperationInProgress = true;
    int i = this.mOperationToken + 1;
    this.mOperationToken = i;
    return i;
  }

  public static List<String> poke(long paramLong)
    throws JSCSamplingProfiler.ProfilerException
  {
    monitorenter;
    try
    {
      LinkedList localLinkedList = new LinkedList();
      if (sRegisteredDumpers.isEmpty())
        throw new ProfilerException("No JSC registered");
    }
    finally
    {
      monitorexit;
    }
    Iterator localIterator = sRegisteredDumpers.iterator();
    while (localIterator.hasNext())
    {
      JSCSamplingProfiler localJSCSamplingProfiler = (JSCSamplingProfiler)localIterator.next();
      localJSCSamplingProfiler.pokeHelper(paramLong);
      localObject.add(localJSCSamplingProfiler.mSamplingProfilerResult);
    }
    monitorexit;
    return localObject;
  }

  private void pokeHelper(long paramLong)
    throws JSCSamplingProfiler.ProfilerException
  {
    monitorenter;
    try
    {
      if (this.mSamplingProfiler == null)
        throw new ProfilerException("SamplingProfiler.js module not connected");
    }
    finally
    {
      monitorexit;
    }
    this.mSamplingProfiler.poke(getOperationToken());
    waitForOperation(paramLong);
    monitorexit;
  }

  private static void registerSamplingProfiler(JSCSamplingProfiler paramJSCSamplingProfiler)
  {
    monitorenter;
    try
    {
      if (sRegisteredDumpers.contains(paramJSCSamplingProfiler))
        throw new RuntimeException("a JSCSamplingProfiler registered more than once");
    }
    finally
    {
      monitorexit;
    }
    sRegisteredDumpers.add(paramJSCSamplingProfiler);
    monitorexit;
  }

  private static void unregisterSamplingProfiler(JSCSamplingProfiler paramJSCSamplingProfiler)
  {
    monitorenter;
    try
    {
      sRegisteredDumpers.remove(paramJSCSamplingProfiler);
      monitorexit;
      return;
    }
    finally
    {
      paramJSCSamplingProfiler = finally;
      monitorexit;
    }
    throw paramJSCSamplingProfiler;
  }

  private void waitForOperation(long paramLong)
    throws JSCSamplingProfiler.ProfilerException
  {
    try
    {
      wait(paramLong);
      if (this.mOperationInProgress)
      {
        this.mOperationInProgress = false;
        throw new ProfilerException("heap capture timed out.");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new ProfilerException("Waiting for heap capture failed: " + localInterruptedException.getMessage());
    }
    if (this.mOperationError != null)
      throw new ProfilerException(this.mOperationError);
  }

  public String getName()
  {
    return "JSCSamplingProfiler";
  }

  public void initialize()
  {
    super.initialize();
    this.mSamplingProfiler = ((SamplingProfiler)getReactApplicationContext().getJSModule(SamplingProfiler.class));
    registerSamplingProfiler(this);
  }

  public void onCatalystInstanceDestroy()
  {
    super.onCatalystInstanceDestroy();
    unregisterSamplingProfiler(this);
    this.mSamplingProfiler = null;
  }

  @ReactMethod
  public void operationComplete(int paramInt, String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      if (paramInt == this.mOperationToken)
      {
        this.mOperationInProgress = false;
        this.mSamplingProfilerResult = paramString1;
        this.mOperationError = paramString2;
        notify();
        return;
      }
      throw new RuntimeException("Completed operation is not in progress.");
    }
    finally
    {
      monitorexit;
    }
    throw paramString1;
  }

  public static class ProfilerException extends Exception
  {
    ProfilerException(String paramString)
    {
      super();
    }
  }

  public static abstract interface SamplingProfiler extends JavaScriptModule
  {
    public abstract void poke(int paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.JSCSamplingProfiler
 * JD-Core Version:    0.6.0
 */