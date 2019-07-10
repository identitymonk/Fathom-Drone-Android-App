.class public Lcom/facebook/common/webp/WebpSupportStatus;
.super Ljava/lang/Object;
.source "WebpSupportStatus.java"


# static fields
.field private static final EXTENDED_WEBP_HEADER_LENGTH:I = 0x15

.field private static final SIMPLE_WEBP_HEADER_LENGTH:I = 0x14

.field private static final VP8X_WEBP_BASE64:Ljava/lang/String; = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA=="

.field private static final WEBP_NAME_BYTES:[B

.field private static final WEBP_RIFF_BYTES:[B

.field private static final WEBP_VP8L_BYTES:[B

.field private static final WEBP_VP8X_BYTES:[B

.field private static final WEBP_VP8_BYTES:[B

.field public static final sIsExtendedWebpSupported:Z

.field public static final sIsSimpleWebpSupported:Z

.field public static final sIsWebpSupportRequired:Z

.field public static sWebpBitmapFactory:Lcom/facebook/common/webp/WebpBitmapFactory;

.field private static sWebpLibraryChecked:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 19
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x11

    if-gt v0, v3, :cond_0

    move v0, v1

    :goto_0
    sput-boolean v0, Lcom/facebook/common/webp/WebpSupportStatus;->sIsWebpSupportRequired:Z

    .line 22
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xe

    if-lt v0, v3, :cond_1

    :goto_1
    sput-boolean v1, Lcom/facebook/common/webp/WebpSupportStatus;->sIsSimpleWebpSupported:Z

    .line 25
    invoke-static {}, Lcom/facebook/common/webp/WebpSupportStatus;->isExtendedWebpSupported()Z

    move-result v0

    sput-boolean v0, Lcom/facebook/common/webp/WebpSupportStatus;->sIsExtendedWebpSupported:Z

    .line 27
    const/4 v0, 0x0

    sput-object v0, Lcom/facebook/common/webp/WebpSupportStatus;->sWebpBitmapFactory:Lcom/facebook/common/webp/WebpBitmapFactory;

    .line 29
    sput-boolean v2, Lcom/facebook/common/webp/WebpSupportStatus;->sWebpLibraryChecked:Z

    .line 83
    const-string v0, "RIFF"

    invoke-static {v0}, Lcom/facebook/common/webp/WebpSupportStatus;->asciiBytes(Ljava/lang/String;)[B

    move-result-object v0

    sput-object v0, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_RIFF_BYTES:[B

    .line 84
    const-string v0, "WEBP"

    invoke-static {v0}, Lcom/facebook/common/webp/WebpSupportStatus;->asciiBytes(Ljava/lang/String;)[B

    move-result-object v0

    sput-object v0, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_NAME_BYTES:[B

    .line 89
    const-string v0, "VP8 "

    invoke-static {v0}, Lcom/facebook/common/webp/WebpSupportStatus;->asciiBytes(Ljava/lang/String;)[B

    move-result-object v0

    sput-object v0, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_VP8_BYTES:[B

    .line 90
    const-string v0, "VP8L"

    invoke-static {v0}, Lcom/facebook/common/webp/WebpSupportStatus;->asciiBytes(Ljava/lang/String;)[B

    move-result-object v0

    sput-object v0, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_VP8L_BYTES:[B

    .line 91
    const-string v0, "VP8X"

    invoke-static {v0}, Lcom/facebook/common/webp/WebpSupportStatus;->asciiBytes(Ljava/lang/String;)[B

    move-result-object v0

    sput-object v0, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_VP8X_BYTES:[B

    return-void

    :cond_0
    move v0, v2

    .line 19
    goto :goto_0

    :cond_1
    move v1, v2

    .line 22
    goto :goto_1
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static asciiBytes(Ljava/lang/String;)[B
    .locals 3
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 61
    :try_start_0
    const-string v1, "ASCII"

    invoke-virtual {p0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 62
    :catch_0
    move-exception v0

    .line 64
    .local v0, "uee":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "ASCII not found!"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public static isAnimatedWebpHeader([BI)Z
    .locals 6
    .param p0, "imageHeaderBytes"    # [B
    .param p1, "offset"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 147
    add-int/lit8 v4, p1, 0xc

    sget-object v5, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_VP8X_BYTES:[B

    invoke-static {p0, v4, v5}, Lcom/facebook/common/webp/WebpSupportStatus;->matchBytePattern([BI[B)Z

    move-result v1

    .line 149
    .local v1, "isVp8x":Z
    add-int/lit8 v4, p1, 0x14

    aget-byte v4, p0, v4

    and-int/lit8 v4, v4, 0x2

    const/4 v5, 0x2

    if-ne v4, v5, :cond_0

    move v0, v2

    .line 150
    .local v0, "hasAnimationBit":Z
    :goto_0
    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    :goto_1
    return v2

    .end local v0    # "hasAnimationBit":Z
    :cond_0
    move v0, v3

    .line 149
    goto :goto_0

    .restart local v0    # "hasAnimationBit":Z
    :cond_1
    move v2, v3

    .line 150
    goto :goto_1
.end method

.method public static isExtendedWebpHeader([BII)Z
    .locals 2
    .param p0, "imageHeaderBytes"    # [B
    .param p1, "offset"    # I
    .param p2, "headerSize"    # I

    .prologue
    .line 165
    const/16 v0, 0x15

    if-lt p2, v0, :cond_0

    add-int/lit8 v0, p1, 0xc

    sget-object v1, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_VP8X_BYTES:[B

    .line 166
    invoke-static {p0, v0, v1}, Lcom/facebook/common/webp/WebpSupportStatus;->matchBytePattern([BI[B)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isExtendedWebpHeaderWithAlpha([BI)Z
    .locals 6
    .param p0, "imageHeaderBytes"    # [B
    .param p1, "offset"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 172
    add-int/lit8 v4, p1, 0xc

    sget-object v5, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_VP8X_BYTES:[B

    invoke-static {p0, v4, v5}, Lcom/facebook/common/webp/WebpSupportStatus;->matchBytePattern([BI[B)Z

    move-result v1

    .line 174
    .local v1, "isVp8x":Z
    add-int/lit8 v4, p1, 0x14

    aget-byte v4, p0, v4

    and-int/lit8 v4, v4, 0x10

    const/16 v5, 0x10

    if-ne v4, v5, :cond_0

    move v0, v2

    .line 175
    .local v0, "hasAlphaBit":Z
    :goto_0
    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    :goto_1
    return v2

    .end local v0    # "hasAlphaBit":Z
    :cond_0
    move v0, v3

    .line 174
    goto :goto_0

    .restart local v0    # "hasAlphaBit":Z
    :cond_1
    move v2, v3

    .line 175
    goto :goto_1
.end method

.method private static isExtendedWebpSupported()Z
    .locals 6

    .prologue
    const/16 v5, 0x11

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 100
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v4, v5, :cond_1

    .line 121
    .local v0, "decodedBytes":[B
    .local v1, "opts":Landroid/graphics/BitmapFactory$Options;
    :cond_0
    :goto_0
    return v2

    .line 104
    .end local v0    # "decodedBytes":[B
    .end local v1    # "opts":Landroid/graphics/BitmapFactory$Options;
    :cond_1
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ne v4, v5, :cond_2

    .line 107
    const-string v4, "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA=="

    invoke-static {v4, v2}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    .line 108
    .restart local v0    # "decodedBytes":[B
    new-instance v1, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v1}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 109
    .restart local v1    # "opts":Landroid/graphics/BitmapFactory$Options;
    iput-boolean v3, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 110
    array-length v4, v0

    invoke-static {v0, v2, v4, v1}, Landroid/graphics/BitmapFactory;->decodeByteArray([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 116
    iget v4, v1, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    if-ne v4, v3, :cond_0

    iget v4, v1, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    if-ne v4, v3, :cond_0

    :cond_2
    move v2, v3

    .line 121
    goto :goto_0
.end method

.method public static isLosslessWebpHeader([BI)Z
    .locals 2
    .param p0, "imageHeaderBytes"    # [B
    .param p1, "offset"    # I

    .prologue
    .line 158
    add-int/lit8 v0, p1, 0xc

    sget-object v1, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_VP8L_BYTES:[B

    invoke-static {p0, v0, v1}, Lcom/facebook/common/webp/WebpSupportStatus;->matchBytePattern([BI[B)Z

    move-result v0

    return v0
.end method

.method public static isSimpleWebpHeader([BI)Z
    .locals 2
    .param p0, "imageHeaderBytes"    # [B
    .param p1, "offset"    # I

    .prologue
    .line 154
    add-int/lit8 v0, p1, 0xc

    sget-object v1, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_VP8_BYTES:[B

    invoke-static {p0, v0, v1}, Lcom/facebook/common/webp/WebpSupportStatus;->matchBytePattern([BI[B)Z

    move-result v0

    return v0
.end method

.method public static isWebpHeader([BII)Z
    .locals 2
    .param p0, "imageHeaderBytes"    # [B
    .param p1, "offset"    # I
    .param p2, "headerSize"    # I

    .prologue
    .line 191
    const/16 v0, 0x14

    if-lt p2, v0, :cond_0

    sget-object v0, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_RIFF_BYTES:[B

    .line 192
    invoke-static {p0, p1, v0}, Lcom/facebook/common/webp/WebpSupportStatus;->matchBytePattern([BI[B)Z

    move-result v0

    if-eqz v0, :cond_0

    add-int/lit8 v0, p1, 0x8

    sget-object v1, Lcom/facebook/common/webp/WebpSupportStatus;->WEBP_NAME_BYTES:[B

    .line 193
    invoke-static {p0, v0, v1}, Lcom/facebook/common/webp/WebpSupportStatus;->matchBytePattern([BI[B)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isWebpSupportedByPlatform([BII)Z
    .locals 2
    .param p0, "imageHeaderBytes"    # [B
    .param p1, "offset"    # I
    .param p2, "headerSize"    # I

    .prologue
    const/4 v0, 0x0

    .line 128
    invoke-static {p0, p1}, Lcom/facebook/common/webp/WebpSupportStatus;->isSimpleWebpHeader([BI)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 129
    sget-boolean v0, Lcom/facebook/common/webp/WebpSupportStatus;->sIsSimpleWebpSupported:Z

    .line 143
    :cond_0
    :goto_0
    return v0

    .line 132
    :cond_1
    invoke-static {p0, p1}, Lcom/facebook/common/webp/WebpSupportStatus;->isLosslessWebpHeader([BI)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 133
    sget-boolean v0, Lcom/facebook/common/webp/WebpSupportStatus;->sIsExtendedWebpSupported:Z

    goto :goto_0

    .line 136
    :cond_2
    invoke-static {p0, p1, p2}, Lcom/facebook/common/webp/WebpSupportStatus;->isExtendedWebpHeader([BII)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 137
    invoke-static {p0, p1}, Lcom/facebook/common/webp/WebpSupportStatus;->isAnimatedWebpHeader([BI)Z

    move-result v1

    if-nez v1, :cond_0

    .line 140
    sget-boolean v0, Lcom/facebook/common/webp/WebpSupportStatus;->sIsExtendedWebpSupported:Z

    goto :goto_0
.end method

.method public static loadWebpBitmapFactoryIfExists()Lcom/facebook/common/webp/WebpBitmapFactory;
    .locals 3

    .prologue
    .line 32
    sget-boolean v2, Lcom/facebook/common/webp/WebpSupportStatus;->sWebpLibraryChecked:Z

    if-eqz v2, :cond_0

    .line 33
    sget-object v1, Lcom/facebook/common/webp/WebpSupportStatus;->sWebpBitmapFactory:Lcom/facebook/common/webp/WebpBitmapFactory;

    .line 44
    .local v1, "loadedWebpBitmapFactory":Lcom/facebook/common/webp/WebpBitmapFactory;
    :goto_0
    return-object v1

    .line 35
    .end local v1    # "loadedWebpBitmapFactory":Lcom/facebook/common/webp/WebpBitmapFactory;
    :cond_0
    const/4 v1, 0x0

    .line 37
    .restart local v1    # "loadedWebpBitmapFactory":Lcom/facebook/common/webp/WebpBitmapFactory;
    :try_start_0
    const-string v2, "com.facebook.webpsupport.WebpBitmapFactoryImpl"

    .line 38
    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    .line 39
    invoke-virtual {v2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lcom/facebook/common/webp/WebpBitmapFactory;

    move-object v1, v0
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 43
    :goto_1
    const/4 v2, 0x1

    sput-boolean v2, Lcom/facebook/common/webp/WebpSupportStatus;->sWebpLibraryChecked:Z

    goto :goto_0

    .line 40
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method private static matchBytePattern([BI[B)Z
    .locals 4
    .param p0, "byteArray"    # [B
    .param p1, "offset"    # I
    .param p2, "pattern"    # [B

    .prologue
    const/4 v1, 0x0

    .line 200
    if-eqz p2, :cond_0

    if-nez p0, :cond_1

    .line 213
    :cond_0
    :goto_0
    return v1

    .line 203
    :cond_1
    array-length v2, p2

    add-int/2addr v2, p1

    array-length v3, p0

    if-gt v2, v3, :cond_0

    .line 207
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v2, p2

    if-ge v0, v2, :cond_2

    .line 208
    add-int v2, v0, p1

    aget-byte v2, p0, v2

    aget-byte v3, p2, v0

    if-ne v2, v3, :cond_0

    .line 207
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 213
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method
