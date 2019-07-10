package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class SnackbarManager
{
  private static final int LONG_DURATION_MS = 2750;
  private static final int MSG_TIMEOUT = 0;
  private static final int SHORT_DURATION_MS = 1500;
  private static SnackbarManager sSnackbarManager;
  private SnackbarRecord mCurrentSnackbar;
  private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return false;
      case 0:
      }
      SnackbarManager.this.handleTimeout((SnackbarManager.SnackbarRecord)paramMessage.obj);
      return true;
    }
  });
  private final Object mLock = new Object();
  private SnackbarRecord mNextSnackbar;

  private boolean cancelSnackbarLocked(SnackbarRecord paramSnackbarRecord, int paramInt)
  {
    Callback localCallback = (Callback)paramSnackbarRecord.callback.get();
    if (localCallback != null)
    {
      this.mHandler.removeCallbacksAndMessages(paramSnackbarRecord);
      localCallback.dismiss(paramInt);
      return true;
    }
    return false;
  }

  static SnackbarManager getInstance()
  {
    if (sSnackbarManager == null)
      sSnackbarManager = new SnackbarManager();
    return sSnackbarManager;
  }

  private void handleTimeout(SnackbarRecord paramSnackbarRecord)
  {
    synchronized (this.mLock)
    {
      if ((this.mCurrentSnackbar == paramSnackbarRecord) || (this.mNextSnackbar == paramSnackbarRecord))
        cancelSnackbarLocked(paramSnackbarRecord, 2);
      return;
    }
  }

  private boolean isCurrentSnackbarLocked(Callback paramCallback)
  {
    return (this.mCurrentSnackbar != null) && (this.mCurrentSnackbar.isSnackbar(paramCallback));
  }

  private boolean isNextSnackbarLocked(Callback paramCallback)
  {
    return (this.mNextSnackbar != null) && (this.mNextSnackbar.isSnackbar(paramCallback));
  }

  private void scheduleTimeoutLocked(SnackbarRecord paramSnackbarRecord)
  {
    if (paramSnackbarRecord.duration == -2)
      return;
    int i = 2750;
    if (paramSnackbarRecord.duration > 0)
      i = paramSnackbarRecord.duration;
    while (true)
    {
      this.mHandler.removeCallbacksAndMessages(paramSnackbarRecord);
      this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, paramSnackbarRecord), i);
      return;
      if (paramSnackbarRecord.duration != -1)
        continue;
      int j = 1500;
    }
  }

  private void showNextSnackbarLocked()
  {
    if (this.mNextSnackbar != null)
    {
      this.mCurrentSnackbar = this.mNextSnackbar;
      this.mNextSnackbar = null;
      Callback localCallback = (Callback)this.mCurrentSnackbar.callback.get();
      if (localCallback != null)
        localCallback.show();
    }
    else
    {
      return;
    }
    this.mCurrentSnackbar = null;
  }

  public void cancelTimeout(Callback paramCallback)
  {
    synchronized (this.mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback))
        this.mHandler.removeCallbacksAndMessages(this.mCurrentSnackbar);
      return;
    }
  }

  public void dismiss(Callback paramCallback, int paramInt)
  {
    synchronized (this.mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback))
        cancelSnackbarLocked(this.mCurrentSnackbar, paramInt);
      do
        return;
      while (!isNextSnackbarLocked(paramCallback));
      cancelSnackbarLocked(this.mNextSnackbar, paramInt);
    }
  }

  public boolean isCurrent(Callback paramCallback)
  {
    synchronized (this.mLock)
    {
      boolean bool = isCurrentSnackbarLocked(paramCallback);
      return bool;
    }
  }

  public boolean isCurrentOrNext(Callback paramCallback)
  {
    while (true)
    {
      synchronized (this.mLock)
      {
        if (!isCurrentSnackbarLocked(paramCallback))
        {
          if (!isNextSnackbarLocked(paramCallback))
            break label40;
          break label35;
          return i;
        }
      }
      label35: int i = 1;
      continue;
      label40: i = 0;
    }
  }

  public void onDismissed(Callback paramCallback)
  {
    synchronized (this.mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback))
      {
        this.mCurrentSnackbar = null;
        if (this.mNextSnackbar != null)
          showNextSnackbarLocked();
      }
      return;
    }
  }

  public void onShown(Callback paramCallback)
  {
    synchronized (this.mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback))
        scheduleTimeoutLocked(this.mCurrentSnackbar);
      return;
    }
  }

  public void restoreTimeout(Callback paramCallback)
  {
    synchronized (this.mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback))
        scheduleTimeoutLocked(this.mCurrentSnackbar);
      return;
    }
  }

  public void show(int paramInt, Callback paramCallback)
  {
    while (true)
    {
      synchronized (this.mLock)
      {
        if (!isCurrentSnackbarLocked(paramCallback))
          continue;
        SnackbarRecord.access$102(this.mCurrentSnackbar, paramInt);
        this.mHandler.removeCallbacksAndMessages(this.mCurrentSnackbar);
        scheduleTimeoutLocked(this.mCurrentSnackbar);
        return;
        if (isNextSnackbarLocked(paramCallback))
        {
          SnackbarRecord.access$102(this.mNextSnackbar, paramInt);
          if ((this.mCurrentSnackbar == null) || (!cancelSnackbarLocked(this.mCurrentSnackbar, 4)))
            break;
          return;
        }
      }
      this.mNextSnackbar = new SnackbarRecord(paramInt, paramCallback);
    }
    this.mCurrentSnackbar = null;
    showNextSnackbarLocked();
    monitorexit;
  }

  static abstract interface Callback
  {
    public abstract void dismiss(int paramInt);

    public abstract void show();
  }

  private static class SnackbarRecord
  {
    private final WeakReference<SnackbarManager.Callback> callback;
    private int duration;

    SnackbarRecord(int paramInt, SnackbarManager.Callback paramCallback)
    {
      this.callback = new WeakReference(paramCallback);
      this.duration = paramInt;
    }

    boolean isSnackbar(SnackbarManager.Callback paramCallback)
    {
      return (paramCallback != null) && (this.callback.get() == paramCallback);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.SnackbarManager
 * JD-Core Version:    0.6.0
 */