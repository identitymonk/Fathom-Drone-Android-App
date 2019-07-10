.class Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;
.super Landroid/os/AsyncTask;
.source "WifiSetupStep3Activity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "NetworkConnectTask"
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
.field final synthetic this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;


# direct methods
.method private constructor <init>(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
    .param p2, "x1"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$1;

    .prologue
    .line 195
    invoke-direct {p0, p1}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;-><init>(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 195
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 13
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 201
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 202
    .local v6, "result":Ljava/lang/StringBuilder;
    const/4 v7, 0x0

    .line 203
    .local v7, "url":Ljava/net/URL;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "network="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-static {v11}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->access$400(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "&password="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-static {v11}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->access$500(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 205
    .local v4, "query_params":Ljava/lang/String;
    :try_start_0
    new-instance v8, Ljava/net/URL;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "http://"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-static {v11}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->access$200(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "/network/add?"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v8, v10}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .end local v7    # "url":Ljava/net/URL;
    .local v8, "url":Ljava/net/URL;
    move-object v7, v8

    .line 210
    .end local v8    # "url":Ljava/net/URL;
    .restart local v7    # "url":Ljava/net/URL;
    :goto_0
    const/4 v9, 0x0

    .line 212
    .local v9, "urlConnection":Ljava/net/HttpURLConnection;
    :try_start_1
    invoke-virtual {v7}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v10

    move-object v0, v10

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v9, v0
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 218
    :goto_1
    :try_start_2
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v10

    invoke-direct {v2, v10}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 219
    .local v2, "in":Ljava/io/InputStream;
    new-instance v5, Ljava/io/BufferedReader;

    new-instance v10, Ljava/io/InputStreamReader;

    invoke-direct {v10, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v5, v10}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 222
    .local v5, "reader":Ljava/io/BufferedReader;
    :goto_2
    invoke-virtual {v5}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .local v3, "line":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 223
    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 225
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v3    # "line":Ljava/lang/String;
    .end local v5    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v1

    .line 226
    .local v1, "e":Ljava/io/IOException;
    :try_start_3
    const-string v10, "FATHOM1"

    const-string v11, "Error reading input from URL"

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 227
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 229
    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 230
    sget-object v10, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 234
    .end local v1    # "e":Ljava/io/IOException;
    :goto_3
    const-string v10, "TODO"

    return-object v10

    .line 206
    .end local v9    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_1
    move-exception v1

    .line 208
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_0

    .line 213
    .end local v1    # "e":Ljava/net/MalformedURLException;
    .restart local v9    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_2
    move-exception v1

    .line 214
    .local v1, "e":Ljava/io/IOException;
    const-string v10, "FATHOM1"

    const-string v11, "Error establishing URL connection"

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 215
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 229
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v2    # "in":Ljava/io/InputStream;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v5    # "reader":Ljava/io/BufferedReader;
    :cond_0
    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 230
    sget-object v10, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_3

    .line 229
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v3    # "line":Ljava/lang/String;
    .end local v5    # "reader":Ljava/io/BufferedReader;
    :catchall_0
    move-exception v10

    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 230
    sget-object v11, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    throw v10
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 195
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 244
    iget-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-virtual {v1}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->goToFirmwareScreen(Landroid/view/View;)V

    .line 250
    return-void
.end method
