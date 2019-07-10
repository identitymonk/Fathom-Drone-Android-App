package com.facebook.react.modules.dialog;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import javax.annotation.Nullable;

public class AlertFragment extends DialogFragment
  implements DialogInterface.OnClickListener
{
  static final String ARG_BUTTON_NEGATIVE = "button_negative";
  static final String ARG_BUTTON_NEUTRAL = "button_neutral";
  static final String ARG_BUTTON_POSITIVE = "button_positive";
  static final String ARG_ITEMS = "items";
  static final String ARG_MESSAGE = "message";
  static final String ARG_TITLE = "title";

  @Nullable
  private final DialogModule.AlertFragmentListener mListener;

  public AlertFragment()
  {
    this.mListener = null;
  }

  public AlertFragment(@Nullable DialogModule.AlertFragmentListener paramAlertFragmentListener, Bundle paramBundle)
  {
    this.mListener = paramAlertFragmentListener;
    setArguments(paramBundle);
  }

  public static Dialog createDialog(Context paramContext, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new AlertDialog.Builder(paramContext).setTitle(paramBundle.getString("title"));
    if (paramBundle.containsKey("button_positive"))
      paramContext.setPositiveButton(paramBundle.getString("button_positive"), paramOnClickListener);
    if (paramBundle.containsKey("button_negative"))
      paramContext.setNegativeButton(paramBundle.getString("button_negative"), paramOnClickListener);
    if (paramBundle.containsKey("button_neutral"))
      paramContext.setNeutralButton(paramBundle.getString("button_neutral"), paramOnClickListener);
    if (paramBundle.containsKey("message"))
      paramContext.setMessage(paramBundle.getString("message"));
    if (paramBundle.containsKey("items"))
      paramContext.setItems(paramBundle.getCharSequenceArray("items"), paramOnClickListener);
    return paramContext.create();
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.mListener != null)
      this.mListener.onClick(paramDialogInterface, paramInt);
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return createDialog(getActivity(), getArguments(), this);
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.mListener != null)
      this.mListener.onDismiss(paramDialogInterface);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.dialog.AlertFragment
 * JD-Core Version:    0.6.0
 */