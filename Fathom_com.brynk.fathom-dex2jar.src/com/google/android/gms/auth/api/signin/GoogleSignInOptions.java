package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends AbstractSafeParcelable
  implements Api.ApiOptions.Optional, ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  private static Comparator<Scope> jm;
  public static final Scope jn = new Scope("profile");
  public static final Scope jo = new Scope("email");
  public static final Scope jp = new Scope("openid");
  private Account gj;
  private final ArrayList<Scope> jq;
  private boolean jr;
  private final boolean js;
  private final boolean jt;
  private String ju;
  private String jv;
  final int versionCode;

  static
  {
    DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    CREATOR = new zzb();
    jm = new Comparator()
    {
      public int zza(Scope paramScope1, Scope paramScope2)
      {
        return paramScope1.zzari().compareTo(paramScope2.zzari());
      }
    };
  }

  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    this.versionCode = paramInt;
    this.jq = paramArrayList;
    this.gj = paramAccount;
    this.jr = paramBoolean1;
    this.js = paramBoolean2;
    this.jt = paramBoolean3;
    this.ju = paramString1;
    this.jv = paramString2;
  }

  private GoogleSignInOptions(Set<Scope> paramSet, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    this(2, new ArrayList(paramSet), paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2);
  }

  private JSONObject zzais()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      Collections.sort(this.jq, jm);
      Iterator localIterator = this.jq.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((Scope)localIterator.next()).zzari());
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    localJSONException.put("scopes", localJSONArray);
    if (this.gj != null)
      localJSONException.put("accountName", this.gj.name);
    localJSONException.put("idTokenRequested", this.jr);
    localJSONException.put("forceCodeForRefreshToken", this.jt);
    localJSONException.put("serverAuthRequested", this.js);
    if (!TextUtils.isEmpty(this.ju))
      localJSONException.put("serverClientId", this.ju);
    if (!TextUtils.isEmpty(this.jv))
      localJSONException.put("hostedDomain", this.jv);
    return localJSONException;
  }

  @Nullable
  public static GoogleSignInOptions zzgb(@Nullable String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    JSONObject localJSONObject = new JSONObject(paramString);
    HashSet localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(paramString.getString(i)));
      i += 1;
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString));
    for (paramString = new Account(paramString, "com.google"); ; paramString = null)
      return new GoogleSignInOptions(localHashSet, paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null));
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    while (true)
    {
      return false;
      try
      {
        paramObject = (GoogleSignInOptions)paramObject;
        if ((this.jq.size() != paramObject.zzait().size()) || (!this.jq.containsAll(paramObject.zzait())))
          continue;
        if (this.gj == null)
        {
          if (paramObject.getAccount() != null)
            continue;
          label56: if (!TextUtils.isEmpty(this.ju))
            break label128;
          if (!TextUtils.isEmpty(paramObject.zzaix()))
            continue;
        }
        while ((this.jt == paramObject.zzaiw()) && (this.jr == paramObject.zzaiu()) && (this.js == paramObject.zzaiv()))
        {
          return true;
          if (!this.gj.equals(paramObject.getAccount()))
            break;
          break label56;
          label128: boolean bool = this.ju.equals(paramObject.zzaix());
          if (!bool)
            break;
        }
      }
      catch (java.lang.ClassCastException paramObject)
      {
      }
    }
    return false;
  }

  public Account getAccount()
  {
    return this.gj;
  }

  public Scope[] getScopeArray()
  {
    return (Scope[])this.jq.toArray(new Scope[this.jq.size()]);
  }

  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jq.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((Scope)localIterator.next()).zzari());
    Collections.sort(localArrayList);
    return new zze().zzq(localArrayList).zzq(this.gj).zzq(this.ju).zzbe(this.jt).zzbe(this.jr).zzbe(this.js).zzajf();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  public String zzaiq()
  {
    return zzais().toString();
  }

  public ArrayList<Scope> zzait()
  {
    return new ArrayList(this.jq);
  }

  public boolean zzaiu()
  {
    return this.jr;
  }

  public boolean zzaiv()
  {
    return this.js;
  }

  public boolean zzaiw()
  {
    return this.jt;
  }

  public String zzaix()
  {
    return this.ju;
  }

  public String zzaiy()
  {
    return this.jv;
  }

  public static final class Builder
  {
    private Account gj;
    private boolean jr;
    private boolean js;
    private boolean jt;
    private String ju;
    private String jv;
    private Set<Scope> jw = new HashSet();

    public Builder()
    {
    }

    public Builder(@NonNull GoogleSignInOptions paramGoogleSignInOptions)
    {
      zzaa.zzy(paramGoogleSignInOptions);
      this.jw = new HashSet(GoogleSignInOptions.zzb(paramGoogleSignInOptions));
      this.js = GoogleSignInOptions.zzc(paramGoogleSignInOptions);
      this.jt = GoogleSignInOptions.zzd(paramGoogleSignInOptions);
      this.jr = GoogleSignInOptions.zze(paramGoogleSignInOptions);
      this.ju = GoogleSignInOptions.zzf(paramGoogleSignInOptions);
      this.gj = GoogleSignInOptions.zzg(paramGoogleSignInOptions);
      this.jv = GoogleSignInOptions.zzh(paramGoogleSignInOptions);
    }

    private String zzgc(String paramString)
    {
      zzaa.zzib(paramString);
      if ((this.ju == null) || (this.ju.equals(paramString)));
      for (boolean bool = true; ; bool = false)
      {
        zzaa.zzb(bool, "two different server client ids provided");
        return paramString;
      }
    }

    public GoogleSignInOptions build()
    {
      if ((this.jr) && ((this.gj == null) || (!this.jw.isEmpty())))
        requestId();
      return new GoogleSignInOptions(this.jw, this.gj, this.jr, this.js, this.jt, this.ju, this.jv, null);
    }

    public Builder requestEmail()
    {
      this.jw.add(GoogleSignInOptions.jo);
      return this;
    }

    public Builder requestId()
    {
      this.jw.add(GoogleSignInOptions.jp);
      return this;
    }

    public Builder requestIdToken(String paramString)
    {
      this.jr = true;
      this.ju = zzgc(paramString);
      return this;
    }

    public Builder requestProfile()
    {
      this.jw.add(GoogleSignInOptions.jn);
      return this;
    }

    public Builder requestScopes(Scope paramScope, Scope[] paramArrayOfScope)
    {
      this.jw.add(paramScope);
      this.jw.addAll(Arrays.asList(paramArrayOfScope));
      return this;
    }

    public Builder requestServerAuthCode(String paramString)
    {
      return requestServerAuthCode(paramString, false);
    }

    public Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      this.js = true;
      this.ju = zzgc(paramString);
      this.jt = paramBoolean;
      return this;
    }

    public Builder setAccountName(String paramString)
    {
      this.gj = new Account(zzaa.zzib(paramString), "com.google");
      return this;
    }

    public Builder setHostedDomain(String paramString)
    {
      this.jv = zzaa.zzib(paramString);
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInOptions
 * JD-Core Version:    0.6.0
 */