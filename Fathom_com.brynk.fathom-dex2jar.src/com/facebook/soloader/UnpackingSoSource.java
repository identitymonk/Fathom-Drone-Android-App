package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public abstract class UnpackingSoSource extends DirectorySoSource
{
  private static final String DEPS_FILE_NAME = "dso_deps";
  private static final String LOCK_FILE_NAME = "dso_lock";
  private static final String MANIFEST_FILE_NAME = "dso_manifest";
  private static final byte MANIFEST_VERSION = 1;
  private static final byte STATE_CLEAN = 1;
  private static final byte STATE_DIRTY = 0;
  private static final String STATE_FILE_NAME = "dso_state";
  private static final String TAG = "fb-UnpackingSoSource";
  protected final Context mContext;

  protected UnpackingSoSource(Context paramContext, String paramString)
  {
    super(getSoStorePath(paramContext, paramString), 1);
    this.mContext = paramContext;
  }

  private void deleteUnmentionedFiles(Dso[] paramArrayOfDso)
    throws IOException
  {
    String[] arrayOfString = this.soDirectory.list();
    if (arrayOfString == null)
      throw new IOException("unable to list directory " + this.soDirectory);
    int i = 0;
    if (i < arrayOfString.length)
    {
      Object localObject = arrayOfString[i];
      if ((((String)localObject).equals("dso_state")) || (((String)localObject).equals("dso_lock")) || (((String)localObject).equals("dso_deps")) || (((String)localObject).equals("dso_manifest")));
      while (true)
      {
        i += 1;
        break;
        int k = 0;
        int j = 0;
        while ((k == 0) && (j < paramArrayOfDso.length))
        {
          if (paramArrayOfDso[j].name.equals(localObject))
            k = 1;
          j += 1;
        }
        if (k != 0)
          continue;
        localObject = new File(this.soDirectory, (String)localObject);
        Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + localObject);
        SysUtil.dumbDeleteRecursive((File)localObject);
      }
    }
  }

  private void extractDso(InputDso paramInputDso, byte[] paramArrayOfByte)
    throws IOException
  {
    Log.i("fb-UnpackingSoSource", "extracting DSO " + paramInputDso.dso.name);
    File localFile = new File(this.soDirectory, paramInputDso.dso.name);
    try
    {
      RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile, "rw");
      try
      {
        int i = paramInputDso.content.available();
        if (i > 1)
          SysUtil.fallocateIfSupported(localRandomAccessFile1.getFD(), i);
        SysUtil.copyBytes(localRandomAccessFile1, paramInputDso.content, 2147483647, paramArrayOfByte);
        localRandomAccessFile1.setLength(localRandomAccessFile1.getFilePointer());
        if (!localFile.setExecutable(true, false))
          throw new IOException("cannot make file executable: " + localFile);
      }
      finally
      {
        localRandomAccessFile1.close();
      }
    }
    catch (IOException localRandomAccessFile2)
    {
      RandomAccessFile localRandomAccessFile2;
      while (true)
      {
        Log.w("fb-UnpackingSoSource", "error overwriting " + localFile + " trying to delete and start over", localIOException);
        localFile.delete();
        localRandomAccessFile2 = new RandomAccessFile(localFile, "rw");
      }
      localRandomAccessFile2.close();
    }
  }

  public static File getSoStorePath(Context paramContext, String paramString)
  {
    return new File(paramContext.getApplicationInfo().dataDir + "/" + paramString);
  }

  // ERROR //
  private boolean refreshLocked(FileLocker paramFileLocker, int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: new 73	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 71	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   8: ldc 40
    //   10: invokespecial 110	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore 10
    //   15: new 137	java/io/RandomAccessFile
    //   18: dup
    //   19: aload 10
    //   21: ldc 139
    //   23: invokespecial 140	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 7
    //   28: aconst_null
    //   29: astore 6
    //   31: aload 7
    //   33: invokevirtual 216	java/io/RandomAccessFile:readByte	()B
    //   36: istore 5
    //   38: iload 5
    //   40: istore 4
    //   42: iload 5
    //   44: iconst_1
    //   45: if_icmpeq +39 -> 84
    //   48: ldc 43
    //   50: new 79	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   57: ldc 218
    //   59: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 71	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   66: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: ldc 220
    //   71: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: iconst_0
    //   82: istore 4
    //   84: aload 7
    //   86: ifnull +12 -> 98
    //   89: iconst_0
    //   90: ifeq +219 -> 309
    //   93: aload 7
    //   95: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   98: new 73	java/io/File
    //   101: dup
    //   102: aload_0
    //   103: getfield 71	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   106: ldc 25
    //   108: invokespecial 110	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   111: astore 11
    //   113: aconst_null
    //   114: astore 6
    //   116: new 137	java/io/RandomAccessFile
    //   119: dup
    //   120: aload 11
    //   122: ldc 139
    //   124: invokespecial 140	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   127: astore 8
    //   129: aload 8
    //   131: invokevirtual 223	java/io/RandomAccessFile:length	()J
    //   134: l2i
    //   135: newarray byte
    //   137: astore 7
    //   139: aload 8
    //   141: aload 7
    //   143: invokevirtual 227	java/io/RandomAccessFile:read	([B)I
    //   146: aload 7
    //   148: arraylength
    //   149: if_icmpeq +14 -> 163
    //   152: ldc 43
    //   154: ldc 229
    //   156: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   159: pop
    //   160: iconst_0
    //   161: istore 4
    //   163: aload 7
    //   165: aload_3
    //   166: invokestatic 234	java/util/Arrays:equals	([B[B)Z
    //   169: ifne +14 -> 183
    //   172: ldc 43
    //   174: ldc 236
    //   176: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   179: pop
    //   180: iconst_0
    //   181: istore 4
    //   183: iload 4
    //   185: ifne +86 -> 271
    //   188: ldc 43
    //   190: ldc 238
    //   192: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: aload 10
    //   198: iconst_0
    //   199: invokestatic 64	com/facebook/soloader/UnpackingSoSource:writeState	(Ljava/io/File;B)V
    //   202: aload_0
    //   203: invokevirtual 242	com/facebook/soloader/UnpackingSoSource:makeUnpacker	()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    //   206: astore 9
    //   208: aload 9
    //   210: invokevirtual 246	com/facebook/soloader/UnpackingSoSource$Unpacker:getDsoManifest	()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   213: astore 7
    //   215: aload 9
    //   217: invokevirtual 250	com/facebook/soloader/UnpackingSoSource$Unpacker:openDsoIterator	()Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    //   220: astore 12
    //   222: aconst_null
    //   223: astore 6
    //   225: aload_0
    //   226: iload 4
    //   228: aload 7
    //   230: aload 12
    //   232: invokespecial 254	com/facebook/soloader/UnpackingSoSource:regenerate	(BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;)V
    //   235: aload 12
    //   237: ifnull +12 -> 249
    //   240: iconst_0
    //   241: ifeq +164 -> 405
    //   244: aload 12
    //   246: invokevirtual 255	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   249: aload 7
    //   251: astore 6
    //   253: aload 9
    //   255: ifnull +16 -> 271
    //   258: iconst_0
    //   259: ifeq +211 -> 470
    //   262: aload 9
    //   264: invokevirtual 256	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   267: aload 7
    //   269: astore 6
    //   271: aload 8
    //   273: ifnull +12 -> 285
    //   276: iconst_0
    //   277: ifeq +233 -> 510
    //   280: aload 8
    //   282: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   285: aload 6
    //   287: ifnonnull +250 -> 537
    //   290: iconst_0
    //   291: ireturn
    //   292: astore 6
    //   294: iconst_0
    //   295: istore 4
    //   297: goto -213 -> 84
    //   300: astore_1
    //   301: new 258	java/lang/NullPointerException
    //   304: dup
    //   305: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   308: athrow
    //   309: aload 7
    //   311: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   314: goto -216 -> 98
    //   317: astore_1
    //   318: aload_1
    //   319: athrow
    //   320: astore_3
    //   321: aload 7
    //   323: ifnull +12 -> 335
    //   326: aload_1
    //   327: ifnull +21 -> 348
    //   330: aload 7
    //   332: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   335: aload_3
    //   336: athrow
    //   337: astore 6
    //   339: aload_1
    //   340: aload 6
    //   342: invokevirtual 263	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   345: goto -10 -> 335
    //   348: aload 7
    //   350: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   353: goto -18 -> 335
    //   356: astore_1
    //   357: new 258	java/lang/NullPointerException
    //   360: dup
    //   361: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   364: athrow
    //   365: astore_1
    //   366: aload_1
    //   367: athrow
    //   368: astore_3
    //   369: aload 9
    //   371: ifnull +12 -> 383
    //   374: aload_1
    //   375: ifnull +118 -> 493
    //   378: aload 9
    //   380: invokevirtual 256	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   383: aload_3
    //   384: athrow
    //   385: astore_1
    //   386: aload_1
    //   387: athrow
    //   388: astore_3
    //   389: aload 8
    //   391: ifnull +12 -> 403
    //   394: aload_1
    //   395: ifnull +134 -> 529
    //   398: aload 8
    //   400: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   403: aload_3
    //   404: athrow
    //   405: aload 12
    //   407: invokevirtual 255	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   410: goto -161 -> 249
    //   413: astore_3
    //   414: aconst_null
    //   415: astore_1
    //   416: goto -47 -> 369
    //   419: astore_1
    //   420: aload_1
    //   421: astore 6
    //   423: aload_1
    //   424: athrow
    //   425: astore_1
    //   426: aload 12
    //   428: ifnull +13 -> 441
    //   431: aload 6
    //   433: ifnull +20 -> 453
    //   436: aload 12
    //   438: invokevirtual 255	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   441: aload_1
    //   442: athrow
    //   443: astore_3
    //   444: aload 6
    //   446: aload_3
    //   447: invokevirtual 263	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   450: goto -9 -> 441
    //   453: aload 12
    //   455: invokevirtual 255	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   458: goto -17 -> 441
    //   461: astore_1
    //   462: new 258	java/lang/NullPointerException
    //   465: dup
    //   466: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   469: athrow
    //   470: aload 9
    //   472: invokevirtual 256	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   475: aload 7
    //   477: astore 6
    //   479: goto -208 -> 271
    //   482: astore 6
    //   484: aload_1
    //   485: aload 6
    //   487: invokevirtual 263	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   490: goto -107 -> 383
    //   493: aload 9
    //   495: invokevirtual 256	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   498: goto -115 -> 383
    //   501: astore_1
    //   502: new 258	java/lang/NullPointerException
    //   505: dup
    //   506: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   509: athrow
    //   510: aload 8
    //   512: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   515: goto -230 -> 285
    //   518: astore 6
    //   520: aload_1
    //   521: aload 6
    //   523: invokevirtual 263	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   526: goto -123 -> 403
    //   529: aload 8
    //   531: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   534: goto -131 -> 403
    //   537: new 6	com/facebook/soloader/UnpackingSoSource$1
    //   540: dup
    //   541: aload_0
    //   542: aload 11
    //   544: aload_3
    //   545: aload 6
    //   547: aload 10
    //   549: aload_1
    //   550: invokespecial 266	com/facebook/soloader/UnpackingSoSource$1:<init>	(Lcom/facebook/soloader/UnpackingSoSource;Ljava/io/File;[BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Ljava/io/File;Lcom/facebook/soloader/FileLocker;)V
    //   553: astore_1
    //   554: iload_2
    //   555: iconst_1
    //   556: iand
    //   557: ifeq +42 -> 599
    //   560: new 268	java/lang/Thread
    //   563: dup
    //   564: aload_1
    //   565: new 79	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 270
    //   575: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_0
    //   579: getfield 71	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   582: invokevirtual 273	java/io/File:getName	()Ljava/lang/String;
    //   585: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokespecial 276	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   594: invokevirtual 279	java/lang/Thread:start	()V
    //   597: iconst_1
    //   598: ireturn
    //   599: aload_1
    //   600: invokeinterface 284 1 0
    //   605: goto -8 -> 597
    //   608: astore_3
    //   609: aload 6
    //   611: astore_1
    //   612: goto -291 -> 321
    //   615: astore_3
    //   616: aconst_null
    //   617: astore_1
    //   618: goto -229 -> 389
    //
    // Exception table:
    //   from	to	target	type
    //   31	38	292	java/io/EOFException
    //   48	81	292	java/io/EOFException
    //   93	98	300	java/lang/Throwable
    //   31	38	317	java/lang/Throwable
    //   48	81	317	java/lang/Throwable
    //   318	320	320	finally
    //   330	335	337	java/lang/Throwable
    //   244	249	356	java/lang/Throwable
    //   208	222	365	java/lang/Throwable
    //   357	365	365	java/lang/Throwable
    //   405	410	365	java/lang/Throwable
    //   441	443	365	java/lang/Throwable
    //   444	450	365	java/lang/Throwable
    //   453	458	365	java/lang/Throwable
    //   366	368	368	finally
    //   129	139	385	java/lang/Throwable
    //   139	160	385	java/lang/Throwable
    //   163	180	385	java/lang/Throwable
    //   188	208	385	java/lang/Throwable
    //   383	385	385	java/lang/Throwable
    //   462	470	385	java/lang/Throwable
    //   470	475	385	java/lang/Throwable
    //   484	490	385	java/lang/Throwable
    //   493	498	385	java/lang/Throwable
    //   386	388	388	finally
    //   208	222	413	finally
    //   244	249	413	finally
    //   357	365	413	finally
    //   405	410	413	finally
    //   436	441	413	finally
    //   441	443	413	finally
    //   444	450	413	finally
    //   453	458	413	finally
    //   225	235	419	java/lang/Throwable
    //   225	235	425	finally
    //   423	425	425	finally
    //   436	441	443	java/lang/Throwable
    //   262	267	461	java/lang/Throwable
    //   378	383	482	java/lang/Throwable
    //   280	285	501	java/lang/Throwable
    //   398	403	518	java/lang/Throwable
    //   31	38	608	finally
    //   48	81	608	finally
    //   129	139	615	finally
    //   139	160	615	finally
    //   163	180	615	finally
    //   188	208	615	finally
    //   262	267	615	finally
    //   378	383	615	finally
    //   383	385	615	finally
    //   462	470	615	finally
    //   470	475	615	finally
    //   484	490	615	finally
    //   493	498	615	finally
  }

  // ERROR //
  private void regenerate(byte paramByte, DsoManifest paramDsoManifest, InputDsoIterator paramInputDsoIterator)
    throws IOException
  {
    // Byte code:
    //   0: ldc 43
    //   2: new 79	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 288
    //   12: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 294	java/lang/Object:getClass	()Ljava/lang/Class;
    //   19: invokevirtual 297	java/lang/Class:getName	()Ljava/lang/String;
    //   22: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: new 137	java/io/RandomAccessFile
    //   35: dup
    //   36: new 73	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: getfield 71	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   44: ldc 31
    //   46: invokespecial 110	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: ldc 139
    //   51: invokespecial 140	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 9
    //   56: iload_1
    //   57: iconst_1
    //   58: if_icmpne +166 -> 224
    //   61: aload 9
    //   63: invokestatic 300	com/facebook/soloader/UnpackingSoSource$DsoManifest:read	(Ljava/io/DataInput;)Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   66: astore 7
    //   68: aload 7
    //   70: ifnonnull +330 -> 400
    //   73: new 11	com/facebook/soloader/UnpackingSoSource$DsoManifest
    //   76: dup
    //   77: iconst_0
    //   78: anewarray 8	com/facebook/soloader/UnpackingSoSource$Dso
    //   81: invokespecial 302	com/facebook/soloader/UnpackingSoSource$DsoManifest:<init>	([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    //   84: astore 7
    //   86: aload_0
    //   87: aload_2
    //   88: getfield 306	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   91: invokespecial 308	com/facebook/soloader/UnpackingSoSource:deleteUnmentionedFiles	([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    //   94: ldc_w 309
    //   97: newarray byte
    //   99: astore_2
    //   100: aload_3
    //   101: invokevirtual 312	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:hasNext	()Z
    //   104: ifeq +236 -> 340
    //   107: aload_3
    //   108: invokevirtual 316	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:next	()Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    //   111: astore 10
    //   113: aconst_null
    //   114: astore 8
    //   116: iconst_1
    //   117: istore_1
    //   118: iconst_0
    //   119: istore 4
    //   121: iload_1
    //   122: ifeq +108 -> 230
    //   125: iload 4
    //   127: aload 7
    //   129: getfield 306	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   132: arraylength
    //   133: if_icmpge +97 -> 230
    //   136: iload_1
    //   137: istore 5
    //   139: aload 7
    //   141: getfield 306	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   144: iload 4
    //   146: aaload
    //   147: getfield 107	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   150: aload 10
    //   152: getfield 132	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   155: getfield 107	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   158: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifeq +38 -> 199
    //   164: aload 7
    //   166: getfield 306	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   169: iload 4
    //   171: aaload
    //   172: getfield 319	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   175: aload 10
    //   177: getfield 132	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   180: getfield 319	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   183: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: istore 6
    //   188: iload_1
    //   189: istore 5
    //   191: iload 6
    //   193: ifeq +6 -> 199
    //   196: iconst_0
    //   197: istore 5
    //   199: iload 4
    //   201: iconst_1
    //   202: iadd
    //   203: istore 4
    //   205: iload 5
    //   207: istore_1
    //   208: goto -87 -> 121
    //   211: astore 7
    //   213: ldc 43
    //   215: ldc_w 321
    //   218: aload 7
    //   220: invokestatic 323	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   223: pop
    //   224: aconst_null
    //   225: astore 7
    //   227: goto -159 -> 68
    //   230: iload_1
    //   231: ifeq +10 -> 241
    //   234: aload_0
    //   235: aload 10
    //   237: aload_2
    //   238: invokespecial 325	com/facebook/soloader/UnpackingSoSource:extractDso	(Lcom/facebook/soloader/UnpackingSoSource$InputDso;[B)V
    //   241: aload 10
    //   243: ifnull -143 -> 100
    //   246: iconst_0
    //   247: ifeq +40 -> 287
    //   250: aload 10
    //   252: invokevirtual 326	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   255: goto -155 -> 100
    //   258: astore_2
    //   259: new 258	java/lang/NullPointerException
    //   262: dup
    //   263: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   266: athrow
    //   267: astore_2
    //   268: aload_2
    //   269: athrow
    //   270: astore_3
    //   271: aload 9
    //   273: ifnull +12 -> 285
    //   276: aload_2
    //   277: ifnull +104 -> 381
    //   280: aload 9
    //   282: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   285: aload_3
    //   286: athrow
    //   287: aload 10
    //   289: invokevirtual 326	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   292: goto -192 -> 100
    //   295: astore_3
    //   296: aconst_null
    //   297: astore_2
    //   298: goto -27 -> 271
    //   301: astore_3
    //   302: aload_3
    //   303: athrow
    //   304: astore_2
    //   305: aload 10
    //   307: ifnull +12 -> 319
    //   310: aload_3
    //   311: ifnull +21 -> 332
    //   314: aload 10
    //   316: invokevirtual 326	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   319: aload_2
    //   320: athrow
    //   321: astore 7
    //   323: aload_3
    //   324: aload 7
    //   326: invokevirtual 263	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   329: goto -10 -> 319
    //   332: aload 10
    //   334: invokevirtual 326	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   337: goto -18 -> 319
    //   340: aload 9
    //   342: ifnull +12 -> 354
    //   345: iconst_0
    //   346: ifeq +18 -> 364
    //   349: aload 9
    //   351: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   354: return
    //   355: astore_2
    //   356: new 258	java/lang/NullPointerException
    //   359: dup
    //   360: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   363: athrow
    //   364: aload 9
    //   366: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   369: return
    //   370: astore 7
    //   372: aload_2
    //   373: aload 7
    //   375: invokevirtual 263	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   378: goto -93 -> 285
    //   381: aload 9
    //   383: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   386: goto -101 -> 285
    //   389: astore_2
    //   390: goto -122 -> 268
    //   393: astore_2
    //   394: aload 8
    //   396: astore_3
    //   397: goto -92 -> 305
    //   400: goto -314 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   61	68	211	java/lang/Exception
    //   250	255	258	java/lang/Throwable
    //   61	68	267	java/lang/Throwable
    //   86	100	267	java/lang/Throwable
    //   100	113	267	java/lang/Throwable
    //   213	224	267	java/lang/Throwable
    //   259	267	267	java/lang/Throwable
    //   287	292	267	java/lang/Throwable
    //   319	321	267	java/lang/Throwable
    //   323	329	267	java/lang/Throwable
    //   332	337	267	java/lang/Throwable
    //   268	270	270	finally
    //   61	68	295	finally
    //   73	86	295	finally
    //   86	100	295	finally
    //   100	113	295	finally
    //   213	224	295	finally
    //   250	255	295	finally
    //   259	267	295	finally
    //   287	292	295	finally
    //   314	319	295	finally
    //   319	321	295	finally
    //   323	329	295	finally
    //   332	337	295	finally
    //   125	136	301	java/lang/Throwable
    //   139	188	301	java/lang/Throwable
    //   234	241	301	java/lang/Throwable
    //   302	304	304	finally
    //   314	319	321	java/lang/Throwable
    //   349	354	355	java/lang/Throwable
    //   280	285	370	java/lang/Throwable
    //   73	86	389	java/lang/Throwable
    //   125	136	393	finally
    //   139	188	393	finally
    //   234	241	393	finally
  }

  // ERROR //
  private static void writeState(File paramFile, byte paramByte)
    throws IOException
  {
    // Byte code:
    //   0: new 137	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 139
    //   7: invokespecial 140	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_3
    //   14: lconst_0
    //   15: invokevirtual 329	java/io/RandomAccessFile:seek	(J)V
    //   18: aload_3
    //   19: iload_1
    //   20: invokevirtual 333	java/io/RandomAccessFile:write	(I)V
    //   23: aload_3
    //   24: aload_3
    //   25: invokevirtual 167	java/io/RandomAccessFile:getFilePointer	()J
    //   28: invokevirtual 171	java/io/RandomAccessFile:setLength	(J)V
    //   31: aload_3
    //   32: invokevirtual 154	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   35: invokevirtual 338	java/io/FileDescriptor:sync	()V
    //   38: aload_3
    //   39: ifnull +11 -> 50
    //   42: iconst_0
    //   43: ifeq +17 -> 60
    //   46: aload_3
    //   47: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   50: return
    //   51: astore_0
    //   52: new 258	java/lang/NullPointerException
    //   55: dup
    //   56: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   59: athrow
    //   60: aload_3
    //   61: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   64: return
    //   65: astore_2
    //   66: aload_2
    //   67: athrow
    //   68: astore_0
    //   69: aload_3
    //   70: ifnull +11 -> 81
    //   73: aload_2
    //   74: ifnull +18 -> 92
    //   77: aload_3
    //   78: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   81: aload_0
    //   82: athrow
    //   83: astore_3
    //   84: aload_2
    //   85: aload_3
    //   86: invokevirtual 263	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   89: goto -8 -> 81
    //   92: aload_3
    //   93: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   96: goto -15 -> 81
    //   99: astore_0
    //   100: goto -31 -> 69
    //
    // Exception table:
    //   from	to	target	type
    //   46	50	51	java/lang/Throwable
    //   13	38	65	java/lang/Throwable
    //   66	68	68	finally
    //   77	81	83	java/lang/Throwable
    //   13	38	99	finally
  }

  // ERROR //
  protected byte[] getDepsBlock()
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 346	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_0
    //   5: invokevirtual 242	com/facebook/soloader/UnpackingSoSource:makeUnpacker	()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: aload 4
    //   14: invokevirtual 246	com/facebook/soloader/UnpackingSoSource$Unpacker:getDsoManifest	()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   17: getfield 306	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   20: astore 5
    //   22: aload_2
    //   23: iconst_1
    //   24: invokevirtual 350	android/os/Parcel:writeByte	(B)V
    //   27: aload_2
    //   28: aload 5
    //   30: arraylength
    //   31: invokevirtual 353	android/os/Parcel:writeInt	(I)V
    //   34: iconst_0
    //   35: istore_1
    //   36: iload_1
    //   37: aload 5
    //   39: arraylength
    //   40: if_icmpge +32 -> 72
    //   43: aload_2
    //   44: aload 5
    //   46: iload_1
    //   47: aaload
    //   48: getfield 107	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   51: invokevirtual 356	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   54: aload_2
    //   55: aload 5
    //   57: iload_1
    //   58: aaload
    //   59: getfield 319	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   62: invokevirtual 356	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   65: iload_1
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: goto -33 -> 36
    //   72: aload 4
    //   74: ifnull +12 -> 86
    //   77: iconst_0
    //   78: ifeq +28 -> 106
    //   81: aload 4
    //   83: invokevirtual 256	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   86: aload_2
    //   87: invokevirtual 359	android/os/Parcel:marshall	()[B
    //   90: astore_3
    //   91: aload_2
    //   92: invokevirtual 362	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: areturn
    //   97: astore_2
    //   98: new 258	java/lang/NullPointerException
    //   101: dup
    //   102: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   105: athrow
    //   106: aload 4
    //   108: invokevirtual 256	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   111: goto -25 -> 86
    //   114: astore_3
    //   115: aload_3
    //   116: athrow
    //   117: astore_2
    //   118: aload 4
    //   120: ifnull +12 -> 132
    //   123: aload_3
    //   124: ifnull +21 -> 145
    //   127: aload 4
    //   129: invokevirtual 256	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   132: aload_2
    //   133: athrow
    //   134: astore 4
    //   136: aload_3
    //   137: aload 4
    //   139: invokevirtual 263	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   142: goto -10 -> 132
    //   145: aload 4
    //   147: invokevirtual 256	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   150: goto -18 -> 132
    //   153: astore_2
    //   154: goto -36 -> 118
    //
    // Exception table:
    //   from	to	target	type
    //   81	86	97	java/lang/Throwable
    //   12	34	114	java/lang/Throwable
    //   36	65	114	java/lang/Throwable
    //   115	117	117	finally
    //   127	132	134	java/lang/Throwable
    //   12	34	153	finally
    //   36	65	153	finally
  }

  protected abstract Unpacker makeUnpacker()
    throws IOException;

  protected void prepare(int paramInt)
    throws IOException
  {
    SysUtil.mkdirOrThrow(this.soDirectory);
    FileLocker localFileLocker = FileLocker.lock(new File(this.soDirectory, "dso_lock"));
    try
    {
      Log.v("fb-UnpackingSoSource", "locked dso store " + this.soDirectory);
      boolean bool = refreshLocked(localFileLocker, paramInt, getDepsBlock());
      if (bool)
        localFileLocker = null;
      while (localFileLocker != null)
      {
        Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.soDirectory);
        localFileLocker.close();
        return;
        Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.soDirectory);
      }
    }
    finally
    {
      if (localFileLocker == null)
        break label218;
    }
    Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.soDirectory);
    localFileLocker.close();
    while (true)
    {
      throw localObject;
      Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
      return;
      label218: Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
    }
  }

  public static class Dso
  {
    public final String hash;
    public final String name;

    public Dso(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.hash = paramString2;
    }
  }

  public static final class DsoManifest
  {
    public final UnpackingSoSource.Dso[] dsos;

    public DsoManifest(UnpackingSoSource.Dso[] paramArrayOfDso)
    {
      this.dsos = paramArrayOfDso;
    }

    static final DsoManifest read(DataInput paramDataInput)
      throws IOException
    {
      if (paramDataInput.readByte() != 1)
        throw new RuntimeException("wrong dso manifest version");
      int j = paramDataInput.readInt();
      if (j < 0)
        throw new RuntimeException("illegal number of shared libraries");
      UnpackingSoSource.Dso[] arrayOfDso = new UnpackingSoSource.Dso[j];
      int i = 0;
      while (i < j)
      {
        arrayOfDso[i] = new UnpackingSoSource.Dso(paramDataInput.readUTF(), paramDataInput.readUTF());
        i += 1;
      }
      return new DsoManifest(arrayOfDso);
    }

    public final void write(DataOutput paramDataOutput)
      throws IOException
    {
      paramDataOutput.writeByte(1);
      paramDataOutput.writeInt(this.dsos.length);
      int i = 0;
      while (i < this.dsos.length)
      {
        paramDataOutput.writeUTF(this.dsos[i].name);
        paramDataOutput.writeUTF(this.dsos[i].hash);
        i += 1;
      }
    }
  }

  protected static final class InputDso
    implements Closeable
  {
    public final InputStream content;
    public final UnpackingSoSource.Dso dso;

    public InputDso(UnpackingSoSource.Dso paramDso, InputStream paramInputStream)
    {
      this.dso = paramDso;
      this.content = paramInputStream;
    }

    public void close()
      throws IOException
    {
      this.content.close();
    }
  }

  protected static abstract class InputDsoIterator
    implements Closeable
  {
    public void close()
      throws IOException
    {
    }

    public abstract boolean hasNext();

    public abstract UnpackingSoSource.InputDso next()
      throws IOException;
  }

  protected static abstract class Unpacker
    implements Closeable
  {
    public void close()
      throws IOException
    {
    }

    protected abstract UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException;

    protected abstract UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.soloader.UnpackingSoSource
 * JD-Core Version:    0.6.0
 */