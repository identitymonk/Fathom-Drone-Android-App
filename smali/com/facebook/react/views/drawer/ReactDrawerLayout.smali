.class Lcom/facebook/react/views/drawer/ReactDrawerLayout;
.super Landroid/support/v4/widget/DrawerLayout;
.source "ReactDrawerLayout.java"


# static fields
.field public static final DEFAULT_DRAWER_WIDTH:I = -0x1


# instance fields
.field private mDrawerPosition:I

.field private mDrawerWidth:I


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReactContext;)V
    .locals 1
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    .line 32
    invoke-direct {p0, p1}, Landroid/support/v4/widget/DrawerLayout;-><init>(Landroid/content/Context;)V

    .line 28
    const v0, 0x800003

    iput v0, p0, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->mDrawerPosition:I

    .line 29
    const/4 v0, -0x1

    iput v0, p0, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->mDrawerWidth:I

    .line 33
    return-void
.end method


# virtual methods
.method closeDrawer()V
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->mDrawerPosition:I

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->closeDrawer(I)V

    .line 50
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 37
    invoke-super {p0, p1}, Landroid/support/v4/widget/DrawerLayout;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 38
    invoke-static {p0, p1}, Lcom/facebook/react/uimanager/events/NativeGestureUtil;->notifyNativeGestureStarted(Landroid/view/View;Landroid/view/MotionEvent;)V

    .line 39
    const/4 v0, 0x1

    .line 41
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method openDrawer()V
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->mDrawerPosition:I

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->openDrawer(I)V

    .line 46
    return-void
.end method

.method setDrawerPosition(I)V
    .locals 0
    .param p1, "drawerPosition"    # I

    .prologue
    .line 53
    iput p1, p0, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->mDrawerPosition:I

    .line 54
    invoke-virtual {p0}, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->setDrawerProperties()V

    .line 55
    return-void
.end method

.method setDrawerProperties()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 64
    invoke-virtual {p0}, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->getChildCount()I

    move-result v2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_0

    .line 65
    invoke-virtual {p0, v4}, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 66
    .local v0, "drawerView":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/support/v4/widget/DrawerLayout$LayoutParams;

    .line 67
    .local v1, "layoutParams":Landroid/support/v4/widget/DrawerLayout$LayoutParams;
    iget v2, p0, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->mDrawerPosition:I

    iput v2, v1, Landroid/support/v4/widget/DrawerLayout$LayoutParams;->gravity:I

    .line 68
    iget v2, p0, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->mDrawerWidth:I

    iput v2, v1, Landroid/support/v4/widget/DrawerLayout$LayoutParams;->width:I

    .line 69
    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 70
    invoke-virtual {v0, v4}, Landroid/view/View;->setClickable(Z)V

    .line 72
    .end local v0    # "drawerView":Landroid/view/View;
    .end local v1    # "layoutParams":Landroid/support/v4/widget/DrawerLayout$LayoutParams;
    :cond_0
    return-void
.end method

.method setDrawerWidth(I)V
    .locals 0
    .param p1, "drawerWidthInPx"    # I

    .prologue
    .line 58
    iput p1, p0, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->mDrawerWidth:I

    .line 59
    invoke-virtual {p0}, Lcom/facebook/react/views/drawer/ReactDrawerLayout;->setDrawerProperties()V

    .line 60
    return-void
.end method
