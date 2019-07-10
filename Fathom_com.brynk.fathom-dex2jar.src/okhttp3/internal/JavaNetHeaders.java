package okhttp3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.Headers;

public final class JavaNetHeaders
{
  private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator()
  {
    public int compare(String paramString1, String paramString2)
    {
      if (paramString1 == paramString2)
        return 0;
      if (paramString1 == null)
        return -1;
      if (paramString2 == null)
        return 1;
      return String.CASE_INSENSITIVE_ORDER.compare(paramString1, paramString2);
    }
  };

  public static Map<String, List<String>> toMultimap(Headers paramHeaders, String paramString)
  {
    TreeMap localTreeMap = new TreeMap(FIELD_NAME_COMPARATOR);
    int i = 0;
    int j = paramHeaders.size();
    while (i < j)
    {
      String str1 = paramHeaders.name(i);
      String str2 = paramHeaders.value(i);
      ArrayList localArrayList = new ArrayList();
      List localList = (List)localTreeMap.get(str1);
      if (localList != null)
        localArrayList.addAll(localList);
      localArrayList.add(str2);
      localTreeMap.put(str1, Collections.unmodifiableList(localArrayList));
      i += 1;
    }
    if (paramString != null)
      localTreeMap.put(null, Collections.unmodifiableList(Collections.singletonList(paramString)));
    return Collections.unmodifiableMap(localTreeMap);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.JavaNetHeaders
 * JD-Core Version:    0.6.0
 */