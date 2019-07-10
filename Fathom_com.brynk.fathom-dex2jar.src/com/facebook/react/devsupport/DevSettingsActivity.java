package com.facebook.react.devsupport;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.facebook.react.R.string;
import com.facebook.react.R.xml;

public class DevSettingsActivity extends PreferenceActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitle(R.string.catalyst_settings_title);
    addPreferencesFromResource(R.xml.preferences);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevSettingsActivity
 * JD-Core Version:    0.6.0
 */