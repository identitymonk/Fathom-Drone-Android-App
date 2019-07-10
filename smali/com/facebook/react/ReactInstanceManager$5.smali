.class Lcom/facebook/react/ReactInstanceManager$5;
.super Ljava/lang/Object;
.source "ReactInstanceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/ReactInstanceManager;->setupReactContext(Lcom/facebook/react/bridge/ReactApplicationContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/ReactInstanceManager;

.field final synthetic val$finalListeners:[Lcom/facebook/react/ReactInstanceManager$ReactInstanceEventListener;

.field final synthetic val$reactContext:Lcom/facebook/react/bridge/ReactApplicationContext;


# direct methods
.method constructor <init>(Lcom/facebook/react/ReactInstanceManager;[Lcom/facebook/react/ReactInstanceManager$ReactInstanceEventListener;Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/ReactInstanceManager;

    .prologue
    .line 991
    iput-object p1, p0, Lcom/facebook/react/ReactInstanceManager$5;->this$0:Lcom/facebook/react/ReactInstanceManager;

    iput-object p2, p0, Lcom/facebook/react/ReactInstanceManager$5;->val$finalListeners:[Lcom/facebook/react/ReactInstanceManager$ReactInstanceEventListener;

    iput-object p3, p0, Lcom/facebook/react/ReactInstanceManager$5;->val$reactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 994
    iget-object v2, p0, Lcom/facebook/react/ReactInstanceManager$5;->val$finalListeners:[Lcom/facebook/react/ReactInstanceManager$ReactInstanceEventListener;

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v0, v2, v1

    .line 995
    .local v0, "listener":Lcom/facebook/react/ReactInstanceManager$ReactInstanceEventListener;
    iget-object v4, p0, Lcom/facebook/react/ReactInstanceManager$5;->val$reactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-interface {v0, v4}, Lcom/facebook/react/ReactInstanceManager$ReactInstanceEventListener;->onReactContextInitialized(Lcom/facebook/react/bridge/ReactContext;)V

    .line 994
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 997
    .end local v0    # "listener":Lcom/facebook/react/ReactInstanceManager$ReactInstanceEventListener;
    :cond_0
    return-void
.end method
