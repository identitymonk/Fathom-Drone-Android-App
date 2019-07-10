.class public Lcom/facebook/imageutils/JfifUtil;
.super Ljava/lang/Object;
.source "JfifUtil.java"


# static fields
.field public static final APP1_EXIF_MAGIC:I = 0x45786966

.field public static final MARKER_APP1:I = 0xe1

.field public static final MARKER_EOI:I = 0xd9

.field public static final MARKER_ESCAPE_BYTE:I = 0x0

.field public static final MARKER_FIRST_BYTE:I = 0xff

.field public static final MARKER_RST0:I = 0xd0

.field public static final MARKER_RST7:I = 0xd7

.field public static final MARKER_SOFn:I = 0xc0

.field public static final MARKER_SOI:I = 0xd8

.field public static final MARKER_SOS:I = 0xda

.field public static final MARKER_TEM:I = 0x1


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    return-void
.end method

.method public static getAutoRotateAngleFromOrientation(I)I
    .locals 1
    .param p0, "orientation"    # I

    .prologue
    .line 48
    invoke-static {p0}, Lcom/facebook/imageutils/TiffUtil;->getAutoRotateAngleFromOrientation(I)I

    move-result v0

    return v0
.end method

.method public static getOrientation(Ljava/io/InputStream;)I
    .locals 3
    .param p0, "is"    # Ljava/io/InputStream;

    .prologue
    const/4 v2, 0x0

    .line 68
    :try_start_0
    invoke-static {p0}, Lcom/facebook/imageutils/JfifUtil;->moveToAPP1EXIF(Ljava/io/InputStream;)I

    move-result v1

    .line 69
    .local v1, "length":I
    if-nez v1, :cond_0

    .line 74
    .end local v1    # "length":I
    :goto_0
    return v2

    .line 72
    .restart local v1    # "length":I
    :cond_0
    invoke-static {p0, v1}, Lcom/facebook/imageutils/TiffUtil;->readOrientationFromTIFF(Ljava/io/InputStream;I)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 73
    .end local v1    # "length":I
    :catch_0
    move-exception v0

    .line 74
    .local v0, "ioe":Ljava/io/IOException;
    goto :goto_0
.end method

.method public static getOrientation([B)I
    .locals 1
    .param p0, "jpeg"    # [B

    .prologue
    .line 58
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-static {v0}, Lcom/facebook/imageutils/JfifUtil;->getOrientation(Ljava/io/InputStream;)I

    move-result v0

    return v0
.end method

.method private static isSOFn(I)Z
    .locals 1
    .param p0, "marker"    # I

    .prologue
    .line 123
    packed-switch p0, :pswitch_data_0

    .line 139
    :pswitch_0
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 137
    :pswitch_1
    const/4 v0, 0x1

    goto :goto_0

    .line 123
    nop

    :pswitch_data_0
    .packed-switch 0xc0
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method private static moveToAPP1EXIF(Ljava/io/InputStream;)I
    .locals 6
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x2

    const/4 v3, 0x0

    .line 149
    const/16 v4, 0xe1

    invoke-static {p0, v4}, Lcom/facebook/imageutils/JfifUtil;->moveToMarker(Ljava/io/InputStream;I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 152
    invoke-static {p0, v5, v3}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v4

    add-int/lit8 v0, v4, -0x2

    .line 153
    .local v0, "length":I
    const/4 v4, 0x6

    if-le v0, v4, :cond_0

    .line 154
    const/4 v4, 0x4

    invoke-static {p0, v4, v3}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v1

    .line 155
    .local v1, "magic":I
    add-int/lit8 v0, v0, -0x4

    .line 156
    invoke-static {p0, v5, v3}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v2

    .line 157
    .local v2, "zero":I
    add-int/lit8 v0, v0, -0x2

    .line 158
    const v4, 0x45786966

    if-ne v1, v4, :cond_0

    if-nez v2, :cond_0

    .line 164
    .end local v0    # "length":I
    .end local v1    # "magic":I
    .end local v2    # "zero":I
    :goto_0
    return v0

    :cond_0
    move v0, v3

    goto :goto_0
.end method

.method public static moveToMarker(Ljava/io/InputStream;I)Z
    .locals 7
    .param p0, "is"    # Ljava/io/InputStream;
    .param p1, "markerToFind"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v6, 0xff

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 86
    invoke-static {p0}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    :cond_0
    :goto_0
    invoke-static {p0, v2, v3}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v4

    if-ne v4, v6, :cond_6

    .line 89
    const/16 v1, 0xff

    .line 90
    .local v1, "marker":I
    :goto_1
    if-ne v1, v6, :cond_1

    .line 91
    invoke-static {p0, v2, v3}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v1

    goto :goto_1

    .line 94
    :cond_1
    const/16 v4, 0xc0

    if-ne p1, v4, :cond_3

    invoke-static {v1}, Lcom/facebook/imageutils/JfifUtil;->isSOFn(I)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 118
    .end local v1    # "marker":I
    :cond_2
    :goto_2
    return v2

    .line 97
    .restart local v1    # "marker":I
    :cond_3
    if-eq v1, p1, :cond_2

    .line 102
    const/16 v4, 0xd8

    if-eq v1, v4, :cond_0

    if-eq v1, v2, :cond_0

    .line 108
    const/16 v4, 0xd9

    if-eq v1, v4, :cond_4

    const/16 v4, 0xda

    if-ne v1, v4, :cond_5

    :cond_4
    move v2, v3

    .line 109
    goto :goto_2

    .line 114
    :cond_5
    const/4 v4, 0x2

    invoke-static {p0, v4, v3}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v4

    add-int/lit8 v0, v4, -0x2

    .line 116
    .local v0, "length":I
    int-to-long v4, v0

    invoke-virtual {p0, v4, v5}, Ljava/io/InputStream;->skip(J)J

    goto :goto_0

    .end local v0    # "length":I
    .end local v1    # "marker":I
    :cond_6
    move v2, v3

    .line 118
    goto :goto_2
.end method
