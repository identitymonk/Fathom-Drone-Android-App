.class Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;
.super Ljava/lang/Object;
.source "ReactViewPager.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/viewpager/ReactViewPager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PageChangeListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/views/viewpager/ReactViewPager;


# direct methods
.method private constructor <init>(Lcom/facebook/react/views/viewpager/ReactViewPager;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;->this$0:Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/views/viewpager/ReactViewPager;Lcom/facebook/react/views/viewpager/ReactViewPager$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/views/viewpager/ReactViewPager;
    .param p2, "x1"    # Lcom/facebook/react/views/viewpager/ReactViewPager$1;

    .prologue
    .line 121
    invoke-direct {p0, p1}, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;-><init>(Lcom/facebook/react/views/viewpager/ReactViewPager;)V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 4
    .param p1, "state"    # I

    .prologue
    .line 140
    packed-switch p1, :pswitch_data_0

    .line 151
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Unsupported pageScrollState"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 142
    :pswitch_0
    const-string v0, "idle"

    .line 153
    .local v0, "pageScrollState":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;->this$0:Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-static {v1}, Lcom/facebook/react/views/viewpager/ReactViewPager;->access$100(Lcom/facebook/react/views/viewpager/ReactViewPager;)Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v1

    new-instance v2, Lcom/facebook/react/views/viewpager/PageScrollStateChangedEvent;

    iget-object v3, p0, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;->this$0:Lcom/facebook/react/views/viewpager/ReactViewPager;

    .line 154
    invoke-virtual {v3}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getId()I

    move-result v3

    invoke-direct {v2, v3, v0}, Lcom/facebook/react/views/viewpager/PageScrollStateChangedEvent;-><init>(ILjava/lang/String;)V

    .line 153
    invoke-virtual {v1, v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 155
    return-void

    .line 145
    .end local v0    # "pageScrollState":Ljava/lang/String;
    :pswitch_1
    const-string v0, "dragging"

    .line 146
    .restart local v0    # "pageScrollState":Ljava/lang/String;
    goto :goto_0

    .line 148
    .end local v0    # "pageScrollState":Ljava/lang/String;
    :pswitch_2
    const-string v0, "settling"

    .line 149
    .restart local v0    # "pageScrollState":Ljava/lang/String;
    goto :goto_0

    .line 140
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onPageScrolled(IFI)V
    .locals 3
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    .line 125
    iget-object v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;->this$0:Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-static {v0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->access$100(Lcom/facebook/react/views/viewpager/ReactViewPager;)Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v0

    new-instance v1, Lcom/facebook/react/views/viewpager/PageScrollEvent;

    iget-object v2, p0, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;->this$0:Lcom/facebook/react/views/viewpager/ReactViewPager;

    .line 126
    invoke-virtual {v2}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getId()I

    move-result v2

    invoke-direct {v1, v2, p1, p2}, Lcom/facebook/react/views/viewpager/PageScrollEvent;-><init>(IIF)V

    .line 125
    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 127
    return-void
.end method

.method public onPageSelected(I)V
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 131
    iget-object v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;->this$0:Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-static {v0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->access$200(Lcom/facebook/react/views/viewpager/ReactViewPager;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 132
    iget-object v0, p0, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;->this$0:Lcom/facebook/react/views/viewpager/ReactViewPager;

    invoke-static {v0}, Lcom/facebook/react/views/viewpager/ReactViewPager;->access$100(Lcom/facebook/react/views/viewpager/ReactViewPager;)Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v0

    new-instance v1, Lcom/facebook/react/views/viewpager/PageSelectedEvent;

    iget-object v2, p0, Lcom/facebook/react/views/viewpager/ReactViewPager$PageChangeListener;->this$0:Lcom/facebook/react/views/viewpager/ReactViewPager;

    .line 133
    invoke-virtual {v2}, Lcom/facebook/react/views/viewpager/ReactViewPager;->getId()I

    move-result v2

    invoke-direct {v1, v2, p1}, Lcom/facebook/react/views/viewpager/PageSelectedEvent;-><init>(II)V

    .line 132
    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 135
    :cond_0
    return-void
.end method
