.class Lcom/facebook/react/ReactRootView$1;
.super Lcom/facebook/react/bridge/GuardedRunnable;
.source "ReactRootView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/ReactRootView;->updateRootLayoutSpecs(II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/ReactRootView;

.field final synthetic val$heightMeasureSpec:I

.field final synthetic val$reactApplicationContext:Lcom/facebook/react/bridge/ReactContext;

.field final synthetic val$widthMeasureSpec:I


# direct methods
.method constructor <init>(Lcom/facebook/react/ReactRootView;Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/ReactContext;II)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/ReactRootView;
    .param p2, "reactContext"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    .line 334
    iput-object p1, p0, Lcom/facebook/react/ReactRootView$1;->this$0:Lcom/facebook/react/ReactRootView;

    iput-object p3, p0, Lcom/facebook/react/ReactRootView$1;->val$reactApplicationContext:Lcom/facebook/react/bridge/ReactContext;

    iput p4, p0, Lcom/facebook/react/ReactRootView$1;->val$widthMeasureSpec:I

    iput p5, p0, Lcom/facebook/react/ReactRootView$1;->val$heightMeasureSpec:I

    invoke-direct {p0, p2}, Lcom/facebook/react/bridge/GuardedRunnable;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    return-void
.end method


# virtual methods
.method public runGuarded()V
    .locals 4

    .prologue
    .line 337
    iget-object v0, p0, Lcom/facebook/react/ReactRootView$1;->val$reactApplicationContext:Lcom/facebook/react/bridge/ReactContext;

    .line 338
    invoke-virtual {v0}, Lcom/facebook/react/bridge/ReactContext;->getCatalystInstance()Lcom/facebook/react/bridge/CatalystInstance;

    move-result-object v0

    const-class v1, Lcom/facebook/react/uimanager/UIManagerModule;

    .line 339
    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/CatalystInstance;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/UIManagerModule;

    iget-object v1, p0, Lcom/facebook/react/ReactRootView$1;->this$0:Lcom/facebook/react/ReactRootView;

    .line 340
    invoke-virtual {v1}, Lcom/facebook/react/ReactRootView;->getRootViewTag()I

    move-result v1

    iget v2, p0, Lcom/facebook/react/ReactRootView$1;->val$widthMeasureSpec:I

    iget v3, p0, Lcom/facebook/react/ReactRootView$1;->val$heightMeasureSpec:I

    invoke-virtual {v0, v1, v2, v3}, Lcom/facebook/react/uimanager/UIManagerModule;->updateRootLayoutSpecs(III)V

    .line 341
    return-void
.end method
