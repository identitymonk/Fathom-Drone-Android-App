.class public Lcom/brynk/fathom/controllers/FirmwareActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "FirmwareActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;,
        Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateFirmwareTask;
    }
.end annotation


# instance fields
.field private DRONE_IP:Ljava/lang/String;

.field private exec:Ljava/util/concurrent/ScheduledExecutorService;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 29
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity;->exec:Ljava/util/concurrent/ScheduledExecutorService;

    .line 103
    return-void
.end method

.method static synthetic access$100(Lcom/brynk/fathom/controllers/FirmwareActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/FirmwareActivity;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity;->DRONE_IP:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 32
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 33
    const v0, 0x7f04001c

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/FirmwareActivity;->setContentView(I)V

    .line 34
    new-instance v0, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v0}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/FirmwareActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity;->DRONE_IP:Ljava/lang/String;

    .line 36
    new-instance v7, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateFirmwareTask;

    const/4 v0, 0x0

    invoke-direct {v7, p0, v0}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateFirmwareTask;-><init>(Lcom/brynk/fathom/controllers/FirmwareActivity;Lcom/brynk/fathom/controllers/FirmwareActivity$1;)V

    .line 37
    .local v7, "updateFirmwareTask":Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateFirmwareTask;
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, ""

    aput-object v2, v0, v1

    invoke-virtual {v7, v0}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateFirmwareTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 40
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity;->exec:Ljava/util/concurrent/ScheduledExecutorService;

    .line 42
    iget-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity;->exec:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Lcom/brynk/fathom/controllers/FirmwareActivity$1;

    invoke-direct {v1, p0}, Lcom/brynk/fathom/controllers/FirmwareActivity$1;-><init>(Lcom/brynk/fathom/controllers/FirmwareActivity;)V

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 48
    return-void
.end method
