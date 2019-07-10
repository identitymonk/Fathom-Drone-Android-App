.class Lcom/facebook/react/animated/SpringAnimation$PhysicsState;
.super Ljava/lang/Object;
.source "SpringAnimation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/animated/SpringAnimation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "PhysicsState"
.end annotation


# instance fields
.field position:D

.field velocity:D


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/animated/SpringAnimation$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/animated/SpringAnimation$1;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;-><init>()V

    return-void
.end method
