.class final Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;
.super Ljava/lang/ref/WeakReference;
.source "FlatViewGroup.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/flat/FlatViewGroup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "InvalidateCallback"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/ref/WeakReference",
        "<",
        "Lcom/facebook/react/flat/FlatViewGroup;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>(Lcom/facebook/react/flat/FlatViewGroup;)V
    .locals 0
    .param p1, "view"    # Lcom/facebook/react/flat/FlatViewGroup;

    .prologue
    .line 108
    invoke-direct {p0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 109
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/flat/FlatViewGroup;Lcom/facebook/react/flat/FlatViewGroup$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "x1"    # Lcom/facebook/react/flat/FlatViewGroup$1;

    .prologue
    .line 105
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;-><init>(Lcom/facebook/react/flat/FlatViewGroup;)V

    return-void
.end method


# virtual methods
.method public dispatchImageLoadEvent(II)V
    .locals 5
    .param p1, "reactTag"    # I
    .param p2, "imageLoadEvent"    # I

    .prologue
    .line 128
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/flat/FlatViewGroup;

    .line 129
    .local v2, "view":Lcom/facebook/react/flat/FlatViewGroup;
    if-nez v2, :cond_0

    .line 137
    :goto_0
    return-void

    .line 133
    :cond_0
    invoke-virtual {v2}, Lcom/facebook/react/flat/FlatViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/ReactContext;

    .line 134
    .local v0, "reactContext":Lcom/facebook/react/bridge/ReactContext;
    const-class v3, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {v0, v3}, Lcom/facebook/react/bridge/ReactContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/uimanager/UIManagerModule;

    .line 135
    .local v1, "uiManagerModule":Lcom/facebook/react/uimanager/UIManagerModule;
    invoke-virtual {v1}, Lcom/facebook/react/uimanager/UIManagerModule;->getEventDispatcher()Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v3

    new-instance v4, Lcom/facebook/react/views/image/ImageLoadEvent;

    invoke-direct {v4, p1, p2}, Lcom/facebook/react/views/image/ImageLoadEvent;-><init>(II)V

    invoke-virtual {v3, v4}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    goto :goto_0
.end method

.method public invalidate()V
    .locals 1

    .prologue
    .line 115
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatViewGroup;

    .line 116
    .local v0, "view":Lcom/facebook/react/flat/FlatViewGroup;
    if-eqz v0, :cond_0

    .line 117
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatViewGroup;->invalidate()V

    .line 119
    :cond_0
    return-void
.end method
