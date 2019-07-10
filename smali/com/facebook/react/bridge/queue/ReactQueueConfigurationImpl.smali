.class public Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;
.super Ljava/lang/Object;
.source "ReactQueueConfigurationImpl.java"

# interfaces
.implements Lcom/facebook/react/bridge/queue/ReactQueueConfiguration;


# instance fields
.field private final mJSQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

.field private final mNativeModulesQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

.field private final mUIBackgroundQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mUIQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;


# direct methods
.method private constructor <init>(Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;)V
    .locals 0
    .param p1, "uiQueueThread"    # Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;
    .param p2, "uiBackgroundQueueThread"    # Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "nativeModulesQueueThread"    # Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;
    .param p4, "jsQueueThread"    # Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mUIQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    .line 33
    iput-object p2, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mUIBackgroundQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    .line 34
    iput-object p3, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mNativeModulesQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    .line 35
    iput-object p4, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mJSQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    .line 36
    return-void
.end method

.method public static create(Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;Lcom/facebook/react/bridge/queue/QueueThreadExceptionHandler;)Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;
    .locals 7
    .param p0, "spec"    # Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;
    .param p1, "exceptionHandler"    # Lcom/facebook/react/bridge/queue/QueueThreadExceptionHandler;

    .prologue
    .line 78
    invoke-static {}, Lcom/facebook/react/common/MapBuilder;->newHashMap()Ljava/util/HashMap;

    move-result-object v2

    .line 80
    .local v2, "specsToThreads":Ljava/util/Map;, "Ljava/util/Map<Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;>;"
    invoke-static {}, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;->mainThreadSpec()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    move-result-object v5

    .line 82
    .local v5, "uiThreadSpec":Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;
    invoke-static {v5, p1}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->create(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;Lcom/facebook/react/bridge/queue/QueueThreadExceptionHandler;)Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    move-result-object v4

    .line 83
    .local v4, "uiThread":Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;
    invoke-interface {v2, v5, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    invoke-virtual {p0}, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;->getJSQueueThreadSpec()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    .line 86
    .local v0, "jsThread":Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;
    if-nez v0, :cond_0

    .line 87
    invoke-virtual {p0}, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;->getJSQueueThreadSpec()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    move-result-object v6

    invoke-static {v6, p1}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->create(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;Lcom/facebook/react/bridge/queue/QueueThreadExceptionHandler;)Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    move-result-object v0

    .line 91
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;->getNativeModulesQueueThreadSpec()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    .line 92
    .local v1, "nativeModulesThread":Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;
    if-nez v1, :cond_1

    .line 94
    invoke-virtual {p0}, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;->getNativeModulesQueueThreadSpec()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    move-result-object v6

    invoke-static {v6, p1}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->create(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;Lcom/facebook/react/bridge/queue/QueueThreadExceptionHandler;)Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    move-result-object v1

    .line 98
    :cond_1
    invoke-virtual {p0}, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;->getUIBackgroundQueueThreadSpec()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    .line 99
    .local v3, "uiBackgroundThread":Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;
    if-nez v3, :cond_2

    invoke-virtual {p0}, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;->getUIBackgroundQueueThreadSpec()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 101
    invoke-virtual {p0}, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;->getUIBackgroundQueueThreadSpec()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    move-result-object v6

    invoke-static {v6, p1}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->create(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;Lcom/facebook/react/bridge/queue/QueueThreadExceptionHandler;)Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    move-result-object v3

    .line 104
    :cond_2
    new-instance v6, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;

    invoke-direct {v6, v4, v3, v1, v0}, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;-><init>(Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;)V

    return-object v6
.end method


# virtual methods
.method public destroy()V
    .locals 2

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mUIBackgroundQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mUIBackgroundQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    .line 64
    invoke-virtual {v0}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 65
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mUIBackgroundQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    invoke-virtual {v0}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->quitSynchronous()V

    .line 67
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mNativeModulesQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    invoke-virtual {v0}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_1

    .line 68
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mNativeModulesQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    invoke-virtual {v0}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->quitSynchronous()V

    .line 70
    :cond_1
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mJSQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    invoke-virtual {v0}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_2

    .line 71
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mJSQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    invoke-virtual {v0}, Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;->quitSynchronous()V

    .line 73
    :cond_2
    return-void
.end method

.method public getJSQueueThread()Lcom/facebook/react/bridge/queue/MessageQueueThread;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mJSQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    return-object v0
.end method

.method public getNativeModulesQueueThread()Lcom/facebook/react/bridge/queue/MessageQueueThread;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mNativeModulesQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    return-object v0
.end method

.method public getUIBackgroundQueueThread()Lcom/facebook/react/bridge/queue/MessageQueueThread;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 45
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mUIBackgroundQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    return-object v0
.end method

.method public getUIQueueThread()Lcom/facebook/react/bridge/queue/MessageQueueThread;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;->mUIQueueThread:Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;

    return-object v0
.end method
