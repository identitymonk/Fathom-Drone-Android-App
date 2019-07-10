package com.facebook.react.modules.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.SparseArray;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import java.util.ArrayList;

@ReactModule(name="PermissionsAndroid")
public class PermissionsModule extends ReactContextBaseJavaModule
  implements PermissionListener
{
  private static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
  private final String DENIED = "denied";
  private final String GRANTED = "granted";
  private final String NEVER_ASK_AGAIN = "never_ask_again";
  private final SparseArray<Callback> mCallbacks = new SparseArray();
  private int mRequestCode = 0;

  public PermissionsModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private PermissionAwareActivity getPermissionAwareActivity()
  {
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
    if (!(localActivity instanceof PermissionAwareActivity))
      throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
    return (PermissionAwareActivity)localActivity;
  }

  @ReactMethod
  public void checkPermission(String paramString, Promise paramPromise)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Context localContext = getReactApplicationContext().getBaseContext();
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0);
      while (true)
      {
        paramPromise.resolve(Boolean.valueOf(bool1));
        return;
        bool1 = false;
      }
    }
    if (localContext.checkSelfPermission(paramString) == 0);
    for (bool1 = bool2; ; bool1 = false)
    {
      paramPromise.resolve(Boolean.valueOf(bool1));
      return;
    }
  }

  public String getName()
  {
    return "PermissionsAndroid";
  }

  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ((Callback)this.mCallbacks.get(paramInt)).invoke(new Object[] { paramArrayOfInt, getPermissionAwareActivity() });
    this.mCallbacks.remove(paramInt);
    return this.mCallbacks.size() == 0;
  }

  @ReactMethod
  public void requestMultiplePermissions(ReadableArray paramReadableArray, Promise paramPromise)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Context localContext = getReactApplicationContext().getBaseContext();
    int j = 0;
    if (j < paramReadableArray.size())
    {
      String str2 = paramReadableArray.getString(j);
      String str1;
      if (Build.VERSION.SDK_INT < 23)
        if (localContext.checkPermission(str2, Process.myPid(), Process.myUid()) == 0)
        {
          str1 = "granted";
          label81: localWritableNativeMap.putString(str2, str1);
          i += 1;
        }
      while (true)
      {
        j += 1;
        break;
        str1 = "denied";
        break label81;
        if (localContext.checkSelfPermission(str2) == 0)
        {
          localWritableNativeMap.putString(str2, "granted");
          i += 1;
          continue;
        }
        localArrayList.add(str2);
      }
    }
    if (paramReadableArray.size() == i)
    {
      paramPromise.resolve(localWritableNativeMap);
      return;
    }
    try
    {
      paramReadableArray = getPermissionAwareActivity();
      this.mCallbacks.put(this.mRequestCode, new Callback(localArrayList, localWritableNativeMap, paramPromise)
      {
        public void invoke(Object[] paramArrayOfObject)
        {
          int[] arrayOfInt = (int[])(int[])paramArrayOfObject[0];
          paramArrayOfObject = (PermissionAwareActivity)paramArrayOfObject[1];
          int i = 0;
          if (i < this.val$permissionsToCheck.size())
          {
            String str = (String)this.val$permissionsToCheck.get(i);
            if (arrayOfInt[i] == 0)
              this.val$grantedPermissions.putString(str, "granted");
            while (true)
            {
              i += 1;
              break;
              if (paramArrayOfObject.shouldShowRequestPermissionRationale(str))
              {
                this.val$grantedPermissions.putString(str, "denied");
                continue;
              }
              this.val$grantedPermissions.putString(str, "never_ask_again");
            }
          }
          this.val$promise.resolve(this.val$grantedPermissions);
        }
      });
      paramReadableArray.requestPermissions((String[])localArrayList.toArray(new String[0]), this.mRequestCode, this);
      this.mRequestCode += 1;
      return;
    }
    catch (IllegalStateException paramReadableArray)
    {
      paramPromise.reject("E_INVALID_ACTIVITY", paramReadableArray);
    }
  }

  @ReactMethod
  public void requestPermission(String paramString, Promise paramPromise)
  {
    boolean bool = true;
    Object localObject = getReactApplicationContext().getBaseContext();
    if (Build.VERSION.SDK_INT < 23)
    {
      if (((Context)localObject).checkPermission(paramString, Process.myPid(), Process.myUid()) == 0);
      while (true)
      {
        paramPromise.resolve(Boolean.valueOf(bool));
        return;
        bool = false;
      }
    }
    if (((Context)localObject).checkSelfPermission(paramString) == 0)
    {
      paramPromise.resolve("granted");
      return;
    }
    try
    {
      localObject = getPermissionAwareActivity();
      this.mCallbacks.put(this.mRequestCode, new Callback(paramPromise, paramString)
      {
        public void invoke(Object[] paramArrayOfObject)
        {
          if (((int[])(int[])paramArrayOfObject[0])[0] == 0)
          {
            this.val$promise.resolve("granted");
            return;
          }
          if (((PermissionAwareActivity)paramArrayOfObject[1]).shouldShowRequestPermissionRationale(this.val$permission))
          {
            this.val$promise.resolve("denied");
            return;
          }
          this.val$promise.resolve("never_ask_again");
        }
      });
      int i = this.mRequestCode;
      ((PermissionAwareActivity)localObject).requestPermissions(new String[] { paramString }, i, this);
      this.mRequestCode += 1;
      return;
    }
    catch (IllegalStateException paramString)
    {
      paramPromise.reject("E_INVALID_ACTIVITY", paramString);
    }
  }

  @ReactMethod
  public void shouldShowRequestPermissionRationale(String paramString, Promise paramPromise)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      paramPromise.resolve(Boolean.valueOf(false));
      return;
    }
    try
    {
      paramPromise.resolve(Boolean.valueOf(getPermissionAwareActivity().shouldShowRequestPermissionRationale(paramString)));
      return;
    }
    catch (IllegalStateException paramString)
    {
      paramPromise.reject("E_INVALID_ACTIVITY", paramString);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.permissions.PermissionsModule
 * JD-Core Version:    0.6.0
 */