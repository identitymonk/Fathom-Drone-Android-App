.class public final Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/firebase/appindexing/Indexable$Metadata;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# static fields
.field private static final aWw:Lcom/google/android/gms/internal/zzase$zza;


# instance fields
.field private aWx:Z

.field private aWy:Ljava/lang/String;

.field private zzavt:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/zzase$zza;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzase$zza;-><init>()V

    sput-object v0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->aWw:Lcom/google/android/gms/internal/zzase$zza;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->aWw:Lcom/google/android/gms/internal/zzase$zza;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/zzase$zza;->btZ:Z

    iput-boolean v0, p0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->aWx:Z

    sget-object v0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->aWw:Lcom/google/android/gms/internal/zzase$zza;

    iget v0, v0, Lcom/google/android/gms/internal/zzase$zza;->score:I

    iput v0, p0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->zzavt:I

    sget-object v0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->aWw:Lcom/google/android/gms/internal/zzase$zza;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzase$zza;->bua:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->aWy:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public setScore(I)Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;
    .locals 3

    if-ltz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    const/16 v2, 0x35

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v2, "Negative score values are invalid. Value: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/zzaa;->zzb(ZLjava/lang/Object;)V

    iput p1, p0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->zzavt:I

    return-object p0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setWorksOffline(Z)Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;
    .locals 0

    iput-boolean p1, p0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->aWx:Z

    return-object p0
.end method

.method public zzcnz()Lcom/google/firebase/appindexing/internal/Thing$Metadata;
    .locals 4

    new-instance v0, Lcom/google/firebase/appindexing/internal/Thing$Metadata;

    iget-boolean v1, p0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->aWx:Z

    iget v2, p0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->zzavt:I

    iget-object v3, p0, Lcom/google/firebase/appindexing/Indexable$Metadata$Builder;->aWy:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3}, Lcom/google/firebase/appindexing/internal/Thing$Metadata;-><init>(ZILjava/lang/String;)V

    return-object v0
.end method
