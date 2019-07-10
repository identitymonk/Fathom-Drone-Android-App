.class public interface abstract Lcom/facebook/react/bridge/Promise;
.super Ljava/lang/Object;
.source "Promise.java"


# virtual methods
.method public abstract reject(Ljava/lang/String;)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract reject(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract reject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract reject(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract reject(Ljava/lang/Throwable;)V
.end method

.method public abstract resolve(Ljava/lang/Object;)V
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method
