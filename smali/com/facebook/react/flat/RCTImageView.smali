.class Lcom/facebook/react/flat/RCTImageView;
.super Lcom/facebook/react/flat/FlatShadowNode;
.source "RCTImageView.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/facebook/react/flat/AbstractDrawCommand;",
        ":",
        "Lcom/facebook/react/flat/DrawImage;",
        ">",
        "Lcom/facebook/react/flat/FlatShadowNode;"
    }
.end annotation


# static fields
.field static sCallerContext:Ljava/lang/Object;


# instance fields
.field private mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/facebook/react/flat/RCTImageView;

    sput-object v0, Lcom/facebook/react/flat/RCTImageView;->sCallerContext:Ljava/lang/Object;

    return-void
.end method

.method constructor <init>(Lcom/facebook/react/flat/AbstractDrawCommand;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 43
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    .local p1, "drawImage":Lcom/facebook/react/flat/AbstractDrawCommand;, "TT;"
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatShadowNode;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    .line 45
    return-void
.end method

.method static getCallerContext()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/facebook/react/flat/RCTImageView;->sCallerContext:Ljava/lang/Object;

    return-object v0
.end method

.method private getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 146
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    invoke-virtual {v0}, Lcom/facebook/react/flat/AbstractDrawCommand;->isFrozen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 147
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    invoke-virtual {v0}, Lcom/facebook/react/flat/AbstractDrawCommand;->mutableCopy()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    .line 148
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTImageView;->invalidate()V

    .line 151
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    return-object v0
.end method

.method static setCallerContext(Ljava/lang/Object;)V
    .locals 0
    .param p0, "callerContext"    # Ljava/lang/Object;

    .prologue
    .line 34
    sput-object p0, Lcom/facebook/react/flat/RCTImageView;->sCallerContext:Ljava/lang/Object;

    .line 35
    return-void
.end method


# virtual methods
.method protected collectState(Lcom/facebook/react/flat/StateBuilder;FFFFFFFF)V
    .locals 9
    .param p1, "stateBuilder"    # Lcom/facebook/react/flat/StateBuilder;
    .param p2, "left"    # F
    .param p3, "top"    # F
    .param p4, "right"    # F
    .param p5, "bottom"    # F
    .param p6, "clipLeft"    # F
    .param p7, "clipTop"    # F
    .param p8, "clipRight"    # F
    .param p9, "clipBottom"    # F

    .prologue
    .line 58
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    invoke-super/range {p0 .. p9}, Lcom/facebook/react/flat/FlatShadowNode;->collectState(Lcom/facebook/react/flat/StateBuilder;FFFFFFFF)V

    .line 69
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0}, Lcom/facebook/react/flat/DrawImage;->hasImageRequest()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    move v5, p6

    move/from16 v6, p7

    move/from16 v7, p8

    move/from16 v8, p9

    invoke-virtual/range {v0 .. v8}, Lcom/facebook/react/flat/AbstractDrawCommand;->updateBoundsAndFreeze(FFFFFFFF)Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    .line 79
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    invoke-virtual {p1, v0}, Lcom/facebook/react/flat/StateBuilder;->addDrawCommand(Lcom/facebook/react/flat/AbstractDrawCommand;)V

    .line 80
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    check-cast v0, Lcom/facebook/react/flat/AttachDetachListener;

    invoke-virtual {p1, v0}, Lcom/facebook/react/flat/StateBuilder;->addAttachDetachListener(Lcom/facebook/react/flat/AttachDetachListener;)V

    .line 82
    :cond_0
    return-void
.end method

.method doesDraw()Z
    .locals 1

    .prologue
    .line 86
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0}, Lcom/facebook/react/flat/DrawImage;->hasImageRequest()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0}, Lcom/facebook/react/flat/FlatShadowNode;->doesDraw()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setBorder(IF)V
    .locals 1
    .param p1, "spacingType"    # I
    .param p2, "borderWidth"    # F

    .prologue
    .line 121
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/FlatShadowNode;->setBorder(IF)V

    .line 123
    const/16 v0, 0x8

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0}, Lcom/facebook/react/flat/DrawImage;->getBorderWidth()F

    move-result v0

    cmpl-float v0, v0, p2

    if-eqz v0, :cond_0

    .line 124
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTImageView;->getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0, p2}, Lcom/facebook/react/flat/DrawImage;->setBorderWidth(F)V

    .line 126
    :cond_0
    return-void
.end method

.method public setBorderColor(I)V
    .locals 1
    .param p1, "borderColor"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        customType = "Color"
        name = "borderColor"
    .end annotation

    .prologue
    .line 114
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0}, Lcom/facebook/react/flat/DrawImage;->getBorderColor()I

    move-result v0

    if-eq v0, p1, :cond_0

    .line 115
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTImageView;->getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0, p1}, Lcom/facebook/react/flat/DrawImage;->setBorderColor(I)V

    .line 117
    :cond_0
    return-void
.end method

.method public setBorderRadius(F)V
    .locals 2
    .param p1, "borderRadius"    # F
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "borderRadius"
    .end annotation

    .prologue
    .line 130
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    iget-object v0, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0}, Lcom/facebook/react/flat/DrawImage;->getBorderRadius()F

    move-result v0

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_0

    .line 131
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTImageView;->getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-static {p1}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(F)F

    move-result v1

    invoke-interface {v0, v1}, Lcom/facebook/react/flat/DrawImage;->setBorderRadius(F)V

    .line 133
    :cond_0
    return-void
.end method

.method public setFadeDuration(I)V
    .locals 1
    .param p1, "durationMs"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "fadeDuration"
    .end annotation

    .prologue
    .line 137
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTImageView;->getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0, p1}, Lcom/facebook/react/flat/DrawImage;->setFadeDuration(I)V

    .line 138
    return-void
.end method

.method public setProgressiveRenderingEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "progressiveRenderingEnabled"
    .end annotation

    .prologue
    .line 142
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTImageView;->getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0, p1}, Lcom/facebook/react/flat/DrawImage;->setProgressiveRenderingEnabled(Z)V

    .line 143
    return-void
.end method

.method public setResizeMode(Ljava/lang/String;)V
    .locals 2
    .param p1, "resizeMode"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "resizeMode"
    .end annotation

    .prologue
    .line 106
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    invoke-static {p1}, Lcom/facebook/react/views/image/ImageResizeMode;->toScaleType(Ljava/lang/String;)Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    move-result-object v0

    .line 107
    .local v0, "scaleType":Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    iget-object v1, p0, Lcom/facebook/react/flat/RCTImageView;->mDrawImage:Lcom/facebook/react/flat/AbstractDrawCommand;

    check-cast v1, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v1}, Lcom/facebook/react/flat/DrawImage;->getScaleType()Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    move-result-object v1

    if-eq v1, v0, :cond_0

    .line 108
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTImageView;->getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v1, v0}, Lcom/facebook/react/flat/DrawImage;->setScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V

    .line 110
    :cond_0
    return-void
.end method

.method public setShouldNotifyLoadEvents(Z)V
    .locals 2
    .param p1, "shouldNotifyLoadEvents"    # Z
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "shouldNotifyLoadEvents"
    .end annotation

    .prologue
    .line 91
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTImageView;->getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    if-eqz p1, :cond_0

    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTImageView;->getReactTag()I

    move-result v1

    :goto_0
    invoke-interface {v0, v1}, Lcom/facebook/react/flat/DrawImage;->setReactTag(I)V

    .line 92
    return-void

    .line 91
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setSource(Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 2
    .param p1, "sources"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "src"
    .end annotation

    .prologue
    .line 96
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTImageView;->getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTImageView;->getThemedContext()Lcom/facebook/react/uimanager/ThemedReactContext;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/facebook/react/flat/DrawImage;->setSource(Landroid/content/Context;Lcom/facebook/react/bridge/ReadableArray;)V

    .line 97
    return-void
.end method

.method public setTintColor(I)V
    .locals 1
    .param p1, "tintColor"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "tintColor"
    .end annotation

    .prologue
    .line 101
    .local p0, "this":Lcom/facebook/react/flat/RCTImageView;, "Lcom/facebook/react/flat/RCTImageView<TT;>;"
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTImageView;->getMutableDrawImage()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawImage;

    invoke-interface {v0, p1}, Lcom/facebook/react/flat/DrawImage;->setTintColor(I)V

    .line 102
    return-void
.end method
