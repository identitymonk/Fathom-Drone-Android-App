.class Lcom/facebook/react/animated/ValueAnimatedNode;
.super Lcom/facebook/react/animated/AnimatedNode;
.source "ValueAnimatedNode.java"


# instance fields
.field mOffset:D

.field mValue:D

.field private mValueListener:Lcom/facebook/react/animated/AnimatedNodeValueListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/facebook/react/animated/AnimatedNode;-><init>()V

    .line 21
    const-wide/high16 v0, 0x7ff8000000000000L    # Double.NaN

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    .line 22
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mOffset:D

    .line 27
    return-void
.end method

.method public constructor <init>(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 2
    .param p1, "config"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/facebook/react/animated/AnimatedNode;-><init>()V

    .line 21
    const-wide/high16 v0, 0x7ff8000000000000L    # Double.NaN

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    .line 22
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mOffset:D

    .line 30
    const-string v0, "value"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    .line 31
    const-string v0, "offset"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mOffset:D

    .line 32
    return-void
.end method


# virtual methods
.method public extractOffset()V
    .locals 4

    .prologue
    .line 44
    iget-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mOffset:D

    iget-wide v2, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    add-double/2addr v0, v2

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mOffset:D

    .line 45
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    .line 46
    return-void
.end method

.method public flattenOffset()V
    .locals 4

    .prologue
    .line 39
    iget-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    iget-wide v2, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mOffset:D

    add-double/2addr v0, v2

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    .line 40
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mOffset:D

    .line 41
    return-void
.end method

.method public getValue()D
    .locals 4

    .prologue
    .line 35
    iget-wide v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mOffset:D

    iget-wide v2, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    add-double/2addr v0, v2

    return-wide v0
.end method

.method public onValueUpdate()V
    .locals 4

    .prologue
    .line 49
    iget-object v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValueListener:Lcom/facebook/react/animated/AnimatedNodeValueListener;

    if-nez v0, :cond_0

    .line 53
    :goto_0
    return-void

    .line 52
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValueListener:Lcom/facebook/react/animated/AnimatedNodeValueListener;

    invoke-virtual {p0}, Lcom/facebook/react/animated/ValueAnimatedNode;->getValue()D

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lcom/facebook/react/animated/AnimatedNodeValueListener;->onValueUpdate(D)V

    goto :goto_0
.end method

.method public setValueListener(Lcom/facebook/react/animated/AnimatedNodeValueListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/facebook/react/animated/AnimatedNodeValueListener;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 56
    iput-object p1, p0, Lcom/facebook/react/animated/ValueAnimatedNode;->mValueListener:Lcom/facebook/react/animated/AnimatedNodeValueListener;

    .line 57
    return-void
.end method
