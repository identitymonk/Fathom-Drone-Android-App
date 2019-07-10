.class public Lio/vov/vitamio/MediaFile;
.super Ljava/lang/Object;
.source "MediaFile.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/vov/vitamio/MediaFile$MediaFileType;
    }
.end annotation


# static fields
.field public static final FILE_TYPE_3GPP:I = 0x2bf

.field public static final FILE_TYPE_3GPP2:I = 0x2c0

.field public static final FILE_TYPE_AAC:I = 0x8

.field public static final FILE_TYPE_AMR:I = 0x4

.field public static final FILE_TYPE_APE:I = 0xd

.field public static final FILE_TYPE_ASF:I = 0x2c2

.field public static final FILE_TYPE_AVS:I = 0x2cd

.field public static final FILE_TYPE_AWB:I = 0x5

.field public static final FILE_TYPE_DIVX:I = 0x2c9

.field public static final FILE_TYPE_DVD:I = 0x2c8

.field public static final FILE_TYPE_FLAC:I = 0xe

.field public static final FILE_TYPE_FLV:I = 0x2c5

.field public static final FILE_TYPE_IMY:I = 0xc

.field public static final FILE_TYPE_M4A:I = 0x2

.field public static final FILE_TYPE_M4V:I = 0x2be

.field public static final FILE_TYPE_MID:I = 0xa

.field public static final FILE_TYPE_MKA:I = 0x9

.field public static final FILE_TYPE_MKV:I = 0x2c3

.field public static final FILE_TYPE_MOV:I = 0x2c6

.field public static final FILE_TYPE_MP2TS:I = 0x2c4

.field public static final FILE_TYPE_MP3:I = 0x1

.field public static final FILE_TYPE_MP4:I = 0x2bd

.field public static final FILE_TYPE_OGG:I = 0x7

.field public static final FILE_TYPE_OGV:I = 0x2ca

.field public static final FILE_TYPE_RAW:I = 0x2cf

.field public static final FILE_TYPE_RM:I = 0x2c7

.field public static final FILE_TYPE_SMF:I = 0xb

.field public static final FILE_TYPE_SWF:I = 0x2ce

.field public static final FILE_TYPE_VIVO:I = 0x2cb

.field public static final FILE_TYPE_WAV:I = 0x3

.field public static final FILE_TYPE_WMA:I = 0x6

.field public static final FILE_TYPE_WMV:I = 0x2c1

.field public static final FILE_TYPE_WTV:I = 0x2cc

.field private static final FIRST_AUDIO_FILE_TYPE:I = 0x1

.field private static final FIRST_VIDEO_FILE_TYPE:I = 0x2bd

.field private static final LAST_AUDIO_FILE_TYPE:I = 0xe

.field private static final LAST_VIDEO_FILE_TYPE:I = 0x2cf

.field protected static final sFileExtensions:Ljava/lang/String;

.field private static sFileTypeMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lio/vov/vitamio/MediaFile$MediaFileType;",
            ">;"
        }
    .end annotation
.end field

.field private static sMimeTypeMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/16 v8, 0x2c0

    const/16 v7, 0x2bf

    const/16 v6, 0x2c5

    const/16 v5, 0x2c4

    const/16 v4, 0x2bd

    .line 76
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    sput-object v2, Lio/vov/vitamio/MediaFile;->sFileTypeMap:Ljava/util/HashMap;

    .line 77
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    sput-object v2, Lio/vov/vitamio/MediaFile;->sMimeTypeMap:Ljava/util/HashMap;

    .line 106
    const-string v2, "M1V"

    const-string v3, "video/mpeg"

    invoke-static {v2, v4, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 107
    const-string v2, "MP2"

    const-string v3, "video/mpeg"

    invoke-static {v2, v4, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 108
    const-string v2, "MPE"

    const-string v3, "video/mpeg"

    invoke-static {v2, v4, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 109
    const-string v2, "MPG"

    const-string v3, "video/mpeg"

    invoke-static {v2, v4, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 110
    const-string v2, "MPEG"

    const-string v3, "video/mpeg"

    invoke-static {v2, v4, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 111
    const-string v2, "MP4"

    const-string v3, "video/mp4"

    invoke-static {v2, v4, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 112
    const-string v2, "M4V"

    const/16 v3, 0x2be

    const-string v4, "video/mp4"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 113
    const-string v2, "3GP"

    const-string v3, "video/3gpp"

    invoke-static {v2, v7, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 114
    const-string v2, "3GPP"

    const-string v3, "video/3gpp"

    invoke-static {v2, v7, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 115
    const-string v2, "3G2"

    const-string v3, "video/3gpp2"

    invoke-static {v2, v8, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 116
    const-string v2, "3GPP2"

    const-string v3, "video/3gpp2"

    invoke-static {v2, v8, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 117
    const-string v2, "MKV"

    const/16 v3, 0x2c3

    const-string v4, "video/x-matroska"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 118
    const-string v2, "WEBM"

    const/16 v3, 0x2c3

    const-string v4, "video/x-matroska"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 119
    const-string v2, "MTS"

    const-string v3, "video/mp2ts"

    invoke-static {v2, v5, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 120
    const-string v2, "TS"

    const-string v3, "video/mp2ts"

    invoke-static {v2, v5, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 121
    const-string v2, "TP"

    const-string v3, "video/mp2ts"

    invoke-static {v2, v5, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 122
    const-string v2, "WMV"

    const/16 v3, 0x2c1

    const-string v4, "video/x-ms-wmv"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 123
    const-string v2, "ASF"

    const/16 v3, 0x2c2

    const-string v4, "video/x-ms-asf"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 124
    const-string v2, "ASX"

    const/16 v3, 0x2c2

    const-string v4, "video/x-ms-asf"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 125
    const-string v2, "FLV"

    const-string v3, "video/x-flv"

    invoke-static {v2, v6, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 126
    const-string v2, "F4V"

    const-string v3, "video/x-flv"

    invoke-static {v2, v6, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 127
    const-string v2, "HLV"

    const-string v3, "video/x-flv"

    invoke-static {v2, v6, v3}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 128
    const-string v2, "MOV"

    const/16 v3, 0x2c6

    const-string v4, "video/quicktime"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 129
    const-string v2, "QT"

    const/16 v3, 0x2c6

    const-string v4, "video/quicktime"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 130
    const-string v2, "RM"

    const/16 v3, 0x2c7

    const-string v4, "video/x-pn-realvideo"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 131
    const-string v2, "RMVB"

    const/16 v3, 0x2c7

    const-string v4, "video/x-pn-realvideo"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 132
    const-string v2, "VOB"

    const/16 v3, 0x2c8

    const-string v4, "video/dvd"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 133
    const-string v2, "DAT"

    const/16 v3, 0x2c8

    const-string v4, "video/dvd"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 134
    const-string v2, "AVI"

    const/16 v3, 0x2c9

    const-string v4, "video/x-divx"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 135
    const-string v2, "OGV"

    const/16 v3, 0x2ca

    const-string v4, "video/ogg"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 136
    const-string v2, "OGG"

    const/16 v3, 0x2ca

    const-string v4, "video/ogg"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 137
    const-string v2, "VIV"

    const/16 v3, 0x2cb

    const-string v4, "video/vnd.vivo"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 138
    const-string v2, "VIVO"

    const/16 v3, 0x2cb

    const-string v4, "video/vnd.vivo"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 139
    const-string v2, "WTV"

    const/16 v3, 0x2cc

    const-string v4, "video/wtv"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 140
    const-string v2, "AVS"

    const/16 v3, 0x2cd

    const-string v4, "video/avs-video"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 141
    const-string v2, "SWF"

    const/16 v3, 0x2ce

    const-string v4, "video/x-shockwave-flash"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 142
    const-string v2, "YUV"

    const/16 v3, 0x2cf

    const-string v4, "video/x-raw-yuv"

    invoke-static {v2, v3, v4}, Lio/vov/vitamio/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    .line 144
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 145
    .local v0, "builder":Ljava/lang/StringBuilder;
    sget-object v2, Lio/vov/vitamio/MediaFile;->sFileTypeMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 147
    .local v1, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 148
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 149
    const/16 v2, 0x2c

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 150
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 152
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lio/vov/vitamio/MediaFile;->sFileExtensions:Ljava/lang/String;

    .line 153
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    return-void
.end method

.method static addFileType(Ljava/lang/String;ILjava/lang/String;)V
    .locals 2
    .param p0, "extension"    # Ljava/lang/String;
    .param p1, "fileType"    # I
    .param p2, "mimeType"    # Ljava/lang/String;

    .prologue
    .line 80
    sget-object v0, Lio/vov/vitamio/MediaFile;->sFileTypeMap:Ljava/util/HashMap;

    new-instance v1, Lio/vov/vitamio/MediaFile$MediaFileType;

    invoke-direct {v1, p1, p2}, Lio/vov/vitamio/MediaFile$MediaFileType;-><init>(ILjava/lang/String;)V

    invoke-virtual {v0, p0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 81
    sget-object v0, Lio/vov/vitamio/MediaFile;->sMimeTypeMap:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, p2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    return-void
.end method

.method public static getFileType(Ljava/lang/String;)Lio/vov/vitamio/MediaFile$MediaFileType;
    .locals 3
    .param p0, "path"    # Ljava/lang/String;

    .prologue
    .line 164
    const-string v1, "."

    invoke-virtual {p0, v1}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    .line 165
    .local v0, "lastDot":I
    if-gez v0, :cond_0

    .line 166
    const/4 v1, 0x0

    .line 167
    :goto_0
    return-object v1

    :cond_0
    sget-object v1, Lio/vov/vitamio/MediaFile;->sFileTypeMap:Ljava/util/HashMap;

    add-int/lit8 v2, v0, 0x1

    invoke-virtual {p0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/vov/vitamio/MediaFile$MediaFileType;

    goto :goto_0
.end method

.method public static getFileTypeForMimeType(Ljava/lang/String;)I
    .locals 2
    .param p0, "mimeType"    # Ljava/lang/String;

    .prologue
    .line 171
    sget-object v1, Lio/vov/vitamio/MediaFile;->sMimeTypeMap:Ljava/util/HashMap;

    invoke-virtual {v1, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 172
    .local v0, "value":Ljava/lang/Integer;
    if-nez v0, :cond_0

    const/4 v1, 0x0

    :goto_0
    return v1

    :cond_0
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_0
.end method

.method public static isAudioFileType(I)Z
    .locals 2
    .param p0, "fileType"    # I

    .prologue
    const/4 v0, 0x1

    .line 156
    if-lt p0, v0, :cond_0

    const/16 v1, 0xe

    if-gt p0, v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isVideoFileType(I)Z
    .locals 1
    .param p0, "fileType"    # I

    .prologue
    .line 160
    const/16 v0, 0x2bd

    if-lt p0, v0, :cond_0

    const/16 v0, 0x2cf

    if-gt p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
