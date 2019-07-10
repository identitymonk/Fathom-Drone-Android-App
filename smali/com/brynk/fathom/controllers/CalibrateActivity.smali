.class public Lcom/brynk/fathom/controllers/CalibrateActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "CalibrateActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;
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

    .line 124
    return-void
.end method

.method private setStepVideo(IZZ)V
    .locals 3
    .param p1, "video"    # I
    .param p2, "shouldLoop"    # Z
    .param p3, "shouldPlay"    # Z

    .prologue
    .line 109
    const v0, 0x7f0f0093

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/CalibrateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/VideoView;

    iput-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->loadingVideo:Landroid/widget/VideoView;

    .line 110
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->loadingVideo:Landroid/widget/VideoView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "android.resource://"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/CalibrateActivity;->getPackageName()Ljava/lang/String;

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

    .line 111
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->loadingVideo:Landroid/widget/VideoView;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->seekTo(I)V

    .line 112
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->loadingVideo:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->start()V

    .line 113
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->loadingVideo:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->resume()V

    .line 114
    iget-object v0, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->loadingVideo:Landroid/widget/VideoView;

    new-instance v1, Lcom/brynk/fathom/controllers/CalibrateActivity$1;

    invoke-direct {v1, p0, p2, p3}, Lcom/brynk/fathom/controllers/CalibrateActivity$1;-><init>(Lcom/brynk/fathom/controllers/CalibrateActivity;ZZ)V

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 121
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
    const v1, 0x7f040019

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setContentView(I)V

    .line 35
    const v1, 0x7f0f00d1

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/CalibrateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    .line 36
    .local v0, "toolbar":Landroid/support/v7/widget/Toolbar;
    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V

    .line 37
    const/4 v1, 0x1

    iput v1, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->step:I

    .line 38
    new-instance v1, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v1}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/CalibrateActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->DRONE_IP:Ljava/lang/String;

    .line 39
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->loadingVideo:Landroid/widget/VideoView;

    .line 40
    const v1, 0x7f070006

    invoke-direct {p0, v1, v3, v3}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setStepVideo(IZZ)V

    .line 46
    return-void
.end method

.method public onNextClicked(Landroid/view/View;)V
    .locals 9
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const v8, 0x7f070006

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 49
    const v3, 0x7f0f0094

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/CalibrateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 51
    .local v2, "tv_calibrate":Landroid/widget/TextView;
    const-string v1, ""

    .line 52
    .local v1, "instruction":Ljava/lang/String;
    iget v3, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->step:I

    packed-switch v3, :pswitch_data_0

    .line 93
    :goto_0
    iget v3, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->step:I

    const/16 v4, 0x8

    if-ge v3, v4, :cond_0

    .line 94
    iget v3, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->step:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->step:I

    .line 95
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 107
    :goto_1
    return-void

    .line 54
    :pswitch_0
    const-string v1, "Turn left"

    .line 55
    const v3, 0x7f07000a

    invoke-direct {p0, v3, v6, v7}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setStepVideo(IZZ)V

    goto :goto_0

    .line 58
    :pswitch_1
    const-string v1, "Turn right"

    .line 59
    new-instance v3, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;-><init>(Lcom/brynk/fathom/controllers/CalibrateActivity;Ljava/lang/String;)V

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "xmin"

    aput-object v5, v4, v6

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 60
    const v3, 0x7f07000b

    invoke-direct {p0, v3, v6, v7}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setStepVideo(IZZ)V

    goto :goto_0

    .line 63
    :pswitch_2
    const-string v1, "Pitch down"

    .line 64
    new-instance v3, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;-><init>(Lcom/brynk/fathom/controllers/CalibrateActivity;Ljava/lang/String;)V

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "xmax"

    aput-object v5, v4, v6

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 65
    const v3, 0x7f070007

    invoke-direct {p0, v3, v6, v7}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setStepVideo(IZZ)V

    goto :goto_0

    .line 68
    :pswitch_3
    const-string v1, "Pitch up"

    .line 69
    new-instance v3, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;-><init>(Lcom/brynk/fathom/controllers/CalibrateActivity;Ljava/lang/String;)V

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "ymin"

    aput-object v5, v4, v6

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 70
    const v3, 0x7f070008

    invoke-direct {p0, v3, v6, v7}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setStepVideo(IZZ)V

    goto :goto_0

    .line 73
    :pswitch_4
    const-string v1, "Move up"

    .line 74
    new-instance v3, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;-><init>(Lcom/brynk/fathom/controllers/CalibrateActivity;Ljava/lang/String;)V

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "ymax"

    aput-object v5, v4, v6

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 75
    invoke-direct {p0, v8, v6, v7}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setStepVideo(IZZ)V

    goto :goto_0

    .line 78
    :pswitch_5
    const-string v1, "Move down"

    .line 79
    new-instance v3, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;-><init>(Lcom/brynk/fathom/controllers/CalibrateActivity;Ljava/lang/String;)V

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "zmax"

    aput-object v5, v4, v6

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 80
    const v3, 0x7f070005

    invoke-direct {p0, v3, v6, v7}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setStepVideo(IZZ)V

    goto/16 :goto_0

    .line 83
    :pswitch_6
    const-string v1, "Calibration successful"

    .line 84
    const v3, 0x7f0f0095

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/CalibrateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 85
    .local v0, "btn_next":Landroid/widget/Button;
    const-string v3, "Done"

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 86
    new-instance v3, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;-><init>(Lcom/brynk/fathom/controllers/CalibrateActivity;Ljava/lang/String;)V

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "zmin"

    aput-object v5, v4, v6

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 87
    invoke-direct {p0, v8, v6, v6}, Lcom/brynk/fathom/controllers/CalibrateActivity;->setStepVideo(IZZ)V

    goto/16 :goto_0

    .line 99
    .end local v0    # "btn_next":Landroid/widget/Button;
    :cond_0
    new-instance v3, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;-><init>(Lcom/brynk/fathom/controllers/CalibrateActivity;Ljava/lang/String;)V

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "calc"

    aput-object v5, v4, v6

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/CalibrateActivity$CalibrateTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 100
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/CalibrateActivity;->finish()V

    .line 104
    iget v3, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->step:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/brynk/fathom/controllers/CalibrateActivity;->step:I

    goto/16 :goto_1

    .line 52
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method
