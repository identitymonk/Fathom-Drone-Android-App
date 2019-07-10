.class Lcom/brynk/fathom/controllers/LobbyActivity$3;
.super Ljava/lang/Object;
.source "LobbyActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/LobbyActivity;->onRequestPermissionsResult(I[Ljava/lang/String;[I)V
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
    .line 154
    iput-object p1, p0, Lcom/brynk/fathom/controllers/LobbyActivity$3;->this$0:Lcom/brynk/fathom/controllers/LobbyActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 158
    return-void
.end method
