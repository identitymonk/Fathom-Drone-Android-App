.class public Lcom/facebook/react/views/imagehelper/MultiSourceHelper;
.super Ljava/lang/Object;
.source "MultiSourceHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method public static getBestSourceForSize(IILjava/util/List;)Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;
    .locals 2
    .param p0, "width"    # I
    .param p1, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Ljava/util/List",
            "<",
            "Lcom/facebook/react/views/imagehelper/ImageSource;",
            ">;)",
            "Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;"
        }
    .end annotation

    .prologue
    .line 58
    .local p2, "sources":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/react/views/imagehelper/ImageSource;>;"
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    invoke-static {p0, p1, p2, v0, v1}, Lcom/facebook/react/views/imagehelper/MultiSourceHelper;->getBestSourceForSize(IILjava/util/List;D)Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;

    move-result-object v0

    return-object v0
.end method

.method public static getBestSourceForSize(IILjava/util/List;D)Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;
    .locals 21
    .param p0, "width"    # I
    .param p1, "height"    # I
    .param p3, "multiplier"    # D
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Ljava/util/List",
            "<",
            "Lcom/facebook/react/views/imagehelper/ImageSource;",
            ">;D)",
            "Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;"
        }
    .end annotation

    .prologue
    .line 77
    .local p2, "sources":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/react/views/imagehelper/ImageSource;>;"
    invoke-interface/range {p2 .. p2}, Ljava/util/List;->isEmpty()Z

    move-result v14

    if-eqz v14, :cond_0

    .line 78
    new-instance v14, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    invoke-direct/range {v14 .. v17}, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;-><init>(Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/MultiSourceHelper$1;)V

    .line 114
    :goto_0
    return-object v14

    .line 82
    :cond_0
    invoke-interface/range {p2 .. p2}, Ljava/util/List;->size()I

    move-result v14

    const/4 v15, 0x1

    if-ne v14, v15, :cond_1

    .line 83
    new-instance v15, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;

    const/4 v14, 0x0

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/facebook/react/views/imagehelper/ImageSource;

    const/16 v16, 0x0

    const/16 v17, 0x0

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-direct {v15, v14, v0, v1}, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;-><init>(Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/MultiSourceHelper$1;)V

    move-object v14, v15

    goto :goto_0

    .line 88
    :cond_1
    if-lez p0, :cond_2

    if-gtz p1, :cond_3

    .line 89
    :cond_2
    new-instance v14, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    invoke-direct/range {v14 .. v17}, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;-><init>(Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/MultiSourceHelper$1;)V

    goto :goto_0

    .line 92
    :cond_3
    invoke-static {}, Lcom/facebook/imagepipeline/core/ImagePipelineFactory;->getInstance()Lcom/facebook/imagepipeline/core/ImagePipelineFactory;

    move-result-object v14

    invoke-virtual {v14}, Lcom/facebook/imagepipeline/core/ImagePipelineFactory;->getImagePipeline()Lcom/facebook/imagepipeline/core/ImagePipeline;

    move-result-object v8

    .line 93
    .local v8, "imagePipeline":Lcom/facebook/imagepipeline/core/ImagePipeline;
    const/4 v2, 0x0

    .line 94
    .local v2, "best":Lcom/facebook/react/views/imagehelper/ImageSource;
    const/4 v3, 0x0

    .line 95
    .local v3, "bestCached":Lcom/facebook/react/views/imagehelper/ImageSource;
    mul-int v14, p0, p1

    int-to-double v14, v14

    mul-double v12, v14, p3

    .line 96
    .local v12, "viewArea":D
    const-wide v6, 0x7fefffffffffffffL    # Double.MAX_VALUE

    .line 97
    .local v6, "bestPrecision":D
    const-wide v4, 0x7fefffffffffffffL    # Double.MAX_VALUE

    .line 98
    .local v4, "bestCachePrecision":D
    invoke-interface/range {p2 .. p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v14

    :cond_4
    :goto_1
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_7

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/facebook/react/views/imagehelper/ImageSource;

    .line 99
    .local v9, "source":Lcom/facebook/react/views/imagehelper/ImageSource;
    const-wide/high16 v16, 0x3ff0000000000000L    # 1.0

    invoke-virtual {v9}, Lcom/facebook/react/views/imagehelper/ImageSource;->getSize()D

    move-result-wide v18

    div-double v18, v18, v12

    sub-double v16, v16, v18

    invoke-static/range {v16 .. v17}, Ljava/lang/Math;->abs(D)D

    move-result-wide v10

    .line 100
    .local v10, "precision":D
    cmpg-double v15, v10, v6

    if-gez v15, :cond_5

    .line 101
    move-wide v6, v10

    .line 102
    move-object v2, v9

    .line 104
    :cond_5
    cmpg-double v15, v10, v4

    if-gez v15, :cond_4

    .line 105
    invoke-virtual {v9}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v15

    invoke-virtual {v8, v15}, Lcom/facebook/imagepipeline/core/ImagePipeline;->isInBitmapMemoryCache(Landroid/net/Uri;)Z

    move-result v15

    if-nez v15, :cond_6

    .line 106
    invoke-virtual {v9}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v15

    invoke-virtual {v8, v15}, Lcom/facebook/imagepipeline/core/ImagePipeline;->isInDiskCacheSync(Landroid/net/Uri;)Z

    move-result v15

    if-eqz v15, :cond_4

    .line 107
    :cond_6
    move-wide v4, v10

    .line 108
    move-object v3, v9

    goto :goto_1

    .line 111
    .end local v9    # "source":Lcom/facebook/react/views/imagehelper/ImageSource;
    .end local v10    # "precision":D
    :cond_7
    if-eqz v3, :cond_8

    if-eqz v2, :cond_8

    invoke-virtual {v3}, Lcom/facebook/react/views/imagehelper/ImageSource;->getSource()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v2}, Lcom/facebook/react/views/imagehelper/ImageSource;->getSource()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_8

    .line 112
    const/4 v3, 0x0

    .line 114
    :cond_8
    new-instance v14, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;

    const/4 v15, 0x0

    invoke-direct {v14, v2, v3, v15}, Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;-><init>(Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/MultiSourceHelper$1;)V

    goto/16 :goto_0
.end method
