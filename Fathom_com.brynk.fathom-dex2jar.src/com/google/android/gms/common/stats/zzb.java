package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzsi;

public final class zzb
{
  public static zzsi<Integer> FH = zzsi.zza("gms:common:stats:max_num_of_events", Integer.valueOf(100));
  public static zzsi<Integer> FI = zzsi.zza("gms:common:stats:max_chunk_size", Integer.valueOf(100));

  public static final class zza
  {
    public static zzsi<Integer> FJ = zzsi.zza("gms:common:stats:connections:level", Integer.valueOf(zzc.LOG_LEVEL_OFF));
    public static zzsi<String> FK = zzsi.zzaa("gms:common:stats:connections:ignored_calling_processes", "");
    public static zzsi<String> FL = zzsi.zzaa("gms:common:stats:connections:ignored_calling_services", "");
    public static zzsi<String> FM = zzsi.zzaa("gms:common:stats:connections:ignored_target_processes", "");
    public static zzsi<String> FN = zzsi.zzaa("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
    public static zzsi<Long> FO = zzsi.zza("gms:common:stats:connections:time_out_duration", Long.valueOf(600000L));
  }

  public static final class zzb
  {
    public static zzsi<Integer> FJ = zzsi.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzc.LOG_LEVEL_OFF));
    public static zzsi<Long> FO = zzsi.zza("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000L));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.zzb
 * JD-Core Version:    0.6.0
 */