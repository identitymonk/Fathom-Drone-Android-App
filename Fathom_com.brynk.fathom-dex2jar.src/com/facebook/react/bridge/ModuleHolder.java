package com.facebook.react.bridge;

import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Provider;

@DoNotStrip
public class ModuleHolder
{
  private static final AtomicInteger sInstanceKeyCounter = new AtomicInteger(1);
  private final boolean mCanOverrideExistingModule;
  private final boolean mHasConstants;

  @GuardedBy("this")
  private boolean mInitializable;
  private final int mInstanceKey = sInstanceKeyCounter.getAndIncrement();

  @GuardedBy("this")
  private boolean mIsCreating;

  @GuardedBy("this")
  private boolean mIsInitializing;

  @Nullable
  @GuardedBy("this")
  private NativeModule mModule;
  private final String mName;

  @Nullable
  private Provider<? extends NativeModule> mProvider;

  public ModuleHolder(NativeModule paramNativeModule)
  {
    this.mName = paramNativeModule.getName();
    this.mCanOverrideExistingModule = paramNativeModule.canOverrideExistingModule();
    this.mHasConstants = true;
    this.mModule = paramNativeModule;
    PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.NATIVE_MODULE, "NativeModule init: %s", new Object[] { this.mName });
  }

  public ModuleHolder(ReactModuleInfo paramReactModuleInfo, Provider<? extends NativeModule> paramProvider)
  {
    this.mName = paramReactModuleInfo.name();
    this.mCanOverrideExistingModule = paramReactModuleInfo.canOverrideExistingModule();
    this.mHasConstants = paramReactModuleInfo.hasConstants();
    this.mProvider = paramProvider;
    if (paramReactModuleInfo.needsEagerInit())
      this.mModule = create();
  }

  private NativeModule create()
  {
    boolean bool;
    if (this.mModule == null)
      bool = true;
    while (true)
    {
      SoftAssertions.assertCondition(bool, "Creating an already created module.");
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, this.mName, this.mInstanceKey);
      SystraceMessage.beginSection(0L, "ModuleHolder.createModule").arg("name", this.mName).flush();
      PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.NATIVE_MODULE, "NativeModule init: %s", new Object[] { this.mName });
      try
      {
        NativeModule localNativeModule = (NativeModule)((Provider)Assertions.assertNotNull(this.mProvider)).get();
        this.mProvider = null;
        int j = 0;
        monitorenter;
        try
        {
          this.mModule = localNativeModule;
          int i = j;
          if (this.mInitializable)
          {
            i = j;
            if (!this.mIsInitializing)
              i = 1;
          }
          monitorexit;
          if (i != 0)
            doInitialize(localNativeModule);
          ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END, this.mInstanceKey);
          SystraceMessage.endSection(0L).flush();
          return localNativeModule;
          bool = false;
          continue;
        }
        finally
        {
          monitorexit;
        }
      }
      finally
      {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END, this.mInstanceKey);
        SystraceMessage.endSection(0L).flush();
      }
    }
    throw localObject2;
  }

  // ERROR //
  private void doInitialize(NativeModule paramNativeModule)
  {
    // Byte code:
    //   0: lconst_0
    //   1: ldc 174
    //   3: invokestatic 133	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   6: ldc 134
    //   8: aload_0
    //   9: getfield 54	com/facebook/react/bridge/ModuleHolder:mName	Ljava/lang/String;
    //   12: invokevirtual 140	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;Ljava/lang/Object;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   15: invokevirtual 143	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   18: getstatic 177	com/facebook/react/bridge/ReactMarkerConstants:INITIALIZE_MODULE_START	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   21: aload_0
    //   22: getfield 54	com/facebook/react/bridge/ModuleHolder:mName	Ljava/lang/String;
    //   25: aload_0
    //   26: getfield 46	com/facebook/react/bridge/ModuleHolder:mInstanceKey	I
    //   29: invokestatic 125	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;Ljava/lang/String;I)V
    //   32: iconst_0
    //   33: istore_3
    //   34: aload_0
    //   35: monitorenter
    //   36: iload_3
    //   37: istore_2
    //   38: aload_0
    //   39: getfield 157	com/facebook/react/bridge/ModuleHolder:mInitializable	Z
    //   42: ifeq +19 -> 61
    //   45: iload_3
    //   46: istore_2
    //   47: aload_0
    //   48: getfield 159	com/facebook/react/bridge/ModuleHolder:mIsInitializing	Z
    //   51: ifne +10 -> 61
    //   54: iconst_1
    //   55: istore_2
    //   56: aload_0
    //   57: iconst_1
    //   58: putfield 159	com/facebook/react/bridge/ModuleHolder:mIsInitializing	Z
    //   61: aload_0
    //   62: monitorexit
    //   63: iload_2
    //   64: ifeq +18 -> 82
    //   67: aload_1
    //   68: invokeinterface 180 1 0
    //   73: aload_0
    //   74: monitorenter
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 159	com/facebook/react/bridge/ModuleHolder:mIsInitializing	Z
    //   80: aload_0
    //   81: monitorexit
    //   82: getstatic 183	com/facebook/react/bridge/ReactMarkerConstants:INITIALIZE_MODULE_END	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   85: aload_0
    //   86: getfield 46	com/facebook/react/bridge/ModuleHolder:mInstanceKey	I
    //   89: invokestatic 168	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;I)V
    //   92: lconst_0
    //   93: invokestatic 172	com/facebook/systrace/SystraceMessage:endSection	(J)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   96: invokevirtual 143	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   99: return
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: getstatic 183	com/facebook/react/bridge/ReactMarkerConstants:INITIALIZE_MODULE_END	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   109: aload_0
    //   110: getfield 46	com/facebook/react/bridge/ModuleHolder:mInstanceKey	I
    //   113: invokestatic 168	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;I)V
    //   116: lconst_0
    //   117: invokestatic 172	com/facebook/systrace/SystraceMessage:endSection	(J)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   120: invokevirtual 143	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   38	45	100	finally
    //   47	54	100	finally
    //   56	61	100	finally
    //   61	63	100	finally
    //   101	103	100	finally
    //   34	36	105	finally
    //   67	75	105	finally
    //   103	105	105	finally
    //   128	130	105	finally
    //   75	82	125	finally
    //   126	128	125	finally
  }

  public void destroy()
  {
    monitorenter;
    try
    {
      if (this.mModule != null)
        this.mModule.onCatalystInstanceDestroy();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean getCanOverrideExistingModule()
  {
    return this.mCanOverrideExistingModule;
  }

  public boolean getHasConstants()
  {
    return this.mHasConstants;
  }

  @DoNotStrip
  public NativeModule getModule()
  {
    int i = 0;
    monitorenter;
    try
    {
      NativeModule localNativeModule1;
      if (this.mModule != null)
      {
        localNativeModule1 = this.mModule;
        return localNativeModule1;
      }
      if (!this.mIsCreating)
      {
        i = 1;
        this.mIsCreating = true;
      }
      monitorexit;
      if (i != 0)
      {
        localNativeModule1 = create();
        monitorenter;
        try
        {
          this.mIsCreating = false;
          notifyAll();
          return localNativeModule1;
        }
        finally
        {
          monitorexit;
        }
      }
    }
    finally
    {
      monitorexit;
    }
    monitorenter;
    try
    {
      while (this.mModule == null)
      {
        boolean bool = this.mIsCreating;
        if (!bool)
          break;
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
        }
      }
      NativeModule localNativeModule2 = (NativeModule)Assertions.assertNotNull(this.mModule);
      return localNativeModule2;
    }
    finally
    {
      monitorexit;
    }
    throw localObject3;
  }

  @DoNotStrip
  public String getName()
  {
    return this.mName;
  }

  boolean hasInstance()
  {
    monitorenter;
    try
    {
      NativeModule localNativeModule = this.mModule;
      if (localNativeModule != null)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  void markInitializable()
  {
    boolean bool = true;
    int i = 0;
    NativeModule localNativeModule = null;
    monitorenter;
    try
    {
      this.mInitializable = true;
      if (this.mModule != null)
        if (this.mIsInitializing)
          break label50;
      while (true)
      {
        Assertions.assertCondition(bool);
        i = 1;
        localNativeModule = this.mModule;
        monitorexit;
        if (i != 0)
          doInitialize(localNativeModule);
        return;
        label50: bool = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ModuleHolder
 * JD-Core Version:    0.6.0
 */