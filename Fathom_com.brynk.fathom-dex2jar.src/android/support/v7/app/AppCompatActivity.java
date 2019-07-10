package android.support.v7.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v4.view.KeyEventCompat;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatActivity extends FragmentActivity
  implements AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider
{
  private AppCompatDelegate mDelegate;
  private boolean mEatKeyUpEvent;
  private Resources mResources;
  private int mThemeId = 0;

  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().addContentView(paramView, paramLayoutParams);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((KeyEventCompat.hasModifiers(paramKeyEvent, 4096)) && (paramKeyEvent.getUnicodeChar(paramKeyEvent.getMetaState() & 0xFFFF8FFF) == 60))
    {
      int i = paramKeyEvent.getAction();
      if (i == 0)
      {
        ActionBar localActionBar = getSupportActionBar();
        if ((localActionBar != null) && (localActionBar.isShowing()) && (localActionBar.requestFocus()))
        {
          this.mEatKeyUpEvent = true;
          return true;
        }
      }
      else if ((i == 1) && (this.mEatKeyUpEvent))
      {
        this.mEatKeyUpEvent = false;
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  @Nullable
  public View findViewById(@IdRes int paramInt)
  {
    return getDelegate().findViewById(paramInt);
  }

  @NonNull
  public AppCompatDelegate getDelegate()
  {
    if (this.mDelegate == null)
      this.mDelegate = AppCompatDelegate.create(this, this);
    return this.mDelegate;
  }

  @Nullable
  public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return getDelegate().getDrawerToggleDelegate();
  }

  public MenuInflater getMenuInflater()
  {
    return getDelegate().getMenuInflater();
  }

  public Resources getResources()
  {
    if ((this.mResources == null) && (VectorEnabledTintResources.shouldBeUsed()))
      this.mResources = new VectorEnabledTintResources(this, super.getResources());
    if (this.mResources == null)
      return super.getResources();
    return this.mResources;
  }

  @Nullable
  public ActionBar getSupportActionBar()
  {
    return getDelegate().getSupportActionBar();
  }

  @Nullable
  public Intent getSupportParentActivityIntent()
  {
    return NavUtils.getParentActivityIntent(this);
  }

  public void invalidateOptionsMenu()
  {
    getDelegate().invalidateOptionsMenu();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().onConfigurationChanged(paramConfiguration);
    if (this.mResources != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.mResources.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
  }

  public void onContentChanged()
  {
    onSupportContentChanged();
  }

  protected void onCreate(@Nullable Bundle paramBundle)
  {
    AppCompatDelegate localAppCompatDelegate = getDelegate();
    localAppCompatDelegate.installViewFactory();
    localAppCompatDelegate.onCreate(paramBundle);
    if ((localAppCompatDelegate.applyDayNight()) && (this.mThemeId != 0))
    {
      if (Build.VERSION.SDK_INT < 23)
        break label55;
      onApplyThemeResource(getTheme(), this.mThemeId, false);
    }
    while (true)
    {
      super.onCreate(paramBundle);
      return;
      label55: setTheme(this.mThemeId);
    }
  }

  public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder paramTaskStackBuilder)
  {
    paramTaskStackBuilder.addParentStack(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    getDelegate().onDestroy();
  }

  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      return true;
    ActionBar localActionBar = getSupportActionBar();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0))
      return onSupportNavigateUp();
    return false;
  }

  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }

  protected void onPostCreate(@Nullable Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    getDelegate().onPostCreate(paramBundle);
  }

  protected void onPostResume()
  {
    super.onPostResume();
    getDelegate().onPostResume();
  }

  public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder paramTaskStackBuilder)
  {
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    getDelegate().onSaveInstanceState(paramBundle);
  }

  protected void onStop()
  {
    super.onStop();
    getDelegate().onStop();
  }

  @CallSuper
  public void onSupportActionModeFinished(@NonNull ActionMode paramActionMode)
  {
  }

  @CallSuper
  public void onSupportActionModeStarted(@NonNull ActionMode paramActionMode)
  {
  }

  @Deprecated
  public void onSupportContentChanged()
  {
  }

  public boolean onSupportNavigateUp()
  {
    Object localObject = getSupportParentActivityIntent();
    if (localObject != null)
    {
      if (supportShouldUpRecreateTask((Intent)localObject))
      {
        localObject = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack((TaskStackBuilder)localObject);
        onPrepareSupportNavigateUpTaskStack((TaskStackBuilder)localObject);
        ((TaskStackBuilder)localObject).startActivities();
      }
      while (true)
      {
        try
        {
          ActivityCompat.finishAffinity(this);
          return true;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          finish();
          continue;
        }
        supportNavigateUpTo(localIllegalStateException);
      }
    }
    return false;
  }

  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().setTitle(paramCharSequence);
  }

  @Nullable
  public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback paramCallback)
  {
    return null;
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

  @Deprecated
  public void setSupportProgress(int paramInt)
  {
  }

  @Deprecated
  public void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
  }

  @Deprecated
  public void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
  }

  @Deprecated
  public void setSupportProgressBarVisibility(boolean paramBoolean)
  {
  }

  public void setTheme(@StyleRes int paramInt)
  {
    super.setTheme(paramInt);
    this.mThemeId = paramInt;
  }

  @Nullable
  public ActionMode startSupportActionMode(@NonNull ActionMode.Callback paramCallback)
  {
    return getDelegate().startSupportActionMode(paramCallback);
  }

  public void supportInvalidateOptionsMenu()
  {
    getDelegate().invalidateOptionsMenu();
  }

  public void supportNavigateUpTo(@NonNull Intent paramIntent)
  {
    NavUtils.navigateUpTo(this, paramIntent);
  }

  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().requestWindowFeature(paramInt);
  }

  public boolean supportShouldUpRecreateTask(@NonNull Intent paramIntent)
  {
    return NavUtils.shouldUpRecreateTask(this, paramIntent);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.app.AppCompatActivity
 * JD-Core Version:    0.6.0
 */