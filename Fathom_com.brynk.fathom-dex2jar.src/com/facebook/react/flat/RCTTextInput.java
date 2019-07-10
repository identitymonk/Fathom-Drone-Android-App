package com.facebook.react.flat;

import android.annotation.TargetApi;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.view.MeasureUtil;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import javax.annotation.Nullable;

public class RCTTextInput extends RCTVirtualText
  implements AndroidView, YogaMeasureFunction
{

  @Nullable
  private EditText mEditText;
  private int mJsEventCount = -1;
  private int mNumberOfLines = -1;
  private boolean mPaddingChanged = false;

  @Nullable
  private String mText;

  public RCTTextInput()
  {
    forceMountToView();
    setMeasureFunction(this);
  }

  boolean isEditable()
  {
    return true;
  }

  public boolean isPaddingChanged()
  {
    return this.mPaddingChanged;
  }

  public boolean isVirtual()
  {
    return false;
  }

  public boolean isVirtualAnchor()
  {
    return true;
  }

  public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    paramYogaNode = (EditText)Assertions.assertNotNull(this.mEditText);
    int i = getFontSize();
    float f;
    if (i == -1)
      f = (int)Math.ceil(PixelUtil.toPixelFromSP(14.0F));
    while (true)
    {
      paramYogaNode.setTextSize(0, f);
      if (this.mNumberOfLines != -1)
        paramYogaNode.setLines(this.mNumberOfLines);
      paramYogaNode.measure(MeasureUtil.getMeasureSpec(paramFloat1, paramYogaMeasureMode1), MeasureUtil.getMeasureSpec(paramFloat2, paramYogaMeasureMode2));
      return YogaMeasureOutput.make(paramYogaNode.getMeasuredWidth(), paramYogaNode.getMeasuredHeight());
      f = i;
    }
  }

  public boolean needsCustomLayoutForChildren()
  {
    return false;
  }

  protected void notifyChanged(boolean paramBoolean)
  {
    super.notifyChanged(paramBoolean);
    markUpdated();
  }

  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
    super.onCollectExtraUpdates(paramUIViewOperationQueue);
    if (this.mJsEventCount != -1)
    {
      ReactTextUpdate localReactTextUpdate = new ReactTextUpdate(getText(), this.mJsEventCount, false, getPadding(4), getPadding(1), getPadding(5), getPadding(3), -1);
      paramUIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), localReactTextUpdate);
    }
  }

  protected void performCollectText(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (this.mText != null)
      paramSpannableStringBuilder.append(this.mText);
    super.performCollectText(paramSpannableStringBuilder);
  }

  public void resetPaddingChanged()
  {
    this.mPaddingChanged = false;
  }

  public void setBackgroundColor(int paramInt)
  {
  }

  @ReactProp(name="mostRecentEventCount")
  public void setMostRecentEventCount(int paramInt)
  {
    this.mJsEventCount = paramInt;
  }

  @ReactProp(defaultInt=2147483647, name="numberOfLines")
  public void setNumberOfLines(int paramInt)
  {
    this.mNumberOfLines = paramInt;
    notifyChanged(true);
  }

  public void setPadding(int paramInt, float paramFloat)
  {
    super.setPadding(paramInt, paramFloat);
    this.mPaddingChanged = true;
    dirty();
  }

  @ReactProp(name="text")
  public void setText(@Nullable String paramString)
  {
    this.mText = paramString;
    notifyChanged(true);
  }

  @TargetApi(17)
  public void setThemedContext(ThemedReactContext paramThemedReactContext)
  {
    super.setThemedContext(paramThemedReactContext);
    this.mEditText = new EditText(paramThemedReactContext);
    this.mEditText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    setDefaultPadding(4, this.mEditText.getPaddingStart());
    setDefaultPadding(1, this.mEditText.getPaddingTop());
    setDefaultPadding(5, this.mEditText.getPaddingEnd());
    setDefaultPadding(3, this.mEditText.getPaddingBottom());
    this.mEditText.setPadding(0, 0, 0, 0);
  }

  boolean shouldAllowEmptySpans()
  {
    return true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTTextInput
 * JD-Core Version:    0.6.0
 */