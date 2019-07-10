.class public Lcom/facebook/react/devsupport/DevInternalSettings;
.super Ljava/lang/Object;
.source "DevInternalSettings.java"

# interfaces
.implements Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# annotations
.annotation build Lcom/facebook/react/common/annotations/VisibleForTesting;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/devsupport/DevInternalSettings$Listener;
    }
.end annotation


# static fields
.field private static final PREFS_ANIMATIONS_DEBUG_KEY:Ljava/lang/String; = "animations_debug"

.field private static final PREFS_FPS_DEBUG_KEY:Ljava/lang/String; = "fps_debug"

.field private static final PREFS_HOT_MODULE_REPLACEMENT_KEY:Ljava/lang/String; = "hot_module_replacement"

.field private static final PREFS_INSPECTOR_DEBUG_KEY:Ljava/lang/String; = "inspector_debug"

.field private static final PREFS_JS_DEV_MODE_DEBUG_KEY:Ljava/lang/String; = "js_dev_mode_debug"

.field private static final PREFS_JS_MINIFY_DEBUG_KEY:Ljava/lang/String; = "js_minify_debug"

.field private static final PREFS_RELOAD_ON_JS_CHANGE_KEY:Ljava/lang/String; = "reload_on_js_change"

.field private static final PREFS_REMOTE_JS_DEBUG_KEY:Ljava/lang/String; = "remote_js_debug"


# instance fields
.field private final mListener:Lcom/facebook/react/devsupport/DevInternalSettings$Listener;

.field private final mPackagerConnectionSettings:Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;

.field private final mPreferences:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/facebook/react/devsupport/DevInternalSettings$Listener;)V
    .locals 1
    .param p1, "applicationContext"    # Landroid/content/Context;
    .param p2, "listener"    # Lcom/facebook/react/devsupport/DevInternalSettings$Listener;

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p2, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mListener:Lcom/facebook/react/devsupport/DevInternalSettings$Listener;

    .line 49
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    .line 50
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0, p0}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 51
    new-instance v0, Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;

    invoke-direct {v0, p1}, Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPackagerConnectionSettings:Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;

    .line 52
    return-void
.end method


# virtual methods
.method public getPackagerConnectionSettings()Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPackagerConnectionSettings:Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;

    return-object v0
.end method

.method public isAnimationFpsDebugEnabled()Z
    .locals 3

    .prologue
    .line 69
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    const-string v1, "animations_debug"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isElementInspectorEnabled()Z
    .locals 3

    .prologue
    .line 110
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    const-string v1, "inspector_debug"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isFpsDebugEnabled()Z
    .locals 3

    .prologue
    .line 60
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    const-string v1, "fps_debug"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isHotModuleReplacementEnabled()Z
    .locals 3

    .prologue
    .line 94
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    const-string v1, "hot_module_replacement"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isJSDevModeEnabled()Z
    .locals 3

    .prologue
    .line 74
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    const-string v1, "js_dev_mode_debug"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isJSMinifyEnabled()Z
    .locals 3

    .prologue
    .line 79
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    const-string v1, "js_minify_debug"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isReloadOnJSChangeEnabled()Z
    .locals 3

    .prologue
    .line 102
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    const-string v1, "reload_on_js_change"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isRemoteJSDebugEnabled()Z
    .locals 3

    .prologue
    .line 119
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    const-string v1, "remote_js_debug"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 1
    .param p1, "sharedPreferences"    # Landroid/content/SharedPreferences;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mListener:Lcom/facebook/react/devsupport/DevInternalSettings$Listener;

    if-eqz v0, :cond_1

    .line 84
    const-string v0, "fps_debug"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "reload_on_js_change"

    .line 85
    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "js_dev_mode_debug"

    .line 86
    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "js_minify_debug"

    .line 87
    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 88
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mListener:Lcom/facebook/react/devsupport/DevInternalSettings$Listener;

    invoke-interface {v0}, Lcom/facebook/react/devsupport/DevInternalSettings$Listener;->onInternalSettingsChanged()V

    .line 91
    :cond_1
    return-void
.end method

.method public setElementInspectorEnabled(Z)V
    .locals 2
    .param p1, "enabled"    # Z

    .prologue
    .line 114
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "inspector_debug"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 115
    return-void
.end method

.method public setFpsDebugEnabled(Z)V
    .locals 2
    .param p1, "enabled"    # Z

    .prologue
    .line 64
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "fps_debug"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 65
    return-void
.end method

.method public setHotModuleReplacementEnabled(Z)V
    .locals 2
    .param p1, "enabled"    # Z

    .prologue
    .line 98
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "hot_module_replacement"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 99
    return-void
.end method

.method public setReloadOnJSChangeEnabled(Z)V
    .locals 2
    .param p1, "enabled"    # Z

    .prologue
    .line 106
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "reload_on_js_change"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 107
    return-void
.end method

.method public setRemoteJSDebugEnabled(Z)V
    .locals 2
    .param p1, "remoteJSDebugEnabled"    # Z

    .prologue
    .line 124
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevInternalSettings;->mPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "remote_js_debug"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 125
    return-void
.end method
