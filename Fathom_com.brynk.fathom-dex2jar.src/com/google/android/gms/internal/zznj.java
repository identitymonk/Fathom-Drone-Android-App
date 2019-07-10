package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents.zza;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.UsageInfo.zza;
import com.google.android.gms.appindexing.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zznj
{
  public static DocumentSection zza(String paramString, zzvw.zzc paramzzc)
  {
    paramString = new RegisterSectionInfo.zza(paramString).zzaz(true).zzfs(paramString).zzfr("blob").zzahr();
    return new DocumentSection(zzasa.zzf(paramzzc), paramString);
  }

  public static UsageInfo zza(Action paramAction, long paramLong, String paramString, int paramInt)
  {
    boolean bool = false;
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramAction.zzahu());
    Object localObject = localBundle.getBundle("object");
    int i;
    if (((Bundle)localObject).containsKey("id"))
    {
      paramAction = Uri.parse(((Bundle)localObject).getString("id"));
      String str1 = ((Bundle)localObject).getString("name");
      String str2 = ((Bundle)localObject).getString("type");
      localObject = zznk.zza(paramString, Uri.parse(((Bundle)localObject).getString("url")));
      paramAction = UsageInfo.zza((Intent)localObject, str1, paramAction, str2, null);
      if (localBundle.containsKey(".private:ssbContext"))
      {
        paramAction.zza(DocumentSection.zzl(localBundle.getByteArray(".private:ssbContext")));
        localBundle.remove(".private:ssbContext");
      }
      if (localBundle.containsKey(".private:accountName"))
      {
        paramAction.zzb(new Account(localBundle.getString(".private:accountName"), "com.google"));
        localBundle.remove(".private:accountName");
      }
      if ((!localBundle.containsKey(".private:isContextOnly")) || (!localBundle.getBoolean(".private:isContextOnly")))
        break label290;
      i = 4;
      localBundle.remove(".private:isContextOnly");
    }
    while (true)
    {
      if (localBundle.containsKey(".private:isDeviceOnly"))
      {
        bool = localBundle.getBoolean(".private:isDeviceOnly", false);
        localBundle.remove(".private:isDeviceOnly");
      }
      paramAction.zza(zza(".private:action", zzj(localBundle)));
      return new UsageInfo.zza().zza(UsageInfo.zza(paramString, (Intent)localObject)).zzaa(paramLong).zzcq(i).zza(paramAction.zzaho()).zzbb(bool).zzcr(paramInt).zzahs();
      paramAction = null;
      break;
      label290: i = 0;
    }
  }

  private static zzvw.zzb zzb(String paramString, Bundle paramBundle)
  {
    zzvw.zzb localzzb = new zzvw.zzb();
    localzzb.name = paramString;
    localzzb.ahG = new zzvw.zzd();
    localzzb.ahG.ahL = zzj(paramBundle);
    return localzzb;
  }

  private static zzvw.zzb zzh(String paramString, boolean paramBoolean)
  {
    zzvw.zzb localzzb = new zzvw.zzb();
    localzzb.name = paramString;
    localzzb.ahG = new zzvw.zzd();
    localzzb.ahG.ahI = paramBoolean;
    return localzzb;
  }

  public static zzvw.zzc zzj(Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramBundle.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str1 = (String)((Iterator)localObject1).next();
      Object localObject2 = paramBundle.get(str1);
      if ((localObject2 instanceof String))
      {
        localArrayList.add(zzu(str1, (String)localObject2));
        continue;
      }
      if ((localObject2 instanceof Bundle))
      {
        localArrayList.add(zzb(str1, (Bundle)localObject2));
        continue;
      }
      int j;
      int i;
      label126: String str2;
      if ((localObject2 instanceof String[]))
      {
        localObject2 = (String[])localObject2;
        j = localObject2.length;
        i = 0;
        if (i < j)
        {
          str2 = localObject2[i];
          if (str2 != null)
            break label149;
        }
        while (true)
        {
          i += 1;
          break label126;
          break;
          label149: localArrayList.add(zzu(str1, str2));
        }
      }
      if ((localObject2 instanceof Bundle[]))
      {
        localObject2 = (Bundle[])localObject2;
        j = localObject2.length;
        i = 0;
        label187: if (i < j)
        {
          str2 = localObject2[i];
          if (str2 != null)
            break label210;
        }
        while (true)
        {
          i += 1;
          break label187;
          break;
          label210: localArrayList.add(zzb(str1, str2));
        }
      }
      if ((localObject2 instanceof Boolean))
      {
        localArrayList.add(zzh(str1, ((Boolean)localObject2).booleanValue()));
        continue;
      }
      str1 = String.valueOf(localObject2);
      Log.e("SearchIndex", String.valueOf(str1).length() + 19 + "Unsupported value: " + str1);
    }
    localObject1 = new zzvw.zzc();
    if (paramBundle.containsKey("type"))
      ((zzvw.zzc)localObject1).type = paramBundle.getString("type");
    ((zzvw.zzc)localObject1).ahH = ((zzvw.zzb[])localArrayList.toArray(new zzvw.zzb[localArrayList.size()]));
    return (zzvw.zzc)(zzvw.zzc)localObject1;
  }

  private static zzvw.zzb zzu(String paramString1, String paramString2)
  {
    zzvw.zzb localzzb = new zzvw.zzb();
    localzzb.name = paramString1;
    localzzb.ahG = new zzvw.zzd();
    localzzb.ahG.Fe = paramString2;
    return localzzb;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zznj
 * JD-Core Version:    0.6.0
 */