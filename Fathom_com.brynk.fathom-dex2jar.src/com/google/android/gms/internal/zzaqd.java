package com.google.android.gms.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzaqd extends zzapk<Date>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
    {
      if (paramzzaqo.bB() == Date.class)
        return new zzaqd();
      return null;
    }
  };
  private final DateFormat bnQ = DateFormat.getDateTimeInstance(2, 2, Locale.US);
  private final DateFormat bnR = DateFormat.getDateTimeInstance(2, 2);
  private final DateFormat bnS = bp();

  private static DateFormat bp()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat;
  }

  private Date zzur(String paramString)
  {
    monitorenter;
    try
    {
      Date localDate1 = this.bnR.parse(paramString);
      paramString = localDate1;
      return paramString;
    }
    catch (ParseException localParseException3)
    {
      try
      {
        Date localDate2 = this.bnQ.parse(paramString);
        paramString = localDate2;
      }
      catch (ParseException localParseException3)
      {
        try
        {
          Date localDate3 = this.bnS.parse(paramString);
          paramString = localDate3;
        }
        catch (ParseException localParseException3)
        {
          throw new zzaph(paramString, localParseException3);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramString;
  }

  public void zza(zzaqr paramzzaqr, Date paramDate)
    throws IOException
  {
    monitorenter;
    if (paramDate == null);
    try
    {
      paramzzaqr.bA();
      while (true)
      {
        return;
        paramzzaqr.zzut(this.bnQ.format(paramDate));
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramzzaqr;
  }

  public Date zzk(zzaqp paramzzaqp)
    throws IOException
  {
    if (paramzzaqp.bq() == zzaqq.brJ)
    {
      paramzzaqp.nextNull();
      return null;
    }
    return zzur(paramzzaqp.nextString());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqd
 * JD-Core Version:    0.6.0
 */