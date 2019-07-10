package com.brynk.fathom.controllers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnGenericMotionListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.brynk.fathom.api.BatteryTask;
import com.brynk.fathom.api.CalibrateESCsTask;
import com.brynk.fathom.api.LightsTask;
import com.brynk.fathom.api.StorageTask;
import com.brynk.fathom.api.TelemetryServerTask;
import com.brynk.fathom.api.TemperatureTask;
import com.brynk.fathom.api.ThrusterTask;
import com.brynk.fathom.api.WifiTask;
import com.brynk.fathom.helpers.Constants;
import com.brynk.fathom.helpers.CoordinateHelper;
import com.brynk.fathom.helpers.ExternalDevice;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

public class ReactActivity extends Activity
  implements DefaultHardwareBackBtnHandler
{
  public static int OVERLAY_PERMISSION_REQ_CODE = 1234;
  private Boolean isMockDrone = Boolean.valueOf(false);
  private Boolean isRecording = Boolean.valueOf(false);
  private ReactInstanceManager mReactInstanceManager;
  private ReactRootView mReactRootView;

  public void invokeDefaultOnBackPressed()
  {
    super.onBackPressed();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == OVERLAY_PERMISSION_REQ_CODE) && (Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(this)));
  }

  public void onBackPressed()
  {
    if (this.mReactInstanceManager != null)
    {
      this.mReactInstanceManager.onBackPressed();
      return;
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(128);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("drone_ip", new Constants().getDroneIp(getApplicationContext()));
    this.mReactRootView = new ReactRootView(this);
    this.mReactInstanceManager = ReactInstanceManager.builder().setApplication(getApplication()).setBundleAssetName("index.android.bundle").addPackage(new MainReactPackage()).setUseDeveloperSupport(false).setInitialLifecycleState(LifecycleState.RESUMED).build();
    this.mReactRootView.startReactApplication(this.mReactInstanceManager, "HelloWorld", (Bundle)localObject);
    localObject = new FrameLayout(this);
    ((FrameLayout)localObject).setId(2131689636);
    setContentView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    if (paramBundle == null)
    {
      paramBundle = new DebugExampleTwoFragment();
      DebugExampleThreeFragment localDebugExampleThreeFragment = new DebugExampleThreeFragment(this.mReactRootView);
      localDebugExampleThreeFragment.setArguments(new Bundle());
      getIntent().getExtras();
      paramBundle.setArguments(getIntent().getExtras());
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      getFragmentManager().beginTransaction().add(((FrameLayout)localObject).getId(), localDebugExampleThreeFragment).commit();
      localFragmentTransaction.add(((FrameLayout)localObject).getId(), paramBundle).commit();
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      Log.e("FATHOM", "Got this far");
      if (!Settings.canDrawOverlays(this))
      {
        paramBundle = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName()));
        Log.e("FATHOM", "Got this far 2");
        startActivityForResult(paramBundle, OVERLAY_PERMISSION_REQ_CODE);
      }
    }
    else
    {
      return;
    }
    Log.e("FATHOM", "Got this far 3");
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mReactInstanceManager != null)
      this.mReactInstanceManager.onHostDestroy();
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (this.mReactInstanceManager != null))
    {
      this.mReactInstanceManager.showDevOptionsDialog();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onPause()
  {
    super.onPause();
    if (this.mReactInstanceManager != null)
      this.mReactInstanceManager.onHostPause(this);
  }

  protected void onResume()
  {
    super.onResume();
    if (this.mReactInstanceManager != null)
      this.mReactInstanceManager.onHostResume(this, this);
  }

  @SuppressLint({"ValidFragment"})
  public static class DebugExampleThreeFragment extends Fragment
  {
    private ReactRootView reactRootView;

    @SuppressLint({"ValidFragment"})
    public DebugExampleThreeFragment(ReactRootView paramReactRootView)
    {
      this.reactRootView = paramReactRootView;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      return this.reactRootView;
    }
  }

  public static class DebugExampleTwoFragment extends Fragment
  {
    private String DRONE_IP = null;
    private String PHONE_LATITUDE = "-1";
    private String PHONE_LONGITUDE = "-1";
    private CoordinateHelper ch = null;
    private int drag_correction_forward = 375;
    private int drag_correction_reverse = 375;
    private ExternalDevice externalDevice;
    private Boolean isApplyingPitchYaw = Boolean.valueOf(false);
    private Boolean isApplyingThrust = Boolean.valueOf(false);
    private Boolean isAscending = Boolean.valueOf(false);
    private Boolean isDescending = Boolean.valueOf(false);
    private Boolean isMockDrone = Boolean.valueOf(false);
    private Boolean isRecording = Boolean.valueOf(false);
    private Boolean isZeroDegreeMode = Boolean.valueOf(false);
    private Boolean lightsOn = Boolean.valueOf(false);
    private WebSocketClient mWebSocketClient = null;
    private String path = "udp://@:8000";
    DatagramSocket roll_socket = null;
    private ScheduledExecutorService scheduler = null;
    private Boolean shouldInvert = Boolean.valueOf(false);
    private Boolean shouldPitchHold = Boolean.valueOf(false);
    DatagramSocket thruster_socket = null;
    private Boolean websocketConnected = Boolean.valueOf(false);

    private void calculateDragCorrection(int paramInt)
    {
      paramInt -= 50;
      this.drag_correction_forward = (paramInt + 375);
      this.drag_correction_reverse = (375 - paramInt);
    }

    private void connectWebSocket()
    {
      try
      {
        URI localURI = new URI("ws://" + this.DRONE_IP + ":9000");
        this.mWebSocketClient = new WebSocketClient(localURI)
        {
          public void onClose(int paramInt, String paramString, boolean paramBoolean)
          {
            Log.i("Websocket", "Closed " + paramString);
            ReactActivity.DebugExampleTwoFragment.access$1202(ReactActivity.DebugExampleTwoFragment.this, Boolean.valueOf(false));
          }

          public void onError(Exception paramException)
          {
            Log.e("FATHOM1", "Error " + paramException.getMessage());
          }

          public void onMessage(String paramString)
          {
          }

          public void onOpen(ServerHandshake paramServerHandshake)
          {
            Log.e("FATHOM1", "FATHOM is connected to websocket:" + ReactActivity.DebugExampleTwoFragment.this.DRONE_IP);
            Log.e("FATHOM1", "Opened");
            ReactActivity.DebugExampleTwoFragment.access$1202(ReactActivity.DebugExampleTwoFragment.this, Boolean.valueOf(true));
          }
        };
        this.mWebSocketClient.connect();
        return;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        localURISyntaxException.printStackTrace();
      }
    }

    private void disconnectWebSocket()
    {
      this.mWebSocketClient.close();
    }

    private void hidePitch()
    {
      FloatingActionButton localFloatingActionButton = (FloatingActionButton)getView().findViewById(2131689663);
      TextView localTextView = (TextView)getView().findViewById(2131689662);
      ThrusterTask localThrusterTask1 = setupThrusterTask();
      ThrusterTask localThrusterTask2 = setupThrusterTask();
      if (this.shouldPitchHold.booleanValue())
      {
        str = "PITCH_HOLD,375,1,1";
        localThrusterTask2.execute(new String[] { str });
        if (!this.isApplyingThrust.booleanValue())
          break label164;
      }
      label164: for (String str = "999999"; ; str = "375")
      {
        localThrusterTask1.execute(new String[] { "YAW," + str + ",1,1" });
        if (!this.isApplyingThrust.booleanValue())
          setupThrusterTask().execute(new String[] { "YAW,999999,1,1" });
        localFloatingActionButton.setVisibility(4);
        localTextView.setVisibility(4);
        return;
        str = "PITCH,375,1,1";
        break;
      }
    }

    private void hideThruster()
    {
      TextView localTextView1 = (TextView)getView().findViewById(2131689660);
      TextView localTextView2 = (TextView)getView().findViewById(2131689661);
      localTextView1.setVisibility(4);
      localTextView2.setVisibility(4);
      setupThrusterTask().execute(new String[] { "THRUST," + this.ch.getThrusterNeutral() + ",1,1" });
      setupThrusterTask().execute(new String[] { "PITCH,375,1,1" });
    }

    private void movePitch(ArrayList paramArrayList, MotionEvent paramMotionEvent)
    {
      Object localObject = (FloatingActionButton)getView().findViewById(2131689663);
      paramArrayList = (TextView)getView().findViewById(2131689662);
      ArrayList localArrayList = this.ch.boundCoord(paramMotionEvent, paramArrayList);
      ((FloatingActionButton)localObject).setX(((Float)localArrayList.get(0)).floatValue() - ((FloatingActionButton)localObject).getWidth() / 2);
      ((FloatingActionButton)localObject).setY(((Float)localArrayList.get(1)).floatValue() - ((FloatingActionButton)localObject).getHeight() / 2);
      localObject = setupThrusterTask();
      setupThrusterTask().execute(new String[] { "PITCH," + this.ch.boundPitch(paramMotionEvent, paramArrayList, this.shouldInvert, 120.0F) + ",1,1" });
      if (this.isApplyingThrust.booleanValue());
      while (true)
      {
        paramArrayList = this.ch.mapYawToServo(Float.valueOf(((Float)localArrayList.get(0)).floatValue()), paramArrayList, this.isZeroDegreeMode, 120.0F);
        ((ThrusterTask)localObject).execute(new String[] { "YAW," + "999999" + "," + paramArrayList });
        return;
      }
    }

    private void moveThruster(ArrayList paramArrayList, MotionEvent paramMotionEvent)
    {
      TextView localTextView = (TextView)getView().findViewById(2131689661);
      Object localObject = (TextView)getView().findViewById(2131689659);
      localTextView.setY(this.ch.boundThrusterTick(Float.valueOf(((Float)paramArrayList.get(1)).floatValue()), (TextView)localObject).floatValue());
      paramArrayList = setupThrusterTask();
      localObject = this.ch.boundThruster(paramMotionEvent, (TextView)localObject, Boolean.valueOf(false), 0.0F);
      paramArrayList.execute(new String[] { "THRUST," + localObject + ",1,1" });
      if (!this.isApplyingPitchYaw.booleanValue())
      {
        paramMotionEvent = setupThrusterTask();
        if (((Float)localObject).floatValue() <= Constants.SERVO_NEUTRAL.floatValue())
          break label209;
      }
      label209: for (paramArrayList = "" + this.drag_correction_forward; ; paramArrayList = "" + this.drag_correction_reverse)
      {
        paramMotionEvent.execute(new String[] { "PITCH_HOLD," + paramArrayList + ",1,1" });
        return;
      }
    }

    private void positionPitch(ArrayList paramArrayList)
    {
      FloatingActionButton localFloatingActionButton = (FloatingActionButton)getView().findViewById(2131689663);
      TextView localTextView = (TextView)getView().findViewById(2131689662);
      localFloatingActionButton.setX(((Float)paramArrayList.get(0)).floatValue() - localFloatingActionButton.getWidth() / 2);
      localFloatingActionButton.setY(((Float)paramArrayList.get(1)).floatValue() - localFloatingActionButton.getWidth() / 2);
      localFloatingActionButton.setVisibility(0);
      localTextView.setX(((Float)paramArrayList.get(0)).floatValue() - 150.0F);
      localTextView.setY(((Float)paramArrayList.get(1)).floatValue() - 150.0F);
      localTextView.setVisibility(0);
    }

    private void positionThruster(ArrayList paramArrayList)
    {
      TextView localTextView1 = (TextView)getView().findViewById(2131689660);
      TextView localTextView2 = (TextView)getView().findViewById(2131689661);
      TextView localTextView3 = (TextView)getView().findViewById(2131689659);
      localTextView3.setX(((Float)paramArrayList.get(0)).floatValue() - 100.0F);
      localTextView3.setY(((Float)paramArrayList.get(1)).floatValue() - 150.0F);
      localTextView1.setX(((Float)paramArrayList.get(0)).floatValue() + 120.0F);
      localTextView1.setY(((Float)paramArrayList.get(1)).floatValue() - 200.0F);
      localTextView1.setVisibility(0);
      localTextView2.setX(((Float)paramArrayList.get(0)).floatValue() + 150.0F);
      localTextView2.setY(((Float)paramArrayList.get(1)).floatValue());
      localTextView2.setVisibility(0);
    }

    private void setupTelemtry()
    {
      this.scheduler = Executors.newSingleThreadScheduledExecutor();
      View localView = getView().getRootView();
      TelemetryServerTask localTelemetryServerTask = new TelemetryServerTask(localView.getContext(), localView);
      if (Build.VERSION.SDK_INT >= 11)
        localTelemetryServerTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
      while (true)
      {
        this.scheduler.scheduleAtFixedRate(new Runnable(localView)
        {
          public void run()
          {
            new BatteryTask(this.val$rootView.getContext(), this.val$rootView, ReactActivity.DebugExampleTwoFragment.this.DRONE_IP).execute(new String[] { "blah" });
          }
        }
        , 0L, 30L, TimeUnit.SECONDS);
        this.scheduler.scheduleAtFixedRate(new Runnable(localView)
        {
          public void run()
          {
            new TemperatureTask(this.val$rootView.getContext(), this.val$rootView, ReactActivity.DebugExampleTwoFragment.this.DRONE_IP).execute(new String[] { "" });
          }
        }
        , 0L, 10L, TimeUnit.SECONDS);
        this.scheduler.scheduleAtFixedRate(new Runnable(localView)
        {
          public void run()
          {
            new StorageTask(this.val$rootView.getContext(), this.val$rootView, ReactActivity.DebugExampleTwoFragment.this.DRONE_IP).execute(new String[] { "" });
          }
        }
        , 0L, 1L, TimeUnit.MINUTES);
        this.scheduler.scheduleAtFixedRate(new Runnable(localView)
        {
          public void run()
          {
            new WifiTask(this.val$rootView.getContext(), this.val$rootView).execute(new String[] { "blah" });
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

    private void startOrStopRecording(boolean paramBoolean)
    {
      String str1;
      if (paramBoolean)
        str1 = "start";
      while (true)
      {
        String str2 = "";
        Object localObject2 = Calendar.getInstance().getTime();
        localObject2 = "" + ((Date)localObject2).getTime();
        try
        {
          str1 = new JSONObject().put("recording", str1).put("latitude", this.PHONE_LATITUDE).put("longitude", this.PHONE_LONGITUDE).put("when", localObject2).toString();
          this.mWebSocketClient.send(str1);
          return;
          str1 = "stop";
        }
        catch (JSONException localObject1)
        {
          while (true)
          {
            localJSONException.printStackTrace();
            Object localObject1 = str2;
          }
        }
      }
    }

    private void start_recording()
    {
      startOrStopRecording(true);
    }

    private void stopTelemtry()
    {
      this.scheduler.shutdownNow();
    }

    private void stop_recording()
    {
      startOrStopRecording(false);
    }

    public void calibrateESCs(View paramView)
    {
      Toast.makeText(paramView.getContext(), "Calibrating ESCs", 1).show();
      new CalibrateESCsTask(paramView.getContext(), paramView, this.DRONE_IP).execute(new String[] { "blah" });
    }

    public void moveVertically(View paramView, Boolean paramBoolean)
    {
      TextView localTextView1 = (TextView)paramView.findViewById(2131689646);
      TextView localTextView2 = (TextView)paramView.findViewById(2131689647);
      ThrusterTask localThrusterTask1 = setupThrusterTask();
      ThrusterTask localThrusterTask2 = setupThrusterTask();
      if (paramBoolean.booleanValue())
      {
        paramView = "390";
        if (!paramBoolean.booleanValue())
          break label204;
        if (!this.isAscending.booleanValue())
          break label167;
        this.isAscending = Boolean.valueOf(false);
        this.isDescending = Boolean.valueOf(false);
        paramView = "375";
        localTextView1.setBackgroundColor(Color.parseColor("#22aaaaff"));
        localTextView2.setBackgroundColor(Color.parseColor("#22aaaaff"));
      }
      while (true)
      {
        localThrusterTask2.execute(new String[] { "PITCH," + paramView + ",1,1" });
        localThrusterTask1.execute(new String[] { "THRUST,375,1,1" });
        return;
        paramView = "360";
        break;
        label167: this.isAscending = Boolean.valueOf(true);
        this.isDescending = Boolean.valueOf(false);
        localTextView1.setBackgroundColor(-256);
        localTextView2.setBackgroundColor(Color.parseColor("#22aaaaff"));
        continue;
        label204: if (this.isDescending.booleanValue())
        {
          this.isDescending = Boolean.valueOf(false);
          this.isAscending = Boolean.valueOf(false);
          paramView = "375";
          localTextView1.setBackgroundColor(Color.parseColor("#22aaaaff"));
          localTextView2.setBackgroundColor(Color.parseColor("#22aaaaff"));
          continue;
        }
        this.isDescending = Boolean.valueOf(true);
        this.isAscending = Boolean.valueOf(false);
        localTextView1.setBackgroundColor(Color.parseColor("#22aaaaff"));
        localTextView2.setBackgroundColor(-256);
      }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      paramBundle = getArguments();
      this.PHONE_LATITUDE = paramBundle.getString("PHONE_LATITUDE", "-1");
      this.PHONE_LONGITUDE = paramBundle.getString("PHONE_LONGITUDE", "-1");
      Log.d("FATHOM1", "LAT:" + this.PHONE_LATITUDE);
      Log.d("FATHOM1", "LONG:" + this.PHONE_LONGITUDE);
      paramLayoutInflater = paramLayoutInflater.inflate(2130968609, paramViewGroup, false);
      this.ch = new CoordinateHelper(paramLayoutInflater.getContext());
      this.DRONE_IP = new Constants().getDroneIp(paramLayoutInflater.getContext());
      paramViewGroup = new Constants().getDroneIp(paramLayoutInflater.getContext());
      if (this.DRONE_IP.equals(paramViewGroup))
        this.isMockDrone = Boolean.valueOf(true);
      this.externalDevice = new ExternalDevice(this.DRONE_IP, paramLayoutInflater.getContext());
      this.shouldInvert = new Constants().getPrefsInvert(paramLayoutInflater.getContext());
      setupUDP();
      paramLayoutInflater.setKeepScreenOn(true);
      paramLayoutInflater.setOnGenericMotionListener(new View.OnGenericMotionListener()
      {
        public boolean onGenericMotion(View paramView, MotionEvent paramMotionEvent)
        {
          if (paramMotionEvent.getAction() == 19)
            Log.d("FATHOM1", "UPPER");
          if (((paramMotionEvent.getSource() & 0x1000010) == 16777232) && (paramMotionEvent.getAction() == 2))
          {
            ReactActivity.DebugExampleTwoFragment.this.externalDevice.processHistoricalEvents(paramMotionEvent, ReactActivity.DebugExampleTwoFragment.this.thruster_socket);
            ReactActivity.DebugExampleTwoFragment.this.externalDevice.processCurrentEvent(paramMotionEvent, ReactActivity.DebugExampleTwoFragment.this.thruster_socket);
            return true;
          }
          return false;
        }
      });
      paramLayoutInflater.findViewById(2131689641).setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
        {
          int i = MotionEventCompat.getActionMasked(paramMotionEvent);
          Object localObject = (TextView)paramView.findViewById(2131689641);
          localObject = ReactActivity.DebugExampleTwoFragment.this.ch.boundCoordInTextView(paramMotionEvent, (TextView)localObject);
          switch (i)
          {
          default:
            return true;
          case 0:
            ReactActivity.DebugExampleTwoFragment.access$202(ReactActivity.DebugExampleTwoFragment.this, Boolean.valueOf(true));
            ReactActivity.DebugExampleTwoFragment.this.positionThruster((ArrayList)localObject);
            ReactActivity.DebugExampleTwoFragment.this.resetVerticalMovement(paramView);
            return true;
          case 1:
            ReactActivity.DebugExampleTwoFragment.access$202(ReactActivity.DebugExampleTwoFragment.this, Boolean.valueOf(false));
            ReactActivity.DebugExampleTwoFragment.this.hideThruster();
            return true;
          case 2:
          }
          ReactActivity.DebugExampleTwoFragment.access$202(ReactActivity.DebugExampleTwoFragment.this, Boolean.valueOf(true));
          ReactActivity.DebugExampleTwoFragment.this.moveThruster((ArrayList)localObject, paramMotionEvent);
          return true;
        }
      });
      paramLayoutInflater.findViewById(2131689642).setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
        {
          int i = MotionEventCompat.getActionMasked(paramMotionEvent);
          Object localObject = (TextView)paramView.findViewById(2131689642);
          localObject = ReactActivity.DebugExampleTwoFragment.this.ch.boundCoordInTextView(paramMotionEvent, (TextView)localObject);
          switch (i)
          {
          default:
            return true;
          case 0:
            ReactActivity.DebugExampleTwoFragment.access$602(ReactActivity.DebugExampleTwoFragment.this, Boolean.valueOf(true));
            ReactActivity.DebugExampleTwoFragment.this.positionPitch((ArrayList)localObject);
            ReactActivity.DebugExampleTwoFragment.this.resetVerticalMovement(paramView);
            return true;
          case 1:
            ReactActivity.DebugExampleTwoFragment.access$602(ReactActivity.DebugExampleTwoFragment.this, Boolean.valueOf(false));
            ReactActivity.DebugExampleTwoFragment.this.hidePitch();
            return true;
          case 2:
          }
          ReactActivity.DebugExampleTwoFragment.access$602(ReactActivity.DebugExampleTwoFragment.this, Boolean.valueOf(true));
          ReactActivity.DebugExampleTwoFragment.this.movePitch((ArrayList)localObject, paramMotionEvent);
          return true;
        }
      });
      paramLayoutInflater.findViewById(2131689654).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.toggleSecondaryBar(ReactActivity.DebugExampleTwoFragment.this.getView());
        }
      });
      paramLayoutInflater.findViewById(2131689644).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.toggleMode(ReactActivity.DebugExampleTwoFragment.this.getView());
        }
      });
      paramLayoutInflater.findViewById(2131689657).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.toggleThrottleMod(ReactActivity.DebugExampleTwoFragment.this.getView());
        }
      });
      paramLayoutInflater.findViewById(2131689658).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.togglePitchMod(ReactActivity.DebugExampleTwoFragment.this.getView());
        }
      });
      paramLayoutInflater.findViewById(2131689645).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.togglePitchHold(ReactActivity.DebugExampleTwoFragment.this.getView());
        }
      });
      paramLayoutInflater.findViewById(2131689669).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.toggleZeroDegreeMode(ReactActivity.DebugExampleTwoFragment.this.getView());
        }
      });
      paramLayoutInflater.findViewById(2131689646).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.moveVertically(ReactActivity.DebugExampleTwoFragment.this.getView(), Boolean.valueOf(true));
        }
      });
      paramLayoutInflater.findViewById(2131689647).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.moveVertically(ReactActivity.DebugExampleTwoFragment.this.getView(), Boolean.valueOf(false));
        }
      });
      paramLayoutInflater.findViewById(2131689673).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.calibrateESCs(ReactActivity.DebugExampleTwoFragment.this.getView());
        }
      });
      paramLayoutInflater.findViewById(2131689635).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.toggleRecordingClicked(ReactActivity.DebugExampleTwoFragment.this.getView());
        }
      });
      paramLayoutInflater.findViewById(2131689664).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ReactActivity.DebugExampleTwoFragment.this.toggleLights(ReactActivity.DebugExampleTwoFragment.this.getView());
        }
      });
      paramLayoutInflater.findViewById(2131689671).setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
        {
          return true;
        }
      });
      paramLayoutInflater.findViewById(2131689670).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ((RelativeLayout)ReactActivity.DebugExampleTwoFragment.this.getView().findViewById(2131689671)).setVisibility(0);
        }
      });
      paramLayoutInflater.findViewById(2131689674).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramView)
        {
          ((RelativeLayout)ReactActivity.DebugExampleTwoFragment.this.getView().findViewById(2131689671)).setVisibility(4);
        }
      });
      ((SeekBar)paramLayoutInflater.findViewById(2131689672)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
        {
          ReactActivity.DebugExampleTwoFragment.this.calculateDragCorrection(paramInt);
        }

        public void onStartTrackingTouch(SeekBar paramSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramSeekBar)
        {
        }
      });
      paramViewGroup = setupThrusterTask();
      setupThrusterTask().execute(new String[] { "PITCH,375,1,1" });
      paramViewGroup.execute(new String[] { "THRUST,375,1,1" });
      return paramLayoutInflater;
    }

    public void onPause()
    {
      super.onPause();
      stopTelemtry();
      disconnectWebSocket();
    }

    public void onStart()
    {
      super.onStart();
      setupTelemtry();
      connectWebSocket();
    }

    public void resetVerticalMovement(View paramView)
    {
      TextView localTextView = (TextView)paramView.getRootView().findViewById(2131689646);
      paramView = (TextView)paramView.getRootView().findViewById(2131689647);
      localTextView.setBackgroundColor(Color.parseColor("#22aaaaff"));
      paramView.setBackgroundColor(Color.parseColor("#22aaaaff"));
    }

    public void toggleLights(View paramView)
    {
      String str;
      if (this.lightsOn.booleanValue())
      {
        str = "off";
        paramView = (FloatingActionButton)paramView.findViewById(2131689664);
        if (this.lightsOn.booleanValue())
          break label96;
        paramView.setBackgroundTintList(ColorStateList.valueOf(-256));
        label45: if (this.lightsOn.booleanValue())
          break label109;
      }
      label96: label109: for (boolean bool = true; ; bool = false)
      {
        this.lightsOn = Boolean.valueOf(bool);
        new LightsTask(this.DRONE_IP).execute(new String[] { str });
        return;
        str = "on";
        break;
        paramView.setBackgroundTintList(ColorStateList.valueOf(-7829368));
        break label45;
      }
    }

    public void toggleMode(View paramView)
    {
      TextView localTextView1 = (TextView)paramView.findViewById(2131689657);
      TextView localTextView2 = (TextView)paramView.findViewById(2131689658);
      paramView = (TextView)paramView.findViewById(2131689644);
      if (localTextView1.getVisibility() == 0)
      {
        localTextView1.setText("1");
        localTextView2.setText("1");
        this.ch.changeThrottleMinAndMax(Constants.DEFAULT_THROTTLE_MOD_PERCENT);
        this.ch.changePitchMinAndMax(Constants.DEFAULT_PITCH_MOD_PERCENT);
        localTextView1.setVisibility(4);
        localTextView2.setVisibility(4);
        paramView.setBackgroundColor(581610239);
        paramView.setTextColor(-1);
        return;
      }
      localTextView1.setVisibility(0);
      localTextView2.setVisibility(0);
      paramView.setBackgroundColor(-256);
      paramView.setTextColor(-7829368);
    }

    public void togglePitchHold(View paramView)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131689645);
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
      TextView localTextView = (TextView)paramView.findViewById(2131689658);
      int j = Integer.parseInt(localTextView.getText().toString());
      int i = j + 1;
      paramView = Float.valueOf(0.15F);
      if (j == 3)
        i = 1;
      switch (i)
      {
      default:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        this.ch.changePitchMinAndMax(paramView);
        this.externalDevice.changePitchMinAndMax(paramView);
        localTextView.setText("" + i);
        return;
        paramView = Float.valueOf(0.15F);
        continue;
        paramView = Float.valueOf(0.2F);
        continue;
        paramView = Float.valueOf(0.5F);
      }
    }

    public void toggleRecordingClicked(View paramView)
    {
      boolean bool = true;
      String str = "";
      FloatingActionButton localFloatingActionButton = (FloatingActionButton)paramView.findViewById(2131689635);
      if (!this.websocketConnected.booleanValue())
      {
        Toast.makeText(paramView.getContext(), "Cannot connect to Fathom One camera", 1).show();
        return;
      }
      if (this.isRecording.booleanValue())
      {
        stop_recording();
        str = "Stopped recording";
        localFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-7829368));
        if (this.isRecording.booleanValue())
          break label135;
      }
      while (true)
      {
        this.isRecording = Boolean.valueOf(bool);
        Toast.makeText(paramView.getContext(), str, 0).show();
        return;
        if (this.isRecording.booleanValue())
          break;
        start_recording();
        str = "Recording";
        localFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-65536));
        break;
        label135: bool = false;
      }
    }

    public void toggleSecondaryBar(View paramView)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131689643);
      if (paramView.getVisibility() == 0)
        paramView.setVisibility(4);
      while (true)
      {
        Log.d("FATHOM1", "Pitch touched");
        return;
        paramView.setVisibility(0);
      }
    }

    public void toggleThrottleMod(View paramView)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131689657);
      int j = Integer.parseInt(localTextView.getText().toString());
      int i = j + 1;
      paramView = Float.valueOf(0.1F);
      if (j == 3)
        i = 1;
      switch (i)
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        this.ch.changeThrottleMinAndMax(paramView);
        this.externalDevice.changeThrottleMinAndMax(paramView);
        localTextView.setText("" + i);
        return;
        paramView = Float.valueOf(0.1F);
        continue;
        paramView = Float.valueOf(0.3F);
        continue;
        paramView = Float.valueOf(0.5F);
        continue;
        paramView = Float.valueOf(1.0F);
      }
    }

    public void toggleZeroDegreeMode(View paramView)
    {
      paramView = (TextView)paramView.findViewById(2131689669);
      Color.parseColor("#22aaaaff");
      boolean bool;
      if (!this.isZeroDegreeMode.booleanValue())
      {
        bool = true;
        this.isZeroDegreeMode = Boolean.valueOf(bool);
        if (!this.isZeroDegreeMode.booleanValue())
          break label66;
      }
      label66: for (int i = Color.parseColor("#22aaaaff"); ; i = -256)
      {
        paramView.setBackgroundColor(i);
        return;
        bool = false;
        break;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.ReactActivity
 * JD-Core Version:    0.6.0
 */