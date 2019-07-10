package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Ljava.lang.String;>;>;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Headers
{
  private final String[] namesAndValues;

  Headers(Builder paramBuilder)
  {
    this.namesAndValues = ((String[])paramBuilder.namesAndValues.toArray(new String[paramBuilder.namesAndValues.size()]));
  }

  private Headers(String[] paramArrayOfString)
  {
    this.namesAndValues = paramArrayOfString;
  }

  private static String get(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i]))
        return paramArrayOfString[(i + 1)];
      i -= 2;
    }
    return null;
  }

  public static Headers of(Map<String, String> paramMap)
  {
    if (paramMap == null)
      throw new NullPointerException("headers == null");
    String[] arrayOfString = new String[paramMap.size() * 2];
    int i = 0;
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      if ((((Map.Entry)localObject).getKey() == null) || (((Map.Entry)localObject).getValue() == null))
        throw new IllegalArgumentException("Headers cannot be null");
      String str = ((String)((Map.Entry)localObject).getKey()).trim();
      localObject = ((String)((Map.Entry)localObject).getValue()).trim();
      if ((str.length() == 0) || (str.indexOf(0) != -1) || (((String)localObject).indexOf(0) != -1))
        throw new IllegalArgumentException("Unexpected header: " + str + ": " + (String)localObject);
      arrayOfString[i] = str;
      arrayOfString[(i + 1)] = localObject;
      i += 2;
    }
    return (Headers)new Headers(arrayOfString);
  }

  public static Headers of(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null)
      throw new NullPointerException("namesAndValues == null");
    if (paramArrayOfString.length % 2 != 0)
      throw new IllegalArgumentException("Expected alternating header names and values");
    paramArrayOfString = (String[])paramArrayOfString.clone();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] == null)
        throw new IllegalArgumentException("Headers cannot be null");
      paramArrayOfString[i] = paramArrayOfString[i].trim();
      i += 1;
    }
    i = 0;
    while (i < paramArrayOfString.length)
    {
      String str1 = paramArrayOfString[i];
      String str2 = paramArrayOfString[(i + 1)];
      if ((str1.length() == 0) || (str1.indexOf(0) != -1) || (str2.indexOf(0) != -1))
        throw new IllegalArgumentException("Unexpected header: " + str1 + ": " + str2);
      i += 2;
    }
    return new Headers(paramArrayOfString);
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Headers)) && (Arrays.equals(((Headers)paramObject).namesAndValues, this.namesAndValues));
  }

  public String get(String paramString)
  {
    return get(this.namesAndValues, paramString);
  }

  public Date getDate(String paramString)
  {
    paramString = get(paramString);
    if (paramString != null)
      return HttpDate.parse(paramString);
    return null;
  }

  public int hashCode()
  {
    return Arrays.hashCode(this.namesAndValues);
  }

  public String name(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2)];
  }

  public Set<String> names()
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    int j = size();
    while (i < j)
    {
      localTreeSet.add(name(i));
      i += 1;
    }
    return Collections.unmodifiableSet(localTreeSet);
  }

  public Builder newBuilder()
  {
    Builder localBuilder = new Builder();
    Collections.addAll(localBuilder.namesAndValues, this.namesAndValues);
    return localBuilder;
  }

  public int size()
  {
    return this.namesAndValues.length / 2;
  }

  public Map<String, List<String>> toMultimap()
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    int j = size();
    while (i < j)
    {
      String str = name(i).toLowerCase(Locale.US);
      List localList = (List)localTreeMap.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(2);
        localTreeMap.put(str, localObject);
      }
      ((List)localObject).add(value(i));
      i += 1;
    }
    return (Map<String, List<String>>)localTreeMap;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = size();
    while (i < j)
    {
      localStringBuilder.append(name(i)).append(": ").append(value(i)).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }

  public String value(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2 + 1)];
  }

  public List<String> values(String paramString)
  {
    Object localObject1 = null;
    int i = 0;
    int j = size();
    while (i < j)
    {
      Object localObject2 = localObject1;
      if (paramString.equalsIgnoreCase(name(i)))
      {
        localObject2 = localObject1;
        if (localObject1 == null)
          localObject2 = new ArrayList(2);
        ((List)localObject2).add(value(i));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
      return Collections.unmodifiableList(localObject1);
    return (List<String>)Collections.emptyList();
  }

  public static final class Builder
  {
    final List<String> namesAndValues = new ArrayList(20);

    private void checkNameAndValue(String paramString1, String paramString2)
    {
      if (paramString1 == null)
        throw new NullPointerException("name == null");
      if (paramString1.isEmpty())
        throw new IllegalArgumentException("name is empty");
      int i = 0;
      int j = paramString1.length();
      int k;
      while (i < j)
      {
        k = paramString1.charAt(i);
        if ((k <= 32) || (k >= 127))
          throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1 }));
        i += 1;
      }
      if (paramString2 == null)
        throw new NullPointerException("value == null");
      i = 0;
      j = paramString2.length();
      while (i < j)
      {
        k = paramString2.charAt(i);
        if (((k <= 31) && (k != 9)) || (k >= 127))
          throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1, paramString2 }));
        i += 1;
      }
    }

    public Builder add(String paramString)
    {
      int i = paramString.indexOf(":");
      if (i == -1)
        throw new IllegalArgumentException("Unexpected header: " + paramString);
      return add(paramString.substring(0, i).trim(), paramString.substring(i + 1));
    }

    public Builder add(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      return addLenient(paramString1, paramString2);
    }

    Builder addLenient(String paramString)
    {
      int i = paramString.indexOf(":", 1);
      if (i != -1)
        return addLenient(paramString.substring(0, i), paramString.substring(i + 1));
      if (paramString.startsWith(":"))
        return addLenient("", paramString.substring(1));
      return addLenient("", paramString);
    }

    Builder addLenient(String paramString1, String paramString2)
    {
      this.namesAndValues.add(paramString1);
      this.namesAndValues.add(paramString2.trim());
      return this;
    }

    public Headers build()
    {
      return new Headers(this);
    }

    public String get(String paramString)
    {
      int i = this.namesAndValues.size() - 2;
      while (i >= 0)
      {
        if (paramString.equalsIgnoreCase((String)this.namesAndValues.get(i)))
          return (String)this.namesAndValues.get(i + 1);
        i -= 2;
      }
      return null;
    }

    public Builder removeAll(String paramString)
    {
      int j;
      for (int i = 0; i < this.namesAndValues.size(); i = j + 2)
      {
        j = i;
        if (!paramString.equalsIgnoreCase((String)this.namesAndValues.get(i)))
          continue;
        this.namesAndValues.remove(i);
        this.namesAndValues.remove(i);
        j = i - 2;
      }
      return this;
    }

    public Builder set(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      removeAll(paramString1);
      addLenient(paramString1, paramString2);
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Headers
 * JD-Core Version:    0.6.0
 */