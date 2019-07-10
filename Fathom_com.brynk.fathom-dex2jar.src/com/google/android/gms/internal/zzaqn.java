package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzaqn
{
  public static final zzapl bqA;
  public static final zzapk<Character> bqB;
  public static final zzapl bqC;
  public static final zzapk<String> bqD;
  public static final zzapk<BigDecimal> bqE;
  public static final zzapk<BigInteger> bqF;
  public static final zzapl bqG;
  public static final zzapk<StringBuilder> bqH;
  public static final zzapl bqI;
  public static final zzapk<StringBuffer> bqJ;
  public static final zzapl bqK;
  public static final zzapk<URL> bqL;
  public static final zzapl bqM;
  public static final zzapk<URI> bqN;
  public static final zzapl bqO;
  public static final zzapk<InetAddress> bqP;
  public static final zzapl bqQ;
  public static final zzapk<UUID> bqR;
  public static final zzapl bqS;
  public static final zzapl bqT;
  public static final zzapk<Calendar> bqU;
  public static final zzapl bqV;
  public static final zzapk<Locale> bqW;
  public static final zzapl bqX;
  public static final zzapk<zzaoy> bqY;
  public static final zzapl bqZ;
  public static final zzapk<Class> bqj = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Class paramClass)
      throws IOException
    {
      if (paramClass == null)
      {
        paramzzaqr.bA();
        return;
      }
      paramzzaqr = String.valueOf(paramClass.getName());
      throw new UnsupportedOperationException(String.valueOf(paramzzaqr).length() + 76 + "Attempted to serialize java.lang.Class: " + paramzzaqr + ". Forgot to register a type adapter?");
    }

    public Class zzo(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }
  };
  public static final zzapl bqk = zza(Class.class, bqj);
  public static final zzapk<BitSet> bql = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, BitSet paramBitSet)
      throws IOException
    {
      if (paramBitSet == null)
      {
        paramzzaqr.bA();
        return;
      }
      paramzzaqr.bw();
      int i = 0;
      if (i < paramBitSet.length())
      {
        if (paramBitSet.get(i));
        int k;
        for (int j = 1; ; k = 0)
        {
          paramzzaqr.zzcs(j);
          i += 1;
          break;
        }
      }
      paramzzaqr.bx();
    }

    public BitSet zzx(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      BitSet localBitSet = new BitSet();
      paramzzaqp.beginArray();
      Object localObject = paramzzaqp.bq();
      int i = 0;
      if (localObject != zzaqq.brC)
      {
        boolean bool;
        switch (zzaqn.26.bpW[localObject.ordinal()])
        {
        default:
          paramzzaqp = String.valueOf(localObject);
          throw new zzaph(String.valueOf(paramzzaqp).length() + 27 + "Invalid bitset value type: " + paramzzaqp);
        case 1:
          if (paramzzaqp.nextInt() == 0)
            break;
          bool = true;
        case 2:
        case 3:
        }
        while (true)
        {
          if (bool)
            localBitSet.set(i);
          i += 1;
          localObject = paramzzaqp.bq();
          break;
          bool = false;
          continue;
          bool = paramzzaqp.nextBoolean();
          continue;
          localObject = paramzzaqp.nextString();
          try
          {
            int j = Integer.parseInt((String)localObject);
            if (j != 0)
            {
              bool = true;
              continue;
            }
            bool = false;
          }
          catch (java.lang.NumberFormatException paramzzaqp)
          {
            paramzzaqp = String.valueOf(localObject);
            if (paramzzaqp.length() == 0);
          }
        }
        for (paramzzaqp = "Error: Expecting: bitset number value (1, 0), Found: ".concat(paramzzaqp); ; paramzzaqp = new String("Error: Expecting: bitset number value (1, 0), Found: "))
          throw new zzaph(paramzzaqp);
      }
      paramzzaqp.endArray();
      return (BitSet)localBitSet;
    }
  };
  public static final zzapl bqm = zza(BitSet.class, bql);
  public static final zzapk<Boolean> bqn = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Boolean paramBoolean)
      throws IOException
    {
      if (paramBoolean == null)
      {
        paramzzaqr.bA();
        return;
      }
      paramzzaqr.zzdh(paramBoolean.booleanValue());
    }

    public Boolean zzae(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      if (paramzzaqp.bq() == zzaqq.brG)
        return Boolean.valueOf(Boolean.parseBoolean(paramzzaqp.nextString()));
      return Boolean.valueOf(paramzzaqp.nextBoolean());
    }
  };
  public static final zzapk<Boolean> bqo = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Boolean paramBoolean)
      throws IOException
    {
      if (paramBoolean == null);
      for (paramBoolean = "null"; ; paramBoolean = paramBoolean.toString())
      {
        paramzzaqr.zzut(paramBoolean);
        return;
      }
    }

    public Boolean zzae(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      return Boolean.valueOf(paramzzaqp.nextString());
    }
  };
  public static final zzapl bqp = zza(Boolean.TYPE, Boolean.class, bqn);
  public static final zzapk<Number> bqq = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Number paramNumber)
      throws IOException
    {
      paramzzaqr.zza(paramNumber);
    }

    public Number zzg(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      try
      {
        byte b = (byte)paramzzaqp.nextInt();
        return Byte.valueOf(b);
      }
      catch (java.lang.NumberFormatException paramzzaqp)
      {
      }
      throw new zzaph(paramzzaqp);
    }
  };
  public static final zzapl bqr = zza(Byte.TYPE, Byte.class, bqq);
  public static final zzapk<Number> bqs = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Number paramNumber)
      throws IOException
    {
      paramzzaqr.zza(paramNumber);
    }

    public Number zzg(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      try
      {
        short s = (short)paramzzaqp.nextInt();
        return Short.valueOf(s);
      }
      catch (java.lang.NumberFormatException paramzzaqp)
      {
      }
      throw new zzaph(paramzzaqp);
    }
  };
  public static final zzapl bqt = zza(Short.TYPE, Short.class, bqs);
  public static final zzapk<Number> bqu = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Number paramNumber)
      throws IOException
    {
      paramzzaqr.zza(paramNumber);
    }

    public Number zzg(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      try
      {
        int i = paramzzaqp.nextInt();
        return Integer.valueOf(i);
      }
      catch (java.lang.NumberFormatException paramzzaqp)
      {
      }
      throw new zzaph(paramzzaqp);
    }
  };
  public static final zzapl bqv = zza(Integer.TYPE, Integer.class, bqu);
  public static final zzapk<Number> bqw = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Number paramNumber)
      throws IOException
    {
      paramzzaqr.zza(paramNumber);
    }

    public Number zzg(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      try
      {
        long l = paramzzaqp.nextLong();
        return Long.valueOf(l);
      }
      catch (java.lang.NumberFormatException paramzzaqp)
      {
      }
      throw new zzaph(paramzzaqp);
    }
  };
  public static final zzapk<Number> bqx = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Number paramNumber)
      throws IOException
    {
      paramzzaqr.zza(paramNumber);
    }

    public Number zzg(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      return Float.valueOf((float)paramzzaqp.nextDouble());
    }
  };
  public static final zzapk<Number> bqy = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Number paramNumber)
      throws IOException
    {
      paramzzaqr.zza(paramNumber);
    }

    public Number zzg(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      return Double.valueOf(paramzzaqp.nextDouble());
    }
  };
  public static final zzapk<Number> bqz = new zzapk()
  {
    public void zza(zzaqr paramzzaqr, Number paramNumber)
      throws IOException
    {
      paramzzaqr.zza(paramNumber);
    }

    public Number zzg(zzaqp paramzzaqp)
      throws IOException
    {
      zzaqq localzzaqq = paramzzaqp.bq();
      switch (zzaqn.26.bpW[localzzaqq.ordinal()])
      {
      case 2:
      case 3:
      default:
        paramzzaqp = String.valueOf(localzzaqq);
        throw new zzaph(String.valueOf(paramzzaqp).length() + 23 + "Expecting number, got: " + paramzzaqp);
      case 4:
        paramzzaqp.nextNull();
        return null;
      case 1:
      }
      return new zzapv(paramzzaqp.nextString());
    }
  };
  public static final zzapl bra;

  static
  {
    bqA = zza(Number.class, bqz);
    bqB = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, Character paramCharacter)
        throws IOException
      {
        if (paramCharacter == null);
        for (paramCharacter = null; ; paramCharacter = String.valueOf(paramCharacter))
        {
          paramzzaqr.zzut(paramCharacter);
          return;
        }
      }

      public Character zzp(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        paramzzaqp = paramzzaqp.nextString();
        if (paramzzaqp.length() != 1)
        {
          paramzzaqp = String.valueOf(paramzzaqp);
          if (paramzzaqp.length() != 0);
          for (paramzzaqp = "Expecting character, got: ".concat(paramzzaqp); ; paramzzaqp = new String("Expecting character, got: "))
            throw new zzaph(paramzzaqp);
        }
        return Character.valueOf(paramzzaqp.charAt(0));
      }
    };
    bqC = zza(Character.TYPE, Character.class, bqB);
    bqD = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, String paramString)
        throws IOException
      {
        paramzzaqr.zzut(paramString);
      }

      public String zzq(zzaqp paramzzaqp)
        throws IOException
      {
        zzaqq localzzaqq = paramzzaqp.bq();
        if (localzzaqq == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        if (localzzaqq == zzaqq.brI)
          return Boolean.toString(paramzzaqp.nextBoolean());
        return paramzzaqp.nextString();
      }
    };
    bqE = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, BigDecimal paramBigDecimal)
        throws IOException
      {
        paramzzaqr.zza(paramBigDecimal);
      }

      public BigDecimal zzr(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        try
        {
          paramzzaqp = new BigDecimal(paramzzaqp.nextString());
          return paramzzaqp;
        }
        catch (java.lang.NumberFormatException paramzzaqp)
        {
        }
        throw new zzaph(paramzzaqp);
      }
    };
    bqF = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, BigInteger paramBigInteger)
        throws IOException
      {
        paramzzaqr.zza(paramBigInteger);
      }

      public BigInteger zzs(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        try
        {
          paramzzaqp = new BigInteger(paramzzaqp.nextString());
          return paramzzaqp;
        }
        catch (java.lang.NumberFormatException paramzzaqp)
        {
        }
        throw new zzaph(paramzzaqp);
      }
    };
    bqG = zza(String.class, bqD);
    bqH = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, StringBuilder paramStringBuilder)
        throws IOException
      {
        if (paramStringBuilder == null);
        for (paramStringBuilder = null; ; paramStringBuilder = paramStringBuilder.toString())
        {
          paramzzaqr.zzut(paramStringBuilder);
          return;
        }
      }

      public StringBuilder zzt(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        return new StringBuilder(paramzzaqp.nextString());
      }
    };
    bqI = zza(StringBuilder.class, bqH);
    bqJ = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, StringBuffer paramStringBuffer)
        throws IOException
      {
        if (paramStringBuffer == null);
        for (paramStringBuffer = null; ; paramStringBuffer = paramStringBuffer.toString())
        {
          paramzzaqr.zzut(paramStringBuffer);
          return;
        }
      }

      public StringBuffer zzu(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        return new StringBuffer(paramzzaqp.nextString());
      }
    };
    bqK = zza(StringBuffer.class, bqJ);
    bqL = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, URL paramURL)
        throws IOException
      {
        if (paramURL == null);
        for (paramURL = null; ; paramURL = paramURL.toExternalForm())
        {
          paramzzaqr.zzut(paramURL);
          return;
        }
      }

      public URL zzv(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
          paramzzaqp.nextNull();
        do
        {
          return null;
          paramzzaqp = paramzzaqp.nextString();
        }
        while ("null".equals(paramzzaqp));
        return new URL(paramzzaqp);
      }
    };
    bqM = zza(URL.class, bqL);
    bqN = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, URI paramURI)
        throws IOException
      {
        if (paramURI == null);
        for (paramURI = null; ; paramURI = paramURI.toASCIIString())
        {
          paramzzaqr.zzut(paramURI);
          return;
        }
      }

      public URI zzw(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
          paramzzaqp.nextNull();
        while (true)
        {
          return null;
          try
          {
            paramzzaqp = paramzzaqp.nextString();
            if ("null".equals(paramzzaqp))
              continue;
            paramzzaqp = new URI(paramzzaqp);
            return paramzzaqp;
          }
          catch (java.net.URISyntaxException paramzzaqp)
          {
          }
        }
        throw new zzaoz(paramzzaqp);
      }
    };
    bqO = zza(URI.class, bqN);
    bqP = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, InetAddress paramInetAddress)
        throws IOException
      {
        if (paramInetAddress == null);
        for (paramInetAddress = null; ; paramInetAddress = paramInetAddress.getHostAddress())
        {
          paramzzaqr.zzut(paramInetAddress);
          return;
        }
      }

      public InetAddress zzy(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        return InetAddress.getByName(paramzzaqp.nextString());
      }
    };
    bqQ = zzb(InetAddress.class, bqP);
    bqR = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, UUID paramUUID)
        throws IOException
      {
        if (paramUUID == null);
        for (paramUUID = null; ; paramUUID = paramUUID.toString())
        {
          paramzzaqr.zzut(paramUUID);
          return;
        }
      }

      public UUID zzz(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        return UUID.fromString(paramzzaqp.nextString());
      }
    };
    bqS = zza(UUID.class, bqR);
    bqT = new zzapl()
    {
      public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
      {
        if (paramzzaqo.bB() != Timestamp.class)
          return null;
        return new zzapk(paramzzaos.zzk(Date.class))
        {
          public void zza(zzaqr paramzzaqr, Timestamp paramTimestamp)
            throws IOException
          {
            this.brb.zza(paramzzaqr, paramTimestamp);
          }

          public Timestamp zzaa(zzaqp paramzzaqp)
            throws IOException
          {
            paramzzaqp = (Date)this.brb.zzb(paramzzaqp);
            if (paramzzaqp != null)
              return new Timestamp(paramzzaqp.getTime());
            return null;
          }
        };
      }
    };
    bqU = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, Calendar paramCalendar)
        throws IOException
      {
        if (paramCalendar == null)
        {
          paramzzaqr.bA();
          return;
        }
        paramzzaqr.by();
        paramzzaqr.zzus("year");
        paramzzaqr.zzcs(paramCalendar.get(1));
        paramzzaqr.zzus("month");
        paramzzaqr.zzcs(paramCalendar.get(2));
        paramzzaqr.zzus("dayOfMonth");
        paramzzaqr.zzcs(paramCalendar.get(5));
        paramzzaqr.zzus("hourOfDay");
        paramzzaqr.zzcs(paramCalendar.get(11));
        paramzzaqr.zzus("minute");
        paramzzaqr.zzcs(paramCalendar.get(12));
        paramzzaqr.zzus("second");
        paramzzaqr.zzcs(paramCalendar.get(13));
        paramzzaqr.bz();
      }

      public Calendar zzab(zzaqp paramzzaqp)
        throws IOException
      {
        int j = 0;
        if (paramzzaqp.bq() == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        paramzzaqp.beginObject();
        int k = 0;
        int m = 0;
        int n = 0;
        int i1 = 0;
        int i2 = 0;
        while (paramzzaqp.bq() != zzaqq.brE)
        {
          String str = paramzzaqp.nextName();
          int i = paramzzaqp.nextInt();
          if ("year".equals(str))
          {
            i2 = i;
            continue;
          }
          if ("month".equals(str))
          {
            i1 = i;
            continue;
          }
          if ("dayOfMonth".equals(str))
          {
            n = i;
            continue;
          }
          if ("hourOfDay".equals(str))
          {
            m = i;
            continue;
          }
          if ("minute".equals(str))
          {
            k = i;
            continue;
          }
          if (!"second".equals(str))
            continue;
          j = i;
        }
        paramzzaqp.endObject();
        return new GregorianCalendar(i2, i1, n, m, k, j);
      }
    };
    bqV = zzb(Calendar.class, GregorianCalendar.class, bqU);
    bqW = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, Locale paramLocale)
        throws IOException
      {
        if (paramLocale == null);
        for (paramLocale = null; ; paramLocale = paramLocale.toString())
        {
          paramzzaqr.zzut(paramLocale);
          return;
        }
      }

      public Locale zzac(zzaqp paramzzaqp)
        throws IOException
      {
        if (paramzzaqp.bq() == zzaqq.brJ)
        {
          paramzzaqp.nextNull();
          return null;
        }
        Object localObject = new StringTokenizer(paramzzaqp.nextString(), "_");
        if (((StringTokenizer)localObject).hasMoreElements());
        for (paramzzaqp = ((StringTokenizer)localObject).nextToken(); ; paramzzaqp = null)
        {
          if (((StringTokenizer)localObject).hasMoreElements());
          for (String str = ((StringTokenizer)localObject).nextToken(); ; str = null)
          {
            if (((StringTokenizer)localObject).hasMoreElements());
            for (localObject = ((StringTokenizer)localObject).nextToken(); ; localObject = null)
            {
              if ((str == null) && (localObject == null))
                return new Locale(paramzzaqp);
              if (localObject == null)
                return new Locale(paramzzaqp, str);
              return new Locale(paramzzaqp, str, (String)localObject);
            }
          }
        }
      }
    };
    bqX = zza(Locale.class, bqW);
    bqY = new zzapk()
    {
      public void zza(zzaqr paramzzaqr, zzaoy paramzzaoy)
        throws IOException
      {
        if ((paramzzaoy == null) || (paramzzaoy.aY()))
        {
          paramzzaqr.bA();
          return;
        }
        if (paramzzaoy.aX())
        {
          paramzzaoy = paramzzaoy.bb();
          if (paramzzaoy.be())
          {
            paramzzaqr.zza(paramzzaoy.aT());
            return;
          }
          if (paramzzaoy.bd())
          {
            paramzzaqr.zzdh(paramzzaoy.getAsBoolean());
            return;
          }
          paramzzaqr.zzut(paramzzaoy.aU());
          return;
        }
        if (paramzzaoy.aV())
        {
          paramzzaqr.bw();
          paramzzaoy = paramzzaoy.ba().iterator();
          while (paramzzaoy.hasNext())
            zza(paramzzaqr, (zzaoy)paramzzaoy.next());
          paramzzaqr.bx();
          return;
        }
        if (paramzzaoy.aW())
        {
          paramzzaqr.by();
          paramzzaoy = paramzzaoy.aZ().entrySet().iterator();
          while (paramzzaoy.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramzzaoy.next();
            paramzzaqr.zzus((String)localEntry.getKey());
            zza(paramzzaqr, (zzaoy)localEntry.getValue());
          }
          paramzzaqr.bz();
          return;
        }
        paramzzaqr = String.valueOf(paramzzaoy.getClass());
        throw new IllegalArgumentException(String.valueOf(paramzzaqr).length() + 15 + "Couldn't write " + paramzzaqr);
      }

      public zzaoy zzad(zzaqp paramzzaqp)
        throws IOException
      {
        switch (zzaqn.26.bpW[paramzzaqp.bq().ordinal()])
        {
        default:
          throw new IllegalArgumentException();
        case 3:
          return new zzape(paramzzaqp.nextString());
        case 1:
          return new zzape(new zzapv(paramzzaqp.nextString()));
        case 2:
          return new zzape(Boolean.valueOf(paramzzaqp.nextBoolean()));
        case 4:
          paramzzaqp.nextNull();
          return zzapa.bou;
        case 5:
          localObject = new zzaov();
          paramzzaqp.beginArray();
          while (paramzzaqp.hasNext())
            ((zzaov)localObject).zzc((zzaoy)zzb(paramzzaqp));
          paramzzaqp.endArray();
          return localObject;
        case 6:
        }
        Object localObject = new zzapb();
        paramzzaqp.beginObject();
        while (paramzzaqp.hasNext())
          ((zzapb)localObject).zza(paramzzaqp.nextName(), (zzaoy)zzb(paramzzaqp));
        paramzzaqp.endObject();
        return (zzaoy)localObject;
      }
    };
    bqZ = zzb(zzaoy.class, bqY);
    bra = new zzapl()
    {
      public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
      {
        paramzzaqo = paramzzaqo.bB();
        if ((!Enum.class.isAssignableFrom(paramzzaqo)) || (paramzzaqo == Enum.class))
          return null;
        paramzzaos = paramzzaqo;
        if (!paramzzaqo.isEnum())
          paramzzaos = paramzzaqo.getSuperclass();
        return new zzaqn.zza(paramzzaos);
      }
    };
  }

  public static <TT> zzapl zza(zzaqo<TT> paramzzaqo, zzapk<TT> paramzzapk)
  {
    return new zzapl(paramzzaqo, paramzzapk)
    {
      public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
      {
        if (paramzzaqo.equals(this.bpf))
          return this.brd;
        return null;
      }
    };
  }

  public static <TT> zzapl zza(Class<TT> paramClass, zzapk<TT> paramzzapk)
  {
    return new zzapl(paramClass, paramzzapk)
    {
      public String toString()
      {
        String str1 = String.valueOf(this.bre.getName());
        String str2 = String.valueOf(this.brd);
        return String.valueOf(str1).length() + 23 + String.valueOf(str2).length() + "Factory[type=" + str1 + ",adapter=" + str2 + "]";
      }

      public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
      {
        if (paramzzaqo.bB() == this.bre)
          return this.brd;
        return null;
      }
    };
  }

  public static <TT> zzapl zza(Class<TT> paramClass1, Class<TT> paramClass2, zzapk<? super TT> paramzzapk)
  {
    return new zzapl(paramClass1, paramClass2, paramzzapk)
    {
      public String toString()
      {
        String str1 = String.valueOf(this.brg.getName());
        String str2 = String.valueOf(this.brf.getName());
        String str3 = String.valueOf(this.brd);
        return String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + String.valueOf(str3).length() + "Factory[type=" + str1 + "+" + str2 + ",adapter=" + str3 + "]";
      }

      public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
      {
        paramzzaos = paramzzaqo.bB();
        if ((paramzzaos == this.brf) || (paramzzaos == this.brg))
          return this.brd;
        return null;
      }
    };
  }

  public static <TT> zzapl zzb(Class<TT> paramClass, zzapk<TT> paramzzapk)
  {
    return new zzapl(paramClass, paramzzapk)
    {
      public String toString()
      {
        String str1 = String.valueOf(this.brj.getName());
        String str2 = String.valueOf(this.brd);
        return String.valueOf(str1).length() + 32 + String.valueOf(str2).length() + "Factory[typeHierarchy=" + str1 + ",adapter=" + str2 + "]";
      }

      public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
      {
        if (this.brj.isAssignableFrom(paramzzaqo.bB()))
          return this.brd;
        return null;
      }
    };
  }

  public static <TT> zzapl zzb(Class<TT> paramClass, Class<? extends TT> paramClass1, zzapk<? super TT> paramzzapk)
  {
    return new zzapl(paramClass, paramClass1, paramzzapk)
    {
      public String toString()
      {
        String str1 = String.valueOf(this.brh.getName());
        String str2 = String.valueOf(this.bri.getName());
        String str3 = String.valueOf(this.brd);
        return String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + String.valueOf(str3).length() + "Factory[type=" + str1 + "+" + str2 + ",adapter=" + str3 + "]";
      }

      public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
      {
        paramzzaos = paramzzaqo.bB();
        if ((paramzzaos == this.brh) || (paramzzaos == this.bri))
          return this.brd;
        return null;
      }
    };
  }

  private static final class zza<T extends Enum<T>> extends zzapk<T>
  {
    private final Map<String, T> brk = new HashMap();
    private final Map<T, String> brl = new HashMap();

    public zza(Class<T> paramClass)
    {
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int k = arrayOfEnum.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = arrayOfEnum[i];
          Object localObject1 = localEnum.name();
          Object localObject2 = (zzapn)paramClass.getField((String)localObject1).getAnnotation(zzapn.class);
          if (localObject2 != null)
          {
            String str = ((zzapn)localObject2).value();
            localObject2 = ((zzapn)localObject2).bh();
            int m = localObject2.length;
            int j = 0;
            while (true)
            {
              localObject1 = str;
              if (j >= m)
                break;
              localObject1 = localObject2[j];
              this.brk.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.brk.put(localObject1, localEnum);
          this.brl.put(localEnum, localObject1);
          i += 1;
        }
      }
      catch (java.lang.NoSuchFieldException paramClass)
      {
        throw new AssertionError();
      }
    }

    public void zza(zzaqr paramzzaqr, T paramT)
      throws IOException
    {
      if (paramT == null);
      for (paramT = null; ; paramT = (String)this.brl.get(paramT))
      {
        paramzzaqr.zzut(paramT);
        return;
      }
    }

    public T zzaf(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ)
      {
        paramzzaqp.nextNull();
        return null;
      }
      return (Enum)this.brk.get(paramzzaqp.nextString());
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqn
 * JD-Core Version:    0.6.0
 */