.class Lcom/facebook/react/views/textinput/ReactTextInputManager$1;
.super Ljava/lang/Object;
.source "ReactTextInputManager.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


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
.method constructor <init>(Lcom/facebook/react/views/textinput/ReactTextInputManager;Lcom/facebook/react/uimanager/ThemedReactContext;Lcom/facebook/react/views/textinput/ReactEditText;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/views/textinput/ReactTextInputManager;

    .prologue
    .line 707
    iput-object p1, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$1;->this$0:Lcom/facebook/react/views/textinput/ReactTextInputManager;

    iput-object p2, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$1;->val$reactContext:Lcom/facebook/react/uimanager/ThemedReactContext;

    iput-object p3, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$1;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    .line 709
    iget-object v1, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$1;->val$reactContext:Lcom/facebook/react/uimanager/ThemedReactContext;

    const-class v2, Lcom/facebook/react/uimanager/UIManagerModule;

    .line 710
    invoke-virtual {v1, v2}, Lcom/facebook/react/uimanager/ThemedReactContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {v1}, Lcom/facebook/react/uimanager/UIManagerModule;->getEventDispatcher()Lcom/facebook/react/uimanager/events/EventDispatcher;

    move-result-object v0

    .line 711
    .local v0, "eventDispatcher":Lcom/facebook/react/uimanager/events/EventDispatcher;
    if-eqz p2, :cond_0

    .line 712
    new-instance v1, Lcom/facebook/react/views/textinput/ReactTextInputFocusEvent;

    iget-object v2, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$1;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    .line 714
    invoke-virtual {v2}, Lcom/facebook/react/views/textinput/ReactEditText;->getId()I

    move-result v2

    invoke-direct {v1, v2}, Lcom/facebook/react/views/textinput/ReactTextInputFocusEvent;-><init>(I)V

    .line 712
    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 725
    :goto_0
    return-void

    .line 716
    :cond_0
    new-instance v1, Lcom/facebook/react/views/textinput/ReactTextInputBlurEvent;

    iget-object v2, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$1;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    .line 718
    invoke-virtual {v2}, Lcom/facebook/react/views/textinput/ReactEditText;->getId()I

    move-result v2

    invoke-direct {v1, v2}, Lcom/facebook/react/views/textinput/ReactTextInputBlurEvent;-><init>(I)V

    .line 716
    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 720
    new-instance v1, Lcom/facebook/react/views/textinput/ReactTextInputEndEditingEvent;

    iget-object v2, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$1;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    .line 722
    invoke-virtual {v2}, Lcom/facebook/react/views/textinput/ReactEditText;->getId()I

    move-result v2

    iget-object v3, p0, Lcom/facebook/react/views/textinput/ReactTextInputManager$1;->val$editText:Lcom/facebook/react/views/textinput/ReactEditText;

    .line 723
    invoke-virtual {v3}, Lcom/facebook/react/views/textinput/ReactEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/views/textinput/ReactTextInputEndEditingEvent;-><init>(ILjava/lang/String;)V

    .line 720
    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    goto :goto_0
.end method
