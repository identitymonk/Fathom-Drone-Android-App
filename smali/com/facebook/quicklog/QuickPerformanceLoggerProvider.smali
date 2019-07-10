.class public Lcom/facebook/quicklog/QuickPerformanceLoggerProvider;
.super Ljava/lang/Object;
.source "QuickPerformanceLoggerProvider.java"


# static fields
.field private static final sQuickPerformanceLogger:Lcom/facebook/quicklog/QuickPerformanceLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    new-instance v0, Lcom/facebook/quicklog/QuickPerformanceLogger;

    invoke-direct {v0}, Lcom/facebook/quicklog/QuickPerformanceLogger;-><init>()V

    sput-object v0, Lcom/facebook/quicklog/QuickPerformanceLoggerProvider;->sQuickPerformanceLogger:Lcom/facebook/quicklog/QuickPerformanceLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getQPLInstance()Lcom/facebook/quicklog/QuickPerformanceLogger;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/facebook/quicklog/QuickPerformanceLoggerProvider;->sQuickPerformanceLogger:Lcom/facebook/quicklog/QuickPerformanceLogger;

    return-object v0
.end method
