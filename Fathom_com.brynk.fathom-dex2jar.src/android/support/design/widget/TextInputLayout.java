package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.R.color;
import android.support.design.R.string;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.Space;
import android.support.v7.widget.AppCompatDrawableManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class TextInputLayout extends LinearLayout
{
  private static final int ANIMATION_DURATION = 200;
  private static final int INVALID_MAX_LENGTH = -1;
  private static final String LOG_TAG = "TextInputLayout";
  private ValueAnimatorCompat mAnimator;
  private final CollapsingTextHelper mCollapsingTextHelper = new CollapsingTextHelper(this);
  private boolean mCounterEnabled;
  private int mCounterMaxLength;
  private int mCounterOverflowTextAppearance;
  private boolean mCounterOverflowed;
  private int mCounterTextAppearance;
  private TextView mCounterView;
  private ColorStateList mDefaultTextColor;
  private EditText mEditText;
  private CharSequence mError;
  private boolean mErrorEnabled;
  private boolean mErrorShown;
  private int mErrorTextAppearance;
  private TextView mErrorView;
  private ColorStateList mFocusedTextColor;
  private boolean mHasReconstructedEditTextBackground;
  private CharSequence mHint;
  private boolean mHintAnimationEnabled;
  private boolean mHintEnabled;
  private LinearLayout mIndicatorArea;
  private int mIndicatorsAdded;
  private Paint mTmpPaint;

  public TextInputLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    ThemeUtils.checkAppCompatTheme(paramContext);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    this.mCollapsingTextHelper.setPositionInterpolator(new AccelerateInterpolator());
    this.mCollapsingTextHelper.setCollapsedTextGravity(8388659);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextInputLayout, paramInt, R.style.Widget_Design_TextInputLayout);
    this.mHintEnabled = paramContext.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
    setHint(paramContext.getText(R.styleable.TextInputLayout_android_hint));
    this.mHintAnimationEnabled = paramContext.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
    if (paramContext.hasValue(R.styleable.TextInputLayout_android_textColorHint))
    {
      paramAttributeSet = paramContext.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
      this.mFocusedTextColor = paramAttributeSet;
      this.mDefaultTextColor = paramAttributeSet;
    }
    if (paramContext.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1)
      setHintTextAppearance(paramContext.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
    this.mErrorTextAppearance = paramContext.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
    boolean bool1 = paramContext.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
    boolean bool2 = paramContext.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
    setCounterMaxLength(paramContext.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
    this.mCounterTextAppearance = paramContext.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
    this.mCounterOverflowTextAppearance = paramContext.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
    paramContext.recycle();
    setErrorEnabled(bool1);
    setCounterEnabled(bool2);
    if (ViewCompat.getImportantForAccessibility(this) == 0)
      ViewCompat.setImportantForAccessibility(this, 1);
    ViewCompat.setAccessibilityDelegate(this, new TextInputAccessibilityDelegate(null));
  }

  private void addIndicator(TextView paramTextView, int paramInt)
  {
    if (this.mIndicatorArea == null)
    {
      this.mIndicatorArea = new LinearLayout(getContext());
      this.mIndicatorArea.setOrientation(0);
      addView(this.mIndicatorArea, -1, -2);
      Space localSpace = new Space(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.mIndicatorArea.addView(localSpace, localLayoutParams);
      if (this.mEditText != null)
        adjustIndicatorPadding();
    }
    this.mIndicatorArea.setVisibility(0);
    this.mIndicatorArea.addView(paramTextView, paramInt);
    this.mIndicatorsAdded += 1;
  }

  private void adjustIndicatorPadding()
  {
    ViewCompat.setPaddingRelative(this.mIndicatorArea, ViewCompat.getPaddingStart(this.mEditText), 0, ViewCompat.getPaddingEnd(this.mEditText), this.mEditText.getPaddingBottom());
  }

  private void animateToExpansionFraction(float paramFloat)
  {
    if (this.mCollapsingTextHelper.getExpansionFraction() == paramFloat)
      return;
    if (this.mAnimator == null)
    {
      this.mAnimator = ViewUtils.createAnimator();
      this.mAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
      this.mAnimator.setDuration(200);
      this.mAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
        {
          TextInputLayout.this.mCollapsingTextHelper.setExpansionFraction(paramValueAnimatorCompat.getAnimatedFloatValue());
        }
      });
    }
    this.mAnimator.setFloatValues(this.mCollapsingTextHelper.getExpansionFraction(), paramFloat);
    this.mAnimator.start();
  }

  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt)
        return true;
      i += 1;
    }
    return false;
  }

  private static void clearColorFilter(@NonNull Drawable paramDrawable)
  {
    paramDrawable.clearColorFilter();
    if ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22))
    {
      if (!(paramDrawable instanceof InsetDrawable))
        break label38;
      clearColorFilter(((InsetDrawable)paramDrawable).getDrawable());
    }
    while (true)
    {
      return;
      label38: if ((paramDrawable instanceof DrawableWrapper))
      {
        clearColorFilter(((DrawableWrapper)paramDrawable).getWrappedDrawable());
        return;
      }
      if (!(paramDrawable instanceof DrawableContainer))
        continue;
      paramDrawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
      if (paramDrawable == null)
        continue;
      int i = 0;
      int j = paramDrawable.getChildCount();
      while (i < j)
      {
        clearColorFilter(paramDrawable.getChild(i));
        i += 1;
      }
    }
  }

  private void collapseHint(boolean paramBoolean)
  {
    if ((this.mAnimator != null) && (this.mAnimator.isRunning()))
      this.mAnimator.cancel();
    if ((paramBoolean) && (this.mHintAnimationEnabled))
    {
      animateToExpansionFraction(1.0F);
      return;
    }
    this.mCollapsingTextHelper.setExpansionFraction(1.0F);
  }

  private void ensureBackgroundDrawableStateWorkaround()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) && (i != 22));
    Drawable localDrawable2;
    do
    {
      Drawable localDrawable1;
      do
      {
        return;
        localDrawable1 = this.mEditText.getBackground();
      }
      while ((localDrawable1 == null) || (this.mHasReconstructedEditTextBackground));
      localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if (!(localDrawable1 instanceof DrawableContainer))
        continue;
      this.mHasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
    }
    while (this.mHasReconstructedEditTextBackground);
    this.mEditText.setBackgroundDrawable(localDrawable2);
    this.mHasReconstructedEditTextBackground = true;
  }

  private void expandHint(boolean paramBoolean)
  {
    if ((this.mAnimator != null) && (this.mAnimator.isRunning()))
      this.mAnimator.cancel();
    if ((paramBoolean) && (this.mHintAnimationEnabled))
    {
      animateToExpansionFraction(0.0F);
      return;
    }
    this.mCollapsingTextHelper.setExpansionFraction(0.0F);
  }

  private void removeIndicator(TextView paramTextView)
  {
    if (this.mIndicatorArea != null)
    {
      this.mIndicatorArea.removeView(paramTextView);
      int i = this.mIndicatorsAdded - 1;
      this.mIndicatorsAdded = i;
      if (i == 0)
        this.mIndicatorArea.setVisibility(8);
    }
  }

  private void setEditText(EditText paramEditText)
  {
    if (this.mEditText != null)
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    if (!(paramEditText instanceof TextInputEditText))
      Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
    this.mEditText = paramEditText;
    this.mCollapsingTextHelper.setTypefaces(this.mEditText.getTypeface());
    this.mCollapsingTextHelper.setExpandedTextSize(this.mEditText.getTextSize());
    int i = this.mEditText.getGravity();
    this.mCollapsingTextHelper.setCollapsedTextGravity(0x800007 & i | 0x30);
    this.mCollapsingTextHelper.setExpandedTextGravity(i);
    this.mEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramEditable)
      {
        TextInputLayout.this.updateLabelState(true);
        if (TextInputLayout.this.mCounterEnabled)
          TextInputLayout.this.updateCounter(paramEditable.length());
      }

      public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
      {
      }

      public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
      {
      }
    });
    if (this.mDefaultTextColor == null)
      this.mDefaultTextColor = this.mEditText.getHintTextColors();
    if ((this.mHintEnabled) && (TextUtils.isEmpty(this.mHint)))
    {
      setHint(this.mEditText.getHint());
      this.mEditText.setHint(null);
    }
    if (this.mCounterView != null)
      updateCounter(this.mEditText.getText().length());
    if (this.mIndicatorArea != null)
      adjustIndicatorPadding();
    updateLabelState(false);
  }

  private void setHintInternal(CharSequence paramCharSequence)
  {
    this.mHint = paramCharSequence;
    this.mCollapsingTextHelper.setText(paramCharSequence);
  }

  private void updateCounter(int paramInt)
  {
    boolean bool2 = this.mCounterOverflowed;
    if (this.mCounterMaxLength == -1)
    {
      this.mCounterView.setText(String.valueOf(paramInt));
      this.mCounterOverflowed = false;
      if ((this.mEditText != null) && (bool2 != this.mCounterOverflowed))
      {
        updateLabelState(false);
        updateEditTextBackground();
      }
      return;
    }
    boolean bool1;
    label66: TextView localTextView;
    Context localContext;
    if (paramInt > this.mCounterMaxLength)
    {
      bool1 = true;
      this.mCounterOverflowed = bool1;
      if (bool2 != this.mCounterOverflowed)
      {
        localTextView = this.mCounterView;
        localContext = getContext();
        if (!this.mCounterOverflowed)
          break label158;
      }
    }
    label158: for (int i = this.mCounterOverflowTextAppearance; ; i = this.mCounterTextAppearance)
    {
      localTextView.setTextAppearance(localContext, i);
      this.mCounterView.setText(getContext().getString(R.string.character_counter_pattern, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mCounterMaxLength) }));
      break;
      bool1 = false;
      break label66;
    }
  }

  private void updateEditTextBackground()
  {
    ensureBackgroundDrawableStateWorkaround();
    Drawable localDrawable2 = this.mEditText.getBackground();
    if (localDrawable2 == null)
      return;
    Drawable localDrawable1 = localDrawable2;
    if (android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(localDrawable2))
      localDrawable1 = localDrawable2.mutate();
    if ((this.mErrorShown) && (this.mErrorView != null))
    {
      localDrawable1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.mErrorView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((this.mCounterOverflowed) && (this.mCounterView != null))
    {
      localDrawable1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.mCounterView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    clearColorFilter(localDrawable1);
    this.mEditText.refreshDrawableState();
  }

  private LinearLayout.LayoutParams updateEditTextMargin(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LinearLayout.LayoutParams));
    for (paramLayoutParams = (LinearLayout.LayoutParams)paramLayoutParams; this.mHintEnabled; paramLayoutParams = new LinearLayout.LayoutParams(paramLayoutParams))
    {
      if (this.mTmpPaint == null)
        this.mTmpPaint = new Paint();
      this.mTmpPaint.setTypeface(this.mCollapsingTextHelper.getCollapsedTypeface());
      this.mTmpPaint.setTextSize(this.mCollapsingTextHelper.getCollapsedTextSize());
      paramLayoutParams.topMargin = (int)(-this.mTmpPaint.ascent());
      return paramLayoutParams;
    }
    paramLayoutParams.topMargin = 0;
    return paramLayoutParams;
  }

  private void updateLabelState(boolean paramBoolean)
  {
    int i;
    boolean bool;
    int j;
    if ((this.mEditText != null) && (!TextUtils.isEmpty(this.mEditText.getText())))
    {
      i = 1;
      bool = arrayContains(getDrawableState(), 16842908);
      if (TextUtils.isEmpty(getError()))
        break label119;
      j = 1;
      label46: if (this.mDefaultTextColor != null)
        this.mCollapsingTextHelper.setExpandedTextColor(this.mDefaultTextColor.getDefaultColor());
      if ((!this.mCounterOverflowed) || (this.mCounterView == null))
        break label124;
      this.mCollapsingTextHelper.setCollapsedTextColor(this.mCounterView.getCurrentTextColor());
    }
    while (true)
    {
      if ((i == 0) && (!bool) && (j == 0))
        break label177;
      collapseHint(paramBoolean);
      return;
      i = 0;
      break;
      label119: j = 0;
      break label46;
      label124: if ((bool) && (this.mFocusedTextColor != null))
      {
        this.mCollapsingTextHelper.setCollapsedTextColor(this.mFocusedTextColor.getDefaultColor());
        continue;
      }
      if (this.mDefaultTextColor == null)
        continue;
      this.mCollapsingTextHelper.setCollapsedTextColor(this.mDefaultTextColor.getDefaultColor());
    }
    label177: expandHint(paramBoolean);
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      setEditText((EditText)paramView);
      super.addView(paramView, 0, updateEditTextMargin(paramLayoutParams));
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.mHintEnabled)
      this.mCollapsingTextHelper.draw(paramCanvas);
  }

  public int getCounterMaxLength()
  {
    return this.mCounterMaxLength;
  }

  @Nullable
  public EditText getEditText()
  {
    return this.mEditText;
  }

  @Nullable
  public CharSequence getError()
  {
    if (this.mErrorEnabled)
      return this.mError;
    return null;
  }

  @Nullable
  public CharSequence getHint()
  {
    if (this.mHintEnabled)
      return this.mHint;
    return null;
  }

  @NonNull
  public Typeface getTypeface()
  {
    return this.mCollapsingTextHelper.getCollapsedTypeface();
  }

  public boolean isCounterEnabled()
  {
    return this.mCounterEnabled;
  }

  public boolean isErrorEnabled()
  {
    return this.mErrorEnabled;
  }

  public boolean isHintAnimationEnabled()
  {
    return this.mHintAnimationEnabled;
  }

  public boolean isHintEnabled()
  {
    return this.mHintEnabled;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mHintEnabled) && (this.mEditText != null))
    {
      paramInt1 = this.mEditText.getLeft() + this.mEditText.getCompoundPaddingLeft();
      paramInt3 = this.mEditText.getRight() - this.mEditText.getCompoundPaddingRight();
      this.mCollapsingTextHelper.setExpandedBounds(paramInt1, this.mEditText.getTop() + this.mEditText.getCompoundPaddingTop(), paramInt3, this.mEditText.getBottom() - this.mEditText.getCompoundPaddingBottom());
      this.mCollapsingTextHelper.setCollapsedBounds(paramInt1, getPaddingTop(), paramInt3, paramInt4 - paramInt2 - getPaddingBottom());
      this.mCollapsingTextHelper.recalculate();
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setError(paramParcelable.error);
    requestLayout();
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.mErrorShown)
      localSavedState.error = getError();
    return localSavedState;
  }

  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    updateLabelState(ViewCompat.isLaidOut(this));
  }

  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.mCounterEnabled != paramBoolean)
    {
      if (!paramBoolean)
        break label131;
      this.mCounterView = new TextView(getContext());
      this.mCounterView.setMaxLines(1);
    }
    while (true)
    {
      try
      {
        this.mCounterView.setTextAppearance(getContext(), this.mCounterTextAppearance);
        addIndicator(this.mCounterView, -1);
        if (this.mEditText != null)
          continue;
        updateCounter(0);
        this.mCounterEnabled = paramBoolean;
        return;
      }
      catch (Exception localException)
      {
        this.mCounterView.setTextAppearance(getContext(), R.style.TextAppearance_AppCompat_Caption);
        this.mCounterView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
        continue;
        updateCounter(this.mEditText.getText().length());
        continue;
      }
      label131: removeIndicator(this.mCounterView);
      this.mCounterView = null;
    }
  }

  public void setCounterMaxLength(int paramInt)
  {
    if (this.mCounterMaxLength != paramInt)
    {
      if (paramInt <= 0)
        break label39;
      this.mCounterMaxLength = paramInt;
      if (this.mCounterEnabled)
        if (this.mEditText != null)
          break label47;
    }
    label39: label47: for (paramInt = 0; ; paramInt = this.mEditText.getText().length())
    {
      updateCounter(paramInt);
      return;
      this.mCounterMaxLength = -1;
      break;
    }
  }

  public void setError(@Nullable CharSequence paramCharSequence)
  {
    if (TextUtils.equals(this.mError, paramCharSequence));
    while (true)
    {
      return;
      this.mError = paramCharSequence;
      if (this.mErrorEnabled)
        break;
      if (TextUtils.isEmpty(paramCharSequence))
        continue;
      setErrorEnabled(true);
    }
    boolean bool2 = ViewCompat.isLaidOut(this);
    boolean bool1;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      bool1 = true;
      this.mErrorShown = bool1;
      ViewCompat.animate(this.mErrorView).cancel();
      if (!this.mErrorShown)
        break label164;
      this.mErrorView.setText(paramCharSequence);
      this.mErrorView.setVisibility(0);
      if (bool2)
      {
        if (ViewCompat.getAlpha(this.mErrorView) == 1.0F)
          ViewCompat.setAlpha(this.mErrorView, 0.0F);
        ViewCompat.animate(this.mErrorView).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter()
        {
          public void onAnimationStart(View paramView)
          {
            paramView.setVisibility(0);
          }
        }).start();
      }
    }
    while (true)
    {
      updateEditTextBackground();
      updateLabelState(true);
      return;
      bool1 = false;
      break;
      label164: if (this.mErrorView.getVisibility() != 0)
        continue;
      if (bool2)
      {
        ViewCompat.animate(this.mErrorView).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter(paramCharSequence)
        {
          public void onAnimationEnd(View paramView)
          {
            TextInputLayout.this.mErrorView.setText(this.val$error);
            paramView.setVisibility(4);
          }
        }).start();
        continue;
      }
      this.mErrorView.setVisibility(4);
    }
  }

  public void setErrorEnabled(boolean paramBoolean)
  {
    if (this.mErrorEnabled != paramBoolean)
    {
      if (this.mErrorView != null)
        ViewCompat.animate(this.mErrorView).cancel();
      if (!paramBoolean)
        break label125;
    }
    for (this.mErrorView = new TextView(getContext()); ; this.mErrorView = null)
    {
      try
      {
        this.mErrorView.setTextAppearance(getContext(), this.mErrorTextAppearance);
        this.mErrorView.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.mErrorView, 1);
        addIndicator(this.mErrorView, 0);
        this.mErrorEnabled = paramBoolean;
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          this.mErrorView.setTextAppearance(getContext(), R.style.TextAppearance_AppCompat_Caption);
          this.mErrorView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
        }
      }
      label125: this.mErrorShown = false;
      updateEditTextBackground();
      removeIndicator(this.mErrorView);
    }
  }

  public void setHint(@Nullable CharSequence paramCharSequence)
  {
    if (this.mHintEnabled)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }

  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.mHintAnimationEnabled = paramBoolean;
  }

  public void setHintEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean != this.mHintEnabled)
    {
      this.mHintEnabled = paramBoolean;
      localObject = this.mEditText.getHint();
      if (this.mHintEnabled)
        break label89;
      if ((!TextUtils.isEmpty(this.mHint)) && (TextUtils.isEmpty((CharSequence)localObject)))
        this.mEditText.setHint(this.mHint);
      setHintInternal(null);
    }
    while (true)
    {
      if (this.mEditText != null)
      {
        localObject = updateEditTextMargin(this.mEditText.getLayoutParams());
        this.mEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      label89: if (TextUtils.isEmpty((CharSequence)localObject))
        continue;
      if (TextUtils.isEmpty(this.mHint))
        setHint((CharSequence)localObject);
      this.mEditText.setHint(null);
    }
  }

  public void setHintTextAppearance(@StyleRes int paramInt)
  {
    this.mCollapsingTextHelper.setCollapsedTextAppearance(paramInt);
    this.mFocusedTextColor = ColorStateList.valueOf(this.mCollapsingTextHelper.getCollapsedTextColor());
    if (this.mEditText != null)
    {
      updateLabelState(false);
      LinearLayout.LayoutParams localLayoutParams = updateEditTextMargin(this.mEditText.getLayoutParams());
      this.mEditText.setLayoutParams(localLayoutParams);
      this.mEditText.requestLayout();
    }
  }

  public void setTypeface(@Nullable Typeface paramTypeface)
  {
    this.mCollapsingTextHelper.setTypefaces(paramTypeface);
  }

  static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public TextInputLayout.SavedState createFromParcel(Parcel paramParcel)
      {
        return new TextInputLayout.SavedState(paramParcel);
      }

      public TextInputLayout.SavedState[] newArray(int paramInt)
      {
        return new TextInputLayout.SavedState[paramInt];
      }
    };
    CharSequence error;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.error = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public String toString()
    {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.error, paramParcel, paramInt);
    }
  }

  private class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat
  {
    private TextInputAccessibilityDelegate()
    {
    }

    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
    }

    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
      paramView = TextInputLayout.this.mCollapsingTextHelper.getText();
      if (!TextUtils.isEmpty(paramView))
        paramAccessibilityNodeInfoCompat.setText(paramView);
      if (TextInputLayout.this.mEditText != null)
        paramAccessibilityNodeInfoCompat.setLabelFor(TextInputLayout.this.mEditText);
      if (TextInputLayout.this.mErrorView != null);
      for (paramView = TextInputLayout.this.mErrorView.getText(); ; paramView = null)
      {
        if (!TextUtils.isEmpty(paramView))
        {
          paramAccessibilityNodeInfoCompat.setContentInvalid(true);
          paramAccessibilityNodeInfoCompat.setError(paramView);
        }
        return;
      }
    }

    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = TextInputLayout.this.mCollapsingTextHelper.getText();
      if (!TextUtils.isEmpty(paramView))
        paramAccessibilityEvent.getText().add(paramView);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout
 * JD-Core Version:    0.6.0
 */