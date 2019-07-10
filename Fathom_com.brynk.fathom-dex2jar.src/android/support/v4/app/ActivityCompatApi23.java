package android.support.v4.app;

import android.app.Activity;

class ActivityCompatApi23
{
  public static void requestPermissions(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    if ((paramActivity instanceof RequestPermissionsRequestCodeValidator))
      ((RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt);
    paramActivity.requestPermissions(paramArrayOfString, paramInt);
  }

  public static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString)
  {
    return paramActivity.shouldShowRequestPermissionRationale(paramString);
  }

  public static abstract interface RequestPermissionsRequestCodeValidator
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityCompatApi23
 * JD-Core Version:    0.6.0
 */