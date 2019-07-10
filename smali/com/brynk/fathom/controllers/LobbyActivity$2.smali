.class Lcom/brynk/fathom/controllers/LobbyActivity$2;
.super Ljava/lang/Object;
.source "LobbyActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/LobbyActivity;->onStart()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/LobbyActivity;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/LobbyActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/LobbyActivity;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/brynk/fathom/controllers/LobbyActivity$2;->this$0:Lcom/brynk/fathom/controllers/LobbyActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 128
    new-instance v0, Lcom/brynk/fathom/controllers/LobbyActivity$ConnectionStatusTask;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/LobbyActivity$2;->this$0:Lcom/brynk/fathom/controllers/LobbyActivity;

    iget-object v2, p0, Lcom/brynk/fathom/controllers/LobbyActivity$2;->this$0:Lcom/brynk/fathom/controllers/LobbyActivity;

    invoke-static {v2}, Lcom/brynk/fathom/controllers/LobbyActivity;->access$000(Lcom/brynk/fathom/controllers/LobbyActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/brynk/fathom/controllers/LobbyActivity$ConnectionStatusTask;-><init>(Lcom/brynk/fathom/controllers/LobbyActivity;Ljava/lang/String;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, ""

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/controllers/LobbyActivity$ConnectionStatusTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 129
    return-void
.end method
