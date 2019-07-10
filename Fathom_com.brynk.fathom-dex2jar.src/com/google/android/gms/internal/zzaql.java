package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class zzaql extends zzapk<Time>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
    {
      if (paramzzaqo.bB() == Time.class)
        return new zzaql();
      return null;
    }
  };
  private final DateFormat bqg = new SimpleDateFormat("hh:mm:ss a");

  public void zza(zzaqr paramzzaqr, Time paramTime)
    throws IOException
  {
    monitorenter;
    if (paramTime == null)
      paramTime = null;
    try
    {
      while (true)
      {
        paramzzaqr.zzut(paramTime);
        return;
        paramTime = this.bqg.format(paramTime);
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramzzaqr;
  }

  public Time zzn(zzaqp paramzzaqp)
    throws IOException
  {
    monitorenter;
    try
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        paramzzaqp = null;
      }
      while (true)
      {
        return paramzzaqp;
        try
        {
          paramzzaqp = new Time(this.bqg.parse(paramzzaqp.nextString()).getTime());
        }
        catch (java.text.ParseException paramzzaqp)
        {
          throw new zzaph(paramzzaqp);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramzzaqp;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaql
 * JD-Core Version:    0.6.0
 */