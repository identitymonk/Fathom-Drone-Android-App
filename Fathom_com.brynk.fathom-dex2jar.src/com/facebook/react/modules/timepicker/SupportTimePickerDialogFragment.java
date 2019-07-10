package com.facebook.react.modules.timepicker;

import android.app.Dialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import javax.annotation.Nullable;

public class SupportTimePickerDialogFragment extends DialogFragment
{

  @Nullable
  private DialogInterface.OnDismissListener mOnDismissListener;

  @Nullable
  private TimePickerDialog.OnTimeSetListener mOnTimeSetListener;

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return TimePickerDialogFragment.createDialog(getArguments(), getActivity(), this.mOnTimeSetListener);
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.mOnDismissListener != null)
      this.mOnDismissListener.onDismiss(paramDialogInterface);
  }

  public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }

  public void setOnTimeSetListener(@Nullable TimePickerDialog.OnTimeSetListener paramOnTimeSetListener)
  {
    this.mOnTimeSetListener = paramOnTimeSetListener;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.timepicker.SupportTimePickerDialogFragment
 * JD-Core Version:    0.6.0
 */