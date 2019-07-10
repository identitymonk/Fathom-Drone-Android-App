package in.sriraman.sharedpreferences;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.widget.ListView;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import java.util.ArrayList;

public class RNSharedPreferencesModule extends ReactContextBaseJavaModule
{
  final int BT_ACTION_REQUEST_ENABLE = 1;
  private BluetoothAdapter bt_adapter = null;
  private ArrayList<BluetoothDevice> bt_device_list = null;
  private BroadcastReceiver bt_info_receiver = null;
  private ListView bt_list_view;
  private boolean bt_scanning = false;
  private boolean is_watch = false;

  public RNSharedPreferencesModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @ReactMethod
  public void clear()
  {
    SharedHandler.init(getReactApplicationContext());
    SharedDataProvider.clear();
  }

  @ReactMethod
  public void getAll(Callback paramCallback)
  {
    SharedHandler.init(getReactApplicationContext());
    String[][] arrayOfString = SharedDataProvider.getAllSharedValues();
    WritableNativeArray localWritableNativeArray1 = new WritableNativeArray();
    int i = 0;
    while (i < arrayOfString.length)
    {
      WritableNativeArray localWritableNativeArray2 = new WritableNativeArray();
      localWritableNativeArray2.pushString(arrayOfString[i][0]);
      localWritableNativeArray2.pushString(arrayOfString[i][1]);
      localWritableNativeArray1.pushArray(localWritableNativeArray2);
      i += 1;
    }
    paramCallback.invoke(new Object[] { localWritableNativeArray1 });
  }

  @ReactMethod
  public void getAllKeys(Callback paramCallback)
  {
    SharedHandler.init(getReactApplicationContext());
    String[] arrayOfString = SharedDataProvider.getAllKeys();
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    int i = 0;
    while (i < arrayOfString.length)
    {
      localWritableNativeArray.pushString(arrayOfString[i]);
      i += 1;
    }
    paramCallback.invoke(new Object[] { localWritableNativeArray });
  }

  @ReactMethod
  public void getItem(String paramString, Callback paramCallback)
  {
    SharedHandler.init(getReactApplicationContext());
    paramCallback.invoke(new Object[] { SharedDataProvider.getSharedValue(paramString) });
  }

  @ReactMethod
  public void getItems(ReadableArray paramReadableArray, Callback paramCallback)
  {
    SharedHandler.init(getReactApplicationContext());
    Object localObject = new String[paramReadableArray.size()];
    int i = 0;
    while (i < paramReadableArray.size())
    {
      localObject[i] = paramReadableArray.getString(i);
      i += 1;
    }
    localObject = SharedDataProvider.getMultiSharedValues(localObject);
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    i = 0;
    while (i < paramReadableArray.size())
    {
      localWritableNativeArray.pushString(localObject[i][1]);
      i += 1;
    }
    paramCallback.invoke(new Object[] { localWritableNativeArray });
  }

  public String getName()
  {
    return "SharedPreferences";
  }

  public void onCreate(Bundle paramBundle)
  {
  }

  @ReactMethod
  public void removeItem(String paramString)
  {
    SharedHandler.init(getReactApplicationContext());
    SharedDataProvider.deleteSharedValue(paramString);
  }

  @ReactMethod
  public void setItem(String paramString1, String paramString2)
  {
    SharedHandler.init(getReactApplicationContext());
    SharedDataProvider.putSharedValue(paramString1, paramString2);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     in.sriraman.sharedpreferences.RNSharedPreferencesModule
 * JD-Core Version:    0.6.0
 */