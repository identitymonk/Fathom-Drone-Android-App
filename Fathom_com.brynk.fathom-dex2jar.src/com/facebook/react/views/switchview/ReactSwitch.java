package com.facebook.react.views.switchview;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;

class ReactSwitch extends SwitchCompat
{
  private boolean mAllowChange = true;

  public ReactSwitch(Context paramContext)
  {
    super(paramContext);
  }

  public void setChecked(boolean paramBoolean)
  {
    if ((this.mAllowChange) && (isChecked() != paramBoolean))
    {
      this.mAllowChange = false;
      super.setChecked(paramBoolean);
    }
  }

  void setOn(boolean paramBoolean)
  {
    if (isChecked() != paramBoolean)
      super.setChecked(paramBoolean);
    this.mAllowChange = true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.switchview.ReactSwitch
 * JD-Core Version:    0.6.0
 */