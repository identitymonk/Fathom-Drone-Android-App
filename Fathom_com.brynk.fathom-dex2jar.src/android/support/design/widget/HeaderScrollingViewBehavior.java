package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View>
{
  private int mOverlayTop;
  private final Rect mTempRect1 = new Rect();
  private final Rect mTempRect2 = new Rect();
  private int mVerticalLayoutGap = 0;

  public HeaderScrollingViewBehavior()
  {
  }

  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private static int resolveGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
      i = 8388659;
    return i;
  }

  abstract View findFirstDependency(List<View> paramList);

  final int getOverlapPixelsForOffset(View paramView)
  {
    if (this.mOverlayTop == 0)
      return 0;
    return MathUtils.constrain(Math.round(getOverlapRatioForOffset(paramView) * this.mOverlayTop), 0, this.mOverlayTop);
  }

  float getOverlapRatioForOffset(View paramView)
  {
    return 1.0F;
  }

  public final int getOverlayTop()
  {
    return this.mOverlayTop;
  }

  int getScrollRange(View paramView)
  {
    return paramView.getMeasuredHeight();
  }

  final int getVerticalLayoutGap()
  {
    return this.mVerticalLayoutGap;
  }

  protected void layoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
    if (localView != null)
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mTempRect1;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + localLayoutParams.leftMargin, localView.getBottom() + localLayoutParams.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - localLayoutParams.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - localLayoutParams.bottomMargin);
      paramCoordinatorLayout = this.mTempRect2;
      GravityCompat.apply(resolveGravity(localLayoutParams.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = getOverlapPixelsForOffset(localView);
      paramView.layout(paramCoordinatorLayout.left, paramCoordinatorLayout.top - paramInt, paramCoordinatorLayout.right, paramCoordinatorLayout.bottom - paramInt);
      this.mVerticalLayoutGap = (paramCoordinatorLayout.top - localView.getBottom());
      return;
    }
    super.layoutChild(paramCoordinatorLayout, paramView, paramInt);
    this.mVerticalLayoutGap = 0;
  }

  public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramView.getLayoutParams().height;
    if ((j == -1) || (j == -2))
    {
      View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
      if (localView != null)
      {
        if ((ViewCompat.getFitsSystemWindows(localView)) && (!ViewCompat.getFitsSystemWindows(paramView)))
        {
          ViewCompat.setFitsSystemWindows(paramView, true);
          if (ViewCompat.getFitsSystemWindows(paramView))
          {
            paramView.requestLayout();
            return true;
          }
        }
        if (ViewCompat.isLaidOut(localView))
        {
          int i = View.MeasureSpec.getSize(paramInt3);
          paramInt3 = i;
          if (i == 0)
            paramInt3 = paramCoordinatorLayout.getHeight();
          int k = localView.getMeasuredHeight();
          int m = getScrollRange(localView);
          if (j == -1);
          for (i = 1073741824; ; i = -2147483648)
          {
            paramCoordinatorLayout.onMeasureChild(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt3 - k + m, i), paramInt4);
            return true;
          }
        }
      }
    }
    return false;
  }

  public final void setOverlayTop(int paramInt)
  {
    this.mOverlayTop = paramInt;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.HeaderScrollingViewBehavior
 * JD-Core Version:    0.6.0
 */