.class Lcom/google/android/gms/internal/zzsg$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzsg$zzb;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzsg;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic BH:Lcom/google/android/gms/internal/zzsg;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzsg;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzsg$1;->BH:Lcom/google/android/gms/internal/zzsg;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zzc(Lcom/google/android/gms/internal/zzqq;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzqq",
            "<*>;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzsg$1;->BH:Lcom/google/android/gms/internal/zzsg;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzsg;->BF:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzqq;->zzarh()Ljava/lang/Integer;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzsg$1;->BH:Lcom/google/android/gms/internal/zzsg;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzsg;->zza(Lcom/google/android/gms/internal/zzsg;)Lcom/google/android/gms/common/api/zze;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzsg$1;->BH:Lcom/google/android/gms/internal/zzsg;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzsg;->zza(Lcom/google/android/gms/internal/zzsg;)Lcom/google/android/gms/common/api/zze;

    move-result-object v0

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzqq;->zzarh()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/zze;->remove(I)V

    :cond_0
    return-void
.end method
