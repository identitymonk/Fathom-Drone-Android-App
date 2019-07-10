package com.facebook.soloader;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ExoSoSource extends UnpackingSoSource
{
  public ExoSoSource(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }

  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ExoUnpacker();
  }

  private final class ExoUnpacker extends UnpackingSoSource.Unpacker
  {
    private final ExoSoSource.FileDso[] mDsos;

    // ERROR //
    ExoUnpacker()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 22	com/facebook/soloader/ExoSoSource$ExoUnpacker:this$0	Lcom/facebook/soloader/ExoSoSource;
      //   5: aload_0
      //   6: invokespecial 25	com/facebook/soloader/UnpackingSoSource$Unpacker:<init>	()V
      //   9: aload_1
      //   10: getfield 29	com/facebook/soloader/ExoSoSource:mContext	Landroid/content/Context;
      //   13: astore_1
      //   14: new 31	java/io/File
      //   17: dup
      //   18: new 33	java/lang/StringBuilder
      //   21: dup
      //   22: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   25: ldc 36
      //   27: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: aload_1
      //   31: invokevirtual 46	android/content/Context:getPackageName	()Ljava/lang/String;
      //   34: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: ldc 48
      //   39: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   45: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
      //   48: astore 14
      //   50: new 56	java/util/ArrayList
      //   53: dup
      //   54: invokespecial 57	java/util/ArrayList:<init>	()V
      //   57: astore 9
      //   59: invokestatic 63	com/facebook/soloader/SysUtil:getSupportedAbis	()[Ljava/lang/String;
      //   62: astore 12
      //   64: aload 12
      //   66: arraylength
      //   67: istore 6
      //   69: iconst_0
      //   70: istore_2
      //   71: iload_2
      //   72: iload 6
      //   74: if_icmpge +424 -> 498
      //   77: new 31	java/io/File
      //   80: dup
      //   81: aload 14
      //   83: aload 12
      //   85: iload_2
      //   86: aaload
      //   87: invokespecial 66	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   90: astore 13
      //   92: aload 13
      //   94: invokevirtual 70	java/io/File:isDirectory	()Z
      //   97: ifne +10 -> 107
      //   100: iload_2
      //   101: iconst_1
      //   102: iadd
      //   103: istore_2
      //   104: goto -33 -> 71
      //   107: new 31	java/io/File
      //   110: dup
      //   111: aload 13
      //   113: ldc 72
      //   115: invokespecial 66	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   118: astore_1
      //   119: aload_1
      //   120: invokevirtual 75	java/io/File:isFile	()Z
      //   123: ifeq -23 -> 100
      //   126: new 77	java/io/FileReader
      //   129: dup
      //   130: aload_1
      //   131: invokespecial 80	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   134: astore 10
      //   136: new 82	java/io/BufferedReader
      //   139: dup
      //   140: aload 10
      //   142: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   145: astore 11
      //   147: aconst_null
      //   148: astore_1
      //   149: aload 11
      //   151: invokevirtual 88	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   154: astore 16
      //   156: aload 16
      //   158: ifnull +237 -> 395
      //   161: aload 16
      //   163: invokevirtual 94	java/lang/String:length	()I
      //   166: ifeq -17 -> 149
      //   169: aload 16
      //   171: bipush 32
      //   173: invokevirtual 98	java/lang/String:indexOf	(I)I
      //   176: istore 7
      //   178: iload 7
      //   180: iconst_m1
      //   181: if_icmpne +80 -> 261
      //   184: new 100	java/lang/RuntimeException
      //   187: dup
      //   188: new 33	java/lang/StringBuilder
      //   191: dup
      //   192: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   195: ldc 102
      //   197: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   200: aload 16
      //   202: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   205: ldc 104
      //   207: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   210: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   213: invokespecial 105	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   216: athrow
      //   217: astore_1
      //   218: aload_1
      //   219: athrow
      //   220: astore 9
      //   222: aload 11
      //   224: ifnull +12 -> 236
      //   227: aload_1
      //   228: ifnull +235 -> 463
      //   231: aload 11
      //   233: invokevirtual 108	java/io/BufferedReader:close	()V
      //   236: aload 9
      //   238: athrow
      //   239: astore_1
      //   240: aload_1
      //   241: athrow
      //   242: astore 9
      //   244: aload 10
      //   246: ifnull +12 -> 258
      //   249: aload_1
      //   250: ifnull +240 -> 490
      //   253: aload 10
      //   255: invokevirtual 109	java/io/FileReader:close	()V
      //   258: aload 9
      //   260: athrow
      //   261: new 33	java/lang/StringBuilder
      //   264: dup
      //   265: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   268: aload 16
      //   270: iconst_0
      //   271: iload 7
      //   273: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
      //   276: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   279: ldc 115
      //   281: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   284: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   287: astore 15
      //   289: aload 9
      //   291: invokevirtual 118	java/util/ArrayList:size	()I
      //   294: istore 8
      //   296: iconst_0
      //   297: istore 5
      //   299: iconst_0
      //   300: istore 4
      //   302: iload 5
      //   304: istore_3
      //   305: iload 4
      //   307: iload 8
      //   309: if_icmpge +26 -> 335
      //   312: aload 9
      //   314: iload 4
      //   316: invokevirtual 122	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   319: checkcast 124	com/facebook/soloader/ExoSoSource$FileDso
      //   322: getfield 128	com/facebook/soloader/ExoSoSource$FileDso:name	Ljava/lang/String;
      //   325: aload 15
      //   327: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   330: ifeq +56 -> 386
      //   333: iconst_1
      //   334: istore_3
      //   335: iload_3
      //   336: ifne -187 -> 149
      //   339: aload 16
      //   341: iload 7
      //   343: iconst_1
      //   344: iadd
      //   345: invokevirtual 135	java/lang/String:substring	(I)Ljava/lang/String;
      //   348: astore 16
      //   350: aload 9
      //   352: new 124	com/facebook/soloader/ExoSoSource$FileDso
      //   355: dup
      //   356: aload 15
      //   358: aload 16
      //   360: new 31	java/io/File
      //   363: dup
      //   364: aload 13
      //   366: aload 16
      //   368: invokespecial 66	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   371: invokespecial 138	com/facebook/soloader/ExoSoSource$FileDso:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
      //   374: invokevirtual 141	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   377: pop
      //   378: goto -229 -> 149
      //   381: astore 9
      //   383: goto -161 -> 222
      //   386: iload 4
      //   388: iconst_1
      //   389: iadd
      //   390: istore 4
      //   392: goto -90 -> 302
      //   395: aload 11
      //   397: ifnull +12 -> 409
      //   400: iconst_0
      //   401: ifeq +43 -> 444
      //   404: aload 11
      //   406: invokevirtual 108	java/io/BufferedReader:close	()V
      //   409: aload 10
      //   411: ifnull -311 -> 100
      //   414: iconst_0
      //   415: ifeq +56 -> 471
      //   418: aload 10
      //   420: invokevirtual 109	java/io/FileReader:close	()V
      //   423: goto -323 -> 100
      //   426: astore_1
      //   427: new 143	java/lang/NullPointerException
      //   430: dup
      //   431: invokespecial 144	java/lang/NullPointerException:<init>	()V
      //   434: athrow
      //   435: astore_1
      //   436: new 143	java/lang/NullPointerException
      //   439: dup
      //   440: invokespecial 144	java/lang/NullPointerException:<init>	()V
      //   443: athrow
      //   444: aload 11
      //   446: invokevirtual 108	java/io/BufferedReader:close	()V
      //   449: goto -40 -> 409
      //   452: astore 11
      //   454: aload_1
      //   455: aload 11
      //   457: invokevirtual 148	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   460: goto -224 -> 236
      //   463: aload 11
      //   465: invokevirtual 108	java/io/BufferedReader:close	()V
      //   468: goto -232 -> 236
      //   471: aload 10
      //   473: invokevirtual 109	java/io/FileReader:close	()V
      //   476: goto -376 -> 100
      //   479: astore 10
      //   481: aload_1
      //   482: aload 10
      //   484: invokevirtual 148	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   487: goto -229 -> 258
      //   490: aload 10
      //   492: invokevirtual 109	java/io/FileReader:close	()V
      //   495: goto -237 -> 258
      //   498: aload_0
      //   499: aload 9
      //   501: aload 9
      //   503: invokevirtual 118	java/util/ArrayList:size	()I
      //   506: anewarray 124	com/facebook/soloader/ExoSoSource$FileDso
      //   509: invokevirtual 152	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
      //   512: checkcast 153	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   515: putfield 155	com/facebook/soloader/ExoSoSource$ExoUnpacker:mDsos	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   518: return
      //   519: astore 9
      //   521: aconst_null
      //   522: astore_1
      //   523: goto -279 -> 244
      //
      // Exception table:
      //   from	to	target	type
      //   149	156	217	java/lang/Throwable
      //   161	178	217	java/lang/Throwable
      //   184	217	217	java/lang/Throwable
      //   261	296	217	java/lang/Throwable
      //   312	333	217	java/lang/Throwable
      //   339	378	217	java/lang/Throwable
      //   218	220	220	finally
      //   136	147	239	java/lang/Throwable
      //   236	239	239	java/lang/Throwable
      //   436	444	239	java/lang/Throwable
      //   444	449	239	java/lang/Throwable
      //   454	460	239	java/lang/Throwable
      //   463	468	239	java/lang/Throwable
      //   240	242	242	finally
      //   149	156	381	finally
      //   161	178	381	finally
      //   184	217	381	finally
      //   261	296	381	finally
      //   312	333	381	finally
      //   339	378	381	finally
      //   418	423	426	java/lang/Throwable
      //   404	409	435	java/lang/Throwable
      //   231	236	452	java/lang/Throwable
      //   253	258	479	java/lang/Throwable
      //   136	147	519	finally
      //   231	236	519	finally
      //   236	239	519	finally
      //   404	409	519	finally
      //   436	444	519	finally
      //   444	449	519	finally
      //   454	460	519	finally
      //   463	468	519	finally
    }

    protected UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException
    {
      return new UnpackingSoSource.DsoManifest(this.mDsos);
    }

    protected UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException
    {
      return new FileBackedInputDsoIterator(null);
    }

    private final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator
    {
      private int mCurrentDso;

      private FileBackedInputDsoIterator()
      {
      }

      public boolean hasNext()
      {
        return this.mCurrentDso < ExoSoSource.ExoUnpacker.this.mDsos.length;
      }

      public UnpackingSoSource.InputDso next()
        throws IOException
      {
        Object localObject1 = ExoSoSource.ExoUnpacker.this.mDsos;
        int i = this.mCurrentDso;
        this.mCurrentDso = (i + 1);
        Object localObject2 = localObject1[i];
        localObject1 = new FileInputStream(((ExoSoSource.FileDso)localObject2).backingFile);
        try
        {
          localObject2 = new UnpackingSoSource.InputDso((UnpackingSoSource.Dso)localObject2, (InputStream)localObject1);
          if (0 != 0)
            throw new NullPointerException();
          return localObject2;
        }
        finally
        {
          if (localObject1 != null)
            ((FileInputStream)localObject1).close();
        }
        throw localObject3;
      }
    }
  }

  private static final class FileDso extends UnpackingSoSource.Dso
  {
    final File backingFile;

    FileDso(String paramString1, String paramString2, File paramFile)
    {
      super(paramString2);
      this.backingFile = paramFile;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.soloader.ExoSoSource
 * JD-Core Version:    0.6.0
 */