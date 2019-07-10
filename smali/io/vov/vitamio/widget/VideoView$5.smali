.class Lio/vov/vitamio/widget/VideoView$5;
.super Ljava/lang/Object;
.source "VideoView.java"

# interfaces
.implements Lio/vov/vitamio/MediaPlayer$OnErrorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/vov/vitamio/widget/VideoView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/vov/vitamio/widget/VideoView;


# direct methods
.method constructor <init>(Lio/vov/vitamio/widget/VideoView;)V
    .locals 0
    .param p1, "this$0"    # Lio/vov/vitamio/widget/VideoView;

    .prologue
    .line 209
    iput-object p1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lio/vov/vitamio/MediaPlayer;II)Z
    .locals 8
    .param p1, "mp"    # Lio/vov/vitamio/MediaPlayer;
    .param p2, "framework_err"    # I
    .param p3, "impl_err"    # I

    .prologue
    const/4 v7, 0x0

    const/4 v4, -0x1

    const/4 v6, 0x1

    .line 211
    const-string v1, "Error: %d, %d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v7

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v1, v2}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 212
    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v1, v4}, Lio/vov/vitamio/widget/VideoView;->access$502(Lio/vov/vitamio/widget/VideoView;I)I

    .line 213
    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v1, v4}, Lio/vov/vitamio/widget/VideoView;->access$1202(Lio/vov/vitamio/widget/VideoView;I)I

    .line 214
    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v1}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 215
    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v1}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v1

    invoke-virtual {v1}, Lio/vov/vitamio/widget/MediaController;->hide()V

    .line 217
    :cond_0
    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v1}, Lio/vov/vitamio/widget/VideoView;->access$1700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnErrorListener;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 218
    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v1}, Lio/vov/vitamio/widget/VideoView;->access$1700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnErrorListener;

    move-result-object v1

    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v2

    invoke-interface {v1, v2, p2, p3}, Lio/vov/vitamio/MediaPlayer$OnErrorListener;->onError(Lio/vov/vitamio/MediaPlayer;II)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 232
    :cond_1
    :goto_0
    return v6

    .line 222
    :cond_2
    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v1}, Lio/vov/vitamio/widget/VideoView;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 223
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_3

    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v1}, Lio/vov/vitamio/widget/VideoView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "VideoView_error_text_invalid_progressive_playback"

    const-string v3, "string"

    iget-object v4, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v4}, Lio/vov/vitamio/widget/VideoView;->access$1800(Lio/vov/vitamio/widget/VideoView;)Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 225
    .local v0, "message":I
    :goto_1
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$1800(Lio/vov/vitamio/widget/VideoView;)Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v2}, Lio/vov/vitamio/widget/VideoView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const-string v3, "VideoView_error_title"

    const-string v4, "string"

    iget-object v5, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v5}, Lio/vov/vitamio/widget/VideoView;->access$1800(Lio/vov/vitamio/widget/VideoView;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v2}, Lio/vov/vitamio/widget/VideoView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const-string v3, "VideoView_error_button"

    const-string v4, "string"

    iget-object v5, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v5}, Lio/vov/vitamio/widget/VideoView;->access$1800(Lio/vov/vitamio/widget/VideoView;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    new-instance v3, Lio/vov/vitamio/widget/VideoView$5$1;

    invoke-direct {v3, p0}, Lio/vov/vitamio/widget/VideoView$5$1;-><init>(Lio/vov/vitamio/widget/VideoView$5;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    .line 230
    invoke-virtual {v1, v7}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0

    .line 223
    .end local v0    # "message":I
    :cond_3
    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v1}, Lio/vov/vitamio/widget/VideoView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "VideoView_error_text_unknown"

    const-string v3, "string"

    iget-object v4, p0, Lio/vov/vitamio/widget/VideoView$5;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v4}, Lio/vov/vitamio/widget/VideoView;->access$1800(Lio/vov/vitamio/widget/VideoView;)Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    goto :goto_1
.end method
