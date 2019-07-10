.class Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;
.super Ljava/lang/Object;
.source "WifiSetupStep3Activity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->onPostExecute(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

.field final synthetic val$listView:Landroid/widget/ListView;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;Landroid/widget/ListView;)V
    .locals 0
    .param p1, "this$1"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    .prologue
    .line 156
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    iput-object p2, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->val$listView:Landroid/widget/ListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 10
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 163
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    move v3, p3

    .line 166
    .local v3, "itemPosition":I
    iget-object v8, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->val$listView:Landroid/widget/ListView;

    invoke-virtual {v8, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 168
    .local v4, "itemValue":Ljava/lang/String;
    iget-object v8, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    iget-object v8, v8, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    const v9, 0x7f0f00d7

    invoke-virtual {v8, v9}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 169
    .local v7, "tvWifiSSID":Landroid/widget/TextView;
    invoke-virtual {v7, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 170
    iget-object v8, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    iget-object v8, v8, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-static {v8, v4}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->access$402(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;Ljava/lang/String;)Ljava/lang/String;

    .line 172
    iget-object v8, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    iget-object v8, v8, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    const v9, 0x7f0f0099

    invoke-virtual {v8, v9}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ListView;

    .line 173
    .local v5, "listView":Landroid/widget/ListView;
    const/4 v8, 0x4

    invoke-virtual {v5, v8}, Landroid/widget/ListView;->setVisibility(I)V

    .line 174
    iget-object v8, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    iget-object v8, v8, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    const v9, 0x7f0f00d6

    invoke-virtual {v8, v9}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 175
    .local v6, "tvAvailableNetworks":Landroid/widget/TextView;
    const/4 v8, 0x4

    invoke-virtual {v6, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 177
    iget-object v8, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    iget-object v8, v8, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    const v9, 0x7f0f00d8

    invoke-virtual {v8, v9}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    .line 178
    .local v1, "etWifiPassword":Landroid/widget/EditText;
    const/4 v8, 0x0

    invoke-virtual {v1, v8}, Landroid/widget/EditText;->setVisibility(I)V

    .line 179
    invoke-virtual {v1}, Landroid/widget/EditText;->requestFocus()Z

    .line 180
    iget-object v8, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    iget-object v8, v8, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    iget-object v9, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    iget-object v9, v9, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-virtual {v9}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->getApplicationContext()Landroid/content/Context;

    const-string v9, "input_method"

    invoke-virtual {v8, v9}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/inputmethod/InputMethodManager;

    .line 181
    .local v2, "imm":Landroid/view/inputmethod/InputMethodManager;
    const/4 v8, 0x1

    invoke-virtual {v2, v1, v8}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 183
    iget-object v8, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask$1;->this$1:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    iget-object v8, v8, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->this$0:Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    const v9, 0x7f0f00d9

    invoke-virtual {v8, v9}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 184
    .local v0, "btnWifiConnect":Landroid/widget/Button;
    const/4 v8, 0x0

    invoke-virtual {v0, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 189
    return-void
.end method
