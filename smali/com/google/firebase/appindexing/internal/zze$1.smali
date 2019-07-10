.class Lcom/google/firebase/appindexing/internal/zze$1;
.super Lcom/google/firebase/appindexing/internal/zze$zzb;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/firebase/appindexing/internal/zze;->zza(ILcom/google/firebase/appindexing/Action;)Lcom/google/android/gms/tasks/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic aWQ:[Lcom/google/firebase/appindexing/internal/ActionImpl;

.field final synthetic aWR:Lcom/google/firebase/appindexing/internal/zze;


# direct methods
.method constructor <init>(Lcom/google/firebase/appindexing/internal/zze;[Lcom/google/firebase/appindexing/internal/ActionImpl;)V
    .locals 1

    iput-object p1, p0, Lcom/google/firebase/appindexing/internal/zze$1;->aWR:Lcom/google/firebase/appindexing/internal/zze;

    iput-object p2, p0, Lcom/google/firebase/appindexing/internal/zze$1;->aWQ:[Lcom/google/firebase/appindexing/internal/ActionImpl;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/firebase/appindexing/internal/zze$zzb;-><init>(Lcom/google/firebase/appindexing/internal/zze$1;)V

    return-void
.end method


# virtual methods
.method protected zza(Lcom/google/android/gms/internal/zznf;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zznk$zzd;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zznk$zzd;-><init>(Lcom/google/android/gms/internal/zzqo$zzb;)V

    iget-object v1, p0, Lcom/google/firebase/appindexing/internal/zze$1;->aWQ:[Lcom/google/firebase/appindexing/internal/ActionImpl;

    invoke-interface {p1, v0, v1}, Lcom/google/android/gms/internal/zznf;->zza(Lcom/google/android/gms/internal/zzng;[Lcom/google/firebase/appindexing/internal/ActionImpl;)V

    return-void
.end method
