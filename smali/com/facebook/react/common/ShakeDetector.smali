.class public Lcom/facebook/react/common/ShakeDetector;
.super Ljava/lang/Object;
.source "ShakeDetector.java"

# interfaces
.implements Landroid/hardware/SensorEventListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/common/ShakeDetector$ShakeListener;
    }
.end annotation


# static fields
.field private static final MIN_TIME_BETWEEN_SAMPLES_NS:J

.field private static final REQUIRED_FORCE:F = 13.042845f

.field private static final SHAKING_WINDOW_NS:F


# instance fields
.field private mAccelerationX:F

.field private mAccelerationY:F

.field private mAccelerationZ:F

.field private mLastShakeTimestamp:J

.field private mLastTimestamp:J

.field private mMinNumShakes:I

.field private mNumShakes:I

.field private mSensorManager:Landroid/hardware/SensorManager;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mShakeListener:Lcom/facebook/react/common/ShakeDetector$ShakeListener;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 28
    sget-object v0, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v2, 0x14

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 29
    invoke-virtual {v0, v2, v3, v1}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/facebook/react/common/ShakeDetector;->MIN_TIME_BETWEEN_SAMPLES_NS:J

    .line 31
    sget-object v0, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v2, 0x3

    sget-object v1, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    .line 32
    invoke-virtual {v0, v2, v3, v1}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    long-to-float v0, v0

    sput v0, Lcom/facebook/react/common/ShakeDetector;->SHAKING_WINDOW_NS:F

    .line 31
    return-void
.end method

.method public constructor <init>(Lcom/facebook/react/common/ShakeDetector$ShakeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/facebook/react/common/ShakeDetector$ShakeListener;

    .prologue
    .line 53
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/facebook/react/common/ShakeDetector;-><init>(Lcom/facebook/react/common/ShakeDetector$ShakeListener;I)V

    .line 54
    return-void
.end method

.method public constructor <init>(Lcom/facebook/react/common/ShakeDetector$ShakeListener;I)V
    .locals 0
    .param p1, "listener"    # Lcom/facebook/react/common/ShakeDetector$ShakeListener;
    .param p2, "minNumShakes"    # I

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    iput-object p1, p0, Lcom/facebook/react/common/ShakeDetector;->mShakeListener:Lcom/facebook/react/common/ShakeDetector$ShakeListener;

    .line 58
    iput p2, p0, Lcom/facebook/react/common/ShakeDetector;->mMinNumShakes:I

    .line 59
    return-void
.end method

.method private atLeastRequiredForce(F)Z
    .locals 2
    .param p1, "a"    # F

    .prologue
    .line 104
    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    move-result v0

    const v1, 0x4150af7e

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private maybeDispatchShake(J)V
    .locals 3
    .param p1, "currentTimestamp"    # J

    .prologue
    .line 147
    iget v0, p0, Lcom/facebook/react/common/ShakeDetector;->mNumShakes:I

    iget v1, p0, Lcom/facebook/react/common/ShakeDetector;->mMinNumShakes:I

    mul-int/lit8 v1, v1, 0x8

    if-lt v0, v1, :cond_0

    .line 148
    invoke-direct {p0}, Lcom/facebook/react/common/ShakeDetector;->reset()V

    .line 149
    iget-object v0, p0, Lcom/facebook/react/common/ShakeDetector;->mShakeListener:Lcom/facebook/react/common/ShakeDetector$ShakeListener;

    invoke-interface {v0}, Lcom/facebook/react/common/ShakeDetector$ShakeListener;->onShake()V

    .line 152
    :cond_0
    iget-wide v0, p0, Lcom/facebook/react/common/ShakeDetector;->mLastShakeTimestamp:J

    sub-long v0, p1, v0

    long-to-float v0, v0

    sget v1, Lcom/facebook/react/common/ShakeDetector;->SHAKING_WINDOW_NS:F

    cmpl-float v0, v0, v1

    if-lez v0, :cond_1

    .line 153
    invoke-direct {p0}, Lcom/facebook/react/common/ShakeDetector;->reset()V

    .line 155
    :cond_1
    return-void
.end method

.method private recordShake(J)V
    .locals 1
    .param p1, "timestamp"    # J

    .prologue
    .line 112
    iput-wide p1, p0, Lcom/facebook/react/common/ShakeDetector;->mLastShakeTimestamp:J

    .line 113
    iget v0, p0, Lcom/facebook/react/common/ShakeDetector;->mNumShakes:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/facebook/react/common/ShakeDetector;->mNumShakes:I

    .line 114
    return-void
.end method

.method private reset()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 90
    const/4 v0, 0x0

    iput v0, p0, Lcom/facebook/react/common/ShakeDetector;->mNumShakes:I

    .line 91
    iput v1, p0, Lcom/facebook/react/common/ShakeDetector;->mAccelerationX:F

    .line 92
    iput v1, p0, Lcom/facebook/react/common/ShakeDetector;->mAccelerationY:F

    .line 93
    iput v1, p0, Lcom/facebook/react/common/ShakeDetector;->mAccelerationZ:F

    .line 94
    return-void
.end method


# virtual methods
.method public onAccuracyChanged(Landroid/hardware/Sensor;I)V
    .locals 0
    .param p1, "sensor"    # Landroid/hardware/Sensor;
    .param p2, "i"    # I

    .prologue
    .line 144
    return-void
.end method

.method public onSensorChanged(Landroid/hardware/SensorEvent;)V
    .locals 9
    .param p1, "sensorEvent"    # Landroid/hardware/SensorEvent;

    .prologue
    const/4 v8, 0x0

    .line 118
    iget-wide v4, p1, Landroid/hardware/SensorEvent;->timestamp:J

    iget-wide v6, p0, Lcom/facebook/react/common/ShakeDetector;->mLastTimestamp:J

    sub-long/2addr v4, v6

    sget-wide v6, Lcom/facebook/react/common/ShakeDetector;->MIN_TIME_BETWEEN_SAMPLES_NS:J

    cmp-long v3, v4, v6

    if-gez v3, :cond_0

    .line 140
    :goto_0
    return-void

    .line 122
    :cond_0
    iget-object v3, p1, Landroid/hardware/SensorEvent;->values:[F

    const/4 v4, 0x0

    aget v0, v3, v4

    .line 123
    .local v0, "ax":F
    iget-object v3, p1, Landroid/hardware/SensorEvent;->values:[F

    const/4 v4, 0x1

    aget v1, v3, v4

    .line 124
    .local v1, "ay":F
    iget-object v3, p1, Landroid/hardware/SensorEvent;->values:[F

    const/4 v4, 0x2

    aget v3, v3, v4

    const v4, 0x411ce80a

    sub-float v2, v3, v4

    .line 126
    .local v2, "az":F
    iget-wide v4, p1, Landroid/hardware/SensorEvent;->timestamp:J

    iput-wide v4, p0, Lcom/facebook/react/common/ShakeDetector;->mLastTimestamp:J

    .line 128
    invoke-direct {p0, v0}, Lcom/facebook/react/common/ShakeDetector;->atLeastRequiredForce(F)Z

    move-result v3

    if-eqz v3, :cond_2

    iget v3, p0, Lcom/facebook/react/common/ShakeDetector;->mAccelerationX:F

    mul-float/2addr v3, v0

    cmpg-float v3, v3, v8

    if-gtz v3, :cond_2

    .line 129
    iget-wide v4, p1, Landroid/hardware/SensorEvent;->timestamp:J

    invoke-direct {p0, v4, v5}, Lcom/facebook/react/common/ShakeDetector;->recordShake(J)V

    .line 130
    iput v0, p0, Lcom/facebook/react/common/ShakeDetector;->mAccelerationX:F

    .line 139
    :cond_1
    :goto_1
    iget-wide v4, p1, Landroid/hardware/SensorEvent;->timestamp:J

    invoke-direct {p0, v4, v5}, Lcom/facebook/react/common/ShakeDetector;->maybeDispatchShake(J)V

    goto :goto_0

    .line 131
    :cond_2
    invoke-direct {p0, v1}, Lcom/facebook/react/common/ShakeDetector;->atLeastRequiredForce(F)Z

    move-result v3

    if-eqz v3, :cond_3

    iget v3, p0, Lcom/facebook/react/common/ShakeDetector;->mAccelerationY:F

    mul-float/2addr v3, v1

    cmpg-float v3, v3, v8

    if-gtz v3, :cond_3

    .line 132
    iget-wide v4, p1, Landroid/hardware/SensorEvent;->timestamp:J

    invoke-direct {p0, v4, v5}, Lcom/facebook/react/common/ShakeDetector;->recordShake(J)V

    .line 133
    iput v1, p0, Lcom/facebook/react/common/ShakeDetector;->mAccelerationY:F

    goto :goto_1

    .line 134
    :cond_3
    invoke-direct {p0, v2}, Lcom/facebook/react/common/ShakeDetector;->atLeastRequiredForce(F)Z

    move-result v3

    if-eqz v3, :cond_1

    iget v3, p0, Lcom/facebook/react/common/ShakeDetector;->mAccelerationZ:F

    mul-float/2addr v3, v2

    cmpg-float v3, v3, v8

    if-gtz v3, :cond_1

    .line 135
    iget-wide v4, p1, Landroid/hardware/SensorEvent;->timestamp:J

    invoke-direct {p0, v4, v5}, Lcom/facebook/react/common/ShakeDetector;->recordShake(J)V

    .line 136
    iput v2, p0, Lcom/facebook/react/common/ShakeDetector;->mAccelerationZ:F

    goto :goto_1
.end method

.method public start(Landroid/hardware/SensorManager;)V
    .locals 4
    .param p1, "manager"    # Landroid/hardware/SensorManager;

    .prologue
    .line 65
    invoke-static {p1}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v0

    .line 67
    .local v0, "accelerometer":Landroid/hardware/Sensor;
    if-eqz v0, :cond_0

    .line 68
    iput-object p1, p0, Lcom/facebook/react/common/ShakeDetector;->mSensorManager:Landroid/hardware/SensorManager;

    .line 69
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lcom/facebook/react/common/ShakeDetector;->mLastTimestamp:J

    .line 70
    iget-object v1, p0, Lcom/facebook/react/common/ShakeDetector;->mSensorManager:Landroid/hardware/SensorManager;

    const/4 v2, 0x2

    invoke-virtual {v1, p0, v0, v2}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    .line 71
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/facebook/react/common/ShakeDetector;->mLastShakeTimestamp:J

    .line 72
    invoke-direct {p0}, Lcom/facebook/react/common/ShakeDetector;->reset()V

    .line 74
    :cond_0
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/facebook/react/common/ShakeDetector;->mSensorManager:Landroid/hardware/SensorManager;

    if-eqz v0, :cond_0

    .line 81
    iget-object v0, p0, Lcom/facebook/react/common/ShakeDetector;->mSensorManager:Landroid/hardware/SensorManager;

    invoke-virtual {v0, p0}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    .line 82
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/common/ShakeDetector;->mSensorManager:Landroid/hardware/SensorManager;

    .line 84
    :cond_0
    return-void
.end method
