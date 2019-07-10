.class Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;
.super Ljava/lang/Object;
.source "NativeViewHierarchyManager.java"

# interfaces
.implements Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->manageChildren(I[I[Lcom/facebook/react/uimanager/ViewAtIndex;[I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

.field final synthetic val$viewManager:Lcom/facebook/react/uimanager/ViewGroupManager;

.field final synthetic val$viewToDestroy:Landroid/view/View;

.field final synthetic val$viewToManage:Landroid/view/ViewGroup;


# direct methods
.method constructor <init>(Lcom/facebook/react/uimanager/NativeViewHierarchyManager;Lcom/facebook/react/uimanager/ViewGroupManager;Landroid/view/ViewGroup;Landroid/view/View;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    .prologue
    .line 423
    iput-object p1, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;->this$0:Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    iput-object p2, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;->val$viewManager:Lcom/facebook/react/uimanager/ViewGroupManager;

    iput-object p3, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;->val$viewToManage:Landroid/view/ViewGroup;

    iput-object p4, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;->val$viewToDestroy:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd()V
    .locals 3

    .prologue
    .line 426
    iget-object v0, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;->val$viewManager:Lcom/facebook/react/uimanager/ViewGroupManager;

    iget-object v1, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;->val$viewToManage:Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;->val$viewToDestroy:Landroid/view/View;

    invoke-virtual {v0, v1, v2}, Lcom/facebook/react/uimanager/ViewGroupManager;->removeView(Landroid/view/ViewGroup;Landroid/view/View;)V

    .line 427
    iget-object v0, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;->this$0:Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    iget-object v1, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyManager$1;->val$viewToDestroy:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->dropView(Landroid/view/View;)V

    .line 428
    return-void
.end method
