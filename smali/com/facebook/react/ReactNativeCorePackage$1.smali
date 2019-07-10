.class Lcom/facebook/react/ReactNativeCorePackage$1;
.super Ljava/lang/Object;
.source "ReactNativeCorePackage.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/ReactNativeCorePackage;->getNativeModules(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/util/List;
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
.field final synthetic this$0:Lcom/facebook/react/ReactNativeCorePackage;

.field final synthetic val$reactContext:Lcom/facebook/react/bridge/ReactApplicationContext;


# direct methods
.method constructor <init>(Lcom/facebook/react/ReactNativeCorePackage;Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/ReactNativeCorePackage;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/facebook/react/ReactNativeCorePackage$1;->this$0:Lcom/facebook/react/ReactNativeCorePackage;

    iput-object p2, p0, Lcom/facebook/react/ReactNativeCorePackage$1;->val$reactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/facebook/react/bridge/NativeModule;
    .locals 2

    .prologue
    .line 66
    iget-object v0, p0, Lcom/facebook/react/ReactNativeCorePackage$1;->this$0:Lcom/facebook/react/ReactNativeCorePackage;

    iget-object v1, p0, Lcom/facebook/react/ReactNativeCorePackage$1;->val$reactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-static {v0, v1}, Lcom/facebook/react/ReactNativeCorePackage;->access$000(Lcom/facebook/react/ReactNativeCorePackage;Lcom/facebook/react/bridge/ReactApplicationContext;)Lcom/facebook/react/uimanager/UIManagerModule;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/facebook/react/ReactNativeCorePackage$1;->get()Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    return-object v0
.end method
