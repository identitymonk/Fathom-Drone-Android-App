.class public Lcom/brynk/fathom/controllers/SettingsActivity$NotificationPreferenceFragment;
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
    name = "NotificationPreferenceFragment"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 284
    invoke-direct {p0}, Landroid/preference/PreferenceFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 287
    invoke-super {p0, p1}, Landroid/preference/PreferenceFragment;->onCreate(Landroid/os/Bundle;)V

    .line 288
    const v0, 0x7f060004

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/SettingsActivity$NotificationPreferenceFragment;->addPreferencesFromResource(I)V

    .line 289
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/SettingsActivity$NotificationPreferenceFragment;->setHasOptionsMenu(Z)V

    .line 295
    const-string v0, "notifications_new_message_ringtone"

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/SettingsActivity$NotificationPreferenceFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v0

    invoke-static {v0}, Lcom/brynk/fathom/controllers/SettingsActivity;->access$000(Landroid/preference/Preference;)V

    .line 296
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 4
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 300
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 301
    .local v0, "id":I
    const v1, 0x102002c

    if-ne v0, v1, :cond_0

    .line 302
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SettingsActivity$NotificationPreferenceFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const-class v3, Lcom/brynk/fathom/controllers/SettingsActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/SettingsActivity$NotificationPreferenceFragment;->startActivity(Landroid/content/Intent;)V

    .line 303
    const/4 v1, 0x1

    .line 305
    :goto_0
    return v1

    :cond_0
    invoke-super {p0, p1}, Landroid/preference/PreferenceFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    goto :goto_0
.end method
