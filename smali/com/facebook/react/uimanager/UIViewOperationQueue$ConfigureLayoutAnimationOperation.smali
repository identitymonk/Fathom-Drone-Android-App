.class Lcom/facebook/react/uimanager/UIViewOperationQueue$ConfigureLayoutAnimationOperation;
.super Ljava/lang/Object;
.source "UIViewOperationQueue.java"

# interfaces
.implements Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConfigureLayoutAnimationOperation"
.end annotation


# instance fields
.field private final mConfig:Lcom/facebook/react/bridge/ReadableMap;

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 0
    .param p2, "config"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 371
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ConfigureLayoutAnimationOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 372
    iput-object p2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ConfigureLayoutAnimationOperation;->mConfig:Lcom/facebook/react/bridge/ReadableMap;

    .line 373
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/uimanager/UIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;
    .param p2, "x1"    # Lcom/facebook/react/bridge/ReadableMap;
    .param p3, "x2"    # Lcom/facebook/react/uimanager/UIViewOperationQueue$1;

    .prologue
    .line 368
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$ConfigureLayoutAnimationOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/bridge/ReadableMap;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 2

    .prologue
    .line 377
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ConfigureLayoutAnimationOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ConfigureLayoutAnimationOperation;->mConfig:Lcom/facebook/react/bridge/ReadableMap;

    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->configureLayoutAnimation(Lcom/facebook/react/bridge/ReadableMap;)V

    .line 378
    return-void
.end method
