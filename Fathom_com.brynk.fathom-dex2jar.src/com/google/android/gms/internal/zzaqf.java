package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class zzaqf extends zzaqp
{
  private static final Reader bpL = new Reader()
  {
    public void close()
      throws IOException
    {
      throw new AssertionError();
    }

    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      throw new AssertionError();
    }
  };
  private static final Object bpM = new Object();
  private final List<Object> bpN = new ArrayList();

  public zzaqf(zzaoy paramzzaoy)
  {
    super(bpL);
    this.bpN.add(paramzzaoy);
  }

  private Object br()
  {
    return this.bpN.get(this.bpN.size() - 1);
  }

  private Object bs()
  {
    return this.bpN.remove(this.bpN.size() - 1);
  }

  private void zza(zzaqq paramzzaqq)
    throws IOException
  {
    if (bq() != paramzzaqq)
    {
      paramzzaqq = String.valueOf(paramzzaqq);
      String str = String.valueOf(bq());
      throw new IllegalStateException(String.valueOf(paramzzaqq).length() + 18 + String.valueOf(str).length() + "Expected " + paramzzaqq + " but was " + str);
    }
  }

  public void beginArray()
    throws IOException
  {
    zza(zzaqq.brB);
    zzaov localzzaov = (zzaov)br();
    this.bpN.add(localzzaov.iterator());
  }

  public void beginObject()
    throws IOException
  {
    zza(zzaqq.brD);
    zzapb localzzapb = (zzapb)br();
    this.bpN.add(localzzapb.entrySet().iterator());
  }

  public zzaqq bq()
    throws IOException
  {
    if (this.bpN.isEmpty())
      return zzaqq.brK;
    Object localObject = br();
    if ((localObject instanceof Iterator))
    {
      boolean bool = this.bpN.get(this.bpN.size() - 2) instanceof zzapb;
      localObject = (Iterator)localObject;
      if (((Iterator)localObject).hasNext())
      {
        if (bool)
          return zzaqq.brF;
        this.bpN.add(((Iterator)localObject).next());
        return bq();
      }
      if (bool)
        return zzaqq.brE;
      return zzaqq.brC;
    }
    if ((localObject instanceof zzapb))
      return zzaqq.brD;
    if ((localObject instanceof zzaov))
      return zzaqq.brB;
    if ((localObject instanceof zzape))
    {
      localObject = (zzape)localObject;
      if (((zzape)localObject).bf())
        return zzaqq.brG;
      if (((zzape)localObject).bd())
        return zzaqq.brI;
      if (((zzape)localObject).be())
        return zzaqq.brH;
      throw new AssertionError();
    }
    if ((localObject instanceof zzapa))
      return zzaqq.brJ;
    if (localObject == bpM)
      throw new IllegalStateException("JsonReader is closed");
    throw new AssertionError();
  }

  public void bt()
    throws IOException
  {
    zza(zzaqq.brF);
    Map.Entry localEntry = (Map.Entry)((Iterator)br()).next();
    this.bpN.add(localEntry.getValue());
    this.bpN.add(new zzape((String)localEntry.getKey()));
  }

  public void close()
    throws IOException
  {
    this.bpN.clear();
    this.bpN.add(bpM);
  }

  public void endArray()
    throws IOException
  {
    zza(zzaqq.brC);
    bs();
    bs();
  }

  public void endObject()
    throws IOException
  {
    zza(zzaqq.brE);
    bs();
    bs();
  }

  public boolean hasNext()
    throws IOException
  {
    zzaqq localzzaqq = bq();
    return (localzzaqq != zzaqq.brE) && (localzzaqq != zzaqq.brC);
  }

  public boolean nextBoolean()
    throws IOException
  {
    zza(zzaqq.brI);
    return ((zzape)bs()).getAsBoolean();
  }

  public double nextDouble()
    throws IOException
  {
    Object localObject = bq();
    if ((localObject != zzaqq.brH) && (localObject != zzaqq.brG))
    {
      String str = String.valueOf(zzaqq.brH);
      localObject = String.valueOf(localObject);
      throw new IllegalStateException(String.valueOf(str).length() + 18 + String.valueOf(localObject).length() + "Expected " + str + " but was " + (String)localObject);
    }
    double d = ((zzape)br()).getAsDouble();
    if ((!isLenient()) && ((Double.isNaN(d)) || (Double.isInfinite(d))))
      throw new NumberFormatException(57 + "JSON forbids NaN and infinities: " + d);
    bs();
    return d;
  }

  public int nextInt()
    throws IOException
  {
    Object localObject = bq();
    if ((localObject != zzaqq.brH) && (localObject != zzaqq.brG))
    {
      String str = String.valueOf(zzaqq.brH);
      localObject = String.valueOf(localObject);
      throw new IllegalStateException(String.valueOf(str).length() + 18 + String.valueOf(localObject).length() + "Expected " + str + " but was " + (String)localObject);
    }
    int i = ((zzape)br()).getAsInt();
    bs();
    return i;
  }

  public long nextLong()
    throws IOException
  {
    Object localObject = bq();
    if ((localObject != zzaqq.brH) && (localObject != zzaqq.brG))
    {
      String str = String.valueOf(zzaqq.brH);
      localObject = String.valueOf(localObject);
      throw new IllegalStateException(String.valueOf(str).length() + 18 + String.valueOf(localObject).length() + "Expected " + str + " but was " + (String)localObject);
    }
    long l = ((zzape)br()).getAsLong();
    bs();
    return l;
  }

  public String nextName()
    throws IOException
  {
    zza(zzaqq.brF);
    Map.Entry localEntry = (Map.Entry)((Iterator)br()).next();
    this.bpN.add(localEntry.getValue());
    return (String)localEntry.getKey();
  }

  public void nextNull()
    throws IOException
  {
    zza(zzaqq.brJ);
    bs();
  }

  public String nextString()
    throws IOException
  {
    Object localObject = bq();
    if ((localObject != zzaqq.brG) && (localObject != zzaqq.brH))
    {
      String str = String.valueOf(zzaqq.brG);
      localObject = String.valueOf(localObject);
      throw new IllegalStateException(String.valueOf(str).length() + 18 + String.valueOf(localObject).length() + "Expected " + str + " but was " + (String)localObject);
    }
    return (String)((zzape)bs()).aU();
  }

  public void skipValue()
    throws IOException
  {
    if (bq() == zzaqq.brF)
    {
      nextName();
      return;
    }
    bs();
  }

  public String toString()
  {
    return getClass().getSimpleName();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqf
 * JD-Core Version:    0.6.0
 */