.class final Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;
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
    name = "UpdateViewGroup"
.end annotation


# instance fields
.field private final mReactTag:I

.field private final mViewsToAdd:[I

.field private final mViewsToDetach:[I

.field final synthetic this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[I[I)V
    .locals 0
    .param p2, "reactTag"    # I
    .param p3, "viewsToAdd"    # [I
    .param p4, "viewsToDetach"    # [I

    .prologue
    .line 136
    iput-object p1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 137
    iput p2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;->mReactTag:I

    .line 138
    iput-object p3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;->mViewsToAdd:[I

    .line 139
    iput-object p4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;->mViewsToDetach:[I

    .line 140
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[I[ILcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # [I
    .param p4, "x3"    # [I
    .param p5, "x4"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;

    .prologue
    .line 130
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[I[I)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 4

    .prologue
    .line 144
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;->mReactTag:I

    iget-object v2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;->mViewsToAdd:[I

    iget-object v3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;->mViewsToDetach:[I

    invoke-virtual {v0, v1, v2, v3}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->updateViewGroup(I[I[I)V

    .line 145
    return-void
.end method
