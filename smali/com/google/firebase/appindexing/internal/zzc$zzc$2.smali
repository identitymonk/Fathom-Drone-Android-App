.class Lcom/google/firebase/appindexing/internal/zzc$zzc$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/tasks/OnCompleteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/firebase/appindexing/internal/zzc$zzc;->zzb(Lcom/google/firebase/appindexing/internal/zzc$zzb;)Lcom/google/android/gms/tasks/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/tasks/OnCompleteListener",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic aWM:Lcom/google/firebase/appindexing/internal/zzc$zzb;

.field final synthetic aWN:Lcom/google/firebase/appindexing/internal/zzc$zzc;

.field final synthetic zw:Lcom/google/android/gms/tasks/TaskCompletionSource;


# direct methods
.method constructor <init>(Lcom/google/firebase/appindexing/internal/zzc$zzc;Lcom/google/firebase/appindexing/internal/zzc$zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 0

    iput-object p1, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$2;->aWN:Lcom/google/firebase/appindexing/internal/zzc$zzc;

    iput-object p2, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$2;->aWM:Lcom/google/firebase/appindexing/internal/zzc$zzb;

    iput-object p3, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$2;->zw:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onComplete(Lcom/google/android/gms/tasks/Task;)V
    .locals 4
    .param p1    # Lcom/google/android/gms/tasks/Task;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/tasks/Task",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$2;->aWN:Lcom/google/firebase/appindexing/internal/zzc$zzc;

    iget-object v1, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$2;->aWM:Lcom/google/firebase/appindexing/internal/zzc$zzb;

    iget-object v2, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$2;->zw:Lcom/google/android/gms/tasks/TaskCompletionSource;

    const/4 v3, 0x0

    invoke-static {v0, v1, v2, v3}, Lcom/google/firebase/appindexing/internal/zzc$zzc;->zza(Lcom/google/firebase/appindexing/internal/zzc$zzc;Lcom/google/firebase/appindexing/internal/zzc$zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;I)V

    return-void
.end method
