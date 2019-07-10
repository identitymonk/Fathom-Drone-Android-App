package in.sriraman.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Map;

public class SharedHandler
{
  private static final String SHARED_NAME = "wit_player_shared_preferences";
  private static SharedHandler sSharedHandler;
  private SharedPreferences mSharedPreferences;

  public SharedHandler(Context paramContext)
  {
    this.mSharedPreferences = paramContext.getSharedPreferences("wit_player_shared_preferences", 0);
  }

  public static SharedHandler getInstance()
  {
    return sSharedHandler;
  }

  public static void init(Context paramContext)
  {
    if (sSharedHandler == null)
      sSharedHandler = new SharedHandler(paramContext);
  }

  public void clear()
  {
    this.mSharedPreferences.edit().clear().commit();
  }

  public void deleteKey(String paramString)
  {
    SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
    localEditor.remove(paramString);
    localEditor.commit();
  }

  public Map<String, ?> getAllSharedData()
  {
    return this.mSharedPreferences.getAll();
  }

  public Boolean getBoolean(String paramString)
  {
    return Boolean.valueOf(this.mSharedPreferences.getBoolean(paramString, false));
  }

  public Float getFloat(String paramString)
  {
    return Float.valueOf(this.mSharedPreferences.getFloat(paramString, 0.0F));
  }

  public Integer getInt(String paramString)
  {
    return Integer.valueOf(this.mSharedPreferences.getInt(paramString, 0));
  }

  public Long getLong(String paramString)
  {
    return Long.valueOf(this.mSharedPreferences.getLong(paramString, 0L));
  }

  public String getString(String paramString)
  {
    return this.mSharedPreferences.getString(paramString, null);
  }

  public void putExtra(String paramString, Object paramObject)
  {
    SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
    if ((paramObject instanceof String))
      localEditor.putString(paramString, (String)paramObject).commit();
    do
    {
      return;
      if ((paramObject instanceof Boolean))
      {
        localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue()).commit();
        return;
      }
      if ((paramObject instanceof Integer))
      {
        localEditor.putInt(paramString, ((Integer)paramObject).intValue()).commit();
        return;
      }
      if (!(paramObject instanceof Long))
        continue;
      localEditor.putLong(paramString, ((Long)paramObject).longValue()).commit();
      return;
    }
    while (!(paramObject instanceof Float));
    localEditor.putFloat(paramString, ((Float)paramObject).floatValue()).commit();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     in.sriraman.sharedpreferences.SharedHandler
 * JD-Core Version:    0.6.0
 */