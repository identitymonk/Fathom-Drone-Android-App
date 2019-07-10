.class public Lcom/facebook/react/modules/i18nmanager/I18nUtil;
.super Ljava/lang/Object;
.source "I18nUtil.java"


# static fields
.field private static final KEY_FOR_PREFS_ALLOWRTL:Ljava/lang/String; = "RCTI18nUtil_allowRTL"

.field private static final KEY_FOR_PREFS_FORCERTL:Ljava/lang/String; = "RCTI18nUtil_forceRTL"

.field private static final SHARED_PREFS_NAME:Ljava/lang/String; = "com.facebook.react.modules.i18nmanager.I18nUtil"

.field private static sharedI18nUtilInstance:Lcom/facebook/react/modules/i18nmanager/I18nUtil;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    sput-object v0, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->sharedI18nUtilInstance:Lcom/facebook/react/modules/i18nmanager/I18nUtil;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    return-void
.end method

.method public static getInstance()Lcom/facebook/react/modules/i18nmanager/I18nUtil;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->sharedI18nUtilInstance:Lcom/facebook/react/modules/i18nmanager/I18nUtil;

    if-nez v0, :cond_0

    .line 36
    new-instance v0, Lcom/facebook/react/modules/i18nmanager/I18nUtil;

    invoke-direct {v0}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;-><init>()V

    sput-object v0, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->sharedI18nUtilInstance:Lcom/facebook/react/modules/i18nmanager/I18nUtil;

    .line 38
    :cond_0
    sget-object v0, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->sharedI18nUtilInstance:Lcom/facebook/react/modules/i18nmanager/I18nUtil;

    return-object v0
.end method

.method private isDevicePreferredLanguageRTL()Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 83
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v4/text/TextUtilsCompat;->getLayoutDirectionFromLocale(Ljava/util/Locale;)I

    move-result v0

    .line 84
    .local v0, "directionality":I
    if-ne v0, v1, :cond_0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private isPrefSet(Landroid/content/Context;Ljava/lang/String;Z)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "defaultValue"    # Z

    .prologue
    .line 88
    const-string v1, "com.facebook.react.modules.i18nmanager.I18nUtil"

    const/4 v2, 0x0

    .line 89
    invoke-virtual {p1, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 90
    .local v0, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v0, p2, p3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    return v1
.end method

.method private isRTLAllowed(Landroid/content/Context;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 61
    const-string v0, "RCTI18nUtil_allowRTL"

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->isPrefSet(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method private isRTLForced(Landroid/content/Context;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 73
    const-string v0, "RCTI18nUtil_forceRTL"

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->isPrefSet(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method private setPref(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Z

    .prologue
    .line 94
    const-string v1, "com.facebook.react.modules.i18nmanager.I18nUtil"

    const/4 v2, 0x0

    .line 95
    invoke-virtual {p1, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 96
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p2, p3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 97
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 98
    return-void
.end method


# virtual methods
.method public allowRTL(Landroid/content/Context;Z)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "allowRTL"    # Z

    .prologue
    .line 65
    const-string v0, "RCTI18nUtil_allowRTL"

    invoke-direct {p0, p1, v0, p2}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->setPref(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 66
    return-void
.end method

.method public forceRTL(Landroid/content/Context;Z)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "forceRTL"    # Z

    .prologue
    .line 77
    const-string v0, "RCTI18nUtil_forceRTL"

    invoke-direct {p0, p1, v0, p2}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->setPref(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 78
    return-void
.end method

.method public isRTL(Landroid/content/Context;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x1

    .line 48
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->isRTLForced(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 52
    :cond_0
    :goto_0
    return v0

    .line 51
    :cond_1
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->isRTLAllowed(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 52
    invoke-direct {p0}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->isDevicePreferredLanguageRTL()Z

    move-result v1

    if-nez v1, :cond_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
