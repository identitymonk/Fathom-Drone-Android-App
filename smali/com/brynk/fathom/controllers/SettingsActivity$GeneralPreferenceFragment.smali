.class public Lcom/brynk/fathom/controllers/SettingsActivity$GeneralPreferenceFragment;
.super Landroid/preference/PreferenceFragment;
.source "SettingsActivity.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xb
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/SettingsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GeneralPreferenceFragment"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 222
    invoke-direct {p0}, Landroid/preference/PreferenceFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 225
    invoke-super {p0, p1}, Landroid/preference/PreferenceFragment;->onCreate(Landroid/os/Bundle;)V

    .line 226
    const v0, 0x7f060002

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/SettingsActivity$GeneralPreferenceFragment;->addPreferencesFromResource(I)V

    .line 227
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/SettingsActivity$GeneralPreferenceFragment;->setHasOptionsMenu(Z)V

    .line 233
    const-string v0, "example_text"

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/SettingsActivity$GeneralPreferenceFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v0

    invoke-static {v0}, Lcom/brynk/fathom/controllers/SettingsActivity;->access$000(Landroid/preference/Preference;)V

    .line 234
    const-string v0, "example_list"

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/SettingsActivity$GeneralPreferenceFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v0

    invoke-static {v0}, Lcom/brynk/fathom/controllers/SettingsActivity;->access$000(Landroid/preference/Preference;)V

    .line 235
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 4
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 239
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 240
    .local v0, "id":I
    const v1, 0x102002c

    if-ne v0, v1, :cond_0

    .line 241
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SettingsActivity$GeneralPreferenceFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const-class v3, Lcom/brynk/fathom/controllers/SettingsActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/SettingsActivity$GeneralPreferenceFragment;->startActivity(Landroid/content/Intent;)V

    .line 242
    const/4 v1, 0x1

    .line 244
    :goto_0
    return v1

    :cond_0
    invoke-super {p0, p1}, Landroid/preference/PreferenceFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    goto :goto_0
.end method
