.class public Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
.super Ljava/lang/Object;
.source "CatalystInstanceImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/bridge/CatalystInstanceImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private mJSBundleLoader:Lcom/facebook/react/bridge/JSBundleLoader;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mJSExecutor:Lcom/facebook/react/bridge/JavaScriptExecutor;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mNativeModuleCallExceptionHandler:Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mReactQueueConfigurationSpec:Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mRegistry:Lcom/facebook/react/bridge/NativeModuleRegistry;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 544
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build()Lcom/facebook/react/bridge/CatalystInstanceImpl;
    .locals 7

    .prologue
    .line 580
    new-instance v0, Lcom/facebook/react/bridge/CatalystInstanceImpl;

    iget-object v1, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mReactQueueConfigurationSpec:Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;

    .line 581
    invoke-static {v1}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;

    iget-object v2, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mJSExecutor:Lcom/facebook/react/bridge/JavaScriptExecutor;

    .line 582
    invoke-static {v2}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/bridge/JavaScriptExecutor;

    iget-object v3, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mRegistry:Lcom/facebook/react/bridge/NativeModuleRegistry;

    .line 583
    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/bridge/NativeModuleRegistry;

    iget-object v4, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mJSBundleLoader:Lcom/facebook/react/bridge/JSBundleLoader;

    .line 584
    invoke-static {v4}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/facebook/react/bridge/JSBundleLoader;

    iget-object v5, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mNativeModuleCallExceptionHandler:Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;

    .line 585
    invoke-static {v5}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;

    const/4 v6, 0x0

    invoke-direct/range {v0 .. v6}, Lcom/facebook/react/bridge/CatalystInstanceImpl;-><init>(Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;Lcom/facebook/react/bridge/JavaScriptExecutor;Lcom/facebook/react/bridge/NativeModuleRegistry;Lcom/facebook/react/bridge/JSBundleLoader;Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;Lcom/facebook/react/bridge/CatalystInstanceImpl$1;)V

    return-object v0
.end method

.method public setJSBundleLoader(Lcom/facebook/react/bridge/JSBundleLoader;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    .locals 0
    .param p1, "jsBundleLoader"    # Lcom/facebook/react/bridge/JSBundleLoader;

    .prologue
    .line 564
    iput-object p1, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mJSBundleLoader:Lcom/facebook/react/bridge/JSBundleLoader;

    .line 565
    return-object p0
.end method

.method public setJSExecutor(Lcom/facebook/react/bridge/JavaScriptExecutor;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    .locals 0
    .param p1, "jsExecutor"    # Lcom/facebook/react/bridge/JavaScriptExecutor;

    .prologue
    .line 569
    iput-object p1, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mJSExecutor:Lcom/facebook/react/bridge/JavaScriptExecutor;

    .line 570
    return-object p0
.end method

.method public setNativeModuleCallExceptionHandler(Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    .locals 0
    .param p1, "handler"    # Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;

    .prologue
    .line 575
    iput-object p1, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mNativeModuleCallExceptionHandler:Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;

    .line 576
    return-object p0
.end method

.method public setReactQueueConfigurationSpec(Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    .locals 0
    .param p1, "ReactQueueConfigurationSpec"    # Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;

    .prologue
    .line 554
    iput-object p1, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mReactQueueConfigurationSpec:Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;

    .line 555
    return-object p0
.end method

.method public setRegistry(Lcom/facebook/react/bridge/NativeModuleRegistry;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    .locals 0
    .param p1, "registry"    # Lcom/facebook/react/bridge/NativeModuleRegistry;

    .prologue
    .line 559
    iput-object p1, p0, Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;->mRegistry:Lcom/facebook/react/bridge/NativeModuleRegistry;

    .line 560
    return-object p0
.end method
