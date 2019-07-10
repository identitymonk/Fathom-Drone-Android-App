.class Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;
.super Landroid/os/AsyncTask;
.source "WifiSetupStep3Activity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "NetworkTask"
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
    .line 77
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
    .param p2, "x1"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$1;

    .prologue
    .line 77
    invoke-direct {p0, p1}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;-><init>(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 77
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 83
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 84
    .local v5, "result":Ljava/lang/StringBuilder;
    const/4 v6, 0x0

    .line 86
    .local v6, "url":Ljava/net/URL;
    :try_start_0
    new-instance v7, Ljava/net/URL;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "http://"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-static {v10}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->access$200(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "/network/available"

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

    .line 91
    .end local v7    # "url":Ljava/net/URL;
    .restart local v6    # "url":Ljava/net/URL;
    :goto_0
    const/4 v8, 0x0

    .line 93
    .local v8, "urlConnection":Ljava/net/HttpURLConnection;
    :try_start_1
    invoke-virtual {v6}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v9

    move-object v0, v9

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v8, v0
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 99
    :goto_1
    :try_start_2
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v9

    invoke-direct {v2, v9}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 100
    .local v2, "in":Ljava/io/InputStream;
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v9, Ljava/io/InputStreamReader;

    invoke-direct {v9, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v4, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 103
    .local v4, "reader":Ljava/io/BufferedReader;
    :goto_2
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .local v3, "line":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 104
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 106
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v1

    .line 107
    .local v1, "e":Ljava/io/IOException;
    :try_start_3
    const-string v9, "FATHOM1"

    const-string v10, "Error reading input from URL"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 108
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 110
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 111
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 115
    .end local v1    # "e":Ljava/io/IOException;
    :goto_3
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->access$302(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;Ljava/lang/String;)Ljava/lang/String;

    .line 116
    const-string v9, "TODO"

    return-object v9

    .line 87
    .end local v8    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_1
    move-exception v1

    .line 89
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_0

    .line 94
    .end local v1    # "e":Ljava/net/MalformedURLException;
    .restart local v8    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_2
    move-exception v1

    .line 95
    .local v1, "e":Ljava/io/IOException;
    const-string v9, "FATHOM1"

    const-string v10, "Error establishing URL connection"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 96
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 110
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v2    # "in":Ljava/io/InputStream;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    :cond_0
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 111
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_3

    .line 110
    .end local v2    # "in":Ljava/io/InputStream;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    :catchall_0
    move-exception v9

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 111
    sget-object v10, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    throw v9
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 77
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 13
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 124
    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    const v10, 0x7f0f0099

    invoke-virtual {v9, v10}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ListView;

    .line 125
    .local v4, "listView":Landroid/widget/ListView;
    const/4 v6, 0x0

    .line 126
    .local v6, "networks_jsonArray":Lorg/json/JSONArray;
    const/4 v9, 0x0

    new-array v5, v9, [Ljava/lang/String;

    .line 128
    .local v5, "networks":[Ljava/lang/String;
    :try_start_0
    new-instance v7, Lorg/json/JSONArray;

    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-static {v9}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->access$300(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v7, v9}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 137
    .end local v6    # "networks_jsonArray":Lorg/json/JSONArray;
    .local v7, "networks_jsonArray":Lorg/json/JSONArray;
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v9

    new-array v5, v9, [Ljava/lang/String;

    .line 138
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v9

    if-ge v2, v9, :cond_0

    .line 140
    :try_start_1
    invoke-virtual {v7, v2}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 141
    .local v8, "wifi_network":Ljava/lang/String;
    const-string v9, "\""

    const-string v10, ""

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    const-string v10, "\n"

    const-string v11, ""

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v5, v2
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    .line 138
    .end local v8    # "wifi_network":Ljava/lang/String;
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 142
    :catch_0
    move-exception v0

    .line 143
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .end local v0    # "e":Lorg/json/JSONException;
    :cond_0
    move-object v6, v7

    .line 150
    .end local v7    # "networks_jsonArray":Lorg/json/JSONArray;
    .restart local v6    # "networks_jsonArray":Lorg/json/JSONArray;
    :cond_1
    new-instance v3, Landroid/widget/ArrayAdapter;

    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-virtual {v9}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    const v10, 0x1090003

    const v11, 0x1020014

    invoke-direct {v3, v9, v10, v11, v5}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;II[Ljava/lang/Object;)V

    .line 152
    .local v3, "listAdapter":Landroid/widget/ArrayAdapter;, "Landroid/widget/ArrayAdapter<Ljava/lang/String;>;"
    invoke-virtual {v4, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 156
    new-instance v9, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;

    invoke-direct {v9, p0, v4}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;-><init>(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;Landroid/widget/ListView;)V

    invoke-virtual {v4, v9}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 193
    return-void

    .line 129
    .end local v2    # "i":I
    .end local v3    # "listAdapter":Landroid/widget/ArrayAdapter;, "Landroid/widget/ArrayAdapter<Ljava/lang/String;>;"
    :catch_1
    move-exception v0

    .line 130
    .restart local v0    # "e":Lorg/json/JSONException;
    :try_start_2
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 132
    :try_start_3
    new-instance v7, Lorg/json/JSONArray;

    const-string v9, ""

    invoke-direct {v7, v9}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .end local v6    # "networks_jsonArray":Lorg/json/JSONArray;
    .restart local v7    # "networks_jsonArray":Lorg/json/JSONArray;
    move-object v6, v7

    .line 137
    .end local v7    # "networks_jsonArray":Lorg/json/JSONArray;
    .restart local v6    # "networks_jsonArray":Lorg/json/JSONArray;
    :goto_2
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v9

    new-array v5, v9, [Ljava/lang/String;

    .line 138
    const/4 v2, 0x0

    .restart local v2    # "i":I
    :goto_3
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v9

    if-ge v2, v9, :cond_1

    .line 140
    :try_start_4
    invoke-virtual {v6, v2}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 141
    .restart local v8    # "wifi_network":Ljava/lang/String;
    const-string v9, "\""

    const-string v10, ""

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    const-string v10, "\n"

    const-string v11, ""

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v5, v2
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_3

    .line 138
    .end local v8    # "wifi_network":Ljava/lang/String;
    :goto_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 133
    .end local v2    # "i":I
    :catch_2
    move-exception v1

    .line 134
    .local v1, "e1":Lorg/json/JSONException;
    :try_start_5
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 137
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v1    # "e1":Lorg/json/JSONException;
    :catchall_0
    move-exception v9

    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v10

    new-array v5, v10, [Ljava/lang/String;

    .line 138
    const/4 v2, 0x0

    .restart local v2    # "i":I
    :goto_5
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v10

    if-ge v2, v10, :cond_2

    .line 140
    :try_start_6
    invoke-virtual {v6, v2}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 141
    .restart local v8    # "wifi_network":Ljava/lang/String;
    const-string v10, "\""

    const-string v11, ""

    invoke-virtual {v8, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v10

    const-string v11, "\n"

    const-string v12, ""

    invoke-virtual {v10, v11, v12}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v5, v2
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_4

    .line 138
    .end local v8    # "wifi_network":Ljava/lang/String;
    :goto_6
    add-int/lit8 v2, v2, 0x1

    goto :goto_5

    .line 142
    .restart local v0    # "e":Lorg/json/JSONException;
    :catch_3
    move-exception v0

    .line 143
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_4

    .line 142
    .end local v0    # "e":Lorg/json/JSONException;
    :catch_4
    move-exception v0

    .line 143
    .restart local v0    # "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_6

    .line 138
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_2
    throw v9
.end method
