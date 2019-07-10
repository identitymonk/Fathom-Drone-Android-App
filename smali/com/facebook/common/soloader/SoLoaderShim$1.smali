.class final Lcom/facebook/common/soloader/SoLoaderShim$1;
.super Ljava/lang/Object;
.source "SoLoaderShim.java"

# interfaces
.implements Lcom/facebook/common/soloader/SoLoaderShim$Handler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/common/soloader/SoLoaderShim;->setInTestMode()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadLibrary(Ljava/lang/String;)V
    .locals 0
    .param p1, "libraryName"    # Ljava/lang/String;

    .prologue
    .line 64
    return-void
.end method
