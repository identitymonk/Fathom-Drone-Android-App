.class final enum Lcom/google/android/gms/internal/zzaoq$3;
.super Lcom/google/android/gms/internal/zzaoq;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzaoq;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/zzaoq;-><init>(Ljava/lang/String;ILcom/google/android/gms/internal/zzaoq$1;)V

    return-void
.end method


# virtual methods
.method public zzc(Ljava/lang/reflect/Field;)Ljava/lang/String;
    .locals 2

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, " "

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzaoq;->zzca(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzaoq;->zzun(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
