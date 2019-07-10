.class Lcom/facebook/react/uimanager/UIViewOperationQueue$RegisterAnimationOperation;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$AnimationOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RegisterAnimationOperation"
.end annotation


# instance fields
.field private final mAnimation:Lcom/facebook/react/animation/Animation;

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/animation/Animation;)V
    .locals 1
    .param p2, "animation"    # Lcom/facebook/react/animation/Animation;

    .prologue
    .line 302
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RegisterAnimationOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 303
    invoke-virtual {p2}, Lcom/facebook/react/animation/Animation;->getAnimationID()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue$AnimationOperation;-><init>(I)V

    .line 304
    iput-object p2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RegisterAnimationOperation;->mAnimation:Lcom/facebook/react/animation/Animation;

    .line 305
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/animation/Animation;Lcom/facebook/react/uimanager/UIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;
    .param p2, "x1"    # Lcom/facebook/react/animation/Animation;
    .param p3, "x2"    # Lcom/facebook/react/uimanager/UIViewOperationQueue$1;

    .prologue
    .line 298
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$RegisterAnimationOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/animation/Animation;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 2

    .prologue
    .line 309
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RegisterAnimationOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$100(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/animation/AnimationRegistry;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RegisterAnimationOperation;->mAnimation:Lcom/facebook/react/animation/Animation;

    invoke-virtual {v0, v1}, Lcom/facebook/react/animation/AnimationRegistry;->registerAnimation(Lcom/facebook/react/animation/Animation;)V

    .line 310
    return-void
.end method
