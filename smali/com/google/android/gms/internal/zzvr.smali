.class public Lcom/google/android/gms/internal/zzvr;
.super Ljava/lang/Object;


# instance fields
.field private final zzbcp:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gms/internal/zzvq;",
            ">;"
        }
    .end annotation
.end field

.field private final zzbcq:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gms/internal/zzvq$zzd;",
            ">;"
        }
    .end annotation
.end field

.field private final zzbcr:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gms/internal/zzvq$zzd;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzvr;->zzbcp:Ljava/util/Collection;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzvr;->zzbcq:Ljava/util/Collection;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzvr;->zzbcr:Ljava/util/Collection;

    return-void
.end method

.method public static initialize(Landroid/content/Context;)V
    .locals 1

    invoke-static {}, Lcom/google/android/gms/internal/zzvu;->zzbhf()Lcom/google/android/gms/internal/zzvs;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/zzvs;->initialize(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzvq;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzvr;->zzbcp:Ljava/util/Collection;

    invoke-interface {v0, p1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    return-void
.end method
