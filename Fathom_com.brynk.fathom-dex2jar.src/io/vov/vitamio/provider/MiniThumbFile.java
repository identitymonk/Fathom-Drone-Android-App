package io.vov.vitamio.provider;

import android.net.Uri;
import android.os.Environment;
import io.vov.vitamio.utils.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class MiniThumbFile
{
  protected static final int BYTES_PER_MINTHUMB = 10000;
  private static final int HEADER_SIZE = 13;
  private static final int MINI_THUMB_DATA_FILE_VERSION = 7;
  private static Hashtable<String, MiniThumbFile> sThumbFiles = new Hashtable();
  private ByteBuffer mBuffer;
  private FileChannel mChannel;
  private RandomAccessFile mMiniThumbFile;
  private Uri mUri;

  public MiniThumbFile(Uri paramUri)
  {
    this.mUri = paramUri;
    this.mBuffer = ByteBuffer.allocateDirect(10000);
  }

  protected static MiniThumbFile instance(Uri paramUri)
  {
    monitorenter;
    try
    {
      String str = (String)paramUri.getPathSegments().get(0);
      MiniThumbFile localMiniThumbFile = (MiniThumbFile)sThumbFiles.get(str);
      paramUri = localMiniThumbFile;
      if (localMiniThumbFile == null)
      {
        paramUri = new MiniThumbFile(Uri.parse("content://me.abitno.vplayer.mediaprovider/" + str + "/media"));
        sThumbFiles.put(str, paramUri);
      }
      return paramUri;
    }
    finally
    {
      monitorexit;
    }
    throw paramUri;
  }

  private RandomAccessFile miniThumbDataFile()
  {
    Object localObject;
    if (this.mMiniThumbFile == null)
    {
      removeOldFile();
      localObject = randomAccessFilePath(7);
      File localFile = new File((String)localObject).getParentFile();
      if ((!localFile.isDirectory()) && (!localFile.mkdirs()))
        Log.e("Unable to create .thumbnails directory %s", new Object[] { localFile.toString() });
      localObject = new File((String)localObject);
    }
    try
    {
      this.mMiniThumbFile = new RandomAccessFile((File)localObject, "rw");
      if (this.mMiniThumbFile != null)
        this.mChannel = this.mMiniThumbFile.getChannel();
      return this.mMiniThumbFile;
    }
    catch (IOException localIOException2)
    {
      while (true)
        try
        {
          this.mMiniThumbFile = new RandomAccessFile((File)localObject, "r");
        }
        catch (IOException localIOException1)
        {
        }
    }
  }

  private String randomAccessFilePath(int paramInt)
  {
    String str = Environment.getExternalStorageDirectory().toString() + "/" + "Android/data/me.abitno.vplayer.t/thumbnails";
    return str + "/.thumbdata" + paramInt + "-" + this.mUri.hashCode();
  }

  private void removeOldFile()
  {
    File localFile = new File(randomAccessFilePath(6));
    if (localFile.exists());
    try
    {
      localFile.delete();
      return;
    }
    catch (SecurityException localSecurityException)
    {
    }
  }

  protected static void reset()
  {
    monitorenter;
    try
    {
      Iterator localIterator = sThumbFiles.values().iterator();
      while (localIterator.hasNext())
        ((MiniThumbFile)localIterator.next()).deactivate();
    }
    finally
    {
      monitorexit;
    }
    sThumbFiles.clear();
    monitorexit;
  }

  // ERROR //
  protected void deactivate()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	io/vov/vitamio/provider/MiniThumbFile:mMiniThumbFile	Ljava/io/RandomAccessFile;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 94	io/vov/vitamio/provider/MiniThumbFile:mMiniThumbFile	Ljava/io/RandomAccessFile;
    //   15: invokevirtual 198	java/io/RandomAccessFile:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 94	io/vov/vitamio/provider/MiniThumbFile:mMiniThumbFile	Ljava/io/RandomAccessFile;
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    //   31: astore_1
    //   32: goto -9 -> 23
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   11	23	26	finally
    //   11	23	31	java/io/IOException
  }

  // ERROR //
  protected long getMagic(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 204	io/vov/vitamio/provider/MiniThumbFile:miniThumbDataFile	()Ljava/io/RandomAccessFile;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnull +209 -> 219
    //   13: lload_1
    //   14: ldc2_w 205
    //   17: lmul
    //   18: lstore_3
    //   19: aconst_null
    //   20: astore 9
    //   22: aconst_null
    //   23: astore 10
    //   25: aconst_null
    //   26: astore 8
    //   28: aload 8
    //   30: astore 6
    //   32: aload 9
    //   34: astore 7
    //   36: aload 10
    //   38: astore 5
    //   40: aload_0
    //   41: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   44: invokevirtual 209	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   47: pop
    //   48: aload 8
    //   50: astore 6
    //   52: aload 9
    //   54: astore 7
    //   56: aload 10
    //   58: astore 5
    //   60: aload_0
    //   61: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   64: bipush 9
    //   66: invokevirtual 213	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   69: pop
    //   70: aload 8
    //   72: astore 6
    //   74: aload 9
    //   76: astore 7
    //   78: aload 10
    //   80: astore 5
    //   82: aload_0
    //   83: getfield 139	io/vov/vitamio/provider/MiniThumbFile:mChannel	Ljava/nio/channels/FileChannel;
    //   86: lload_3
    //   87: ldc2_w 214
    //   90: iconst_1
    //   91: invokevirtual 221	java/nio/channels/FileChannel:lock	(JJZ)Ljava/nio/channels/FileLock;
    //   94: astore 8
    //   96: aload 8
    //   98: astore 6
    //   100: aload 8
    //   102: astore 7
    //   104: aload 8
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 139	io/vov/vitamio/provider/MiniThumbFile:mChannel	Ljava/nio/channels/FileChannel;
    //   112: aload_0
    //   113: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   116: lload_3
    //   117: invokevirtual 225	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;J)I
    //   120: bipush 9
    //   122: if_icmpne +87 -> 209
    //   125: aload 8
    //   127: astore 6
    //   129: aload 8
    //   131: astore 7
    //   133: aload 8
    //   135: astore 5
    //   137: aload_0
    //   138: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   141: iconst_0
    //   142: invokevirtual 228	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   145: pop
    //   146: aload 8
    //   148: astore 6
    //   150: aload 8
    //   152: astore 7
    //   154: aload 8
    //   156: astore 5
    //   158: aload_0
    //   159: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   162: invokevirtual 231	java/nio/ByteBuffer:get	()B
    //   165: iconst_1
    //   166: if_icmpne +43 -> 209
    //   169: aload 8
    //   171: astore 6
    //   173: aload 8
    //   175: astore 7
    //   177: aload 8
    //   179: astore 5
    //   181: aload_0
    //   182: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   185: invokevirtual 235	java/nio/ByteBuffer:getLong	()J
    //   188: lstore_3
    //   189: lload_3
    //   190: lstore_1
    //   191: lload_1
    //   192: lstore_3
    //   193: aload 8
    //   195: ifnull +10 -> 205
    //   198: aload 8
    //   200: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   203: lload_1
    //   204: lstore_3
    //   205: aload_0
    //   206: monitorexit
    //   207: lload_3
    //   208: lreturn
    //   209: aload 8
    //   211: ifnull +8 -> 219
    //   214: aload 8
    //   216: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   219: lconst_0
    //   220: lstore_3
    //   221: goto -16 -> 205
    //   224: astore 7
    //   226: aload 6
    //   228: astore 5
    //   230: ldc 242
    //   232: aload 7
    //   234: invokestatic 245	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   237: aload 6
    //   239: ifnull -20 -> 219
    //   242: aload 6
    //   244: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   247: goto -28 -> 219
    //   250: astore 5
    //   252: goto -33 -> 219
    //   255: astore 6
    //   257: aload 7
    //   259: astore 5
    //   261: ldc 247
    //   263: iconst_2
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: lload_1
    //   270: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   273: aastore
    //   274: dup
    //   275: iconst_1
    //   276: aload 6
    //   278: invokevirtual 257	java/lang/Object:getClass	()Ljava/lang/Class;
    //   281: invokevirtual 260	java/lang/Class:toString	()Ljava/lang/String;
    //   284: aastore
    //   285: invokestatic 126	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: aload 7
    //   290: ifnull -71 -> 219
    //   293: aload 7
    //   295: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   298: goto -79 -> 219
    //   301: astore 5
    //   303: goto -84 -> 219
    //   306: astore 6
    //   308: aload 5
    //   310: ifnull +8 -> 318
    //   313: aload 5
    //   315: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   318: aload 6
    //   320: athrow
    //   321: astore 5
    //   323: aload_0
    //   324: monitorexit
    //   325: aload 5
    //   327: athrow
    //   328: astore 5
    //   330: lload_1
    //   331: lstore_3
    //   332: goto -127 -> 205
    //   335: astore 5
    //   337: goto -118 -> 219
    //   340: astore 5
    //   342: goto -24 -> 318
    //
    // Exception table:
    //   from	to	target	type
    //   40	48	224	java/io/IOException
    //   60	70	224	java/io/IOException
    //   82	96	224	java/io/IOException
    //   108	125	224	java/io/IOException
    //   137	146	224	java/io/IOException
    //   158	169	224	java/io/IOException
    //   181	189	224	java/io/IOException
    //   242	247	250	java/io/IOException
    //   40	48	255	java/lang/RuntimeException
    //   60	70	255	java/lang/RuntimeException
    //   82	96	255	java/lang/RuntimeException
    //   108	125	255	java/lang/RuntimeException
    //   137	146	255	java/lang/RuntimeException
    //   158	169	255	java/lang/RuntimeException
    //   181	189	255	java/lang/RuntimeException
    //   293	298	301	java/io/IOException
    //   40	48	306	finally
    //   60	70	306	finally
    //   82	96	306	finally
    //   108	125	306	finally
    //   137	146	306	finally
    //   158	169	306	finally
    //   181	189	306	finally
    //   230	237	306	finally
    //   261	288	306	finally
    //   2	8	321	finally
    //   198	203	321	finally
    //   214	219	321	finally
    //   242	247	321	finally
    //   293	298	321	finally
    //   313	318	321	finally
    //   318	321	321	finally
    //   198	203	328	java/io/IOException
    //   214	219	335	java/io/IOException
    //   313	318	340	java/io/IOException
  }

  // ERROR //
  protected byte[] getMiniThumbFromFile(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 204	io/vov/vitamio/provider/MiniThumbFile:miniThumbDataFile	()Ljava/io/RandomAccessFile;
    //   6: astore 8
    //   8: aload 8
    //   10: ifnonnull +11 -> 21
    //   13: aconst_null
    //   14: astore 8
    //   16: aload_0
    //   17: monitorexit
    //   18: aload 8
    //   20: areturn
    //   21: lload_1
    //   22: ldc2_w 205
    //   25: lmul
    //   26: lstore 6
    //   28: aconst_null
    //   29: astore 12
    //   31: aconst_null
    //   32: astore 13
    //   34: aconst_null
    //   35: astore 11
    //   37: aload 11
    //   39: astore 9
    //   41: aload 12
    //   43: astore 10
    //   45: aload 13
    //   47: astore 8
    //   49: aload_0
    //   50: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   53: invokevirtual 209	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   56: pop
    //   57: aload 11
    //   59: astore 9
    //   61: aload 12
    //   63: astore 10
    //   65: aload 13
    //   67: astore 8
    //   69: aload_0
    //   70: getfield 139	io/vov/vitamio/provider/MiniThumbFile:mChannel	Ljava/nio/channels/FileChannel;
    //   73: lload 6
    //   75: ldc2_w 205
    //   78: iconst_1
    //   79: invokevirtual 221	java/nio/channels/FileChannel:lock	(JJZ)Ljava/nio/channels/FileLock;
    //   82: astore 11
    //   84: aload 11
    //   86: astore 9
    //   88: aload 11
    //   90: astore 10
    //   92: aload 11
    //   94: astore 8
    //   96: aload_0
    //   97: getfield 139	io/vov/vitamio/provider/MiniThumbFile:mChannel	Ljava/nio/channels/FileChannel;
    //   100: aload_0
    //   101: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   104: lload 6
    //   106: invokevirtual 225	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;J)I
    //   109: istore 4
    //   111: iload 4
    //   113: bipush 13
    //   115: if_icmple +126 -> 241
    //   118: aload 11
    //   120: astore 9
    //   122: aload 11
    //   124: astore 10
    //   126: aload 11
    //   128: astore 8
    //   130: aload_0
    //   131: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   134: bipush 9
    //   136: invokevirtual 228	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   139: pop
    //   140: aload 11
    //   142: astore 9
    //   144: aload 11
    //   146: astore 10
    //   148: aload 11
    //   150: astore 8
    //   152: aload_0
    //   153: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   156: invokevirtual 265	java/nio/ByteBuffer:getInt	()I
    //   159: istore 5
    //   161: iload 4
    //   163: iload 5
    //   165: bipush 13
    //   167: iadd
    //   168: if_icmplt +73 -> 241
    //   171: aload 11
    //   173: astore 9
    //   175: aload 11
    //   177: astore 10
    //   179: aload 11
    //   181: astore 8
    //   183: aload_3
    //   184: arraylength
    //   185: iload 5
    //   187: if_icmplt +54 -> 241
    //   190: aload 11
    //   192: astore 9
    //   194: aload 11
    //   196: astore 10
    //   198: aload 11
    //   200: astore 8
    //   202: aload_0
    //   203: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   206: aload_3
    //   207: iconst_0
    //   208: iload 5
    //   210: invokevirtual 268	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   213: pop
    //   214: aload_3
    //   215: astore 8
    //   217: aload 11
    //   219: ifnull -203 -> 16
    //   222: aload 11
    //   224: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   227: aload_3
    //   228: astore 8
    //   230: goto -214 -> 16
    //   233: astore 8
    //   235: aload_3
    //   236: astore 8
    //   238: goto -222 -> 16
    //   241: aload 11
    //   243: ifnull +8 -> 251
    //   246: aload 11
    //   248: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   251: aconst_null
    //   252: astore 8
    //   254: goto -238 -> 16
    //   257: astore_3
    //   258: aload 9
    //   260: astore 8
    //   262: ldc_w 270
    //   265: iconst_2
    //   266: anewarray 4	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: lload_1
    //   272: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: aastore
    //   276: dup
    //   277: iconst_1
    //   278: aload_3
    //   279: invokevirtual 273	java/io/IOException:getMessage	()Ljava/lang/String;
    //   282: aastore
    //   283: invokestatic 126	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: aload 9
    //   288: ifnull -37 -> 251
    //   291: aload 9
    //   293: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   296: goto -45 -> 251
    //   299: astore_3
    //   300: goto -49 -> 251
    //   303: astore_3
    //   304: aload 10
    //   306: astore 8
    //   308: ldc_w 275
    //   311: iconst_2
    //   312: anewarray 4	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: lload_1
    //   318: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: aload_3
    //   325: invokevirtual 257	java/lang/Object:getClass	()Ljava/lang/Class;
    //   328: invokevirtual 260	java/lang/Class:toString	()Ljava/lang/String;
    //   331: aastore
    //   332: invokestatic 126	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: aload 10
    //   337: ifnull -86 -> 251
    //   340: aload 10
    //   342: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   345: goto -94 -> 251
    //   348: astore_3
    //   349: goto -98 -> 251
    //   352: astore_3
    //   353: aload 8
    //   355: ifnull +8 -> 363
    //   358: aload 8
    //   360: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   363: aload_3
    //   364: athrow
    //   365: astore_3
    //   366: aload_0
    //   367: monitorexit
    //   368: aload_3
    //   369: athrow
    //   370: astore_3
    //   371: goto -120 -> 251
    //   374: astore 8
    //   376: goto -13 -> 363
    //
    // Exception table:
    //   from	to	target	type
    //   222	227	233	java/io/IOException
    //   49	57	257	java/io/IOException
    //   69	84	257	java/io/IOException
    //   96	111	257	java/io/IOException
    //   130	140	257	java/io/IOException
    //   152	161	257	java/io/IOException
    //   183	190	257	java/io/IOException
    //   202	214	257	java/io/IOException
    //   291	296	299	java/io/IOException
    //   49	57	303	java/lang/RuntimeException
    //   69	84	303	java/lang/RuntimeException
    //   96	111	303	java/lang/RuntimeException
    //   130	140	303	java/lang/RuntimeException
    //   152	161	303	java/lang/RuntimeException
    //   183	190	303	java/lang/RuntimeException
    //   202	214	303	java/lang/RuntimeException
    //   340	345	348	java/io/IOException
    //   49	57	352	finally
    //   69	84	352	finally
    //   96	111	352	finally
    //   130	140	352	finally
    //   152	161	352	finally
    //   183	190	352	finally
    //   202	214	352	finally
    //   262	286	352	finally
    //   308	335	352	finally
    //   2	8	365	finally
    //   222	227	365	finally
    //   246	251	365	finally
    //   291	296	365	finally
    //   340	345	365	finally
    //   358	363	365	finally
    //   363	365	365	finally
    //   246	251	370	java/io/IOException
    //   358	363	374	java/io/IOException
  }

  // ERROR //
  protected void saveMiniThumbToFile(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 204	io/vov/vitamio/provider/MiniThumbFile:miniThumbDataFile	()Ljava/io/RandomAccessFile;
    //   6: astore 9
    //   8: aload 9
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: lload_2
    //   17: ldc2_w 205
    //   20: lmul
    //   21: lstore 7
    //   23: aconst_null
    //   24: astore 12
    //   26: aconst_null
    //   27: astore 13
    //   29: aconst_null
    //   30: astore 14
    //   32: aconst_null
    //   33: astore 9
    //   35: aload_1
    //   36: ifnull +221 -> 257
    //   39: aload 12
    //   41: astore 11
    //   43: aload 13
    //   45: astore 9
    //   47: aload 14
    //   49: astore 10
    //   51: aload_1
    //   52: arraylength
    //   53: istore 6
    //   55: iload 6
    //   57: sipush 9987
    //   60: if_icmple +19 -> 79
    //   63: iconst_0
    //   64: ifeq -51 -> 13
    //   67: new 279	java/lang/NullPointerException
    //   70: dup
    //   71: invokespecial 280	java/lang/NullPointerException:<init>	()V
    //   74: athrow
    //   75: astore_1
    //   76: goto -63 -> 13
    //   79: aload 12
    //   81: astore 11
    //   83: aload 13
    //   85: astore 9
    //   87: aload 14
    //   89: astore 10
    //   91: aload_0
    //   92: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   95: invokevirtual 209	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   98: pop
    //   99: aload 12
    //   101: astore 11
    //   103: aload 13
    //   105: astore 9
    //   107: aload 14
    //   109: astore 10
    //   111: aload_0
    //   112: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   115: iconst_1
    //   116: invokevirtual 283	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   119: pop
    //   120: aload 12
    //   122: astore 11
    //   124: aload 13
    //   126: astore 9
    //   128: aload 14
    //   130: astore 10
    //   132: aload_0
    //   133: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   136: lload 4
    //   138: invokevirtual 287	java/nio/ByteBuffer:putLong	(J)Ljava/nio/ByteBuffer;
    //   141: pop
    //   142: aload 12
    //   144: astore 11
    //   146: aload 13
    //   148: astore 9
    //   150: aload 14
    //   152: astore 10
    //   154: aload_0
    //   155: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   158: aload_1
    //   159: arraylength
    //   160: invokevirtual 290	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   163: pop
    //   164: aload 12
    //   166: astore 11
    //   168: aload 13
    //   170: astore 9
    //   172: aload 14
    //   174: astore 10
    //   176: aload_0
    //   177: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   180: aload_1
    //   181: invokevirtual 293	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   184: pop
    //   185: aload 12
    //   187: astore 11
    //   189: aload 13
    //   191: astore 9
    //   193: aload 14
    //   195: astore 10
    //   197: aload_0
    //   198: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   201: invokevirtual 296	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   204: pop
    //   205: aload 12
    //   207: astore 11
    //   209: aload 13
    //   211: astore 9
    //   213: aload 14
    //   215: astore 10
    //   217: aload_0
    //   218: getfield 139	io/vov/vitamio/provider/MiniThumbFile:mChannel	Ljava/nio/channels/FileChannel;
    //   221: lload 7
    //   223: ldc2_w 205
    //   226: iconst_0
    //   227: invokevirtual 221	java/nio/channels/FileChannel:lock	(JJZ)Ljava/nio/channels/FileLock;
    //   230: astore_1
    //   231: aload_1
    //   232: astore 11
    //   234: aload_1
    //   235: astore 9
    //   237: aload_1
    //   238: astore 10
    //   240: aload_0
    //   241: getfield 139	io/vov/vitamio/provider/MiniThumbFile:mChannel	Ljava/nio/channels/FileChannel;
    //   244: aload_0
    //   245: getfield 44	io/vov/vitamio/provider/MiniThumbFile:mBuffer	Ljava/nio/ByteBuffer;
    //   248: lload 7
    //   250: invokevirtual 299	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;J)I
    //   253: pop
    //   254: aload_1
    //   255: astore 9
    //   257: aload 9
    //   259: ifnull -246 -> 13
    //   262: aload 9
    //   264: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   267: goto -254 -> 13
    //   270: astore_1
    //   271: goto -258 -> 13
    //   274: astore_1
    //   275: aload 11
    //   277: astore 9
    //   279: ldc_w 301
    //   282: iconst_2
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: lload_2
    //   289: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   292: aastore
    //   293: dup
    //   294: iconst_1
    //   295: aload_1
    //   296: invokevirtual 273	java/io/IOException:getMessage	()Ljava/lang/String;
    //   299: aastore
    //   300: invokestatic 126	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   303: aload 11
    //   305: astore 9
    //   307: aload_1
    //   308: athrow
    //   309: astore_1
    //   310: aload 9
    //   312: ifnull +8 -> 320
    //   315: aload 9
    //   317: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   320: aload_1
    //   321: athrow
    //   322: astore_1
    //   323: aload_0
    //   324: monitorexit
    //   325: aload_1
    //   326: athrow
    //   327: astore_1
    //   328: aload 10
    //   330: astore 9
    //   332: ldc_w 303
    //   335: iconst_2
    //   336: anewarray 4	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: lload_2
    //   342: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: aload_1
    //   349: invokevirtual 257	java/lang/Object:getClass	()Ljava/lang/Class;
    //   352: invokevirtual 260	java/lang/Class:toString	()Ljava/lang/String;
    //   355: aastore
    //   356: invokestatic 126	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: aload 10
    //   361: ifnull -348 -> 13
    //   364: aload 10
    //   366: invokevirtual 240	java/nio/channels/FileLock:release	()V
    //   369: goto -356 -> 13
    //   372: astore_1
    //   373: goto -360 -> 13
    //   376: astore 9
    //   378: goto -58 -> 320
    //
    // Exception table:
    //   from	to	target	type
    //   67	75	75	java/io/IOException
    //   262	267	270	java/io/IOException
    //   51	55	274	java/io/IOException
    //   91	99	274	java/io/IOException
    //   111	120	274	java/io/IOException
    //   132	142	274	java/io/IOException
    //   154	164	274	java/io/IOException
    //   176	185	274	java/io/IOException
    //   197	205	274	java/io/IOException
    //   217	231	274	java/io/IOException
    //   240	254	274	java/io/IOException
    //   51	55	309	finally
    //   91	99	309	finally
    //   111	120	309	finally
    //   132	142	309	finally
    //   154	164	309	finally
    //   176	185	309	finally
    //   197	205	309	finally
    //   217	231	309	finally
    //   240	254	309	finally
    //   279	303	309	finally
    //   307	309	309	finally
    //   332	359	309	finally
    //   2	8	322	finally
    //   67	75	322	finally
    //   262	267	322	finally
    //   315	320	322	finally
    //   320	322	322	finally
    //   364	369	322	finally
    //   51	55	327	java/lang/RuntimeException
    //   91	99	327	java/lang/RuntimeException
    //   111	120	327	java/lang/RuntimeException
    //   132	142	327	java/lang/RuntimeException
    //   154	164	327	java/lang/RuntimeException
    //   176	185	327	java/lang/RuntimeException
    //   197	205	327	java/lang/RuntimeException
    //   217	231	327	java/lang/RuntimeException
    //   240	254	327	java/lang/RuntimeException
    //   364	369	372	java/io/IOException
    //   315	320	376	java/io/IOException
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.provider.MiniThumbFile
 * JD-Core Version:    0.6.0
 */