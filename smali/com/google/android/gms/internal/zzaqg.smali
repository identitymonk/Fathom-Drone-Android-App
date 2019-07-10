.class public final Lcom/google/android/gms/internal/zzaqg;
.super Lcom/google/android/gms/internal/zzaqr;


# static fields
.field private static final bpO:Ljava/io/Writer;

.field private static final bpP:Lcom/google/android/gms/internal/zzape;


# instance fields
.field private final bpN:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/internal/zzaoy;",
            ">;"
        }
    .end annotation
.end field

.field private bpQ:Ljava/lang/String;

.field private bpR:Lcom/google/android/gms/internal/zzaoy;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/google/android/gms/internal/zzaqg$1;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzaqg$1;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/zzaqg;->bpO:Ljava/io/Writer;

    new-instance v0, Lcom/google/android/gms/internal/zzape;

    const-string v1, "closed"

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzape;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzaqg;->bpP:Lcom/google/android/gms/internal/zzape;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/zzaqg;->bpO:Ljava/io/Writer;

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzaqr;-><init>(Ljava/io/Writer;)V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    sget-object v0, Lcom/google/android/gms/internal/zzapa;->bou:Lcom/google/android/gms/internal/zzapa;

    iput-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpR:Lcom/google/android/gms/internal/zzaoy;

    return-void
.end method

.method private bv()Lcom/google/android/gms/internal/zzaoy;
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzaoy;

    return-object v0
.end method

.method private zzd(Lcom/google/android/gms/internal/zzaoy;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpQ:Ljava/lang/String;

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzaoy;->aY()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzaqg;->bN()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzaqg;->bv()Lcom/google/android/gms/internal/zzaoy;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzapb;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqg;->bpQ:Ljava/lang/String;

    invoke-virtual {v0, v1, p1}, Lcom/google/android/gms/internal/zzapb;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzaoy;)V

    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpQ:Ljava/lang/String;

    :goto_0
    return-void

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    iput-object p1, p0, Lcom/google/android/gms/internal/zzaqg;->bpR:Lcom/google/android/gms/internal/zzaoy;

    goto :goto_0

    :cond_3
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzaqg;->bv()Lcom/google/android/gms/internal/zzaoy;

    move-result-object v0

    instance-of v1, v0, Lcom/google/android/gms/internal/zzaov;

    if-eqz v1, :cond_4

    check-cast v0, Lcom/google/android/gms/internal/zzaov;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzaov;->zzc(Lcom/google/android/gms/internal/zzaoy;)V

    goto :goto_0

    :cond_4
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method


# virtual methods
.method public bA()Lcom/google/android/gms/internal/zzaqr;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    sget-object v0, Lcom/google/android/gms/internal/zzapa;->bou:Lcom/google/android/gms/internal/zzapa;

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzaqg;->zzd(Lcom/google/android/gms/internal/zzaoy;)V

    return-object p0
.end method

.method public bu()Lcom/google/android/gms/internal/zzaoy;
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x22

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "Expected one JSON element but was "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpR:Lcom/google/android/gms/internal/zzaoy;

    return-object v0
.end method

.method public bw()Lcom/google/android/gms/internal/zzaqr;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzaov;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzaov;-><init>()V

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzaqg;->zzd(Lcom/google/android/gms/internal/zzaoy;)V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-object p0
.end method

.method public bx()Lcom/google/android/gms/internal/zzaqr;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpQ:Ljava/lang/String;

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    :cond_1
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzaqg;->bv()Lcom/google/android/gms/internal/zzaoy;

    move-result-object v0

    instance-of v0, v0, Lcom/google/android/gms/internal/zzaov;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    return-object p0

    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method public by()Lcom/google/android/gms/internal/zzaqr;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzapb;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzapb;-><init>()V

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzaqg;->zzd(Lcom/google/android/gms/internal/zzaoy;)V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-object p0
.end method

.method public bz()Lcom/google/android/gms/internal/zzaqr;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpQ:Ljava/lang/String;

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    :cond_1
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzaqg;->bv()Lcom/google/android/gms/internal/zzaoy;

    move-result-object v0

    instance-of v0, v0, Lcom/google/android/gms/internal/zzapb;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    return-object p0

    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method public close()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/io/IOException;

    const-string v1, "Incomplete document"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    sget-object v1, Lcom/google/android/gms/internal/zzaqg;->bpP:Lcom/google/android/gms/internal/zzape;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public flush()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    return-void
.end method

.method public zza(Ljava/lang/Number;)Lcom/google/android/gms/internal/zzaqr;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzaqg;->bA()Lcom/google/android/gms/internal/zzaqr;

    move-result-object p0

    :goto_0
    return-object p0

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzaqg;->isLenient()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {p1}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v2

    if-nez v2, :cond_1

    invoke-static {v0, v1}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x21

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "JSON forbids NaN and infinities: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    new-instance v0, Lcom/google/android/gms/internal/zzape;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/zzape;-><init>(Ljava/lang/Number;)V

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzaqg;->zzd(Lcom/google/android/gms/internal/zzaoy;)V

    goto :goto_0
.end method

.method public zzcs(J)Lcom/google/android/gms/internal/zzaqr;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzape;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzape;-><init>(Ljava/lang/Number;)V

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzaqg;->zzd(Lcom/google/android/gms/internal/zzaoy;)V

    return-object p0
.end method

.method public zzdh(Z)Lcom/google/android/gms/internal/zzaqr;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzape;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzape;-><init>(Ljava/lang/Boolean;)V

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzaqg;->zzd(Lcom/google/android/gms/internal/zzaoy;)V

    return-object p0
.end method

.method public zzus(Ljava/lang/String;)Lcom/google/android/gms/internal/zzaqr;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpN:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqg;->bpQ:Ljava/lang/String;

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    :cond_1
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzaqg;->bv()Lcom/google/android/gms/internal/zzaoy;

    move-result-object v0

    instance-of v0, v0, Lcom/google/android/gms/internal/zzapb;

    if-eqz v0, :cond_2

    iput-object p1, p0, Lcom/google/android/gms/internal/zzaqg;->bpQ:Ljava/lang/String;

    return-object p0

    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method public zzut(Ljava/lang/String;)Lcom/google/android/gms/internal/zzaqr;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzaqg;->bA()Lcom/google/android/gms/internal/zzaqr;

    move-result-object p0

    :goto_0
    return-object p0

    :cond_0
    new-instance v0, Lcom/google/android/gms/internal/zzape;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/zzape;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzaqg;->zzd(Lcom/google/android/gms/internal/zzaoy;)V

    goto :goto_0
.end method
