package com.facebook.react.modules.datepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import javax.annotation.Nullable;

@SuppressLint({"ValidFragment"})
public class SupportDatePickerDialogFragment extends DialogFragment
{

  @Nullable
  private DatePickerDialog.OnDateSetListener mOnDateSetListener;

  @Nullable
  private DialogInterface.OnDismissListener mOnDismissListener;

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return DatePickerDialogFragment.createDialog(getArguments(), getActivity(), this.mOnDateSetListener);
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.mOnDismissListener != null)
      this.mOnDismissListener.onDismiss(paramDialogInterface);
  }

  void setOnDateSetListener(@Nullable DatePickerDialog.OnDateSetListener paramOnDateSetListener)
  {
    this.mOnDateSetListener = paramOnDateSetListener;
  }

  void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.datepicker.SupportDatePickerDialogFragment
 * JD-Core Version:    0.6.0
 */