package android.support.v4.app;

import android.os.Bundle;
import java.util.Arrays;

class BundleUtil
{
  public static Bundle[] getBundleArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Object localObject = paramBundle.getParcelableArray(paramString);
    if (((localObject instanceof Bundle[])) || (localObject == null))
      return (Bundle[])(Bundle[])localObject;
    localObject = (Bundle[])Arrays.copyOf(localObject, localObject.length, [Landroid.os.Bundle.class);
    paramBundle.putParcelableArray(paramString, localObject);
    return (Bundle)localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BundleUtil
 * JD-Core Version:    0.6.0
 */