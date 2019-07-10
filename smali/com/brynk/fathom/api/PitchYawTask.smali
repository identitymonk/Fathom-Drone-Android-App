.class public Lcom/brynk/fathom/api/PitchYawTask;
.super Landroid/os/AsyncTask;
.source "PitchYawTask.java"


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

.field private messageStr:Ljava/lang/String;

.field private roll_socket:Ljava/net/DatagramSocket;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 15
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 16
    iput-object v0, p0, Lcom/brynk/fathom/api/PitchYawTask;->messageStr:Ljava/lang/String;

    .line 17
    iput-object v0, p0, Lcom/brynk/fathom/api/PitchYawTask;->DRONE_IP:Ljava/lang/String;

    .line 18
    iput-object v0, p0, Lcom/brynk/fathom/api/PitchYawTask;->roll_socket:Ljava/net/DatagramSocket;

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 15
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/PitchYawTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 51
    const/4 v6, 0x0

    aget-object v6, p1, v6

    iput-object v6, p0, Lcom/brynk/fathom/api/PitchYawTask;->messageStr:Ljava/lang/String;

    .line 52
    const/16 v5, 0x1f41

    .line 55
    .local v5, "server_port":I
    const/4 v1, 0x0

    .line 57
    .local v1, "local":Ljava/net/InetAddress;
    :try_start_0
    iget-object v6, p0, Lcom/brynk/fathom/api/PitchYawTask;->DRONE_IP:Ljava/lang/String;

    invoke-static {v6}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 61
    :goto_0
    iget-object v6, p0, Lcom/brynk/fathom/api/PitchYawTask;->messageStr:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v3

    .line 62
    .local v3, "msg_length":I
    iget-object v6, p0, Lcom/brynk/fathom/api/PitchYawTask;->messageStr:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    .line 63
    .local v2, "message":[B
    new-instance v4, Ljava/net/DatagramPacket;

    invoke-direct {v4, v2, v3, v1, v5}, Ljava/net/DatagramPacket;-><init>([BILjava/net/InetAddress;I)V

    .line 65
    .local v4, "p":Ljava/net/DatagramPacket;
    :try_start_1
    iget-object v6, p0, Lcom/brynk/fathom/api/PitchYawTask;->roll_socket:Ljava/net/DatagramSocket;

    invoke-virtual {v6, v4}, Ljava/net/DatagramSocket;->send(Ljava/net/DatagramPacket;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 69
    :goto_1
    const-string v6, "TODO"

    return-object v6

    .line 58
    .end local v2    # "message":[B
    .end local v3    # "msg_length":I
    .end local v4    # "p":Ljava/net/DatagramPacket;
    :catch_0
    move-exception v0

    .line 59
    .local v0, "e":Ljava/net/UnknownHostException;
    invoke-virtual {v0}, Ljava/net/UnknownHostException;->printStackTrace()V

    goto :goto_0

    .line 66
    .end local v0    # "e":Ljava/net/UnknownHostException;
    .restart local v2    # "message":[B
    .restart local v3    # "msg_length":I
    .restart local v4    # "p":Ljava/net/DatagramPacket;
    :catch_1
    move-exception v0

    .line 67
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method

.method public getDRONE_IP()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/brynk/fathom/api/PitchYawTask;->DRONE_IP:Ljava/lang/String;

    return-object v0
.end method

.method public getMessageStr()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/brynk/fathom/api/PitchYawTask;->messageStr:Ljava/lang/String;

    return-object v0
.end method

.method public getRoll_socket()Ljava/net/DatagramSocket;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/brynk/fathom/api/PitchYawTask;->roll_socket:Ljava/net/DatagramSocket;

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 15
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/PitchYawTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 0
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 75
    return-void
.end method

.method public setDRONE_IP(Ljava/lang/String;)V
    .locals 0
    .param p1, "DRONE_IP"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/brynk/fathom/api/PitchYawTask;->DRONE_IP:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setMessageStr(Ljava/lang/String;)V
    .locals 0
    .param p1, "messageStr"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/brynk/fathom/api/PitchYawTask;->messageStr:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setRoll_socket(Ljava/net/DatagramSocket;)V
    .locals 0
    .param p1, "roll_socket"    # Ljava/net/DatagramSocket;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/brynk/fathom/api/PitchYawTask;->roll_socket:Ljava/net/DatagramSocket;

    .line 45
    return-void
.end method
