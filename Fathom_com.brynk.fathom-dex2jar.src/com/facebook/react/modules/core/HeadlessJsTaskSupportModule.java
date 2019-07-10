package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="HeadlessJsTaskSupport")
public class HeadlessJsTaskSupportModule extends ReactContextBaseJavaModule
{
  protected static final String MODULE_NAME = "HeadlessJsTaskSupport";

  public HeadlessJsTaskSupportModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  public String getName()
  {
    return "HeadlessJsTaskSupport";
  }

  @ReactMethod
  public void notifyTaskFinished(int paramInt)
  {
    HeadlessJsTaskContext localHeadlessJsTaskContext = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
    if (localHeadlessJsTaskContext.isTaskRunning(paramInt))
    {
      localHeadlessJsTaskContext.finishTask(paramInt);
      return;
    }
    FLog.w(HeadlessJsTaskSupportModule.class, "Tried to finish non-active task with id %d. Did it time out?", new Object[] { Integer.valueOf(paramInt) });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.HeadlessJsTaskSupportModule
 * JD-Core Version:    0.6.0
 */