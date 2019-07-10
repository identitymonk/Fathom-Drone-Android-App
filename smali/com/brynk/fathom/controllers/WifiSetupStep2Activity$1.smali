.class Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$1;
.super Ljava/lang/Object;
.source "WifiSetupStep2Activity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$1;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 60
    iget-object v3, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$1;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    const v4, 0x7f0f009c

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    .line 61
    .local v1, "progressBar":Landroid/widget/ProgressBar;
    const/4 v3, 0x4

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 63
    iget-object v3, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$1;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    const v4, 0x7f0f00d4

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 64
    .local v2, "tvConnected":Landroid/widget/TextView;
    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 67
    iget-object v3, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$1;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    const v4, 0x7f0f00d5

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 68
    .local v0, "btnNext":Landroid/widget/Button;
    invoke-virtual {v0, v5}, Landroid/widget/Button;->setVisibility(I)V

    .line 70
    return-void
.end method
