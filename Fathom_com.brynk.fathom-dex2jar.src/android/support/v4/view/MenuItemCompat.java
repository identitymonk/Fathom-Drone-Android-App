package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class MenuItemCompat
{
  static final MenuVersionImpl IMPL;
  public static final int SHOW_AS_ACTION_ALWAYS = 2;
  public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
  public static final int SHOW_AS_ACTION_IF_ROOM = 1;
  public static final int SHOW_AS_ACTION_NEVER = 0;
  public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
  private static final String TAG = "MenuItemCompat";

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      IMPL = new IcsMenuVersionImpl();
      return;
    }
    if (i >= 11)
    {
      IMPL = new HoneycombMenuVersionImpl();
      return;
    }
    IMPL = new BaseMenuVersionImpl();
  }

  public static boolean collapseActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).collapseActionView();
    return IMPL.collapseActionView(paramMenuItem);
  }

  public static boolean expandActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).expandActionView();
    return IMPL.expandActionView(paramMenuItem);
  }

  public static ActionProvider getActionProvider(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).getSupportActionProvider();
    Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
    return null;
  }

  public static View getActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).getActionView();
    return IMPL.getActionView(paramMenuItem);
  }

  public static boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).isActionViewExpanded();
    return IMPL.isActionViewExpanded(paramMenuItem);
  }

  public static MenuItem setActionProvider(MenuItem paramMenuItem, ActionProvider paramActionProvider)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setSupportActionProvider(paramActionProvider);
    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    return paramMenuItem;
  }

  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setActionView(paramInt);
    return IMPL.setActionView(paramMenuItem, paramInt);
  }

  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setActionView(paramView);
    return IMPL.setActionView(paramMenuItem, paramView);
  }

  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, OnActionExpandListener paramOnActionExpandListener)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setSupportOnActionExpandListener(paramOnActionExpandListener);
    return IMPL.setOnActionExpandListener(paramMenuItem, paramOnActionExpandListener);
  }

  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setShowAsAction(paramInt);
      return;
    }
    IMPL.setShowAsAction(paramMenuItem, paramInt);
  }

  static class BaseMenuVersionImpl
    implements MenuItemCompat.MenuVersionImpl
  {
    public boolean collapseActionView(MenuItem paramMenuItem)
    {
      return false;
    }

    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return false;
    }

    public View getActionView(MenuItem paramMenuItem)
    {
      return null;
    }

    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return false;
    }

    public MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
    {
      return paramMenuItem;
    }

    public MenuItem setActionView(MenuItem paramMenuItem, View paramView)
    {
      return paramMenuItem;
    }

    public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      return paramMenuItem;
    }

    public void setShowAsAction(MenuItem paramMenuItem, int paramInt)
    {
    }
  }

  static class HoneycombMenuVersionImpl
    implements MenuItemCompat.MenuVersionImpl
  {
    public boolean collapseActionView(MenuItem paramMenuItem)
    {
      return false;
    }

    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return false;
    }

    public View getActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatHoneycomb.getActionView(paramMenuItem);
    }

    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return false;
    }

    public MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
    {
      return MenuItemCompatHoneycomb.setActionView(paramMenuItem, paramInt);
    }

    public MenuItem setActionView(MenuItem paramMenuItem, View paramView)
    {
      return MenuItemCompatHoneycomb.setActionView(paramMenuItem, paramView);
    }

    public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      return paramMenuItem;
    }

    public void setShowAsAction(MenuItem paramMenuItem, int paramInt)
    {
      MenuItemCompatHoneycomb.setShowAsAction(paramMenuItem, paramInt);
    }
  }

  static class IcsMenuVersionImpl extends MenuItemCompat.HoneycombMenuVersionImpl
  {
    public boolean collapseActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.collapseActionView(paramMenuItem);
    }

    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.expandActionView(paramMenuItem);
    }

    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.isActionViewExpanded(paramMenuItem);
    }

    public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      if (paramOnActionExpandListener == null)
        return MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, null);
      return MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, new MenuItemCompatIcs.SupportActionExpandProxy(paramOnActionExpandListener)
      {
        public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
        {
          return this.val$listener.onMenuItemActionCollapse(paramMenuItem);
        }

        public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
        {
          return this.val$listener.onMenuItemActionExpand(paramMenuItem);
        }
      });
    }
  }

  static abstract interface MenuVersionImpl
  {
    public abstract boolean collapseActionView(MenuItem paramMenuItem);

    public abstract boolean expandActionView(MenuItem paramMenuItem);

    public abstract View getActionView(MenuItem paramMenuItem);

    public abstract boolean isActionViewExpanded(MenuItem paramMenuItem);

    public abstract MenuItem setActionView(MenuItem paramMenuItem, int paramInt);

    public abstract MenuItem setActionView(MenuItem paramMenuItem, View paramView);

    public abstract MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener);

    public abstract void setShowAsAction(MenuItem paramMenuItem, int paramInt);
  }

  public static abstract interface OnActionExpandListener
  {
    public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);

    public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat
 * JD-Core Version:    0.6.0
 */