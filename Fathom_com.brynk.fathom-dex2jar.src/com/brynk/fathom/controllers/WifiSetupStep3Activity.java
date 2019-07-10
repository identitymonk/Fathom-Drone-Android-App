package com.brynk.fathom.controllers;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.brynk.fathom.helpers.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class WifiSetupStep3Activity extends AppCompatActivity
{
  private String DRONE_IP;
  private String result_from_api;
  private String selected_network = "";
  private String selected_network_password = "";

  public void connectToWifi(View paramView)
  {
    this.selected_network_password = ((EditText)findViewById(2131689688)).getText().toString();
    Log.d("FATHOM1", "Adding network...");
    new NetworkConnectTask(null).execute(new String[] { "" });
  }

  public void goToFirmwareScreen(View paramView)
  {
    startActivity(new Intent(this, FirmwareActivity.class));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968614);
    this.DRONE_IP = new Constants().getDroneIp(getApplicationContext());
  }

  public void turnOnWifi(View paramView)
  {
    Toast.makeText(getApplicationContext(), "Turning on WiFi", 1).show();
    new NetworkTask(null).execute(new String[] { "" });
  }

  private class NetworkConnectTask extends AsyncTask<String, Void, String>
  {
    private NetworkConnectTask()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      Object localObject1 = "network=" + URLEncoder.encode(WifiSetupStep3Activity.this.selected_network) + "&password=" + URLEncoder.encode(WifiSetupStep3Activity.this.selected_network_password);
      try
      {
        localObject1 = new URL("http://" + WifiSetupStep3Activity.this.DRONE_IP + "/network/add?" + (String)localObject1);
        paramArrayOfString = (String)localObject1;
        localObject1 = null;
      }
      catch (IOException paramArrayOfString)
      {
        try
        {
          paramArrayOfString = (HttpURLConnection)paramArrayOfString.openConnection();
        }
        catch (IOException paramArrayOfString)
        {
          try
          {
            label111: localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
            while (true)
            {
              String str = ((BufferedReader)localObject1).readLine();
              if (str == null)
                break;
              localStringBuilder.append(str);
            }
          }
          catch (IOException localMalformedURLException)
          {
            Log.e("FATHOM1", "Error reading input from URL");
            localIOException.printStackTrace();
            while (true)
            {
              return "TODO";
              localMalformedURLException = localMalformedURLException;
              localMalformedURLException.printStackTrace();
              break;
              paramArrayOfString = paramArrayOfString;
              Log.e("FATHOM1", "Error establishing URL connection");
              paramArrayOfString.printStackTrace();
              paramArrayOfString = localMalformedURLException;
              break label111;
              paramArrayOfString.disconnect();
              System.out.println(localStringBuilder.toString());
            }
          }
          finally
          {
            paramArrayOfString.disconnect();
            System.out.println(localStringBuilder.toString());
          }
        }
      }
      throw localObject2;
    }

    protected void onPostExecute(String paramString)
    {
      WifiSetupStep3Activity.this.goToFirmwareScreen(WifiSetupStep3Activity.this.getWindow().getDecorView().getRootView());
    }
  }

  private class NetworkConnectedTask extends AsyncTask<String, Void, String>
  {
    private NetworkConnectedTask()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject1 = new URL("http://" + WifiSetupStep3Activity.this.DRONE_IP + "/network/isConnected");
        paramArrayOfString = (String)localObject1;
        localObject1 = null;
      }
      catch (IOException paramArrayOfString)
      {
        try
        {
          paramArrayOfString = (HttpURLConnection)paramArrayOfString.openConnection();
        }
        catch (IOException paramArrayOfString)
        {
          try
          {
            label60: Object localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
            while (true)
            {
              String str = ((BufferedReader)localObject1).readLine();
              if (str == null)
                break;
              localStringBuilder.append(str);
            }
          }
          catch (IOException localMalformedURLException)
          {
            Log.e("FATHOM1", "Error reading input from URL");
            localIOException.printStackTrace();
            while (true)
            {
              return localStringBuilder.toString();
              localMalformedURLException = localMalformedURLException;
              localMalformedURLException.printStackTrace();
              break;
              paramArrayOfString = paramArrayOfString;
              Log.e("FATHOM1", "Error establishing URL connection");
              paramArrayOfString.printStackTrace();
              paramArrayOfString = localMalformedURLException;
              break label60;
              paramArrayOfString.disconnect();
              System.out.println(localStringBuilder.toString());
            }
          }
          finally
          {
            paramArrayOfString.disconnect();
            System.out.println(localStringBuilder.toString());
          }
        }
      }
      throw localObject2;
    }

    protected void onPostExecute(String paramString)
    {
      TextView localTextView = (TextView)WifiSetupStep3Activity.this.findViewById(2131689678);
      if (Boolean.parseBoolean(paramString))
      {
        localTextView.setTextColor(17170452);
        return;
      }
      localTextView.setTextColor(17170454);
    }
  }

  private class NetworkTask extends AsyncTask<String, Void, String>
  {
    private NetworkTask()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject1 = new URL("http://" + WifiSetupStep3Activity.this.DRONE_IP + "/network/available");
        paramArrayOfString = (String)localObject1;
        localObject1 = null;
      }
      catch (IOException paramArrayOfString)
      {
        try
        {
          paramArrayOfString = (HttpURLConnection)paramArrayOfString.openConnection();
        }
        catch (IOException paramArrayOfString)
        {
          try
          {
            label60: Object localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
            while (true)
            {
              String str = ((BufferedReader)localObject1).readLine();
              if (str == null)
                break;
              localStringBuilder.append(str);
            }
          }
          catch (IOException localMalformedURLException)
          {
            Log.e("FATHOM1", "Error reading input from URL");
            localIOException.printStackTrace();
            paramArrayOfString.disconnect();
            System.out.println(localStringBuilder.toString());
            while (true)
            {
              WifiSetupStep3Activity.access$302(WifiSetupStep3Activity.this, localStringBuilder.toString());
              return "TODO";
              localMalformedURLException = localMalformedURLException;
              localMalformedURLException.printStackTrace();
              break;
              paramArrayOfString = paramArrayOfString;
              Log.e("FATHOM1", "Error establishing URL connection");
              paramArrayOfString.printStackTrace();
              paramArrayOfString = localMalformedURLException;
              break label60;
              paramArrayOfString.disconnect();
              System.out.println(localStringBuilder.toString());
            }
          }
          finally
          {
            paramArrayOfString.disconnect();
            System.out.println(localStringBuilder.toString());
          }
        }
      }
      throw localObject2;
    }

    // ERROR //
    protected void onPostExecute(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	com/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask:this$0	Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
      //   4: ldc 129
      //   6: invokevirtual 133	com/brynk/fathom/controllers/WifiSetupStep3Activity:findViewById	(I)Landroid/view/View;
      //   9: checkcast 135	android/widget/ListView
      //   12: astore 5
      //   14: aconst_null
      //   15: astore_1
      //   16: new 137	org/json/JSONArray
      //   19: dup
      //   20: aload_0
      //   21: getfield 16	com/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask:this$0	Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
      //   24: invokestatic 140	com/brynk/fathom/controllers/WifiSetupStep3Activity:access$300	(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;
      //   27: invokespecial 141	org/json/JSONArray:<init>	(Ljava/lang/String;)V
      //   30: astore 4
      //   32: aload 4
      //   34: invokevirtual 145	org/json/JSONArray:length	()I
      //   37: anewarray 124	java/lang/String
      //   40: astore_3
      //   41: iconst_0
      //   42: istore_2
      //   43: iload_2
      //   44: aload 4
      //   46: invokevirtual 145	org/json/JSONArray:length	()I
      //   49: if_icmpge +41 -> 90
      //   52: aload_3
      //   53: iload_2
      //   54: aload 4
      //   56: iload_2
      //   57: invokevirtual 149	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   60: ldc 151
      //   62: ldc 153
      //   64: invokevirtual 157	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   67: ldc 159
      //   69: ldc 153
      //   71: invokevirtual 157	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   74: aastore
      //   75: iload_2
      //   76: iconst_1
      //   77: iadd
      //   78: istore_2
      //   79: goto -36 -> 43
      //   82: astore_1
      //   83: aload_1
      //   84: invokevirtual 160	org/json/JSONException:printStackTrace	()V
      //   87: goto -12 -> 75
      //   90: aload 5
      //   92: new 162	android/widget/ArrayAdapter
      //   95: dup
      //   96: aload_0
      //   97: getfield 16	com/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask:this$0	Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
      //   100: invokevirtual 166	com/brynk/fathom/controllers/WifiSetupStep3Activity:getApplicationContext	()Landroid/content/Context;
      //   103: ldc 167
      //   105: ldc 168
      //   107: aload_3
      //   108: invokespecial 171	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;II[Ljava/lang/Object;)V
      //   111: invokevirtual 175	android/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
      //   114: aload 5
      //   116: new 10	com/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1
      //   119: dup
      //   120: aload_0
      //   121: aload 5
      //   123: invokespecial 178	com/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1:<init>	(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;Landroid/widget/ListView;)V
      //   126: invokevirtual 182	android/widget/ListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
      //   129: return
      //   130: astore_3
      //   131: aload_3
      //   132: invokevirtual 160	org/json/JSONException:printStackTrace	()V
      //   135: new 137	org/json/JSONArray
      //   138: dup
      //   139: ldc 153
      //   141: invokespecial 141	org/json/JSONArray:<init>	(Ljava/lang/String;)V
      //   144: astore_3
      //   145: aload_3
      //   146: astore_1
      //   147: aload_1
      //   148: invokevirtual 145	org/json/JSONArray:length	()I
      //   151: anewarray 124	java/lang/String
      //   154: astore 4
      //   156: iconst_0
      //   157: istore_2
      //   158: aload 4
      //   160: astore_3
      //   161: iload_2
      //   162: aload_1
      //   163: invokevirtual 145	org/json/JSONArray:length	()I
      //   166: if_icmpge -76 -> 90
      //   169: aload 4
      //   171: iload_2
      //   172: aload_1
      //   173: iload_2
      //   174: invokevirtual 149	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   177: ldc 151
      //   179: ldc 153
      //   181: invokevirtual 157	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   184: ldc 159
      //   186: ldc 153
      //   188: invokevirtual 157	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   191: aastore
      //   192: iload_2
      //   193: iconst_1
      //   194: iadd
      //   195: istore_2
      //   196: goto -38 -> 158
      //   199: astore_3
      //   200: aload_3
      //   201: invokevirtual 160	org/json/JSONException:printStackTrace	()V
      //   204: goto -57 -> 147
      //   207: astore_1
      //   208: new 184	java/lang/NullPointerException
      //   211: dup
      //   212: invokespecial 185	java/lang/NullPointerException:<init>	()V
      //   215: athrow
      //   216: astore_3
      //   217: aload_3
      //   218: invokevirtual 160	org/json/JSONException:printStackTrace	()V
      //   221: goto -29 -> 192
      //
      // Exception table:
      //   from	to	target	type
      //   52	75	82	org/json/JSONException
      //   16	32	130	org/json/JSONException
      //   135	145	199	org/json/JSONException
      //   16	32	207	finally
      //   131	135	207	finally
      //   135	145	207	finally
      //   200	204	207	finally
      //   169	192	216	org/json/JSONException
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.WifiSetupStep3Activity
 * JD-Core Version:    0.6.0
 */