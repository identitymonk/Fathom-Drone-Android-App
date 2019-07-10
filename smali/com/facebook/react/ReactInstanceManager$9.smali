.class Lcom/facebook/react/ReactInstanceManager$9;
.super Ljava/lang/Object;
.source "ReactInstanceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/ReactInstanceManager;->attachRootViewToInstance(Lcom/facebook/react/ReactRootView;Lcom/facebook/react/bridge/CatalystInstance;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/ReactInstanceManager;

.field final synthetic val$rootTag:I

.field final synthetic val$rootView:Lcom/facebook/react/ReactRootView;


# direct methods
.method constructor <init>(Lcom/facebook/react/ReactInstanceManager;ILcom/facebook/react/ReactRootView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/ReactInstanceManager;

    .prologue
    .line 1039
    iput-object p1, p0, Lcom/facebook/react/ReactInstanceManager$9;->this$0:Lcom/facebook/react/ReactInstanceManager;

    iput p2, p0, Lcom/facebook/react/ReactInstanceManager$9;->val$rootTag:I

    iput-object p3, p0, Lcom/facebook/react/ReactInstanceManager$9;->val$rootView:Lcom/facebook/react/ReactRootView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 1042
    const-wide/16 v0, 0x0

    const-string v2, "pre_rootView.onAttachedToReactInstance"

    iget v3, p0, Lcom/facebook/react/ReactInstanceManager$9;->val$rootTag:I

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/systrace/Systrace;->endAsyncSection(JLjava/lang/String;I)V

    .line 1046
    iget-object v0, p0, Lcom/facebook/react/ReactInstanceManager$9;->val$rootView:Lcom/facebook/react/ReactRootView;

    invoke-virtual {v0}, Lcom/facebook/react/ReactRootView;->onAttachedToReactInstance()V

    .line 1047
    return-void
.end method
