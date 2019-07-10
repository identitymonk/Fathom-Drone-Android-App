package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class NotificationManagerCompatKitKat
{
  private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";

  public static boolean areNotificationsEnabled(Context paramContext)
  {
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    Object localObject = paramContext.getApplicationInfo();
    paramContext = paramContext.getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject).uid;
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), paramContext })).intValue();
      return i == 0;
    }
    catch (java.lang.ClassNotFoundException paramContext)
    {
      return true;
    }
    catch (java.lang.RuntimeException paramContext)
    {
      break label122;
    }
    catch (java.lang.NoSuchFieldException paramContext)
    {
      break label122;
    }
    catch (java.lang.IllegalAccessException paramContext)
    {
      break label122;
    }
    catch (java.lang.NoSuchMethodException paramContext)
    {
      break label122;
    }
    catch (java.lang.reflect.InvocationTargetException paramContext)
    {
      label122: break label122;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationManagerCompatKitKat
 * JD-Core Version:    0.6.0
 */