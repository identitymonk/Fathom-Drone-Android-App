package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.R.dimen;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton
{
  private static final String LOG_TAG = "FloatingActionButton";
  private static final int SIZE_MINI = 1;
  private static final int SIZE_NORMAL = 0;
  private ColorStateList mBackgroundTint;
  private PorterDuff.Mode mBackgroundTintMode;
  private int mBorderWidth;
  private boolean mCompatPadding;
  private AppCompatImageHelper mImageHelper;
  private int mImagePadding;
  private FloatingActionButtonImpl mImpl;
  private int mRippleColor;
  private final Rect mShadowPadding = new Rect();
  private int mSize;

  public FloatingActionButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(paramContext);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton, paramInt, R.style.Widget_Design_FloatingActionButton);
    this.mBackgroundTint = paramContext.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
    this.mBackgroundTintMode = parseTintMode(paramContext.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
    this.mRippleColor = paramContext.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
    this.mSize = paramContext.getInt(R.styleable.FloatingActionButton_fabSize, 0);
    this.mBorderWidth = paramContext.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
    float f1 = paramContext.getDimension(R.styleable.FloatingActionButton_elevation, 0.0F);
    float f2 = paramContext.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
    this.mCompatPadding = paramContext.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
    paramContext.recycle();
    this.mImageHelper = new AppCompatImageHelper(this, AppCompatDrawableManager.get());
    this.mImageHelper.loadFromAttributes(paramAttributeSet, paramInt);
    paramInt = (int)getResources().getDimension(R.dimen.design_fab_image_size);
    this.mImagePadding = ((getSizeDimension() - paramInt) / 2);
    getImpl().setBackgroundDrawable(this.mBackgroundTint, this.mBackgroundTintMode, this.mRippleColor, this.mBorderWidth);
    getImpl().setElevation(f1);
    getImpl().setPressedTranslationZ(f2);
    getImpl().updatePadding();
  }

  private FloatingActionButtonImpl createImpl()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
      return new FloatingActionButtonLollipop(this, new ShadowDelegateImpl(null));
    if (i >= 14)
      return new FloatingActionButtonIcs(this, new ShadowDelegateImpl(null));
    return new FloatingActionButtonEclairMr1(this, new ShadowDelegateImpl(null));
  }

  private FloatingActionButtonImpl getImpl()
  {
    if (this.mImpl == null)
      this.mImpl = createImpl();
    return this.mImpl;
  }

  private void hide(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().hide(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }

  static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    default:
      return paramMode;
    case 3:
      return PorterDuff.Mode.SRC_OVER;
    case 5:
      return PorterDuff.Mode.SRC_IN;
    case 9:
      return PorterDuff.Mode.SRC_ATOP;
    case 14:
      return PorterDuff.Mode.MULTIPLY;
    case 15:
    }
    return PorterDuff.Mode.SCREEN;
  }

  private static int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    default:
      return paramInt1;
    case 0:
      return paramInt1;
    case -2147483648:
      return Math.min(paramInt1, paramInt2);
    case 1073741824:
    }
    return paramInt2;
  }

  private void show(OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().show(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }

  @Nullable
  private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null)
      return null;
    return new FloatingActionButtonImpl.InternalVisibilityChangedListener(paramOnVisibilityChangedListener)
    {
      public void onHidden()
      {
        this.val$listener.onHidden(FloatingActionButton.this);
      }

      public void onShown()
      {
        this.val$listener.onShown(FloatingActionButton.this);
      }
    };
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().onDrawableStateChanged(getDrawableState());
  }

  @Nullable
  public ColorStateList getBackgroundTintList()
  {
    return this.mBackgroundTint;
  }

  @Nullable
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.mBackgroundTintMode;
  }

  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }

  @NonNull
  public Drawable getContentBackground()
  {
    return getImpl().getContentBackground();
  }

  public boolean getContentRect(@NonNull Rect paramRect)
  {
    int i = 0;
    if (ViewCompat.isLaidOut(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      paramRect.left += this.mShadowPadding.left;
      paramRect.top += this.mShadowPadding.top;
      paramRect.right -= this.mShadowPadding.right;
      paramRect.bottom -= this.mShadowPadding.bottom;
      i = 1;
    }
    return i;
  }

  final int getSizeDimension()
  {
    switch (this.mSize)
    {
    default:
      return getResources().getDimensionPixelSize(R.dimen.design_fab_size_normal);
    case 1:
    }
    return getResources().getDimensionPixelSize(R.dimen.design_fab_size_mini);
  }

  public boolean getUseCompatPadding()
  {
    return this.mCompatPadding;
  }

  public void hide()
  {
    hide(null);
  }

  public void hide(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    hide(paramOnVisibilityChangedListener, true);
  }

  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().jumpDrawableToCurrentState();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getImpl().onAttachedToWindow();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getImpl().onDetachedFromWindow();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(this.mShadowPadding.left + paramInt1 + this.mShadowPadding.right, this.mShadowPadding.top + paramInt1 + this.mShadowPadding.bottom);
  }

  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }

  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }

  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTint != paramColorStateList)
    {
      this.mBackgroundTint = paramColorStateList;
      getImpl().setBackgroundTintList(paramColorStateList);
    }
  }

  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTintMode != paramMode)
    {
      this.mBackgroundTintMode = paramMode;
      getImpl().setBackgroundTintMode(paramMode);
    }
  }

  public void setCompatElevation(float paramFloat)
  {
    getImpl().setElevation(paramFloat);
  }

  public void setImageResource(@DrawableRes int paramInt)
  {
    this.mImageHelper.setImageResource(paramInt);
  }

  public void setRippleColor(@ColorInt int paramInt)
  {
    if (this.mRippleColor != paramInt)
    {
      this.mRippleColor = paramInt;
      getImpl().setRippleColor(paramInt);
    }
  }

  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.mCompatPadding != paramBoolean)
    {
      this.mCompatPadding = paramBoolean;
      getImpl().onCompatShadowChanged();
    }
  }

  public void show()
  {
    show(null);
  }

  public void show(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    show(paramOnVisibilityChangedListener, true);
  }

  public static class Behavior extends CoordinatorLayout.Behavior<FloatingActionButton>
  {
    private static final boolean SNACKBAR_BEHAVIOR_ENABLED;
    private float mFabTranslationY;
    private ValueAnimatorCompat mFabTranslationYAnimator;
    private Rect mTmpRect;

    static
    {
      if (Build.VERSION.SDK_INT >= 11);
      for (boolean bool = true; ; bool = false)
      {
        SNACKBAR_BEHAVIOR_ENABLED = bool;
        return;
      }
    }

    private float getFabTranslationYForSnackbar(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      float f1 = 0.0F;
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int i = 0;
      int j = localList.size();
      while (i < j)
      {
        View localView = (View)localList.get(i);
        float f2 = f1;
        if ((localView instanceof Snackbar.SnackbarLayout))
        {
          f2 = f1;
          if (paramCoordinatorLayout.doViewsOverlap(paramFloatingActionButton, localView))
            f2 = Math.min(f1, ViewCompat.getTranslationY(localView) - localView.getHeight());
        }
        i += 1;
        f1 = f2;
      }
      return f1;
    }

    private void offsetIfNeeded(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      Rect localRect = paramFloatingActionButton.mShadowPadding;
      CoordinatorLayout.LayoutParams localLayoutParams;
      int j;
      int i;
      if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
      {
        localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
        j = 0;
        i = 0;
        if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - localLayoutParams.rightMargin)
          break label100;
        i = localRect.right;
        if (paramFloatingActionButton.getBottom() < paramCoordinatorLayout.getBottom() - localLayoutParams.bottomMargin)
          break label122;
        j = localRect.bottom;
      }
      while (true)
      {
        paramFloatingActionButton.offsetTopAndBottom(j);
        paramFloatingActionButton.offsetLeftAndRight(i);
        return;
        label100: if (paramFloatingActionButton.getLeft() > localLayoutParams.leftMargin)
          break;
        i = -localRect.left;
        break;
        label122: if (paramFloatingActionButton.getTop() > localLayoutParams.topMargin)
          continue;
        j = -localRect.top;
      }
    }

    private void updateFabTranslationForSnackbar(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      float f1 = getFabTranslationYForSnackbar(paramCoordinatorLayout, paramFloatingActionButton);
      if (this.mFabTranslationY == f1)
        return;
      float f2 = ViewCompat.getTranslationY(paramFloatingActionButton);
      if ((this.mFabTranslationYAnimator != null) && (this.mFabTranslationYAnimator.isRunning()))
        this.mFabTranslationYAnimator.cancel();
      if ((paramFloatingActionButton.isShown()) && (Math.abs(f2 - f1) > paramFloatingActionButton.getHeight() * 0.667F))
      {
        if (this.mFabTranslationYAnimator == null)
        {
          this.mFabTranslationYAnimator = ViewUtils.createAnimator();
          this.mFabTranslationYAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
          this.mFabTranslationYAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener(paramFloatingActionButton)
          {
            public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
            {
              ViewCompat.setTranslationY(this.val$fab, paramValueAnimatorCompat.getAnimatedFloatValue());
            }
          });
        }
        this.mFabTranslationYAnimator.setFloatValues(f2, f1);
        this.mFabTranslationYAnimator.start();
      }
      while (true)
      {
        this.mFabTranslationY = f1;
        return;
        ViewCompat.setTranslationY(paramFloatingActionButton, f1);
      }
    }

    private boolean updateFabVisibility(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (((CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams()).getAnchorId() != paramAppBarLayout.getId());
      do
        return false;
      while (paramFloatingActionButton.getUserSetVisibility() != 0);
      if (this.mTmpRect == null)
        this.mTmpRect = new Rect();
      Rect localRect = this.mTmpRect;
      ViewGroupUtils.getDescendantRect(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent())
        paramFloatingActionButton.hide(null, false);
      while (true)
      {
        return true;
        paramFloatingActionButton.show(null, false);
      }
    }

    public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      return (SNACKBAR_BEHAVIOR_ENABLED) && ((paramView instanceof Snackbar.SnackbarLayout));
    }

    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof Snackbar.SnackbarLayout))
        updateFabTranslationForSnackbar(paramCoordinatorLayout, paramFloatingActionButton, paramView);
      while (true)
      {
        return false;
        if (!(paramView instanceof AppBarLayout))
          continue;
        updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      }
    }

    public void onDependentViewRemoved(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof Snackbar.SnackbarLayout))
        updateFabTranslationForSnackbar(paramCoordinatorLayout, paramFloatingActionButton, paramView);
    }

    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int i = 0;
      int j = localList.size();
      while (true)
      {
        if (i < j)
        {
          View localView = (View)localList.get(i);
          if ((!(localView instanceof AppBarLayout)) || (!updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton)));
        }
        else
        {
          paramCoordinatorLayout.onLayoutChild(paramFloatingActionButton, paramInt);
          offsetIfNeeded(paramCoordinatorLayout, paramFloatingActionButton);
          return true;
        }
        i += 1;
      }
    }
  }

  public static abstract class OnVisibilityChangedListener
  {
    public void onHidden(FloatingActionButton paramFloatingActionButton)
    {
    }

    public void onShown(FloatingActionButton paramFloatingActionButton)
    {
    }
  }

  private class ShadowDelegateImpl
    implements ShadowViewDelegate
  {
    private ShadowDelegateImpl()
    {
    }

    public float getRadius()
    {
      return FloatingActionButton.this.getSizeDimension() / 2.0F;
    }

    public boolean isCompatPaddingEnabled()
    {
      return FloatingActionButton.this.mCompatPadding;
    }

    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      FloatingActionButton.this.setBackgroundDrawable(paramDrawable);
    }

    public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.this.mShadowPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton.this.setPadding(FloatingActionButton.this.mImagePadding + paramInt1, FloatingActionButton.this.mImagePadding + paramInt2, FloatingActionButton.this.mImagePadding + paramInt3, FloatingActionButton.this.mImagePadding + paramInt4);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButton
 * JD-Core Version:    0.6.0
 */