.class public abstract Lcom/facebook/systrace/SystraceMessage$Builder;
.super Ljava/lang/Object;
.source "SystraceMessage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/systrace/SystraceMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract arg(Ljava/lang/String;D)Lcom/facebook/systrace/SystraceMessage$Builder;
.end method

.method public abstract arg(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
.end method

.method public abstract arg(Ljava/lang/String;J)Lcom/facebook/systrace/SystraceMessage$Builder;
.end method

.method public abstract arg(Ljava/lang/String;Ljava/lang/Object;)Lcom/facebook/systrace/SystraceMessage$Builder;
.end method

.method public abstract flush()V
.end method
