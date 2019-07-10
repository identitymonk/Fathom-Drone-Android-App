.class public final Lio/vov/vitamio/provider/MediaStore$Video$Media;
.super Ljava/lang/Object;
.source "MediaStore.java"

# interfaces
.implements Lio/vov/vitamio/provider/MediaStore$Video$VideoColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/vov/vitamio/provider/MediaStore$Video;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Media"
.end annotation


# static fields
.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/video"

.field public static final CONTENT_URI:Landroid/net/Uri;

.field protected static final SQL_FIELDS:Ljava/lang/String; = "_id INTEGER PRIMARY KEY,_data TEXT NOT NULL,_directory TEXT NOT NULL,_directory_name TEXT NOT NULL,_size INTEGER,_display_name TEXT,title TEXT,title_key TEXT,date_added INTEGER,date_modified INTEGER,mime_type TEXT,available_size INTEGER default 0,play_status INTEGER ,duration INTEGER,artist TEXT,album TEXT,width INTEGER,height INTEGER,description TEXT,language TEXT,latitude DOUBLE,longitude DOUBLE,datetaken INTEGER,bookmark INTEGER,mini_thumb_magic INTEGER,hidden INTEGER default 0,sub_track TEXT,audio_track INTEGER"

.field protected static final SQL_TRIGGER_VIDEO_CLEANUP:Ljava/lang/String; = "CREATE TRIGGER IF NOT EXISTS video_cleanup AFTER DELETE ON videos BEGIN SELECT _DELETE_FILE(old._data);SELECT _DELETE_FILE(old._data || \'.ssi\');END"

.field protected static final SQL_TRIGGER_VIDEO_UPDATE:Ljava/lang/String; = "CREATE TRIGGER IF NOT EXISTS video_update AFTER UPDATE ON videos WHEN new._data <> old._data BEGIN SELECT _DELETE_FILE(old._data || \'.ssi\');END"

.field protected static final TABLE_NAME:Ljava/lang/String; = "videos"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 117
    const-string v0, "content://me.abitno.vplayer.mediaprovider/videos/media"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lio/vov/vitamio/provider/MediaStore$Video$Media;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
