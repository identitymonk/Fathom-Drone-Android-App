package io.vov.vitamio.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import java.lang.ref.WeakReference;

public class InitActivity extends Activity
{
  public static final String FROM_ME = "fromVitamioInitActivity";
  private ProgressDialog mPD;
  private UIHandler uiHandler;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    this.uiHandler = new UIHandler(this);
    new AsyncTask()
    {
      protected Boolean doInBackground(Object[] paramArrayOfObject)
      {
        return null;
      }

      protected void onPostExecute(Boolean paramBoolean)
      {
        if (paramBoolean.booleanValue())
          InitActivity.this.uiHandler.sendEmptyMessage(0);
      }

      protected void onPreExecute()
      {
        InitActivity.access$002(InitActivity.this, new ProgressDialog(InitActivity.this));
        InitActivity.this.mPD.setCancelable(false);
        InitActivity.this.mPD.setMessage(InitActivity.this.getString(InitActivity.this.getResources().getIdentifier("vitamio_init_decoders", "string", InitActivity.this.getPackageName())));
        InitActivity.this.mPD.show();
      }
    }
    .execute(new Object[0]);
  }

  private static class UIHandler extends Handler
  {
    private WeakReference<Context> mContext;

    public UIHandler(Context paramContext)
    {
      this.mContext = new WeakReference(paramContext);
    }

    public void handleMessage(Message paramMessage)
    {
      InitActivity localInitActivity = (InitActivity)this.mContext.get();
      switch (paramMessage.what)
      {
      default:
        return;
      case 0:
      }
      localInitActivity.mPD.dismiss();
      paramMessage = localInitActivity.getIntent();
      Intent localIntent = new Intent();
      localIntent.setClassName(paramMessage.getStringExtra("package"), paramMessage.getStringExtra("className"));
      localIntent.setData(paramMessage.getData());
      localIntent.putExtras(paramMessage);
      localIntent.putExtra("fromVitamioInitActivity", true);
      localInitActivity.startActivity(localIntent);
      localInitActivity.finish();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.activity.InitActivity
 * JD-Core Version:    0.6.0
 */