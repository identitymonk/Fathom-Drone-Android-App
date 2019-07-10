package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R.string;

public class zzah
{
  private final Resources EP;
  private final String EQ;

  public zzah(Context paramContext)
  {
    zzaa.zzy(paramContext);
    this.EP = paramContext.getResources();
    this.EQ = this.EP.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }

  public String getString(String paramString)
  {
    int i = this.EP.getIdentifier(paramString, "string", this.EQ);
    if (i == 0)
      return null;
    return this.EP.getString(i);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzah
 * JD-Core Version:    0.6.0
 */