.class public Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
.super Landroid/app/Fragment;
.source "ReactActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/ReactActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DebugExampleTwoFragment"
.end annotation


# instance fields
.field private DRONE_IP:Ljava/lang/String;

.field private PHONE_LATITUDE:Ljava/lang/String;

.field private PHONE_LONGITUDE:Ljava/lang/String;

.field private ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

.field private drag_correction_forward:I

.field private drag_correction_reverse:I

.field private externalDevice:Lcom/brynk/fathom/helpers/ExternalDevice;

.field private isApplyingPitchYaw:Ljava/lang/Boolean;

.field private isApplyingThrust:Ljava/lang/Boolean;

.field private isAscending:Ljava/lang/Boolean;

.field private isDescending:Ljava/lang/Boolean;

.field private isMockDrone:Ljava/lang/Boolean;

.field private isRecording:Ljava/lang/Boolean;

.field private isZeroDegreeMode:Ljava/lang/Boolean;

.field private lightsOn:Ljava/lang/Boolean;

.field private mWebSocketClient:Lorg/java_websocket/client/WebSocketClient;

.field private path:Ljava/lang/String;

.field roll_socket:Ljava/net/DatagramSocket;

.field private scheduler:Ljava/util/concurrent/ScheduledExecutorService;

.field private shouldInvert:Ljava/lang/Boolean;

.field private shouldPitchHold:Ljava/lang/Boolean;

.field thruster_socket:Ljava/net/DatagramSocket;

.field private websocketConnected:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/16 v3, 0x177

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 226
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 227
    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    .line 228
    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->DRONE_IP:Ljava/lang/String;

    .line 230
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->shouldPitchHold:Ljava/lang/Boolean;

    .line 231
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->shouldInvert:Ljava/lang/Boolean;

    .line 232
    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    .line 234
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isRecording:Ljava/lang/Boolean;

    .line 235
    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->mWebSocketClient:Lorg/java_websocket/client/WebSocketClient;

    .line 236
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->websocketConnected:Ljava/lang/Boolean;

    .line 237
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->lightsOn:Ljava/lang/Boolean;

    .line 238
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isMockDrone:Ljava/lang/Boolean;

    .line 240
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isApplyingThrust:Ljava/lang/Boolean;

    .line 241
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isApplyingPitchYaw:Ljava/lang/Boolean;

    .line 242
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isZeroDegreeMode:Ljava/lang/Boolean;

    .line 244
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isAscending:Ljava/lang/Boolean;

    .line 245
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isDescending:Ljava/lang/Boolean;

    .line 247
    iput v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->drag_correction_reverse:I

    .line 248
    iput v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->drag_correction_forward:I

    .line 250
    const-string v0, "-1"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->PHONE_LATITUDE:Ljava/lang/String;

    .line 251
    const-string v0, "-1"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->PHONE_LONGITUDE:Ljava/lang/String;

    .line 257
    const-string v0, "udp://@:8000"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->path:Ljava/lang/String;

    .line 258
    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->thruster_socket:Ljava/net/DatagramSocket;

    .line 259
    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->roll_socket:Ljava/net/DatagramSocket;

    return-void
.end method

.method static synthetic access$000(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)Lcom/brynk/fathom/helpers/ExternalDevice;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    .prologue
    .line 226
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->externalDevice:Lcom/brynk/fathom/helpers/ExternalDevice;

    return-object v0
.end method

.method static synthetic access$100(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)Lcom/brynk/fathom/helpers/CoordinateHelper;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    .prologue
    .line 226
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;I)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
    .param p1, "x1"    # I

    .prologue
    .line 226
    invoke-direct {p0, p1}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->calculateDragCorrection(I)V

    return-void
.end method

.method static synthetic access$1100(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    .prologue
    .line 226
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->DRONE_IP:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1202(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
    .param p1, "x1"    # Ljava/lang/Boolean;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->websocketConnected:Ljava/lang/Boolean;

    return-object p1
.end method

.method static synthetic access$202(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
    .param p1, "x1"    # Ljava/lang/Boolean;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isApplyingThrust:Ljava/lang/Boolean;

    return-object p1
.end method

.method static synthetic access$300(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/util/ArrayList;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
    .param p1, "x1"    # Ljava/util/ArrayList;

    .prologue
    .line 226
    invoke-direct {p0, p1}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->positionThruster(Ljava/util/ArrayList;)V

    return-void
.end method

.method static synthetic access$400(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    .prologue
    .line 226
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->hideThruster()V

    return-void
.end method

.method static synthetic access$500(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/util/ArrayList;Landroid/view/MotionEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
    .param p1, "x1"    # Ljava/util/ArrayList;
    .param p2, "x2"    # Landroid/view/MotionEvent;

    .prologue
    .line 226
    invoke-direct {p0, p1, p2}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->moveThruster(Ljava/util/ArrayList;Landroid/view/MotionEvent;)V

    return-void
.end method

.method static synthetic access$602(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
    .param p1, "x1"    # Ljava/lang/Boolean;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isApplyingPitchYaw:Ljava/lang/Boolean;

    return-object p1
.end method

.method static synthetic access$700(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/util/ArrayList;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
    .param p1, "x1"    # Ljava/util/ArrayList;

    .prologue
    .line 226
    invoke-direct {p0, p1}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->positionPitch(Ljava/util/ArrayList;)V

    return-void
.end method

.method static synthetic access$800(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    .prologue
    .line 226
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->hidePitch()V

    return-void
.end method

.method static synthetic access$900(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/util/ArrayList;Landroid/view/MotionEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
    .param p1, "x1"    # Ljava/util/ArrayList;
    .param p2, "x2"    # Landroid/view/MotionEvent;

    .prologue
    .line 226
    invoke-direct {p0, p1, p2}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->movePitch(Ljava/util/ArrayList;Landroid/view/MotionEvent;)V

    return-void
.end method

.method private calculateDragCorrection(I)V
    .locals 1
    .param p1, "progress"    # I

    .prologue
    .line 1043
    add-int/lit8 p1, p1, -0x32

    .line 1046
    add-int/lit16 v0, p1, 0x177

    iput v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->drag_correction_forward:I

    .line 1047
    rsub-int v0, p1, 0x177

    iput v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->drag_correction_reverse:I

    .line 1049
    return-void
.end method

.method private connectWebSocket()V
    .locals 4

    .prologue
    .line 820
    :try_start_0
    new-instance v1, Ljava/net/URI;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "ws://"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":9000"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 827
    .local v1, "uri":Ljava/net/URI;
    new-instance v2, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$23;

    invoke-direct {v2, p0, v1}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$23;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/net/URI;)V

    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->mWebSocketClient:Lorg/java_websocket/client/WebSocketClient;

    .line 853
    iget-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->mWebSocketClient:Lorg/java_websocket/client/WebSocketClient;

    invoke-virtual {v2}, Lorg/java_websocket/client/WebSocketClient;->connect()V

    .line 854
    .end local v1    # "uri":Ljava/net/URI;
    :goto_0
    return-void

    .line 821
    :catch_0
    move-exception v0

    .line 822
    .local v0, "e":Ljava/net/URISyntaxException;
    invoke-virtual {v0}, Ljava/net/URISyntaxException;->printStackTrace()V

    goto :goto_0
.end method

.method private disconnectWebSocket()V
    .locals 1

    .prologue
    .line 856
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->mWebSocketClient:Lorg/java_websocket/client/WebSocketClient;

    invoke-virtual {v0}, Lorg/java_websocket/client/WebSocketClient;->close()V

    .line 857
    return-void
.end method

.method private hidePitch()V
    .locals 13

    .prologue
    const/4 v12, 0x4

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 578
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v7

    const v8, 0x7f0f00bf

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 579
    .local v0, "fab_rollStick":Landroid/support/design/widget/FloatingActionButton;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v7

    const v8, 0x7f0f00be

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 581
    .local v4, "tvRoll":Landroid/widget/TextView;
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v3

    .line 582
    .local v3, "thrusterTask_up":Lcom/brynk/fathom/api/ThrusterTask;
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v1

    .line 583
    .local v1, "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->shouldPitchHold:Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_1

    const-string v2, "PITCH_HOLD,375,1,1"

    .line 584
    .local v2, "pitchUpArgs":Ljava/lang/String;
    :goto_0
    new-array v7, v11, [Ljava/lang/String;

    aput-object v2, v7, v10

    invoke-virtual {v1, v7}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 585
    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isApplyingThrust:Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_2

    const-string v6, "999999"

    .line 587
    .local v6, "yaw_thrustValue":Ljava/lang/String;
    :goto_1
    new-array v7, v11, [Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "YAW,"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ",1,1"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v10

    invoke-virtual {v3, v7}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 589
    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isApplyingThrust:Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-nez v7, :cond_0

    .line 591
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v5

    .line 592
    .local v5, "yawNeutral":Lcom/brynk/fathom/api/ThrusterTask;
    new-array v7, v11, [Ljava/lang/String;

    const-string v8, "YAW,999999,1,1"

    aput-object v8, v7, v10

    invoke-virtual {v5, v7}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 601
    .end local v5    # "yawNeutral":Lcom/brynk/fathom/api/ThrusterTask;
    :cond_0
    invoke-virtual {v0, v12}, Landroid/support/design/widget/FloatingActionButton;->setVisibility(I)V

    .line 602
    invoke-virtual {v4, v12}, Landroid/widget/TextView;->setVisibility(I)V

    .line 603
    return-void

    .line 583
    .end local v2    # "pitchUpArgs":Ljava/lang/String;
    .end local v6    # "yaw_thrustValue":Ljava/lang/String;
    :cond_1
    const-string v2, "PITCH,375,1,1"

    goto :goto_0

    .line 585
    .restart local v2    # "pitchUpArgs":Ljava/lang/String;
    :cond_2
    const-string v6, "375"

    goto :goto_1
.end method

.method private hideThruster()V
    .locals 9

    .prologue
    const/4 v6, 0x4

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 606
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v4

    const v5, 0x7f0f00bc

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 607
    .local v1, "thrusterScale":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v4

    const v5, 0x7f0f00bd

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 609
    .local v2, "thrusterTick":Landroid/widget/TextView;
    invoke-virtual {v1, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 610
    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 612
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v3

    .line 613
    .local v3, "thruster_task_up":Lcom/brynk/fathom/api/ThrusterTask;
    new-array v4, v8, [Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "THRUST,"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v6}, Lcom/brynk/fathom/helpers/CoordinateHelper;->getThrusterNeutral()Ljava/lang/Float;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ",1,1"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 615
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v0

    .line 616
    .local v0, "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    new-array v4, v8, [Ljava/lang/String;

    const-string v5, "PITCH,375,1,1"

    aput-object v5, v4, v7

    invoke-virtual {v0, v4}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 618
    return-void
.end method

.method private movePitch(Ljava/util/ArrayList;Landroid/view/MotionEvent;)V
    .locals 13
    .param p1, "boundedCoords"    # Ljava/util/ArrayList;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 537
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v7

    const v8, 0x7f0f00bf

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 538
    .local v0, "fab_rollStick":Landroid/support/design/widget/FloatingActionButton;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v7

    const v8, 0x7f0f00be

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 540
    .local v3, "tvRoll":Landroid/widget/TextView;
    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v7, p2, v3}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundCoord(Landroid/view/MotionEvent;Landroid/widget/TextView;)Ljava/util/ArrayList;

    move-result-object v4

    .line 543
    .local v4, "tvRollBounds":Ljava/util/ArrayList;
    const/4 v7, 0x0

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Float;

    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v7

    invoke-virtual {v0}, Landroid/support/design/widget/FloatingActionButton;->getWidth()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    int-to-float v8, v8

    sub-float/2addr v7, v8

    invoke-virtual {v0, v7}, Landroid/support/design/widget/FloatingActionButton;->setX(F)V

    .line 544
    const/4 v7, 0x1

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Float;

    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v7

    invoke-virtual {v0}, Landroid/support/design/widget/FloatingActionButton;->getHeight()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    int-to-float v8, v8

    sub-float/2addr v7, v8

    invoke-virtual {v0, v7}, Landroid/support/design/widget/FloatingActionButton;->setY(F)V

    .line 547
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v2

    .line 548
    .local v2, "thrusterTask":Lcom/brynk/fathom/api/ThrusterTask;
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v1

    .line 549
    .local v1, "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "PITCH,"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    iget-object v11, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->shouldInvert:Ljava/lang/Boolean;

    const/high16 v12, 0x42f00000    # 120.0f

    invoke-virtual {v10, p2, v3, v11, v12}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundPitch(Landroid/view/MotionEvent;Landroid/widget/TextView;Ljava/lang/Boolean;F)Ljava/lang/Float;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ",1,1"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v1, v7}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 550
    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isApplyingThrust:Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_0

    const-string v6, "999999"

    .line 551
    .local v6, "yaw_thrustValue":Ljava/lang/String;
    :goto_0
    iget-object v8, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    const/4 v7, 0x0

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Float;

    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v7

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    iget-object v9, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isZeroDegreeMode:Ljava/lang/Boolean;

    const/high16 v10, 0x42f00000    # 120.0f

    invoke-virtual {v8, v7, v3, v9, v10}, Lcom/brynk/fathom/helpers/CoordinateHelper;->mapYawToServo(Ljava/lang/Float;Landroid/widget/TextView;Ljava/lang/Boolean;F)Ljava/lang/String;

    move-result-object v5

    .line 552
    .local v5, "yaw_scaleValues":Ljava/lang/String;
    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "YAW,"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ","

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v2, v7}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 558
    return-void

    .line 550
    .end local v5    # "yaw_scaleValues":Ljava/lang/String;
    .end local v6    # "yaw_thrustValue":Ljava/lang/String;
    :cond_0
    const-string v6, "999999"

    goto :goto_0
.end method

.method private moveThruster(Ljava/util/ArrayList;Landroid/view/MotionEvent;)V
    .locals 11
    .param p1, "boundedCoords"    # Ljava/util/ArrayList;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 561
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v6

    const v7, 0x7f0f00bd

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 562
    .local v3, "thrusterTick":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v6

    const v7, 0x7f0f00bb

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 563
    .local v5, "tvThruster":Landroid/widget/TextView;
    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {p1, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Float;

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v6

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    invoke-virtual {v7, v6, v5}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundThrusterTick(Ljava/lang/Float;Landroid/widget/TextView;)Ljava/lang/Float;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v6

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setY(F)V

    .line 565
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v4

    .line 566
    .local v4, "thruster_task":Lcom/brynk/fathom/api/ThrusterTask;
    iget-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v6, p2, v5, v7, v8}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundThruster(Landroid/view/MotionEvent;Landroid/widget/TextView;Ljava/lang/Boolean;F)Ljava/lang/Float;

    move-result-object v2

    .line 567
    .local v2, "thrust_Value":Ljava/lang/Float;
    new-array v6, v10, [Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "THRUST,"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ",1,1"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-virtual {v4, v6}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 569
    iget-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isApplyingPitchYaw:Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    if-nez v6, :cond_0

    .line 570
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v1

    .line 572
    .local v1, "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v6

    sget-object v7, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v7

    cmpl-float v6, v6, v7

    if-lez v6, :cond_1

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->drag_correction_forward:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 573
    .local v0, "drag_correction_value":Ljava/lang/String;
    :goto_0
    new-array v6, v10, [Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "PITCH_HOLD,"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ",1,1"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-virtual {v1, v6}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 575
    .end local v0    # "drag_correction_value":Ljava/lang/String;
    .end local v1    # "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    :cond_0
    return-void

    .line 572
    .restart local v1    # "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    :cond_1
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->drag_correction_reverse:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private positionPitch(Ljava/util/ArrayList;)V
    .locals 7
    .param p1, "boundedCoords"    # Ljava/util/ArrayList;

    .prologue
    const/4 v6, 0x1

    const/high16 v5, 0x43160000    # 150.0f

    const/4 v4, 0x0

    .line 621
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0f00bf

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 622
    .local v0, "fab_rollStick":Landroid/support/design/widget/FloatingActionButton;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0f00be

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 624
    .local v1, "tvRoll":Landroid/widget/TextView;
    invoke-virtual {p1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-virtual {v0}, Landroid/support/design/widget/FloatingActionButton;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    sub-float/2addr v2, v3

    invoke-virtual {v0, v2}, Landroid/support/design/widget/FloatingActionButton;->setX(F)V

    .line 625
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-virtual {v0}, Landroid/support/design/widget/FloatingActionButton;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    sub-float/2addr v2, v3

    invoke-virtual {v0, v2}, Landroid/support/design/widget/FloatingActionButton;->setY(F)V

    .line 626
    invoke-virtual {v0, v4}, Landroid/support/design/widget/FloatingActionButton;->setVisibility(I)V

    .line 628
    invoke-virtual {p1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    sub-float/2addr v2, v5

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setX(F)V

    .line 629
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    sub-float/2addr v2, v5

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setY(F)V

    .line 630
    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 631
    return-void
.end method

.method private positionThruster(Ljava/util/ArrayList;)V
    .locals 8
    .param p1, "boundedCoords"    # Ljava/util/ArrayList;

    .prologue
    const/high16 v7, 0x43160000    # 150.0f

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 635
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v3

    const v4, 0x7f0f00bc

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 636
    .local v0, "thrusterScale":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v3

    const v4, 0x7f0f00bd

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 637
    .local v1, "thrusterTick":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v3

    const v4, 0x7f0f00bb

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 639
    .local v2, "tvThruster":Landroid/widget/TextView;
    invoke-virtual {p1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    const/high16 v4, 0x42c80000    # 100.0f

    sub-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setX(F)V

    .line 640
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float/2addr v3, v7

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setY(F)V

    .line 642
    invoke-virtual {p1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    const/high16 v4, 0x42f00000    # 120.0f

    add-float/2addr v3, v4

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setX(F)V

    .line 643
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    const/high16 v4, 0x43480000    # 200.0f

    sub-float/2addr v3, v4

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setY(F)V

    .line 644
    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 646
    invoke-virtual {p1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    add-float/2addr v3, v7

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setX(F)V

    .line 647
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setY(F)V

    .line 648
    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 652
    return-void
.end method

.method private setupTelemtry()V
    .locals 9

    .prologue
    const/4 v4, 0x0

    const-wide/16 v2, 0x0

    .line 732
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    .line 733
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v7

    .line 739
    .local v7, "rootView":Landroid/view/View;
    new-instance v8, Lcom/brynk/fathom/api/TelemetryServerTask;

    invoke-virtual {v7}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {v8, v0, v7}, Lcom/brynk/fathom/api/TelemetryServerTask;-><init>(Landroid/content/Context;Landroid/view/View;)V

    .line 740
    .local v8, "tst":Lcom/brynk/fathom/api/TelemetryServerTask;
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    .line 741
    sget-object v0, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v1, v4, [Ljava/lang/String;

    invoke-virtual {v8, v0, v1}, Lcom/brynk/fathom/api/TelemetryServerTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 757
    :goto_0
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$19;

    invoke-direct {v1, p0, v7}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$19;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Landroid/view/View;)V

    const-wide/16 v4, 0x1e

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 774
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$20;

    invoke-direct {v1, p0, v7}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$20;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Landroid/view/View;)V

    const-wide/16 v4, 0xa

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 782
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$21;

    invoke-direct {v1, p0, v7}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$21;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Landroid/view/View;)V

    const-wide/16 v4, 0x1

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MINUTES:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 791
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$22;

    invoke-direct {v1, p0, v7}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$22;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Landroid/view/View;)V

    const-wide/16 v4, 0x3

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 799
    return-void

    .line 743
    :cond_0
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, ""

    aput-object v1, v0, v4

    invoke-virtual {v8, v0}, Lcom/brynk/fathom/api/TelemetryServerTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method private setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;
    .locals 2

    .prologue
    .line 530
    new-instance v0, Lcom/brynk/fathom/api/ThrusterTask;

    invoke-direct {v0}, Lcom/brynk/fathom/api/ThrusterTask;-><init>()V

    .line 531
    .local v0, "t_task":Lcom/brynk/fathom/api/ThrusterTask;
    iget-object v1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/ThrusterTask;->setDRONE_IP(Ljava/lang/String;)V

    .line 532
    iget-object v1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->thruster_socket:Ljava/net/DatagramSocket;

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/ThrusterTask;->setThruster_socket(Ljava/net/DatagramSocket;)V

    .line 533
    return-object v0
.end method

.method private setupUDP()V
    .locals 2

    .prologue
    .line 522
    :try_start_0
    new-instance v1, Ljava/net/DatagramSocket;

    invoke-direct {v1}, Ljava/net/DatagramSocket;-><init>()V

    iput-object v1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->thruster_socket:Ljava/net/DatagramSocket;

    .line 523
    new-instance v1, Ljava/net/DatagramSocket;

    invoke-direct {v1}, Ljava/net/DatagramSocket;-><init>()V

    iput-object v1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->roll_socket:Ljava/net/DatagramSocket;
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_0

    .line 528
    :goto_0
    return-void

    .line 524
    :catch_0
    move-exception v0

    .line 525
    .local v0, "e":Ljava/net/SocketException;
    invoke-virtual {v0}, Ljava/net/SocketException;->printStackTrace()V

    goto :goto_0
.end method

.method private startOrStopRecording(Z)V
    .locals 8
    .param p1, "shouldRecord"    # Z

    .prologue
    .line 859
    if-eqz p1, :cond_0

    const-string v4, "start"

    .line 860
    .local v4, "startOrStop":Ljava/lang/String;
    :goto_0
    const-string v3, ""

    .line 861
    .local v3, "payload":Ljava/lang/String;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    .line 862
    .local v0, "currentTime":Ljava/util/Date;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 865
    .local v1, "currentTimeString":Ljava/lang/String;
    :try_start_0
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    const-string v6, "recording"

    invoke-virtual {v5, v6, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "latitude"

    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->PHONE_LATITUDE:Ljava/lang/String;

    invoke-virtual {v5, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "longitude"

    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->PHONE_LONGITUDE:Ljava/lang/String;

    invoke-virtual {v5, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "when"

    invoke-virtual {v5, v6, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v5

    invoke-virtual {v5}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 871
    :goto_1
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->mWebSocketClient:Lorg/java_websocket/client/WebSocketClient;

    invoke-virtual {v5, v3}, Lorg/java_websocket/client/WebSocketClient;->send(Ljava/lang/String;)V

    .line 872
    return-void

    .line 859
    .end local v0    # "currentTime":Ljava/util/Date;
    .end local v1    # "currentTimeString":Ljava/lang/String;
    .end local v3    # "payload":Ljava/lang/String;
    .end local v4    # "startOrStop":Ljava/lang/String;
    :cond_0
    const-string v4, "stop"

    goto :goto_0

    .line 867
    .restart local v0    # "currentTime":Ljava/util/Date;
    .restart local v1    # "currentTimeString":Ljava/lang/String;
    .restart local v3    # "payload":Ljava/lang/String;
    .restart local v4    # "startOrStop":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 868
    .local v2, "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method

.method private start_recording()V
    .locals 1

    .prologue
    .line 808
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->startOrStopRecording(Z)V

    .line 809
    return-void
.end method

.method private stopTelemtry()V
    .locals 1

    .prologue
    .line 802
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->scheduler:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    .line 804
    return-void
.end method

.method private stop_recording()V
    .locals 1

    .prologue
    .line 812
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->startOrStopRecording(Z)V

    .line 813
    return-void
.end method


# virtual methods
.method public calibrateESCs(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x1

    .line 1020
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "Calibrating ESCs"

    invoke-static {v1, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 1021
    .local v0, "toast":Landroid/widget/Toast;
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 1022
    new-instance v1, Lcom/brynk/fathom/api/CalibrateESCsTask;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v1, v2, p1, v3}, Lcom/brynk/fathom/api/CalibrateESCsTask;-><init>(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V

    new-array v2, v4, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "blah"

    aput-object v4, v2, v3

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/api/CalibrateESCsTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1025
    return-void
.end method

.method public moveVertically(Landroid/view/View;Ljava/lang/Boolean;)V
    .locals 10
    .param p1, "v"    # Landroid/view/View;
    .param p2, "shouldMoveUp"    # Ljava/lang/Boolean;

    .prologue
    const/16 v6, -0x100

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 958
    const v5, 0x7f0f00ae

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 959
    .local v3, "tvVerticalAscend":Landroid/widget/TextView;
    const v5, 0x7f0f00af

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 961
    .local v4, "tvVerticalDescend":Landroid/widget/TextView;
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v2

    .line 962
    .local v2, "thrusterTask":Lcom/brynk/fathom/api/ThrusterTask;
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v0

    .line 963
    .local v0, "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_0

    const-string v1, "390"

    .line 966
    .local v1, "pitch_value":Ljava/lang/String;
    :goto_0
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 967
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isAscending:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 968
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iput-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isAscending:Ljava/lang/Boolean;

    .line 969
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iput-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isDescending:Ljava/lang/Boolean;

    .line 972
    const-string v1, "375"

    .line 974
    const-string v5, "#22aaaaff"

    invoke-static {v5}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 975
    const-string v5, "#22aaaaff"

    invoke-static {v5}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 1012
    :goto_1
    new-array v5, v9, [Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "PITCH,"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ",1,1"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-virtual {v0, v5}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1013
    new-array v5, v9, [Ljava/lang/String;

    const-string v6, "THRUST,375,1,1"

    aput-object v6, v5, v8

    invoke-virtual {v2, v5}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1017
    return-void

    .line 963
    .end local v1    # "pitch_value":Ljava/lang/String;
    :cond_0
    const-string v1, "360"

    goto :goto_0

    .line 981
    .restart local v1    # "pitch_value":Ljava/lang/String;
    :cond_1
    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iput-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isAscending:Ljava/lang/Boolean;

    .line 982
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iput-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isDescending:Ljava/lang/Boolean;

    .line 985
    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 986
    const-string v5, "#22aaaaff"

    invoke-static {v5}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setBackgroundColor(I)V

    goto :goto_1

    .line 991
    :cond_2
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isDescending:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 992
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iput-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isDescending:Ljava/lang/Boolean;

    .line 993
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iput-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isAscending:Ljava/lang/Boolean;

    .line 996
    const-string v1, "375"

    .line 998
    const-string v5, "#22aaaaff"

    invoke-static {v5}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 999
    const-string v5, "#22aaaaff"

    invoke-static {v5}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setBackgroundColor(I)V

    goto :goto_1

    .line 1003
    :cond_3
    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iput-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isDescending:Ljava/lang/Boolean;

    .line 1004
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iput-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isAscending:Ljava/lang/Boolean;

    .line 1006
    const-string v5, "#22aaaaff"

    invoke-static {v5}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 1007
    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setBackgroundColor(I)V

    goto/16 :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 11
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x1

    .line 285
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    .line 287
    .local v1, "args":Landroid/os/Bundle;
    const-string v6, "PHONE_LATITUDE"

    const-string v7, "-1"

    invoke-virtual {v1, v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->PHONE_LATITUDE:Ljava/lang/String;

    .line 288
    const-string v6, "PHONE_LONGITUDE"

    const-string v7, "-1"

    invoke-virtual {v1, v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->PHONE_LONGITUDE:Ljava/lang/String;

    .line 290
    const-string v6, "FATHOM1"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "LAT:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->PHONE_LATITUDE:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 291
    const-string v6, "FATHOM1"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "LONG:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->PHONE_LONGITUDE:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 296
    const v6, 0x7f040021

    invoke-virtual {p1, v6, p2, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v5

    .line 297
    .local v5, "v":Landroid/view/View;
    new-instance v6, Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v5}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/brynk/fathom/helpers/CoordinateHelper;-><init>(Landroid/content/Context;)V

    iput-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    .line 298
    new-instance v6, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v6}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {v5}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->DRONE_IP:Ljava/lang/String;

    .line 301
    new-instance v6, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v6}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {v5}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 302
    .local v0, "MOCK_DRONE_IP":Ljava/lang/String;
    iget-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 303
    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    iput-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isMockDrone:Ljava/lang/Boolean;

    .line 305
    :cond_0
    new-instance v6, Lcom/brynk/fathom/helpers/ExternalDevice;

    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v5}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-direct {v6, v7, v8}, Lcom/brynk/fathom/helpers/ExternalDevice;-><init>(Ljava/lang/String;Landroid/content/Context;)V

    iput-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->externalDevice:Lcom/brynk/fathom/helpers/ExternalDevice;

    .line 306
    new-instance v6, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v6}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {v5}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/brynk/fathom/helpers/Constants;->getPrefsInvert(Landroid/content/Context;)Ljava/lang/Boolean;

    move-result-object v6

    iput-object v6, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->shouldInvert:Ljava/lang/Boolean;

    .line 307
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupUDP()V

    .line 309
    invoke-virtual {v5, v9}, Landroid/view/View;->setKeepScreenOn(Z)V

    .line 312
    new-instance v6, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$1;

    invoke-direct {v6, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$1;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v5, v6}, Landroid/view/View;->setOnGenericMotionListener(Landroid/view/View$OnGenericMotionListener;)V

    .line 336
    const v6, 0x7f0f00a9

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 365
    const v6, 0x7f0f00aa

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$3;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$3;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 393
    const v6, 0x7f0f00b6

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$4;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$4;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 399
    const v6, 0x7f0f00ac

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$5;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$5;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 405
    const v6, 0x7f0f00b9

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$6;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$6;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 411
    const v6, 0x7f0f00ba

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$7;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$7;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 417
    const v6, 0x7f0f00ad

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$8;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$8;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 423
    const v6, 0x7f0f00c5

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$9;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$9;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 429
    const v6, 0x7f0f00ae

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$10;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$10;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 435
    const v6, 0x7f0f00af

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$11;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$11;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 441
    const v6, 0x7f0f00c9

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$12;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$12;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 447
    const v6, 0x7f0f00a3

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$13;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$13;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 455
    const v6, 0x7f0f00c0

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$14;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$14;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 464
    const v6, 0x7f0f00c7

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$15;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$15;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 471
    const v6, 0x7f0f00c6

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$16;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$16;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 479
    const v6, 0x7f0f00ca

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$17;

    invoke-direct {v7, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$17;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 488
    const v6, 0x7f0f00c8

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/SeekBar;

    .line 489
    .local v3, "sb":Landroid/widget/SeekBar;
    new-instance v6, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$18;

    invoke-direct {v6, p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$18;-><init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    invoke-virtual {v3, v6}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 513
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v4

    .line 514
    .local v4, "thrusterTask":Lcom/brynk/fathom/api/ThrusterTask;
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v2

    .line 515
    .local v2, "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    new-array v6, v9, [Ljava/lang/String;

    const-string v7, "PITCH,375,1,1"

    aput-object v7, v6, v10

    invoke-virtual {v2, v6}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 516
    new-array v6, v9, [Ljava/lang/String;

    const-string v7, "THRUST,375,1,1"

    aput-object v7, v6, v10

    invoke-virtual {v4, v6}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 518
    return-object v5
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 271
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 272
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->stopTelemtry()V

    .line 273
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->disconnectWebSocket()V

    .line 275
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 264
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 265
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupTelemtry()V

    .line 266
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->connectWebSocket()V

    .line 268
    return-void
.end method

.method public resetVerticalMovement(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 656
    invoke-virtual {p1}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0f00ae

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 657
    .local v0, "tvVerticalAscend":Landroid/widget/TextView;
    invoke-virtual {p1}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0f00af

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 659
    .local v1, "tvVerticalDescend":Landroid/widget/TextView;
    const-string v2, "#22aaaaff"

    invoke-static {v2}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 660
    const-string v2, "#22aaaaff"

    invoke-static {v2}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 661
    return-void
.end method

.method public toggleLights(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 1027
    iget-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->lightsOn:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v1, "off"

    .line 1028
    .local v1, "onOrOff":Ljava/lang/String;
    :goto_0
    const v2, 0x7f0f00c0

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 1029
    .local v0, "lights":Landroid/support/design/widget/FloatingActionButton;
    iget-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->lightsOn:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_1

    .line 1031
    const/16 v2, -0x100

    invoke-static {v2}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/design/widget/FloatingActionButton;->setBackgroundTintList(Landroid/content/res/ColorStateList;)V

    .line 1037
    :goto_1
    iget-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->lightsOn:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_2

    move v2, v3

    :goto_2
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->lightsOn:Ljava/lang/Boolean;

    .line 1038
    new-instance v2, Lcom/brynk/fathom/api/LightsTask;

    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v2, v5}, Lcom/brynk/fathom/api/LightsTask;-><init>(Ljava/lang/String;)V

    new-array v3, v3, [Ljava/lang/String;

    aput-object v1, v3, v4

    invoke-virtual {v2, v3}, Lcom/brynk/fathom/api/LightsTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1039
    return-void

    .line 1027
    .end local v0    # "lights":Landroid/support/design/widget/FloatingActionButton;
    .end local v1    # "onOrOff":Ljava/lang/String;
    :cond_0
    const-string v1, "on"

    goto :goto_0

    .line 1034
    .restart local v0    # "lights":Landroid/support/design/widget/FloatingActionButton;
    .restart local v1    # "onOrOff":Ljava/lang/String;
    :cond_1
    const v2, -0x777778

    invoke-static {v2}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/design/widget/FloatingActionButton;->setBackgroundTintList(Landroid/content/res/ColorStateList;)V

    goto :goto_1

    :cond_2
    move v2, v4

    .line 1037
    goto :goto_2
.end method

.method public toggleMode(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x4

    const/4 v4, 0x0

    .line 698
    const v3, 0x7f0f00b9

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 699
    .local v2, "tvThrottleMod":Landroid/widget/TextView;
    const v3, 0x7f0f00ba

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 700
    .local v1, "tvPitchMod":Landroid/widget/TextView;
    const v3, 0x7f0f00ac

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 702
    .local v0, "tvMode":Landroid/widget/TextView;
    invoke-virtual {v2}, Landroid/widget/TextView;->getVisibility()I

    move-result v3

    if-nez v3, :cond_0

    .line 706
    const-string v3, "1"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 707
    const-string v3, "1"

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 708
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_THROTTLE_MOD_PERCENT:Ljava/lang/Float;

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changeThrottleMinAndMax(Ljava/lang/Float;)V

    .line 709
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_PITCH_MOD_PERCENT:Ljava/lang/Float;

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changePitchMinAndMax(Ljava/lang/Float;)V

    .line 712
    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 713
    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 714
    const v3, 0x22aaaaff

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 715
    const/4 v3, -0x1

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 728
    :goto_0
    return-void

    .line 719
    :cond_0
    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 720
    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 721
    const/16 v3, -0x100

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 722
    const v3, -0x777778

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0
.end method

.method public togglePitchHold(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 935
    const v2, 0x7f0f00ad

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 936
    .local v1, "tvPitchHold":Landroid/widget/TextView;
    const-string v0, "PH "

    .line 937
    .local v0, "phText":Ljava/lang/String;
    iget-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->shouldPitchHold:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->shouldPitchHold:Ljava/lang/Boolean;

    .line 938
    iget-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->shouldPitchHold:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "ON"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 939
    :goto_1
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 941
    return-void

    .line 937
    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 938
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "OFF"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public togglePitchMod(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const v6, 0x3e19999a    # 0.15f

    .line 906
    const v5, 0x7f0f00ba

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 907
    .local v4, "tvPitchMod":Landroid/widget/TextView;
    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-interface {v5}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 908
    .local v0, "currentValue":I
    add-int/lit8 v1, v0, 0x1

    .line 909
    .local v1, "nextValue":I
    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 911
    .local v3, "t_mod":Ljava/lang/Float;
    const/4 v5, 0x3

    if-ne v0, v5, :cond_0

    .line 912
    const/4 v1, 0x1

    .line 915
    :cond_0
    packed-switch v1, :pswitch_data_0

    .line 928
    :goto_0
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v5, v3}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changePitchMinAndMax(Ljava/lang/Float;)V

    .line 929
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->externalDevice:Lcom/brynk/fathom/helpers/ExternalDevice;

    invoke-virtual {v5, v3}, Lcom/brynk/fathom/helpers/ExternalDevice;->changePitchMinAndMax(Ljava/lang/Float;)V

    .line 930
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 931
    .local v2, "nextValueString":Ljava/lang/String;
    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 933
    return-void

    .line 917
    .end local v2    # "nextValueString":Ljava/lang/String;
    :pswitch_0
    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 918
    goto :goto_0

    .line 920
    :pswitch_1
    const v5, 0x3e4ccccd    # 0.2f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 921
    goto :goto_0

    .line 923
    :pswitch_2
    const/high16 v5, 0x3f000000    # 0.5f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    goto :goto_0

    .line 915
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public toggleRecordingClicked(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 673
    const-string v2, ""

    .line 674
    .local v2, "toast_message":Ljava/lang/String;
    const v5, 0x7f0f00a3

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 676
    .local v0, "fab":Landroid/support/design/widget/FloatingActionButton;
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->websocketConnected:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-nez v5, :cond_0

    .line 677
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "Cannot connect to Fathom One camera"

    invoke-static {v4, v5, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 678
    .local v1, "toast":Landroid/widget/Toast;
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 695
    :goto_0
    return-void

    .line 681
    .end local v1    # "toast":Landroid/widget/Toast;
    :cond_0
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isRecording:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 682
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->stop_recording()V

    .line 683
    const-string v2, "Stopped recording"

    .line 684
    const v5, -0x777778

    invoke-static {v5}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v5

    invoke-virtual {v0, v5}, Landroid/support/design/widget/FloatingActionButton;->setBackgroundTintList(Landroid/content/res/ColorStateList;)V

    .line 691
    :cond_1
    :goto_1
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isRecording:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-nez v5, :cond_3

    :goto_2
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isRecording:Ljava/lang/Boolean;

    .line 692
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 693
    .restart local v1    # "toast":Landroid/widget/Toast;
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 686
    .end local v1    # "toast":Landroid/widget/Toast;
    :cond_2
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isRecording:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-nez v5, :cond_1

    .line 687
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->start_recording()V

    .line 688
    const-string v2, "Recording"

    .line 689
    const/high16 v5, -0x10000

    invoke-static {v5}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v5

    invoke-virtual {v0, v5}, Landroid/support/design/widget/FloatingActionButton;->setBackgroundTintList(Landroid/content/res/ColorStateList;)V

    goto :goto_1

    :cond_3
    move v3, v4

    .line 691
    goto :goto_2
.end method

.method public toggleSecondaryBar(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 663
    const v1, 0x7f0f00ab

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 664
    .local v0, "rlSecondaryBar":Landroid/widget/RelativeLayout;
    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    .line 665
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 669
    :goto_0
    const-string v1, "FATHOM1"

    const-string v2, "Pitch touched"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 671
    return-void

    .line 667
    :cond_0
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public toggleThrottleMod(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const v6, 0x3dcccccd    # 0.1f

    .line 875
    const v5, 0x7f0f00b9

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 876
    .local v4, "tvThrottleMod":Landroid/widget/TextView;
    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-interface {v5}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 877
    .local v0, "currentValue":I
    add-int/lit8 v1, v0, 0x1

    .line 878
    .local v1, "nextValue":I
    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 879
    .local v3, "t_mod":Ljava/lang/Float;
    const/4 v5, 0x3

    if-ne v0, v5, :cond_0

    .line 880
    const/4 v1, 0x1

    .line 883
    :cond_0
    packed-switch v1, :pswitch_data_0

    .line 898
    :goto_0
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v5, v3}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changeThrottleMinAndMax(Ljava/lang/Float;)V

    .line 899
    iget-object v5, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->externalDevice:Lcom/brynk/fathom/helpers/ExternalDevice;

    invoke-virtual {v5, v3}, Lcom/brynk/fathom/helpers/ExternalDevice;->changeThrottleMinAndMax(Ljava/lang/Float;)V

    .line 900
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 901
    .local v2, "nextValueString":Ljava/lang/String;
    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 903
    return-void

    .line 885
    .end local v2    # "nextValueString":Ljava/lang/String;
    :pswitch_0
    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 886
    goto :goto_0

    .line 888
    :pswitch_1
    const v5, 0x3e99999a    # 0.3f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 889
    goto :goto_0

    .line 891
    :pswitch_2
    const/high16 v5, 0x3f000000    # 0.5f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 892
    goto :goto_0

    .line 894
    :pswitch_3
    const/high16 v5, 0x3f800000    # 1.0f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    goto :goto_0

    .line 883
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public toggleZeroDegreeMode(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 943
    const v2, 0x7f0f00c5

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 944
    .local v0, "tvZeroDegreeMode":Landroid/widget/TextView;
    const-string v2, "#22aaaaff"

    invoke-static {v2}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    .line 945
    .local v1, "zeroDegreeColor":I
    iget-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isZeroDegreeMode:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isZeroDegreeMode:Ljava/lang/Boolean;

    .line 946
    iget-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->isZeroDegreeMode:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v2, "#22aaaaff"

    invoke-static {v2}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    .line 947
    :goto_1
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 950
    return-void

    .line 945
    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 946
    :cond_1
    const/16 v1, -0x100

    goto :goto_1
.end method
