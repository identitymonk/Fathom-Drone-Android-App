package com.brynk.fathom.controllers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.brynk.fathom.api.BatteryTask;
import com.brynk.fathom.api.DepthTask;
import com.brynk.fathom.api.HeadingTask;
import com.brynk.fathom.api.LightsTask;
import com.brynk.fathom.api.PitchYawTask;
import com.brynk.fathom.api.RecordingTask;
import com.brynk.fathom.api.StorageTask;
import com.brynk.fathom.api.TelemetryServerTask;
import com.brynk.fathom.api.TemperatureTask;
import com.brynk.fathom.api.ThrusterTask;
import com.brynk.fathom.api.WifiTask;
import com.brynk.fathom.helpers.Constants;
import com.brynk.fathom.helpers.CoordinateHelper;
import com.brynk.fathom.helpers.ExternalDevice;
import com.brynk.fathom.helpers.WiFiHelper;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.Action.Builder;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.appindexing.Thing.Builder;
import io.vov.vitamio.widget.MediaController;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
{
  private String DEBUG_TAG = "FATHOM1";
  private String DRONE_IP;
  private CoordinateHelper ch = null;
  private boolean connectedToFathomNetwork = false;
  private ExternalDevice externalDevice;
  private Boolean isRecording = Boolean.valueOf(false);
  private Boolean lightsOn = Boolean.valueOf(false);
  android.widget.VideoView loadingVideo = null;
  private MediaController mediaController;
  private String path = "udp://@:8000";
  DatagramSocket roll_socket = null;
  private Boolean shouldInvert = Boolean.valueOf(false);
  private Boolean shouldPitchHold = Boolean.valueOf(false);
  DatagramSocket thruster_socket = null;
  private io.vov.vitamio.widget.VideoView videoView;

  private AlertDialog buildWifiAlertDialog()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage("Connect to the Fathom Wifi Network.");
    localBuilder.setCancelable(false);
    localBuilder.setPositiveButton("Go to settings", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        paramDialogInterface.cancel();
        MainActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
      }
    });
    return localBuilder.create();
  }

  private void checkWifiStatus()
  {
    if (new WiFiHelper().isConnectedToFathomNetwork(getApplicationContext()))
    {
      Toast.makeText(getApplicationContext(), "Connected", 1);
      this.connectedToFathomNetwork = true;
      return;
    }
    buildWifiAlertDialog().show();
  }

  private void hidePitch()
  {
    FloatingActionButton localFloatingActionButton = (FloatingActionButton)findViewById(2131689663);
    TextView localTextView = (TextView)findViewById(2131689662);
    ThrusterTask localThrusterTask1 = setupThrusterTask();
    ThrusterTask localThrusterTask2 = setupThrusterTask();
    if (this.shouldPitchHold.booleanValue());
    for (String str = "PITCH_HOLD,375,1,1"; ; str = "PITCH,375,1,1")
    {
      localThrusterTask2.execute(new String[] { str });
      localThrusterTask1.execute(new String[] { "YAW,999999,1,1" });
      localFloatingActionButton.setVisibility(4);
      localTextView.setVisibility(4);
      return;
    }
  }

  private void hideThruster()
  {
    TextView localTextView1 = (TextView)findViewById(2131689660);
    TextView localTextView2 = (TextView)findViewById(2131689661);
    localTextView1.setVisibility(4);
    localTextView2.setVisibility(4);
    setupThrusterTask().execute(new String[] { "THRUST," + this.ch.getThrusterNeutral() + ",1,1" });
  }

  private void init()
  {
    this.videoView = ((io.vov.vitamio.widget.VideoView)findViewById(2131689637));
    this.mediaController = new MediaController(this);
  }

  private Boolean isLeftSide(MotionEvent paramMotionEvent)
  {
    TextView localTextView = (TextView)findViewById(2131689641);
    if (paramMotionEvent.getRawX() <= localTextView.getWidth() / 2);
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }

  private void movePitch(ArrayList paramArrayList, MotionEvent paramMotionEvent)
  {
    Object localObject = (FloatingActionButton)findViewById(2131689663);
    TextView localTextView = (TextView)findViewById(2131689662);
    ArrayList localArrayList = this.ch.boundCoord(paramMotionEvent, localTextView);
    ((FloatingActionButton)localObject).setX(((Float)localArrayList.get(0)).floatValue() - ((FloatingActionButton)localObject).getWidth() / 2);
    ((FloatingActionButton)localObject).setY(((Float)localArrayList.get(1)).floatValue() - ((FloatingActionButton)localObject).getHeight() / 2);
    localObject = setupThrusterTask();
    setupThrusterTask().execute(new String[] { "PITCH," + this.ch.boundThruster(paramMotionEvent, localTextView, this.shouldInvert, 30.0F) + ",1,1" });
    ((ThrusterTask)localObject).execute(new String[] { "YAW,999999," + this.ch.mapYawToServo(Float.valueOf(((Float)paramArrayList.get(0)).floatValue()), localTextView, Boolean.valueOf(false), 120.0F) });
  }

  private void moveThruster(ArrayList paramArrayList, MotionEvent paramMotionEvent)
  {
    TextView localTextView1 = (TextView)findViewById(2131689661);
    TextView localTextView2 = (TextView)findViewById(2131689659);
    localTextView1.setY(this.ch.boundThrusterTick(Float.valueOf(((Float)paramArrayList.get(1)).floatValue()), localTextView2).floatValue());
    setupThrusterTask().execute(new String[] { "THRUST," + this.ch.boundThruster(paramMotionEvent, localTextView2, Boolean.valueOf(false), 0.0F) + ",1,1" });
  }

  private void positionPitch(ArrayList paramArrayList)
  {
    FloatingActionButton localFloatingActionButton = (FloatingActionButton)findViewById(2131689663);
    TextView localTextView = (TextView)findViewById(2131689662);
    localFloatingActionButton.setX(((Float)paramArrayList.get(0)).floatValue() - localFloatingActionButton.getWidth() / 2);
    localFloatingActionButton.setY(((Float)paramArrayList.get(1)).floatValue() - localFloatingActionButton.getWidth() / 2);
    localFloatingActionButton.setVisibility(0);
    localTextView.setX(((Float)paramArrayList.get(0)).floatValue() - 150.0F);
    localTextView.setY(((Float)paramArrayList.get(1)).floatValue() - 150.0F);
    localTextView.setVisibility(0);
  }

  private void positionThruster(ArrayList paramArrayList)
  {
    TextView localTextView1 = (TextView)findViewById(2131689660);
    TextView localTextView2 = (TextView)findViewById(2131689661);
    TextView localTextView3 = (TextView)findViewById(2131689659);
    localTextView3.setX(((Float)paramArrayList.get(0)).floatValue() - 100.0F);
    localTextView3.setY(((Float)paramArrayList.get(1)).floatValue() - 150.0F);
    localTextView1.setX(((Float)paramArrayList.get(0)).floatValue() + 120.0F);
    localTextView1.setY(((Float)paramArrayList.get(1)).floatValue() - 200.0F);
    localTextView1.setVisibility(0);
    localTextView2.setX(((Float)paramArrayList.get(0)).floatValue() + 150.0F);
    localTextView2.setY(((Float)paramArrayList.get(1)).floatValue());
    localTextView2.setVisibility(0);
  }

  private PitchYawTask setupPitchYawTask()
  {
    PitchYawTask localPitchYawTask = new PitchYawTask();
    localPitchYawTask.setDRONE_IP(this.DRONE_IP);
    localPitchYawTask.setRoll_socket(this.roll_socket);
    return localPitchYawTask;
  }

  private void setupTelemtry()
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    View localView = getWindow().getDecorView().getRootView();
    TelemetryServerTask localTelemetryServerTask = new TelemetryServerTask(getApplicationContext(), getWindow().getDecorView().getRootView());
    if (Build.VERSION.SDK_INT >= 11)
      localTelemetryServerTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    while (true)
    {
      localScheduledExecutorService.scheduleAtFixedRate(new Runnable(localView)
      {
        public void run()
        {
          new DepthTask(MainActivity.this.getApplicationContext(), this.val$rootView, MainActivity.this.DRONE_IP).execute(new String[] { "blah" });
        }
      }
      , 0L, 1L, TimeUnit.SECONDS);
      localScheduledExecutorService.scheduleAtFixedRate(new Runnable(localView)
      {
        public void run()
        {
          new BatteryTask(MainActivity.this.getApplicationContext(), this.val$rootView, MainActivity.this.DRONE_IP).execute(new String[] { "blah" });
        }
      }
      , 0L, 30L, TimeUnit.SECONDS);
      localScheduledExecutorService.scheduleAtFixedRate(new Runnable(localView)
      {
        public void run()
        {
          new HeadingTask(MainActivity.this.getApplicationContext(), this.val$rootView, MainActivity.this.DRONE_IP).execute(new String[] { "blah" });
        }
      }
      , 0L, 1L, TimeUnit.SECONDS);
      localScheduledExecutorService.scheduleAtFixedRate(new Runnable(localView)
      {
        public void run()
        {
          new TemperatureTask(MainActivity.this.getApplicationContext(), this.val$rootView, MainActivity.this.DRONE_IP).execute(new String[] { "" });
        }
      }
      , 0L, 10L, TimeUnit.SECONDS);
      localScheduledExecutorService.scheduleAtFixedRate(new Runnable(localView)
      {
        public void run()
        {
          new StorageTask(MainActivity.this.getApplicationContext(), this.val$rootView, MainActivity.this.DRONE_IP).execute(new String[] { "" });
        }
      }
      , 0L, 1L, TimeUnit.MINUTES);
      localScheduledExecutorService.scheduleAtFixedRate(new Runnable(localView)
      {
        public void run()
        {
          new WifiTask(MainActivity.this.getApplicationContext(), this.val$rootView).execute(new String[] { "blah" });
        }
      }
      , 0L, 3L, TimeUnit.SECONDS);
      return;
      localTelemetryServerTask.execute(new String[] { "" });
    }
  }

  private ThrusterTask setupThrusterTask()
  {
    ThrusterTask localThrusterTask = new ThrusterTask();
    localThrusterTask.setDRONE_IP(this.DRONE_IP);
    localThrusterTask.setThruster_socket(this.thruster_socket);
    return localThrusterTask;
  }

  private void setupUDP()
  {
    try
    {
      this.thruster_socket = new DatagramSocket();
      this.roll_socket = new DatagramSocket();
      return;
    }
    catch (SocketException localSocketException)
    {
      localSocketException.printStackTrace();
    }
  }

  private void start_recording()
  {
    new RecordingTask(this.DRONE_IP).execute(new String[] { "start" });
  }

  private void stop_recording()
  {
    new RecordingTask(this.DRONE_IP).execute(new String[] { "stop" });
  }

  public Action getIndexApiAction()
  {
    Thing localThing = new Thing.Builder().setName("Main Page").setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]")).build();
    return new Action.Builder("http://schema.org/ViewAction").setObject(localThing).setActionStatus("http://schema.org/CompletedActionStatus").build();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968606);
    this.ch = new CoordinateHelper(getApplicationContext());
    this.DRONE_IP = new Constants().getDroneIp(getApplicationContext());
    this.externalDevice = new ExternalDevice(this.DRONE_IP, getApplicationContext());
    this.shouldInvert = new Constants().getPrefsInvert(getApplicationContext());
    getWindow().setFlags(1024, 1024);
    init();
    paramBundle = (RelativeLayout)findViewById(2131689665);
    this.loadingVideo = ((android.widget.VideoView)findViewById(2131689666));
    this.loadingVideo.setVideoPath("android.resource://" + getPackageName() + "/" + 2131165187);
    this.loadingVideo.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(android.media.MediaPlayer paramMediaPlayer)
      {
        paramMediaPlayer.setLooping(true);
      }
    });
    this.loadingVideo.start();
    checkWifiStatus();
    if (!this.connectedToFathomNetwork)
      return;
    setupUDP();
    try
    {
      this.videoView.setVideoURI(Uri.parse(this.path));
      this.videoView.setOnPreparedListener(new io.vov.vitamio.MediaPlayer.OnPreparedListener()
      {
        public void onPrepared(io.vov.vitamio.MediaPlayer paramMediaPlayer)
        {
          paramMediaPlayer.setPlaybackSpeed(1.0F);
          paramMediaPlayer.setBufferSize(1000L);
          MainActivity.this.videoView.setBufferSize(1000);
          paramMediaPlayer.start();
          MainActivity.this.videoView.start();
          paramMediaPlayer = (RelativeLayout)MainActivity.this.findViewById(2131689665);
          android.widget.VideoView localVideoView = (android.widget.VideoView)MainActivity.this.findViewById(2131689666);
          RelativeLayout localRelativeLayout = (RelativeLayout)MainActivity.this.findViewById(2131689636);
          new Handler().postDelayed(new Runnable(paramMediaPlayer, localVideoView, localRelativeLayout)
          {
            public void run()
            {
              this.val$rl_pilotLoader.setVisibility(4);
              this.val$rl_pilotLoader.setVisibility(8);
              this.val$loadingVideo.setVisibility(4);
              this.val$loadingVideo.setVisibility(8);
              this.val$rl_pilotViewWrapper.setVisibility(0);
            }
          }
          , 6000L);
        }
      });
      findViewById(2131689641).setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
        {
          Log.d("FATHOM1", "LEFT TOUCHED");
          int i = MotionEventCompat.getActionMasked(paramMotionEvent);
          paramView = (TextView)MainActivity.this.findViewById(2131689641);
          paramView = MainActivity.this.ch.boundCoordInTextView(paramMotionEvent, paramView);
          switch (i)
          {
          default:
            return true;
          case 0:
            MainActivity.this.positionThruster(paramView);
            return true;
          case 1:
            MainActivity.this.hideThruster();
            return true;
          case 2:
          }
          MainActivity.this.moveThruster(paramView, paramMotionEvent);
          return true;
        }
      });
      findViewById(2131689642).setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
        {
          int i = MotionEventCompat.getActionMasked(paramMotionEvent);
          paramView = (TextView)MainActivity.this.findViewById(2131689642);
          paramView = MainActivity.this.ch.boundCoordInTextView(paramMotionEvent, paramView);
          switch (i)
          {
          default:
            return true;
          case 0:
            MainActivity.this.positionPitch(paramView);
            return true;
          case 1:
            MainActivity.this.hidePitch();
            return true;
          case 2:
          }
          MainActivity.this.movePitch(paramView, paramMotionEvent);
          return true;
        }
      });
      return;
    }
    catch (Exception paramBundle)
    {
      while (true)
      {
        Toast.makeText(getApplicationContext(), paramBundle.getMessage(), 1).show();
        Log.d("FATHOM1", "Caught it");
      }
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755008, paramMenu);
    return true;
  }

  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    Log.v("FATHOM1", "GENERIC");
    if (((paramMotionEvent.getSource() & 0x1000010) == 16777232) && (paramMotionEvent.getAction() == 2))
    {
      this.externalDevice.processHistoricalEvents(paramMotionEvent, this.thruster_socket);
      this.externalDevice.processCurrentEvent(paramMotionEvent, this.thruster_socket);
      return true;
    }
    return super.onGenericMotionEvent(paramMotionEvent);
  }

  public void onLightsClicked(View paramView)
    throws Exception
  {
    FloatingActionButton localFloatingActionButton;
    if (this.lightsOn.booleanValue())
    {
      paramView = "off";
      localFloatingActionButton = (FloatingActionButton)findViewById(2131689664);
      if (this.lightsOn.booleanValue())
        break label96;
      localFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-256));
      label45: if (this.lightsOn.booleanValue())
        break label109;
    }
    label96: label109: for (boolean bool = true; ; bool = false)
    {
      this.lightsOn = Boolean.valueOf(bool);
      new LightsTask(this.DRONE_IP).execute(new String[] { paramView });
      return;
      paramView = "on";
      break;
      localFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-7829368));
      break label45;
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131689744)
      return true;
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onPause()
  {
    super.onPause();
  }

  public void onStart()
  {
    super.onStart();
    setupTelemtry();
  }

  public void onStop()
  {
    super.onStop();
  }

  public void toggleMode(View paramView)
  {
    paramView = (TextView)findViewById(2131689657);
    TextView localTextView1 = (TextView)findViewById(2131689658);
    TextView localTextView2 = (TextView)findViewById(2131689644);
    if (paramView.getVisibility() == 0)
    {
      paramView.setText("2");
      localTextView1.setText("4");
      this.ch.changeThrottleMinAndMax(Constants.DEFAULT_THROTTLE_MOD_PERCENT);
      this.ch.changePitchMinAndMax(Constants.DEFAULT_PITCH_MOD_PERCENT);
      paramView.setVisibility(4);
      localTextView1.setVisibility(4);
      localTextView2.setBackgroundColor(581610239);
      localTextView2.setTextColor(-1);
      return;
    }
    paramView.setVisibility(0);
    localTextView1.setVisibility(0);
    localTextView2.setBackgroundColor(-256);
    localTextView2.setTextColor(-7829368);
  }

  public void togglePitchHold(View paramView)
  {
    TextView localTextView = (TextView)findViewById(2131689645);
    boolean bool;
    if (!this.shouldPitchHold.booleanValue())
    {
      bool = true;
      this.shouldPitchHold = Boolean.valueOf(bool);
      if (!this.shouldPitchHold.booleanValue())
        break label75;
    }
    label75: for (paramView = "PH " + "ON"; ; paramView = "PH " + "OFF")
    {
      localTextView.setText(paramView);
      return;
      bool = false;
      break;
    }
  }

  public void togglePitchMod(View paramView)
  {
    TextView localTextView = (TextView)findViewById(2131689658);
    int j = Integer.parseInt(localTextView.getText().toString());
    int i = j + 1;
    paramView = Float.valueOf(1.0F);
    if (j == 10)
      i = 1;
    switch (i)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    }
    while (true)
    {
      this.ch.changePitchMinAndMax(paramView);
      localTextView.setText("" + i);
      return;
      paramView = Float.valueOf(0.1F);
      continue;
      paramView = Float.valueOf(0.2F);
      continue;
      paramView = Float.valueOf(0.3F);
      continue;
      paramView = Float.valueOf(0.4F);
      continue;
      paramView = Float.valueOf(0.5F);
      continue;
      paramView = Float.valueOf(0.6F);
      continue;
      paramView = Float.valueOf(0.7F);
      continue;
      paramView = Float.valueOf(0.8F);
      continue;
      paramView = Float.valueOf(0.9F);
      continue;
      paramView = Float.valueOf(1.0F);
    }
  }

  public void toggleRecordingClicked(View paramView)
  {
    paramView = "";
    FloatingActionButton localFloatingActionButton = (FloatingActionButton)findViewById(2131689635);
    if (this.isRecording.booleanValue())
    {
      stop_recording();
      paramView = "Stopped recording";
      localFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-7829368));
      if (this.isRecording.booleanValue())
        break label107;
    }
    label107: for (boolean bool = true; ; bool = false)
    {
      this.isRecording = Boolean.valueOf(bool);
      Toast.makeText(getApplicationContext(), paramView, 0).show();
      return;
      if (this.isRecording.booleanValue())
        break;
      start_recording();
      paramView = "Recording";
      localFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-65536));
      break;
    }
  }

  public void toggleSecondaryBar(View paramView)
  {
    paramView = (RelativeLayout)findViewById(2131689643);
    if (paramView.getVisibility() == 0)
    {
      paramView.setVisibility(4);
      return;
    }
    paramView.setVisibility(0);
  }

  public void toggleThrottleMod(View paramView)
  {
    TextView localTextView = (TextView)findViewById(2131689657);
    int j = Integer.parseInt(localTextView.getText().toString());
    int i = j + 1;
    paramView = Float.valueOf(1.0F);
    if (j == 10)
      i = 1;
    switch (i)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    }
    while (true)
    {
      this.ch.changeThrottleMinAndMax(paramView);
      localTextView.setText("" + i);
      return;
      paramView = Float.valueOf(0.1F);
      continue;
      paramView = Float.valueOf(0.2F);
      continue;
      paramView = Float.valueOf(0.3F);
      continue;
      paramView = Float.valueOf(0.4F);
      continue;
      paramView = Float.valueOf(0.5F);
      continue;
      paramView = Float.valueOf(0.6F);
      continue;
      paramView = Float.valueOf(0.7F);
      continue;
      paramView = Float.valueOf(0.8F);
      continue;
      paramView = Float.valueOf(0.9F);
      continue;
      paramView = Float.valueOf(1.0F);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.MainActivity
 * JD-Core Version:    0.6.0
 */