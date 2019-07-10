.class public final Lcom/google/android/gms/internal/zzqj$zzc;
.super Lcom/google/android/gms/internal/zzqj$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzqj;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "zzc"
.end annotation


# instance fields
.field public final yi:Lcom/google/android/gms/internal/zzrw;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzrw",
            "<",
            "Lcom/google/android/gms/common/api/Api$zzb;",
            ">;"
        }
    .end annotation
.end field

.field public final yj:Lcom/google/android/gms/internal/zzsh;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzsh",
            "<",
            "Lcom/google/android/gms/common/api/Api$zzb;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzrx;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzrx;",
            "Lcom/google/android/gms/tasks/TaskCompletionSource",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    const/4 v0, 0x3

    invoke-direct {p0, v0, p2}, Lcom/google/android/gms/internal/zzqj$zza;-><init>(ILcom/google/android/gms/tasks/TaskCompletionSource;)V

    iget-object v0, p1, Lcom/google/android/gms/internal/zzrx;->yi:Lcom/google/android/gms/internal/zzrw;

    iput-object v0, p0, Lcom/google/android/gms/internal/zzqj$zzc;->yi:Lcom/google/android/gms/internal/zzrw;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzrx;->yj:Lcom/google/android/gms/internal/zzsh;

    iput-object v0, p0, Lcom/google/android/gms/internal/zzqj$zzc;->yj:Lcom/google/android/gms/internal/zzsh;

    return-void
.end method


# virtual methods
.method public bridge synthetic zza(Lcom/google/android/gms/internal/zzqv;Z)V
    .locals 0
    .param p1    # Lcom/google/android/gms/internal/zzqv;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    invoke-super {p0, p1, p2}, Lcom/google/android/gms/internal/zzqj$zza;->zza(Lcom/google/android/gms/internal/zzqv;Z)V

    return-void
.end method

.method public zzb(Lcom/google/android/gms/internal/zzrh$zza;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzrh$zza",
            "<*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/DeadObjectException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqj$zzc;->yi:Lcom/google/android/gms/internal/zzrw;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzrh$zza;->getClient()Lcom/google/android/gms/common/api/Api$zze;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzqj$zzc;->yg:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzrw;->zza(Lcom/google/android/gms/common/api/Api$zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqj$zzc;->yi:Lcom/google/android/gms/internal/zzrw;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzrw;->zzatz()Lcom/google/android/gms/internal/zzrr$zzb;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzrh$zza;->zzatn()Ljava/util/Map;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzqj$zzc;->yi:Lcom/google/android/gms/internal/zzrw;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzrw;->zzatz()Lcom/google/android/gms/internal/zzrr$zzb;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/internal/zzrx;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzqj$zzc;->yi:Lcom/google/android/gms/internal/zzrw;

    iget-object v4, p0, Lcom/google/android/gms/internal/zzqj$zzc;->yj:Lcom/google/android/gms/internal/zzsh;

    invoke-direct {v2, v3, v4}, Lcom/google/android/gms/internal/zzrx;-><init>(Lcom/google/android/gms/internal/zzrw;Lcom/google/android/gms/internal/zzsh;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    return-void
.end method

.method public bridge synthetic zzy(Lcom/google/android/gms/common/api/Status;)V
    .locals 0
    .param p1    # Lcom/google/android/gms/common/api/Status;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    invoke-super {p0, p1}, Lcom/google/android/gms/internal/zzqj$zza;->zzy(Lcom/google/android/gms/common/api/Status;)V

    return-void
.end method
