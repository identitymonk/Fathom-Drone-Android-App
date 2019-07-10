.class Lcom/facebook/react/shell/MainReactPackage$9;
.super Ljava/lang/Object;
.source "MainReactPackage.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/shell/MainReactPackage;->getNativeModules(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/util/List;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/facebook/react/bridge/NativeModule;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/shell/MainReactPackage;

.field final synthetic val$context:Lcom/facebook/react/bridge/ReactApplicationContext;


# direct methods
.method constructor <init>(Lcom/facebook/react/shell/MainReactPackage;Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/shell/MainReactPackage;

    .prologue
    .line 170
    iput-object p1, p0, Lcom/facebook/react/shell/MainReactPackage$9;->this$0:Lcom/facebook/react/shell/MainReactPackage;

    iput-object p2, p0, Lcom/facebook/react/shell/MainReactPackage$9;->val$context:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/facebook/react/bridge/NativeModule;
    .locals 4

    .prologue
    .line 173
    new-instance v1, Lcom/facebook/react/modules/fresco/FrescoModule;

    iget-object v2, p0, Lcom/facebook/react/shell/MainReactPackage$9;->val$context:Lcom/facebook/react/bridge/ReactApplicationContext;

    const/4 v3, 0x1

    iget-object v0, p0, Lcom/facebook/react/shell/MainReactPackage$9;->this$0:Lcom/facebook/react/shell/MainReactPackage;

    .line 174
    invoke-static {v0}, Lcom/facebook/react/shell/MainReactPackage;->access$000(Lcom/facebook/react/shell/MainReactPackage;)Lcom/facebook/react/shell/MainPackageConfig;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/shell/MainReactPackage$9;->this$0:Lcom/facebook/react/shell/MainReactPackage;

    invoke-static {v0}, Lcom/facebook/react/shell/MainReactPackage;->access$000(Lcom/facebook/react/shell/MainReactPackage;)Lcom/facebook/react/shell/MainPackageConfig;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/react/shell/MainPackageConfig;->getFrescoConfig()Lcom/facebook/imagepipeline/core/ImagePipelineConfig;

    move-result-object v0

    :goto_0
    invoke-direct {v1, v2, v3, v0}, Lcom/facebook/react/modules/fresco/FrescoModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;ZLcom/facebook/imagepipeline/core/ImagePipelineConfig;)V

    return-object v1

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 170
    invoke-virtual {p0}, Lcom/facebook/react/shell/MainReactPackage$9;->get()Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    return-object v0
.end method
