.class public Lcom/brynk/fathom/api/TelemetryServerTask;
.super Landroid/os/AsyncTask;
.source "TelemetryServerTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Float;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private mContext:Landroid/content/Context;

.field private rootView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/View;)V
    .locals 0
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "v"    # Landroid/view/View;

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/brynk/fathom/api/TelemetryServerTask;->mContext:Landroid/content/Context;

    .line 28
    iput-object p2, p0, Lcom/brynk/fathom/api/TelemetryServerTask;->rootView:Landroid/view/View;

    .line 29
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 22
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/TelemetryServerTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 14
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 34
    const/16 v10, 0x2694

    .line 35
    .local v10, "server_port":I
    const/16 v12, 0x5dc

    new-array v3, v12, [B

    .line 36
    .local v3, "message":[B
    const/4 v8, 0x0

    .line 38
    .local v8, "s":Ljava/net/MulticastSocket;
    :try_start_0
    new-instance v9, Ljava/net/MulticastSocket;

    const/16 v12, 0x2694

    invoke-direct {v9, v12}, Ljava/net/MulticastSocket;-><init>(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .end local v8    # "s":Ljava/net/MulticastSocket;
    .local v9, "s":Ljava/net/MulticastSocket;
    move-object v8, v9

    .line 43
    .end local v9    # "s":Ljava/net/MulticastSocket;
    .restart local v8    # "s":Ljava/net/MulticastSocket;
    :goto_0
    :try_start_1
    const-string v12, "224.1.1.1"

    invoke-static {v12}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v12

    invoke-virtual {v8, v12}, Ljava/net/MulticastSocket;->joinGroup(Ljava/net/InetAddress;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 49
    :goto_1
    new-instance v5, Ljava/net/DatagramPacket;

    array-length v12, v3

    invoke-direct {v5, v3, v12}, Ljava/net/DatagramPacket;-><init>([BI)V

    .line 53
    .local v5, "p":Ljava/net/DatagramPacket;
    :goto_2
    :try_start_2
    invoke-virtual {v8, v5}, Ljava/net/MulticastSocket;->receive(Ljava/net/DatagramPacket;)V

    .line 54
    new-instance v11, Ljava/lang/String;

    const/4 v12, 0x0

    invoke-virtual {v5}, Ljava/net/DatagramPacket;->getLength()I

    move-result v13

    invoke-direct {v11, v3, v12, v13}, Ljava/lang/String;-><init>([BII)V

    .line 55
    .local v11, "text":Ljava/lang/String;
    const-string v12, ","

    invoke-virtual {v11, v12}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 56
    .local v4, "message_parts":[Ljava/lang/String;
    const/4 v12, 0x0

    aget-object v12, v4, v12

    invoke-static {v12}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v12

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    .line 57
    .local v6, "pitch":Ljava/lang/Float;
    const/4 v12, 0x1

    aget-object v12, v4, v12

    invoke-static {v12}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v12

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    .line 58
    .local v7, "roll":Ljava/lang/Float;
    const/4 v12, 0x2

    aget-object v12, v4, v12

    invoke-static {v12}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v12

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 59
    .local v0, "depth":Ljava/lang/Float;
    const/4 v12, 0x3

    aget-object v12, v4, v12

    invoke-static {v12}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v12

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 61
    .local v2, "heading":Ljava/lang/Float;
    const/4 v12, 0x4

    new-array v12, v12, [Ljava/lang/Float;

    const/4 v13, 0x0

    aput-object v6, v12, v13

    const/4 v13, 0x1

    aput-object v7, v12, v13

    const/4 v13, 0x2

    aput-object v0, v12, v13

    const/4 v13, 0x3

    aput-object v2, v12, v13

    invoke-virtual {p0, v12}, Lcom/brynk/fathom/api/TelemetryServerTask;->publishProgress([Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/lang/NullPointerException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_4

    goto :goto_2

    .line 64
    .end local v0    # "depth":Ljava/lang/Float;
    .end local v2    # "heading":Ljava/lang/Float;
    .end local v4    # "message_parts":[Ljava/lang/String;
    .end local v6    # "pitch":Ljava/lang/Float;
    .end local v7    # "roll":Ljava/lang/Float;
    .end local v11    # "text":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 65
    .local v1, "e":Ljava/lang/Exception;
    :goto_3
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 68
    invoke-virtual {v8}, Ljava/net/MulticastSocket;->close()V

    .line 69
    const/4 v12, 0x0

    return-object v12

    .line 39
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v5    # "p":Ljava/net/DatagramPacket;
    :catch_1
    move-exception v1

    .line 40
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 44
    .end local v1    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v1

    .line 45
    .restart local v1    # "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 64
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v5    # "p":Ljava/net/DatagramPacket;
    :catch_3
    move-exception v1

    goto :goto_3

    :catch_4
    move-exception v1

    goto :goto_3

    :catch_5
    move-exception v1

    goto :goto_3
.end method

.method protected varargs onProgressUpdate([Ljava/lang/Float;)V
    .locals 22
    .param p1, "values"    # [Ljava/lang/Float;

    .prologue
    .line 75
    invoke-super/range {p0 .. p1}, Landroid/os/AsyncTask;->onProgressUpdate([Ljava/lang/Object;)V

    .line 76
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/brynk/fathom/api/TelemetryServerTask;->rootView:Landroid/view/View;

    move-object/from16 v17, v0

    const v18, 0x7f0f00b7

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/ImageView;

    .line 77
    .local v10, "ivPitch":Landroid/widget/ImageView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/brynk/fathom/api/TelemetryServerTask;->rootView:Landroid/view/View;

    move-object/from16 v17, v0

    const v18, 0x7f0f00a7

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/ImageView;

    .line 78
    .local v11, "ivPitchIndicator":Landroid/widget/ImageView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/brynk/fathom/api/TelemetryServerTask;->rootView:Landroid/view/View;

    move-object/from16 v17, v0

    const v18, 0x7f0f00b5

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v15

    check-cast v15, Landroid/widget/TextView;

    .line 79
    .local v15, "tvDepth":Landroid/widget/TextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/brynk/fathom/api/TelemetryServerTask;->rootView:Landroid/view/View;

    move-object/from16 v17, v0

    const v18, 0x7f0f00b4

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v16

    check-cast v16, Landroid/widget/TextView;

    .line 81
    .local v16, "tvHeading":Landroid/widget/TextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/brynk/fathom/api/TelemetryServerTask;->rootView:Landroid/view/View;

    move-object/from16 v17, v0

    const v18, 0x7f0f00a8

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/widget/ImageView;

    .line 84
    .local v12, "ivRollIndicator":Landroid/widget/ImageView;
    invoke-virtual {v12}, Landroid/widget/ImageView;->getY()F

    move-result v17

    const/high16 v18, 0x43020000    # 130.0f

    sub-float v13, v17, v18

    .line 86
    .local v13, "pitchIndicatorCenter":F
    const/16 v17, 0x0

    aget-object v14, p1, v17

    .line 87
    .local v14, "pitch_value":Ljava/lang/Float;
    const/16 v17, 0x2

    aget-object v4, p1, v17

    .line 88
    .local v4, "depth_value":Ljava/lang/Float;
    const/16 v17, 0x3

    aget-object v9, p1, v17

    .line 90
    .local v9, "heading_value":Ljava/lang/Float;
    const/16 v17, 0x1

    aget-object v17, p1, v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Float;->floatValue()F

    move-result v17

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/widget/ImageView;->setRotation(F)V

    .line 91
    const/high16 v17, 0x40000000    # 2.0f

    invoke-virtual {v14}, Ljava/lang/Float;->floatValue()F

    move-result v18

    mul-float v17, v17, v18

    sub-float v17, v13, v17

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/widget/ImageView;->setY(F)V

    .line 95
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v17

    move/from16 v0, v17

    float-to-double v0, v0

    move-wide/from16 v18, v0

    const-wide v20, 0x3fd381d7dbf487fdL    # 0.3048

    mul-double v18, v18, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    .line 96
    .local v3, "depth_in_meters":Ljava/lang/Double;
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "%.1f"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v3, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "m"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 97
    .local v8, "formatted_depth":Ljava/lang/String;
    invoke-virtual {v15, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    const/4 v2, 0x0

    .line 105
    .local v2, "closest_45":I
    :try_start_0
    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v17

    const/high16 v18, 0x43b40000    # 360.0f

    rem-float v17, v17, v18

    const/high16 v18, 0x42340000    # 45.0f

    div-float v17, v17, v18

    invoke-static/range {v17 .. v17}, Ljava/lang/Math;->round(F)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    .line 110
    :goto_0
    const/16 v17, 0x7

    move/from16 v0, v17

    if-le v2, v0, :cond_0

    .line 112
    const/4 v2, 0x7

    .line 114
    :cond_0
    const/16 v17, 0x8

    move/from16 v0, v17

    new-array v6, v0, [Ljava/lang/String;

    const/16 v17, 0x0

    const-string v18, "N"

    aput-object v18, v6, v17

    const/16 v17, 0x1

    const-string v18, "NW"

    aput-object v18, v6, v17

    const/16 v17, 0x2

    const-string v18, "W"

    aput-object v18, v6, v17

    const/16 v17, 0x3

    const-string v18, "SW"

    aput-object v18, v6, v17

    const/16 v17, 0x4

    const-string v18, "S"

    aput-object v18, v6, v17

    const/16 v17, 0x5

    const-string v18, "SE"

    aput-object v18, v6, v17

    const/16 v17, 0x6

    const-string v18, "E"

    aput-object v18, v6, v17

    const/16 v17, 0x7

    const-string v18, "NE"

    aput-object v18, v6, v17

    .line 115
    .local v6, "directions":[Ljava/lang/String;
    aget-object v5, v6, v2

    .line 117
    .local v5, "direction":Ljava/lang/String;
    move-object/from16 v0, v16

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 120
    return-void

    .line 106
    .end local v5    # "direction":Ljava/lang/String;
    .end local v6    # "directions":[Ljava/lang/String;
    :catch_0
    move-exception v7

    .line 107
    .local v7, "e":Ljava/lang/NumberFormatException;
    const-string v17, "FATHOM1"

    const-string v18, "Unable to read heading as a number"

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected bridge synthetic onProgressUpdate([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 22
    check-cast p1, [Ljava/lang/Float;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/TelemetryServerTask;->onProgressUpdate([Ljava/lang/Float;)V

    return-void
.end method
