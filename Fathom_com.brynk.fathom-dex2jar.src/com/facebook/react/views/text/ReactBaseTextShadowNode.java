package com.facebook.react.views.text;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaDirection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public abstract class ReactBaseTextShadowNode extends LayoutShadowNode
{
  public static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
  private static final String INLINE_IMAGE_PLACEHOLDER = "I";
  public static final String PROP_SHADOW_COLOR = "textShadowColor";
  public static final String PROP_SHADOW_OFFSET = "textShadowOffset";
  public static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
  public static final String PROP_SHADOW_OFFSET_WIDTH = "width";
  public static final String PROP_SHADOW_RADIUS = "textShadowRadius";
  public static final int UNSET = -1;
  protected boolean mAllowFontScaling = true;
  protected int mBackgroundColor;
  protected int mColor;
  protected boolean mContainsImages;

  @Nullable
  protected String mFontFamily;
  protected int mFontSize = -1;
  protected float mFontSizeInput = -1.0F;
  protected int mFontStyle;
  protected int mFontWeight;
  protected float mHeightOfTallestInlineImage;
  protected boolean mIncludeFontPadding;
  protected boolean mIsBackgroundColorSet = false;
  protected boolean mIsColorSet = false;
  protected boolean mIsLineThroughTextDecorationSet;
  protected boolean mIsUnderlineTextDecorationSet;
  protected float mLineHeight = (0.0F / 0.0F);
  protected float mLineHeightInput = -1.0F;
  protected int mNumberOfLines = -1;
  protected int mTextAlign = 0;
  protected int mTextBreakStrategy;
  protected int mTextShadowColor;
  protected float mTextShadowOffsetDx;
  protected float mTextShadowOffsetDy;
  protected float mTextShadowRadius;

  public ReactBaseTextShadowNode()
  {
    if (Build.VERSION.SDK_INT < 23);
    for (int i = 0; ; i = 1)
    {
      this.mTextBreakStrategy = i;
      this.mTextShadowOffsetDx = 0.0F;
      this.mTextShadowOffsetDy = 0.0F;
      this.mTextShadowRadius = 1.0F;
      this.mTextShadowColor = 1426063360;
      this.mIsUnderlineTextDecorationSet = false;
      this.mIsLineThroughTextDecorationSet = false;
      this.mIncludeFontPadding = true;
      this.mFontStyle = -1;
      this.mFontWeight = -1;
      this.mFontFamily = null;
      this.mContainsImages = false;
      this.mHeightOfTallestInlineImage = (0.0F / 0.0F);
      return;
    }
  }

  private static void buildSpannedFromShadowNode(ReactBaseTextShadowNode paramReactBaseTextShadowNode, SpannableStringBuilder paramSpannableStringBuilder, List<SetSpanOperation> paramList)
  {
    int j = paramSpannableStringBuilder.length();
    int i = 0;
    int k = paramReactBaseTextShadowNode.getChildCount();
    if (i < k)
    {
      ReactShadowNodeImpl localReactShadowNodeImpl = paramReactBaseTextShadowNode.getChildAt(i);
      if ((localReactShadowNodeImpl instanceof ReactRawTextShadowNode))
        paramSpannableStringBuilder.append(((ReactRawTextShadowNode)localReactShadowNodeImpl).getText());
      while (true)
      {
        localReactShadowNodeImpl.markUpdateSeen();
        i += 1;
        break;
        if ((localReactShadowNodeImpl instanceof ReactBaseTextShadowNode))
        {
          buildSpannedFromShadowNode((ReactBaseTextShadowNode)localReactShadowNodeImpl, paramSpannableStringBuilder, paramList);
          continue;
        }
        if (!(localReactShadowNodeImpl instanceof ReactTextInlineImageShadowNode))
          break label137;
        paramSpannableStringBuilder.append("I");
        paramList.add(new SetSpanOperation(paramSpannableStringBuilder.length() - "I".length(), paramSpannableStringBuilder.length(), ((ReactTextInlineImageShadowNode)localReactShadowNodeImpl).buildInlineImageSpan()));
      }
      label137: throw new IllegalViewOperationException("Unexpected view type nested under text node: " + localReactShadowNodeImpl.getClass());
    }
    i = paramSpannableStringBuilder.length();
    if (i >= j)
    {
      if (paramReactBaseTextShadowNode.mIsColorSet)
        paramList.add(new SetSpanOperation(j, i, new ForegroundColorSpan(paramReactBaseTextShadowNode.mColor)));
      if (paramReactBaseTextShadowNode.mIsBackgroundColorSet)
        paramList.add(new SetSpanOperation(j, i, new BackgroundColorSpan(paramReactBaseTextShadowNode.mBackgroundColor)));
      if (paramReactBaseTextShadowNode.mFontSize != -1)
        paramList.add(new SetSpanOperation(j, i, new AbsoluteSizeSpan(paramReactBaseTextShadowNode.mFontSize)));
      if ((paramReactBaseTextShadowNode.mFontStyle != -1) || (paramReactBaseTextShadowNode.mFontWeight != -1) || (paramReactBaseTextShadowNode.mFontFamily != null))
        paramList.add(new SetSpanOperation(j, i, new CustomStyleSpan(paramReactBaseTextShadowNode.mFontStyle, paramReactBaseTextShadowNode.mFontWeight, paramReactBaseTextShadowNode.mFontFamily, paramReactBaseTextShadowNode.getThemedContext().getAssets())));
      if (paramReactBaseTextShadowNode.mIsUnderlineTextDecorationSet)
        paramList.add(new SetSpanOperation(j, i, new UnderlineSpan()));
      if (paramReactBaseTextShadowNode.mIsLineThroughTextDecorationSet)
        paramList.add(new SetSpanOperation(j, i, new StrikethroughSpan()));
      if ((paramReactBaseTextShadowNode.mTextShadowOffsetDx != 0.0F) || (paramReactBaseTextShadowNode.mTextShadowOffsetDy != 0.0F))
        paramList.add(new SetSpanOperation(j, i, new ShadowStyleSpan(paramReactBaseTextShadowNode.mTextShadowOffsetDx, paramReactBaseTextShadowNode.mTextShadowOffsetDy, paramReactBaseTextShadowNode.mTextShadowRadius, paramReactBaseTextShadowNode.mTextShadowColor)));
      if (!Float.isNaN(paramReactBaseTextShadowNode.getEffectiveLineHeight()))
        paramList.add(new SetSpanOperation(j, i, new CustomLineHeightSpan(paramReactBaseTextShadowNode.getEffectiveLineHeight())));
      paramList.add(new SetSpanOperation(j, i, new ReactTagSpan(paramReactBaseTextShadowNode.getReactTag())));
    }
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

  private static int parseNumericFontWeight(String paramString)
  {
    if ((paramString.length() == 3) && (paramString.endsWith("00")) && (paramString.charAt(0) <= '9') && (paramString.charAt(0) >= '1'))
      return (paramString.charAt(0) - '0') * 100;
    return -1;
  }

  protected static Spannable spannedFromShadowNode(ReactBaseTextShadowNode paramReactBaseTextShadowNode, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = new ArrayList();
    buildSpannedFromShadowNode(paramReactBaseTextShadowNode, localSpannableStringBuilder, (List)localObject);
    if (paramString != null)
      localSpannableStringBuilder.append(paramString);
    if (paramReactBaseTextShadowNode.mFontSize == -1)
      if (!paramReactBaseTextShadowNode.mAllowFontScaling)
        break label203;
    label203: for (int i = (int)Math.ceil(PixelUtil.toPixelFromSP(14.0F)); ; i = (int)Math.ceil(PixelUtil.toPixelFromDIP(14.0F)))
    {
      ((List)localObject).add(new SetSpanOperation(0, localSpannableStringBuilder.length(), new AbsoluteSizeSpan(i)));
      paramReactBaseTextShadowNode.mContainsImages = false;
      paramReactBaseTextShadowNode.mHeightOfTallestInlineImage = (0.0F / 0.0F);
      i = 0;
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (SetSpanOperation)paramString.next();
        if ((((SetSpanOperation)localObject).what instanceof TextInlineImageSpan))
        {
          int j = ((TextInlineImageSpan)((SetSpanOperation)localObject).what).getHeight();
          paramReactBaseTextShadowNode.mContainsImages = true;
          if ((Float.isNaN(paramReactBaseTextShadowNode.mHeightOfTallestInlineImage)) || (j > paramReactBaseTextShadowNode.mHeightOfTallestInlineImage))
            paramReactBaseTextShadowNode.mHeightOfTallestInlineImage = j;
        }
        ((SetSpanOperation)localObject).execute(localSpannableStringBuilder, i);
        i += 1;
      }
    }
    return (Spannable)localSpannableStringBuilder;
  }

  public float getEffectiveLineHeight()
  {
    if ((!Float.isNaN(this.mLineHeight)) && (!Float.isNaN(this.mHeightOfTallestInlineImage)) && (this.mHeightOfTallestInlineImage > this.mLineHeight));
    for (int i = 1; i != 0; i = 0)
      return this.mHeightOfTallestInlineImage;
    return this.mLineHeight;
  }

  @ReactProp(defaultBoolean=true, name="allowFontScaling")
  public void setAllowFontScaling(boolean paramBoolean)
  {
    if (paramBoolean != this.mAllowFontScaling)
    {
      this.mAllowFontScaling = paramBoolean;
      setFontSize(this.mFontSizeInput);
      setLineHeight(this.mLineHeightInput);
      markUpdated();
    }
  }

  @ReactProp(name="backgroundColor")
  public void setBackgroundColor(Integer paramInteger)
  {
    if (!isVirtualAnchor())
      if (paramInteger == null)
        break label38;
    label38: for (boolean bool = true; ; bool = false)
    {
      this.mIsBackgroundColorSet = bool;
      if (this.mIsBackgroundColorSet)
        this.mBackgroundColor = paramInteger.intValue();
      markUpdated();
      return;
    }
  }

  @ReactProp(name="color")
  public void setColor(@Nullable Integer paramInteger)
  {
    if (paramInteger != null);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsColorSet = bool;
      if (this.mIsColorSet)
        this.mColor = paramInteger.intValue();
      markUpdated();
      return;
    }
  }

  @ReactProp(name="fontFamily")
  public void setFontFamily(@Nullable String paramString)
  {
    this.mFontFamily = paramString;
    markUpdated();
  }

  @ReactProp(defaultFloat=-1.0F, name="fontSize")
  public void setFontSize(float paramFloat)
  {
    this.mFontSizeInput = paramFloat;
    float f = paramFloat;
    if (paramFloat != -1.0F)
    {
      if (!this.mAllowFontScaling)
        break label42;
      f = (float)Math.ceil(PixelUtil.toPixelFromSP(paramFloat));
    }
    while (true)
    {
      this.mFontSize = (int)f;
      markUpdated();
      return;
      label42: f = (float)Math.ceil(PixelUtil.toPixelFromDIP(paramFloat));
    }
  }

  @ReactProp(name="fontStyle")
  public void setFontStyle(@Nullable String paramString)
  {
    int i = -1;
    if ("italic".equals(paramString))
      i = 2;
    while (true)
    {
      if (i != this.mFontStyle)
      {
        this.mFontStyle = i;
        markUpdated();
      }
      return;
      if (!"normal".equals(paramString))
        continue;
      i = 0;
    }
  }

  @ReactProp(name="fontWeight")
  public void setFontWeight(@Nullable String paramString)
  {
    int j;
    int k;
    int i;
    if (paramString != null)
    {
      j = parseNumericFontWeight(paramString);
      k = -1;
      if ((j < 500) && (!"bold".equals(paramString)))
        break label54;
      i = 1;
    }
    while (true)
    {
      if (i != this.mFontWeight)
      {
        this.mFontWeight = i;
        markUpdated();
      }
      return;
      j = -1;
      break;
      label54: if (!"normal".equals(paramString))
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

  @ReactProp(defaultBoolean=true, name="includeFontPadding")
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.mIncludeFontPadding = paramBoolean;
  }

  @ReactProp(defaultFloat=-1.0F, name="lineHeight")
  public void setLineHeight(float paramFloat)
  {
    this.mLineHeightInput = paramFloat;
    if (paramFloat == -1.0F)
    {
      this.mLineHeight = (0.0F / 0.0F);
      markUpdated();
      return;
    }
    if (this.mAllowFontScaling)
      paramFloat = PixelUtil.toPixelFromSP(paramFloat);
    while (true)
    {
      this.mLineHeight = paramFloat;
      break;
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    }
  }

  @ReactProp(defaultInt=-1, name="numberOfLines")
  public void setNumberOfLines(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
      i = -1;
    this.mNumberOfLines = i;
    markUpdated();
  }

  @ReactProp(name="textAlign")
  public void setTextAlign(@Nullable String paramString)
  {
    if ((paramString == null) || ("auto".equals(paramString)))
      this.mTextAlign = 0;
    while (true)
    {
      markUpdated();
      return;
      if ("left".equals(paramString))
      {
        this.mTextAlign = 3;
        continue;
      }
      if ("right".equals(paramString))
      {
        this.mTextAlign = 5;
        continue;
      }
      if ("center".equals(paramString))
      {
        this.mTextAlign = 1;
        continue;
      }
      if (!"justify".equals(paramString))
        break;
      this.mTextAlign = 3;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + paramString);
  }

  @ReactProp(name="textBreakStrategy")
  public void setTextBreakStrategy(@Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT < 23)
      return;
    if ((paramString == null) || ("highQuality".equals(paramString)))
      this.mTextBreakStrategy = 1;
    while (true)
    {
      markUpdated();
      return;
      if ("simple".equals(paramString))
      {
        this.mTextBreakStrategy = 0;
        continue;
      }
      if (!"balanced".equals(paramString))
        break;
      this.mTextBreakStrategy = 2;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textBreakStrategy: " + paramString);
  }

  @ReactProp(name="textDecorationLine")
  public void setTextDecorationLine(@Nullable String paramString)
  {
    int i = 0;
    this.mIsUnderlineTextDecorationSet = false;
    this.mIsLineThroughTextDecorationSet = false;
    if (paramString != null)
    {
      paramString = paramString.split(" ");
      int j = paramString.length;
      if (i < j)
      {
        Object localObject = paramString[i];
        if ("underline".equals(localObject))
          this.mIsUnderlineTextDecorationSet = true;
        while (true)
        {
          i += 1;
          break;
          if (!"line-through".equals(localObject))
            continue;
          this.mIsLineThroughTextDecorationSet = true;
        }
      }
    }
    markUpdated();
  }

  @ReactProp(customType="Color", defaultInt=1426063360, name="textShadowColor")
  public void setTextShadowColor(int paramInt)
  {
    if (paramInt != this.mTextShadowColor)
    {
      this.mTextShadowColor = paramInt;
      markUpdated();
    }
  }

  @ReactProp(name="textShadowOffset")
  public void setTextShadowOffset(ReadableMap paramReadableMap)
  {
    this.mTextShadowOffsetDx = 0.0F;
    this.mTextShadowOffsetDy = 0.0F;
    if (paramReadableMap != null)
    {
      if ((paramReadableMap.hasKey("width")) && (!paramReadableMap.isNull("width")))
        this.mTextShadowOffsetDx = PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("width"));
      if ((paramReadableMap.hasKey("height")) && (!paramReadableMap.isNull("height")))
        this.mTextShadowOffsetDy = PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("height"));
    }
    markUpdated();
  }

  @ReactProp(defaultInt=1, name="textShadowRadius")
  public void setTextShadowRadius(float paramFloat)
  {
    if (paramFloat != this.mTextShadowRadius)
    {
      this.mTextShadowRadius = paramFloat;
      markUpdated();
    }
  }

  private static class SetSpanOperation
  {
    protected int end;
    protected int start;
    protected Object what;

    SetSpanOperation(int paramInt1, int paramInt2, Object paramObject)
    {
      this.start = paramInt1;
      this.end = paramInt2;
      this.what = paramObject;
    }

    public void execute(SpannableStringBuilder paramSpannableStringBuilder, int paramInt)
    {
      int i = 34;
      if (this.start == 0)
        i = 18;
      paramSpannableStringBuilder.setSpan(this.what, this.start, this.end, i & 0xFF00FFFF | paramInt << 16 & 0xFF0000);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactBaseTextShadowNode
 * JD-Core Version:    0.6.0
 */