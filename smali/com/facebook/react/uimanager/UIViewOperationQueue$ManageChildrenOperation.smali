.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "ManageChildrenOperation"
.end annotation


# instance fields
.field private final mIndicesToRemove:[I
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mTagsToDelete:[I
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mViewsToAdd:[Lcom/facebook/react/uimanager/ViewAtIndex;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method public constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I[I[Lcom/facebook/react/uimanager/ViewAtIndex;[I)V
    .locals 0
    .param p2, "tag"    # I
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "indicesToRemove"    # [I
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "viewsToAdd"    # [Lcom/facebook/react/uimanager/ViewAtIndex;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p5, "tagsToDelete"    # [I

    .prologue
    .line 171
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 172
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V

    .line 173
    iput-object p3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;->mIndicesToRemove:[I

    .line 174
    iput-object p4, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;->mViewsToAdd:[Lcom/facebook/react/uimanager/ViewAtIndex;

    .line 175
    iput-object p5, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;->mTagsToDelete:[I

    .line 176
    return-void
.end method


# virtual methods
.method public execute()V
    .locals 5

    .prologue
    .line 180
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;->mTag:I

    iget-object v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;->mIndicesToRemove:[I

    iget-object v3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;->mViewsToAdd:[Lcom/facebook/react/uimanager/ViewAtIndex;

    iget-object v4, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ManageChildrenOperation;->mTagsToDelete:[I

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->manageChildren(I[I[Lcom/facebook/react/uimanager/ViewAtIndex;[I)V

    .line 185
    return-void
.end method
