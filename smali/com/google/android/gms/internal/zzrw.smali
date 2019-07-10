.class public abstract Lcom/google/android/gms/internal/zzrw;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<A::",
        "Lcom/google/android/gms/common/api/Api$zzb;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final Bt:Lcom/google/android/gms/internal/zzrr;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzrr",
            "<*>;"
        }
    .end annotation
.end field


# virtual methods
.method protected abstract zza(Lcom/google/android/gms/common/api/Api$zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TA;",
            "Lcom/google/android/gms/tasks/TaskCompletionSource",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/DeadObjectException;
        }
    .end annotation
.end method

.method public zzatz()Lcom/google/android/gms/internal/zzrr$zzb;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/android/gms/internal/zzrr$zzb",
            "<*>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrw;->Bt:Lcom/google/android/gms/internal/zzrr;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzrr;->zzatz()Lcom/google/android/gms/internal/zzrr$zzb;

    move-result-object v0

    return-object v0
.end method

.method public zzaua()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrw;->Bt:Lcom/google/android/gms/internal/zzrr;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzrr;->clear()V

    return-void
.end method
