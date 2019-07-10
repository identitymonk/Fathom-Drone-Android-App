.class Lcom/google/android/gms/internal/zzapw$zzb$1;
.super Lcom/google/android/gms/internal/zzapw$zzc;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzapw$zzb;->iterator()Ljava/util/Iterator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/zzapw$zzc",
        "<TK;>;"
    }
.end annotation


# instance fields
.field final synthetic bpp:Lcom/google/android/gms/internal/zzapw$zzb;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzapw$zzb;)V
    .locals 2

    iput-object p1, p0, Lcom/google/android/gms/internal/zzapw$zzb$1;->bpp:Lcom/google/android/gms/internal/zzapw$zzb;

    iget-object v0, p1, Lcom/google/android/gms/internal/zzapw$zzb;->bpn:Lcom/google/android/gms/internal/zzapw;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/android/gms/internal/zzapw$zzc;-><init>(Lcom/google/android/gms/internal/zzapw;Lcom/google/android/gms/internal/zzapw$1;)V

    return-void
.end method


# virtual methods
.method public next()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TK;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzapw$zzb$1;->bl()Lcom/google/android/gms/internal/zzapw$zzd;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/internal/zzapw$zzd;->bap:Ljava/lang/Object;

    return-object v0
.end method
