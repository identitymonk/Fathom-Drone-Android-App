package com.facebook.react.flat;

import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.facebook.fbui.textlayoutbuilder.TextLayoutBuilder;
import com.facebook.fbui.textlayoutbuilder.glyphwarmer.GlyphWarmerImpl;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import javax.annotation.Nullable;

final class RCTText extends RCTVirtualText
  implements YogaMeasureFunction
{
  private static final int ALIGNMENT_LEFT = 3;
  private static final int ALIGNMENT_RIGHT = 4;
  private static final TextLayoutBuilder sTextLayoutBuilder = new TextLayoutBuilder().setShouldCacheLayout(false).setShouldWarmText(true).setGlyphWarmer(new GlyphWarmerImpl());
  private int mAlignment = 0;

  @Nullable
  private DrawTextLayout mDrawCommand;
  private boolean mIncludeFontPadding = true;
  private int mNumberOfLines = 2147483647;
  private float mSpacingAdd = 0.0F;
  private float mSpacingMult = 1.0F;

  @Nullable
  private CharSequence mText;

  public RCTText()
  {
    setMeasureFunction(this);
    getSpan().setFontSize(getDefaultFontSize());
  }

  private static Layout createTextLayout(int paramInt1, YogaMeasureMode paramYogaMeasureMode, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, CharSequence paramCharSequence, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, Layout.Alignment paramAlignment)
  {
    int i;
    switch (1.$SwitchMap$com$facebook$yoga$YogaMeasureMode[paramYogaMeasureMode.ordinal()])
    {
    default:
      throw new IllegalStateException("Unexpected size mode: " + paramYogaMeasureMode);
    case 1:
      i = 0;
    case 2:
    case 3:
    }
    while (true)
    {
      sTextLayoutBuilder.setEllipsize(paramTruncateAt).setMaxLines(paramInt2).setSingleLine(paramBoolean2).setText(paramCharSequence).setTextSize(paramInt3).setWidth(paramInt1, i);
      sTextLayoutBuilder.setTextStyle(paramInt4);
      sTextLayoutBuilder.setTextDirection(TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR);
      sTextLayoutBuilder.setIncludeFontPadding(paramBoolean1);
      sTextLayoutBuilder.setTextSpacingExtra(paramFloat1);
      sTextLayoutBuilder.setTextSpacingMultiplier(paramFloat2);
      sTextLayoutBuilder.setAlignment(paramAlignment);
      paramYogaMeasureMode = sTextLayoutBuilder.build();
      sTextLayoutBuilder.setText(null);
      return paramYogaMeasureMode;
      i = 1;
      continue;
      i = 2;
    }
  }

  protected void collectState(StateBuilder paramStateBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    super.collectState(paramStateBuilder, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    Object localObject;
    if (this.mText == null)
    {
      if ((paramFloat4 - paramFloat2 > 0.0F) && (paramFloat3 - paramFloat1 > 0.0F))
      {
        localObject = getText();
        if (!TextUtils.isEmpty((CharSequence)localObject))
          this.mText = ((CharSequence)localObject);
      }
      if (this.mText == null)
        return;
    }
    int i = 0;
    TextUtils.TruncateAt localTruncateAt;
    boolean bool2;
    int j;
    if (this.mDrawCommand == null)
    {
      i = (int)Math.ceil(paramFloat3 - paramFloat1);
      localObject = YogaMeasureMode.EXACTLY;
      localTruncateAt = TextUtils.TruncateAt.END;
      bool2 = this.mIncludeFontPadding;
      j = this.mNumberOfLines;
      if (this.mNumberOfLines != 1)
        break label293;
    }
    label293: for (boolean bool1 = true; ; bool1 = false)
    {
      this.mDrawCommand = new DrawTextLayout(createTextLayout(i, (YogaMeasureMode)localObject, localTruncateAt, bool2, j, bool1, this.mText, getFontSize(), this.mSpacingAdd, this.mSpacingMult, getFontStyle(), getAlignment()));
      i = 1;
      paramFloat1 += getPadding(0);
      paramFloat2 += getPadding(1);
      paramFloat3 = this.mDrawCommand.getLayoutWidth();
      paramFloat4 = this.mDrawCommand.getLayoutHeight();
      this.mDrawCommand = ((DrawTextLayout)this.mDrawCommand.updateBoundsAndFreeze(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8));
      paramStateBuilder.addDrawCommand(this.mDrawCommand);
      if (i != 0)
      {
        localObject = getNodeRegion();
        if ((localObject instanceof TextNodeRegion))
          ((TextNodeRegion)localObject).setLayout(this.mDrawCommand.getLayout());
      }
      performCollectAttachDetachListeners(paramStateBuilder);
      return;
    }
  }

  boolean doesDraw()
  {
    return true;
  }

  public Layout.Alignment getAlignment()
  {
    int i = 4;
    if (getLayoutDirection() == YogaDirection.RTL);
    for (int j = 1; ; j = 0)
      switch (this.mAlignment)
      {
      default:
        return Layout.Alignment.ALIGN_NORMAL;
      case 3:
      case 5:
      case 17:
      }
    if (j != 0);
    while (true)
    {
      return Layout.Alignment.values()[i];
      i = 3;
    }
    if (j != 0)
      i = 3;
    return Layout.Alignment.values()[i];
    return Layout.Alignment.ALIGN_CENTER;
  }

  protected int getDefaultFontSize()
  {
    return fontSizeFromSp(14.0F);
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
    paramYogaNode = getText();
    if (TextUtils.isEmpty(paramYogaNode))
    {
      this.mText = null;
      return YogaMeasureOutput.make(0, 0);
    }
    this.mText = paramYogaNode;
    int i = (int)Math.ceil(paramFloat1);
    paramYogaMeasureMode2 = TextUtils.TruncateAt.END;
    boolean bool2 = this.mIncludeFontPadding;
    int j = this.mNumberOfLines;
    boolean bool1;
    if (this.mNumberOfLines == 1)
    {
      bool1 = true;
      paramYogaNode = createTextLayout(i, paramYogaMeasureMode1, paramYogaMeasureMode2, bool2, j, bool1, paramYogaNode, getFontSize(), this.mSpacingAdd, this.mSpacingMult, getFontStyle(), getAlignment());
      if ((this.mDrawCommand == null) || (this.mDrawCommand.isFrozen()))
        break label149;
      this.mDrawCommand.setLayout(paramYogaNode);
    }
    while (true)
    {
      return YogaMeasureOutput.make(this.mDrawCommand.getLayoutWidth(), this.mDrawCommand.getLayoutHeight());
      bool1 = false;
      break;
      label149: this.mDrawCommand = new DrawTextLayout(paramYogaNode);
    }
  }

  protected void notifyChanged(boolean paramBoolean)
  {
    dirty();
  }

  @ReactProp(defaultBoolean=true, name="includeFontPadding")
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.mIncludeFontPadding = paramBoolean;
  }

  @ReactProp(defaultDouble=(0.0D / 0.0D), name="lineHeight")
  public void setLineHeight(double paramDouble)
  {
    if (Double.isNaN(paramDouble))
      this.mSpacingMult = 1.0F;
    for (this.mSpacingAdd = 0.0F; ; this.mSpacingAdd = PixelUtil.toPixelFromSP((float)paramDouble))
    {
      notifyChanged(true);
      return;
      this.mSpacingMult = 0.0F;
    }
  }

  @ReactProp(defaultInt=2147483647, name="numberOfLines")
  public void setNumberOfLines(int paramInt)
  {
    this.mNumberOfLines = paramInt;
    notifyChanged(true);
  }

  @ReactProp(name="textAlign")
  public void setTextAlign(@Nullable String paramString)
  {
    if ((paramString == null) || ("auto".equals(paramString)))
      this.mAlignment = 0;
    while (true)
    {
      notifyChanged(false);
      return;
      if ("left".equals(paramString))
      {
        this.mAlignment = 3;
        continue;
      }
      if ("right".equals(paramString))
      {
        this.mAlignment = 5;
        continue;
      }
      if (!"center".equals(paramString))
        break;
      this.mAlignment = 17;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + paramString);
  }

  void updateNodeRegion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    NodeRegion localNodeRegion = getNodeRegion();
    if (this.mDrawCommand == null)
      if (!localNodeRegion.matches(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean))
        setNodeRegion(new TextNodeRegion(paramFloat1, paramFloat2, paramFloat3, paramFloat4, getReactTag(), paramBoolean, null));
    Layout localLayout1;
    Layout localLayout2;
    do
    {
      return;
      localLayout1 = null;
      if ((localNodeRegion instanceof TextNodeRegion))
        localLayout1 = ((TextNodeRegion)localNodeRegion).getLayout();
      localLayout2 = this.mDrawCommand.getLayout();
    }
    while ((localNodeRegion.matches(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean)) && (localLayout1 == localLayout2));
    setNodeRegion(new TextNodeRegion(paramFloat1, paramFloat2, paramFloat3, paramFloat4, getReactTag(), paramBoolean, localLayout2));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTText
 * JD-Core Version:    0.6.0
 */