.class public interface abstract Lcom/facebook/react/uimanager/events/RCTEventEmitter;
.super Ljava/lang/Object;
.source "RCTEventEmitter.java"

# interfaces
.implements Lcom/facebook/react/bridge/JavaScriptModule;


# virtual methods
.method public abstract receiveEvent(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V
    .param p3    # Lcom/facebook/react/bridge/WritableMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract receiveTouches(Ljava/lang/String;Lcom/facebook/react/bridge/WritableArray;Lcom/facebook/react/bridge/WritableArray;)V
.end method
