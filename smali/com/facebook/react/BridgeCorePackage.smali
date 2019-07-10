.class Lcom/facebook/react/BridgeCorePackage;
.super Lcom/facebook/react/LazyReactPackage;
.source "BridgeCorePackage.java"


# instance fields
.field private final mHardwareBackBtnHandler:Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;

.field private final mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;


# direct methods
.method constructor <init>(Lcom/facebook/react/ReactInstanceManager;Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;)V
    .locals 0
    .param p1, "reactInstanceManager"    # Lcom/facebook/react/ReactInstanceManager;
    .param p2, "hardwareBackBtnHandler"    # Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/facebook/react/LazyReactPackage;-><init>()V

    .line 55
    iput-object p1, p0, Lcom/facebook/react/BridgeCorePackage;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    .line 56
    iput-object p2, p0, Lcom/facebook/react/BridgeCorePackage;->mHardwareBackBtnHandler:Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;

    .line 57
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/BridgeCorePackage;)Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/BridgeCorePackage;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/facebook/react/BridgeCorePackage;->mHardwareBackBtnHandler:Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;

    return-object v0
.end method

.method static synthetic access$100(Lcom/facebook/react/BridgeCorePackage;)Lcom/facebook/react/ReactInstanceManager;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/BridgeCorePackage;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/facebook/react/BridgeCorePackage;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    return-object v0
.end method


# virtual methods
.method public getNativeModules(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/util/List;
    .locals 4
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/react/bridge/ReactApplicationContext;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/facebook/react/bridge/ModuleSpec;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 63
    .local v0, "moduleSpecList":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/react/bridge/ModuleSpec;>;"
    new-instance v1, Lcom/facebook/react/bridge/ModuleSpec;

    const-class v2, Lcom/facebook/react/modules/systeminfo/AndroidInfoModule;

    new-instance v3, Lcom/facebook/react/BridgeCorePackage$1;

    invoke-direct {v3, p0}, Lcom/facebook/react/BridgeCorePackage$1;-><init>(Lcom/facebook/react/BridgeCorePackage;)V

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/bridge/ModuleSpec;-><init>(Ljava/lang/Class;Ljavax/inject/Provider;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 70
    new-instance v1, Lcom/facebook/react/bridge/ModuleSpec;

    const-class v2, Lcom/facebook/react/modules/core/DeviceEventManagerModule;

    new-instance v3, Lcom/facebook/react/BridgeCorePackage$2;

    invoke-direct {v3, p0, p1}, Lcom/facebook/react/BridgeCorePackage$2;-><init>(Lcom/facebook/react/BridgeCorePackage;Lcom/facebook/react/bridge/ReactApplicationContext;)V

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/bridge/ModuleSpec;-><init>(Ljava/lang/Class;Ljavax/inject/Provider;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 77
    new-instance v1, Lcom/facebook/react/bridge/ModuleSpec;

    const-class v2, Lcom/facebook/react/modules/core/ExceptionsManagerModule;

    new-instance v3, Lcom/facebook/react/BridgeCorePackage$3;

    invoke-direct {v3, p0}, Lcom/facebook/react/BridgeCorePackage$3;-><init>(Lcom/facebook/react/BridgeCorePackage;)V

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/bridge/ModuleSpec;-><init>(Ljava/lang/Class;Ljavax/inject/Provider;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 84
    new-instance v1, Lcom/facebook/react/bridge/ModuleSpec;

    const-class v2, Lcom/facebook/react/modules/core/HeadlessJsTaskSupportModule;

    new-instance v3, Lcom/facebook/react/BridgeCorePackage$4;

    invoke-direct {v3, p0, p1}, Lcom/facebook/react/BridgeCorePackage$4;-><init>(Lcom/facebook/react/BridgeCorePackage;Lcom/facebook/react/bridge/ReactApplicationContext;)V

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/bridge/ModuleSpec;-><init>(Ljava/lang/Class;Ljavax/inject/Provider;)V

    .line 85
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 91
    new-instance v1, Lcom/facebook/react/bridge/ModuleSpec;

    const-class v2, Lcom/facebook/react/modules/debug/SourceCodeModule;

    new-instance v3, Lcom/facebook/react/BridgeCorePackage$5;

    invoke-direct {v3, p0, p1}, Lcom/facebook/react/BridgeCorePackage$5;-><init>(Lcom/facebook/react/BridgeCorePackage;Lcom/facebook/react/bridge/ReactApplicationContext;)V

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/bridge/ModuleSpec;-><init>(Ljava/lang/Class;Ljavax/inject/Provider;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 98
    new-instance v1, Lcom/facebook/react/bridge/ModuleSpec;

    const-class v2, Lcom/facebook/react/modules/core/Timing;

    new-instance v3, Lcom/facebook/react/BridgeCorePackage$6;

    invoke-direct {v3, p0, p1}, Lcom/facebook/react/BridgeCorePackage$6;-><init>(Lcom/facebook/react/BridgeCorePackage;Lcom/facebook/react/bridge/ReactApplicationContext;)V

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/bridge/ModuleSpec;-><init>(Ljava/lang/Class;Ljavax/inject/Provider;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 105
    new-instance v1, Lcom/facebook/react/bridge/ModuleSpec;

    const-class v2, Lcom/facebook/react/modules/deviceinfo/DeviceInfoModule;

    new-instance v3, Lcom/facebook/react/BridgeCorePackage$7;

    invoke-direct {v3, p0, p1}, Lcom/facebook/react/BridgeCorePackage$7;-><init>(Lcom/facebook/react/BridgeCorePackage;Lcom/facebook/react/bridge/ReactApplicationContext;)V

    invoke-direct {v1, v2, v3}, Lcom/facebook/react/bridge/ModuleSpec;-><init>(Ljava/lang/Class;Ljavax/inject/Provider;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 113
    return-object v0
.end method

.method public getReactModuleInfoProvider()Lcom/facebook/react/module/model/ReactModuleInfoProvider;
    .locals 1

    .prologue
    .line 118
    invoke-static {p0}, Lcom/facebook/react/LazyReactPackage;->getReactModuleInfoProviderViaReflection(Lcom/facebook/react/LazyReactPackage;)Lcom/facebook/react/module/model/ReactModuleInfoProvider;

    move-result-object v0

    return-object v0
.end method
