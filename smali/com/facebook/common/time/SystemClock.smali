.class public Lcom/facebook/common/time/SystemClock;
.super Ljava/lang/Object;
.source "SystemClock.java"

# interfaces
.implements Lcom/facebook/common/time/Clock;


# static fields
.field private static final INSTANCE:Lcom/facebook/common/time/SystemClock;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    new-instance v0, Lcom/facebook/common/time/SystemClock;

    invoke-direct {v0}, Lcom/facebook/common/time/SystemClock;-><init>()V

    sput-object v0, Lcom/facebook/common/time/SystemClock;->INSTANCE:Lcom/facebook/common/time/SystemClock;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method

.method public static get()Lcom/facebook/common/time/SystemClock;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/facebook/common/time/SystemClock;->INSTANCE:Lcom/facebook/common/time/SystemClock;

    return-object v0
.end method


# virtual methods
.method public now()J
    .locals 2

    .prologue
    .line 28
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    return-wide v0
.end method
