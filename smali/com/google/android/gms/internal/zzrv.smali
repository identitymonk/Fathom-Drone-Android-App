.class public Lcom/google/android/gms/internal/zzrv;
.super Ljava/lang/Object;


# instance fields
.field public final Bq:Lcom/google/android/gms/internal/zzqj;

.field public final Br:I

.field public final Bs:Lcom/google/android/gms/common/api/zzc;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/common/api/zzc",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzqj;ILcom/google/android/gms/common/api/zzc;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzqj;",
            "I",
            "Lcom/google/android/gms/common/api/zzc",
            "<*>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzrv;->Bq:Lcom/google/android/gms/internal/zzqj;

    iput p2, p0, Lcom/google/android/gms/internal/zzrv;->Br:I

    iput-object p3, p0, Lcom/google/android/gms/internal/zzrv;->Bs:Lcom/google/android/gms/common/api/zzc;

    return-void
.end method
