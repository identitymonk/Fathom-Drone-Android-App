package io.vov.vitamio.utils;

import java.util.Arrays;
import java.util.Iterator;

public class StringUtils
{
  public static int convertToInt(String paramString)
    throws NumberFormatException
  {
    int i = 0;
    while (true)
    {
      int j;
      if ((i >= paramString.length()) || (Character.isDigit(paramString.charAt(i))))
      {
        j = paramString.length();
        if (((j <= 0) || (Character.isDigit(paramString.charAt(j - 1)))) && (j <= i))
          break;
      }
      else
      {
        try
        {
          i = Integer.parseInt(paramString.substring(i, j));
          return i;
          i += 1;
          continue;
          j -= 1;
        }
        catch (NumberFormatException paramString)
        {
          Log.e("convertToInt", paramString);
          throw new NumberFormatException();
        }
      }
    }
    throw new NumberFormatException();
  }

  public static String fixLastSlash(String paramString)
  {
    if (paramString == null);
    for (paramString = "/"; ; paramString = paramString.trim() + "/")
    {
      String str = paramString;
      if (paramString.length() > 2)
      {
        str = paramString;
        if (paramString.charAt(paramString.length() - 2) == '/')
          str = paramString.substring(0, paramString.length() - 1);
      }
      return str;
    }
  }

  public static String generateTime(long paramLong)
  {
    int k = (int)(paramLong / 1000L);
    int i = k % 60;
    int j = k / 60 % 60;
    k /= 3600;
    if (k > 0)
      return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
  }

  public static String join(Iterable<? extends Object> paramIterable, CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      if (paramIterable.hasNext())
      {
        localStringBuilder.append(String.valueOf(paramIterable.next()));
        while (paramIterable.hasNext())
          localStringBuilder.append(paramCharSequence).append(String.valueOf(paramIterable.next()));
      }
    }
    return localStringBuilder.toString();
  }

  public static String join(Object[] paramArrayOfObject, CharSequence paramCharSequence)
  {
    return join(Arrays.asList(paramArrayOfObject), paramCharSequence);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.utils.StringUtils
 * JD-Core Version:    0.6.0
 */