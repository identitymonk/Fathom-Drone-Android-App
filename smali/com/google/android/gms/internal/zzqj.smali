.class public abstract Lcom/google/android/gms/internal/zzqj;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzqj$zzd;,
        Lcom/google/android/gms/internal/zzqj$zze;,
        Lcom/google/android/gms/internal/zzqj$zzc;,
        Lcom/google/android/gms/internal/zzqj$zza;,
        Lcom/google/android/gms/internal/zzqj$zzb;
    }
.end annotation


# instance fields
.field public final nV:I


# direct methods
.method public constructor <init>(I)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/zzqj;->nV:I

    return-void
.end method


# virtual methods
.method public abstract zza(Lcom/google/android/gms/internal/zzqv;Z)V
    .param p1    # Lcom/google/android/gms/internal/zzqv;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
.end method

.method public abstract zza(Lcom/google/android/gms/internal/zzrh$zza;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzrh$zza",
            "<*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/DeadObjectException;
        }
    .end annotation
.end method

.method public abstract zzy(Lcom/google/android/gms/common/api/Status;)V
    .param p1    # Lcom/google/android/gms/common/api/Status;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
.end method
