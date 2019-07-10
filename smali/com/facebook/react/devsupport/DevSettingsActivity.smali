.class public Lcom/facebook/react/devsupport/DevSettingsActivity;
.super Landroid/preference/PreferenceActivity;
.source "DevSettingsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/preference/PreferenceActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 26
    invoke-super {p0, p1}, Landroid/preference/PreferenceActivity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    sget v0, Lcom/facebook/react/R$string;->catalyst_settings_title:I

    invoke-virtual {p0, v0}, Lcom/facebook/react/devsupport/DevSettingsActivity;->setTitle(I)V

    .line 28
    sget v0, Lcom/facebook/react/R$xml;->preferences:I

    invoke-virtual {p0, v0}, Lcom/facebook/react/devsupport/DevSettingsActivity;->addPreferencesFromResource(I)V

    .line 29
    return-void
.end method
