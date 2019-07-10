.class public final Lcom/google/firebase/appindexing/internal/zze;
.super Lcom/google/firebase/appindexing/FirebaseUserActions;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/firebase/appindexing/internal/zze$zzb;,
        Lcom/google/firebase/appindexing/internal/zze$zza;
    }
.end annotation


# instance fields
.field private aWP:Lcom/google/firebase/appindexing/internal/zze$zza;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Lcom/google/firebase/appindexing/FirebaseUserActions;-><init>()V

    new-instance v0, Lcom/google/firebase/appindexing/internal/zze$zza;

    invoke-direct {v0, p1}, Lcom/google/firebase/appindexing/internal/zze$zza;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/firebase/appindexing/internal/zze;->aWP:Lcom/google/firebase/appindexing/internal/zze$zza;

    return-void
.end method

.method private zza(ILcom/google/firebase/appindexing/Action;)Lcom/google/android/gms/tasks/Task;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/google/firebase/appindexing/Action;",
            ")",
            "Lcom/google/android/gms/tasks/Task",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    const/4 v1, 0x0

    instance-of v0, p2, Lcom/google/firebase/appindexing/internal/ActionImpl;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/firebase/appindexing/FirebaseAppIndexingInvalidArgumentException;

    const-string v1, "Custom Action objects are not allowed. Please use the \'Actions\' or \'ActionBuilder\' class for creating Action objects."

    invoke-direct {v0, v1}, Lcom/google/firebase/appindexing/FirebaseAppIndexingInvalidArgumentException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/google/android/gms/tasks/Tasks;->forException(Ljava/lang/Exception;)Lcom/google/android/gms/tasks/Task;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/google/firebase/appindexing/internal/ActionImpl;

    check-cast p2, Lcom/google/firebase/appindexing/internal/ActionImpl;

    aput-object p2, v0, v1

    aget-object v1, v0, v1

    invoke-virtual {v1}, Lcom/google/firebase/appindexing/internal/ActionImpl;->zzcof()Lcom/google/firebase/appindexing/internal/ActionImpl$MetadataImpl;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/google/firebase/appindexing/internal/ActionImpl$MetadataImpl;->zzaey(I)V

    iget-object v1, p0, Lcom/google/firebase/appindexing/internal/zze;->aWP:Lcom/google/firebase/appindexing/internal/zze$zza;

    new-instance v2, Lcom/google/firebase/appindexing/internal/zze$1;

    invoke-direct {v2, p0, v0}, Lcom/google/firebase/appindexing/internal/zze$1;-><init>(Lcom/google/firebase/appindexing/internal/zze;[Lcom/google/firebase/appindexing/internal/ActionImpl;)V

    invoke-virtual {v1, v2}, Lcom/google/firebase/appindexing/internal/zze$zza;->doWrite(Lcom/google/android/gms/internal/zzse;)Lcom/google/android/gms/tasks/Task;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public end(Lcom/google/firebase/appindexing/Action;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/firebase/appindexing/Action;",
            ")",
            "Lcom/google/android/gms/tasks/Task",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x2

    invoke-direct {p0, v0, p1}, Lcom/google/firebase/appindexing/internal/zze;->zza(ILcom/google/firebase/appindexing/Action;)Lcom/google/android/gms/tasks/Task;

    move-result-object v0

    return-object v0
.end method

.method public start(Lcom/google/firebase/appindexing/Action;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/firebase/appindexing/Action;",
            ")",
            "Lcom/google/android/gms/tasks/Task",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x1

    invoke-direct {p0, v0, p1}, Lcom/google/firebase/appindexing/internal/zze;->zza(ILcom/google/firebase/appindexing/Action;)Lcom/google/android/gms/tasks/Task;

    move-result-object v0

    return-object v0
.end method
