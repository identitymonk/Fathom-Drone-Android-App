.class public Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;
.super Landroid/os/AsyncTask;
.source "FirmwareActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/FirmwareActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "UpdateStatusTask"
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

.field private MESSAGE_NOT_UPDATED:Ljava/lang/String;

.field private MESSAGE_UPDATED:Ljava/lang/String;

.field private MESSAGE_UPDATING:Ljava/lang/String;

.field private MESSAGE_WRONG_WIFI:Ljava/lang/String;

.field private isUpdated:Ljava/lang/Boolean;

.field private statusMessageForUser:Ljava/lang/String;

.field final synthetic this$0:Lcom/brynk/fathom/controllers/FirmwareActivity;


# direct methods
.method public constructor <init>(Lcom/brynk/fathom/controllers/FirmwareActivity;Ljava/lang/String;)V
    .locals 1
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/FirmwareActivity;
    .param p2, "i"    # Ljava/lang/String;

    .prologue
    .line 114
    iput-object p1, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->this$0:Lcom/brynk/fathom/controllers/FirmwareActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 105
    const-string v0, ""

    iput-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->statusMessageForUser:Ljava/lang/String;

    .line 106
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->isUpdated:Ljava/lang/Boolean;

    .line 107
    const-string v0, "Fathom One is updated"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->MESSAGE_UPDATED:Ljava/lang/String;

    .line 108
    const-string v0, "Fathom One is updating"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->MESSAGE_UPDATING:Ljava/lang/String;

    .line 109
    const-string v0, "Fathom One failed to update"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->MESSAGE_NOT_UPDATED:Ljava/lang/String;

    .line 110
    const-string v0, "Please connect to the Fathom wifi network"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->MESSAGE_WRONG_WIFI:Ljava/lang/String;

    .line 111
    const v0, -0xff0100

    iput v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->COLOR_CONNECTED:I

    .line 112
    const/high16 v0, -0x10000

    iput v0, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->COLOR_NOT_CONNECTED:I

    .line 115
    iput-object p2, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->DRONE_IP:Ljava/lang/String;

    .line 116
    return-void
.end method

.method private reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "status"    # Ljava/lang/Boolean;

    .prologue
    .line 174
    iput-object p2, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->isUpdated:Ljava/lang/Boolean;

    .line 175
    iput-object p1, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->statusMessageForUser:Ljava/lang/String;

    .line 177
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 103
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p1, "urls"    # [Ljava/lang/String;

    .prologue
    const/4 v11, 0x0

    .line 123
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

    iget-object v10, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "/system/status"

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
    :goto_0
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
    :goto_1
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
    :goto_2
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .local v3, "line":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 148
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 161
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v1

    .line 162
    .local v1, "e":Ljava/io/IOException;
    :try_start_3
    const-string v9, "FATHOM1"

    const-string v10, "Error reading input from URL"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 163
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    .line 164
    iget-object v9, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->MESSAGE_NOT_UPDATED:Ljava/lang/String;

    const/4 v10, 0x0

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 166
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 170
    .end local v1    # "e":Ljava/io/IOException;
    :goto_3
    iget-object v9, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->statusMessageForUser:Ljava/lang/String;

    return-object v9

    .line 127
    .end local v8    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_1
    move-exception v1

    .line 129
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    .line 130
    iget-object v9, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->MESSAGE_NOT_UPDATED:Ljava/lang/String;

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V

    goto :goto_0

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
    iget-object v9, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->MESSAGE_NOT_UPDATED:Ljava/lang/String;

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V

    goto :goto_1

    .line 151
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v2    # "in":Ljava/io/InputStream;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    :cond_0
    :try_start_4
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const-string v10, "UPDATING"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 153
    iget-object v9, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->MESSAGE_UPDATING:Ljava/lang/String;

    const/4 v10, 0x0

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 154
    const-string v9, "FATHOM1"

    const-string v10, "Still updating..."

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 166
    :goto_4
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_3

    .line 158
    :cond_1
    :try_start_5
    iget-object v9, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->MESSAGE_UPDATED:Ljava/lang/String;

    const/4 v10, 0x1

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    invoke-direct {p0, v9, v10}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->reportStatus(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 159
    const-string v9, "FATHOM1"

    const-string v10, "Updated..."

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_4

    .line 166
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
    .line 103
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 181
    iget-object v1, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->this$0:Lcom/brynk/fathom/controllers/FirmwareActivity;

    const v2, 0x7f0f009e

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/controllers/FirmwareActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 184
    .local v0, "tvUpdateStatus":Landroid/widget/TextView;
    iget-object v1, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->statusMessageForUser:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 185
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 188
    return-void
.end method
