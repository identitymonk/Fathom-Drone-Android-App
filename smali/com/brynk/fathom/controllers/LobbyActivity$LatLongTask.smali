.class Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;
.super Landroid/os/AsyncTask;
.source "LobbyActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/LobbyActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LatLongTask"
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

.field private mContext:Landroid/content/Context;

.field private phone_latitude:D

.field private phone_longitude:D

.field final synthetic this$0:Lcom/brynk/fathom/controllers/LobbyActivity;


# direct methods
.method public constructor <init>(Lcom/brynk/fathom/controllers/LobbyActivity;Ljava/lang/String;Landroid/content/Context;)V
    .locals 2
    .param p2, "i"    # Ljava/lang/String;
    .param p3, "c"    # Landroid/content/Context;

    .prologue
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 345
    iput-object p1, p0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->this$0:Lcom/brynk/fathom/controllers/LobbyActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 341
    iput-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->phone_latitude:D

    .line 342
    iput-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->phone_longitude:D

    .line 346
    iput-object p2, p0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->DRONE_IP:Ljava/lang/String;

    .line 347
    iput-object p3, p0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->mContext:Landroid/content/Context;

    .line 348
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 339
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 26
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 353
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->mContext:Landroid/content/Context;

    move-object/from16 v22, v0

    const-string v23, "window"

    invoke-virtual/range {v22 .. v23}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Landroid/view/WindowManager;

    .line 354
    .local v21, "wm":Landroid/view/WindowManager;
    invoke-interface/range {v21 .. v21}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v4

    .line 355
    .local v4, "display":Landroid/view/Display;
    new-instance v10, Landroid/util/DisplayMetrics;

    invoke-direct {v10}, Landroid/util/DisplayMetrics;-><init>()V

    .line 356
    .local v10, "metrics":Landroid/util/DisplayMetrics;
    invoke-virtual {v4, v10}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 359
    iget v6, v10, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 360
    .local v6, "height":I
    iget v0, v10, Landroid/util/DisplayMetrics;->heightPixels:I

    move/from16 v20, v0

    .line 363
    .local v20, "width":I
    move/from16 v0, v20

    if-le v6, v0, :cond_0

    .line 364
    move/from16 v16, v20

    .line 365
    .local v16, "t":I
    move/from16 v20, v6

    .line 366
    move/from16 v6, v16

    .line 369
    .end local v16    # "t":I
    :cond_0
    move/from16 v0, v20

    int-to-double v0, v0

    move-wide/from16 v22, v0

    int-to-double v0, v6

    move-wide/from16 v24, v0

    div-double v12, v22, v24

    .line 370
    .local v12, "ratio":D
    const/16 v22, 0x168

    move/from16 v0, v22

    if-le v6, v0, :cond_1

    .line 371
    const/16 v6, 0x168

    .line 372
    int-to-double v0, v6

    move-wide/from16 v22, v0

    mul-double v22, v22, v12

    invoke-static/range {v22 .. v23}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    .line 373
    .local v11, "newWidth":Ljava/lang/Double;
    invoke-virtual {v11}, Ljava/lang/Double;->intValue()I

    move-result v20

    .line 380
    .end local v11    # "newWidth":Ljava/lang/Double;
    :cond_1
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    .line 381
    .local v15, "result":Ljava/lang/StringBuilder;
    const/16 v17, 0x0

    .line 383
    .local v17, "url":Ljava/net/URL;
    :try_start_0
    new-instance v22, Lcom/brynk/fathom/helpers/WiFiHelper;

    invoke-direct/range {v22 .. v22}, Lcom/brynk/fathom/helpers/WiFiHelper;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->this$0:Lcom/brynk/fathom/controllers/LobbyActivity;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Lcom/brynk/fathom/helpers/WiFiHelper;->getIPAddress(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v8

    .line 384
    .local v8, "ip":Ljava/lang/String;
    new-instance v18, Ljava/net/URL;

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "http://"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->DRONE_IP:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "/camera/start?ip="

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "&lat="

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->phone_latitude:D

    move-wide/from16 v24, v0

    move-object/from16 v0, v22

    move-wide/from16 v1, v24

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "&longitude="

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->phone_longitude:D

    move-wide/from16 v24, v0

    move-object/from16 v0, v22

    move-wide/from16 v1, v24

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "&h="

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "&w="

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .end local v17    # "url":Ljava/net/URL;
    .local v18, "url":Ljava/net/URL;
    move-object/from16 v17, v18

    .line 389
    .end local v8    # "ip":Ljava/lang/String;
    .end local v18    # "url":Ljava/net/URL;
    .restart local v17    # "url":Ljava/net/URL;
    :goto_0
    const/16 v19, 0x0

    .line 391
    .local v19, "urlConnection":Ljava/net/HttpURLConnection;
    :try_start_1
    invoke-virtual/range {v17 .. v17}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v22

    move-object/from16 v0, v22

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object/from16 v19, v0

    .line 392
    new-instance v7, Ljava/io/BufferedInputStream;

    invoke-virtual/range {v19 .. v19}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-direct {v7, v0}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 393
    .local v7, "in":Ljava/io/InputStream;
    new-instance v14, Ljava/io/BufferedReader;

    new-instance v22, Ljava/io/InputStreamReader;

    move-object/from16 v0, v22

    invoke-direct {v0, v7}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    move-object/from16 v0, v22

    invoke-direct {v14, v0}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 396
    .local v14, "reader":Ljava/io/BufferedReader;
    :goto_1
    invoke-virtual {v14}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v9

    .local v9, "line":Ljava/lang/String;
    if-eqz v9, :cond_2

    .line 397
    invoke-virtual {v15, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 403
    .end local v7    # "in":Ljava/io/InputStream;
    .end local v9    # "line":Ljava/lang/String;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v5

    .line 406
    .local v5, "e":Ljava/io/IOException;
    const-string v22, "FATHOM1"

    const-string v23, "Error establishing URL connection"

    invoke-static/range {v22 .. v23}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 407
    invoke-virtual {v5}, Ljava/io/IOException;->printStackTrace()V

    .line 410
    .end local v5    # "e":Ljava/io/IOException;
    :goto_2
    const-string v22, "TODO"

    return-object v22

    .line 385
    .end local v19    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_1
    move-exception v5

    .line 387
    .local v5, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v5}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_0

    .line 399
    .end local v5    # "e":Ljava/net/MalformedURLException;
    .restart local v7    # "in":Ljava/io/InputStream;
    .restart local v9    # "line":Ljava/lang/String;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v19    # "urlConnection":Ljava/net/HttpURLConnection;
    :cond_2
    :try_start_2
    invoke-virtual/range {v19 .. v19}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 400
    sget-object v22, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 401
    const-string v22, "FATHOM1"

    const-string v23, "Pilot stream started"

    invoke-static/range {v22 .. v23}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_2
.end method

.method public getPhone_latitude()D
    .locals 2

    .prologue
    .line 434
    iget-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->phone_latitude:D

    return-wide v0
.end method

.method public getPhone_longitude()D
    .locals 2

    .prologue
    .line 422
    iget-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->phone_longitude:D

    return-wide v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 339
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 0
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 419
    return-void
.end method

.method public setPhone_latitude(D)V
    .locals 1
    .param p1, "phone_latitude"    # D

    .prologue
    .line 430
    iput-wide p1, p0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->phone_latitude:D

    .line 431
    return-void
.end method

.method public setPhone_longitude(D)V
    .locals 1
    .param p1, "phone_longitude"    # D

    .prologue
    .line 426
    iput-wide p1, p0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->phone_longitude:D

    .line 427
    return-void
.end method
