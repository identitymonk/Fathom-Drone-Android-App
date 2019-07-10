package com.facebook.react.devsupport;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.R.layout;
import com.facebook.react.R.string;
import com.facebook.react.bridge.UiThreadUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import javax.annotation.Nullable;

public class DevLoadingViewController
{
  private static final int COLOR_DARK_GREEN = Color.parseColor("#035900");
  private static boolean sEnabled = true;
  private final Context mContext;
  private TextView mDevLoadingView;
  private boolean mIsVisible = false;
  private final WindowManager mWindowManager;

  public DevLoadingViewController(Context paramContext)
  {
    this.mContext = paramContext;
    this.mWindowManager = ((WindowManager)this.mContext.getSystemService("window"));
    this.mDevLoadingView = ((TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(R.layout.dev_loading_view, null));
  }

  private boolean isWindowPermissionGranted()
  {
    return (Build.VERSION.SDK_INT < 23) || (Settings.canDrawOverlays(this.mContext)) || (this.mContext.checkSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0);
  }

  public static void setDevLoadingEnabled(boolean paramBoolean)
  {
    sEnabled = paramBoolean;
  }

  private void setVisible(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.mIsVisible))
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, WindowOverlayCompat.TYPE_SYSTEM_OVERLAY, 8, -3);
      localLayoutParams.gravity = 48;
      this.mWindowManager.addView(this.mDevLoadingView, localLayoutParams);
    }
    while (true)
    {
      this.mIsVisible = paramBoolean;
      return;
      if ((paramBoolean) || (!this.mIsVisible))
        continue;
      this.mWindowManager.removeView(this.mDevLoadingView);
    }
  }

  public void hide()
  {
    if (!sEnabled)
      return;
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevLoadingViewController.this.setVisible(false);
      }
    });
  }

  public void show()
  {
    if (!sEnabled)
      return;
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevLoadingViewController.this.setVisible(true);
      }
    });
  }

  public void showForRemoteJSEnabled()
  {
    showMessage(this.mContext.getString(R.string.catalyst_remotedbg_message), -1, COLOR_DARK_GREEN);
  }

  public void showForUrl(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      showMessage(this.mContext.getString(R.string.catalyst_loading_from_url, new Object[] { paramString.getHost() + ":" + paramString.getPort() }), -1, COLOR_DARK_GREEN);
      return;
    }
    catch (MalformedURLException paramString)
    {
      FLog.e("ReactNative", "Bundle url format is invalid. \n\n" + paramString.toString());
    }
  }

  public void showMessage(String paramString, int paramInt1, int paramInt2)
  {
    if ((!sEnabled) || (!isWindowPermissionGranted()))
      return;
    UiThreadUtil.runOnUiThread(new Runnable(paramInt2, paramString, paramInt1)
    {
      public void run()
      {
        DevLoadingViewController.this.mDevLoadingView.setBackgroundColor(this.val$backgroundColor);
        DevLoadingViewController.this.mDevLoadingView.setText(this.val$message);
        DevLoadingViewController.this.mDevLoadingView.setTextColor(this.val$color);
        DevLoadingViewController.this.setVisible(true);
      }
    });
  }

  public void updateProgress(@Nullable String paramString, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    if (!sEnabled)
      return;
    UiThreadUtil.runOnUiThread(new Runnable(paramString, paramInteger1, paramInteger2)
    {
      public void run()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.val$status != null);
        for (String str = this.val$status; ; str = "Loading")
        {
          localStringBuilder.append(str);
          if ((this.val$done != null) && (this.val$total != null) && (this.val$total.intValue() > 0))
            localStringBuilder.append(String.format(Locale.getDefault(), " %.1f%% (%d/%d)", new Object[] { Float.valueOf(this.val$done.intValue() / this.val$total.intValue() * 100.0F), this.val$done, this.val$total }));
          localStringBuilder.append("…");
          DevLoadingViewController.this.mDevLoadingView.setText(localStringBuilder);
          return;
        }
      }
    });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevLoadingViewController
 * JD-Core Version:    0.6.0
 */