package com.google.android.gms.internal;

import B;
import D;
import F;
import I;
import J;
import Z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzarx
  implements Cloneable
{
  private zzarv<?, ?> btM;
  private List<zzasc> btN = new ArrayList();
  private Object value;

  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzx()];
    zza(zzart.zzbe(arrayOfByte));
    return arrayOfByte;
  }

  public final zzarx cq()
  {
    zzarx localzzarx = new zzarx();
    try
    {
      localzzarx.btM = this.btM;
      if (this.btN == null)
        localzzarx.btN = null;
      while (this.value == null)
      {
        return localzzarx;
        localzzarx.btN.addAll(this.btN);
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    if ((this.value instanceof zzasa))
    {
      localCloneNotSupportedException.value = ((zzasa)((zzasa)this.value).clone());
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof byte[]))
    {
      localCloneNotSupportedException.value = ((byte[])this.value).clone();
      return localCloneNotSupportedException;
    }
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.value instanceof byte[][]))
    {
      localObject1 = (byte[][])this.value;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((this.value instanceof boolean[]))
    {
      localCloneNotSupportedException.value = ((boolean[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof int[]))
    {
      localCloneNotSupportedException.value = ((int[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof long[]))
    {
      localCloneNotSupportedException.value = ((long[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof float[]))
    {
      localCloneNotSupportedException.value = ((float[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof double[]))
    {
      localCloneNotSupportedException.value = ((double[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof zzasa[]))
    {
      localObject1 = (zzasa[])this.value;
      localObject2 = new zzasa[localObject1.length];
      localCloneNotSupportedException.value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((zzasa)localObject1[i].clone());
        i += 1;
      }
    }
    return (zzarx)(zzarx)localCloneNotSupportedException;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this)
      bool1 = true;
    while (true)
    {
      return bool1;
      bool1 = bool2;
      if (!(paramObject instanceof zzarx))
        continue;
      paramObject = (zzarx)paramObject;
      if ((this.value == null) || (paramObject.value == null))
        break;
      bool1 = bool2;
      if (this.btM != paramObject.btM)
        continue;
      if (!this.btM.bkp.isArray())
        return this.value.equals(paramObject.value);
      if ((this.value instanceof byte[]))
        return Arrays.equals((byte[])this.value, (byte[])paramObject.value);
      if ((this.value instanceof int[]))
        return Arrays.equals((int[])this.value, (int[])paramObject.value);
      if ((this.value instanceof long[]))
        return Arrays.equals((long[])this.value, (long[])paramObject.value);
      if ((this.value instanceof float[]))
        return Arrays.equals((float[])this.value, (float[])paramObject.value);
      if ((this.value instanceof double[]))
        return Arrays.equals((double[])this.value, (double[])paramObject.value);
      if ((this.value instanceof boolean[]))
        return Arrays.equals((boolean[])this.value, (boolean[])paramObject.value);
      return Arrays.deepEquals((Object[])this.value, (Object[])paramObject.value);
    }
    if ((this.btN != null) && (paramObject.btN != null))
      return this.btN.equals(paramObject.btN);
    try
    {
      bool1 = Arrays.equals(toByteArray(), paramObject.toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
    }
    throw new IllegalStateException(paramObject);
  }

  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
    }
    throw new IllegalStateException(localIOException);
  }

  void zza(zzart paramzzart)
    throws IOException
  {
    if (this.value != null)
      this.btM.zza(this.value, paramzzart);
    while (true)
    {
      return;
      Iterator localIterator = this.btN.iterator();
      while (localIterator.hasNext())
        ((zzasc)localIterator.next()).zza(paramzzart);
    }
  }

  void zza(zzasc paramzzasc)
  {
    this.btN.add(paramzzasc);
  }

  <T> T zzb(zzarv<?, T> paramzzarv)
  {
    if (this.value != null)
    {
      if (!this.btM.equals(paramzzarv))
        throw new IllegalStateException("Tried to getExtension with a different Extension.");
    }
    else
    {
      this.btM = paramzzarv;
      this.value = paramzzarv.zzay(this.btN);
      this.btN = null;
    }
    return this.value;
  }

  int zzx()
  {
    int j;
    if (this.value != null)
    {
      j = this.btM.zzct(this.value);
      return j;
    }
    Iterator localIterator = this.btN.iterator();
    for (int i = 0; ; i = ((zzasc)localIterator.next()).zzx() + i)
    {
      j = i;
      if (!localIterator.hasNext())
        break;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzarx
 * JD-Core Version:    0.6.0
 */