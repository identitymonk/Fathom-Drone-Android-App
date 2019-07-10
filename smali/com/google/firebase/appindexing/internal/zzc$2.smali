.class Lcom/google/firebase/appindexing/internal/zzc$2;
.super Lcom/google/firebase/appindexing/internal/zzc$zzb;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/firebase/appindexing/internal/zzc;->remove([Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic aWE:Lcom/google/firebase/appindexing/internal/zzc;

.field final synthetic aWF:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/firebase/appindexing/internal/zzc;[Ljava/lang/String;)V
    .locals 1

    iput-object p1, p0, Lcom/google/firebase/appindexing/internal/zzc$2;->aWE:Lcom/google/firebase/appindexing/internal/zzc;

    iput-object p2, p0, Lcom/google/firebase/appindexing/internal/zzc$2;->aWF:[Ljava/lang/String;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/firebase/appindexing/internal/zzc$zzb;-><init>(Lcom/google/firebase/appindexing/internal/zzc$1;)V

    return-void
.end method


# virtual methods
.method protected zza(Lcom/google/firebase/appindexing/internal/zzf;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/firebase/appindexing/internal/zzc$2;->zzcom()Lcom/google/android/gms/internal/zzrl;

    move-result-object v0

    iget-object v1, p0, Lcom/google/firebase/appindexing/internal/zzc$2;->aWF:[Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Lcom/google/firebase/appindexing/internal/zzf;->zza(Lcom/google/android/gms/internal/zzrl;[Ljava/lang/String;)V

    return-void
.end method
