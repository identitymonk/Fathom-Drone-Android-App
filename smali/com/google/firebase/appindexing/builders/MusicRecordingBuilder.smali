.class public final Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;
.super Lcom/google/firebase/appindexing/builders/IndexableBuilder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/firebase/appindexing/builders/IndexableBuilder",
        "<",
        "Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 1

    const-string v0, "MusicRecording"

    invoke-direct {p0, v0}, Lcom/google/firebase/appindexing/builders/IndexableBuilder;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public setByArtist(Lcom/google/firebase/appindexing/builders/MusicGroupBuilder;)Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;
    .locals 3
    .param p1    # Lcom/google/firebase/appindexing/builders/MusicGroupBuilder;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    const-string v0, "byArtist"

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/google/firebase/appindexing/builders/MusicGroupBuilder;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;->put(Ljava/lang/String;[Lcom/google/firebase/appindexing/builders/IndexableBuilder;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;

    return-object v0
.end method

.method public setDuration(I)Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;
    .locals 6

    const-string v0, "duration"

    const/4 v1, 0x1

    new-array v1, v1, [J

    const/4 v2, 0x0

    int-to-long v4, p1

    aput-wide v4, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;->put(Ljava/lang/String;[J)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;

    return-object v0
.end method

.method public setInAlbum(Lcom/google/firebase/appindexing/builders/MusicAlbumBuilder;)Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;
    .locals 3
    .param p1    # Lcom/google/firebase/appindexing/builders/MusicAlbumBuilder;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    const-string v0, "inAlbum"

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/google/firebase/appindexing/builders/MusicAlbumBuilder;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;->put(Ljava/lang/String;[Lcom/google/firebase/appindexing/builders/IndexableBuilder;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;

    return-object v0
.end method

.method public varargs setInPlaylist([Lcom/google/firebase/appindexing/builders/MusicPlaylistBuilder;)Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;
    .locals 1
    .param p1    # [Lcom/google/firebase/appindexing/builders/MusicPlaylistBuilder;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    const-string v0, "inPlaylist"

    invoke-virtual {p0, v0, p1}, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;->put(Ljava/lang/String;[Lcom/google/firebase/appindexing/builders/IndexableBuilder;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;

    return-object v0
.end method
