package com.facebook.react.modules.debug;

import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.util.Locale;
import javax.annotation.Nullable;

@ReactModule(name="AnimationsDebugModule")
public class AnimationsDebugModule extends ReactContextBaseJavaModule
{
  protected static final String NAME = "AnimationsDebugModule";

  @Nullable
  private final DeveloperSettings mCatalystSettings;

  @Nullable
  private FpsDebugFrameCallback mFrameCallback;

  public AnimationsDebugModule(ReactApplicationContext paramReactApplicationContext, DeveloperSettings paramDeveloperSettings)
  {
    super(paramReactApplicationContext);
    this.mCatalystSettings = paramDeveloperSettings;
  }

  public String getName()
  {
    return "AnimationsDebugModule";
  }

  public void onCatalystInstanceDestroy()
  {
    if (this.mFrameCallback != null)
    {
      this.mFrameCallback.stop();
      this.mFrameCallback = null;
    }
  }

  @ReactMethod
  public void startRecordingFps()
  {
    if ((this.mCatalystSettings == null) || (!this.mCatalystSettings.isAnimationFpsDebugEnabled()))
      return;
    if (this.mFrameCallback != null)
      throw new JSApplicationCausedNativeException("Already recording FPS!");
    this.mFrameCallback = new FpsDebugFrameCallback(ChoreographerCompat.getInstance(), getReactApplicationContext());
    this.mFrameCallback.startAndRecordFpsAtEachFrame();
  }

  @ReactMethod
  public void stopRecordingFps(double paramDouble)
  {
    if (this.mFrameCallback == null)
      return;
    this.mFrameCallback.stop();
    Object localObject = this.mFrameCallback.getFpsInfo(()paramDouble);
    if (localObject == null)
      Toast.makeText(getReactApplicationContext(), "Unable to get FPS info", 1);
    while (true)
    {
      this.mFrameCallback = null;
      return;
      String str1 = String.format(Locale.US, "FPS: %.2f, %d frames (%d expected)", new Object[] { Double.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).fps), Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalFrames), Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalExpectedFrames) });
      String str2 = String.format(Locale.US, "JS FPS: %.2f, %d frames (%d expected)", new Object[] { Double.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).jsFps), Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalJsFrames), Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalExpectedFrames) });
      localObject = str1 + "\n" + str2 + "\n" + "Total Time MS: " + String.format(Locale.US, "%d", new Object[] { Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalTimeMs) });
      FLog.d("ReactNative", (String)localObject);
      Toast.makeText(getReactApplicationContext(), (CharSequence)localObject, 1).show();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.debug.AnimationsDebugModule
 * JD-Core Version:    0.6.0
 */