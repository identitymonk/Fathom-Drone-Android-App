.class public interface abstract Lcom/facebook/react/devsupport/DevServerHelper$SymbolicationListener;
.super Ljava/lang/Object;
.source "DevServerHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/devsupport/DevServerHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "SymbolicationListener"
.end annotation


# virtual methods
.method public abstract onSymbolicationComplete(Ljava/lang/Iterable;)V
    .param p1    # Ljava/lang/Iterable;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable",
            "<",
            "Lcom/facebook/react/devsupport/interfaces/StackFrame;",
            ">;)V"
        }
    .end annotation
.end method
