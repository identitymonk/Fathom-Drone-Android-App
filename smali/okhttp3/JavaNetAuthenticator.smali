.class public final Lokhttp3/JavaNetAuthenticator;
.super Ljava/lang/Object;
.source "JavaNetAuthenticator.java"

# interfaces
.implements Lokhttp3/Authenticator;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getConnectToInetAddress(Ljava/net/Proxy;Lokhttp3/HttpUrl;)Ljava/net/InetAddress;
    .locals 2
    .param p1, "proxy"    # Ljava/net/Proxy;
    .param p2, "url"    # Lokhttp3/HttpUrl;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 68
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v0

    sget-object v1, Ljava/net/Proxy$Type;->DIRECT:Ljava/net/Proxy$Type;

    if-eq v0, v1, :cond_0

    .line 69
    invoke-virtual {p1}, Ljava/net/Proxy;->address()Ljava/net/SocketAddress;

    move-result-object v0

    check-cast v0, Ljava/net/InetSocketAddress;

    invoke-virtual {v0}, Ljava/net/InetSocketAddress;->getAddress()Ljava/net/InetAddress;

    move-result-object v0

    .line 68
    :goto_0
    return-object v0

    .line 70
    :cond_0
    invoke-virtual {p2}, Lokhttp3/HttpUrl;->host()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public authenticate(Lokhttp3/Route;Lokhttp3/Response;)Lokhttp3/Request;
    .locals 21
    .param p1, "route"    # Lokhttp3/Route;
    .param p2, "response"    # Lokhttp3/Response;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 33
    invoke-virtual/range {p2 .. p2}, Lokhttp3/Response;->challenges()Ljava/util/List;

    move-result-object v12

    .line 34
    .local v12, "challenges":Ljava/util/List;, "Ljava/util/List<Lokhttp3/Challenge;>;"
    invoke-virtual/range {p2 .. p2}, Lokhttp3/Response;->request()Lokhttp3/Request;

    move-result-object v18

    .line 35
    .local v18, "request":Lokhttp3/Request;
    invoke-virtual/range {v18 .. v18}, Lokhttp3/Request;->url()Lokhttp3/HttpUrl;

    move-result-object v20

    .line 36
    .local v20, "url":Lokhttp3/HttpUrl;
    invoke-virtual/range {p2 .. p2}, Lokhttp3/Response;->code()I

    move-result v2

    const/16 v3, 0x197

    if-ne v2, v3, :cond_1

    const/16 v17, 0x1

    .line 37
    .local v17, "proxyAuthorization":Z
    :goto_0
    invoke-virtual/range {p1 .. p1}, Lokhttp3/Route;->proxy()Ljava/net/Proxy;

    move-result-object v15

    .line 39
    .local v15, "proxy":Ljava/net/Proxy;
    const/4 v14, 0x0

    .local v14, "i":I
    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v19

    .local v19, "size":I
    :goto_1
    move/from16 v0, v19

    if-ge v14, v0, :cond_5

    .line 40
    invoke-interface {v12, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lokhttp3/Challenge;

    .line 41
    .local v11, "challenge":Lokhttp3/Challenge;
    const-string v2, "Basic"

    invoke-virtual {v11}, Lokhttp3/Challenge;->scheme()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 39
    :cond_0
    add-int/lit8 v14, v14, 0x1

    goto :goto_1

    .line 36
    .end local v11    # "challenge":Lokhttp3/Challenge;
    .end local v14    # "i":I
    .end local v15    # "proxy":Ljava/net/Proxy;
    .end local v17    # "proxyAuthorization":Z
    .end local v19    # "size":I
    :cond_1
    const/16 v17, 0x0

    goto :goto_0

    .line 44
    .restart local v11    # "challenge":Lokhttp3/Challenge;
    .restart local v14    # "i":I
    .restart local v15    # "proxy":Ljava/net/Proxy;
    .restart local v17    # "proxyAuthorization":Z
    .restart local v19    # "size":I
    :cond_2
    if-eqz v17, :cond_3

    .line 45
    invoke-virtual {v15}, Ljava/net/Proxy;->address()Ljava/net/SocketAddress;

    move-result-object v16

    check-cast v16, Ljava/net/InetSocketAddress;

    .line 47
    .local v16, "proxyAddress":Ljava/net/InetSocketAddress;
    invoke-virtual/range {v16 .. v16}, Ljava/net/InetSocketAddress;->getHostName()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v15, v1}, Lokhttp3/JavaNetAuthenticator;->getConnectToInetAddress(Ljava/net/Proxy;Lokhttp3/HttpUrl;)Ljava/net/InetAddress;

    move-result-object v3

    invoke-virtual/range {v16 .. v16}, Ljava/net/InetSocketAddress;->getPort()I

    move-result v4

    .line 48
    invoke-virtual/range {v20 .. v20}, Lokhttp3/HttpUrl;->scheme()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v11}, Lokhttp3/Challenge;->realm()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v11}, Lokhttp3/Challenge;->scheme()Ljava/lang/String;

    move-result-object v7

    invoke-virtual/range {v20 .. v20}, Lokhttp3/HttpUrl;->url()Ljava/net/URL;

    move-result-object v8

    sget-object v9, Ljava/net/Authenticator$RequestorType;->PROXY:Ljava/net/Authenticator$RequestorType;

    .line 46
    invoke-static/range {v2 .. v9}, Ljava/net/Authenticator;->requestPasswordAuthentication(Ljava/lang/String;Ljava/net/InetAddress;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/net/Authenticator$RequestorType;)Ljava/net/PasswordAuthentication;

    move-result-object v10

    .line 56
    .end local v16    # "proxyAddress":Ljava/net/InetSocketAddress;
    .local v10, "auth":Ljava/net/PasswordAuthentication;
    :goto_2
    if-eqz v10, :cond_0

    .line 57
    invoke-virtual {v10}, Ljava/net/PasswordAuthentication;->getUserName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/String;

    invoke-virtual {v10}, Ljava/net/PasswordAuthentication;->getPassword()[C

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/String;-><init>([C)V

    invoke-static {v2, v3}, Lokhttp3/Credentials;->basic(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 58
    .local v13, "credential":Ljava/lang/String;
    invoke-virtual/range {v18 .. v18}, Lokhttp3/Request;->newBuilder()Lokhttp3/Request$Builder;

    move-result-object v3

    if-eqz v17, :cond_4

    const-string v2, "Proxy-Authorization"

    .line 59
    :goto_3
    invoke-virtual {v3, v2, v13}, Lokhttp3/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    move-result-object v2

    .line 60
    invoke-virtual {v2}, Lokhttp3/Request$Builder;->build()Lokhttp3/Request;

    move-result-object v2

    .line 64
    .end local v10    # "auth":Ljava/net/PasswordAuthentication;
    .end local v11    # "challenge":Lokhttp3/Challenge;
    .end local v13    # "credential":Ljava/lang/String;
    :goto_4
    return-object v2

    .line 52
    .restart local v11    # "challenge":Lokhttp3/Challenge;
    :cond_3
    invoke-virtual/range {v20 .. v20}, Lokhttp3/HttpUrl;->host()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v15, v1}, Lokhttp3/JavaNetAuthenticator;->getConnectToInetAddress(Ljava/net/Proxy;Lokhttp3/HttpUrl;)Ljava/net/InetAddress;

    move-result-object v3

    invoke-virtual/range {v20 .. v20}, Lokhttp3/HttpUrl;->port()I

    move-result v4

    invoke-virtual/range {v20 .. v20}, Lokhttp3/HttpUrl;->scheme()Ljava/lang/String;

    move-result-object v5

    .line 53
    invoke-virtual {v11}, Lokhttp3/Challenge;->realm()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v11}, Lokhttp3/Challenge;->scheme()Ljava/lang/String;

    move-result-object v7

    invoke-virtual/range {v20 .. v20}, Lokhttp3/HttpUrl;->url()Ljava/net/URL;

    move-result-object v8

    sget-object v9, Ljava/net/Authenticator$RequestorType;->SERVER:Ljava/net/Authenticator$RequestorType;

    .line 51
    invoke-static/range {v2 .. v9}, Ljava/net/Authenticator;->requestPasswordAuthentication(Ljava/lang/String;Ljava/net/InetAddress;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/net/Authenticator$RequestorType;)Ljava/net/PasswordAuthentication;

    move-result-object v10

    .restart local v10    # "auth":Ljava/net/PasswordAuthentication;
    goto :goto_2

    .line 58
    .restart local v13    # "credential":Ljava/lang/String;
    :cond_4
    const-string v2, "Authorization"

    goto :goto_3

    .line 64
    .end local v10    # "auth":Ljava/net/PasswordAuthentication;
    .end local v11    # "challenge":Lokhttp3/Challenge;
    .end local v13    # "credential":Ljava/lang/String;
    :cond_5
    const/4 v2, 0x0

    goto :goto_4
.end method
