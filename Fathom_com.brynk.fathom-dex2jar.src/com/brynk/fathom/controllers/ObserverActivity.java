package com.brynk.fathom.controllers;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnPreparedListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class ObserverActivity extends AppCompatActivity
{
  private MediaController mediaController;
  private String path = "udp://@:8010";
  private VideoView videoView;

  private void init()
  {
    this.videoView = ((VideoView)findViewById(2131689667));
    this.mediaController = new MediaController(this);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968607);
    getWindow().setFlags(1024, 1024);
    init();
    this.videoView.setMediaController(this.mediaController);
    this.videoView.setVideoURI(Uri.parse(this.path));
    this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(MediaPlayer paramMediaPlayer)
      {
        paramMediaPlayer.setPlaybackSpeed(1.0F);
        ObserverActivity.this.videoView.seekTo(ObserverActivity.this.videoView.getDuration());
        ObserverActivity.this.videoView.start();
      }
    });
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.ObserverActivity
 * JD-Core Version:    0.6.0
 */