package com.google.android.gms.common.util;

public final class zzm
{
  public static String zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramInt1 < 0) || (paramInt2 <= 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length))
      return null;
    int i = 57;
    if (paramBoolean)
      i = 75;
    StringBuilder localStringBuilder = new StringBuilder(i * ((paramInt2 + 16 - 1) / 16));
    int k = paramInt2;
    int m = 0;
    int j = 0;
    if (k > 0)
    {
      if (j == 0)
        if (paramInt2 < 65536)
        {
          localStringBuilder.append(String.format("%04X:", new Object[] { Integer.valueOf(paramInt1) }));
          i = paramInt1;
        }
      while (true)
      {
        localStringBuilder.append(String.format(" %02X", new Object[] { Integer.valueOf(paramArrayOfByte[paramInt1] & 0xFF) }));
        k -= 1;
        m = j + 1;
        if ((!paramBoolean) || ((m != 16) && (k != 0)))
          break;
        int n = 16 - m;
        if (n > 0)
        {
          j = 0;
          while (true)
            if (j < n)
            {
              localStringBuilder.append("   ");
              j += 1;
              continue;
              localStringBuilder.append(String.format("%08X:", new Object[] { Integer.valueOf(paramInt1) }));
              i = paramInt1;
              break;
              i = m;
              if (j != 8)
                break;
              localStringBuilder.append(" -");
              i = m;
              break;
            }
        }
        if (n >= 8)
          localStringBuilder.append("  ");
        localStringBuilder.append("  ");
        j = 0;
        if (j >= m)
          break;
        char c = (char)paramArrayOfByte[(i + j)];
        if ((c >= ' ') && (c <= '~'));
        while (true)
        {
          localStringBuilder.append(c);
          j += 1;
          break;
          c = '.';
        }
      }
      if ((m != 16) && (k != 0))
        break label380;
      localStringBuilder.append('\n');
    }
    label380: for (j = 0; ; j = m)
    {
      paramInt1 += 1;
      m = i;
      break;
      return localStringBuilder.toString();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzm
 * JD-Core Version:    0.6.0
 */