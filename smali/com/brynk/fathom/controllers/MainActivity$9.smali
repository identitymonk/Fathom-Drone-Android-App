.class Lcom/brynk/fathom/controllers/MainActivity$9;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/MainActivity;->setupTelemtry()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/MainActivity;

.field final synthetic val$rootView:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/MainActivity;Landroid/view/View;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/MainActivity;

    .prologue
    .line 651
    iput-object p1, p0, Lcom/brynk/fathom/controllers/MainActivity$9;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    iput-object p2, p0, Lcom/brynk/fathom/controllers/MainActivity$9;->val$rootView:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 654
    new-instance v0, Lcom/brynk/fathom/api/TemperatureTask;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity$9;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-virtual {v1}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity$9;->val$rootView:Landroid/view/View;

    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity$9;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-static {v3}, Lcom/brynk/fathom/controllers/MainActivity;->access$800(Lcom/brynk/fathom/controllers/MainActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/brynk/fathom/api/TemperatureTask;-><init>(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, ""

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/TemperatureTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 655
    return-void
.end method
