.class final Lcom/google/android/gms/internal/zzaqn$20;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzapl;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzaqn;->zza(Lcom/google/android/gms/internal/zzaqo;Lcom/google/android/gms/internal/zzapk;)Lcom/google/android/gms/internal/zzapl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic bpf:Lcom/google/android/gms/internal/zzaqo;

.field final synthetic brd:Lcom/google/android/gms/internal/zzapk;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzaqo;Lcom/google/android/gms/internal/zzapk;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzaqn$20;->bpf:Lcom/google/android/gms/internal/zzaqo;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzaqn$20;->brd:Lcom/google/android/gms/internal/zzapk;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;
    .locals 1
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

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqn$20;->bpf:Lcom/google/android/gms/internal/zzaqo;

    invoke-virtual {p2, v0}, Lcom/google/android/gms/internal/zzaqo;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqn$20;->brd:Lcom/google/android/gms/internal/zzapk;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
