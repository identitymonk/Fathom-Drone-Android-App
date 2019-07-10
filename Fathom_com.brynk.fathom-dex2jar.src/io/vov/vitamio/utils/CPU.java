package io.vov.vitamio.utils;

import android.os.Build;
import java.util.HashMap;
import java.util.Map;

public class CPU
{
  public static final int FEATURE_ARM_NEON = 32;
  public static final int FEATURE_ARM_V5TE = 1;
  public static final int FEATURE_ARM_V6 = 2;
  public static final int FEATURE_ARM_V7A = 8;
  public static final int FEATURE_ARM_VFP = 4;
  public static final int FEATURE_ARM_VFPV3 = 16;
  public static final int FEATURE_MIPS = 128;
  public static final int FEATURE_X86 = 64;
  private static int cachedFeature;
  private static String cachedFeatureString;
  private static final Map<String, String> cpuinfo = new HashMap();

  static
  {
    cachedFeature = -1;
    cachedFeatureString = null;
  }

  private static int getCachedFeature()
  {
    if (cachedFeatureString == null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if ((cachedFeature & 0x1) > 0)
        localStringBuffer.append("V5TE ");
      if ((cachedFeature & 0x2) > 0)
        localStringBuffer.append("V6 ");
      if ((cachedFeature & 0x4) > 0)
        localStringBuffer.append("VFP ");
      if ((cachedFeature & 0x8) > 0)
        localStringBuffer.append("V7A ");
      if ((cachedFeature & 0x10) > 0)
        localStringBuffer.append("VFPV3 ");
      if ((cachedFeature & 0x20) > 0)
        localStringBuffer.append("NEON ");
      if ((cachedFeature & 0x40) > 0)
        localStringBuffer.append("X86 ");
      if ((cachedFeature & 0x80) > 0)
        localStringBuffer.append("MIPS ");
      cachedFeatureString = localStringBuffer.toString();
    }
    Log.d("GET CPU FATURE: %s", new Object[] { cachedFeatureString });
    return cachedFeature;
  }

  // ERROR //
  public static int getFeature()
  {
    // Byte code:
    //   0: getstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   3: ifle +7 -> 10
    //   6: invokestatic 88	io/vov/vitamio/utils/CPU:getCachedFeature	()I
    //   9: ireturn
    //   10: iconst_1
    //   11: putstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   14: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   17: invokeinterface 94 1 0
    //   22: ifeq +124 -> 146
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore 6
    //   31: new 96	java/io/BufferedReader
    //   34: dup
    //   35: new 98	java/io/FileReader
    //   38: dup
    //   39: new 100	java/io/File
    //   42: dup
    //   43: ldc 102
    //   45: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: invokespecial 108	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   51: invokespecial 111	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore 5
    //   56: aload 5
    //   58: invokevirtual 114	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +159 -> 224
    //   68: aload 4
    //   70: invokevirtual 119	java/lang/String:trim	()Ljava/lang/String;
    //   73: ldc 121
    //   75: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifne -22 -> 56
    //   81: aload 4
    //   83: ldc 127
    //   85: invokevirtual 131	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   88: astore 4
    //   90: aload 4
    //   92: arraylength
    //   93: iconst_1
    //   94: if_icmple -38 -> 56
    //   97: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   100: aload 4
    //   102: iconst_0
    //   103: aaload
    //   104: invokevirtual 119	java/lang/String:trim	()Ljava/lang/String;
    //   107: aload 4
    //   109: iconst_1
    //   110: aaload
    //   111: invokevirtual 119	java/lang/String:trim	()Ljava/lang/String;
    //   114: invokeinterface 135 3 0
    //   119: pop
    //   120: goto -64 -> 56
    //   123: astore 6
    //   125: aload 5
    //   127: astore 4
    //   129: ldc 137
    //   131: aload 6
    //   133: invokestatic 141	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload 5
    //   138: ifnull +8 -> 146
    //   141: aload 5
    //   143: invokevirtual 144	java/io/BufferedReader:close	()V
    //   146: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   149: invokeinterface 94 1 0
    //   154: ifne +373 -> 527
    //   157: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   160: invokeinterface 148 1 0
    //   165: invokeinterface 154 1 0
    //   170: astore 4
    //   172: aload 4
    //   174: invokeinterface 159 1 0
    //   179: ifeq +109 -> 288
    //   182: aload 4
    //   184: invokeinterface 163 1 0
    //   189: checkcast 116	java/lang/String
    //   192: astore 5
    //   194: ldc 165
    //   196: iconst_2
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload 5
    //   204: aastore
    //   205: dup
    //   206: iconst_1
    //   207: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   210: aload 5
    //   212: invokeinterface 169 2 0
    //   217: aastore
    //   218: invokestatic 79	io/vov/vitamio/utils/Log:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: goto -49 -> 172
    //   224: aload 5
    //   226: ifnull -80 -> 146
    //   229: aload 5
    //   231: invokevirtual 144	java/io/BufferedReader:close	()V
    //   234: goto -88 -> 146
    //   237: astore 4
    //   239: ldc 137
    //   241: aload 4
    //   243: invokestatic 141	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: goto -100 -> 146
    //   249: astore 4
    //   251: ldc 137
    //   253: aload 4
    //   255: invokestatic 141	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: goto -112 -> 146
    //   261: astore 5
    //   263: aload 4
    //   265: ifnull +8 -> 273
    //   268: aload 4
    //   270: invokevirtual 144	java/io/BufferedReader:close	()V
    //   273: aload 5
    //   275: athrow
    //   276: astore 4
    //   278: ldc 137
    //   280: aload 4
    //   282: invokestatic 141	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   285: goto -12 -> 273
    //   288: iconst_0
    //   289: istore_0
    //   290: iconst_0
    //   291: istore_1
    //   292: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   295: ldc 171
    //   297: invokeinterface 169 2 0
    //   302: checkcast 116	java/lang/String
    //   305: astore 4
    //   307: aload 4
    //   309: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   312: ifne +287 -> 599
    //   315: aload 4
    //   317: invokestatic 182	io/vov/vitamio/utils/StringUtils:convertToInt	(Ljava/lang/String;)I
    //   320: istore_2
    //   321: ldc 184
    //   323: iconst_1
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: iload_2
    //   330: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: invokestatic 79	io/vov/vitamio/utils/Log:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: iload_2
    //   338: bipush 7
    //   340: if_icmplt +191 -> 531
    //   343: iconst_1
    //   344: istore_0
    //   345: iconst_1
    //   346: istore_1
    //   347: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   350: ldc 192
    //   352: invokeinterface 169 2 0
    //   357: checkcast 116	java/lang/String
    //   360: astore 5
    //   362: aload 5
    //   364: astore 4
    //   366: aload 5
    //   368: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifeq +18 -> 389
    //   374: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   377: ldc 194
    //   379: invokeinterface 169 2 0
    //   384: checkcast 116	java/lang/String
    //   387: astore 4
    //   389: iload_0
    //   390: istore_3
    //   391: iload_1
    //   392: istore_2
    //   393: aload 4
    //   395: ifnull +31 -> 426
    //   398: aload 4
    //   400: ldc 196
    //   402: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   405: ifne +17 -> 422
    //   408: iload_0
    //   409: istore_3
    //   410: iload_1
    //   411: istore_2
    //   412: aload 4
    //   414: ldc 201
    //   416: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   419: ifeq +7 -> 426
    //   422: iconst_1
    //   423: istore_3
    //   424: iconst_1
    //   425: istore_2
    //   426: iload_3
    //   427: istore_1
    //   428: iload_2
    //   429: istore_0
    //   430: aload 4
    //   432: ifnull +31 -> 463
    //   435: aload 4
    //   437: ldc 203
    //   439: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   442: ifne +17 -> 459
    //   445: iload_3
    //   446: istore_1
    //   447: iload_2
    //   448: istore_0
    //   449: aload 4
    //   451: ldc 205
    //   453: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   456: ifeq +7 -> 463
    //   459: iconst_1
    //   460: istore_1
    //   461: iconst_0
    //   462: istore_0
    //   463: iload_1
    //   464: ifeq +11 -> 475
    //   467: getstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   470: iconst_2
    //   471: ior
    //   472: putstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   475: iload_0
    //   476: ifeq +12 -> 488
    //   479: getstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   482: bipush 8
    //   484: ior
    //   485: putstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   488: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   491: ldc 207
    //   493: invokeinterface 169 2 0
    //   498: checkcast 116	java/lang/String
    //   501: astore 4
    //   503: aload 4
    //   505: ifnull +22 -> 527
    //   508: aload 4
    //   510: ldc 209
    //   512: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   515: ifeq +41 -> 556
    //   518: getstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   521: bipush 52
    //   523: ior
    //   524: putstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   527: invokestatic 88	io/vov/vitamio/utils/CPU:getCachedFeature	()I
    //   530: ireturn
    //   531: iload_2
    //   532: bipush 6
    //   534: if_icmplt -187 -> 347
    //   537: iconst_1
    //   538: istore_0
    //   539: iconst_0
    //   540: istore_1
    //   541: goto -194 -> 347
    //   544: astore 4
    //   546: ldc 137
    //   548: aload 4
    //   550: invokestatic 141	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   553: goto -206 -> 347
    //   556: aload 4
    //   558: ldc 211
    //   560: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   563: ifeq +15 -> 578
    //   566: getstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   569: bipush 20
    //   571: ior
    //   572: putstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   575: goto -48 -> 527
    //   578: aload 4
    //   580: ldc 213
    //   582: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   585: ifeq -58 -> 527
    //   588: getstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   591: iconst_4
    //   592: ior
    //   593: putstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   596: goto -69 -> 527
    //   599: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   602: ldc 215
    //   604: invokeinterface 169 2 0
    //   609: checkcast 116	java/lang/String
    //   612: astore 4
    //   614: getstatic 36	io/vov/vitamio/utils/CPU:cpuinfo	Ljava/util/Map;
    //   617: ldc 217
    //   619: invokeinterface 169 2 0
    //   624: checkcast 116	java/lang/String
    //   627: astore 5
    //   629: aload 4
    //   631: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   634: ifne +25 -> 659
    //   637: aload 4
    //   639: ldc 219
    //   641: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   644: ifeq +15 -> 659
    //   647: getstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   650: bipush 64
    //   652: ior
    //   653: putstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   656: goto -129 -> 527
    //   659: aload 5
    //   661: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   664: ifne -137 -> 527
    //   667: aload 5
    //   669: ldc 221
    //   671: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   674: ifeq -147 -> 527
    //   677: getstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   680: sipush 128
    //   683: ior
    //   684: putstatic 38	io/vov/vitamio/utils/CPU:cachedFeature	I
    //   687: goto -160 -> 527
    //   690: astore 6
    //   692: aload 5
    //   694: astore 4
    //   696: aload 6
    //   698: astore 5
    //   700: goto -437 -> 263
    //   703: astore 4
    //   705: aload 6
    //   707: astore 5
    //   709: aload 4
    //   711: astore 6
    //   713: goto -588 -> 125
    //
    // Exception table:
    //   from	to	target	type
    //   56	63	123	java/lang/Exception
    //   68	120	123	java/lang/Exception
    //   229	234	237	java/io/IOException
    //   141	146	249	java/io/IOException
    //   31	56	261	finally
    //   129	136	261	finally
    //   268	273	276	java/io/IOException
    //   315	337	544	java/lang/NumberFormatException
    //   56	63	690	finally
    //   68	120	690	finally
    //   31	56	703	java/lang/Exception
  }

  public static String getFeatureString()
  {
    getFeature();
    return cachedFeatureString;
  }

  public static boolean isDroidXDroid2()
  {
    return (Build.MODEL.trim().equalsIgnoreCase("DROIDX")) || (Build.MODEL.trim().equalsIgnoreCase("DROID2")) || (Build.FINGERPRINT.toLowerCase().contains("shadow")) || (Build.FINGERPRINT.toLowerCase().contains("droid2"));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.utils.CPU
 * JD-Core Version:    0.6.0
 */