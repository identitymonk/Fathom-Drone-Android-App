.class Lcom/google/android/gms/internal/zzqu$zza;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/tasks/OnFailureListener;
.implements Lcom/google/android/gms/tasks/OnSuccessListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzqu;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "zza"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/tasks/OnFailureListener;",
        "Lcom/google/android/gms/tasks/OnSuccessListener",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic zr:Lcom/google/android/gms/internal/zzqu;


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/zzqu;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/zzqu;Lcom/google/android/gms/internal/zzqu$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzqu$zza;-><init>(Lcom/google/android/gms/internal/zzqu;)V

    return-void
.end method

.method private zzash()Lcom/google/android/gms/common/ConnectionResult;
    .locals 7
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    const/4 v4, 0x0

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zzg(Lcom/google/android/gms/internal/zzqu;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/api/Api;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzqu;->zzc(Lcom/google/android/gms/internal/zzqu;)Ljava/util/Map;

    move-result-object v2

    iget-object v1, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzqu;->zzb(Lcom/google/android/gms/internal/zzqu;)Ljava/util/Map;

    move-result-object v1

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/Api;->zzaqv()Lcom/google/android/gms/common/api/Api$zzc;

    move-result-object v6

    invoke-interface {v1, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/common/api/zzc;

    invoke-virtual {v1}, Lcom/google/android/gms/common/api/zzc;->getApiKey()Lcom/google/android/gms/internal/zzql;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/common/ConnectionResult;

    invoke-virtual {v1}, Lcom/google/android/gms/common/ConnectionResult;->isSuccess()Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzqu;->zzg(Lcom/google/android/gms/internal/zzqu;)Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    const/4 v6, 0x2

    if-eq v2, v6, :cond_0

    const/4 v6, 0x1

    if-ne v2, v6, :cond_1

    invoke-virtual {v1}, Lcom/google/android/gms/common/ConnectionResult;->hasResolution()Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzqu;->zzh(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/common/zzc;

    move-result-object v2

    invoke-virtual {v1}, Lcom/google/android/gms/common/ConnectionResult;->getErrorCode()I

    move-result v6

    invoke-virtual {v2, v6}, Lcom/google/android/gms/common/zzc;->isUserResolvableError(I)Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_1
    invoke-virtual {v0}, Lcom/google/android/gms/common/api/Api;->zzaqs()Lcom/google/android/gms/common/api/Api$zzd;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/Api$zzd;->getPriority()I

    move-result v0

    if-eqz v4, :cond_2

    if-le v3, v0, :cond_4

    :cond_2
    :goto_1
    move v3, v0

    move-object v4, v1

    goto :goto_0

    :cond_3
    return-object v4

    :cond_4
    move v0, v3

    move-object v1, v4

    goto :goto_1
.end method


# virtual methods
.method public onFailure(Ljava/lang/Exception;)V
    .locals 2
    .param p1    # Ljava/lang/Exception;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    check-cast p1, Lcom/google/android/gms/common/api/zzb;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/zzb;->zzara()Landroid/support/v4/util/ArrayMap;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;Ljava/util/Map;)Ljava/util/Map;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzqu$zza;->zzash()Lcom/google/android/gms/common/ConnectionResult;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;Lcom/google/android/gms/common/ConnectionResult;)Lcom/google/android/gms/common/ConnectionResult;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zzf(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/common/ConnectionResult;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zzd(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/internal/zzrd;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzrd;->zzn(Landroid/os/Bundle;)V

    :goto_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zze(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;Z)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zzd(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/internal/zzrd;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzqu;->zzf(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/common/ConnectionResult;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzrd;->zzc(Lcom/google/android/gms/common/ConnectionResult;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Lock;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method public synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzqu$zza;->zza(Ljava/lang/Void;)V

    return-void
.end method

.method public zza(Ljava/lang/Void;)V
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    new-instance v1, Landroid/support/v4/util/ArrayMap;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzqu;->zzb(Lcom/google/android/gms/internal/zzqu;)Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v2

    invoke-direct {v1, v2}, Landroid/support/v4/util/ArrayMap;-><init>(I)V

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;Ljava/util/Map;)Ljava/util/Map;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zzb(Lcom/google/android/gms/internal/zzqu;)Ljava/util/Map;

    move-result-object v0

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

    check-cast v0, Lcom/google/android/gms/common/api/Api$zzc;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzqu;->zzc(Lcom/google/android/gms/internal/zzqu;)Ljava/util/Map;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v3}, Lcom/google/android/gms/internal/zzqu;->zzb(Lcom/google/android/gms/internal/zzqu;)Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/api/zzc;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/zzc;->getApiKey()Lcom/google/android/gms/internal/zzql;

    move-result-object v0

    sget-object v3, Lcom/google/android/gms/common/ConnectionResult;->wO:Lcom/google/android/gms/common/ConnectionResult;

    invoke-interface {v2, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Lock;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zzd(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/internal/zzrd;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzrd;->zzn(Landroid/os/Bundle;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zze(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqu$zza;->zr:Lcom/google/android/gms/internal/zzqu;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzqu;->zza(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void
.end method
