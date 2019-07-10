.class public final Lcom/facebook/react/flat/RCTViewManager;
.super Lcom/facebook/react/flat/FlatViewManager;
.source "RCTViewManager.java"


# static fields
.field private static final CMD_HOTSPOT_UPDATE:I = 0x1

.field private static final CMD_SET_PRESSED:I = 0x2

.field static final REACT_CLASS:Ljava/lang/String; = "RCTView"

.field private static final TMP_INT_ARRAY:[I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x2

    new-array v0, v0, [I

    sput-object v0, Lcom/facebook/react/flat/RCTViewManager;->TMP_INT_ARRAY:[I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatViewManager;-><init>()V

    return-void
.end method

.method private static parsePointerEvents(Ljava/lang/String;)Lcom/facebook/react/uimanager/PointerEvents;
    .locals 2
    .param p0, "pointerEventsStr"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 113
    if-eqz p0, :cond_1

    .line 114
    const/4 v0, -0x1

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 126
    :cond_1
    sget-object v0, Lcom/facebook/react/uimanager/PointerEvents;->AUTO:Lcom/facebook/react/uimanager/PointerEvents;

    :goto_1
    return-object v0

    .line 114
    :sswitch_0
    const-string v1, "none"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :sswitch_1
    const-string v1, "auto"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :sswitch_2
    const-string v1, "box-none"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x2

    goto :goto_0

    :sswitch_3
    const-string v1, "box-only"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x3

    goto :goto_0

    .line 116
    :pswitch_0
    sget-object v0, Lcom/facebook/react/uimanager/PointerEvents;->NONE:Lcom/facebook/react/uimanager/PointerEvents;

    goto :goto_1

    .line 118
    :pswitch_1
    sget-object v0, Lcom/facebook/react/uimanager/PointerEvents;->AUTO:Lcom/facebook/react/uimanager/PointerEvents;

    goto :goto_1

    .line 120
    :pswitch_2
    sget-object v0, Lcom/facebook/react/uimanager/PointerEvents;->BOX_NONE:Lcom/facebook/react/uimanager/PointerEvents;

    goto :goto_1

    .line 122
    :pswitch_3
    sget-object v0, Lcom/facebook/react/uimanager/PointerEvents;->BOX_ONLY:Lcom/facebook/react/uimanager/PointerEvents;

    goto :goto_1

    .line 114
    :sswitch_data_0
    .sparse-switch
        -0x7c85c606 -> :sswitch_2
        -0x7c855592 -> :sswitch_3
        0x2dddaf -> :sswitch_1
        0x33af38 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method


# virtual methods
.method public createShadowNodeInstance()Lcom/facebook/react/flat/RCTView;
    .locals 1

    .prologue
    .line 51
    new-instance v0, Lcom/facebook/react/flat/RCTView;

    invoke-direct {v0}, Lcom/facebook/react/flat/RCTView;-><init>()V

    return-object v0
.end method

.method public bridge synthetic createShadowNodeInstance()Lcom/facebook/react/uimanager/LayoutShadowNode;
    .locals 1

    .prologue
    .line 31
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTViewManager;->createShadowNodeInstance()Lcom/facebook/react/flat/RCTView;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createShadowNodeInstance()Lcom/facebook/react/uimanager/ReactShadowNode;
    .locals 1

    .prologue
    .line 31
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTViewManager;->createShadowNodeInstance()Lcom/facebook/react/flat/RCTView;

    move-result-object v0

    return-object v0
.end method

.method public getCommandsMap()Ljava/util/Map;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 46
    const-string v0, "hotspotUpdate"

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "setPressed"

    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/react/common/MapBuilder;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    const-string v0, "RCTView"

    return-object v0
.end method

.method public getShadowNodeClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<",
            "Lcom/facebook/react/flat/RCTView;",
            ">;"
        }
    .end annotation

    .prologue
    .line 56
    const-class v0, Lcom/facebook/react/flat/RCTView;

    return-object v0
.end method

.method public bridge synthetic receiveCommand(Landroid/view/View;ILcom/facebook/react/bridge/ReadableArray;)V
    .locals 0
    .param p3    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 31
    check-cast p1, Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {p0, p1, p2, p3}, Lcom/facebook/react/flat/RCTViewManager;->receiveCommand(Lcom/facebook/react/flat/FlatViewGroup;ILcom/facebook/react/bridge/ReadableArray;)V

    return-void
.end method

.method public receiveCommand(Lcom/facebook/react/flat/FlatViewGroup;ILcom/facebook/react/bridge/ReadableArray;)V
    .locals 6
    .param p1, "view"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "commandId"    # I
    .param p3, "args"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 70
    packed-switch p2, :pswitch_data_0

    .line 93
    :cond_0
    :goto_0
    return-void

    .line 72
    :pswitch_0
    if-eqz p3, :cond_1

    invoke-interface {p3}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    const/4 v3, 0x2

    if-eq v2, v3, :cond_2

    .line 73
    :cond_1
    new-instance v2, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v3, "Illegal number of arguments for \'updateHotspot\' command"

    invoke-direct {v2, v3}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 76
    :cond_2
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x15

    if-lt v2, v3, :cond_0

    .line 77
    sget-object v2, Lcom/facebook/react/flat/RCTViewManager;->TMP_INT_ARRAY:[I

    invoke-virtual {p1, v2}, Lcom/facebook/react/flat/FlatViewGroup;->getLocationOnScreen([I)V

    .line 78
    invoke-interface {p3, v4}, Lcom/facebook/react/bridge/ReadableArray;->getDouble(I)D

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v2

    sget-object v3, Lcom/facebook/react/flat/RCTViewManager;->TMP_INT_ARRAY:[I

    aget v3, v3, v4

    int-to-float v3, v3

    sub-float v0, v2, v3

    .line 79
    .local v0, "x":F
    invoke-interface {p3, v5}, Lcom/facebook/react/bridge/ReadableArray;->getDouble(I)D

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v2

    sget-object v3, Lcom/facebook/react/flat/RCTViewManager;->TMP_INT_ARRAY:[I

    aget v3, v3, v5

    int-to-float v3, v3

    sub-float v1, v2, v3

    .line 80
    .local v1, "y":F
    invoke-virtual {p1, v0, v1}, Lcom/facebook/react/flat/FlatViewGroup;->drawableHotspotChanged(FF)V

    goto :goto_0

    .line 85
    .end local v0    # "x":F
    .end local v1    # "y":F
    :pswitch_1
    if-eqz p3, :cond_3

    invoke-interface {p3}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    if-eq v2, v5, :cond_4

    .line 86
    :cond_3
    new-instance v2, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v3, "Illegal number of arguments for \'setPressed\' command"

    invoke-direct {v2, v3}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 89
    :cond_4
    invoke-interface {p3, v4}, Lcom/facebook/react/bridge/ReadableArray;->getBoolean(I)Z

    move-result v2

    invoke-virtual {p1, v2}, Lcom/facebook/react/flat/FlatViewGroup;->setPressed(Z)V

    goto :goto_0

    .line 70
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public bridge synthetic removeAllViews(Lcom/facebook/react/flat/FlatViewGroup;)V
    .locals 0

    .prologue
    .line 31
    invoke-super {p0, p1}, Lcom/facebook/react/flat/FlatViewManager;->removeAllViews(Lcom/facebook/react/flat/FlatViewGroup;)V

    return-void
.end method

.method public bridge synthetic setBackgroundColor(Lcom/facebook/react/flat/FlatViewGroup;I)V
    .locals 0

    .prologue
    .line 31
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/FlatViewManager;->setBackgroundColor(Lcom/facebook/react/flat/FlatViewGroup;I)V

    return-void
.end method

.method public setHitSlop(Lcom/facebook/react/flat/FlatViewGroup;Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 6
    .param p1, "view"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "hitSlop"    # Lcom/facebook/react/bridge/ReadableMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "hitSlop"
    .end annotation

    .prologue
    .line 131
    if-nez p2, :cond_0

    .line 132
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/facebook/react/flat/FlatViewGroup;->setHitSlopRect(Landroid/graphics/Rect;)V

    .line 141
    :goto_0
    return-void

    .line 134
    :cond_0
    new-instance v0, Landroid/graphics/Rect;

    const-string v1, "left"

    .line 135
    invoke-interface {p2, v1}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v1

    float-to-int v1, v1

    const-string v2, "top"

    .line 136
    invoke-interface {p2, v2}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v2

    float-to-int v2, v2

    const-string v3, "right"

    .line 137
    invoke-interface {p2, v3}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v3

    float-to-int v3, v3

    const-string v4, "bottom"

    .line 138
    invoke-interface {p2, v4}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v4

    float-to-int v4, v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 134
    invoke-virtual {p1, v0}, Lcom/facebook/react/flat/FlatViewGroup;->setHitSlopRect(Landroid/graphics/Rect;)V

    goto :goto_0
.end method

.method public setHotspot(Lcom/facebook/react/flat/FlatViewGroup;Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 1
    .param p1, "view"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "bg"    # Lcom/facebook/react/bridge/ReadableMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "nativeBackgroundAndroid"
    .end annotation

    .prologue
    .line 61
    if-nez p2, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1, v0}, Lcom/facebook/react/flat/FlatViewGroup;->setHotspot(Landroid/graphics/drawable/Drawable;)V

    .line 63
    return-void

    .line 62
    :cond_0
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p2}, Lcom/facebook/react/views/view/ReactDrawableHelper;->createDrawableFromJSDescription(Landroid/content/Context;Lcom/facebook/react/bridge/ReadableMap;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0
.end method

.method public setNeedsOffscreenAlphaCompositing(Lcom/facebook/react/flat/FlatViewGroup;Z)V
    .locals 0
    .param p1, "view"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "needsOffscreenAlphaCompositing"    # Z
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "needsOffscreenAlphaCompositing"
    .end annotation

    .prologue
    .line 99
    invoke-virtual {p1, p2}, Lcom/facebook/react/flat/FlatViewGroup;->setNeedsOffscreenAlphaCompositing(Z)V

    .line 100
    return-void
.end method

.method public setPointerEvents(Lcom/facebook/react/flat/FlatViewGroup;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "pointerEventsStr"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "pointerEvents"
    .end annotation

    .prologue
    .line 104
    invoke-static {p2}, Lcom/facebook/react/flat/RCTViewManager;->parsePointerEvents(Ljava/lang/String;)Lcom/facebook/react/uimanager/PointerEvents;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/facebook/react/flat/FlatViewGroup;->setPointerEvents(Lcom/facebook/react/uimanager/PointerEvents;)V

    .line 105
    return-void
.end method

.method public setRemoveClippedSubviews(Lcom/facebook/react/flat/FlatViewGroup;Z)V
    .locals 0
    .param p1, "view"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "removeClippedSubviews"    # Z
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "removeClippedSubviews"
    .end annotation

    .prologue
    .line 109
    invoke-virtual {p1, p2}, Lcom/facebook/react/flat/FlatViewGroup;->setRemoveClippedSubviews(Z)V

    .line 110
    return-void
.end method
