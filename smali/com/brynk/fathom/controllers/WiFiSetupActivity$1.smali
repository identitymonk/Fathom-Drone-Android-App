.class Lcom/brynk/fathom/controllers/WiFiSetupActivity$1;
.super Ljava/lang/Object;
.source "WiFiSetupActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/WiFiSetupActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/WiFiSetupActivity;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/WiFiSetupActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/WiFiSetupActivity;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WiFiSetupActivity$1;->this$0:Lcom/brynk/fathom/controllers/WiFiSetupActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/brynk/fathom/controllers/WiFiSetupActivity$1;->this$0:Lcom/brynk/fathom/controllers/WiFiSetupActivity;

    invoke-static {v0}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->access$000(Lcom/brynk/fathom/controllers/WiFiSetupActivity;)V

    .line 61
    return-void
.end method
