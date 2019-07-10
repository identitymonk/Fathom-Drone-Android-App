.class Lcom/google/firebase/appindexing/internal/zzc$1;
.super Lcom/google/firebase/appindexing/internal/zzc$zzb;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/firebase/appindexing/internal/zzc;->update([Lcom/google/firebase/appindexing/Indexable;)Lcom/google/android/gms/tasks/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic aWD:[Lcom/google/firebase/appindexing/internal/Thing;

.field final synthetic aWE:Lcom/google/firebase/appindexing/internal/zzc;


# direct methods
.method constructor <init>(Lcom/google/firebase/appindexing/internal/zzc;[Lcom/google/firebase/appindexing/internal/Thing;)V
    .locals 1

    iput-object p1, p0, Lcom/google/firebase/appindexing/internal/zzc$1;->aWE:Lcom/google/firebase/appindexing/internal/zzc;

    iput-object p2, p0, Lcom/google/firebase/appindexing/internal/zzc$1;->aWD:[Lcom/google/firebase/appindexing/internal/Thing;

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

    invoke-virtual {p0}, Lcom/google/firebase/appindexing/internal/zzc$1;->zzcom()Lcom/google/android/gms/internal/zzrl;

    move-result-object v0

    iget-object v1, p0, Lcom/google/firebase/appindexing/internal/zzc$1;->aWD:[Lcom/google/firebase/appindexing/internal/Thing;

    invoke-interface {p1, v0, v1}, Lcom/google/firebase/appindexing/internal/zzf;->zza(Lcom/google/android/gms/internal/zzrl;[Lcom/google/firebase/appindexing/internal/Thing;)V

    return-void
.end method
