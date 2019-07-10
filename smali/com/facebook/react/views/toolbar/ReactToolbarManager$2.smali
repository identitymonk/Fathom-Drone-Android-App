.class Lcom/facebook/react/views/toolbar/ReactToolbarManager$2;
.super Ljava/lang/Object;
.source "ReactToolbarManager.java"

# interfaces
.implements Landroid/support/v7/widget/Toolbar$OnMenuItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/views/toolbar/ReactToolbarManager;->addEventEmitters(Lcom/facebook/react/uimanager/ThemedReactContext;Lcom/facebook/react/views/toolbar/ReactToolbar;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/views/toolbar/ReactToolbarManager;

.field final synthetic val$mEventDispatcher:Lcom/facebook/react/uimanager/events/EventDispatcher;

.field final synthetic val$view:Lcom/facebook/react/views/toolbar/ReactToolbar;


# direct methods
.method constructor <init>(Lcom/facebook/react/views/toolbar/ReactToolbarManager;Lcom/facebook/react/uimanager/events/EventDispatcher;Lcom/facebook/react/views/toolbar/ReactToolbar;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/views/toolbar/ReactToolbarManager;

    .prologue
    .line 134
    iput-object p1, p0, Lcom/facebook/react/views/toolbar/ReactToolbarManager$2;->this$0:Lcom/facebook/react/views/toolbar/ReactToolbarManager;

    iput-object p2, p0, Lcom/facebook/react/views/toolbar/ReactToolbarManager$2;->val$mEventDispatcher:Lcom/facebook/react/uimanager/events/EventDispatcher;

    iput-object p3, p0, Lcom/facebook/react/views/toolbar/ReactToolbarManager$2;->val$view:Lcom/facebook/react/views/toolbar/ReactToolbar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 4
    .param p1, "menuItem"    # Landroid/view/MenuItem;

    .prologue
    .line 137
    iget-object v0, p0, Lcom/facebook/react/views/toolbar/ReactToolbarManager$2;->val$mEventDispatcher:Lcom/facebook/react/uimanager/events/EventDispatcher;

    new-instance v1, Lcom/facebook/react/views/toolbar/events/ToolbarClickEvent;

    iget-object v2, p0, Lcom/facebook/react/views/toolbar/ReactToolbarManager$2;->val$view:Lcom/facebook/react/views/toolbar/ReactToolbar;

    .line 139
    invoke-virtual {v2}, Lcom/facebook/react/views/toolbar/ReactToolbar;->getId()I

    move-result v2

    .line 140
    invoke-interface {p1}, Landroid/view/MenuItem;->getOrder()I

    move-result v3

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/views/toolbar/events/ToolbarClickEvent;-><init>(II)V

    .line 137
    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 141
    const/4 v0, 0x1

    return v0
.end method
