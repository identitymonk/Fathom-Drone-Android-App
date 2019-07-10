.class final Lcom/google/android/gms/internal/zzapw$zzb;
.super Ljava/util/AbstractSet;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzapw;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "zzb"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/AbstractSet",
        "<TK;>;"
    }
.end annotation


# instance fields
.field final synthetic bpn:Lcom/google/android/gms/internal/zzapw;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzapw;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzapw$zzb;->bpn:Lcom/google/android/gms/internal/zzapw;

    invoke-direct {p0}, Ljava/util/AbstractSet;-><init>()V

    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapw$zzb;->bpn:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzapw;->clear()V

    return-void
.end method

.method public contains(Ljava/lang/Object;)Z
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapw$zzb;->bpn:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzapw;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<TK;>;"
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzapw$zzb$1;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzapw$zzb$1;-><init>(Lcom/google/android/gms/internal/zzapw$zzb;)V

    return-object v0
.end method

.method public remove(Ljava/lang/Object;)Z
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapw$zzb;->bpn:Lcom/google/android/gms/internal/zzapw;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzapw;->zzcr(Ljava/lang/Object;)Lcom/google/android/gms/internal/zzapw$zzd;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public size()I
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapw$zzb;->bpn:Lcom/google/android/gms/internal/zzapw;

    iget v0, v0, Lcom/google/android/gms/internal/zzapw;->size:I

    return v0
.end method
