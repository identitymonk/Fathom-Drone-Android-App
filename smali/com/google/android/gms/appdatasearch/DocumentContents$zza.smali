.class public Lcom/google/android/gms/appdatasearch/DocumentContents$zza;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/appdatasearch/DocumentContents;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "zza"
.end annotation


# instance fields
.field private gg:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/appdatasearch/DocumentSection;",
            ">;"
        }
    .end annotation
.end field

.field private gh:Ljava/lang/String;

.field private gi:Z

.field private gj:Landroid/accounts/Account;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/appdatasearch/DocumentSection;)Lcom/google/android/gms/appdatasearch/DocumentContents$zza;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gg:Ljava/util/List;

    if-nez v0, :cond_0

    if-eqz p1, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gg:Ljava/util/List;

    :cond_0
    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gg:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1
    return-object p0
.end method

.method public zzaho()Lcom/google/android/gms/appdatasearch/DocumentContents;
    .locals 6

    new-instance v1, Lcom/google/android/gms/appdatasearch/DocumentContents;

    iget-object v2, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gh:Ljava/lang/String;

    iget-boolean v3, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gi:Z

    iget-object v4, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gj:Landroid/accounts/Account;

    iget-object v0, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gg:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gg:Ljava/util/List;

    iget-object v5, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gg:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    new-array v5, v5, [Lcom/google/android/gms/appdatasearch/DocumentSection;

    invoke-interface {v0, v5}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/android/gms/appdatasearch/DocumentSection;

    :goto_0
    invoke-direct {v1, v2, v3, v4, v0}, Lcom/google/android/gms/appdatasearch/DocumentContents;-><init>(Ljava/lang/String;ZLandroid/accounts/Account;[Lcom/google/android/gms/appdatasearch/DocumentSection;)V

    return-object v1

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public zzay(Z)Lcom/google/android/gms/appdatasearch/DocumentContents$zza;
    .locals 0

    iput-boolean p1, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gi:Z

    return-object p0
.end method

.method public zzb(Landroid/accounts/Account;)Lcom/google/android/gms/appdatasearch/DocumentContents$zza;
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gj:Landroid/accounts/Account;

    return-object p0
.end method

.method public zzfp(Ljava/lang/String;)Lcom/google/android/gms/appdatasearch/DocumentContents$zza;
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/appdatasearch/DocumentContents$zza;->gh:Ljava/lang/String;

    return-object p0
.end method
