.class public Lcom/facebook/react/modules/statusbar/StatusBarModule;
.super Lcom/facebook/react/bridge/ReactContextBaseJavaModule;
.source "StatusBarModule.java"


# annotations
.annotation runtime Lcom/facebook/react/module/annotations/ReactModule;
    name = "StatusBarManager"
.end annotation


# static fields
.field private static final HEIGHT_KEY:Ljava/lang/String; = "HEIGHT"


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 0
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/ReactContextBaseJavaModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V

    .line 46
    return-void
.end method


# virtual methods
.method public getConstants()Ljava/util/Map;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 55
    invoke-virtual {p0}, Lcom/facebook/react/modules/statusbar/StatusBarModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    .line 56
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const-string v4, "status_bar_height"

    const-string v5, "dimen"

    const-string v6, "android"

    .line 57
    invoke-virtual {v3, v4, v5, v6}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .line 58
    .local v2, "heightResId":I
    if-lez v2, :cond_0

    .line 59
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    int-to-float v3, v3

    invoke-static {v3}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v1

    .line 62
    .local v1, "height":F
    :goto_0
    const-string v3, "HEIGHT"

    .line 63
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 62
    invoke-static {v3, v4}, Lcom/facebook/react/common/MapBuilder;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v3

    return-object v3

    .line 59
    .end local v1    # "height":F
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    const-string v0, "StatusBarManager"

    return-object v0
.end method

.method public setColor(IZ)V
    .locals 6
    .param p1, "color"    # I
    .param p2, "animated"    # Z
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 68
    invoke-virtual {p0}, Lcom/facebook/react/modules/statusbar/StatusBarModule;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v3

    .line 69
    .local v3, "activity":Landroid/app/Activity;
    if-nez v3, :cond_1

    .line 70
    const-string v0, "ReactNative"

    const-string v1, "StatusBarModule: Ignored status bar change, current activity is null."

    invoke-static {v0, v1}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    :cond_0
    :goto_0
    return-void

    .line 74
    :cond_1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 76
    new-instance v0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;

    .line 77
    invoke-virtual {p0}, Lcom/facebook/react/modules/statusbar/StatusBarModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v2

    move-object v1, p0

    move v4, p2

    move v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;-><init>(Lcom/facebook/react/modules/statusbar/StatusBarModule;Lcom/facebook/react/bridge/ReactContext;Landroid/app/Activity;ZI)V

    .line 76
    invoke-static {v0}, Lcom/facebook/react/bridge/UiThreadUtil;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public setHidden(Z)V
    .locals 3
    .param p1, "hidden"    # Z
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 149
    invoke-virtual {p0}, Lcom/facebook/react/modules/statusbar/StatusBarModule;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v0

    .line 150
    .local v0, "activity":Landroid/app/Activity;
    if-nez v0, :cond_0

    .line 151
    const-string v1, "ReactNative"

    const-string v2, "StatusBarModule: Ignored status bar change, current activity is null."

    invoke-static {v1, v2}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    :goto_0
    return-void

    .line 154
    :cond_0
    new-instance v1, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;

    invoke-direct {v1, p0, p1, v0}, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;-><init>(Lcom/facebook/react/modules/statusbar/StatusBarModule;ZLandroid/app/Activity;)V

    invoke-static {v1}, Lcom/facebook/react/bridge/UiThreadUtil;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public setStyle(Ljava/lang/String;)V
    .locals 3
    .param p1, "style"    # Ljava/lang/String;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 171
    invoke-virtual {p0}, Lcom/facebook/react/modules/statusbar/StatusBarModule;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v0

    .line 172
    .local v0, "activity":Landroid/app/Activity;
    if-nez v0, :cond_1

    .line 173
    const-string v1, "ReactNative"

    const-string v2, "StatusBarModule: Ignored status bar change, current activity is null."

    invoke-static {v1, v2}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    :cond_0
    :goto_0
    return-void

    .line 177
    :cond_1
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x17

    if-lt v1, v2, :cond_0

    .line 178
    new-instance v1, Lcom/facebook/react/modules/statusbar/StatusBarModule$4;

    invoke-direct {v1, p0, v0, p1}, Lcom/facebook/react/modules/statusbar/StatusBarModule$4;-><init>(Lcom/facebook/react/modules/statusbar/StatusBarModule;Landroid/app/Activity;Ljava/lang/String;)V

    invoke-static {v1}, Lcom/facebook/react/bridge/UiThreadUtil;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public setTranslucent(Z)V
    .locals 3
    .param p1, "translucent"    # Z
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/facebook/react/modules/statusbar/StatusBarModule;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v0

    .line 111
    .local v0, "activity":Landroid/app/Activity;
    if-nez v0, :cond_1

    .line 112
    const-string v1, "ReactNative"

    const-string v2, "StatusBarModule: Ignored status bar change, current activity is null."

    invoke-static {v1, v2}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    :cond_0
    :goto_0
    return-void

    .line 116
    :cond_1
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x15

    if-lt v1, v2, :cond_0

    .line 117
    new-instance v1, Lcom/facebook/react/modules/statusbar/StatusBarModule$2;

    .line 118
    invoke-virtual {p0}, Lcom/facebook/react/modules/statusbar/StatusBarModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v2

    invoke-direct {v1, p0, v2, v0, p1}, Lcom/facebook/react/modules/statusbar/StatusBarModule$2;-><init>(Lcom/facebook/react/modules/statusbar/StatusBarModule;Lcom/facebook/react/bridge/ReactContext;Landroid/app/Activity;Z)V

    .line 117
    invoke-static {v1}, Lcom/facebook/react/bridge/UiThreadUtil;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
