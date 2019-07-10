.class public Lio/vov/vitamio/Vitamio;
.super Ljava/lang/Object;
.source "Vitamio.java"


# static fields
.field private static vitamioLibraryPath:Ljava/lang/String;

.field private static vitamioPackage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final getLibraryPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    sget-object v0, Lio/vov/vitamio/Vitamio;->vitamioLibraryPath:Ljava/lang/String;

    return-object v0
.end method

.method public static getVitamioPackage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lio/vov/vitamio/Vitamio;->vitamioPackage:Ljava/lang/String;

    return-object v0
.end method

.method public static isInitialized(Landroid/content/Context;)Z
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;

    .prologue
    .line 44
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lio/vov/vitamio/Vitamio;->vitamioPackage:Ljava/lang/String;

    .line 45
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lio/vov/vitamio/utils/ContextUtils;->getDataDir(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "lib/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lio/vov/vitamio/Vitamio;->vitamioLibraryPath:Ljava/lang/String;

    .line 46
    const/4 v0, 0x1

    return v0
.end method
