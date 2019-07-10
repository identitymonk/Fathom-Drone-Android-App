.class Lcom/brynk/fathom/controllers/MainActivity$11;
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
    .line 668
    iput-object p1, p0, Lcom/brynk/fathom/controllers/MainActivity$11;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    iput-object p2, p0, Lcom/brynk/fathom/controllers/MainActivity$11;->val$rootView:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 671
    new-instance v0, Lcom/brynk/fathom/api/WifiTask;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/MainActivity$11;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-virtual {v1}, Lcom/brynk/fathom/controllers/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/brynk/fathom/controllers/MainActivity$11;->val$rootView:Landroid/view/View;

    invoke-direct {v0, v1, v2}, Lcom/brynk/fathom/api/WifiTask;-><init>(Landroid/content/Context;Landroid/view/View;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "blah"

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/WifiTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 672
    return-void
.end method
