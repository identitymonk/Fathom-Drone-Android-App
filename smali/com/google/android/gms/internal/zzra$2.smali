.class Lcom/google/android/gms/internal/zzra$2;
.super Lcom/google/android/gms/internal/zzrf$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzra;->connect()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zC:Lcom/google/android/gms/internal/zzra;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzra;Lcom/google/android/gms/internal/zzre;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzra$2;->zC:Lcom/google/android/gms/internal/zzra;

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzrf$zza;-><init>(Lcom/google/android/gms/internal/zzre;)V

    return-void
.end method


# virtual methods
.method public zzaso()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzra$2;->zC:Lcom/google/android/gms/internal/zzra;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzra;->zza(Lcom/google/android/gms/internal/zzra;)Lcom/google/android/gms/internal/zzrf;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzrf;->AC:Lcom/google/android/gms/internal/zzrm$zza;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzrm$zza;->zzn(Landroid/os/Bundle;)V

    return-void
.end method
