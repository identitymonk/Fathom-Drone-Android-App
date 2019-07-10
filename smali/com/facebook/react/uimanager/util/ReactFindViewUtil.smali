.class public Lcom/facebook/react/uimanager/util/ReactFindViewUtil;
.super Ljava/lang/Object;
.source "ReactFindViewUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;
    }
.end annotation


# static fields
.field private static final mOnViewFoundListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/facebook/react/uimanager/util/ReactFindViewUtil;->mOnViewFoundListeners:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    return-void
.end method

.method public static addViewListener(Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;)V
    .locals 1
    .param p0, "onViewFoundListener"    # Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;

    .prologue
    .line 83
    sget-object v0, Lcom/facebook/react/uimanager/util/ReactFindViewUtil;->mOnViewFoundListeners:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 84
    return-void
.end method

.method public static findView(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;
    .locals 5
    .param p0, "root"    # Landroid/view/View;
    .param p1, "nativeId"    # Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 46
    invoke-static {p0}, Lcom/facebook/react/uimanager/util/ReactFindViewUtil;->getNativeId(Landroid/view/View;)Ljava/lang/String;

    move-result-object v1

    .line 47
    .local v1, "tag":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 61
    .end local p0    # "root":Landroid/view/View;
    :goto_0
    return-object p0

    .line 51
    .restart local p0    # "root":Landroid/view/View;
    :cond_0
    instance-of v4, p0, Landroid/view/ViewGroup;

    if-eqz v4, :cond_2

    move-object v3, p0

    .line 52
    check-cast v3, Landroid/view/ViewGroup;

    .line 53
    .local v3, "viewGroup":Landroid/view/ViewGroup;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-virtual {v3}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v4

    if-ge v0, v4, :cond_2

    .line 54
    invoke-virtual {v3, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-static {v4, p1}, Lcom/facebook/react/uimanager/util/ReactFindViewUtil;->findView(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;

    move-result-object v2

    .line 55
    .local v2, "view":Landroid/view/View;
    if-eqz v2, :cond_1

    move-object p0, v2

    .line 56
    goto :goto_0

    .line 53
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 61
    .end local v0    # "i":I
    .end local v2    # "view":Landroid/view/View;
    .end local v3    # "viewGroup":Landroid/view/ViewGroup;
    :cond_2
    const/4 p0, 0x0

    goto :goto_0
.end method

.method public static findView(Landroid/view/View;Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;)V
    .locals 2
    .param p0, "root"    # Landroid/view/View;
    .param p1, "onViewFoundListener"    # Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;

    .prologue
    .line 71
    invoke-interface {p1}, Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;->getNativeId()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/facebook/react/uimanager/util/ReactFindViewUtil;->findView(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 72
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 73
    invoke-interface {p1, v0}, Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;->onViewFound(Landroid/view/View;)V

    .line 75
    :cond_0
    invoke-static {p1}, Lcom/facebook/react/uimanager/util/ReactFindViewUtil;->addViewListener(Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;)V

    .line 76
    return-void
.end method

.method private static getNativeId(Landroid/view/View;)Ljava/lang/String;
    .locals 2
    .param p0, "view"    # Landroid/view/View;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 112
    sget v1, Lcom/facebook/react/R$id;->view_tag_native_id:I

    invoke-virtual {p0, v1}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v0

    .line 113
    .local v0, "tag":Ljava/lang/Object;
    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/String;

    .end local v0    # "tag":Ljava/lang/Object;
    :goto_0
    return-object v0

    .restart local v0    # "tag":Ljava/lang/Object;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static notifyViewRendered(Landroid/view/View;)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 97
    invoke-static {p0}, Lcom/facebook/react/uimanager/util/ReactFindViewUtil;->getNativeId(Landroid/view/View;)Ljava/lang/String;

    move-result-object v2

    .line 98
    .local v2, "nativeId":Ljava/lang/String;
    if-nez v2, :cond_1

    .line 109
    :cond_0
    return-void

    .line 101
    :cond_1
    sget-object v3, Lcom/facebook/react/uimanager/util/ReactFindViewUtil;->mOnViewFoundListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 102
    .local v0, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;>;"
    :cond_2
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 103
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;

    .line 104
    .local v1, "listener":Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;
    if-eqz v2, :cond_2

    invoke-interface {v1}, Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;->getNativeId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 105
    invoke-interface {v1, p0}, Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;->onViewFound(Landroid/view/View;)V

    .line 106
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_0
.end method

.method public static removeViewListener(Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;)V
    .locals 1
    .param p0, "onViewFoundListener"    # Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;

    .prologue
    .line 90
    sget-object v0, Lcom/facebook/react/uimanager/util/ReactFindViewUtil;->mOnViewFoundListeners:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 91
    return-void
.end method
