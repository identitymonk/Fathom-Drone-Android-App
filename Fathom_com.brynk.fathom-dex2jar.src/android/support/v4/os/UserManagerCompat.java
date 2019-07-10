package android.support.v4.os;

import android.content.Context;

public class UserManagerCompat
{
  @Deprecated
  public static boolean isUserRunningAndLocked(Context paramContext)
  {
    return !isUserUnlocked(paramContext);
  }

  @Deprecated
  public static boolean isUserRunningAndUnlocked(Context paramContext)
  {
    return isUserUnlocked(paramContext);
  }

  public static boolean isUserUnlocked(Context paramContext)
  {
    if (BuildCompat.isAtLeastN())
      return UserManagerCompatApi24.isUserUnlocked(paramContext);
    return true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.os.UserManagerCompat
 * JD-Core Version:    0.6.0
 */