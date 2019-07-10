package io.vov.vitamio;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import io.vov.vitamio.provider.MediaStore.Video.Media;
import io.vov.vitamio.utils.ContextUtils;
import io.vov.vitamio.utils.FileUtils;
import io.vov.vitamio.utils.Log;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class MediaScanner
{
  private static final int DATE_MODIFIED_VIDEO_COLUMN_INDEX = 2;
  private static final int ID_VIDEO_COLUMN_INDEX = 0;
  private static final int PATH_VIDEO_COLUMN_INDEX = 1;
  private static final String[] VIDEO_PROJECTION = { "_id", "_data", "date_modified" };
  private boolean mCaseInsensitivePaths;
  private MyMediaScannerClient mClient = new MyMediaScannerClient(null);
  private Context mContext;
  private HashMap<String, FileCacheEntry> mFileCache;
  private ContentProviderClient mProvider;

  static
  {
    String str = Vitamio.getLibraryPath();
    Log.i("LIB ROOT: %s", new Object[] { str });
    System.load(str + "libstlport_shared.so");
    System.load(str + "libvscanner.so");
    loadFFmpeg_native(str + "libffmpeg.so");
  }

  public MediaScanner(Context paramContext)
  {
    this.mContext = paramContext;
    native_init(this.mClient);
  }

  private boolean inScanDirectory(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramString.startsWith(paramArrayOfString[i]))
        return true;
      i += 1;
    }
    return false;
  }

  private void initialize()
  {
    this.mCaseInsensitivePaths = true;
  }

  private static native boolean loadFFmpeg_native(String paramString);

  private final native void native_finalize();

  private final native void native_init(MediaScannerClient paramMediaScannerClient);

  private void postscan(String[] paramArrayOfString)
    throws RemoteException
  {
    Iterator localIterator = this.mFileCache.values().iterator();
    while (localIterator.hasNext())
    {
      FileCacheEntry localFileCacheEntry = (FileCacheEntry)localIterator.next();
      String str = localFileCacheEntry.mPath;
      if ((localFileCacheEntry.mSeenInFileSystem) || (!inScanDirectory(str, paramArrayOfString)) || (new File(str).exists()))
        continue;
      this.mProvider.delete(ContentUris.withAppendedId(localFileCacheEntry.mTableUri, localFileCacheEntry.mRowId), null, null);
      localIterator.remove();
    }
    this.mFileCache.clear();
    this.mFileCache = null;
    this.mProvider.release();
    this.mProvider = null;
  }

  private void prescan(String paramString)
    throws RemoteException
  {
    this.mProvider = this.mContext.getContentResolver().acquireContentProviderClient("me.abitno.vplayer.mediaprovider");
    Cursor localCursor = null;
    String str1 = null;
    String[] arrayOfString = null;
    Object localObject;
    if (this.mFileCache == null)
    {
      this.mFileCache = new HashMap();
      if (paramString != null)
      {
        str1 = "_data=?";
        localObject = localCursor;
      }
    }
    label303: label310: label324: 
    do
    {
      while (true)
      {
        String str2;
        try
        {
          while (true)
          {
            arrayOfString = new String[] { paramString };
            localObject = localCursor;
            localCursor = this.mProvider.query(MediaStore.Video.Media.CONTENT_URI, VIDEO_PROJECTION, str1, arrayOfString, null);
            localObject = localCursor;
            if (localCursor == null)
              break label324;
            try
            {
              while (true)
              {
                if (!localCursor.moveToNext())
                  break label310;
                long l1 = localCursor.getLong(0);
                localObject = localCursor.getString(1);
                long l2 = localCursor.getLong(2);
                if (!((String)localObject).startsWith("/"))
                  continue;
                localObject = new File((String)localObject);
                if ((!TextUtils.isEmpty(paramString)) && (!((File)localObject).exists()))
                {
                  this.mProvider.delete(MediaStore.Video.Media.CONTENT_URI, str1, arrayOfString);
                  localObject = localCursor;
                  localCursor.close();
                  if (0 != 0)
                    throw new NullPointerException();
                  return;
                  this.mFileCache.clear();
                  break;
                }
                str2 = FileUtils.getCanonical((File)localObject);
                if (!this.mCaseInsensitivePaths)
                  break label303;
                localObject = str2.toLowerCase();
                this.mFileCache.put(localObject, new FileCacheEntry(MediaStore.Video.Media.CONTENT_URI, l1, str2, l2));
              }
            }
            finally
            {
              localObject = localCursor;
              localCursor.close();
              localObject = null;
            }
          }
        }
        finally
        {
          if (localObject == null)
            continue;
          ((Cursor)localObject).close();
        }
        localObject = str2;
      }
      localObject = localCursor;
      localCursor.close();
      localObject = null;
    }
    while (localObject == null);
    ((Cursor)localObject).close();
  }

  private native void processDirectory(String paramString1, String paramString2);

  private native boolean processFile(String paramString1, String paramString2);

  protected void finalize()
    throws Throwable
  {
    try
    {
      native_finalize();
      return;
    }
    finally
    {
      super.finalize();
    }
    throw localObject;
  }

  public native void release();

  public void scanDirectories(String[] paramArrayOfString)
  {
    while (true)
    {
      int i;
      try
      {
        long l1 = System.currentTimeMillis();
        prescan(null);
        long l2 = System.currentTimeMillis();
        i = 0;
        if (i >= paramArrayOfString.length)
          continue;
        if (!TextUtils.isEmpty(paramArrayOfString[i]))
        {
          paramArrayOfString[i] = ContextUtils.fixLastSlash(paramArrayOfString[i]);
          processDirectory(paramArrayOfString[i], MediaFile.sFileExtensions);
          break label178;
          long l3 = System.currentTimeMillis();
          postscan(paramArrayOfString);
          long l4 = System.currentTimeMillis();
          Log.d(" prescan time: %dms", new Object[] { Long.valueOf(l2 - l1) });
          Log.d("    scan time: %dms", new Object[] { Long.valueOf(l3 - l2) });
          Log.d("postscan time: %dms", new Object[] { Long.valueOf(l4 - l3) });
          Log.d("   total time: %dms", new Object[] { Long.valueOf(l4 - l1) });
          return;
        }
      }
      catch (android.database.SQLException paramArrayOfString)
      {
        Log.e("SQLException in MediaScanner.scan()", paramArrayOfString);
        return;
      }
      catch (java.lang.UnsupportedOperationException paramArrayOfString)
      {
        Log.e("UnsupportedOperationException in MediaScanner.scan()", paramArrayOfString);
        return;
      }
      catch (RemoteException paramArrayOfString)
      {
        Log.e("RemoteException in MediaScanner.scan()", paramArrayOfString);
        return;
      }
      label178: i += 1;
    }
  }

  public Uri scanSingleFile(String paramString1, String paramString2)
  {
    try
    {
      prescan(paramString1);
      paramString2 = new File(paramString1);
      long l = paramString2.lastModified() / 1000L;
      paramString1 = this.mClient.doScanFile(paramString1, l, paramString2.length(), true);
      return paramString1;
    }
    catch (RemoteException paramString1)
    {
      Log.e("RemoteException in MediaScanner.scanFile()", paramString1);
    }
    return null;
  }

  private static class FileCacheEntry
  {
    long mLastModified;
    boolean mLastModifiedChanged;
    String mPath;
    long mRowId;
    boolean mSeenInFileSystem;
    Uri mTableUri;

    FileCacheEntry(Uri paramUri, long paramLong1, String paramString, long paramLong2)
    {
      this.mTableUri = paramUri;
      this.mRowId = paramLong1;
      this.mPath = paramString;
      this.mLastModified = paramLong2;
      this.mSeenInFileSystem = false;
      this.mLastModifiedChanged = false;
    }

    public String toString()
    {
      return this.mPath;
    }
  }

  private class MyMediaScannerClient
    implements MediaScannerClient
  {
    private String mAlbum;
    private String mArtist;
    private long mDuration;
    private long mFileSize;
    private int mFileType;
    private int mHeight;
    private String mLanguage;
    private long mLastModified;
    private String mMimeType;
    private String mPath;
    private String mTitle;
    private int mWidth;

    private MyMediaScannerClient()
    {
    }

    private Uri endFile(MediaScanner.FileCacheEntry paramFileCacheEntry)
      throws RemoteException
    {
      int i;
      if ((MediaFile.isVideoFileType(this.mFileType)) && (this.mWidth > 0) && (this.mHeight > 0))
        i = 1;
      Uri localUri;
      ContentValues localContentValues;
      long l;
      while (true)
        if (i != 0)
        {
          localUri = MediaStore.Video.Media.CONTENT_URI;
          paramFileCacheEntry.mTableUri = localUri;
          localContentValues = toValues();
          if (TextUtils.isEmpty(localContentValues.getAsString("title")))
          {
            Object localObject2 = localContentValues.getAsString("_data");
            i = ((String)localObject2).lastIndexOf('/');
            localObject1 = localObject2;
            if (i >= 0)
            {
              i += 1;
              localObject1 = localObject2;
              if (i < ((String)localObject2).length())
                localObject1 = ((String)localObject2).substring(i);
            }
            i = ((String)localObject1).lastIndexOf('.');
            localObject2 = localObject1;
            if (i > 0)
              localObject2 = ((String)localObject1).substring(0, i);
            localContentValues.put("title", (String)localObject2);
          }
          l = paramFileCacheEntry.mRowId;
          if (l != 0L)
            break;
          Object localObject1 = MediaScanner.this.mProvider.insert(localUri, localContentValues);
          if (localObject1 != null)
            paramFileCacheEntry.mRowId = ContentUris.parseId((Uri)localObject1);
          return localObject1;
          i = 0;
          continue;
        }
        else
        {
          return null;
        }
      paramFileCacheEntry = ContentUris.withAppendedId(localUri, l);
      MediaScanner.this.mProvider.update(paramFileCacheEntry, localContentValues, null, null);
      return (Uri)(Uri)paramFileCacheEntry;
    }

    private int parseSubstring(String paramString, int paramInt1, int paramInt2)
    {
      int j = paramString.length();
      if (paramInt1 == j)
        return paramInt2;
      int i = paramInt1 + 1;
      paramInt1 = paramString.charAt(paramInt1);
      if ((paramInt1 < 48) || (paramInt1 > 57))
        return paramInt2;
      paramInt2 = paramInt1 - 48;
      paramInt1 = i;
      while (paramInt1 < j)
      {
        i = paramString.charAt(paramInt1);
        if ((i < 48) || (i > 57))
          return paramInt2;
        paramInt2 = paramInt2 * 10 + (i - 48);
        paramInt1 += 1;
      }
      return paramInt2;
    }

    private ContentValues toValues()
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_data", this.mPath);
      localContentValues.put("date_modified", Long.valueOf(this.mLastModified));
      localContentValues.put("_size", Long.valueOf(this.mFileSize));
      localContentValues.put("mime_type", this.mMimeType);
      localContentValues.put("title", this.mTitle);
      if (MediaFile.isVideoFileType(this.mFileType))
      {
        localContentValues.put("duration", Long.valueOf(this.mDuration));
        localContentValues.put("language", this.mLanguage);
        localContentValues.put("album", this.mAlbum);
        localContentValues.put("artist", this.mArtist);
        localContentValues.put("width", Integer.valueOf(this.mWidth));
        localContentValues.put("height", Integer.valueOf(this.mHeight));
      }
      return localContentValues;
    }

    public void addNoMediaFolder(String paramString)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_data", "");
      paramString = paramString + '%';
      try
      {
        MediaScanner.this.mProvider.update(MediaStore.Video.Media.CONTENT_URI, localContentValues, "_data LIKE ?", new String[] { paramString });
        return;
      }
      catch (RemoteException paramString)
      {
      }
      throw new RuntimeException();
    }

    public MediaScanner.FileCacheEntry beginFile(String paramString, long paramLong1, long paramLong2)
    {
      int i = paramString.lastIndexOf('/');
      if ((i >= 0) && (i + 2 < paramString.length()))
      {
        if (paramString.regionMatches(i + 1, "._", 0, 2))
          return null;
        if (paramString.regionMatches(true, paramString.length() - 4, ".jpg", 0, 4))
        {
          if ((paramString.regionMatches(true, i + 1, "AlbumArt_{", 0, 10)) || (paramString.regionMatches(true, i + 1, "AlbumArt.", 0, 9)))
            return null;
          int j = paramString.length() - i - 1;
          if (((j == 17) && (paramString.regionMatches(true, i + 1, "AlbumArtSmall", 0, 13))) || ((j == 10) && (paramString.regionMatches(true, i + 1, "Folder", 0, 6))))
            return null;
        }
      }
      Object localObject = MediaFile.getFileType(paramString);
      if (localObject != null)
      {
        this.mFileType = ((MediaFile.MediaFileType)localObject).fileType;
        this.mMimeType = ((MediaFile.MediaFileType)localObject).mimeType;
      }
      localObject = FileUtils.getCanonical(new File(paramString));
      if (MediaScanner.this.mCaseInsensitivePaths)
        localObject = paramString.toLowerCase();
      MediaScanner.FileCacheEntry localFileCacheEntry2 = (MediaScanner.FileCacheEntry)MediaScanner.this.mFileCache.get(localObject);
      MediaScanner.FileCacheEntry localFileCacheEntry1 = localFileCacheEntry2;
      if (localFileCacheEntry2 == null)
      {
        localFileCacheEntry1 = new MediaScanner.FileCacheEntry(null, 0L, paramString, 0L);
        MediaScanner.this.mFileCache.put(localObject, localFileCacheEntry1);
      }
      localFileCacheEntry1.mSeenInFileSystem = true;
      long l = paramLong1 - localFileCacheEntry1.mLastModified;
      if ((l > 1L) || (l < -1L))
      {
        localFileCacheEntry1.mLastModified = paramLong1;
        localFileCacheEntry1.mLastModifiedChanged = true;
      }
      this.mPath = paramString;
      this.mLastModified = paramLong1;
      this.mFileSize = paramLong2;
      this.mTitle = null;
      this.mDuration = 0L;
      return (MediaScanner.FileCacheEntry)localFileCacheEntry1;
    }

    public Uri doScanFile(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      try
      {
        MediaScanner.FileCacheEntry localFileCacheEntry = beginFile(paramString, paramLong1, paramLong2);
        if ((localFileCacheEntry == null) || ((!localFileCacheEntry.mLastModifiedChanged) && (!paramBoolean)))
          break label96;
        if (MediaScanner.this.processFile(paramString, null))
          return endFile(localFileCacheEntry);
        if (MediaScanner.this.mCaseInsensitivePaths)
        {
          MediaScanner.this.mFileCache.remove(paramString.toLowerCase());
          return null;
        }
      }
      catch (RemoteException paramString)
      {
        Log.e("RemoteException in MediaScanner.scanFile()", paramString);
        return null;
      }
      MediaScanner.this.mFileCache.remove(paramString);
      label96: return null;
    }

    public void handleStringTag(String paramString1, byte[] paramArrayOfByte, String paramString2)
    {
      try
      {
        paramString2 = new String(paramArrayOfByte, paramString2);
        paramArrayOfByte = paramString2;
        Log.i("%s : %s", new Object[] { paramString1, paramArrayOfByte });
        if (paramString1.equalsIgnoreCase("title"))
        {
          this.mTitle = paramArrayOfByte;
          return;
        }
      }
      catch (java.lang.Exception paramString2)
      {
        do
        {
          do
          {
            while (true)
            {
              Log.e("handleStringTag", paramString2);
              paramArrayOfByte = new String(paramArrayOfByte);
            }
            if (paramString1.equalsIgnoreCase("artist"))
            {
              this.mArtist = paramArrayOfByte.trim();
              return;
            }
            if (!paramString1.equalsIgnoreCase("albumartist"))
              break;
          }
          while (!TextUtils.isEmpty(this.mArtist));
          this.mArtist = paramArrayOfByte.trim();
          return;
          if (paramString1.equalsIgnoreCase("album"))
          {
            this.mAlbum = paramArrayOfByte.trim();
            return;
          }
          if (paramString1.equalsIgnoreCase("language"))
          {
            this.mLanguage = paramArrayOfByte.trim();
            return;
          }
          if (paramString1.equalsIgnoreCase("duration"))
          {
            this.mDuration = parseSubstring(paramArrayOfByte, 0, 0);
            return;
          }
          if (!paramString1.equalsIgnoreCase("width"))
            continue;
          this.mWidth = parseSubstring(paramArrayOfByte, 0, 0);
          return;
        }
        while (!paramString1.equalsIgnoreCase("height"));
        this.mHeight = parseSubstring(paramArrayOfByte, 0, 0);
      }
    }

    public void scanFile(String paramString, long paramLong1, long paramLong2)
    {
      Log.i("scanFile: %s", new Object[] { paramString });
      doScanFile(paramString, paramLong1, paramLong2, false);
    }

    public void setMimeType(String paramString)
    {
      Log.i("setMimeType: %s", new Object[] { paramString });
      this.mMimeType = paramString;
      this.mFileType = MediaFile.getFileTypeForMimeType(paramString);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.MediaScanner
 * JD-Core Version:    0.6.0
 */