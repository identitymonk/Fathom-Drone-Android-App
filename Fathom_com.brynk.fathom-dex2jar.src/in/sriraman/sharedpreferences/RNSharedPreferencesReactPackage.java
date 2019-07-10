package in.sriraman.sharedpreferences;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.List;

public class RNSharedPreferencesReactPackage
  implements ReactPackage
{
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RNSharedPreferencesModule(paramReactApplicationContext));
    return localArrayList;
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return new ArrayList();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     in.sriraman.sharedpreferences.RNSharedPreferencesReactPackage
 * JD-Core Version:    0.6.0
 */