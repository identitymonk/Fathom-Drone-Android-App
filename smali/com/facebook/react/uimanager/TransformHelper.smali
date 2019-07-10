.class public Lcom/facebook/react/uimanager/TransformHelper;
.super Ljava/lang/Object;
.source "TransformHelper.java"


# static fields
.field private static sHelperMatrix:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<[D>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    new-instance v0, Lcom/facebook/react/uimanager/TransformHelper$1;

    invoke-direct {v0}, Lcom/facebook/react/uimanager/TransformHelper$1;-><init>()V

    sput-object v0, Lcom/facebook/react/uimanager/TransformHelper;->sHelperMatrix:Ljava/lang/ThreadLocal;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static convertToRadians(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)D
    .locals 7
    .param p0, "transformMap"    # Lcom/facebook/react/bridge/ReadableMap;
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 23
    const/4 v0, 0x1

    .line 24
    .local v0, "inRadians":Z
    invoke-interface {p0, p1}, Lcom/facebook/react/bridge/ReadableMap;->getType(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableType;

    move-result-object v4

    sget-object v5, Lcom/facebook/react/bridge/ReadableType;->String:Lcom/facebook/react/bridge/ReadableType;

    if-ne v4, v5, :cond_2

    .line 25
    invoke-interface {p0, p1}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 26
    .local v1, "stringValue":Ljava/lang/String;
    const-string v4, "rad"

    invoke-virtual {v1, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 27
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x3

    invoke-virtual {v1, v6, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 32
    :cond_0
    :goto_0
    invoke-static {v1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v4

    float-to-double v2, v4

    .line 36
    .end local v1    # "stringValue":Ljava/lang/String;
    .local v2, "value":D
    :goto_1
    if-eqz v0, :cond_3

    .end local v2    # "value":D
    :goto_2
    return-wide v2

    .line 28
    .restart local v1    # "stringValue":Ljava/lang/String;
    :cond_1
    const-string v4, "deg"

    invoke-virtual {v1, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 29
    const/4 v0, 0x0

    .line 30
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x3

    invoke-virtual {v1, v6, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 34
    .end local v1    # "stringValue":Ljava/lang/String;
    :cond_2
    invoke-interface {p0, p1}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    .restart local v2    # "value":D
    goto :goto_1

    .line 36
    :cond_3
    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/MatrixMathHelper;->degreesToRadians(D)D

    move-result-wide v2

    goto :goto_2
.end method

.method public static processTransform(Lcom/facebook/react/bridge/ReadableArray;[D)V
    .locals 24
    .param p0, "transforms"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p1, "result"    # [D

    .prologue
    .line 40
    sget-object v20, Lcom/facebook/react/uimanager/TransformHelper;->sHelperMatrix:Ljava/lang/ThreadLocal;

    invoke-virtual/range {v20 .. v20}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [D

    .line 41
    .local v5, "helperMatrix":[D
    invoke-static/range {p1 .. p1}, Lcom/facebook/react/uimanager/MatrixMathHelper;->resetIdentityMatrix([D)V

    .line 43
    const/16 v17, 0x0

    .local v17, "transformIdx":I
    invoke-interface/range {p0 .. p0}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v13

    .local v13, "size":I
    :goto_0
    move/from16 v0, v17

    if-ge v0, v13, :cond_10

    .line 44
    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableArray;->getMap(I)Lcom/facebook/react/bridge/ReadableMap;

    move-result-object v16

    .line 45
    .local v16, "transform":Lcom/facebook/react/bridge/ReadableMap;
    invoke-interface/range {v16 .. v16}, Lcom/facebook/react/bridge/ReadableMap;->keySetIterator()Lcom/facebook/react/bridge/ReadableMapKeySetIterator;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Lcom/facebook/react/bridge/ReadableMapKeySetIterator;->nextKey()Ljava/lang/String;

    move-result-object v18

    .line 47
    .local v18, "transformType":Ljava/lang/String;
    invoke-static {v5}, Lcom/facebook/react/uimanager/MatrixMathHelper;->resetIdentityMatrix([D)V

    .line 48
    const-string v20, "matrix"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_0

    .line 49
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v12

    .line 50
    .local v12, "matrix":Lcom/facebook/react/bridge/ReadableArray;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    const/16 v20, 0x10

    move/from16 v0, v20

    if-ge v4, v0, :cond_1

    .line 51
    invoke-interface {v12, v4}, Lcom/facebook/react/bridge/ReadableArray;->getDouble(I)D

    move-result-wide v20

    aput-wide v20, v5, v4

    .line 50
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 53
    .end local v4    # "i":I
    .end local v12    # "matrix":Lcom/facebook/react/bridge/ReadableArray;
    :cond_0
    const-string v20, "perspective"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_2

    .line 54
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v20

    move-wide/from16 v0, v20

    invoke-static {v5, v0, v1}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyPerspective([DD)V

    .line 98
    :cond_1
    :goto_2
    move-object/from16 v0, p1

    move-object/from16 v1, p1

    invoke-static {v0, v1, v5}, Lcom/facebook/react/uimanager/MatrixMathHelper;->multiplyInto([D[D[D)V

    .line 43
    add-int/lit8 v17, v17, 0x1

    goto :goto_0

    .line 55
    :cond_2
    const-string v20, "rotateX"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_3

    .line 58
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/facebook/react/uimanager/TransformHelper;->convertToRadians(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)D

    move-result-wide v20

    .line 56
    move-wide/from16 v0, v20

    invoke-static {v5, v0, v1}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyRotateX([DD)V

    goto :goto_2

    .line 59
    :cond_3
    const-string v20, "rotateY"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_4

    .line 62
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/facebook/react/uimanager/TransformHelper;->convertToRadians(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)D

    move-result-wide v20

    .line 60
    move-wide/from16 v0, v20

    invoke-static {v5, v0, v1}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyRotateY([DD)V

    goto :goto_2

    .line 63
    :cond_4
    const-string v20, "rotate"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-nez v20, :cond_5

    const-string v20, "rotateZ"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_6

    .line 66
    :cond_5
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/facebook/react/uimanager/TransformHelper;->convertToRadians(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)D

    move-result-wide v20

    .line 64
    move-wide/from16 v0, v20

    invoke-static {v5, v0, v1}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyRotateZ([DD)V

    goto :goto_2

    .line 67
    :cond_6
    const-string v20, "scale"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_7

    .line 68
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v14

    .line 69
    .local v14, "scale":D
    invoke-static {v5, v14, v15}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyScaleX([DD)V

    .line 70
    invoke-static {v5, v14, v15}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyScaleY([DD)V

    goto :goto_2

    .line 71
    .end local v14    # "scale":D
    :cond_7
    const-string v20, "scaleX"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_8

    .line 72
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v20

    move-wide/from16 v0, v20

    invoke-static {v5, v0, v1}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyScaleX([DD)V

    goto/16 :goto_2

    .line 73
    :cond_8
    const-string v20, "scaleY"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_9

    .line 74
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v20

    move-wide/from16 v0, v20

    invoke-static {v5, v0, v1}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyScaleY([DD)V

    goto/16 :goto_2

    .line 75
    :cond_9
    const-string v20, "translate"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_b

    .line 76
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v19

    .line 77
    .local v19, "value":Lcom/facebook/react/bridge/ReadableArray;
    const/16 v20, 0x0

    invoke-interface/range {v19 .. v20}, Lcom/facebook/react/bridge/ReadableArray;->getDouble(I)D

    move-result-wide v6

    .line 78
    .local v6, "x":D
    const/16 v20, 0x1

    invoke-interface/range {v19 .. v20}, Lcom/facebook/react/bridge/ReadableArray;->getDouble(I)D

    move-result-wide v8

    .line 79
    .local v8, "y":D
    invoke-interface/range {v19 .. v19}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v20

    const/16 v21, 0x2

    move/from16 v0, v20

    move/from16 v1, v21

    if-le v0, v1, :cond_a

    const/16 v20, 0x2

    invoke-interface/range {v19 .. v20}, Lcom/facebook/react/bridge/ReadableArray;->getDouble(I)D

    move-result-wide v10

    .line 80
    .local v10, "z":D
    :goto_3
    invoke-static/range {v5 .. v11}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyTranslate3D([DDDD)V

    goto/16 :goto_2

    .line 79
    .end local v10    # "z":D
    :cond_a
    const-wide/16 v10, 0x0

    goto :goto_3

    .line 81
    .end local v6    # "x":D
    .end local v8    # "y":D
    .end local v19    # "value":Lcom/facebook/react/bridge/ReadableArray;
    :cond_b
    const-string v20, "translateX"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_c

    .line 82
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v20

    const-wide/16 v22, 0x0

    move-wide/from16 v0, v20

    move-wide/from16 v2, v22

    invoke-static {v5, v0, v1, v2, v3}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyTranslate2D([DDD)V

    goto/16 :goto_2

    .line 83
    :cond_c
    const-string v20, "translateY"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_d

    .line 84
    const-wide/16 v20, 0x0

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v22

    move-wide/from16 v0, v20

    move-wide/from16 v2, v22

    invoke-static {v5, v0, v1, v2, v3}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applyTranslate2D([DDD)V

    goto/16 :goto_2

    .line 85
    :cond_d
    const-string v20, "skewX"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_e

    .line 88
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/facebook/react/uimanager/TransformHelper;->convertToRadians(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)D

    move-result-wide v20

    .line 86
    move-wide/from16 v0, v20

    invoke-static {v5, v0, v1}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applySkewX([DD)V

    goto/16 :goto_2

    .line 89
    :cond_e
    const-string v20, "skewY"

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_f

    .line 92
    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/facebook/react/uimanager/TransformHelper;->convertToRadians(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)D

    move-result-wide v20

    .line 90
    move-wide/from16 v0, v20

    invoke-static {v5, v0, v1}, Lcom/facebook/react/uimanager/MatrixMathHelper;->applySkewY([DD)V

    goto/16 :goto_2

    .line 94
    :cond_f
    new-instance v20, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Unsupported transform type: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-direct/range {v20 .. v21}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v20

    .line 100
    .end local v16    # "transform":Lcom/facebook/react/bridge/ReadableMap;
    .end local v18    # "transformType":Ljava/lang/String;
    :cond_10
    return-void
.end method
