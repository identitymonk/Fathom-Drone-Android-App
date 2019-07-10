package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class AppCompatDelegateImplBase extends AppCompatDelegate
{
  ActionBar mActionBar;
  final AppCompatCallback mAppCompatCallback;
  final Window.Callback mAppCompatWindowCallback;
  final Context mContext;
  boolean mHasActionBar;
  private boolean mIsDestroyed;
  boolean mIsFloating;
  MenuInflater mMenuInflater;
  final Window.Callback mOriginalWindowCallback;
  boolean mOverlayActionBar;
  boolean mOverlayActionMode;
  boolean mThemeRead;
  private CharSequence mTitle;
  final Window mWindow;
  boolean mWindowNoTitle;

  AppCompatDelegateImplBase(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    this.mContext = paramContext;
    this.mWindow = paramWindow;
    this.mAppCompatCallback = paramAppCompatCallback;
    this.mOriginalWindowCallback = this.mWindow.getCallback();
    if ((this.mOriginalWindowCallback instanceof AppCompatWindowCallbackBase))
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    this.mAppCompatWindowCallback = wrapWindowCallback(this.mOriginalWindowCallback);
    this.mWindow.setCallback(this.mAppCompatWindowCallback);
  }

  public boolean applyDayNight()
  {
    return false;
  }

  abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);

  final Context getActionBarThemedContext()
  {
    Context localContext = null;
    Object localObject = getSupportActionBar();
    if (localObject != null)
      localContext = ((ActionBar)localObject).getThemedContext();
    localObject = localContext;
    if (localContext == null)
      localObject = this.mContext;
    return (Context)localObject;
  }

  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new ActionBarDrawableToggleImpl(null);
  }

  public MenuInflater getMenuInflater()
  {
    if (this.mMenuInflater == null)
    {
      initWindowDecorActionBar();
      if (this.mActionBar == null)
        break label43;
    }
    label43: for (Context localContext = this.mActionBar.getThemedContext(); ; localContext = this.mContext)
    {
      this.mMenuInflater = new SupportMenuInflater(localContext);
      return this.mMenuInflater;
    }
  }

  public ActionBar getSupportActionBar()
  {
    initWindowDecorActionBar();
    return this.mActionBar;
  }

  final CharSequence getTitle()
  {
    if ((this.mOriginalWindowCallback instanceof Activity))
      return ((Activity)this.mOriginalWindowCallback).getTitle();
    return this.mTitle;
  }

  final Window.Callback getWindowCallback()
  {
    return this.mWindow.getCallback();
  }

  abstract void initWindowDecorActionBar();

  final boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }

  public boolean isHandleNativeActionModesEnabled()
  {
    return false;
  }

  public void onDestroy()
  {
    this.mIsDestroyed = true;
  }

  abstract boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent);

  abstract boolean onMenuOpened(int paramInt, Menu paramMenu);

  abstract void onPanelClosed(int paramInt, Menu paramMenu);

  public void onSaveInstanceState(Bundle paramBundle)
  {
  }

  abstract void onTitleChanged(CharSequence paramCharSequence);

  final ActionBar peekSupportActionBar()
  {
    return this.mActionBar;
  }

  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
  }

  public void setLocalNightMode(int paramInt)
  {
  }

  public final void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    onTitleChanged(paramCharSequence);
  }

  abstract ActionMode startSupportActionModeFromWindow(ActionMode.Callback paramCallback);

  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatWindowCallbackBase(paramCallback);
  }

  private class ActionBarDrawableToggleImpl
    implements ActionBarDrawerToggle.Delegate
  {
    private ActionBarDrawableToggleImpl()
    {
    }

    public Context getActionBarThemedContext()
    {
      return AppCompatDelegateImplBase.this.getActionBarThemedContext();
    }

    public Drawable getThemeUpIndicator()
    {
      TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[] { R.attr.homeAsUpIndicator });
      Drawable localDrawable = localTintTypedArray.getDrawable(0);
      localTintTypedArray.recycle();
      return localDrawable;
    }

    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
      return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
    }

    public void setActionBarDescription(int paramInt)
    {
      ActionBar localActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
      if (localActionBar != null)
        localActionBar.setHomeActionContentDescription(paramInt);
    }

    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
      if (localActionBar != null)
      {
        localActionBar.setHomeAsUpIndicator(paramDrawable);
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }

  class AppCompatWindowCallbackBase extends WindowCallbackWrapper
  {
    AppCompatWindowCallbackBase(Window.Callback arg2)
    {
      super();
    }

    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImplBase.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (AppCompatDelegateImplBase.this.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }

    public void onContentChanged()
    {
    }

    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof MenuBuilder)))
        return false;
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }

    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      AppCompatDelegateImplBase.this.onMenuOpened(paramInt, paramMenu);
      return true;
    }

    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImplBase.this.onPanelClosed(paramInt, paramMenu);
    }

    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      MenuBuilder localMenuBuilder;
      int i;
      if ((paramMenu instanceof MenuBuilder))
      {
        localMenuBuilder = (MenuBuilder)paramMenu;
        if ((paramInt != 0) || (localMenuBuilder != null))
          break label34;
        i = 0;
      }
      label34: boolean bool;
      do
      {
        return i;
        localMenuBuilder = null;
        break;
        if (localMenuBuilder != null)
          localMenuBuilder.setOverrideVisibleItems(true);
        bool = super.onPreparePanel(paramInt, paramView, paramMenu);
        i = bool;
      }
      while (localMenuBuilder == null);
      localMenuBuilder.setOverrideVisibleItems(false);
      return bool;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplBase
 * JD-Core Version:    0.6.0
 */