package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView
{
  private static final int[] TINT_ATTRS = { 16843016 };
  private AppCompatDrawableManager mDrawableManager;
  private AppCompatTextHelper mTextHelper = AppCompatTextHelper.create(this);

  public AppCompatCheckedTextView(Context paramContext)
  {
    this(paramContext, null);
  }

  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }

  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.mTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper.applyCompoundDrawablesTints();
    this.mDrawableManager = AppCompatDrawableManager.get();
    paramContext = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, TINT_ATTRS, paramInt, 0);
    setCheckMarkDrawable(paramContext.getDrawable(0));
    paramContext.recycle();
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mTextHelper != null)
      this.mTextHelper.applyCompoundDrawablesTints();
  }

  public void setCheckMarkDrawable(@DrawableRes int paramInt)
  {
    if (this.mDrawableManager != null)
    {
      setCheckMarkDrawable(this.mDrawableManager.getDrawable(getContext(), paramInt));
      return;
    }
    super.setCheckMarkDrawable(paramInt);
  }

  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null)
      this.mTextHelper.onSetTextAppearance(paramContext, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCheckedTextView
 * JD-Core Version:    0.6.0
 */