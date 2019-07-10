.class public Lcom/facebook/react/bridge/ProxyJavaScriptExecutor;
.super Lcom/facebook/react/bridge/JavaScriptExecutor;
.source "ProxyJavaScriptExecutor.java"


# annotations
.annotation build Lcom/facebook/proguard/annotations/DoNotStrip;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/bridge/ProxyJavaScriptExecutor$Factory;
    }
.end annotation


# instance fields
.field private mJavaJSExecutor:Lcom/facebook/react/bridge/JavaJSExecutor;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 41
    invoke-static {}, Lcom/facebook/react/bridge/ReactBridge;->staticInit()V

    .line 42
    return-void
.end method

.method public constructor <init>(Lcom/facebook/react/bridge/JavaJSExecutor;)V
    .locals 1
    .param p1, "executor"    # Lcom/facebook/react/bridge/JavaJSExecutor;

    .prologue
    .line 52
    invoke-static {p1}, Lcom/facebook/react/bridge/ProxyJavaScriptExecutor;->initHybrid(Lcom/facebook/react/bridge/JavaJSExecutor;)Lcom/facebook/jni/HybridData;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/facebook/react/bridge/JavaScriptExecutor;-><init>(Lcom/facebook/jni/HybridData;)V

    .line 53
    iput-object p1, p0, Lcom/facebook/react/bridge/ProxyJavaScriptExecutor;->mJavaJSExecutor:Lcom/facebook/react/bridge/JavaJSExecutor;

    .line 54
    return-void
.end method

.method private static native initHybrid(Lcom/facebook/react/bridge/JavaJSExecutor;)Lcom/facebook/jni/HybridData;
.end method


# virtual methods
.method public close()V
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/facebook/react/bridge/ProxyJavaScriptExecutor;->mJavaJSExecutor:Lcom/facebook/react/bridge/JavaJSExecutor;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/facebook/react/bridge/ProxyJavaScriptExecutor;->mJavaJSExecutor:Lcom/facebook/react/bridge/JavaJSExecutor;

    invoke-interface {v0}, Lcom/facebook/react/bridge/JavaJSExecutor;->close()V

    .line 60
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/bridge/ProxyJavaScriptExecutor;->mJavaJSExecutor:Lcom/facebook/react/bridge/JavaJSExecutor;

    .line 62
    :cond_0
    return-void
.end method
