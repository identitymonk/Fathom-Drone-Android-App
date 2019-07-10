package com.google.android.gms.common.util;

import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Scanner;
import java.util.regex.Pattern;

public class zzn
{
  private static final Pattern GA;
  private static final Pattern GB;
  private static final Pattern Gz = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

  static
  {
    GA = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    GB = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
  }

  private static String decode(String paramString1, String paramString2)
  {
    if (paramString2 != null);
    try
    {
      while (true)
      {
        return URLDecoder.decode(paramString1, paramString2);
        paramString2 = "ISO-8859-1";
      }
    }
    catch (java.io.UnsupportedEncodingException paramString1)
    {
    }
    throw new IllegalArgumentException(paramString1);
  }

  public static Map<String, String> zza(URI paramURI, String paramString)
  {
    Object localObject1 = Collections.emptyMap();
    Object localObject2 = paramURI.getRawQuery();
    paramURI = (URI)localObject1;
    if (localObject2 != null)
    {
      paramURI = (URI)localObject1;
      if (((String)localObject2).length() > 0)
      {
        localObject1 = new HashMap();
        localObject2 = new Scanner((String)localObject2);
        ((Scanner)localObject2).useDelimiter("&");
        while (((Scanner)localObject2).hasNext())
        {
          String[] arrayOfString = ((Scanner)localObject2).next().split("=");
          if ((arrayOfString.length == 0) || (arrayOfString.length > 2))
            throw new IllegalArgumentException("bad parameter");
          String str = decode(arrayOfString[0], paramString);
          paramURI = null;
          if (arrayOfString.length == 2)
            paramURI = decode(arrayOfString[1], paramString);
          ((Map)localObject1).put(str, paramURI);
        }
        paramURI = (URI)localObject1;
      }
    }
    return (Map<String, String>)(Map<String, String>)paramURI;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzn
 * JD-Core Version:    0.6.0
 */