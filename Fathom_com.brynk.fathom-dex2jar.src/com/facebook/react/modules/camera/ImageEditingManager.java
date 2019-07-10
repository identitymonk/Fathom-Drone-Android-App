package com.facebook.react.modules.camera;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="ImageEditingManager")
public class ImageEditingManager extends ReactContextBaseJavaModule
{
  private static final int COMPRESS_QUALITY = 90;

  @SuppressLint({"InlinedApi"})
  private static final String[] EXIF_ATTRIBUTES;
  private static final List<String> LOCAL_URI_PREFIXES = Arrays.asList(new String[] { "file://", "content://" });
  protected static final String NAME = "ImageEditingManager";
  private static final String TEMP_FILE_PREFIX = "ReactNative_cropped_image_";

  static
  {
    EXIF_ATTRIBUTES = new String[] { "FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance" };
  }

  public ImageEditingManager(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    new CleanTask(getReactApplicationContext(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  private static void copyExif(Context paramContext, Uri paramUri, File paramFile)
    throws IOException
  {
    paramContext = getFileFromUri(paramContext, paramUri);
    if (paramContext == null)
    {
      FLog.w("ReactNative", "Couldn't get real path for uri: " + paramUri);
      return;
    }
    paramContext = new ExifInterface(paramContext.getAbsolutePath());
    paramUri = new ExifInterface(paramFile.getAbsolutePath());
    paramFile = EXIF_ATTRIBUTES;
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      String str1 = paramFile[i];
      String str2 = paramContext.getAttribute(str1);
      if (str2 != null)
        paramUri.setAttribute(str1, str2);
      i += 1;
    }
    paramUri.saveAttributes();
  }

  private static File createTempFile(Context paramContext, @Nullable String paramString)
    throws IOException
  {
    File localFile = paramContext.getExternalCacheDir();
    paramContext = paramContext.getCacheDir();
    if ((localFile == null) && (paramContext == null))
      throw new IOException("No cache directory available");
    if (localFile == null);
    while (true)
    {
      return File.createTempFile("ReactNative_cropped_image_", getFileExtensionForType(paramString), paramContext);
      if (paramContext != null)
        break;
      paramContext = localFile;
    }
    if (localFile.getFreeSpace() > paramContext.getFreeSpace())
      paramContext = localFile;
    while (true)
      break;
  }

  private static Bitmap.CompressFormat getCompressFormatForType(String paramString)
  {
    if ("image/png".equals(paramString))
      return Bitmap.CompressFormat.PNG;
    if ("image/webp".equals(paramString))
      return Bitmap.CompressFormat.WEBP;
    return Bitmap.CompressFormat.JPEG;
  }

  private static int getDecodeSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    int j = 1;
    if ((paramInt2 > paramInt3) || (paramInt1 > paramInt4))
    {
      paramInt2 /= 2;
      int k = paramInt1 / 2;
      paramInt1 = j;
      while (true)
      {
        i = paramInt1;
        if (k / paramInt1 < paramInt3)
          break;
        i = paramInt1;
        if (paramInt2 / paramInt1 < paramInt4)
          break;
        paramInt1 *= 2;
      }
    }
    return i;
  }

  private static String getFileExtensionForType(@Nullable String paramString)
  {
    if ("image/png".equals(paramString))
      return ".png";
    if ("image/webp".equals(paramString))
      return ".webp";
    return ".jpg";
  }

  @Nullable
  private static File getFileFromUri(Context paramContext, Uri paramUri)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramUri.getScheme().equals("file"))
      localObject1 = new File(paramUri.getPath());
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      }
      while (!paramUri.getScheme().equals("content"));
      paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
      localObject1 = localObject2;
    }
    while (paramContext == null);
    try
    {
      if (paramContext.moveToFirst())
      {
        paramUri = paramContext.getString(0);
        if (!TextUtils.isEmpty(paramUri))
        {
          paramUri = new File(paramUri);
          return paramUri;
        }
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
    throw paramUri;
  }

  private static boolean isLocalUri(String paramString)
  {
    Iterator localIterator = LOCAL_URI_PREFIXES.iterator();
    while (localIterator.hasNext())
      if (paramString.startsWith((String)localIterator.next()))
        return true;
    return false;
  }

  private static void writeCompressedBitmapToFile(Bitmap paramBitmap, String paramString, File paramFile)
    throws IOException
  {
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramBitmap.compress(getCompressFormatForType(paramString), 90, paramFile);
      return;
    }
    finally
    {
      if (paramFile != null)
        paramFile.close();
    }
    throw paramBitmap;
  }

  @ReactMethod
  public void cropImage(String paramString, ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    ReadableMap localReadableMap1;
    if (paramReadableMap.hasKey("offset"))
    {
      localReadableMap1 = paramReadableMap.getMap("offset");
      if (!paramReadableMap.hasKey("size"))
        break label125;
    }
    label125: for (ReadableMap localReadableMap2 = paramReadableMap.getMap("size"); ; localReadableMap2 = null)
    {
      if ((localReadableMap1 != null) && (localReadableMap2 != null) && (localReadableMap1.hasKey("x")) && (localReadableMap1.hasKey("y")) && (localReadableMap2.hasKey("width")) && (localReadableMap2.hasKey("height")))
        break label131;
      throw new JSApplicationIllegalArgumentException("Please specify offset and size");
      localReadableMap1 = null;
      break;
    }
    label131: if ((paramString == null) || (paramString.isEmpty()))
      throw new JSApplicationIllegalArgumentException("Please specify a URI");
    paramString = new CropTask(getReactApplicationContext(), paramString, (int)localReadableMap1.getDouble("x"), (int)localReadableMap1.getDouble("y"), (int)localReadableMap2.getDouble("width"), (int)localReadableMap2.getDouble("height"), paramCallback1, paramCallback2, null);
    if (paramReadableMap.hasKey("displaySize"))
    {
      paramReadableMap = paramReadableMap.getMap("displaySize");
      paramString.setTargetSize((int)paramReadableMap.getDouble("width"), (int)paramReadableMap.getDouble("height"));
    }
    paramString.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public Map<String, Object> getConstants()
  {
    return Collections.emptyMap();
  }

  public String getName()
  {
    return "ImageEditingManager";
  }

  public void onCatalystInstanceDestroy()
  {
    new CleanTask(getReactApplicationContext(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  private static class CleanTask extends GuardedAsyncTask<Void, Void>
  {
    private final Context mContext;

    private CleanTask(ReactContext paramReactContext)
    {
      super();
      this.mContext = paramReactContext;
    }

    private void cleanDirectory(File paramFile)
    {
      paramFile = paramFile.listFiles(new FilenameFilter()
      {
        public boolean accept(File paramFile, String paramString)
        {
          return paramString.startsWith("ReactNative_cropped_image_");
        }
      });
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          paramFile[i].delete();
          i += 1;
        }
      }
    }

    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      cleanDirectory(this.mContext.getCacheDir());
      paramArrayOfVoid = this.mContext.getExternalCacheDir();
      if (paramArrayOfVoid != null)
        cleanDirectory(paramArrayOfVoid);
    }
  }

  private static class CropTask extends GuardedAsyncTask<Void, Void>
  {
    final Context mContext;
    final Callback mError;
    final int mHeight;
    final Callback mSuccess;
    int mTargetHeight = 0;
    int mTargetWidth = 0;
    final String mUri;
    final int mWidth;
    final int mX;
    final int mY;

    private CropTask(ReactContext paramReactContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Callback paramCallback1, Callback paramCallback2)
    {
      super();
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 <= 0) || (paramInt4 <= 0))
        throw new JSApplicationIllegalArgumentException(String.format("Invalid crop rectangle: [%d, %d, %d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      this.mContext = paramReactContext;
      this.mUri = paramString;
      this.mX = paramInt1;
      this.mY = paramInt2;
      this.mWidth = paramInt3;
      this.mHeight = paramInt4;
      this.mSuccess = paramCallback1;
      this.mError = paramCallback2;
    }

    private Bitmap crop(BitmapFactory.Options paramOptions)
      throws IOException
    {
      InputStream localInputStream = openBitmapInputStream();
      BitmapRegionDecoder localBitmapRegionDecoder = BitmapRegionDecoder.newInstance(localInputStream, false);
      try
      {
        paramOptions = localBitmapRegionDecoder.decodeRegion(new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), paramOptions);
        return paramOptions;
      }
      finally
      {
        if (localInputStream != null)
          localInputStream.close();
        localBitmapRegionDecoder.recycle();
      }
      throw paramOptions;
    }

    private Bitmap cropAndResize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
      throws IOException
    {
      Assertions.assertNotNull(paramOptions);
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      InputStream localInputStream = openBitmapInputStream();
      float f2;
      float f3;
      float f4;
      float f5;
      while (true)
      {
        try
        {
          BitmapFactory.decodeStream(localInputStream, null, (BitmapFactory.Options)localObject);
          if (localInputStream == null)
            continue;
          localInputStream.close();
          f2 = this.mWidth / this.mHeight;
          f1 = paramInt1 / paramInt2;
          if (f2 > f1)
          {
            f2 = this.mHeight * f1;
            f1 = this.mHeight;
            f3 = this.mX + (this.mWidth - f2) / 2.0F;
            f4 = this.mY;
            f5 = paramInt2 / this.mHeight;
            paramOptions.inSampleSize = ImageEditingManager.access$600(this.mWidth, this.mHeight, paramInt1, paramInt2);
            ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
            localInputStream = openBitmapInputStream();
            try
            {
              localObject = BitmapFactory.decodeStream(localInputStream, null, paramOptions);
              if (localObject != null)
                break;
              throw new IOException("Cannot decode bitmap: " + this.mUri);
            }
            finally
            {
              if (localInputStream == null)
                continue;
              localInputStream.close();
            }
          }
        }
        finally
        {
          if (localInputStream == null)
            continue;
          localInputStream.close();
        }
        f2 = this.mWidth;
        f1 = this.mWidth / f1;
        f3 = this.mX;
        f4 = this.mY + (this.mHeight - f1) / 2.0F;
        f5 = paramInt1 / this.mWidth;
      }
      if (localInputStream != null)
        localInputStream.close();
      paramInt1 = (int)Math.floor(f3 / paramOptions.inSampleSize);
      paramInt2 = (int)Math.floor(f4 / paramOptions.inSampleSize);
      int i = (int)Math.floor(f2 / paramOptions.inSampleSize);
      int j = (int)Math.floor(f1 / paramOptions.inSampleSize);
      float f1 = f5 * paramOptions.inSampleSize;
      paramOptions = new Matrix();
      paramOptions.setScale(f1, f1);
      return (Bitmap)Bitmap.createBitmap((Bitmap)localObject, paramInt1, paramInt2, i, j, paramOptions, true);
    }

    private InputStream openBitmapInputStream()
      throws IOException
    {
      if (ImageEditingManager.access$200(this.mUri));
      for (InputStream localInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mUri)); localInputStream == null; localInputStream = new URL(this.mUri).openConnection().getInputStream())
        throw new IOException("Cannot open bitmap: " + this.mUri);
      return localInputStream;
    }

    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      Object localObject;
      while (true)
      {
        try
        {
          localObject = new BitmapFactory.Options();
          if ((this.mTargetWidth > 0) && (this.mTargetHeight > 0))
          {
            i = 1;
            if (i == 0)
              break label95;
            paramArrayOfVoid = cropAndResize(this.mTargetWidth, this.mTargetHeight, (BitmapFactory.Options)localObject);
            localObject = ((BitmapFactory.Options)localObject).outMimeType;
            if ((localObject != null) && (!((String)localObject).isEmpty()))
              break;
            throw new IOException("Could not determine MIME type");
          }
        }
        catch (Exception paramArrayOfVoid)
        {
          this.mError.invoke(new Object[] { paramArrayOfVoid.getMessage() });
          return;
        }
        int i = 0;
        continue;
        label95: paramArrayOfVoid = crop((BitmapFactory.Options)localObject);
      }
      File localFile = ImageEditingManager.access$300(this.mContext, (String)localObject);
      ImageEditingManager.access$400(paramArrayOfVoid, (String)localObject, localFile);
      if (((String)localObject).equals("image/jpeg"))
        ImageEditingManager.access$500(this.mContext, Uri.parse(this.mUri), localFile);
      this.mSuccess.invoke(new Object[] { Uri.fromFile(localFile).toString() });
    }

    public void setTargetSize(int paramInt1, int paramInt2)
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
        throw new JSApplicationIllegalArgumentException(String.format("Invalid target size: [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      this.mTargetWidth = paramInt1;
      this.mTargetHeight = paramInt2;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.camera.ImageEditingManager
 * JD-Core Version:    0.6.0
 */