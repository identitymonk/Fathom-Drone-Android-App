package com.brynk.fathom.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class StorageTask extends AsyncTask<String, Void, String>
{
  private String DRONE_IP;
  private Context mContext;
  private View rootView;

  public StorageTask(Context paramContext, View paramView, String paramString)
  {
    this.mContext = paramContext;
    this.rootView = paramView;
    this.DRONE_IP = paramString;
  }

  // ERROR //
  protected String doInBackground(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 36	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: new 39	java/net/URL
    //   11: dup
    //   12: new 36	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   19: ldc 41
    //   21: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 22	com/brynk/fathom/api/StorageTask:DRONE_IP	Ljava/lang/String;
    //   28: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 47
    //   33: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 54	java/net/URL:<init>	(Ljava/lang/String;)V
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 58	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   49: checkcast 60	java/net/HttpURLConnection
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: new 62	java/io/BufferedReader
    //   58: dup
    //   59: new 64	java/io/InputStreamReader
    //   62: dup
    //   63: new 66	java/io/BufferedInputStream
    //   66: dup
    //   67: aload_1
    //   68: invokevirtual 70	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   71: invokespecial 73	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   74: invokespecial 74	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   77: invokespecial 77	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 80	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   85: astore 4
    //   87: aload 4
    //   89: ifnull +83 -> 172
    //   92: aload_3
    //   93: aload 4
    //   95: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: goto -18 -> 81
    //   102: astore_2
    //   103: ldc 82
    //   105: ldc 84
    //   107: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   110: pop
    //   111: aload_2
    //   112: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   115: aload_1
    //   116: invokevirtual 96	java/net/HttpURLConnection:disconnect	()V
    //   119: aload_3
    //   120: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore_1
    //   124: new 36	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   131: ldc 98
    //   133: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: areturn
    //   144: astore_1
    //   145: ldc 82
    //   147: ldc 100
    //   149: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   152: pop
    //   153: ldc 98
    //   155: areturn
    //   156: astore_2
    //   157: ldc 82
    //   159: ldc 102
    //   161: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   164: pop
    //   165: aload_2
    //   166: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   169: goto -114 -> 55
    //   172: aload_1
    //   173: invokevirtual 96	java/net/HttpURLConnection:disconnect	()V
    //   176: goto -57 -> 119
    //   179: astore_2
    //   180: aload_1
    //   181: invokevirtual 96	java/net/HttpURLConnection:disconnect	()V
    //   184: aload_2
    //   185: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   55	81	102	java/io/IOException
    //   81	87	102	java/io/IOException
    //   92	99	102	java/io/IOException
    //   8	43	144	java/net/MalformedURLException
    //   45	53	156	java/io/IOException
    //   55	81	179	finally
    //   81	87	179	finally
    //   92	99	179	finally
    //   103	115	179	finally
  }

  protected void onPostExecute(String paramString)
  {
    TextView localTextView = (TextView)this.rootView.findViewById(2131689651);
    Double localDouble = Double.valueOf(0.0D);
    try
    {
      double d = Double.parseDouble(paramString);
      paramString = Double.valueOf(d);
      localTextView.setText(paramString + "%");
      if (paramString.doubleValue() < 10.0D)
      {
        localTextView.setVisibility(0);
        return;
      }
    }
    catch (java.lang.NumberFormatException paramString)
    {
      while (true)
      {
        Log.e("FATHOM1", "Storage is not a double");
        paramString = localDouble;
      }
      localTextView.setVisibility(4);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.api.StorageTask
 * JD-Core Version:    0.6.0
 */