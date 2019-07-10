package com.facebook.react.modules.datepicker;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Build.VERSION;
import javax.annotation.Nullable;

public class DismissableDatePickerDialog extends DatePickerDialog
{
  public DismissableDatePickerDialog(Context paramContext, int paramInt1, @Nullable DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext, paramInt1, paramOnDateSetListener, paramInt2, paramInt3, paramInt4);
  }

  public DismissableDatePickerDialog(Context paramContext, @Nullable DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
  }

  protected void onStop()
  {
    if (Build.VERSION.SDK_INT > 19)
      super.onStop();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.datepicker.DismissableDatePickerDialog
 * JD-Core Version:    0.6.0
 */