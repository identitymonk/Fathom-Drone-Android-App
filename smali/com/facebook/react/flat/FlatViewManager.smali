.class abstract Lcom/facebook/react/flat/FlatViewManager;
.super Lcom/facebook/react/uimanager/ViewGroupManager;
.source "FlatViewManager.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/ViewGroupManager",
        "<",
        "Lcom/facebook/react/flat/FlatViewGroup;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/facebook/react/uimanager/ViewGroupManager;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic createViewInstance(Lcom/facebook/react/uimanager/ThemedReactContext;)Landroid/view/View;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatViewManager;->createViewInstance(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/facebook/react/flat/FlatViewGroup;

    move-result-object v0

    return-object v0
.end method

.method protected createViewInstance(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/facebook/react/flat/FlatViewGroup;
    .locals 1
    .param p1, "reactContext"    # Lcom/facebook/react/uimanager/ThemedReactContext;

    .prologue
    .line 19
    new-instance v0, Lcom/facebook/react/flat/FlatViewGroup;

    invoke-direct {v0, p1}, Lcom/facebook/react/flat/FlatViewGroup;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public bridge synthetic removeAllViews(Landroid/view/ViewGroup;)V
    .locals 0

    .prologue
    .line 15
    check-cast p1, Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatViewManager;->removeAllViews(Lcom/facebook/react/flat/FlatViewGroup;)V

    return-void
.end method

.method public removeAllViews(Lcom/facebook/react/flat/FlatViewGroup;)V
    .locals 0
    .param p1, "parent"    # Lcom/facebook/react/flat/FlatViewGroup;

    .prologue
    .line 29
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatViewGroup;->removeAllViewsInLayout()V

    .line 30
    return-void
.end method

.method public bridge synthetic setBackgroundColor(Landroid/view/View;I)V
    .locals 0

    .prologue
    .line 15
    check-cast p1, Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/flat/FlatViewManager;->setBackgroundColor(Lcom/facebook/react/flat/FlatViewGroup;I)V

    return-void
.end method

.method public setBackgroundColor(Lcom/facebook/react/flat/FlatViewGroup;I)V
    .locals 0
    .param p1, "view"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "backgroundColor"    # I

    .prologue
    .line 25
    return-void
.end method
