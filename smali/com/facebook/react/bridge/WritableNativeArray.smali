.class public Lcom/facebook/react/bridge/WritableNativeArray;
.super Lcom/facebook/react/bridge/ReadableNativeArray;
.source "WritableNativeArray.java"

# interfaces
.implements Lcom/facebook/react/bridge/WritableArray;


# annotations
.annotation build Lcom/facebook/proguard/annotations/DoNotStrip;
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 24
    invoke-static {}, Lcom/facebook/react/bridge/ReactBridge;->staticInit()V

    .line 25
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-static {}, Lcom/facebook/react/bridge/WritableNativeArray;->initHybrid()Lcom/facebook/jni/HybridData;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/facebook/react/bridge/ReadableNativeArray;-><init>(Lcom/facebook/jni/HybridData;)V

    .line 29
    return-void
.end method

.method private static native initHybrid()Lcom/facebook/jni/HybridData;
.end method

.method private native pushNativeArray(Lcom/facebook/react/bridge/WritableNativeArray;)V
.end method

.method private native pushNativeMap(Lcom/facebook/react/bridge/WritableNativeMap;)V
.end method


# virtual methods
.method public pushArray(Lcom/facebook/react/bridge/WritableArray;)V
    .locals 2
    .param p1, "array"    # Lcom/facebook/react/bridge/WritableArray;

    .prologue
    .line 45
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/facebook/react/bridge/WritableNativeArray;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    const-string v1, "Illegal type provided"

    invoke-static {v0, v1}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(ZLjava/lang/String;)V

    .line 47
    check-cast p1, Lcom/facebook/react/bridge/WritableNativeArray;

    .end local p1    # "array":Lcom/facebook/react/bridge/WritableArray;
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/WritableNativeArray;->pushNativeArray(Lcom/facebook/react/bridge/WritableNativeArray;)V

    .line 48
    return-void

    .line 45
    .restart local p1    # "array":Lcom/facebook/react/bridge/WritableArray;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public native pushBoolean(Z)V
.end method

.method public native pushDouble(D)V
.end method

.method public native pushInt(I)V
.end method

.method public pushMap(Lcom/facebook/react/bridge/WritableMap;)V
    .locals 2
    .param p1, "map"    # Lcom/facebook/react/bridge/WritableMap;

    .prologue
    .line 53
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/facebook/react/bridge/WritableNativeMap;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    const-string v1, "Illegal type provided"

    invoke-static {v0, v1}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(ZLjava/lang/String;)V

    .line 55
    check-cast p1, Lcom/facebook/react/bridge/WritableNativeMap;

    .end local p1    # "map":Lcom/facebook/react/bridge/WritableMap;
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/WritableNativeArray;->pushNativeMap(Lcom/facebook/react/bridge/WritableNativeMap;)V

    .line 56
    return-void

    .line 53
    .restart local p1    # "map":Lcom/facebook/react/bridge/WritableMap;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public native pushNull()V
.end method

.method public native pushString(Ljava/lang/String;)V
.end method
