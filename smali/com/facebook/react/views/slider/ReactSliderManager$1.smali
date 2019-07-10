.class final Lcom/facebook/react/views/slider/ReactSliderManager$1;
.super Ljava/lang/Object;
.source "ReactSliderManager.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/slider/ReactSliderManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 6
    .param p1, "seekbar"    # Landroid/widget/SeekBar;
    .param p2, "progress"    # I
    .param p3, "fromUser"    # Z

    .prologue
    .line 82
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/ReactContext;

    .line 83
    .local v0, "reactContext":Lcom/facebook/react/bridge/ReactContext;
    const-class v1, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {v0, v1}, Lcom/facebook/react/bridge/ReactContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {v1}, Lcom/facebook/react/uimanager/UIManagerModule;->getEventDispatcher()Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v1

    new-instance v2, Lcom/facebook/react/views/slider/ReactSliderEvent;

    .line 85
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getId()I

    move-result v3

    check-cast p1, Lcom/facebook/react/views/slider/ReactSlider;

    .line 86
    .end local p1    # "seekbar":Landroid/widget/SeekBar;
    invoke-virtual {p1, p2}, Lcom/facebook/react/views/slider/ReactSlider;->toRealProgress(I)D

    move-result-wide v4

    invoke-direct {v2, v3, v4, v5, p3}, Lcom/facebook/react/views/slider/ReactSliderEvent;-><init>(IDZ)V

    .line 83
    invoke-virtual {v1, v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 88
    return-void
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0
    .param p1, "seekbar"    # Landroid/widget/SeekBar;

    .prologue
    .line 92
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 8
    .param p1, "seekbar"    # Landroid/widget/SeekBar;

    .prologue
    .line 96
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/ReactContext;

    .line 97
    .local v0, "reactContext":Lcom/facebook/react/bridge/ReactContext;
    const-class v1, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {v0, v1}, Lcom/facebook/react/bridge/ReactContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {v1}, Lcom/facebook/react/uimanager/UIManagerModule;->getEventDispatcher()Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v2

    new-instance v3, Lcom/facebook/react/views/slider/ReactSlidingCompleteEvent;

    .line 99
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getId()I

    move-result v4

    move-object v1, p1

    check-cast v1, Lcom/facebook/react/views/slider/ReactSlider;

    .line 100
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v5

    invoke-virtual {v1, v5}, Lcom/facebook/react/views/slider/ReactSlider;->toRealProgress(I)D

    move-result-wide v6

    invoke-direct {v3, v4, v6, v7}, Lcom/facebook/react/views/slider/ReactSlidingCompleteEvent;-><init>(ID)V

    .line 97
    invoke-virtual {v2, v3}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 101
    return-void
.end method
