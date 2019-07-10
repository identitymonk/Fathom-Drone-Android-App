.class public Lio/vov/vitamio/provider/MediaStore$Video$Thumbnails;
.super Ljava/lang/Object;
.source "MediaStore.java"

# interfaces
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/vov/vitamio/provider/MediaStore$Video;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Thumbnails"
.end annotation


# static fields
.field public static final CONTENT_URI:Landroid/net/Uri;

.field public static final DATA:Ljava/lang/String; = "_data"

.field public static final HEIGHT:Ljava/lang/String; = "height"

.field public static final KIND:Ljava/lang/String; = "kind"

.field public static final MICRO_KIND:I = 0x3

.field public static final MINI_KIND:I = 0x1

.field protected static final SQL_FIELDS:Ljava/lang/String; = "_id INTEGER PRIMARY KEY,_data TEXT,video_id INTEGER,kind INTEGER,width INTEGER,height INTEGER"

.field protected static final SQL_INDEX_VIDEO_ID:Ljava/lang/String; = "CREATE INDEX IF NOT EXISTS video_id_index on videothumbnails(video_id);"

.field protected static final SQL_TRIGGER_VIDEO_THUMBNAILS_CLEANUP:Ljava/lang/String; = "CREATE TRIGGER IF NOT EXISTS videothumbnails_cleanup DELETE ON videothumbnails BEGIN SELECT _DELETE_FILE(old._data);END"

.field protected static final TABLE_NAME:Ljava/lang/String; = "videothumbnails"

.field public static final THUMBNAILS_DIRECTORY:Ljava/lang/String; = "Android/data/me.abitno.vplayer.t/thumbnails"

.field public static final VIDEO_ID:Ljava/lang/String; = "video_id"

.field public static final WIDTH:Ljava/lang/String; = "width"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 153
    const-string v0, "content://me.abitno.vplayer.mediaprovider/videos/thumbnails"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lio/vov/vitamio/provider/MediaStore$Video$Thumbnails;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static cancelThumbnailRequest(Landroid/content/ContentResolver;J)V
    .locals 7
    .param p0, "cr"    # Landroid/content/ContentResolver;
    .param p1, "origId"    # J

    .prologue
    .line 175
    sget-object v3, Lio/vov/vitamio/provider/MediaStore$Video$Thumbnails;->CONTENT_URI:Landroid/net/Uri;

    const-wide/16 v4, 0x0

    move-object v0, p0

    move-wide v1, p1

    invoke-static/range {v0 .. v5}, Lio/vov/vitamio/provider/MediaStore$InternalThumbnails;->cancelThumbnailRequest(Landroid/content/ContentResolver;JLandroid/net/Uri;J)V

    .line 176
    return-void
.end method

.method public static cancelThumbnailRequest(Landroid/content/ContentResolver;JJ)V
    .locals 7
    .param p0, "cr"    # Landroid/content/ContentResolver;
    .param p1, "origId"    # J
    .param p3, "groupId"    # J

    .prologue
    .line 191
    sget-object v3, Lio/vov/vitamio/provider/MediaStore$Video$Thumbnails;->CONTENT_URI:Landroid/net/Uri;

    move-object v0, p0

    move-wide v1, p1

    move-wide v4, p3

    invoke-static/range {v0 .. v5}, Lio/vov/vitamio/provider/MediaStore$InternalThumbnails;->cancelThumbnailRequest(Landroid/content/ContentResolver;JLandroid/net/Uri;J)V

    .line 192
    return-void
.end method

.method public static getThumbnail(Landroid/content/Context;Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    .locals 10
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "cr"    # Landroid/content/ContentResolver;
    .param p2, "origId"    # J
    .param p4, "kind"    # I
    .param p5, "options"    # Landroid/graphics/BitmapFactory$Options;

    .prologue
    .line 179
    const-wide/16 v4, 0x0

    sget-object v8, Lio/vov/vitamio/provider/MediaStore$Video$Thumbnails;->CONTENT_URI:Landroid/net/Uri;

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move v6, p4

    move-object v7, p5

    invoke-static/range {v0 .. v8}, Lio/vov/vitamio/provider/MediaStore$InternalThumbnails;->getThumbnail(Landroid/content/Context;Landroid/content/ContentResolver;JJILandroid/graphics/BitmapFactory$Options;Landroid/net/Uri;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public static getThumbnail(Landroid/content/Context;Landroid/content/ContentResolver;JJILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    .locals 10
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "cr"    # Landroid/content/ContentResolver;
    .param p2, "origId"    # J
    .param p4, "groupId"    # J
    .param p6, "kind"    # I
    .param p7, "options"    # Landroid/graphics/BitmapFactory$Options;

    .prologue
    .line 183
    sget-object v8, Lio/vov/vitamio/provider/MediaStore$Video$Thumbnails;->CONTENT_URI:Landroid/net/Uri;

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move-wide v4, p4

    move/from16 v6, p6

    move-object/from16 v7, p7

    invoke-static/range {v0 .. v8}, Lio/vov/vitamio/provider/MediaStore$InternalThumbnails;->getThumbnail(Landroid/content/Context;Landroid/content/ContentResolver;JJILandroid/graphics/BitmapFactory$Options;Landroid/net/Uri;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public static getThumbnailPath(Landroid/content/Context;Landroid/content/ContentResolver;J)Ljava/lang/String;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "cr"    # Landroid/content/ContentResolver;
    .param p2, "origId"    # J

    .prologue
    .line 187
    sget-object v0, Lio/vov/vitamio/provider/MediaStore$Video$Thumbnails;->CONTENT_URI:Landroid/net/Uri;

    invoke-static {p0, p1, p2, p3, v0}, Lio/vov/vitamio/provider/MediaStore$InternalThumbnails;->getThumbnailPath(Landroid/content/Context;Landroid/content/ContentResolver;JLandroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
