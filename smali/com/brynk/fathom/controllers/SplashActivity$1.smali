.class Lcom/brynk/fathom/controllers/SplashActivity$1;
.super Ljava/lang/Object;
.source "SplashActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/SplashActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/SplashActivity;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/SplashActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/SplashActivity;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/brynk/fathom/controllers/SplashActivity$1;->this$0:Lcom/brynk/fathom/controllers/SplashActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "InlinedApi"
        }
    .end annotation

    .prologue
    .line 39
    iget-object v0, p0, Lcom/brynk/fathom/controllers/SplashActivity$1;->this$0:Lcom/brynk/fathom/controllers/SplashActivity;

    invoke-static {v0}, Lcom/brynk/fathom/controllers/SplashActivity;->access$000(Lcom/brynk/fathom/controllers/SplashActivity;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x1307

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 45
    return-void
.end method
