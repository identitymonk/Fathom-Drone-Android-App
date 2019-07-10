.class Lcom/facebook/jni/DestructorThread$DestructorStack;
.super Ljava/lang/Object;
.source "DestructorThread.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/jni/DestructorThread;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DestructorStack"
.end annotation


# instance fields
.field private mHead:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Lcom/facebook/jni/DestructorThread$Destructor;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object v0, p0, Lcom/facebook/jni/DestructorThread$DestructorStack;->mHead:Ljava/util/concurrent/atomic/AtomicReference;

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/jni/DestructorThread$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/jni/DestructorThread$1;

    .prologue
    .line 88
    invoke-direct {p0}, Lcom/facebook/jni/DestructorThread$DestructorStack;-><init>()V

    return-void
.end method


# virtual methods
.method public push(Lcom/facebook/jni/DestructorThread$Destructor;)V
    .locals 2
    .param p1, "newHead"    # Lcom/facebook/jni/DestructorThread$Destructor;

    .prologue
    .line 94
    :cond_0
    iget-object v1, p0, Lcom/facebook/jni/DestructorThread$DestructorStack;->mHead:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/jni/DestructorThread$Destructor;

    .line 95
    .local v0, "oldHead":Lcom/facebook/jni/DestructorThread$Destructor;
    invoke-static {p1, v0}, Lcom/facebook/jni/DestructorThread$Destructor;->access$602(Lcom/facebook/jni/DestructorThread$Destructor;Lcom/facebook/jni/DestructorThread$Destructor;)Lcom/facebook/jni/DestructorThread$Destructor;

    .line 96
    iget-object v1, p0, Lcom/facebook/jni/DestructorThread$DestructorStack;->mHead:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v1, v0, p1}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 97
    return-void
.end method

.method public transferAllToList()V
    .locals 4

    .prologue
    .line 100
    iget-object v2, p0, Lcom/facebook/jni/DestructorThread$DestructorStack;->mHead:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicReference;->getAndSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/jni/DestructorThread$Destructor;

    .line 101
    .local v0, "current":Lcom/facebook/jni/DestructorThread$Destructor;
    :goto_0
    if-eqz v0, :cond_0

    .line 102
    invoke-static {v0}, Lcom/facebook/jni/DestructorThread$Destructor;->access$600(Lcom/facebook/jni/DestructorThread$Destructor;)Lcom/facebook/jni/DestructorThread$Destructor;

    move-result-object v1

    .line 103
    .local v1, "next":Lcom/facebook/jni/DestructorThread$Destructor;
    invoke-static {}, Lcom/facebook/jni/DestructorThread;->access$700()Lcom/facebook/jni/DestructorThread$DestructorList;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/facebook/jni/DestructorThread$DestructorList;->enqueue(Lcom/facebook/jni/DestructorThread$Destructor;)V

    .line 104
    move-object v0, v1

    .line 105
    goto :goto_0

    .line 106
    .end local v1    # "next":Lcom/facebook/jni/DestructorThread$Destructor;
    :cond_0
    return-void
.end method
