.class Lcom/brynk/fathom/controllers/SettingsActivity$ConnectedTask;
.super Landroid/os/AsyncTask;
.source "SettingsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/SettingsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConnectedTask"
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

.field final synthetic this$0:Lcom/brynk/fathom/controllers/SettingsActivity;


# direct methods
.method public constructor <init>(Lcom/brynk/fathom/controllers/SettingsActivity;Landroid/content/Context;Ljava/lang/String;)V
    .locals 0
    .param p2, "c"    # Landroid/content/Context;
    .param p3, "drone_ip"    # Ljava/lang/String;

    .prologue
    .line 505
    iput-object p1, p0, Lcom/brynk/fathom/controllers/SettingsActivity$ConnectedTask;->this$0:Lcom/brynk/fathom/controllers/SettingsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 506
    iput-object p2, p0, Lcom/brynk/fathom/controllers/SettingsActivity$ConnectedTask;->mContext:Landroid/content/Context;

    .line 507
    iput-object p3, p0, Lcom/brynk/fathom/controllers/SettingsActivity$ConnectedTask;->DRONE_IP:Ljava/lang/String;

    .line 508
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 502
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/SettingsActivity$ConnectedTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 13
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 512
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 513
    .local v7, "result":Ljava/lang/StringBuilder;
    const/4 v8, 0x0

    .line 514
    .local v8, "url":Ljava/net/URL;
    const-string v6, "NOT_CONNECTED"

    .line 515
    .local v6, "response":Ljava/lang/String;
    const/4 v3, 0x0

    .line 517
    .local v3, "isConnected":Z
    :try_start_0
    new-instance v9, Ljava/net/URL;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "http://"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    iget-object v12, p0, Lcom/brynk/fathom/controllers/SettingsActivity$ConnectedTask;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "/"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v9, v11}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .end local v8    # "url":Ljava/net/URL;
    .local v9, "url":Ljava/net/URL;
    move-object v8, v9

    .line 523
    .end local v9    # "url":Ljava/net/URL;
    .restart local v8    # "url":Ljava/net/URL;
    :goto_0
    const/4 v10, 0x0

    .line 525
    .local v10, "urlConnection":Ljava/net/HttpURLConnection;
    :try_start_1
    invoke-virtual {v8}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v11

    move-object v0, v11

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v10, v0
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 532
    :goto_1
    :try_start_2
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v11

    invoke-direct {v2, v11}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 533
    .local v2, "in":Ljava/io/InputStream;
    new-instance v5, Ljava/io/BufferedReader;

    new-instance v11, Ljava/io/InputStreamReader;

    invoke-direct {v11, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v5, v11}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 536
    .local v5, "reader":Ljava/io/BufferedReader;
    :goto_2
    invoke-virtual {v5}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .local v4, "line":Ljava/lang/String;
    if-eqz v4, :cond_1

    .line 537
    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 540
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v1

    .line 541
    .local v1, "e":Ljava/io/IOException;
    :try_start_3
    const-string v11, "FATHOM1"

    const-string v12, "Error reading input from URL"

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 542
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 543
    const/4 v3, 0x0

    .line 545
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 546
    if-eqz v3, :cond_0

    .line 547
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 552
    .end local v1    # "e":Ljava/io/IOException;
    :cond_0
    :goto_3
    return-object v6

    .line 518
    .end local v10    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_1
    move-exception v1

    .line 520
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    .line 521
    const/4 v3, 0x0

    goto :goto_0

    .line 526
    .end local v1    # "e":Ljava/net/MalformedURLException;
    .restart local v10    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_2
    move-exception v1

    .line 527
    .local v1, "e":Ljava/io/IOException;
    const-string v11, "FATHOM1"

    const-string v12, "Error establishing URL connection"

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 528
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    .line 529
    const/4 v3, 0x0

    goto :goto_1

    .line 539
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v2    # "in":Ljava/io/InputStream;
    .restart local v4    # "line":Ljava/lang/String;
    .restart local v5    # "reader":Ljava/io/BufferedReader;
    :cond_1
    const/4 v3, 0x1

    .line 545
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 546
    if-eqz v3, :cond_0

    .line 547
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_3

    .line 545
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "reader":Ljava/io/BufferedReader;
    :catchall_0
    move-exception v11

    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 546
    if-eqz v3, :cond_2

    .line 547
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    :cond_2
    throw v11
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 502
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/SettingsActivity$ConnectedTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 557
    const-string v0, "Connection failed"

    .line 558
    .local v0, "r":Ljava/lang/String;
    if-eqz p1, :cond_0

    const-string v2, "NOT_CONNECTED"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 560
    const-string v0, "Connected"

    .line 562
    :cond_0
    iget-object v2, p0, Lcom/brynk/fathom/controllers/SettingsActivity$ConnectedTask;->mContext:Landroid/content/Context;

    const/4 v3, 0x0

    invoke-static {v2, v0, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 563
    .local v1, "toast":Landroid/widget/Toast;
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 564
    return-void
.end method
