.class public Lcom/facebook/react/flat/FlatARTSurfaceViewManager;
.super Lcom/facebook/react/uimanager/BaseViewManager;
.source "FlatARTSurfaceViewManager.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/BaseViewManager",
        "<",
        "Lcom/facebook/react/views/art/ARTSurfaceView;",
        "Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;",
        ">;"
    }
.end annotation


# static fields
.field private static final MEASURE_FUNCTION:Lcom/facebook/yoga/YogaMeasureFunction;

.field static final REACT_CLASS:Ljava/lang/String; = "ARTSurfaceView"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    new-instance v0, Lcom/facebook/react/flat/FlatARTSurfaceViewManager$1;

    invoke-direct {v0}, Lcom/facebook/react/flat/FlatARTSurfaceViewManager$1;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatARTSurfaceViewManager;->MEASURE_FUNCTION:Lcom/facebook/yoga/YogaMeasureFunction;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/facebook/react/uimanager/BaseViewManager;-><init>()V

    return-void
.end method


# virtual methods
.method public createShadowNodeInstance()Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;
    .locals 2

    .prologue
    .line 43
    new-instance v0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;

    invoke-direct {v0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;-><init>()V

    .line 44
    .local v0, "node":Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;
    sget-object v1, Lcom/facebook/react/flat/FlatARTSurfaceViewManager;->MEASURE_FUNCTION:Lcom/facebook/yoga/YogaMeasureFunction;

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->setMeasureFunction(Lcom/facebook/yoga/YogaMeasureFunction;)V

    .line 45
    return-object v0
.end method

.method public bridge synthetic createShadowNodeInstance()Lcom/facebook/react/uimanager/ReactShadowNode;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewManager;->createShadowNodeInstance()Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic createViewInstance(Lcom/facebook/react/uimanager/ThemedReactContext;)Landroid/view/View;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatARTSurfaceViewManager;->createViewInstance(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/facebook/react/views/art/ARTSurfaceView;

    move-result-object v0

    return-object v0
.end method

.method protected createViewInstance(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/facebook/react/views/art/ARTSurfaceView;
    .locals 1
    .param p1, "reactContext"    # Lcom/facebook/react/uimanager/ThemedReactContext;

    .prologue
    .line 55
    new-instance v0, Lcom/facebook/react/views/art/ARTSurfaceView;

    invoke-direct {v0, p1}, Lcom/facebook/react/views/art/ARTSurfaceView;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    const-string v0, "ARTSurfaceView"

    return-object v0
.end method

.method public getShadowNodeClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<",
            "Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;",
            ">;"
        }
    .end annotation

    .prologue
    .line 50
    const-class v0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;

    return-object v0
.end method

.method public bridge synthetic updateExtraData(Landroid/view/View;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 19
    check-cast p1, Lcom/facebook/react/views/art/ARTSurfaceView;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/flat/FlatARTSurfaceViewManager;->updateExtraData(Lcom/facebook/react/views/art/ARTSurfaceView;Ljava/lang/Object;)V

    return-void
.end method

.method public updateExtraData(Lcom/facebook/react/views/art/ARTSurfaceView;Ljava/lang/Object;)V
    .locals 0
    .param p1, "root"    # Lcom/facebook/react/views/art/ARTSurfaceView;
    .param p2, "extraData"    # Ljava/lang/Object;

    .prologue
    .line 60
    check-cast p2, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;

    .end local p2    # "extraData":Ljava/lang/Object;
    invoke-virtual {p1, p2}, Lcom/facebook/react/views/art/ARTSurfaceView;->setSurfaceTextureListener(Landroid/view/TextureView$SurfaceTextureListener;)V

    .line 61
    return-void
.end method
