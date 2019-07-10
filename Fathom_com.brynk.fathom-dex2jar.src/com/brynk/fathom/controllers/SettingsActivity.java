package com.brynk.fathom.controllers;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity.Header;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
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
import java.util.List;

public class SettingsActivity extends AppCompatPreferenceActivity
{
  private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener()
  {
    public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
    {
      Object localObject = null;
      paramObject = paramObject.toString();
      if ((paramPreference instanceof ListPreference))
      {
        ListPreference localListPreference = (ListPreference)paramPreference;
        int i = localListPreference.findIndexOfValue(paramObject);
        paramObject = localObject;
        if (i >= 0)
          paramObject = localListPreference.getEntries()[i];
        paramPreference.setSummary(paramObject);
      }
      while (true)
      {
        return true;
        if ((paramPreference instanceof RingtonePreference))
        {
          if (TextUtils.isEmpty(paramObject))
          {
            paramPreference.setSummary(2131230805);
            continue;
          }
          paramObject = RingtoneManager.getRingtone(paramPreference.getContext(), Uri.parse(paramObject));
          if (paramObject == null)
          {
            paramPreference.setSummary(null);
            continue;
          }
          paramPreference.setSummary(paramObject.getTitle(paramPreference.getContext()));
          continue;
        }
        paramPreference.setSummary(paramObject);
      }
    }
  };

  private static void bindPreferenceSummaryToValue(Preference paramPreference)
  {
    paramPreference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);
    sBindPreferenceSummaryToValueListener.onPreferenceChange(paramPreference, PreferenceManager.getDefaultSharedPreferences(paramPreference.getContext()).getString(paramPreference.getKey(), ""));
  }

  private static boolean isXLargeTablet(Context paramContext)
  {
    return (paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 4;
  }

  private void setupActionBar()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
      localActionBar.setDisplayHomeAsUpEnabled(true);
  }

  protected boolean isValidFragment(String paramString)
  {
    return (PreferenceFragment.class.getName().equals(paramString)) || (GeneralPreferenceFragment.class.getName().equals(paramString)) || (DronePreferenceFragment.class.getName().equals(paramString)) || (DataSyncPreferenceFragment.class.getName().equals(paramString)) || (NotificationPreferenceFragment.class.getName().equals(paramString));
  }

  @TargetApi(11)
  public void onBuildHeaders(List<PreferenceActivity.Header> paramList)
  {
    loadHeadersFromResource(2131099651, paramList);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setupActionBar();
  }

  public void onHeaderClick(PreferenceActivity.Header paramHeader, int paramInt)
  {
    super.onHeaderClick(paramHeader, paramInt);
    if (paramHeader.id == 2131689740L)
    {
      paramHeader = new Constants().getDroneIp(getApplicationContext());
      new CalibrateDepthTask(getApplicationContext(), paramHeader).execute(new String[] { "" });
    }
    do
    {
      return;
      if (paramHeader.id == 2131689743L)
      {
        paramHeader = new Constants().getDroneIp(getApplicationContext());
        new RebootTask(getApplicationContext(), paramHeader).execute(new String[] { "" });
        return;
      }
      if (paramHeader.id == 2131689738L)
      {
        startActivity(new Intent(this, CalibrateActivity.class));
        return;
      }
      if (paramHeader.id == 2131689739L)
      {
        startActivity(new Intent(this, CalibrateCompassActivity.class));
        return;
      }
      if (paramHeader.id != 2131689741L)
        continue;
      startActivity(new Intent(this, WiFiSetupActivity.class));
      return;
    }
    while (paramHeader.id != 2131689742L);
    startActivity(new Intent(this, WifiSetupStep3Activity.class));
  }

  public boolean onIsMultiPane()
  {
    return isXLargeTablet(this);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    finish();
    return true;
  }

  private class CalibrateDepthTask extends AsyncTask<String, Void, String>
  {
    private String DRONE_IP;
    private Context mContext;

    public CalibrateDepthTask(Context paramString, String arg3)
    {
      this.mContext = paramString;
      Object localObject;
      this.DRONE_IP = localObject;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject1 = new URL("http://" + this.DRONE_IP + "/depth/calibrate");
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
            label57: Object localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
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
              break label57;
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
      Log.v("FATHOM1", "Calibrated depth");
      Toast.makeText(this.mContext, "Depth sensor calibrated", 0).show();
    }
  }

  private class ConnectedTask extends AsyncTask<String, Void, String>
  {
    private String DRONE_IP;
    private Context mContext;

    public ConnectedTask(Context paramString, String arg3)
    {
      this.mContext = paramString;
      Object localObject;
      this.DRONE_IP = localObject;
    }

    // ERROR //
    protected String doInBackground(String[] paramArrayOfString)
    {
      // Byte code:
      //   0: new 39	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   7: astore 4
      //   9: aconst_null
      //   10: astore_1
      //   11: ldc 42
      //   13: astore_2
      //   14: new 44	java/net/URL
      //   17: dup
      //   18: new 39	java/lang/StringBuilder
      //   21: dup
      //   22: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   25: ldc 46
      //   27: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: aload_0
      //   31: getfield 25	com/brynk/fathom/controllers/SettingsActivity$ConnectedTask:DRONE_IP	Ljava/lang/String;
      //   34: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: ldc 52
      //   39: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   45: invokespecial 59	java/net/URL:<init>	(Ljava/lang/String;)V
      //   48: astore_3
      //   49: aload_3
      //   50: astore_1
      //   51: aconst_null
      //   52: astore_3
      //   53: aload_1
      //   54: invokevirtual 63	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   57: checkcast 65	java/net/HttpURLConnection
      //   60: astore_1
      //   61: new 67	java/io/BufferedReader
      //   64: dup
      //   65: new 69	java/io/InputStreamReader
      //   68: dup
      //   69: new 71	java/io/BufferedInputStream
      //   72: dup
      //   73: aload_1
      //   74: invokevirtual 75	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   77: invokespecial 78	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   80: invokespecial 79	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   83: invokespecial 82	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   86: astore_3
      //   87: aload_3
      //   88: invokevirtual 85	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   91: astore 5
      //   93: aload 5
      //   95: ifnull +71 -> 166
      //   98: aload 4
      //   100: aload 5
      //   102: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: pop
      //   106: goto -19 -> 87
      //   109: astore_3
      //   110: ldc 87
      //   112: ldc 89
      //   114: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   117: pop
      //   118: aload_3
      //   119: invokevirtual 98	java/io/IOException:printStackTrace	()V
      //   122: aload_1
      //   123: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
      //   126: aload_2
      //   127: astore_1
      //   128: iconst_0
      //   129: ifeq +9 -> 138
      //   132: aload 4
      //   134: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   137: astore_1
      //   138: aload_1
      //   139: areturn
      //   140: astore_3
      //   141: aload_3
      //   142: invokevirtual 102	java/net/MalformedURLException:printStackTrace	()V
      //   145: goto -94 -> 51
      //   148: astore_1
      //   149: ldc 87
      //   151: ldc 104
      //   153: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   156: pop
      //   157: aload_1
      //   158: invokevirtual 98	java/io/IOException:printStackTrace	()V
      //   161: aload_3
      //   162: astore_1
      //   163: goto -102 -> 61
      //   166: aload_1
      //   167: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
      //   170: aload_2
      //   171: astore_1
      //   172: iconst_1
      //   173: ifeq -35 -> 138
      //   176: aload 4
      //   178: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   181: areturn
      //   182: astore_2
      //   183: aload_1
      //   184: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
      //   187: iconst_0
      //   188: ifeq +9 -> 197
      //   191: aload 4
      //   193: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   196: pop
      //   197: aload_2
      //   198: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   61	87	109	java/io/IOException
      //   87	93	109	java/io/IOException
      //   98	106	109	java/io/IOException
      //   14	49	140	java/net/MalformedURLException
      //   53	61	148	java/io/IOException
      //   61	87	182	finally
      //   87	93	182	finally
      //   98	106	182	finally
      //   110	122	182	finally
    }

    protected void onPostExecute(String paramString)
    {
      String str2 = "Connection failed";
      String str1 = str2;
      if (paramString != null)
      {
        str1 = str2;
        if (!paramString.equals("NOT_CONNECTED"))
          str1 = "Connected";
      }
      Toast.makeText(this.mContext, str1, 0).show();
    }
  }

  @TargetApi(11)
  public static class DataSyncPreferenceFragment extends PreferenceFragment
  {
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      addPreferencesFromResource(2131099648);
      setHasOptionsMenu(true);
      SettingsActivity.access$000(findPreference("sync_frequency"));
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
      if (paramMenuItem.getItemId() == 16908332)
      {
        startActivity(new Intent(getActivity(), SettingsActivity.class));
        return true;
      }
      return super.onOptionsItemSelected(paramMenuItem);
    }
  }

  @TargetApi(11)
  public static class DronePreferenceFragment extends PreferenceFragment
  {
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      addPreferencesFromResource(2131099649);
      setHasOptionsMenu(true);
      SettingsActivity.access$000(findPreference("drone_ip"));
      SettingsActivity.access$000(findPreference("temperature_cutoff"));
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
      if (paramMenuItem.getItemId() == 16908332)
      {
        startActivity(new Intent(getActivity(), SettingsActivity.class));
        return true;
      }
      return super.onOptionsItemSelected(paramMenuItem);
    }
  }

  @TargetApi(11)
  public static class GeneralPreferenceFragment extends PreferenceFragment
  {
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      addPreferencesFromResource(2131099650);
      setHasOptionsMenu(true);
      SettingsActivity.access$000(findPreference("example_text"));
      SettingsActivity.access$000(findPreference("example_list"));
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
      if (paramMenuItem.getItemId() == 16908332)
      {
        startActivity(new Intent(getActivity(), SettingsActivity.class));
        return true;
      }
      return super.onOptionsItemSelected(paramMenuItem);
    }
  }

  @TargetApi(11)
  public static class NotificationPreferenceFragment extends PreferenceFragment
  {
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      addPreferencesFromResource(2131099652);
      setHasOptionsMenu(true);
      SettingsActivity.access$000(findPreference("notifications_new_message_ringtone"));
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
      if (paramMenuItem.getItemId() == 16908332)
      {
        startActivity(new Intent(getActivity(), SettingsActivity.class));
        return true;
      }
      return super.onOptionsItemSelected(paramMenuItem);
    }
  }

  private class RebootTask extends AsyncTask<String, Void, String>
  {
    private String DRONE_IP;
    private Context mContext;

    public RebootTask(Context paramString, String arg3)
    {
      this.mContext = paramString;
      Object localObject;
      this.DRONE_IP = localObject;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject1 = new URL("http://" + this.DRONE_IP + "/reboot");
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
            label57: Object localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
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
              break label57;
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
      Log.v("FATHOM1", "Rebooting drone");
      Toast.makeText(this.mContext, "Rebooting drone. Please wait 3 minutes to reconnect", 1).show();
    }
  }

  private class StopSessionsTask extends AsyncTask<String, Void, String>
  {
    private String DRONE_IP;
    private Context mContext;

    public StopSessionsTask(Context paramString, String arg3)
    {
      this.mContext = paramString;
      Object localObject;
      this.DRONE_IP = localObject;
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayOfString = null;
      try
      {
        localObject1 = new URL("http://" + this.DRONE_IP + "/camera/stop");
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
            label57: Object localObject1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(paramArrayOfString.getInputStream())));
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
              break label57;
              Log.v("FATHOM1", "Stopping sessions");
              paramArrayOfString.disconnect();
              System.out.println(localStringBuilder.toString());
            }
          }
          finally
          {
            Log.v("FATHOM1", "Stopping sessions");
            paramArrayOfString.disconnect();
            System.out.println(localStringBuilder.toString());
          }
        }
      }
      throw localObject2;
    }

    protected void onPostExecute(String paramString)
    {
      Log.v("FATHOM1", "Sessions stopped");
      Toast.makeText(this.mContext, "Sessions stopped", 0).show();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.SettingsActivity
 * JD-Core Version:    0.6.0
 */