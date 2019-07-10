package com.brynk.fathom.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.brynk.fathom.helpers.WiFiHelper;
import java.util.concurrent.Executors;

public class WiFiSetupActivity extends AppCompatActivity
{
  private Boolean connectedToFathomNetwork = Boolean.valueOf(false);

  private void checkWifiStatus()
  {
    if (new WiFiHelper().isConnectedToFathomNetwork(getApplicationContext()))
    {
      this.connectedToFathomNetwork = Boolean.valueOf(true);
      ((ProgressBar)findViewById(2131689628)).setVisibility(4);
      ((TextView)findViewById(2131689679)).setVisibility(0);
      ((Button)findViewById(2131689680)).setVisibility(0);
    }
    Button localButton = (Button)findViewById(2131689680);
  }

  public void goToNextStep(View paramView)
  {
    startActivity(new Intent(this, WifiSetupStep2Activity.class));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968611);
    Executors.newSingleThreadScheduledExecutor();
    getWindow().getDecorView().getRootView();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        WiFiSetupActivity.this.checkWifiStatus();
      }
    }
    , 1000L);
  }

  public void onPause()
  {
    super.onPause();
    overridePendingTransition(0, 0);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.WiFiSetupActivity
 * JD-Core Version:    0.6.0
 */