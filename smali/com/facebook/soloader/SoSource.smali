.class public abstract Lcom/facebook/soloader/SoSource;
.super Ljava/lang/Object;
.source "SoSource.java"


# static fields
.field public static final LOAD_FLAG_ALLOW_IMPLICIT_PROVISION:I = 0x1

.field public static final LOAD_RESULT_IMPLICITLY_PROVIDED:I = 0x2

.field public static final LOAD_RESULT_LOADED:I = 0x1

.field public static final LOAD_RESULT_NOT_FOUND:I = 0x0

.field public static final PREPARE_FLAG_ALLOW_ASYNC_INIT:I = 0x1


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addToLdLibraryPath(Ljava/util/Collection;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 78
    .local p1, "paths":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    return-void
.end method

.method public abstract loadLibrary(Ljava/lang/String;I)I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method protected prepare(I)V
    .locals 0
    .param p1, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 50
    return-void
.end method

.method public abstract unpackLibrary(Ljava/lang/String;)Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
