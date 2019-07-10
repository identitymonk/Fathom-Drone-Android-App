package com.brynk.fathom.api;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import com.brynk.fathom.helpers.Constants;

public class TemperatureTask extends AsyncTask<String, Void, String>
{
  private String DRONE_IP;
  private Context mContext;
  private View rootView;
  private String temperature_cutoff;

  public TemperatureTask(Context paramContext, View paramView, String paramString)
  {
    this.mContext = paramContext;
    this.rootView = paramView;
    this.DRONE_IP = paramString;
    this.temperature_cutoff = new Constants().getTemperatureCutoff(this.mContext);
  }

  // ERROR //
  protected String doInBackground(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 46	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: new 49	java/net/URL
    //   11: dup
    //   12: new 46	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   19: ldc 51
    //   21: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 23	com/brynk/fathom/api/TemperatureTask:DRONE_IP	Ljava/lang/String;
    //   28: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 57
    //   33: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 32	com/brynk/fathom/api/TemperatureTask:temperature_cutoff	Ljava/lang/String;
    //   40: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 64	java/net/URL:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_2
    //   53: invokevirtual 68	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   56: checkcast 70	java/net/HttpURLConnection
    //   59: astore_2
    //   60: aload_2
    //   61: astore_1
    //   62: new 72	java/io/BufferedReader
    //   65: dup
    //   66: new 74	java/io/InputStreamReader
    //   69: dup
    //   70: new 76	java/io/BufferedInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokevirtual 80	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   78: invokespecial 83	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: invokespecial 84	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   84: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 90	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +83 -> 179
    //   99: aload_3
    //   100: aload 4
    //   102: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: goto -18 -> 88
    //   109: astore_2
    //   110: ldc 92
    //   112: ldc 94
    //   114: invokestatic 100	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   117: pop
    //   118: aload_2
    //   119: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   122: aload_1
    //   123: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   126: aload_3
    //   127: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: astore_1
    //   131: new 46	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   138: ldc 108
    //   140: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: areturn
    //   151: astore_1
    //   152: ldc 92
    //   154: ldc 110
    //   156: invokestatic 100	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   159: pop
    //   160: ldc 108
    //   162: areturn
    //   163: astore_2
    //   164: ldc 92
    //   166: ldc 112
    //   168: invokestatic 100	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: aload_2
    //   173: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   176: goto -114 -> 62
    //   179: aload_1
    //   180: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   183: goto -57 -> 126
    //   186: astore_2
    //   187: aload_1
    //   188: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   191: aload_2
    //   192: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   62	88	109	java/io/IOException
    //   88	94	109	java/io/IOException
    //   99	106	109	java/io/IOException
    //   8	50	151	java/net/MalformedURLException
    //   52	60	163	java/io/IOException
    //   62	88	186	finally
    //   88	94	186	finally
    //   99	106	186	finally
    //   110	122	186	finally
  }

  // ERROR //
  protected void onPostExecute(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/brynk/fathom/api/TemperatureTask:rootView	Landroid/view/View;
    //   4: ldc 123
    //   6: invokevirtual 129	android/view/View:findViewById	(I)Landroid/view/View;
    //   9: checkcast 131	android/widget/TextView
    //   12: astore 8
    //   14: aload_0
    //   15: getfield 21	com/brynk/fathom/api/TemperatureTask:rootView	Landroid/view/View;
    //   18: ldc 132
    //   20: invokevirtual 129	android/view/View:findViewById	(I)Landroid/view/View;
    //   23: checkcast 131	android/widget/TextView
    //   26: astore 9
    //   28: aload_1
    //   29: ldc 134
    //   31: invokevirtual 138	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   34: astore 10
    //   36: dconst_0
    //   37: invokestatic 144	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   40: astore 5
    //   42: dconst_0
    //   43: invokestatic 144	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   46: astore 7
    //   48: aload 5
    //   50: astore_1
    //   51: aload 10
    //   53: iconst_0
    //   54: aaload
    //   55: invokestatic 148	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   58: invokestatic 144	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   61: astore 6
    //   63: aload 6
    //   65: astore_1
    //   66: aload 6
    //   68: astore 5
    //   70: aload 10
    //   72: iconst_1
    //   73: aaload
    //   74: invokestatic 148	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   77: dstore_2
    //   78: dload_2
    //   79: invokestatic 144	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   82: astore 5
    //   84: aload 6
    //   86: astore_1
    //   87: aload 5
    //   89: astore 6
    //   91: new 150	java/text/DecimalFormat
    //   94: dup
    //   95: ldc 152
    //   97: invokespecial 153	java/text/DecimalFormat:<init>	(Ljava/lang/String;)V
    //   100: astore 5
    //   102: aload 8
    //   104: new 46	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   111: aload 5
    //   113: aload_1
    //   114: invokevirtual 157	java/text/DecimalFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   117: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 159
    //   122: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 163	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   131: aload 9
    //   133: new 46	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   140: aload 5
    //   142: aload 6
    //   144: invokevirtual 157	java/text/DecimalFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   147: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 159
    //   152: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 163	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   161: aload_0
    //   162: getfield 32	com/brynk/fathom/api/TemperatureTask:temperature_cutoff	Ljava/lang/String;
    //   165: invokestatic 169	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   168: istore 4
    //   170: aload_1
    //   171: invokevirtual 173	java/lang/Double:doubleValue	()D
    //   174: ldc2_w 174
    //   177: dcmpl
    //   178: ifgt +17 -> 195
    //   181: aload 6
    //   183: invokevirtual 173	java/lang/Double:doubleValue	()D
    //   186: iload 4
    //   188: iconst_5
    //   189: isub
    //   190: i2d
    //   191: dcmpl
    //   192: ifle +86 -> 278
    //   195: aload 8
    //   197: iconst_0
    //   198: invokevirtual 179	android/widget/TextView:setVisibility	(I)V
    //   201: aload 9
    //   203: iconst_0
    //   204: invokevirtual 179	android/widget/TextView:setVisibility	(I)V
    //   207: aload 6
    //   209: invokevirtual 173	java/lang/Double:doubleValue	()D
    //   212: iload 4
    //   214: iconst_2
    //   215: isub
    //   216: i2d
    //   217: dcmpl
    //   218: ifle +19 -> 237
    //   221: aload_0
    //   222: getfield 21	com/brynk/fathom/api/TemperatureTask:rootView	Landroid/view/View;
    //   225: invokevirtual 183	android/view/View:getContext	()Landroid/content/Context;
    //   228: ldc 185
    //   230: iconst_1
    //   231: invokestatic 191	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   234: invokevirtual 194	android/widget/Toast:show	()V
    //   237: return
    //   238: astore 5
    //   240: ldc 92
    //   242: ldc 196
    //   244: invokestatic 100	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   247: pop
    //   248: aload 7
    //   250: astore 6
    //   252: goto -161 -> 91
    //   255: astore_1
    //   256: ldc 92
    //   258: ldc 196
    //   260: invokestatic 100	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   263: pop
    //   264: aload_1
    //   265: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   268: aload 7
    //   270: astore 6
    //   272: aload 5
    //   274: astore_1
    //   275: goto -184 -> 91
    //   278: aload 8
    //   280: iconst_4
    //   281: invokevirtual 179	android/widget/TextView:setVisibility	(I)V
    //   284: aload 9
    //   286: iconst_4
    //   287: invokevirtual 179	android/widget/TextView:setVisibility	(I)V
    //   290: return
    //   291: astore_1
    //   292: ldc 92
    //   294: ldc 199
    //   296: invokestatic 100	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   299: pop
    //   300: return
    //
    // Exception table:
    //   from	to	target	type
    //   51	63	238	java/lang/NumberFormatException
    //   70	78	238	java/lang/NumberFormatException
    //   51	63	255	java/lang/Exception
    //   70	78	255	java/lang/Exception
    //   161	195	291	java/lang/Exception
    //   195	237	291	java/lang/Exception
    //   278	290	291	java/lang/Exception
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.TemperatureTask
 * JD-Core Version:    0.6.0
 */