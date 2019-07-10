.class public Lcom/facebook/react/uimanager/NoSuchNativeViewException;
.super Lcom/facebook/react/uimanager/IllegalViewOperationException;
.source "NoSuchNativeViewException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/IllegalViewOperationException;-><init>(Ljava/lang/String;)V

    .line 20
    return-void
.end method
