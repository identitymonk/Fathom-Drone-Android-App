.class public Lcom/brynk/fathom/controllers/DivelogActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "DivelogActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;,
        Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;,
        Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;
    }
.end annotation


# static fields
.field static final FRUITS:[Ljava/lang/String;


# instance fields
.field private DRONE_IP:Ljava/lang/String;

.field private entries:[Lcom/brynk/fathom/helpers/DivelogEntry;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 38
    const/16 v0, 0xd

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "Apple"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "Avocado"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "Banana"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "Blueberry"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "Coconut"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "Durian"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "Guava"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "Kiwifruit"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "Jackfruit"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "Mango"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "Olive"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "Pear"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "Sugar-apple"

    aput-object v2, v0, v1

    sput-object v0, Lcom/brynk/fathom/controllers/DivelogActivity;->FRUITS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 223
    return-void
.end method

.method static synthetic access$000(Lcom/brynk/fathom/controllers/DivelogActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/DivelogActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/brynk/fathom/controllers/DivelogActivity;->tryToConnect(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/brynk/fathom/controllers/DivelogActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/DivelogActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/brynk/fathom/controllers/DivelogActivity;->DRONE_IP:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/brynk/fathom/controllers/DivelogActivity;I)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/DivelogActivity;
    .param p1, "x1"    # I

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/brynk/fathom/controllers/DivelogActivity;->formatUptime(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private formatUptime(I)Ljava/lang/String;
    .locals 6
    .param p1, "uptime"    # I

    .prologue
    .line 129
    const-string v0, ""

    .line 135
    .local v0, "formmatedUptime":Ljava/lang/String;
    const/16 v4, 0x3c

    if-ge p1, v4, :cond_0

    .line 136
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "m"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 146
    :goto_0
    return-object v0

    .line 139
    :cond_0
    div-int/lit8 v1, p1, 0x3c

    .line 140
    .local v1, "hours":I
    rem-int/lit8 v3, p1, 0x3c

    .line 141
    .local v3, "minutes":I
    const-string v2, "h"

    .line 143
    .local v2, "hrs":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "m"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private tryToConnect(Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p1, "urlToTry"    # Ljava/lang/String;

    .prologue
    .line 94
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 95
    .local v5, "result":Ljava/lang/StringBuilder;
    const/4 v6, 0x0

    .line 97
    .local v6, "url":Ljava/net/URL;
    :try_start_0
    new-instance v7, Ljava/net/URL;

    invoke-direct {v7, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .end local v6    # "url":Ljava/net/URL;
    .local v7, "url":Ljava/net/URL;
    move-object v6, v7

    .line 102
    .end local v7    # "url":Ljava/net/URL;
    .restart local v6    # "url":Ljava/net/URL;
    :goto_0
    const/4 v8, 0x0

    .line 104
    .local v8, "urlConnection":Ljava/net/HttpURLConnection;
    :try_start_1
    invoke-virtual {v6}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v9

    move-object v0, v9

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v8, v0
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 110
    :goto_1
    :try_start_2
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v9

    invoke-direct {v2, v9}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 111
    .local v2, "in":Ljava/io/InputStream;
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v9, Ljava/io/InputStreamReader;

    invoke-direct {v9, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v4, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 114
    .local v4, "reader":Ljava/io/BufferedReader;
    :goto_2
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .local v3, "line":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 115
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 117
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v1

    .line 118
    .local v1, "e":Ljava/io/IOException;
    :try_start_3
    const-string v9, "FATHOM1"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Error reading input from URL:"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 119
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 121
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 125
    .end local v1    # "e":Ljava/io/IOException;
    :goto_3
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    return-object v9

    .line 98
    .end local v8    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_1
    move-exception v1

    .line 100
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_0

    .line 105
    .end local v1    # "e":Ljava/net/MalformedURLException;
    .restart local v8    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_2
    move-exception v1

    .line 106
    .local v1, "e":Ljava/io/IOException;
    const-string v9, "FATHOM1"

    const-string v10, "Error establishing URL connection"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 107
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 121
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


# virtual methods
.method public convertVideos(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 83
    const v2, 0x7f0f009b

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/DivelogActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    .line 84
    .local v1, "rlDiveLogConvertingOverlay":Landroid/widget/RelativeLayout;
    invoke-virtual {v1, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 87
    new-instance v0, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;

    invoke-direct {v0, p0}, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;-><init>(Lcom/brynk/fathom/controllers/DivelogActivity;)V

    .line 88
    .local v0, "cvt":Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "http://"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/brynk/fathom/controllers/DivelogActivity;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/convert/all"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {v0, v2}, Lcom/brynk/fathom/controllers/DivelogActivity$ConvertVideosTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 91
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 44
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 45
    const v4, 0x7f04001b

    invoke-virtual {p0, v4}, Lcom/brynk/fathom/controllers/DivelogActivity;->setContentView(I)V

    .line 46
    const v4, 0x7f0f00d1

    invoke-virtual {p0, v4}, Lcom/brynk/fathom/controllers/DivelogActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/support/v7/widget/Toolbar;

    .line 47
    .local v3, "toolbar":Landroid/support/v7/widget/Toolbar;
    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/DivelogActivity;->setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V

    .line 49
    new-instance v4, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v4}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/DivelogActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/brynk/fathom/controllers/DivelogActivity;->DRONE_IP:Ljava/lang/String;

    .line 59
    new-instance v4, Lcom/brynk/fathom/helpers/WiFiHelper;

    invoke-direct {v4}, Lcom/brynk/fathom/helpers/WiFiHelper;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/DivelogActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/brynk/fathom/helpers/WiFiHelper;->isConnectedToFathomNetwork(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 60
    new-instance v1, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;

    iget-object v4, p0, Lcom/brynk/fathom/controllers/DivelogActivity;->DRONE_IP:Ljava/lang/String;

    invoke-direct {v1, p0, v4}, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;-><init>(Lcom/brynk/fathom/controllers/DivelogActivity;Ljava/lang/String;)V

    .line 61
    .local v1, "droneRecordingTask":Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;
    new-array v4, v6, [Ljava/lang/String;

    const-string v5, ""

    aput-object v5, v4, v7

    invoke-virtual {v1, v4}, Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 63
    new-instance v0, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;

    invoke-direct {v0, p0}, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;-><init>(Lcom/brynk/fathom/controllers/DivelogActivity;)V

    .line 64
    .local v0, "droneInfoTask":Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;
    new-array v4, v6, [Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "http://"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/brynk/fathom/controllers/DivelogActivity;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "/drone/info"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-virtual {v0, v4}, Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 74
    .end local v0    # "droneInfoTask":Lcom/brynk/fathom/controllers/DivelogActivity$DroneInfoTask;
    .end local v1    # "droneRecordingTask":Lcom/brynk/fathom/controllers/DivelogActivity$DiveRecordingTask;
    :goto_0
    return-void

    .line 67
    :cond_0
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/DivelogActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "Connect to Fathom network"

    invoke-static {v4, v5, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 68
    .local v2, "toast":Landroid/widget/Toast;
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method
