package com.facebook.cache.disk;

public class DefaultEntryEvictionComparatorSupplier
  implements EntryEvictionComparatorSupplier
{
  public EntryEvictionComparator get()
  {
    return new EntryEvictionComparator()
    {
      public int compare(DiskStorage.Entry paramEntry1, DiskStorage.Entry paramEntry2)
      {
        long l1 = paramEntry1.getTimestamp();
        long l2 = paramEntry2.getTimestamp();
        if (l1 < l2)
          return -1;
        if (l2 == l1)
          return 0;
        return 1;
      }
    };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier
 * JD-Core Version:    0.6.0
 */