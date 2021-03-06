package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.R.dimen;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.widget.AppCompatDrawableManager;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayout extends HorizontalScrollView
{
  private static final int ANIMATION_DURATION = 300;
  private static final int DEFAULT_GAP_TEXT_ICON = 8;
  private static final int DEFAULT_HEIGHT = 48;
  private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
  private static final int FIXED_WRAP_GUTTER_MIN = 16;
  public static final int GRAVITY_CENTER = 1;
  public static final int GRAVITY_FILL = 0;
  private static final int INVALID_WIDTH = -1;
  public static final int MODE_FIXED = 1;
  public static final int MODE_SCROLLABLE = 0;
  private static final int MOTION_NON_ADJACENT_OFFSET = 24;
  private static final int TAB_MIN_WIDTH_MARGIN = 56;
  private static final Pools.Pool<Tab> sTabPool = new Pools.SynchronizedPool(16);
  private int mContentInsetStart;
  private int mMode;
  private OnTabSelectedListener mOnTabSelectedListener;
  private TabLayoutOnPageChangeListener mPageChangeListener;
  private PagerAdapter mPagerAdapter;
  private DataSetObserver mPagerAdapterObserver;
  private final int mRequestedTabMaxWidth;
  private final int mRequestedTabMinWidth;
  private ValueAnimatorCompat mScrollAnimator;
  private final int mScrollableTabMinWidth;
  private Tab mSelectedTab;
  private final int mTabBackgroundResId;
  private int mTabGravity;
  private int mTabMaxWidth = 2147483647;
  private int mTabPaddingBottom;
  private int mTabPaddingEnd;
  private int mTabPaddingStart;
  private int mTabPaddingTop;
  private final SlidingTabStrip mTabStrip;
  private int mTabTextAppearance;
  private ColorStateList mTabTextColors;
  private float mTabTextMultiLineSize;
  private float mTabTextSize;
  private final Pools.Pool<TabView> mTabViewPool = new Pools.SimplePool(12);
  private final ArrayList<Tab> mTabs = new ArrayList();
  private ViewPager mViewPager;

  public TabLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(paramContext);
    setHorizontalScrollBarEnabled(false);
    this.mTabStrip = new SlidingTabStrip(paramContext);
    super.addView(this.mTabStrip, 0, new FrameLayout.LayoutParams(-2, -1));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TabLayout, paramInt, R.style.Widget_Design_TabLayout);
    this.mTabStrip.setSelectedIndicatorHeight(paramAttributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
    this.mTabStrip.setSelectedIndicatorColor(paramAttributeSet.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
    paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
    this.mTabPaddingBottom = paramInt;
    this.mTabPaddingEnd = paramInt;
    this.mTabPaddingTop = paramInt;
    this.mTabPaddingStart = paramInt;
    this.mTabPaddingStart = paramAttributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.mTabPaddingStart);
    this.mTabPaddingTop = paramAttributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
    this.mTabPaddingEnd = paramAttributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
    this.mTabPaddingBottom = paramAttributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
    this.mTabTextAppearance = paramAttributeSet.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
    paramContext = paramContext.obtainStyledAttributes(this.mTabTextAppearance, R.styleable.TextAppearance);
    try
    {
      this.mTabTextSize = paramContext.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
      this.mTabTextColors = paramContext.getColorStateList(R.styleable.TextAppearance_android_textColor);
      paramContext.recycle();
      if (paramAttributeSet.hasValue(R.styleable.TabLayout_tabTextColor))
        this.mTabTextColors = paramAttributeSet.getColorStateList(R.styleable.TabLayout_tabTextColor);
      if (paramAttributeSet.hasValue(R.styleable.TabLayout_tabSelectedTextColor))
      {
        paramInt = paramAttributeSet.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0);
        this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), paramInt);
      }
      this.mRequestedTabMinWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
      this.mRequestedTabMaxWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
      this.mTabBackgroundResId = paramAttributeSet.getResourceId(R.styleable.TabLayout_tabBackground, 0);
      this.mContentInsetStart = paramAttributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
      this.mMode = paramAttributeSet.getInt(R.styleable.TabLayout_tabMode, 1);
      this.mTabGravity = paramAttributeSet.getInt(R.styleable.TabLayout_tabGravity, 0);
      paramAttributeSet.recycle();
      paramContext = getResources();
      this.mTabTextMultiLineSize = paramContext.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
      this.mScrollableTabMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
      applyModeAndGravity();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
    throw paramAttributeSet;
  }

  private void addTabFromItemView(@NonNull TabItem paramTabItem)
  {
    Tab localTab = newTab();
    if (paramTabItem.mText != null)
      localTab.setText(paramTabItem.mText);
    if (paramTabItem.mIcon != null)
      localTab.setIcon(paramTabItem.mIcon);
    if (paramTabItem.mCustomLayout != 0)
      localTab.setCustomView(paramTabItem.mCustomLayout);
    addTab(localTab);
  }

  private void addTabView(Tab paramTab, int paramInt, boolean paramBoolean)
  {
    paramTab = paramTab.mView;
    this.mTabStrip.addView(paramTab, paramInt, createLayoutParamsForTabs());
    if (paramBoolean)
      paramTab.setSelected(true);
  }

  private void addTabView(Tab paramTab, boolean paramBoolean)
  {
    paramTab = paramTab.mView;
    this.mTabStrip.addView(paramTab, createLayoutParamsForTabs());
    if (paramBoolean)
      paramTab.setSelected(true);
  }

  private void addViewInternal(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      addTabFromItemView((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }

  private void animateToTab(int paramInt)
  {
    if (paramInt == -1)
      return;
    if ((getWindowToken() == null) || (!ViewCompat.isLaidOut(this)) || (this.mTabStrip.childrenNeedLayout()))
    {
      setScrollPosition(paramInt, 0.0F, true);
      return;
    }
    int i = getScrollX();
    int j = calculateScrollXForTab(paramInt, 0.0F);
    if (i != j)
    {
      if (this.mScrollAnimator == null)
      {
        this.mScrollAnimator = ViewUtils.createAnimator();
        this.mScrollAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.mScrollAnimator.setDuration(300);
        this.mScrollAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
          {
            TabLayout.this.scrollTo(paramValueAnimatorCompat.getAnimatedIntValue(), 0);
          }
        });
      }
      this.mScrollAnimator.setIntValues(i, j);
      this.mScrollAnimator.start();
    }
    this.mTabStrip.animateIndicatorToPosition(paramInt, 300);
  }

  private void applyModeAndGravity()
  {
    int i = 0;
    if (this.mMode == 0)
      i = Math.max(0, this.mContentInsetStart - this.mTabPaddingStart);
    ViewCompat.setPaddingRelative(this.mTabStrip, i, 0, 0, 0);
    switch (this.mMode)
    {
    default:
    case 1:
    case 0:
    }
    while (true)
    {
      updateTabViews(true);
      return;
      this.mTabStrip.setGravity(1);
      continue;
      this.mTabStrip.setGravity(8388611);
    }
  }

  private int calculateScrollXForTab(int paramInt, float paramFloat)
  {
    int i = 0;
    int j = 0;
    View localView2;
    View localView1;
    if (this.mMode == 0)
    {
      localView2 = this.mTabStrip.getChildAt(paramInt);
      if (paramInt + 1 >= this.mTabStrip.getChildCount())
        break label107;
      localView1 = this.mTabStrip.getChildAt(paramInt + 1);
      if (localView2 == null)
        break label113;
    }
    label107: label113: for (paramInt = localView2.getWidth(); ; paramInt = 0)
    {
      i = j;
      if (localView1 != null)
        i = localView1.getWidth();
      i = localView2.getLeft() + (int)((paramInt + i) * paramFloat * 0.5F) + localView2.getWidth() / 2 - getWidth() / 2;
      return i;
      localView1 = null;
      break;
    }
  }

  private void configureTab(Tab paramTab, int paramInt)
  {
    paramTab.setPosition(paramInt);
    this.mTabs.add(paramInt, paramTab);
    int i = this.mTabs.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((Tab)this.mTabs.get(paramInt)).setPosition(paramInt);
      paramInt += 1;
    }
  }

  private static ColorStateList createColorStateList(int paramInt1, int paramInt2)
  {
    int[][] arrayOfInt = new int[2][];
    int[] arrayOfInt1 = new int[2];
    arrayOfInt[0] = SELECTED_STATE_SET;
    arrayOfInt1[0] = paramInt2;
    paramInt2 = 0 + 1;
    arrayOfInt[paramInt2] = EMPTY_STATE_SET;
    arrayOfInt1[paramInt2] = paramInt1;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private LinearLayout.LayoutParams createLayoutParamsForTabs()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    updateTabViewLayoutParams(localLayoutParams);
    return localLayoutParams;
  }

  private TabView createTabView(@NonNull Tab paramTab)
  {
    if (this.mTabViewPool != null);
    for (TabView localTabView1 = (TabView)this.mTabViewPool.acquire(); ; localTabView1 = null)
    {
      TabView localTabView2 = localTabView1;
      if (localTabView1 == null)
        localTabView2 = new TabView(getContext());
      localTabView2.setTab(paramTab);
      localTabView2.setFocusable(true);
      localTabView2.setMinimumWidth(getTabMinWidth());
      return localTabView2;
    }
  }

  private int dpToPx(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }

  private int getDefaultHeight()
  {
    int k = 0;
    int i = 0;
    int m = this.mTabs.size();
    while (true)
    {
      int j = k;
      if (i < m)
      {
        Tab localTab = (Tab)this.mTabs.get(i);
        if ((localTab != null) && (localTab.getIcon() != null) && (!TextUtils.isEmpty(localTab.getText())))
          j = 1;
      }
      else
      {
        if (j == 0)
          break;
        return 72;
      }
      i += 1;
    }
    return 48;
  }

  private float getScrollPosition()
  {
    return this.mTabStrip.getIndicatorPosition();
  }

  private int getTabMaxWidth()
  {
    return this.mTabMaxWidth;
  }

  private int getTabMinWidth()
  {
    if (this.mRequestedTabMinWidth != -1)
      return this.mRequestedTabMinWidth;
    if (this.mMode == 0)
      return this.mScrollableTabMinWidth;
    return 0;
  }

  private int getTabScrollRange()
  {
    return Math.max(0, this.mTabStrip.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }

  private void populateFromPagerAdapter()
  {
    removeAllTabs();
    if (this.mPagerAdapter != null)
    {
      int j = this.mPagerAdapter.getCount();
      int i = 0;
      while (i < j)
      {
        addTab(newTab().setText(this.mPagerAdapter.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.mViewPager != null) && (j > 0))
      {
        i = this.mViewPager.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount()))
          selectTab(getTabAt(i));
      }
      return;
    }
    removeAllTabs();
  }

  private void removeTabViewAt(int paramInt)
  {
    TabView localTabView = (TabView)this.mTabStrip.getChildAt(paramInt);
    this.mTabStrip.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.reset();
      this.mTabViewPool.release(localTabView);
    }
    requestLayout();
  }

  private void setPagerAdapter(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    if ((this.mPagerAdapter != null) && (this.mPagerAdapterObserver != null))
      this.mPagerAdapter.unregisterDataSetObserver(this.mPagerAdapterObserver);
    this.mPagerAdapter = paramPagerAdapter;
    if ((paramBoolean) && (paramPagerAdapter != null))
    {
      if (this.mPagerAdapterObserver == null)
        this.mPagerAdapterObserver = new PagerAdapterObserver(null);
      paramPagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
    }
    populateFromPagerAdapter();
  }

  private void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Math.round(paramInt + paramFloat);
    if ((i < 0) || (i >= this.mTabStrip.getChildCount()));
    do
    {
      return;
      if (paramBoolean2)
        this.mTabStrip.setIndicatorPositionFromTabPosition(paramInt, paramFloat);
      if ((this.mScrollAnimator != null) && (this.mScrollAnimator.isRunning()))
        this.mScrollAnimator.cancel();
      scrollTo(calculateScrollXForTab(paramInt, paramFloat), 0);
    }
    while (!paramBoolean1);
    setSelectedTabView(i);
  }

  private void setSelectedTabView(int paramInt)
  {
    int j = this.mTabStrip.getChildCount();
    if ((paramInt < j) && (!this.mTabStrip.getChildAt(paramInt).isSelected()))
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.mTabStrip.getChildAt(i);
        if (i == paramInt);
        for (boolean bool = true; ; bool = false)
        {
          localView.setSelected(bool);
          i += 1;
          break;
        }
      }
    }
  }

  private void updateAllTabs()
  {
    int i = 0;
    int j = this.mTabs.size();
    while (i < j)
    {
      ((Tab)this.mTabs.get(i)).updateView();
      i += 1;
    }
  }

  private void updateTabViewLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mMode == 1) && (this.mTabGravity == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }

  private void updateTabViews(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.mTabStrip.getChildCount())
    {
      View localView = this.mTabStrip.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      updateTabViewLayoutParams((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean)
        localView.requestLayout();
      i += 1;
    }
  }

  public void addTab(@NonNull Tab paramTab)
  {
    addTab(paramTab, this.mTabs.isEmpty());
  }

  public void addTab(@NonNull Tab paramTab, int paramInt)
  {
    addTab(paramTab, paramInt, this.mTabs.isEmpty());
  }

  public void addTab(@NonNull Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (paramTab.mParent != this)
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    addTabView(paramTab, paramInt, paramBoolean);
    configureTab(paramTab, paramInt);
    if (paramBoolean)
      paramTab.select();
  }

  public void addTab(@NonNull Tab paramTab, boolean paramBoolean)
  {
    if (paramTab.mParent != this)
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    addTabView(paramTab, paramBoolean);
    configureTab(paramTab, this.mTabs.size());
    if (paramBoolean)
      paramTab.select();
  }

  public void addView(View paramView)
  {
    addViewInternal(paramView);
  }

  public void addView(View paramView, int paramInt)
  {
    addViewInternal(paramView);
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }

  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }

  public int getSelectedTabPosition()
  {
    if (this.mSelectedTab != null)
      return this.mSelectedTab.getPosition();
    return -1;
  }

  @Nullable
  public Tab getTabAt(int paramInt)
  {
    return (Tab)this.mTabs.get(paramInt);
  }

  public int getTabCount()
  {
    return this.mTabs.size();
  }

  public int getTabGravity()
  {
    return this.mTabGravity;
  }

  public int getTabMode()
  {
    return this.mMode;
  }

  @Nullable
  public ColorStateList getTabTextColors()
  {
    return this.mTabTextColors;
  }

  @NonNull
  public Tab newTab()
  {
    Tab localTab2 = (Tab)sTabPool.acquire();
    Tab localTab1 = localTab2;
    if (localTab2 == null)
      localTab1 = new Tab(null);
    Tab.access$002(localTab1, this);
    Tab.access$202(localTab1, createTabView(localTab1));
    return localTab1;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = dpToPx(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default:
      label48: i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) == 0)
        break;
      if (this.mRequestedTabMaxWidth > 0)
        i = this.mRequestedTabMaxWidth;
    case -2147483648:
    case 0:
    }
    View localView;
    while (true)
    {
      this.mTabMaxWidth = i;
      super.onMeasure(paramInt1, paramInt2);
      if (getChildCount() == 1)
      {
        localView = getChildAt(0);
        paramInt1 = 0;
      }
      switch (this.mMode)
      {
      default:
        if (paramInt1 != 0)
        {
          paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
          localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
        }
        return;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(paramInt2)), 1073741824);
        break label48;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        break label48;
        i -= dpToPx(56);
      case 0:
      case 1:
      }
    }
    if (localView.getMeasuredWidth() < getMeasuredWidth());
    for (paramInt1 = 1; ; paramInt1 = 0)
      break;
    if (localView.getMeasuredWidth() != getMeasuredWidth());
    for (paramInt1 = 1; ; paramInt1 = 0)
      break;
  }

  public void removeAllTabs()
  {
    int i = this.mTabStrip.getChildCount() - 1;
    while (i >= 0)
    {
      removeTabViewAt(i);
      i -= 1;
    }
    Iterator localIterator = this.mTabs.iterator();
    while (localIterator.hasNext())
    {
      Tab localTab = (Tab)localIterator.next();
      localIterator.remove();
      localTab.reset();
      sTabPool.release(localTab);
    }
    this.mSelectedTab = null;
  }

  public void removeTab(Tab paramTab)
  {
    if (paramTab.mParent != this)
      throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    removeTabAt(paramTab.getPosition());
  }

  public void removeTabAt(int paramInt)
  {
    if (this.mSelectedTab != null);
    for (int i = this.mSelectedTab.getPosition(); ; i = 0)
    {
      removeTabViewAt(paramInt);
      localTab = (Tab)this.mTabs.remove(paramInt);
      if (localTab != null)
      {
        localTab.reset();
        sTabPool.release(localTab);
      }
      int k = this.mTabs.size();
      int j = paramInt;
      while (j < k)
      {
        ((Tab)this.mTabs.get(j)).setPosition(j);
        j += 1;
      }
    }
    if (i == paramInt)
      if (!this.mTabs.isEmpty())
        break label123;
    label123: for (Tab localTab = null; ; localTab = (Tab)this.mTabs.get(Math.max(0, paramInt - 1)))
    {
      selectTab(localTab);
      return;
    }
  }

  void selectTab(Tab paramTab)
  {
    selectTab(paramTab, true);
  }

  void selectTab(Tab paramTab, boolean paramBoolean)
  {
    if (this.mSelectedTab == paramTab)
    {
      if (this.mSelectedTab != null)
      {
        if (this.mOnTabSelectedListener != null)
          this.mOnTabSelectedListener.onTabReselected(this.mSelectedTab);
        animateToTab(paramTab.getPosition());
      }
      return;
    }
    int i;
    if (paramBoolean)
    {
      if (paramTab == null)
        break label157;
      i = paramTab.getPosition();
      label57: if (i != -1)
        setSelectedTabView(i);
      if (((this.mSelectedTab != null) && (this.mSelectedTab.getPosition() != -1)) || (i == -1))
        break label162;
      setScrollPosition(i, 0.0F, true);
    }
    while (true)
    {
      if ((this.mSelectedTab != null) && (this.mOnTabSelectedListener != null))
        this.mOnTabSelectedListener.onTabUnselected(this.mSelectedTab);
      this.mSelectedTab = paramTab;
      if ((this.mSelectedTab == null) || (this.mOnTabSelectedListener == null))
        break;
      this.mOnTabSelectedListener.onTabSelected(this.mSelectedTab);
      return;
      label157: i = -1;
      break label57;
      label162: animateToTab(i);
    }
  }

  public void setOnTabSelectedListener(OnTabSelectedListener paramOnTabSelectedListener)
  {
    this.mOnTabSelectedListener = paramOnTabSelectedListener;
  }

  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    setScrollPosition(paramInt, paramFloat, paramBoolean, true);
  }

  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    this.mTabStrip.setSelectedIndicatorColor(paramInt);
  }

  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.mTabStrip.setSelectedIndicatorHeight(paramInt);
  }

  public void setTabGravity(int paramInt)
  {
    if (this.mTabGravity != paramInt)
    {
      this.mTabGravity = paramInt;
      applyModeAndGravity();
    }
  }

  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mMode)
    {
      this.mMode = paramInt;
      applyModeAndGravity();
    }
  }

  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(createColorStateList(paramInt1, paramInt2));
  }

  public void setTabTextColors(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mTabTextColors != paramColorStateList)
    {
      this.mTabTextColors = paramColorStateList;
      updateAllTabs();
    }
  }

  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    setPagerAdapter(paramPagerAdapter, false);
  }

  public void setupWithViewPager(@Nullable ViewPager paramViewPager)
  {
    if ((this.mViewPager != null) && (this.mPageChangeListener != null))
      this.mViewPager.removeOnPageChangeListener(this.mPageChangeListener);
    if (paramViewPager != null)
    {
      PagerAdapter localPagerAdapter = paramViewPager.getAdapter();
      if (localPagerAdapter == null)
        throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
      this.mViewPager = paramViewPager;
      if (this.mPageChangeListener == null)
        this.mPageChangeListener = new TabLayoutOnPageChangeListener(this);
      this.mPageChangeListener.reset();
      paramViewPager.addOnPageChangeListener(this.mPageChangeListener);
      setOnTabSelectedListener(new ViewPagerOnTabSelectedListener(paramViewPager));
      setPagerAdapter(localPagerAdapter, true);
      return;
    }
    this.mViewPager = null;
    setOnTabSelectedListener(null);
    setPagerAdapter(null, true);
  }

  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Mode
  {
  }

  public static abstract interface OnTabSelectedListener
  {
    public abstract void onTabReselected(TabLayout.Tab paramTab);

    public abstract void onTabSelected(TabLayout.Tab paramTab);

    public abstract void onTabUnselected(TabLayout.Tab paramTab);
  }

  private class PagerAdapterObserver extends DataSetObserver
  {
    private PagerAdapterObserver()
    {
    }

    public void onChanged()
    {
      TabLayout.this.populateFromPagerAdapter();
    }

    public void onInvalidated()
    {
      TabLayout.this.populateFromPagerAdapter();
    }
  }

  private class SlidingTabStrip extends LinearLayout
  {
    private ValueAnimatorCompat mIndicatorAnimator;
    private int mIndicatorLeft = -1;
    private int mIndicatorRight = -1;
    private int mSelectedIndicatorHeight;
    private final Paint mSelectedIndicatorPaint;
    private int mSelectedPosition = -1;
    private float mSelectionOffset;

    SlidingTabStrip(Context arg2)
    {
      super();
      setWillNotDraw(false);
      this.mSelectedIndicatorPaint = new Paint();
    }

    private void setIndicatorPosition(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != this.mIndicatorLeft) || (paramInt2 != this.mIndicatorRight))
      {
        this.mIndicatorLeft = paramInt1;
        this.mIndicatorRight = paramInt2;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }

    private void updateIndicatorPosition()
    {
      View localView = getChildAt(this.mSelectedPosition);
      int i;
      int j;
      if ((localView != null) && (localView.getWidth() > 0))
      {
        int m = localView.getLeft();
        int k = localView.getRight();
        i = m;
        j = k;
        if (this.mSelectionOffset > 0.0F)
        {
          i = m;
          j = k;
          if (this.mSelectedPosition < getChildCount() - 1)
          {
            localView = getChildAt(this.mSelectedPosition + 1);
            i = (int)(this.mSelectionOffset * localView.getLeft() + (1.0F - this.mSelectionOffset) * m);
            j = (int)(this.mSelectionOffset * localView.getRight() + (1.0F - this.mSelectionOffset) * k);
          }
        }
      }
      while (true)
      {
        setIndicatorPosition(i, j);
        return;
        j = -1;
        i = -1;
      }
    }

    void animateIndicatorToPosition(int paramInt1, int paramInt2)
    {
      if ((this.mIndicatorAnimator != null) && (this.mIndicatorAnimator.isRunning()))
        this.mIndicatorAnimator.cancel();
      int i;
      Object localObject;
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        i = 1;
        localObject = getChildAt(paramInt1);
        if (localObject != null)
          break label56;
        updateIndicatorPosition();
      }
      while (true)
      {
        return;
        i = 0;
        break;
        label56: int k = ((View)localObject).getLeft();
        int m = ((View)localObject).getRight();
        int j;
        if (Math.abs(paramInt1 - this.mSelectedPosition) <= 1)
        {
          i = this.mIndicatorLeft;
          j = this.mIndicatorRight;
        }
        while ((i != k) || (j != m))
        {
          localObject = ViewUtils.createAnimator();
          this.mIndicatorAnimator = ((ValueAnimatorCompat)localObject);
          ((ValueAnimatorCompat)localObject).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
          ((ValueAnimatorCompat)localObject).setDuration(paramInt2);
          ((ValueAnimatorCompat)localObject).setFloatValues(0.0F, 1.0F);
          ((ValueAnimatorCompat)localObject).setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener(i, k, j, m)
          {
            public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
            {
              float f = paramValueAnimatorCompat.getAnimatedFraction();
              TabLayout.SlidingTabStrip.this.setIndicatorPosition(AnimationUtils.lerp(this.val$startLeft, this.val$targetLeft, f), AnimationUtils.lerp(this.val$startRight, this.val$targetRight, f));
            }
          });
          ((ValueAnimatorCompat)localObject).setListener(new ValueAnimatorCompat.AnimatorListenerAdapter(paramInt1)
          {
            public void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat)
            {
              TabLayout.SlidingTabStrip.access$2502(TabLayout.SlidingTabStrip.this, this.val$position);
              TabLayout.SlidingTabStrip.access$2602(TabLayout.SlidingTabStrip.this, 0.0F);
            }
          });
          ((ValueAnimatorCompat)localObject).start();
          return;
          j = TabLayout.this.dpToPx(24);
          if (paramInt1 < this.mSelectedPosition)
          {
            if (i != 0)
            {
              j = k - j;
              i = j;
              continue;
            }
            j = m + j;
            i = j;
            continue;
          }
          if (i != 0)
          {
            j = m + j;
            i = j;
            continue;
          }
          j = k - j;
          i = j;
        }
      }
    }

    boolean childrenNeedLayout()
    {
      int i = 0;
      int j = getChildCount();
      while (i < j)
      {
        if (getChildAt(i).getWidth() <= 0)
          return true;
        i += 1;
      }
      return false;
    }

    public void draw(Canvas paramCanvas)
    {
      super.draw(paramCanvas);
      if ((this.mIndicatorLeft >= 0) && (this.mIndicatorRight > this.mIndicatorLeft))
        paramCanvas.drawRect(this.mIndicatorLeft, getHeight() - this.mSelectedIndicatorHeight, this.mIndicatorRight, getHeight(), this.mSelectedIndicatorPaint);
    }

    float getIndicatorPosition()
    {
      return this.mSelectedPosition + this.mSelectionOffset;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.mIndicatorAnimator != null) && (this.mIndicatorAnimator.isRunning()))
      {
        this.mIndicatorAnimator.cancel();
        long l = this.mIndicatorAnimator.getDuration();
        animateIndicatorToPosition(this.mSelectedPosition, Math.round((1.0F - this.mIndicatorAnimator.getAnimatedFraction()) * (float)l));
        return;
      }
      updateIndicatorPosition();
    }

    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824);
      int m;
      do
      {
        int n;
        int j;
        Object localObject;
        do
        {
          do
            return;
          while ((TabLayout.this.mMode != 1) || (TabLayout.this.mTabGravity != 1));
          n = getChildCount();
          j = 0;
          i = 0;
          while (i < n)
          {
            localObject = getChildAt(i);
            k = j;
            if (((View)localObject).getVisibility() == 0)
              k = Math.max(j, ((View)localObject).getMeasuredWidth());
            i += 1;
            j = k;
          }
        }
        while (j <= 0);
        int k = TabLayout.this.dpToPx(16);
        int i = 0;
        if (j * n <= getMeasuredWidth() - k * 2)
        {
          k = 0;
          while (true)
          {
            m = i;
            if (k >= n)
              break;
            localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
            if ((((LinearLayout.LayoutParams)localObject).width != j) || (((LinearLayout.LayoutParams)localObject).weight != 0.0F))
            {
              ((LinearLayout.LayoutParams)localObject).width = j;
              ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
              i = 1;
            }
            k += 1;
          }
        }
        TabLayout.access$2202(TabLayout.this, 0);
        TabLayout.this.updateTabViews(false);
        m = 1;
      }
      while (m == 0);
      super.onMeasure(paramInt1, paramInt2);
    }

    void setIndicatorPositionFromTabPosition(int paramInt, float paramFloat)
    {
      if ((this.mIndicatorAnimator != null) && (this.mIndicatorAnimator.isRunning()))
        this.mIndicatorAnimator.cancel();
      this.mSelectedPosition = paramInt;
      this.mSelectionOffset = paramFloat;
      updateIndicatorPosition();
    }

    void setSelectedIndicatorColor(int paramInt)
    {
      if (this.mSelectedIndicatorPaint.getColor() != paramInt)
      {
        this.mSelectedIndicatorPaint.setColor(paramInt);
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }

    void setSelectedIndicatorHeight(int paramInt)
    {
      if (this.mSelectedIndicatorHeight != paramInt)
      {
        this.mSelectedIndicatorHeight = paramInt;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
  }

  public static final class Tab
  {
    public static final int INVALID_POSITION = -1;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private TabLayout mParent;
    private int mPosition = -1;
    private Object mTag;
    private CharSequence mText;
    private TabLayout.TabView mView;

    private void reset()
    {
      this.mParent = null;
      this.mView = null;
      this.mTag = null;
      this.mIcon = null;
      this.mText = null;
      this.mContentDesc = null;
      this.mPosition = -1;
      this.mCustomView = null;
    }

    private void updateView()
    {
      if (this.mView != null)
        this.mView.update();
    }

    @Nullable
    public CharSequence getContentDescription()
    {
      return this.mContentDesc;
    }

    @Nullable
    public View getCustomView()
    {
      return this.mCustomView;
    }

    @Nullable
    public Drawable getIcon()
    {
      return this.mIcon;
    }

    public int getPosition()
    {
      return this.mPosition;
    }

    @Nullable
    public Object getTag()
    {
      return this.mTag;
    }

    @Nullable
    public CharSequence getText()
    {
      return this.mText;
    }

    public boolean isSelected()
    {
      if (this.mParent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      return this.mParent.getSelectedTabPosition() == this.mPosition;
    }

    public void select()
    {
      if (this.mParent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      this.mParent.selectTab(this);
    }

    @NonNull
    public Tab setContentDescription(@StringRes int paramInt)
    {
      if (this.mParent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      return setContentDescription(this.mParent.getResources().getText(paramInt));
    }

    @NonNull
    public Tab setContentDescription(@Nullable CharSequence paramCharSequence)
    {
      this.mContentDesc = paramCharSequence;
      updateView();
      return this;
    }

    @NonNull
    public Tab setCustomView(@LayoutRes int paramInt)
    {
      return setCustomView(LayoutInflater.from(this.mView.getContext()).inflate(paramInt, this.mView, false));
    }

    @NonNull
    public Tab setCustomView(@Nullable View paramView)
    {
      this.mCustomView = paramView;
      updateView();
      return this;
    }

    @NonNull
    public Tab setIcon(@DrawableRes int paramInt)
    {
      if (this.mParent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      return setIcon(AppCompatDrawableManager.get().getDrawable(this.mParent.getContext(), paramInt));
    }

    @NonNull
    public Tab setIcon(@Nullable Drawable paramDrawable)
    {
      this.mIcon = paramDrawable;
      updateView();
      return this;
    }

    void setPosition(int paramInt)
    {
      this.mPosition = paramInt;
    }

    @NonNull
    public Tab setTag(@Nullable Object paramObject)
    {
      this.mTag = paramObject;
      return this;
    }

    @NonNull
    public Tab setText(@StringRes int paramInt)
    {
      if (this.mParent == null)
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      return setText(this.mParent.getResources().getText(paramInt));
    }

    @NonNull
    public Tab setText(@Nullable CharSequence paramCharSequence)
    {
      this.mText = paramCharSequence;
      updateView();
      return this;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface TabGravity
  {
  }

  public static class TabLayoutOnPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    private int mPreviousScrollState;
    private int mScrollState;
    private final WeakReference<TabLayout> mTabLayoutRef;

    public TabLayoutOnPageChangeListener(TabLayout paramTabLayout)
    {
      this.mTabLayoutRef = new WeakReference(paramTabLayout);
    }

    private void reset()
    {
      this.mScrollState = 0;
      this.mPreviousScrollState = 0;
    }

    public void onPageScrollStateChanged(int paramInt)
    {
      this.mPreviousScrollState = this.mScrollState;
      this.mScrollState = paramInt;
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      TabLayout localTabLayout = (TabLayout)this.mTabLayoutRef.get();
      boolean bool1;
      if (localTabLayout != null)
      {
        if ((this.mScrollState == 2) && (this.mPreviousScrollState != 1))
          break label66;
        bool1 = true;
        if ((this.mScrollState == 2) && (this.mPreviousScrollState == 0))
          break label72;
      }
      label66: label72: for (boolean bool2 = true; ; bool2 = false)
      {
        localTabLayout.setScrollPosition(paramInt1, paramFloat, bool1, bool2);
        return;
        bool1 = false;
        break;
      }
    }

    public void onPageSelected(int paramInt)
    {
      TabLayout localTabLayout = (TabLayout)this.mTabLayoutRef.get();
      if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt))
        if ((this.mScrollState != 0) && ((this.mScrollState != 2) || (this.mPreviousScrollState != 0)))
          break label58;
      label58: for (boolean bool = true; ; bool = false)
      {
        localTabLayout.selectTab(localTabLayout.getTabAt(paramInt), bool);
        return;
      }
    }
  }

  class TabView extends LinearLayout
    implements View.OnLongClickListener
  {
    private ImageView mCustomIconView;
    private TextView mCustomTextView;
    private View mCustomView;
    private int mDefaultMaxLines = 2;
    private ImageView mIconView;
    private TabLayout.Tab mTab;
    private TextView mTextView;

    public TabView(Context arg2)
    {
      super();
      if (TabLayout.this.mTabBackgroundResId != 0)
        setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(localContext, TabLayout.this.mTabBackgroundResId));
      ViewCompat.setPaddingRelative(this, TabLayout.this.mTabPaddingStart, TabLayout.this.mTabPaddingTop, TabLayout.this.mTabPaddingEnd, TabLayout.this.mTabPaddingBottom);
      setGravity(17);
      setOrientation(1);
      setClickable(true);
    }

    private float approximateLineWidth(Layout paramLayout, int paramInt, float paramFloat)
    {
      return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
    }

    private void reset()
    {
      setTab(null);
      setSelected(false);
    }

    private void setTab(@Nullable TabLayout.Tab paramTab)
    {
      if (paramTab != this.mTab)
      {
        this.mTab = paramTab;
        update();
      }
    }

    private void updateTextAndIcon(@Nullable TextView paramTextView, @Nullable ImageView paramImageView)
    {
      Drawable localDrawable;
      CharSequence localCharSequence1;
      label32: CharSequence localCharSequence2;
      label48: label73: int i;
      if (this.mTab != null)
      {
        localDrawable = this.mTab.getIcon();
        if (this.mTab == null)
          break label207;
        localCharSequence1 = this.mTab.getText();
        if (this.mTab == null)
          break label213;
        localCharSequence2 = this.mTab.getContentDescription();
        if (paramImageView != null)
        {
          if (localDrawable == null)
            break label219;
          paramImageView.setImageDrawable(localDrawable);
          paramImageView.setVisibility(0);
          setVisibility(0);
          paramImageView.setContentDescription(localCharSequence2);
        }
        if (TextUtils.isEmpty(localCharSequence1))
          break label233;
        i = 1;
        label89: if (paramTextView != null)
        {
          if (i == 0)
            break label238;
          paramTextView.setText(localCharSequence1);
          paramTextView.setVisibility(0);
          setVisibility(0);
        }
      }
      while (true)
      {
        paramTextView.setContentDescription(localCharSequence2);
        if (paramImageView != null)
        {
          paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
          int k = 0;
          int j = k;
          if (i != 0)
          {
            j = k;
            if (paramImageView.getVisibility() == 0)
              j = TabLayout.this.dpToPx(8);
          }
          if (j != paramTextView.bottomMargin)
          {
            paramTextView.bottomMargin = j;
            paramImageView.requestLayout();
          }
        }
        if ((i != 0) || (TextUtils.isEmpty(localCharSequence2)))
          break label252;
        setOnLongClickListener(this);
        return;
        localDrawable = null;
        break;
        label207: localCharSequence1 = null;
        break label32;
        label213: localCharSequence2 = null;
        break label48;
        label219: paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
        break label73;
        label233: i = 0;
        break label89;
        label238: paramTextView.setVisibility(8);
        paramTextView.setText(null);
      }
      label252: setOnLongClickListener(null);
      setLongClickable(false);
    }

    public TabLayout.Tab getTab()
    {
      return this.mTab;
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }

    public boolean onLongClick(View paramView)
    {
      paramView = new int[2];
      getLocationOnScreen(paramView);
      Object localObject = getContext();
      int i = getWidth();
      int j = getHeight();
      int k = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
      localObject = Toast.makeText((Context)localObject, this.mTab.getContentDescription(), 0);
      ((Toast)localObject).setGravity(49, paramView[0] + i / 2 - k / 2, j);
      ((Toast)localObject).show();
      return true;
    }

    public void onMeasure(int paramInt1, int paramInt2)
    {
      int i = View.MeasureSpec.getSize(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt1);
      int k = TabLayout.this.getTabMaxWidth();
      float f2;
      float f1;
      if ((k > 0) && ((j == 0) || (i > k)))
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.mTabMaxWidth, -2147483648);
        super.onMeasure(paramInt1, paramInt2);
        if (this.mTextView != null)
        {
          getResources();
          f2 = TabLayout.this.mTabTextSize;
          j = this.mDefaultMaxLines;
          if ((this.mIconView == null) || (this.mIconView.getVisibility() != 0))
            break label265;
          i = 1;
          f1 = f2;
        }
      }
      while (true)
      {
        f2 = this.mTextView.getTextSize();
        int m = this.mTextView.getLineCount();
        j = TextViewCompat.getMaxLines(this.mTextView);
        if ((f1 != f2) || ((j >= 0) && (i != j)))
        {
          k = 1;
          j = k;
          if (TabLayout.this.mMode == 1)
          {
            j = k;
            if (f1 > f2)
            {
              j = k;
              if (m == 1)
              {
                Layout localLayout = this.mTextView.getLayout();
                if (localLayout != null)
                {
                  j = k;
                  if (approximateLineWidth(localLayout, 0, f1) <= localLayout.getWidth());
                }
                else
                {
                  j = 0;
                }
              }
            }
          }
          if (j != 0)
          {
            this.mTextView.setTextSize(0, f1);
            this.mTextView.setMaxLines(i);
            super.onMeasure(paramInt1, paramInt2);
          }
        }
        return;
        break;
        label265: i = j;
        f1 = f2;
        if (this.mTextView == null)
          continue;
        i = j;
        f1 = f2;
        if (this.mTextView.getLineCount() <= 1)
          continue;
        f1 = TabLayout.this.mTabTextMultiLineSize;
        i = j;
      }
    }

    public boolean performClick()
    {
      boolean bool = super.performClick();
      if (this.mTab != null)
      {
        this.mTab.select();
        bool = true;
      }
      return bool;
    }

    public void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean);
      for (int i = 1; ; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean))
        {
          sendAccessibilityEvent(4);
          if (this.mTextView != null)
            this.mTextView.setSelected(paramBoolean);
          if (this.mIconView != null)
            this.mIconView.setSelected(paramBoolean);
        }
        return;
      }
    }

    final void update()
    {
      Object localObject = this.mTab;
      if (localObject != null)
      {
        localObject = ((TabLayout.Tab)localObject).getCustomView();
        if (localObject == null)
          break label287;
        ViewParent localViewParent = ((View)localObject).getParent();
        if (localViewParent != this)
        {
          if (localViewParent != null)
            ((ViewGroup)localViewParent).removeView((View)localObject);
          addView((View)localObject);
        }
        this.mCustomView = ((View)localObject);
        if (this.mTextView != null)
          this.mTextView.setVisibility(8);
        if (this.mIconView != null)
        {
          this.mIconView.setVisibility(8);
          this.mIconView.setImageDrawable(null);
        }
        this.mCustomTextView = ((TextView)((View)localObject).findViewById(16908308));
        if (this.mCustomTextView != null)
          this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mCustomTextView);
        this.mCustomIconView = ((ImageView)((View)localObject).findViewById(16908294));
        label136: if (this.mCustomView != null)
          break label320;
        if (this.mIconView == null)
        {
          localObject = (ImageView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
          addView((View)localObject, 0);
          this.mIconView = ((ImageView)localObject);
        }
        if (this.mTextView == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
          addView((View)localObject);
          this.mTextView = ((TextView)localObject);
          this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mTextView);
        }
        this.mTextView.setTextAppearance(getContext(), TabLayout.this.mTabTextAppearance);
        if (TabLayout.this.mTabTextColors != null)
          this.mTextView.setTextColor(TabLayout.this.mTabTextColors);
        updateTextAndIcon(this.mTextView, this.mIconView);
      }
      label287: label320: 
      do
      {
        return;
        localObject = null;
        break;
        if (this.mCustomView != null)
        {
          removeView(this.mCustomView);
          this.mCustomView = null;
        }
        this.mCustomTextView = null;
        this.mCustomIconView = null;
        break label136;
      }
      while ((this.mCustomTextView == null) && (this.mCustomIconView == null));
      updateTextAndIcon(this.mCustomTextView, this.mCustomIconView);
    }
  }

  public static class ViewPagerOnTabSelectedListener
    implements TabLayout.OnTabSelectedListener
  {
    private final ViewPager mViewPager;

    public ViewPagerOnTabSelectedListener(ViewPager paramViewPager)
    {
      this.mViewPager = paramViewPager;
    }

    public void onTabReselected(TabLayout.Tab paramTab)
    {
    }

    public void onTabSelected(TabLayout.Tab paramTab)
    {
      this.mViewPager.setCurrentItem(paramTab.getPosition());
    }

    public void onTabUnselected(TabLayout.Tab paramTab)
    {
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.TabLayout
 * JD-Core Version:    0.6.0
 */