.class final Lcom/facebook/react/bridge/ModuleSpec$2;
.super Lcom/facebook/react/bridge/ModuleSpec$ConstructorProvider;
.source "ModuleSpec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/bridge/ModuleSpec;->simple(Ljava/lang/Class;Lcom/facebook/react/bridge/ReactApplicationContext;)Lcom/facebook/react/bridge/ModuleSpec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Lcom/facebook/react/bridge/ReactApplicationContext;

.field final synthetic val$type:Ljava/lang/Class;


# direct methods
.method constructor <init>(Ljava/lang/Class;[Ljava/lang/Class;Ljava/lang/Class;Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 0
    .param p2, "signature"    # [Ljava/lang/Class;

    .prologue
    .line 55
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/facebook/react/bridge/NativeModule;>;"
    iput-object p3, p0, Lcom/facebook/react/bridge/ModuleSpec$2;->val$type:Ljava/lang/Class;

    iput-object p4, p0, Lcom/facebook/react/bridge/ModuleSpec$2;->val$context:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-direct {p0, p1, p2}, Lcom/facebook/react/bridge/ModuleSpec$ConstructorProvider;-><init>(Ljava/lang/Class;[Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method public get()Lcom/facebook/react/bridge/NativeModule;
    .locals 5

    .prologue
    .line 59
    :try_start_0
    iget-object v1, p0, Lcom/facebook/react/bridge/ModuleSpec$2;->val$type:Ljava/lang/Class;

    invoke-static {}, Lcom/facebook/react/bridge/ModuleSpec;->access$100()[Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/facebook/react/bridge/ModuleSpec$2;->getConstructor(Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/facebook/react/bridge/ModuleSpec$2;->val$context:Lcom/facebook/react/bridge/ReactApplicationContext;

    aput-object v4, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/bridge/NativeModule;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 60
    :catch_0
    move-exception v0

    .line 61
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "ModuleSpec with class: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/react/bridge/ModuleSpec$2;->val$type:Ljava/lang/Class;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 55
    invoke-virtual {p0}, Lcom/facebook/react/bridge/ModuleSpec$2;->get()Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    return-object v0
.end method
