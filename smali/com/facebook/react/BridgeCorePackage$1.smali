.class Lcom/facebook/react/BridgeCorePackage$1;
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
    .line 64
    iput-object p1, p0, Lcom/facebook/react/BridgeCorePackage$1;->this$0:Lcom/facebook/react/BridgeCorePackage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/facebook/react/bridge/NativeModule;
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/facebook/react/modules/systeminfo/AndroidInfoModule;

    invoke-direct {v0}, Lcom/facebook/react/modules/systeminfo/AndroidInfoModule;-><init>()V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/facebook/react/BridgeCorePackage$1;->get()Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    return-object v0
.end method
