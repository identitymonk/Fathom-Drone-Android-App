.class public interface abstract Lcom/facebook/cache/common/CacheEventListener;
.super Ljava/lang/Object;
.source "CacheEventListener.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/cache/common/CacheEventListener$EvictionReason;
    }
.end annotation


# virtual methods
.method public abstract onCleared()V
.end method

.method public abstract onEviction(Lcom/facebook/cache/common/CacheEvent;)V
.end method

.method public abstract onHit(Lcom/facebook/cache/common/CacheEvent;)V
.end method

.method public abstract onMiss(Lcom/facebook/cache/common/CacheEvent;)V
.end method

.method public abstract onReadException(Lcom/facebook/cache/common/CacheEvent;)V
.end method

.method public abstract onWriteAttempt(Lcom/facebook/cache/common/CacheEvent;)V
.end method

.method public abstract onWriteException(Lcom/facebook/cache/common/CacheEvent;)V
.end method

.method public abstract onWriteSuccess(Lcom/facebook/cache/common/CacheEvent;)V
.end method
