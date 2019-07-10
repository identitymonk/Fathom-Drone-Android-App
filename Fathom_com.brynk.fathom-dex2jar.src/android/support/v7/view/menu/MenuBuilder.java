package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.bool;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder
  implements SupportMenu
{
  private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
  private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
  private static final String PRESENTER_KEY = "android:menu:presenters";
  private static final String TAG = "MenuBuilder";
  private static final int[] sCategoryToOrder = { 1, 4, 5, 3, 2, 0 };
  private ArrayList<MenuItemImpl> mActionItems;
  private Callback mCallback;
  private final Context mContext;
  private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
  private int mDefaultShowAsAction = 0;
  private MenuItemImpl mExpandedItem;
  private SparseArray<Parcelable> mFrozenViewStates;
  Drawable mHeaderIcon;
  CharSequence mHeaderTitle;
  View mHeaderView;
  private boolean mIsActionItemsStale;
  private boolean mIsClosing = false;
  private boolean mIsVisibleItemsStale;
  private ArrayList<MenuItemImpl> mItems;
  private boolean mItemsChangedWhileDispatchPrevented = false;
  private ArrayList<MenuItemImpl> mNonActionItems;
  private boolean mOptionalIconsVisible = false;
  private boolean mOverrideVisibleItems;
  private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList();
  private boolean mPreventDispatchingItemsChanged = false;
  private boolean mQwertyMode;
  private final Resources mResources;
  private boolean mShortcutsVisible;
  private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList();
  private ArrayList<MenuItemImpl> mVisibleItems;

  public MenuBuilder(Context paramContext)
  {
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.mItems = new ArrayList();
    this.mVisibleItems = new ArrayList();
    this.mIsVisibleItemsStale = true;
    this.mActionItems = new ArrayList();
    this.mNonActionItems = new ArrayList();
    this.mIsActionItemsStale = true;
    setShortcutsVisibleInner(true);
  }

  private MenuItemImpl createNewMenuItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    return new MenuItemImpl(this, paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence, paramInt5);
  }

  private void dispatchPresenterUpdate(boolean paramBoolean)
  {
    if (this.mPresenters.isEmpty())
      return;
    stopDispatchingItemsChanged();
    Iterator localIterator = this.mPresenters.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.mPresenters.remove(localWeakReference);
        continue;
      }
      localMenuPresenter.updateMenuView(paramBoolean);
    }
    startDispatchingItemsChanged();
  }

  private void dispatchRestoreInstanceState(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if ((paramBundle == null) || (this.mPresenters.isEmpty()));
    while (true)
    {
      return;
      Iterator localIterator = this.mPresenters.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        MenuPresenter localMenuPresenter = (MenuPresenter)((WeakReference)localObject).get();
        if (localMenuPresenter == null)
        {
          this.mPresenters.remove(localObject);
          continue;
        }
        int i = localMenuPresenter.getId();
        if (i <= 0)
          continue;
        localObject = (Parcelable)paramBundle.get(i);
        if (localObject == null)
          continue;
        localMenuPresenter.onRestoreInstanceState((Parcelable)localObject);
      }
    }
  }

  private void dispatchSaveInstanceState(Bundle paramBundle)
  {
    if (this.mPresenters.isEmpty())
      return;
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = this.mPresenters.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)((WeakReference)localObject).get();
      if (localMenuPresenter == null)
      {
        this.mPresenters.remove(localObject);
        continue;
      }
      int i = localMenuPresenter.getId();
      if (i <= 0)
        continue;
      localObject = localMenuPresenter.onSaveInstanceState();
      if (localObject == null)
        continue;
      localSparseArray.put(i, localObject);
    }
    paramBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
  }

  private boolean dispatchSubMenuSelected(SubMenuBuilder paramSubMenuBuilder, MenuPresenter paramMenuPresenter)
  {
    int i;
    if (this.mPresenters.isEmpty())
    {
      i = 0;
      return i;
    }
    boolean bool = false;
    if (paramMenuPresenter != null)
      bool = paramMenuPresenter.onSubMenuSelected(paramSubMenuBuilder);
    paramMenuPresenter = this.mPresenters.iterator();
    while (true)
    {
      i = bool;
      if (!paramMenuPresenter.hasNext())
        break;
      WeakReference localWeakReference = (WeakReference)paramMenuPresenter.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.mPresenters.remove(localWeakReference);
        continue;
      }
      if (bool)
        continue;
      bool = localMenuPresenter.onSubMenuSelected(paramSubMenuBuilder);
    }
  }

  private static int findInsertIndex(ArrayList<MenuItemImpl> paramArrayList, int paramInt)
  {
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (((MenuItemImpl)paramArrayList.get(i)).getOrdering() <= paramInt)
        return i + 1;
      i -= 1;
    }
    return 0;
  }

  private static int getOrdering(int paramInt)
  {
    int i = (0xFFFF0000 & paramInt) >> 16;
    if ((i < 0) || (i >= sCategoryToOrder.length))
      throw new IllegalArgumentException("order does not contain a valid category.");
    return sCategoryToOrder[i] << 16 | 0xFFFF & paramInt;
  }

  private void removeItemAtInt(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.mItems.size()));
    do
    {
      return;
      this.mItems.remove(paramInt);
    }
    while (!paramBoolean);
    onItemsChanged(true);
  }

  private void setHeaderInternal(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = getResources();
    if (paramView != null)
    {
      this.mHeaderView = paramView;
      this.mHeaderTitle = null;
      this.mHeaderIcon = null;
      onItemsChanged(false);
      return;
    }
    if (paramInt1 > 0)
    {
      this.mHeaderTitle = localResources.getText(paramInt1);
      label47: if (paramInt2 <= 0)
        break label83;
      this.mHeaderIcon = ContextCompat.getDrawable(getContext(), paramInt2);
    }
    while (true)
    {
      this.mHeaderView = null;
      break;
      if (paramCharSequence == null)
        break label47;
      this.mHeaderTitle = paramCharSequence;
      break label47;
      label83: if (paramDrawable == null)
        continue;
      this.mHeaderIcon = paramDrawable;
    }
  }

  private void setShortcutsVisibleInner(boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBoolean) && (this.mResources.getConfiguration().keyboard != 1) && (this.mResources.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent)));
    for (paramBoolean = bool; ; paramBoolean = false)
    {
      this.mShortcutsVisible = paramBoolean;
      return;
    }
  }

  public MenuItem add(int paramInt)
  {
    return addInternal(0, 0, 0, this.mResources.getString(paramInt));
  }

  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addInternal(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
  }

  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }

  public MenuItem add(CharSequence paramCharSequence)
  {
    return addInternal(0, 0, 0, paramCharSequence);
  }

  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i;
    label52: ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i = localList.size();
      if ((paramInt4 & 0x1) == 0)
        removeGroup(paramInt1);
      paramInt4 = 0;
      if (paramInt4 >= i)
        break label214;
      localResolveInfo = (ResolveInfo)localList.get(paramInt4);
      if (localResolveInfo.specificIndex >= 0)
        break label201;
    }
    label201: for (paramComponentName = paramIntent; ; paramComponentName = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0))
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = paramComponentName;
      paramInt4 += 1;
      break label52;
      i = 0;
      break;
    }
    label214: return i;
  }

  protected MenuItem addInternal(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i = getOrdering(paramInt3);
    paramCharSequence = createNewMenuItem(paramInt1, paramInt2, paramInt3, i, paramCharSequence, this.mDefaultShowAsAction);
    if (this.mCurrentMenuInfo != null)
      paramCharSequence.setMenuInfo(this.mCurrentMenuInfo);
    this.mItems.add(findInsertIndex(this.mItems, i), paramCharSequence);
    onItemsChanged(true);
    return paramCharSequence;
  }

  public void addMenuPresenter(MenuPresenter paramMenuPresenter)
  {
    addMenuPresenter(paramMenuPresenter, this.mContext);
  }

  public void addMenuPresenter(MenuPresenter paramMenuPresenter, Context paramContext)
  {
    this.mPresenters.add(new WeakReference(paramMenuPresenter));
    paramMenuPresenter.initForMenu(paramContext, this);
    this.mIsActionItemsStale = true;
  }

  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.mResources.getString(paramInt));
  }

  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
  }

  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (MenuItemImpl)addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
    SubMenuBuilder localSubMenuBuilder = new SubMenuBuilder(this.mContext, this, paramCharSequence);
    paramCharSequence.setSubMenu(localSubMenuBuilder);
    return localSubMenuBuilder;
  }

  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }

  public void changeMenuMode()
  {
    if (this.mCallback != null)
      this.mCallback.onMenuModeChange(this);
  }

  public void clear()
  {
    if (this.mExpandedItem != null)
      collapseItemActionView(this.mExpandedItem);
    this.mItems.clear();
    onItemsChanged(true);
  }

  public void clearAll()
  {
    this.mPreventDispatchingItemsChanged = true;
    clear();
    clearHeader();
    this.mPreventDispatchingItemsChanged = false;
    this.mItemsChangedWhileDispatchPrevented = false;
    onItemsChanged(true);
  }

  public void clearHeader()
  {
    this.mHeaderIcon = null;
    this.mHeaderTitle = null;
    this.mHeaderView = null;
    onItemsChanged(false);
  }

  public void close()
  {
    close(true);
  }

  public final void close(boolean paramBoolean)
  {
    if (this.mIsClosing)
      return;
    this.mIsClosing = true;
    Iterator localIterator = this.mPresenters.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.mPresenters.remove(localWeakReference);
        continue;
      }
      localMenuPresenter.onCloseMenu(this, paramBoolean);
    }
    this.mIsClosing = false;
  }

  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool1;
    if ((this.mPresenters.isEmpty()) || (this.mExpandedItem != paramMenuItemImpl))
      bool1 = false;
    boolean bool2;
    label105: 
    do
    {
      return bool1;
      bool1 = false;
      stopDispatchingItemsChanged();
      Iterator localIterator = this.mPresenters.iterator();
      do
      {
        MenuPresenter localMenuPresenter;
        while (true)
        {
          bool2 = bool1;
          if (!localIterator.hasNext())
            break label105;
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          localMenuPresenter = (MenuPresenter)localWeakReference.get();
          if (localMenuPresenter != null)
            break;
          this.mPresenters.remove(localWeakReference);
        }
        bool2 = localMenuPresenter.collapseItemActionView(this, paramMenuItemImpl);
        bool1 = bool2;
      }
      while (!bool2);
      startDispatchingItemsChanged();
      bool1 = bool2;
    }
    while (!bool2);
    this.mExpandedItem = null;
    return bool2;
  }

  boolean dispatchMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (this.mCallback != null) && (this.mCallback.onMenuItemSelected(paramMenuBuilder, paramMenuItem));
  }

  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool1;
    if (this.mPresenters.isEmpty())
      bool1 = false;
    boolean bool2;
    label97: 
    do
    {
      return bool1;
      bool1 = false;
      stopDispatchingItemsChanged();
      Iterator localIterator = this.mPresenters.iterator();
      do
      {
        MenuPresenter localMenuPresenter;
        while (true)
        {
          bool2 = bool1;
          if (!localIterator.hasNext())
            break label97;
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          localMenuPresenter = (MenuPresenter)localWeakReference.get();
          if (localMenuPresenter != null)
            break;
          this.mPresenters.remove(localWeakReference);
        }
        bool2 = localMenuPresenter.expandItemActionView(this, paramMenuItemImpl);
        bool1 = bool2;
      }
      while (!bool2);
      startDispatchingItemsChanged();
      bool1 = bool2;
    }
    while (!bool2);
    this.mExpandedItem = paramMenuItemImpl;
    return bool2;
  }

  public int findGroupIndex(int paramInt)
  {
    return findGroupIndex(paramInt, 0);
  }

  public int findGroupIndex(int paramInt1, int paramInt2)
  {
    int j = size();
    int i = paramInt2;
    if (paramInt2 < 0)
      i = 0;
    while (i < j)
    {
      if (((MenuItemImpl)this.mItems.get(i)).getGroupId() == paramInt1)
        return i;
      i += 1;
    }
    return -1;
  }

  public MenuItem findItem(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (MenuItemImpl)this.mItems.get(i);
      if (((MenuItemImpl)localObject).getItemId() == paramInt)
        return localObject;
      if (((MenuItemImpl)localObject).hasSubMenu())
      {
        localObject = ((MenuItemImpl)localObject).getSubMenu().findItem(paramInt);
        if (localObject != null)
          return localObject;
      }
      i += 1;
    }
    return (MenuItem)null;
  }

  public int findItemIndex(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (((MenuItemImpl)this.mItems.get(i)).getItemId() == paramInt)
        return i;
      i += 1;
    }
    return -1;
  }

  MenuItemImpl findItemWithShortcutForKey(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.mTempShortcutItemList;
    localArrayList.clear();
    findItemsWithShortcutForKey(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty());
    while (true)
    {
      return null;
      int k = paramKeyEvent.getMetaState();
      KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
      paramKeyEvent.getKeyData(localKeyData);
      int m = localArrayList.size();
      if (m == 1)
        return (MenuItemImpl)localArrayList.get(0);
      boolean bool = isQwertyMode();
      int i = 0;
      while (i < m)
      {
        paramKeyEvent = (MenuItemImpl)localArrayList.get(i);
        if (bool);
        for (int j = paramKeyEvent.getAlphabeticShortcut(); ((j == localKeyData.meta[0]) && ((k & 0x2) == 0)) || ((j == localKeyData.meta[2]) && ((k & 0x2) != 0)) || ((bool) && (j == 8) && (paramInt == 67)); j = paramKeyEvent.getNumericShortcut())
          return paramKeyEvent;
        i += 1;
      }
    }
  }

  void findItemsWithShortcutForKey(List<MenuItemImpl> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = isQwertyMode();
    int k = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67))
      return;
    int m = this.mItems.size();
    int i = 0;
    label49: MenuItemImpl localMenuItemImpl;
    if (i < m)
    {
      localMenuItemImpl = (MenuItemImpl)this.mItems.get(i);
      if (localMenuItemImpl.hasSubMenu())
        ((MenuBuilder)localMenuItemImpl.getSubMenu()).findItemsWithShortcutForKey(paramList, paramInt, paramKeyEvent);
      if (!bool)
        break label184;
    }
    label184: for (int j = localMenuItemImpl.getAlphabeticShortcut(); ; j = localMenuItemImpl.getNumericShortcut())
    {
      if (((k & 0x5) == 0) && (j != 0) && ((j == localKeyData.meta[0]) || (j == localKeyData.meta[2]) || ((bool) && (j == 8) && (paramInt == 67))) && (localMenuItemImpl.isEnabled()))
        paramList.add(localMenuItemImpl);
      i += 1;
      break label49;
      break;
    }
  }

  public void flagActionItems()
  {
    ArrayList localArrayList = getVisibleItems();
    if (!this.mIsActionItemsStale)
      return;
    int i = 0;
    Object localObject = this.mPresenters.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.mPresenters.remove(localWeakReference);
        continue;
      }
      i |= localMenuPresenter.flagActionItems();
    }
    if (i != 0)
    {
      this.mActionItems.clear();
      this.mNonActionItems.clear();
      int k = localArrayList.size();
      i = 0;
      if (i < k)
      {
        localObject = (MenuItemImpl)localArrayList.get(i);
        if (((MenuItemImpl)localObject).isActionButton())
          this.mActionItems.add(localObject);
        while (true)
        {
          int j;
          i += 1;
          break;
          this.mNonActionItems.add(localObject);
        }
      }
    }
    else
    {
      this.mActionItems.clear();
      this.mNonActionItems.clear();
      this.mNonActionItems.addAll(getVisibleItems());
    }
    this.mIsActionItemsStale = false;
  }

  public ArrayList<MenuItemImpl> getActionItems()
  {
    flagActionItems();
    return this.mActionItems;
  }

  protected String getActionViewStatesKey()
  {
    return "android:menu:actionviewstates";
  }

  public Context getContext()
  {
    return this.mContext;
  }

  public MenuItemImpl getExpandedItem()
  {
    return this.mExpandedItem;
  }

  public Drawable getHeaderIcon()
  {
    return this.mHeaderIcon;
  }

  public CharSequence getHeaderTitle()
  {
    return this.mHeaderTitle;
  }

  public View getHeaderView()
  {
    return this.mHeaderView;
  }

  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.mItems.get(paramInt);
  }

  public ArrayList<MenuItemImpl> getNonActionItems()
  {
    flagActionItems();
    return this.mNonActionItems;
  }

  boolean getOptionalIconsVisible()
  {
    return this.mOptionalIconsVisible;
  }

  Resources getResources()
  {
    return this.mResources;
  }

  public MenuBuilder getRootMenu()
  {
    return this;
  }

  public ArrayList<MenuItemImpl> getVisibleItems()
  {
    if (!this.mIsVisibleItemsStale)
      return this.mVisibleItems;
    this.mVisibleItems.clear();
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(i);
      if (localMenuItemImpl.isVisible())
        this.mVisibleItems.add(localMenuItemImpl);
      i += 1;
    }
    this.mIsVisibleItemsStale = false;
    this.mIsActionItemsStale = true;
    return this.mVisibleItems;
  }

  public boolean hasVisibleItems()
  {
    if (this.mOverrideVisibleItems)
      return true;
    int j = size();
    int i = 0;
    while (true)
    {
      if (i >= j)
        break label45;
      if (((MenuItemImpl)this.mItems.get(i)).isVisible())
        break;
      i += 1;
    }
    label45: return false;
  }

  boolean isQwertyMode()
  {
    return this.mQwertyMode;
  }

  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return findItemWithShortcutForKey(paramInt, paramKeyEvent) != null;
  }

  public boolean isShortcutsVisible()
  {
    return this.mShortcutsVisible;
  }

  void onItemActionRequestChanged(MenuItemImpl paramMenuItemImpl)
  {
    this.mIsActionItemsStale = true;
    onItemsChanged(true);
  }

  void onItemVisibleChanged(MenuItemImpl paramMenuItemImpl)
  {
    this.mIsVisibleItemsStale = true;
    onItemsChanged(true);
  }

  public void onItemsChanged(boolean paramBoolean)
  {
    if (!this.mPreventDispatchingItemsChanged)
    {
      if (paramBoolean)
      {
        this.mIsVisibleItemsStale = true;
        this.mIsActionItemsStale = true;
      }
      dispatchPresenterUpdate(paramBoolean);
      return;
    }
    this.mItemsChangedWhileDispatchPrevented = true;
  }

  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return performItemAction(findItem(paramInt1), paramInt2);
  }

  public boolean performItemAction(MenuItem paramMenuItem, int paramInt)
  {
    return performItemAction(paramMenuItem, null, paramInt);
  }

  public boolean performItemAction(MenuItem paramMenuItem, MenuPresenter paramMenuPresenter, int paramInt)
  {
    Object localObject = (MenuItemImpl)paramMenuItem;
    int j;
    if ((localObject == null) || (!((MenuItemImpl)localObject).isEnabled()))
      j = 0;
    boolean bool;
    label93: 
    do
    {
      while (true)
      {
        return j;
        bool = ((MenuItemImpl)localObject).invoke();
        paramMenuItem = ((MenuItemImpl)localObject).getSupportActionProvider();
        if ((paramMenuItem != null) && (paramMenuItem.hasSubMenu()));
        for (int i = 1; ; i = 0)
        {
          if (!((MenuItemImpl)localObject).hasCollapsibleActionView())
            break label93;
          bool |= ((MenuItemImpl)localObject).expandActionView();
          j = bool;
          if (!bool)
            break;
          close(true);
          return bool;
        }
        if ((!((MenuItemImpl)localObject).hasSubMenu()) && (i == 0))
          break;
        close(false);
        if (!((MenuItemImpl)localObject).hasSubMenu())
          ((MenuItemImpl)localObject).setSubMenu(new SubMenuBuilder(getContext(), this, (MenuItemImpl)localObject));
        localObject = (SubMenuBuilder)((MenuItemImpl)localObject).getSubMenu();
        if (i != 0)
          paramMenuItem.onPrepareSubMenu((SubMenu)localObject);
        bool |= dispatchSubMenuSelected((SubMenuBuilder)localObject, paramMenuPresenter);
        j = bool;
        if (bool)
          continue;
        close(true);
        return bool;
      }
      j = bool;
    }
    while ((paramInt & 0x1) != 0);
    close(true);
    return bool;
  }

  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = findItemWithShortcutForKey(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (paramKeyEvent != null)
      bool = performItemAction(paramKeyEvent, paramInt2);
    if ((paramInt2 & 0x2) != 0)
      close(true);
    return bool;
  }

  public void removeGroup(int paramInt)
  {
    int j = findGroupIndex(paramInt);
    if (j >= 0)
    {
      int k = this.mItems.size();
      int i = 0;
      while ((i < k - j) && (((MenuItemImpl)this.mItems.get(j)).getGroupId() == paramInt))
      {
        removeItemAtInt(j, false);
        i += 1;
      }
      onItemsChanged(true);
    }
  }

  public void removeItem(int paramInt)
  {
    removeItemAtInt(findItemIndex(paramInt), true);
  }

  public void removeItemAt(int paramInt)
  {
    removeItemAtInt(paramInt, true);
  }

  public void removeMenuPresenter(MenuPresenter paramMenuPresenter)
  {
    Iterator localIterator = this.mPresenters.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if ((localMenuPresenter != null) && (localMenuPresenter != paramMenuPresenter))
        continue;
      this.mPresenters.remove(localWeakReference);
    }
  }

  public void restoreActionViewStates(Bundle paramBundle)
  {
    if (paramBundle == null);
    do
    {
      int i;
      do
      {
        return;
        SparseArray localSparseArray = paramBundle.getSparseParcelableArray(getActionViewStatesKey());
        int j = size();
        i = 0;
        while (i < j)
        {
          MenuItem localMenuItem = getItem(i);
          View localView = MenuItemCompat.getActionView(localMenuItem);
          if ((localView != null) && (localView.getId() != -1))
            localView.restoreHierarchyState(localSparseArray);
          if (localMenuItem.hasSubMenu())
            ((SubMenuBuilder)localMenuItem.getSubMenu()).restoreActionViewStates(paramBundle);
          i += 1;
        }
        i = paramBundle.getInt("android:menu:expandedactionview");
      }
      while (i <= 0);
      paramBundle = findItem(i);
    }
    while (paramBundle == null);
    MenuItemCompat.expandActionView(paramBundle);
  }

  public void restorePresenterStates(Bundle paramBundle)
  {
    dispatchRestoreInstanceState(paramBundle);
  }

  public void saveActionViewStates(Bundle paramBundle)
  {
    Object localObject1 = null;
    int j = size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = getItem(i);
      View localView = MenuItemCompat.getActionView(localMenuItem);
      Object localObject3 = localObject1;
      if (localView != null)
      {
        localObject3 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null)
            localObject2 = new SparseArray();
          localView.saveHierarchyState((SparseArray)localObject2);
          localObject3 = localObject2;
          if (MenuItemCompat.isActionViewExpanded(localMenuItem))
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject3 = localObject2;
          }
        }
      }
      if (localMenuItem.hasSubMenu())
        ((SubMenuBuilder)localMenuItem.getSubMenu()).saveActionViewStates(paramBundle);
      i += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null)
      paramBundle.putSparseParcelableArray(getActionViewStatesKey(), localObject1);
  }

  public void savePresenterStates(Bundle paramBundle)
  {
    dispatchSaveInstanceState(paramBundle);
  }

  public void setCallback(Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }

  public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.mCurrentMenuInfo = paramContextMenuInfo;
  }

  public MenuBuilder setDefaultShowAsAction(int paramInt)
  {
    this.mDefaultShowAsAction = paramInt;
    return this;
  }

  void setExclusiveItemChecked(MenuItem paramMenuItem)
  {
    int j = paramMenuItem.getGroupId();
    int k = this.mItems.size();
    int i = 0;
    if (i < k)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(i);
      if ((localMenuItemImpl.getGroupId() != j) || (!localMenuItemImpl.isExclusiveCheckable()));
      do
      {
        i += 1;
        break;
      }
      while (!localMenuItemImpl.isCheckable());
      if (localMenuItemImpl == paramMenuItem);
      for (boolean bool = true; ; bool = false)
      {
        localMenuItemImpl.setCheckedInt(bool);
        break;
      }
    }
  }

  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(i);
      if (localMenuItemImpl.getGroupId() == paramInt)
      {
        localMenuItemImpl.setExclusiveCheckable(paramBoolean2);
        localMenuItemImpl.setCheckable(paramBoolean1);
      }
      i += 1;
    }
  }

  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(i);
      if (localMenuItemImpl.getGroupId() == paramInt)
        localMenuItemImpl.setEnabled(paramBoolean);
      i += 1;
    }
  }

  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int m = this.mItems.size();
    int j = 0;
    int i = 0;
    while (i < m)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(i);
      int k = j;
      if (localMenuItemImpl.getGroupId() == paramInt)
      {
        k = j;
        if (localMenuItemImpl.setVisibleInt(paramBoolean))
          k = 1;
      }
      i += 1;
      j = k;
    }
    if (j != 0)
      onItemsChanged(true);
  }

  protected MenuBuilder setHeaderIconInt(int paramInt)
  {
    setHeaderInternal(0, null, paramInt, null, null);
    return this;
  }

  protected MenuBuilder setHeaderIconInt(Drawable paramDrawable)
  {
    setHeaderInternal(0, null, 0, paramDrawable, null);
    return this;
  }

  protected MenuBuilder setHeaderTitleInt(int paramInt)
  {
    setHeaderInternal(paramInt, null, 0, null, null);
    return this;
  }

  protected MenuBuilder setHeaderTitleInt(CharSequence paramCharSequence)
  {
    setHeaderInternal(0, paramCharSequence, 0, null, null);
    return this;
  }

  protected MenuBuilder setHeaderViewInt(View paramView)
  {
    setHeaderInternal(0, null, 0, null, paramView);
    return this;
  }

  void setOptionalIconsVisible(boolean paramBoolean)
  {
    this.mOptionalIconsVisible = paramBoolean;
  }

  public void setOverrideVisibleItems(boolean paramBoolean)
  {
    this.mOverrideVisibleItems = paramBoolean;
  }

  public void setQwertyMode(boolean paramBoolean)
  {
    this.mQwertyMode = paramBoolean;
    onItemsChanged(false);
  }

  public void setShortcutsVisible(boolean paramBoolean)
  {
    if (this.mShortcutsVisible == paramBoolean)
      return;
    setShortcutsVisibleInner(paramBoolean);
    onItemsChanged(false);
  }

  public int size()
  {
    return this.mItems.size();
  }

  public void startDispatchingItemsChanged()
  {
    this.mPreventDispatchingItemsChanged = false;
    if (this.mItemsChangedWhileDispatchPrevented)
    {
      this.mItemsChangedWhileDispatchPrevented = false;
      onItemsChanged(true);
    }
  }

  public void stopDispatchingItemsChanged()
  {
    if (!this.mPreventDispatchingItemsChanged)
    {
      this.mPreventDispatchingItemsChanged = true;
      this.mItemsChangedWhileDispatchPrevented = false;
    }
  }

  public static abstract interface Callback
  {
    public abstract boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem);

    public abstract void onMenuModeChange(MenuBuilder paramMenuBuilder);
  }

  public static abstract interface ItemInvoker
  {
    public abstract boolean invokeItem(MenuItemImpl paramMenuItemImpl);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.MenuBuilder
 * JD-Core Version:    0.6.0
 */