package com.facebook.react.views.text;

import android.os.Build.VERSION;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import javax.annotation.Nullable;

public class ReactTextShadowNode extends ReactBaseTextShadowNode
{
  private static final TextPaint sTextPaintInstance = new TextPaint(1);

  @Nullable
  private Spannable mPreparedSpannableText;
  private final YogaMeasureFunction mTextMeasureFunction = new YogaMeasureFunction()
  {
    public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
    {
      paramYogaNode = ReactTextShadowNode.sTextPaintInstance;
      paramYogaMeasureMode2 = (Spanned)Assertions.assertNotNull(ReactTextShadowNode.this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout");
      BoringLayout.Metrics localMetrics = BoringLayout.isBoring(paramYogaMeasureMode2, paramYogaNode);
      int i;
      if (localMetrics == null)
      {
        paramFloat2 = Layout.getDesiredWidth(paramYogaMeasureMode2, paramYogaNode);
        if ((paramYogaMeasureMode1 != YogaMeasureMode.UNDEFINED) && (paramFloat1 >= 0.0F))
          break label178;
        i = 1;
        label58: if ((localMetrics != null) || ((i == 0) && ((YogaConstants.isUndefined(paramFloat2)) || (paramFloat2 > paramFloat1))))
          break label242;
        i = (int)Math.ceil(paramFloat2);
        if (Build.VERSION.SDK_INT >= 23)
          break label184;
        paramYogaNode = new StaticLayout(paramYogaMeasureMode2, paramYogaNode, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, ReactTextShadowNode.this.mIncludeFontPadding);
      }
      while (true)
      {
        if ((ReactTextShadowNode.this.mNumberOfLines == -1) || (ReactTextShadowNode.this.mNumberOfLines >= paramYogaNode.getLineCount()))
          break label386;
        return YogaMeasureOutput.make(paramYogaNode.getWidth(), paramYogaNode.getLineBottom(ReactTextShadowNode.this.mNumberOfLines - 1));
        paramFloat2 = (0.0F / 0.0F);
        break;
        label178: i = 0;
        break label58;
        label184: paramYogaNode = StaticLayout.Builder.obtain(paramYogaMeasureMode2, 0, paramYogaMeasureMode2.length(), paramYogaNode, i).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0F, 1.0F).setIncludePad(ReactTextShadowNode.this.mIncludeFontPadding).setBreakStrategy(ReactTextShadowNode.this.mTextBreakStrategy).setHyphenationFrequency(1).build();
        continue;
        label242: if ((localMetrics != null) && ((i != 0) || (localMetrics.width <= paramFloat1)))
        {
          paramYogaNode = BoringLayout.make(paramYogaMeasureMode2, paramYogaNode, localMetrics.width, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, localMetrics, ReactTextShadowNode.this.mIncludeFontPadding);
          continue;
        }
        if (Build.VERSION.SDK_INT < 23)
        {
          paramYogaNode = new StaticLayout(paramYogaMeasureMode2, paramYogaNode, (int)paramFloat1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, ReactTextShadowNode.this.mIncludeFontPadding);
          continue;
        }
        paramYogaNode = StaticLayout.Builder.obtain(paramYogaMeasureMode2, 0, paramYogaMeasureMode2.length(), paramYogaNode, (int)paramFloat1).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0F, 1.0F).setIncludePad(ReactTextShadowNode.this.mIncludeFontPadding).setBreakStrategy(ReactTextShadowNode.this.mTextBreakStrategy).setHyphenationFrequency(1).build();
      }
      label386: return YogaMeasureOutput.make(paramYogaNode.getWidth(), paramYogaNode.getHeight());
    }
  };

  public ReactTextShadowNode()
  {
    if (!isVirtual())
      setMeasureFunction(this.mTextMeasureFunction);
  }

  private int getTextAlign()
  {
    int j = this.mTextAlign;
    int i = j;
    if (getLayoutDirection() == YogaDirection.RTL)
    {
      if (j != 5)
        break label26;
      i = 3;
    }
    label26: 
    do
    {
      return i;
      i = j;
    }
    while (j != 3);
    return 5;
  }

  public boolean isVirtualAnchor()
  {
    return true;
  }

  public void markUpdated()
  {
    super.markUpdated();
    super.dirty();
  }

  public void onBeforeLayout()
  {
    this.mPreparedSpannableText = spannedFromShadowNode(this, null);
    markUpdated();
  }

  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
    super.onCollectExtraUpdates(paramUIViewOperationQueue);
    if (this.mPreparedSpannableText != null)
    {
      ReactTextUpdate localReactTextUpdate = new ReactTextUpdate(this.mPreparedSpannableText, -1, this.mContainsImages, getPadding(4), getPadding(1), getPadding(5), getPadding(3), getTextAlign(), this.mTextBreakStrategy);
      paramUIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), localReactTextUpdate);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactTextShadowNode
 * JD-Core Version:    0.6.0
 */