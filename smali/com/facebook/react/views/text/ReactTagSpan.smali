.class public Lcom/facebook/react/views/text/ReactTagSpan;
.super Ljava/lang/Object;
.source "ReactTagSpan.java"


# instance fields
.field private final mReactTag:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "reactTag"    # I

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput p1, p0, Lcom/facebook/react/views/text/ReactTagSpan;->mReactTag:I

    .line 22
    return-void
.end method


# virtual methods
.method public getReactTag()I
    .locals 1

    .prologue
    .line 25
    iget v0, p0, Lcom/facebook/react/views/text/ReactTagSpan;->mReactTag:I

    return v0
.end method
