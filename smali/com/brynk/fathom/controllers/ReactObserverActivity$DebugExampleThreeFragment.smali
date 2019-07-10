.class public Lcom/brynk/fathom/controllers/ReactObserverActivity$DebugExampleThreeFragment;
.super Landroid/app/Fragment;
.source "ReactObserverActivity.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ValidFragment"
    }
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/ReactObserverActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DebugExampleThreeFragment"
.end annotation


# instance fields
.field private reactRootView:Lcom/facebook/react/ReactRootView;


# direct methods
.method public constructor <init>(Lcom/facebook/react/ReactRootView;)V
    .locals 0
    .param p1, "rrv"    # Lcom/facebook/react/ReactRootView;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ValidFragment"
        }
    .end annotation

    .prologue
    .line 198
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 199
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity$DebugExampleThreeFragment;->reactRootView:Lcom/facebook/react/ReactRootView;

    .line 201
    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 207
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactObserverActivity$DebugExampleThreeFragment;->reactRootView:Lcom/facebook/react/ReactRootView;

    return-object v0
.end method
