.class Lcom/facebook/react/devsupport/DevSupportManagerImpl$JscProfileTask;
.super Landroid/os/AsyncTask;
.source "DevSupportManagerImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/devsupport/DevSupportManagerImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "JscProfileTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# static fields
.field private static final JSON:Lokhttp3/MediaType;


# instance fields
.field private final mSourceUrl:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 143
    const-string v0, "application/json; charset=utf-8"

    .line 144
    invoke-static {v0}, Lokhttp3/MediaType;->parse(Ljava/lang/String;)Lokhttp3/MediaType;

    move-result-object v0

    sput-object v0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$JscProfileTask;->JSON:Lokhttp3/MediaType;

    .line 143
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "sourceUrl"    # Ljava/lang/String;

    .prologue
    .line 148
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 149
    iput-object p1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$JscProfileTask;->mSourceUrl:Ljava/lang/String;

    .line 150
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Lcom/facebook/react/devsupport/DevSupportManagerImpl$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Lcom/facebook/react/devsupport/DevSupportManagerImpl$1;

    .prologue
    .line 142
    invoke-direct {p0, p1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl$JscProfileTask;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 142
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl$JscProfileTask;->doInBackground([Ljava/lang/String;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/Void;
    .locals 10
    .param p1, "jsonData"    # [Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    .line 155
    :try_start_0
    iget-object v6, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$JscProfileTask;->mSourceUrl:Ljava/lang/String;

    .line 156
    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v6}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v6

    const-string v7, "/jsc-profile"

    .line 157
    invoke-virtual {v6, v7}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v6

    const/4 v7, 0x0

    .line 158
    invoke-virtual {v6, v7}, Landroid/net/Uri$Builder;->query(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v6

    .line 159
    invoke-virtual {v6}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v6

    .line 160
    invoke-virtual {v6}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    .line 161
    .local v3, "jscProfileUrl":Ljava/lang/String;
    new-instance v1, Lokhttp3/OkHttpClient;

    invoke-direct {v1}, Lokhttp3/OkHttpClient;-><init>()V

    .line 162
    .local v1, "client":Lokhttp3/OkHttpClient;
    array-length v7, p1

    const/4 v6, 0x0

    :goto_0
    if-ge v6, v7, :cond_0

    aget-object v4, p1, v6

    .line 163
    .local v4, "json":Ljava/lang/String;
    sget-object v8, Lcom/facebook/react/devsupport/DevSupportManagerImpl$JscProfileTask;->JSON:Lokhttp3/MediaType;

    invoke-static {v8, v4}, Lokhttp3/RequestBody;->create(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;

    move-result-object v0

    .line 164
    .local v0, "body":Lokhttp3/RequestBody;
    new-instance v8, Lokhttp3/Request$Builder;

    invoke-direct {v8}, Lokhttp3/Request$Builder;-><init>()V

    .line 165
    invoke-virtual {v8, v3}, Lokhttp3/Request$Builder;->url(Ljava/lang/String;)Lokhttp3/Request$Builder;

    move-result-object v8

    invoke-virtual {v8, v0}, Lokhttp3/Request$Builder;->post(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;

    move-result-object v8

    invoke-virtual {v8}, Lokhttp3/Request$Builder;->build()Lokhttp3/Request;

    move-result-object v5

    .line 166
    .local v5, "request":Lokhttp3/Request;
    invoke-virtual {v1, v5}, Lokhttp3/OkHttpClient;->newCall(Lokhttp3/Request;)Lokhttp3/Call;

    move-result-object v8

    invoke-interface {v8}, Lokhttp3/Call;->execute()Lokhttp3/Response;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 162
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 168
    .end local v0    # "body":Lokhttp3/RequestBody;
    .end local v1    # "client":Lokhttp3/OkHttpClient;
    .end local v3    # "jscProfileUrl":Ljava/lang/String;
    .end local v4    # "json":Ljava/lang/String;
    .end local v5    # "request":Lokhttp3/Request;
    :catch_0
    move-exception v2

    .line 169
    .local v2, "e":Ljava/io/IOException;
    const-string v6, "ReactNative"

    const-string v7, "Failed not talk to server"

    invoke-static {v6, v7, v2}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 171
    .end local v2    # "e":Ljava/io/IOException;
    :cond_0
    return-object v9
.end method
