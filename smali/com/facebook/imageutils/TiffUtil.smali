.class Lcom/facebook/imageutils/TiffUtil;
.super Ljava/lang/Object;
.source "TiffUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/imageutils/TiffUtil$TiffHeader;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field public static final TIFF_BYTE_ORDER_BIG_END:I = 0x4d4d002a

.field public static final TIFF_BYTE_ORDER_LITTLE_END:I = 0x49492a00

.field public static final TIFF_TAG_ORIENTATION:I = 0x112

.field public static final TIFF_TYPE_SHORT:I = 0x3


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/facebook/imageutils/TiffUtil;

    sput-object v0, Lcom/facebook/imageutils/TiffUtil;->TAG:Ljava/lang/Class;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAutoRotateAngleFromOrientation(I)I
    .locals 3
    .param p0, "orientation"    # I

    .prologue
    const/4 v0, 0x0

    .line 37
    packed-switch p0, :pswitch_data_0

    .line 48
    :pswitch_0
    sget-object v1, Lcom/facebook/imageutils/TiffUtil;->TAG:Ljava/lang/Class;

    const-string v2, "Unsupported orientation"

    invoke-static {v1, v2}, Lcom/facebook/common/logging/FLog;->i(Ljava/lang/Class;Ljava/lang/String;)V

    .line 49
    :goto_0
    :pswitch_1
    return v0

    .line 42
    :pswitch_2
    const/16 v0, 0xb4

    goto :goto_0

    .line 44
    :pswitch_3
    const/16 v0, 0x5a

    goto :goto_0

    .line 46
    :pswitch_4
    const/16 v0, 0x10e

    goto :goto_0

    .line 37
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_4
    .end packed-switch
.end method

.method private static getOrientationFromTiffEntry(Ljava/io/InputStream;IZ)I
    .locals 6
    .param p0, "is"    # Ljava/io/InputStream;
    .param p1, "length"    # I
    .param p2, "isLittleEndian"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x2

    const/4 v3, 0x0

    .line 166
    const/16 v4, 0xa

    if-ge p1, v4, :cond_1

    .line 181
    :cond_0
    :goto_0
    return v3

    .line 170
    :cond_1
    invoke-static {p0, v5, p2}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v2

    .line 171
    .local v2, "type":I
    const/4 v4, 0x3

    if-ne v2, v4, :cond_0

    .line 175
    const/4 v4, 0x4

    invoke-static {p0, v4, p2}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v0

    .line 176
    .local v0, "count":I
    const/4 v4, 0x1

    if-ne v0, v4, :cond_0

    .line 179
    invoke-static {p0, v5, p2}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v3

    .line 180
    .local v3, "value":I
    invoke-static {p0, v5, p2}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v1

    .line 181
    .local v1, "padding":I
    goto :goto_0
.end method

.method private static moveToTiffEntryWithTag(Ljava/io/InputStream;IZI)I
    .locals 7
    .param p0, "is"    # Ljava/io/InputStream;
    .param p1, "length"    # I
    .param p2, "isLittleEndian"    # Z
    .param p3, "tagToFind"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x2

    const/4 v3, 0x0

    .line 137
    const/16 v4, 0xe

    if-ge p1, v4, :cond_1

    .line 154
    :cond_0
    :goto_0
    return v3

    .line 143
    :cond_1
    invoke-static {p0, v6, p2}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v0

    .line 144
    .local v0, "numEntries":I
    add-int/lit8 p1, p1, -0x2

    move v1, v0

    .line 145
    .end local v0    # "numEntries":I
    .local v1, "numEntries":I
    :goto_1
    add-int/lit8 v0, v1, -0x1

    .end local v1    # "numEntries":I
    .restart local v0    # "numEntries":I
    if-lez v1, :cond_0

    const/16 v4, 0xc

    if-lt p1, v4, :cond_0

    .line 146
    invoke-static {p0, v6, p2}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v2

    .line 147
    .local v2, "tag":I
    add-int/lit8 p1, p1, -0x2

    .line 148
    if-ne v2, p3, :cond_2

    move v3, p1

    .line 149
    goto :goto_0

    .line 151
    :cond_2
    const-wide/16 v4, 0xa

    invoke-virtual {p0, v4, v5}, Ljava/io/InputStream;->skip(J)J

    .line 152
    add-int/lit8 p1, p1, -0xa

    move v1, v0

    .line 153
    .end local v0    # "numEntries":I
    .restart local v1    # "numEntries":I
    goto :goto_1
.end method

.method public static readOrientationFromTIFF(Ljava/io/InputStream;I)I
    .locals 4
    .param p0, "is"    # Ljava/io/InputStream;
    .param p1, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 60
    new-instance v0, Lcom/facebook/imageutils/TiffUtil$TiffHeader;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/facebook/imageutils/TiffUtil$TiffHeader;-><init>(Lcom/facebook/imageutils/TiffUtil$1;)V

    .line 61
    .local v0, "tiffHeader":Lcom/facebook/imageutils/TiffUtil$TiffHeader;
    invoke-static {p0, p1, v0}, Lcom/facebook/imageutils/TiffUtil;->readTiffHeader(Ljava/io/InputStream;ILcom/facebook/imageutils/TiffUtil$TiffHeader;)I

    move-result p1

    .line 66
    iget v2, v0, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->firstIfdOffset:I

    add-int/lit8 v1, v2, -0x8

    .line 67
    .local v1, "toSkip":I
    if-eqz p1, :cond_0

    if-le v1, p1, :cond_1

    .line 68
    :cond_0
    const/4 v2, 0x0

    .line 77
    :goto_0
    return v2

    .line 70
    :cond_1
    int-to-long v2, v1

    invoke-virtual {p0, v2, v3}, Ljava/io/InputStream;->skip(J)J

    .line 71
    sub-int/2addr p1, v1

    .line 74
    iget-boolean v2, v0, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->isLittleEndian:Z

    const/16 v3, 0x112

    invoke-static {p0, p1, v2, v3}, Lcom/facebook/imageutils/TiffUtil;->moveToTiffEntryWithTag(Ljava/io/InputStream;IZI)I

    move-result p1

    .line 77
    iget-boolean v2, v0, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->isLittleEndian:Z

    invoke-static {p0, p1, v2}, Lcom/facebook/imageutils/TiffUtil;->getOrientationFromTiffEntry(Ljava/io/InputStream;IZ)I

    move-result v2

    goto :goto_0
.end method

.method private static readTiffHeader(Ljava/io/InputStream;ILcom/facebook/imageutils/TiffUtil$TiffHeader;)I
    .locals 6
    .param p0, "is"    # Ljava/io/InputStream;
    .param p1, "length"    # I
    .param p2, "tiffHeader"    # Lcom/facebook/imageutils/TiffUtil$TiffHeader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const v5, 0x49492a00    # 823968.0f

    const/16 v4, 0x8

    const/4 v3, 0x4

    const/4 v1, 0x0

    .line 98
    if-gt p1, v4, :cond_0

    .line 120
    :goto_0
    return v1

    .line 103
    :cond_0
    invoke-static {p0, v3, v1}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v0

    iput v0, p2, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->byteOrder:I

    .line 104
    add-int/lit8 p1, p1, -0x4

    .line 105
    iget v0, p2, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->byteOrder:I

    if-eq v0, v5, :cond_1

    iget v0, p2, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->byteOrder:I

    const v2, 0x4d4d002a    # 2.14958752E8f

    if-eq v0, v2, :cond_1

    .line 107
    sget-object v0, Lcom/facebook/imageutils/TiffUtil;->TAG:Ljava/lang/Class;

    const-string v2, "Invalid TIFF header"

    invoke-static {v0, v2}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/Class;Ljava/lang/String;)V

    goto :goto_0

    .line 110
    :cond_1
    iget v0, p2, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->byteOrder:I

    if-ne v0, v5, :cond_3

    const/4 v0, 0x1

    :goto_1
    iput-boolean v0, p2, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->isLittleEndian:Z

    .line 113
    iget-boolean v0, p2, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->isLittleEndian:Z

    invoke-static {p0, v3, v0}, Lcom/facebook/imageutils/StreamProcessor;->readPackedInt(Ljava/io/InputStream;IZ)I

    move-result v0

    iput v0, p2, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->firstIfdOffset:I

    .line 114
    add-int/lit8 p1, p1, -0x4

    .line 115
    iget v0, p2, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->firstIfdOffset:I

    if-lt v0, v4, :cond_2

    iget v0, p2, Lcom/facebook/imageutils/TiffUtil$TiffHeader;->firstIfdOffset:I

    add-int/lit8 v0, v0, -0x8

    if-le v0, p1, :cond_4

    .line 116
    :cond_2
    sget-object v0, Lcom/facebook/imageutils/TiffUtil;->TAG:Ljava/lang/Class;

    const-string v2, "Invalid offset"

    invoke-static {v0, v2}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/Class;Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    move v0, v1

    .line 110
    goto :goto_1

    :cond_4
    move v1, p1

    .line 120
    goto :goto_0
.end method
