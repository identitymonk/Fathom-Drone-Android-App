package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactFontManager;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.yoga.YogaConstants;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="AndroidTextInput")
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode>
{
  private static final int BLUR_TEXT_INPUT = 2;
  private static final InputFilter[] EMPTY_FILTERS;
  private static final int FOCUS_TEXT_INPUT = 1;
  private static final int IME_ACTION_ID = 1648;
  private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
  private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
  private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
  private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
  protected static final String REACT_CLASS = "AndroidTextInput";
  private static final int[] SPACING_TYPES = { 8, 0, 2, 1, 3 };
  private static final int UNSET = -1;

  static
  {
    EMPTY_FILTERS = new InputFilter[0];
  }

  private static void checkPasswordType(ReactEditText paramReactEditText)
  {
    if (((paramReactEditText.getStagedInputType() & 0x3002) != 0) && ((paramReactEditText.getStagedInputType() & 0x80) != 0))
      updateStagedInputTypeFlag(paramReactEditText, 128, 16);
  }

  private static int parseNumericFontWeight(String paramString)
  {
    if ((paramString.length() == 3) && (paramString.endsWith("00")) && (paramString.charAt(0) <= '9') && (paramString.charAt(0) >= '1'))
      return (paramString.charAt(0) - '0') * 100;
    return -1;
  }

  private void setCursorColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    try
    {
      Object localObject = TextView.class.getDeclaredField("mCursorDrawableRes");
      ((Field)localObject).setAccessible(true);
      int i = ((Field)localObject).getInt(paramReactEditText);
      localObject = ContextCompat.getDrawable(paramReactEditText.getContext(), i);
      if (paramInteger != null)
        ((Drawable)localObject).setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
      paramInteger = TextView.class.getDeclaredField("mEditor");
      paramInteger.setAccessible(true);
      paramReactEditText = paramInteger.get(paramReactEditText);
      paramInteger = paramReactEditText.getClass().getDeclaredField("mCursorDrawable");
      paramInteger.setAccessible(true);
      paramInteger.set(paramReactEditText, new Drawable[] { localObject, localObject });
      return;
    }
    catch (java.lang.IllegalAccessException paramReactEditText)
    {
      return;
    }
    catch (java.lang.NoSuchFieldException paramReactEditText)
    {
    }
  }

  private static void updateStagedInputTypeFlag(ReactEditText paramReactEditText, int paramInt1, int paramInt2)
  {
    paramReactEditText.setStagedInputType(paramReactEditText.getStagedInputType() & (paramInt1 ^ 0xFFFFFFFF) | paramInt2);
  }

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactEditText paramReactEditText)
  {
    paramReactEditText.addTextChangedListener(new ReactTextInputTextWatcher(paramThemedReactContext, paramReactEditText));
    paramReactEditText.setOnFocusChangeListener(new View.OnFocusChangeListener(paramThemedReactContext, paramReactEditText)
    {
      public void onFocusChange(View paramView, boolean paramBoolean)
      {
        paramView = ((UIManagerModule)this.val$reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        if (paramBoolean)
        {
          paramView.dispatchEvent(new ReactTextInputFocusEvent(this.val$editText.getId()));
          return;
        }
        paramView.dispatchEvent(new ReactTextInputBlurEvent(this.val$editText.getId()));
        paramView.dispatchEvent(new ReactTextInputEndEditingEvent(this.val$editText.getId(), this.val$editText.getText().toString()));
      }
    });
    paramReactEditText.setOnEditorActionListener(new TextView.OnEditorActionListener(paramReactEditText, paramThemedReactContext)
    {
      public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
      {
        boolean bool2 = false;
        boolean bool1 = true;
        if (((paramInt & 0xFF) > 0) || (paramInt == 0))
        {
          bool1 = this.val$editText.getBlurOnSubmit();
          if ((this.val$editText.getInputType() & 0x20000) == 0)
            break label115;
        }
        label115: for (paramInt = 1; ; paramInt = 0)
        {
          ((UIManagerModule)this.val$reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactTextInputSubmitEditingEvent(this.val$editText.getId(), this.val$editText.getText().toString()));
          if (bool1)
            this.val$editText.clearFocus();
          if (!bool1)
          {
            bool1 = bool2;
            if (paramInt != 0);
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
      }
    });
  }

  public LayoutShadowNode createShadowNodeInstance()
  {
    return new ReactTextInputShadowNode();
  }

  public ReactEditText createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    paramThemedReactContext = new ReactEditText(paramThemedReactContext);
    paramThemedReactContext.setInputType(0xFFFDFFFF & paramThemedReactContext.getInputType());
    paramThemedReactContext.setReturnKeyType("done");
    paramThemedReactContext.setTextSize(0, (int)Math.ceil(PixelUtil.toPixelFromSP(14.0F)));
    return paramThemedReactContext;
  }

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("focusTextInput", Integer.valueOf(1), "blurTextInput", Integer.valueOf(2));
  }

  @Nullable
  public Map<String, Object> getExportedCustomBubblingEventTypeConstants()
  {
    return MapBuilder.builder().put("topSubmitEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).put("topEndEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).put("topTextInput", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTextInput", "captured", "onTextInputCapture"))).put("topFocus", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFocus", "captured", "onFocusCapture"))).put("topBlur", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onBlur", "captured", "onBlurCapture"))).build();
  }

  @Nullable
  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.builder().put(ScrollEventType.SCROLL.getJSEventName(), MapBuilder.of("registrationName", "onScroll")).build();
  }

  @Nullable
  public Map getExportedViewConstants()
  {
    return MapBuilder.of("AutoCapitalizationType", MapBuilder.of("none", Integer.valueOf(0), "characters", Integer.valueOf(4096), "words", Integer.valueOf(8192), "sentences", Integer.valueOf(16384)));
  }

  public String getName()
  {
    return "AndroidTextInput";
  }

  public Class<? extends LayoutShadowNode> getShadowNodeClass()
  {
    return ReactTextInputShadowNode.class;
  }

  protected void onAfterUpdateTransaction(ReactEditText paramReactEditText)
  {
    super.onAfterUpdateTransaction(paramReactEditText);
    paramReactEditText.commitStagedInputType();
  }

  public void receiveCommand(ReactEditText paramReactEditText, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      paramReactEditText.requestFocusFromJS();
      return;
    case 2:
    }
    paramReactEditText.clearFocusFromJS();
  }

  @ReactProp(name="autoCapitalize")
  public void setAutoCapitalize(ReactEditText paramReactEditText, int paramInt)
  {
    updateStagedInputTypeFlag(paramReactEditText, 28672, paramInt);
  }

  @ReactProp(name="autoCorrect")
  public void setAutoCorrect(ReactEditText paramReactEditText, @Nullable Boolean paramBoolean)
  {
    int i;
    if (paramBoolean != null)
      if (paramBoolean.booleanValue())
        i = 32768;
    while (true)
    {
      updateStagedInputTypeFlag(paramReactEditText, 557056, i);
      return;
      i = 524288;
      continue;
      i = 0;
    }
  }

  @ReactProp(name="blurOnSubmit")
  public void setBlurOnSubmit(ReactEditText paramReactEditText, @Nullable Boolean paramBoolean)
  {
    paramReactEditText.setBlurOnSubmit(paramBoolean);
  }

  @ReactPropGroup(customType="Color", names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
  public void setBorderColor(ReactEditText paramReactEditText, int paramInt, Integer paramInteger)
  {
    float f2 = (0.0F / 0.0F);
    float f1;
    if (paramInteger == null)
    {
      f1 = (0.0F / 0.0F);
      if (paramInteger != null)
        break label46;
    }
    while (true)
    {
      paramReactEditText.setBorderColor(SPACING_TYPES[paramInt], f1, f2);
      return;
      f1 = paramInteger.intValue() & 0xFFFFFF;
      break;
      label46: f2 = paramInteger.intValue() >>> 24;
    }
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
  public void setBorderRadius(ReactEditText paramReactEditText, int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (!YogaConstants.isUndefined(paramFloat))
      f = PixelUtil.toPixelFromDIP(paramFloat);
    if (paramInt == 0)
    {
      paramReactEditText.setBorderRadius(f);
      return;
    }
    paramReactEditText.setBorderRadius(f, paramInt - 1);
  }

  @ReactProp(name="borderStyle")
  public void setBorderStyle(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    paramReactEditText.setBorderStyle(paramString);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidth(ReactEditText paramReactEditText, int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (!YogaConstants.isUndefined(paramFloat))
      f = PixelUtil.toPixelFromDIP(paramFloat);
    paramReactEditText.setBorderWidth(SPACING_TYPES[paramInt], f);
  }

  @ReactProp(defaultBoolean=false, name="caretHidden")
  public void setCaretHidden(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (paramBoolean = true; ; paramBoolean = false)
    {
      paramReactEditText.setCursorVisible(paramBoolean);
      return;
    }
  }

  @ReactProp(customType="Color", name="color")
  public void setColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactEditText.setTextColor(DefaultStyleValuesUtil.getDefaultTextColor(paramReactEditText.getContext()));
      return;
    }
    paramReactEditText.setTextColor(paramInteger.intValue());
  }

  @ReactProp(defaultBoolean=false, name="disableFullscreenUI")
  public void setDisableFullscreenUI(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    paramReactEditText.setDisableFullscreenUI(paramBoolean);
  }

  @ReactProp(defaultBoolean=true, name="editable")
  public void setEditable(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    paramReactEditText.setEnabled(paramBoolean);
  }

  @ReactProp(name="fontFamily")
  public void setFontFamily(ReactEditText paramReactEditText, String paramString)
  {
    int i = 0;
    if (paramReactEditText.getTypeface() != null)
      i = paramReactEditText.getTypeface().getStyle();
    paramReactEditText.setTypeface(ReactFontManager.getInstance().getTypeface(paramString, i, paramReactEditText.getContext().getAssets()));
  }

  @ReactProp(defaultFloat=14.0F, name="fontSize")
  public void setFontSize(ReactEditText paramReactEditText, float paramFloat)
  {
    paramReactEditText.setTextSize(0, (int)Math.ceil(PixelUtil.toPixelFromSP(paramFloat)));
  }

  @ReactProp(name="fontStyle")
  public void setFontStyle(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    int i = -1;
    if ("italic".equals(paramString))
      i = 2;
    while (true)
    {
      Typeface localTypeface = paramReactEditText.getTypeface();
      paramString = localTypeface;
      if (localTypeface == null)
        paramString = Typeface.DEFAULT;
      if (i != paramString.getStyle())
        paramReactEditText.setTypeface(paramString, i);
      return;
      if (!"normal".equals(paramString))
        continue;
      i = 0;
    }
  }

  @ReactProp(name="fontWeight")
  public void setFontWeight(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    int j;
    int k;
    int i;
    if (paramString != null)
    {
      j = parseNumericFontWeight(paramString);
      k = -1;
      if ((j < 500) && (!"bold".equals(paramString)))
        break label72;
      i = 1;
    }
    while (true)
    {
      Typeface localTypeface = paramReactEditText.getTypeface();
      paramString = localTypeface;
      if (localTypeface == null)
        paramString = Typeface.DEFAULT;
      if (i != paramString.getStyle())
        paramReactEditText.setTypeface(paramString, i);
      return;
      j = -1;
      break;
      label72: if (!"normal".equals(paramString))
      {
        i = k;
        if (j == -1)
          continue;
        i = k;
        if (j >= 500)
          continue;
      }
      i = 0;
    }
  }

  @ReactProp(name="inlineImageLeft")
  public void setInlineImageLeft(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    paramReactEditText.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.getInstance().getResourceDrawableId(paramReactEditText.getContext(), paramString), 0, 0, 0);
  }

  @ReactProp(name="inlineImagePadding")
  public void setInlineImagePadding(ReactEditText paramReactEditText, int paramInt)
  {
    paramReactEditText.setCompoundDrawablePadding(paramInt);
  }

  @ReactProp(name="keyboardType")
  public void setKeyboardType(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    int i = 1;
    if ("numeric".equalsIgnoreCase(paramString))
      i = 12290;
    while (true)
    {
      updateStagedInputTypeFlag(paramReactEditText, 12323, i);
      checkPasswordType(paramReactEditText);
      return;
      if ("email-address".equalsIgnoreCase(paramString))
      {
        i = 33;
        continue;
      }
      if (!"phone-pad".equalsIgnoreCase(paramString))
        continue;
      i = 3;
    }
  }

  @ReactProp(name="maxLength")
  public void setMaxLength(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    InputFilter[] arrayOfInputFilter2 = paramReactEditText.getFilters();
    InputFilter[] arrayOfInputFilter3 = EMPTY_FILTERS;
    InputFilter[] arrayOfInputFilter1;
    int i;
    if (paramInteger == null)
    {
      arrayOfInputFilter1 = arrayOfInputFilter3;
      if (arrayOfInputFilter2.length > 0)
      {
        paramInteger = new LinkedList();
        i = 0;
        while (i < arrayOfInputFilter2.length)
        {
          if (!(arrayOfInputFilter2[i] instanceof InputFilter.LengthFilter))
            paramInteger.add(arrayOfInputFilter2[i]);
          i += 1;
        }
        arrayOfInputFilter1 = arrayOfInputFilter3;
        if (!paramInteger.isEmpty())
          arrayOfInputFilter1 = (InputFilter[])(InputFilter[])paramInteger.toArray(new InputFilter[paramInteger.size()]);
      }
    }
    while (true)
    {
      paramReactEditText.setFilters(arrayOfInputFilter1);
      return;
      if (arrayOfInputFilter2.length > 0)
      {
        arrayOfInputFilter1 = arrayOfInputFilter2;
        int j = 0;
        i = 0;
        while (i < arrayOfInputFilter2.length)
        {
          if ((arrayOfInputFilter2[i] instanceof InputFilter.LengthFilter))
          {
            arrayOfInputFilter2[i] = new InputFilter.LengthFilter(paramInteger.intValue());
            j = 1;
          }
          i += 1;
        }
        if (j != 0)
          continue;
        arrayOfInputFilter1 = new InputFilter[arrayOfInputFilter2.length + 1];
        System.arraycopy(arrayOfInputFilter2, 0, arrayOfInputFilter1, 0, arrayOfInputFilter2.length);
        arrayOfInputFilter2[arrayOfInputFilter2.length] = new InputFilter.LengthFilter(paramInteger.intValue());
        continue;
      }
      arrayOfInputFilter1 = new InputFilter[1];
      arrayOfInputFilter1[0] = new InputFilter.LengthFilter(paramInteger.intValue());
    }
  }

  @ReactProp(defaultBoolean=false, name="multiline")
  public void setMultiline(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    int j = 131072;
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean)
        break label30;
    }
    while (true)
    {
      updateStagedInputTypeFlag(paramReactEditText, i, j);
      return;
      i = 131072;
      break;
      label30: j = 0;
    }
  }

  @ReactProp(defaultInt=1, name="numberOfLines")
  public void setNumLines(ReactEditText paramReactEditText, int paramInt)
  {
    paramReactEditText.setLines(paramInt);
  }

  @ReactProp(defaultBoolean=false, name="onContentSizeChange")
  public void setOnContentSizeChange(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramReactEditText.setContentSizeWatcher(new ReactContentSizeWatcher(paramReactEditText));
      return;
    }
    paramReactEditText.setContentSizeWatcher(null);
  }

  @ReactProp(defaultBoolean=false, name="onScroll")
  public void setOnScroll(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramReactEditText.setScrollWatcher(new ReactScrollWatcher(paramReactEditText));
      return;
    }
    paramReactEditText.setScrollWatcher(null);
  }

  @ReactProp(defaultBoolean=false, name="onSelectionChange")
  public void setOnSelectionChange(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramReactEditText.setSelectionWatcher(new ReactSelectionWatcher(paramReactEditText));
      return;
    }
    paramReactEditText.setSelectionWatcher(null);
  }

  @ReactProp(name="placeholder")
  public void setPlaceholder(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    paramReactEditText.setHint(paramString);
  }

  @ReactProp(customType="Color", name="placeholderTextColor")
  public void setPlaceholderTextColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactEditText.setHintTextColor(DefaultStyleValuesUtil.getDefaultTextColorHint(paramReactEditText.getContext()));
      return;
    }
    paramReactEditText.setHintTextColor(paramInteger.intValue());
  }

  @ReactProp(name="returnKeyLabel")
  public void setReturnKeyLabel(ReactEditText paramReactEditText, String paramString)
  {
    paramReactEditText.setImeActionLabel(paramString, 1648);
  }

  @ReactProp(name="returnKeyType")
  public void setReturnKeyType(ReactEditText paramReactEditText, String paramString)
  {
    paramReactEditText.setReturnKeyType(paramString);
  }

  @ReactProp(defaultBoolean=false, name="secureTextEntry")
  public void setSecureTextEntry(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean);
    for (int i = 0; ; i = 144)
    {
      if (paramBoolean)
        j = 128;
      updateStagedInputTypeFlag(paramReactEditText, i, j);
      checkPasswordType(paramReactEditText);
      return;
    }
  }

  @ReactProp(defaultBoolean=false, name="selectTextOnFocus")
  public void setSelectTextOnFocus(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    paramReactEditText.setSelectAllOnFocus(paramBoolean);
  }

  @ReactProp(name="selection")
  public void setSelection(ReactEditText paramReactEditText, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null);
    do
      return;
    while ((!paramReadableMap.hasKey("start")) || (!paramReadableMap.hasKey("end")));
    paramReactEditText.setSelection(paramReadableMap.getInt("start"), paramReadableMap.getInt("end"));
  }

  @ReactProp(customType="Color", name="selectionColor")
  public void setSelectionColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
      paramReactEditText.setHighlightColor(DefaultStyleValuesUtil.getDefaultTextColorHighlight(paramReactEditText.getContext()));
    while (true)
    {
      setCursorColor(paramReactEditText, paramInteger);
      return;
      paramReactEditText.setHighlightColor(paramInteger.intValue());
    }
  }

  @ReactProp(name="textAlign")
  public void setTextAlign(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    if ((paramString == null) || ("auto".equals(paramString)))
    {
      paramReactEditText.setGravityHorizontal(0);
      return;
    }
    if ("left".equals(paramString))
    {
      paramReactEditText.setGravityHorizontal(3);
      return;
    }
    if ("right".equals(paramString))
    {
      paramReactEditText.setGravityHorizontal(5);
      return;
    }
    if ("center".equals(paramString))
    {
      paramReactEditText.setGravityHorizontal(1);
      return;
    }
    if ("justify".equals(paramString))
    {
      paramReactEditText.setGravityHorizontal(3);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + paramString);
  }

  @ReactProp(name="textAlignVertical")
  public void setTextAlignVertical(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    if ((paramString == null) || ("auto".equals(paramString)))
    {
      paramReactEditText.setGravityVertical(0);
      return;
    }
    if ("top".equals(paramString))
    {
      paramReactEditText.setGravityVertical(48);
      return;
    }
    if ("bottom".equals(paramString))
    {
      paramReactEditText.setGravityVertical(80);
      return;
    }
    if ("center".equals(paramString))
    {
      paramReactEditText.setGravityVertical(16);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + paramString);
  }

  @ReactProp(customType="Color", name="underlineColorAndroid")
  public void setUnderlineColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    paramReactEditText = paramReactEditText.getBackground();
    if (paramReactEditText.getConstantState() != null)
      paramReactEditText = paramReactEditText.mutate();
    while (paramInteger == null)
    {
      paramReactEditText.clearColorFilter();
      return;
    }
    paramReactEditText.setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
  }

  public void updateExtraData(ReactEditText paramReactEditText, Object paramObject)
  {
    if ((paramObject instanceof ReactTextUpdate))
    {
      paramObject = (ReactTextUpdate)paramObject;
      paramReactEditText.setPadding((int)paramObject.getPaddingLeft(), (int)paramObject.getPaddingTop(), (int)paramObject.getPaddingRight(), (int)paramObject.getPaddingBottom());
      if (paramObject.containsImages())
        TextInlineImageSpan.possiblyUpdateInlineImageSpans(paramObject.getText(), paramReactEditText);
      paramReactEditText.maybeSetText(paramObject);
    }
  }

  private class ReactContentSizeWatcher
    implements ContentSizeWatcher
  {
    private ReactEditText mEditText;
    private EventDispatcher mEventDispatcher;
    private int mPreviousContentHeight = 0;
    private int mPreviousContentWidth = 0;

    public ReactContentSizeWatcher(ReactEditText arg2)
    {
      Object localObject;
      this.mEditText = localObject;
      this.mEventDispatcher = ((UIManagerModule)((ReactContext)localObject.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void onLayout()
    {
      int j = this.mEditText.getWidth();
      int i = this.mEditText.getHeight();
      if (this.mEditText.getLayout() != null)
      {
        j = this.mEditText.getCompoundPaddingLeft() + this.mEditText.getLayout().getWidth() + this.mEditText.getCompoundPaddingRight();
        i = this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight() + this.mEditText.getCompoundPaddingBottom();
      }
      if ((j != this.mPreviousContentWidth) || (i != this.mPreviousContentHeight))
      {
        this.mPreviousContentHeight = i;
        this.mPreviousContentWidth = j;
        this.mEventDispatcher.dispatchEvent(new ReactContentSizeChangedEvent(this.mEditText.getId(), PixelUtil.toDIPFromPixel(j), PixelUtil.toDIPFromPixel(i)));
      }
    }
  }

  private class ReactScrollWatcher
    implements ScrollWatcher
  {
    private EventDispatcher mEventDispatcher;
    private int mPreviousHoriz;
    private int mPreviousVert;
    private ReactEditText mReactEditText;

    public ReactScrollWatcher(ReactEditText arg2)
    {
      Object localObject;
      this.mReactEditText = localObject;
      this.mEventDispatcher = ((UIManagerModule)((ReactContext)localObject.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if ((this.mPreviousHoriz != paramInt1) || (this.mPreviousVert != paramInt2))
      {
        ScrollEvent localScrollEvent = ScrollEvent.obtain(this.mReactEditText.getId(), ScrollEventType.SCROLL, paramInt1, paramInt2, 0.0F, 0.0F, 0, 0, this.mReactEditText.getWidth(), this.mReactEditText.getHeight());
        this.mEventDispatcher.dispatchEvent(localScrollEvent);
        this.mPreviousHoriz = paramInt1;
        this.mPreviousVert = paramInt2;
      }
    }
  }

  private class ReactSelectionWatcher
    implements SelectionWatcher
  {
    private EventDispatcher mEventDispatcher;
    private int mPreviousSelectionEnd;
    private int mPreviousSelectionStart;
    private ReactEditText mReactEditText;

    public ReactSelectionWatcher(ReactEditText arg2)
    {
      Object localObject;
      this.mReactEditText = localObject;
      this.mEventDispatcher = ((UIManagerModule)((ReactContext)localObject.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void onSelectionChanged(int paramInt1, int paramInt2)
    {
      if ((this.mPreviousSelectionStart != paramInt1) || (this.mPreviousSelectionEnd != paramInt2))
      {
        this.mEventDispatcher.dispatchEvent(new ReactTextInputSelectionEvent(this.mReactEditText.getId(), paramInt1, paramInt2));
        this.mPreviousSelectionStart = paramInt1;
        this.mPreviousSelectionEnd = paramInt2;
      }
    }
  }

  private class ReactTextInputTextWatcher
    implements TextWatcher
  {
    private ReactEditText mEditText;
    private EventDispatcher mEventDispatcher;
    private String mPreviousText;

    public ReactTextInputTextWatcher(ReactContext paramReactEditText, ReactEditText arg3)
    {
      this.mEventDispatcher = ((UIManagerModule)paramReactEditText.getNativeModule(UIManagerModule.class)).getEventDispatcher();
      Object localObject;
      this.mEditText = localObject;
      this.mPreviousText = null;
    }

    public void afterTextChanged(Editable paramEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      this.mPreviousText = paramCharSequence.toString();
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt3 == 0) && (paramInt2 == 0));
      String str1;
      String str2;
      do
      {
        return;
        Assertions.assertNotNull(this.mPreviousText);
        str1 = paramCharSequence.toString().substring(paramInt1, paramInt1 + paramInt3);
        str2 = this.mPreviousText.substring(paramInt1, paramInt1 + paramInt2);
      }
      while ((paramInt3 == paramInt2) && (str1.equals(str2)));
      this.mEventDispatcher.dispatchEvent(new ReactTextChangedEvent(this.mEditText.getId(), paramCharSequence.toString(), this.mEditText.incrementAndGetEventCounter()));
      this.mEventDispatcher.dispatchEvent(new ReactTextInputEvent(this.mEditText.getId(), str1, str2, paramInt1, paramInt1 + paramInt2));
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.textinput.ReactTextInputManager
 * JD-Core Version:    0.6.0
 */