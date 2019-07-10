.class public Lcom/brynk/fathom/controllers/ReactObserverActivity;
.super Landroid/app/Activity;
.source "ReactObserverActivity.java"

# interfaces
.implements Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/ReactObserverActivity$DebugExampleThreeFragment;
    }
.end annotation


# static fields
.field public static OVERLAY_PERMISSION_REQ_CODE:I


# instance fields
.field private mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

.field private mReactRootView:Lcom/facebook/react/ReactRootView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    const/16 v0, 0x4d2

    sput v0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->OVERLAY_PERMISSION_REQ_CODE:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 193
    return-void
.end method


# virtual methods
.method public invokeDefaultOnBackPressed()V
    .locals 0

    .prologue
    .line 147
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 148
    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 127
    sget v0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->OVERLAY_PERMISSION_REQ_CODE:I

    if-ne p1, v0, :cond_0

    .line 128
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    .line 129
    invoke-static {p0}, Landroid/provider/Settings;->canDrawOverlays(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 134
    :cond_0
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 178
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0}, Lcom/facebook/react/ReactInstanceManager;->onBackPressed()V

    .line 182
    :goto_0
    return-void

    .line 180
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 10
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v7, 0x400

    const/4 v9, -0x1

    .line 70
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 73
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactObserverActivity;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6, v7, v7}, Landroid/view/Window;->setFlags(II)V

    .line 76
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 77
    .local v1, "dataForReact":Landroid/os/Bundle;
    const-string v6, "drone_ip"

    new-instance v7, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v7}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactObserverActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    new-instance v6, Lcom/facebook/react/ReactRootView;

    invoke-direct {v6, p0}, Lcom/facebook/react/ReactRootView;-><init>(Landroid/content/Context;)V

    iput-object v6, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactRootView:Lcom/facebook/react/ReactRootView;

    .line 79
    invoke-static {}, Lcom/facebook/react/ReactInstanceManager;->builder()Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v6

    .line 80
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactObserverActivity;->getApplication()Landroid/app/Application;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/facebook/react/ReactInstanceManagerBuilder;->setApplication(Landroid/app/Application;)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v6

    const-string v7, "index.android.bundle"

    .line 81
    invoke-virtual {v6, v7}, Lcom/facebook/react/ReactInstanceManagerBuilder;->setBundleAssetName(Ljava/lang/String;)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v6

    new-instance v7, Lcom/facebook/react/shell/MainReactPackage;

    invoke-direct {v7}, Lcom/facebook/react/shell/MainReactPackage;-><init>()V

    .line 83
    invoke-virtual {v6, v7}, Lcom/facebook/react/ReactInstanceManagerBuilder;->addPackage(Lcom/facebook/react/ReactPackage;)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v6

    const/4 v7, 0x0

    .line 85
    invoke-virtual {v6, v7}, Lcom/facebook/react/ReactInstanceManagerBuilder;->setUseDeveloperSupport(Z)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v6

    sget-object v7, Lcom/facebook/react/common/LifecycleState;->RESUMED:Lcom/facebook/react/common/LifecycleState;

    .line 86
    invoke-virtual {v6, v7}, Lcom/facebook/react/ReactInstanceManagerBuilder;->setInitialLifecycleState(Lcom/facebook/react/common/LifecycleState;)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v6

    .line 87
    invoke-virtual {v6}, Lcom/facebook/react/ReactInstanceManagerBuilder;->build()Lcom/facebook/react/ReactInstanceManager;

    move-result-object v6

    iput-object v6, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    .line 88
    iget-object v6, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactRootView:Lcom/facebook/react/ReactRootView;

    iget-object v7, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    const-string v8, "HelloWorld"

    invoke-virtual {v6, v7, v8, v1}, Lcom/facebook/react/ReactRootView;->startReactApplication(Lcom/facebook/react/ReactInstanceManager;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 91
    new-instance v2, Landroid/widget/FrameLayout;

    invoke-direct {v2, p0}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 92
    .local v2, "frame":Landroid/widget/FrameLayout;
    const v6, 0x7f0f00a4

    invoke-virtual {v2, v6}, Landroid/widget/FrameLayout;->setId(I)V

    .line 93
    new-instance v6, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v6, v9, v9}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v2, v6}, Lcom/brynk/fathom/controllers/ReactObserverActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 96
    if-nez p1, :cond_0

    .line 97
    new-instance v5, Lcom/brynk/fathom/controllers/ReactObserverActivity$DebugExampleThreeFragment;

    iget-object v6, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactRootView:Lcom/facebook/react/ReactRootView;

    invoke-direct {v5, v6}, Lcom/brynk/fathom/controllers/ReactObserverActivity$DebugExampleThreeFragment;-><init>(Lcom/facebook/react/ReactRootView;)V

    .line 98
    .local v5, "thirdFragment":Landroid/app/Fragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 99
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {v5, v0}, Landroid/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 100
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactObserverActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v3

    .line 101
    .local v3, "ft2":Landroid/app/FragmentTransaction;
    invoke-virtual {v2}, Landroid/widget/FrameLayout;->getId()I

    move-result v6

    invoke-virtual {v3, v6, v5}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/FragmentTransaction;->commit()I

    .line 108
    .end local v0    # "bundle":Landroid/os/Bundle;
    .end local v3    # "ft2":Landroid/app/FragmentTransaction;
    .end local v5    # "thirdFragment":Landroid/app/Fragment;
    :cond_0
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0x17

    if-lt v6, v7, :cond_1

    .line 109
    const-string v6, "FATHOM"

    const-string v7, "Got this far"

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 110
    invoke-static {p0}, Landroid/provider/Settings;->canDrawOverlays(Landroid/content/Context;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 111
    new-instance v4, Landroid/content/Intent;

    const-string v6, "android.settings.action.MANAGE_OVERLAY_PERMISSION"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "package:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 112
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactObserverActivity;->getPackageName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    invoke-direct {v4, v6, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 113
    .local v4, "intent":Landroid/content/Intent;
    const-string v6, "FATHOM"

    const-string v7, "Got this far 2"

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 115
    sget v6, Lcom/brynk/fathom/controllers/ReactObserverActivity;->OVERLAY_PERMISSION_REQ_CODE:I

    invoke-virtual {p0, v4, v6}, Lcom/brynk/fathom/controllers/ReactObserverActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 123
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_1
    :goto_0
    return-void

    .line 117
    :cond_2
    const-string v6, "FATHOM"

    const-string v7, "Got this far 3"

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 169
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 171
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 172
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0}, Lcom/facebook/react/ReactInstanceManager;->onHostDestroy()V

    .line 174
    :cond_0
    return-void
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 186
    const/16 v0, 0x52

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0}, Lcom/facebook/react/ReactInstanceManager;->showDevOptionsDialog()V

    .line 188
    const/4 v0, 0x1

    .line 190
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 151
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 153
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 154
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0, p0}, Lcom/facebook/react/ReactInstanceManager;->onHostPause(Landroid/app/Activity;)V

    .line 156
    :cond_0
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 160
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 162
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0, p0, p0}, Lcom/facebook/react/ReactInstanceManager;->onHostResume(Landroid/app/Activity;Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;)V

    .line 165
    :cond_0
    return-void
.end method
