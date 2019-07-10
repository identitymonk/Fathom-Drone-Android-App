.class Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$AnimationOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AddAnimationOperation"
.end annotation


# instance fields
.field private final mReactTag:I

.field private final mSuccessCallback:Lcom/facebook/react/bridge/Callback;

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;IILcom/facebook/react/bridge/Callback;)V
    .locals 0
    .param p2, "reactTag"    # I
    .param p3, "animationID"    # I
    .param p4, "successCallback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 317
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 318
    invoke-direct {p0, p3}, Lcom/facebook/react/uimanager/UIViewOperationQueue$AnimationOperation;-><init>(I)V

    .line 319
    iput p2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;->mReactTag:I

    .line 320
    iput-object p4, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;->mSuccessCallback:Lcom/facebook/react/bridge/Callback;

    .line 321
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;IILcom/facebook/react/bridge/Callback;Lcom/facebook/react/uimanager/UIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # I
    .param p4, "x3"    # Lcom/facebook/react/bridge/Callback;
    .param p5, "x4"    # Lcom/facebook/react/uimanager/UIViewOperationQueue$1;

    .prologue
    .line 313
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;IILcom/facebook/react/bridge/Callback;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 4

    .prologue
    .line 325
    iget-object v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v1}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$100(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/animation/AnimationRegistry;

    move-result-object v1

    iget v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;->mAnimationID:I

    invoke-virtual {v1, v2}, Lcom/facebook/react/animation/AnimationRegistry;->getAnimation(I)Lcom/facebook/react/animation/Animation;

    move-result-object v0

    .line 326
    .local v0, "animation":Lcom/facebook/react/animation/Animation;
    if-eqz v0, :cond_0

    .line 327
    iget-object v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v1}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v1

    iget v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;->mReactTag:I

    iget-object v3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;->mSuccessCallback:Lcom/facebook/react/bridge/Callback;

    invoke-virtual {v1, v2, v0, v3}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->startAnimationForNativeView(ILcom/facebook/react/animation/Animation;Lcom/facebook/react/bridge/Callback;)V

    .line 337
    return-void

    .line 334
    :cond_0
    new-instance v1, Lcom/facebook/react/uimanager/IllegalViewOperationException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Animation with id "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$AddAnimationOperation;->mAnimationID:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " was not found"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/facebook/react/uimanager/IllegalViewOperationException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
