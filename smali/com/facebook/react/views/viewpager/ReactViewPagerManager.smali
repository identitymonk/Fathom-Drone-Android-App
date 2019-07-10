.class public Lcom/facebook/react/views/viewpager/ReactViewPagerManager;
.super Lcom/facebook/react/uimanager/ViewGroupManager;
.source "ReactViewPagerManager.java"


# annotations
.annotation runtime Lcom/facebook/react/module/annotations/ReactModule;
    name = "AndroidViewPager"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/ViewGroupManager",
        "<",
        "Lcom/facebook/react/views/viewpager/ReactViewPager;",
        ">;"
    }
.end annotation


# static fields
.field public static final COMMAND_SET_PAGE:I = 0x1

.field public static final COMMAND_SET_PAGE_WITHOUT_ANIMATION:I = 0x2

.field protected static final REACT_CLASS:Ljava/lang/String; = "AndroidViewPager"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/facebook/react/uimanager/ViewGroupManager;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic addView(Landroid/view/ViewGroup;Landroid/view/View;I)V
    .locals 0

    .prologue
    .line 30
    check-cast p1, Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-virtual {p0, p1, p2, p3}, Lcom/facebook/react/views/viewpager/ReactViewPagerManager;->addView(Lcom/facebook/react/views/viewpager/ReactViewPager;Landroid/view/View;I)V

    return-void
.end method

.method public addView(Lcom/facebook/react/views/viewpager/ReactViewPager;Landroid/view/View;I)V
    .locals 0
    .param p1, "parent"    # Lcom/facebook/react/views/viewpager/ReactViewPager;
    .param p2, "child"    # Landroid/view/View;
    .param p3, "index"    # I

    .prologue
    .line 101
    invoke-virtual {p1, p2, p3}, Lcom/facebook/react/views/viewpager/ReactViewPager;->addViewToAdapter(Landroid/view/View;I)V

    .line 102
    return-void
.end method

.method protected bridge synthetic createViewInstance(Lcom/facebook/react/uimanager/ThemedReactContext;)Landroid/view/View;
    .locals 1

    .prologue
    .line 30
    invoke-virtual {p0, p1}, Lcom/facebook/react/views/viewpager/ReactViewPagerManager;->createViewInstance(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/facebook/react/views/viewpager/ReactViewPager;

    move-result-object v0

    return-object v0
.end method

.method protected createViewInstance(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/facebook/react/views/viewpager/ReactViewPager;
    .locals 1
    .param p1, "reactContext"    # Lcom/facebook/react/uimanager/ThemedReactContext;

    .prologue
    .line 45
    new-instance v0, Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-direct {v0, p1}, Lcom/facebook/react/views/viewpager/ReactViewPager;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    return-object v0
.end method

.method public bridge synthetic getChildAt(Landroid/view/ViewGroup;I)Landroid/view/View;
    .locals 1

    .prologue
    .line 30
    check-cast p1, Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/views/viewpager/ReactViewPagerManager;->getChildAt(Lcom/facebook/react/views/viewpager/ReactViewPager;I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getChildAt(Lcom/facebook/react/views/viewpager/ReactViewPager;I)Landroid/view/View;
    .locals 1
    .param p1, "parent"    # Lcom/facebook/react/views/viewpager/ReactViewPager;
    .param p2, "index"    # I

    .prologue
    .line 111
    invoke-virtual {p1, p2}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getViewFromAdapter(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getChildCount(Landroid/view/ViewGroup;)I
    .locals 1

    .prologue
    .line 30
    check-cast p1, Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-virtual {p0, p1}, Lcom/facebook/react/views/viewpager/ReactViewPagerManager;->getChildCount(Lcom/facebook/react/views/viewpager/ReactViewPager;)I

    move-result v0

    return v0
.end method

.method public getChildCount(Lcom/facebook/react/views/viewpager/ReactViewPager;)I
    .locals 1
    .param p1, "parent"    # Lcom/facebook/react/views/viewpager/ReactViewPager;

    .prologue
    .line 106
    invoke-virtual {p1}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getViewCountInAdapter()I

    move-result v0

    return v0
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
    .line 68
    const-string v0, "setPage"

    const/4 v1, 0x1

    .line 70
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "setPageWithoutAnimation"

    const/4 v3, 0x2

    .line 72
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    .line 68
    invoke-static {v0, v1, v2, v3}, Lcom/facebook/react/common/MapBuilder;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getExportedCustomDirectEventTypeConstants()Ljava/util/Map;
    .locals 7

    .prologue
    .line 60
    const-string v0, "topPageScroll"

    const-string v1, "registrationName"

    const-string v2, "onPageScroll"

    .line 61
    invoke-static {v1, v2}, Lcom/facebook/react/common/MapBuilder;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v1

    const-string v2, "topPageScrollStateChanged"

    const-string v3, "registrationName"

    const-string v4, "onPageScrollStateChanged"

    .line 62
    invoke-static {v3, v4}, Lcom/facebook/react/common/MapBuilder;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v3

    const-string v4, "topPageSelected"

    const-string v5, "registrationName"

    const-string v6, "onPageSelected"

    .line 63
    invoke-static {v5, v6}, Lcom/facebook/react/common/MapBuilder;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v5

    .line 60
    invoke-static/range {v0 .. v5}, Lcom/facebook/react/common/MapBuilder;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    const-string v0, "AndroidViewPager"

    return-object v0
.end method

.method public needsCustomLayoutForChildren()Z
    .locals 1

    .prologue
    .line 55
    const/4 v0, 0x1

    return v0
.end method

.method public bridge synthetic receiveCommand(Landroid/view/View;ILcom/facebook/react/bridge/ReadableArray;)V
    .locals 0
    .param p3    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 30
    check-cast p1, Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-virtual {p0, p1, p2, p3}, Lcom/facebook/react/views/viewpager/ReactViewPagerManager;->receiveCommand(Lcom/facebook/react/views/viewpager/ReactViewPager;ILcom/facebook/react/bridge/ReadableArray;)V

    return-void
.end method

.method public receiveCommand(Lcom/facebook/react/views/viewpager/ReactViewPager;ILcom/facebook/react/bridge/ReadableArray;)V
    .locals 6
    .param p1, "viewPager"    # Lcom/facebook/react/views/viewpager/ReactViewPager;
    .param p2, "commandType"    # I
    .param p3, "args"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 80
    invoke-static {p1}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 81
    invoke-static {p3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    packed-switch p2, :pswitch_data_0

    .line 92
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unsupported command %d received by %s."

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    .line 94
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    .line 95
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    .line 92
    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 84
    :pswitch_0
    invoke-interface {p3, v4}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v0

    invoke-virtual {p1, v0, v5}, Lcom/facebook/react/views/viewpager/ReactViewPager;->setCurrentItemFromJs(IZ)V

    .line 89
    :goto_0
    return-void

    .line 88
    :pswitch_1
    invoke-interface {p3, v4}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v0

    invoke-virtual {p1, v0, v4}, Lcom/facebook/react/views/viewpager/ReactViewPager;->setCurrentItemFromJs(IZ)V

    goto :goto_0

    .line 82
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public bridge synthetic removeViewAt(Landroid/view/ViewGroup;I)V
    .locals 0

    .prologue
    .line 30
    check-cast p1, Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/views/viewpager/ReactViewPagerManager;->removeViewAt(Lcom/facebook/react/views/viewpager/ReactViewPager;I)V

    return-void
.end method

.method public removeViewAt(Lcom/facebook/react/views/viewpager/ReactViewPager;I)V
    .locals 0
    .param p1, "parent"    # Lcom/facebook/react/views/viewpager/ReactViewPager;
    .param p2, "index"    # I

    .prologue
    .line 116
    invoke-virtual {p1, p2}, Lcom/facebook/react/views/viewpager/ReactViewPager;->removeViewFromAdapter(I)V

    .line 117
    return-void
.end method

.method public setPageMargin(Lcom/facebook/react/views/viewpager/ReactViewPager;F)V
    .locals 1
    .param p1, "pager"    # Lcom/facebook/react/views/viewpager/ReactViewPager;
    .param p2, "margin"    # F
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultFloat = 0.0f
        name = "pageMargin"
    .end annotation

    .prologue
    .line 121
    invoke-static {p2}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(F)F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p1, v0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->setPageMargin(I)V

    .line 122
    return-void
.end method

.method public setPeekEnabled(Lcom/facebook/react/views/viewpager/ReactViewPager;Z)V
    .locals 1
    .param p1, "pager"    # Lcom/facebook/react/views/viewpager/ReactViewPager;
    .param p2, "peekEnabled"    # Z
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultBoolean = false
        name = "peekEnabled"
    .end annotation

    .prologue
    .line 126
    if-nez p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->setClipToPadding(Z)V

    .line 127
    return-void

    .line 126
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setScrollEnabled(Lcom/facebook/react/views/viewpager/ReactViewPager;Z)V
    .locals 0
    .param p1, "viewPager"    # Lcom/facebook/react/views/viewpager/ReactViewPager;
    .param p2, "value"    # Z
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultBoolean = true
        name = "scrollEnabled"
    .end annotation

    .prologue
    .line 50
    invoke-virtual {p1, p2}, Lcom/facebook/react/views/viewpager/ReactViewPager;->setScrollEnabled(Z)V

    .line 51
    return-void
.end method
