package okio;

public final class Utf8
{
  public static long size(String paramString)
  {
    return size(paramString, 0, paramString.length());
  }

  public static long size(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
      throw new IllegalArgumentException("string == null");
    if (paramInt1 < 0)
      throw new IllegalArgumentException("beginIndex < 0: " + paramInt1);
    if (paramInt2 < paramInt1)
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    if (paramInt2 > paramString.length())
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
    long l = 0L;
    while (paramInt1 < paramInt2)
    {
      int j = paramString.charAt(paramInt1);
      if (j < 128)
      {
        l += 1L;
        paramInt1 += 1;
        continue;
      }
      if (j < 2048)
      {
        l += 2L;
        paramInt1 += 1;
        continue;
      }
      if ((j < 55296) || (j > 57343))
      {
        l += 3L;
        paramInt1 += 1;
        continue;
      }
      if (paramInt1 + 1 < paramInt2);
      for (int i = paramString.charAt(paramInt1 + 1); ; i = 0)
      {
        if ((j <= 56319) && (i >= 56320) && (i <= 57343))
          break label273;
        l += 1L;
        paramInt1 += 1;
        break;
      }
      label273: l += 4L;
      paramInt1 += 2;
    }
    return l;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okio.Utf8
 * JD-Core Version:    0.6.0
 */