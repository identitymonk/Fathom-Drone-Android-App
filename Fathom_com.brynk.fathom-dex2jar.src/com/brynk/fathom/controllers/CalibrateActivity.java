package com.brynk.fathom.controllers;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import com.brynk.fathom.helpers.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CalibrateActivity extends AppCompatActivity
{
  private String DRONE_IP;
  private VideoView loadingVideo;
  private int step;

  private void setStepVideo(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.loadingVideo = ((VideoView)findViewById(2131689619));
    this.loadingVideo.setVideoPath("android.resource://" + getPackageName() + "/" + paramInt);
    this.loadingVideo.seekTo(100);
    this.loadingVideo.start();
    this.loadingVideo.resume();
    this.loadingVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener(paramBoolean1, paramBoolean2)
    {
      public void onPrepared(MediaPlayer paramMediaPlayer)
      {
        paramMediaPlayer.setLooping(this.val$shouldLoop);
        if (this.val$shouldPlay)
          paramMediaPlayer.start();
      }
    });
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968601);
    setSupportActionBar((Toolbar)findViewById(2131689681));
    this.step = 1;
    this.DRONE_IP = new Constants().getDroneIp(getApplicationContext());
    this.loadingVideo = null;
    setStepVideo(2131165190, false, false);
  }

  public void onNextClicked(View paramView)
  {
    TextView localTextView = (TextView)findViewById(2131689620);
    paramView = "";
    switch (this.step)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (this.step < 8)
    {
      this.step += 1;
      localTextView.setText(paramView);
      return;
      paramView = "Turn left";
      setStepVideo(2131165194, false, true);
      continue;
      paramView = "Turn right";
      new CalibrateTask(this.DRONE_IP).execute(new String[] { "xmin" });
      setStepVideo(2131165195, false, true);
      continue;
      paramView = "Pitch down";
      new CalibrateTask(this.DRONE_IP).execute(new String[] { "xmax" });
      setStepVideo(2131165191, false, true);
      continue;
      paramView = "Pitch up";
      new CalibrateTask(this.DRONE_IP).execute(new String[] { "ymin" });
      setStepVideo(2131165192, false, true);
      continue;
      paramView = "Move up";
      new CalibrateTask(this.DRONE_IP).execute(new String[] { "ymax" });
      setStepVideo(2131165190, false, true);
      continue;
      paramView = "Move down";
      new CalibrateTask(this.DRONE_IP).execute(new String[] { "zmax" });
      setStepVideo(2131165189, false, true);
      continue;
      paramView = "Calibration successful";
      ((Button)findViewById(2131689621)).setText("Done");
      new CalibrateTask(this.DRONE_IP).execute(new String[] { "zmin" });
      setStepVideo(2131165190, false, false);
    }
    new CalibrateTask(this.DRONE_IP).execute(new String[] { "calc" });
    localTextView.setText(paramView);
    finish();
    this.step += 1;
  }

  private class CalibrateTask extends AsyncTask<String, Void, String>
  {
    private String DRONE_IP;

    public CalibrateTask(String arg2)
    {
      Object localObject;
      this.DRONE_IP = localObject;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      String str1 = paramArrayOfString[0];
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject1 = new URL("http://" + this.DRONE_IP + "/calibrate?direction=" + str1);
        paramArrayOfString = (String)localObject1;
        localObject1 = null;
      }
      catch (IOException paramArrayOfString)
      {
        try
        {
          paramArrayOfString = (HttpURLConnection)paramArrayOfString.openConnection();
        }
        catch (IOException paramArrayOfString)
        {
          try
          {
            label66: Object localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
            while (true)
            {
              String str2 = ((BufferedReader)localObject1).readLine();
              if (str2 == null)
                break;
              localStringBuilder.append(str2);
            }
          }
          catch (IOException localMalformedURLException)
          {
            Log.e("FATHOM1", "Error reading input from URL");
            localIOException.printStackTrace();
            while (true)
            {
              return "TODO";
              localMalformedURLException = localMalformedURLException;
              localMalformedURLException.printStackTrace();
              break;
              paramArrayOfString = paramArrayOfString;
              Log.e("FATHOM1", "Error establishing URL connection");
              paramArrayOfString.printStackTrace();
              paramArrayOfString = localMalformedURLException;
              break label66;
              Log.v("FATHOM1", "Calibrated " + str1);
              paramArrayOfString.disconnect();
              System.out.println(localStringBuilder.toString());
            }
          }
          finally
          {
            Log.v("FATHOM1", "Calibrated " + str1);
            paramArrayOfString.disconnect();
            System.out.println(localStringBuilder.toString());
          }
        }
      }
      throw localObject2;
    }

    protected void onPostExecute(String paramString)
    {
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.CalibrateActivity
 * JD-Core Version:    0.6.0
 */