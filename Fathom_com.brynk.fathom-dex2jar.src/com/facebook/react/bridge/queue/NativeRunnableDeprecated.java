package com.facebook.react.bridge.queue;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class NativeRunnableDeprecated extends Countable
  implements Runnable
{
  public native void run();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.NativeRunnableDeprecated
 * JD-Core Version:    0.6.0
 */