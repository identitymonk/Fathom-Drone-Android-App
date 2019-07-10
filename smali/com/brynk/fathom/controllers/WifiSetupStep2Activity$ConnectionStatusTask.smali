.class public Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;
.super Landroid/os/AsyncTask;
.source "WifiSetupStep2Activity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ConnectionStatusTask"
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
.field private COLOR_CONNECTED:I

.field private COLOR_NOT_CONNECTED:I

.field private DRONE_IP:Ljava/lang/String;

.field private MESSAGE_CONNECTED:Ljava/lang/String;

.field private MESSAGE_NOT_CONNECTED:Ljava/lang/String;

.field private MESSAGE_WRONG_WIFI:Ljava/lang/String;

.field private statusMessageForUser:Ljava/lang/String;

.field final synthetic this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;


# direct methods
.method public constructor <init>(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;Ljava/lang/String;)V
    .locals 1
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;
    .param p2, "i"    # Ljava/lang/String;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->statusMessageForUser:Ljava/lang/String;

    .line 100
    const-string v0, "Fathom One is connected"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->MESSAGE_CONNECTED:Ljava/lang/String;

    .line 101
    const-string v0, "Fathom One is offline"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->MESSAGE_NOT_CONNECTED:Ljava/lang/String;

    .line 102
    const-string v0, "Please connect to the Fathom wifi network"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->MESSAGE_WRONG_WIFI:Ljava/lang/String;

    .line 103
    const v0, -0xff0100

    iput v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->COLOR_CONNECTED:I

    .line 104
    const/high16 v0, -0x10000

    iput v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->COLOR_NOT_CONNECTED:I

    .line 107
    iput-object p2, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->DRONE_IP:Ljava/lang/String;

    .line 108
    return-void
.end method

.method private reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "status"    # Ljava/lang/Boolean;

    .prologue
    .line 164
    iget-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    invoke-static {v0, p2}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->access$202(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 165
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->statusMessageForUser:Ljava/lang/String;

    .line 167
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 97
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p1, "urls"    # [Ljava/lang/String;

    .prologue
    const/4 v11, 0x0

    .line 114
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    invoke-static {v9}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->access$000(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;)V

    .line 115
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    invoke-static {v9}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->access$100(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;)Ljava/lang/Boolean;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    if-nez v9, :cond_0

    .line 116
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->MESSAGE_WRONG_WIFI:Ljava/lang/String;

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 117
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->statusMessageForUser:Ljava/lang/String;

    .line 160
    :goto_0
    return-object v9

    .line 123
    :cond_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 124
    .local v5, "result":Ljava/lang/StringBuilder;
    const/4 v6, 0x0

    .line 126
    .local v6, "url":Ljava/net/URL;
    :try_start_0
    new-instance v7, Ljava/net/URL;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "http://"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "/"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v7, v9}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .end local v6    # "url":Ljava/net/URL;
    .local v7, "url":Ljava/net/URL;
    move-object v6, v7

    .line 132
    .end local v7    # "url":Ljava/net/URL;
    .restart local v6    # "url":Ljava/net/URL;
    :goto_1
    const/4 v8, 0x0

    .line 134
    .local v8, "urlConnection":Ljava/net/HttpURLConnection;
    :try_start_1
    invoke-virtual {v6}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v9

    move-object v0, v9

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v8, v0

    .line 135
    const/16 v9, 0xbb8

    invoke-virtual {v8, v9}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 143
    :goto_2
    :try_start_2
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v9

    invoke-direct {v2, v9}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 144
    .local v2, "in":Ljava/io/InputStream;
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v9, Ljava/io/InputStreamReader;

    invoke-direct {v9, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v4, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 147
    .local v4, "reader":Ljava/io/BufferedReader;
    :goto_3
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .local v3, "line":Ljava/lang/String;
    if-eqz v3, :cond_1

    .line 148
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_3

    .line 151
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v1

    .line 152
    .local v1, "e":Ljava/io/IOException;
    :try_start_3
    const-string v9, "FATHOM1"

    const-string v10, "Error reading input from URL"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 153
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    .line 154
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->MESSAGE_NOT_CONNECTED:Ljava/lang/String;

    const/4 v10, 0x0

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 156
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 160
    .end local v1    # "e":Ljava/io/IOException;
    :goto_4
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->statusMessageForUser:Ljava/lang/String;

    goto :goto_0

    .line 127
    .end local v8    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_1
    move-exception v1

    .line 129
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    .line 130
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->MESSAGE_NOT_CONNECTED:Ljava/lang/String;

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V

    goto :goto_1

    .line 136
    .end local v1    # "e":Ljava/net/MalformedURLException;
    .restart local v8    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_2
    move-exception v1

    .line 137
    .local v1, "e":Ljava/io/IOException;
    const-string v9, "FATHOM1"

    const-string v10, "Error establishing URL connection"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 138
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    .line 139
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->MESSAGE_NOT_CONNECTED:Ljava/lang/String;

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V

    goto :goto_2

    .line 150
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v2    # "in":Ljava/io/InputStream;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    :cond_1
    :try_start_4
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->MESSAGE_CONNECTED:Ljava/lang/String;

    const/4 v10, 0x1

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 156
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_4

    .end local v2    # "in":Ljava/io/InputStream;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    :catchall_0
    move-exception v9

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v9
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 97
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 172
    iget-object v2, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    invoke-static {v2}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->access$200(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 174
    iget-object v2, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    const v3, 0x7f0f00d4

    invoke-virtual {v2, v3}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 175
    .local v1, "tvConnected":Landroid/widget/TextView;
    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 178
    iget-object v2, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    const v3, 0x7f0f00d5

    invoke-virtual {v2, v3}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 179
    .local v0, "btnNext":Landroid/widget/Button;
    invoke-virtual {v0, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 183
    .end local v0    # "btnNext":Landroid/widget/Button;
    .end local v1    # "tvConnected":Landroid/widget/TextView;
    :cond_0
    return-void
.end method
