.class public Lcom/facebook/common/util/ExceptionWithNoStacktrace;
.super Ljava/lang/Exception;
.source "ExceptionWithNoStacktrace.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 22
    return-void
.end method


# virtual methods
.method public declared-synchronized fillInStackTrace()Ljava/lang/Throwable;
    .locals 0

    .prologue
    .line 18
    monitor-enter p0

    monitor-exit p0

    return-object p0
.end method
