.class public Lcom/brynk/fathom/api/TemperatureTask;
.super Landroid/os/AsyncTask;
.source "TemperatureTask.java"


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

.field private mContext:Landroid/content/Context;

.field private rootView:Landroid/view/View;

.field private temperature_cutoff:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V
    .locals 2
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "i"    # Ljava/lang/String;

    .prologue
    .line 33
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/brynk/fathom/api/TemperatureTask;->mContext:Landroid/content/Context;

    .line 35
    iput-object p2, p0, Lcom/brynk/fathom/api/TemperatureTask;->rootView:Landroid/view/View;

    .line 36
    iput-object p3, p0, Lcom/brynk/fathom/api/TemperatureTask;->DRONE_IP:Ljava/lang/String;

    .line 38
    new-instance v0, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v0}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    iget-object v1, p0, Lcom/brynk/fathom/api/TemperatureTask;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/helpers/Constants;->getTemperatureCutoff(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/api/TemperatureTask;->temperature_cutoff:Ljava/lang/String;

    .line 39
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 27
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/TemperatureTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p1, "urls"    # [Ljava/lang/String;

    .prologue
    .line 49
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 50
    .local v6, "result":Ljava/lang/StringBuilder;
    const/4 v7, 0x0

    .line 52
    .local v7, "url":Ljava/net/URL;
    :try_start_0
    new-instance v8, Ljava/net/URL;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "http://"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/brynk/fathom/api/TemperatureTask;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "/temperature?cutoff="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/brynk/fathom/api/TemperatureTask;->temperature_cutoff:Ljava/lang/String;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v8, v10}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .line 59
    .end local v7    # "url":Ljava/net/URL;
    .local v8, "url":Ljava/net/URL;
    const/4 v9, 0x0

    .line 61
    .local v9, "urlConnection":Ljava/net/HttpURLConnection;
    :try_start_1
    invoke-virtual {v8}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v10

    move-object v0, v10

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v9, v0
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 67
    :goto_0
    :try_start_2
    new-instance v3, Ljava/io/BufferedInputStream;

    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v10

    invoke-direct {v3, v10}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 68
    .local v3, "in":Ljava/io/InputStream;
    new-instance v5, Ljava/io/BufferedReader;

    new-instance v10, Ljava/io/InputStreamReader;

    invoke-direct {v10, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v5, v10}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 71
    .local v5, "reader":Ljava/io/BufferedReader;
    :goto_1
    invoke-virtual {v5}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .local v4, "line":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 72
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 74
    .end local v3    # "in":Ljava/io/InputStream;
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v1

    .line 75
    .local v1, "e":Ljava/io/IOException;
    :try_start_3
    const-string v10, "FATHOM1"

    const-string v11, "Error reading input from URL"

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 77
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 80
    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 85
    .end local v1    # "e":Ljava/io/IOException;
    :goto_2
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 91
    .local v2, "formatted_temperature":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, ""

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    move-object v7, v8

    .end local v2    # "formatted_temperature":Ljava/lang/String;
    .end local v8    # "url":Ljava/net/URL;
    .end local v9    # "urlConnection":Ljava/net/HttpURLConnection;
    .restart local v7    # "url":Ljava/net/URL;
    :goto_3
    return-object v10

    .line 53
    :catch_1
    move-exception v1

    .line 54
    .local v1, "e":Ljava/net/MalformedURLException;
    const-string v10, "FATHOM1"

    const-string v11, "Unable to read temperature"

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 55
    const-string v10, ""

    goto :goto_3

    .line 62
    .end local v1    # "e":Ljava/net/MalformedURLException;
    .end local v7    # "url":Ljava/net/URL;
    .restart local v8    # "url":Ljava/net/URL;
    .restart local v9    # "urlConnection":Ljava/net/HttpURLConnection;
    :catch_2
    move-exception v1

    .line 63
    .local v1, "e":Ljava/io/IOException;
    const-string v10, "FATHOM1"

    const-string v11, "Error establishing URL connection"

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 64
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 80
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v3    # "in":Ljava/io/InputStream;
    .restart local v4    # "line":Ljava/lang/String;
    .restart local v5    # "reader":Ljava/io/BufferedReader;
    :cond_0
    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_2

    .end local v3    # "in":Ljava/io/InputStream;
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "reader":Ljava/io/BufferedReader;
    :catchall_0
    move-exception v10

    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v10
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 27
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/TemperatureTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 14
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const-wide/16 v12, 0x0

    .line 96
    iget-object v10, p0, Lcom/brynk/fathom/api/TemperatureTask;->rootView:Landroid/view/View;

    const v11, 0x7f0f00b1

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 97
    .local v9, "tvTemp":Landroid/widget/TextView;
    iget-object v10, p0, Lcom/brynk/fathom/api/TemperatureTask;->rootView:Landroid/view/View;

    const v11, 0x7f0f00b2

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 99
    .local v8, "tvBatteryTemp":Landroid/widget/TextView;
    const-string v10, ","

    invoke-virtual {p1, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 101
    .local v5, "temp_parts":[Ljava/lang/String;
    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    .line 102
    .local v4, "pi_temp":Ljava/lang/Double;
    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    .line 104
    .local v0, "battery_temp":Ljava/lang/Double;
    const/4 v10, 0x0

    :try_start_0
    aget-object v10, v5, v10

    invoke-static {v10}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    .line 105
    const/4 v10, 0x1

    aget-object v10, v5, v10

    invoke-static {v10}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 115
    :goto_0
    new-instance v3, Ljava/text/DecimalFormat;

    const-string v10, "#,##0.0"

    invoke-direct {v3, v10}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 116
    .local v3, "oneDigit":Ljava/text/DecimalFormat;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v4}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "C"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 117
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "C"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 121
    :try_start_1
    iget-object v10, p0, Lcom/brynk/fathom/api/TemperatureTask;->temperature_cutoff:Ljava/lang/String;

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    .line 123
    .local v6, "temperature_cutoff_int":I
    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v10

    const-wide/high16 v12, 0x404e000000000000L    # 60.0

    cmpl-double v10, v10, v12

    if-gtz v10, :cond_0

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v10

    add-int/lit8 v12, v6, -0x5

    int-to-double v12, v12

    cmpl-double v10, v10, v12

    if-lez v10, :cond_2

    .line 125
    :cond_0
    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 126
    const/4 v10, 0x0

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 127
    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v10

    add-int/lit8 v12, v6, -0x2

    int-to-double v12, v12

    cmpl-double v10, v10, v12

    if-lez v10, :cond_1

    .line 128
    iget-object v10, p0, Lcom/brynk/fathom/api/TemperatureTask;->rootView:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v10

    const-string v11, "Battery temperature is high. The unit will shutdown soon."

    const/4 v12, 0x1

    invoke-static {v10, v11, v12}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v7

    .line 129
    .local v7, "toast":Landroid/widget/Toast;
    invoke-virtual {v7}, Landroid/widget/Toast;->show()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 141
    .end local v6    # "temperature_cutoff_int":I
    .end local v7    # "toast":Landroid/widget/Toast;
    :cond_1
    :goto_1
    return-void

    .line 107
    .end local v3    # "oneDigit":Ljava/text/DecimalFormat;
    :catch_0
    move-exception v2

    .line 108
    .local v2, "nfe":Ljava/lang/NumberFormatException;
    const-string v10, "FATHOM1"

    const-string v11, "Temperature is not a double"

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 109
    .end local v2    # "nfe":Ljava/lang/NumberFormatException;
    :catch_1
    move-exception v1

    .line 110
    .local v1, "e":Ljava/lang/Exception;
    const-string v10, "FATHOM1"

    const-string v11, "Temperature is not a double"

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 111
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 133
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v3    # "oneDigit":Ljava/text/DecimalFormat;
    .restart local v6    # "temperature_cutoff_int":I
    :cond_2
    const/4 v10, 0x4

    :try_start_2
    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 134
    const/4 v10, 0x4

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setVisibility(I)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_1

    .line 136
    .end local v6    # "temperature_cutoff_int":I
    :catch_2
    move-exception v1

    .line 137
    .restart local v1    # "e":Ljava/lang/Exception;
    const-string v10, "FATHOM1"

    const-string v11, "Unable to determine temperature cutoff"

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method
