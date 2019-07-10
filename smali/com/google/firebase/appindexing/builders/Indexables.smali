.class public final Lcom/google/firebase/appindexing/builders/Indexables;
.super Ljava/lang/Object;


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static conversationBuilder()Lcom/google/firebase/appindexing/builders/ConversationBuilder;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/builders/ConversationBuilder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/builders/ConversationBuilder;-><init>()V

    return-object v0
.end method

.method public static digitalDocumentBuilder()Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;-><init>()V

    return-object v0
.end method

.method public static digitalDocumentPermissionBuilder()Lcom/google/firebase/appindexing/builders/DigitalDocumentPermissionBuilder;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/builders/DigitalDocumentPermissionBuilder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/builders/DigitalDocumentPermissionBuilder;-><init>()V

    return-object v0
.end method

.method public static emailMessageBuilder()Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 2

    new-instance v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    const-string v1, "EmailMessage"

    invoke-direct {v0, v1}, Lcom/google/firebase/appindexing/builders/MessageBuilder;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static messageBuilder()Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/builders/MessageBuilder;-><init>()V

    return-object v0
.end method

.method public static musicAlbumBuilder()Lcom/google/firebase/appindexing/builders/MusicAlbumBuilder;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/builders/MusicAlbumBuilder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/builders/MusicAlbumBuilder;-><init>()V

    return-object v0
.end method

.method public static musicGroupBuilder()Lcom/google/firebase/appindexing/builders/MusicGroupBuilder;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/builders/MusicGroupBuilder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/builders/MusicGroupBuilder;-><init>()V

    return-object v0
.end method

.method public static musicPlaylistBuilder()Lcom/google/firebase/appindexing/builders/MusicPlaylistBuilder;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/builders/MusicPlaylistBuilder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/builders/MusicPlaylistBuilder;-><init>()V

    return-object v0
.end method

.method public static musicRecordingBuilder()Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/builders/MusicRecordingBuilder;-><init>()V

    return-object v0
.end method

.method public static newSimple(Ljava/lang/String;Ljava/lang/String;)Lcom/google/firebase/appindexing/Indexable;
    .locals 1
    .param p0    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    invoke-static {p0}, Lcom/google/android/gms/common/internal/zzaa;->zzy(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzaa;->zzy(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Lcom/google/firebase/appindexing/Indexable$Builder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/Indexable$Builder;-><init>()V

    invoke-virtual {v0, p1}, Lcom/google/firebase/appindexing/Indexable$Builder;->setUrl(Ljava/lang/String;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/Indexable$Builder;

    invoke-virtual {v0, p0}, Lcom/google/firebase/appindexing/Indexable$Builder;->setName(Ljava/lang/String;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/Indexable$Builder;

    invoke-virtual {v0}, Lcom/google/firebase/appindexing/Indexable$Builder;->build()Lcom/google/firebase/appindexing/Indexable;

    move-result-object v0

    return-object v0
.end method

.method public static noteDigitalDocumentBuilder()Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;
    .locals 2

    new-instance v0, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;

    const-string v1, "NoteDigitalDocument"

    invoke-direct {v0, v1}, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static personBuilder()Lcom/google/firebase/appindexing/builders/PersonBuilder;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/builders/PersonBuilder;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/builders/PersonBuilder;-><init>()V

    return-object v0
.end method

.method public static presentationDigitalDocumentBuilder()Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;
    .locals 2

    new-instance v0, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;

    const-string v1, "PresentationDigitalDocument"

    invoke-direct {v0, v1}, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static spreadsheetDigitalDocumentBuilder()Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;
    .locals 2

    new-instance v0, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;

    const-string v1, "SpreadsheetDigitalDocument"

    invoke-direct {v0, v1}, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static textDigitalDocumentBuilder()Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;
    .locals 2

    new-instance v0, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;

    const-string v1, "TextDigitalDocument"

    invoke-direct {v0, v1}, Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;-><init>(Ljava/lang/String;)V

    return-object v0
.end method
