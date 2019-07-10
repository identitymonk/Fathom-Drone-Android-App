package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzp
{
  private static final Pattern GC = Pattern.compile("\\\\.");
  private static final Pattern GD = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

  public static boolean zzf(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject1 == null) && (paramObject2 == null))
      bool1 = true;
    while (true)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject1 == null)
        continue;
      bool1 = bool2;
      if (paramObject2 == null)
        continue;
      label73: String str;
      if (((paramObject1 instanceof JSONObject)) && ((paramObject2 instanceof JSONObject)))
      {
        paramObject1 = (JSONObject)paramObject1;
        paramObject2 = (JSONObject)paramObject2;
        bool1 = bool2;
        if (paramObject1.length() != paramObject2.length())
          continue;
        Iterator localIterator = paramObject1.keys();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          bool1 = bool2;
          if (!paramObject2.has(str))
            continue;
        }
      }
      try
      {
        bool1 = zzf(paramObject1.get(str), paramObject2.get(str));
        if (bool1)
          break label73;
        return false;
        return true;
        int i;
        if (((paramObject1 instanceof JSONArray)) && ((paramObject2 instanceof JSONArray)))
        {
          paramObject1 = (JSONArray)paramObject1;
          paramObject2 = (JSONArray)paramObject2;
          bool1 = bool2;
          if (paramObject1.length() != paramObject2.length())
            continue;
          i = 0;
          label171: if (i >= paramObject1.length());
        }
        try
        {
          boolean bool3 = zzf(paramObject1.get(i), paramObject2.get(i));
          bool1 = bool2;
          if (!bool3)
            continue;
          i += 1;
          break label171;
          return true;
          return paramObject1.equals(paramObject2);
        }
        catch (org.json.JSONException paramObject1)
        {
          return false;
        }
      }
      catch (org.json.JSONException paramObject1)
      {
      }
    }
    return false;
  }

  public static String zzii(String paramString)
  {
    Matcher localMatcher;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localMatcher = GD.matcher(paramString);
      localObject1 = null;
      while (localMatcher.find())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
          localObject2 = new StringBuffer();
        switch (localMatcher.group().charAt(0))
        {
        default:
          localObject1 = localObject2;
          break;
        case '\b':
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\b");
          localObject1 = localObject2;
          break;
        case '"':
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\\\\"");
          localObject1 = localObject2;
          break;
        case '\\':
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\\\\\");
          localObject1 = localObject2;
          break;
        case '/':
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\/");
          localObject1 = localObject2;
          break;
        case '\f':
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\f");
          localObject1 = localObject2;
          break;
        case '\n':
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\n");
          localObject1 = localObject2;
          break;
        case '\r':
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\r");
          localObject1 = localObject2;
          break;
        case '\t':
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\t");
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null);
    }
    else
    {
      return paramString;
    }
    localMatcher.appendTail(localObject1);
    return (String)localObject1.toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzp
 * JD-Core Version:    0.6.0
 */