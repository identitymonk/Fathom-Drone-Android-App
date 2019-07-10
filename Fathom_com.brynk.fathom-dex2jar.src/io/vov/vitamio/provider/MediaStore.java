package io.vov.vitamio.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.provider.BaseColumns;
import io.vov.vitamio.utils.Log;

public final class MediaStore
{
  public static final String AUTHORITY = "me.abitno.vplayer.mediaprovider";
  private static final String BASE_SQL_FIELDS = "_id INTEGER PRIMARY KEY,_data TEXT NOT NULL,_directory TEXT NOT NULL,_directory_name TEXT NOT NULL,_size INTEGER,_display_name TEXT,title TEXT,title_key TEXT,date_added INTEGER,date_modified INTEGER,mime_type TEXT,available_size INTEGER default 0,play_status INTEGER ,";
  public static final String CONTENT_AUTHORITY_SLASH = "content://me.abitno.vplayer.mediaprovider/";
  public static final Uri CONTENT_URI = Uri.parse("content://me.abitno.vplayer.mediaprovider/");
  public static final String MEDIA_SCANNER_VOLUME = "volume";

  public static Uri getMediaScannerUri()
  {
    return Uri.parse("content://me.abitno.vplayer.mediaprovider/media_scanner");
  }

  public static Uri getVolumeUri()
  {
    return Uri.parse("content://me.abitno.vplayer.mediaprovider/volume");
  }

  public static final class Audio
  {
    public static abstract interface AudioColumns extends MediaStore.MediaColumns
    {
      public static final String ALBUM = "album";
      public static final String ARTIST = "artist";
      public static final String BOOKMARK = "bookmark";
      public static final String COMPOSER = "composer";
      public static final String DURATION = "duration";
      public static final String TRACK = "track";
      public static final String YEAR = "year";
    }

    public static final class Media
      implements MediaStore.Audio.AudioColumns
    {
      public static final String CONTENT_TYPE = "vnd.android.cursor.dir/audio";
      public static final Uri CONTENT_URI = Uri.parse("content://me.abitno.vplayer.mediaprovider/audios/media");
    }
  }

  private static class InternalThumbnails
    implements BaseColumns
  {
    static final int DEFAULT_GROUP_ID = 0;
    private static final int MICRO_KIND = 3;
    private static final int MINI_KIND = 1;
    private static final String[] PROJECTION = { "_id", "_data" };
    private static byte[] sThumbBuf;
    private static final Object sThumbBufLock = new Object();

    static void cancelThumbnailRequest(ContentResolver paramContentResolver, long paramLong1, Uri paramUri, long paramLong2)
    {
      paramUri = paramUri.buildUpon().appendQueryParameter("cancel", "1").appendQueryParameter("orig_id", String.valueOf(paramLong1)).appendQueryParameter("group_id", String.valueOf(paramLong2)).build();
      try
      {
        paramContentResolver = paramContentResolver.query(paramUri, PROJECTION, null, null, null);
        if (paramContentResolver != null)
          paramContentResolver.close();
        return;
      }
      finally
      {
        if (0 == 0);
      }
      throw paramContentResolver;
    }

    private static Bitmap getMiniThumbFromFile(Cursor paramCursor, Uri paramUri, ContentResolver paramContentResolver, BitmapFactory.Options paramOptions)
    {
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject4 = null;
      Object localObject1 = localObject4;
      Object localObject2 = localObject5;
      Object localObject3 = localObject6;
      try
      {
        paramUri = paramContentResolver.openFileDescriptor(ContentUris.withAppendedId(paramUri, paramCursor.getLong(0)), "r");
        localObject1 = localObject4;
        localObject2 = localObject5;
        localObject3 = localObject6;
        paramCursor = BitmapFactory.decodeFileDescriptor(paramUri.getFileDescriptor(), null, paramOptions);
        localObject1 = paramCursor;
        localObject2 = paramCursor;
        localObject3 = paramCursor;
        paramUri.close();
        return paramCursor;
      }
      catch (java.io.FileNotFoundException paramCursor)
      {
        Log.e("getMiniThumbFromFile", paramCursor);
        return localObject1;
      }
      catch (java.io.IOException paramCursor)
      {
        Log.e("getMiniThumbFromFile", paramCursor);
        return localObject2;
      }
      catch (java.lang.OutOfMemoryError paramCursor)
      {
        Log.e("getMiniThumbFromFile", paramCursor);
      }
      return (Bitmap)(Bitmap)(Bitmap)localObject3;
    }

    // ERROR //
    static Bitmap getThumbnail(Context paramContext, ContentResolver paramContentResolver, long paramLong1, long paramLong2, int paramInt, BitmapFactory.Options paramOptions, Uri paramUri)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 10
      //   3: aconst_null
      //   4: astore 11
      //   6: aconst_null
      //   7: astore 9
      //   9: aload 8
      //   11: invokestatic 136	io/vov/vitamio/provider/MiniThumbFile:instance	(Landroid/net/Uri;)Lio/vov/vitamio/provider/MiniThumbFile;
      //   14: astore 14
      //   16: aload 11
      //   18: astore_0
      //   19: aload 14
      //   21: lload_2
      //   22: invokevirtual 140	io/vov/vitamio/provider/MiniThumbFile:getMagic	(J)J
      //   25: lconst_0
      //   26: lcmp
      //   27: ifeq +212 -> 239
      //   30: iload 6
      //   32: iconst_3
      //   33: if_icmpne +80 -> 113
      //   36: getstatic 37	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBufLock	Ljava/lang/Object;
      //   39: astore 7
      //   41: aload 7
      //   43: monitorenter
      //   44: getstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   47: ifnonnull +11 -> 58
      //   50: sipush 10000
      //   53: newarray byte
      //   55: putstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   58: aload 9
      //   60: astore_0
      //   61: aload 14
      //   63: lload_2
      //   64: getstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   67: invokevirtual 145	io/vov/vitamio/provider/MiniThumbFile:getMiniThumbFromFile	(J[B)[B
      //   70: ifnull +32 -> 102
      //   73: getstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   76: iconst_0
      //   77: getstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   80: arraylength
      //   81: invokestatic 149	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
      //   84: astore_1
      //   85: aload_1
      //   86: astore_0
      //   87: aload_1
      //   88: ifnonnull +14 -> 102
      //   91: ldc 151
      //   93: iconst_0
      //   94: anewarray 4	java/lang/Object
      //   97: invokestatic 155	io/vov/vitamio/utils/Log:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   100: aload_1
      //   101: astore_0
      //   102: aload 7
      //   104: monitorexit
      //   105: aload_0
      //   106: areturn
      //   107: astore_0
      //   108: aload 7
      //   110: monitorexit
      //   111: aload_0
      //   112: athrow
      //   113: aload 11
      //   115: astore_0
      //   116: iload 6
      //   118: iconst_1
      //   119: if_icmpne +120 -> 239
      //   122: aconst_null
      //   123: astore_0
      //   124: aload_1
      //   125: aload 8
      //   127: getstatic 32	io/vov/vitamio/provider/MediaStore$InternalThumbnails:PROJECTION	[Ljava/lang/String;
      //   130: new 157	java/lang/StringBuilder
      //   133: dup
      //   134: invokespecial 158	java/lang/StringBuilder:<init>	()V
      //   137: ldc 160
      //   139: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   142: lload_2
      //   143: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   146: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   149: aconst_null
      //   150: aconst_null
      //   151: invokevirtual 74	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   154: astore 11
      //   156: aload 10
      //   158: astore 9
      //   160: aload 11
      //   162: ifnull +59 -> 221
      //   165: aload 10
      //   167: astore 9
      //   169: aload 11
      //   171: astore_0
      //   172: aload 11
      //   174: invokeinterface 175 1 0
      //   179: ifeq +42 -> 221
      //   182: aload 11
      //   184: astore_0
      //   185: aload 11
      //   187: aload 8
      //   189: aload_1
      //   190: aload 7
      //   192: invokestatic 177	io/vov/vitamio/provider/MediaStore$InternalThumbnails:getMiniThumbFromFile	(Landroid/database/Cursor;Landroid/net/Uri;Landroid/content/ContentResolver;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   195: astore 9
      //   197: aload 9
      //   199: astore_0
      //   200: aload_0
      //   201: astore 9
      //   203: aload_0
      //   204: ifnull +17 -> 221
      //   207: aload 11
      //   209: ifnull +10 -> 219
      //   212: aload 11
      //   214: invokeinterface 79 1 0
      //   219: aload_0
      //   220: areturn
      //   221: aload 9
      //   223: astore_0
      //   224: aload 11
      //   226: ifnull +13 -> 239
      //   229: aload 11
      //   231: invokeinterface 79 1 0
      //   236: aload 9
      //   238: astore_0
      //   239: aconst_null
      //   240: astore 13
      //   242: aconst_null
      //   243: astore 12
      //   245: aload_0
      //   246: astore 10
      //   248: aload_1
      //   249: aload 8
      //   251: invokevirtual 46	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
      //   254: ldc 179
      //   256: ldc 50
      //   258: invokevirtual 56	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   261: ldc 58
      //   263: lload_2
      //   264: invokestatic 62	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   267: invokevirtual 56	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   270: ldc 64
      //   272: lload 4
      //   274: invokestatic 62	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   277: invokevirtual 56	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      //   280: invokevirtual 68	android/net/Uri$Builder:build	()Landroid/net/Uri;
      //   283: getstatic 32	io/vov/vitamio/provider/MediaStore$InternalThumbnails:PROJECTION	[Ljava/lang/String;
      //   286: aconst_null
      //   287: aconst_null
      //   288: aconst_null
      //   289: invokevirtual 74	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   292: astore 11
      //   294: aload 11
      //   296: ifnonnull +30 -> 326
      //   299: aload 11
      //   301: ifnull +316 -> 617
      //   304: aload 11
      //   306: invokeinterface 79 1 0
      //   311: aconst_null
      //   312: areturn
      //   313: astore_1
      //   314: aload_0
      //   315: ifnull +9 -> 324
      //   318: aload_0
      //   319: invokeinterface 79 1 0
      //   324: aload_1
      //   325: athrow
      //   326: iload 6
      //   328: iconst_3
      //   329: if_icmpne +178 -> 507
      //   332: aload_0
      //   333: astore 10
      //   335: aload 11
      //   337: astore 12
      //   339: aload 11
      //   341: astore 13
      //   343: getstatic 37	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBufLock	Ljava/lang/Object;
      //   346: astore 7
      //   348: aload_0
      //   349: astore 10
      //   351: aload 11
      //   353: astore 12
      //   355: aload 11
      //   357: astore 13
      //   359: aload 7
      //   361: monitorenter
      //   362: aload_0
      //   363: astore_1
      //   364: getstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   367: ifnonnull +13 -> 380
      //   370: aload_0
      //   371: astore_1
      //   372: sipush 10000
      //   375: newarray byte
      //   377: putstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   380: aload_0
      //   381: astore 9
      //   383: aload_0
      //   384: astore_1
      //   385: aload 14
      //   387: lload_2
      //   388: getstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   391: invokevirtual 145	io/vov/vitamio/provider/MiniThumbFile:getMiniThumbFromFile	(J[B)[B
      //   394: ifnull +38 -> 432
      //   397: aload_0
      //   398: astore_1
      //   399: getstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   402: iconst_0
      //   403: getstatic 142	io/vov/vitamio/provider/MediaStore$InternalThumbnails:sThumbBuf	[B
      //   406: arraylength
      //   407: invokestatic 149	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
      //   410: astore_0
      //   411: aload_0
      //   412: astore 9
      //   414: aload_0
      //   415: ifnonnull +17 -> 432
      //   418: aload_0
      //   419: astore_1
      //   420: ldc 151
      //   422: iconst_0
      //   423: anewarray 4	java/lang/Object
      //   426: invokestatic 155	io/vov/vitamio/utils/Log:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   429: aload_0
      //   430: astore 9
      //   432: aload 9
      //   434: astore_1
      //   435: aload 7
      //   437: monitorexit
      //   438: aload 9
      //   440: astore_0
      //   441: aload 11
      //   443: ifnull +13 -> 456
      //   446: aload 11
      //   448: invokeinterface 79 1 0
      //   453: aload 9
      //   455: astore_0
      //   456: aload_0
      //   457: areturn
      //   458: astore_0
      //   459: aload 7
      //   461: monitorexit
      //   462: aload_1
      //   463: astore 10
      //   465: aload 11
      //   467: astore 12
      //   469: aload 11
      //   471: astore 13
      //   473: aload_0
      //   474: athrow
      //   475: astore_0
      //   476: aload 12
      //   478: astore 13
      //   480: ldc 180
      //   482: aload_0
      //   483: invokestatic 126	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   486: aload 10
      //   488: astore_0
      //   489: aload 12
      //   491: ifnull -35 -> 456
      //   494: aload 12
      //   496: invokeinterface 79 1 0
      //   501: aload 10
      //   503: astore_0
      //   504: goto -48 -> 456
      //   507: iload 6
      //   509: iconst_1
      //   510: if_icmpne +53 -> 563
      //   513: aload_0
      //   514: astore 9
      //   516: aload_0
      //   517: astore 10
      //   519: aload 11
      //   521: astore 12
      //   523: aload 11
      //   525: astore 13
      //   527: aload 11
      //   529: invokeinterface 175 1 0
      //   534: ifeq -96 -> 438
      //   537: aload_0
      //   538: astore 10
      //   540: aload 11
      //   542: astore 12
      //   544: aload 11
      //   546: astore 13
      //   548: aload 11
      //   550: aload 8
      //   552: aload_1
      //   553: aload 7
      //   555: invokestatic 177	io/vov/vitamio/provider/MediaStore$InternalThumbnails:getMiniThumbFromFile	(Landroid/database/Cursor;Landroid/net/Uri;Landroid/content/ContentResolver;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   558: astore 9
      //   560: goto -122 -> 438
      //   563: aload_0
      //   564: astore 10
      //   566: aload 11
      //   568: astore 12
      //   570: aload 11
      //   572: astore 13
      //   574: new 182	java/lang/IllegalArgumentException
      //   577: dup
      //   578: new 157	java/lang/StringBuilder
      //   581: dup
      //   582: invokespecial 158	java/lang/StringBuilder:<init>	()V
      //   585: ldc 184
      //   587: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   590: iload 6
      //   592: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   595: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   598: invokespecial 190	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   601: athrow
      //   602: astore_0
      //   603: aload 13
      //   605: ifnull +10 -> 615
      //   608: aload 13
      //   610: invokeinterface 79 1 0
      //   615: aload_0
      //   616: athrow
      //   617: aconst_null
      //   618: areturn
      //
      // Exception table:
      //   from	to	target	type
      //   44	58	107	finally
      //   61	85	107	finally
      //   91	100	107	finally
      //   102	105	107	finally
      //   108	111	107	finally
      //   124	156	313	finally
      //   172	182	313	finally
      //   185	197	313	finally
      //   364	370	458	finally
      //   372	380	458	finally
      //   385	397	458	finally
      //   399	411	458	finally
      //   420	429	458	finally
      //   435	438	458	finally
      //   459	462	458	finally
      //   248	294	475	android/database/sqlite/SQLiteException
      //   343	348	475	android/database/sqlite/SQLiteException
      //   359	362	475	android/database/sqlite/SQLiteException
      //   473	475	475	android/database/sqlite/SQLiteException
      //   527	537	475	android/database/sqlite/SQLiteException
      //   548	560	475	android/database/sqlite/SQLiteException
      //   574	602	475	android/database/sqlite/SQLiteException
      //   248	294	602	finally
      //   343	348	602	finally
      //   359	362	602	finally
      //   473	475	602	finally
      //   480	486	602	finally
      //   527	537	602	finally
      //   548	560	602	finally
      //   574	602	602	finally
    }

    static String getThumbnailPath(Context paramContext, ContentResolver paramContentResolver, long paramLong, Uri paramUri)
    {
      String str = "";
      paramContext = null;
      try
      {
        paramUri = paramContentResolver.query(paramUri, PROJECTION, "video_id=" + paramLong, null, null);
        paramContentResolver = str;
        if (paramUri != null)
        {
          paramContentResolver = str;
          paramContext = paramUri;
          if (paramUri.moveToFirst())
          {
            paramContext = paramUri;
            paramContentResolver = paramUri.getString(paramUri.getColumnIndex("_data"));
          }
        }
        return paramContentResolver;
      }
      finally
      {
        if (paramContext != null)
          paramContext.close();
      }
      throw paramContentResolver;
    }
  }

  public static abstract interface MediaColumns extends BaseColumns
  {
    public static final String AVAILABLE_SIZE = "available_size";
    public static final String DATA = "_data";
    public static final String DATE_ADDED = "date_added";
    public static final String DATE_MODIFIED = "date_modified";
    public static final String DIRECTORY = "_directory";
    public static final String DIRECTORY_NAME = "_directory_name";
    public static final String DISPLAY_NAME = "_display_name";
    public static final String MIME_TYPE = "mime_type";
    public static final String PLAY_STATUS = "play_status";
    public static final String SIZE = "_size";
    public static final String TITLE = "title";
    public static final String TITLE_KEY = "title_key";
  }

  public static final class Video
  {
    public static final class Media
      implements MediaStore.Video.VideoColumns
    {
      public static final String CONTENT_TYPE = "vnd.android.cursor.dir/video";
      public static final Uri CONTENT_URI = Uri.parse("content://me.abitno.vplayer.mediaprovider/videos/media");
      protected static final String SQL_FIELDS = "_id INTEGER PRIMARY KEY,_data TEXT NOT NULL,_directory TEXT NOT NULL,_directory_name TEXT NOT NULL,_size INTEGER,_display_name TEXT,title TEXT,title_key TEXT,date_added INTEGER,date_modified INTEGER,mime_type TEXT,available_size INTEGER default 0,play_status INTEGER ,duration INTEGER,artist TEXT,album TEXT,width INTEGER,height INTEGER,description TEXT,language TEXT,latitude DOUBLE,longitude DOUBLE,datetaken INTEGER,bookmark INTEGER,mini_thumb_magic INTEGER,hidden INTEGER default 0,sub_track TEXT,audio_track INTEGER";
      protected static final String SQL_TRIGGER_VIDEO_CLEANUP = "CREATE TRIGGER IF NOT EXISTS video_cleanup AFTER DELETE ON videos BEGIN SELECT _DELETE_FILE(old._data);SELECT _DELETE_FILE(old._data || '.ssi');END";
      protected static final String SQL_TRIGGER_VIDEO_UPDATE = "CREATE TRIGGER IF NOT EXISTS video_update AFTER UPDATE ON videos WHEN new._data <> old._data BEGIN SELECT _DELETE_FILE(old._data || '.ssi');END";
      protected static final String TABLE_NAME = "videos";
    }

    public static class Thumbnails
      implements BaseColumns
    {
      public static final Uri CONTENT_URI = Uri.parse("content://me.abitno.vplayer.mediaprovider/videos/thumbnails");
      public static final String DATA = "_data";
      public static final String HEIGHT = "height";
      public static final String KIND = "kind";
      public static final int MICRO_KIND = 3;
      public static final int MINI_KIND = 1;
      protected static final String SQL_FIELDS = "_id INTEGER PRIMARY KEY,_data TEXT,video_id INTEGER,kind INTEGER,width INTEGER,height INTEGER";
      protected static final String SQL_INDEX_VIDEO_ID = "CREATE INDEX IF NOT EXISTS video_id_index on videothumbnails(video_id);";
      protected static final String SQL_TRIGGER_VIDEO_THUMBNAILS_CLEANUP = "CREATE TRIGGER IF NOT EXISTS videothumbnails_cleanup DELETE ON videothumbnails BEGIN SELECT _DELETE_FILE(old._data);END";
      protected static final String TABLE_NAME = "videothumbnails";
      public static final String THUMBNAILS_DIRECTORY = "Android/data/me.abitno.vplayer.t/thumbnails";
      public static final String VIDEO_ID = "video_id";
      public static final String WIDTH = "width";

      public static void cancelThumbnailRequest(ContentResolver paramContentResolver, long paramLong)
      {
        MediaStore.InternalThumbnails.cancelThumbnailRequest(paramContentResolver, paramLong, CONTENT_URI, 0L);
      }

      public static void cancelThumbnailRequest(ContentResolver paramContentResolver, long paramLong1, long paramLong2)
      {
        MediaStore.InternalThumbnails.cancelThumbnailRequest(paramContentResolver, paramLong1, CONTENT_URI, paramLong2);
      }

      public static Bitmap getThumbnail(Context paramContext, ContentResolver paramContentResolver, long paramLong, int paramInt, BitmapFactory.Options paramOptions)
      {
        return MediaStore.InternalThumbnails.getThumbnail(paramContext, paramContentResolver, paramLong, 0L, paramInt, paramOptions, CONTENT_URI);
      }

      public static Bitmap getThumbnail(Context paramContext, ContentResolver paramContentResolver, long paramLong1, long paramLong2, int paramInt, BitmapFactory.Options paramOptions)
      {
        return MediaStore.InternalThumbnails.getThumbnail(paramContext, paramContentResolver, paramLong1, paramLong2, paramInt, paramOptions, CONTENT_URI);
      }

      public static String getThumbnailPath(Context paramContext, ContentResolver paramContentResolver, long paramLong)
      {
        return MediaStore.InternalThumbnails.getThumbnailPath(paramContext, paramContentResolver, paramLong, CONTENT_URI);
      }
    }

    public static abstract interface VideoColumns extends MediaStore.MediaColumns
    {
      public static final String ALBUM = "album";
      public static final String ARTIST = "artist";
      public static final String AUDIO_TRACK = "audio_track";
      public static final String BOOKMARK = "bookmark";
      public static final String DATE_TAKEN = "datetaken";
      public static final String DESCRIPTION = "description";
      public static final String DURATION = "duration";
      public static final String HEIGHT = "height";
      public static final String HIDDEN = "hidden";
      public static final String LANGUAGE = "language";
      public static final String LATITUDE = "latitude";
      public static final String LONGITUDE = "longitude";
      public static final String MINI_THUMB_MAGIC = "mini_thumb_magic";
      public static final String SUBTRACK = "sub_track";
      public static final String WIDTH = "width";
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.provider.MediaStore
 * JD-Core Version:    0.6.0
 */