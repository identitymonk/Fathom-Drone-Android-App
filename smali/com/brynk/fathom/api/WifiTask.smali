.class public Lcom/brynk/fathom/api/WifiTask;
.super Landroid/os/AsyncTask;
.source "WifiTask.java"


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
.field private mContext:Landroid/content/Context;

.field private rootView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/View;)V
    .locals 0
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "v"    # Landroid/view/View;

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/brynk/fathom/api/WifiTask;->mContext:Landroid/content/Context;

    .line 21
    iput-object p2, p0, Lcom/brynk/fathom/api/WifiTask;->rootView:Landroid/view/View;

    .line 23
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 16
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/WifiTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "urls"    # [Ljava/lang/String;

    .prologue
    .line 28
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    new-instance v1, Lcom/brynk/fathom/helpers/WiFiHelper;

    invoke-direct {v1}, Lcom/brynk/fathom/helpers/WiFiHelper;-><init>()V

    iget-object v2, p0, Lcom/brynk/fathom/api/WifiTask;->mContext:Landroid/content/Context;

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/helpers/WiFiHelper;->calculateSignalStrength(Landroid/content/Context;)I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 16
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/brynk/fathom/api/WifiTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 33
    iget-object v4, p0, Lcom/brynk/fathom/api/WifiTask;->rootView:Landroid/view/View;

    const v5, 0x7f0f00b8

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 34
    .local v1, "ivWifi":Landroid/widget/ImageView;
    const/4 v3, -0x1

    .line 35
    .local v3, "wifi_status":I
    const v2, 0x7f02009c

    .line 37
    .local v2, "wifi_res":I
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 44
    :goto_0
    const/16 v4, 0x5a

    if-le v3, v4, :cond_1

    .line 45
    const v2, 0x7f020098

    .line 54
    :cond_0
    :goto_1
    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 56
    return-void

    .line 39
    :catch_0
    move-exception v0

    .line 41
    .local v0, "e":Ljava/lang/NumberFormatException;
    const-string v4, "FATHOM1"

    const-string v5, "Unable to parse wifi result as a number"

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 46
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_1
    const/16 v4, 0x55

    if-le v3, v4, :cond_2

    .line 47
    const v2, 0x7f02009b

    goto :goto_1

    .line 48
    :cond_2
    const/16 v4, 0x50

    if-le v3, v4, :cond_3

    .line 49
    const v2, 0x7f02009a

    goto :goto_1

    .line 50
    :cond_3
    const/16 v4, 0x46

    if-le v3, v4, :cond_0

    .line 51
    const v2, 0x7f020099

    goto :goto_1
.end method
