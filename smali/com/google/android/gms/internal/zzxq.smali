.class public final Lcom/google/android/gms/internal/zzxq;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/api/Api$ApiOptions$Optional;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzxq$zza;
    }
.end annotation


# static fields
.field public static final aDl:Lcom/google/android/gms/internal/zzxq;


# instance fields
.field private final aDm:Z

.field private final aDn:Z

.field private final aDo:Ljava/lang/Long;

.field private final aDp:Ljava/lang/Long;

.field private final jr:Z

.field private final jt:Z

.field private final ju:Ljava/lang/String;

.field private final jv:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/zzxq$zza;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzxq$zza;-><init>()V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzxq$zza;->zzcdh()Lcom/google/android/gms/internal/zzxq;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/zzxq;->aDl:Lcom/google/android/gms/internal/zzxq;

    return-void
.end method

.method private constructor <init>(ZZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p1, p0, Lcom/google/android/gms/internal/zzxq;->aDm:Z

    iput-boolean p2, p0, Lcom/google/android/gms/internal/zzxq;->jr:Z

    iput-object p3, p0, Lcom/google/android/gms/internal/zzxq;->ju:Ljava/lang/String;

    iput-boolean p4, p0, Lcom/google/android/gms/internal/zzxq;->jt:Z

    iput-boolean p6, p0, Lcom/google/android/gms/internal/zzxq;->aDn:Z

    iput-object p5, p0, Lcom/google/android/gms/internal/zzxq;->jv:Ljava/lang/String;

    iput-object p7, p0, Lcom/google/android/gms/internal/zzxq;->aDo:Ljava/lang/Long;

    iput-object p8, p0, Lcom/google/android/gms/internal/zzxq;->aDp:Ljava/lang/Long;

    return-void
.end method

.method synthetic constructor <init>(ZZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;Lcom/google/android/gms/internal/zzxq$1;)V
    .locals 0

    invoke-direct/range {p0 .. p8}, Lcom/google/android/gms/internal/zzxq;-><init>(ZZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;)V

    return-void
.end method


# virtual methods
.method public zzaiu()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzxq;->jr:Z

    return v0
.end method

.method public zzaiw()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzxq;->jt:Z

    return v0
.end method

.method public zzaix()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzxq;->ju:Ljava/lang/String;

    return-object v0
.end method

.method public zzaiy()Ljava/lang/String;
    .locals 1
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzxq;->jv:Ljava/lang/String;

    return-object v0
.end method

.method public zzcdd()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzxq;->aDm:Z

    return v0
.end method

.method public zzcde()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzxq;->aDn:Z

    return v0
.end method

.method public zzcdf()Ljava/lang/Long;
    .locals 1
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzxq;->aDo:Ljava/lang/Long;

    return-object v0
.end method

.method public zzcdg()Ljava/lang/Long;
    .locals 1
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzxq;->aDp:Ljava/lang/Long;

    return-object v0
.end method
