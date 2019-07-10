.class public Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
.super Ljava/lang/Object;
.source "TextLayoutBuilder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;,
        Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;,
        Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$MeasureMode;
    }
.end annotation


# static fields
.field public static final DEFAULT_MAX_LINES:I = 0x7fffffff

.field public static final MEASURE_MODE_AT_MOST:I = 0x2

.field public static final MEASURE_MODE_EXACTLY:I = 0x1

.field public static final MEASURE_MODE_UNSPECIFIED:I

.field static final sCache:Landroid/support/v4/util/LruCache;
    .annotation build Landroid/support/annotation/VisibleForTesting;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LruCache",
            "<",
            "Ljava/lang/Integer;",
            "Landroid/text/Layout;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mGlyphWarmer:Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;

.field final mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;
    .annotation build Landroid/support/annotation/VisibleForTesting;
    .end annotation
.end field

.field private mSavedLayout:Landroid/text/Layout;

.field private mShouldCacheLayout:Z

.field private mShouldWarmText:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 63
    new-instance v0, Landroid/support/v4/util/LruCache;

    const/16 v1, 0x64

    invoke-direct {v0, v1}, Landroid/support/v4/util/LruCache;-><init>(I)V

    sput-object v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->sCache:Landroid/support/v4/util/LruCache;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 125
    new-instance v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    invoke-direct {v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;-><init>()V

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    .line 129
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 135
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldCacheLayout:Z

    .line 138
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldWarmText:Z

    return-void
.end method


# virtual methods
.method public build()Landroid/text/Layout;
    .locals 28

    .prologue
    .line 628
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldCacheLayout:Z

    if-eqz v2, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    if-eqz v2, :cond_1

    .line 629
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    move-object/from16 v22, v0

    .line 749
    :cond_0
    :goto_0
    return-object v22

    .line 632
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 633
    const/16 v22, 0x0

    goto :goto_0

    .line 636
    :cond_2
    const/16 v24, 0x0

    .line 637
    .local v24, "hasClickableSpans":Z
    const/16 v25, -0x1

    .line 639
    .local v25, "hashCode":I
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldCacheLayout:Z

    if-eqz v2, :cond_3

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    instance-of v2, v2, Landroid/text/Spannable;

    if-eqz v2, :cond_3

    .line 640
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    check-cast v2, Landroid/text/Spannable;

    const/4 v3, 0x0

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v5, v5, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    .line 642
    invoke-interface {v5}, Ljava/lang/CharSequence;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    const-class v6, Landroid/text/style/ClickableSpan;

    .line 640
    invoke-interface {v2, v3, v5, v6}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v27

    check-cast v27, [Landroid/text/style/ClickableSpan;

    .line 644
    .local v27, "spans":[Landroid/text/style/ClickableSpan;
    move-object/from16 v0, v27

    array-length v2, v0

    if-lez v2, :cond_6

    const/16 v24, 0x1

    .line 650
    .end local v27    # "spans":[Landroid/text/style/ClickableSpan;
    :cond_3
    :goto_1
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldCacheLayout:Z

    if-eqz v2, :cond_4

    if-nez v24, :cond_4

    .line 651
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    invoke-virtual {v2}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->hashCode()I

    move-result v25

    .line 652
    sget-object v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->sCache:Landroid/support/v4/util/LruCache;

    invoke-static/range {v25 .. v25}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/support/v4/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Landroid/text/Layout;

    .line 653
    .local v22, "cachedLayout":Landroid/text/Layout;
    if-nez v22, :cond_0

    .line 658
    .end local v22    # "cachedLayout":Landroid/text/Layout;
    :cond_4
    const/4 v8, 0x0

    .line 660
    .local v8, "metrics":Landroid/text/BoringLayout$Metrics;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-boolean v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->singleLine:Z

    if-eqz v2, :cond_7

    const/16 v20, 0x1

    .line 663
    .local v20, "numLines":I
    :goto_2
    const/4 v2, 0x1

    move/from16 v0, v20

    if-ne v0, v2, :cond_5

    .line 664
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v3, v3, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-static {v2, v3}, Landroid/text/BoringLayout;->isBoring(Ljava/lang/CharSequence;Landroid/text/TextPaint;)Landroid/text/BoringLayout$Metrics;

    move-result-object v8

    .line 671
    :cond_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->measureMode:I

    packed-switch v2, :pswitch_data_0

    .line 685
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unexpected measure mode "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v5, v5, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->measureMode:I

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 644
    .end local v8    # "metrics":Landroid/text/BoringLayout$Metrics;
    .end local v20    # "numLines":I
    .restart local v27    # "spans":[Landroid/text/style/ClickableSpan;
    :cond_6
    const/16 v24, 0x0

    goto :goto_1

    .line 660
    .end local v27    # "spans":[Landroid/text/style/ClickableSpan;
    .restart local v8    # "metrics":Landroid/text/BoringLayout$Metrics;
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->maxLines:I

    move/from16 v20, v0

    goto :goto_2

    .line 673
    .restart local v20    # "numLines":I
    :pswitch_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v3, v3, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-static {v2, v3}, Landroid/text/Layout;->getDesiredWidth(Ljava/lang/CharSequence;Landroid/text/TextPaint;)F

    move-result v2

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v4, v2

    .line 689
    .local v4, "width":I
    :goto_3
    if-eqz v8, :cond_a

    .line 690
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v3, v3, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v5, v5, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->alignment:Landroid/text/Layout$Alignment;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v6, v6, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingMult:F

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v7, v7, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingAdd:F

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-boolean v9, v9, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->includePadding:Z

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v10, v10, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->ellipsize:Landroid/text/TextUtils$TruncateAt;

    move v11, v4

    invoke-static/range {v2 .. v11}, Landroid/text/BoringLayout;->make(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZLandroid/text/TextUtils$TruncateAt;I)Landroid/text/BoringLayout;

    move-result-object v26

    .line 736
    .local v26, "layout":Landroid/text/Layout;
    :goto_4
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldCacheLayout:Z

    if-eqz v2, :cond_8

    if-nez v24, :cond_8

    .line 737
    move-object/from16 v0, v26

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 738
    sget-object v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->sCache:Landroid/support/v4/util/LruCache;

    invoke-static/range {v25 .. v25}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    move-object/from16 v0, v26

    invoke-virtual {v2, v3, v0}, Landroid/support/v4/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 742
    :cond_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->mForceNewPaint:Z

    .line 744
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldWarmText:Z

    if-eqz v2, :cond_9

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mGlyphWarmer:Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;

    if-eqz v2, :cond_9

    .line 746
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mGlyphWarmer:Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;

    move-object/from16 v0, v26

    invoke-interface {v2, v0}, Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;->warmLayout(Landroid/text/Layout;)V

    :cond_9
    move-object/from16 v22, v26

    .line 749
    goto/16 :goto_0

    .line 676
    .end local v4    # "width":I
    .end local v26    # "layout":Landroid/text/Layout;
    :pswitch_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v4, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->width:I

    .line 677
    .restart local v4    # "width":I
    goto :goto_3

    .line 679
    .end local v4    # "width":I
    :pswitch_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v3, v3, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    .line 681
    invoke-static {v2, v3}, Landroid/text/Layout;->getDesiredWidth(Ljava/lang/CharSequence;Landroid/text/TextPaint;)F

    move-result v2

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v2, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v3, v3, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->width:I

    .line 680
    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v4

    .line 683
    .restart local v4    # "width":I
    goto/16 :goto_3

    .line 718
    :catch_0
    move-exception v23

    .line 720
    .local v23, "e":Ljava/lang/IndexOutOfBoundsException;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    instance-of v2, v2, Ljava/lang/String;

    if-nez v2, :cond_b

    .line 722
    const-string v2, "TextLayoutBuilder"

    const-string v3, "Hit bug #35412, retrying with Spannables removed"

    move-object/from16 v0, v23

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 723
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v3, v3, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    .line 704
    .end local v23    # "e":Ljava/lang/IndexOutOfBoundsException;
    :cond_a
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v9, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    const/4 v10, 0x0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v2, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    .line 707
    invoke-interface {v2}, Ljava/lang/CharSequence;->length()I

    move-result v11

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v12, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v14, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->alignment:Landroid/text/Layout$Alignment;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v15, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingMult:F

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingAdd:F

    move/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-boolean v0, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->includePadding:Z

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->ellipsize:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v2, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->textDirection:Landroid/support/v4/text/TextDirectionHeuristicCompat;

    move-object/from16 v21, v0

    move v13, v4

    move/from16 v19, v4

    .line 704
    invoke-static/range {v9 .. v21}, Lcom/facebook/fbui/textlayoutbuilder/StaticLayoutHelper;->make(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;IILandroid/support/v4/text/TextDirectionHeuristicCompat;)Landroid/text/StaticLayout;
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v26

    .restart local v26    # "layout":Landroid/text/Layout;
    goto/16 :goto_4

    .line 727
    .end local v26    # "layout":Landroid/text/Layout;
    .restart local v23    # "e":Ljava/lang/IndexOutOfBoundsException;
    :cond_b
    throw v23

    .line 671
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public getAlignment()Landroid/text/Layout$Alignment;
    .locals 1

    .prologue
    .line 360
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->alignment:Landroid/text/Layout$Alignment;

    return-object v0
.end method

.method public getDrawableState()[I
    .locals 1

    .prologue
    .line 459
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    iget-object v0, v0, Landroid/text/TextPaint;->drawableState:[I

    return-object v0
.end method

.method public getEllipsize()Landroid/text/TextUtils$TruncateAt;
    .locals 1

    .prologue
    .line 486
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->ellipsize:Landroid/text/TextUtils$TruncateAt;

    return-object v0
.end method

.method public getGlyphWarmer()Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;
    .locals 1

    .prologue
    .line 606
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mGlyphWarmer:Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;

    return-object v0
.end method

.method public getIncludeFontPadding()Z
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-boolean v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->includePadding:Z

    return v0
.end method

.method public getLinkColor()I
    .locals 1
    .annotation build Landroid/support/annotation/ColorInt;
    .end annotation

    .prologue
    .line 264
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    iget v0, v0, Landroid/text/TextPaint;->linkColor:I

    return v0
.end method

.method public getMaxLines()I
    .locals 1

    .prologue
    .line 533
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->maxLines:I

    return v0
.end method

.method public getShouldCacheLayout()Z
    .locals 1

    .prologue
    .line 560
    iget-boolean v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldCacheLayout:Z

    return v0
.end method

.method public getShouldWarmText()Z
    .locals 1

    .prologue
    .line 582
    iget-boolean v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldWarmText:Z

    return v0
.end method

.method public getSingleLine()Z
    .locals 1

    .prologue
    .line 509
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-boolean v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->singleLine:Z

    return v0
.end method

.method public getText()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getTextColor()I
    .locals 1
    .annotation build Landroid/support/annotation/ColorInt;
    .end annotation

    .prologue
    .line 226
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0}, Landroid/text/TextPaint;->getColor()I

    move-result v0

    return v0
.end method

.method public getTextDirection()Landroid/support/v4/text/TextDirectionHeuristicCompat;
    .locals 1

    .prologue
    .line 383
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->textDirection:Landroid/support/v4/text/TextDirectionHeuristicCompat;

    return-object v0
.end method

.method public getTextSize()F
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0}, Landroid/text/TextPaint;->getTextSize()F

    move-result v0

    return v0
.end method

.method public getTextSpacingExtra()F
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingAdd:F

    return v0
.end method

.method public getTextSpacingMultiplier()F
    .locals 1

    .prologue
    .line 311
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingMult:F

    return v0
.end method

.method public getTypeface()Landroid/graphics/Typeface;
    .locals 1

    .prologue
    .line 435
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0}, Landroid/text/TextPaint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v0

    return-object v0
.end method

.method public setAlignment(Landroid/text/Layout$Alignment;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "alignment"    # Landroid/text/Layout$Alignment;

    .prologue
    .line 370
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->alignment:Landroid/text/Layout$Alignment;

    if-eq v0, p1, :cond_0

    .line 371
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput-object p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->alignment:Landroid/text/Layout$Alignment;

    .line 372
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 374
    :cond_0
    return-object p0
.end method

.method public setDrawableState([I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 3
    .param p1, "drawableState"    # [I

    .prologue
    .line 469
    iget-object v1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    invoke-virtual {v1}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->createNewPaintIfNeeded()V

    .line 470
    iget-object v1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v1, v1, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    iput-object p1, v1, Landroid/text/TextPaint;->drawableState:[I

    .line 472
    iget-object v1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v1, v1, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->color:Landroid/content/res/ColorStateList;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v1, v1, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->color:Landroid/content/res/ColorStateList;

    invoke-virtual {v1}, Landroid/content/res/ColorStateList;->isStateful()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 473
    iget-object v1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v1, v1, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->color:Landroid/content/res/ColorStateList;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    .line 474
    .local v0, "color":I
    iget-object v1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v1, v1, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-virtual {v1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 475
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 477
    .end local v0    # "color":I
    :cond_0
    return-object p0
.end method

.method public setEllipsize(Landroid/text/TextUtils$TruncateAt;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "ellipsize"    # Landroid/text/TextUtils$TruncateAt;

    .prologue
    .line 496
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->ellipsize:Landroid/text/TextUtils$TruncateAt;

    if-eq v0, p1, :cond_0

    .line 497
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput-object p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->ellipsize:Landroid/text/TextUtils$TruncateAt;

    .line 498
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 500
    :cond_0
    return-object p0
.end method

.method public setGlyphWarmer(Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 0
    .param p1, "glyphWarmer"    # Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;

    .prologue
    .line 617
    iput-object p1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mGlyphWarmer:Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;

    .line 618
    return-object p0
.end method

.method public setIncludeFontPadding(Z)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "shouldInclude"    # Z

    .prologue
    .line 347
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-boolean v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->includePadding:Z

    if-eq v0, p1, :cond_0

    .line 348
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput-boolean p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->includePadding:Z

    .line 349
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 351
    :cond_0
    return-object p0
.end method

.method public setLinkColor(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "linkColor"    # I
        .annotation build Landroid/support/annotation/ColorInt;
        .end annotation
    .end param

    .prologue
    .line 274
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    iget v0, v0, Landroid/text/TextPaint;->linkColor:I

    if-eq v0, p1, :cond_0

    .line 275
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    invoke-virtual {v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->createNewPaintIfNeeded()V

    .line 276
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    iput p1, v0, Landroid/text/TextPaint;->linkColor:I

    .line 277
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 279
    :cond_0
    return-object p0
.end method

.method public setMaxLines(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "maxLines"    # I

    .prologue
    .line 547
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->maxLines:I

    if-eq v0, p1, :cond_0

    .line 548
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->maxLines:I

    .line 549
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 551
    :cond_0
    return-object p0
.end method

.method public setShadowLayer(FFFI)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "radius"    # F
    .param p2, "dx"    # F
    .param p3, "dy"    # F
    .param p4, "color"    # I
        .annotation build Landroid/support/annotation/ColorInt;
        .end annotation
    .end param

    .prologue
    .line 413
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    invoke-virtual {v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->createNewPaintIfNeeded()V

    .line 414
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/text/TextPaint;->setShadowLayer(FFFI)V

    .line 415
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 416
    return-object p0
.end method

.method public setShouldCacheLayout(Z)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 0
    .param p1, "shouldCacheLayout"    # Z

    .prologue
    .line 572
    iput-boolean p1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldCacheLayout:Z

    .line 573
    return-object p0
.end method

.method public setShouldWarmText(Z)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 0
    .param p1, "shouldWarmText"    # Z

    .prologue
    .line 596
    iput-boolean p1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mShouldWarmText:Z

    .line 597
    return-object p0
.end method

.method public setSingleLine(Z)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "singleLine"    # Z

    .prologue
    .line 520
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-boolean v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->singleLine:Z

    if-eq v0, p1, :cond_0

    .line 521
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput-boolean p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->singleLine:Z

    .line 522
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 524
    :cond_0
    return-object p0
.end method

.method public setText(Ljava/lang/CharSequence;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 186
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    if-eq p1, v0, :cond_0

    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    .line 187
    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 192
    :cond_0
    :goto_0
    return-object p0

    .line 190
    :cond_1
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput-object p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->text:Ljava/lang/CharSequence;

    .line 191
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    goto :goto_0
.end method

.method public setTextColor(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 2
    .param p1, "color"    # I
        .annotation build Landroid/support/annotation/ColorInt;
        .end annotation
    .end param

    .prologue
    const/4 v1, 0x0

    .line 236
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    invoke-virtual {v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->createNewPaintIfNeeded()V

    .line 237
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput-object v1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->color:Landroid/content/res/ColorStateList;

    .line 238
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0, p1}, Landroid/text/TextPaint;->setColor(I)V

    .line 239
    iput-object v1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 240
    return-object p0
.end method

.method public setTextColor(Landroid/content/res/ColorStateList;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 2
    .param p1, "colorStateList"    # Landroid/content/res/ColorStateList;

    .prologue
    .line 250
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    invoke-virtual {v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->createNewPaintIfNeeded()V

    .line 251
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput-object p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->color:Landroid/content/res/ColorStateList;

    .line 252
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->color:Landroid/content/res/ColorStateList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->color:Landroid/content/res/ColorStateList;

    invoke-virtual {v0}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 253
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 254
    return-object p0

    .line 252
    :cond_0
    const/high16 v0, -0x1000000

    goto :goto_0
.end method

.method public setTextDirection(Landroid/support/v4/text/TextDirectionHeuristicCompat;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "textDirection"    # Landroid/support/v4/text/TextDirectionHeuristicCompat;

    .prologue
    .line 396
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->textDirection:Landroid/support/v4/text/TextDirectionHeuristicCompat;

    if-eq v0, p1, :cond_0

    .line 397
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput-object p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->textDirection:Landroid/support/v4/text/TextDirectionHeuristicCompat;

    .line 398
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 400
    :cond_0
    return-object p0
.end method

.method public setTextSize(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 2
    .param p1, "size"    # I

    .prologue
    .line 211
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0}, Landroid/text/TextPaint;->getTextSize()F

    move-result v0

    int-to-float v1, p1

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_0

    .line 212
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    invoke-virtual {v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->createNewPaintIfNeeded()V

    .line 213
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    int-to-float v1, p1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 214
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 216
    :cond_0
    return-object p0
.end method

.method public setTextSpacingExtra(F)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "spacingExtra"    # F

    .prologue
    .line 298
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingAdd:F

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_0

    .line 299
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingAdd:F

    .line 300
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 302
    :cond_0
    return-object p0
.end method

.method public setTextSpacingMultiplier(F)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "spacingMultiplier"    # F

    .prologue
    .line 321
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingMult:F

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_0

    .line 322
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->spacingMult:F

    .line 323
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 325
    :cond_0
    return-object p0
.end method

.method public setTextStyle(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "style"    # I

    .prologue
    .line 426
    invoke-static {p1}, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTypeface(Landroid/graphics/Typeface;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v0

    return-object v0
.end method

.method public setTypeface(Landroid/graphics/Typeface;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "typeface"    # Landroid/graphics/Typeface;

    .prologue
    .line 445
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0}, Landroid/text/TextPaint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v0

    if-eq v0, p1, :cond_0

    .line 446
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    invoke-virtual {v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->createNewPaintIfNeeded()V

    .line 447
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget-object v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0, p1}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 448
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 450
    :cond_0
    return-object p0
.end method

.method public setWidth(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "width"    # I
        .annotation build Landroid/support/annotation/Px;
        .end annotation
    .end param

    .prologue
    .line 148
    if-gtz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0, p1, v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setWidth(II)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setWidth(II)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .locals 1
    .param p1, "width"    # I
        .annotation build Landroid/support/annotation/Px;
        .end annotation
    .end param
    .param p2, "measureMode"    # I

    .prologue
    .line 162
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->width:I

    if-ne v0, p1, :cond_0

    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iget v0, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->measureMode:I

    if-eq v0, p2, :cond_1

    .line 163
    :cond_0
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput p1, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->width:I

    .line 164
    iget-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mParams:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;

    iput p2, v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$Params;->measureMode:I

    .line 165
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->mSavedLayout:Landroid/text/Layout;

    .line 167
    :cond_1
    return-object p0
.end method
