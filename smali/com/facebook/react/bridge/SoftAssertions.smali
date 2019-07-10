.class public Lcom/facebook/react/bridge/SoftAssertions;
.super Ljava/lang/Object;
.source "SoftAssertions.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static assertCondition(ZLjava/lang/String;)V
    .locals 1
    .param p0, "condition"    # Z
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 36
    if-nez p0, :cond_0

    .line 37
    new-instance v0, Lcom/facebook/react/bridge/AssertionException;

    invoke-direct {v0, p1}, Lcom/facebook/react/bridge/AssertionException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 39
    :cond_0
    return-void
.end method

.method public static assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p0    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)TT;"
        }
    .end annotation

    .prologue
    .line 45
    .local p0, "instance":Ljava/lang/Object;, "TT;"
    if-nez p0, :cond_0

    .line 46
    new-instance v0, Lcom/facebook/react/bridge/AssertionException;

    const-string v1, "Expected object to not be null!"

    invoke-direct {v0, v1}, Lcom/facebook/react/bridge/AssertionException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 48
    :cond_0
    return-object p0
.end method

.method public static assertUnreachable(Ljava/lang/String;)V
    .locals 1
    .param p0, "message"    # Ljava/lang/String;

    .prologue
    .line 28
    new-instance v0, Lcom/facebook/react/bridge/AssertionException;

    invoke-direct {v0, p0}, Lcom/facebook/react/bridge/AssertionException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
