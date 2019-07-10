package io.vov.vitamio;

import android.content.Context;
import io.vov.vitamio.utils.ContextUtils;

public class Vitamio
{
  private static String vitamioLibraryPath;
  private static String vitamioPackage;

  public static final String getLibraryPath()
  {
    return vitamioLibraryPath;
  }

  public static String getVitamioPackage()
  {
    return vitamioPackage;
  }

  public static boolean isInitialized(Context paramContext)
  {
    vitamioPackage = paramContext.getPackageName();
    vitamioLibraryPath = ContextUtils.getDataDir(paramContext) + "lib/";
    return true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.Vitamio
 * JD-Core Version:    0.6.0
 */