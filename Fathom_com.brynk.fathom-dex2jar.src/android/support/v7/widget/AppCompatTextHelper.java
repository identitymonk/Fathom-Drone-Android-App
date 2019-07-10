package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class AppCompatTextHelper
{
  private static final int[] TEXT_APPEARANCE_ATTRS;
  private static final int[] VIEW_ATTRS = { 16842804, 16843119, 16843117, 16843120, 16843118 };
  private TintInfo mDrawableBottomTint;
  private TintInfo mDrawableLeftTint;
  private TintInfo mDrawableRightTint;
  private TintInfo mDrawableTopTint;
  final TextView mView;

  static
  {
    TEXT_APPEARANCE_ATTRS = new int[] { R.attr.textAllCaps };
  }

  AppCompatTextHelper(TextView paramTextView)
  {
    this.mView = paramTextView;
  }

  static AppCompatTextHelper create(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return new AppCompatTextHelperV17(paramTextView);
    return new AppCompatTextHelper(paramTextView);
  }

  protected static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt)
  {
    paramContext = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (paramContext != null)
    {
      paramAppCompatDrawableManager = new TintInfo();
      paramAppCompatDrawableManager.mHasTintList = true;
      paramAppCompatDrawableManager.mTintList = paramContext;
      return paramAppCompatDrawableManager;
    }
    return null;
  }

  final void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramDrawable != null) && (paramTintInfo != null))
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState());
  }

  void applyCompoundDrawablesTints()
  {
    if ((this.mDrawableLeftTint != null) || (this.mDrawableTopTint != null) || (this.mDrawableRightTint != null) || (this.mDrawableBottomTint != null))
    {
      Drawable[] arrayOfDrawable = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], this.mDrawableBottomTint);
    }
  }

  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.mView.getContext();
    Object localObject = AppCompatDrawableManager.get();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, VIEW_ATTRS, paramInt, 0);
    int k = localTypedArray.getResourceId(0, -1);
    if (localTypedArray.hasValue(1))
      this.mDrawableLeftTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(1, 0));
    if (localTypedArray.hasValue(2))
      this.mDrawableTopTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(2, 0));
    if (localTypedArray.hasValue(3))
      this.mDrawableRightTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(3, 0));
    if (localTypedArray.hasValue(4))
      this.mDrawableBottomTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(4, 0));
    localTypedArray.recycle();
    if (!(this.mView.getTransformationMethod() instanceof PasswordTransformationMethod))
    {
      boolean bool1 = false;
      boolean bool2 = false;
      int i = 0;
      int j = 0;
      if (k != -1)
      {
        localObject = localContext.obtainStyledAttributes(k, R.styleable.TextAppearance);
        bool1 = bool2;
        i = j;
        if (((TypedArray)localObject).hasValue(R.styleable.TextAppearance_textAllCaps))
        {
          i = 1;
          bool1 = ((TypedArray)localObject).getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        }
        ((TypedArray)localObject).recycle();
      }
      paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, TEXT_APPEARANCE_ATTRS, paramInt, 0);
      if (paramAttributeSet.hasValue(0))
      {
        i = 1;
        bool1 = paramAttributeSet.getBoolean(0, false);
      }
      paramAttributeSet.recycle();
      if (i != 0)
        setAllCaps(bool1);
    }
  }

  void onSetTextAppearance(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, TEXT_APPEARANCE_ATTRS);
    if (paramContext.hasValue(0))
      setAllCaps(paramContext.getBoolean(0, false));
    paramContext.recycle();
  }

  void setAllCaps(boolean paramBoolean)
  {
    TextView localTextView = this.mView;
    if (paramBoolean);
    for (AllCapsTransformationMethod localAllCapsTransformationMethod = new AllCapsTransformationMethod(this.mView.getContext()); ; localAllCapsTransformationMethod = null)
    {
      localTextView.setTransformationMethod(localAllCapsTransformationMethod);
      return;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextHelper
 * JD-Core Version:    0.6.0
 */