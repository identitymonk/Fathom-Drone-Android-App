.class public Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;
.super Ljava/lang/Object;
.source "TouchEventCoalescingKeyHelper.java"


# instance fields
.field private final mDownTimeToCoalescingKey:Landroid/util/SparseIntArray;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;->mDownTimeToCoalescingKey:Landroid/util/SparseIntArray;

    return-void
.end method


# virtual methods
.method public addCoalescingKey(J)V
    .locals 3
    .param p1, "downTime"    # J

    .prologue
    .line 55
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;->mDownTimeToCoalescingKey:Landroid/util/SparseIntArray;

    long-to-int v1, p1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->put(II)V

    .line 56
    return-void
.end method

.method public getCoalescingKey(J)S
    .locals 5
    .param p1, "downTime"    # J

    .prologue
    const/4 v3, -0x1

    .line 73
    iget-object v1, p0, Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;->mDownTimeToCoalescingKey:Landroid/util/SparseIntArray;

    long-to-int v2, p1

    invoke-virtual {v1, v2, v3}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    .line 74
    .local v0, "currentValue":I
    if-ne v0, v3, :cond_0

    .line 75
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Tried to get non-existent cookie"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 77
    :cond_0
    const v1, 0xffff

    and-int/2addr v1, v0

    int-to-short v1, v1

    return v1
.end method

.method public hasCoalescingKey(J)Z
    .locals 5
    .param p1, "downTime"    # J

    .prologue
    const/4 v3, -0x1

    .line 88
    iget-object v1, p0, Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;->mDownTimeToCoalescingKey:Landroid/util/SparseIntArray;

    long-to-int v2, p1

    invoke-virtual {v1, v2, v3}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    .line 89
    .local v0, "currentValue":I
    if-ne v0, v3, :cond_0

    .line 90
    const/4 v1, 0x0

    .line 92
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public incrementCoalescingKey(J)V
    .locals 5
    .param p1, "downTime"    # J

    .prologue
    const/4 v3, -0x1

    .line 62
    iget-object v1, p0, Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;->mDownTimeToCoalescingKey:Landroid/util/SparseIntArray;

    long-to-int v2, p1

    invoke-virtual {v1, v2, v3}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    .line 63
    .local v0, "currentValue":I
    if-ne v0, v3, :cond_0

    .line 64
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Tried to increment non-existent cookie"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 66
    :cond_0
    iget-object v1, p0, Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;->mDownTimeToCoalescingKey:Landroid/util/SparseIntArray;

    long-to-int v2, p1

    add-int/lit8 v3, v0, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/util/SparseIntArray;->put(II)V

    .line 67
    return-void
.end method

.method public removeCoalescingKey(J)V
    .locals 3
    .param p1, "downTime"    # J

    .prologue
    .line 84
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;->mDownTimeToCoalescingKey:Landroid/util/SparseIntArray;

    long-to-int v1, p1

    invoke-virtual {v0, v1}, Landroid/util/SparseIntArray;->delete(I)V

    .line 85
    return-void
.end method
