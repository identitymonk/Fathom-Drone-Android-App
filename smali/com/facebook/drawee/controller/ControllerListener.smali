.class public interface abstract Lcom/facebook/drawee/controller/ControllerListener;
.super Ljava/lang/Object;
.source "ControllerListener.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<INFO:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract onFailure(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract onFinalImageSet(Ljava/lang/String;Ljava/lang/Object;Landroid/graphics/drawable/Animatable;)V
    .param p2    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3    # Landroid/graphics/drawable/Animatable;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "TINFO;",
            "Landroid/graphics/drawable/Animatable;",
            ")V"
        }
    .end annotation
.end method

.method public abstract onIntermediateImageFailed(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract onIntermediateImageSet(Ljava/lang/String;Ljava/lang/Object;)V
    .param p2    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "TINFO;)V"
        }
    .end annotation
.end method

.method public abstract onRelease(Ljava/lang/String;)V
.end method

.method public abstract onSubmit(Ljava/lang/String;Ljava/lang/Object;)V
.end method
