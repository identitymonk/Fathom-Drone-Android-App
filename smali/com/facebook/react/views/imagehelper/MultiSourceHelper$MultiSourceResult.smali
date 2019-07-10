.class public Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;
.super Ljava/lang/Object;
.source "MultiSourceHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/imagehelper/MultiSourceHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MultiSourceResult"
.end annotation


# instance fields
.field private final bestResult:Lcom/facebook/react/views/imagehelper/ImageSource;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final bestResultInCache:Lcom/facebook/react/views/imagehelper/ImageSource;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/ImageSource;)V
    .locals 0
    .param p1, "bestResult"    # Lcom/facebook/react/views/imagehelper/ImageSource;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p2, "bestResultInCache"    # Lcom/facebook/react/views/imagehelper/ImageSource;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;->bestResult:Lcom/facebook/react/views/imagehelper/ImageSource;

    .line 33
    iput-object p2, p0, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;->bestResultInCache:Lcom/facebook/react/views/imagehelper/ImageSource;

    .line 34
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/MultiSourceHelper$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/views/imagehelper/ImageSource;
    .param p2, "x1"    # Lcom/facebook/react/views/imagehelper/ImageSource;
    .param p3, "x2"    # Lcom/facebook/react/views/imagehelper/MultiSourceHelper$1;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;-><init>(Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/ImageSource;)V

    return-void
.end method


# virtual methods
.method public getBestResult()Lcom/facebook/react/views/imagehelper/ImageSource;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 41
    iget-object v0, p0, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;->bestResult:Lcom/facebook/react/views/imagehelper/ImageSource;

    return-object v0
.end method

.method public getBestResultInCache()Lcom/facebook/react/views/imagehelper/ImageSource;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;->bestResultInCache:Lcom/facebook/react/views/imagehelper/ImageSource;

    return-object v0
.end method
