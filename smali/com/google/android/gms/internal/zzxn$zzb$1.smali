.class Lcom/google/android/gms/internal/zzxn$zzb$1;
.super Lcom/google/android/gms/internal/zzxn$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzxn$zzb;->zza(Lcom/google/android/gms/internal/zzxm;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic aDb:Lcom/google/android/gms/internal/zzxn$zzb;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzxn$zzb;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzxn$zzb$1;->aDb:Lcom/google/android/gms/internal/zzxn$zzb;

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzxn$zza;-><init>()V

    return-void
.end method


# virtual methods
.method public zzeh(Lcom/google/android/gms/common/api/Status;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzxn$zzb$1;->aDb:Lcom/google/android/gms/internal/zzxn$zzb;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzxn$zzb;->zza(Lcom/google/android/gms/internal/zzxn$zzb;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "SearchAuth"

    const-string v1, "ClearTokenImpl success"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzxn$zzb$1;->aDb:Lcom/google/android/gms/internal/zzxn$zzb;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzxn$zzb;->zzc(Lcom/google/android/gms/common/api/Result;)V

    return-void
.end method
