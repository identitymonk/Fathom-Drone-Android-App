package android.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable
{
  public ActionBarBackgroundDrawableV21(ActionBarContainer paramActionBarContainer)
  {
    super(paramActionBarContainer);
  }

  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.mContainer.mIsSplit)
      if (this.mContainer.mSplitBackground != null)
        this.mContainer.mSplitBackground.getOutline(paramOutline);
    do
      return;
    while (this.mContainer.mBackground == null);
    this.mContainer.mBackground.getOutline(paramOutline);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionBarBackgroundDrawableV21
 * JD-Core Version:    0.6.0
 */