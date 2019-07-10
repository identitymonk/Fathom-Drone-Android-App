.class public final Lcom/facebook/react/flat/RCTTextManager;
.super Lcom/facebook/react/flat/FlatViewManager;
.source "RCTTextManager.java"


# static fields
.field static final REACT_CLASS:Ljava/lang/String; = "RCTText"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatViewManager;-><init>()V

    return-void
.end method


# virtual methods
.method public createShadowNodeInstance()Lcom/facebook/react/flat/RCTText;
    .locals 1

    .prologue
    .line 26
    new-instance v0, Lcom/facebook/react/flat/RCTText;

    invoke-direct {v0}, Lcom/facebook/react/flat/RCTText;-><init>()V

    return-object v0
.end method

.method public bridge synthetic createShadowNodeInstance()Lcom/facebook/react/uimanager/LayoutShadowNode;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextManager;->createShadowNodeInstance()Lcom/facebook/react/flat/RCTText;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createShadowNodeInstance()Lcom/facebook/react/uimanager/ReactShadowNode;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextManager;->createShadowNodeInstance()Lcom/facebook/react/flat/RCTText;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    const-string v0, "RCTText"

    return-object v0
.end method

.method public getShadowNodeClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<",
            "Lcom/facebook/react/flat/RCTText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    const-class v0, Lcom/facebook/react/flat/RCTText;

    return-object v0
.end method

.method public bridge synthetic removeAllViews(Lcom/facebook/react/flat/FlatViewGroup;)V
    .locals 0

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/facebook/react/flat/FlatViewManager;->removeAllViews(Lcom/facebook/react/flat/FlatViewGroup;)V

    return-void
.end method

.method public bridge synthetic setBackgroundColor(Lcom/facebook/react/flat/FlatViewGroup;I)V
    .locals 0

    .prologue
    .line 15
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/FlatViewManager;->setBackgroundColor(Lcom/facebook/react/flat/FlatViewGroup;I)V

    return-void
.end method
