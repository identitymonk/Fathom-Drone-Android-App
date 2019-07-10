.class Lcom/facebook/react/uimanager/ViewGroupDrawingOrderHelper$1;
.super Ljava/lang/Object;
.source "ViewGroupDrawingOrderHelper.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/uimanager/ViewGroupDrawingOrderHelper;->getChildDrawingOrder(II)I
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Landroid/view/View;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/uimanager/ViewGroupDrawingOrderHelper;


# direct methods
.method constructor <init>(Lcom/facebook/react/uimanager/ViewGroupDrawingOrderHelper;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/uimanager/ViewGroupDrawingOrderHelper;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/facebook/react/uimanager/ViewGroupDrawingOrderHelper$1;->this$0:Lcom/facebook/react/uimanager/ViewGroupDrawingOrderHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Landroid/view/View;Landroid/view/View;)I
    .locals 4
    .param p1, "view1"    # Landroid/view/View;
    .param p2, "view2"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 81
    invoke-static {p1}, Lcom/facebook/react/uimanager/ViewGroupManager;->getViewZIndex(Landroid/view/View;)Ljava/lang/Integer;

    move-result-object v0

    .line 82
    .local v0, "view1ZIndex":Ljava/lang/Integer;
    if-nez v0, :cond_0

    .line 83
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 86
    :cond_0
    invoke-static {p2}, Lcom/facebook/react/uimanager/ViewGroupManager;->getViewZIndex(Landroid/view/View;)Ljava/lang/Integer;

    move-result-object v1

    .line 87
    .local v1, "view2ZIndex":Ljava/lang/Integer;
    if-nez v1, :cond_1

    .line 88
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 91
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v3

    sub-int/2addr v2, v3

    return v2
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 78
    check-cast p1, Landroid/view/View;

    check-cast p2, Landroid/view/View;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/uimanager/ViewGroupDrawingOrderHelper$1;->compare(Landroid/view/View;Landroid/view/View;)I

    move-result v0

    return v0
.end method
