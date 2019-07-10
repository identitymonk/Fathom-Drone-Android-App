package com.facebook.react.modules.timepicker;

import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Build.VERSION;
import javax.annotation.Nullable;

public class DismissableTimePickerDialog extends TimePickerDialog
{
  public DismissableTimePickerDialog(Context paramContext, int paramInt1, @Nullable TimePickerDialog.OnTimeSetListener paramOnTimeSetListener, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramContext, paramInt1, paramOnTimeSetListener, paramInt2, paramInt3, paramBoolean);
  }

  public DismissableTimePickerDialog(Context paramContext, @Nullable TimePickerDialog.OnTimeSetListener paramOnTimeSetListener, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramOnTimeSetListener, paramInt1, paramInt2, paramBoolean);
  }

  protected void onStop()
  {
    if (Build.VERSION.SDK_INT > 19)
      super.onStop();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.timepicker.DismissableTimePickerDialog
 * JD-Core Version:    0.6.0
 */