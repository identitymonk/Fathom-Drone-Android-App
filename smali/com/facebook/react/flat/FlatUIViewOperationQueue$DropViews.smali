.class final Lcom/facebook/react/flat/FlatUIViewOperationQueue$DropViews;
.super Ljava/lang/Object;
.source "FlatUIViewOperationQueue.java"

# interfaces
.implements Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/flat/FlatUIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "DropViews"
.end annotation


# instance fields
.field private final mViewsToDrop:Landroid/util/SparseIntArray;

.field final synthetic this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 209
    .local p2, "viewsToDrop":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    .local p3, "parentsForViewsToDrop":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    iput-object p1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DropViews;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 210
    new-instance v2, Landroid/util/SparseIntArray;

    invoke-direct {v2}, Landroid/util/SparseIntArray;-><init>()V

    .line 211
    .local v2, "sparseIntArray":Landroid/util/SparseIntArray;
    const/4 v1, 0x0

    .local v1, "i":I
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v0

    .local v0, "count":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 212
    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {p3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v2, v4, v3}, Landroid/util/SparseIntArray;->put(II)V

    .line 211
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 214
    :cond_0
    iput-object v2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DropViews;->mViewsToDrop:Landroid/util/SparseIntArray;

    .line 215
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .param p2, "x1"    # Ljava/util/ArrayList;
    .param p3, "x2"    # Ljava/util/ArrayList;
    .param p4, "x3"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;

    .prologue
    .line 205
    invoke-direct {p0, p1, p2, p3}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DropViews;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 2

    .prologue
    .line 219
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DropViews;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DropViews;->mViewsToDrop:Landroid/util/SparseIntArray;

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->dropViews(Landroid/util/SparseIntArray;)V

    .line 220
    return-void
.end method
