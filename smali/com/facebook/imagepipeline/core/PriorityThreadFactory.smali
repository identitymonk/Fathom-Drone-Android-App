.class public Lcom/facebook/imagepipeline/core/PriorityThreadFactory;
.super Ljava/lang/Object;
.source "PriorityThreadFactory.java"

# interfaces
.implements Ljava/util/concurrent/ThreadFactory;


# instance fields
.field private final mThreadPriority:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "threadPriority"    # I

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput p1, p0, Lcom/facebook/imagepipeline/core/PriorityThreadFactory;->mThreadPriority:I

    .line 31
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/imagepipeline/core/PriorityThreadFactory;)I
    .locals 1
    .param p0, "x0"    # Lcom/facebook/imagepipeline/core/PriorityThreadFactory;

    .prologue
    .line 18
    iget v0, p0, Lcom/facebook/imagepipeline/core/PriorityThreadFactory;->mThreadPriority:I

    return v0
.end method


# virtual methods
.method public newThread(Ljava/lang/Runnable;)Ljava/lang/Thread;
    .locals 2
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 35
    new-instance v0, Lcom/facebook/imagepipeline/core/PriorityThreadFactory$1;

    invoke-direct {v0, p0, p1}, Lcom/facebook/imagepipeline/core/PriorityThreadFactory$1;-><init>(Lcom/facebook/imagepipeline/core/PriorityThreadFactory;Ljava/lang/Runnable;)V

    .line 46
    .local v0, "wrapperRunnable":Ljava/lang/Runnable;
    new-instance v1, Ljava/lang/Thread;

    invoke-direct {v1, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    return-object v1
.end method
