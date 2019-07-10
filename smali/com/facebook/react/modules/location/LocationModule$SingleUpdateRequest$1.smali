.class Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;
.super Ljava/lang/Object;
.source "LocationModule.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    .prologue
    .line 254
    iput-object p1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 257
    iget-object v1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    monitor-enter v1

    .line 258
    :try_start_0
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v0}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$900(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 259
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v0}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1000(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Lcom/facebook/react/bridge/Callback;

    move-result-object v0

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    sget v4, Lcom/facebook/react/modules/location/PositionError;->TIMEOUT:I

    const-string v5, "Location request timed out"

    invoke-static {v4, v5}, Lcom/facebook/react/modules/location/PositionError;->buildError(ILjava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v2}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 260
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v0}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1200(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/location/LocationManager;

    move-result-object v0

    iget-object v2, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v2}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1100(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/location/LocationListener;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 261
    const-string v0, "ReactNative"

    const-string v2, "LocationModule: Location request timed out"

    invoke-static {v0, v2}, Lcom/facebook/common/logging/FLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$1;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$902(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;Z)Z

    .line 264
    :cond_0
    monitor-exit v1

    .line 265
    return-void

    .line 264
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
