.class Lcom/google/android/gms/internal/zzqp$zza$1;
.super Lcom/google/android/gms/internal/zzrj$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzqp$zza;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic yE:Landroid/app/Dialog;

.field final synthetic yF:Lcom/google/android/gms/internal/zzqp$zza;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzqp$zza;Landroid/app/Dialog;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzqp$zza$1;->yF:Lcom/google/android/gms/internal/zzqp$zza;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzqp$zza$1;->yE:Landroid/app/Dialog;

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzrj$zza;-><init>()V

    return-void
.end method


# virtual methods
.method public zzarr()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqp$zza$1;->yF:Lcom/google/android/gms/internal/zzqp$zza;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzqp$zza;->yD:Lcom/google/android/gms/internal/zzqp;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzqp;->zzarq()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqp$zza$1;->yE:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzqp$zza$1;->yE:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    :cond_0
    return-void
.end method
