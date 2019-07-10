.class Lcom/facebook/react/modules/permissions/PermissionsModule$2;
.super Ljava/lang/Object;
.source "PermissionsModule.java"

# interfaces
.implements Lcom/facebook/react/bridge/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/permissions/PermissionsModule;->requestMultiplePermissions(Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/Promise;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/permissions/PermissionsModule;

.field final synthetic val$grantedPermissions:Lcom/facebook/react/bridge/WritableMap;

.field final synthetic val$permissionsToCheck:Ljava/util/ArrayList;

.field final synthetic val$promise:Lcom/facebook/react/bridge/Promise;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/permissions/PermissionsModule;Ljava/util/ArrayList;Lcom/facebook/react/bridge/WritableMap;Lcom/facebook/react/bridge/Promise;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/permissions/PermissionsModule;

    .prologue
    .line 171
    iput-object p1, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->this$0:Lcom/facebook/react/modules/permissions/PermissionsModule;

    iput-object p2, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$permissionsToCheck:Ljava/util/ArrayList;

    iput-object p3, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$grantedPermissions:Lcom/facebook/react/bridge/WritableMap;

    iput-object p4, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$promise:Lcom/facebook/react/bridge/Promise;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public varargs invoke([Ljava/lang/Object;)V
    .locals 6
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 174
    const/4 v4, 0x0

    aget-object v4, p1, v4

    check-cast v4, [I

    move-object v3, v4

    check-cast v3, [I

    .line 175
    .local v3, "results":[I
    const/4 v4, 0x1

    aget-object v0, p1, v4

    check-cast v0, Lcom/facebook/react/modules/core/PermissionAwareActivity;

    .line 176
    .local v0, "activity":Lcom/facebook/react/modules/core/PermissionAwareActivity;
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_0
    iget-object v4, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$permissionsToCheck:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v1, v4, :cond_2

    .line 177
    iget-object v4, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$permissionsToCheck:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 178
    .local v2, "permission":Ljava/lang/String;
    aget v4, v3, v1

    if-nez v4, :cond_0

    .line 179
    iget-object v4, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$grantedPermissions:Lcom/facebook/react/bridge/WritableMap;

    const-string v5, "granted"

    invoke-interface {v4, v2, v5}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 181
    :cond_0
    invoke-interface {v0, v2}, Lcom/facebook/react/modules/core/PermissionAwareActivity;->shouldShowRequestPermissionRationale(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 182
    iget-object v4, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$grantedPermissions:Lcom/facebook/react/bridge/WritableMap;

    const-string v5, "denied"

    invoke-interface {v4, v2, v5}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 184
    :cond_1
    iget-object v4, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$grantedPermissions:Lcom/facebook/react/bridge/WritableMap;

    const-string v5, "never_ask_again"

    invoke-interface {v4, v2, v5}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 188
    .end local v2    # "permission":Ljava/lang/String;
    :cond_2
    iget-object v4, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$promise:Lcom/facebook/react/bridge/Promise;

    iget-object v5, p0, Lcom/facebook/react/modules/permissions/PermissionsModule$2;->val$grantedPermissions:Lcom/facebook/react/bridge/WritableMap;

    invoke-interface {v4, v5}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V

    .line 189
    return-void
.end method
