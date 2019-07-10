package com.facebook.react.flat;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

class RCTVirtualText extends FlatTextShadowNode
{
  private static final String BOLD = "bold";
  private static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
  private static final String ITALIC = "italic";
  private static final String NORMAL = "normal";
  private static final String PROP_SHADOW_COLOR = "textShadowColor";
  private static final String PROP_SHADOW_OFFSET = "textShadowOffset";
  private static final String PROP_SHADOW_RADIUS = "textShadowRadius";
  private FontStylingSpan mFontStylingSpan = FontStylingSpan.INSTANCE;
  private ShadowStyleSpan mShadowStyleSpan = ShadowStyleSpan.INSTANCE;

  static int fontSizeFromSp(float paramFloat)
  {
    return (int)Math.ceil(PixelUtil.toPixelFromSP(paramFloat));
  }

  private final ShadowStyleSpan getShadowSpan()
  {
    if (this.mShadowStyleSpan.isFrozen())
      this.mShadowStyleSpan = this.mShadowStyleSpan.mutableCopy();
    return this.mShadowStyleSpan;
  }

  private static int parseNumericFontWeight(String paramString)
  {
    if ((paramString.length() == 3) && (paramString.endsWith("00")) && (paramString.charAt(0) <= '9') && (paramString.charAt(0) >= '1'))
      return (paramString.charAt(0) - '0') * 100;
    return -1;
  }

  public void addChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    super.addChildAt(paramReactShadowNodeImpl, paramInt);
    notifyChanged(true);
  }

  protected int getDefaultFontSize()
  {
    return -1;
  }

  protected final int getFontSize()
  {
    return this.mFontStylingSpan.getFontSize();
  }

  protected final int getFontStyle()
  {
    int i = this.mFontStylingSpan.getFontStyle();
    if (i >= 0)
      return i;
    return 0;
  }

  protected final FontStylingSpan getSpan()
  {
    if (this.mFontStylingSpan.isFrozen())
      this.mFontStylingSpan = this.mFontStylingSpan.mutableCopy();
    return this.mFontStylingSpan;
  }

  final SpannableStringBuilder getText()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    collectText(localSpannableStringBuilder);
    applySpans(localSpannableStringBuilder, isEditable());
    return localSpannableStringBuilder;
  }

  protected void performApplySpans(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mFontStylingSpan.freeze();
    if (paramBoolean)
    {
      i = 33;
      paramSpannableStringBuilder.setSpan(this.mFontStylingSpan, paramInt1, paramInt2, i);
      if ((this.mShadowStyleSpan.getColor() != 0) && (this.mShadowStyleSpan.getRadius() != 0.0F))
      {
        this.mShadowStyleSpan.freeze();
        paramSpannableStringBuilder.setSpan(this.mShadowStyleSpan, paramInt1, paramInt2, i);
      }
      paramInt1 = 0;
      paramInt2 = getChildCount();
      while (paramInt1 < paramInt2)
      {
        ((FlatTextShadowNode)getChildAt(paramInt1)).applySpans(paramSpannableStringBuilder, paramBoolean);
        paramInt1 += 1;
      }
    }
    if (paramInt1 == 0);
    for (int i = 18; ; i = 34)
      break;
  }

  protected void performCollectAttachDetachListeners(StateBuilder paramStateBuilder)
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      ((FlatTextShadowNode)getChildAt(i)).performCollectAttachDetachListeners(paramStateBuilder);
      i += 1;
    }
  }

  protected void performCollectText(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      ((FlatTextShadowNode)getChildAt(i)).collectText(paramSpannableStringBuilder);
      i += 1;
    }
  }

  public void setBackgroundColor(int paramInt)
  {
    if (isVirtual())
    {
      if (this.mFontStylingSpan.getBackgroundColor() != paramInt)
      {
        getSpan().setBackgroundColor(paramInt);
        notifyChanged(false);
      }
      return;
    }
    super.setBackgroundColor(paramInt);
  }

  @ReactProp(defaultDouble=(0.0D / 0.0D), name="color")
  public void setColor(double paramDouble)
  {
    if (this.mFontStylingSpan.getTextColor() != paramDouble)
    {
      getSpan().setTextColor(paramDouble);
      notifyChanged(false);
    }
  }

  @ReactProp(name="fontFamily")
  public void setFontFamily(@Nullable String paramString)
  {
    if (!TextUtils.equals(this.mFontStylingSpan.getFontFamily(), paramString))
    {
      getSpan().setFontFamily(paramString);
      notifyChanged(true);
    }
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="fontSize")
  public void setFontSize(float paramFloat)
  {
    if (Float.isNaN(paramFloat));
    for (int i = getDefaultFontSize(); ; i = fontSizeFromSp(paramFloat))
    {
      if (this.mFontStylingSpan.getFontSize() != i)
      {
        getSpan().setFontSize(i);
        notifyChanged(true);
      }
      return;
    }
  }

  @ReactProp(name="fontStyle")
  public void setFontStyle(@Nullable String paramString)
  {
    int i;
    if (paramString == null)
      i = -1;
    while (true)
    {
      if (this.mFontStylingSpan.getFontStyle() != i)
      {
        getSpan().setFontStyle(i);
        notifyChanged(true);
      }
      return;
      if ("italic".equals(paramString))
      {
        i = 2;
        continue;
      }
      if (!"normal".equals(paramString))
        break;
      i = 0;
    }
    throw new RuntimeException("invalid font style " + paramString);
  }

  @ReactProp(name="fontWeight")
  public void setFontWeight(@Nullable String paramString)
  {
    if (paramString == null)
      i = -1;
    while (true)
    {
      if (this.mFontStylingSpan.getFontWeight() != i)
      {
        getSpan().setFontWeight(i);
        notifyChanged(true);
      }
      return;
      if ("bold".equals(paramString))
      {
        i = 1;
        continue;
      }
      if (!"normal".equals(paramString))
        break;
      i = 0;
    }
    int i = parseNumericFontWeight(paramString);
    if (i == -1)
      throw new RuntimeException("invalid font weight " + paramString);
    if (i >= 500);
    for (i = 1; ; i = 0)
      break;
  }

  @ReactProp(name="textDecorationLine")
  public void setTextDecorationLine(@Nullable String paramString)
  {
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramString != null)
    {
      paramString = paramString.split(" ");
      int j = paramString.length;
      int i = 0;
      bool3 = bool2;
      bool4 = bool1;
      if (i < j)
      {
        Object localObject = paramString[i];
        if ("underline".equals(localObject))
          bool3 = true;
        while (true)
        {
          i += 1;
          bool1 = bool3;
          break;
          bool3 = bool1;
          if (!"line-through".equals(localObject))
            continue;
          bool2 = true;
          bool3 = bool1;
        }
      }
    }
    if ((bool4 != this.mFontStylingSpan.hasUnderline()) || (bool3 != this.mFontStylingSpan.hasStrikeThrough()))
    {
      paramString = getSpan();
      paramString.setHasUnderline(bool4);
      paramString.setHasStrikeThrough(bool3);
      notifyChanged(true);
    }
  }

  @ReactProp(customType="Color", defaultInt=1426063360, name="textShadowColor")
  public void setTextShadowColor(int paramInt)
  {
    if (this.mShadowStyleSpan.getColor() != paramInt)
    {
      getShadowSpan().setColor(paramInt);
      notifyChanged(false);
    }
  }

  @ReactProp(name="textShadowOffset")
  public void setTextShadowOffset(@Nullable ReadableMap paramReadableMap)
  {
    float f2 = 0.0F;
    float f1 = 0.0F;
    float f4 = 0.0F;
    float f3 = f4;
    if (paramReadableMap != null)
    {
      if (paramReadableMap.hasKey("width"))
        f1 = PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("width"));
      f2 = f1;
      f3 = f4;
      if (paramReadableMap.hasKey("height"))
      {
        f3 = PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("height"));
        f2 = f1;
      }
    }
    if (!this.mShadowStyleSpan.offsetMatches(f2, f3))
    {
      getShadowSpan().setOffset(f2, f3);
      notifyChanged(false);
    }
  }

  @ReactProp(name="textShadowRadius")
  public void setTextShadowRadius(float paramFloat)
  {
    paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    if (this.mShadowStyleSpan.getRadius() != paramFloat)
    {
      getShadowSpan().setRadius(paramFloat);
      notifyChanged(false);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTVirtualText
 * JD-Core Version:    0.6.0
 */