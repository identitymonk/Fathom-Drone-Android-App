package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh
{
  private static final String[] gB;
  private static final Map<String, Integer> gC;

  static
  {
    int i = 0;
    gB = new String[] { "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity", "thing_proto" };
    gC = new HashMap(gB.length);
    while (i < gB.length)
    {
      gC.put(gB[i], Integer.valueOf(i));
      i += 1;
    }
  }

  public static int zzahq()
  {
    return gB.length;
  }

  public static String zzcn(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= gB.length))
      return null;
    return gB[paramInt];
  }

  public static int zzfq(String paramString)
  {
    Integer localInteger = (Integer)gC.get(paramString);
    if (localInteger == null)
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 44 + "[" + paramString + "] is not a valid global search section name");
    return localInteger.intValue();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.zzh
 * JD-Core Version:    0.6.0
 */