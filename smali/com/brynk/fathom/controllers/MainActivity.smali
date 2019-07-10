.class public Lcom/brynk/fathom/controllers/MainActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# instance fields
.field private DEBUG_TAG:Ljava/lang/String;

.field private DRONE_IP:Ljava/lang/String;

.field private ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

.field private connectedToFathomNetwork:Z

.field private externalDevice:Lcom/brynk/fathom/helpers/ExternalDevice;

.field private isRecording:Ljava/lang/Boolean;

.field private lightsOn:Ljava/lang/Boolean;

.field loadingVideo:Landroid/widget/VideoView;

.field private mediaController:Lio/vov/vitamio/widget/MediaController;

.field private path:Ljava/lang/String;

.field roll_socket:Ljava/net/DatagramSocket;

.field private shouldInvert:Ljava/lang/Boolean;

.field private shouldPitchHold:Ljava/lang/Boolean;

.field thruster_socket:Ljava/net/DatagramSocket;

.field private videoView:Lio/vov/vitamio/widget/VideoView;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 72
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 76
    const-string v0, "FATHOM1"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->DEBUG_TAG:Ljava/lang/String;

    .line 77
    iput-boolean v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->connectedToFathomNetwork:Z

    .line 78
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->lightsOn:Ljava/lang/Boolean;

    .line 79
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->isRecording:Ljava/lang/Boolean;

    .line 80
    iput-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    .line 84
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->shouldPitchHold:Ljava/lang/Boolean;

    .line 85
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->shouldInvert:Ljava/lang/Boolean;

    .line 91
    const-string v0, "udp://@:8000"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->path:Ljava/lang/String;

    .line 92
    iput-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->thruster_socket:Ljava/net/DatagramSocket;

    .line 93
    iput-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->roll_socket:Ljava/net/DatagramSocket;

    .line 98
    iput-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->loadingVideo:Landroid/widget/VideoView;

    return-void
.end method

.method static synthetic access$000(Lcom/brynk/fathom/controllers/MainActivity;)Lio/vov/vitamio/widget/VideoView;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/MainActivity;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->videoView:Lio/vov/vitamio/widget/VideoView;

    return-object v0
.end method

.method static synthetic access$100(Lcom/brynk/fathom/controllers/MainActivity;)Lcom/brynk/fathom/helpers/CoordinateHelper;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/MainActivity;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    return-object v0
.end method

.method static synthetic access$200(Lcom/brynk/fathom/controllers/MainActivity;Ljava/util/ArrayList;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/MainActivity;
    .param p1, "x1"    # Ljava/util/ArrayList;

    .prologue
    .line 72
    invoke-direct {p0, p1}, Lcom/brynk/fathom/controllers/MainActivity;->positionThruster(Ljava/util/ArrayList;)V

    return-void
.end method

.method static synthetic access$300(Lcom/brynk/fathom/controllers/MainActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/MainActivity;

    .prologue
    .line 72
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->hideThruster()V

    return-void
.end method

.method static synthetic access$400(Lcom/brynk/fathom/controllers/MainActivity;Ljava/util/ArrayList;Landroid/view/MotionEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/MainActivity;
    .param p1, "x1"    # Ljava/util/ArrayList;
    .param p2, "x2"    # Landroid/view/MotionEvent;

    .prologue
    .line 72
    invoke-direct {p0, p1, p2}, Lcom/brynk/fathom/controllers/MainActivity;->moveThruster(Ljava/util/ArrayList;Landroid/view/MotionEvent;)V

    return-void
.end method

.method static synthetic access$500(Lcom/brynk/fathom/controllers/MainActivity;Ljava/util/ArrayList;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/MainActivity;
    .param p1, "x1"    # Ljava/util/ArrayList;

    .prologue
    .line 72
    invoke-direct {p0, p1}, Lcom/brynk/fathom/controllers/MainActivity;->positionPitch(Ljava/util/ArrayList;)V

    return-void
.end method

.method static synthetic access$600(Lcom/brynk/fathom/controllers/MainActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/MainActivity;

    .prologue
    .line 72
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->hidePitch()V

    return-void
.end method

.method static synthetic access$700(Lcom/brynk/fathom/controllers/MainActivity;Ljava/util/ArrayList;Landroid/view/MotionEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/MainActivity;
    .param p1, "x1"    # Ljava/util/ArrayList;
    .param p2, "x2"    # Landroid/view/MotionEvent;

    .prologue
    .line 72
    invoke-direct {p0, p1, p2}, Lcom/brynk/fathom/controllers/MainActivity;->movePitch(Ljava/util/ArrayList;Landroid/view/MotionEvent;)V

    return-void
.end method

.method static synthetic access$800(Lcom/brynk/fathom/controllers/MainActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/MainActivity;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->DRONE_IP:Ljava/lang/String;

    return-object v0
.end method

.method private buildWifiAlertDialog()Landroid/support/v7/app/AlertDialog;
    .locals 4

    .prologue
    .line 445
    new-instance v1, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v1, p0}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 446
    .local v1, "builder1":Landroid/support/v7/app/AlertDialog$Builder;
    const-string v2, "Connect to the Fathom Wifi Network."

    invoke-virtual {v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 447
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->setCancelable(Z)Landroid/support/v7/app/AlertDialog$Builder;

    .line 449
    const-string v2, "Go to settings"

    new-instance v3, Lcom/brynk/fathom/controllers/MainActivity$5;

    invoke-direct {v3, p0}, Lcom/brynk/fathom/controllers/MainActivity$5;-><init>(Lcom/brynk/fathom/controllers/MainActivity;)V

    invoke-virtual {v1, v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 457
    invoke-virtual {v1}, Landroid/support/v7/app/AlertDialog$Builder;->create()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    .line 458
    .local v0, "alert11":Landroid/support/v7/app/AlertDialog;
    return-object v0
.end method

.method private checkWifiStatus()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 432
    new-instance v2, Lcom/brynk/fathom/helpers/WiFiHelper;

    invoke-direct {v2}, Lcom/brynk/fathom/helpers/WiFiHelper;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/brynk/fathom/helpers/WiFiHelper;->isConnectedToFathomNetwork(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 433
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "Connected"

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 435
    .local v0, "toast":Landroid/widget/Toast;
    iput-boolean v4, p0, Lcom/brynk/fathom/controllers/MainActivity;->connectedToFathomNetwork:Z

    .line 443
    .end local v0    # "toast":Landroid/widget/Toast;
    :goto_0
    return-void

    .line 438
    :cond_0
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->buildWifiAlertDialog()Landroid/support/v7/app/AlertDialog;

    move-result-object v1

    .line 439
    .local v1, "wifi_alert":Landroid/support/v7/app/AlertDialog;
    invoke-virtual {v1}, Landroid/support/v7/app/AlertDialog;->show()V

    goto :goto_0
.end method

.method private hidePitch()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 343
    const v5, 0x7f0f00bf

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 344
    .local v0, "fab_rollStick":Landroid/support/design/widget/FloatingActionButton;
    const v5, 0x7f0f00be

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 348
    .local v4, "tvRoll":Landroid/widget/TextView;
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v3

    .line 349
    .local v3, "thrusterTask_up":Lcom/brynk/fathom/api/ThrusterTask;
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v1

    .line 351
    .local v1, "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity;->shouldPitchHold:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_0

    const-string v2, "PITCH_HOLD,375,1,1"

    .line 352
    .local v2, "pitchUpArgs":Ljava/lang/String;
    :goto_0
    new-array v5, v6, [Ljava/lang/String;

    aput-object v2, v5, v7

    invoke-virtual {v1, v5}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 353
    new-array v5, v6, [Ljava/lang/String;

    const-string v6, "YAW,999999,1,1"

    aput-object v6, v5, v7

    invoke-virtual {v3, v5}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 355
    invoke-virtual {v0, v8}, Landroid/support/design/widget/FloatingActionButton;->setVisibility(I)V

    .line 356
    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 357
    return-void

    .line 351
    .end local v2    # "pitchUpArgs":Ljava/lang/String;
    :cond_0
    const-string v2, "PITCH,375,1,1"

    goto :goto_0
.end method

.method private hideThruster()V
    .locals 7

    .prologue
    const/4 v4, 0x4

    .line 360
    const v3, 0x7f0f00bc

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 361
    .local v0, "thrusterScale":Landroid/widget/TextView;
    const v3, 0x7f0f00bd

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 363
    .local v1, "thrusterTick":Landroid/widget/TextView;
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 364
    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 366
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v2

    .line 367
    .local v2, "thruster_task_up":Lcom/brynk/fathom/api/ThrusterTask;
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "THRUST,"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v6}, Lcom/brynk/fathom/helpers/CoordinateHelper;->getThrusterNeutral()Ljava/lang/Float;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ",1,1"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v2, v3}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 368
    return-void
.end method

.method private init()V
    .locals 1

    .prologue
    .line 422
    const v0, 0x7f0f00a5

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lio/vov/vitamio/widget/VideoView;

    iput-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->videoView:Lio/vov/vitamio/widget/VideoView;

    .line 423
    new-instance v0, Lio/vov/vitamio/widget/MediaController;

    invoke-direct {v0, p0}, Lio/vov/vitamio/widget/MediaController;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->mediaController:Lio/vov/vitamio/widget/MediaController;

    .line 424
    return-void
.end method

.method private isLeftSide(Landroid/view/MotionEvent;)Ljava/lang/Boolean;
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 307
    const v1, 0x7f0f00a9

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 308
    .local v0, "pilotView":Landroid/widget/TextView;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v1

    invoke-virtual {v0}, Landroid/widget/TextView;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private movePitch(Ljava/util/ArrayList;Landroid/view/MotionEvent;)V
    .locals 12
    .param p1, "boundedCoords"    # Ljava/util/ArrayList;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v10, 0x1

    const/4 v11, 0x0

    .line 313
    const v5, 0x7f0f00bf

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 314
    .local v0, "fab_rollStick":Landroid/support/design/widget/FloatingActionButton;
    const v5, 0x7f0f00be

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 316
    .local v3, "tvRoll":Landroid/widget/TextView;
    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v5, p2, v3}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundCoord(Landroid/view/MotionEvent;Landroid/widget/TextView;)Ljava/util/ArrayList;

    move-result-object v4

    .line 319
    .local v4, "tvRollBounds":Ljava/util/ArrayList;
    invoke-virtual {v4, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Float;

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v5

    invoke-virtual {v0}, Landroid/support/design/widget/FloatingActionButton;->getWidth()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    int-to-float v6, v6

    sub-float/2addr v5, v6

    invoke-virtual {v0, v5}, Landroid/support/design/widget/FloatingActionButton;->setX(F)V

    .line 320
    invoke-virtual {v4, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Float;

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v5

    invoke-virtual {v0}, Landroid/support/design/widget/FloatingActionButton;->getHeight()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    int-to-float v6, v6

    sub-float/2addr v5, v6

    invoke-virtual {v0, v5}, Landroid/support/design/widget/FloatingActionButton;->setY(F)V

    .line 323
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v2

    .line 324
    .local v2, "thrusterTask":Lcom/brynk/fathom/api/ThrusterTask;
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v1

    .line 325
    .local v1, "pitchTask":Lcom/brynk/fathom/api/ThrusterTask;
    new-array v5, v10, [Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "PITCH,"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    iget-object v8, p0, Lcom/brynk/fathom/controllers/MainActivity;->shouldInvert:Ljava/lang/Boolean;

    const/high16 v9, 0x41f00000    # 30.0f

    invoke-virtual {v7, p2, v3, v8, v9}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundThruster(Landroid/view/MotionEvent;Landroid/widget/TextView;Ljava/lang/Boolean;F)Ljava/lang/Float;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ",1,1"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v11

    invoke-virtual {v1, v5}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 326
    new-array v6, v10, [Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "YAW,999999,"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {p1, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Float;

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    const/high16 v10, 0x42f00000    # 120.0f

    invoke-virtual {v8, v5, v3, v9, v10}, Lcom/brynk/fathom/helpers/CoordinateHelper;->mapYawToServo(Ljava/lang/Float;Landroid/widget/TextView;Ljava/lang/Boolean;F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v6, v11

    invoke-virtual {v2, v6}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 331
    return-void
.end method

.method private moveThruster(Ljava/util/ArrayList;Landroid/view/MotionEvent;)V
    .locals 9
    .param p1, "boundedCoords"    # Ljava/util/ArrayList;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v5, 0x1

    const/4 v8, 0x0

    .line 334
    const v3, 0x7f0f00bd

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 335
    .local v0, "thrusterTick":Landroid/widget/TextView;
    const v3, 0x7f0f00bb

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 336
    .local v2, "tvThruster":Landroid/widget/TextView;
    iget-object v4, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {p1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    invoke-virtual {v4, v3, v2}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundThrusterTick(Ljava/lang/Float;Landroid/widget/TextView;)Ljava/lang/Float;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setY(F)V

    .line 338
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;

    move-result-object v1

    .line 339
    .local v1, "thruster_task":Lcom/brynk/fathom/api/ThrusterTask;
    new-array v3, v5, [Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "THRUST,"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v5, p2, v2, v6, v7}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundThruster(Landroid/view/MotionEvent;Landroid/widget/TextView;Ljava/lang/Boolean;F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ",1,1"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v8

    invoke-virtual {v1, v3}, Lcom/brynk/fathom/api/ThrusterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 340
    return-void
.end method

.method private positionPitch(Ljava/util/ArrayList;)V
    .locals 7
    .param p1, "boundedCoords"    # Ljava/util/ArrayList;

    .prologue
    const/4 v6, 0x1

    const/high16 v5, 0x43160000    # 150.0f

    const/4 v4, 0x0

    .line 371
    const v2, 0x7f0f00bf

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 372
    .local v0, "fab_rollStick":Landroid/support/design/widget/FloatingActionButton;
    const v2, 0x7f0f00be

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 374
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

    .line 375
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

    .line 376
    invoke-virtual {v0, v4}, Landroid/support/design/widget/FloatingActionButton;->setVisibility(I)V

    .line 378
    invoke-virtual {p1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    sub-float/2addr v2, v5

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setX(F)V

    .line 379
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    sub-float/2addr v2, v5

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setY(F)V

    .line 380
    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 381
    return-void
.end method

.method private positionThruster(Ljava/util/ArrayList;)V
    .locals 8
    .param p1, "boundedCoords"    # Ljava/util/ArrayList;

    .prologue
    const/high16 v7, 0x43160000    # 150.0f

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 385
    const v3, 0x7f0f00bc

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 386
    .local v0, "thrusterScale":Landroid/widget/TextView;
    const v3, 0x7f0f00bd

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 387
    .local v1, "thrusterTick":Landroid/widget/TextView;
    const v3, 0x7f0f00bb

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 389
    .local v2, "tvThruster":Landroid/widget/TextView;
    invoke-virtual {p1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    const/high16 v4, 0x42c80000    # 100.0f

    sub-float/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setX(F)V

    .line 390
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float/2addr v3, v7

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setY(F)V

    .line 392
    invoke-virtual {p1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    const/high16 v4, 0x42f00000    # 120.0f

    add-float/2addr v3, v4

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setX(F)V

    .line 393
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    const/high16 v4, 0x43480000    # 200.0f

    sub-float/2addr v3, v4

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setY(F)V

    .line 394
    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 396
    invoke-virtual {p1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    add-float/2addr v3, v7

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setX(F)V

    .line 397
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setY(F)V

    .line 398
    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 402
    return-void
.end method

.method private setupPitchYawTask()Lcom/brynk/fathom/api/PitchYawTask;
    .locals 2

    .prologue
    .line 413
    new-instance v0, Lcom/brynk/fathom/api/PitchYawTask;

    invoke-direct {v0}, Lcom/brynk/fathom/api/PitchYawTask;-><init>()V

    .line 414
    .local v0, "pyt":Lcom/brynk/fathom/api/PitchYawTask;
    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/PitchYawTask;->setDRONE_IP(Ljava/lang/String;)V

    .line 415
    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->roll_socket:Ljava/net/DatagramSocket;

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/PitchYawTask;->setRoll_socket(Ljava/net/DatagramSocket;)V

    .line 417
    return-object v0
.end method

.method private setupTelemtry()V
    .locals 15

    .prologue
    const/4 v7, 0x0

    const-wide/16 v4, 0x1

    const-wide/16 v2, 0x0

    .line 612
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    .line 613
    .local v0, "exec":Ljava/util/concurrent/ScheduledExecutorService;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v13

    .line 618
    .local v13, "rootView":Landroid/view/View;
    new-instance v14, Lcom/brynk/fathom/api/TelemetryServerTask;

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v6

    invoke-direct {v14, v1, v6}, Lcom/brynk/fathom/api/TelemetryServerTask;-><init>(Landroid/content/Context;Landroid/view/View;)V

    .line 619
    .local v14, "tst":Lcom/brynk/fathom/api/TelemetryServerTask;
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0xb

    if-lt v1, v6, :cond_0

    .line 620
    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v6, v7, [Ljava/lang/String;

    invoke-virtual {v14, v1, v6}, Lcom/brynk/fathom/api/TelemetryServerTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 627
    :goto_0
    new-instance v1, Lcom/brynk/fathom/controllers/MainActivity$6;

    invoke-direct {v1, p0, v13}, Lcom/brynk/fathom/controllers/MainActivity$6;-><init>(Lcom/brynk/fathom/controllers/MainActivity;Landroid/view/View;)V

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 636
    new-instance v7, Lcom/brynk/fathom/controllers/MainActivity$7;

    invoke-direct {v7, p0, v13}, Lcom/brynk/fathom/controllers/MainActivity$7;-><init>(Lcom/brynk/fathom/controllers/MainActivity;Landroid/view/View;)V

    const-wide/16 v10, 0x1e

    sget-object v12, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move-object v6, v0

    move-wide v8, v2

    invoke-interface/range {v6 .. v12}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 643
    new-instance v1, Lcom/brynk/fathom/controllers/MainActivity$8;

    invoke-direct {v1, p0, v13}, Lcom/brynk/fathom/controllers/MainActivity$8;-><init>(Lcom/brynk/fathom/controllers/MainActivity;Landroid/view/View;)V

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 651
    new-instance v7, Lcom/brynk/fathom/controllers/MainActivity$9;

    invoke-direct {v7, p0, v13}, Lcom/brynk/fathom/controllers/MainActivity$9;-><init>(Lcom/brynk/fathom/controllers/MainActivity;Landroid/view/View;)V

    const-wide/16 v10, 0xa

    sget-object v12, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move-object v6, v0

    move-wide v8, v2

    invoke-interface/range {v6 .. v12}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 659
    new-instance v1, Lcom/brynk/fathom/controllers/MainActivity$10;

    invoke-direct {v1, p0, v13}, Lcom/brynk/fathom/controllers/MainActivity$10;-><init>(Lcom/brynk/fathom/controllers/MainActivity;Landroid/view/View;)V

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MINUTES:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 668
    new-instance v1, Lcom/brynk/fathom/controllers/MainActivity$11;

    invoke-direct {v1, p0, v13}, Lcom/brynk/fathom/controllers/MainActivity$11;-><init>(Lcom/brynk/fathom/controllers/MainActivity;Landroid/view/View;)V

    const-wide/16 v4, 0x3

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 676
    return-void

    .line 622
    :cond_0
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const-string v6, ""

    aput-object v6, v1, v7

    invoke-virtual {v14, v1}, Lcom/brynk/fathom/api/TelemetryServerTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method private setupThrusterTask()Lcom/brynk/fathom/api/ThrusterTask;
    .locals 2

    .prologue
    .line 405
    new-instance v0, Lcom/brynk/fathom/api/ThrusterTask;

    invoke-direct {v0}, Lcom/brynk/fathom/api/ThrusterTask;-><init>()V

    .line 406
    .local v0, "t_task":Lcom/brynk/fathom/api/ThrusterTask;
    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/ThrusterTask;->setDRONE_IP(Ljava/lang/String;)V

    .line 407
    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->thruster_socket:Ljava/net/DatagramSocket;

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/ThrusterTask;->setThruster_socket(Ljava/net/DatagramSocket;)V

    .line 408
    return-object v0
.end method

.method private setupUDP()V
    .locals 2

    .prologue
    .line 728
    :try_start_0
    new-instance v1, Ljava/net/DatagramSocket;

    invoke-direct {v1}, Ljava/net/DatagramSocket;-><init>()V

    iput-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->thruster_socket:Ljava/net/DatagramSocket;

    .line 729
    new-instance v1, Ljava/net/DatagramSocket;

    invoke-direct {v1}, Ljava/net/DatagramSocket;-><init>()V

    iput-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->roll_socket:Ljava/net/DatagramSocket;
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_0

    .line 734
    :goto_0
    return-void

    .line 730
    :catch_0
    move-exception v0

    .line 731
    .local v0, "e":Ljava/net/SocketException;
    invoke-virtual {v0}, Ljava/net/SocketException;->printStackTrace()V

    goto :goto_0
.end method

.method private start_recording()V
    .locals 4

    .prologue
    .line 592
    new-instance v0, Lcom/brynk/fathom/api/RecordingTask;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/brynk/fathom/api/RecordingTask;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "start"

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/RecordingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 593
    return-void
.end method

.method private stop_recording()V
    .locals 4

    .prologue
    .line 595
    new-instance v0, Lcom/brynk/fathom/api/RecordingTask;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/brynk/fathom/api/RecordingTask;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "stop"

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/RecordingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 596
    return-void
.end method


# virtual methods
.method public getIndexApiAction()Lcom/google/android/gms/appindexing/Action;
    .locals 3

    .prologue
    .line 685
    new-instance v1, Lcom/google/android/gms/appindexing/Thing$Builder;

    invoke-direct {v1}, Lcom/google/android/gms/appindexing/Thing$Builder;-><init>()V

    const-string v2, "Main Page"

    .line 686
    invoke-virtual {v1, v2}, Lcom/google/android/gms/appindexing/Thing$Builder;->setName(Ljava/lang/String;)Lcom/google/android/gms/appindexing/Thing$Builder;

    move-result-object v1

    const-string v2, "http://[ENTER-YOUR-URL-HERE]"

    .line 688
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/appindexing/Thing$Builder;->setUrl(Landroid/net/Uri;)Lcom/google/android/gms/appindexing/Thing$Builder;

    move-result-object v1

    .line 689
    invoke-virtual {v1}, Lcom/google/android/gms/appindexing/Thing$Builder;->build()Lcom/google/android/gms/appindexing/Thing;

    move-result-object v0

    .line 690
    .local v0, "object":Lcom/google/android/gms/appindexing/Thing;
    new-instance v1, Lcom/google/android/gms/appindexing/Action$Builder;

    const-string v2, "http://schema.org/ViewAction"

    invoke-direct {v1, v2}, Lcom/google/android/gms/appindexing/Action$Builder;-><init>(Ljava/lang/String;)V

    .line 691
    invoke-virtual {v1, v0}, Lcom/google/android/gms/appindexing/Action$Builder;->setObject(Lcom/google/android/gms/appindexing/Thing;)Lcom/google/android/gms/appindexing/Action$Builder;

    move-result-object v1

    const-string v2, "http://schema.org/CompletedActionStatus"

    .line 692
    invoke-virtual {v1, v2}, Lcom/google/android/gms/appindexing/Action$Builder;->setActionStatus(Ljava/lang/String;)Lcom/google/android/gms/appindexing/Action$Builder;

    move-result-object v1

    .line 693
    invoke-virtual {v1}, Lcom/google/android/gms/appindexing/Action$Builder;->build()Lcom/google/android/gms/appindexing/Action;

    move-result-object v1

    return-object v1
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v6, 0x400

    .line 126
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 128
    const v3, 0x7f04001e

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->setContentView(I)V

    .line 130
    new-instance v3, Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/brynk/fathom/helpers/CoordinateHelper;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    .line 131
    new-instance v3, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v3}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->DRONE_IP:Ljava/lang/String;

    .line 132
    new-instance v3, Lcom/brynk/fathom/helpers/ExternalDevice;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/MainActivity;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/brynk/fathom/helpers/ExternalDevice;-><init>(Ljava/lang/String;Landroid/content/Context;)V

    iput-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->externalDevice:Lcom/brynk/fathom/helpers/ExternalDevice;

    .line 133
    new-instance v3, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v3}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/helpers/Constants;->getPrefsInvert(Landroid/content/Context;)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->shouldInvert:Ljava/lang/Boolean;

    .line 134
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3, v6, v6}, Landroid/view/Window;->setFlags(II)V

    .line 137
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->init()V

    .line 139
    const v3, 0x7f0f00c1

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    .line 141
    .local v1, "rl_pilotLoading":Landroid/widget/RelativeLayout;
    const v3, 0x7f0f00c2

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/VideoView;

    iput-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->loadingVideo:Landroid/widget/VideoView;

    .line 142
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->loadingVideo:Landroid/widget/VideoView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "android.resource://"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const v5, 0x7f070003

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/VideoView;->setVideoPath(Ljava/lang/String;)V

    .line 143
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->loadingVideo:Landroid/widget/VideoView;

    new-instance v4, Lcom/brynk/fathom/controllers/MainActivity$1;

    invoke-direct {v4, p0}, Lcom/brynk/fathom/controllers/MainActivity$1;-><init>(Lcom/brynk/fathom/controllers/MainActivity;)V

    invoke-virtual {v3, v4}, Landroid/widget/VideoView;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 150
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->loadingVideo:Landroid/widget/VideoView;

    invoke-virtual {v3}, Landroid/widget/VideoView;->start()V

    .line 156
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->checkWifiStatus()V

    .line 157
    iget-boolean v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->connectedToFathomNetwork:Z

    if-nez v3, :cond_0

    .line 259
    :goto_0
    return-void

    .line 165
    :cond_0
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->setupUDP()V

    .line 167
    :try_start_0
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->videoView:Lio/vov/vitamio/widget/VideoView;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/MainActivity;->path:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v3, v4}, Lio/vov/vitamio/widget/VideoView;->setVideoURI(Landroid/net/Uri;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 176
    :goto_1
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->videoView:Lio/vov/vitamio/widget/VideoView;

    new-instance v4, Lcom/brynk/fathom/controllers/MainActivity$2;

    invoke-direct {v4, p0}, Lcom/brynk/fathom/controllers/MainActivity$2;-><init>(Lcom/brynk/fathom/controllers/MainActivity;)V

    invoke-virtual {v3, v4}, Lio/vov/vitamio/widget/VideoView;->setOnPreparedListener(Lio/vov/vitamio/MediaPlayer$OnPreparedListener;)V

    .line 211
    const v3, 0x7f0f00a9

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    new-instance v4, Lcom/brynk/fathom/controllers/MainActivity$3;

    invoke-direct {v4, p0}, Lcom/brynk/fathom/controllers/MainActivity$3;-><init>(Lcom/brynk/fathom/controllers/MainActivity;)V

    invoke-virtual {v3, v4}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 235
    const v3, 0x7f0f00aa

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    new-instance v4, Lcom/brynk/fathom/controllers/MainActivity$4;

    invoke-direct {v4, p0}, Lcom/brynk/fathom/controllers/MainActivity$4;-><init>(Lcom/brynk/fathom/controllers/MainActivity;)V

    invoke-virtual {v3, v4}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    goto :goto_0

    .line 169
    :catch_0
    move-exception v0

    .line 170
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    invoke-static {v3, v4, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 171
    .local v2, "toast":Landroid/widget/Toast;
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 172
    const-string v3, "FATHOM1"

    const-string v4, "Caught it"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 743
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const/high16 v1, 0x7f100000

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 744
    const/4 v0, 0x1

    return v0
.end method

.method public onGenericMotionEvent(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const v2, 0x1000010

    .line 106
    const-string v0, "FATHOM1"

    const-string v1, "GENERIC"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 108
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getSource()I

    move-result v0

    and-int/2addr v0, v2

    if-ne v0, v2, :cond_0

    .line 110
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 112
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->externalDevice:Lcom/brynk/fathom/helpers/ExternalDevice;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->thruster_socket:Ljava/net/DatagramSocket;

    invoke-virtual {v0, p1, v1}, Lcom/brynk/fathom/helpers/ExternalDevice;->processHistoricalEvents(Landroid/view/MotionEvent;Ljava/net/DatagramSocket;)V

    .line 113
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity;->externalDevice:Lcom/brynk/fathom/helpers/ExternalDevice;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity;->thruster_socket:Ljava/net/DatagramSocket;

    invoke-virtual {v0, p1, v1}, Lcom/brynk/fathom/helpers/ExternalDevice;->processCurrentEvent(Landroid/view/MotionEvent;Ljava/net/DatagramSocket;)V

    .line 115
    const/4 v0, 0x1

    .line 117
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onGenericMotionEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onLightsClicked(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 598
    iget-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->lightsOn:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v1, "off"

    .line 599
    .local v1, "onOrOff":Ljava/lang/String;
    :goto_0
    const v2, 0x7f0f00c0

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 600
    .local v0, "lights":Landroid/support/design/widget/FloatingActionButton;
    iget-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->lightsOn:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_1

    .line 602
    const/16 v2, -0x100

    invoke-static {v2}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/design/widget/FloatingActionButton;->setBackgroundTintList(Landroid/content/res/ColorStateList;)V

    .line 608
    :goto_1
    iget-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->lightsOn:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_2

    move v2, v3

    :goto_2
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->lightsOn:Ljava/lang/Boolean;

    .line 609
    new-instance v2, Lcom/brynk/fathom/api/LightsTask;

    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v2, v5}, Lcom/brynk/fathom/api/LightsTask;-><init>(Ljava/lang/String;)V

    new-array v3, v3, [Ljava/lang/String;

    aput-object v1, v3, v4

    invoke-virtual {v2, v3}, Lcom/brynk/fathom/api/LightsTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 610
    return-void

    .line 598
    .end local v0    # "lights":Landroid/support/design/widget/FloatingActionButton;
    .end local v1    # "onOrOff":Ljava/lang/String;
    :cond_0
    const-string v1, "on"

    goto :goto_0

    .line 605
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

    .line 608
    goto :goto_2
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 752
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 755
    .local v0, "id":I
    const v1, 0x7f0f0110

    if-ne v0, v1, :cond_0

    .line 756
    const/4 v1, 0x1

    .line 759
    :goto_0
    return v1

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    goto :goto_0
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 710
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 713
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 698
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStart()V

    .line 699
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->setupTelemtry()V

    .line 706
    return-void
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 717
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStop()V

    .line 723
    return-void
.end method

.method public toggleMode(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x4

    const/4 v4, 0x0

    .line 274
    const v3, 0x7f0f00b9

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 275
    .local v2, "tvThrottleMod":Landroid/widget/TextView;
    const v3, 0x7f0f00ba

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 276
    .local v1, "tvPitchMod":Landroid/widget/TextView;
    const v3, 0x7f0f00ac

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 278
    .local v0, "tvMode":Landroid/widget/TextView;
    invoke-virtual {v2}, Landroid/widget/TextView;->getVisibility()I

    move-result v3

    if-nez v3, :cond_0

    .line 282
    const-string v3, "2"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 283
    const-string v3, "4"

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 284
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_THROTTLE_MOD_PERCENT:Ljava/lang/Float;

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changeThrottleMinAndMax(Ljava/lang/Float;)V

    .line 285
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_PITCH_MOD_PERCENT:Ljava/lang/Float;

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changePitchMinAndMax(Ljava/lang/Float;)V

    .line 288
    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 289
    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 290
    const v3, 0x22aaaaff

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 291
    const/4 v3, -0x1

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 304
    :goto_0
    return-void

    .line 295
    :cond_0
    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 296
    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 297
    const/16 v3, -0x100

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 298
    const v3, -0x777778

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0
.end method

.method public togglePitchHold(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 584
    const v2, 0x7f0f00ad

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 585
    .local v1, "tvPitchHold":Landroid/widget/TextView;
    const-string v0, "PH "

    .line 586
    .local v0, "phText":Ljava/lang/String;
    iget-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->shouldPitchHold:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->shouldPitchHold:Ljava/lang/Boolean;

    .line 587
    iget-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity;->shouldPitchHold:Ljava/lang/Boolean;

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

    .line 588
    :goto_1
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 590
    return-void

    .line 586
    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 587
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
    const/high16 v6, 0x3f800000    # 1.0f

    .line 533
    const v5, 0x7f0f00ba

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 534
    .local v4, "tvPitchMod":Landroid/widget/TextView;
    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-interface {v5}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 535
    .local v0, "currentValue":I
    add-int/lit8 v1, v0, 0x1

    .line 536
    .local v1, "nextValue":I
    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 538
    .local v3, "t_mod":Ljava/lang/Float;
    const/16 v5, 0xa

    if-ne v0, v5, :cond_0

    .line 539
    const/4 v1, 0x1

    .line 542
    :cond_0
    packed-switch v1, :pswitch_data_0

    .line 575
    :goto_0
    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v5, v3}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changePitchMinAndMax(Ljava/lang/Float;)V

    .line 576
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 577
    .local v2, "nextValueString":Ljava/lang/String;
    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 579
    return-void

    .line 544
    .end local v2    # "nextValueString":Ljava/lang/String;
    :pswitch_0
    const v5, 0x3dcccccd    # 0.1f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 545
    goto :goto_0

    .line 547
    :pswitch_1
    const v5, 0x3e4ccccd    # 0.2f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 548
    goto :goto_0

    .line 550
    :pswitch_2
    const v5, 0x3e99999a    # 0.3f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 551
    goto :goto_0

    .line 553
    :pswitch_3
    const v5, 0x3ecccccd    # 0.4f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 554
    goto :goto_0

    .line 556
    :pswitch_4
    const/high16 v5, 0x3f000000    # 0.5f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 557
    goto :goto_0

    .line 559
    :pswitch_5
    const v5, 0x3f19999a    # 0.6f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 560
    goto :goto_0

    .line 562
    :pswitch_6
    const v5, 0x3f333333    # 0.7f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 563
    goto :goto_0

    .line 565
    :pswitch_7
    const v5, 0x3f4ccccd    # 0.8f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 566
    goto :goto_0

    .line 568
    :pswitch_8
    const v5, 0x3f666666    # 0.9f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 569
    goto :goto_0

    .line 571
    :pswitch_9
    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    goto :goto_0

    .line 542
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method public toggleRecordingClicked(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 463
    const-string v2, ""

    .line 464
    .local v2, "toast_message":Ljava/lang/String;
    const v3, 0x7f0f00a3

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 466
    .local v0, "fab":Landroid/support/design/widget/FloatingActionButton;
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->isRecording:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 467
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->stop_recording()V

    .line 468
    const-string v2, "Stopped recording"

    .line 469
    const v3, -0x777778

    invoke-static {v3}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/support/design/widget/FloatingActionButton;->setBackgroundTintList(Landroid/content/res/ColorStateList;)V

    .line 476
    :cond_0
    :goto_0
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->isRecording:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_2

    const/4 v3, 0x1

    :goto_1
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->isRecording:Ljava/lang/Boolean;

    .line 477
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 478
    .local v1, "toast":Landroid/widget/Toast;
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 480
    return-void

    .line 471
    .end local v1    # "toast":Landroid/widget/Toast;
    :cond_1
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity;->isRecording:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_0

    .line 472
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/MainActivity;->start_recording()V

    .line 473
    const-string v2, "Recording"

    .line 474
    const/high16 v3, -0x10000

    invoke-static {v3}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/support/design/widget/FloatingActionButton;->setBackgroundTintList(Landroid/content/res/ColorStateList;)V

    goto :goto_0

    :cond_2
    move v3, v4

    .line 476
    goto :goto_1
.end method

.method public toggleSecondaryBar(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 264
    const v1, 0x7f0f00ab

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 265
    .local v0, "rlSecondaryBar":Landroid/widget/RelativeLayout;
    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    .line 266
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 271
    :goto_0
    return-void

    .line 268
    :cond_0
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public toggleThrottleMod(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/high16 v6, 0x3f800000    # 1.0f

    .line 483
    const v5, 0x7f0f00b9

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 484
    .local v4, "tvThrottleMod":Landroid/widget/TextView;
    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-interface {v5}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 485
    .local v0, "currentValue":I
    add-int/lit8 v1, v0, 0x1

    .line 486
    .local v1, "nextValue":I
    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 488
    .local v3, "t_mod":Ljava/lang/Float;
    const/16 v5, 0xa

    if-ne v0, v5, :cond_0

    .line 489
    const/4 v1, 0x1

    .line 492
    :cond_0
    packed-switch v1, :pswitch_data_0

    .line 525
    :goto_0
    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity;->ch:Lcom/brynk/fathom/helpers/CoordinateHelper;

    invoke-virtual {v5, v3}, Lcom/brynk/fathom/helpers/CoordinateHelper;->changeThrottleMinAndMax(Ljava/lang/Float;)V

    .line 526
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 527
    .local v2, "nextValueString":Ljava/lang/String;
    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 529
    return-void

    .line 494
    .end local v2    # "nextValueString":Ljava/lang/String;
    :pswitch_0
    const v5, 0x3dcccccd    # 0.1f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 495
    goto :goto_0

    .line 497
    :pswitch_1
    const v5, 0x3e4ccccd    # 0.2f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 498
    goto :goto_0

    .line 500
    :pswitch_2
    const v5, 0x3e99999a    # 0.3f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 501
    goto :goto_0

    .line 503
    :pswitch_3
    const v5, 0x3ecccccd    # 0.4f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 504
    goto :goto_0

    .line 506
    :pswitch_4
    const/high16 v5, 0x3f000000    # 0.5f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 507
    goto :goto_0

    .line 509
    :pswitch_5
    const v5, 0x3f19999a    # 0.6f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 510
    goto :goto_0

    .line 512
    :pswitch_6
    const v5, 0x3f333333    # 0.7f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 513
    goto :goto_0

    .line 515
    :pswitch_7
    const v5, 0x3f4ccccd    # 0.8f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 516
    goto :goto_0

    .line 518
    :pswitch_8
    const v5, 0x3f666666    # 0.9f

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 519
    goto :goto_0

    .line 521
    :pswitch_9
    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    goto :goto_0

    .line 492
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method
