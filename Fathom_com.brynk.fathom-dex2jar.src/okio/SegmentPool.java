package okio;

import javax.annotation.Nullable;

final class SegmentPool
{
  static final long MAX_SIZE = 65536L;
  static long byteCount;

  @Nullable
  static Segment next;

  static void recycle(Segment paramSegment)
  {
    if ((paramSegment.next != null) || (paramSegment.prev != null))
      throw new IllegalArgumentException();
    if (paramSegment.shared)
      return;
    monitorenter;
    try
    {
      if (byteCount + 8192L > 65536L)
        return;
    }
    finally
    {
      monitorexit;
    }
    byteCount += 8192L;
    paramSegment.next = next;
    paramSegment.limit = 0;
    paramSegment.pos = 0;
    next = paramSegment;
    monitorexit;
  }

  static Segment take()
  {
    monitorenter;
    try
    {
      if (next != null)
      {
        Segment localSegment = next;
        next = localSegment.next;
        localSegment.next = null;
        byteCount -= 8192L;
        return localSegment;
      }
      return new Segment();
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okio.SegmentPool
 * JD-Core Version:    0.6.0
 */