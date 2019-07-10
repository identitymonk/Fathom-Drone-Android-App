package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzasa;
import com.google.android.gms.internal.zzvw.zza;
import com.google.android.gms.internal.zzvw.zza.zza;
import java.util.List;
import java.util.Locale;
import java.util.zip.CRC32;

public class UsageInfo extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<UsageInfo> CREATOR = new zzj();
  final DocumentId gR;
  final long gS;
  int gT;
  final DocumentContents gU;
  final boolean gV;
  int gW;
  int gX;
  final int mVersionCode;
  public final String zzbcj;

  UsageInfo(int paramInt1, DocumentId paramDocumentId, long paramLong, int paramInt2, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.gR = paramDocumentId;
    this.gS = paramLong;
    this.gT = paramInt2;
    this.zzbcj = paramString;
    this.gU = paramDocumentContents;
    this.gV = paramBoolean;
    this.gW = paramInt3;
    this.gX = paramInt4;
  }

  private UsageInfo(DocumentId paramDocumentId, long paramLong, int paramInt1, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this(1, paramDocumentId, paramLong, paramInt1, paramString, paramDocumentContents, paramBoolean, paramInt2, paramInt3);
  }

  public UsageInfo(String paramString1, Intent paramIntent, String paramString2, Uri paramUri, String paramString3, List<AppIndexApi.AppIndexingLink> paramList, int paramInt)
  {
    this(1, zza(paramString1, paramIntent), System.currentTimeMillis(), 0, null, zza(paramIntent, paramString2, paramUri, paramString3, paramList).zzaho(), false, -1, paramInt);
  }

  public static DocumentContents.zza zza(Intent paramIntent, String paramString1, Uri paramUri, String paramString2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    DocumentContents.zza localzza = new DocumentContents.zza();
    localzza.zza(zzft(paramString1));
    if (paramUri != null)
      localzza.zza(zzk(paramUri));
    if (paramList != null)
      localzza.zza(zzv(paramList));
    paramString1 = paramIntent.getAction();
    if (paramString1 != null)
      localzza.zza(zzt("intent_action", paramString1));
    paramString1 = paramIntent.getDataString();
    if (paramString1 != null)
      localzza.zza(zzt("intent_data", paramString1));
    paramString1 = paramIntent.getComponent();
    if (paramString1 != null)
      localzza.zza(zzt("intent_activity", paramString1.getClassName()));
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getString("intent_extra_data_key");
      if (paramIntent != null)
        localzza.zza(zzt("intent_extra_data", paramIntent));
    }
    return localzza.zzfp(paramString2).zzay(true);
  }

  public static DocumentId zza(String paramString, Intent paramIntent)
  {
    return zzs(paramString, zzg(paramIntent));
  }

  private static DocumentSection zzft(String paramString)
  {
    return new DocumentSection(paramString, new RegisterSectionInfo.zza("title").zzco(1).zzba(true).zzfs("name").zzahr(), "text1");
  }

  private static String zzg(Intent paramIntent)
  {
    paramIntent = paramIntent.toUri(1);
    CRC32 localCRC32 = new CRC32();
    try
    {
      localCRC32.update(paramIntent.getBytes("UTF-8"));
      return Long.toHexString(localCRC32.getValue());
    }
    catch (java.io.UnsupportedEncodingException paramIntent)
    {
    }
    throw new IllegalStateException(paramIntent);
  }

  private static DocumentSection zzk(Uri paramUri)
  {
    return new DocumentSection(paramUri.toString(), new RegisterSectionInfo.zza("web_url").zzco(4).zzaz(true).zzfs("url").zzahr());
  }

  private static DocumentId zzs(String paramString1, String paramString2)
  {
    return new DocumentId(paramString1, "", paramString2);
  }

  private static DocumentSection zzt(String paramString1, String paramString2)
  {
    return new DocumentSection(paramString2, new RegisterSectionInfo.zza(paramString1).zzaz(true).zzahr(), paramString1);
  }

  private static DocumentSection zzv(List<AppIndexApi.AppIndexingLink> paramList)
  {
    zzvw.zza localzza = new zzvw.zza();
    zzvw.zza.zza[] arrayOfzza = new zzvw.zza.zza[paramList.size()];
    int i = 0;
    while (i < arrayOfzza.length)
    {
      arrayOfzza[i] = new zzvw.zza.zza();
      AppIndexApi.AppIndexingLink localAppIndexingLink = (AppIndexApi.AppIndexingLink)paramList.get(i);
      arrayOfzza[i].ahD = localAppIndexingLink.appIndexingUrl.toString();
      arrayOfzza[i].viewId = localAppIndexingLink.viewId;
      if (localAppIndexingLink.webUrl != null)
        arrayOfzza[i].ahE = localAppIndexingLink.webUrl.toString();
      i += 1;
    }
    localzza.ahB = arrayOfzza;
    return new DocumentSection(zzasa.zzf(localzza), new RegisterSectionInfo.zza("outlinks").zzaz(true).zzfs(".private:outLinks").zzfr("blob").zzahr());
  }

  public String toString()
  {
    return String.format(Locale.US, "UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[] { this.gR, Long.valueOf(this.gS), Integer.valueOf(this.gT), Integer.valueOf(this.gX) });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }

  public static final class zza
  {
    private DocumentId gR;
    private long gS = -1L;
    private int gT = -1;
    private DocumentContents gU;
    private boolean gV = false;
    private int gW = -1;
    private int gX = 0;

    public zza zza(DocumentContents paramDocumentContents)
    {
      this.gU = paramDocumentContents;
      return this;
    }

    public zza zza(DocumentId paramDocumentId)
    {
      this.gR = paramDocumentId;
      return this;
    }

    public zza zzaa(long paramLong)
    {
      this.gS = paramLong;
      return this;
    }

    public UsageInfo zzahs()
    {
      return new UsageInfo(this.gR, this.gS, this.gT, null, this.gU, this.gV, this.gW, this.gX, null);
    }

    public zza zzbb(boolean paramBoolean)
    {
      this.gV = paramBoolean;
      return this;
    }

    public zza zzcq(int paramInt)
    {
      this.gT = paramInt;
      return this;
    }

    public zza zzcr(int paramInt)
    {
      this.gX = paramInt;
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.UsageInfo
 * JD-Core Version:    0.6.0
 */