package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window.Callback;

public abstract interface DecorContentParent
{
  public abstract boolean canShowOverflowMenu();

  public abstract void dismissPopups();

  public abstract CharSequence getTitle();

  public abstract boolean hasIcon();

  public abstract boolean hasLogo();

  public abstract boolean hideOverflowMenu();

  public abstract void initFeature(int paramInt);

  public abstract boolean isOverflowMenuShowPending();

  public abstract boolean isOverflowMenuShowing();

  public abstract void restoreToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray);

  public abstract void saveToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray);

  public abstract void setIcon(int paramInt);

  public abstract void setIcon(Drawable paramDrawable);

  public abstract void setLogo(int paramInt);

  public abstract void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback);

  public abstract void setMenuPrepared();

  public abstract void setUiOptions(int paramInt);

  public abstract void setWindowCallback(Window.Callback paramCallback);

  public abstract void setWindowTitle(CharSequence paramCharSequence);

  public abstract boolean showOverflowMenu();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.DecorContentParent
 * JD-Core Version:    0.6.0
 */