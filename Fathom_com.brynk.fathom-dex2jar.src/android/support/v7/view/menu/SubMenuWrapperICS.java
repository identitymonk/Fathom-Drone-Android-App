package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class SubMenuWrapperICS extends MenuWrapperICS
  implements SubMenu
{
  SubMenuWrapperICS(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    super(paramContext, paramSupportSubMenu);
  }

  public void clearHeader()
  {
    getWrappedObject().clearHeader();
  }

  public MenuItem getItem()
  {
    return getMenuItemWrapper(getWrappedObject().getItem());
  }

  public SupportSubMenu getWrappedObject()
  {
    return (SupportSubMenu)this.mWrappedObject;
  }

  public SubMenu setHeaderIcon(int paramInt)
  {
    getWrappedObject().setHeaderIcon(paramInt);
    return this;
  }

  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    getWrappedObject().setHeaderIcon(paramDrawable);
    return this;
  }

  public SubMenu setHeaderTitle(int paramInt)
  {
    getWrappedObject().setHeaderTitle(paramInt);
    return this;
  }

  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    getWrappedObject().setHeaderTitle(paramCharSequence);
    return this;
  }

  public SubMenu setHeaderView(View paramView)
  {
    getWrappedObject().setHeaderView(paramView);
    return this;
  }

  public SubMenu setIcon(int paramInt)
  {
    getWrappedObject().setIcon(paramInt);
    return this;
  }

  public SubMenu setIcon(Drawable paramDrawable)
  {
    getWrappedObject().setIcon(paramDrawable);
    return this;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.SubMenuWrapperICS
 * JD-Core Version:    0.6.0
 */