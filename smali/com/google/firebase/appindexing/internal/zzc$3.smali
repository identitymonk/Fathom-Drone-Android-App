.class Lcom/google/firebase/appindexing/internal/zzc$3;
.super Lcom/google/firebase/appindexing/internal/zzc$zzb;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/firebase/appindexing/internal/zzc;->removeAll()Lcom/google/android/gms/tasks/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic aWE:Lcom/google/firebase/appindexing/internal/zzc;


# direct methods
.method constructor <init>(Lcom/google/firebase/appindexing/internal/zzc;)V
    .locals 1

    iput-object p1, p0, Lcom/google/firebase/appindexing/internal/zzc$3;->aWE:Lcom/google/firebase/appindexing/internal/zzc;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/firebase/appindexing/internal/zzc$zzb;-><init>(Lcom/google/firebase/appindexing/internal/zzc$1;)V

    return-void
.end method


# virtual methods
.method protected zza(Lcom/google/firebase/appindexing/internal/zzf;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/firebase/appindexing/internal/zzc$3;->zzcom()Lcom/google/android/gms/internal/zzrl;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/google/firebase/appindexing/internal/zzf;->zze(Lcom/google/android/gms/internal/zzrl;)V

    return-void
.end method
