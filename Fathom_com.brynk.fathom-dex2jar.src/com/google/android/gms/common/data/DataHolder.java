package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzc;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepName
public final class DataHolder extends AbstractSafeParcelable
  implements Closeable
{
  public static final Parcelable.Creator<DataHolder> CREATOR = new zze();
  private static final zza Cf = new zza(null)
  {
    public DataHolder.zza zza(ContentValues paramContentValues)
    {
      throw new UnsupportedOperationException("Cannot add data to empty builder");
    }

    public DataHolder.zza zzb(HashMap<String, Object> paramHashMap)
    {
      throw new UnsupportedOperationException("Cannot add data to empty builder");
    }
  };
  private final String[] BY;
  Bundle BZ;
  private final CursorWindow[] Ca;
  private final Bundle Cb;
  int[] Cc;
  int Cd;
  private boolean Ce = true;
  boolean mClosed = false;
  final int mVersionCode;
  private final int uo;

  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    this.mVersionCode = paramInt1;
    this.BY = paramArrayOfString;
    this.Ca = paramArrayOfCursorWindow;
    this.uo = paramInt2;
    this.Cb = paramBundle;
  }

  private DataHolder(zza paramzza, int paramInt, Bundle paramBundle)
  {
    this(zza.zza(paramzza), zza(paramzza, -1), paramInt, paramBundle);
  }

  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    this.mVersionCode = 1;
    this.BY = ((String[])zzaa.zzy(paramArrayOfString));
    this.Ca = ((CursorWindow[])zzaa.zzy(paramArrayOfCursorWindow));
    this.uo = paramInt;
    this.Cb = paramBundle;
    zzaun();
  }

  public static DataHolder zza(int paramInt, Bundle paramBundle)
  {
    return new DataHolder(Cf, paramInt, paramBundle);
  }

  private static CursorWindow[] zza(zza paramzza, int paramInt)
  {
    int k = 0;
    if (zza.zza(paramzza).length == 0)
      return new CursorWindow[0];
    Object localObject3;
    Object localObject2;
    ArrayList localArrayList;
    int i;
    label88: Object localObject1;
    if ((paramInt < 0) || (paramInt >= zza.zzb(paramzza).size()))
    {
      localObject3 = zza.zzb(paramzza);
      int m = ((List)localObject3).size();
      localObject2 = new CursorWindow(false);
      localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      ((CursorWindow)localObject2).setNumColumns(zza.zza(paramzza).length);
      paramInt = 0;
      i = 0;
      if (paramInt >= m)
        break label723;
      localObject1 = localObject2;
    }
    while (true)
    {
      int j;
      try
      {
        if (((CursorWindow)localObject2).allocRow())
          continue;
        Log.d("DataHolder", 72 + "Allocating additional cursor window for large data set (row " + paramInt + ")");
        localObject2 = new CursorWindow(false);
        ((CursorWindow)localObject2).setStartPosition(paramInt);
        ((CursorWindow)localObject2).setNumColumns(zza.zza(paramzza).length);
        localArrayList.add(localObject2);
        localObject1 = localObject2;
        if (((CursorWindow)localObject2).allocRow())
          continue;
        Log.e("DataHolder", "Unable to allocate row to hold data.");
        localArrayList.remove(localObject2);
        paramzza = (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
        return paramzza;
        localObject3 = zza.zzb(paramzza).subList(0, paramInt);
        break;
        Map localMap = (Map)((List)localObject3).get(paramInt);
        j = 0;
        bool = true;
        if ((j >= zza.zza(paramzza).length) || (!bool))
          continue;
        localObject2 = zza.zza(paramzza)[j];
        Object localObject4 = localMap.get(localObject2);
        if (localObject4 != null)
          continue;
        bool = ((CursorWindow)localObject1).putNull(paramInt, j);
        break label740;
        if (!(localObject4 instanceof String))
          continue;
        bool = ((CursorWindow)localObject1).putString((String)localObject4, paramInt, j);
        break label740;
        if (!(localObject4 instanceof Long))
          continue;
        bool = ((CursorWindow)localObject1).putLong(((Long)localObject4).longValue(), paramInt, j);
        break label740;
        if (!(localObject4 instanceof Integer))
          continue;
        bool = ((CursorWindow)localObject1).putLong(((Integer)localObject4).intValue(), paramInt, j);
        break label740;
        if (!(localObject4 instanceof Boolean))
          continue;
        if (!((Boolean)localObject4).booleanValue())
          break label747;
        l = 1L;
        bool = ((CursorWindow)localObject1).putLong(l, paramInt, j);
        break label740;
        if (!(localObject4 instanceof byte[]))
          continue;
        bool = ((CursorWindow)localObject1).putBlob((byte[])localObject4, paramInt, j);
        break label740;
        if (!(localObject4 instanceof Double))
          continue;
        bool = ((CursorWindow)localObject1).putDouble(((Double)localObject4).doubleValue(), paramInt, j);
        break label740;
        if (!(localObject4 instanceof Float))
          continue;
        bool = ((CursorWindow)localObject1).putDouble(((Float)localObject4).floatValue(), paramInt, j);
        break label740;
        paramzza = String.valueOf(localObject4);
        throw new IllegalArgumentException(String.valueOf(localObject2).length() + 32 + String.valueOf(paramzza).length() + "Unsupported object for column " + (String)localObject2 + ": " + paramzza);
      }
      catch (RuntimeException paramzza)
      {
        boolean bool;
        i = localArrayList.size();
        paramInt = k;
        if (paramInt >= i)
          continue;
        ((CursorWindow)localArrayList.get(paramInt)).close();
        paramInt += 1;
        continue;
        if (bool)
          continue;
        if (i == 0)
          continue;
        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
        Log.d("DataHolder", 74 + "Couldn't populate window data for row " + paramInt + " - allocating new window.");
        ((CursorWindow)localObject1).freeLastRow();
        localObject1 = new CursorWindow(false);
        ((CursorWindow)localObject1).setStartPosition(paramInt);
        ((CursorWindow)localObject1).setNumColumns(zza.zza(paramzza).length);
        localArrayList.add(localObject1);
        i = paramInt - 1;
        paramInt = 1;
        j = paramInt;
        paramInt = i + 1;
        localObject2 = localObject1;
        i = j;
        break label88;
        j = 0;
        i = paramInt;
        paramInt = j;
        continue;
        throw paramzza;
      }
      label723: return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
      label740: j += 1;
      continue;
      label747: long l = 0L;
    }
  }

  public static zza zzc(String[] paramArrayOfString)
  {
    return new zza(paramArrayOfString, null, null);
  }

  public static DataHolder zzgb(int paramInt)
  {
    return zza(paramInt, null);
  }

  private void zzi(String paramString, int paramInt)
  {
    if ((this.BZ == null) || (!this.BZ.containsKey(paramString)))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0);
      for (paramString = "No such column: ".concat(paramString); ; paramString = new String("No such column: "))
        throw new IllegalArgumentException(paramString);
    }
    if (isClosed())
      throw new IllegalArgumentException("Buffer is closed.");
    if ((paramInt < 0) || (paramInt >= this.Cd))
      throw new CursorIndexOutOfBoundsException(paramInt, this.Cd);
  }

  public void close()
  {
    monitorenter;
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        int i = 0;
        while (i < this.Ca.length)
        {
          this.Ca[i].close();
          i += 1;
        }
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      if ((this.Ce) && (this.Ca.length > 0) && (!isClosed()))
      {
        close();
        String str = String.valueOf(toString());
        Log.e("DataBuffer", String.valueOf(str).length() + 178 + "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + str + ")");
      }
      return;
    }
    finally
    {
      super.finalize();
    }
    throw localObject;
  }

  public int getCount()
  {
    return this.Cd;
  }

  public int getStatusCode()
  {
    return this.uo;
  }

  public boolean isClosed()
  {
    monitorenter;
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }

  public void zza(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    zzi(paramString, paramInt1);
    this.Ca[paramInt2].copyStringToBuffer(paramInt1, this.BZ.getInt(paramString), paramCharArrayBuffer);
  }

  public Bundle zzaui()
  {
    return this.Cb;
  }

  public void zzaun()
  {
    int j = 0;
    this.BZ = new Bundle();
    int i = 0;
    while (i < this.BY.length)
    {
      this.BZ.putInt(this.BY[i], i);
      i += 1;
    }
    this.Cc = new int[this.Ca.length];
    int k = 0;
    i = j;
    j = k;
    while (i < this.Ca.length)
    {
      this.Cc[i] = j;
      k = this.Ca[i].getStartPosition();
      j += this.Ca[i].getNumRows() - (j - k);
      i += 1;
    }
    this.Cd = j;
  }

  String[] zzauo()
  {
    return this.BY;
  }

  CursorWindow[] zzaup()
  {
    return this.Ca;
  }

  public long zzb(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.Ca[paramInt2].getLong(paramInt1, this.BZ.getInt(paramString));
  }

  public int zzc(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.Ca[paramInt2].getInt(paramInt1, this.BZ.getInt(paramString));
  }

  public String zzd(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.Ca[paramInt2].getString(paramInt1, this.BZ.getInt(paramString));
  }

  public boolean zze(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return Long.valueOf(this.Ca[paramInt2].getLong(paramInt1, this.BZ.getInt(paramString))).longValue() == 1L;
  }

  public float zzf(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.Ca[paramInt2].getFloat(paramInt1, this.BZ.getInt(paramString));
  }

  public byte[] zzg(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.Ca[paramInt2].getBlob(paramInt1, this.BZ.getInt(paramString));
  }

  public int zzga(int paramInt)
  {
    int j = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.Cd))
    {
      bool = true;
      zzaa.zzbs(bool);
    }
    while (true)
    {
      int i = j;
      if (j < this.Cc.length)
      {
        if (paramInt < this.Cc[j])
          i = j - 1;
      }
      else
      {
        paramInt = i;
        if (i == this.Cc.length)
          paramInt = i - 1;
        return paramInt;
        bool = false;
        break;
      }
      j += 1;
    }
  }

  public Uri zzh(String paramString, int paramInt1, int paramInt2)
  {
    paramString = zzd(paramString, paramInt1, paramInt2);
    if (paramString == null)
      return null;
    return Uri.parse(paramString);
  }

  public boolean zzho(String paramString)
  {
    return this.BZ.containsKey(paramString);
  }

  public boolean zzi(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.Ca[paramInt2].isNull(paramInt1, this.BZ.getInt(paramString));
  }

  public static class zza
  {
    private final String[] BY;
    private final ArrayList<HashMap<String, Object>> Cg;
    private final String Ch;
    private final HashMap<Object, Integer> Ci;
    private boolean Cj;
    private String Ck;

    private zza(String[] paramArrayOfString, String paramString)
    {
      this.BY = ((String[])zzaa.zzy(paramArrayOfString));
      this.Cg = new ArrayList();
      this.Ch = paramString;
      this.Ci = new HashMap();
      this.Cj = false;
      this.Ck = null;
    }

    private int zzc(HashMap<String, Object> paramHashMap)
    {
      if (this.Ch == null)
        return -1;
      paramHashMap = paramHashMap.get(this.Ch);
      if (paramHashMap == null)
        return -1;
      Integer localInteger = (Integer)this.Ci.get(paramHashMap);
      if (localInteger == null)
      {
        this.Ci.put(paramHashMap, Integer.valueOf(this.Cg.size()));
        return -1;
      }
      return localInteger.intValue();
    }

    public zza zza(ContentValues paramContentValues)
    {
      zzc.zzu(paramContentValues);
      HashMap localHashMap = new HashMap(paramContentValues.size());
      paramContentValues = paramContentValues.valueSet().iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        localHashMap.put((String)localEntry.getKey(), localEntry.getValue());
      }
      return zzb(localHashMap);
    }

    public zza zzb(HashMap<String, Object> paramHashMap)
    {
      zzc.zzu(paramHashMap);
      int i = zzc(paramHashMap);
      if (i == -1)
        this.Cg.add(paramHashMap);
      while (true)
      {
        this.Cj = false;
        return this;
        this.Cg.remove(i);
        this.Cg.add(i, paramHashMap);
      }
    }

    public DataHolder zzgc(int paramInt)
    {
      return new DataHolder(this, paramInt, null, null);
    }
  }

  public static class zzb extends RuntimeException
  {
    public zzb(String paramString)
    {
      super();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder
 * JD-Core Version:    0.6.0
 */