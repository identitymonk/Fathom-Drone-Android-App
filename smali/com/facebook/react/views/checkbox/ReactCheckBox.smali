.class Lcom/facebook/react/views/checkbox/ReactCheckBox;
.super Landroid/widget/CheckBox;
.source "ReactCheckBox.java"


# instance fields
.field private mAllowChange:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Landroid/widget/CheckBox;-><init>(Landroid/content/Context;)V

    .line 20
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/checkbox/ReactCheckBox;->mAllowChange:Z

    .line 21
    return-void
.end method


# virtual methods
.method public setChecked(Z)V
    .locals 1
    .param p1, "checked"    # Z

    .prologue
    .line 25
    iget-boolean v0, p0, Lcom/facebook/react/views/checkbox/ReactCheckBox;->mAllowChange:Z

    if-eqz v0, :cond_0

    .line 26
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/views/checkbox/ReactCheckBox;->mAllowChange:Z

    .line 27
    invoke-super {p0, p1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 29
    :cond_0
    return-void
.end method

.method setOn(Z)V
    .locals 1
    .param p1, "on"    # Z

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/facebook/react/views/checkbox/ReactCheckBox;->isChecked()Z

    move-result v0

    if-eq v0, p1, :cond_0

    .line 34
    invoke-super {p0, p1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 36
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/checkbox/ReactCheckBox;->mAllowChange:Z

    .line 37
    return-void
.end method
