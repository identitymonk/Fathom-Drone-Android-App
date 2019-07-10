.class public Lcom/brynk/fathom/helpers/Constants;
.super Ljava/lang/Object;
.source "Constants.java"


# static fields
.field public static final DEBUG_TAG:Ljava/lang/String; = "FATHOM1"

.field public static final DEFAULT_PITCH_MOD_PERCENT:Ljava/lang/Float;

.field public static final DEFAULT_THROTTLE_MOD_PERCENT:Ljava/lang/Float;

.field public static final HOME_NETWORK_NAME:Ljava/lang/String; = "ATT7DJQpi2"

.field public static final NETWORK_NAME:Ljava/lang/String; = "Fathom"

.field public static final PREFS:Ljava/lang/String; = "FATHOM_PREFS"

.field public static final PREFS_DRONE_IP:Ljava/lang/String; = "drone_ip"

.field public static final PREFS_INVERT:Ljava/lang/String; = "fathom_should_invert"

.field public static final PREFS_PITCH_MOD:Ljava/lang/String; = "pitch_mod"

.field public static final PREFS_TEMPERATURE_CUTOFF:Ljava/lang/String; = "temperature_cutoff"

.field public static final PREFS_THROTTLE_MOD:Ljava/lang/String; = "throttle_mod"

.field public static final SERVO_MAX:Ljava/lang/Float;

.field public static final SERVO_MIN:Ljava/lang/Float;

.field public static final SERVO_NEUTRAL:Ljava/lang/Float;

.field public static final TEST_NETWORK_NAME:Ljava/lang/String; = "ALFA"

.field public static final TEST_NETWORK_NAME_TWO:Ljava/lang/String; = "GR Makers"


# instance fields
.field private DEFAULT_DRONE_IP:Ljava/lang/String;

.field private DEFAULT_TEMPERATURE_CUTOFF:Ljava/lang/String;

.field private MOCK_DRONE_IP:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    const v0, 0x440fc000    # 575.0f

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    sput-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_MAX:Ljava/lang/Float;

    .line 32
    const/high16 v0, 0x432f0000    # 175.0f

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    sput-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_MIN:Ljava/lang/Float;

    .line 33
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_MAX:Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    sget-object v1, Lcom/brynk/fathom/helpers/Constants;->SERVO_MIN:Ljava/lang/Float;

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v1

    add-float/2addr v0, v1

    const/high16 v1, 0x40000000    # 2.0f

    div-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    sput-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    .line 35
    const v0, 0x3dcccccd    # 0.1f

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    sput-object v0, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_THROTTLE_MOD_PERCENT:Ljava/lang/Float;

    .line 36
    const v0, 0x3e19999a    # 0.15f

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    sput-object v0, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_PITCH_MOD_PERCENT:Ljava/lang/Float;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    const-string v0, "192.168.2.10"

    iput-object v0, p0, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_DRONE_IP:Ljava/lang/String;

    .line 13
    const-string v0, "172.16.50.116"

    iput-object v0, p0, Lcom/brynk/fathom/helpers/Constants;->MOCK_DRONE_IP:Ljava/lang/String;

    .line 14
    const-string v0, "37"

    iput-object v0, p0, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_TEMPERATURE_CUTOFF:Ljava/lang/String;

    return-void
.end method

.method private buildEditor(Landroid/content/Context;)Landroid/content/SharedPreferences$Editor;
    .locals 2
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 138
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 139
    .local v1, "settings":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 140
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    return-object v0
.end method


# virtual methods
.method public getDroneIp(Landroid/content/Context;)Ljava/lang/String;
    .locals 4
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 41
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 42
    .local v1, "settings":Landroid/content/SharedPreferences;
    const-string v2, "drone_ip"

    const-string v3, "-1"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 43
    .local v0, "drone_ip":Ljava/lang/String;
    const-string v2, "-1"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 44
    iget-object v2, p0, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_DRONE_IP:Ljava/lang/String;

    invoke-virtual {p0, p1, v2}, Lcom/brynk/fathom/helpers/Constants;->setDroneIp(Landroid/content/Context;Ljava/lang/String;)V

    .line 45
    iget-object v0, p0, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_DRONE_IP:Ljava/lang/String;

    .line 51
    .end local v0    # "drone_ip":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v0

    .line 46
    .restart local v0    # "drone_ip":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/brynk/fathom/helpers/Constants;->MOCK_DRONE_IP:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0
.end method

.method public getMockDroneIp(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/brynk/fathom/helpers/Constants;->MOCK_DRONE_IP:Ljava/lang/String;

    return-object v0
.end method

.method public getPITCH_MOD_PERCENT(Landroid/content/Context;)Ljava/lang/Float;
    .locals 4
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    const/high16 v3, -0x40800000    # -1.0f

    .line 102
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 103
    .local v1, "settings":Landroid/content/SharedPreferences;
    const-string v2, "pitch_mod"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 104
    .local v0, "pitch_mod":Ljava/lang/Float;
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v2

    cmpl-float v2, v2, v3

    if-nez v2, :cond_0

    .line 105
    sget-object v2, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_PITCH_MOD_PERCENT:Ljava/lang/Float;

    invoke-virtual {p0, p1, v2}, Lcom/brynk/fathom/helpers/Constants;->setPITCH_MOD_PERCENT(Landroid/content/Context;Ljava/lang/Float;)V

    .line 106
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_PITCH_MOD_PERCENT:Ljava/lang/Float;

    .line 108
    .end local v0    # "pitch_mod":Ljava/lang/Float;
    :cond_0
    return-object v0
.end method

.method public getPrefsInvert(Landroid/content/Context;)Ljava/lang/Boolean;
    .locals 4
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 84
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 85
    .local v0, "settings":Landroid/content/SharedPreferences;
    const-string v2, "fathom_should_invert"

    const/high16 v3, -0x40800000    # -1.0f

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 87
    .local v1, "should_invert_raw":Ljava/lang/Float;
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v2

    const/high16 v3, 0x3f800000    # 1.0f

    cmpg-float v2, v2, v3

    if-gez v2, :cond_0

    .line 88
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {p0, p1, v2}, Lcom/brynk/fathom/helpers/Constants;->setPrefsInvert(Landroid/content/Context;Ljava/lang/Float;)V

    .line 89
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 91
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    goto :goto_0
.end method

.method public getTHROTTLE_MOD_PERCENT(Landroid/content/Context;)Ljava/lang/Float;
    .locals 4
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    const/high16 v3, -0x40800000    # -1.0f

    .line 121
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 122
    .local v0, "settings":Landroid/content/SharedPreferences;
    const-string v2, "throttle_mod"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 123
    .local v1, "throttle_mod":Ljava/lang/Float;
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v2

    cmpl-float v2, v2, v3

    if-nez v2, :cond_0

    .line 124
    sget-object v2, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_THROTTLE_MOD_PERCENT:Ljava/lang/Float;

    invoke-virtual {p0, p1, v2}, Lcom/brynk/fathom/helpers/Constants;->setTHROTTLE_MOD_PERCENT(Landroid/content/Context;Ljava/lang/Float;)V

    .line 125
    sget-object v1, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_THROTTLE_MOD_PERCENT:Ljava/lang/Float;

    .line 127
    .end local v1    # "throttle_mod":Ljava/lang/Float;
    :cond_0
    return-object v1
.end method

.method public getTemperatureCutoff(Landroid/content/Context;)Ljava/lang/String;
    .locals 4
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 56
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 57
    .local v0, "settings":Landroid/content/SharedPreferences;
    const-string v2, "temperature_cutoff"

    const-string v3, "-1"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 58
    .local v1, "temperature_cutoff":Ljava/lang/String;
    const-string v2, "-1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 59
    iget-object v2, p0, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_TEMPERATURE_CUTOFF:Ljava/lang/String;

    invoke-virtual {p0, p1, v2}, Lcom/brynk/fathom/helpers/Constants;->setTemperatureCutoff(Landroid/content/Context;Ljava/lang/String;)V

    .line 60
    iget-object v1, p0, Lcom/brynk/fathom/helpers/Constants;->DEFAULT_TEMPERATURE_CUTOFF:Ljava/lang/String;

    .line 62
    .end local v1    # "temperature_cutoff":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method public setDroneIp(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "ip"    # Ljava/lang/String;

    .prologue
    .line 70
    invoke-direct {p0, p1}, Lcom/brynk/fathom/helpers/Constants;->buildEditor(Landroid/content/Context;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 71
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "drone_ip"

    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 72
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 74
    return-void
.end method

.method public setPITCH_MOD_PERCENT(Landroid/content/Context;Ljava/lang/Float;)V
    .locals 3
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "val"    # Ljava/lang/Float;

    .prologue
    .line 113
    invoke-direct {p0, p1}, Lcom/brynk/fathom/helpers/Constants;->buildEditor(Landroid/content/Context;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 114
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pitch_mod"

    invoke-virtual {p2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;

    .line 115
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 119
    return-void
.end method

.method public setPrefsInvert(Landroid/content/Context;Ljava/lang/Float;)V
    .locals 3
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "shouldInvert"    # Ljava/lang/Float;

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/brynk/fathom/helpers/Constants;->buildEditor(Landroid/content/Context;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 96
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "fathom_should_invert"

    invoke-virtual {p2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;

    .line 97
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 98
    return-void
.end method

.method public setTHROTTLE_MOD_PERCENT(Landroid/content/Context;Ljava/lang/Float;)V
    .locals 3
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "val"    # Ljava/lang/Float;

    .prologue
    .line 132
    invoke-direct {p0, p1}, Lcom/brynk/fathom/helpers/Constants;->buildEditor(Landroid/content/Context;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 133
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "throttle_mod"

    invoke-virtual {p2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;

    .line 134
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 135
    return-void
.end method

.method public setTemperatureCutoff(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "cutoff"    # Ljava/lang/String;

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/brynk/fathom/helpers/Constants;->buildEditor(Landroid/content/Context;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 77
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "temperature_cutoff"

    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 78
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 80
    return-void
.end method
