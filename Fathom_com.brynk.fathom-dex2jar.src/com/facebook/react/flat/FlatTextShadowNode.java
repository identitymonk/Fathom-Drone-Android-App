package com.facebook.react.flat;

import android.text.SpannableStringBuilder;
import com.facebook.react.uimanager.ReactShadowNodeImpl;

abstract class FlatTextShadowNode extends FlatShadowNode
{
  private int mTextBegin;
  private int mTextEnd;

  final void applySpans(SpannableStringBuilder paramSpannableStringBuilder, boolean paramBoolean)
  {
    if ((this.mTextBegin != this.mTextEnd) || (shouldAllowEmptySpans()))
      performApplySpans(paramSpannableStringBuilder, this.mTextBegin, this.mTextEnd, paramBoolean);
  }

  final void collectText(SpannableStringBuilder paramSpannableStringBuilder)
  {
    this.mTextBegin = paramSpannableStringBuilder.length();
    performCollectText(paramSpannableStringBuilder);
    this.mTextEnd = paramSpannableStringBuilder.length();
  }

  boolean isEditable()
  {
    return false;
  }

  public boolean isVirtual()
  {
    return true;
  }

  protected void notifyChanged(boolean paramBoolean)
  {
    ReactShadowNodeImpl localReactShadowNodeImpl = getParent();
    if ((localReactShadowNodeImpl instanceof FlatTextShadowNode))
      ((FlatTextShadowNode)localReactShadowNodeImpl).notifyChanged(paramBoolean);
  }

  protected abstract void performApplySpans(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, boolean paramBoolean);

  protected abstract void performCollectAttachDetachListeners(StateBuilder paramStateBuilder);

  protected abstract void performCollectText(SpannableStringBuilder paramSpannableStringBuilder);

  boolean shouldAllowEmptySpans()
  {
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatTextShadowNode
 * JD-Core Version:    0.6.0
 */