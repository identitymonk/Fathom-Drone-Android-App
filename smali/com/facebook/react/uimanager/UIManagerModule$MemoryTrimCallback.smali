.class Lcom/facebook/react/uimanager/UIManagerModule$MemoryTrimCallback;
.super Ljava/lang/Object;
.source "UIManagerModule.java"

# interfaces
.implements Landroid/content/ComponentCallbacks2;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIManagerModule;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MemoryTrimCallback"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/uimanager/UIManagerModule;


# direct methods
.method private constructor <init>(Lcom/facebook/react/uimanager/UIManagerModule;)V
    .locals 0

    .prologue
    .line 732
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIManagerModule$MemoryTrimCallback;->this$0:Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/uimanager/UIManagerModule;Lcom/facebook/react/uimanager/UIManagerModule$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/uimanager/UIManagerModule;
    .param p2, "x1"    # Lcom/facebook/react/uimanager/UIManagerModule$1;

    .prologue
    .line 732
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/UIManagerModule$MemoryTrimCallback;-><init>(Lcom/facebook/react/uimanager/UIManagerModule;)V

    return-void
.end method


# virtual methods
.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 743
    return-void
.end method

.method public onLowMemory()V
    .locals 0

    .prologue
    .line 747
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 1
    .param p1, "level"    # I

    .prologue
    .line 736
    const/16 v0, 0x3c

    if-lt p1, v0, :cond_0

    .line 737
    invoke-static {}, Lcom/facebook/react/uimanager/YogaNodePool;->get()Lcom/facebook/react/common/ClearableSynchronizedPool;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/react/common/ClearableSynchronizedPool;->clear()V

    .line 739
    :cond_0
    return-void
.end method
