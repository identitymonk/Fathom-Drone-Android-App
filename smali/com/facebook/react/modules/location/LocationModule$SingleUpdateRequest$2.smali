.class Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;
.super Ljava/lang/Object;
.source "LocationModule.java"

# interfaces
.implements Landroid/location/LocationListener;


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
    .line 267
    iput-object p1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLocationChanged(Landroid/location/Location;)V
    .locals 5
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    .line 270
    iget-object v1, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    monitor-enter v1

    .line 271
    :try_start_0
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v0}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$900(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    iget-object v2, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v2}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1300(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/location/Location;

    move-result-object v2

    invoke-static {v0, p1, v2}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1400(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;Landroid/location/Location;Landroid/location/Location;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 272
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v0}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1500(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Lcom/facebook/react/bridge/Callback;

    move-result-object v0

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Lcom/facebook/react/modules/location/LocationModule;->access$000(Landroid/location/Location;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v2}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 273
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v0}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1700(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/os/Handler;

    move-result-object v0

    iget-object v2, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v2}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1600(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Ljava/lang/Runnable;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 274
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$902(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;Z)Z

    .line 275
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v0}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1200(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/location/LocationManager;

    move-result-object v0

    iget-object v2, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v2}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1100(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;)Landroid/location/LocationListener;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 278
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest$2;->this$0:Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;

    invoke-static {v0, p1}, Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;->access$1302(Lcom/facebook/react/modules/location/LocationModule$SingleUpdateRequest;Landroid/location/Location;)Landroid/location/Location;

    .line 279
    monitor-exit v1

    .line 280
    return-void

    .line 279
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onProviderDisabled(Ljava/lang/String;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 289
    return-void
.end method

.method public onProviderEnabled(Ljava/lang/String;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 286
    return-void
.end method

.method public onStatusChanged(Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;
    .param p2, "status"    # I
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 283
    return-void
.end method
