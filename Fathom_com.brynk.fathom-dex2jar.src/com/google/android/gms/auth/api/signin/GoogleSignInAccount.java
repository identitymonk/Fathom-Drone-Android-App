package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zza();
  public static zze jf = zzh.zzayl();
  private static Comparator<Scope> jm = new Comparator()
  {
    public int zza(Scope paramScope1, Scope paramScope2)
    {
      return paramScope1.zzari().compareTo(paramScope2.zzari());
    }
  };
  List<Scope> hR;
  private String iF;
  private String is;
  private String it;
  private String jg;
  private String jh;
  private Uri ji;
  private String jj;
  private long jk;
  private String jl;
  final int versionCode;
  private String zzboa;

  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List<Scope> paramList, String paramString7, String paramString8)
  {
    this.versionCode = paramInt;
    this.zzboa = paramString1;
    this.iF = paramString2;
    this.jg = paramString3;
    this.jh = paramString4;
    this.ji = paramUri;
    this.jj = paramString5;
    this.jk = paramLong;
    this.jl = paramString6;
    this.hR = paramList;
    this.is = paramString7;
    this.it = paramString8;
  }

  public static GoogleSignInAccount zza(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable Uri paramUri, @Nullable Long paramLong, @NonNull String paramString7, @NonNull Set<Scope> paramSet)
  {
    Long localLong = paramLong;
    if (paramLong == null)
      localLong = Long.valueOf(jf.currentTimeMillis() / 1000L);
    return new GoogleSignInAccount(3, paramString1, paramString2, paramString3, paramString4, paramUri, null, localLong.longValue(), zzaa.zzib(paramString7), new ArrayList((Collection)zzaa.zzy(paramSet)), paramString5, paramString6);
  }

  private JSONObject zzais()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      if (getId() != null)
        localJSONObject.put("id", getId());
      if (getIdToken() != null)
        localJSONObject.put("tokenId", getIdToken());
      if (getEmail() != null)
        localJSONObject.put("email", getEmail());
      if (getDisplayName() != null)
        localJSONObject.put("displayName", getDisplayName());
      if (getGivenName() != null)
        localJSONObject.put("givenName", getGivenName());
      if (getFamilyName() != null)
        localJSONObject.put("familyName", getFamilyName());
      if (getPhotoUrl() != null)
        localJSONObject.put("photoUrl", getPhotoUrl().toString());
      if (getServerAuthCode() != null)
        localJSONObject.put("serverAuthCode", getServerAuthCode());
      localJSONObject.put("expirationTime", this.jk);
      localJSONObject.put("obfuscatedIdentifier", zzaip());
      localJSONArray = new JSONArray();
      Collections.sort(this.hR, jm);
      Iterator localIterator = this.hR.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((Scope)localIterator.next()).zzari());
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    localJSONException.put("grantedScopes", localJSONArray);
    return localJSONException;
  }

  @Nullable
  public static GoogleSignInAccount zzfz(@Nullable String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString));
    for (paramString = Uri.parse(paramString); ; paramString = null)
    {
      long l = Long.parseLong(localJSONObject.getString("expirationTime"));
      HashSet localHashSet = new HashSet();
      JSONArray localJSONArray = localJSONObject.getJSONArray("grantedScopes");
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        localHashSet.add(new Scope(localJSONArray.getString(i)));
        i += 1;
      }
      return zza(localJSONObject.optString("id"), localJSONObject.optString("tokenId", null), localJSONObject.optString("email", null), localJSONObject.optString("displayName", null), localJSONObject.optString("givenName", null), localJSONObject.optString("familyName", null), paramString, Long.valueOf(l), localJSONObject.getString("obfuscatedIdentifier"), localHashSet).zzga(localJSONObject.optString("serverAuthCode", null));
    }
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleSignInAccount))
      return false;
    return ((GoogleSignInAccount)paramObject).zzaiq().equals(zzaiq());
  }

  @Nullable
  public String getDisplayName()
  {
    return this.jh;
  }

  @Nullable
  public String getEmail()
  {
    return this.jg;
  }

  @Nullable
  public String getFamilyName()
  {
    return this.it;
  }

  @Nullable
  public String getGivenName()
  {
    return this.is;
  }

  @NonNull
  public Set<Scope> getGrantedScopes()
  {
    return new HashSet(this.hR);
  }

  @Nullable
  public String getId()
  {
    return this.zzboa;
  }

  @Nullable
  public String getIdToken()
  {
    return this.iF;
  }

  @Nullable
  public Uri getPhotoUrl()
  {
    return this.ji;
  }

  @Nullable
  public String getServerAuthCode()
  {
    return this.jj;
  }

  public int hashCode()
  {
    return zzaiq().hashCode();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public boolean zza()
  {
    return jf.currentTimeMillis() / 1000L >= this.jk - 300L;
  }

  public long zzaio()
  {
    return this.jk;
  }

  @NonNull
  public String zzaip()
  {
    return this.jl;
  }

  public String zzaiq()
  {
    return zzais().toString();
  }

  public String zzair()
  {
    JSONObject localJSONObject = zzais();
    localJSONObject.remove("serverAuthCode");
    return localJSONObject.toString();
  }

  public GoogleSignInAccount zzga(String paramString)
  {
    this.jj = paramString;
    return this;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInAccount
 * JD-Core Version:    0.6.0
 */