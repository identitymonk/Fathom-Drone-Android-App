package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

class AppCompatTextHelperV17 extends AppCompatTextHelper
{
  private static final int[] VIEW_ATTRS_v17 = { 16843666, 16843667 };
  private TintInfo mDrawableEndTint;
  private TintInfo mDrawableStartTint;

  AppCompatTextHelperV17(TextView paramTextView)
  {
    super(paramTextView);
  }

  void applyCompoundDrawablesTints()
  {
    super.applyCompoundDrawablesTints();
    if ((this.mDrawableStartTint != null) || (this.mDrawableEndTint != null))
    {
      Drawable[] arrayOfDrawable = this.mView.getCompoundDrawablesRelative();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableStartTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableEndTint);
    }
  }

  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    super.loadFromAttributes(paramAttributeSet, paramInt);
    Context localContext = this.mView.getContext();
    AppCompatDrawableManager localAppCompatDrawableManager = AppCompatDrawableManager.get();
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, VIEW_ATTRS_v17, paramInt, 0);
    if (paramAttributeSet.hasValue(0))
      this.mDrawableStartTint = createTintInfo(localContext, localAppCompatDrawableManager, paramAttributeSet.getResourceId(0, 0));
    if (paramAttributeSet.hasValue(1))
      this.mDrawableEndTint = createTintInfo(localContext, localAppCompatDrawableManager, paramAttributeSet.getResourceId(1, 0));
    paramAttributeSet.recycle();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextHelperV17
 * JD-Core Version:    0.6.0
 */