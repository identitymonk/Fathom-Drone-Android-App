.class public Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;
.super Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final aWS:[Ljava/lang/String;

.field private final aWT:[Ljava/lang/String;

.field public final mVersionCode:I

.field private final zzae:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/firebase/appindexing/internal/zzk;

    invoke-direct {v0}, Lcom/google/firebase/appindexing/internal/zzk;-><init>()V

    sput-object v0, Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(ILjava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    iput p1, p0, Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;->mVersionCode:I

    iput-object p2, p0, Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;->zzae:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;->aWS:[Ljava/lang/String;

    iput-object p4, p0, Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;->aWT:[Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getUrl()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;->zzae:Ljava/lang/String;

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/google/firebase/appindexing/internal/zzk;->zza(Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;Landroid/os/Parcel;I)V

    return-void
.end method

.method public zzcor()[Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;->aWS:[Ljava/lang/String;

    return-object v0
.end method

.method public zzcos()[Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/appindexing/internal/UpdateTagsRequest;->aWT:[Ljava/lang/String;

    return-object v0
.end method
