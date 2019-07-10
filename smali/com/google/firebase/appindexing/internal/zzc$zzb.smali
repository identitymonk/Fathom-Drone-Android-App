.class abstract Lcom/google/firebase/appindexing/internal/zzc$zzb;
.super Lcom/google/android/gms/internal/zzse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/firebase/appindexing/internal/zzc;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "zzb"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/zzse",
        "<",
        "Lcom/google/firebase/appindexing/internal/zzb;",
        "Lcom/google/android/gms/common/api/Status;",
        ">;"
    }
.end annotation


# instance fields
.field private yg:Lcom/google/android/gms/tasks/TaskCompletionSource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/tasks/TaskCompletionSource",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzse;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/firebase/appindexing/internal/zzc$1;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/firebase/appindexing/internal/zzc$zzb;-><init>()V

    return-void
.end method

.method static synthetic zza(Lcom/google/firebase/appindexing/internal/zzc$zzb;)Lcom/google/android/gms/tasks/TaskCompletionSource;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/appindexing/internal/zzc$zzb;->yg:Lcom/google/android/gms/tasks/TaskCompletionSource;

    return-object v0
.end method


# virtual methods
.method protected final zza(Lcom/google/firebase/appindexing/internal/zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/firebase/appindexing/internal/zzb;",
            "Lcom/google/android/gms/tasks/TaskCompletionSource",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iput-object p2, p0, Lcom/google/firebase/appindexing/internal/zzc$zzb;->yg:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-virtual {p1}, Lcom/google/firebase/appindexing/internal/zzb;->zzavg()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/firebase/appindexing/internal/zzf;

    invoke-virtual {p0, v0}, Lcom/google/firebase/appindexing/internal/zzc$zzb;->zza(Lcom/google/firebase/appindexing/internal/zzf;)V

    return-void
.end method

.method protected abstract zza(Lcom/google/firebase/appindexing/internal/zzf;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method protected synthetic zzb(Lcom/google/android/gms/common/api/Api$zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    check-cast p1, Lcom/google/firebase/appindexing/internal/zzb;

    invoke-virtual {p0, p1, p2}, Lcom/google/firebase/appindexing/internal/zzc$zzb;->zza(Lcom/google/firebase/appindexing/internal/zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;)V

    return-void
.end method

.method protected zzcom()Lcom/google/android/gms/internal/zzrl;
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/internal/zzc$zzb$1;

    invoke-direct {v0, p0}, Lcom/google/firebase/appindexing/internal/zzc$zzb$1;-><init>(Lcom/google/firebase/appindexing/internal/zzc$zzb;)V

    return-object v0
.end method
