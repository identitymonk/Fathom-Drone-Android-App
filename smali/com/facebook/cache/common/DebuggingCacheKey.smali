.class public Lcom/facebook/cache/common/DebuggingCacheKey;
.super Lcom/facebook/cache/common/SimpleCacheKey;
.source "DebuggingCacheKey.java"


# instance fields
.field private final mCallerContext:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "callerContext"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/facebook/cache/common/SimpleCacheKey;-><init>(Ljava/lang/String;)V

    .line 24
    iput-object p2, p0, Lcom/facebook/cache/common/DebuggingCacheKey;->mCallerContext:Ljava/lang/Object;

    .line 25
    return-void
.end method


# virtual methods
.method public getCallerContext()Ljava/lang/Object;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/facebook/cache/common/DebuggingCacheKey;->mCallerContext:Ljava/lang/Object;

    return-object v0
.end method
