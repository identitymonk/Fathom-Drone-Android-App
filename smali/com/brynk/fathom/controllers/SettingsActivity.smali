.class public Lcom/brynk/fathom/controllers/SettingsActivity;
.super Lcom/brynk/fathom/controllers/AppCompatPreferenceActivity;
.source "SettingsActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/SettingsActivity$ConnectedTask;,
        Lcom/brynk/fathom/controllers/SettingsActivity$RebootTask;,
        Lcom/brynk/fathom/controllers/SettingsActivity$StopSessionsTask;,
        Lcom/brynk/fathom/controllers/SettingsActivity$CalibrateDepthTask;,
        Lcom/brynk/fathom/controllers/SettingsActivity$DataSyncPreferenceFragment;,
        Lcom/brynk/fathom/controllers/SettingsActivity$NotificationPreferenceFragment;,
        Lcom/brynk/fathom/controllers/SettingsActivity$DronePreferenceFragment;,
        Lcom/brynk/fathom/controllers/SettingsActivity$GeneralPreferenceFragment;
    }
.end annotation


# static fields
.field private static sBindPreferenceSummaryToValueListener:Landroid/preference/Preference$OnPreferenceChangeListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/brynk/fathom/controllers/SettingsActivity$1;

    invoke-direct {v0}, Lcom/brynk/fathom/controllers/SettingsActivity$1;-><init>()V

    sput-object v0, Lcom/brynk/fathom/controllers/SettingsActivity;->sBindPreferenceSummaryToValueListener:Landroid/preference/Preference$OnPreferenceChangeListener;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/AppCompatPreferenceActivity;-><init>()V

    .line 502
    return-void
.end method

.method static synthetic access$000(Landroid/preference/Preference;)V
    .locals 0
    .param p0, "x0"    # Landroid/preference/Preference;

    .prologue
    .line 50
    invoke-static {p0}, Lcom/brynk/fathom/controllers/SettingsActivity;->bindPreferenceSummaryToValue(Landroid/preference/Preference;)V

    return-void
.end method

.method private static bindPreferenceSummaryToValue(Landroid/preference/Preference;)V
    .locals 4
    .param p0, "preference"    # Landroid/preference/Preference;

    .prologue
    .line 123
    sget-object v0, Lcom/brynk/fathom/controllers/SettingsActivity;->sBindPreferenceSummaryToValueListener:Landroid/preference/Preference$OnPreferenceChangeListener;

    invoke-virtual {p0, v0}, Landroid/preference/Preference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 127
    sget-object v0, Lcom/brynk/fathom/controllers/SettingsActivity;->sBindPreferenceSummaryToValueListener:Landroid/preference/Preference$OnPreferenceChangeListener;

    .line 129
    invoke-virtual {p0}, Landroid/preference/Preference;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 130
    invoke-virtual {p0}, Landroid/preference/Preference;->getKey()Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 127
    invoke-interface {v0, p0, v1}, Landroid/preference/Preference$OnPreferenceChangeListener;->onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z

    .line 131
    return-void
.end method

.method private static isXLargeTablet(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 108
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v0, v0, 0xf

    const/4 v1, 0x4

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setupActionBar()V
    .locals 2

    .prologue
    .line 143
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SettingsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 144
    .local v0, "actionBar":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    .line 146
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 148
    :cond_0
    return-void
.end method


# virtual methods
.method protected isValidFragment(Ljava/lang/String;)Z
    .locals 1
    .param p1, "fragmentName"    # Ljava/lang/String;

    .prologue
    .line 172
    const-class v0, Landroid/preference/PreferenceFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-class v0, Lcom/brynk/fathom/controllers/SettingsActivity$GeneralPreferenceFragment;

    .line 173
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-class v0, Lcom/brynk/fathom/controllers/SettingsActivity$DronePreferenceFragment;

    .line 174
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-class v0, Lcom/brynk/fathom/controllers/SettingsActivity$DataSyncPreferenceFragment;

    .line 175
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-class v0, Lcom/brynk/fathom/controllers/SettingsActivity$NotificationPreferenceFragment;

    .line 176
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onBuildHeaders(Ljava/util/List;)V
    .locals 1
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/preference/PreferenceActivity$Header;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 164
    .local p1, "target":Ljava/util/List;, "Ljava/util/List<Landroid/preference/PreferenceActivity$Header;>;"
    const v0, 0x7f060003

    invoke-virtual {p0, v0, p1}, Lcom/brynk/fathom/controllers/SettingsActivity;->loadHeadersFromResource(ILjava/util/List;)V

    .line 165
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 135
    invoke-super {p0, p1}, Lcom/brynk/fathom/controllers/AppCompatPreferenceActivity;->onCreate(Landroid/os/Bundle;)V

    .line 136
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/SettingsActivity;->setupActionBar()V

    .line 137
    return-void
.end method

.method public onHeaderClick(Landroid/preference/PreferenceActivity$Header;I)V
    .locals 8
    .param p1, "header"    # Landroid/preference/PreferenceActivity$Header;
    .param p2, "position"    # I

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 191
    invoke-super {p0, p1, p2}, Lcom/brynk/fathom/controllers/AppCompatPreferenceActivity;->onHeaderClick(Landroid/preference/PreferenceActivity$Header;I)V

    .line 192
    iget-wide v2, p1, Landroid/preference/PreferenceActivity$Header;->id:J

    const-wide/32 v4, 0x7f0f010c

    cmp-long v1, v2, v4

    if-nez v1, :cond_1

    .line 193
    new-instance v1, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v1}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SettingsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 194
    .local v0, "d":Ljava/lang/String;
    new-instance v1, Lcom/brynk/fathom/controllers/SettingsActivity$CalibrateDepthTask;

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SettingsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, p0, v2, v0}, Lcom/brynk/fathom/controllers/SettingsActivity$CalibrateDepthTask;-><init>(Lcom/brynk/fathom/controllers/SettingsActivity;Landroid/content/Context;Ljava/lang/String;)V

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, ""

    aput-object v3, v2, v6

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/controllers/SettingsActivity$CalibrateDepthTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 215
    .end local v0    # "d":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 196
    :cond_1
    iget-wide v2, p1, Landroid/preference/PreferenceActivity$Header;->id:J

    const-wide/32 v4, 0x7f0f010f

    cmp-long v1, v2, v4

    if-nez v1, :cond_2

    .line 197
    new-instance v1, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v1}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SettingsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 198
    .restart local v0    # "d":Ljava/lang/String;
    new-instance v1, Lcom/brynk/fathom/controllers/SettingsActivity$RebootTask;

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SettingsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, p0, v2, v0}, Lcom/brynk/fathom/controllers/SettingsActivity$RebootTask;-><init>(Lcom/brynk/fathom/controllers/SettingsActivity;Landroid/content/Context;Ljava/lang/String;)V

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, ""

    aput-object v3, v2, v6

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/controllers/SettingsActivity$RebootTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 203
    .end local v0    # "d":Ljava/lang/String;
    :cond_2
    iget-wide v2, p1, Landroid/preference/PreferenceActivity$Header;->id:J

    const-wide/32 v4, 0x7f0f010a

    cmp-long v1, v2, v4

    if-nez v1, :cond_3

    .line 204
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/brynk/fathom/controllers/CalibrateActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/SettingsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 205
    :cond_3
    iget-wide v2, p1, Landroid/preference/PreferenceActivity$Header;->id:J

    const-wide/32 v4, 0x7f0f010b

    cmp-long v1, v2, v4

    if-nez v1, :cond_4

    .line 206
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/brynk/fathom/controllers/CalibrateCompassActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/SettingsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 207
    :cond_4
    iget-wide v2, p1, Landroid/preference/PreferenceActivity$Header;->id:J

    const-wide/32 v4, 0x7f0f010d

    cmp-long v1, v2, v4

    if-nez v1, :cond_5

    .line 208
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/brynk/fathom/controllers/WiFiSetupActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/SettingsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 209
    :cond_5
    iget-wide v2, p1, Landroid/preference/PreferenceActivity$Header;->id:J

    const-wide/32 v4, 0x7f0f010e

    cmp-long v1, v2, v4

    if-nez v1, :cond_0

    .line 210
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/SettingsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public onIsMultiPane()Z
    .locals 1

    .prologue
    .line 155
    invoke-static {p0}, Lcom/brynk/fathom/controllers/SettingsActivity;->isXLargeTablet(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 181
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 186
    invoke-super {p0, p1}, Lcom/brynk/fathom/controllers/AppCompatPreferenceActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 183
    :pswitch_0
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SettingsActivity;->finish()V

    .line 184
    const/4 v0, 0x1

    goto :goto_0

    .line 181
    nop

    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method
