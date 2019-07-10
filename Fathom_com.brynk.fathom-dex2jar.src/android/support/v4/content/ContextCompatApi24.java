package android.support.v4.content;

import android.content.Context;
import java.io.File;

public class ContextCompatApi24
{
  public static Context createDeviceProtectedStorageContext(Context paramContext)
  {
    return paramContext.createDeviceProtectedStorageContext();
  }

  public static File getDataDir(Context paramContext)
  {
    return paramContext.getDataDir();
  }

  public static boolean isDeviceProtectedStorage(Context paramContext)
  {
    return paramContext.isDeviceProtectedStorage();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompatApi24
 * JD-Core Version:    0.6.0
 */