.class public Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;
.super Lcom/facebook/react/uimanager/LayoutShadowNode;
.source "ProgressBarShadowNode.java"

# interfaces
.implements Lcom/facebook/yoga/YogaMeasureFunction;


# instance fields
.field private final mHeight:Landroid/util/SparseIntArray;

.field private final mMeasured:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mStyle:Ljava/lang/String;

.field private final mWidth:Landroid/util/SparseIntArray;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/facebook/react/uimanager/LayoutShadowNode;-><init>()V

    .line 36
    const-string v0, "Normal"

    iput-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mStyle:Ljava/lang/String;

    .line 38
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mHeight:Landroid/util/SparseIntArray;

    .line 39
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mWidth:Landroid/util/SparseIntArray;

    .line 40
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mMeasured:Ljava/util/Set;

    .line 43
    invoke-virtual {p0, p0}, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->setMeasureFunction(Lcom/facebook/yoga/YogaMeasureFunction;)V

    .line 44
    return-void
.end method


# virtual methods
.method public getStyle()Ljava/lang/String;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mStyle:Ljava/lang/String;

    return-object v0
.end method

.method public measure(Lcom/facebook/yoga/YogaNode;FLcom/facebook/yoga/YogaMeasureMode;FLcom/facebook/yoga/YogaMeasureMode;)J
    .locals 6
    .param p1, "node"    # Lcom/facebook/yoga/YogaNode;
    .param p2, "width"    # F
    .param p3, "widthMode"    # Lcom/facebook/yoga/YogaMeasureMode;
    .param p4, "height"    # F
    .param p5, "heightMode"    # Lcom/facebook/yoga/YogaMeasureMode;

    .prologue
    .line 62
    invoke-virtual {p0}, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->getStyle()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/react/views/progressbar/ReactProgressBarViewManager;->getStyleFromString(Ljava/lang/String;)I

    move-result v2

    .line 63
    .local v2, "style":I
    iget-object v3, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mMeasured:Ljava/util/Set;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 64
    invoke-virtual {p0}, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->getThemedContext()Lcom/facebook/react/uimanager/ThemedReactContext;

    move-result-object v3

    invoke-static {v3, v2}, Lcom/facebook/react/views/progressbar/ReactProgressBarViewManager;->createProgressBar(Landroid/content/Context;I)Landroid/widget/ProgressBar;

    move-result-object v0

    .line 65
    .local v0, "progressBar":Landroid/widget/ProgressBar;
    const/4 v3, -0x2

    const/4 v4, 0x0

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .line 68
    .local v1, "spec":I
    invoke-virtual {v0, v1, v1}, Landroid/widget/ProgressBar;->measure(II)V

    .line 69
    iget-object v3, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mHeight:Landroid/util/SparseIntArray;

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getMeasuredHeight()I

    move-result v4

    invoke-virtual {v3, v2, v4}, Landroid/util/SparseIntArray;->put(II)V

    .line 70
    iget-object v3, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mWidth:Landroid/util/SparseIntArray;

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getMeasuredWidth()I

    move-result v4

    invoke-virtual {v3, v2, v4}, Landroid/util/SparseIntArray;->put(II)V

    .line 71
    iget-object v3, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mMeasured:Ljava/util/Set;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 74
    .end local v0    # "progressBar":Landroid/widget/ProgressBar;
    .end local v1    # "spec":I
    :cond_0
    iget-object v3, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mWidth:Landroid/util/SparseIntArray;

    invoke-virtual {v3, v2}, Landroid/util/SparseIntArray;->get(I)I

    move-result v3

    iget-object v4, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mHeight:Landroid/util/SparseIntArray;

    invoke-virtual {v4, v2}, Landroid/util/SparseIntArray;->get(I)I

    move-result v4

    invoke-static {v3, v4}, Lcom/facebook/yoga/YogaMeasureOutput;->make(II)J

    move-result-wide v4

    return-wide v4
.end method

.method public setStyle(Ljava/lang/String;)V
    .locals 0
    .param p1, "style"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "styleAttr"
    .end annotation

    .prologue
    .line 52
    if-nez p1, :cond_0

    const-string p1, "Normal"

    .end local p1    # "style":Ljava/lang/String;
    :cond_0
    iput-object p1, p0, Lcom/facebook/react/views/progressbar/ProgressBarShadowNode;->mStyle:Ljava/lang/String;

    .line 53
    return-void
.end method
