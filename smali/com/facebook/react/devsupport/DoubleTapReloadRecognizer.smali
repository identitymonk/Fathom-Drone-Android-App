.class public Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer;
.super Ljava/lang/Object;
.source "DoubleTapReloadRecognizer.java"


# static fields
.field private static final DOUBLE_TAP_DELAY:J = 0xc8L


# instance fields
.field private mDoRefresh:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer;->mDoRefresh:Z

    return-void
.end method

.method static synthetic access$002(Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer;
    .param p1, "x1"    # Z

    .prologue
    .line 21
    iput-boolean p1, p0, Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer;->mDoRefresh:Z

    return p1
.end method


# virtual methods
.method public didDoubleTapR(ILandroid/view/View;)Z
    .locals 6
    .param p1, "keyCode"    # I
    .param p2, "view"    # Landroid/view/View;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 26
    const/16 v2, 0x2e

    if-ne p1, v2, :cond_1

    instance-of v2, p2, Landroid/widget/EditText;

    if-nez v2, :cond_1

    .line 27
    iget-boolean v2, p0, Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer;->mDoRefresh:Z

    if-eqz v2, :cond_0

    .line 28
    iput-boolean v1, p0, Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer;->mDoRefresh:Z

    .line 42
    :goto_0
    return v0

    .line 31
    :cond_0
    iput-boolean v0, p0, Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer;->mDoRefresh:Z

    .line 32
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v2, Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer$1;

    invoke-direct {v2, p0}, Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer$1;-><init>(Lcom/facebook/react/devsupport/DoubleTapReloadRecognizer;)V

    const-wide/16 v4, 0xc8

    invoke-virtual {v0, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :cond_1
    move v0, v1

    .line 42
    goto :goto_0
.end method
