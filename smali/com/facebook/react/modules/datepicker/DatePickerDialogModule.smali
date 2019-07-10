.class public Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;
.super Lcom/facebook/react/bridge/ReactContextBaseJavaModule;
.source "DatePickerDialogModule.java"


# annotations
.annotation runtime Lcom/facebook/react/module/annotations/ReactModule;
    name = "DatePickerAndroid"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/modules/datepicker/DatePickerDialogModule$DatePickerDialogListener;
    }
.end annotation


# static fields
.field static final ACTION_DATE_SET:Ljava/lang/String; = "dateSetAction"

.field static final ACTION_DISMISSED:Ljava/lang/String; = "dismissedAction"

.field static final ARG_DATE:Ljava/lang/String; = "date"

.field static final ARG_MAXDATE:Ljava/lang/String; = "maxDate"

.field static final ARG_MINDATE:Ljava/lang/String; = "minDate"

.field static final ARG_MODE:Ljava/lang/String; = "mode"

.field private static final ERROR_NO_ACTIVITY:Ljava/lang/String; = "E_NO_ACTIVITY"

.field public static final FRAGMENT_TAG:Ljava/lang/String; = "DatePickerAndroid"
    .annotation build Lcom/facebook/react/common/annotations/VisibleForTesting;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 0
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/ReactContextBaseJavaModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V

    .line 58
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;)Lcom/facebook/react/bridge/ReactApplicationContext;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;)Lcom/facebook/react/bridge/ReactApplicationContext;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    return-object v0
.end method

.method private createFragmentArguments(Lcom/facebook/react/bridge/ReadableMap;)Landroid/os/Bundle;
    .locals 4
    .param p1, "options"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 170
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 171
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "date"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "date"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 172
    const-string v1, "date"

    const-string v2, "date"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 174
    :cond_0
    const-string v1, "minDate"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v1, "minDate"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 175
    const-string v1, "minDate"

    const-string v2, "minDate"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 177
    :cond_1
    const-string v1, "maxDate"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "maxDate"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 178
    const-string v1, "maxDate"

    const-string v2, "maxDate"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 180
    :cond_2
    const-string v1, "mode"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string v1, "mode"

    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 181
    const-string v1, "mode"

    const-string v2, "mode"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    :cond_3
    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    const-string v0, "DatePickerAndroid"

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
    .line 125
    invoke-virtual {p0}, Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v0

    .line 126
    .local v0, "activity":Landroid/app/Activity;
    if-nez v0, :cond_0

    .line 127
    const-string v6, "E_NO_ACTIVITY"

    const-string v7, "Tried to open a DatePicker dialog while not attached to an Activity"

    invoke-interface {p2, v6, v7}, Lcom/facebook/react/bridge/Promise;->reject(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    .end local v0    # "activity":Landroid/app/Activity;
    :goto_0
    return-void

    .line 134
    .restart local v0    # "activity":Landroid/app/Activity;
    :cond_0
    instance-of v6, v0, Landroid/support/v4/app/FragmentActivity;

    if-eqz v6, :cond_3

    .line 135
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    .line 136
    .end local v0    # "activity":Landroid/app/Activity;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    .line 137
    .local v3, "fragmentManager":Landroid/support/v4/app/FragmentManager;
    const-string v6, "DatePickerAndroid"

    .line 138
    invoke-virtual {v3, v6}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v5

    check-cast v5, Landroid/support/v4/app/DialogFragment;

    .line 139
    .local v5, "oldFragment":Landroid/support/v4/app/DialogFragment;
    if-eqz v5, :cond_1

    .line 140
    invoke-virtual {v5}, Landroid/support/v4/app/DialogFragment;->dismiss()V

    .line 142
    :cond_1
    new-instance v2, Lcom/facebook/react/modules/datepicker/SupportDatePickerDialogFragment;

    invoke-direct {v2}, Lcom/facebook/react/modules/datepicker/SupportDatePickerDialogFragment;-><init>()V

    .line 143
    .local v2, "fragment":Lcom/facebook/react/modules/datepicker/SupportDatePickerDialogFragment;
    if-eqz p1, :cond_2

    .line 144
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;->createFragmentArguments(Lcom/facebook/react/bridge/ReadableMap;)Landroid/os/Bundle;

    move-result-object v1

    .line 145
    .local v1, "args":Landroid/os/Bundle;
    invoke-virtual {v2, v1}, Lcom/facebook/react/modules/datepicker/SupportDatePickerDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 147
    .end local v1    # "args":Landroid/os/Bundle;
    :cond_2
    new-instance v4, Lcom/facebook/react/modules/datepicker/DatePickerDialogModule$DatePickerDialogListener;

    invoke-direct {v4, p0, p2}, Lcom/facebook/react/modules/datepicker/DatePickerDialogModule$DatePickerDialogListener;-><init>(Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;Lcom/facebook/react/bridge/Promise;)V

    .line 148
    .local v4, "listener":Lcom/facebook/react/modules/datepicker/DatePickerDialogModule$DatePickerDialogListener;
    invoke-virtual {v2, v4}, Lcom/facebook/react/modules/datepicker/SupportDatePickerDialogFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 149
    invoke-virtual {v2, v4}, Lcom/facebook/react/modules/datepicker/SupportDatePickerDialogFragment;->setOnDateSetListener(Landroid/app/DatePickerDialog$OnDateSetListener;)V

    .line 150
    const-string v6, "DatePickerAndroid"

    invoke-virtual {v2, v3, v6}, Lcom/facebook/react/modules/datepicker/SupportDatePickerDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0

    .line 152
    .end local v2    # "fragment":Lcom/facebook/react/modules/datepicker/SupportDatePickerDialogFragment;
    .end local v3    # "fragmentManager":Landroid/support/v4/app/FragmentManager;
    .end local v4    # "listener":Lcom/facebook/react/modules/datepicker/DatePickerDialogModule$DatePickerDialogListener;
    .end local v5    # "oldFragment":Landroid/support/v4/app/DialogFragment;
    .restart local v0    # "activity":Landroid/app/Activity;
    :cond_3
    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v3

    .line 153
    .local v3, "fragmentManager":Landroid/app/FragmentManager;
    const-string v6, "DatePickerAndroid"

    invoke-virtual {v3, v6}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v5

    check-cast v5, Landroid/app/DialogFragment;

    .line 154
    .local v5, "oldFragment":Landroid/app/DialogFragment;
    if-eqz v5, :cond_4

    .line 155
    invoke-virtual {v5}, Landroid/app/DialogFragment;->dismiss()V

    .line 157
    :cond_4
    new-instance v2, Lcom/facebook/react/modules/datepicker/DatePickerDialogFragment;

    invoke-direct {v2}, Lcom/facebook/react/modules/datepicker/DatePickerDialogFragment;-><init>()V

    .line 158
    .local v2, "fragment":Lcom/facebook/react/modules/datepicker/DatePickerDialogFragment;
    if-eqz p1, :cond_5

    .line 159
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;->createFragmentArguments(Lcom/facebook/react/bridge/ReadableMap;)Landroid/os/Bundle;

    move-result-object v1

    .line 160
    .restart local v1    # "args":Landroid/os/Bundle;
    invoke-virtual {v2, v1}, Lcom/facebook/react/modules/datepicker/DatePickerDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 162
    .end local v1    # "args":Landroid/os/Bundle;
    :cond_5
    new-instance v4, Lcom/facebook/react/modules/datepicker/DatePickerDialogModule$DatePickerDialogListener;

    invoke-direct {v4, p0, p2}, Lcom/facebook/react/modules/datepicker/DatePickerDialogModule$DatePickerDialogListener;-><init>(Lcom/facebook/react/modules/datepicker/DatePickerDialogModule;Lcom/facebook/react/bridge/Promise;)V

    .line 163
    .restart local v4    # "listener":Lcom/facebook/react/modules/datepicker/DatePickerDialogModule$DatePickerDialogListener;
    invoke-virtual {v2, v4}, Lcom/facebook/react/modules/datepicker/DatePickerDialogFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 164
    invoke-virtual {v2, v4}, Lcom/facebook/react/modules/datepicker/DatePickerDialogFragment;->setOnDateSetListener(Landroid/app/DatePickerDialog$OnDateSetListener;)V

    .line 165
    const-string v6, "DatePickerAndroid"

    invoke-virtual {v2, v3, v6}, Lcom/facebook/react/modules/datepicker/DatePickerDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0
.end method
