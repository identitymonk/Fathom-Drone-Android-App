.class public Lcom/brynk/fathom/api/ThrusterTask;
.super Landroid/os/AsyncTask;
.source "ThrusterTask.java"


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

.field private thruster_socket:Ljava/net/DatagramSocket;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 18
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 20
    iput-object v0, p0, Lcom/brynk/fathom/api/ThrusterTask;->messageStr:Ljava/lang/String;

    .line 21
    iput-object v0, p0, Lcom/brynk/fathom/api/ThrusterTask;->DRONE_IP:Ljava/lang/String;

    .line 22
    iput-object v0, p0, Lcom/brynk/fathom/api/ThrusterTask;->thruster_socket:Ljava/net/DatagramSocket;

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 18
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/ThrusterTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "coords"    # [Ljava/lang/String;

    .prologue
    .line 55
    const/4 v6, 0x0

    aget-object v6, p1, v6

    iput-object v6, p0, Lcom/brynk/fathom/api/ThrusterTask;->messageStr:Ljava/lang/String;

    .line 57
    const/16 v5, 0x1f42

    .line 60
    .local v5, "server_port":I
    const/4 v1, 0x0

    .line 62
    .local v1, "local":Ljava/net/InetAddress;
    :try_start_0
    iget-object v6, p0, Lcom/brynk/fathom/api/ThrusterTask;->DRONE_IP:Ljava/lang/String;

    invoke-static {v6}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 66
    :goto_0
    iget-object v6, p0, Lcom/brynk/fathom/api/ThrusterTask;->messageStr:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v3

    .line 67
    .local v3, "msg_length":I
    iget-object v6, p0, Lcom/brynk/fathom/api/ThrusterTask;->messageStr:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    .line 68
    .local v2, "message":[B
    new-instance v4, Ljava/net/DatagramPacket;

    invoke-direct {v4, v2, v3, v1, v5}, Ljava/net/DatagramPacket;-><init>([BILjava/net/InetAddress;I)V

    .line 70
    .local v4, "p":Ljava/net/DatagramPacket;
    :try_start_1
    iget-object v6, p0, Lcom/brynk/fathom/api/ThrusterTask;->thruster_socket:Ljava/net/DatagramSocket;

    invoke-virtual {v6, v4}, Ljava/net/DatagramSocket;->send(Ljava/net/DatagramPacket;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 74
    :goto_1
    const-string v6, "TODO"

    return-object v6

    .line 63
    .end local v2    # "message":[B
    .end local v3    # "msg_length":I
    .end local v4    # "p":Ljava/net/DatagramPacket;
    :catch_0
    move-exception v0

    .line 64
    .local v0, "e":Ljava/net/UnknownHostException;
    invoke-virtual {v0}, Ljava/net/UnknownHostException;->printStackTrace()V

    goto :goto_0

    .line 71
    .end local v0    # "e":Ljava/net/UnknownHostException;
    .restart local v2    # "message":[B
    .restart local v3    # "msg_length":I
    .restart local v4    # "p":Ljava/net/DatagramPacket;
    :catch_1
    move-exception v0

    .line 72
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method

.method public getDRONE_IP()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/brynk/fathom/api/ThrusterTask;->DRONE_IP:Ljava/lang/String;

    return-object v0
.end method

.method public getMessageStr()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/brynk/fathom/api/ThrusterTask;->messageStr:Ljava/lang/String;

    return-object v0
.end method

.method public getThruster_socket()Ljava/net/DatagramSocket;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/brynk/fathom/api/ThrusterTask;->thruster_socket:Ljava/net/DatagramSocket;

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 18
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/ThrusterTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 0
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 80
    return-void
.end method

.method public setDRONE_IP(Ljava/lang/String;)V
    .locals 0
    .param p1, "DRONE_IP"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/brynk/fathom/api/ThrusterTask;->DRONE_IP:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setMessageStr(Ljava/lang/String;)V
    .locals 0
    .param p1, "messageStr"    # Ljava/lang/String;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/brynk/fathom/api/ThrusterTask;->messageStr:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public setThruster_socket(Ljava/net/DatagramSocket;)V
    .locals 0
    .param p1, "thruster_socket"    # Ljava/net/DatagramSocket;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/brynk/fathom/api/ThrusterTask;->thruster_socket:Ljava/net/DatagramSocket;

    .line 31
    return-void
.end method
