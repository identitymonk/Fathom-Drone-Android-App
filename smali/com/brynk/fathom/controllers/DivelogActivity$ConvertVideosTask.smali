.class Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;
.super Landroid/os/AsyncTask;
.source "DivelogActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/DivelogActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConvertVideosTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/DivelogActivity;


# direct methods
.method public constructor <init>(Lcom/brynk/fathom/controllers/DivelogActivity;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 151
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 149
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 155
    iget-object v1, p0, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    const/4 v2, 0x0

    aget-object v2, p1, v2

    invoke-static {v1, v2}, Lcom/brynk/fathom/controllers/DivelogActivity;->access$000(Lcom/brynk/fathom/controllers/DivelogActivity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 157
    .local v0, "result":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 149
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 164
    iget-object v2, p0, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    const v3, 0x7f0f009b

    invoke-virtual {v2, v3}, Lcom/brynk/fathom/controllers/DivelogActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    .line 165
    .local v1, "rlDiveLogConvertingOverlay":Landroid/widget/RelativeLayout;
    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 168
    new-instance v0, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;

    iget-object v2, p0, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    iget-object v3, p0, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    invoke-static {v3}, Lcom/brynk/fathom/controllers/DivelogActivity;->access$100(Lcom/brynk/fathom/controllers/DivelogActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;-><init>(Lcom/brynk/fathom/controllers/DivelogActivity;Ljava/lang/String;)V

    .line 169
    .local v0, "drt":Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, ""

    aput-object v4, v2, v3

    invoke-virtual {v0, v2}, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 173
    return-void
.end method
