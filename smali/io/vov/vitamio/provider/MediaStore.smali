.class public final Lio/vov/vitamio/provider/MediaStore;
.super Ljava/lang/Object;
.source "MediaStore.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/vov/vitamio/provider/MediaStore$InternalThumbnails;,
        Lio/vov/vitamio/provider/MediaStore$Video;,
        Lio/vov/vitamio/provider/MediaStore$Audio;,
        Lio/vov/vitamio/provider/MediaStore$MediaColumns;
    }
.end annotation


# static fields
.field public static final AUTHORITY:Ljava/lang/String; = "me.abitno.vplayer.mediaprovider"

.field private static final BASE_SQL_FIELDS:Ljava/lang/String; = "_id INTEGER PRIMARY KEY,_data TEXT NOT NULL,_directory TEXT NOT NULL,_directory_name TEXT NOT NULL,_size INTEGER,_display_name TEXT,title TEXT,title_key TEXT,date_added INTEGER,date_modified INTEGER,mime_type TEXT,available_size INTEGER default 0,play_status INTEGER ,"

.field public static final CONTENT_AUTHORITY_SLASH:Ljava/lang/String; = "content://me.abitno.vplayer.mediaprovider/"

.field public static final CONTENT_URI:Landroid/net/Uri;

.field public static final MEDIA_SCANNER_VOLUME:Ljava/lang/String; = "volume"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-string v0, "content://me.abitno.vplayer.mediaprovider/"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lio/vov/vitamio/provider/MediaStore;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 196
    return-void
.end method

.method public static getMediaScannerUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 56
    const-string v0, "content://me.abitno.vplayer.mediaprovider/media_scanner"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getVolumeUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 60
    const-string v0, "content://me.abitno.vplayer.mediaprovider/volume"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method
