.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$RemoveAnimationOperation;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$AnimationOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "RemoveAnimationOperation"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V
    .locals 0
    .param p2, "animationID"    # I

    .prologue
    .line 342
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RemoveAnimationOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 343
    invoke-direct {p0, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$AnimationOperation;-><init>(I)V

    .line 344
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;ILcom/facebook/react/uimanager/UIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/facebook/react/uimanager/UIViewOperationQueue$1;

    .prologue
    .line 340
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$RemoveAnimationOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 3

    .prologue
    .line 348
    iget-object v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RemoveAnimationOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v1}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$100(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/animation/AnimationRegistry;

    move-result-object v1

    iget v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RemoveAnimationOperation;->mAnimationID:I

    invoke-virtual {v1, v2}, Lcom/facebook/react/animation/AnimationRegistry;->getAnimation(I)Lcom/facebook/react/animation/Animation;

    move-result-object v0

    .line 349
    .local v0, "animation":Lcom/facebook/react/animation/Animation;
    if-eqz v0, :cond_0

    .line 350
    invoke-virtual {v0}, Lcom/facebook/react/animation/Animation;->cancel()V

    .line 352
    :cond_0
    return-void
.end method
