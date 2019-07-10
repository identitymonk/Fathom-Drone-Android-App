.class public Lcom/google/firebase/appindexing/internal/zzg;
.super Ljava/lang/Object;


# direct methods
.method public static zzbi(I)Z
    .locals 1

    const-string v0, "FirebaseAppIndex"

    invoke-static {v0, p0}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "FirebaseAppIndex"

    invoke-static {v0, p0}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static zzrr(Ljava/lang/String;)I
    .locals 1

    const/4 v0, 0x3

    invoke-static {v0}, Lcom/google/firebase/appindexing/internal/zzg;->zzbi(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "FirebaseAppIndex"

    invoke-static {v0, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
