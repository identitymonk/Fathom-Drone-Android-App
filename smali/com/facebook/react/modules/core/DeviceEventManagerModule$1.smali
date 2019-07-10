.class Lcom/facebook/react/modules/core/DeviceEventManagerModule$1;
.super Ljava/lang/Object;
.source "DeviceEventManagerModule.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/core/DeviceEventManagerModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/core/DeviceEventManagerModule;

.field final synthetic val$backBtnHandler:Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/core/DeviceEventManagerModule;Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/core/DeviceEventManagerModule;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/facebook/react/modules/core/DeviceEventManagerModule$1;->this$0:Lcom/facebook/react/modules/core/DeviceEventManagerModule;

    iput-object p2, p0, Lcom/facebook/react/modules/core/DeviceEventManagerModule$1;->val$backBtnHandler:Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 44
    invoke-static {}, Lcom/facebook/react/bridge/UiThreadUtil;->assertOnUiThread()V

    .line 45
    iget-object v0, p0, Lcom/facebook/react/modules/core/DeviceEventManagerModule$1;->val$backBtnHandler:Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;

    invoke-interface {v0}, Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;->invokeDefaultOnBackPressed()V

    .line 46
    return-void
.end method
