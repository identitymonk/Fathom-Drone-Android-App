package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzxq;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzf
{
  private final Set<Scope> DJ;
  private final Map<Api<?>, zza> DK;
  private final zzxq DL;
  private Integer DM;
  private final Account gj;
  private final String hu;
  private final Set<Scope> xF;
  private final int xH;
  private final View xI;
  private final String xJ;

  public zzf(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzxq paramzzxq)
  {
    this.gj = paramAccount;
    if (paramSet == null);
    for (paramAccount = Collections.EMPTY_SET; ; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      this.xF = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null)
        paramAccount = Collections.EMPTY_MAP;
      this.DK = paramAccount;
      this.xI = paramView;
      this.xH = paramInt;
      this.hu = paramString1;
      this.xJ = paramString2;
      this.DL = paramzzxq;
      paramAccount = new HashSet(this.xF);
      paramSet = this.DK.values().iterator();
      while (paramSet.hasNext())
        paramAccount.addAll(((zza)paramSet.next()).jw);
    }
    this.DJ = Collections.unmodifiableSet(paramAccount);
  }

  public static zzf zzca(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).zzarf();
  }

  public Account getAccount()
  {
    return this.gj;
  }

  @Deprecated
  public String getAccountName()
  {
    if (this.gj != null)
      return this.gj.name;
    return null;
  }

  public Account zzave()
  {
    if (this.gj != null)
      return this.gj;
    return new Account("<<default account>>", "com.google");
  }

  public int zzavo()
  {
    return this.xH;
  }

  public Set<Scope> zzavp()
  {
    return this.xF;
  }

  public Set<Scope> zzavq()
  {
    return this.DJ;
  }

  public Map<Api<?>, zza> zzavr()
  {
    return this.DK;
  }

  public String zzavs()
  {
    return this.hu;
  }

  public String zzavt()
  {
    return this.xJ;
  }

  public View zzavu()
  {
    return this.xI;
  }

  public zzxq zzavv()
  {
    return this.DL;
  }

  public Integer zzavw()
  {
    return this.DM;
  }

  public Set<Scope> zzc(Api<?> paramApi)
  {
    paramApi = (zza)this.DK.get(paramApi);
    if ((paramApi == null) || (paramApi.jw.isEmpty()))
      return this.xF;
    HashSet localHashSet = new HashSet(this.xF);
    localHashSet.addAll(paramApi.jw);
    return localHashSet;
  }

  public void zzc(Integer paramInteger)
  {
    this.DM = paramInteger;
  }

  public static final class zza
  {
    public final boolean DN;
    public final Set<Scope> jw;

    public zza(Set<Scope> paramSet, boolean paramBoolean)
    {
      zzaa.zzy(paramSet);
      this.jw = Collections.unmodifiableSet(paramSet);
      this.DN = paramBoolean;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf
 * JD-Core Version:    0.6.0
 */