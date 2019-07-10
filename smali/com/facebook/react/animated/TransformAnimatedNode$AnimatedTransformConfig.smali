.class Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;
.super Lcom/facebook/react/animated/TransformAnimatedNode$TransformConfig;
.source "TransformAnimatedNode.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/animated/TransformAnimatedNode;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AnimatedTransformConfig"
.end annotation


# instance fields
.field public mNodeTag:I

.field final synthetic this$0:Lcom/facebook/react/animated/TransformAnimatedNode;


# direct methods
.method private constructor <init>(Lcom/facebook/react/animated/TransformAnimatedNode;)V
    .locals 1

    .prologue
    .line 29
    iput-object p1, p0, Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;->this$0:Lcom/facebook/react/animated/TransformAnimatedNode;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/facebook/react/animated/TransformAnimatedNode$TransformConfig;-><init>(Lcom/facebook/react/animated/TransformAnimatedNode;Lcom/facebook/react/animated/TransformAnimatedNode$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/animated/TransformAnimatedNode;Lcom/facebook/react/animated/TransformAnimatedNode$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/animated/TransformAnimatedNode;
    .param p2, "x1"    # Lcom/facebook/react/animated/TransformAnimatedNode$1;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;-><init>(Lcom/facebook/react/animated/TransformAnimatedNode;)V

    return-void
.end method
