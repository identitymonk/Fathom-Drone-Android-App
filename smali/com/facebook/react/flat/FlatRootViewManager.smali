.class Lcom/facebook/react/flat/FlatRootViewManager;
.super Lcom/facebook/react/uimanager/RootViewManager;
.source "FlatRootViewManager.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/facebook/react/uimanager/RootViewManager;-><init>()V

    return-void
.end method


# virtual methods
.method public removeAllViews(Landroid/view/ViewGroup;)V
    .locals 0
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 20
    invoke-virtual {p1}, Landroid/view/ViewGroup;->removeAllViewsInLayout()V

    .line 21
    return-void
.end method
