.class Lcom/facebook/react/modules/core/Timing$1;
.super Ljava/lang/Object;
.source "Timing.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/core/Timing;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/devsupport/interfaces/DevSupportManager;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/facebook/react/modules/core/Timing$Timer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/core/Timing;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/core/Timing;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/core/Timing;

    .prologue
    .line 192
    iput-object p1, p0, Lcom/facebook/react/modules/core/Timing$1;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/facebook/react/modules/core/Timing$Timer;Lcom/facebook/react/modules/core/Timing$Timer;)I
    .locals 8
    .param p1, "lhs"    # Lcom/facebook/react/modules/core/Timing$Timer;
    .param p2, "rhs"    # Lcom/facebook/react/modules/core/Timing$Timer;

    .prologue
    const-wide/16 v6, 0x0

    .line 195
    invoke-static {p1}, Lcom/facebook/react/modules/core/Timing$Timer;->access$400(Lcom/facebook/react/modules/core/Timing$Timer;)J

    move-result-wide v2

    invoke-static {p2}, Lcom/facebook/react/modules/core/Timing$Timer;->access$400(Lcom/facebook/react/modules/core/Timing$Timer;)J

    move-result-wide v4

    sub-long v0, v2, v4

    .line 196
    .local v0, "diff":J
    cmp-long v2, v0, v6

    if-nez v2, :cond_0

    .line 197
    const/4 v2, 0x0

    .line 201
    :goto_0
    return v2

    .line 198
    :cond_0
    cmp-long v2, v0, v6

    if-gez v2, :cond_1

    .line 199
    const/4 v2, -0x1

    goto :goto_0

    .line 201
    :cond_1
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 192
    check-cast p1, Lcom/facebook/react/modules/core/Timing$Timer;

    check-cast p2, Lcom/facebook/react/modules/core/Timing$Timer;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/modules/core/Timing$1;->compare(Lcom/facebook/react/modules/core/Timing$Timer;Lcom/facebook/react/modules/core/Timing$Timer;)I

    move-result v0

    return v0
.end method
