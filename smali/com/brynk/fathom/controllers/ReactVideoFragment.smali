.class public Lcom/brynk/fathom/controllers/ReactVideoFragment;
.super Landroid/support/v4/app/Fragment;
.source "ReactVideoFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/ReactVideoFragment$OnFragmentInteractionListener;
    }
.end annotation


# static fields
.field private static final ARG_PARAM1:Ljava/lang/String; = "param1"

.field private static final ARG_PARAM2:Ljava/lang/String; = "param2"


# instance fields
.field private mListener:Lcom/brynk/fathom/controllers/ReactVideoFragment$OnFragmentInteractionListener;

.field private mParam1:Ljava/lang/String;

.field private mParam2:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 35
    return-void
.end method

.method public static newInstance(Ljava/lang/String;Ljava/lang/String;)Lcom/brynk/fathom/controllers/ReactVideoFragment;
    .locals 3
    .param p0, "param1"    # Ljava/lang/String;
    .param p1, "param2"    # Ljava/lang/String;

    .prologue
    .line 47
    new-instance v1, Lcom/brynk/fathom/controllers/ReactVideoFragment;

    invoke-direct {v1}, Lcom/brynk/fathom/controllers/ReactVideoFragment;-><init>()V

    .line 48
    .local v1, "fragment":Lcom/brynk/fathom/controllers/ReactVideoFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 49
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "param1"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    const-string v2, "param2"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    invoke-virtual {v1, v0}, Lcom/brynk/fathom/controllers/ReactVideoFragment;->setArguments(Landroid/os/Bundle;)V

    .line 52
    return-object v1
.end method


# virtual methods
.method public onAttach(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 80
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onAttach(Landroid/content/Context;)V

    .line 81
    instance-of v0, p1, Lcom/brynk/fathom/controllers/ReactVideoFragment$OnFragmentInteractionListener;

    if-eqz v0, :cond_0

    .line 82
    check-cast p1, Lcom/brynk/fathom/controllers/ReactVideoFragment$OnFragmentInteractionListener;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactVideoFragment;->mListener:Lcom/brynk/fathom/controllers/ReactVideoFragment$OnFragmentInteractionListener;

    .line 87
    return-void

    .line 84
    .restart local p1    # "context":Landroid/content/Context;
    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " must implement OnFragmentInteractionListener"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onButtonPressed(Landroid/net/Uri;)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactVideoFragment;->mListener:Lcom/brynk/fathom/controllers/ReactVideoFragment$OnFragmentInteractionListener;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactVideoFragment;->mListener:Lcom/brynk/fathom/controllers/ReactVideoFragment$OnFragmentInteractionListener;

    invoke-interface {v0, p1}, Lcom/brynk/fathom/controllers/ReactVideoFragment$OnFragmentInteractionListener;->onFragmentInteraction(Landroid/net/Uri;)V

    .line 76
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 57
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 58
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactVideoFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 59
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactVideoFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "param1"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactVideoFragment;->mParam1:Ljava/lang/String;

    .line 60
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ReactVideoFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "param2"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactVideoFragment;->mParam2:Ljava/lang/String;

    .line 62
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 68
    const v0, 0x7f04003a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDetach()V
    .locals 1

    .prologue
    .line 91
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDetach()V

    .line 92
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ReactVideoFragment;->mListener:Lcom/brynk/fathom/controllers/ReactVideoFragment$OnFragmentInteractionListener;

    .line 93
    return-void
.end method
