package com.facebook.react.flat;

import android.text.SpannableStringBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.imagehelper.ImageSource;
import javax.annotation.Nullable;

class RCTTextInlineImage extends FlatTextShadowNode
{
  private InlineImageSpanWithPipeline mInlineImageSpan = new InlineImageSpanWithPipeline();

  private InlineImageSpanWithPipeline getMutableSpan()
  {
    if (this.mInlineImageSpan.isFrozen())
      this.mInlineImageSpan = this.mInlineImageSpan.mutableCopy();
    return this.mInlineImageSpan;
  }

  protected void performApplySpans(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mInlineImageSpan.freeze();
    paramSpannableStringBuilder.setSpan(this.mInlineImageSpan, paramInt1, paramInt2, 17);
  }

  protected void performCollectAttachDetachListeners(StateBuilder paramStateBuilder)
  {
    paramStateBuilder.addAttachDetachListener(this.mInlineImageSpan);
  }

  protected void performCollectText(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append("I");
  }

  @ReactProp(name="src")
  public void setSource(@Nullable ReadableArray paramReadableArray)
  {
    Object localObject = null;
    label23: InlineImageSpanWithPipeline localInlineImageSpanWithPipeline;
    if ((paramReadableArray == null) || (paramReadableArray.size() == 0))
    {
      paramReadableArray = null;
      if (paramReadableArray != null)
        break label58;
      paramReadableArray = null;
      localInlineImageSpanWithPipeline = getMutableSpan();
      if (paramReadableArray != null)
        break label74;
    }
    label58: label74: for (paramReadableArray = localObject; ; paramReadableArray = ImageRequestBuilder.newBuilderWithSource(paramReadableArray.getUri()).build())
    {
      localInlineImageSpanWithPipeline.setImageRequest(paramReadableArray);
      return;
      paramReadableArray = paramReadableArray.getMap(0).getString("uri");
      break;
      paramReadableArray = new ImageSource(getThemedContext(), paramReadableArray);
      break label23;
    }
  }

  public void setStyleHeight(float paramFloat)
  {
    super.setStyleHeight(paramFloat);
    if (this.mInlineImageSpan.getHeight() != paramFloat)
    {
      getMutableSpan().setHeight(paramFloat);
      notifyChanged(true);
    }
  }

  public void setStyleWidth(float paramFloat)
  {
    super.setStyleWidth(paramFloat);
    if (this.mInlineImageSpan.getWidth() != paramFloat)
    {
      getMutableSpan().setWidth(paramFloat);
      notifyChanged(true);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTTextInlineImage
 * JD-Core Version:    0.6.0
 */