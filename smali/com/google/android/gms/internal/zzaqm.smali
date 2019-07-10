.class final Lcom/google/android/gms/internal/zzaqm;
.super Lcom/google/android/gms/internal/zzapk;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/google/android/gms/internal/zzapk",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final bol:Lcom/google/android/gms/internal/zzapk;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzapk",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final bqh:Lcom/google/android/gms/internal/zzaos;

.field private final bqi:Ljava/lang/reflect/Type;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzapk;Ljava/lang/reflect/Type;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzaos;",
            "Lcom/google/android/gms/internal/zzapk",
            "<TT;>;",
            "Ljava/lang/reflect/Type;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzapk;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzaqm;->bqh:Lcom/google/android/gms/internal/zzaos;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzaqm;->bol:Lcom/google/android/gms/internal/zzapk;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzaqm;->bqi:Ljava/lang/reflect/Type;

    return-void
.end method

.method private zzb(Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/reflect/Type;
    .locals 1

    if-eqz p2, :cond_1

    const-class v0, Ljava/lang/Object;

    if-eq p1, v0, :cond_0

    instance-of v0, p1, Ljava/lang/reflect/TypeVariable;

    if-nez v0, :cond_0

    instance-of v0, p1, Ljava/lang/Class;

    if-eqz v0, :cond_1

    :cond_0
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    :cond_1
    return-object p1
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzaqr;Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzaqr;",
            "TT;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqm;->bol:Lcom/google/android/gms/internal/zzapk;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqm;->bqi:Ljava/lang/reflect/Type;

    invoke-direct {p0, v1, p2}, Lcom/google/android/gms/internal/zzaqm;->zzb(Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/reflect/Type;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzaqm;->bqi:Ljava/lang/reflect/Type;

    if-eq v1, v2, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqm;->bqh:Lcom/google/android/gms/internal/zzaos;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzaqo;->zzl(Ljava/lang/reflect/Type;)Lcom/google/android/gms/internal/zzaqo;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzaos;->zza(Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;

    move-result-object v0

    instance-of v1, v0, Lcom/google/android/gms/internal/zzaqj$zza;

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    invoke-virtual {v0, p1, p2}, Lcom/google/android/gms/internal/zzapk;->zza(Lcom/google/android/gms/internal/zzaqr;Ljava/lang/Object;)V

    return-void

    :cond_1
    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqm;->bol:Lcom/google/android/gms/internal/zzapk;

    instance-of v1, v1, Lcom/google/android/gms/internal/zzaqj$zza;

    if-nez v1, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqm;->bol:Lcom/google/android/gms/internal/zzapk;

    goto :goto_0
.end method

.method public zzb(Lcom/google/android/gms/internal/zzaqp;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzaqp;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqm;->bol:Lcom/google/android/gms/internal/zzapk;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzapk;->zzb(Lcom/google/android/gms/internal/zzaqp;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
