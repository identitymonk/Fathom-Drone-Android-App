.class public Lcom/facebook/react/flat/RCTModalHostManager;
.super Lcom/facebook/react/views/modal/ReactModalHostManager;
.source "RCTModalHostManager.java"


# static fields
.field static final REACT_CLASS:Ljava/lang/String; = "RCTModalHostView"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/facebook/react/views/modal/ReactModalHostManager;-><init>()V

    return-void
.end method


# virtual methods
.method public createShadowNodeInstance()Lcom/facebook/react/uimanager/LayoutShadowNode;
    .locals 1

    .prologue
    .line 21
    new-instance v0, Lcom/facebook/react/flat/FlatReactModalShadowNode;

    invoke-direct {v0}, Lcom/facebook/react/flat/FlatReactModalShadowNode;-><init>()V

    return-object v0
.end method

.method public bridge synthetic createShadowNodeInstance()Lcom/facebook/react/uimanager/ReactShadowNode;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTModalHostManager;->createShadowNodeInstance()Lcom/facebook/react/uimanager/LayoutShadowNode;

    move-result-object v0

    return-object v0
.end method

.method public getShadowNodeClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<+",
            "Lcom/facebook/react/uimanager/LayoutShadowNode;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    const-class v0, Lcom/facebook/react/flat/FlatReactModalShadowNode;

    return-object v0
.end method
