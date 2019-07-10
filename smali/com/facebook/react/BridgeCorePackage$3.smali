.class Lcom/facebook/react/BridgeCorePackage$3;
.super Ljava/lang/Object;
.source "BridgeCorePackage.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/BridgeCorePackage;->getNativeModules(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/util/List;
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
.field final synthetic this$0:Lcom/facebook/react/BridgeCorePackage;


# direct methods
.method constructor <init>(Lcom/facebook/react/BridgeCorePackage;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/BridgeCorePackage;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/facebook/react/BridgeCorePackage$3;->this$0:Lcom/facebook/react/BridgeCorePackage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/facebook/react/bridge/NativeModule;
    .locals 2

    .prologue
    .line 81
    new-instance v0, Lcom/facebook/react/modules/core/ExceptionsManagerModule;

    iget-object v1, p0, Lcom/facebook/react/BridgeCorePackage$3;->this$0:Lcom/facebook/react/BridgeCorePackage;

    invoke-static {v1}, Lcom/facebook/react/BridgeCorePackage;->access$100(Lcom/facebook/react/BridgeCorePackage;)Lcom/facebook/react/ReactInstanceManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/react/ReactInstanceManager;->getDevSupportManager()Lcom/facebook/react/devsupport/interfaces/DevSupportManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/react/modules/core/ExceptionsManagerModule;-><init>(Lcom/facebook/react/devsupport/interfaces/DevSupportManager;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 78
    invoke-virtual {p0}, Lcom/facebook/react/BridgeCorePackage$3;->get()Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    return-object v0
.end method
