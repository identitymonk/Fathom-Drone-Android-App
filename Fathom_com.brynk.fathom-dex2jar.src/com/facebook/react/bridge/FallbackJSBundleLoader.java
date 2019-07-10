package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public final class FallbackJSBundleLoader extends JSBundleLoader
{
  static final String RECOVERABLE = "facebook::react::Recoverable";
  static final String TAG = "FallbackJSBundleLoader";
  private Stack<JSBundleLoader> mLoaders = new Stack();
  private final ArrayList<Exception> mRecoveredErrors = new ArrayList();

  public FallbackJSBundleLoader(List<JSBundleLoader> paramList)
  {
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious())
      this.mLoaders.push(paramList.previous());
  }

  private JSBundleLoader getDelegateLoader()
  {
    if (!this.mLoaders.empty())
      return (JSBundleLoader)this.mLoaders.peek();
    RuntimeException localRuntimeException = new RuntimeException("No fallback options available");
    Object localObject1 = localRuntimeException;
    Iterator localIterator = this.mRecoveredErrors.iterator();
    if (localIterator.hasNext())
    {
      ((Throwable)localObject1).initCause((Exception)localIterator.next());
      for (Object localObject2 = localObject1; ; localObject2 = ((Throwable)localObject2).getCause())
      {
        localObject1 = localObject2;
        if (((Throwable)localObject2).getCause() == null)
          break;
      }
    }
    throw localRuntimeException;
  }

  public String loadScript(CatalystInstanceImpl paramCatalystInstanceImpl)
  {
    while (true)
      try
      {
        String str = getDelegateLoader().loadScript(paramCatalystInstanceImpl);
        return str;
      }
      catch (Exception localException)
      {
        if (localException.getMessage().startsWith("facebook::react::Recoverable"))
          continue;
        throw localException;
        this.mLoaders.pop();
        this.mRecoveredErrors.add(localException);
        FLog.wtf("FallbackJSBundleLoader", "Falling back from recoverable error", localException);
      }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.FallbackJSBundleLoader
 * JD-Core Version:    0.6.0
 */