package in.sriraman.sharedpreferences;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharedDataProvider
{
  private static final String TAG = "SharedDataProvider";

  public static void clear()
  {
    SharedHandler.getInstance().clear();
  }

  public static void deleteSharedValue(String paramString)
  {
    SharedHandler.getInstance().deleteKey(paramString);
  }

  public static String[] getAllKeys()
  {
    ArrayList localArrayList = new ArrayList(SharedHandler.getInstance().getAllSharedData().keySet());
    String[] arrayOfString = new String[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfString[i] = ((String)localArrayList.get(i));
      i += 1;
    }
    return arrayOfString;
  }

  public static String[][] getAllSharedValues()
  {
    Map localMap = SharedHandler.getInstance().getAllSharedData();
    ArrayList localArrayList = new ArrayList(localMap.keySet());
    String[][] arrayOfString = (String[][])Array.newInstance(String.class, new int[] { localArrayList.size(), 2 });
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfString[i][0] = ((String)localArrayList.get(i));
      arrayOfString[i][1] = String.valueOf(localMap.get(localArrayList.get(i)));
      i += 1;
    }
    return arrayOfString;
  }

  public static String[][] getMultiSharedValues(String[] paramArrayOfString)
  {
    SharedHandler localSharedHandler = SharedHandler.getInstance();
    String[][] arrayOfString = (String[][])Array.newInstance(String.class, new int[] { paramArrayOfString.length, 2 });
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfString[i][0] = paramArrayOfString[i];
      arrayOfString[i][1] = String.valueOf(localSharedHandler.getString(paramArrayOfString[i]));
      i += 1;
    }
    return arrayOfString;
  }

  public static String getSharedValue(String paramString)
  {
    return SharedHandler.getInstance().getString(paramString);
  }

  public static void putSharedValue(String paramString1, String paramString2)
  {
    SharedHandler.getInstance().putExtra(paramString1, paramString2);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     in.sriraman.sharedpreferences.SharedDataProvider
 * JD-Core Version:    0.6.0
 */