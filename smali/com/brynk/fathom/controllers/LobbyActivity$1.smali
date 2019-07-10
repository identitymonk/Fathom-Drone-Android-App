.class Lcom/brynk/fathom/controllers/LobbyActivity$1;
.super Ljava/lang/Object;
.source "LobbyActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/LobbyActivity;->onCreate(Landroid/os/Bundle;)V
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
    .line 71
    iput-object p1, p0, Lcom/brynk/fathom/controllers/LobbyActivity$1;->this$0:Lcom/brynk/fathom/controllers/LobbyActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 74
    const-string v0, "Have a question? Contact hello@fathomdrone.com"

    const/4 v1, 0x0

    invoke-static {p1, v0, v1}, Landroid/support/design/widget/Snackbar;->make(Landroid/view/View;Ljava/lang/CharSequence;I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    const-string v1, "Action"

    const/4 v2, 0x0

    .line 75
    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->setAction(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->show()V

    .line 76
    return-void
.end method
