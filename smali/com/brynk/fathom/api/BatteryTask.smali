.class public Lcom/brynk/fathom/api/BatteryTask;
.super Landroid/os/AsyncTask;
.source "BatteryTask.java"


# annotations
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

.field private VOLTAGE_MAX:I

.field private VOLTAGE_MIN:I

.field private mContext:Landroid/content/Context;

.field private rootView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "i"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 30
    const/16 v0, 0x63bf

    iput v0, p0, Lcom/brynk/fathom/api/BatteryTask;->VOLTAGE_MAX:I

    .line 32
    const/16 v0, 0x5519

    iput v0, p0, Lcom/brynk/fathom/api/BatteryTask;->VOLTAGE_MIN:I

    .line 36
    iput-object p1, p0, Lcom/brynk/fathom/api/BatteryTask;->mContext:Landroid/content/Context;

    .line 37
    iput-object p2, p0, Lcom/brynk/fathom/api/BatteryTask;->rootView:Landroid/view/View;

    .line 38
    iput-object p3, p0, Lcom/brynk/fathom/api/BatteryTask;->DRONE_IP:Ljava/lang/String;

    .line 39
    return-void
.end method

.method private convertBatteryStatus(I)D
    .locals 3
    .param p1, "rawBatteryStatus"    # I

    .prologue
    .line 50
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 58
    .local v0, "status":D
    const/16 v2, 0x61b8

    if-le p1, v2, :cond_1

    .line 59
    const-wide/high16 v0, 0x4059000000000000L    # 100.0

    .line 73
    :cond_0
    :goto_0
    return-wide v0

    .line 60
    :cond_1
    const/16 v2, 0x5cff

    if-le p1, v2, :cond_2

    .line 61
    const-wide v0, 0x4052c00000000000L    # 75.0

    goto :goto_0

    .line 62
    :cond_2
    const/16 v2, 0x5923

    if-le p1, v2, :cond_3

    .line 63
    const-wide/high16 v0, 0x4049000000000000L    # 50.0

    goto :goto_0

    .line 64
    :cond_3
    const/16 v2, 0x568e

    if-le p1, v2, :cond_4

    .line 65
    const-wide/high16 v0, 0x4039000000000000L    # 25.0

    goto :goto_0

    .line 66
    :cond_4
    const/16 v2, 0x55c9

    if-le p1, v2, :cond_5

    .line 67
    const-wide/high16 v0, 0x4024000000000000L    # 10.0

    goto :goto_0

    .line 68
    :cond_5
    if-lez p1, :cond_0

    .line 69
    const-wide/16 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 26
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/BatteryTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p1, "urls"    # [Ljava/lang/String;

    .prologue
    .line 79
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 80
    .local v5, "result":Ljava/lang/StringBuilder;
    const/4 v6, 0x0

    .line 82
    .local v6, "url":Ljava/net/URL;
    :try_start_0
    new-instance v7, Ljava/net/URL;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "http://"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lcom/brynk/fathom/api/BatteryTask;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "/battery?cutoff=21500"

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

    .line 87
    .end local v7    # "url":Ljava/net/URL;
    .restart local v6    # "url":Ljava/net/URL;
    :goto_0
    const/4 v8, 0x0

    .line 89
    .local v8, "urlConnection":Ljava/net/HttpURLConnection;
    :try_start_1
    invoke-virtual {v6}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v9

    move-object v0, v9

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v8, v0
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 95
    :goto_1
    :try_start_2
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v9

    invoke-direct {v2, v9}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 96
    .local v2, "in":Ljava/io/InputStream;
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v9, Ljava/io/InputStreamReader;

    invoke-direct {v9, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v4, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 99
    .local v4, "reader":Ljava/io/BufferedReader;
    :goto_2
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .local v3, "line":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 100
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 102
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v1

    .line 103
    .local v1, "e":Ljava/io/IOException;
    :try_start_3
    const-string v9, "FATHOM1"

    const-string v10, "Error reading input from URL"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 104
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 107
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 111
    .end local v1    # "e":Ljava/io/IOException;
    :goto_3
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    return-object v9

    .line 83
    .end local v8    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_1
    move-exception v1

    .line 85
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_0

    .line 90
    .end local v1    # "e":Ljava/net/MalformedURLException;
    .restart local v8    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_2
    move-exception v1

    .line 91
    .local v1, "e":Ljava/io/IOException;
    const-string v9, "FATHOM1"

    const-string v10, "Error establishing URL connection"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 92
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 107
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v2    # "in":Ljava/io/InputStream;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    :cond_0
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_3

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
    .line 26
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/BatteryTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 12
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const-wide/16 v10, 0x0

    .line 117
    const/4 v5, -0x1

    .line 118
    .local v5, "raw_battery_status":I
    const v0, 0x7f02004f

    .line 120
    .local v0, "battery_res":I
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    .line 124
    :goto_0
    iget-object v7, p0, Lcom/brynk/fathom/api/BatteryTask;->rootView:Landroid/view/View;

    const v8, 0x7f0f00b0

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 126
    .local v4, "ivBattery":Landroid/widget/ImageView;
    invoke-direct {p0, v5}, Lcom/brynk/fathom/api/BatteryTask;->convertBatteryStatus(I)D

    move-result-wide v2

    .line 127
    .local v2, "battery_status":D
    const-string v7, "FATHOM1"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "BATTERY_STATUS: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 129
    const-wide v8, 0x4052800000000000L    # 74.0

    cmpl-double v7, v2, v8

    if-lez v7, :cond_1

    .line 130
    const v0, 0x7f020050

    .line 154
    :cond_0
    :goto_1
    invoke-virtual {v4, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 155
    return-void

    .line 121
    .end local v2    # "battery_status":D
    .end local v4    # "ivBattery":Landroid/widget/ImageView;
    :catch_0
    move-exception v1

    .line 122
    .local v1, "e":Ljava/lang/NumberFormatException;
    const-string v7, "FATHOM1"

    const-string v8, "Unable to read battery status as a number"

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 131
    .end local v1    # "e":Ljava/lang/NumberFormatException;
    .restart local v2    # "battery_status":D
    .restart local v4    # "ivBattery":Landroid/widget/ImageView;
    :cond_1
    const-wide v8, 0x4048800000000000L    # 49.0

    cmpl-double v7, v2, v8

    if-lez v7, :cond_2

    .line 132
    const v0, 0x7f02004e

    goto :goto_1

    .line 134
    :cond_2
    const-wide/high16 v8, 0x4038000000000000L    # 24.0

    cmpl-double v7, v2, v8

    if-lez v7, :cond_3

    .line 135
    const v0, 0x7f02004d

    goto :goto_1

    .line 137
    :cond_3
    const-wide/high16 v8, 0x4022000000000000L    # 9.0

    cmpl-double v7, v2, v8

    if-lez v7, :cond_4

    .line 138
    const v0, 0x7f02004c

    goto :goto_1

    .line 139
    :cond_4
    cmpl-double v7, v2, v10

    if-ltz v7, :cond_5

    .line 140
    const v0, 0x7f02004f

    .line 142
    iget-object v7, p0, Lcom/brynk/fathom/api/BatteryTask;->rootView:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v7

    const-string v8, "Low battery. The unit will shutdown soon."

    const/4 v9, 0x1

    invoke-static {v7, v8, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v6

    .line 143
    .local v6, "toast":Landroid/widget/Toast;
    invoke-virtual {v6}, Landroid/widget/Toast;->show()V

    goto :goto_1

    .line 146
    .end local v6    # "toast":Landroid/widget/Toast;
    :cond_5
    cmpg-double v7, v2, v10

    if-gez v7, :cond_0

    .line 147
    const v0, 0x7f020051

    goto :goto_1
.end method
