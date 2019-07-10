.class Lcom/facebook/react/modules/permissions/PermissionsModule$1;
.super Ljava/lang/Object;
.source "PermissionsModule.java"

# interfaces
.implements Lcom/facebook/react/bridge/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/permissions/PermissionsModule;->requestPermission(Ljava/lang/String;Lcom/facebook/react/bridge/Promise;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/permissions/PermissionsModule;

.field final synthetic val$permission:Ljava/lang/String;

.field final synthetic val$promise:Lcom/facebook/react/bridge/Promise;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/permissions/PermissionsModule;Lcom/facebook/react/bridge/Promise;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/permissions/PermissionsModule;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$1;->this$0:Lcom/facebook/react/modules/permissions/PermissionsModule;

    iput-object p2, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$1;->val$promise:Lcom/facebook/react/bridge/Promise;

    iput-object p3, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$1;->val$permission:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public varargs invoke([Ljava/lang/Object;)V
    .locals 4
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    const/4 v3, 0x0

    .line 118
    aget-object v2, p1, v3

    check-cast v2, [I

    move-object v1, v2

    check-cast v1, [I

    .line 119
    .local v1, "results":[I
    aget v2, v1, v3

    if-nez v2, :cond_0

    .line 120
    iget-object v2, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$1;->val$promise:Lcom/facebook/react/bridge/Promise;

    const-string v3, "granted"

    invoke-interface {v2, v3}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V

    .line 129
    :goto_0
    return-void

    .line 122
    :cond_0
    const/4 v2, 0x1

    aget-object v0, p1, v2

    check-cast v0, Lcom/facebook/react/modules/core/PermissionAwareActivity;

    .line 123
    .local v0, "activity":Lcom/facebook/react/modules/core/PermissionAwareActivity;
    iget-object v2, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$1;->val$permission:Ljava/lang/String;

    invoke-interface {v0, v2}, Lcom/facebook/react/modules/core/PermissionAwareActivity;->shouldShowRequestPermissionRationale(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 124
    iget-object v2, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$1;->val$promise:Lcom/facebook/react/bridge/Promise;

    const-string v3, "denied"

    invoke-interface {v2, v3}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V

    goto :goto_0

    .line 126
    :cond_1
    iget-object v2, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$1;->val$promise:Lcom/facebook/react/bridge/Promise;

    const-string v3, "never_ask_again"

    invoke-interface {v2, v3}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V

    goto :goto_0
.end method
