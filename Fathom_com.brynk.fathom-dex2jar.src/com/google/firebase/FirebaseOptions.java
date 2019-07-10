package com.google.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.internal.zzz.zza;
import com.google.android.gms.common.util.zzv;

public final class FirebaseOptions
{
  private final String aWg;
  private final String aWh;
  private final String aWi;
  private final String aWj;
  private final String aWk;
  private final String lU;

  private FirebaseOptions(@NonNull String paramString1, @NonNull String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6)
  {
    if (!zzv.zzij(paramString1));
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zza(bool, "ApplicationId must be set.");
      this.lU = paramString1;
      this.aWg = paramString2;
      this.aWh = paramString3;
      this.aWi = paramString4;
      this.aWj = paramString5;
      this.aWk = paramString6;
      return;
    }
  }

  public static FirebaseOptions fromResource(Context paramContext)
  {
    paramContext = new zzah(paramContext);
    String str = paramContext.getString("google_app_id");
    if (TextUtils.isEmpty(str))
      return null;
    return new FirebaseOptions(str, paramContext.getString("google_api_key"), paramContext.getString("firebase_database_url"), paramContext.getString("ga_trackingId"), paramContext.getString("gcm_defaultSenderId"), paramContext.getString("google_storage_bucket"));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FirebaseOptions));
    do
    {
      return false;
      paramObject = (FirebaseOptions)paramObject;
    }
    while ((!zzz.equal(this.lU, paramObject.lU)) || (!zzz.equal(this.aWg, paramObject.aWg)) || (!zzz.equal(this.aWh, paramObject.aWh)) || (!zzz.equal(this.aWi, paramObject.aWi)) || (!zzz.equal(this.aWj, paramObject.aWj)) || (!zzz.equal(this.aWk, paramObject.aWk)));
    return true;
  }

  public String getApiKey()
  {
    return this.aWg;
  }

  public String getApplicationId()
  {
    return this.lU;
  }

  public String getDatabaseUrl()
  {
    return this.aWh;
  }

  public String getGcmSenderId()
  {
    return this.aWj;
  }

  public String getStorageBucket()
  {
    return this.aWk;
  }

  public int hashCode()
  {
    return zzz.hashCode(new Object[] { this.lU, this.aWg, this.aWh, this.aWi, this.aWj, this.aWk });
  }

  public String toString()
  {
    return zzz.zzx(this).zzg("applicationId", this.lU).zzg("apiKey", this.aWg).zzg("databaseUrl", this.aWh).zzg("gcmSenderId", this.aWj).zzg("storageBucket", this.aWk).toString();
  }

  public static final class Builder
  {
    private String aWg;
    private String aWh;
    private String aWi;
    private String aWj;
    private String aWk;
    private String lU;

    public Builder()
    {
    }

    public Builder(FirebaseOptions paramFirebaseOptions)
    {
      this.lU = FirebaseOptions.zza(paramFirebaseOptions);
      this.aWg = FirebaseOptions.zzb(paramFirebaseOptions);
      this.aWh = FirebaseOptions.zzc(paramFirebaseOptions);
      this.aWi = FirebaseOptions.zzd(paramFirebaseOptions);
      this.aWj = FirebaseOptions.zze(paramFirebaseOptions);
      this.aWk = FirebaseOptions.zzf(paramFirebaseOptions);
    }

    public FirebaseOptions build()
    {
      return new FirebaseOptions(this.lU, this.aWg, this.aWh, this.aWi, this.aWj, this.aWk, null);
    }

    public Builder setApiKey(@NonNull String paramString)
    {
      this.aWg = zzaa.zzh(paramString, "ApiKey must be set.");
      return this;
    }

    public Builder setApplicationId(@NonNull String paramString)
    {
      this.lU = zzaa.zzh(paramString, "ApplicationId must be set.");
      return this;
    }

    public Builder setDatabaseUrl(@Nullable String paramString)
    {
      this.aWh = paramString;
      return this;
    }

    public Builder setGcmSenderId(@Nullable String paramString)
    {
      this.aWj = paramString;
      return this;
    }

    public Builder setStorageBucket(@Nullable String paramString)
    {
      this.aWk = paramString;
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.FirebaseOptions
 * JD-Core Version:    0.6.0
 */