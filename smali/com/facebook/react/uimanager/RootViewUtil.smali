.class public Lcom/facebook/react/uimanager/RootViewUtil;
.super Ljava/lang/Object;
.source "RootViewUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getRootView(Landroid/view/View;)Lcom/facebook/react/uimanager/RootView;
    .locals 3
    .param p0, "reactView"    # Landroid/view/View;

    .prologue
    .line 23
    move-object v0, p0

    .line 25
    .local v0, "current":Landroid/view/View;
    :goto_0
    instance-of v2, v0, Lcom/facebook/react/uimanager/RootView;

    if-eqz v2, :cond_0

    .line 26
    check-cast v0, Lcom/facebook/react/uimanager/RootView;

    .line 30
    .end local v0    # "current":Landroid/view/View;
    :goto_1
    return-object v0

    .line 28
    .restart local v0    # "current":Landroid/view/View;
    :cond_0
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    .line 29
    .local v1, "next":Landroid/view/ViewParent;
    if-nez v1, :cond_1

    .line 30
    const/4 v0, 0x0

    goto :goto_1

    .line 32
    :cond_1
    instance-of v2, v1, Landroid/view/View;

    invoke-static {v2}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(Z)V

    move-object v0, v1

    .line 33
    check-cast v0, Landroid/view/View;

    .line 34
    goto :goto_0
.end method
