.class public Lcom/facebook/react/uimanager/ReactRootViewTagGenerator;
.super Ljava/lang/Object;
.source "ReactRootViewTagGenerator.java"


# static fields
.field private static final ROOT_VIEW_TAG_INCREMENT:I = 0xa

.field private static sNextRootViewTag:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const/4 v0, 0x1

    sput v0, Lcom/facebook/react/uimanager/ReactRootViewTagGenerator;->sNextRootViewTag:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized getNextRootViewTag()I
    .locals 3

    .prologue
    .line 15
    const-class v2, Lcom/facebook/react/uimanager/ReactRootViewTagGenerator;

    monitor-enter v2

    :try_start_0
    sget v0, Lcom/facebook/react/uimanager/ReactRootViewTagGenerator;->sNextRootViewTag:I

    .line 16
    .local v0, "tag":I
    sget v1, Lcom/facebook/react/uimanager/ReactRootViewTagGenerator;->sNextRootViewTag:I

    add-int/lit8 v1, v1, 0xa

    sput v1, Lcom/facebook/react/uimanager/ReactRootViewTagGenerator;->sNextRootViewTag:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 17
    monitor-exit v2

    return v0

    .line 15
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method
