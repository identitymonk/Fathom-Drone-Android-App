package okhttp3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.List<Lokhttp3.Cookie;>;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Cookie
{
  private static final Pattern DAY_OF_MONTH_PATTERN;
  private static final Pattern MONTH_PATTERN;
  private static final Pattern TIME_PATTERN;
  private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
  private final String domain;
  private final long expiresAt;
  private final boolean hostOnly;
  private final boolean httpOnly;
  private final String name;
  private final String path;
  private final boolean persistent;
  private final boolean secure;
  private final String value;

  static
  {
    MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  }

  private Cookie(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.name = paramString1;
    this.value = paramString2;
    this.expiresAt = paramLong;
    this.domain = paramString3;
    this.path = paramString4;
    this.secure = paramBoolean1;
    this.httpOnly = paramBoolean2;
    this.hostOnly = paramBoolean3;
    this.persistent = paramBoolean4;
  }

  Cookie(Builder paramBuilder)
  {
    if (paramBuilder.name == null)
      throw new NullPointerException("builder.name == null");
    if (paramBuilder.value == null)
      throw new NullPointerException("builder.value == null");
    if (paramBuilder.domain == null)
      throw new NullPointerException("builder.domain == null");
    this.name = paramBuilder.name;
    this.value = paramBuilder.value;
    this.expiresAt = paramBuilder.expiresAt;
    this.domain = paramBuilder.domain;
    this.path = paramBuilder.path;
    this.secure = paramBuilder.secure;
    this.httpOnly = paramBuilder.httpOnly;
    this.persistent = paramBuilder.persistent;
    this.hostOnly = paramBuilder.hostOnly;
  }

  private static int dateCharacterOffset(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (paramInt1 < paramInt2)
    {
      int i = paramString.charAt(paramInt1);
      if (((i < 32) && (i != 9)) || (i >= 127) || ((i >= 48) && (i <= 57)) || ((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)) || (i == 58))
      {
        i = 1;
        if (paramBoolean)
          break label107;
      }
      label107: for (int j = 1; ; j = 0)
      {
        if (i != j)
          break label113;
        return paramInt1;
        i = 0;
        break;
      }
      label113: paramInt1 += 1;
    }
    return paramInt2;
  }

  private static boolean domainMatch(HttpUrl paramHttpUrl, String paramString)
  {
    paramHttpUrl = paramHttpUrl.host();
    if (paramHttpUrl.equals(paramString));
    do
      return true;
    while ((paramHttpUrl.endsWith(paramString)) && (paramHttpUrl.charAt(paramHttpUrl.length() - paramString.length() - 1) == '.') && (!Util.verifyAsIpAddress(paramHttpUrl)));
    return false;
  }

  // ERROR //
  static Cookie parse(long paramLong, HttpUrl paramHttpUrl, String paramString)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 120	java/lang/String:length	()I
    //   4: istore 5
    //   6: aload_3
    //   7: iconst_0
    //   8: iload 5
    //   10: bipush 59
    //   12: invokestatic 135	okhttp3/internal/Util:delimiterOffset	(Ljava/lang/String;IIC)I
    //   15: istore 4
    //   17: aload_3
    //   18: iconst_0
    //   19: iload 4
    //   21: bipush 61
    //   23: invokestatic 135	okhttp3/internal/Util:delimiterOffset	(Ljava/lang/String;IIC)I
    //   26: istore 6
    //   28: iload 6
    //   30: iload 4
    //   32: if_icmpne +5 -> 37
    //   35: aconst_null
    //   36: areturn
    //   37: aload_3
    //   38: iconst_0
    //   39: iload 6
    //   41: invokestatic 139	okhttp3/internal/Util:trimSubstring	(Ljava/lang/String;II)Ljava/lang/String;
    //   44: astore 27
    //   46: aload 27
    //   48: invokevirtual 143	java/lang/String:isEmpty	()Z
    //   51: ifne +12 -> 63
    //   54: aload 27
    //   56: invokestatic 147	okhttp3/internal/Util:indexOfControlOrNonAscii	(Ljava/lang/String;)I
    //   59: iconst_m1
    //   60: if_icmpeq +5 -> 65
    //   63: aconst_null
    //   64: areturn
    //   65: aload_3
    //   66: iload 6
    //   68: iconst_1
    //   69: iadd
    //   70: iload 4
    //   72: invokestatic 139	okhttp3/internal/Util:trimSubstring	(Ljava/lang/String;II)Ljava/lang/String;
    //   75: astore 28
    //   77: aload 28
    //   79: invokestatic 147	okhttp3/internal/Util:indexOfControlOrNonAscii	(Ljava/lang/String;)I
    //   82: iconst_m1
    //   83: if_icmpeq +5 -> 88
    //   86: aconst_null
    //   87: areturn
    //   88: ldc2_w 148
    //   91: lstore 8
    //   93: ldc2_w 150
    //   96: lstore 10
    //   98: aconst_null
    //   99: astore 24
    //   101: aconst_null
    //   102: astore 23
    //   104: iconst_0
    //   105: istore 19
    //   107: iconst_0
    //   108: istore 20
    //   110: iconst_1
    //   111: istore 17
    //   113: iconst_0
    //   114: istore 18
    //   116: iload 4
    //   118: iconst_1
    //   119: iadd
    //   120: istore 4
    //   122: iload 4
    //   124: iload 5
    //   126: if_icmpge +385 -> 511
    //   129: aload_3
    //   130: iload 4
    //   132: iload 5
    //   134: bipush 59
    //   136: invokestatic 135	okhttp3/internal/Util:delimiterOffset	(Ljava/lang/String;IIC)I
    //   139: istore 6
    //   141: aload_3
    //   142: iload 4
    //   144: iload 6
    //   146: bipush 61
    //   148: invokestatic 135	okhttp3/internal/Util:delimiterOffset	(Ljava/lang/String;IIC)I
    //   151: istore 7
    //   153: aload_3
    //   154: iload 4
    //   156: iload 7
    //   158: invokestatic 139	okhttp3/internal/Util:trimSubstring	(Ljava/lang/String;II)Ljava/lang/String;
    //   161: astore 29
    //   163: iload 7
    //   165: iload 6
    //   167: if_icmpge +98 -> 265
    //   170: aload_3
    //   171: iload 7
    //   173: iconst_1
    //   174: iadd
    //   175: iload 6
    //   177: invokestatic 139	okhttp3/internal/Util:trimSubstring	(Ljava/lang/String;II)Ljava/lang/String;
    //   180: astore 25
    //   182: aload 29
    //   184: ldc 153
    //   186: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   189: ifeq +83 -> 272
    //   192: aload 25
    //   194: iconst_0
    //   195: aload 25
    //   197: invokevirtual 120	java/lang/String:length	()I
    //   200: invokestatic 160	okhttp3/Cookie:parseExpires	(Ljava/lang/String;II)J
    //   203: lstore 12
    //   205: iconst_1
    //   206: istore 16
    //   208: lload 10
    //   210: lstore 14
    //   212: iload 17
    //   214: istore 22
    //   216: iload 19
    //   218: istore 21
    //   220: aload 23
    //   222: astore 26
    //   224: aload 24
    //   226: astore 25
    //   228: iload 6
    //   230: iconst_1
    //   231: iadd
    //   232: istore 4
    //   234: lload 12
    //   236: lstore 8
    //   238: aload 25
    //   240: astore 24
    //   242: aload 26
    //   244: astore 23
    //   246: iload 21
    //   248: istore 19
    //   250: iload 22
    //   252: istore 17
    //   254: iload 16
    //   256: istore 18
    //   258: lload 14
    //   260: lstore 10
    //   262: goto -140 -> 122
    //   265: ldc 162
    //   267: astore 25
    //   269: goto -87 -> 182
    //   272: aload 29
    //   274: ldc 164
    //   276: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   279: ifeq +36 -> 315
    //   282: aload 25
    //   284: invokestatic 168	okhttp3/Cookie:parseMaxAge	(Ljava/lang/String;)J
    //   287: lstore 14
    //   289: iconst_1
    //   290: istore 16
    //   292: lload 8
    //   294: lstore 12
    //   296: aload 24
    //   298: astore 25
    //   300: aload 23
    //   302: astore 26
    //   304: iload 19
    //   306: istore 21
    //   308: iload 17
    //   310: istore 22
    //   312: goto -84 -> 228
    //   315: aload 29
    //   317: ldc 169
    //   319: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   322: ifeq +36 -> 358
    //   325: aload 25
    //   327: invokestatic 173	okhttp3/Cookie:parseDomain	(Ljava/lang/String;)Ljava/lang/String;
    //   330: astore 25
    //   332: iconst_0
    //   333: istore 22
    //   335: lload 8
    //   337: lstore 12
    //   339: aload 23
    //   341: astore 26
    //   343: iload 19
    //   345: istore 21
    //   347: iload 18
    //   349: istore 16
    //   351: lload 10
    //   353: lstore 14
    //   355: goto -127 -> 228
    //   358: aload 29
    //   360: ldc 174
    //   362: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   365: ifeq +34 -> 399
    //   368: aload 25
    //   370: astore 26
    //   372: lload 8
    //   374: lstore 12
    //   376: aload 24
    //   378: astore 25
    //   380: iload 19
    //   382: istore 21
    //   384: iload 17
    //   386: istore 22
    //   388: iload 18
    //   390: istore 16
    //   392: lload 10
    //   394: lstore 14
    //   396: goto -168 -> 228
    //   399: aload 29
    //   401: ldc 175
    //   403: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   406: ifeq +33 -> 439
    //   409: iconst_1
    //   410: istore 21
    //   412: lload 8
    //   414: lstore 12
    //   416: aload 24
    //   418: astore 25
    //   420: aload 23
    //   422: astore 26
    //   424: iload 17
    //   426: istore 22
    //   428: iload 18
    //   430: istore 16
    //   432: lload 10
    //   434: lstore 14
    //   436: goto -208 -> 228
    //   439: lload 8
    //   441: lstore 12
    //   443: aload 24
    //   445: astore 25
    //   447: aload 23
    //   449: astore 26
    //   451: iload 19
    //   453: istore 21
    //   455: iload 17
    //   457: istore 22
    //   459: iload 18
    //   461: istore 16
    //   463: lload 10
    //   465: lstore 14
    //   467: aload 29
    //   469: ldc 177
    //   471: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   474: ifeq -246 -> 228
    //   477: iconst_1
    //   478: istore 20
    //   480: lload 8
    //   482: lstore 12
    //   484: aload 24
    //   486: astore 25
    //   488: aload 23
    //   490: astore 26
    //   492: iload 19
    //   494: istore 21
    //   496: iload 17
    //   498: istore 22
    //   500: iload 18
    //   502: istore 16
    //   504: lload 10
    //   506: lstore 14
    //   508: goto -280 -> 228
    //   511: lload 10
    //   513: ldc2_w 178
    //   516: lcmp
    //   517: ifne +88 -> 605
    //   520: ldc2_w 178
    //   523: lstore 8
    //   525: aload 24
    //   527: ifnonnull +146 -> 673
    //   530: aload_2
    //   531: invokevirtual 108	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   534: astore 25
    //   536: aload 23
    //   538: ifnull +16 -> 554
    //   541: aload 23
    //   543: astore_3
    //   544: aload 23
    //   546: ldc 181
    //   548: invokevirtual 184	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   551: ifne +29 -> 580
    //   554: aload_2
    //   555: invokevirtual 187	okhttp3/HttpUrl:encodedPath	()Ljava/lang/String;
    //   558: astore_2
    //   559: aload_2
    //   560: bipush 47
    //   562: invokevirtual 191	java/lang/String:lastIndexOf	(I)I
    //   565: istore 4
    //   567: iload 4
    //   569: ifeq +119 -> 688
    //   572: aload_2
    //   573: iconst_0
    //   574: iload 4
    //   576: invokevirtual 195	java/lang/String:substring	(II)Ljava/lang/String;
    //   579: astore_3
    //   580: new 2	okhttp3/Cookie
    //   583: dup
    //   584: aload 27
    //   586: aload 28
    //   588: lload 8
    //   590: aload 25
    //   592: aload_3
    //   593: iload 19
    //   595: iload 20
    //   597: iload 17
    //   599: iload 18
    //   601: invokespecial 197	okhttp3/Cookie:<init>	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V
    //   604: areturn
    //   605: lload 10
    //   607: ldc2_w 150
    //   610: lcmp
    //   611: ifeq -86 -> 525
    //   614: lload 10
    //   616: ldc2_w 198
    //   619: lcmp
    //   620: ifgt +45 -> 665
    //   623: lload 10
    //   625: ldc2_w 200
    //   628: lmul
    //   629: lstore 8
    //   631: lload_0
    //   632: lload 8
    //   634: ladd
    //   635: lstore 10
    //   637: lload 10
    //   639: lload_0
    //   640: lcmp
    //   641: iflt +16 -> 657
    //   644: lload 10
    //   646: lstore 8
    //   648: lload 10
    //   650: ldc2_w 148
    //   653: lcmp
    //   654: ifle -129 -> 525
    //   657: ldc2_w 148
    //   660: lstore 8
    //   662: goto -137 -> 525
    //   665: ldc2_w 202
    //   668: lstore 8
    //   670: goto -39 -> 631
    //   673: aload 24
    //   675: astore 25
    //   677: aload_2
    //   678: aload 24
    //   680: invokestatic 205	okhttp3/Cookie:domainMatch	(Lokhttp3/HttpUrl;Ljava/lang/String;)Z
    //   683: ifne -147 -> 536
    //   686: aconst_null
    //   687: areturn
    //   688: ldc 181
    //   690: astore_3
    //   691: goto -111 -> 580
    //   694: astore 25
    //   696: lload 8
    //   698: lstore 12
    //   700: aload 24
    //   702: astore 25
    //   704: aload 23
    //   706: astore 26
    //   708: iload 19
    //   710: istore 21
    //   712: iload 17
    //   714: istore 22
    //   716: iload 18
    //   718: istore 16
    //   720: lload 10
    //   722: lstore 14
    //   724: goto -496 -> 228
    //   727: astore 25
    //   729: lload 8
    //   731: lstore 12
    //   733: aload 24
    //   735: astore 25
    //   737: aload 23
    //   739: astore 26
    //   741: iload 19
    //   743: istore 21
    //   745: iload 17
    //   747: istore 22
    //   749: iload 18
    //   751: istore 16
    //   753: lload 10
    //   755: lstore 14
    //   757: goto -529 -> 228
    //   760: astore 25
    //   762: lload 8
    //   764: lstore 12
    //   766: aload 24
    //   768: astore 25
    //   770: aload 23
    //   772: astore 26
    //   774: iload 19
    //   776: istore 21
    //   778: iload 17
    //   780: istore 22
    //   782: iload 18
    //   784: istore 16
    //   786: lload 10
    //   788: lstore 14
    //   790: goto -562 -> 228
    //
    // Exception table:
    //   from	to	target	type
    //   282	289	694	java/lang/NumberFormatException
    //   325	332	727	java/lang/IllegalArgumentException
    //   192	205	760	java/lang/IllegalArgumentException
  }

  public static Cookie parse(HttpUrl paramHttpUrl, String paramString)
  {
    return parse(System.currentTimeMillis(), paramHttpUrl, paramString);
  }

  public static List<Cookie> parseAll(HttpUrl paramHttpUrl, Headers paramHeaders)
  {
    List localList = paramHeaders.values("Set-Cookie");
    paramHeaders = null;
    int i = 0;
    int j = localList.size();
    if (i < j)
    {
      Cookie localCookie = parse(paramHttpUrl, (String)localList.get(i));
      if (localCookie == null);
      while (true)
      {
        i += 1;
        break;
        Object localObject = paramHeaders;
        if (paramHeaders == null)
          localObject = new ArrayList();
        ((List)localObject).add(localCookie);
        paramHeaders = (Headers)localObject;
      }
    }
    if (paramHeaders != null)
      return Collections.unmodifiableList(paramHeaders);
    return (List<Cookie>)Collections.emptyList();
  }

  private static String parseDomain(String paramString)
  {
    if (paramString.endsWith("."))
      throw new IllegalArgumentException();
    String str = paramString;
    if (paramString.startsWith("."))
      str = paramString.substring(1);
    paramString = Util.domainToAscii(str);
    if (paramString == null)
      throw new IllegalArgumentException();
    return paramString;
  }

  private static long parseExpires(String paramString, int paramInt1, int paramInt2)
  {
    int i1 = dateCharacterOffset(paramString, paramInt1, paramInt2, false);
    int n = -1;
    int m = -1;
    int j = -1;
    int k = -1;
    int i = -1;
    paramInt1 = -1;
    Matcher localMatcher = TIME_PATTERN.matcher(paramString);
    if (i1 < paramInt2)
    {
      int i7 = dateCharacterOffset(paramString, i1 + 1, paramInt2, true);
      localMatcher.region(i1, i7);
      int i6;
      int i3;
      int i4;
      int i2;
      int i5;
      if ((n == -1) && (localMatcher.usePattern(TIME_PATTERN).matches()))
      {
        i6 = Integer.parseInt(localMatcher.group(1));
        i1 = Integer.parseInt(localMatcher.group(2));
        i3 = Integer.parseInt(localMatcher.group(3));
        i4 = paramInt1;
        i2 = i;
        i5 = k;
      }
      while (true)
      {
        i7 = dateCharacterOffset(paramString, i7 + 1, paramInt2, false);
        k = i5;
        n = i6;
        m = i1;
        i = i2;
        j = i3;
        paramInt1 = i4;
        i1 = i7;
        break;
        if ((k == -1) && (localMatcher.usePattern(DAY_OF_MONTH_PATTERN).matches()))
        {
          i5 = Integer.parseInt(localMatcher.group(1));
          i6 = n;
          i1 = m;
          i2 = i;
          i3 = j;
          i4 = paramInt1;
          continue;
        }
        if ((i == -1) && (localMatcher.usePattern(MONTH_PATTERN).matches()))
        {
          String str = localMatcher.group(1).toLowerCase(Locale.US);
          i2 = MONTH_PATTERN.pattern().indexOf(str) / 4;
          i5 = k;
          i6 = n;
          i1 = m;
          i3 = j;
          i4 = paramInt1;
          continue;
        }
        i5 = k;
        i6 = n;
        i1 = m;
        i2 = i;
        i3 = j;
        i4 = paramInt1;
        if (paramInt1 != -1)
          continue;
        i5 = k;
        i6 = n;
        i1 = m;
        i2 = i;
        i3 = j;
        i4 = paramInt1;
        if (!localMatcher.usePattern(YEAR_PATTERN).matches())
          continue;
        i4 = Integer.parseInt(localMatcher.group(1));
        i5 = k;
        i6 = n;
        i1 = m;
        i2 = i;
        i3 = j;
      }
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= 70)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 99)
        paramInt2 = paramInt1 + 1900;
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 69)
        paramInt1 = paramInt2 + 2000;
    }
    if (paramInt1 < 1601)
      throw new IllegalArgumentException();
    if (i == -1)
      throw new IllegalArgumentException();
    if ((k < 1) || (k > 31))
      throw new IllegalArgumentException();
    if ((n < 0) || (n > 23))
      throw new IllegalArgumentException();
    if ((m < 0) || (m > 59))
      throw new IllegalArgumentException();
    if ((j < 0) || (j > 59))
      throw new IllegalArgumentException();
    paramString = new GregorianCalendar(Util.UTC);
    paramString.setLenient(false);
    paramString.set(1, paramInt1);
    paramString.set(2, i - 1);
    paramString.set(5, k);
    paramString.set(11, n);
    paramString.set(12, m);
    paramString.set(13, j);
    paramString.set(14, 0);
    return paramString.getTimeInMillis();
  }

  private static long parseMaxAge(String paramString)
  {
    long l1 = -9223372036854775808L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
      l2 = l1;
      if (l1 <= 0L)
        l2 = -9223372036854775808L;
      return l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramString.matches("-?\\d+"))
      {
        if (paramString.startsWith("-"));
        while (true)
        {
          return l1;
          l1 = 9223372036854775807L;
        }
      }
    }
    throw localNumberFormatException;
  }

  private static boolean pathMatch(HttpUrl paramHttpUrl, String paramString)
  {
    paramHttpUrl = paramHttpUrl.encodedPath();
    if (paramHttpUrl.equals(paramString));
    do
      return true;
    while ((paramHttpUrl.startsWith(paramString)) && ((paramString.endsWith("/")) || (paramHttpUrl.charAt(paramString.length()) == '/')));
    return false;
  }

  public String domain()
  {
    return this.domain;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Cookie));
    do
    {
      return false;
      paramObject = (Cookie)paramObject;
    }
    while ((!paramObject.name.equals(this.name)) || (!paramObject.value.equals(this.value)) || (!paramObject.domain.equals(this.domain)) || (!paramObject.path.equals(this.path)) || (paramObject.expiresAt != this.expiresAt) || (paramObject.secure != this.secure) || (paramObject.httpOnly != this.httpOnly) || (paramObject.persistent != this.persistent) || (paramObject.hostOnly != this.hostOnly));
    return true;
  }

  public long expiresAt()
  {
    return this.expiresAt;
  }

  public int hashCode()
  {
    int m = 0;
    int n = this.name.hashCode();
    int i1 = this.value.hashCode();
    int i2 = this.domain.hashCode();
    int i3 = this.path.hashCode();
    int i4 = (int)(this.expiresAt ^ this.expiresAt >>> 32);
    int i;
    int j;
    label72: int k;
    if (this.secure)
    {
      i = 0;
      if (!this.httpOnly)
        break label145;
      j = 0;
      if (!this.persistent)
        break label150;
      k = 0;
      label81: if (!this.hostOnly)
        break label155;
    }
    while (true)
    {
      return ((((((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i) * 31 + j) * 31 + k) * 31 + m;
      i = 1;
      break;
      label145: j = 1;
      break label72;
      label150: k = 1;
      break label81;
      label155: m = 1;
    }
  }

  public boolean hostOnly()
  {
    return this.hostOnly;
  }

  public boolean httpOnly()
  {
    return this.httpOnly;
  }

  public boolean matches(HttpUrl paramHttpUrl)
  {
    boolean bool;
    if (this.hostOnly)
    {
      bool = paramHttpUrl.host().equals(this.domain);
      if (bool)
        break label37;
    }
    label37: 
    do
    {
      return false;
      bool = domainMatch(paramHttpUrl, this.domain);
      break;
    }
    while ((!pathMatch(paramHttpUrl, this.path)) || ((this.secure) && (!paramHttpUrl.isHttps())));
    return true;
  }

  public String name()
  {
    return this.name;
  }

  public String path()
  {
    return this.path;
  }

  public boolean persistent()
  {
    return this.persistent;
  }

  public boolean secure()
  {
    return this.secure;
  }

  public String toString()
  {
    return toString(false);
  }

  String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append('=');
    localStringBuilder.append(this.value);
    if (this.persistent)
    {
      if (this.expiresAt != -9223372036854775808L)
        break label144;
      localStringBuilder.append("; max-age=0");
    }
    while (true)
    {
      if (!this.hostOnly)
      {
        localStringBuilder.append("; domain=");
        if (paramBoolean)
          localStringBuilder.append(".");
        localStringBuilder.append(this.domain);
      }
      localStringBuilder.append("; path=").append(this.path);
      if (this.secure)
        localStringBuilder.append("; secure");
      if (this.httpOnly)
        localStringBuilder.append("; httponly");
      return localStringBuilder.toString();
      label144: localStringBuilder.append("; expires=").append(HttpDate.format(new Date(this.expiresAt)));
    }
  }

  public String value()
  {
    return this.value;
  }

  public static final class Builder
  {
    String domain;
    long expiresAt = 253402300799999L;
    boolean hostOnly;
    boolean httpOnly;
    String name;
    String path = "/";
    boolean persistent;
    boolean secure;
    String value;

    private Builder domain(String paramString, boolean paramBoolean)
    {
      if (paramString == null)
        throw new NullPointerException("domain == null");
      String str = Util.domainToAscii(paramString);
      if (str == null)
        throw new IllegalArgumentException("unexpected domain: " + paramString);
      this.domain = str;
      this.hostOnly = paramBoolean;
      return this;
    }

    public Cookie build()
    {
      return new Cookie(this);
    }

    public Builder domain(String paramString)
    {
      return domain(paramString, false);
    }

    public Builder expiresAt(long paramLong)
    {
      long l = paramLong;
      if (paramLong <= 0L)
        l = -9223372036854775808L;
      paramLong = l;
      if (l > 253402300799999L)
        paramLong = 253402300799999L;
      this.expiresAt = paramLong;
      this.persistent = true;
      return this;
    }

    public Builder hostOnlyDomain(String paramString)
    {
      return domain(paramString, true);
    }

    public Builder httpOnly()
    {
      this.httpOnly = true;
      return this;
    }

    public Builder name(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("name == null");
      if (!paramString.trim().equals(paramString))
        throw new IllegalArgumentException("name is not trimmed");
      this.name = paramString;
      return this;
    }

    public Builder path(String paramString)
    {
      if (!paramString.startsWith("/"))
        throw new IllegalArgumentException("path must start with '/'");
      this.path = paramString;
      return this;
    }

    public Builder secure()
    {
      this.secure = true;
      return this;
    }

    public Builder value(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("value == null");
      if (!paramString.trim().equals(paramString))
        throw new IllegalArgumentException("value is not trimmed");
      this.value = paramString;
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Cookie
 * JD-Core Version:    0.6.0
 */