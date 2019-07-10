.class Lcom/google/android/gms/internal/zzrh$zza;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;
.implements Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;
.implements Lcom/google/android/gms/internal/zzqs;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzrh;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "zza"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<O::",
        "Lcom/google/android/gms/common/api/Api$ApiOptions;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;",
        "Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;",
        "Lcom/google/android/gms/internal/zzqs;"
    }
.end annotation


# instance fields
.field private final AQ:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/google/android/gms/internal/zzqj;",
            ">;"
        }
    .end annotation
.end field

.field private final AR:Lcom/google/android/gms/common/api/Api$zzb;

.field private final AS:Lcom/google/android/gms/internal/zzqv;

.field private final AT:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/google/android/gms/internal/zzqn;",
            ">;"
        }
    .end annotation
.end field

.field private final AU:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/google/android/gms/internal/zzrr$zzb",
            "<*>;",
            "Lcom/google/android/gms/internal/zzrx;",
            ">;"
        }
    .end annotation
.end field

.field private final AV:I

.field private AW:Lcom/google/android/gms/common/ConnectionResult;

.field final synthetic AX:Lcom/google/android/gms/internal/zzrh;

.field private Ae:Z

.field private final xB:Lcom/google/android/gms/common/api/Api$zze;

.field private final xx:Lcom/google/android/gms/internal/zzql;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzql",
            "<TO;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzrh;Lcom/google/android/gms/common/api/zzc;)V
    .locals 1
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/zzc",
            "<TO;>;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AQ:Ljava/util/Queue;

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AT:Ljava/util/Set;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AU:Ljava/util/Map;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AW:Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {p2}, Lcom/google/android/gms/common/api/zzc;->isConnectionlessGoogleApiClient()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p2}, Lcom/google/android/gms/common/api/zzc;->getClient()Lcom/google/android/gms/common/api/Api$zze;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-virtual {p2}, Lcom/google/android/gms/common/api/zzc;->getClientCallbacks()Lcom/google/android/gms/internal/zzqr;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/zzqr;->zza(Lcom/google/android/gms/internal/zzqs;)V

    :goto_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    instance-of v0, v0, Lcom/google/android/gms/common/internal/zzag;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    check-cast v0, Lcom/google/android/gms/common/internal/zzag;

    invoke-virtual {v0}, Lcom/google/android/gms/common/internal/zzag;->zzawt()Lcom/google/android/gms/common/api/Api$zzg;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AR:Lcom/google/android/gms/common/api/Api$zzb;

    :goto_1
    invoke-virtual {p2}, Lcom/google/android/gms/common/api/zzc;->getApiKey()Lcom/google/android/gms/internal/zzql;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    new-instance v0, Lcom/google/android/gms/internal/zzqv;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzqv;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AS:Lcom/google/android/gms/internal/zzqv;

    invoke-virtual {p2}, Lcom/google/android/gms/common/api/zzc;->getInstanceId()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AV:I

    return-void

    :cond_0
    invoke-static {p1}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {p2, v0, p0, p0}, Lcom/google/android/gms/common/api/zzc;->buildApiClient(Landroid/os/Looper;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)Lcom/google/android/gms/common/api/Api$zze;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AR:Lcom/google/android/gms/common/api/Api$zzb;

    goto :goto_1
.end method

.method private connect()V
    .locals 4
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->isConnected()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->isConnecting()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->zzaqx()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zzi(Lcom/google/android/gms/internal/zzrh;)I

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzrh;->zzg(Lcom/google/android/gms/internal/zzrh;)Lcom/google/android/gms/common/GoogleApiAvailability;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzrh;->zzf(Lcom/google/android/gms/internal/zzrh;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/common/GoogleApiAvailability;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v1

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;I)I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zzi(Lcom/google/android/gms/internal/zzrh;)I

    move-result v0

    if-eqz v0, :cond_2

    new-instance v0, Lcom/google/android/gms/common/ConnectionResult;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzrh;->zzi(Lcom/google/android/gms/internal/zzrh;)I

    move-result v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/common/ConnectionResult;-><init>(ILandroid/app/PendingIntent;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->zzain()Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_3
    new-instance v0, Lcom/google/android/gms/internal/zzrh$zzb;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gms/internal/zzrh$zzb;-><init>(Lcom/google/android/gms/internal/zzrh;Lcom/google/android/gms/common/api/Api$zze;Lcom/google/android/gms/internal/zzql;)V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v1, v0}, Lcom/google/android/gms/common/api/Api$zze;->zza(Lcom/google/android/gms/common/internal/zze$zzf;)V

    goto :goto_0
.end method

.method private resume()V
    .locals 1
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->Ae:Z

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->connect()V

    :cond_0
    return-void
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zzrh$zza;Lcom/google/android/gms/common/api/Status;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzrh$zza;->zzac(Lcom/google/android/gms/common/api/Status;)V

    return-void
.end method

.method private zzac(Lcom/google/android/gms/common/api/Status;)V
    .locals 2
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AQ:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzqj;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzqj;->zzy(Lcom/google/android/gms/common/api/Status;)V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AQ:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    return-void
.end method

.method private zzasx()V
    .locals 3
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    const/16 v2, 0x8

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->Ae:Z

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzatq()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zzg(Lcom/google/android/gms/internal/zzrh;)Lcom/google/android/gms/common/GoogleApiAvailability;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzrh;->zzf(Lcom/google/android/gms/internal/zzrh;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/GoogleApiAvailability;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v0

    const/16 v1, 0x12

    if-ne v0, v1, :cond_1

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const-string v1, "Connection timed out while waiting for Google Play services update to complete."

    invoke-direct {v0, v2, v1}, Lcom/google/android/gms/common/api/Status;-><init>(ILjava/lang/String;)V

    :goto_0
    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->zzac(Lcom/google/android/gms/common/api/Status;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->disconnect()V

    :cond_0
    return-void

    :cond_1
    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const-string v1, "API failed to connect while resuming due to an unknown error."

    invoke-direct {v0, v2, v1}, Lcom/google/android/gms/common/api/Status;-><init>(ILjava/lang/String;)V

    goto :goto_0
.end method

.method private zzatq()V
    .locals 3
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->Ae:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v0

    const/16 v1, 0x9

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-virtual {v0, v1, v2}, Landroid/os/Handler;->removeMessages(ILjava/lang/Object;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v0

    const/4 v1, 0x7

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-virtual {v0, v1, v2}, Landroid/os/Handler;->removeMessages(ILjava/lang/Object;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->Ae:Z

    :cond_0
    return-void
.end method

.method private zzatr()V
    .locals 4

    const/16 v3, 0xa

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-virtual {v0, v3, v1}, Landroid/os/Handler;->removeMessages(ILjava/lang/Object;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-virtual {v1, v3, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzrh;->zzh(Lcom/google/android/gms/internal/zzrh;)J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    return-void
.end method

.method private zzats()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AU:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AS:Lcom/google/android/gms/internal/zzqv;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzqv;->zzasi()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzatr()V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->disconnect()V

    goto :goto_0
.end method

.method private zzb(Lcom/google/android/gms/internal/zzqj;)V
    .locals 2
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AS:Lcom/google/android/gms/internal/zzqv;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzain()Z

    move-result v1

    invoke-virtual {p1, v0, v1}, Lcom/google/android/gms/internal/zzqj;->zza(Lcom/google/android/gms/internal/zzqv;Z)V

    :try_start_0
    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/zzqj;->zza(Lcom/google/android/gms/internal/zzrh$zza;)V
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->onConnectionSuspended(I)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->disconnect()V

    goto :goto_0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/zzrh$zza;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->connect()V

    return-void
.end method

.method static synthetic zzd(Lcom/google/android/gms/internal/zzrh$zza;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->resume()V

    return-void
.end method

.method static synthetic zze(Lcom/google/android/gms/internal/zzrh$zza;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzasx()V

    return-void
.end method

.method static synthetic zzf(Lcom/google/android/gms/internal/zzrh$zza;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzats()V

    return-void
.end method

.method private zzi(Lcom/google/android/gms/common/ConnectionResult;)V
    .locals 3
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AT:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzqn;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-virtual {v0, v2, p1}, Lcom/google/android/gms/internal/zzqn;->zza(Lcom/google/android/gms/internal/zzql;Lcom/google/android/gms/common/ConnectionResult;)V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AT:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    return-void
.end method


# virtual methods
.method public getClient()Lcom/google/android/gms/common/api/Api$zze;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    return-object v0
.end method

.method public getInstanceId()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AV:I

    return v0
.end method

.method isConnected()Z
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->isConnected()Z

    move-result v0

    return v0
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 4
    .param p1    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzato()V

    sget-object v0, Lcom/google/android/gms/common/ConnectionResult;->wO:Lcom/google/android/gms/common/ConnectionResult;

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->zzi(Lcom/google/android/gms/common/ConnectionResult;)V

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzatq()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AU:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzrx;

    :try_start_0
    iget-object v0, v0, Lcom/google/android/gms/internal/zzrx;->yi:Lcom/google/android/gms/internal/zzrw;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->AR:Lcom/google/android/gms/common/api/Api$zzb;

    new-instance v3, Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-direct {v3}, Lcom/google/android/gms/tasks/TaskCompletionSource;-><init>()V

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/zzrw;->zza(Lcom/google/android/gms/common/api/Api$zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->onConnectionSuspended(I)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->disconnect()V

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzatm()V

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzatr()V

    return-void
.end method

.method public onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V
    .locals 5
    .param p1    # Lcom/google/android/gms/common/ConnectionResult;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzato()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    const/4 v1, -0x1

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;I)I

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzrh$zza;->zzi(Lcom/google/android/gms/common/ConnectionResult;)V

    invoke-virtual {p1}, Lcom/google/android/gms/common/ConnectionResult;->getErrorCode()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    invoke-static {}, Lcom/google/android/gms/internal/zzrh;->zzatk()Lcom/google/android/gms/common/api/Status;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->zzac(Lcom/google/android/gms/common/api/Status;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AQ:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    iput-object p1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AW:Lcom/google/android/gms/common/ConnectionResult;

    goto :goto_0

    :cond_2
    invoke-static {}, Lcom/google/android/gms/internal/zzrh;->zzatl()Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zzd(Lcom/google/android/gms/internal/zzrh;)Lcom/google/android/gms/internal/zzqw;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zze(Lcom/google/android/gms/internal/zzrh;)Ljava/util/Set;

    move-result-object v0

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-interface {v0, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zzd(Lcom/google/android/gms/internal/zzrh;)Lcom/google/android/gms/internal/zzqw;

    move-result-object v0

    iget v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->AV:I

    invoke-virtual {v0, p1, v2}, Lcom/google/android/gms/internal/zzqw;->zzb(Lcom/google/android/gms/common/ConnectionResult;I)V

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_3
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    iget v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AV:I

    invoke-virtual {v0, p1, v1}, Lcom/google/android/gms/internal/zzrh;->zzc(Lcom/google/android/gms/common/ConnectionResult;I)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gms/common/ConnectionResult;->getErrorCode()I

    move-result v0

    const/16 v1, 0x12

    if-ne v0, v1, :cond_4

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->Ae:Z

    :cond_4
    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->Ae:Z

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v1

    const/4 v2, 0x7

    iget-object v3, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-static {v1, v2, v3}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzrh;->zzb(Lcom/google/android/gms/internal/zzrh;)J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_0

    :cond_5
    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/16 v1, 0x11

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzql;->zzarl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, 0x26

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v4, "API: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is not available on this device."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/common/api/Status;-><init>(ILjava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->zzac(Lcom/google/android/gms/common/api/Status;)V

    goto/16 :goto_0
.end method

.method public onConnectionSuspended(I)V
    .locals 4
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzato()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->Ae:Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AS:Lcom/google/android/gms/internal/zzqv;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzqv;->zzask()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v1

    const/4 v2, 0x7

    iget-object v3, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-static {v1, v2, v3}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzrh;->zzb(Lcom/google/android/gms/internal/zzrh;)J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;)Landroid/os/Handler;

    move-result-object v1

    const/16 v2, 0x9

    iget-object v3, p0, Lcom/google/android/gms/internal/zzrh$zza;->xx:Lcom/google/android/gms/internal/zzql;

    invoke-static {v1, v2, v3}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzrh;->zzc(Lcom/google/android/gms/internal/zzrh;)J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AX:Lcom/google/android/gms/internal/zzrh;

    const/4 v1, -0x1

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzrh;->zza(Lcom/google/android/gms/internal/zzrh;I)I

    return-void
.end method

.method public signOut()V
    .locals 4
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    sget-object v0, Lcom/google/android/gms/internal/zzrh;->AG:Lcom/google/android/gms/common/api/Status;

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->zzac(Lcom/google/android/gms/common/api/Status;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AS:Lcom/google/android/gms/internal/zzqv;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzqv;->zzasj()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AU:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzrr$zzb;

    new-instance v2, Lcom/google/android/gms/internal/zzqj$zze;

    new-instance v3, Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-direct {v3}, Lcom/google/android/gms/tasks/TaskCompletionSource;-><init>()V

    invoke-direct {v2, v0, v3}, Lcom/google/android/gms/internal/zzqj$zze;-><init>(Lcom/google/android/gms/internal/zzrr$zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;)V

    invoke-virtual {p0, v2}, Lcom/google/android/gms/internal/zzrh$zza;->zza(Lcom/google/android/gms/internal/zzqj;)V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->disconnect()V

    return-void
.end method

.method public zza(Lcom/google/android/gms/common/ConnectionResult;Lcom/google/android/gms/common/api/Api;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/ConnectionResult;",
            "Lcom/google/android/gms/common/api/Api",
            "<*>;I)V"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzrh$zza;->onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V

    return-void
.end method

.method public zza(Lcom/google/android/gms/internal/zzqj;)V
    .locals 1
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzrh$zza;->zzb(Lcom/google/android/gms/internal/zzqj;)V

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->zzatr()V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AQ:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AW:Lcom/google/android/gms/common/ConnectionResult;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AW:Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {v0}, Lcom/google/android/gms/common/ConnectionResult;->hasResolution()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AW:Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V

    goto :goto_0

    :cond_1
    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrh$zza;->connect()V

    goto :goto_0
.end method

.method public zzain()Z
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->zzain()Z

    move-result v0

    return v0
.end method

.method public zzatm()V
    .locals 1
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    :goto_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->xB:Lcom/google/android/gms/common/api/Api$zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/Api$zze;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AQ:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AQ:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->remove()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzqj;

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzrh$zza;->zzb(Lcom/google/android/gms/internal/zzqj;)V

    goto :goto_0

    :cond_0
    return-void
.end method

.method public zzatn()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Lcom/google/android/gms/internal/zzrr$zzb",
            "<*>;",
            "Lcom/google/android/gms/internal/zzrx;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AU:Ljava/util/Map;

    return-object v0
.end method

.method public zzato()V
    .locals 1
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AW:Lcom/google/android/gms/common/ConnectionResult;

    return-void
.end method

.method zzatp()Lcom/google/android/gms/common/ConnectionResult;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AW:Lcom/google/android/gms/common/ConnectionResult;

    return-object v0
.end method

.method public zzb(Lcom/google/android/gms/internal/zzqn;)V
    .locals 1
    .annotation build Landroid/support/annotation/WorkerThread;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrh$zza;->AT:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    return-void
.end method
