.class public final Lcom/google/android/gms/internal/zzaqe;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzapl;


# instance fields
.field private final bod:Lcom/google/android/gms/internal/zzaps;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzaps;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzaqe;->bod:Lcom/google/android/gms/internal/zzaps;

    return-void
.end method

.method static zza(Lcom/google/android/gms/internal/zzaps;Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;Lcom/google/android/gms/internal/zzapm;)Lcom/google/android/gms/internal/zzapk;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzaps;",
            "Lcom/google/android/gms/internal/zzaos;",
            "Lcom/google/android/gms/internal/zzaqo",
            "<*>;",
            "Lcom/google/android/gms/internal/zzapm;",
            ")",
            "Lcom/google/android/gms/internal/zzapk",
            "<*>;"
        }
    .end annotation

    invoke-interface {p3}, Lcom/google/android/gms/internal/zzapm;->value()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/google/android/gms/internal/zzapk;

    invoke-virtual {v1, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzaqo;->zzr(Ljava/lang/Class;)Lcom/google/android/gms/internal/zzaqo;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzaps;->zzb(Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapx;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzapx;->bj()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzapk;

    :goto_0
    return-object v0

    :cond_0
    const-class v1, Lcom/google/android/gms/internal/zzapl;

    invoke-virtual {v1, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {v0}, Lcom/google/android/gms/internal/zzaqo;->zzr(Ljava/lang/Class;)Lcom/google/android/gms/internal/zzaqo;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzaps;->zzb(Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapx;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzapx;->bj()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzapl;

    invoke-interface {v0, p1, p2}, Lcom/google/android/gms/internal/zzapl;->zza(Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;

    move-result-object v0

    goto :goto_0

    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;
    .locals 2
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

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzaqo;->bB()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/google/android/gms/internal/zzapm;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzapm;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqe;->bod:Lcom/google/android/gms/internal/zzaps;

    invoke-static {v1, p1, p2, v0}, Lcom/google/android/gms/internal/zzaqe;->zza(Lcom/google/android/gms/internal/zzaps;Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;Lcom/google/android/gms/internal/zzapm;)Lcom/google/android/gms/internal/zzapk;

    move-result-object v0

    goto :goto_0
.end method
