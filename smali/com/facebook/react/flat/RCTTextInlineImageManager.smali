.class public final Lcom/facebook/react/flat/RCTTextInlineImageManager;
.super Lcom/facebook/react/flat/VirtualViewManager;
.source "RCTTextInlineImageManager.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/flat/VirtualViewManager",
        "<",
        "Lcom/facebook/react/flat/RCTTextInlineImage;",
        ">;"
    }
.end annotation


# static fields
.field static final REACT_CLASS:Ljava/lang/String; = "RCTTextInlineImage"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/facebook/react/flat/VirtualViewManager;-><init>()V

    return-void
.end method


# virtual methods
.method public createShadowNodeInstance()Lcom/facebook/react/flat/RCTTextInlineImage;
    .locals 1

    .prologue
    .line 26
    new-instance v0, Lcom/facebook/react/flat/RCTTextInlineImage;

    invoke-direct {v0}, Lcom/facebook/react/flat/RCTTextInlineImage;-><init>()V

    return-object v0
.end method

.method public bridge synthetic createShadowNodeInstance()Lcom/facebook/react/uimanager/ReactShadowNode;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextInlineImageManager;->createShadowNodeInstance()Lcom/facebook/react/flat/RCTTextInlineImage;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    const-string v0, "RCTTextInlineImage"

    return-object v0
.end method

.method public getShadowNodeClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<",
            "Lcom/facebook/react/flat/RCTTextInlineImage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    const-class v0, Lcom/facebook/react/flat/RCTTextInlineImage;

    return-object v0
.end method

.method public bridge synthetic updateExtraData(Landroid/view/View;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 15
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/VirtualViewManager;->updateExtraData(Landroid/view/View;Ljava/lang/Object;)V

    return-void
.end method
