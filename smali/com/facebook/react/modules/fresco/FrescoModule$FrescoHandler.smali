.class Lcom/facebook/react/modules/fresco/FrescoModule$FrescoHandler;
.super Ljava/lang/Object;
.source "FrescoModule.java"

# interfaces
.implements Lcom/facebook/common/soloader/SoLoaderShim$Handler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/fresco/FrescoModule;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FrescoHandler"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 190
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/modules/fresco/FrescoModule$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/modules/fresco/FrescoModule$1;

    .prologue
    .line 190
    invoke-direct {p0}, Lcom/facebook/react/modules/fresco/FrescoModule$FrescoHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public loadLibrary(Ljava/lang/String;)V
    .locals 0
    .param p1, "libraryName"    # Ljava/lang/String;

    .prologue
    .line 193
    invoke-static {p1}, Lcom/facebook/soloader/SoLoader;->loadLibrary(Ljava/lang/String;)V

    .line 194
    return-void
.end method
