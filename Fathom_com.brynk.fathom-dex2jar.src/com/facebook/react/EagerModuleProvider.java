package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import javax.inject.Provider;

public class EagerModuleProvider
  implements Provider<NativeModule>
{
  private final NativeModule mModule;

  public EagerModuleProvider(NativeModule paramNativeModule)
  {
    this.mModule = paramNativeModule;
  }

  public NativeModule get()
  {
    return this.mModule;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.EagerModuleProvider
 * JD-Core Version:    0.6.0
 */