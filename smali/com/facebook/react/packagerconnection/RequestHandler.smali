.class public interface abstract Lcom/facebook/react/packagerconnection/RequestHandler;
.super Ljava/lang/Object;
.source "RequestHandler.java"


# virtual methods
.method public abstract onNotification(Ljava/lang/Object;)V
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract onRequest(Ljava/lang/Object;Lcom/facebook/react/packagerconnection/Responder;)V
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method
