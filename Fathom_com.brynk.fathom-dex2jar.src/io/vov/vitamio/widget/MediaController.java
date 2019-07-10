package io.vov.vitamio.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import io.vov.vitamio.utils.Log;
import io.vov.vitamio.utils.StringUtils;
import java.lang.reflect.Method;

public class MediaController extends FrameLayout
{
  private static final int FADE_OUT = 1;
  private static final int SHOW_PROGRESS = 2;
  private static final int sDefaultTimeout = 3000;
  private AudioManager mAM;
  private View mAnchor;
  private int mAnimStyle;
  private Context mContext;
  private TextView mCurrentTime;
  private boolean mDragging;
  private long mDuration;
  private TextView mEndTime;
  private TextView mFileName;
  private boolean mFromXml = false;

  @SuppressLint({"HandlerLeak"})
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 1:
      case 2:
      }
      long l;
      do
      {
        return;
        MediaController.this.hide();
        return;
        l = MediaController.this.setProgress();
      }
      while ((MediaController.this.mDragging) || (!MediaController.this.mShowing));
      sendMessageDelayed(obtainMessage(2), 1000L - l % 1000L);
      MediaController.this.updatePausePlay();
    }
  };
  private OnHiddenListener mHiddenListener;
  private OutlineTextView mInfoView;
  private boolean mInstantSeeking = false;
  private ImageButton mPauseButton;
  private View.OnClickListener mPauseListener = new View.OnClickListener()
  {
    public void onClick(View paramView)
    {
      MediaController.this.doPauseResume();
      MediaController.this.show(3000);
    }
  };
  private MediaPlayerControl mPlayer;
  private SeekBar mProgress;
  private View mRoot;
  private SeekBar.OnSeekBarChangeListener mSeekListener = new SeekBar.OnSeekBarChangeListener()
  {
    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      if (!paramBoolean);
      do
      {
        return;
        long l = MediaController.this.mDuration * paramInt / 1000L;
        paramSeekBar = StringUtils.generateTime(l);
        if (MediaController.this.mInstantSeeking)
          MediaController.this.mPlayer.seekTo(l);
        if (MediaController.this.mInfoView == null)
          continue;
        MediaController.this.mInfoView.setText(paramSeekBar);
      }
      while (MediaController.this.mCurrentTime == null);
      MediaController.this.mCurrentTime.setText(paramSeekBar);
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      MediaController.access$102(MediaController.this, true);
      MediaController.this.show(3600000);
      MediaController.this.mHandler.removeMessages(2);
      if (MediaController.this.mInstantSeeking)
        MediaController.this.mAM.setStreamMute(3, true);
      if (MediaController.this.mInfoView != null)
      {
        MediaController.this.mInfoView.setText("");
        MediaController.this.mInfoView.setVisibility(0);
      }
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      if (!MediaController.this.mInstantSeeking)
        MediaController.this.mPlayer.seekTo(MediaController.this.mDuration * paramSeekBar.getProgress() / 1000L);
      if (MediaController.this.mInfoView != null)
      {
        MediaController.this.mInfoView.setText("");
        MediaController.this.mInfoView.setVisibility(8);
      }
      MediaController.this.show(3000);
      MediaController.this.mHandler.removeMessages(2);
      MediaController.this.mAM.setStreamMute(3, false);
      MediaController.access$102(MediaController.this, false);
      MediaController.this.mHandler.sendEmptyMessageDelayed(2, 1000L);
    }
  };
  private boolean mShowing;
  private OnShownListener mShownListener;
  private String mTitle;
  private PopupWindow mWindow;

  public MediaController(Context paramContext)
  {
    super(paramContext);
    if ((!this.mFromXml) && (initController(paramContext)))
      initFloatingWindow();
  }

  public MediaController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mRoot = this;
    this.mFromXml = true;
    initController(paramContext);
  }

  private void doPauseResume()
  {
    if (this.mPlayer.isPlaying())
      this.mPlayer.pause();
    while (true)
    {
      updatePausePlay();
      return;
      this.mPlayer.start();
    }
  }

  private boolean initController(Context paramContext)
  {
    this.mContext = paramContext;
    this.mAM = ((AudioManager)this.mContext.getSystemService("audio"));
    return true;
  }

  private void initControllerView(View paramView)
  {
    this.mPauseButton = ((ImageButton)paramView.findViewById(getResources().getIdentifier("mediacontroller_play_pause", "id", this.mContext.getPackageName())));
    if (this.mPauseButton != null)
    {
      this.mPauseButton.requestFocus();
      this.mPauseButton.setOnClickListener(this.mPauseListener);
    }
    this.mProgress = ((SeekBar)paramView.findViewById(getResources().getIdentifier("mediacontroller_seekbar", "id", this.mContext.getPackageName())));
    if (this.mProgress != null)
    {
      if ((this.mProgress instanceof SeekBar))
        this.mProgress.setOnSeekBarChangeListener(this.mSeekListener);
      this.mProgress.setMax(1000);
    }
    this.mEndTime = ((TextView)paramView.findViewById(getResources().getIdentifier("mediacontroller_time_total", "id", this.mContext.getPackageName())));
    this.mCurrentTime = ((TextView)paramView.findViewById(getResources().getIdentifier("mediacontroller_time_current", "id", this.mContext.getPackageName())));
    this.mFileName = ((TextView)paramView.findViewById(getResources().getIdentifier("mediacontroller_file_name", "id", this.mContext.getPackageName())));
    if (this.mFileName != null)
      this.mFileName.setText(this.mTitle);
  }

  private void initFloatingWindow()
  {
    this.mWindow = new PopupWindow(this.mContext);
    this.mWindow.setFocusable(false);
    this.mWindow.setBackgroundDrawable(null);
    this.mWindow.setOutsideTouchable(true);
    this.mAnimStyle = 16973824;
  }

  private long setProgress()
  {
    long l1;
    if ((this.mPlayer == null) || (this.mDragging))
      l1 = 0L;
    long l2;
    do
    {
      return l1;
      l2 = this.mPlayer.getCurrentPosition();
      l1 = this.mPlayer.getDuration();
      if (this.mProgress != null)
      {
        if (l1 > 0L)
        {
          long l3 = 1000L * l2 / l1;
          this.mProgress.setProgress((int)l3);
        }
        int i = this.mPlayer.getBufferPercentage();
        this.mProgress.setSecondaryProgress(i * 10);
      }
      this.mDuration = l1;
      if (this.mEndTime != null)
        this.mEndTime.setText(StringUtils.generateTime(this.mDuration));
      l1 = l2;
    }
    while (this.mCurrentTime == null);
    this.mCurrentTime.setText(StringUtils.generateTime(l2));
    return l2;
  }

  private void updatePausePlay()
  {
    if ((this.mRoot == null) || (this.mPauseButton == null))
      return;
    if (this.mPlayer.isPlaying())
    {
      this.mPauseButton.setImageResource(getResources().getIdentifier("mediacontroller_pause", "drawable", this.mContext.getPackageName()));
      return;
    }
    this.mPauseButton.setImageResource(getResources().getIdentifier("mediacontroller_play", "drawable", this.mContext.getPackageName()));
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    if ((paramKeyEvent.getRepeatCount() == 0) && ((i == 79) || (i == 85) || (i == 62)))
    {
      doPauseResume();
      show(3000);
      if (this.mPauseButton != null)
        this.mPauseButton.requestFocus();
    }
    while (true)
    {
      return true;
      if (i != 86)
        break;
      if (!this.mPlayer.isPlaying())
        continue;
      this.mPlayer.pause();
      updatePausePlay();
      return true;
    }
    if ((i == 4) || (i == 82))
    {
      hide();
      return true;
    }
    show(3000);
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public void hide()
  {
    if (this.mAnchor == null);
    while (true)
    {
      return;
      if (!this.mShowing)
        continue;
      try
      {
        this.mHandler.removeMessages(2);
        if (this.mFromXml)
          setVisibility(8);
        while (true)
        {
          this.mShowing = false;
          if (this.mHiddenListener == null)
            break;
          this.mHiddenListener.onHidden();
          return;
          this.mWindow.dismiss();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
          Log.d("MediaController already removed", new Object[0]);
      }
    }
  }

  public boolean isShowing()
  {
    return this.mShowing;
  }

  protected View makeControllerView()
  {
    return ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(getResources().getIdentifier("mediacontroller", "layout", this.mContext.getPackageName()), this);
  }

  public void onFinishInflate()
  {
    if (this.mRoot != null)
      initControllerView(this.mRoot);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    show(3000);
    return true;
  }

  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    show(3000);
    return false;
  }

  public void setAnchorView(View paramView)
  {
    this.mAnchor = paramView;
    if (!this.mFromXml)
    {
      removeAllViews();
      this.mRoot = makeControllerView();
      this.mWindow.setContentView(this.mRoot);
      this.mWindow.setWidth(-1);
      this.mWindow.setHeight(-2);
    }
    initControllerView(this.mRoot);
  }

  public void setAnimationStyle(int paramInt)
  {
    this.mAnimStyle = paramInt;
  }

  public void setEnabled(boolean paramBoolean)
  {
    if (this.mPauseButton != null)
      this.mPauseButton.setEnabled(paramBoolean);
    if (this.mProgress != null)
      this.mProgress.setEnabled(paramBoolean);
    super.setEnabled(paramBoolean);
  }

  public void setFileName(String paramString)
  {
    this.mTitle = paramString;
    if (this.mFileName != null)
      this.mFileName.setText(this.mTitle);
  }

  public void setInfoView(OutlineTextView paramOutlineTextView)
  {
    this.mInfoView = paramOutlineTextView;
  }

  public void setInstantSeeking(boolean paramBoolean)
  {
    this.mInstantSeeking = paramBoolean;
  }

  public void setMediaPlayer(MediaPlayerControl paramMediaPlayerControl)
  {
    this.mPlayer = paramMediaPlayerControl;
    updatePausePlay();
  }

  public void setOnHiddenListener(OnHiddenListener paramOnHiddenListener)
  {
    this.mHiddenListener = paramOnHiddenListener;
  }

  public void setOnShownListener(OnShownListener paramOnShownListener)
  {
    this.mShownListener = paramOnShownListener;
  }

  @TargetApi(16)
  public void setWindowLayoutType()
  {
    if (Build.VERSION.SDK_INT >= 14);
    try
    {
      this.mAnchor.setSystemUiVisibility(512);
      PopupWindow.class.getMethod("setWindowLayoutType", new Class[] { Integer.TYPE }).invoke(this.mWindow, new Object[] { Integer.valueOf(1003) });
      return;
    }
    catch (Exception localException)
    {
      Log.e("setWindowLayoutType", localException);
    }
  }

  public void show()
  {
    show(3000);
  }

  public void show(int paramInt)
  {
    if ((!this.mShowing) && (this.mAnchor != null) && (this.mAnchor.getWindowToken() != null))
    {
      if (this.mPauseButton != null)
        this.mPauseButton.requestFocus();
      if (!this.mFromXml)
        break label116;
      setVisibility(0);
    }
    while (true)
    {
      this.mShowing = true;
      if (this.mShownListener != null)
        this.mShownListener.onShown();
      updatePausePlay();
      this.mHandler.sendEmptyMessage(2);
      if (paramInt != 0)
      {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), paramInt);
      }
      return;
      label116: Object localObject = new int[2];
      this.mAnchor.getLocationOnScreen(localObject);
      localObject = new Rect(localObject[0], localObject[1], localObject[0] + this.mAnchor.getWidth(), localObject[1] + this.mAnchor.getHeight());
      this.mWindow.setAnimationStyle(this.mAnimStyle);
      setWindowLayoutType();
      this.mWindow.showAtLocation(this.mAnchor, 0, ((Rect)localObject).left, ((Rect)localObject).bottom);
    }
  }

  public static abstract interface MediaPlayerControl
  {
    public abstract int getBufferPercentage();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void seekTo(long paramLong);

    public abstract void start();
  }

  public static abstract interface OnHiddenListener
  {
    public abstract void onHidden();
  }

  public static abstract interface OnShownListener
  {
    public abstract void onShown();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.widget.MediaController
 * JD-Core Version:    0.6.0
 */