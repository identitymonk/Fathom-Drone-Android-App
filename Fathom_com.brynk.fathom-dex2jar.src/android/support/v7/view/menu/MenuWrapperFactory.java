package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class MenuWrapperFactory
{
  public static Menu wrapSupportMenu(Context paramContext, SupportMenu paramSupportMenu)
  {
    if (Build.VERSION.SDK_INT >= 14)
      return new MenuWrapperICS(paramContext, paramSupportMenu);
    throw new UnsupportedOperationException();
  }

  public static MenuItem wrapSupportMenuItem(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return new MenuItemWrapperJB(paramContext, paramSupportMenuItem);
    if (Build.VERSION.SDK_INT >= 14)
      return new MenuItemWrapperICS(paramContext, paramSupportMenuItem);
    throw new UnsupportedOperationException();
  }

  public static SubMenu wrapSupportSubMenu(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    if (Build.VERSION.SDK_INT >= 14)
      return new SubMenuWrapperICS(paramContext, paramSupportSubMenu);
    throw new UnsupportedOperationException();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.MenuWrapperFactory
 * JD-Core Version:    0.6.0
 */