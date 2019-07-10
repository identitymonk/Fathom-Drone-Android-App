.class Lcom/facebook/react/uimanager/UIManagerModule$1;
.super Ljava/lang/Object;
.source "UIManagerModule.java"

# interfaces
.implements Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/uimanager/UIManagerModule;->getDirectEventNamesResolver()Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/uimanager/UIManagerModule;


# direct methods
.method constructor <init>(Lcom/facebook/react/uimanager/UIManagerModule;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/uimanager/UIManagerModule;

    .prologue
    .line 262
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIManagerModule$1;->this$0:Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public resolveCustomEventName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "eventName"    # Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 265
    iget-object v1, p0, Lcom/facebook/react/uimanager/UIManagerModule$1;->this$0:Lcom/facebook/react/uimanager/UIManagerModule;

    .line 266
    invoke-static {v1}, Lcom/facebook/react/uimanager/UIManagerModule;->access$100(Lcom/facebook/react/uimanager/UIManagerModule;)Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 267
    .local v0, "customEventType":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    .line 268
    const-string v1, "registrationName"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 270
    :goto_0
    return-object v1

    :cond_0
    move-object v1, p1

    goto :goto_0
.end method
