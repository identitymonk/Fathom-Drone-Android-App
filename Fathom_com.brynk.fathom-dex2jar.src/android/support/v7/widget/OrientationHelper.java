package android.support.v7.widget;

import android.view.View;

public abstract class OrientationHelper
{
  public static final int HORIZONTAL = 0;
  private static final int INVALID_SIZE = -2147483648;
  public static final int VERTICAL = 1;
  private int mLastTotalSpace = -2147483648;
  protected final RecyclerView.LayoutManager mLayoutManager;

  private OrientationHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.mLayoutManager = paramLayoutManager;
  }

  public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    return new OrientationHelper(paramLayoutManager)
    {
      public int getDecoratedEnd(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return this.mLayoutManager.getDecoratedRight(paramView) + localLayoutParams.rightMargin;
      }

      public int getDecoratedMeasurement(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredWidth(paramView) + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
      }

      public int getDecoratedMeasurementInOther(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredHeight(paramView) + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
      }

      public int getDecoratedStart(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return this.mLayoutManager.getDecoratedLeft(paramView) - localLayoutParams.leftMargin;
      }

      public int getEnd()
      {
        return this.mLayoutManager.getWidth();
      }

      public int getEndAfterPadding()
      {
        return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
      }

      public int getEndPadding()
      {
        return this.mLayoutManager.getPaddingRight();
      }

      public int getMode()
      {
        return this.mLayoutManager.getWidthMode();
      }

      public int getModeInOther()
      {
        return this.mLayoutManager.getHeightMode();
      }

      public int getStartAfterPadding()
      {
        return this.mLayoutManager.getPaddingLeft();
      }

      public int getTotalSpace()
      {
        return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft() - this.mLayoutManager.getPaddingRight();
      }

      public void offsetChild(View paramView, int paramInt)
      {
        paramView.offsetLeftAndRight(paramInt);
      }

      public void offsetChildren(int paramInt)
      {
        this.mLayoutManager.offsetChildrenHorizontal(paramInt);
      }
    };
  }

  public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager paramLayoutManager, int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("invalid orientation");
    case 0:
      return createHorizontalHelper(paramLayoutManager);
    case 1:
    }
    return createVerticalHelper(paramLayoutManager);
  }

  public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    return new OrientationHelper(paramLayoutManager)
    {
      public int getDecoratedEnd(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return this.mLayoutManager.getDecoratedBottom(paramView) + localLayoutParams.bottomMargin;
      }

      public int getDecoratedMeasurement(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredHeight(paramView) + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
      }

      public int getDecoratedMeasurementInOther(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredWidth(paramView) + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
      }

      public int getDecoratedStart(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return this.mLayoutManager.getDecoratedTop(paramView) - localLayoutParams.topMargin;
      }

      public int getEnd()
      {
        return this.mLayoutManager.getHeight();
      }

      public int getEndAfterPadding()
      {
        return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
      }

      public int getEndPadding()
      {
        return this.mLayoutManager.getPaddingBottom();
      }

      public int getMode()
      {
        return this.mLayoutManager.getHeightMode();
      }

      public int getModeInOther()
      {
        return this.mLayoutManager.getWidthMode();
      }

      public int getStartAfterPadding()
      {
        return this.mLayoutManager.getPaddingTop();
      }

      public int getTotalSpace()
      {
        return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop() - this.mLayoutManager.getPaddingBottom();
      }

      public void offsetChild(View paramView, int paramInt)
      {
        paramView.offsetTopAndBottom(paramInt);
      }

      public void offsetChildren(int paramInt)
      {
        this.mLayoutManager.offsetChildrenVertical(paramInt);
      }
    };
  }

  public abstract int getDecoratedEnd(View paramView);

  public abstract int getDecoratedMeasurement(View paramView);

  public abstract int getDecoratedMeasurementInOther(View paramView);

  public abstract int getDecoratedStart(View paramView);

  public abstract int getEnd();

  public abstract int getEndAfterPadding();

  public abstract int getEndPadding();

  public abstract int getMode();

  public abstract int getModeInOther();

  public abstract int getStartAfterPadding();

  public abstract int getTotalSpace();

  public int getTotalSpaceChange()
  {
    if (-2147483648 == this.mLastTotalSpace)
      return 0;
    return getTotalSpace() - this.mLastTotalSpace;
  }

  public abstract void offsetChild(View paramView, int paramInt);

  public abstract void offsetChildren(int paramInt);

  public void onLayoutComplete()
  {
    this.mLastTotalSpace = getTotalSpace();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.OrientationHelper
 * JD-Core Version:    0.6.0
 */