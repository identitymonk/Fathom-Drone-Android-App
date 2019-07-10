package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class ViewOffsetHelper
{
  private int mLayoutLeft;
  private int mLayoutTop;
  private int mOffsetLeft;
  private int mOffsetTop;
  private final View mView;

  public ViewOffsetHelper(View paramView)
  {
    this.mView = paramView;
  }

  private void updateOffsets()
  {
    ViewCompat.offsetTopAndBottom(this.mView, this.mOffsetTop - (this.mView.getTop() - this.mLayoutTop));
    ViewCompat.offsetLeftAndRight(this.mView, this.mOffsetLeft - (this.mView.getLeft() - this.mLayoutLeft));
  }

  public int getLeftAndRightOffset()
  {
    return this.mOffsetLeft;
  }

  public int getTopAndBottomOffset()
  {
    return this.mOffsetTop;
  }

  public void onViewLayout()
  {
    this.mLayoutTop = this.mView.getTop();
    this.mLayoutLeft = this.mView.getLeft();
    updateOffsets();
  }

  public boolean setLeftAndRightOffset(int paramInt)
  {
    if (this.mOffsetLeft != paramInt)
    {
      this.mOffsetLeft = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }

  public boolean setTopAndBottomOffset(int paramInt)
  {
    if (this.mOffsetTop != paramInt)
    {
      this.mOffsetTop = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.ViewOffsetHelper
 * JD-Core Version:    0.6.0
 */