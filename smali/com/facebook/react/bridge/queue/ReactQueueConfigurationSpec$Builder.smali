.class public Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;
.super Ljava/lang/Object;
.source "ReactQueueConfigurationSpec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private mJSQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mNativeModulesQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mUIBackgroundQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build()Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;
    .locals 5

    .prologue
    .line 108
    new-instance v2, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;

    iget-object v3, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;->mUIBackgroundQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;->mNativeModulesQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    .line 110
    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    iget-object v1, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;->mJSQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    .line 111
    invoke-static {v1}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    const/4 v4, 0x0

    invoke-direct {v2, v3, v0, v1, v4}, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;-><init>(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$1;)V

    return-object v2
.end method

.method public setJSQueueThreadSpec(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;)Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;
    .locals 2
    .param p1, "spec"    # Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;->mJSQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v1, "Setting JS queue multiple times!"

    invoke-static {v0, v1}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(ZLjava/lang/String;)V

    .line 103
    iput-object p1, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;->mJSQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    .line 104
    return-object p0

    .line 102
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setNativeModulesQueueThreadSpec(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;)Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;
    .locals 2
    .param p1, "spec"    # Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;->mNativeModulesQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v1, "Setting native modules queue spec multiple times!"

    invoke-static {v0, v1}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(ZLjava/lang/String;)V

    .line 97
    iput-object p1, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;->mNativeModulesQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    .line 98
    return-object p0

    .line 94
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setUIBackgroundQueueThreadSpec(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;)Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;
    .locals 2
    .param p1, "spec"    # Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;->mUIBackgroundQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v1, "Setting UI background queue multiple times!"

    invoke-static {v0, v1}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(ZLjava/lang/String;)V

    .line 89
    iput-object p1, p0, Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;->mUIBackgroundQueueSpec:Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;

    .line 90
    return-object p0

    .line 86
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
