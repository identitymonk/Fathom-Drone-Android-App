.class public Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;
.super Lcom/facebook/react/bridge/ReactContextBaseJavaModule;
.source "TimePickerDialogModule.java"


# annotations
.annotation runtime Lcom/facebook/react/module/annotations/ReactModule;
    name = "TimePickerAndroid"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;
    }
.end annotation


# static fields
.field static final ACTION_DISMISSED:Ljava/lang/String; = "dismissedAction"

.field static final ACTION_TIME_SET:Ljava/lang/String; = "timeSetAction"

.field static final ARG_HOUR:Ljava/lang/String; = "hour"

.field static final ARG_IS24HOUR:Ljava/lang/String; = "is24Hour"

.field static final ARG_MINUTE:Ljava/lang/String; = "minute"

.field static final ARG_MODE:Ljava/lang/String; = "mode"

.field private static final ERROR_NO_ACTIVITY:Ljava/lang/String; = "E_NO_ACTIVITY"

.field public static final FRAGMENT_TAG:Ljava/lang/String; = "TimePickerAndroid"
    .annotation build Lcom/facebook/react/common/annotations/VisibleForTesting;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 0
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;

    .prologue
    .line 54
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/ReactContextBaseJavaModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V

    .line 55
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;)Lcom/facebook/react/bridge/ReactApplicationContext;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;

    .prologue
    .line 39
    invoke-virtual {p0}, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;)Lcom/facebook/react/bridge/ReactApplicationContext;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;

    .prologue
    .line 39
    invoke-virtual {p0}, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    return-object v0
.end method

.method private createFragmentArguments(Lcom/facebook/react/bridge/ReadableMap;)Landroid/os/Bundle;
    .locals 3
    .param p1, "options"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 142
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 143
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "hour"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "hour"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 144
    const-string v1, "hour"

    const-string v2, "hour"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 146
    :cond_0
    const-string v1, "minute"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v1, "minute"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 147
    const-string v1, "minute"

    const-string v2, "minute"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 149
    :cond_1
    const-string v1, "is24Hour"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "is24Hour"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 150
    const-string v1, "is24Hour"

    const-string v2, "is24Hour"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 152
    :cond_2
    const-string v1, "mode"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string v1, "mode"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 153
    const-string v1, "mode"

    const-string v2, "mode"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    :cond_3
    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    const-string v0, "TimePickerAndroid"

    return-object v0
.end method

.method public open(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/bridge/Promise;)V
    .locals 8
    .param p1, "options"    # Lcom/facebook/react/bridge/ReadableMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p2, "promise"    # Lcom/facebook/react/bridge/Promise;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 97
    invoke-virtual {p0}, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v0

    .line 98
    .local v0, "activity":Landroid/app/Activity;
    if-nez v0, :cond_0

    .line 99
    const-string v6, "E_NO_ACTIVITY"

    const-string v7, "Tried to open a TimePicker dialog while not attached to an Activity"

    invoke-interface {p2, v6, v7}, Lcom/facebook/react/bridge/Promise;->reject(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    .end local v0    # "activity":Landroid/app/Activity;
    :goto_0
    return-void

    .line 106
    .restart local v0    # "activity":Landroid/app/Activity;
    :cond_0
    instance-of v6, v0, Landroid/support/v4/app/FragmentActivity;

    if-eqz v6, :cond_3

    .line 107
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    .line 108
    .end local v0    # "activity":Landroid/app/Activity;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    .line 109
    .local v3, "fragmentManager":Landroid/support/v4/app/FragmentManager;
    const-string v6, "TimePickerAndroid"

    .line 110
    invoke-virtual {v3, v6}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v5

    check-cast v5, Landroid/support/v4/app/DialogFragment;

    .line 111
    .local v5, "oldFragment":Landroid/support/v4/app/DialogFragment;
    if-eqz v5, :cond_1

    .line 112
    invoke-virtual {v5}, Landroid/support/v4/app/DialogFragment;->dismiss()V

    .line 114
    :cond_1
    new-instance v2, Lcom/facebook/react/modules/timepicker/SupportTimePickerDialogFragment;

    invoke-direct {v2}, Lcom/facebook/react/modules/timepicker/SupportTimePickerDialogFragment;-><init>()V

    .line 115
    .local v2, "fragment":Lcom/facebook/react/modules/timepicker/SupportTimePickerDialogFragment;
    if-eqz p1, :cond_2

    .line 116
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;->createFragmentArguments(Lcom/facebook/react/bridge/ReadableMap;)Landroid/os/Bundle;

    move-result-object v1

    .line 117
    .local v1, "args":Landroid/os/Bundle;
    invoke-virtual {v2, v1}, Lcom/facebook/react/modules/timepicker/SupportTimePickerDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 119
    .end local v1    # "args":Landroid/os/Bundle;
    :cond_2
    new-instance v4, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;

    invoke-direct {v4, p0, p2}, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;-><init>(Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;Lcom/facebook/react/bridge/Promise;)V

    .line 120
    .local v4, "listener":Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;
    invoke-virtual {v2, v4}, Lcom/facebook/react/modules/timepicker/SupportTimePickerDialogFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 121
    invoke-virtual {v2, v4}, Lcom/facebook/react/modules/timepicker/SupportTimePickerDialogFragment;->setOnTimeSetListener(Landroid/app/TimePickerDialog$OnTimeSetListener;)V

    .line 122
    const-string v6, "TimePickerAndroid"

    invoke-virtual {v2, v3, v6}, Lcom/facebook/react/modules/timepicker/SupportTimePickerDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0

    .line 124
    .end local v2    # "fragment":Lcom/facebook/react/modules/timepicker/SupportTimePickerDialogFragment;
    .end local v3    # "fragmentManager":Landroid/support/v4/app/FragmentManager;
    .end local v4    # "listener":Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;
    .end local v5    # "oldFragment":Landroid/support/v4/app/DialogFragment;
    .restart local v0    # "activity":Landroid/app/Activity;
    :cond_3
    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v3

    .line 125
    .local v3, "fragmentManager":Landroid/app/FragmentManager;
    const-string v6, "TimePickerAndroid"

    invoke-virtual {v3, v6}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v5

    check-cast v5, Landroid/app/DialogFragment;

    .line 126
    .local v5, "oldFragment":Landroid/app/DialogFragment;
    if-eqz v5, :cond_4

    .line 127
    invoke-virtual {v5}, Landroid/app/DialogFragment;->dismiss()V

    .line 129
    :cond_4
    new-instance v2, Lcom/facebook/react/modules/timepicker/TimePickerDialogFragment;

    invoke-direct {v2}, Lcom/facebook/react/modules/timepicker/TimePickerDialogFragment;-><init>()V

    .line 130
    .local v2, "fragment":Lcom/facebook/react/modules/timepicker/TimePickerDialogFragment;
    if-eqz p1, :cond_5

    .line 131
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;->createFragmentArguments(Lcom/facebook/react/bridge/ReadableMap;)Landroid/os/Bundle;

    move-result-object v1

    .line 132
    .restart local v1    # "args":Landroid/os/Bundle;
    invoke-virtual {v2, v1}, Lcom/facebook/react/modules/timepicker/TimePickerDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 134
    .end local v1    # "args":Landroid/os/Bundle;
    :cond_5
    new-instance v4, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;

    invoke-direct {v4, p0, p2}, Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;-><init>(Lcom/facebook/react/modules/timepicker/TimePickerDialogModule;Lcom/facebook/react/bridge/Promise;)V

    .line 135
    .restart local v4    # "listener":Lcom/facebook/react/modules/timepicker/TimePickerDialogModule$TimePickerDialogListener;
    invoke-virtual {v2, v4}, Lcom/facebook/react/modules/timepicker/TimePickerDialogFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 136
    invoke-virtual {v2, v4}, Lcom/facebook/react/modules/timepicker/TimePickerDialogFragment;->setOnTimeSetListener(Landroid/app/TimePickerDialog$OnTimeSetListener;)V

    .line 137
    const-string v6, "TimePickerAndroid"

    invoke-virtual {v2, v3, v6}, Lcom/facebook/react/modules/timepicker/TimePickerDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0
.end method
