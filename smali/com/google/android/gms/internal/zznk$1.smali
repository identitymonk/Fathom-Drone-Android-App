.class Lcom/google/android/gms/internal/zznk$1;
.super Lcom/google/android/gms/internal/zznk$zzc;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zznk;->zza(Lcom/google/android/gms/common/api/GoogleApiClient;[Lcom/google/android/gms/appdatasearch/UsageInfo;)Lcom/google/android/gms/common/api/PendingResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/zznk$zzc",
        "<",
        "Lcom/google/android/gms/common/api/Status;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic gZ:[Lcom/google/android/gms/appdatasearch/UsageInfo;

.field final synthetic ha:Lcom/google/android/gms/internal/zznk;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zznk;Lcom/google/android/gms/common/api/GoogleApiClient;[Lcom/google/android/gms/appdatasearch/UsageInfo;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zznk$1;->ha:Lcom/google/android/gms/internal/zznk;

    iput-object p3, p0, Lcom/google/android/gms/internal/zznk$1;->gZ:[Lcom/google/android/gms/appdatasearch/UsageInfo;

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zznk$zzc;-><init>(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    return-void
.end method


# virtual methods
.method protected zza(Lcom/google/android/gms/internal/zznf;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zznk$zzd;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zznk$zzd;-><init>(Lcom/google/android/gms/internal/zzqo$zzb;)V

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/google/android/gms/internal/zznk$1;->gZ:[Lcom/google/android/gms/appdatasearch/UsageInfo;

    invoke-interface {p1, v0, v1, v2}, Lcom/google/android/gms/internal/zznf;->zza(Lcom/google/android/gms/internal/zzng;Ljava/lang/String;[Lcom/google/android/gms/appdatasearch/UsageInfo;)V

    return-void
.end method
