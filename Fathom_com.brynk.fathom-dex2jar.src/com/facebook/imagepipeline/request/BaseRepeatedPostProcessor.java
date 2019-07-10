package com.facebook.imagepipeline.request;

public abstract class BaseRepeatedPostProcessor extends BasePostprocessor
  implements RepeatedPostprocessor
{
  private RepeatedPostprocessorRunner mCallback;

  private RepeatedPostprocessorRunner getCallback()
  {
    monitorenter;
    try
    {
      RepeatedPostprocessorRunner localRepeatedPostprocessorRunner = this.mCallback;
      monitorexit;
      return localRepeatedPostprocessorRunner;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setCallback(RepeatedPostprocessorRunner paramRepeatedPostprocessorRunner)
  {
    monitorenter;
    try
    {
      this.mCallback = paramRepeatedPostprocessorRunner;
      monitorexit;
      return;
    }
    finally
    {
      paramRepeatedPostprocessorRunner = finally;
      monitorexit;
    }
    throw paramRepeatedPostprocessorRunner;
  }

  public void update()
  {
    RepeatedPostprocessorRunner localRepeatedPostprocessorRunner = getCallback();
    if (localRepeatedPostprocessorRunner != null)
      localRepeatedPostprocessorRunner.update();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.request.BaseRepeatedPostProcessor
 * JD-Core Version:    0.6.0
 */