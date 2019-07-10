package com.brynk.fathom.controllers;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class AppCompatPreferenceActivity extends PreferenceActivity
{
  private AppCompatDelegate mDelegate;

  private AppCompatDelegate getDelegate()
  {
    if (this.mDelegate == null)
      this.mDelegate = AppCompatDelegate.create(this, null);
    return this.mDelegate;
  }

  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().addContentView(paramView, paramLayoutParams);
  }

  public MenuInflater getMenuInflater()
  {
    return getDelegate().getMenuInflater();
  }

  public ActionBar getSupportActionBar()
  {
    return getDelegate().getSupportActionBar();
  }

  public void invalidateOptionsMenu()
  {
    getDelegate().invalidateOptionsMenu();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().onConfigurationChanged(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    getDelegate().installViewFactory();
    getDelegate().onCreate(paramBundle);
    super.onCreate(paramBundle);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    getDelegate().onDestroy();
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    getDelegate().onPostCreate(paramBundle);
  }

  protected void onPostResume()
  {
    super.onPostResume();
    getDelegate().onPostResume();
  }

  protected void onStop()
  {
    super.onStop();
    getDelegate().onStop();
  }

  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().setTitle(paramCharSequence);
  }

  public void setContentView(@LayoutRes int paramInt)
  {
    getDelegate().setContentView(paramInt);
  }

  public void setContentView(View paramView)
  {
    getDelegate().setContentView(paramView);
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().setContentView(paramView, paramLayoutParams);
  }

  public void setSupportActionBar(@Nullable Toolbar paramToolbar)
  {
    getDelegate().setSupportActionBar(paramToolbar);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.AppCompatPreferenceActivity
 * JD-Core Version:    0.6.0
 */