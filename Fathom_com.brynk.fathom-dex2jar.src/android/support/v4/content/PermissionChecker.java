package android.support.v4.content;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.v4.app.AppOpsManagerCompat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionChecker
{
  public static final int PERMISSION_DENIED = -1;
  public static final int PERMISSION_DENIED_APP_OP = -2;
  public static final int PERMISSION_GRANTED = 0;

  public static int checkCallingOrSelfPermission(@NonNull Context paramContext, @NonNull String paramString)
  {
    if (Binder.getCallingPid() == Process.myPid());
    for (String str = paramContext.getPackageName(); ; str = null)
      return checkPermission(paramContext, paramString, Binder.getCallingPid(), Binder.getCallingUid(), str);
  }

  public static int checkCallingPermission(@NonNull Context paramContext, @NonNull String paramString1, String paramString2)
  {
    if (Binder.getCallingPid() == Process.myPid())
      return -1;
    return checkPermission(paramContext, paramString1, Binder.getCallingPid(), Binder.getCallingUid(), paramString2);
  }

  public static int checkPermission(@NonNull Context paramContext, @NonNull String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) == -1);
    String str;
    while (true)
    {
      return -1;
      str = AppOpsManagerCompat.permissionToOp(paramString1);
      if (str == null)
        return 0;
      paramString1 = paramString2;
      if (paramString2 != null)
        break;
      paramString1 = paramContext.getPackageManager().getPackagesForUid(paramInt2);
      if ((paramString1 == null) || (paramString1.length <= 0))
        continue;
      paramString1 = paramString1[0];
    }
    if (AppOpsManagerCompat.noteProxyOp(paramContext, str, paramString1) != 0)
      return -2;
    return 0;
  }

  public static int checkSelfPermission(@NonNull Context paramContext, @NonNull String paramString)
  {
    return checkPermission(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface PermissionResult
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.content.PermissionChecker
 * JD-Core Version:    0.6.0
 */