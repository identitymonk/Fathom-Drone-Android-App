.class Lcom/facebook/react/modules/location/LocationModule$LocationOptions;
.super Ljava/lang/Object;
.source "LocationModule.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/location/LocationModule;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LocationOptions"
.end annotation


# instance fields
.field private final distanceFilter:F

.field private final highAccuracy:Z

.field private final maximumAge:D

.field private final timeout:J


# direct methods
.method private constructor <init>(JDZF)V
    .locals 1
    .param p1, "timeout"    # J
    .param p3, "maximumAge"    # D
    .param p5, "highAccuracy"    # Z
    .param p6, "distanceFilter"    # F

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    iput-wide p1, p0, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;->timeout:J

    .line 89
    iput-wide p3, p0, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;->maximumAge:D

    .line 90
    iput-boolean p5, p0, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;->highAccuracy:Z

    .line 91
    iput p6, p0, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;->distanceFilter:F

    .line 92
    return-void
.end method

.method static synthetic access$300(Lcom/facebook/react/bridge/ReadableMap;)Lcom/facebook/react/modules/location/LocationModule$LocationOptions;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 77
    invoke-static {p0}, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;->fromReactMap(Lcom/facebook/react/bridge/ReadableMap;)Lcom/facebook/react/modules/location/LocationModule$LocationOptions;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/facebook/react/modules/location/LocationModule$LocationOptions;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$LocationOptions;

    .prologue
    .line 77
    iget-boolean v0, p0, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;->highAccuracy:Z

    return v0
.end method

.method static synthetic access$500(Lcom/facebook/react/modules/location/LocationModule$LocationOptions;)D
    .locals 2
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$LocationOptions;

    .prologue
    .line 77
    iget-wide v0, p0, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;->maximumAge:D

    return-wide v0
.end method

.method static synthetic access$600(Lcom/facebook/react/modules/location/LocationModule$LocationOptions;)J
    .locals 2
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$LocationOptions;

    .prologue
    .line 77
    iget-wide v0, p0, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;->timeout:J

    return-wide v0
.end method

.method static synthetic access$800(Lcom/facebook/react/modules/location/LocationModule$LocationOptions;)F
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$LocationOptions;

    .prologue
    .line 77
    iget v0, p0, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;->distanceFilter:F

    return v0
.end method

.method private static fromReactMap(Lcom/facebook/react/bridge/ReadableMap;)Lcom/facebook/react/modules/location/LocationModule$LocationOptions;
    .locals 8
    .param p0, "map"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 96
    const-string v0, "timeout"

    .line 97
    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "timeout"

    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v0

    double-to-long v2, v0

    .line 98
    .local v2, "timeout":J
    :goto_0
    const-string v0, "maximumAge"

    .line 99
    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "maximumAge"

    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    .line 100
    .local v4, "maximumAge":D
    :goto_1
    const-string v0, "enableHighAccuracy"

    .line 101
    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "enableHighAccuracy"

    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableMap;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v6, 0x1

    .line 102
    .local v6, "highAccuracy":Z
    :goto_2
    const-string v0, "distanceFilter"

    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "distanceFilter"

    .line 103
    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v0

    double-to-float v7, v0

    .line 106
    .local v7, "distanceFilter":F
    :goto_3
    new-instance v1, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;

    invoke-direct/range {v1 .. v7}, Lcom/facebook/react/modules/location/LocationModule$LocationOptions;-><init>(JDZF)V

    return-object v1

    .line 97
    .end local v2    # "timeout":J
    .end local v4    # "maximumAge":D
    .end local v6    # "highAccuracy":Z
    .end local v7    # "distanceFilter":F
    :cond_0
    const-wide v2, 0x7fffffffffffffffL

    goto :goto_0

    .line 99
    .restart local v2    # "timeout":J
    :cond_1
    const-wide/high16 v4, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    goto :goto_1

    .line 101
    .restart local v4    # "maximumAge":D
    :cond_2
    const/4 v6, 0x0

    goto :goto_2

    .line 103
    .restart local v6    # "highAccuracy":Z
    :cond_3
    const/high16 v7, 0x42c80000    # 100.0f

    goto :goto_3
.end method
