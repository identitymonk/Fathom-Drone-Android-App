package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R.id;
import com.facebook.react.R.layout;
import com.facebook.react.R.style;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.StackFrame;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONObject;

class RedBoxDialog extends Dialog
  implements AdapterView.OnItemClickListener
{
  private boolean isReporting = false;
  private Button mCopyToClipboardButton;
  private final DevSupportManager mDevSupportManager;
  private Button mDismissButton;
  private final DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;

  @Nullable
  private View mLineSeparator;

  @Nullable
  private ProgressBar mLoadingIndicator;

  @Nullable
  private final RedBoxHandler mRedBoxHandler;
  private Button mReloadJsButton;

  @Nullable
  private Button mReportButton;
  private View.OnClickListener mReportButtonOnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramView)
    {
      if ((RedBoxDialog.this.mRedBoxHandler == null) || (!RedBoxDialog.this.mRedBoxHandler.isReportEnabled()) || (RedBoxDialog.this.isReporting))
        return;
      RedBoxDialog.access$002(RedBoxDialog.this, true);
      ((TextView)Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText("Reporting...");
      ((TextView)Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setVisibility(0);
      ((ProgressBar)Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(0);
      ((View)Assertions.assertNotNull(RedBoxDialog.this.mLineSeparator)).setVisibility(0);
      ((Button)Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(false);
      paramView = (String)Assertions.assertNotNull(RedBoxDialog.this.mDevSupportManager.getLastErrorTitle());
      StackFrame[] arrayOfStackFrame = (StackFrame[])Assertions.assertNotNull(RedBoxDialog.this.mDevSupportManager.getLastErrorStack());
      String str = RedBoxDialog.this.mDevSupportManager.getSourceUrl();
      RedBoxDialog.this.mRedBoxHandler.reportRedbox(paramView, arrayOfStackFrame, str, (RedBoxHandler.ReportCompletedListener)Assertions.assertNotNull(RedBoxDialog.this.mReportCompletedListener));
    }
  };
  private RedBoxHandler.ReportCompletedListener mReportCompletedListener = new RedBoxHandler.ReportCompletedListener()
  {
    public void onReportError(SpannedString paramSpannedString)
    {
      RedBoxDialog.access$002(RedBoxDialog.this, false);
      ((Button)Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(true);
      ((ProgressBar)Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(8);
      ((TextView)Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText(paramSpannedString);
    }

    public void onReportSuccess(SpannedString paramSpannedString)
    {
      RedBoxDialog.access$002(RedBoxDialog.this, false);
      ((Button)Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(true);
      ((ProgressBar)Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(8);
      ((TextView)Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText(paramSpannedString);
    }
  };

  @Nullable
  private TextView mReportTextView;
  private ListView mStackView;

  protected RedBoxDialog(Context paramContext, DevSupportManager paramDevSupportManager, @Nullable RedBoxHandler paramRedBoxHandler)
  {
    super(paramContext, R.style.Theme_Catalyst_RedBox);
    requestWindowFeature(1);
    setContentView(R.layout.redbox_view);
    this.mDevSupportManager = paramDevSupportManager;
    this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
    this.mRedBoxHandler = paramRedBoxHandler;
    this.mStackView = ((ListView)findViewById(R.id.rn_redbox_stack));
    this.mStackView.setOnItemClickListener(this);
    this.mReloadJsButton = ((Button)findViewById(R.id.rn_redbox_reload_button));
    this.mReloadJsButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        RedBoxDialog.this.mDevSupportManager.handleReloadJS();
      }
    });
    this.mDismissButton = ((Button)findViewById(R.id.rn_redbox_dismiss_button));
    this.mDismissButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        RedBoxDialog.this.dismiss();
      }
    });
    this.mCopyToClipboardButton = ((Button)findViewById(R.id.rn_redbox_copy_button));
    this.mCopyToClipboardButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        paramView = RedBoxDialog.this.mDevSupportManager.getLastErrorTitle();
        StackFrame[] arrayOfStackFrame = RedBoxDialog.this.mDevSupportManager.getLastErrorStack();
        Assertions.assertNotNull(paramView);
        Assertions.assertNotNull(arrayOfStackFrame);
        new RedBoxDialog.CopyToHostClipBoardTask(RedBoxDialog.this.mDevSupportManager, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { StackTraceHelper.formatStackTrace(paramView, arrayOfStackFrame) });
      }
    });
    if ((this.mRedBoxHandler != null) && (this.mRedBoxHandler.isReportEnabled()))
    {
      this.mLoadingIndicator = ((ProgressBar)findViewById(R.id.rn_redbox_loading_indicator));
      this.mLineSeparator = findViewById(R.id.rn_redbox_line_separator);
      this.mReportTextView = ((TextView)findViewById(R.id.rn_redbox_report_label));
      this.mReportTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.mReportTextView.setHighlightColor(0);
      this.mReportButton = ((Button)findViewById(R.id.rn_redbox_report_button));
      this.mReportButton.setOnClickListener(this.mReportButtonOnClickListener);
    }
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    new OpenStackFrameTask(this.mDevSupportManager, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new StackFrame[] { (StackFrame)this.mStackView.getAdapter().getItem(paramInt) });
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82)
    {
      this.mDevSupportManager.showDevOptionsDialog();
      return true;
    }
    if (this.mDoubleTapReloadRecognizer.didDoubleTapR(paramInt, getCurrentFocus()))
      this.mDevSupportManager.handleReloadJS();
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  public void resetReporting(boolean paramBoolean)
  {
    int i = 0;
    if ((this.mRedBoxHandler == null) || (!this.mRedBoxHandler.isReportEnabled()))
      return;
    this.isReporting = false;
    ((TextView)Assertions.assertNotNull(this.mReportTextView)).setVisibility(8);
    ((ProgressBar)Assertions.assertNotNull(this.mLoadingIndicator)).setVisibility(8);
    ((View)Assertions.assertNotNull(this.mLineSeparator)).setVisibility(8);
    Button localButton = (Button)Assertions.assertNotNull(this.mReportButton);
    if (paramBoolean);
    while (true)
    {
      localButton.setVisibility(i);
      ((Button)Assertions.assertNotNull(this.mReportButton)).setEnabled(true);
      return;
      i = 8;
    }
  }

  public void setExceptionDetails(String paramString, StackFrame[] paramArrayOfStackFrame)
  {
    this.mStackView.setAdapter(new StackAdapter(paramString, paramArrayOfStackFrame));
  }

  private static class CopyToHostClipBoardTask extends AsyncTask<String, Void, Void>
  {
    private final DevSupportManager mDevSupportManager;

    private CopyToHostClipBoardTask(DevSupportManager paramDevSupportManager)
    {
      this.mDevSupportManager = paramDevSupportManager;
    }

    protected Void doInBackground(String[] paramArrayOfString)
    {
      try
      {
        String str = Uri.parse(this.mDevSupportManager.getSourceUrl()).buildUpon().path("/copy-to-clipboard").query(null).build().toString();
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramArrayOfString[i];
          OkHttpClient localOkHttpClient = new OkHttpClient();
          localObject = RequestBody.create(null, (String)localObject);
          localOkHttpClient.newCall(new Request.Builder().url(str).post((RequestBody)localObject).build()).execute();
          i += 1;
        }
      }
      catch (java.lang.Exception paramArrayOfString)
      {
        FLog.e("ReactNative", "Could not copy to the host clipboard", paramArrayOfString);
      }
      return (Void)null;
    }
  }

  private static class OpenStackFrameTask extends AsyncTask<StackFrame, Void, Void>
  {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final DevSupportManager mDevSupportManager;

    private OpenStackFrameTask(DevSupportManager paramDevSupportManager)
    {
      this.mDevSupportManager = paramDevSupportManager;
    }

    private static JSONObject stackFrameToJson(StackFrame paramStackFrame)
    {
      return new JSONObject(MapBuilder.of("file", paramStackFrame.getFile(), "methodName", paramStackFrame.getMethod(), "lineNumber", Integer.valueOf(paramStackFrame.getLine()), "column", Integer.valueOf(paramStackFrame.getColumn())));
    }

    protected Void doInBackground(StackFrame[] paramArrayOfStackFrame)
    {
      try
      {
        String str = Uri.parse(this.mDevSupportManager.getSourceUrl()).buildUpon().path("/open-stack-frame").query(null).build().toString();
        OkHttpClient localOkHttpClient = new OkHttpClient();
        int j = paramArrayOfStackFrame.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = stackFrameToJson(paramArrayOfStackFrame[i]).toString();
          localObject = RequestBody.create(JSON, (String)localObject);
          localOkHttpClient.newCall(new Request.Builder().url(str).post((RequestBody)localObject).build()).execute();
          i += 1;
        }
      }
      catch (java.lang.Exception paramArrayOfStackFrame)
      {
        FLog.e("ReactNative", "Could not open stack frame", paramArrayOfStackFrame);
      }
      return (Void)null;
    }
  }

  private static class StackAdapter extends BaseAdapter
  {
    private static final int VIEW_TYPE_COUNT = 2;
    private static final int VIEW_TYPE_STACKFRAME = 1;
    private static final int VIEW_TYPE_TITLE = 0;
    private final StackFrame[] mStack;
    private final String mTitle;

    public StackAdapter(String paramString, StackFrame[] paramArrayOfStackFrame)
    {
      this.mTitle = paramString;
      this.mStack = paramArrayOfStackFrame;
    }

    public boolean areAllItemsEnabled()
    {
      return false;
    }

    public int getCount()
    {
      return this.mStack.length + 1;
    }

    public Object getItem(int paramInt)
    {
      if (paramInt == 0)
        return this.mTitle;
      return this.mStack[(paramInt - 1)];
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public int getItemViewType(int paramInt)
    {
      if (paramInt == 0)
        return 0;
      return 1;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramInt == 0)
      {
        if (paramView != null);
        for (paramView = (TextView)paramView; ; paramView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.redbox_item_title, paramViewGroup, false))
        {
          paramView.setText(this.mTitle);
          return paramView;
        }
      }
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.redbox_item_frame, paramViewGroup, false);
        localView.setTag(new FrameViewHolder(localView, null));
      }
      paramView = this.mStack[(paramInt - 1)];
      paramViewGroup = (FrameViewHolder)localView.getTag();
      paramViewGroup.mMethodView.setText(paramView.getMethod());
      paramViewGroup.mFileView.setText(StackTraceHelper.formatFrameSource(paramView));
      return localView;
    }

    public int getViewTypeCount()
    {
      return 2;
    }

    public boolean isEnabled(int paramInt)
    {
      return paramInt > 0;
    }

    private static class FrameViewHolder
    {
      private final TextView mFileView;
      private final TextView mMethodView;

      private FrameViewHolder(View paramView)
      {
        this.mMethodView = ((TextView)paramView.findViewById(R.id.rn_frame_method));
        this.mFileView = ((TextView)paramView.findViewById(R.id.rn_frame_file));
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.RedBoxDialog
 * JD-Core Version:    0.6.0
 */