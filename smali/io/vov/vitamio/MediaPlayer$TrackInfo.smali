.class public Lio/vov/vitamio/MediaPlayer$TrackInfo;
.super Ljava/lang/Object;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/vov/vitamio/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TrackInfo"
.end annotation


# static fields
.field public static final MEDIA_TRACK_TYPE_AUDIO:I = 0x2

.field public static final MEDIA_TRACK_TYPE_SUBTITLE:I = 0x4

.field public static final MEDIA_TRACK_TYPE_TIMEDTEXT:I = 0x3

.field public static final MEDIA_TRACK_TYPE_UNKNOWN:I = 0x0

.field public static final MEDIA_TRACK_TYPE_VIDEO:I = 0x1


# instance fields
.field final mTrackInfoArray:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lio/vov/vitamio/MediaFormat;",
            ">;"
        }
    .end annotation
.end field

.field final mTrackType:I


# direct methods
.method constructor <init>(ILandroid/util/SparseArray;)V
    .locals 0
    .param p1, "trackType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/util/SparseArray",
            "<",
            "Lio/vov/vitamio/MediaFormat;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1581
    .local p2, "trackInfoArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lio/vov/vitamio/MediaFormat;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1582
    iput p1, p0, Lio/vov/vitamio/MediaPlayer$TrackInfo;->mTrackType:I

    .line 1583
    iput-object p2, p0, Lio/vov/vitamio/MediaPlayer$TrackInfo;->mTrackInfoArray:Landroid/util/SparseArray;

    .line 1584
    return-void
.end method


# virtual methods
.method public getTrackInfoArray()Landroid/util/SparseArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/SparseArray",
            "<",
            "Lio/vov/vitamio/MediaFormat;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1602
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer$TrackInfo;->mTrackInfoArray:Landroid/util/SparseArray;

    return-object v0
.end method

.method public getTrackType()I
    .locals 1

    .prologue
    .line 1593
    iget v0, p0, Lio/vov/vitamio/MediaPlayer$TrackInfo;->mTrackType:I

    return v0
.end method
