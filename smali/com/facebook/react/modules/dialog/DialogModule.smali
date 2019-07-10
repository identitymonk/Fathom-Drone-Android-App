.class public Lcom/facebook/react/modules/dialog/DialogModule;
.super Lcom/facebook/react/bridge/ReactContextBaseJavaModule;
.source "DialogModule.java"

# interfaces
.implements Lcom/facebook/react/bridge/LifecycleEventListener;


# annotations
.annotation runtime Lcom/facebook/react/module/annotations/ReactModule;
    name = "DialogManagerAndroid"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/modules/dialog/DialogModule$AlertFragmentListener;,
        Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;
    }
.end annotation


# static fields
.field static final ACTION_BUTTON_CLICKED:Ljava/lang/String; = "buttonClicked"

.field static final ACTION_DISMISSED:Ljava/lang/String; = "dismissed"

.field static final CONSTANTS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field static final FRAGMENT_TAG:Ljava/lang/String; = "com.facebook.catalyst.react.dialog.DialogModule"

.field static final KEY_BUTTON_NEGATIVE:Ljava/lang/String; = "buttonNegative"

.field static final KEY_BUTTON_NEUTRAL:Ljava/lang/String; = "buttonNeutral"

.field static final KEY_BUTTON_POSITIVE:Ljava/lang/String; = "buttonPositive"

.field static final KEY_CANCELABLE:Ljava/lang/String; = "cancelable"

.field static final KEY_ITEMS:Ljava/lang/String; = "items"

.field static final KEY_MESSAGE:Ljava/lang/String; = "message"

.field static final KEY_TITLE:Ljava/lang/String; = "title"

.field static final NAME:Ljava/lang/String; = "DialogManagerAndroid"


# instance fields
.field private mIsInForeground:Z


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    .line 52
    const-string v0, "buttonClicked"

    const-string v1, "buttonClicked"

    const-string v2, "dismissed"

    const-string v3, "dismissed"

    const-string v4, "buttonPositive"

    const/4 v5, -0x1

    .line 55
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    const-string v6, "buttonNegative"

    const/4 v7, -0x2

    .line 56
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    const-string v8, "buttonNeutral"

    const/4 v9, -0x3

    .line 57
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    .line 52
    invoke-static/range {v0 .. v9}, Lcom/facebook/react/common/MapBuilder;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/facebook/react/modules/dialog/DialogModule;->CONSTANTS:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 0
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;

    .prologue
    .line 62
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/ReactContextBaseJavaModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V

    .line 63
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/modules/dialog/DialogModule;)Lcom/facebook/react/bridge/ReactApplicationContext;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/dialog/DialogModule;

    .prologue
    .line 35
    invoke-virtual {p0}, Lcom/facebook/react/modules/dialog/DialogModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/facebook/react/modules/dialog/DialogModule;)Lcom/facebook/react/bridge/ReactApplicationContext;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/dialog/DialogModule;

    .prologue
    .line 35
    invoke-virtual {p0}, Lcom/facebook/react/modules/dialog/DialogModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    return-object v0
.end method

.method private getFragmentManagerHelper()Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;
    .locals 3
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 267
    invoke-virtual {p0}, Lcom/facebook/react/modules/dialog/DialogModule;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v0

    .line 268
    .local v0, "activity":Landroid/app/Activity;
    if-nez v0, :cond_0

    .line 269
    const/4 v1, 0x0

    .line 274
    .end local v0    # "activity":Landroid/app/Activity;
    :goto_0
    return-object v1

    .line 271
    .restart local v0    # "activity":Landroid/app/Activity;
    :cond_0
    instance-of v1, v0, Landroid/support/v4/app/FragmentActivity;

    if-eqz v1, :cond_1

    .line 272
    new-instance v1, Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    .end local v0    # "activity":Landroid/app/Activity;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;-><init>(Lcom/facebook/react/modules/dialog/DialogModule;Landroid/support/v4/app/FragmentManager;)V

    goto :goto_0

    .line 274
    .restart local v0    # "activity":Landroid/app/Activity;
    :cond_1
    new-instance v1, Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;

    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;-><init>(Lcom/facebook/react/modules/dialog/DialogModule;Landroid/app/FragmentManager;)V

    goto :goto_0
.end method


# virtual methods
.method public getConstants()Ljava/util/Map;
    .locals 1
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

    .prologue
    .line 187
    sget-object v0, Lcom/facebook/react/modules/dialog/DialogModule;->CONSTANTS:Ljava/util/Map;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    const-string v0, "DialogManagerAndroid"

    return-object v0
.end method

.method public initialize()V
    .locals 1

    .prologue
    .line 192
    invoke-virtual {p0}, Lcom/facebook/react/modules/dialog/DialogModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/facebook/react/bridge/ReactApplicationContext;->addLifecycleEventListener(Lcom/facebook/react/bridge/LifecycleEventListener;)V

    .line 193
    return-void
.end method

.method public onHostDestroy()V
    .locals 0

    .prologue
    .line 203
    return-void
.end method

.method public onHostPause()V
    .locals 1

    .prologue
    .line 198
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/modules/dialog/DialogModule;->mIsInForeground:Z

    .line 199
    return-void
.end method

.method public onHostResume()V
    .locals 3

    .prologue
    .line 207
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/facebook/react/modules/dialog/DialogModule;->mIsInForeground:Z

    .line 209
    invoke-direct {p0}, Lcom/facebook/react/modules/dialog/DialogModule;->getFragmentManagerHelper()Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;

    move-result-object v0

    .line 210
    .local v0, "fragmentManagerHelper":Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;
    if-eqz v0, :cond_0

    .line 211
    invoke-virtual {v0}, Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;->showPendingAlert()V

    .line 215
    :goto_0
    return-void

    .line 213
    :cond_0
    const-class v1, Lcom/facebook/react/modules/dialog/DialogModule;

    const-string v2, "onHostResume called but no FragmentManager found"

    invoke-static {v1, v2}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/Class;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public showAlert(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;)V
    .locals 8
    .param p1, "options"    # Lcom/facebook/react/bridge/ReadableMap;
    .param p2, "errorCallback"    # Lcom/facebook/react/bridge/Callback;
    .param p3, "actionCallback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 222
    invoke-direct {p0}, Lcom/facebook/react/modules/dialog/DialogModule;->getFragmentManagerHelper()Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;

    move-result-object v1

    .line 223
    .local v1, "fragmentManagerHelper":Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;
    if-nez v1, :cond_0

    .line 224
    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "Tried to show an alert while not attached to an Activity"

    aput-object v7, v5, v6

    invoke-interface {p2, v5}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 257
    :goto_0
    return-void

    .line 228
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 229
    .local v0, "args":Landroid/os/Bundle;
    const-string v5, "title"

    invoke-interface {p1, v5}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 230
    const-string v5, "title"

    const-string v6, "title"

    invoke-interface {p1, v6}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    :cond_1
    const-string v5, "message"

    invoke-interface {p1, v5}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 233
    const-string v5, "message"

    const-string v6, "message"

    invoke-interface {p1, v6}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    :cond_2
    const-string v5, "buttonPositive"

    invoke-interface {p1, v5}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 236
    const-string v5, "button_positive"

    const-string v6, "buttonPositive"

    invoke-interface {p1, v6}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    :cond_3
    const-string v5, "buttonNegative"

    invoke-interface {p1, v5}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 239
    const-string v5, "button_negative"

    const-string v6, "buttonNegative"

    invoke-interface {p1, v6}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 241
    :cond_4
    const-string v5, "buttonNeutral"

    invoke-interface {p1, v5}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 242
    const-string v5, "button_neutral"

    const-string v6, "buttonNeutral"

    invoke-interface {p1, v6}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 244
    :cond_5
    const-string v5, "items"

    invoke-interface {p1, v5}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 245
    const-string v5, "items"

    invoke-interface {p1, v5}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v3

    .line 246
    .local v3, "items":Lcom/facebook/react/bridge/ReadableArray;
    invoke-interface {v3}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v5

    new-array v4, v5, [Ljava/lang/CharSequence;

    .line 247
    .local v4, "itemsArray":[Ljava/lang/CharSequence;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-interface {v3}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v5

    if-ge v2, v5, :cond_6

    .line 248
    invoke-interface {v3, v2}, Lcom/facebook/react/bridge/ReadableArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v2

    .line 247
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 250
    :cond_6
    const-string v5, "items"

    invoke-virtual {v0, v5, v4}, Landroid/os/Bundle;->putCharSequenceArray(Ljava/lang/String;[Ljava/lang/CharSequence;)V

    .line 252
    .end local v2    # "i":I
    .end local v3    # "items":Lcom/facebook/react/bridge/ReadableArray;
    .end local v4    # "itemsArray":[Ljava/lang/CharSequence;
    :cond_7
    const-string v5, "cancelable"

    invoke-interface {p1, v5}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 253
    const-string v5, "cancelable"

    const-string v6, "cancelable"

    invoke-interface {p1, v6}, Lcom/facebook/react/bridge/ReadableMap;->getBoolean(Ljava/lang/String;)Z

    move-result v6

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 256
    :cond_8
    iget-boolean v5, p0, Lcom/facebook/react/modules/dialog/DialogModule;->mIsInForeground:Z

    invoke-virtual {v1, v5, v0, p3}, Lcom/facebook/react/modules/dialog/DialogModule$FragmentManagerHelper;->showNewAlert(ZLandroid/os/Bundle;Lcom/facebook/react/bridge/Callback;)V

    goto/16 :goto_0
.end method
