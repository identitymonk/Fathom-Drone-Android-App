package com.facebook.react.devsupport;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.devsupport.interfaces.StackFrame;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class StackTraceHelper
{
  public static final String COLUMN_KEY = "column";
  public static final String LINE_NUMBER_KEY = "lineNumber";
  private static final Pattern STACK_FRAME_PATTERN = Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");

  public static StackFrame[] convertJavaStackTrace(Throwable paramThrowable)
  {
    paramThrowable = paramThrowable.getStackTrace();
    StackFrame[] arrayOfStackFrame = new StackFrame[paramThrowable.length];
    int i = 0;
    while (i < paramThrowable.length)
    {
      arrayOfStackFrame[i] = new StackFrameImpl(paramThrowable[i].getClassName(), paramThrowable[i].getFileName(), paramThrowable[i].getMethodName(), paramThrowable[i].getLineNumber(), -1, null);
      i += 1;
    }
    return arrayOfStackFrame;
  }

  public static StackFrame[] convertJsStackTrace(@Nullable ReadableArray paramReadableArray)
  {
    int i;
    StackFrame[] arrayOfStackFrame;
    int j;
    label19: Object localObject;
    if (paramReadableArray != null)
    {
      i = paramReadableArray.size();
      arrayOfStackFrame = new StackFrame[i];
      j = 0;
      if (j >= i)
        break label225;
      localObject = paramReadableArray.getType(j);
      if (localObject != ReadableType.Map)
        break label192;
      localObject = paramReadableArray.getMap(j);
      String str1 = ((ReadableMap)localObject).getString("methodName");
      String str2 = ((ReadableMap)localObject).getString("file");
      int m = -1;
      int k = m;
      if (((ReadableMap)localObject).hasKey("lineNumber"))
      {
        k = m;
        if (!((ReadableMap)localObject).isNull("lineNumber"))
          k = ((ReadableMap)localObject).getInt("lineNumber");
      }
      int n = -1;
      m = n;
      if (((ReadableMap)localObject).hasKey("column"))
      {
        m = n;
        if (!((ReadableMap)localObject).isNull("column"))
          m = ((ReadableMap)localObject).getInt("column");
      }
      arrayOfStackFrame[j] = new StackFrameImpl(str2, str1, k, m, null);
    }
    while (true)
    {
      j += 1;
      break label19;
      i = 0;
      break;
      label192: if (localObject != ReadableType.String)
        continue;
      arrayOfStackFrame[j] = new StackFrameImpl(null, paramReadableArray.getString(j), -1, -1, null);
    }
    label225: return (StackFrame)arrayOfStackFrame;
  }

  public static StackFrame[] convertJsStackTrace(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    StackFrame[] arrayOfStackFrame = new StackFrame[arrayOfString.length];
    int i = 0;
    if (i < arrayOfString.length)
    {
      Matcher localMatcher = STACK_FRAME_PATTERN.matcher(arrayOfString[i]);
      if (localMatcher.find())
      {
        String str = localMatcher.group(2);
        if (localMatcher.group(1) == null)
        {
          paramString = "(unknown)";
          label60: arrayOfStackFrame[i] = new StackFrameImpl(str, paramString, Integer.parseInt(localMatcher.group(3)), Integer.parseInt(localMatcher.group(4)), null);
        }
      }
      while (true)
      {
        i += 1;
        break;
        paramString = localMatcher.group(1);
        break label60;
        arrayOfStackFrame[i] = new StackFrameImpl(null, arrayOfString[i], -1, -1, null);
      }
    }
    return arrayOfStackFrame;
  }

  public static StackFrame[] convertJsStackTrace(JSONArray paramJSONArray)
  {
    int i;
    if (paramJSONArray != null)
      i = paramJSONArray.length();
    StackFrame[] arrayOfStackFrame;
    while (true)
    {
      arrayOfStackFrame = new StackFrame[i];
      int j = 0;
      label17: if (j >= i)
        break;
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(j);
        String str1 = localJSONObject.getString("methodName");
        String str2 = localJSONObject.getString("file");
        int m = -1;
        int k = m;
        if (localJSONObject.has("lineNumber"))
        {
          k = m;
          if (!localJSONObject.isNull("lineNumber"))
            k = localJSONObject.getInt("lineNumber");
        }
        int n = -1;
        m = n;
        if (localJSONObject.has("column"))
        {
          m = n;
          if (!localJSONObject.isNull("column"))
            m = localJSONObject.getInt("column");
        }
        arrayOfStackFrame[j] = new StackFrameImpl(str2, str1, k, m, null);
        j += 1;
        break label17;
        i = 0;
      }
      catch (org.json.JSONException paramJSONArray)
      {
        throw new RuntimeException(paramJSONArray);
      }
    }
    return arrayOfStackFrame;
  }

  public static String formatFrameSource(StackFrame paramStackFrame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStackFrame.getFileName());
    int i = paramStackFrame.getLine();
    if (i > 0)
    {
      localStringBuilder.append(":").append(i);
      i = paramStackFrame.getColumn();
      if (i > 0)
        localStringBuilder.append(":").append(i);
    }
    return localStringBuilder.toString();
  }

  public static String formatStackTrace(String paramString, StackFrame[] paramArrayOfStackFrame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n");
    int j = paramArrayOfStackFrame.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramArrayOfStackFrame[i];
      localStringBuilder.append(paramString.getMethod()).append("\n").append("    ").append(formatFrameSource(paramString)).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }

  public static class StackFrameImpl
    implements StackFrame
  {
    private final int mColumn;
    private final String mFile;
    private final String mFileName;
    private final int mLine;
    private final String mMethod;

    private StackFrameImpl(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.mFile = paramString1;
      this.mMethod = paramString2;
      this.mLine = paramInt1;
      this.mColumn = paramInt2;
      if (paramString1 != null);
      for (paramString1 = new File(paramString1).getName(); ; paramString1 = "")
      {
        this.mFileName = paramString1;
        return;
      }
    }

    private StackFrameImpl(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      this.mFile = paramString1;
      this.mFileName = paramString2;
      this.mMethod = paramString3;
      this.mLine = paramInt1;
      this.mColumn = paramInt2;
    }

    public int getColumn()
    {
      return this.mColumn;
    }

    public String getFile()
    {
      return this.mFile;
    }

    public String getFileName()
    {
      return this.mFileName;
    }

    public int getLine()
    {
      return this.mLine;
    }

    public String getMethod()
    {
      return this.mMethod;
    }

    public JSONObject toJSON()
    {
      return new JSONObject(MapBuilder.of("file", getFile(), "methodName", getMethod(), "lineNumber", Integer.valueOf(getLine()), "column", Integer.valueOf(getColumn())));
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.StackTraceHelper
 * JD-Core Version:    0.6.0
 */