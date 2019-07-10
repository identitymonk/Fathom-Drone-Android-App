package com.facebook.react.util;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSStackTrace
{
  private static final Pattern mJsModuleIdPattern = Pattern.compile("(?:^|[/\\\\])(\\d+\\.js)$");

  public static String format(String paramString, ReadableArray paramReadableArray)
  {
    paramString = new StringBuilder(paramString).append(", stack:\n");
    int i = 0;
    while (i < paramReadableArray.size())
    {
      ReadableMap localReadableMap = paramReadableArray.getMap(i);
      paramString.append(localReadableMap.getString("methodName")).append("@").append(stackFrameToModuleId(localReadableMap)).append(localReadableMap.getInt("lineNumber"));
      if ((localReadableMap.hasKey("column")) && (!localReadableMap.isNull("column")) && (localReadableMap.getType("column") == ReadableType.Number))
        paramString.append(":").append(localReadableMap.getInt("column"));
      paramString.append("\n");
      i += 1;
    }
    return paramString.toString();
  }

  private static String stackFrameToModuleId(ReadableMap paramReadableMap)
  {
    if ((paramReadableMap.hasKey("file")) && (!paramReadableMap.isNull("file")) && (paramReadableMap.getType("file") == ReadableType.String))
    {
      paramReadableMap = mJsModuleIdPattern.matcher(paramReadableMap.getString("file"));
      if (paramReadableMap.find())
        return paramReadableMap.group(1) + ":";
    }
    return "";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.util.JSStackTrace
 * JD-Core Version:    0.6.0
 */