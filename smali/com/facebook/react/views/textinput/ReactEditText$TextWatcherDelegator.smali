.class Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;
.super Ljava/lang/Object;
.source "ReactEditText.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/textinput/ReactEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TextWatcherDelegator"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/views/textinput/ReactEditText;


# direct methods
.method private constructor <init>(Lcom/facebook/react/views/textinput/ReactEditText;)V
    .locals 0

    .prologue
    .line 623
    iput-object p1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/views/textinput/ReactEditText;Lcom/facebook/react/views/textinput/ReactEditText$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/views/textinput/ReactEditText;
    .param p2, "x1"    # Lcom/facebook/react/views/textinput/ReactEditText$1;

    .prologue
    .line 623
    invoke-direct {p0, p1}, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;-><init>(Lcom/facebook/react/views/textinput/ReactEditText;)V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 3
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 646
    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$100(Lcom/facebook/react/views/textinput/ReactEditText;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$200(Lcom/facebook/react/views/textinput/ReactEditText;)Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 647
    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$200(Lcom/facebook/react/views/textinput/ReactEditText;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/text/TextWatcher;

    .line 648
    .local v0, "listener":Landroid/text/TextWatcher;
    invoke-interface {v0, p1}, Landroid/text/TextWatcher;->afterTextChanged(Landroid/text/Editable;)V

    goto :goto_0

    .line 651
    .end local v0    # "listener":Landroid/text/TextWatcher;
    :cond_0
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 3
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 626
    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$100(Lcom/facebook/react/views/textinput/ReactEditText;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$200(Lcom/facebook/react/views/textinput/ReactEditText;)Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 627
    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$200(Lcom/facebook/react/views/textinput/ReactEditText;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/text/TextWatcher;

    .line 628
    .local v0, "listener":Landroid/text/TextWatcher;
    invoke-interface {v0, p1, p2, p3, p4}, Landroid/text/TextWatcher;->beforeTextChanged(Ljava/lang/CharSequence;III)V

    goto :goto_0

    .line 631
    .end local v0    # "listener":Landroid/text/TextWatcher;
    :cond_0
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 3
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 635
    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$100(Lcom/facebook/react/views/textinput/ReactEditText;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$200(Lcom/facebook/react/views/textinput/ReactEditText;)Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 636
    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$200(Lcom/facebook/react/views/textinput/ReactEditText;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/text/TextWatcher;

    .line 637
    .local v0, "listener":Landroid/text/TextWatcher;
    invoke-interface {v0, p1, p2, p3, p4}, Landroid/text/TextWatcher;->onTextChanged(Ljava/lang/CharSequence;III)V

    goto :goto_0

    .line 641
    .end local v0    # "listener":Landroid/text/TextWatcher;
    :cond_0
    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactEditText$TextWatcherDelegator;->this$0:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-static {v1}, Lcom/facebook/react/views/textinput/ReactEditText;->access$300(Lcom/facebook/react/views/textinput/ReactEditText;)V

    .line 642
    return-void
.end method
