.class public Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;
.super Ljava/lang/Object;
.source "HeadlessJsTaskConfig.java"


# instance fields
.field private final mAllowedInForeground:Z

.field private final mData:Lcom/facebook/react/bridge/WritableMap;

.field private final mTaskKey:Ljava/lang/String;

.field private final mTimeout:J


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V
    .locals 7
    .param p1, "taskKey"    # Ljava/lang/String;
    .param p2, "data"    # Lcom/facebook/react/bridge/WritableMap;

    .prologue
    .line 22
    const-wide/16 v4, 0x0

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    invoke-direct/range {v1 .. v6}, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;-><init>(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;JZ)V

    .line 23
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;J)V
    .locals 7
    .param p1, "taskKey"    # Ljava/lang/String;
    .param p2, "data"    # Lcom/facebook/react/bridge/WritableMap;
    .param p3, "timeout"    # J

    .prologue
    .line 31
    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-wide v4, p3

    invoke-direct/range {v1 .. v6}, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;-><init>(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;JZ)V

    .line 32
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;JZ)V
    .locals 1
    .param p1, "taskKey"    # Ljava/lang/String;
    .param p2, "data"    # Lcom/facebook/react/bridge/WritableMap;
    .param p3, "timeout"    # J
    .param p5, "allowedInForeground"    # Z

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p1, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->mTaskKey:Ljava/lang/String;

    .line 56
    iput-object p2, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->mData:Lcom/facebook/react/bridge/WritableMap;

    .line 57
    iput-wide p3, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->mTimeout:J

    .line 58
    iput-boolean p5, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->mAllowedInForeground:Z

    .line 59
    return-void
.end method


# virtual methods
.method getData()Lcom/facebook/react/bridge/WritableMap;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->mData:Lcom/facebook/react/bridge/WritableMap;

    return-object v0
.end method

.method getTaskKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->mTaskKey:Ljava/lang/String;

    return-object v0
.end method

.method getTimeout()J
    .locals 2

    .prologue
    .line 70
    iget-wide v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->mTimeout:J

    return-wide v0
.end method

.method isAllowedInForeground()Z
    .locals 1

    .prologue
    .line 74
    iget-boolean v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->mAllowedInForeground:Z

    return v0
.end method
