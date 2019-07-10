package com.facebook.react.modules.image;

import android.net.Uri;
import android.util.SparseArray;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import javax.annotation.Nullable;

@ReactModule(name="ImageLoader")
public class ImageLoaderModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  private static final String ERROR_GET_SIZE_FAILURE = "E_GET_SIZE_FAILURE";
  private static final String ERROR_INVALID_URI = "E_INVALID_URI";
  private static final String ERROR_PREFETCH_FAILURE = "E_PREFETCH_FAILURE";
  private final Object mCallerContext;
  private final Object mEnqueuedRequestMonitor = new Object();
  private final SparseArray<DataSource<Void>> mEnqueuedRequests = new SparseArray();

  public ImageLoaderModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mCallerContext = this;
  }

  public ImageLoaderModule(ReactApplicationContext paramReactApplicationContext, Object paramObject)
  {
    super(paramReactApplicationContext);
    this.mCallerContext = paramObject;
  }

  private void registerRequest(int paramInt, DataSource<Void> paramDataSource)
  {
    synchronized (this.mEnqueuedRequestMonitor)
    {
      this.mEnqueuedRequests.put(paramInt, paramDataSource);
      return;
    }
  }

  @Nullable
  private DataSource<Void> removeRequest(int paramInt)
  {
    synchronized (this.mEnqueuedRequestMonitor)
    {
      DataSource localDataSource = (DataSource)this.mEnqueuedRequests.get(paramInt);
      this.mEnqueuedRequests.remove(paramInt);
      return localDataSource;
    }
  }

  @ReactMethod
  public void abortRequest(int paramInt)
  {
    DataSource localDataSource = removeRequest(paramInt);
    if (localDataSource != null)
      localDataSource.close();
  }

  public String getName()
  {
    return "ImageLoader";
  }

  @ReactMethod
  public void getSize(String paramString, Promise paramPromise)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramPromise.reject("E_INVALID_URI", "Cannot get the size of an image for an empty URI");
      return;
    }
    paramString = ImageRequestBuilder.newBuilderWithSource(Uri.parse(paramString)).build();
    Fresco.getImagePipeline().fetchDecodedImage(paramString, this.mCallerContext).subscribe(new BaseDataSubscriber(paramPromise)
    {
      protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> paramDataSource)
      {
        this.val$promise.reject("E_GET_SIZE_FAILURE", paramDataSource.getFailureCause());
      }

      protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> paramDataSource)
      {
        if (!paramDataSource.isFinished())
          return;
        paramDataSource = (CloseableReference)paramDataSource.getResult();
        if (paramDataSource != null)
          try
          {
            CloseableImage localCloseableImage = (CloseableImage)paramDataSource.get();
            WritableMap localWritableMap = Arguments.createMap();
            localWritableMap.putInt("width", localCloseableImage.getWidth());
            localWritableMap.putInt("height", localCloseableImage.getHeight());
            this.val$promise.resolve(localWritableMap);
            return;
          }
          catch (Exception localException)
          {
            this.val$promise.reject("E_GET_SIZE_FAILURE", localException);
            return;
          }
          finally
          {
            CloseableReference.closeSafely(paramDataSource);
          }
        this.val$promise.reject("E_GET_SIZE_FAILURE");
      }
    }
    , CallerThreadExecutor.getInstance());
  }

  public void onHostDestroy()
  {
    Object localObject1 = this.mEnqueuedRequestMonitor;
    monitorenter;
    int i = 0;
    while (true)
    {
      try
      {
        int j = this.mEnqueuedRequests.size();
        if (i >= j)
          continue;
        DataSource localDataSource = (DataSource)this.mEnqueuedRequests.valueAt(i);
        if (localDataSource != null)
        {
          localDataSource.close();
          break label68;
          this.mEnqueuedRequests.clear();
          return;
        }
      }
      finally
      {
        monitorexit;
      }
      label68: i += 1;
    }
  }

  public void onHostPause()
  {
  }

  public void onHostResume()
  {
  }

  @ReactMethod
  public void prefetchImage(String paramString, int paramInt, Promise paramPromise)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramPromise.reject("E_INVALID_URI", "Cannot prefetch an image for an empty URI");
      return;
    }
    paramString = ImageRequestBuilder.newBuilderWithSource(Uri.parse(paramString)).build();
    paramString = Fresco.getImagePipeline().prefetchToDiskCache(paramString, this.mCallerContext);
    paramPromise = new BaseDataSubscriber(paramInt, paramPromise)
    {
      protected void onFailureImpl(DataSource<Void> paramDataSource)
      {
        try
        {
          ImageLoaderModule.this.removeRequest(this.val$requestId);
          this.val$promise.reject("E_PREFETCH_FAILURE", paramDataSource.getFailureCause());
          return;
        }
        finally
        {
          paramDataSource.close();
        }
        throw localObject;
      }

      protected void onNewResultImpl(DataSource<Void> paramDataSource)
      {
        if (!paramDataSource.isFinished())
          return;
        try
        {
          ImageLoaderModule.this.removeRequest(this.val$requestId);
          this.val$promise.resolve(Boolean.valueOf(true));
          return;
        }
        finally
        {
          paramDataSource.close();
        }
        throw localObject;
      }
    };
    registerRequest(paramInt, paramString);
    paramString.subscribe(paramPromise, CallerThreadExecutor.getInstance());
  }

  @ReactMethod
  public void queryCache(ReadableArray paramReadableArray, Promise paramPromise)
  {
    new GuardedAsyncTask(getReactApplicationContext(), paramReadableArray, paramPromise)
    {
      protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
      {
        paramArrayOfVoid = Arguments.createMap();
        ImagePipeline localImagePipeline = Fresco.getImagePipeline();
        int i = 0;
        if (i < this.val$uris.size())
        {
          String str = this.val$uris.getString(i);
          Uri localUri = Uri.parse(str);
          if (localImagePipeline.isInBitmapMemoryCache(localUri))
            paramArrayOfVoid.putString(str, "memory");
          while (true)
          {
            i += 1;
            break;
            if (!localImagePipeline.isInDiskCacheSync(localUri))
              continue;
            paramArrayOfVoid.putString(str, "disk");
          }
        }
        this.val$promise.resolve(paramArrayOfVoid);
      }
    }
    .executeOnExecutor(GuardedAsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.image.ImageLoaderModule
 * JD-Core Version:    0.6.0
 */