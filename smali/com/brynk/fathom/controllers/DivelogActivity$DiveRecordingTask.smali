.class Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;
.super Landroid/os/AsyncTask;
.source "DivelogActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/DivelogActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DiveRecordingTask"
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
.field private DRONE_IP:Ljava/lang/String;

.field final synthetic this$0:Lcom/brynk/fathom/controllers/DivelogActivity;


# direct methods
.method public constructor <init>(Lcom/brynk/fathom/controllers/DivelogActivity;Ljava/lang/String;)V
    .locals 0
    .param p2, "i"    # Ljava/lang/String;

    .prologue
    .line 225
    iput-object p1, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 226
    iput-object p2, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->DRONE_IP:Ljava/lang/String;

    .line 227
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 223
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 231
    iget-object v1, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "http://"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/flights/recordings"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/brynk/fathom/controllers/DivelogActivity;->access$000(Lcom/brynk/fathom/controllers/DivelogActivity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 233
    .local v0, "result":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 223
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 22
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 239
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    const v21, 0x7f0f0099

    move/from16 v0, v21

    invoke-virtual {v7, v0}, Lcom/brynk/fathom/controllers/DivelogActivity;->findViewById(I)Landroid/view/View;

    move-result-object v15

    check-cast v15, Landroid/widget/ListView;

    .line 240
    .local v15, "listView":Landroid/widget/ListView;
    const/16 v19, 0x0

    .line 242
    .local v19, "recordings":Lorg/json/JSONArray;
    :try_start_0
    new-instance v20, Lorg/json/JSONArray;

    move-object/from16 v0, v20

    move-object/from16 v1, p1

    invoke-direct {v0, v1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v19    # "recordings":Lorg/json/JSONArray;
    .local v20, "recordings":Lorg/json/JSONArray;
    move-object/from16 v19, v20

    .line 252
    .end local v20    # "recordings":Lorg/json/JSONArray;
    .restart local v19    # "recordings":Lorg/json/JSONArray;
    :goto_0
    const-string v17, ""

    .line 253
    .local v17, "message_to_log":Ljava/lang/String;
    const/4 v10, 0x0

    .line 254
    .local v10, "divelogEntries":[Lcom/brynk/fathom/helpers/DivelogEntry;
    if-nez v19, :cond_2

    .line 256
    const-string v17, "No records found"

    .line 281
    :cond_0
    const-string v7, "FATHOM1"

    move-object/from16 v0, v17

    invoke-static {v7, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 283
    if-eqz v10, :cond_1

    .line 284
    new-instance v9, Lcom/brynk/fathom/helpers/DivelogAdapter;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->this$0:Lcom/brynk/fathom/controllers/DivelogActivity;

    invoke-virtual {v7}, Lcom/brynk/fathom/controllers/DivelogActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    invoke-direct {v9, v7, v10}, Lcom/brynk/fathom/helpers/DivelogAdapter;-><init>(Landroid/content/Context;[Lcom/brynk/fathom/helpers/DivelogEntry;)V

    .line 285
    .local v9, "adapter":Lcom/brynk/fathom/helpers/DivelogAdapter;
    invoke-virtual {v15, v9}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 289
    .end local v9    # "adapter":Lcom/brynk/fathom/helpers/DivelogAdapter;
    :cond_1
    return-void

    .line 243
    .end local v10    # "divelogEntries":[Lcom/brynk/fathom/helpers/DivelogEntry;
    .end local v17    # "message_to_log":Ljava/lang/String;
    :catch_0
    move-exception v11

    .line 244
    .local v11, "e":Lorg/json/JSONException;
    invoke-virtual {v11}, Lorg/json/JSONException;->printStackTrace()V

    .line 246
    :try_start_1
    new-instance v20, Lorg/json/JSONArray;

    const-string v7, ""

    move-object/from16 v0, v20

    invoke-direct {v0, v7}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .end local v19    # "recordings":Lorg/json/JSONArray;
    .restart local v20    # "recordings":Lorg/json/JSONArray;
    move-object/from16 v19, v20

    .line 249
    .end local v20    # "recordings":Lorg/json/JSONArray;
    .restart local v19    # "recordings":Lorg/json/JSONArray;
    goto :goto_0

    .line 247
    :catch_1
    move-exception v12

    .line 248
    .local v12, "e1":Lorg/json/JSONException;
    invoke-virtual {v12}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 258
    .end local v11    # "e":Lorg/json/JSONException;
    .end local v12    # "e1":Lorg/json/JSONException;
    .restart local v10    # "divelogEntries":[Lcom/brynk/fathom/helpers/DivelogEntry;
    .restart local v17    # "message_to_log":Ljava/lang/String;
    :cond_2
    invoke-virtual/range {v19 .. v19}, Lorg/json/JSONArray;->length()I

    move-result v7

    new-array v10, v7, [Lcom/brynk/fathom/helpers/DivelogEntry;

    .line 259
    invoke-virtual/range {v19 .. v19}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v17

    .line 260
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_1
    invoke-virtual/range {v19 .. v19}, Lorg/json/JSONArray;->length()I

    move-result v7

    if-ge v13, v7, :cond_0

    .line 262
    :try_start_2
    move-object/from16 v0, v19

    invoke-virtual {v0, v13}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v18

    .line 263
    .local v18, "r":Lorg/json/JSONObject;
    const-string v7, "name"

    move-object/from16 v0, v18

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 264
    .local v3, "n":Ljava/lang/String;
    const-string v7, "latitude"

    move-object/from16 v0, v18

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 265
    .local v14, "la":Ljava/lang/String;
    const-string v7, "longitude"

    move-object/from16 v0, v18

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 266
    .local v16, "lo":Ljava/lang/String;
    const-string v7, "start_time"

    move-object/from16 v0, v18

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 268
    .local v5, "s_t":Ljava/lang/String;
    const-string v6, ""

    .line 269
    .local v6, "e_t":Ljava/lang/String;
    const-string v7, "when"

    move-object/from16 v0, v18

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 270
    .local v4, "w":Ljava/lang/String;
    const-string v7, "converted"

    move-object/from16 v0, v18

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 273
    .local v8, "isConverted":Ljava/lang/String;
    new-instance v2, Lcom/brynk/fathom/helpers/DivelogEntry;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v21, ","

    move-object/from16 v0, v21

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, v16

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v2 .. v8}, Lcom/brynk/fathom/helpers/DivelogEntry;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    .local v2, "dle":Lcom/brynk/fathom/helpers/DivelogEntry;
    aput-object v2, v10, v13
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 260
    .end local v2    # "dle":Lcom/brynk/fathom/helpers/DivelogEntry;
    .end local v3    # "n":Ljava/lang/String;
    .end local v4    # "w":Ljava/lang/String;
    .end local v5    # "s_t":Ljava/lang/String;
    .end local v6    # "e_t":Ljava/lang/String;
    .end local v8    # "isConverted":Ljava/lang/String;
    .end local v14    # "la":Ljava/lang/String;
    .end local v16    # "lo":Ljava/lang/String;
    .end local v18    # "r":Lorg/json/JSONObject;
    :goto_2
    add-int/lit8 v13, v13, 0x1

    goto :goto_1

    .line 275
    :catch_2
    move-exception v11

    .line 276
    .restart local v11    # "e":Lorg/json/JSONException;
    invoke-virtual {v11}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_2
.end method
