.class Lcom/facebook/react/shell/MainReactPackage$16;
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
    .line 227
    iput-object p1, p0, Lcom/facebook/react/shell/MainReactPackage$16;->this$0:Lcom/facebook/react/shell/MainReactPackage;

    iput-object p2, p0, Lcom/facebook/react/shell/MainReactPackage$16;->val$context:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/facebook/react/bridge/NativeModule;
    .locals 2

    .prologue
    .line 230
    new-instance v0, Lcom/facebook/react/animated/NativeAnimatedModule;

    iget-object v1, p0, Lcom/facebook/react/shell/MainReactPackage$16;->val$context:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-direct {v0, v1}, Lcom/facebook/react/animated/NativeAnimatedModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 227
    invoke-virtual {p0}, Lcom/facebook/react/shell/MainReactPackage$16;->get()Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    return-object v0
.end method
