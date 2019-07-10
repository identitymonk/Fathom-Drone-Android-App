.class public Lcom/brynk/fathom/controllers/ReactActivity;
.super Landroid/app/Activity;
.source "ReactActivity.java"

# interfaces
.implements Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleThreeFragment;,
        Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;
    }
.end annotation


# static fields
.field public static OVERLAY_PERMISSION_REQ_CODE:I


# instance fields
.field private isMockDrone:Ljava/lang/Boolean;

.field private isRecording:Ljava/lang/Boolean;

.field private mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

.field private mReactRootView:Lcom/facebook/react/ReactRootView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 77
    const/16 v0, 0x4d2

    sput v0, Lcom/brynk/fathom/controllers/ReactActivity;->OVERLAY_PERMISSION_REQ_CODE:I

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 74
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 78
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->isRecording:Ljava/lang/Boolean;

    .line 79
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->isMockDrone:Ljava/lang/Boolean;

    .line 1052
    return-void
.end method


# virtual methods
.method public invokeDefaultOnBackPressed()V
    .locals 0

    .prologue
    .line 180
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 181
    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 160
    sget v0, Lcom/brynk/fathom/controllers/ReactActivity;->OVERLAY_PERMISSION_REQ_CODE:I

    if-ne p1, v0, :cond_0

    .line 161
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    .line 162
    invoke-static {p0}, Landroid/provider/Settings;->canDrawOverlays(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 167
    :cond_0
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 211
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0}, Lcom/facebook/react/ReactInstanceManager;->onBackPressed()V

    .line 215
    :goto_0
    return-void

    .line 213
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 13
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v10, 0x400

    const/4 v12, -0x1

    .line 86
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 88
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity;->getWindow()Landroid/view/Window;

    move-result-object v9

    invoke-virtual {v9, v10, v10}, Landroid/view/Window;->setFlags(II)V

    .line 90
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity;->getWindow()Landroid/view/Window;

    move-result-object v9

    const/16 v10, 0x80

    invoke-virtual {v9, v10}, Landroid/view/Window;->addFlags(I)V

    .line 93
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 94
    .local v1, "dataForReact":Landroid/os/Bundle;
    const-string v9, "drone_ip"

    new-instance v10, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v10}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    new-instance v9, Lcom/facebook/react/ReactRootView;

    invoke-direct {v9, p0}, Lcom/facebook/react/ReactRootView;-><init>(Landroid/content/Context;)V

    iput-object v9, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactRootView:Lcom/facebook/react/ReactRootView;

    .line 96
    invoke-static {}, Lcom/facebook/react/ReactInstanceManager;->builder()Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v9

    .line 97
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity;->getApplication()Landroid/app/Application;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/facebook/react/ReactInstanceManagerBuilder;->setApplication(Landroid/app/Application;)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v9

    const-string v10, "index.android.bundle"

    .line 98
    invoke-virtual {v9, v10}, Lcom/facebook/react/ReactInstanceManagerBuilder;->setBundleAssetName(Ljava/lang/String;)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v9

    new-instance v10, Lcom/facebook/react/shell/MainReactPackage;

    invoke-direct {v10}, Lcom/facebook/react/shell/MainReactPackage;-><init>()V

    .line 100
    invoke-virtual {v9, v10}, Lcom/facebook/react/ReactInstanceManagerBuilder;->addPackage(Lcom/facebook/react/ReactPackage;)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v9

    const/4 v10, 0x0

    .line 102
    invoke-virtual {v9, v10}, Lcom/facebook/react/ReactInstanceManagerBuilder;->setUseDeveloperSupport(Z)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v9

    sget-object v10, Lcom/facebook/react/common/LifecycleState;->RESUMED:Lcom/facebook/react/common/LifecycleState;

    .line 103
    invoke-virtual {v9, v10}, Lcom/facebook/react/ReactInstanceManagerBuilder;->setInitialLifecycleState(Lcom/facebook/react/common/LifecycleState;)Lcom/facebook/react/ReactInstanceManagerBuilder;

    move-result-object v9

    .line 104
    invoke-virtual {v9}, Lcom/facebook/react/ReactInstanceManagerBuilder;->build()Lcom/facebook/react/ReactInstanceManager;

    move-result-object v9

    iput-object v9, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    .line 105
    iget-object v9, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactRootView:Lcom/facebook/react/ReactRootView;

    iget-object v10, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    const-string v11, "HelloWorld"

    invoke-virtual {v9, v10, v11, v1}, Lcom/facebook/react/ReactRootView;->startReactApplication(Lcom/facebook/react/ReactInstanceManager;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 109
    new-instance v3, Landroid/widget/FrameLayout;

    invoke-direct {v3, p0}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 110
    .local v3, "frame":Landroid/widget/FrameLayout;
    const v9, 0x7f0f00a4

    invoke-virtual {v3, v9}, Landroid/widget/FrameLayout;->setId(I)V

    .line 111
    new-instance v9, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v9, v12, v12}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v3, v9}, Lcom/brynk/fathom/controllers/ReactActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 114
    if-nez p1, :cond_0

    .line 115
    new-instance v7, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-direct {v7}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;-><init>()V

    .line 116
    .local v7, "newFragment":Landroid/app/Fragment;
    new-instance v8, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleThreeFragment;

    iget-object v9, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactRootView:Lcom/facebook/react/ReactRootView;

    invoke-direct {v8, v9}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleThreeFragment;-><init>(Lcom/facebook/react/ReactRootView;)V

    .line 117
    .local v8, "thirdFragment":Landroid/app/Fragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 118
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {v8, v0}, Landroid/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 119
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity;->getIntent()Landroid/content/Intent;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 120
    .local v2, "ex":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity;->getIntent()Landroid/content/Intent;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 121
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v9

    invoke-virtual {v9}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v4

    .line 122
    .local v4, "ft":Landroid/app/FragmentTransaction;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v9

    invoke-virtual {v9}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v5

    .line 124
    .local v5, "ft2":Landroid/app/FragmentTransaction;
    invoke-virtual {v3}, Landroid/widget/FrameLayout;->getId()I

    move-result v9

    invoke-virtual {v5, v9, v8}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v9

    invoke-virtual {v9}, Landroid/app/FragmentTransaction;->commit()I

    .line 125
    invoke-virtual {v3}, Landroid/widget/FrameLayout;->getId()I

    move-result v9

    invoke-virtual {v4, v9, v7}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v9

    invoke-virtual {v9}, Landroid/app/FragmentTransaction;->commit()I

    .line 132
    .end local v0    # "bundle":Landroid/os/Bundle;
    .end local v2    # "ex":Landroid/os/Bundle;
    .end local v4    # "ft":Landroid/app/FragmentTransaction;
    .end local v5    # "ft2":Landroid/app/FragmentTransaction;
    .end local v7    # "newFragment":Landroid/app/Fragment;
    .end local v8    # "thirdFragment":Landroid/app/Fragment;
    :cond_0
    sget v9, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v10, 0x17

    if-lt v9, v10, :cond_1

    .line 133
    const-string v9, "FATHOM"

    const-string v10, "Got this far"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 134
    invoke-static {p0}, Landroid/provider/Settings;->canDrawOverlays(Landroid/content/Context;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 135
    new-instance v6, Landroid/content/Intent;

    const-string v9, "android.settings.action.MANAGE_OVERLAY_PERMISSION"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "package:"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    .line 136
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactActivity;->getPackageName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v10

    invoke-direct {v6, v9, v10}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 137
    .local v6, "intent":Landroid/content/Intent;
    const-string v9, "FATHOM"

    const-string v10, "Got this far 2"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 139
    sget v9, Lcom/brynk/fathom/controllers/ReactActivity;->OVERLAY_PERMISSION_REQ_CODE:I

    invoke-virtual {p0, v6, v9}, Lcom/brynk/fathom/controllers/ReactActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 156
    .end local v6    # "intent":Landroid/content/Intent;
    :cond_1
    :goto_0
    return-void

    .line 141
    :cond_2
    const-string v9, "FATHOM"

    const-string v10, "Got this far 3"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 202
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 204
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 205
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0}, Lcom/facebook/react/ReactInstanceManager;->onHostDestroy()V

    .line 207
    :cond_0
    return-void
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 219
    const/16 v0, 0x52

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 220
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0}, Lcom/facebook/react/ReactInstanceManager;->showDevOptionsDialog()V

    .line 221
    const/4 v0, 0x1

    .line 223
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
    .line 184
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 186
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0, p0}, Lcom/facebook/react/ReactInstanceManager;->onHostPause(Landroid/app/Activity;)V

    .line 189
    :cond_0
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 193
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 195
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    if-eqz v0, :cond_0

    .line 196
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity;->mReactInstanceManager:Lcom/facebook/react/ReactInstanceManager;

    invoke-virtual {v0, p0, p0}, Lcom/facebook/react/ReactInstanceManager;->onHostResume(Landroid/app/Activity;Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;)V

    .line 198
    :cond_0
    return-void
.end method
