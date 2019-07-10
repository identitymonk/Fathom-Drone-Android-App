.class Lcom/google/android/gms/internal/zzrd$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzrd;->clearDefaultAccountAndReconnect()Lcom/google/android/gms/common/api/PendingResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic Ar:Lcom/google/android/gms/internal/zzrd;

.field final synthetic As:Ljava/util/concurrent/atomic/AtomicReference;

.field final synthetic At:Lcom/google/android/gms/internal/zzsc;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzrd;Ljava/util/concurrent/atomic/AtomicReference;Lcom/google/android/gms/internal/zzsc;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzrd$2;->Ar:Lcom/google/android/gms/internal/zzrd;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzrd$2;->As:Ljava/util/concurrent/atomic/AtomicReference;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzrd$2;->At:Lcom/google/android/gms/internal/zzsc;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConnected(Landroid/os/Bundle;)V
    .locals 4

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrd$2;->Ar:Lcom/google/android/gms/internal/zzrd;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrd$2;->As:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/api/GoogleApiClient;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrd$2;->At:Lcom/google/android/gms/internal/zzsc;

    const/4 v3, 0x1

    invoke-static {v1, v0, v2, v3}, Lcom/google/android/gms/internal/zzrd;->zza(Lcom/google/android/gms/internal/zzrd;Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/internal/zzsc;Z)V

    return-void
.end method

.method public onConnectionSuspended(I)V
    .locals 0

    return-void
.end method
