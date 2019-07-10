.class Lcom/google/android/gms/internal/zzaqj$1;
.super Lcom/google/android/gms/internal/zzaqj$zzb;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzaqj;->zza(Lcom/google/android/gms/internal/zzaos;Ljava/lang/reflect/Field;Ljava/lang/String;Lcom/google/android/gms/internal/zzaqo;ZZ)Lcom/google/android/gms/internal/zzaqj$zzb;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final bpX:Lcom/google/android/gms/internal/zzapk;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzapk",
            "<*>;"
        }
    .end annotation
.end field

.field final synthetic bpY:Lcom/google/android/gms/internal/zzaos;

.field final synthetic bpZ:Ljava/lang/reflect/Field;

.field final synthetic bqa:Lcom/google/android/gms/internal/zzaqo;

.field final synthetic bqb:Z

.field final synthetic bqc:Lcom/google/android/gms/internal/zzaqj;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzaqj;Ljava/lang/String;ZZLcom/google/android/gms/internal/zzaos;Ljava/lang/reflect/Field;Lcom/google/android/gms/internal/zzaqo;Z)V
    .locals 4

    iput-object p1, p0, Lcom/google/android/gms/internal/zzaqj$1;->bqc:Lcom/google/android/gms/internal/zzaqj;

    iput-object p5, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpY:Lcom/google/android/gms/internal/zzaos;

    iput-object p6, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpZ:Ljava/lang/reflect/Field;

    iput-object p7, p0, Lcom/google/android/gms/internal/zzaqj$1;->bqa:Lcom/google/android/gms/internal/zzaqo;

    iput-boolean p8, p0, Lcom/google/android/gms/internal/zzaqj$1;->bqb:Z

    invoke-direct {p0, p2, p3, p4}, Lcom/google/android/gms/internal/zzaqj$zzb;-><init>(Ljava/lang/String;ZZ)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqj$1;->bqc:Lcom/google/android/gms/internal/zzaqj;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpY:Lcom/google/android/gms/internal/zzaos;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpZ:Ljava/lang/reflect/Field;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzaqj$1;->bqa:Lcom/google/android/gms/internal/zzaqo;

    invoke-static {v0, v1, v2, v3}, Lcom/google/android/gms/internal/zzaqj;->zza(Lcom/google/android/gms/internal/zzaqj;Lcom/google/android/gms/internal/zzaos;Ljava/lang/reflect/Field;Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpX:Lcom/google/android/gms/internal/zzapk;

    return-void
.end method


# virtual methods
.method zza(Lcom/google/android/gms/internal/zzaqp;Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpX:Lcom/google/android/gms/internal/zzapk;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzapk;->zzb(Lcom/google/android/gms/internal/zzaqp;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    iget-boolean v1, p0, Lcom/google/android/gms/internal/zzaqj$1;->bqb:Z

    if-nez v1, :cond_1

    :cond_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpZ:Ljava/lang/reflect/Field;

    invoke-virtual {v1, p2, v0}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_1
    return-void
.end method

.method zza(Lcom/google/android/gms/internal/zzaqr;Ljava/lang/Object;)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpZ:Ljava/lang/reflect/Field;

    invoke-virtual {v0, p2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/zzaqm;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpY:Lcom/google/android/gms/internal/zzaos;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpX:Lcom/google/android/gms/internal/zzapk;

    iget-object v4, p0, Lcom/google/android/gms/internal/zzaqj$1;->bqa:Lcom/google/android/gms/internal/zzaqo;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzaqo;->bC()Ljava/lang/reflect/Type;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/google/android/gms/internal/zzaqm;-><init>(Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzapk;Ljava/lang/reflect/Type;)V

    invoke-virtual {v1, p1, v0}, Lcom/google/android/gms/internal/zzapk;->zza(Lcom/google/android/gms/internal/zzaqr;Ljava/lang/Object;)V

    return-void
.end method

.method public zzcs(Ljava/lang/Object;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    const/4 v0, 0x0

    iget-boolean v1, p0, Lcom/google/android/gms/internal/zzaqj$1;->bqe:Z

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/google/android/gms/internal/zzaqj$1;->bpZ:Ljava/lang/reflect/Field;

    invoke-virtual {v1, p1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eq v1, p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method
