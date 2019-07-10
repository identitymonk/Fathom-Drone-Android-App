.class public final Lcom/google/android/gms/internal/zzapb;
.super Lcom/google/android/gms/internal/zzaoy;


# instance fields
.field private final bov:Lcom/google/android/gms/internal/zzapw;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzapw",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/zzaoy;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzaoy;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/zzapw;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzapw;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzapb;->bov:Lcom/google/android/gms/internal/zzapw;

    return-void
.end method

.method private zzcl(Ljava/lang/Object;)Lcom/google/android/gms/internal/zzaoy;
    .locals 1

    if-nez p1, :cond_0

    sget-object v0, Lcom/google/android/gms/internal/zzapa;->bou:Lcom/google/android/gms/internal/zzapa;

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/google/android/gms/internal/zzape;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/zzape;-><init>(Ljava/lang/Object;)V

    goto :goto_0
.end method


# virtual methods
.method public entrySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/util/Map$Entry",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/zzaoy;",
            ">;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapb;->bov:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzapw;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    if-eq p1, p0, :cond_0

    instance-of v0, p1, Lcom/google/android/gms/internal/zzapb;

    if-eqz v0, :cond_1

    check-cast p1, Lcom/google/android/gms/internal/zzapb;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzapb;->bov:Lcom/google/android/gms/internal/zzapw;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzapb;->bov:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzapw;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public has(Ljava/lang/String;)Z
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapb;->bov:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzapw;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public hashCode()I
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapb;->bov:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzapw;->hashCode()I

    move-result v0

    return v0
.end method

.method public zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzaoy;)V
    .locals 1

    if-nez p2, :cond_0

    sget-object p2, Lcom/google/android/gms/internal/zzapa;->bou:Lcom/google/android/gms/internal/zzapa;

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzapb;->bov:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gms/internal/zzapw;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public zzb(Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 1

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzapb;->zzcl(Ljava/lang/Object;)Lcom/google/android/gms/internal/zzaoy;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/google/android/gms/internal/zzapb;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzaoy;)V

    return-void
.end method

.method public zzcb(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzapb;->zzcl(Ljava/lang/Object;)Lcom/google/android/gms/internal/zzaoy;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/google/android/gms/internal/zzapb;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzaoy;)V

    return-void
.end method

.method public zzuo(Ljava/lang/String;)Lcom/google/android/gms/internal/zzaoy;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapb;->bov:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzapw;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzaoy;

    return-object v0
.end method

.method public zzup(Ljava/lang/String;)Lcom/google/android/gms/internal/zzaov;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapb;->bov:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzapw;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzaov;

    return-object v0
.end method
