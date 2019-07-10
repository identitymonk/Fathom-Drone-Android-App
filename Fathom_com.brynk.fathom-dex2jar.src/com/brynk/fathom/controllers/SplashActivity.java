package com.brynk.fathom.controllers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.VideoView;

public class SplashActivity extends AppCompatActivity
{
  private static final int UI_ANIMATION_DELAY = 0;
  private final int SPLASH_DISPLAY_LENGTH = 3000;
  private View mContentView;
  private final Handler mHideHandler = new Handler();
  private final Runnable mHidePart2Runnable = new Runnable()
  {
    @SuppressLint({"InlinedApi"})
    public void run()
    {
      SplashActivity.this.mContentView.setSystemUiVisibility(4871);
    }
  };

  private void checkWifiAndGo()
  {
    startActivity(new Intent(this, LobbyActivity.class));
  }

  private void hide()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
      localActionBar.hide();
    this.mHideHandler.postDelayed(this.mHidePart2Runnable, 0L);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hide();
    setContentView(2130968610);
    this.mContentView = findViewById(2131689675);
    paramBundle = (VideoView)findViewById(2131689676);
    paramBundle.setVideoPath("android.resource://" + getPackageName() + "/" + 2131165186);
    paramBundle.start();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        SplashActivity.this.checkWifiAndGo();
      }
    }
    , 3000L);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.SplashActivity
 * JD-Core Version:    0.6.0
 */