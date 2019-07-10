.class public Lcom/facebook/react/bridge/AssertionException;
.super Ljava/lang/RuntimeException;
.source "AssertionException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 21
    return-void
.end method
