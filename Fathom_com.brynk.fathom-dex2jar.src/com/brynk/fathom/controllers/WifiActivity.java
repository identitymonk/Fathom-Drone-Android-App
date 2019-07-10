package com.brynk.fathom.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import com.brynk.fathom.helpers.WiFiHelper;

public class WifiActivity extends AppCompatActivity
{
  public void goToMainScreen(View paramView)
  {
    startActivity(new Intent(this, LobbyActivity.class));
  }

  public void goToWifiScreen(View paramView)
  {
    startActivity(new Intent("android.settings.WIFI_SETTINGS"));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968612);
    setSupportActionBar((Toolbar)findViewById(2131689681));
    ((FloatingActionButton)findViewById(2131689635)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        Snackbar.make(paramView, "Replace with your own action", 0).setAction("Action", null).show();
      }
    });
    if (new WiFiHelper().isConnectedToFathomNetwork(getApplicationContext()))
      startActivity(new Intent(this, LobbyActivity.class));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.WifiActivity
 * JD-Core Version:    0.6.0
 */