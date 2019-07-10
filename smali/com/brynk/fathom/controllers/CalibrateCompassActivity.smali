.class public Lcom/brynk/fathom/controllers/CalibrateCompassActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "CalibrateCompassActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/CalibrateCompassActivity$CalibrateTask;
    }
.end annotation


# instance fields
.field private DRONE_IP:Ljava/lang/String;

.field private loadingVideo:Landroid/widget/VideoView;

.field private step:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 99
    return-void
.end method

.method private setStepVideo(IZZ)V
    .locals 3
    .param p1, "video"    # I
    .param p2, "shouldLoop"    # Z
    .param p3, "shouldPlay"    # Z

    .prologue
    .line 84
    const v0, 0x7f0f0093

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/VideoView;

    iput-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->loadingVideo:Landroid/widget/VideoView;

    .line 85
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->loadingVideo:Landroid/widget/VideoView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "android.resource://"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setVideoPath(Ljava/lang/String;)V

    .line 86
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->loadingVideo:Landroid/widget/VideoView;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->seekTo(I)V

    .line 87
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->loadingVideo:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->start()V

    .line 88
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->loadingVideo:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->resume()V

    .line 89
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->loadingVideo:Landroid/widget/VideoView;

    new-instance v1, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$1;

    invoke-direct {v1, p0, p2, p3}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$1;-><init>(Lcom/brynk/fathom/controllers/CalibrateCompassActivity;ZZ)V

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 96
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 33
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 34
    const v1, 0x7f04001a

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->setContentView(I)V

    .line 35
    const v1, 0x7f0f00d1

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    .line 36
    .local v0, "toolbar":Landroid/support/v7/widget/Toolbar;
    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V

    .line 37
    const/4 v1, 0x1

    iput v1, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->step:I

    .line 38
    new-instance v1, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v1}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->DRONE_IP:Ljava/lang/String;

    .line 39
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->loadingVideo:Landroid/widget/VideoView;

    .line 40
    const v1, 0x7f070006

    invoke-direct {p0, v1, v3, v3}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->setStepVideo(IZZ)V

    .line 46
    return-void
.end method

.method public onNextClicked(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 49
    const v3, 0x7f0f0094

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 51
    .local v2, "tv_calibrate":Landroid/widget/TextView;
    const-string v1, ""

    .line 52
    .local v1, "instruction":Ljava/lang/String;
    iget v3, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->step:I

    packed-switch v3, :pswitch_data_0

    .line 69
    :goto_0
    iget v3, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->step:I

    const/4 v4, 0x3

    if-ge v3, v4, :cond_0

    .line 70
    iget v3, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->step:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->step:I

    .line 71
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 82
    :goto_1
    return-void

    .line 54
    :pswitch_0
    const-string v1, "Spin twice"

    .line 55
    new-instance v3, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$CalibrateTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$CalibrateTask;-><init>(Lcom/brynk/fathom/controllers/CalibrateCompassActivity;Ljava/lang/String;)V

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "mag"

    aput-object v5, v4, v6

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$CalibrateTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 56
    const v3, 0x7f070004

    invoke-direct {p0, v3, v7, v7}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->setStepVideo(IZZ)V

    goto :goto_0

    .line 59
    :pswitch_1
    const-string v1, "Calibration successful"

    .line 60
    const v3, 0x7f0f0095

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 61
    .local v0, "btn_next":Landroid/widget/Button;
    const-string v3, "Done"

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 62
    new-instance v3, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$CalibrateTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$CalibrateTask;-><init>(Lcom/brynk/fathom/controllers/CalibrateCompassActivity;Ljava/lang/String;)V

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "calc"

    aput-object v5, v4, v6

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$CalibrateTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 63
    const v3, 0x7f070006

    invoke-direct {p0, v3, v6, v6}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->setStepVideo(IZZ)V

    goto :goto_0

    .line 75
    .end local v0    # "btn_next":Landroid/widget/Button;
    :cond_0
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->finish()V

    .line 79
    iget v3, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->step:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->step:I

    goto :goto_1

    .line 52
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
