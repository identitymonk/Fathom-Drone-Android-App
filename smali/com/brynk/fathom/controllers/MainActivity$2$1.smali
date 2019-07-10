.class Lcom/brynk/fathom/controllers/MainActivity$2$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/MainActivity$2;->onPrepared(Lio/vov/vitamio/MediaPlayer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/brynk/fathom/controllers/MainActivity$2;

.field final synthetic val$loadingVideo:Landroid/widget/VideoView;

.field final synthetic val$rl_pilotLoader:Landroid/widget/RelativeLayout;

.field final synthetic val$rl_pilotViewWrapper:Landroid/widget/RelativeLayout;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/MainActivity$2;Landroid/widget/RelativeLayout;Landroid/widget/VideoView;Landroid/widget/RelativeLayout;)V
    .locals 0
    .param p1, "this$1"    # Lcom/brynk/fathom/controllers/MainActivity$2;

    .prologue
    .line 192
    iput-object p1, p0, Lcom/brynk/fathom/controllers/MainActivity$2$1;->this$1:Lcom/brynk/fathom/controllers/MainActivity$2;

    iput-object p2, p0, Lcom/brynk/fathom/controllers/MainActivity$2$1;->val$rl_pilotLoader:Landroid/widget/RelativeLayout;

    iput-object p3, p0, Lcom/brynk/fathom/controllers/MainActivity$2$1;->val$loadingVideo:Landroid/widget/VideoView;

    iput-object p4, p0, Lcom/brynk/fathom/controllers/MainActivity$2$1;->val$rl_pilotViewWrapper:Landroid/widget/RelativeLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x4

    .line 197
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity$2$1;->val$rl_pilotLoader:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 198
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity$2$1;->val$rl_pilotLoader:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 199
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity$2$1;->val$loadingVideo:Landroid/widget/VideoView;

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setVisibility(I)V

    .line 200
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity$2$1;->val$loadingVideo:Landroid/widget/VideoView;

    invoke-virtual {v0, v2}, Landroid/widget/VideoView;->setVisibility(I)V

    .line 201
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity$2$1;->val$rl_pilotViewWrapper:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 204
    return-void
.end method
