package com.facebook.react.devsupport;

import android.text.SpannedString;
import com.facebook.react.devsupport.interfaces.StackFrame;

public abstract interface RedBoxHandler
{
  public abstract void handleRedbox(String paramString, StackFrame[] paramArrayOfStackFrame, ErrorType paramErrorType);

  public abstract boolean isReportEnabled();

  public abstract void reportRedbox(String paramString1, StackFrame[] paramArrayOfStackFrame, String paramString2, ReportCompletedListener paramReportCompletedListener);

  public static enum ErrorType
  {
    private final String name;

    static
    {
      $VALUES = new ErrorType[] { JS, NATIVE };
    }

    private ErrorType(String paramString)
    {
      this.name = paramString;
    }

    public String getName()
    {
      return this.name;
    }
  }

  public static abstract interface ReportCompletedListener
  {
    public abstract void onReportError(SpannedString paramSpannedString);

    public abstract void onReportSuccess(SpannedString paramSpannedString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.RedBoxHandler
 * JD-Core Version:    0.6.0
 */