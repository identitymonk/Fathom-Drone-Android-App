.class Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;
.super Landroid/os/AsyncTask;
.source "DivelogActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/DivelogActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DroneInfoTask"
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
    .line 177
    iput-object p1, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 178
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 176
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 182
    iget-object v1, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    const/4 v2, 0x0

    aget-object v2, p1, v2

    invoke-static {v1, v2}, Lcom/brynk/fathom/controllers/DivelogActivity;->access$000(Lcom/brynk/fathom/controllers/DivelogActivity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 184
    .local v0, "result":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 176
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 9
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 190
    iget-object v7, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    const v8, 0x7f0f0096

    invoke-virtual {v7, v8}, Lcom/brynk/fathom/controllers/DivelogActivity;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 191
    .local v6, "tvDiveLogUptime":Landroid/widget/TextView;
    iget-object v7, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    const v8, 0x7f0f0097

    invoke-virtual {v7, v8}, Lcom/brynk/fathom/controllers/DivelogActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 192
    .local v5, "tvDiveLogFlighttime":Landroid/widget/TextView;
    iget-object v7, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    const v8, 0x7f0f0098

    invoke-virtual {v7, v8}, Lcom/brynk/fathom/controllers/DivelogActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 194
    .local v4, "tvDiveLogFlightCount":Landroid/widget/TextView;
    const/4 v0, 0x0

    .line 196
    .local v0, "droneInfo":Lorg/json/JSONObject;
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v0    # "droneInfo":Lorg/json/JSONObject;
    .local v1, "droneInfo":Lorg/json/JSONObject;
    move-object v0, v1

    .line 210
    .end local v1    # "droneInfo":Lorg/json/JSONObject;
    .restart local v0    # "droneInfo":Lorg/json/JSONObject;
    :goto_0
    :try_start_1
    iget-object v7, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    const-string v8, "uptime"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    invoke-static {v7, v8}, Lcom/brynk/fathom/controllers/DivelogActivity;->access$200(Lcom/brynk/fathom/controllers/DivelogActivity;I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 211
    iget-object v7, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    const-string v8, "flighttime"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    invoke-static {v7, v8}, Lcom/brynk/fathom/controllers/DivelogActivity;->access$200(Lcom/brynk/fathom/controllers/DivelogActivity;I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 212
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "flightcount"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_2

    .line 219
    :goto_1
    return-void

    .line 197
    :catch_0
    move-exception v2

    .line 198
    .local v2, "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    .line 200
    :try_start_2
    new-instance v1, Lorg/json/JSONObject;

    const-string v7, ""

    invoke-direct {v1, v7}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    .end local v0    # "droneInfo":Lorg/json/JSONObject;
    .restart local v1    # "droneInfo":Lorg/json/JSONObject;
    move-object v0, v1

    .line 205
    .end local v1    # "droneInfo":Lorg/json/JSONObject;
    .restart local v0    # "droneInfo":Lorg/json/JSONObject;
    goto :goto_0

    .line 203
    :catch_1
    move-exception v3

    .line 204
    .local v3, "e1":Lorg/json/JSONException;
    invoke-virtual {v3}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 214
    .end local v2    # "e":Lorg/json/JSONException;
    .end local v3    # "e1":Lorg/json/JSONException;
    :catch_2
    move-exception v2

    .line 215
    .restart local v2    # "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method
