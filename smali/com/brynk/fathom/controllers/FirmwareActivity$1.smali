.class Lcom/brynk/fathom/controllers/FirmwareActivity$1;
.super Ljava/lang/Object;
.source "FirmwareActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/FirmwareActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/FirmwareActivity;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/FirmwareActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/FirmwareActivity;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$1;->this$0:Lcom/brynk/fathom/controllers/FirmwareActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 45
    new-instance v0, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$1;->this$0:Lcom/brynk/fathom/controllers/FirmwareActivity;

    iget-object v2, p0, Lcom/brynk/fathom/controllers/FirmwareActivity$1;->this$0:Lcom/brynk/fathom/controllers/FirmwareActivity;

    invoke-static {v2}, Lcom/brynk/fathom/controllers/FirmwareActivity;->access$100(Lcom/brynk/fathom/controllers/FirmwareActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;-><init>(Lcom/brynk/fathom/controllers/FirmwareActivity;Ljava/lang/String;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, ""

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/controllers/FirmwareActivity$UpdateStatusTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 46
    return-void
.end method
