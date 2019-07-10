package android.support.v4.os;

import android.content.Context;
import android.os.UserManager;

public class UserManagerCompatApi24
{
  public static boolean isUserUnlocked(Context paramContext)
  {
    return ((UserManager)paramContext.getSystemService(UserManager.class)).isUserUnlocked();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.os.UserManagerCompatApi24
 * JD-Core Version:    0.6.0
 */