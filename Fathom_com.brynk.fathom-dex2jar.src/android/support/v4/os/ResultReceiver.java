package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResultReceiver
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator()
  {
    public ResultReceiver createFromParcel(Parcel paramParcel)
    {
      return new ResultReceiver(paramParcel);
    }

    public ResultReceiver[] newArray(int paramInt)
    {
      return new ResultReceiver[paramInt];
    }
  };
  final Handler mHandler;
  final boolean mLocal;
  IResultReceiver mReceiver;

  public ResultReceiver(Handler paramHandler)
  {
    this.mLocal = true;
    this.mHandler = paramHandler;
  }

  ResultReceiver(Parcel paramParcel)
  {
    this.mLocal = false;
    this.mHandler = null;
    this.mReceiver = IResultReceiver.Stub.asInterface(paramParcel.readStrongBinder());
  }

  public int describeContents()
  {
    return 0;
  }

  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
  }

  public void send(int paramInt, Bundle paramBundle)
  {
    if (this.mLocal)
      if (this.mHandler != null)
        this.mHandler.post(new MyRunnable(paramInt, paramBundle));
    do
    {
      return;
      onReceiveResult(paramInt, paramBundle);
      return;
    }
    while (this.mReceiver == null);
    try
    {
      this.mReceiver.send(paramInt, paramBundle);
      return;
    }
    catch (android.os.RemoteException paramBundle)
    {
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    monitorenter;
    try
    {
      if (this.mReceiver == null)
        this.mReceiver = new MyResultReceiver();
      paramParcel.writeStrongBinder(this.mReceiver.asBinder());
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramParcel;
  }

  class MyResultReceiver extends IResultReceiver.Stub
  {
    MyResultReceiver()
    {
    }

    public void send(int paramInt, Bundle paramBundle)
    {
      if (ResultReceiver.this.mHandler != null)
      {
        ResultReceiver.this.mHandler.post(new ResultReceiver.MyRunnable(ResultReceiver.this, paramInt, paramBundle));
        return;
      }
      ResultReceiver.this.onReceiveResult(paramInt, paramBundle);
    }
  }

  class MyRunnable
    implements Runnable
  {
    final int mResultCode;
    final Bundle mResultData;

    MyRunnable(int paramBundle, Bundle arg3)
    {
      this.mResultCode = paramBundle;
      Object localObject;
      this.mResultData = localObject;
    }

    public void run()
    {
      ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * JD-Core Version:    0.6.0
 */