package com.google.android.gms.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class zzaqk extends zzapk<java.sql.Date>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
    {
      if (paramzzaqo.bB() == java.sql.Date.class)
        return new zzaqk();
      return null;
    }
  };
  private final DateFormat bqg = new SimpleDateFormat("MMM d, yyyy");

  public void zza(zzaqr paramzzaqr, java.sql.Date paramDate)
    throws IOException
  {
    monitorenter;
    if (paramDate == null)
      paramDate = null;
    try
    {
      while (true)
      {
        paramzzaqr.zzut(paramDate);
        return;
        paramDate = this.bqg.format(paramDate);
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramzzaqr;
  }

  public java.sql.Date zzm(zzaqp paramzzaqp)
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
          paramzzaqp = new java.sql.Date(this.bqg.parse(paramzzaqp.nextString()).getTime());
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
 * Qualified Name:     com.google.android.gms.internal.zzaqk
 * JD-Core Version:    0.6.0
 */