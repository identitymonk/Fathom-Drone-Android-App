.class Lcom/brynk/fathom/helpers/DivelogAdapter$1;
.super Ljava/lang/Object;
.source "DivelogAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/helpers/DivelogAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/helpers/DivelogAdapter;

.field final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/brynk/fathom/helpers/DivelogAdapter;I)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/helpers/DivelogAdapter;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/brynk/fathom/helpers/DivelogAdapter$1;->this$0:Lcom/brynk/fathom/helpers/DivelogAdapter;

    iput p2, p0, Lcom/brynk/fathom/helpers/DivelogAdapter$1;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 64
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "http://"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/brynk/fathom/helpers/DivelogAdapter$1;->this$0:Lcom/brynk/fathom/helpers/DivelogAdapter;

    invoke-static {v3}, Lcom/brynk/fathom/helpers/DivelogAdapter;->access$000(Lcom/brynk/fathom/helpers/DivelogAdapter;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/static/recordings/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/brynk/fathom/helpers/DivelogAdapter$1;->this$0:Lcom/brynk/fathom/helpers/DivelogAdapter;

    invoke-static {v3}, Lcom/brynk/fathom/helpers/DivelogAdapter;->access$100(Lcom/brynk/fathom/helpers/DivelogAdapter;)[Lcom/brynk/fathom/helpers/DivelogEntry;

    move-result-object v3

    iget v4, p0, Lcom/brynk/fathom/helpers/DivelogAdapter$1;->val$position:I

    aget-object v3, v3, v4

    invoke-virtual {v3}, Lcom/brynk/fathom/helpers/DivelogEntry;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 65
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 66
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v0, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 67
    iget-object v2, p0, Lcom/brynk/fathom/helpers/DivelogAdapter$1;->this$0:Lcom/brynk/fathom/helpers/DivelogAdapter;

    invoke-static {v2}, Lcom/brynk/fathom/helpers/DivelogAdapter;->access$200(Lcom/brynk/fathom/helpers/DivelogAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 69
    return-void
.end method
