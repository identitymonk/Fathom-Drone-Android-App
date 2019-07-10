.class public abstract Lcom/facebook/react/bridge/JavaScriptExecutor;
.super Ljava/lang/Object;
.source "JavaScriptExecutor.java"


# annotations
.annotation build Lcom/facebook/proguard/annotations/DoNotStrip;
.end annotation


# instance fields
.field private final mHybridData:Lcom/facebook/jni/HybridData;


# direct methods
.method protected constructor <init>(Lcom/facebook/jni/HybridData;)V
    .locals 0
    .param p1, "hybridData"    # Lcom/facebook/jni/HybridData;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/facebook/react/bridge/JavaScriptExecutor;->mHybridData:Lcom/facebook/jni/HybridData;

    .line 21
    return-void
.end method


# virtual methods
.method public close()V
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaScriptExecutor;->mHybridData:Lcom/facebook/jni/HybridData;

    invoke-virtual {v0}, Lcom/facebook/jni/HybridData;->resetNative()V

    .line 30
    return-void
.end method
