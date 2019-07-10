.class Lcom/facebook/react/views/textinput/ReactTextInputManager$2;
.super Ljava/lang/Object;
.source "ReactTextInputManager.java"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/views/textinput/ReactTextInputManager;->addEventEmitters(Lcom/facebook/react/uimanager/ThemedReactContext;Lcom/facebook/react/views/textinput/ReactEditText;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/views/textinput/ReactTextInputManager;

.field final synthetic val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

.field final synthetic val$reactContext:Lcom/facebook/react/uimanager/ThemedReactContext;


# direct methods
.method constructor <init>(Lcom/facebook/react/views/textinput/ReactTextInputManager;Lcom/facebook/react/views/textinput/ReactEditText;Lcom/facebook/react/uimanager/ThemedReactContext;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/views/textinput/ReactTextInputManager;

    .prologue
    .line 729
    iput-object p1, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$2;->this$0:Lcom/facebook/react/views/textinput/ReactTextInputManager;

    iput-object p2, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$2;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    iput-object p3, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$2;->val$reactContext:Lcom/facebook/react/uimanager/ThemedReactContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 8
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "keyEvent"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 733
    and-int/lit16 v3, p2, 0xff

    if-gtz v3, :cond_0

    if-nez p2, :cond_4

    .line 735
    :cond_0
    iget-object v3, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$2;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-virtual {v3}, Lcom/facebook/react/views/textinput/ReactEditText;->getBlurOnSubmit()Z

    move-result v0

    .line 736
    .local v0, "blurOnSubmit":Z
    iget-object v3, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$2;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-virtual {v3}, Lcom/facebook/react/views/textinput/ReactEditText;->getInputType()I

    move-result v3

    const/high16 v6, 0x20000

    and-int/2addr v3, v6

    if-eqz v3, :cond_5

    move v2, v4

    .line 746
    .local v2, "isMultiline":Z
    :goto_0
    iget-object v3, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$2;->val$reactContext:Lcom/facebook/react/uimanager/ThemedReactContext;

    const-class v6, Lcom/facebook/react/uimanager/UIManagerModule;

    .line 747
    invoke-virtual {v3, v6}, Lcom/facebook/react/uimanager/ThemedReactContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {v3}, Lcom/facebook/react/uimanager/UIManagerModule;->getEventDispatcher()Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v1

    .line 749
    .local v1, "eventDispatcher":Lcom/facebook/react/uimanager/events/EventDispatcher;
    new-instance v3, Lcom/facebook/react/views/textinput/ReactTextInputSubmitEditingEvent;

    iget-object v6, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$2;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    .line 751
    invoke-virtual {v6}, Lcom/facebook/react/views/textinput/ReactEditText;->getId()I

    move-result v6

    iget-object v7, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$2;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    .line 752
    invoke-virtual {v7}, Lcom/facebook/react/views/textinput/ReactEditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v3, v6, v7}, Lcom/facebook/react/views/textinput/ReactTextInputSubmitEditingEvent;-><init>(ILjava/lang/String;)V

    .line 749
    invoke-virtual {v1, v3}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 754
    if-eqz v0, :cond_1

    .line 755
    iget-object v3, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$2;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-virtual {v3}, Lcom/facebook/react/views/textinput/ReactEditText;->clearFocus()V

    .line 759
    :cond_1
    if-nez v0, :cond_2

    if-nez v2, :cond_3

    :cond_2
    move v5, v4

    :cond_3
    move v4, v5

    .line 762
    .end local v0    # "blurOnSubmit":Z
    .end local v1    # "eventDispatcher":Lcom/facebook/react/uimanager/events/EventDispatcher;
    .end local v2    # "isMultiline":Z
    :cond_4
    return v4

    .restart local v0    # "blurOnSubmit":Z
    :cond_5
    move v2, v5

    .line 736
    goto :goto_0
.end method
