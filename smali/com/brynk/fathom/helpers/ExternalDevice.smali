.class public Lcom/brynk/fathom/helpers/ExternalDevice;
.super Ljava/lang/Object;
.source "ExternalDevice.java"


# instance fields
.field private DRONE_IP:Ljava/lang/String;

.field private ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

.field private controllerNeutral:Ljava/lang/Float;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/content/Context;)V
    .locals 1
    .param p1, "drone_ip"    # Ljava/lang/String;
    .param p2, "c"    # Landroid/content/Context;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    const v0, 0x3b808100

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->controllerNeutral:Ljava/lang/Float;

    .line 21
    iput-object p1, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->DRONE_IP:Ljava/lang/String;

    .line 22
    new-instance v0, Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-direct {v0, p2}, Lcom/brynk/fathom/helpers/CoordinateHelper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    .line 23
    return-void
.end method

.method private isPanning(Landroid/view/MotionEvent;)Z
    .locals 10
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v4, 0x1

    const-wide v8, 0x3f50624dd2f1a9fcL    # 0.001

    .line 119
    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 120
    .local v1, "thrust_value":Ljava/lang/Float;
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v5

    iget-object v6, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->controllerNeutral:Ljava/lang/Float;

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v6

    sub-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 122
    .local v0, "thrust_difference":Ljava/lang/Float;
    const/16 v5, 0xb

    invoke-virtual {p1, v5}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 123
    .local v3, "yaw_value":Ljava/lang/Float;
    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v5

    iget-object v6, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->controllerNeutral:Ljava/lang/Float;

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v6

    sub-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 125
    .local v2, "yaw_difference":Ljava/lang/Float;
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v5

    float-to-double v6, v5

    cmpg-double v5, v6, v8

    if-gez v5, :cond_0

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v5

    float-to-double v6, v5

    cmpl-double v5, v6, v8

    if-lez v5, :cond_0

    .line 128
    :goto_0
    return v4

    :cond_0
    const/4 v4, 0x0

    goto :goto_0
.end method

.method private setupThrusterTask(Ljava/net/DatagramSocket;)Lcom/brynk/fathom/api/ThrusterTask;
    .locals 2
    .param p1, "thruster_socket"    # Ljava/net/DatagramSocket;

    .prologue
    .line 111
    new-instance v0, Lcom/brynk/fathom/api/ThrusterTask;

    invoke-direct {v0}, Lcom/brynk/fathom/api/ThrusterTask;-><init>()V

    .line 112
    .local v0, "t_task":Lcom/brynk/fathom/api/ThrusterTask;
    iget-object v1, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/ThrusterTask;->setDRONE_IP(Ljava/lang/String;)V

    .line 113
    invoke-virtual {v0, p1}, Lcom/brynk/fathom/api/ThrusterTask;->setThruster_socket(Ljava/net/DatagramSocket;)V

    .line 114
    return-object v0
.end method


# virtual methods
.method public changePitchMinAndMax(Ljava/lang/Float;)V
    .locals 1
    .param p1, "t_mod"    # Ljava/lang/Float;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v0, p1}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changePitchMinAndMax(Ljava/lang/Float;)V

    .line 66
    return-void
.end method

.method public changeThrottleMinAndMax(Ljava/lang/Float;)V
    .locals 1
    .param p1, "t_mod"    # Ljava/lang/Float;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v0, p1}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changeThrottleMinAndMax(Ljava/lang/Float;)V

    .line 62
    return-void
.end method

.method public mapExternalControllerThruster(Ljava/lang/Float;)I
    .locals 10
    .param p1, "val"    # Ljava/lang/Float;

    .prologue
    const-wide v8, 0x3ee4f8b588e368f1L    # 1.0E-5

    .line 29
    move-object v2, p1

    .line 30
    .local v2, "rawY":Ljava/lang/Float;
    const/high16 v6, 0x3f800000    # 1.0f

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    .line 31
    .local v5, "y_upBound":Ljava/lang/Float;
    const/high16 v6, -0x40800000    # -1.0f

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 32
    .local v3, "y_downBound":Ljava/lang/Float;
    invoke-static {v8, v9}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    .line 33
    .local v1, "epsilon":Ljava/lang/Double;
    const v6, 0x3b808100

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 37
    .local v4, "y_neutral":Ljava/lang/Float;
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    .line 39
    .local v0, "bounded_y":Ljava/lang/Float;
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v6

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v7

    sub-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Math;->abs(F)F

    move-result v6

    float-to-double v6, v6

    cmpg-double v6, v6, v8

    if-gez v6, :cond_1

    .line 40
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    .line 55
    :cond_0
    :goto_0
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v6

    invoke-static {v6}, Ljava/lang/Math;->round(F)I

    move-result v6

    return v6

    .line 43
    :cond_1
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v6

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v7

    cmpg-float v6, v6, v7

    if-gez v6, :cond_2

    .line 45
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v6

    invoke-static {v6}, Ljava/lang/Math;->abs(F)F

    move-result v6

    sget-object v7, Lcom/brynk/fathom/helpers/Constants;->SERVO_MAX:Ljava/lang/Float;

    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v7

    sget-object v8, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v8

    sub-float/2addr v7, v8

    mul-float/2addr v6, v7

    sget-object v7, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v7

    add-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    goto :goto_0

    .line 47
    :cond_2
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v6

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v7

    cmpl-float v6, v6, v7

    if-lez v6, :cond_0

    .line 49
    sget-object v6, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v6

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v7

    invoke-static {v7}, Ljava/lang/Math;->abs(F)F

    move-result v7

    sget-object v8, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v8

    sget-object v9, Lcom/brynk/fathom/helpers/Constants;->SERVO_MIN:Ljava/lang/Float;

    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    mul-float/2addr v7, v8

    sub-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    goto :goto_0
.end method

.method public processCurrentEvent(Landroid/view/MotionEvent;Ljava/net/DatagramSocket;)V
    .locals 10
    .param p1, "event"    # Landroid/view/MotionEvent;
    .param p2, "thruster_socket"    # Ljava/net/DatagramSocket;

    .prologue
    const/4 v9, 0x1

    .line 91
    invoke-direct {p0, p2}, Lcom/brynk/fathom/helpers/ExternalDevice;->setupThrusterTask(Ljava/net/DatagramSocket;)Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v3

    .line 92
    .local v3, "thrusterTask":Lcom/brynk/fathom/api/ThrusterTask;
    invoke-direct {p0, p2}, Lcom/brynk/fathom/helpers/ExternalDevice;->setupThrusterTask(Ljava/net/DatagramSocket;)Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v1

    .line 102
    .local v1, "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    iget-object v5, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    const/16 v6, 0xb

    invoke-virtual {p1, v6}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v6

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    invoke-direct {p0, p1}, Lcom/brynk/fathom/helpers/ExternalDevice;->isPanning(Landroid/view/MotionEvent;)Z

    move-result v7

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v5, v6, v7, v8}, Lcom/brynk/fathom/helpers/CoordinateHelper;->mapExternalYawToServo(Ljava/lang/Float;Ljava/lang/Boolean;F)Ljava/lang/String;

    move-result-object v4

    .line 103
    .local v4, "yawValues":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    const/16 v7, 0xe

    invoke-virtual {p1, v7}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v7

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/brynk/fathom/helpers/CoordinateHelper;->mapExternalControllerPitch(Ljava/lang/Float;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 105
    .local v2, "pitchValue":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "EXTERNAL,"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v7

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/brynk/fathom/helpers/CoordinateHelper;->mapExternalControllerThruster(Ljava/lang/Float;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 107
    .local v0, "message":Ljava/lang/String;
    const-string v5, "FATHOM1"

    invoke-static {v5, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 108
    new-array v5, v9, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object v0, v5, v6

    invoke-virtual {v3, v5}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 109
    return-void
.end method

.method public processHistoricalEvents(Landroid/view/MotionEvent;Ljava/net/DatagramSocket;)V
    .locals 9
    .param p1, "event"    # Landroid/view/MotionEvent;
    .param p2, "thruster_socket"    # Ljava/net/DatagramSocket;

    .prologue
    .line 69
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getHistorySize()I

    move-result v0

    .line 70
    .local v0, "historySize":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getDevice()Landroid/view/InputDevice;

    move-result-object v2

    .line 74
    .local v2, "inputDevice":Landroid/view/InputDevice;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 80
    iget-object v5, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    const/16 v6, 0xb

    invoke-virtual {p1, v6}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v6

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    invoke-direct {p0, p1}, Lcom/brynk/fathom/helpers/ExternalDevice;->isPanning(Landroid/view/MotionEvent;)Z

    move-result v7

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v5, v6, v7, v8}, Lcom/brynk/fathom/helpers/CoordinateHelper;->mapExternalYawToServo(Ljava/lang/Float;Ljava/lang/Boolean;F)Ljava/lang/String;

    move-result-object v4

    .line 81
    .local v4, "yawValues":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    const/16 v7, 0xe

    invoke-virtual {p1, v7}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v7

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/brynk/fathom/helpers/CoordinateHelper;->mapExternalControllerPitch(Ljava/lang/Float;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 83
    .local v3, "pitchValue":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "EXTERNAL,"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/brynk/fathom/helpers/ExternalDevice;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    const/4 v7, 0x1

    invoke-virtual {p1, v7}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v7

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/brynk/fathom/helpers/CoordinateHelper;->mapExternalControllerThruster(Ljava/lang/Float;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 74
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 88
    .end local v3    # "pitchValue":Ljava/lang/String;
    .end local v4    # "yawValues":Ljava/lang/String;
    :cond_0
    return-void
.end method
