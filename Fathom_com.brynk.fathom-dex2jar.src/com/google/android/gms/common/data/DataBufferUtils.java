package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils
{
  public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> paramDataBuffer)
  {
    ArrayList localArrayList = new ArrayList(paramDataBuffer.getCount());
    try
    {
      Iterator localIterator = paramDataBuffer.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((Freezable)localIterator.next()).freeze());
    }
    finally
    {
      paramDataBuffer.close();
    }
    paramDataBuffer.close();
    return localObject;
  }

  public static boolean hasData(DataBuffer<?> paramDataBuffer)
  {
    return (paramDataBuffer != null) && (paramDataBuffer.getCount() > 0);
  }

  public static boolean hasNextPage(DataBuffer<?> paramDataBuffer)
  {
    paramDataBuffer = paramDataBuffer.zzaui();
    return (paramDataBuffer != null) && (paramDataBuffer.getString("next_page_token") != null);
  }

  public static boolean hasPrevPage(DataBuffer<?> paramDataBuffer)
  {
    paramDataBuffer = paramDataBuffer.zzaui();
    return (paramDataBuffer != null) && (paramDataBuffer.getString("prev_page_token") != null);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferUtils
 * JD-Core Version:    0.6.0
 */