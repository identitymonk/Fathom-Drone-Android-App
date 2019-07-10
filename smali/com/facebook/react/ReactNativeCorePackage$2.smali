.class Lcom/facebook/react/ReactNativeCorePackage$2;
.super Ljava/lang/Object;
.source "ReactNativeCorePackage.java"

# interfaces
.implements Lcom/facebook/react/uimanager/UIManagerModule$ViewManagerResolver;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/ReactNativeCorePackage;->createUIManager(Lcom/facebook/react/bridge/ReactApplicationContext;)Lcom/facebook/react/uimanager/UIManagerModule;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/ReactNativeCorePackage;


# direct methods
.method constructor <init>(Lcom/facebook/react/ReactNativeCorePackage;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/ReactNativeCorePackage;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/facebook/react/ReactNativeCorePackage$2;->this$0:Lcom/facebook/react/ReactNativeCorePackage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getViewManager(Ljava/lang/String;)Lcom/facebook/react/uimanager/ViewManager;
    .locals 1
    .param p1, "viewManagerName"    # Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 90
    iget-object v0, p0, Lcom/facebook/react/ReactNativeCorePackage$2;->this$0:Lcom/facebook/react/ReactNativeCorePackage;

    invoke-static {v0}, Lcom/facebook/react/ReactNativeCorePackage;->access$100(Lcom/facebook/react/ReactNativeCorePackage;)Lcom/facebook/react/ReactInstanceManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/ReactInstanceManager;->createViewManager(Ljava/lang/String;)Lcom/facebook/react/uimanager/ViewManager;

    move-result-object v0

    return-object v0
.end method

.method public getViewManagerNames()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 95
    iget-object v0, p0, Lcom/facebook/react/ReactNativeCorePackage$2;->this$0:Lcom/facebook/react/ReactNativeCorePackage;

    invoke-static {v0}, Lcom/facebook/react/ReactNativeCorePackage;->access$100(Lcom/facebook/react/ReactNativeCorePackage;)Lcom/facebook/react/ReactInstanceManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/react/ReactInstanceManager;->getViewManagerNames()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
