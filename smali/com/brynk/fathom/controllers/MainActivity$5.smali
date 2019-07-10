.class Lcom/brynk/fathom/controllers/MainActivity$5;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/MainActivity;->buildWifiAlertDialog()Landroid/support/v7/app/AlertDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/MainActivity;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/MainActivity;

    .prologue
    .line 451
    iput-object p1, p0, Lcom/brynk/fathom/controllers/MainActivity$5;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 453
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 454
    iget-object v0, p0, Lcom/brynk/fathom/controllers/MainActivity$5;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.settings.WIFI_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/controllers/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 455
    return-void
.end method
