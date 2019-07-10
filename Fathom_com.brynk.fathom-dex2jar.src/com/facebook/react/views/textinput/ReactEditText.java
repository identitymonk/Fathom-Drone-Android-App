package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.text.CustomStyleSpan;
import com.facebook.react.views.text.ReactTagSpan;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

public class ReactEditText extends EditText
{
  private static final KeyListener sKeyListener = QwertyKeyListener.getInstanceForFullKeyboard();

  @Nullable
  private Boolean mBlurOnSubmit;
  private boolean mContainsImages;

  @Nullable
  private ContentSizeWatcher mContentSizeWatcher;
  private int mDefaultGravityHorizontal;
  private int mDefaultGravityVertical;
  private boolean mDetectScrollMovement = false;
  private boolean mDisableFullscreen;
  private final InputMethodManager mInputMethodManager;
  private boolean mIsJSSettingFocus;
  private boolean mIsSettingTextFromJS;
  private final InternalKeyListener mKeyListener;

  @Nullable
  private ArrayList<TextWatcher> mListeners;
  private int mMostRecentEventCount;
  private int mNativeEventCount;
  private ReactViewBackgroundManager mReactBackgroundManager;

  @Nullable
  private String mReturnKeyType;

  @Nullable
  private ScrollWatcher mScrollWatcher;

  @Nullable
  private SelectionWatcher mSelectionWatcher;
  private int mStagedInputType;

  @Nullable
  private TextWatcherDelegator mTextWatcherDelegator;

  public ReactEditText(Context paramContext)
  {
    super(paramContext);
    setFocusableInTouchMode(false);
    this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
    this.mInputMethodManager = ((InputMethodManager)Assertions.assertNotNull(getContext().getSystemService("input_method")));
    this.mDefaultGravityHorizontal = (getGravity() & 0x800007);
    this.mDefaultGravityVertical = (getGravity() & 0x70);
    this.mNativeEventCount = 0;
    this.mMostRecentEventCount = 0;
    this.mIsSettingTextFromJS = false;
    this.mIsJSSettingFocus = false;
    this.mBlurOnSubmit = null;
    this.mDisableFullscreen = false;
    this.mListeners = null;
    this.mTextWatcherDelegator = null;
    this.mStagedInputType = getInputType();
    this.mKeyListener = new InternalKeyListener();
    this.mScrollWatcher = null;
  }

  private TextWatcherDelegator getTextWatcherDelegator()
  {
    if (this.mTextWatcherDelegator == null)
      this.mTextWatcherDelegator = new TextWatcherDelegator(null);
    return this.mTextWatcherDelegator;
  }

  private void hideSoftKeyboard()
  {
    this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }

  private boolean isMultiline()
  {
    return (getInputType() & 0x20000) != 0;
  }

  private void manageSpans(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object[] arrayOfObject = getText().getSpans(0, length(), Object.class);
    int i = 0;
    if (i < arrayOfObject.length)
    {
      if ((ForegroundColorSpan.class.isInstance(arrayOfObject[i])) || (BackgroundColorSpan.class.isInstance(arrayOfObject[i])) || (AbsoluteSizeSpan.class.isInstance(arrayOfObject[i])) || (CustomStyleSpan.class.isInstance(arrayOfObject[i])) || (ReactTagSpan.class.isInstance(arrayOfObject[i])))
        getText().removeSpan(arrayOfObject[i]);
      if ((getText().getSpanFlags(arrayOfObject[i]) & 0x21) != 33);
      while (true)
      {
        i += 1;
        break;
        Object localObject = arrayOfObject[i];
        int j = getText().getSpanStart(arrayOfObject[i]);
        int k = getText().getSpanEnd(arrayOfObject[i]);
        int m = getText().getSpanFlags(arrayOfObject[i]);
        getText().removeSpan(arrayOfObject[i]);
        if (!sameTextForSpan(getText(), paramSpannableStringBuilder, j, k))
          continue;
        paramSpannableStringBuilder.setSpan(localObject, j, k, m);
      }
    }
  }

  private void onContentSizeChange()
  {
    if (this.mContentSizeWatcher != null)
      this.mContentSizeWatcher.onLayout();
    setIntrinsicContentSize();
  }

  private static boolean sameTextForSpan(Editable paramEditable, SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > paramSpannableStringBuilder.length()) || (paramInt2 > paramSpannableStringBuilder.length()))
      return false;
    while (true)
    {
      if (paramInt1 >= paramInt2)
        break label45;
      if (paramEditable.charAt(paramInt1) != paramSpannableStringBuilder.charAt(paramInt1))
        break;
      paramInt1 += 1;
    }
    label45: return true;
  }

  private void setIntrinsicContentSize()
  {
    UIManagerModule localUIManagerModule = (UIManagerModule)((ReactContext)getContext()).getNativeModule(UIManagerModule.class);
    ReactTextInputLocalData localReactTextInputLocalData = new ReactTextInputLocalData(this);
    localUIManagerModule.setViewLocalData(getId(), localReactTextInputLocalData);
  }

  private boolean showSoftKeyboard()
  {
    return this.mInputMethodManager.showSoftInput(this, 0);
  }

  private void updateImeOptions()
  {
    int j = 6;
    int i = j;
    String str;
    if (this.mReturnKeyType != null)
    {
      str = this.mReturnKeyType;
      i = -1;
      switch (str.hashCode())
      {
      default:
        switch (i)
        {
        default:
          i = j;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        }
      case 3304:
      case 3377907:
      case 3387192:
      case -1273775369:
      case -906336856:
      case 3526536:
      case 3089282:
      }
    }
    while (true)
    {
      if (!this.mDisableFullscreen)
        break label294;
      setImeOptions(0x2000000 | i);
      return;
      if (!str.equals("go"))
        break;
      i = 0;
      break;
      if (!str.equals("next"))
        break;
      i = 1;
      break;
      if (!str.equals("none"))
        break;
      i = 2;
      break;
      if (!str.equals("previous"))
        break;
      i = 3;
      break;
      if (!str.equals("search"))
        break;
      i = 4;
      break;
      if (!str.equals("send"))
        break;
      i = 5;
      break;
      if (!str.equals("done"))
        break;
      i = 6;
      break;
      i = 2;
      continue;
      i = 5;
      continue;
      i = 1;
      continue;
      i = 7;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 6;
    }
    label294: setImeOptions(i);
  }

  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    if (this.mListeners == null)
    {
      this.mListeners = new ArrayList();
      super.addTextChangedListener(getTextWatcherDelegator());
    }
    this.mListeners.add(paramTextWatcher);
  }

  public void clearFocus()
  {
    setFocusableInTouchMode(false);
    super.clearFocus();
    hideSoftKeyboard();
  }

  void clearFocusFromJS()
  {
    clearFocus();
  }

  void commitStagedInputType()
  {
    if (getInputType() != this.mStagedInputType)
      setInputType(this.mStagedInputType);
  }

  public boolean getBlurOnSubmit()
  {
    if (this.mBlurOnSubmit == null)
      return !isMultiline();
    return this.mBlurOnSubmit.booleanValue();
  }

  public boolean getDisableFullscreenUI()
  {
    return this.mDisableFullscreen;
  }

  public String getReturnKeyType()
  {
    return this.mReturnKeyType;
  }

  int getStagedInputType()
  {
    return this.mStagedInputType;
  }

  public int incrementAndGetEventCounter()
  {
    int i = this.mNativeEventCount + 1;
    this.mNativeEventCount = i;
    return i;
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    int i = 0;
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        if (localObject[i].getDrawable() == paramDrawable)
          invalidate();
        i += 1;
      }
    }
    super.invalidateDrawable(paramDrawable);
  }

  public boolean isLayoutRequested()
  {
    if (this.mContentSizeWatcher != null)
      return isMultiline();
    return false;
  }

  public void maybeSetText(ReactTextUpdate paramReactTextUpdate)
  {
    this.mMostRecentEventCount = paramReactTextUpdate.getJsEventCounter();
    if (this.mMostRecentEventCount < this.mNativeEventCount);
    do
    {
      return;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramReactTextUpdate.getText());
      manageSpans(localSpannableStringBuilder);
      this.mContainsImages = paramReactTextUpdate.containsImages();
      this.mIsSettingTextFromJS = true;
      getText().replace(0, length(), localSpannableStringBuilder);
      this.mIsSettingTextFromJS = false;
    }
    while ((Build.VERSION.SDK_INT < 23) || (getBreakStrategy() == paramReactTextUpdate.getTextBreakStrategy()));
    setBreakStrategy(paramReactTextUpdate.getTextBreakStrategy());
  }

  public void onAttachedToWindow()
  {
    int i = 0;
    super.onAttachedToWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].onAttachedToWindow();
        i += 1;
      }
    }
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((isMultiline()) && (getBlurOnSubmit()))
      paramEditorInfo.imeOptions &= -1073741825;
    return localInputConnection;
  }

  public void onDetachedFromWindow()
  {
    int i = 0;
    super.onDetachedFromWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].onDetachedFromWindow();
        i += 1;
      }
    }
  }

  public void onFinishTemporaryDetach()
  {
    int i = 0;
    super.onFinishTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].onFinishTemporaryDetach();
        i += 1;
      }
    }
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.mSelectionWatcher != null))
      this.mSelectionWatcher.onSelectionChanged(getSelectionStart(), getSelectionEnd());
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (!isMultiline()))
    {
      hideSoftKeyboard();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onContentSizeChange();
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mScrollWatcher != null)
      this.mScrollWatcher.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if ((this.mSelectionWatcher != null) && (hasFocus()))
      this.mSelectionWatcher.onSelectionChanged(paramInt1, paramInt2);
  }

  public void onStartTemporaryDetach()
  {
    int i = 0;
    super.onStartTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].onStartTemporaryDetach();
        i += 1;
      }
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mDetectScrollMovement = true;
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if (!this.mDetectScrollMovement)
        continue;
      if ((!canScrollVertically(-1)) && (!canScrollVertically(1)) && (!canScrollHorizontally(-1)) && (!canScrollHorizontally(1)))
        getParent().requestDisallowInterceptTouchEvent(false);
      this.mDetectScrollMovement = false;
    }
  }

  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    if (this.mListeners != null)
    {
      this.mListeners.remove(paramTextWatcher);
      if (this.mListeners.isEmpty())
      {
        this.mListeners = null;
        super.removeTextChangedListener(getTextWatcherDelegator());
      }
    }
  }

  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (isFocused())
      return true;
    if (!this.mIsJSSettingFocus)
      return false;
    setFocusableInTouchMode(true);
    boolean bool = super.requestFocus(paramInt, paramRect);
    showSoftKeyboard();
    return bool;
  }

  public void requestFocusFromJS()
  {
    this.mIsJSSettingFocus = true;
    requestFocus();
    this.mIsJSSettingFocus = false;
  }

  public void setBackgroundColor(int paramInt)
  {
    this.mReactBackgroundManager.setBackgroundColor(paramInt);
  }

  public void setBlurOnSubmit(@Nullable Boolean paramBoolean)
  {
    this.mBlurOnSubmit = paramBoolean;
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mReactBackgroundManager.setBorderColor(paramInt, paramFloat1, paramFloat2);
  }

  public void setBorderRadius(float paramFloat)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat);
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat, paramInt);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    this.mReactBackgroundManager.setBorderStyle(paramString);
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    this.mReactBackgroundManager.setBorderWidth(paramInt, paramFloat);
  }

  public void setContentSizeWatcher(ContentSizeWatcher paramContentSizeWatcher)
  {
    this.mContentSizeWatcher = paramContentSizeWatcher;
  }

  public void setDisableFullscreenUI(boolean paramBoolean)
  {
    this.mDisableFullscreen = paramBoolean;
    updateImeOptions();
  }

  void setGravityHorizontal(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
      i = this.mDefaultGravityHorizontal;
    setGravity(getGravity() & 0xFFFFFFF8 & 0xFF7FFFF8 | i);
  }

  void setGravityVertical(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
      i = this.mDefaultGravityVertical;
    setGravity(getGravity() & 0xFFFFFF8F | i);
  }

  public void setInputType(int paramInt)
  {
    Typeface localTypeface = super.getTypeface();
    super.setInputType(paramInt);
    this.mStagedInputType = paramInt;
    super.setTypeface(localTypeface);
    this.mKeyListener.setInputType(paramInt);
    setKeyListener(this.mKeyListener);
  }

  public void setReturnKeyType(String paramString)
  {
    this.mReturnKeyType = paramString;
    updateImeOptions();
  }

  public void setScrollWatcher(ScrollWatcher paramScrollWatcher)
  {
    this.mScrollWatcher = paramScrollWatcher;
  }

  public void setSelection(int paramInt1, int paramInt2)
  {
    if (this.mMostRecentEventCount < this.mNativeEventCount)
      return;
    super.setSelection(paramInt1, paramInt2);
  }

  public void setSelectionWatcher(SelectionWatcher paramSelectionWatcher)
  {
    this.mSelectionWatcher = paramSelectionWatcher;
  }

  void setStagedInputType(int paramInt)
  {
    this.mStagedInputType = paramInt;
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    int i = 0;
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      while (i < j)
      {
        if (localObject[i].getDrawable() == paramDrawable)
          return true;
        i += 1;
      }
    }
    return super.verifyDrawable(paramDrawable);
  }

  private static class InternalKeyListener
    implements KeyListener
  {
    private int mInputType = 0;

    public void clearMetaKeyState(View paramView, Editable paramEditable, int paramInt)
    {
      ReactEditText.sKeyListener.clearMetaKeyState(paramView, paramEditable, paramInt);
    }

    public int getInputType()
    {
      return this.mInputType;
    }

    public boolean onKeyDown(View paramView, Editable paramEditable, int paramInt, KeyEvent paramKeyEvent)
    {
      return ReactEditText.sKeyListener.onKeyDown(paramView, paramEditable, paramInt, paramKeyEvent);
    }

    public boolean onKeyOther(View paramView, Editable paramEditable, KeyEvent paramKeyEvent)
    {
      return ReactEditText.sKeyListener.onKeyOther(paramView, paramEditable, paramKeyEvent);
    }

    public boolean onKeyUp(View paramView, Editable paramEditable, int paramInt, KeyEvent paramKeyEvent)
    {
      return ReactEditText.sKeyListener.onKeyUp(paramView, paramEditable, paramInt, paramKeyEvent);
    }

    public void setInputType(int paramInt)
    {
      this.mInputType = paramInt;
    }
  }

  private class TextWatcherDelegator
    implements TextWatcher
  {
    private TextWatcherDelegator()
    {
    }

    public void afterTextChanged(Editable paramEditable)
    {
      if ((!ReactEditText.this.mIsSettingTextFromJS) && (ReactEditText.this.mListeners != null))
      {
        Iterator localIterator = ReactEditText.this.mListeners.iterator();
        while (localIterator.hasNext())
          ((TextWatcher)localIterator.next()).afterTextChanged(paramEditable);
      }
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((!ReactEditText.this.mIsSettingTextFromJS) && (ReactEditText.this.mListeners != null))
      {
        Iterator localIterator = ReactEditText.this.mListeners.iterator();
        while (localIterator.hasNext())
          ((TextWatcher)localIterator.next()).beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      }
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((!ReactEditText.this.mIsSettingTextFromJS) && (ReactEditText.this.mListeners != null))
      {
        Iterator localIterator = ReactEditText.this.mListeners.iterator();
        while (localIterator.hasNext())
          ((TextWatcher)localIterator.next()).onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      }
      ReactEditText.this.onContentSizeChange();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.textinput.ReactEditText
 * JD-Core Version:    0.6.0
 */