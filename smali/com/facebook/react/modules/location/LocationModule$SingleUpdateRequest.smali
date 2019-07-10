.class Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;
.super Ljava/lang/Object;
.source "LocationModule.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/location/LocationModule;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingleUpdateRequest"
.end annotation


# static fields
.field private static final TWO_MINUTES:I = 0x1d4c0


# instance fields
.field private final mError:Lcom/facebook/react/bridge/Callback;

.field private final mHandler:Landroid/os/Handler;

.field private final mLocationListener:Landroid/location/LocationListener;

.field private final mLocationManager:Landroid/location/LocationManager;

.field private mOldLocation:Landroid/location/Location;

.field private final mProvider:Ljava/lang/String;

.field private final mSuccess:Lcom/facebook/react/bridge/Callback;

.field private final mTimeout:J

.field private final mTimeoutRunnable:Ljava/lang/Runnable;

.field private mTriggered:Z


# direct methods
.method private constructor <init>(Landroid/location/LocationManager;Ljava/lang/String;JLcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;)V
    .locals 1
    .param p1, "locationManager"    # Landroid/location/LocationManager;
    .param p2, "provider"    # Ljava/lang/String;
    .param p3, "timeout"    # J
    .param p5, "success"    # Lcom/facebook/react/bridge/Callback;
    .param p6, "error"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 298
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 253
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mHandler:Landroid/os/Handler;

    .line 254
    new-instance v0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;

    invoke-direct {v0, p0}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;-><init>(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)V

    iput-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mTimeoutRunnable:Ljava/lang/Runnable;

    .line 267
    new-instance v0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;

    invoke-direct {v0, p0}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;-><init>(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)V

    iput-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mLocationListener:Landroid/location/LocationListener;

    .line 299
    iput-object p1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mLocationManager:Landroid/location/LocationManager;

    .line 300
    iput-object p2, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mProvider:Ljava/lang/String;

    .line 301
    iput-wide p3, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mTimeout:J

    .line 302
    iput-object p5, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mSuccess:Lcom/facebook/react/bridge/Callback;

    .line 303
    iput-object p6, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mError:Lcom/facebook/react/bridge/Callback;

    .line 304
    return-void
.end method

.method synthetic constructor <init>(Landroid/location/LocationManager;Ljava/lang/String;JLcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/modules/location/LocationModule$1;)V
    .locals 1
    .param p1, "x0"    # Landroid/location/LocationManager;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # J
    .param p5, "x3"    # Lcom/facebook/react/bridge/Callback;
    .param p6, "x4"    # Lcom/facebook/react/bridge/Callback;
    .param p7, "x5"    # Lcom/facebook/react/modules/location/LocationModule$1;

    .prologue
    .line 245
    invoke-direct/range {p0 .. p6}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;-><init>(Landroid/location/LocationManager;Ljava/lang/String;JLcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Lcom/facebook/react/bridge/Callback;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    .prologue
    .line 245
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mError:Lcom/facebook/react/bridge/Callback;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/location/LocationListener;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    .prologue
    .line 245
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mLocationListener:Landroid/location/LocationListener;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/location/LocationManager;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    .prologue
    .line 245
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mLocationManager:Landroid/location/LocationManager;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/location/Location;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    .prologue
    .line 245
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mOldLocation:Landroid/location/Location;

    return-object v0
.end method

.method static synthetic access$1302(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;Landroid/location/Location;)Landroid/location/Location;
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;
    .param p1, "x1"    # Landroid/location/Location;

    .prologue
    .line 245
    iput-object p1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mOldLocation:Landroid/location/Location;

    return-object p1
.end method

.method static synthetic access$1400(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;Landroid/location/Location;Landroid/location/Location;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;
    .param p1, "x1"    # Landroid/location/Location;
    .param p2, "x2"    # Landroid/location/Location;

    .prologue
    .line 245
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->isBetterLocation(Landroid/location/Location;Landroid/location/Location;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$1500(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Lcom/facebook/react/bridge/Callback;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    .prologue
    .line 245
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mSuccess:Lcom/facebook/react/bridge/Callback;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    .prologue
    .line 245
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mTimeoutRunnable:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    .prologue
    .line 245
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$900(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    .prologue
    .line 245
    iget-boolean v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mTriggered:Z

    return v0
.end method

.method static synthetic access$902(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;
    .param p1, "x1"    # Z

    .prologue
    .line 245
    iput-boolean p1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mTriggered:Z

    return p1
.end method

.method private isBetterLocation(Landroid/location/Location;Landroid/location/Location;)Z
    .locals 14
    .param p1, "location"    # Landroid/location/Location;
    .param p2, "currentBestLocation"    # Landroid/location/Location;

    .prologue
    .line 321
    if-nez p2, :cond_0

    .line 323
    const/4 v10, 0x1

    .line 360
    :goto_0
    return v10

    .line 327
    :cond_0
    invoke-virtual {p1}, Landroid/location/Location;->getTime()J

    move-result-wide v10

    invoke-virtual/range {p2 .. p2}, Landroid/location/Location;->getTime()J

    move-result-wide v12

    sub-long v8, v10, v12

    .line 328
    .local v8, "timeDelta":J
    const-wide/32 v10, 0x1d4c0

    cmp-long v10, v8, v10

    if-lez v10, :cond_1

    const/4 v6, 0x1

    .line 329
    .local v6, "isSignificantlyNewer":Z
    :goto_1
    const-wide/32 v10, -0x1d4c0

    cmp-long v10, v8, v10

    if-gez v10, :cond_2

    const/4 v7, 0x1

    .line 330
    .local v7, "isSignificantlyOlder":Z
    :goto_2
    const-wide/16 v10, 0x0

    cmp-long v10, v8, v10

    if-lez v10, :cond_3

    const/4 v4, 0x1

    .line 334
    .local v4, "isNewer":Z
    :goto_3
    if-eqz v6, :cond_4

    .line 335
    const/4 v10, 0x1

    goto :goto_0

    .line 328
    .end local v4    # "isNewer":Z
    .end local v6    # "isSignificantlyNewer":Z
    .end local v7    # "isSignificantlyOlder":Z
    :cond_1
    const/4 v6, 0x0

    goto :goto_1

    .line 329
    .restart local v6    # "isSignificantlyNewer":Z
    :cond_2
    const/4 v7, 0x0

    goto :goto_2

    .line 330
    .restart local v7    # "isSignificantlyOlder":Z
    :cond_3
    const/4 v4, 0x0

    goto :goto_3

    .line 337
    .restart local v4    # "isNewer":Z
    :cond_4
    if-eqz v7, :cond_5

    .line 338
    const/4 v10, 0x0

    goto :goto_0

    .line 342
    :cond_5
    invoke-virtual {p1}, Landroid/location/Location;->getAccuracy()F

    move-result v10

    invoke-virtual/range {p2 .. p2}, Landroid/location/Location;->getAccuracy()F

    move-result v11

    sub-float/2addr v10, v11

    float-to-int v0, v10

    .line 343
    .local v0, "accuracyDelta":I
    if-lez v0, :cond_6

    const/4 v2, 0x1

    .line 344
    .local v2, "isLessAccurate":Z
    :goto_4
    if-gez v0, :cond_7

    const/4 v3, 0x1

    .line 345
    .local v3, "isMoreAccurate":Z
    :goto_5
    const/16 v10, 0xc8

    if-le v0, v10, :cond_8

    const/4 v5, 0x1

    .line 348
    .local v5, "isSignificantlyLessAccurate":Z
    :goto_6
    invoke-virtual {p1}, Landroid/location/Location;->getProvider()Ljava/lang/String;

    move-result-object v10

    .line 349
    invoke-virtual/range {p2 .. p2}, Landroid/location/Location;->getProvider()Ljava/lang/String;

    move-result-object v11

    .line 348
    invoke-direct {p0, v10, v11}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->isSameProvider(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    .line 352
    .local v1, "isFromSameProvider":Z
    if-eqz v3, :cond_9

    .line 353
    const/4 v10, 0x1

    goto :goto_0

    .line 343
    .end local v1    # "isFromSameProvider":Z
    .end local v2    # "isLessAccurate":Z
    .end local v3    # "isMoreAccurate":Z
    .end local v5    # "isSignificantlyLessAccurate":Z
    :cond_6
    const/4 v2, 0x0

    goto :goto_4

    .line 344
    .restart local v2    # "isLessAccurate":Z
    :cond_7
    const/4 v3, 0x0

    goto :goto_5

    .line 345
    .restart local v3    # "isMoreAccurate":Z
    :cond_8
    const/4 v5, 0x0

    goto :goto_6

    .line 354
    .restart local v1    # "isFromSameProvider":Z
    .restart local v5    # "isSignificantlyLessAccurate":Z
    :cond_9
    if-eqz v4, :cond_a

    if-nez v2, :cond_a

    .line 355
    const/4 v10, 0x1

    goto :goto_0

    .line 356
    :cond_a
    if-eqz v4, :cond_b

    if-nez v5, :cond_b

    if-eqz v1, :cond_b

    .line 357
    const/4 v10, 0x1

    goto :goto_0

    .line 360
    :cond_b
    const/4 v10, 0x0

    goto :goto_0
.end method

.method private isSameProvider(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p1, "provider1"    # Ljava/lang/String;
    .param p2, "provider2"    # Ljava/lang/String;

    .prologue
    .line 365
    if-nez p1, :cond_1

    .line 366
    if-nez p2, :cond_0

    const/4 v0, 0x1

    .line 368
    :goto_0
    return v0

    .line 366
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 368
    :cond_1
    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method


# virtual methods
.method public invoke(Landroid/location/Location;)V
    .locals 6
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    .line 307
    iput-object p1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mOldLocation:Landroid/location/Location;

    .line 308
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mLocationManager:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mProvider:Ljava/lang/String;

    const-wide/16 v2, 0x64

    const/high16 v4, 0x3f800000    # 1.0f

    iget-object v5, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mLocationListener:Landroid/location/LocationListener;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    .line 309
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mTimeoutRunnable:Ljava/lang/Runnable;

    iget-wide v2, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->mTimeout:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 310
    return-void
.end method
