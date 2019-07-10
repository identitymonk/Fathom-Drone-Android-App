.class final Lcom/facebook/react/uimanager/TransformHelper$1;
.super Ljava/lang/ThreadLocal;
.source "TransformHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/TransformHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/ThreadLocal",
        "<[D>;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/ThreadLocal;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic initialValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 14
    invoke-virtual {p0}, Lcom/facebook/react/uimanager/TransformHelper$1;->initialValue()[D

    move-result-object v0

    return-object v0
.end method

.method protected initialValue()[D
    .locals 1

    .prologue
    .line 17
    const/16 v0, 0x10

    new-array v0, v0, [D

    return-object v0
.end method
