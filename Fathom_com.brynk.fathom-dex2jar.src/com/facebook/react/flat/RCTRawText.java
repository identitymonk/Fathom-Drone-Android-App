package com.facebook.react.flat;

import android.text.SpannableStringBuilder;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

final class RCTRawText extends FlatTextShadowNode
{

  @Nullable
  private String mText;

  protected void performApplySpans(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramSpannableStringBuilder.setSpan(this, paramInt1, paramInt2, 17);
  }

  protected void performCollectAttachDetachListeners(StateBuilder paramStateBuilder)
  {
  }

  protected void performCollectText(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (this.mText != null)
      paramSpannableStringBuilder.append(this.mText);
  }

  @ReactProp(name="text")
  public void setText(@Nullable String paramString)
  {
    this.mText = paramString;
    notifyChanged(true);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTRawText
 * JD-Core Version:    0.6.0
 */