.class Lcom/facebook/react/uimanager/UIManagerModule$2$1;
.super Lcom/facebook/react/bridge/GuardedRunnable;
.source "UIManagerModule.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/uimanager/UIManagerModule$2;->onSizeChanged(IIII)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/facebook/react/uimanager/UIManagerModule$2;

.field final synthetic val$height:I

.field final synthetic val$width:I


# direct methods
.method constructor <init>(Lcom/facebook/react/uimanager/UIManagerModule$2;Lcom/facebook/react/bridge/ReactContext;II)V
    .locals 0
    .param p1, "this$1"    # Lcom/facebook/react/uimanager/UIManagerModule$2;
    .param p2, "reactContext"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    .line 306
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIManagerModule$2$1;->this$1:Lcom/facebook/react/uimanager/UIManagerModule$2;

    iput p3, p0, Lcom/facebook/react/uimanager/UIManagerModule$2$1;->val$width:I

    iput p4, p0, Lcom/facebook/react/uimanager/UIManagerModule$2$1;->val$height:I

    invoke-direct {p0, p2}, Lcom/facebook/react/bridge/GuardedRunnable;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    return-void
.end method


# virtual methods
.method public runGuarded()V
    .locals 4

    .prologue
    .line 309
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIManagerModule$2$1;->this$1:Lcom/facebook/react/uimanager/UIManagerModule$2;

    iget-object v0, v0, Lcom/facebook/react/uimanager/UIManagerModule$2;->this$0:Lcom/facebook/react/uimanager/UIManagerModule;

    iget-object v1, p0, Lcom/facebook/react/uimanager/UIManagerModule$2$1;->this$1:Lcom/facebook/react/uimanager/UIManagerModule$2;

    iget v1, v1, Lcom/facebook/react/uimanager/UIManagerModule$2;->val$tag:I

    iget v2, p0, Lcom/facebook/react/uimanager/UIManagerModule$2$1;->val$width:I

    iget v3, p0, Lcom/facebook/react/uimanager/UIManagerModule$2$1;->val$height:I

    invoke-virtual {v0, v1, v2, v3}, Lcom/facebook/react/uimanager/UIManagerModule;->updateNodeSize(III)V

    .line 310
    return-void
.end method
