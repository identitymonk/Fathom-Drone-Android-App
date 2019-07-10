.class Lcom/google/firebase/appindexing/internal/zzc$zzc$1$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/firebase/appindexing/internal/zzc$zzc$1;->onComplete(Lcom/google/android/gms/tasks/Task;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic aWO:Lcom/google/firebase/appindexing/internal/zzc$zzc$1;


# direct methods
.method constructor <init>(Lcom/google/firebase/appindexing/internal/zzc$zzc$1;)V
    .locals 0

    iput-object p1, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$1$1;->aWO:Lcom/google/firebase/appindexing/internal/zzc$zzc$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    iget-object v0, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$1$1;->aWO:Lcom/google/firebase/appindexing/internal/zzc$zzc$1;

    iget-object v0, v0, Lcom/google/firebase/appindexing/internal/zzc$zzc$1;->aWN:Lcom/google/firebase/appindexing/internal/zzc$zzc;

    iget-object v1, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$1$1;->aWO:Lcom/google/firebase/appindexing/internal/zzc$zzc$1;

    iget-object v1, v1, Lcom/google/firebase/appindexing/internal/zzc$zzc$1;->aWM:Lcom/google/firebase/appindexing/internal/zzc$zzb;

    iget-object v2, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$1$1;->aWO:Lcom/google/firebase/appindexing/internal/zzc$zzc$1;

    iget-object v2, v2, Lcom/google/firebase/appindexing/internal/zzc$zzc$1;->zw:Lcom/google/android/gms/tasks/TaskCompletionSource;

    iget-object v3, p0, Lcom/google/firebase/appindexing/internal/zzc$zzc$1$1;->aWO:Lcom/google/firebase/appindexing/internal/zzc$zzc$1;

    iget v3, v3, Lcom/google/firebase/appindexing/internal/zzc$zzc$1;->aWL:I

    add-int/lit8 v3, v3, 0x1

    invoke-static {v0, v1, v2, v3}, Lcom/google/firebase/appindexing/internal/zzc$zzc;->zza(Lcom/google/firebase/appindexing/internal/zzc$zzc;Lcom/google/firebase/appindexing/internal/zzc$zzb;Lcom/google/android/gms/tasks/TaskCompletionSource;I)V

    return-void
.end method
