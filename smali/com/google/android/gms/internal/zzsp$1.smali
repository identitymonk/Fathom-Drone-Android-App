.class Lcom/google/android/gms/internal/zzsp$1;
.super Lcom/google/android/gms/internal/zzsq$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzsp;->zzg(Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/google/android/gms/common/api/PendingResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic EV:Lcom/google/android/gms/internal/zzsp;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzsp;Lcom/google/android/gms/common/api/GoogleApiClient;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzsp$1;->EV:Lcom/google/android/gms/internal/zzsp;

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzsq$zza;-><init>(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic zza(Lcom/google/android/gms/common/api/Api$zzb;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    check-cast p1, Lcom/google/android/gms/internal/zzsr;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzsp$1;->zza(Lcom/google/android/gms/internal/zzsr;)V

    return-void
.end method

.method protected zza(Lcom/google/android/gms/internal/zzsr;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzsr;->zzavg()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzst;

    new-instance v1, Lcom/google/android/gms/internal/zzsp$zza;

    invoke-direct {v1, p0}, Lcom/google/android/gms/internal/zzsp$zza;-><init>(Lcom/google/android/gms/internal/zzqo$zzb;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzst;->zza(Lcom/google/android/gms/internal/zzss;)V

    return-void
.end method
