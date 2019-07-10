.class public Lcom/google/firebase/appindexing/internal/Thing$Metadata;
.super Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/firebase/appindexing/internal/Thing;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Metadata"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/google/firebase/appindexing/internal/Thing$Metadata;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final aWx:Z

.field private aWy:Ljava/lang/String;

.field public final mVersionCode:I

.field private zzavt:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/internal/zzh;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/internal/zzh;-><init>()V

    sput-object v0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(IZILjava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    iput p1, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->mVersionCode:I

    iput-boolean p2, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWx:Z

    iput p3, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->zzavt:I

    iput-object p4, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWy:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(ZILjava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->mVersionCode:I

    iput-boolean p1, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWx:Z

    iput p2, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->zzavt:I

    iput-object p3, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWy:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3

    const/4 v0, 0x0

    instance-of v1, p1, Lcom/google/firebase/appindexing/internal/Thing$Metadata;

    if-eqz v1, :cond_0

    check-cast p1, Lcom/google/firebase/appindexing/internal/Thing$Metadata;

    iget-boolean v1, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWx:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iget-boolean v2, p1, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWx:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/android/gms/common/internal/zzz;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->zzavt:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iget v2, p1, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->zzavt:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/android/gms/common/internal/zzz;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWy:Ljava/lang/String;

    iget-object v2, p1, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWy:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/google/android/gms/common/internal/zzz;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method public getScore()I
    .locals 1

    iget v0, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->zzavt:I

    return v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-boolean v2, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWx:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget v2, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->zzavt:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWy:Ljava/lang/String;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzz;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    const-string v0, ""

    invoke-virtual {p0}, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->zzcoq()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, ", accountEmail: "

    invoke-virtual {p0}, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->zzcoq()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-eqz v2, :cond_1

    invoke-virtual {v1, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->zzcop()Z

    move-result v1

    invoke-virtual {p0}, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->getScore()I

    move-result v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, 0x27

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v4, "worksOffline: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, ", score: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_1
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/google/firebase/appindexing/internal/zzh;->zza(Lcom/google/firebase/appindexing/internal/Thing$Metadata;Landroid/os/Parcel;I)V

    return-void
.end method

.method public zzcop()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWx:Z

    return v0
.end method

.method public zzcoq()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;->aWy:Ljava/lang/String;

    return-object v0
.end method
