package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.BuildCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class MediaBrowserServiceCompat extends Service
{
  private static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
  public static final String KEY_MEDIA_ITEM = "media_item";
  private static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
  public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
  private static final String TAG = "MBServiceCompat";
  private final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap();
  private ConnectionRecord mCurConnection;
  private final ServiceHandler mHandler = new ServiceHandler(null);
  private MediaBrowserServiceImpl mImpl;
  MediaSessionCompat.Token mSession;

  private void addSubscription(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder, Bundle paramBundle)
  {
    Object localObject2 = (List)paramConnectionRecord.subscriptions.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
      localObject1 = new ArrayList();
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject2).next();
      if ((paramIBinder == localPair.first) && (MediaBrowserCompatUtils.areSameOptions(paramBundle, (Bundle)localPair.second)))
        return;
    }
    ((List)localObject1).add(new Pair(paramIBinder, paramBundle));
    paramConnectionRecord.subscriptions.put(paramString, localObject1);
    performLoadChildren(paramString, paramConnectionRecord, paramBundle);
  }

  private List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
  {
    if (paramList == null)
      paramBundle = null;
    int m;
    do
    {
      return paramBundle;
      i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
      m = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      if (i != -1)
        break;
      paramBundle = paramList;
    }
    while (m == -1);
    int k = m * i;
    int j = k + m;
    if ((i < 0) || (m < 1) || (k >= paramList.size()))
      return Collections.EMPTY_LIST;
    int i = j;
    if (j > paramList.size())
      i = paramList.size();
    return paramList.subList(k, i);
  }

  private boolean isValidPackage(String paramString, int paramInt)
  {
    if (paramString == null);
    while (true)
    {
      return false;
      String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
      int i = arrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        if (arrayOfString[paramInt].equals(paramString))
          return true;
        paramInt += 1;
      }
    }
  }

  private void performLoadChildren(String paramString, ConnectionRecord paramConnectionRecord, Bundle paramBundle)
  {
    1 local1 = new Result(paramString, paramConnectionRecord, paramString, paramBundle)
    {
      void onResultSent(List<MediaBrowserCompat.MediaItem> paramList, int paramInt)
      {
        if (MediaBrowserServiceCompat.this.mConnections.get(this.val$connection.callbacks.asBinder()) != this.val$connection)
        {
          if (MediaBrowserServiceCompat.DEBUG)
            Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.val$connection.pkg + " id=" + this.val$parentId);
          return;
        }
        if ((paramInt & 0x1) != 0)
          paramList = MediaBrowserServiceCompat.this.applyOptions(paramList, this.val$options);
        while (true)
          try
          {
            this.val$connection.callbacks.onLoadChildren(this.val$parentId, paramList, this.val$options);
            return;
          }
          catch (RemoteException paramList)
          {
            Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.val$parentId + " package=" + this.val$connection.pkg);
            return;
          }
      }
    };
    this.mCurConnection = paramConnectionRecord;
    if (paramBundle == null)
      onLoadChildren(paramString, local1);
    while (true)
    {
      this.mCurConnection = null;
      if (local1.isDone())
        break;
      throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + paramConnectionRecord.pkg + " id=" + paramString);
      onLoadChildren(paramString, local1, paramBundle);
    }
  }

  private void performLoadItem(String paramString, ConnectionRecord paramConnectionRecord, ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new Result(paramString, paramResultReceiver)
    {
      void onResultSent(MediaBrowserCompat.MediaItem paramMediaItem, int paramInt)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("media_item", paramMediaItem);
        this.val$receiver.send(0, localBundle);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onLoadItem(paramString, paramResultReceiver);
    this.mCurConnection = null;
    if (!paramResultReceiver.isDone())
      throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + paramString);
  }

  private boolean removeSubscription(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return paramConnectionRecord.subscriptions.remove(paramString) != null;
    int j = 0;
    int i = 0;
    List localList = (List)paramConnectionRecord.subscriptions.get(paramString);
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (paramIBinder != localPair.first)
          continue;
        i = 1;
        localList.remove(localPair);
      }
      j = i;
      if (localList.size() == 0)
      {
        paramConnectionRecord.subscriptions.remove(paramString);
        j = i;
      }
    }
    return j;
  }

  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
  }

  public final Bundle getBrowserRootHints()
  {
    return this.mImpl.getBrowserRootHints();
  }

  @Nullable
  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mSession;
  }

  public void notifyChildrenChanged(@NonNull String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    this.mImpl.notifyChildrenChanged(paramString, null);
  }

  public void notifyChildrenChanged(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if (paramString == null)
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    if (paramBundle == null)
      throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    this.mImpl.notifyChildrenChanged(paramString, paramBundle);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.mImpl.onBind(paramIntent);
  }

  public void onCreate()
  {
    super.onCreate();
    if ((Build.VERSION.SDK_INT >= 24) || (BuildCompat.isAtLeastN()))
      this.mImpl = new MediaBrowserServiceImplApi24();
    while (true)
    {
      this.mImpl.onCreate();
      return;
      if (Build.VERSION.SDK_INT >= 23)
      {
        this.mImpl = new MediaBrowserServiceImplApi23();
        continue;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mImpl = new MediaBrowserServiceImplApi21();
        continue;
      }
      this.mImpl = new MediaBrowserServiceImplBase();
    }
  }

  @Nullable
  public abstract BrowserRoot onGetRoot(@NonNull String paramString, int paramInt, @Nullable Bundle paramBundle);

  public abstract void onLoadChildren(@NonNull String paramString, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult);

  public void onLoadChildren(@NonNull String paramString, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult, @NonNull Bundle paramBundle)
  {
    paramResult.setFlags(1);
    onLoadChildren(paramString, paramResult);
  }

  public void onLoadItem(String paramString, Result<MediaBrowserCompat.MediaItem> paramResult)
  {
    paramResult.sendResult(null);
  }

  public void setSessionToken(MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null)
      throw new IllegalArgumentException("Session token may not be null.");
    if (this.mSession != null)
      throw new IllegalStateException("The session token has already been set.");
    this.mSession = paramToken;
    this.mImpl.setSessionToken(paramToken);
  }

  public static final class BrowserRoot
  {
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
    private final Bundle mExtras;
    private final String mRootId;

    public BrowserRoot(@NonNull String paramString, @Nullable Bundle paramBundle)
    {
      if (paramString == null)
        throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
      this.mRootId = paramString;
      this.mExtras = paramBundle;
    }

    public Bundle getExtras()
    {
      return this.mExtras;
    }

    public String getRootId()
    {
      return this.mRootId;
    }
  }

  private class ConnectionRecord
  {
    MediaBrowserServiceCompat.ServiceCallbacks callbacks;
    String pkg;
    MediaBrowserServiceCompat.BrowserRoot root;
    Bundle rootHints;
    HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap();

    private ConnectionRecord()
    {
    }
  }

  static abstract interface MediaBrowserServiceImpl
  {
    public abstract Bundle getBrowserRootHints();

    public abstract void notifyChildrenChanged(String paramString, Bundle paramBundle);

    public abstract IBinder onBind(Intent paramIntent);

    public abstract void onCreate();

    public abstract void setSessionToken(MediaSessionCompat.Token paramToken);
  }

  class MediaBrowserServiceImplApi21
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy
  {
    Messenger mMessenger;
    Object mServiceObj;

    MediaBrowserServiceImplApi21()
    {
    }

    public Bundle getBrowserRootHints()
    {
      if (this.mMessenger == null);
      do
      {
        return null;
        if (MediaBrowserServiceCompat.this.mCurConnection != null)
          continue;
        throw new IllegalStateException("This should be called inside of onLoadChildren or onLoadItem methods");
      }
      while (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null);
      return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
    }

    public void notifyChildrenChanged(String paramString, Bundle paramBundle)
    {
      if (this.mMessenger == null)
      {
        MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, paramString);
        return;
      }
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable(paramString, paramBundle)
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = (IBinder)localIterator.next();
            localObject1 = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject1);
            Object localObject2 = (List)((MediaBrowserServiceCompat.ConnectionRecord)localObject1).subscriptions.get(this.val$parentId);
            if (localObject2 == null)
              continue;
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Pair localPair = (Pair)((Iterator)localObject2).next();
              if (!MediaBrowserCompatUtils.hasDuplicatedItems(this.val$options, (Bundle)localPair.second))
                continue;
              MediaBrowserServiceCompat.this.performLoadChildren(this.val$parentId, (MediaBrowserServiceCompat.ConnectionRecord)localObject1, (Bundle)localPair.second);
            }
          }
        }
      });
    }

    public IBinder onBind(Intent paramIntent)
    {
      return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, paramIntent);
    }

    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
    }

    public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String paramString, int paramInt, Bundle paramBundle)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramBundle != null)
      {
        localObject1 = localObject2;
        if (paramBundle.getInt("extra_client_version", 0) != 0)
        {
          paramBundle.remove("extra_client_version");
          this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("extra_service_version", 1);
          BundleCompat.putBinder((Bundle)localObject1, "extra_messenger", this.mMessenger.getBinder());
        }
      }
      paramBundle = MediaBrowserServiceCompat.this.onGetRoot(paramString, paramInt, paramBundle);
      if (paramBundle == null)
        return null;
      if (localObject1 == null)
        paramString = paramBundle.getExtras();
      while (true)
      {
        return new MediaBrowserServiceCompatApi21.BrowserRoot(paramBundle.getRootId(), paramString);
        paramString = (String)localObject1;
        if (paramBundle.getExtras() == null)
          continue;
        ((Bundle)localObject1).putAll(paramBundle.getExtras());
        paramString = (String)localObject1;
      }
    }

    public void onLoadChildren(String paramString, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> paramResultWrapper)
    {
      paramResultWrapper = new MediaBrowserServiceCompat.Result(paramString, paramResultWrapper)
      {
        public void detach()
        {
          this.val$resultWrapper.detach();
        }

        void onResultSent(List<MediaBrowserCompat.MediaItem> paramList, int paramInt)
        {
          Object localObject = null;
          if (paramList != null)
          {
            ArrayList localArrayList = new ArrayList();
            paramList = paramList.iterator();
            while (true)
            {
              localObject = localArrayList;
              if (!paramList.hasNext())
                break;
              localObject = (MediaBrowserCompat.MediaItem)paramList.next();
              Parcel localParcel = Parcel.obtain();
              ((MediaBrowserCompat.MediaItem)localObject).writeToParcel(localParcel, 0);
              localArrayList.add(localParcel);
            }
          }
          this.val$resultWrapper.sendResult(localObject);
        }
      };
      MediaBrowserServiceCompat.this.onLoadChildren(paramString, paramResultWrapper);
    }

    public void setSessionToken(MediaSessionCompat.Token paramToken)
    {
      MediaBrowserServiceCompatApi21.setSessionToken(this.mServiceObj, paramToken.getToken());
    }
  }

  class MediaBrowserServiceImplApi23 extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
    implements MediaBrowserServiceCompatApi23.ServiceCompatProxy
  {
    MediaBrowserServiceImplApi23()
    {
      super();
    }

    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
    }

    public void onLoadItem(String paramString, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> paramResultWrapper)
    {
      paramResultWrapper = new MediaBrowserServiceCompat.Result(paramString, paramResultWrapper)
      {
        public void detach()
        {
          this.val$resultWrapper.detach();
        }

        void onResultSent(MediaBrowserCompat.MediaItem paramMediaItem, int paramInt)
        {
          Parcel localParcel = Parcel.obtain();
          paramMediaItem.writeToParcel(localParcel, 0);
          this.val$resultWrapper.sendResult(localParcel);
        }
      };
      MediaBrowserServiceCompat.this.onLoadItem(paramString, paramResultWrapper);
    }
  }

  class MediaBrowserServiceImplApi24 extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi23
    implements MediaBrowserServiceCompatApi24.ServiceCompatProxy
  {
    MediaBrowserServiceImplApi24()
    {
      super();
    }

    public Bundle getBrowserRootHints()
    {
      return MediaBrowserServiceCompatApi24.getBrowserRootHints(this.mServiceObj);
    }

    public void notifyChildrenChanged(String paramString, Bundle paramBundle)
    {
      if (paramBundle == null)
      {
        MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, paramString);
        return;
      }
      MediaBrowserServiceCompatApi24.notifyChildrenChanged(this.mServiceObj, paramString, paramBundle);
    }

    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi24.createService(MediaBrowserServiceCompat.this, this);
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
    }

    public void onLoadChildren(String paramString, MediaBrowserServiceCompatApi24.ResultWrapper paramResultWrapper, Bundle paramBundle)
    {
      paramResultWrapper = new MediaBrowserServiceCompat.Result(paramString, paramResultWrapper)
      {
        public void detach()
        {
          this.val$resultWrapper.detach();
        }

        void onResultSent(List<MediaBrowserCompat.MediaItem> paramList, int paramInt)
        {
          Object localObject = null;
          if (paramList != null)
          {
            ArrayList localArrayList = new ArrayList();
            paramList = paramList.iterator();
            while (true)
            {
              localObject = localArrayList;
              if (!paramList.hasNext())
                break;
              localObject = (MediaBrowserCompat.MediaItem)paramList.next();
              Parcel localParcel = Parcel.obtain();
              ((MediaBrowserCompat.MediaItem)localObject).writeToParcel(localParcel, 0);
              localArrayList.add(localParcel);
            }
          }
          this.val$resultWrapper.sendResult((List)localObject, paramInt);
        }
      };
      MediaBrowserServiceCompat.this.onLoadChildren(paramString, paramResultWrapper, paramBundle);
    }
  }

  class MediaBrowserServiceImplBase
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl
  {
    private Messenger mMessenger;

    MediaBrowserServiceImplBase()
    {
    }

    public Bundle getBrowserRootHints()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection == null)
        throw new IllegalStateException("This should be called inside of onLoadChildren or onLoadItem methods");
      if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null)
        return null;
      return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
    }

    public void notifyChildrenChanged(@NonNull String paramString, Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable(paramString, paramBundle)
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = (IBinder)localIterator.next();
            localObject1 = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject1);
            Object localObject2 = (List)((MediaBrowserServiceCompat.ConnectionRecord)localObject1).subscriptions.get(this.val$parentId);
            if (localObject2 == null)
              continue;
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Pair localPair = (Pair)((Iterator)localObject2).next();
              if (!MediaBrowserCompatUtils.hasDuplicatedItems(this.val$options, (Bundle)localPair.second))
                continue;
              MediaBrowserServiceCompat.this.performLoadChildren(this.val$parentId, (MediaBrowserServiceCompat.ConnectionRecord)localObject1, (Bundle)localPair.second);
            }
          }
        }
      });
    }

    public IBinder onBind(Intent paramIntent)
    {
      if ("android.media.browse.MediaBrowserService".equals(paramIntent.getAction()))
        return this.mMessenger.getBinder();
      return null;
    }

    public void onCreate()
    {
      this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
    }

    public void setSessionToken(MediaSessionCompat.Token paramToken)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable(paramToken)
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
          while (localIterator.hasNext())
          {
            IBinder localIBinder = (IBinder)localIterator.next();
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localIBinder);
            try
            {
              localConnectionRecord.callbacks.onConnect(localConnectionRecord.root.getRootId(), this.val$token, localConnectionRecord.root.getExtras());
            }
            catch (RemoteException localRemoteException)
            {
              Log.w("MBServiceCompat", "Connection for " + localConnectionRecord.pkg + " is no longer valid.");
              MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
            }
          }
        }
      });
    }
  }

  public static class Result<T>
  {
    private Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendResultCalled;

    Result(Object paramObject)
    {
      this.mDebug = paramObject;
    }

    public void detach()
    {
      if (this.mDetachCalled)
        throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
      if (this.mSendResultCalled)
        throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
      this.mDetachCalled = true;
    }

    boolean isDone()
    {
      return (this.mDetachCalled) || (this.mSendResultCalled);
    }

    void onResultSent(T paramT, int paramInt)
    {
    }

    public void sendResult(T paramT)
    {
      if (this.mSendResultCalled)
        throw new IllegalStateException("sendResult() called twice for: " + this.mDebug);
      this.mSendResultCalled = true;
      onResultSent(paramT, this.mFlags);
    }

    void setFlags(int paramInt)
    {
      this.mFlags = paramInt;
    }
  }

  private class ServiceBinderImpl
  {
    private ServiceBinderImpl()
    {
    }

    public void addSubscription(String paramString, IBinder paramIBinder, Bundle paramBundle, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(paramServiceCallbacks, paramString, paramIBinder, paramBundle)
      {
        public void run()
        {
          Object localObject = this.val$callbacks.asBinder();
          localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
          if (localObject == null)
          {
            Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.val$id);
            return;
          }
          MediaBrowserServiceCompat.this.addSubscription(this.val$id, (MediaBrowserServiceCompat.ConnectionRecord)localObject, this.val$token, this.val$options);
        }
      });
    }

    public void connect(String paramString, int paramInt, Bundle paramBundle, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if (!MediaBrowserServiceCompat.this.isValidPackage(paramString, paramInt))
        throw new IllegalArgumentException("Package/uid mismatch: uid=" + paramInt + " package=" + paramString);
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(paramServiceCallbacks, paramString, paramBundle, paramInt)
      {
        public void run()
        {
          IBinder localIBinder = this.val$callbacks.asBinder();
          MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, null);
          localConnectionRecord.pkg = this.val$pkg;
          localConnectionRecord.rootHints = this.val$rootHints;
          localConnectionRecord.callbacks = this.val$callbacks;
          localConnectionRecord.root = MediaBrowserServiceCompat.this.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
          if (localConnectionRecord.root == null)
            Log.i("MBServiceCompat", "No root for client " + this.val$pkg + " from service " + getClass().getName());
          while (true)
          {
            try
            {
              this.val$callbacks.onConnectFailed();
              return;
            }
            catch (RemoteException localRemoteException1)
            {
              Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.val$pkg);
              return;
            }
            try
            {
              MediaBrowserServiceCompat.this.mConnections.put(localRemoteException1, localConnectionRecord);
              if (MediaBrowserServiceCompat.this.mSession == null)
                continue;
              this.val$callbacks.onConnect(localConnectionRecord.root.getRootId(), MediaBrowserServiceCompat.this.mSession, localConnectionRecord.root.getExtras());
              return;
            }
            catch (RemoteException localRemoteException2)
            {
              Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.val$pkg);
              MediaBrowserServiceCompat.this.mConnections.remove(localRemoteException1);
            }
          }
        }
      });
    }

    public void disconnect(MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(paramServiceCallbacks)
      {
        public void run()
        {
          IBinder localIBinder = this.val$callbacks.asBinder();
          if ((MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(localIBinder) != null);
        }
      });
    }

    public void getMediaItem(String paramString, ResultReceiver paramResultReceiver, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramResultReceiver == null))
        return;
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(paramServiceCallbacks, paramString, paramResultReceiver)
      {
        public void run()
        {
          Object localObject = this.val$callbacks.asBinder();
          localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
          if (localObject == null)
          {
            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.val$mediaId);
            return;
          }
          MediaBrowserServiceCompat.this.performLoadItem(this.val$mediaId, (MediaBrowserServiceCompat.ConnectionRecord)localObject, this.val$receiver);
        }
      });
    }

    public void registerCallbacks(MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks, Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(paramServiceCallbacks, paramBundle)
      {
        public void run()
        {
          IBinder localIBinder = this.val$callbacks.asBinder();
          MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, null);
          localConnectionRecord.callbacks = this.val$callbacks;
          localConnectionRecord.rootHints = this.val$rootHints;
          MediaBrowserServiceCompat.this.mConnections.put(localIBinder, localConnectionRecord);
        }
      });
    }

    public void removeSubscription(String paramString, IBinder paramIBinder, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(paramServiceCallbacks, paramString, paramIBinder)
      {
        public void run()
        {
          Object localObject = this.val$callbacks.asBinder();
          localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
          if (localObject == null)
            Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.val$id);
          do
            return;
          while (MediaBrowserServiceCompat.this.removeSubscription(this.val$id, (MediaBrowserServiceCompat.ConnectionRecord)localObject, this.val$token));
          Log.w("MBServiceCompat", "removeSubscription called for " + this.val$id + " which is not subscribed");
        }
      });
    }

    public void unregisterCallbacks(MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(paramServiceCallbacks)
      {
        public void run()
        {
          IBinder localIBinder = this.val$callbacks.asBinder();
          MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
        }
      });
    }
  }

  private static abstract interface ServiceCallbacks
  {
    public abstract IBinder asBinder();

    public abstract void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException;

    public abstract void onConnectFailed()
      throws RemoteException;

    public abstract void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
      throws RemoteException;
  }

  private class ServiceCallbacksCompat
    implements MediaBrowserServiceCompat.ServiceCallbacks
  {
    final Messenger mCallbacks;

    ServiceCallbacksCompat(Messenger arg2)
    {
      Object localObject;
      this.mCallbacks = localObject;
    }

    private void sendRequest(int paramInt, Bundle paramBundle)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 1;
      localMessage.setData(paramBundle);
      this.mCallbacks.send(localMessage);
    }

    public IBinder asBinder()
    {
      return this.mCallbacks.getBinder();
    }

    public void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null)
        localBundle = new Bundle();
      localBundle.putInt("extra_service_version", 1);
      paramBundle = new Bundle();
      paramBundle.putString("data_media_item_id", paramString);
      paramBundle.putParcelable("data_media_session_token", paramToken);
      paramBundle.putBundle("data_root_hints", localBundle);
      sendRequest(1, paramBundle);
    }

    public void onConnectFailed()
      throws RemoteException
    {
      sendRequest(2, null);
    }

    public void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putBundle("data_options", paramBundle);
      if (paramList != null)
        if (!(paramList instanceof ArrayList))
          break label57;
      label57: for (paramString = (ArrayList)paramList; ; paramString = new ArrayList(paramList))
      {
        localBundle.putParcelableArrayList("data_media_item_list", paramString);
        sendRequest(3, localBundle);
        return;
      }
    }
  }

  private final class ServiceHandler extends Handler
  {
    private final MediaBrowserServiceCompat.ServiceBinderImpl mServiceBinderImpl = new MediaBrowserServiceCompat.ServiceBinderImpl(MediaBrowserServiceCompat.this, null);

    private ServiceHandler()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      Bundle localBundle = paramMessage.getData();
      switch (paramMessage.what)
      {
      default:
        Log.w("MBServiceCompat", "Unhandled message: " + paramMessage + "\n  Service version: " + 1 + "\n  Client version: " + paramMessage.arg1);
        return;
      case 1:
        this.mServiceBinderImpl.connect(localBundle.getString("data_package_name"), localBundle.getInt("data_calling_uid"), localBundle.getBundle("data_root_hints"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      case 2:
        this.mServiceBinderImpl.disconnect(new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      case 3:
        this.mServiceBinderImpl.addSubscription(localBundle.getString("data_media_item_id"), BundleCompat.getBinder(localBundle, "data_callback_token"), localBundle.getBundle("data_options"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      case 4:
        this.mServiceBinderImpl.removeSubscription(localBundle.getString("data_media_item_id"), BundleCompat.getBinder(localBundle, "data_callback_token"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      case 5:
        this.mServiceBinderImpl.getMediaItem(localBundle.getString("data_media_item_id"), (ResultReceiver)localBundle.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      case 6:
        this.mServiceBinderImpl.registerCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo), localBundle.getBundle("data_root_hints"));
        return;
      case 7:
      }
      this.mServiceBinderImpl.unregisterCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
    }

    public void postOrRun(Runnable paramRunnable)
    {
      if (Thread.currentThread() == getLooper().getThread())
      {
        paramRunnable.run();
        return;
      }
      post(paramRunnable);
    }

    public boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat
 * JD-Core Version:    0.6.0
 */