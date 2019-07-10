.class Lcom/brynk/fathom/controllers/CalibrateCompassActivity$1;
.super Ljava/lang/Object;
.source "CalibrateCompassActivity.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnPreparedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/CalibrateCompassActivity;->setStepVideo(IZZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/CalibrateCompassActivity;

.field final synthetic val$shouldLoop:Z

.field final synthetic val$shouldPlay:Z


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/CalibrateCompassActivity;ZZ)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/CalibrateCompassActivity;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$1;->this$0:Lcom/brynk/fathom/controllers/CalibrateCompassActivity;

    iput-boolean p2, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$1;->val$shouldLoop:Z

    iput-boolean p3, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$1;->val$shouldPlay:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPrepared(Landroid/media/MediaPlayer;)V
    .locals 1
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$1;->val$shouldLoop:Z

    invoke-virtual {p1, v0}, Landroid/media/MediaPlayer;->setLooping(Z)V

    .line 93
    iget-boolean v0, p0, Lcom/brynk/fathom/controllers/CalibrateCompassActivity$1;->val$shouldPlay:Z

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroid/media/MediaPlayer;->start()V

    .line 94
    :cond_0
    return-void
.end method
