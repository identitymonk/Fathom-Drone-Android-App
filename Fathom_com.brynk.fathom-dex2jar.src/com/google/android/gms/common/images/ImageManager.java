package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzsl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object Co = new Object();
  private static HashSet<Uri> Cp = new HashSet();
  private static ImageManager Cq;
  private static ImageManager Cr;
  private final ExecutorService Cs;
  private final zzb Ct;
  private final zzsl Cu;
  private final Map<zza, ImageReceiver> Cv;
  private final Map<Uri, ImageReceiver> Cw;
  private final Map<Uri, Long> Cx;
  private final Context mContext;
  private final Handler mHandler;

  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.Cs = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.Ct = new zzb(this.mContext);
      if (zzs.zzayq())
        zzaut();
    }
    while (true)
    {
      this.Cu = new zzsl();
      this.Cv = new HashMap();
      this.Cw = new HashMap();
      this.Cx = new HashMap();
      return;
      this.Ct = null;
    }
  }

  public static ImageManager create(Context paramContext)
  {
    return zzg(paramContext, false);
  }

  private Bitmap zza(zza.zza paramzza)
  {
    if (this.Ct == null)
      return null;
    return (Bitmap)this.Ct.get(paramzza);
  }

  @TargetApi(14)
  private void zzaut()
  {
    this.mContext.registerComponentCallbacks(new zze(this.Ct));
  }

  public static ImageManager zzg(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Cr == null)
        Cr = new ImageManager(paramContext, true);
      return Cr;
    }
    if (Cq == null)
      Cq = new ImageManager(paramContext, false);
    return Cq;
  }

  public void loadImage(ImageView paramImageView, int paramInt)
  {
    zza(new zza.zzb(paramImageView, paramInt));
  }

  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    zza(new zza.zzb(paramImageView, paramUri));
  }

  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new zza.zzb(paramImageView, paramUri);
    paramImageView.zzgg(paramInt);
    zza(paramImageView);
  }

  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    zza(new zza.zzc(paramOnImageLoadedListener, paramUri));
  }

  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new zza.zzc(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.zzgg(paramInt);
    zza(paramOnImageLoadedListener);
  }

  public void zza(zza paramzza)
  {
    zzc.zzhs("ImageManager.loadImage() must be called in the main thread");
    new zzd(paramzza).run();
  }

  @KeepName
  private final class ImageReceiver extends ResultReceiver
  {
    private final ArrayList<zza> Cy;
    private final Uri mUri;

    ImageReceiver(Uri arg2)
    {
      super();
      Object localObject;
      this.mUri = localObject;
      this.Cy = new ArrayList();
    }

    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zzf(ImageManager.this).execute(new ImageManager.zzc(ImageManager.this, this.mUri, paramBundle));
    }

    public void zzauv()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zzb(ImageManager.this).sendBroadcast(localIntent);
    }

    public void zzb(zza paramzza)
    {
      zzc.zzhs("ImageReceiver.addImageRequest() must be called in the main thread");
      this.Cy.add(paramzza);
    }

    public void zzc(zza paramzza)
    {
      zzc.zzhs("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.Cy.remove(paramzza);
    }
  }

  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }

  @TargetApi(11)
  private static final class zza
  {
    static int zza(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }

  private static final class zzb extends LruCache<zza.zza, Bitmap>
  {
    public zzb(Context paramContext)
    {
      super();
    }

    @TargetApi(11)
    private static int zzbz(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if ((paramContext.getApplicationInfo().flags & 0x100000) != 0)
      {
        i = 1;
        if ((i == 0) || (!zzs.zzayn()))
          break label55;
      }
      label55: for (int i = ImageManager.zza.zza(localActivityManager); ; i = localActivityManager.getMemoryClass())
      {
        return (int)(i * 1048576 * 0.33F);
        i = 0;
        break;
      }
    }

    protected int zza(zza.zza paramzza, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }

    protected void zza(boolean paramBoolean, zza.zza paramzza, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, paramzza, paramBitmap1, paramBitmap2);
    }
  }

  private final class zzc
    implements Runnable
  {
    private final ParcelFileDescriptor CA;
    private final Uri mUri;

    public zzc(Uri paramParcelFileDescriptor, ParcelFileDescriptor arg3)
    {
      this.mUri = paramParcelFileDescriptor;
      Object localObject;
      this.CA = localObject;
    }

    public void run()
    {
      zzc.zzht("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      boolean bool1 = false;
      boolean bool2 = false;
      Bitmap localBitmap = null;
      CountDownLatch localCountDownLatch = null;
      if (this.CA != null);
      try
      {
        localBitmap = BitmapFactory.decodeFileDescriptor(this.CA.getFileDescriptor());
        bool1 = bool2;
      }
      catch (IOException localIOException)
      {
        try
        {
          this.CA.close();
          localCountDownLatch = new CountDownLatch(1);
          ImageManager.zzg(ImageManager.this).post(new ImageManager.zzf(ImageManager.this, this.mUri, localBitmap, bool1, localCountDownLatch));
        }
        catch (IOException localIOException)
        {
          try
          {
            while (true)
            {
              localCountDownLatch.await();
              return;
              localOutOfMemoryError = localOutOfMemoryError;
              String str2 = String.valueOf(this.mUri);
              Log.e("ImageManager", String.valueOf(str2).length() + 34 + "OOM while loading bitmap for uri: " + str2, localOutOfMemoryError);
              bool1 = true;
              Object localObject = localCountDownLatch;
            }
            localIOException = localIOException;
            Log.e("ImageManager", "closed failed", localIOException);
          }
          catch (InterruptedException str1)
          {
            String str1 = String.valueOf(this.mUri);
            Log.w("ImageManager", String.valueOf(str1).length() + 32 + "Latch interrupted while posting " + str1);
          }
        }
      }
    }
  }

  private final class zzd
    implements Runnable
  {
    private final zza CB;

    public zzd(zza arg2)
    {
      Object localObject;
      this.CB = localObject;
    }

    public void run()
    {
      zzc.zzhs("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zza(ImageManager.this).get(this.CB);
      if (localObject1 != null)
      {
        ImageManager.zza(ImageManager.this).remove(this.CB);
        ((ImageManager.ImageReceiver)localObject1).zzc(this.CB);
      }
      zza.zza localzza = this.CB.CD;
      if (localzza.uri == null)
      {
        this.CB.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
        return;
      }
      localObject1 = ImageManager.zza(ImageManager.this, localzza);
      if (localObject1 != null)
      {
        this.CB.zza(ImageManager.zzb(ImageManager.this), (Bitmap)localObject1, true);
        return;
      }
      localObject1 = (Long)ImageManager.zzd(ImageManager.this).get(localzza.uri);
      if (localObject1 != null)
      {
        if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
        {
          this.CB.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
          return;
        }
        ImageManager.zzd(ImageManager.this).remove(localzza.uri);
      }
      this.CB.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this));
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).get(localzza.uri);
      localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, localzza.uri);
        ImageManager.zze(ImageManager.this).put(localzza.uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).zzb(this.CB);
      if (!(this.CB instanceof zza.zzc))
        ImageManager.zza(ImageManager.this).put(this.CB, localObject1);
      synchronized (ImageManager.zzaps())
      {
        if (!ImageManager.zzauu().contains(localzza.uri))
        {
          ImageManager.zzauu().add(localzza.uri);
          ((ImageManager.ImageReceiver)localObject1).zzauv();
        }
        return;
      }
    }
  }

  @TargetApi(14)
  private static final class zze
    implements ComponentCallbacks2
  {
    private final ImageManager.zzb Ct;

    public zze(ImageManager.zzb paramzzb)
    {
      this.Ct = paramzzb;
    }

    public void onConfigurationChanged(Configuration paramConfiguration)
    {
    }

    public void onLowMemory()
    {
      this.Ct.evictAll();
    }

    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60)
        this.Ct.evictAll();
      do
        return;
      while (paramInt < 20);
      this.Ct.trimToSize(this.Ct.size() / 2);
    }
  }

  private final class zzf
    implements Runnable
  {
    private boolean CC;
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch zzank;

    public zzf(Uri paramBitmap, Bitmap paramBoolean, boolean paramCountDownLatch, CountDownLatch arg5)
    {
      this.mUri = paramBitmap;
      this.mBitmap = paramBoolean;
      this.CC = paramCountDownLatch;
      Object localObject;
      this.zzank = localObject;
    }

    private void zza(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      paramImageReceiver = ImageManager.ImageReceiver.zza(paramImageReceiver);
      int j = paramImageReceiver.size();
      int i = 0;
      if (i < j)
      {
        zza localzza = (zza)paramImageReceiver.get(i);
        if (paramBoolean)
          localzza.zza(ImageManager.zzb(ImageManager.this), this.mBitmap, false);
        while (true)
        {
          if (!(localzza instanceof zza.zzc))
            ImageManager.zza(ImageManager.this).remove(localzza);
          i += 1;
          break;
          ImageManager.zzd(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          localzza.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), false);
        }
      }
    }

    public void run()
    {
      zzc.zzhs("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null)
        bool = true;
      while (ImageManager.zzh(ImageManager.this) != null)
      {
        if (this.CC)
        {
          ImageManager.zzh(ImageManager.this).evictAll();
          System.gc();
          this.CC = false;
          ImageManager.zzg(ImageManager.this).post(this);
          return;
          bool = false;
          continue;
        }
        if (!bool)
          break;
        ImageManager.zzh(ImageManager.this).put(new zza.zza(this.mUri), this.mBitmap);
      }
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).remove(this.mUri);
      if (??? != null)
        zza((ImageManager.ImageReceiver)???, bool);
      this.zzank.countDown();
      synchronized (ImageManager.zzaps())
      {
        ImageManager.zzauu().remove(this.mUri);
        return;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.6.0
 */