.class public Lcom/facebook/react/views/viewpager/ReactViewPager;
.super Landroid/support/v4/view/ViewPager;
.source "ReactViewPager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;,
        Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;
    }
.end annotation


# instance fields
.field private final mEventDispatcher:Lcom/facebook/react/uimanager/events/EventDispatcher;

.field private mIsCurrentItemFromJs:Z

.field private mScrollEnabled:Z


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReactContext;)V
    .locals 2
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    const/4 v1, 0x0

    .line 163
    invoke-direct {p0, p1}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;)V

    .line 160
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mScrollEnabled:Z

    .line 164
    const-class v0, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {p1, v0}, Lcom/facebook/react/bridge/ReactContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {v0}, Lcom/facebook/react/uimanager/UIManagerModule;->getEventDispatcher()Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mEventDispatcher:Lcom/facebook/react/uimanager/events/EventDispatcher;

    .line 165
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mIsCurrentItemFromJs:Z

    .line 166
    new-instance v0, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;

    invoke-direct {v0, p0, v1}, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;-><init>(Lcom/facebook/react/views/viewpager/ReactViewPager;Lcom/facebook/react/views/viewpager/ReactViewPager$1;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 167
    new-instance v0, Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;

    invoke-direct {v0, p0, v1}, Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;-><init>(Lcom/facebook/react/views/viewpager/ReactViewPager;Lcom/facebook/react/views/viewpager/ReactViewPager$1;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 168
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/views/viewpager/ReactViewPager;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/views/viewpager/ReactViewPager;

    .prologue
    .line 31
    invoke-virtual {p0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/facebook/react/views/viewpager/ReactViewPager;)Lcom/facebook/react/uimanager/events/EventDispatcher;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/views/viewpager/ReactViewPager;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mEventDispatcher:Lcom/facebook/react/uimanager/events/EventDispatcher;

    return-object v0
.end method

.method static synthetic access$200(Lcom/facebook/react/views/viewpager/ReactViewPager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/views/viewpager/ReactViewPager;

    .prologue
    .line 31
    iget-boolean v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mIsCurrentItemFromJs:Z

    return v0
.end method


# virtual methods
.method addViewToAdapter(Landroid/view/View;I)V
    .locals 1
    .param p1, "child"    # Landroid/view/View;
    .param p2, "index"    # I

    .prologue
    .line 208
    invoke-virtual {p0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getAdapter()Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;->addView(Landroid/view/View;I)V

    .line 209
    return-void
.end method

.method public bridge synthetic getAdapter()Landroid/support/v4/view/PagerAdapter;
    .locals 1

    .prologue
    .line 31
    invoke-virtual {p0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getAdapter()Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;
    .locals 1

    .prologue
    .line 172
    invoke-super {p0}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;

    return-object v0
.end method

.method getViewCountInAdapter()I
    .locals 1

    .prologue
    .line 216
    invoke-virtual {p0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getAdapter()Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;->getCount()I

    move-result v0

    return v0
.end method

.method getViewFromAdapter(I)Landroid/view/View;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 220
    invoke-virtual {p0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getAdapter()Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;->getViewAt(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x0

    .line 177
    iget-boolean v1, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mScrollEnabled:Z

    if-nez v1, :cond_1

    .line 185
    :cond_0
    :goto_0
    return v0

    .line 181
    :cond_1
    invoke-super {p0, p1}, Landroid/support/v4/view/ViewPager;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 182
    invoke-static {p0, p1}, Lcom/facebook/react/uimanager/events/NativeGestureUtil;->notifyNativeGestureStarted(Landroid/view/View;Landroid/view/MotionEvent;)V

    .line 183
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 190
    iget-boolean v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mScrollEnabled:Z

    if-nez v0, :cond_0

    .line 191
    const/4 v0, 0x0

    .line 194
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v4/view/ViewPager;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public removeAllViewsFromAdapter()V
    .locals 1

    .prologue
    .line 228
    invoke-virtual {p0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getAdapter()Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;->removeAllViewsFromAdapter(Landroid/support/v4/view/ViewPager;)V

    .line 229
    return-void
.end method

.method removeViewFromAdapter(I)V
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 212
    invoke-virtual {p0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getAdapter()Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;->removeViewAt(I)V

    .line 213
    return-void
.end method

.method public setCurrentItemFromJs(IZ)V
    .locals 1
    .param p1, "item"    # I
    .param p2, "animated"    # Z

    .prologue
    .line 198
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mIsCurrentItemFromJs:Z

    .line 199
    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/views/viewpager/ReactViewPager;->setCurrentItem(IZ)V

    .line 200
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mIsCurrentItemFromJs:Z

    .line 201
    return-void
.end method

.method public setScrollEnabled(Z)V
    .locals 0
    .param p1, "scrollEnabled"    # Z

    .prologue
    .line 204
    iput-boolean p1, p0, Lcom/facebook/react/views/viewpager/ReactViewPager;->mScrollEnabled:Z

    .line 205
    return-void
.end method

.method public setViews(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 224
    .local p1, "views":Ljava/util/List;, "Ljava/util/List<Landroid/view/View;>;"
    invoke-virtual {p0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getAdapter()Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/views/viewpager/ReactViewPager$Adapter;->setViews(Ljava/util/List;)V

    .line 225
    return-void
.end method
