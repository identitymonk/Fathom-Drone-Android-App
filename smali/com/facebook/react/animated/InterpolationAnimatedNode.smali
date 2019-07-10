.class Lcom/facebook/react/animated/InterpolationAnimatedNode;
.super Lcom/facebook/react/animated/ValueAnimatedNode;
.source "InterpolationAnimatedNode.java"


# static fields
.field public static final EXTRAPOLATE_TYPE_CLAMP:Ljava/lang/String; = "clamp"

.field public static final EXTRAPOLATE_TYPE_EXTEND:Ljava/lang/String; = "extend"

.field public static final EXTRAPOLATE_TYPE_IDENTITY:Ljava/lang/String; = "identity"


# instance fields
.field private final mExtrapolateLeft:Ljava/lang/String;

.field private final mExtrapolateRight:Ljava/lang/String;

.field private final mInputRange:[D

.field private final mOutputRange:[D

.field private mParent:Lcom/facebook/react/animated/ValueAnimatedNode;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 1
    .param p1, "config"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 107
    invoke-direct {p0}, Lcom/facebook/react/animated/ValueAnimatedNode;-><init>()V

    .line 108
    const-string v0, "inputRange"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/react/animated/InterpolationAnimatedNode;->fromDoubleArray(Lcom/facebook/react/bridge/ReadableArray;)[D

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mInputRange:[D

    .line 109
    const-string v0, "outputRange"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/react/animated/InterpolationAnimatedNode;->fromDoubleArray(Lcom/facebook/react/bridge/ReadableArray;)[D

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mOutputRange:[D

    .line 110
    const-string v0, "extrapolateLeft"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mExtrapolateLeft:Ljava/lang/String;

    .line 111
    const-string v0, "extrapolateRight"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mExtrapolateRight:Ljava/lang/String;

    .line 112
    return-void
.end method

.method private static findRangeIndex(D[D)I
    .locals 4
    .param p0, "value"    # D
    .param p2, "ranges"    # [D

    .prologue
    .line 93
    const/4 v0, 0x1

    .local v0, "index":I
    :goto_0
    array-length v1, p2

    add-int/lit8 v1, v1, -0x1

    if-ge v0, v1, :cond_0

    .line 94
    aget-wide v2, p2, v0

    cmpl-double v1, v2, p0

    if-ltz v1, :cond_1

    .line 98
    :cond_0
    add-int/lit8 v1, v0, -0x1

    return v1

    .line 93
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private static fromDoubleArray(Lcom/facebook/react/bridge/ReadableArray;)[D
    .locals 4
    .param p0, "ary"    # Lcom/facebook/react/bridge/ReadableArray;

    .prologue
    .line 21
    invoke-interface {p0}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    new-array v1, v2, [D

    .line 22
    .local v1, "res":[D
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_0

    .line 23
    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableArray;->getDouble(I)D

    move-result-wide v2

    aput-wide v2, v1, v0

    .line 22
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 25
    :cond_0
    return-object v1
.end method

.method private static interpolate(DDDDDLjava/lang/String;Ljava/lang/String;)D
    .locals 8
    .param p0, "value"    # D
    .param p2, "inputMin"    # D
    .param p4, "inputMax"    # D
    .param p6, "outputMin"    # D
    .param p8, "outputMax"    # D
    .param p10, "extrapolateLeft"    # Ljava/lang/String;
    .param p11, "extrapolateRight"    # Ljava/lang/String;

    .prologue
    .line 36
    move-wide v2, p0

    .line 39
    .local v2, "result":D
    cmpg-double v4, v2, p2

    if-gez v4, :cond_1

    .line 40
    const/4 v4, -0x1

    invoke-virtual/range {p10 .. p10}, Ljava/lang/String;->hashCode()I

    move-result v5

    sparse-switch v5, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v4, :pswitch_data_0

    .line 49
    new-instance v4, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid extrapolation type "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, p10

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "for left extrapolation"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 40
    :sswitch_0
    const-string v5, "identity"

    move-object/from16 v0, p10

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    const/4 v4, 0x0

    goto :goto_0

    :sswitch_1
    const-string v5, "clamp"

    move-object/from16 v0, p10

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    const/4 v4, 0x1

    goto :goto_0

    :sswitch_2
    const-string v5, "extend"

    move-object/from16 v0, p10

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    const/4 v4, 0x2

    goto :goto_0

    :pswitch_0
    move-wide v4, v2

    .line 69
    :goto_1
    return-wide v4

    .line 44
    :pswitch_1
    move-wide v2, p2

    .line 54
    :cond_1
    :pswitch_2
    cmpl-double v4, v2, p4

    if-lez v4, :cond_3

    .line 55
    const/4 v4, -0x1

    invoke-virtual/range {p11 .. p11}, Ljava/lang/String;->hashCode()I

    move-result v5

    sparse-switch v5, :sswitch_data_1

    :cond_2
    :goto_2
    packed-switch v4, :pswitch_data_1

    .line 64
    new-instance v4, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid extrapolation type "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, p11

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "for right extrapolation"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 55
    :sswitch_3
    const-string v5, "identity"

    move-object/from16 v0, p11

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v4, 0x0

    goto :goto_2

    :sswitch_4
    const-string v5, "clamp"

    move-object/from16 v0, p11

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v4, 0x1

    goto :goto_2

    :sswitch_5
    const-string v5, "extend"

    move-object/from16 v0, p11

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v4, 0x2

    goto :goto_2

    :pswitch_3
    move-wide v4, v2

    .line 57
    goto :goto_1

    .line 59
    :pswitch_4
    move-wide v2, p4

    .line 69
    :cond_3
    :pswitch_5
    sub-double v4, p8, p6

    sub-double v6, v2, p2

    mul-double/2addr v4, v6

    sub-double v6, p4, p2

    div-double/2addr v4, v6

    add-double/2addr v4, p6

    goto :goto_1

    .line 40
    nop

    :sswitch_data_0
    .sparse-switch
        -0x4cd540e6 -> :sswitch_2
        -0x8178f42 -> :sswitch_0
        0x5a5a8bb -> :sswitch_1
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch

    .line 55
    :sswitch_data_1
    .sparse-switch
        -0x4cd540e6 -> :sswitch_5
        -0x8178f42 -> :sswitch_3
        0x5a5a8bb -> :sswitch_4
    .end sparse-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method static interpolate(D[D[DLjava/lang/String;Ljava/lang/String;)D
    .locals 14
    .param p0, "value"    # D
    .param p2, "inputRange"    # [D
    .param p3, "outputRange"    # [D
    .param p4, "extrapolateLeft"    # Ljava/lang/String;
    .param p5, "extrapolateRight"    # Ljava/lang/String;

    .prologue
    .line 80
    invoke-static/range {p0 .. p2}, Lcom/facebook/react/animated/InterpolationAnimatedNode;->findRangeIndex(D[D)I

    move-result v12

    .line 81
    .local v12, "rangeIndex":I
    aget-wide v2, p2, v12

    add-int/lit8 v0, v12, 0x1

    aget-wide v4, p2, v0

    aget-wide v6, p3, v12

    add-int/lit8 v0, v12, 0x1

    aget-wide v8, p3, v0

    move-wide v0, p0

    move-object/from16 v10, p4

    move-object/from16 v11, p5

    invoke-static/range {v0 .. v11}, Lcom/facebook/react/animated/InterpolationAnimatedNode;->interpolate(DDDDDLjava/lang/String;Ljava/lang/String;)D

    move-result-wide v0

    return-wide v0
.end method


# virtual methods
.method public onAttachedToNode(Lcom/facebook/react/animated/AnimatedNode;)V
    .locals 2
    .param p1, "parent"    # Lcom/facebook/react/animated/AnimatedNode;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mParent:Lcom/facebook/react/animated/ValueAnimatedNode;

    if-eqz v0, :cond_0

    .line 117
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Parent already attached"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 119
    :cond_0
    instance-of v0, p1, Lcom/facebook/react/animated/ValueAnimatedNode;

    if-nez v0, :cond_1

    .line 120
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Parent is of an invalid type"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 122
    :cond_1
    check-cast p1, Lcom/facebook/react/animated/ValueAnimatedNode;

    .end local p1    # "parent":Lcom/facebook/react/animated/AnimatedNode;
    iput-object p1, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mParent:Lcom/facebook/react/animated/ValueAnimatedNode;

    .line 123
    return-void
.end method

.method public onDetachedFromNode(Lcom/facebook/react/animated/AnimatedNode;)V
    .locals 2
    .param p1, "parent"    # Lcom/facebook/react/animated/AnimatedNode;

    .prologue
    .line 127
    iget-object v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mParent:Lcom/facebook/react/animated/ValueAnimatedNode;

    if-eq p1, v0, :cond_0

    .line 128
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid parent node provided"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 130
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mParent:Lcom/facebook/react/animated/ValueAnimatedNode;

    .line 131
    return-void
.end method

.method public update()V
    .locals 6

    .prologue
    .line 135
    iget-object v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mParent:Lcom/facebook/react/animated/ValueAnimatedNode;

    if-nez v0, :cond_0

    .line 136
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Trying to update interpolation node that has not been attached to the parent"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 139
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mParent:Lcom/facebook/react/animated/ValueAnimatedNode;

    invoke-virtual {v0}, Lcom/facebook/react/animated/ValueAnimatedNode;->getValue()D

    move-result-wide v0

    iget-object v2, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mInputRange:[D

    iget-object v3, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mOutputRange:[D

    iget-object v4, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mExtrapolateLeft:Ljava/lang/String;

    iget-object v5, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mExtrapolateRight:Ljava/lang/String;

    invoke-static/range {v0 .. v5}, Lcom/facebook/react/animated/InterpolationAnimatedNode;->interpolate(D[D[DLjava/lang/String;Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/facebook/react/animated/InterpolationAnimatedNode;->mValue:D

    .line 140
    return-void
.end method
