.class public interface abstract Lcom/facebook/react/modules/core/JSTimers;
.super Ljava/lang/Object;
.source "JSTimers.java"

# interfaces
.implements Lcom/facebook/react/bridge/JavaScriptModule;


# virtual methods
.method public abstract callIdleCallbacks(D)V
.end method

.method public abstract callTimers(Lcom/facebook/react/bridge/WritableArray;)V
.end method

.method public abstract emitTimeDriftWarning(Ljava/lang/String;)V
.end method
