package com.brynk.fathom.api;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

public class DepthTask extends AsyncTask<String, Void, String>
{
  private String DRONE_IP;
  private Context mContext;
  private View rootView;

  public DepthTask(Context paramContext, View paramView, String paramString)
  {
    this.mContext = paramContext;
    this.rootView = paramView;
    this.DRONE_IP = paramString;
  }

  // ERROR //
  protected String doInBackground(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 38	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: new 41	java/net/URL
    //   12: dup
    //   13: new 38	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   20: ldc 43
    //   22: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 22	com/brynk/fathom/api/DepthTask:DRONE_IP	Ljava/lang/String;
    //   29: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 49
    //   34: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 56	java/net/URL:<init>	(Ljava/lang/String;)V
    //   43: astore 4
    //   45: aconst_null
    //   46: astore_1
    //   47: aload 4
    //   49: invokevirtual 60	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   52: checkcast 62	java/net/HttpURLConnection
    //   55: astore 4
    //   57: aload 4
    //   59: astore_1
    //   60: new 64	java/io/BufferedReader
    //   63: dup
    //   64: new 66	java/io/InputStreamReader
    //   67: dup
    //   68: new 68	java/io/BufferedInputStream
    //   71: dup
    //   72: aload_1
    //   73: invokevirtual 72	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   76: invokespecial 75	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: invokespecial 76	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   82: invokespecial 79	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 4
    //   87: aload 4
    //   89: invokevirtual 82	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   92: astore 6
    //   94: aload 6
    //   96: ifnull +148 -> 244
    //   99: aload 5
    //   101: aload 6
    //   103: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: goto -20 -> 87
    //   110: astore 4
    //   112: ldc 84
    //   114: ldc 86
    //   116: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aload 4
    //   122: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   125: aload_1
    //   126: invokevirtual 98	java/net/HttpURLConnection:disconnect	()V
    //   129: ldc2_w 99
    //   132: invokestatic 106	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   135: astore_1
    //   136: aload 5
    //   138: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 110	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   144: dstore_2
    //   145: dload_2
    //   146: invokestatic 106	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 114	java/lang/Double:doubleValue	()D
    //   154: dstore_2
    //   155: new 38	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   162: ldc 116
    //   164: iconst_1
    //   165: anewarray 118	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: dload_2
    //   171: ldc2_w 119
    //   174: dmul
    //   175: invokestatic 106	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   178: aastore
    //   179: invokestatic 126	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   182: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 128
    //   187: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: astore_1
    //   194: new 38	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   201: ldc 130
    //   203: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: areturn
    //   214: astore_1
    //   215: ldc 84
    //   217: ldc 132
    //   219: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   222: pop
    //   223: ldc 130
    //   225: areturn
    //   226: astore 4
    //   228: ldc 84
    //   230: ldc 134
    //   232: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   235: pop
    //   236: aload 4
    //   238: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   241: goto -181 -> 60
    //   244: aload_1
    //   245: invokevirtual 98	java/net/HttpURLConnection:disconnect	()V
    //   248: goto -119 -> 129
    //   251: astore 4
    //   253: aload_1
    //   254: invokevirtual 98	java/net/HttpURLConnection:disconnect	()V
    //   257: aload 4
    //   259: athrow
    //   260: astore 4
    //   262: ldc 84
    //   264: ldc 136
    //   266: invokestatic 139	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   269: pop
    //   270: goto -120 -> 150
    //
    // Exception table:
    //   from	to	target	type
    //   60	87	110	java/io/IOException
    //   87	94	110	java/io/IOException
    //   99	107	110	java/io/IOException
    //   9	45	214	java/net/MalformedURLException
    //   47	57	226	java/io/IOException
    //   60	87	251	finally
    //   87	94	251	finally
    //   99	107	251	finally
    //   112	125	251	finally
    //   136	145	260	java/lang/NumberFormatException
  }

  protected void onPostExecute(String paramString)
  {
    ((TextView)this.rootView.findViewById(2131689653)).setText(paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.DepthTask
 * JD-Core Version:    0.6.0
 */