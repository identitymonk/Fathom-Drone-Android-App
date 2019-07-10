package com.facebook.fbui.textlayoutbuilder;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.annotation.Px;
import android.support.annotation.VisibleForTesting;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.util.LruCache;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TextLayoutBuilder
{
  public static final int DEFAULT_MAX_LINES = 2147483647;
  public static final int MEASURE_MODE_AT_MOST = 2;
  public static final int MEASURE_MODE_EXACTLY = 1;
  public static final int MEASURE_MODE_UNSPECIFIED = 0;

  @VisibleForTesting
  static final LruCache<Integer, Layout> sCache = new LruCache(100);
  private GlyphWarmer mGlyphWarmer;

  @VisibleForTesting
  final Params mParams = new Params();
  private Layout mSavedLayout = null;
  private boolean mShouldCacheLayout = true;
  private boolean mShouldWarmText = false;

  // ERROR //
  public Layout build()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mShouldCacheLayout	Z
    //   4: ifeq +19 -> 23
    //   7: aload_0
    //   8: getfield 53	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mSavedLayout	Landroid/text/Layout;
    //   11: ifnull +12 -> 23
    //   14: aload_0
    //   15: getfield 53	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mSavedLayout	Landroid/text/Layout;
    //   18: astore 5
    //   20: aload 5
    //   22: areturn
    //   23: aload_0
    //   24: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   27: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   30: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +5 -> 38
    //   36: aconst_null
    //   37: areturn
    //   38: iconst_0
    //   39: istore_3
    //   40: iconst_m1
    //   41: istore_2
    //   42: iload_3
    //   43: istore_1
    //   44: aload_0
    //   45: getfield 55	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mShouldCacheLayout	Z
    //   48: ifeq +59 -> 107
    //   51: iload_3
    //   52: istore_1
    //   53: aload_0
    //   54: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   57: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   60: instanceof 73
    //   63: ifeq +44 -> 107
    //   66: aload_0
    //   67: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   70: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   73: checkcast 73	android/text/Spannable
    //   76: iconst_0
    //   77: aload_0
    //   78: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   81: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   84: invokeinterface 79 1 0
    //   89: iconst_1
    //   90: isub
    //   91: ldc 81
    //   93: invokeinterface 85 4 0
    //   98: checkcast 87	[Landroid/text/style/ClickableSpan;
    //   101: arraylength
    //   102: ifle +159 -> 261
    //   105: iconst_1
    //   106: istore_1
    //   107: iload_2
    //   108: istore_3
    //   109: aload_0
    //   110: getfield 55	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mShouldCacheLayout	Z
    //   113: ifeq +41 -> 154
    //   116: iload_2
    //   117: istore_3
    //   118: iload_1
    //   119: ifne +35 -> 154
    //   122: aload_0
    //   123: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   126: invokevirtual 90	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:hashCode	()I
    //   129: istore_3
    //   130: getstatic 45	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:sCache	Landroid/support/v4/util/LruCache;
    //   133: iload_3
    //   134: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: invokevirtual 100	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast 102	android/text/Layout
    //   143: astore 6
    //   145: aload 6
    //   147: astore 5
    //   149: aload 6
    //   151: ifnonnull -131 -> 20
    //   154: aconst_null
    //   155: astore 5
    //   157: aload_0
    //   158: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   161: getfield 105	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:singleLine	Z
    //   164: ifeq +102 -> 266
    //   167: iconst_1
    //   168: istore 4
    //   170: iload 4
    //   172: iconst_1
    //   173: if_icmpne +22 -> 195
    //   176: aload_0
    //   177: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   180: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   183: aload_0
    //   184: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   187: getfield 109	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:paint	Landroid/text/TextPaint;
    //   190: invokestatic 115	android/text/BoringLayout:isBoring	(Ljava/lang/CharSequence;Landroid/text/TextPaint;)Landroid/text/BoringLayout$Metrics;
    //   193: astore 5
    //   195: aload_0
    //   196: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   199: getfield 118	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:measureMode	I
    //   202: tableswitch	default:+26 -> 228, 0:+76->278, 1:+228->430, 2:+239->441
    //   229: nop
    //   230: ishl
    //   231: dup
    //   232: new 122	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   239: ldc 125
    //   241: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_0
    //   245: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   248: getfield 118	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:measureMode	I
    //   251: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokespecial 139	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   260: athrow
    //   261: iconst_0
    //   262: istore_1
    //   263: goto -156 -> 107
    //   266: aload_0
    //   267: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   270: getfield 142	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:maxLines	I
    //   273: istore 4
    //   275: goto -105 -> 170
    //   278: aload_0
    //   279: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   282: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   285: aload_0
    //   286: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   289: getfield 109	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:paint	Landroid/text/TextPaint;
    //   292: invokestatic 146	android/text/Layout:getDesiredWidth	(Ljava/lang/CharSequence;Landroid/text/TextPaint;)F
    //   295: f2d
    //   296: invokestatic 152	java/lang/Math:ceil	(D)D
    //   299: d2i
    //   300: istore_2
    //   301: aload 5
    //   303: ifnull +218 -> 521
    //   306: aload_0
    //   307: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   310: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   313: aload_0
    //   314: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   317: getfield 109	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:paint	Landroid/text/TextPaint;
    //   320: iload_2
    //   321: aload_0
    //   322: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   325: getfield 156	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:alignment	Landroid/text/Layout$Alignment;
    //   328: aload_0
    //   329: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   332: getfield 160	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:spacingMult	F
    //   335: aload_0
    //   336: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   339: getfield 163	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:spacingAdd	F
    //   342: aload 5
    //   344: aload_0
    //   345: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   348: getfield 166	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:includePadding	Z
    //   351: aload_0
    //   352: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   355: getfield 170	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:ellipsize	Landroid/text/TextUtils$TruncateAt;
    //   358: iload_2
    //   359: invokestatic 174	android/text/BoringLayout:make	(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZLandroid/text/TextUtils$TruncateAt;I)Landroid/text/BoringLayout;
    //   362: astore 5
    //   364: aload_0
    //   365: getfield 55	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mShouldCacheLayout	Z
    //   368: ifeq +26 -> 394
    //   371: iload_1
    //   372: ifne +22 -> 394
    //   375: aload_0
    //   376: aload 5
    //   378: putfield 53	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mSavedLayout	Landroid/text/Layout;
    //   381: getstatic 45	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:sCache	Landroid/support/v4/util/LruCache;
    //   384: iload_3
    //   385: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aload 5
    //   390: invokevirtual 178	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   393: pop
    //   394: aload_0
    //   395: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   398: iconst_1
    //   399: putfield 181	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:mForceNewPaint	Z
    //   402: aload_0
    //   403: getfield 57	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mShouldWarmText	Z
    //   406: ifeq +21 -> 427
    //   409: aload_0
    //   410: getfield 183	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mGlyphWarmer	Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;
    //   413: ifnull +14 -> 427
    //   416: aload_0
    //   417: getfield 183	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mGlyphWarmer	Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;
    //   420: aload 5
    //   422: invokeinterface 189 2 0
    //   427: aload 5
    //   429: areturn
    //   430: aload_0
    //   431: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   434: getfield 192	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:width	I
    //   437: istore_2
    //   438: goto -137 -> 301
    //   441: aload_0
    //   442: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   445: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   448: aload_0
    //   449: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   452: getfield 109	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:paint	Landroid/text/TextPaint;
    //   455: invokestatic 146	android/text/Layout:getDesiredWidth	(Ljava/lang/CharSequence;Landroid/text/TextPaint;)F
    //   458: f2d
    //   459: invokestatic 152	java/lang/Math:ceil	(D)D
    //   462: d2i
    //   463: aload_0
    //   464: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   467: getfield 192	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:width	I
    //   470: invokestatic 196	java/lang/Math:min	(II)I
    //   473: istore_2
    //   474: goto -173 -> 301
    //   477: astore 5
    //   479: aload_0
    //   480: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   483: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   486: instanceof 198
    //   489: ifne +113 -> 602
    //   492: ldc 200
    //   494: ldc 202
    //   496: aload 5
    //   498: invokestatic 208	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   501: pop
    //   502: aload_0
    //   503: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   506: aload_0
    //   507: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   510: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   513: invokeinterface 209 1 0
    //   518: putfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   521: aload_0
    //   522: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   525: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   528: iconst_0
    //   529: aload_0
    //   530: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   533: getfield 65	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:text	Ljava/lang/CharSequence;
    //   536: invokeinterface 79 1 0
    //   541: aload_0
    //   542: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   545: getfield 109	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:paint	Landroid/text/TextPaint;
    //   548: iload_2
    //   549: aload_0
    //   550: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   553: getfield 156	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:alignment	Landroid/text/Layout$Alignment;
    //   556: aload_0
    //   557: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   560: getfield 160	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:spacingMult	F
    //   563: aload_0
    //   564: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   567: getfield 163	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:spacingAdd	F
    //   570: aload_0
    //   571: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   574: getfield 166	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:includePadding	Z
    //   577: aload_0
    //   578: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   581: getfield 170	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:ellipsize	Landroid/text/TextUtils$TruncateAt;
    //   584: iload_2
    //   585: iload 4
    //   587: aload_0
    //   588: getfield 51	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder:mParams	Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    //   591: getfield 213	com/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params:textDirection	Landroid/support/v4/text/TextDirectionHeuristicCompat;
    //   594: invokestatic 218	com/facebook/fbui/textlayoutbuilder/StaticLayoutHelper:make	(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;IILandroid/support/v4/text/TextDirectionHeuristicCompat;)Landroid/text/StaticLayout;
    //   597: astore 5
    //   599: goto -235 -> 364
    //   602: aload 5
    //   604: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   521	599	477	java/lang/IndexOutOfBoundsException
  }

  public Layout.Alignment getAlignment()
  {
    return this.mParams.alignment;
  }

  public int[] getDrawableState()
  {
    return this.mParams.paint.drawableState;
  }

  public TextUtils.TruncateAt getEllipsize()
  {
    return this.mParams.ellipsize;
  }

  public GlyphWarmer getGlyphWarmer()
  {
    return this.mGlyphWarmer;
  }

  public boolean getIncludeFontPadding()
  {
    return this.mParams.includePadding;
  }

  @ColorInt
  public int getLinkColor()
  {
    return this.mParams.paint.linkColor;
  }

  public int getMaxLines()
  {
    return this.mParams.maxLines;
  }

  public boolean getShouldCacheLayout()
  {
    return this.mShouldCacheLayout;
  }

  public boolean getShouldWarmText()
  {
    return this.mShouldWarmText;
  }

  public boolean getSingleLine()
  {
    return this.mParams.singleLine;
  }

  public CharSequence getText()
  {
    return this.mParams.text;
  }

  @ColorInt
  public int getTextColor()
  {
    return this.mParams.paint.getColor();
  }

  public TextDirectionHeuristicCompat getTextDirection()
  {
    return this.mParams.textDirection;
  }

  public float getTextSize()
  {
    return this.mParams.paint.getTextSize();
  }

  public float getTextSpacingExtra()
  {
    return this.mParams.spacingAdd;
  }

  public float getTextSpacingMultiplier()
  {
    return this.mParams.spacingMult;
  }

  public Typeface getTypeface()
  {
    return this.mParams.paint.getTypeface();
  }

  public TextLayoutBuilder setAlignment(Layout.Alignment paramAlignment)
  {
    if (this.mParams.alignment != paramAlignment)
    {
      this.mParams.alignment = paramAlignment;
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setDrawableState(int[] paramArrayOfInt)
  {
    this.mParams.createNewPaintIfNeeded();
    this.mParams.paint.drawableState = paramArrayOfInt;
    if ((this.mParams.color != null) && (this.mParams.color.isStateful()))
    {
      int i = this.mParams.color.getColorForState(paramArrayOfInt, 0);
      this.mParams.paint.setColor(i);
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.mParams.ellipsize != paramTruncateAt)
    {
      this.mParams.ellipsize = paramTruncateAt;
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setGlyphWarmer(GlyphWarmer paramGlyphWarmer)
  {
    this.mGlyphWarmer = paramGlyphWarmer;
    return this;
  }

  public TextLayoutBuilder setIncludeFontPadding(boolean paramBoolean)
  {
    if (this.mParams.includePadding != paramBoolean)
    {
      this.mParams.includePadding = paramBoolean;
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setLinkColor(@ColorInt int paramInt)
  {
    if (this.mParams.paint.linkColor != paramInt)
    {
      this.mParams.createNewPaintIfNeeded();
      this.mParams.paint.linkColor = paramInt;
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setMaxLines(int paramInt)
  {
    if (this.mParams.maxLines != paramInt)
    {
      this.mParams.maxLines = paramInt;
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, @ColorInt int paramInt)
  {
    this.mParams.createNewPaintIfNeeded();
    this.mParams.paint.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
    this.mSavedLayout = null;
    return this;
  }

  public TextLayoutBuilder setShouldCacheLayout(boolean paramBoolean)
  {
    this.mShouldCacheLayout = paramBoolean;
    return this;
  }

  public TextLayoutBuilder setShouldWarmText(boolean paramBoolean)
  {
    this.mShouldWarmText = paramBoolean;
    return this;
  }

  public TextLayoutBuilder setSingleLine(boolean paramBoolean)
  {
    if (this.mParams.singleLine != paramBoolean)
    {
      this.mParams.singleLine = paramBoolean;
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == this.mParams.text) || ((paramCharSequence != null) && (this.mParams.text != null) && (paramCharSequence.equals(this.mParams.text))))
      return this;
    this.mParams.text = paramCharSequence;
    this.mSavedLayout = null;
    return this;
  }

  public TextLayoutBuilder setTextColor(@ColorInt int paramInt)
  {
    this.mParams.createNewPaintIfNeeded();
    this.mParams.color = null;
    this.mParams.paint.setColor(paramInt);
    this.mSavedLayout = null;
    return this;
  }

  public TextLayoutBuilder setTextColor(ColorStateList paramColorStateList)
  {
    this.mParams.createNewPaintIfNeeded();
    this.mParams.color = paramColorStateList;
    paramColorStateList = this.mParams.paint;
    if (this.mParams.color != null);
    for (int i = this.mParams.color.getDefaultColor(); ; i = -16777216)
    {
      paramColorStateList.setColor(i);
      this.mSavedLayout = null;
      return this;
    }
  }

  public TextLayoutBuilder setTextDirection(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    if (this.mParams.textDirection != paramTextDirectionHeuristicCompat)
    {
      this.mParams.textDirection = paramTextDirectionHeuristicCompat;
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setTextSize(int paramInt)
  {
    if (this.mParams.paint.getTextSize() != paramInt)
    {
      this.mParams.createNewPaintIfNeeded();
      this.mParams.paint.setTextSize(paramInt);
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setTextSpacingExtra(float paramFloat)
  {
    if (this.mParams.spacingAdd != paramFloat)
    {
      this.mParams.spacingAdd = paramFloat;
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setTextSpacingMultiplier(float paramFloat)
  {
    if (this.mParams.spacingMult != paramFloat)
    {
      this.mParams.spacingMult = paramFloat;
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setTextStyle(int paramInt)
  {
    return setTypeface(Typeface.defaultFromStyle(paramInt));
  }

  public TextLayoutBuilder setTypeface(Typeface paramTypeface)
  {
    if (this.mParams.paint.getTypeface() != paramTypeface)
    {
      this.mParams.createNewPaintIfNeeded();
      this.mParams.paint.setTypeface(paramTypeface);
      this.mSavedLayout = null;
    }
    return this;
  }

  public TextLayoutBuilder setWidth(@Px int paramInt)
  {
    if (paramInt <= 0);
    for (int i = 0; ; i = 1)
      return setWidth(paramInt, i);
  }

  public TextLayoutBuilder setWidth(@Px int paramInt1, int paramInt2)
  {
    if ((this.mParams.width != paramInt1) || (this.mParams.measureMode != paramInt2))
    {
      this.mParams.width = paramInt1;
      this.mParams.measureMode = paramInt2;
      this.mSavedLayout = null;
    }
    return this;
  }

  private static class ComparableTextPaint extends TextPaint
  {
    private int mShadowColor;
    private float mShadowDx;
    private float mShadowDy;
    private float mShadowRadius;

    public ComparableTextPaint()
    {
    }

    public ComparableTextPaint(int paramInt)
    {
      super();
    }

    public ComparableTextPaint(Paint paramPaint)
    {
      super();
    }

    public int hashCode()
    {
      Typeface localTypeface = getTypeface();
      int j = getColor();
      int k = Float.floatToIntBits(getTextSize());
      if (localTypeface != null);
      for (int i = localTypeface.hashCode(); ; i = 0)
      {
        i = (((((((j + 31) * 31 + k) * 31 + i) * 31 + Float.floatToIntBits(this.mShadowDx)) * 31 + Float.floatToIntBits(this.mShadowDy)) * 31 + Float.floatToIntBits(this.mShadowRadius)) * 31 + this.mShadowColor) * 31 + this.linkColor;
        if (this.drawableState != null)
          break;
        k = i * 31 + 0;
        return k;
      }
      j = 0;
      while (true)
      {
        k = i;
        if (j >= this.drawableState.length)
          break;
        i = i * 31 + this.drawableState[j];
        j += 1;
      }
    }

    public void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
    {
      this.mShadowRadius = paramFloat1;
      this.mShadowDx = paramFloat2;
      this.mShadowDy = paramFloat3;
      this.mShadowColor = paramInt;
      super.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface MeasureMode
  {
  }

  @VisibleForTesting
  static class Params
  {
    Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
    ColorStateList color;
    TextUtils.TruncateAt ellipsize = null;
    boolean includePadding = true;
    boolean mForceNewPaint = false;
    int maxLines = 2147483647;
    int measureMode;
    TextPaint paint = new TextLayoutBuilder.ComparableTextPaint(1);
    boolean singleLine = false;
    float spacingAdd = 0.0F;
    float spacingMult = 1.0F;
    CharSequence text;
    TextDirectionHeuristicCompat textDirection = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    int width;

    void createNewPaintIfNeeded()
    {
      if (this.mForceNewPaint)
      {
        this.paint = new TextLayoutBuilder.ComparableTextPaint(this.paint);
        this.mForceNewPaint = false;
      }
    }

    public int hashCode()
    {
      int m = 1;
      int i2 = 0;
      int i;
      int i3;
      int i4;
      int i5;
      int i6;
      int j;
      label60: int k;
      label75: label82: int i7;
      int n;
      if (this.paint != null)
      {
        i = this.paint.hashCode();
        i3 = this.width;
        i4 = this.measureMode;
        i5 = Float.floatToIntBits(this.spacingMult);
        i6 = Float.floatToIntBits(this.spacingAdd);
        if (!this.includePadding)
          break label210;
        j = 1;
        if (this.ellipsize == null)
          break label215;
        k = this.ellipsize.hashCode();
        if (!this.singleLine)
          break label220;
        i7 = this.maxLines;
        if (this.alignment == null)
          break label226;
        n = this.alignment.hashCode();
        label104: if (this.textDirection == null)
          break label232;
      }
      label210: label215: label220: label226: label232: for (int i1 = this.textDirection.hashCode(); ; i1 = 0)
      {
        if (this.text != null)
          i2 = this.text.hashCode();
        return (((((((((((i + 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + j) * 31 + k) * 31 + m) * 31 + i7) * 31 + n) * 31 + i1) * 31 + i2;
        i = 0;
        break;
        j = 0;
        break label60;
        k = 0;
        break label75;
        m = 0;
        break label82;
        n = 0;
        break label104;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.fbui.textlayoutbuilder.TextLayoutBuilder
 * JD-Core Version:    0.6.0
 */