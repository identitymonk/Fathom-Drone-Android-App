.class final Lcom/brynk/fathom/controllers/SettingsActivity$1;
.super Ljava/lang/Object;
.source "SettingsActivity.java"

# interfaces
.implements Landroid/preference/Preference$OnPreferenceChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/brynk/fathom/controllers/SettingsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 8
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x0

    .line 58
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 60
    .local v4, "stringValue":Ljava/lang/String;
    instance-of v6, p1, Landroid/preference/ListPreference;

    if-eqz v6, :cond_1

    move-object v1, p1

    .line 63
    check-cast v1, Landroid/preference/ListPreference;

    .line 64
    .local v1, "listPreference":Landroid/preference/ListPreference;
    invoke-virtual {v1, v4}, Landroid/preference/ListPreference;->findIndexOfValue(Ljava/lang/String;)I

    move-result v0

    .line 67
    .local v0, "index":I
    if-ltz v0, :cond_0

    .line 69
    invoke-virtual {v1}, Landroid/preference/ListPreference;->getEntries()[Ljava/lang/CharSequence;

    move-result-object v5

    aget-object v5, v5, v0

    .line 67
    :cond_0
    invoke-virtual {p1, v5}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 99
    .end local v0    # "index":I
    .end local v1    # "listPreference":Landroid/preference/ListPreference;
    :goto_0
    const/4 v5, 0x1

    return v5

    .line 72
    :cond_1
    instance-of v6, p1, Landroid/preference/RingtonePreference;

    if-eqz v6, :cond_4

    .line 75
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 77
    const v5, 0x7f080055

    invoke-virtual {p1, v5}, Landroid/preference/Preference;->setSummary(I)V

    goto :goto_0

    .line 81
    :cond_2
    invoke-virtual {p1}, Landroid/preference/Preference;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .line 80
    invoke-static {v6, v7}, Landroid/media/RingtoneManager;->getRingtone(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/Ringtone;

    move-result-object v3

    .line 83
    .local v3, "ringtone":Landroid/media/Ringtone;
    if-nez v3, :cond_3

    .line 85
    invoke-virtual {p1, v5}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 89
    :cond_3
    invoke-virtual {p1}, Landroid/preference/Preference;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v3, v5}, Landroid/media/Ringtone;->getTitle(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 90
    .local v2, "name":Ljava/lang/String;
    invoke-virtual {p1, v2}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 97
    .end local v2    # "name":Ljava/lang/String;
    .end local v3    # "ringtone":Landroid/media/Ringtone;
    :cond_4
    invoke-virtual {p1, v4}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
