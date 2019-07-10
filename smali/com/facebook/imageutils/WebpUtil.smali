.class public Lcom/facebook/imageutils/WebpUtil;
.super Ljava/lang/Object;
.source "WebpUtil.java"


# static fields
.field private static final VP8L_HEADER:Ljava/lang/String; = "VP8L"

.field private static final VP8X_HEADER:Ljava/lang/String; = "VP8X"

.field private static final VP8_HEADER:Ljava/lang/String; = "VP8 "


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    return-void
.end method

.method private static compare([BLjava/lang/String;)Z
    .locals 4
    .param p0, "what"    # [B
    .param p1, "with"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 160
    array-length v2, p0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-eq v2, v3, :cond_1

    .line 168
    :cond_0
    :goto_0
    return v1

    .line 163
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-ge v0, v2, :cond_2

    .line 164
    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    aget-byte v3, p0, v0

    if-ne v2, v3, :cond_0

    .line 163
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 168
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static get2BytesAsInt(Ljava/io/InputStream;)I
    .locals 4
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 191
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v2

    int-to-byte v0, v2

    .line 192
    .local v0, "byte1":B
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v2

    int-to-byte v1, v2

    .line 193
    .local v1, "byte2":B
    shl-int/lit8 v2, v1, 0x8

    const v3, 0xff00

    and-int/2addr v2, v3

    and-int/lit16 v3, v0, 0xff

    or-int/2addr v2, v3

    return v2
.end method

.method private static getByte(Ljava/io/InputStream;)B
    .locals 1
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 210
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v0

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    return v0
.end method

.method private static getHeader([B)Ljava/lang/String;
    .locals 3
    .param p0, "header"    # [B

    .prologue
    .line 172
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 173
    .local v1, "str":Ljava/lang/StringBuilder;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, p0

    if-ge v0, v2, :cond_0

    .line 174
    aget-byte v2, p0, v0

    int-to-char v2, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 173
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 176
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private static getInt(Ljava/io/InputStream;)I
    .locals 7
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 180
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v4

    int-to-byte v0, v4

    .line 181
    .local v0, "byte1":B
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v4

    int-to-byte v1, v4

    .line 182
    .local v1, "byte2":B
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v4

    int-to-byte v2, v4

    .line 183
    .local v2, "byte3":B
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v4

    int-to-byte v3, v4

    .line 184
    .local v3, "byte4":B
    shl-int/lit8 v4, v3, 0x18

    const/high16 v5, -0x1000000

    and-int/2addr v4, v5

    shl-int/lit8 v5, v2, 0x10

    const/high16 v6, 0xff0000

    and-int/2addr v5, v6

    or-int/2addr v4, v5

    shl-int/lit8 v5, v1, 0x8

    const v6, 0xff00

    and-int/2addr v5, v6

    or-int/2addr v4, v5

    and-int/lit16 v5, v0, 0xff

    or-int/2addr v4, v5

    return v4
.end method

.method private static getShort(Ljava/io/InputStream;)S
    .locals 1
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 206
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v0

    and-int/lit16 v0, v0, 0xff

    int-to-short v0, v0

    return v0
.end method

.method public static getSize(Ljava/io/InputStream;)Landroid/util/Pair;
    .locals 6
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 51
    const/4 v3, 0x0

    .line 52
    .local v3, "result":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    const/4 v5, 0x4

    new-array v2, v5, [B

    .line 54
    .local v2, "headerBuffer":[B
    :try_start_0
    invoke-virtual {p0, v2}, Ljava/io/InputStream;->read([B)I

    .line 56
    const-string v5, "RIFF"

    invoke-static {v2, v5}, Lcom/facebook/imageutils/WebpUtil;->compare([BLjava/lang/String;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_6
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v5

    if-nez v5, :cond_1

    .line 79
    if-eqz p0, :cond_0

    .line 81
    :try_start_1
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 88
    :cond_0
    :goto_0
    return-object v4

    .line 82
    :catch_0
    move-exception v0

    .line 83
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 60
    .end local v0    # "e":Ljava/io/IOException;
    :cond_1
    :try_start_2
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getInt(Ljava/io/InputStream;)I

    .line 62
    invoke-virtual {p0, v2}, Ljava/io/InputStream;->read([B)I

    .line 63
    const-string v5, "WEBP"

    invoke-static {v2, v5}, Lcom/facebook/imageutils/WebpUtil;->compare([BLjava/lang/String;)Z
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_6
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v5

    if-nez v5, :cond_2

    .line 79
    if-eqz p0, :cond_0

    .line 81
    :try_start_3
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 82
    :catch_1
    move-exception v0

    .line 83
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 67
    .end local v0    # "e":Ljava/io/IOException;
    :cond_2
    :try_start_4
    invoke-virtual {p0, v2}, Ljava/io/InputStream;->read([B)I

    .line 68
    invoke-static {v2}, Lcom/facebook/imageutils/WebpUtil;->getHeader([B)Ljava/lang/String;

    move-result-object v1

    .line 69
    .local v1, "headerAsString":Ljava/lang/String;
    const-string v5, "VP8 "

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 70
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getVP8Dimension(Ljava/io/InputStream;)Landroid/util/Pair;
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_6
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v4

    .line 79
    if-eqz p0, :cond_0

    .line 81
    :try_start_5
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2

    goto :goto_0

    .line 82
    :catch_2
    move-exception v0

    .line 83
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 71
    .end local v0    # "e":Ljava/io/IOException;
    :cond_3
    :try_start_6
    const-string v5, "VP8L"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 72
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getVP8LDimension(Ljava/io/InputStream;)Landroid/util/Pair;
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-object v4

    .line 79
    if-eqz p0, :cond_0

    .line 81
    :try_start_7
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_3

    goto :goto_0

    .line 82
    :catch_3
    move-exception v0

    .line 83
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 73
    .end local v0    # "e":Ljava/io/IOException;
    :cond_4
    :try_start_8
    const-string v5, "VP8X"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 74
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getVP8XDimension(Ljava/io/InputStream;)Landroid/util/Pair;
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_6
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    move-result-object v4

    .line 79
    if-eqz p0, :cond_0

    .line 81
    :try_start_9
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_4

    goto :goto_0

    .line 82
    :catch_4
    move-exception v0

    .line 83
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 79
    .end local v0    # "e":Ljava/io/IOException;
    :cond_5
    if-eqz p0, :cond_0

    .line 81
    :try_start_a
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_5

    goto :goto_0

    .line 82
    :catch_5
    move-exception v0

    .line 83
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 76
    .end local v0    # "e":Ljava/io/IOException;
    .end local v1    # "headerAsString":Ljava/lang/String;
    :catch_6
    move-exception v0

    .line 77
    .restart local v0    # "e":Ljava/io/IOException;
    :try_start_b
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    .line 79
    if-eqz p0, :cond_0

    .line 81
    :try_start_c
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_7

    goto :goto_0

    .line 82
    :catch_7
    move-exception v0

    .line 83
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto/16 :goto_0

    .line 79
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    if-eqz p0, :cond_6

    .line 81
    :try_start_d
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_8

    .line 84
    :cond_6
    :goto_1
    throw v4

    .line 82
    :catch_8
    move-exception v0

    .line 83
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method

.method private static getVP8Dimension(Ljava/io/InputStream;)Landroid/util/Pair;
    .locals 6
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 100
    const-wide/16 v4, 0x7

    invoke-virtual {p0, v4, v5}, Ljava/io/InputStream;->skip(J)J

    .line 102
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getShort(Ljava/io/InputStream;)S

    move-result v0

    .line 103
    .local v0, "sign1":S
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getShort(Ljava/io/InputStream;)S

    move-result v1

    .line 104
    .local v1, "sign2":S
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getShort(Ljava/io/InputStream;)S

    move-result v2

    .line 105
    .local v2, "sign3":S
    const/16 v3, 0x9d

    if-ne v0, v3, :cond_0

    const/4 v3, 0x1

    if-ne v1, v3, :cond_0

    const/16 v3, 0x2a

    if-eq v2, v3, :cond_1

    .line 107
    :cond_0
    const/4 v3, 0x0

    .line 110
    :goto_0
    return-object v3

    :cond_1
    new-instance v3, Landroid/util/Pair;

    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->get2BytesAsInt(Ljava/io/InputStream;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->get2BytesAsInt(Ljava/io/InputStream;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private static getVP8LDimension(Ljava/io/InputStream;)Landroid/util/Pair;
    .locals 10
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 122
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getInt(Ljava/io/InputStream;)I

    .line 124
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getByte(Ljava/io/InputStream;)B

    move-result v0

    .line 125
    .local v0, "check":B
    const/16 v7, 0x2f

    if-eq v0, v7, :cond_0

    .line 126
    const/4 v7, 0x0

    .line 135
    :goto_0
    return-object v7

    .line 128
    :cond_0
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v7

    int-to-byte v7, v7

    and-int/lit16 v1, v7, 0xff

    .line 129
    .local v1, "data1":I
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v7

    int-to-byte v7, v7

    and-int/lit16 v2, v7, 0xff

    .line 130
    .local v2, "data2":I
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v7

    int-to-byte v7, v7

    and-int/lit16 v3, v7, 0xff

    .line 131
    .local v3, "data3":I
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v7

    int-to-byte v7, v7

    and-int/lit16 v4, v7, 0xff

    .line 133
    .local v4, "data4":I
    and-int/lit8 v7, v2, 0x3f

    shl-int/lit8 v7, v7, 0x8

    or-int/2addr v7, v1

    add-int/lit8 v6, v7, 0x1

    .line 134
    .local v6, "width":I
    and-int/lit8 v7, v4, 0xf

    shl-int/lit8 v7, v7, 0xa

    shl-int/lit8 v8, v3, 0x2

    or-int/2addr v7, v8

    and-int/lit16 v8, v2, 0xc0

    shr-int/lit8 v8, v8, 0x6

    or-int/2addr v7, v8

    add-int/lit8 v5, v7, 0x1

    .line 135
    .local v5, "height":I
    new-instance v7, Landroid/util/Pair;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-direct {v7, v8, v9}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private static getVP8XDimension(Ljava/io/InputStream;)Landroid/util/Pair;
    .locals 3
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 147
    const-wide/16 v0, 0x8

    invoke-virtual {p0, v0, v1}, Ljava/io/InputStream;->skip(J)J

    .line 149
    new-instance v0, Landroid/util/Pair;

    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->read3Bytes(Ljava/io/InputStream;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->read3Bytes(Ljava/io/InputStream;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0
.end method

.method private static isBitOne(BI)Z
    .locals 2
    .param p0, "input"    # B
    .param p1, "bitIndex"    # I

    .prologue
    const/4 v0, 0x1

    .line 214
    rem-int/lit8 v1, p1, 0x8

    shr-int v1, p0, v1

    and-int/lit8 v1, v1, 0x1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static read3Bytes(Ljava/io/InputStream;)I
    .locals 6
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 197
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getByte(Ljava/io/InputStream;)B

    move-result v0

    .line 198
    .local v0, "byte1":B
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getByte(Ljava/io/InputStream;)B

    move-result v1

    .line 199
    .local v1, "byte2":B
    invoke-static {p0}, Lcom/facebook/imageutils/WebpUtil;->getByte(Ljava/io/InputStream;)B

    move-result v2

    .line 200
    .local v2, "byte3":B
    shl-int/lit8 v3, v2, 0x10

    const/high16 v4, 0xff0000

    and-int/2addr v3, v4

    shl-int/lit8 v4, v1, 0x8

    const v5, 0xff00

    and-int/2addr v4, v5

    or-int/2addr v3, v4

    and-int/lit16 v4, v0, 0xff

    or-int/2addr v3, v4

    return v3
.end method
