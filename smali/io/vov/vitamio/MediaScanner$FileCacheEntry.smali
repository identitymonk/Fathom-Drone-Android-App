.class Lio/vov/vitamio/MediaScanner$FileCacheEntry;
.super Ljava/lang/Object;
.source "MediaScanner.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/vov/vitamio/MediaScanner;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FileCacheEntry"
.end annotation


# instance fields
.field mLastModified:J

.field mLastModifiedChanged:Z

.field mPath:Ljava/lang/String;

.field mRowId:J

.field mSeenInFileSystem:Z

.field mTableUri:Landroid/net/Uri;


# direct methods
.method constructor <init>(Landroid/net/Uri;JLjava/lang/String;J)V
    .locals 1
    .param p1, "tableUri"    # Landroid/net/Uri;
    .param p2, "rowId"    # J
    .param p4, "path"    # Ljava/lang/String;
    .param p5, "lastModified"    # J

    .prologue
    const/4 v0, 0x0

    .line 218
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 219
    iput-object p1, p0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mTableUri:Landroid/net/Uri;

    .line 220
    iput-wide p2, p0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mRowId:J

    .line 221
    iput-object p4, p0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mPath:Ljava/lang/String;

    .line 222
    iput-wide p5, p0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mLastModified:J

    .line 223
    iput-boolean v0, p0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mSeenInFileSystem:Z

    .line 224
    iput-boolean v0, p0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mLastModifiedChanged:Z

    .line 225
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mPath:Ljava/lang/String;

    return-object v0
.end method
