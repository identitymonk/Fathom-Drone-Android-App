.class public final Lcom/google/android/gms/internal/zzaqh;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzapl;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzaqh$zza;
    }
.end annotation


# instance fields
.field private final bod:Lcom/google/android/gms/internal/zzaps;

.field private final bpS:Z


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzaps;Z)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzaqh;->bod:Lcom/google/android/gms/internal/zzaps;

    iput-boolean p2, p0, Lcom/google/android/gms/internal/zzaqh;->bpS:Z

    return-void
.end method

.method private zza(Lcom/google/android/gms/internal/zzaos;Ljava/lang/reflect/Type;)Lcom/google/android/gms/internal/zzapk;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzaos;",
            "Ljava/lang/reflect/Type;",
            ")",
            "Lcom/google/android/gms/internal/zzapk",
            "<*>;"
        }
    .end annotation

    sget-object v0, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    if-eq p2, v0, :cond_0

    const-class v0, Ljava/lang/Boolean;

    if-ne p2, v0, :cond_1

    :cond_0
    sget-object v0, Lcom/google/android/gms/internal/zzaqn;->bqo:Lcom/google/android/gms/internal/zzapk;

    :goto_0
    return-object v0

    :cond_1
    invoke-static {p2}, Lcom/google/android/gms/internal/zzaqo;->zzl(Ljava/lang/reflect/Type;)Lcom/google/android/gms/internal/zzaqo;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/zzaos;->zza(Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;

    move-result-object v0

    goto :goto_0
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zzaqh;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzaqh;->bpS:Z

    return v0
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/google/android/gms/internal/zzaos;",
            "Lcom/google/android/gms/internal/zzaqo",
            "<TT;>;)",
            "Lcom/google/android/gms/internal/zzapk",
            "<TT;>;"
        }
    .end annotation

    const/4 v5, 0x1

    const/4 v3, 0x0

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzaqo;->bC()Ljava/lang/reflect/Type;

    move-result-object v0

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzaqo;->bB()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Ljava/util/Map;

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {v0}, Lcom/google/android/gms/internal/zzapr;->zzf(Ljava/lang/reflect/Type;)Ljava/lang/Class;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzapr;->zzb(Ljava/lang/reflect/Type;Ljava/lang/Class;)[Ljava/lang/reflect/Type;

    move-result-object v1

    aget-object v0, v1, v3

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/zzaqh;->zza(Lcom/google/android/gms/internal/zzaos;Ljava/lang/reflect/Type;)Lcom/google/android/gms/internal/zzapk;

    move-result-object v4

    aget-object v0, v1, v5

    invoke-static {v0}, Lcom/google/android/gms/internal/zzaqo;->zzl(Ljava/lang/reflect/Type;)Lcom/google/android/gms/internal/zzaqo;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/zzaos;->zza(Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;

    move-result-object v6

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqh;->bod:Lcom/google/android/gms/internal/zzaps;

    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/zzaps;->zzb(Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapx;

    move-result-object v7

    new-instance v0, Lcom/google/android/gms/internal/zzaqh$zza;

    aget-object v3, v1, v3

    aget-object v5, v1, v5

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gms/internal/zzaqh$zza;-><init>(Lcom/google/android/gms/internal/zzaqh;Lcom/google/android/gms/internal/zzaos;Ljava/lang/reflect/Type;Lcom/google/android/gms/internal/zzapk;Ljava/lang/reflect/Type;Lcom/google/android/gms/internal/zzapk;Lcom/google/android/gms/internal/zzapx;)V

    goto :goto_0
.end method
