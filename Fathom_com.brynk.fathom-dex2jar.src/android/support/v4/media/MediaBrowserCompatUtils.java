package android.support.v4.media;

import android.os.Bundle;

public class MediaBrowserCompatUtils
{
  public static boolean areSameOptions(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == paramBundle2);
    do
      while (true)
      {
        return true;
        if (paramBundle1 == null)
          if ((paramBundle2.getInt("android.media.browse.extra.PAGE", -1) != -1) || (paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1))
            return false;
        if (paramBundle2 != null)
          break;
        if ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) != -1) || (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1))
          return false;
      }
    while ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE", -1)) && (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)));
    return false;
  }

  public static boolean hasDuplicatedItems(Bundle paramBundle1, Bundle paramBundle2)
  {
    int k;
    int i;
    label13: int m;
    label20: int j;
    if (paramBundle1 == null)
    {
      k = -1;
      if (paramBundle2 != null)
        break label86;
      i = -1;
      if (paramBundle1 != null)
        break label97;
      m = -1;
      if (paramBundle2 != null)
        break label109;
      j = -1;
      label26: if ((k != -1) && (m != -1))
        break label120;
      m = 0;
      k = 2147483647;
      label45: if ((i != -1) && (j != -1))
        break label143;
      j = 0;
      i = 2147483647;
      label60: if ((m > j) || (j > k))
        break label161;
    }
    label86: label97: label109: label120: 
    do
    {
      return true;
      k = paramBundle1.getInt("android.media.browse.extra.PAGE", -1);
      break;
      i = paramBundle2.getInt("android.media.browse.extra.PAGE", -1);
      break label13;
      m = paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      break label20;
      j = paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      break label26;
      int n = m * k;
      k = n + m - 1;
      m = n;
      break label45;
      n = j * i;
      i = n + j - 1;
      j = n;
      break label60;
    }
    while ((m <= i) && (i <= k));
    label143: label161: return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompatUtils
 * JD-Core Version:    0.6.0
 */