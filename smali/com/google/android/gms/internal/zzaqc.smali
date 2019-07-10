.class public final Lcom/google/android/gms/internal/zzaqc;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzapl;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzaqc$zza;
    }
.end annotation


# instance fields
.field private final bod:Lcom/google/android/gms/internal/zzaps;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzaps;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzaqc;->bod:Lcom/google/android/gms/internal/zzaps;

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;
    .locals 4
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

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzaqo;->bC()Ljava/lang/reflect/Type;

    move-result-object v0

    invoke-virtual {p2}, Lcom/google/android/gms/internal/zzaqo;->bB()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Ljava/util/Collection;

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzapr;->zza(Ljava/lang/reflect/Type;Ljava/lang/Class;)Ljava/lang/reflect/Type;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gms/internal/zzaqo;->zzl(Ljava/lang/reflect/Type;)Lcom/google/android/gms/internal/zzaqo;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/zzaos;->zza(Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;

    move-result-object v2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqc;->bod:Lcom/google/android/gms/internal/zzaps;

    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/zzaps;->zzb(Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapx;

    move-result-object v3

    new-instance v0, Lcom/google/android/gms/internal/zzaqc$zza;

    invoke-direct {v0, p1, v1, v2, v3}, Lcom/google/android/gms/internal/zzaqc$zza;-><init>(Lcom/google/android/gms/internal/zzaos;Ljava/lang/reflect/Type;Lcom/google/android/gms/internal/zzapk;Lcom/google/android/gms/internal/zzapx;)V

    goto :goto_0
.end method
