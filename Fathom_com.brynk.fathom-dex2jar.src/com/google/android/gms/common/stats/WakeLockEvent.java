package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzf();
  private final long Ga;
  private int Gb;
  private final String Gc;
  private final String Gd;
  private final String Ge;
  private final int Gf;
  private final List<String> Gg;
  private final String Gh;
  private final long Gi;
  private int Gj;
  private final String Gk;
  private final float Gl;
  private long Gm;
  private final long mTimeout;
  final int mVersionCode;

  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this.mVersionCode = paramInt1;
    this.Ga = paramLong1;
    this.Gb = paramInt2;
    this.Gc = paramString1;
    this.Gd = paramString3;
    this.Ge = paramString5;
    this.Gf = paramInt3;
    this.Gm = -1L;
    this.Gg = paramList;
    this.Gh = paramString2;
    this.Gi = paramLong2;
    this.Gj = paramInt4;
    this.Gk = paramString4;
    this.Gl = paramFloat;
    this.mTimeout = paramLong3;
  }

  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5);
  }

  public int getEventType()
  {
    return this.Gb;
  }

  public long getTimeMillis()
  {
    return this.Ga;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }

  public long zzaxt()
  {
    return this.Gm;
  }

  public String zzaxu()
  {
    String str5 = String.valueOf("\t");
    String str6 = String.valueOf(zzaxv());
    String str7 = String.valueOf("\t");
    int i = zzaxy();
    String str8 = String.valueOf("\t");
    String str1;
    String str9;
    int j;
    String str10;
    String str2;
    label76: String str11;
    String str3;
    label94: String str12;
    float f;
    String str13;
    if (zzaxz() == null)
    {
      str1 = "";
      str9 = String.valueOf("\t");
      j = zzayc();
      str10 = String.valueOf("\t");
      if (zzaxw() != null)
        break label345;
      str2 = "";
      str11 = String.valueOf("\t");
      if (zzayd() != null)
        break label354;
      str3 = "";
      str12 = String.valueOf("\t");
      f = zzaye();
      str13 = String.valueOf("\t");
      if (zzaxx() != null)
        break label363;
    }
    label345: label354: label363: for (String str4 = ""; ; str4 = zzaxx())
    {
      return String.valueOf(str5).length() + 37 + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str1).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str2).length() + String.valueOf(str11).length() + String.valueOf(str3).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str4).length() + str5 + str6 + str7 + i + str8 + str1 + str9 + j + str10 + str2 + str11 + str3 + str12 + f + str13 + str4;
      str1 = TextUtils.join(",", zzaxz());
      break;
      str2 = zzaxw();
      break label76;
      str3 = zzayd();
      break label94;
    }
  }

  public String zzaxv()
  {
    return this.Gc;
  }

  public String zzaxw()
  {
    return this.Gd;
  }

  public String zzaxx()
  {
    return this.Ge;
  }

  public int zzaxy()
  {
    return this.Gf;
  }

  public List<String> zzaxz()
  {
    return this.Gg;
  }

  public String zzaya()
  {
    return this.Gh;
  }

  public long zzayb()
  {
    return this.Gi;
  }

  public int zzayc()
  {
    return this.Gj;
  }

  public String zzayd()
  {
    return this.Gk;
  }

  public float zzaye()
  {
    return this.Gl;
  }

  public long zzayf()
  {
    return this.mTimeout;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockEvent
 * JD-Core Version:    0.6.0
 */