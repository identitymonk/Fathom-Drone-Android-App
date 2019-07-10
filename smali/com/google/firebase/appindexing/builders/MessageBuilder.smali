.class public final Lcom/google/firebase/appindexing/builders/MessageBuilder;
.super Lcom/google/firebase/appindexing/builders/IndexableBuilder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/firebase/appindexing/builders/IndexableBuilder",
        "<",
        "Lcom/google/firebase/appindexing/builders/MessageBuilder;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 1

    const-string v0, "Message"

    invoke-direct {p0, v0}, Lcom/google/firebase/appindexing/builders/IndexableBuilder;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method constructor <init>(Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/google/firebase/appindexing/builders/IndexableBuilder;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public setDateRead(Ljava/util/Date;)Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 6
    .param p1    # Ljava/util/Date;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzaa;->zzy(Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "dateRead"

    const/4 v1, 0x1

    new-array v1, v1, [J

    const/4 v2, 0x0

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    aput-wide v4, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/google/firebase/appindexing/builders/MessageBuilder;->put(Ljava/lang/String;[J)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    return-object v0
.end method

.method public setDateReceived(Ljava/util/Date;)Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 6
    .param p1    # Ljava/util/Date;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzaa;->zzy(Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "dateReceived"

    const/4 v1, 0x1

    new-array v1, v1, [J

    const/4 v2, 0x0

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    aput-wide v4, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/google/firebase/appindexing/builders/MessageBuilder;->put(Ljava/lang/String;[J)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    return-object v0
.end method

.method public setDateSent(Ljava/util/Date;)Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 6
    .param p1    # Ljava/util/Date;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzaa;->zzy(Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "dateSent"

    const/4 v1, 0x1

    new-array v1, v1, [J

    const/4 v2, 0x0

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    aput-wide v4, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/google/firebase/appindexing/builders/MessageBuilder;->put(Ljava/lang/String;[J)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    return-object v0
.end method

.method public varargs setIsPartOf([Lcom/google/firebase/appindexing/builders/ConversationBuilder;)Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 1
    .param p1    # [Lcom/google/firebase/appindexing/builders/ConversationBuilder;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    const-string v0, "isPartOf"

    invoke-virtual {p0, v0, p1}, Lcom/google/firebase/appindexing/builders/MessageBuilder;->put(Ljava/lang/String;[Lcom/google/firebase/appindexing/builders/IndexableBuilder;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    return-object v0
.end method

.method public varargs setMessageAttachment([Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;)Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 1
    .param p1    # [Lcom/google/firebase/appindexing/builders/DigitalDocumentBuilder;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    const-string v0, "messageAttachment"

    invoke-virtual {p0, v0, p1}, Lcom/google/firebase/appindexing/builders/MessageBuilder;->put(Ljava/lang/String;[Lcom/google/firebase/appindexing/builders/IndexableBuilder;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    return-object v0
.end method

.method public varargs setRecipient([Lcom/google/firebase/appindexing/builders/PersonBuilder;)Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 1
    .param p1    # [Lcom/google/firebase/appindexing/builders/PersonBuilder;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    const-string v0, "recipient"

    invoke-virtual {p0, v0, p1}, Lcom/google/firebase/appindexing/builders/MessageBuilder;->put(Ljava/lang/String;[Lcom/google/firebase/appindexing/builders/IndexableBuilder;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    return-object v0
.end method

.method public setSender(Lcom/google/firebase/appindexing/builders/PersonBuilder;)Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 3
    .param p1    # Lcom/google/firebase/appindexing/builders/PersonBuilder;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    const-string v0, "sender"

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/google/firebase/appindexing/builders/PersonBuilder;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/google/firebase/appindexing/builders/MessageBuilder;->put(Ljava/lang/String;[Lcom/google/firebase/appindexing/builders/IndexableBuilder;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    return-object v0
.end method

.method public setText(Ljava/lang/String;)Lcom/google/firebase/appindexing/builders/MessageBuilder;
    .locals 3
    .param p1    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    const-string v0, "text"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/google/firebase/appindexing/builders/MessageBuilder;->put(Ljava/lang/String;[Ljava/lang/String;)Lcom/google/firebase/appindexing/builders/IndexableBuilder;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/builders/MessageBuilder;

    return-object v0
.end method
