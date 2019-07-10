.class public final Lcom/google/android/gms/appdatasearch/UsageInfo$zza;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/appdatasearch/UsageInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "zza"
.end annotation


# instance fields
.field private gR:Lcom/google/android/gms/appdatasearch/DocumentId;

.field private gS:J

.field private gT:I

.field private gU:Lcom/google/android/gms/appdatasearch/DocumentContents;

.field private gV:Z

.field private gW:I

.field private gX:I


# direct methods
.method public constructor <init>()V
    .locals 4

    const/4 v3, 0x0

    const/4 v2, -0x1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gS:J

    iput v2, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gT:I

    iput v2, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gW:I

    iput-boolean v3, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gV:Z

    iput v3, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gX:I

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/appdatasearch/DocumentContents;)Lcom/google/android/gms/appdatasearch/UsageInfo$zza;
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gU:Lcom/google/android/gms/appdatasearch/DocumentContents;

    return-object p0
.end method

.method public zza(Lcom/google/android/gms/appdatasearch/DocumentId;)Lcom/google/android/gms/appdatasearch/UsageInfo$zza;
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gR:Lcom/google/android/gms/appdatasearch/DocumentId;

    return-object p0
.end method

.method public zzaa(J)Lcom/google/android/gms/appdatasearch/UsageInfo$zza;
    .locals 1

    iput-wide p1, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gS:J

    return-object p0
.end method

.method public zzahs()Lcom/google/android/gms/appdatasearch/UsageInfo;
    .locals 11

    const/4 v5, 0x0

    new-instance v0, Lcom/google/android/gms/appdatasearch/UsageInfo;

    iget-object v1, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gR:Lcom/google/android/gms/appdatasearch/DocumentId;

    iget-wide v2, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gS:J

    iget v4, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gT:I

    iget-object v6, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gU:Lcom/google/android/gms/appdatasearch/DocumentContents;

    iget-boolean v7, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gV:Z

    iget v8, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gW:I

    iget v9, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gX:I

    move-object v10, v5

    invoke-direct/range {v0 .. v10}, Lcom/google/android/gms/appdatasearch/UsageInfo;-><init>(Lcom/google/android/gms/appdatasearch/DocumentId;JILjava/lang/String;Lcom/google/android/gms/appdatasearch/DocumentContents;ZIILcom/google/android/gms/appdatasearch/UsageInfo$1;)V

    return-object v0
.end method

.method public zzbb(Z)Lcom/google/android/gms/appdatasearch/UsageInfo$zza;
    .locals 0

    iput-boolean p1, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gV:Z

    return-object p0
.end method

.method public zzcq(I)Lcom/google/android/gms/appdatasearch/UsageInfo$zza;
    .locals 0

    iput p1, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gT:I

    return-object p0
.end method

.method public zzcr(I)Lcom/google/android/gms/appdatasearch/UsageInfo$zza;
    .locals 0

    iput p1, p0, Lcom/google/android/gms/appdatasearch/UsageInfo$zza;->gX:I

    return-object p0
.end method
