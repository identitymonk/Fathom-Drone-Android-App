.class public interface abstract Lcom/facebook/react/bridge/Inspector$RemoteConnection;
.super Ljava/lang/Object;
.source "Inspector.java"


# annotations
.annotation build Lcom/facebook/proguard/annotations/DoNotStrip;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/bridge/Inspector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "RemoteConnection"
.end annotation


# virtual methods
.method public abstract onDisconnect()V
.end method

.method public abstract onMessage(Ljava/lang/String;)V
.end method
