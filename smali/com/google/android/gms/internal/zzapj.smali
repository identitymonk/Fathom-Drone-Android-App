.class final Lcom/google/android/gms/internal/zzapj;
.super Lcom/google/android/gms/internal/zzapk;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzapj$zza;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/google/android/gms/internal/zzapk",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final boA:Lcom/google/android/gms/internal/zzapg;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzapg",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final boB:Lcom/google/android/gms/internal/zzaox;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzaox",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final boC:Lcom/google/android/gms/internal/zzaos;

.field private final boD:Lcom/google/android/gms/internal/zzaqo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzaqo",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final boE:Lcom/google/android/gms/internal/zzapl;

.field private bol:Lcom/google/android/gms/internal/zzapk;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzapk",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/zzapg;Lcom/google/android/gms/internal/zzaox;Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;Lcom/google/android/gms/internal/zzapl;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzapg",
            "<TT;>;",
            "Lcom/google/android/gms/internal/zzaox",
            "<TT;>;",
            "Lcom/google/android/gms/internal/zzaos;",
            "Lcom/google/android/gms/internal/zzaqo",
            "<TT;>;",
            "Lcom/google/android/gms/internal/zzapl;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzapk;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzapj;->boA:Lcom/google/android/gms/internal/zzapg;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzapj;->boB:Lcom/google/android/gms/internal/zzaox;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzapj;->boC:Lcom/google/android/gms/internal/zzaos;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzapj;->boD:Lcom/google/android/gms/internal/zzaqo;

    iput-object p5, p0, Lcom/google/android/gms/internal/zzapj;->boE:Lcom/google/android/gms/internal/zzapl;

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/zzapg;Lcom/google/android/gms/internal/zzaox;Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;Lcom/google/android/gms/internal/zzapl;Lcom/google/android/gms/internal/zzapj$1;)V
    .locals 0

    invoke-direct/range {p0 .. p5}, Lcom/google/android/gms/internal/zzapj;-><init>(Lcom/google/android/gms/internal/zzapg;Lcom/google/android/gms/internal/zzaox;Lcom/google/android/gms/internal/zzaos;Lcom/google/android/gms/internal/zzaqo;Lcom/google/android/gms/internal/zzapl;)V

    return-void
.end method

.method private bg()Lcom/google/android/gms/internal/zzapk;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/android/gms/internal/zzapk",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapj;->bol:Lcom/google/android/gms/internal/zzapk;

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzapj;->boC:Lcom/google/android/gms/internal/zzaos;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzapj;->boE:Lcom/google/android/gms/internal/zzapl;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzapj;->boD:Lcom/google/android/gms/internal/zzaqo;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzaos;->zza(Lcom/google/android/gms/internal/zzapl;Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzapj;->bol:Lcom/google/android/gms/internal/zzapk;

    goto :goto_0
.end method

.method public static zza(Lcom/google/android/gms/internal/zzaqo;Ljava/lang/Object;)Lcom/google/android/gms/internal/zzapl;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzaqo",
            "<*>;",
            "Ljava/lang/Object;",
            ")",
            "Lcom/google/android/gms/internal/zzapl;"
        }
    .end annotation

    const/4 v4, 0x0

    new-instance v0, Lcom/google/android/gms/internal/zzapj$zza;

    const/4 v3, 0x0

    move-object v1, p1

    move-object v2, p0

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzapj$zza;-><init>(Ljava/lang/Object;Lcom/google/android/gms/internal/zzaqo;ZLjava/lang/Class;Lcom/google/android/gms/internal/zzapj$1;)V

    return-object v0
.end method

.method public static zzb(Lcom/google/android/gms/internal/zzaqo;Ljava/lang/Object;)Lcom/google/android/gms/internal/zzapl;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzaqo",
            "<*>;",
            "Ljava/lang/Object;",
            ")",
            "Lcom/google/android/gms/internal/zzapl;"
        }
    .end annotation

    const/4 v4, 0x0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzaqo;->bC()Ljava/lang/reflect/Type;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzaqo;->bB()Ljava/lang/Class;

    move-result-object v1

    if-ne v0, v1, :cond_0

    const/4 v3, 0x1

    :goto_0
    new-instance v0, Lcom/google/android/gms/internal/zzapj$zza;

    move-object v1, p1

    move-object v2, p0

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/zzapj$zza;-><init>(Ljava/lang/Object;Lcom/google/android/gms/internal/zzaqo;ZLjava/lang/Class;Lcom/google/android/gms/internal/zzapj$1;)V

    return-object v0

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzaqr;Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzaqr;",
            "TT;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapj;->boA:Lcom/google/android/gms/internal/zzapg;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzapj;->bg()Lcom/google/android/gms/internal/zzapk;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gms/internal/zzapk;->zza(Lcom/google/android/gms/internal/zzaqr;Ljava/lang/Object;)V

    :goto_0
    return-void

    :cond_0
    if-nez p2, :cond_1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzaqr;->bA()Lcom/google/android/gms/internal/zzaqr;

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzapj;->boA:Lcom/google/android/gms/internal/zzapg;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzapj;->boD:Lcom/google/android/gms/internal/zzaqo;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzaqo;->bC()Ljava/lang/reflect/Type;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzapj;->boC:Lcom/google/android/gms/internal/zzaos;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzaos;->boj:Lcom/google/android/gms/internal/zzapf;

    invoke-interface {v0, p2, v1, v2}, Lcom/google/android/gms/internal/zzapg;->zza(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/google/android/gms/internal/zzapf;)Lcom/google/android/gms/internal/zzaoy;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/zzapz;->zzb(Lcom/google/android/gms/internal/zzaoy;Lcom/google/android/gms/internal/zzaqr;)V

    goto :goto_0
.end method

.method public zzb(Lcom/google/android/gms/internal/zzaqp;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzaqp;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzapj;->boB:Lcom/google/android/gms/internal/zzaox;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzapj;->bg()Lcom/google/android/gms/internal/zzapk;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzapk;->zzb(Lcom/google/android/gms/internal/zzaqp;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {p1}, Lcom/google/android/gms/internal/zzapz;->zzh(Lcom/google/android/gms/internal/zzaqp;)Lcom/google/android/gms/internal/zzaoy;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzaoy;->aY()Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzapj;->boB:Lcom/google/android/gms/internal/zzaox;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzapj;->boD:Lcom/google/android/gms/internal/zzaqo;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzaqo;->bC()Ljava/lang/reflect/Type;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/zzapj;->boC:Lcom/google/android/gms/internal/zzaos;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzaos;->boi:Lcom/google/android/gms/internal/zzaow;

    invoke-interface {v1, v0, v2, v3}, Lcom/google/android/gms/internal/zzaox;->zzb(Lcom/google/android/gms/internal/zzaoy;Ljava/lang/reflect/Type;Lcom/google/android/gms/internal/zzaow;)Ljava/lang/Object;
    :try_end_0
    .catch Lcom/google/android/gms/internal/zzapc; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    throw v0

    :catch_1
    move-exception v0

    new-instance v1, Lcom/google/android/gms/internal/zzapc;

    invoke-direct {v1, v0}, Lcom/google/android/gms/internal/zzapc;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
