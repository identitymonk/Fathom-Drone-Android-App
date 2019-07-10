.class Lcom/brynk/fathom/controllers/SplashActivity$2;
.super Ljava/lang/Object;
.source "SplashActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/SplashActivity;->onCreate(Landroid/os/Bundle;)V
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
    .line 69
    iput-object p1, p0, Lcom/brynk/fathom/controllers/SplashActivity$2;->this$0:Lcom/brynk/fathom/controllers/SplashActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/brynk/fathom/controllers/SplashActivity$2;->this$0:Lcom/brynk/fathom/controllers/SplashActivity;

    invoke-static {v0}, Lcom/brynk/fathom/controllers/SplashActivity;->access$100(Lcom/brynk/fathom/controllers/SplashActivity;)V

    .line 80
    return-void
.end method
