package com.facebook.react.views.checkbox;

import android.content.Context;
import android.widget.CheckBox;

class ReactCheckBox extends CheckBox
{
  private boolean mAllowChange = true;

  public ReactCheckBox(Context paramContext)
  {
    super(paramContext);
  }

  public void setChecked(boolean paramBoolean)
  {
    if (this.mAllowChange)
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
 * Qualified Name:     com.facebook.react.views.checkbox.ReactCheckBox
 * JD-Core Version:    0.6.0
 */