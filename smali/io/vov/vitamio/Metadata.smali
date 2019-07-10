.class public Lio/vov/vitamio/Metadata;
.super Ljava/lang/Object;
.source "Metadata.java"


# static fields
.field public static final ALBUM:I = 0x4

.field public static final ALBUM_ART:I = 0xe

.field public static final ANY:I = 0x0

.field public static final ARTIST:I = 0x5

.field public static final AUDIO_BIT_RATE:I = 0x12

.field public static final AUDIO_CODEC:I = 0x17

.field public static final AUDIO_SAMPLE_RATE:I = 0x14

.field public static final AUTHOR:I = 0x6

.field public static final BIT_RATE:I = 0x11

.field public static final CD_TRACK_MAX:I = 0xc

.field public static final CD_TRACK_NUM:I = 0xb

.field public static final COMMENT:I = 0x2

.field public static final COMPOSER:I = 0x7

.field public static final COPYRIGHT:I = 0x3

.field public static final DATE:I = 0x9

.field public static final DRM_CRIPPLED:I = 0x1c

.field public static final DURATION:I = 0xa

.field private static final FIRST_CUSTOM:I = 0x2000

.field public static final GENRE:I = 0x8

.field private static final LAST_SYSTEM:I = 0x20

.field public static final LENGTH:I = 0x10

.field public static final MIME_TYPE:I = 0x16

.field public static final NUM_TRACKS:I = 0x1b

.field public static final PAUSE_AVAILABLE:I = 0x1d

.field public static final RATING:I = 0xd

.field public static final SEEK_AVAILABLE:I = 0x20

.field public static final SEEK_BACKWARD_AVAILABLE:I = 0x1e

.field public static final SEEK_FORWARD_AVAILABLE:I = 0x1f

.field public static final TITLE:I = 0x1

.field public static final VIDEO_BIT_RATE:I = 0x13

.field public static final VIDEO_CODEC:I = 0x18

.field public static final VIDEO_FRAME:I = 0xf

.field public static final VIDEO_FRAME_RATE:I = 0x15

.field public static final VIDEO_HEIGHT:I = 0x19

.field public static final VIDEO_WIDTH:I = 0x1a


# instance fields
.field private mEncoding:Ljava/lang/String;

.field private mMeta:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<[B>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    .line 67
    const-string v0, "UTF-8"

    iput-object v0, p0, Lio/vov/vitamio/Metadata;->mEncoding:Ljava/lang/String;

    return-void
.end method

.method private checkMetadataId(I)Z
    .locals 1
    .param p1, "val"    # I

    .prologue
    .line 216
    if-lez p1, :cond_0

    const/16 v0, 0x20

    if-ge v0, p1, :cond_1

    const/16 v0, 0x2000

    if-ge p1, v0, :cond_1

    .line 217
    :cond_0
    const/4 v0, 0x0

    .line 219
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getBoolean(I)Z
    .locals 2
    .param p1, "key"    # I

    .prologue
    .line 189
    :try_start_0
    invoke-virtual {p0, p1}, Lio/vov/vitamio/Metadata;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 191
    :goto_0
    return v1

    .line 190
    :catch_0
    move-exception v0

    .line 191
    .local v0, "e":Ljava/lang/Exception;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getByteArray(I)[B
    .locals 1
    .param p1, "key"    # I

    .prologue
    .line 212
    iget-object v0, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    return-object v0
.end method

.method public getDouble(I)D
    .locals 4
    .param p1, "key"    # I

    .prologue
    .line 205
    :try_start_0
    invoke-virtual {p0, p1}, Lio/vov/vitamio/Metadata;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    .line 207
    :goto_0
    return-wide v2

    .line 206
    :catch_0
    move-exception v0

    .line 207
    .local v0, "e":Ljava/lang/Exception;
    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    goto :goto_0
.end method

.method public getInt(I)I
    .locals 2
    .param p1, "key"    # I

    .prologue
    .line 181
    :try_start_0
    invoke-virtual {p0, p1}, Lio/vov/vitamio/Metadata;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 183
    :goto_0
    return v1

    .line 182
    :catch_0
    move-exception v0

    .line 183
    .local v0, "e":Ljava/lang/Exception;
    const/4 v1, -0x1

    goto :goto_0
.end method

.method public getLong(I)J
    .locals 4
    .param p1, "key"    # I

    .prologue
    .line 197
    :try_start_0
    invoke-virtual {p0, p1}, Lio/vov/vitamio/Metadata;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    .line 199
    :goto_0
    return-wide v2

    .line 198
    :catch_0
    move-exception v0

    .line 199
    .local v0, "e":Ljava/lang/Exception;
    const-wide/16 v2, -0x1

    goto :goto_0
.end method

.method public getString(I)Ljava/lang/String;
    .locals 4
    .param p1, "key"    # I

    .prologue
    .line 168
    iget-object v2, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    invoke-virtual {v2, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    .line 169
    .local v1, "value":[B
    if-nez v1, :cond_0

    .line 170
    const/4 v2, 0x0

    .line 175
    :goto_0
    return-object v2

    .line 173
    :cond_0
    :try_start_0
    new-instance v2, Ljava/lang/String;

    iget-object v3, p0, Lio/vov/vitamio/Metadata;->mEncoding:Ljava/lang/String;

    invoke-direct {v2, v1, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 174
    :catch_0
    move-exception v0

    .line 175
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v1}, Ljava/lang/String;-><init>([B)V

    goto :goto_0
.end method

.method public has(I)Z
    .locals 3
    .param p1, "metadataId"    # I

    .prologue
    .line 161
    invoke-direct {p0, p1}, Lio/vov/vitamio/Metadata;->checkMetadataId(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 162
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid key: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 164
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v0

    if-ltz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Ljava/util/Map;Ljava/lang/String;)Z
    .locals 8
    .param p2, "encoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<[B[B>;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p1, "meta":Ljava/util/Map;, "Ljava/util/Map<[B[B>;"
    const/4 v7, 0x1

    .line 70
    const/4 v1, 0x0

    .line 71
    .local v1, "key":Ljava/lang/String;
    const/4 v3, 0x0

    .line 72
    .local v3, "value":[B
    iput-object p2, p0, Lio/vov/vitamio/Metadata;->mEncoding:Ljava/lang/String;

    .line 73
    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_19

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    .line 75
    .local v2, "keyBytes":[B
    :try_start_0
    new-instance v5, Ljava/lang/String;

    iget-object v6, p0, Lio/vov/vitamio/Metadata;->mEncoding:Ljava/lang/String;

    invoke-direct {v5, v2, v6}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v5, v6}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 79
    :goto_1
    invoke-interface {p1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "value":[B
    check-cast v3, [B

    .line 80
    .restart local v3    # "value":[B
    const-string v5, "title"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 81
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    invoke-virtual {v5, v7, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_0

    .line 76
    :catch_0
    move-exception v0

    .line 77
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v5, Ljava/lang/String;

    invoke-direct {v5, v2}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v5, v6}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 82
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_1
    const-string v5, "comment"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 83
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/4 v6, 0x2

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_0

    .line 84
    :cond_2
    const-string v5, "copyright"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 85
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/4 v6, 0x3

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_0

    .line 86
    :cond_3
    const-string v5, "album"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 87
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/4 v6, 0x4

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_0

    .line 88
    :cond_4
    const-string v5, "artist"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 89
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/4 v6, 0x5

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_0

    .line 90
    :cond_5
    const-string v5, "author"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 91
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/4 v6, 0x6

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 92
    :cond_6
    const-string v5, "composer"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 93
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/4 v6, 0x7

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 94
    :cond_7
    const-string v5, "genre"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 95
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x8

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 96
    :cond_8
    const-string v5, "creation_time"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_9

    const-string v5, "date"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 97
    :cond_9
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x9

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 98
    :cond_a
    const-string v5, "duration"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_b

    .line 99
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0xa

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 100
    :cond_b
    const-string v5, "length"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_c

    .line 101
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x10

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 102
    :cond_c
    const-string v5, "bit_rate"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_d

    .line 103
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x11

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 104
    :cond_d
    const-string v5, "audio_bit_rate"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_e

    .line 105
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x12

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 106
    :cond_e
    const-string v5, "video_bit_rate"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_f

    .line 107
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x13

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 108
    :cond_f
    const-string v5, "audio_sample_rate"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_10

    .line 109
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x14

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 110
    :cond_10
    const-string v5, "video_frame_rate"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_11

    .line 111
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x15

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 112
    :cond_11
    const-string v5, "format"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_12

    .line 113
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x16

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 114
    :cond_12
    const-string v5, "audio_codec"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_13

    .line 115
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x17

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 116
    :cond_13
    const-string v5, "video_codec"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_14

    .line 117
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x18

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 118
    :cond_14
    const-string v5, "video_height"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_15

    .line 119
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x19

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 120
    :cond_15
    const-string v5, "video_width"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_16

    .line 121
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x1a

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 122
    :cond_16
    const-string v5, "num_tracks"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_17

    .line 123
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x1b

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 124
    :cond_17
    const-string v5, "cap_pause"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_18

    .line 125
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x1d

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 126
    :cond_18
    const-string v5, "cap_seek"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 127
    iget-object v5, p0, Lio/vov/vitamio/Metadata;->mMeta:Landroid/util/SparseArray;

    const/16 v6, 0x20

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_0

    .line 157
    .end local v2    # "keyBytes":[B
    :cond_19
    return v7
.end method
