.class public final Lcom/google/android/gms/internal/zzrx;
.super Ljava/lang/Object;


# instance fields
.field public final yi:Lcom/google/android/gms/internal/zzrw;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzrw",
            "<",
            "Lcom/google/android/gms/common/api/Api$zzb;",
            ">;"
        }
    .end annotation
.end field

.field public final yj:Lcom/google/android/gms/internal/zzsh;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzsh",
            "<",
            "Lcom/google/android/gms/common/api/Api$zzb;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzrw;Lcom/google/android/gms/internal/zzsh;)V
    .locals 0
    .param p1    # Lcom/google/android/gms/internal/zzrw;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2    # Lcom/google/android/gms/internal/zzsh;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzrw",
            "<",
            "Lcom/google/android/gms/common/api/Api$zzb;",
            ">;",
            "Lcom/google/android/gms/internal/zzsh",
            "<",
            "Lcom/google/android/gms/common/api/Api$zzb;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzrx;->yi:Lcom/google/android/gms/internal/zzrw;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzrx;->yj:Lcom/google/android/gms/internal/zzsh;

    return-void
.end method
