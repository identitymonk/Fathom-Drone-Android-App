package com.facebook.react.modules.toast;

import android.widget.Toast;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name="ToastAndroid")
public class ToastModule extends ReactContextBaseJavaModule
{
  private static final String DURATION_LONG_KEY = "LONG";
  private static final String DURATION_SHORT_KEY = "SHORT";
  private static final String GRAVITY_BOTTOM_KEY = "BOTTOM";
  private static final String GRAVITY_CENTER = "CENTER";
  private static final String GRAVITY_TOP_KEY = "TOP";

  public ToastModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    localHashMap.put("SHORT", Integer.valueOf(0));
    localHashMap.put("LONG", Integer.valueOf(1));
    localHashMap.put("TOP", Integer.valueOf(49));
    localHashMap.put("BOTTOM", Integer.valueOf(81));
    localHashMap.put("CENTER", Integer.valueOf(17));
    return localHashMap;
  }

  public String getName()
  {
    return "ToastAndroid";
  }

  @ReactMethod
  public void show(String paramString, int paramInt)
  {
    UiThreadUtil.runOnUiThread(new Runnable(paramString, paramInt)
    {
      public void run()
      {
        Toast.makeText(ToastModule.this.getReactApplicationContext(), this.val$message, this.val$duration).show();
      }
    });
  }

  @ReactMethod
  public void showWithGravity(String paramString, int paramInt1, int paramInt2)
  {
    UiThreadUtil.runOnUiThread(new Runnable(paramString, paramInt1, paramInt2)
    {
      public void run()
      {
        Toast localToast = Toast.makeText(ToastModule.this.getReactApplicationContext(), this.val$message, this.val$duration);
        localToast.setGravity(this.val$gravity, 0, 0);
        localToast.show();
      }
    });
  }

  @ReactMethod
  public void showWithGravityAndOffset(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    UiThreadUtil.runOnUiThread(new Runnable(paramString, paramInt1, paramInt2, paramInt3, paramInt4)
    {
      public void run()
      {
        Toast localToast = Toast.makeText(ToastModule.this.getReactApplicationContext(), this.val$message, this.val$duration);
        localToast.setGravity(this.val$gravity, this.val$xOffset, this.val$yOffset);
        localToast.show();
      }
    });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.toast.ToastModule
 * JD-Core Version:    0.6.0
 */