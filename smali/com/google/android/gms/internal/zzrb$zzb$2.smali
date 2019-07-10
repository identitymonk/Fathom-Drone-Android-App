.class Lcom/google/android/gms/internal/zzrb$zzb$2;
.super Lcom/google/android/gms/internal/zzrf$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzrb$zzb;->zzaso()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zV:Lcom/google/android/gms/internal/zzrb$zzb;

.field final synthetic zW:Lcom/google/android/gms/common/internal/zze$zzf;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzrb$zzb;Lcom/google/android/gms/internal/zzre;Lcom/google/android/gms/common/internal/zze$zzf;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzrb$zzb$2;->zV:Lcom/google/android/gms/internal/zzrb$zzb;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzrb$zzb$2;->zW:Lcom/google/android/gms/common/internal/zze$zzf;

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzrf$zza;-><init>(Lcom/google/android/gms/internal/zzre;)V

    return-void
.end method


# virtual methods
.method public zzaso()V
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/internal/zzrb$zzb$2;->zW:Lcom/google/android/gms/common/internal/zze$zzf;

    new-instance v1, Lcom/google/android/gms/common/ConnectionResult;

    const/16 v2, 0x10

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/google/android/gms/common/ConnectionResult;-><init>(ILandroid/app/PendingIntent;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/common/internal/zze$zzf;->zzg(Lcom/google/android/gms/common/ConnectionResult;)V

    return-void
.end method
