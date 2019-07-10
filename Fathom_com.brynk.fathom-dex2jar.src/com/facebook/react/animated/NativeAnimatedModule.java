package com.facebook.react.animated;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.ArrayList;
import javax.annotation.Nullable;

@ReactModule(name="NativeAnimatedModule")
public class NativeAnimatedModule extends ReactContextBaseJavaModule
  implements OnBatchCompleteListener, LifecycleEventListener
{
  protected static final String NAME = "NativeAnimatedModule";
  private final GuardedFrameCallback mAnimatedFrameCallback;

  @Nullable
  private NativeAnimatedNodesManager mNodesManager;
  private ArrayList<UIThreadOperation> mOperations = new ArrayList();
  private final Object mOperationsCopyLock = new Object();
  private final ReactChoreographer mReactChoreographer = ReactChoreographer.getInstance();

  @Nullable
  private volatile ArrayList<UIThreadOperation> mReadyOperations = null;

  public NativeAnimatedModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mAnimatedFrameCallback = new GuardedFrameCallback(paramReactApplicationContext)
    {
      protected void doFrameGuarded(long paramLong)
      {
        if (NativeAnimatedModule.this.mNodesManager == null)
        {
          ??? = (UIManagerModule)NativeAnimatedModule.this.getReactApplicationContext().getNativeModule(UIManagerModule.class);
          NativeAnimatedModule.access$002(NativeAnimatedModule.this, new NativeAnimatedNodesManager((UIManagerModule)???));
        }
        synchronized (NativeAnimatedModule.this.mOperationsCopyLock)
        {
          ArrayList localArrayList = NativeAnimatedModule.this.mReadyOperations;
          NativeAnimatedModule.access$302(NativeAnimatedModule.this, null);
          if (localArrayList != null)
          {
            int i = 0;
            int j = localArrayList.size();
            if (i < j)
            {
              ((NativeAnimatedModule.UIThreadOperation)localArrayList.get(i)).execute(NativeAnimatedModule.this.mNodesManager);
              i += 1;
            }
          }
        }
        if (NativeAnimatedModule.this.mNodesManager.hasActiveAnimations())
          NativeAnimatedModule.this.mNodesManager.runUpdates(paramLong);
        ((ReactChoreographer)Assertions.assertNotNull(NativeAnimatedModule.this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, NativeAnimatedModule.this.mAnimatedFrameCallback);
      }
    };
  }

  private void clearFrameCallback()
  {
    ((ReactChoreographer)Assertions.assertNotNull(this.mReactChoreographer)).removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
  }

  private void enqueueFrameCallback()
  {
    ((ReactChoreographer)Assertions.assertNotNull(this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
  }

  @ReactMethod
  public void addAnimatedEventToView(int paramInt, String paramString, ReadableMap paramReadableMap)
  {
    this.mOperations.add(new UIThreadOperation(paramInt, paramString, paramReadableMap)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.addAnimatedEventToView(this.val$viewTag, this.val$eventName, this.val$eventMapping);
      }
    });
  }

  @ReactMethod
  public void connectAnimatedNodeToView(int paramInt1, int paramInt2)
  {
    this.mOperations.add(new UIThreadOperation(paramInt1, paramInt2)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.connectAnimatedNodeToView(this.val$animatedNodeTag, this.val$viewTag);
      }
    });
  }

  @ReactMethod
  public void connectAnimatedNodes(int paramInt1, int paramInt2)
  {
    this.mOperations.add(new UIThreadOperation(paramInt1, paramInt2)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.connectAnimatedNodes(this.val$parentNodeTag, this.val$childNodeTag);
      }
    });
  }

  @ReactMethod
  public void createAnimatedNode(int paramInt, ReadableMap paramReadableMap)
  {
    this.mOperations.add(new UIThreadOperation(paramInt, paramReadableMap)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.createAnimatedNode(this.val$tag, this.val$config);
      }
    });
  }

  @ReactMethod
  public void disconnectAnimatedNodeFromView(int paramInt1, int paramInt2)
  {
    this.mOperations.add(new UIThreadOperation(paramInt1, paramInt2)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.disconnectAnimatedNodeFromView(this.val$animatedNodeTag, this.val$viewTag);
      }
    });
  }

  @ReactMethod
  public void disconnectAnimatedNodes(int paramInt1, int paramInt2)
  {
    this.mOperations.add(new UIThreadOperation(paramInt1, paramInt2)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.disconnectAnimatedNodes(this.val$parentNodeTag, this.val$childNodeTag);
      }
    });
  }

  @ReactMethod
  public void dropAnimatedNode(int paramInt)
  {
    this.mOperations.add(new UIThreadOperation(paramInt)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.dropAnimatedNode(this.val$tag);
      }
    });
  }

  @ReactMethod
  public void extractAnimatedNodeOffset(int paramInt)
  {
    this.mOperations.add(new UIThreadOperation(paramInt)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.extractAnimatedNodeOffset(this.val$tag);
      }
    });
  }

  @ReactMethod
  public void flattenAnimatedNodeOffset(int paramInt)
  {
    this.mOperations.add(new UIThreadOperation(paramInt)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.flattenAnimatedNodeOffset(this.val$tag);
      }
    });
  }

  public String getName()
  {
    return "NativeAnimatedModule";
  }

  public void initialize()
  {
    getReactApplicationContext().addLifecycleEventListener(this);
  }

  public void onBatchComplete()
  {
    ArrayList localArrayList;
    if (this.mOperations.isEmpty())
      localArrayList = null;
    while (true)
    {
      if (localArrayList != null)
        this.mOperations = new ArrayList();
      synchronized (this.mOperationsCopyLock)
      {
        if (this.mReadyOperations == null)
        {
          this.mReadyOperations = localArrayList;
          return;
          localArrayList = this.mOperations;
          continue;
        }
        this.mReadyOperations.addAll(localArrayList);
      }
    }
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    clearFrameCallback();
  }

  public void onHostResume()
  {
    enqueueFrameCallback();
  }

  @ReactMethod
  public void removeAnimatedEventFromView(int paramInt1, String paramString, int paramInt2)
  {
    this.mOperations.add(new UIThreadOperation(paramInt1, paramString, paramInt2)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.removeAnimatedEventFromView(this.val$viewTag, this.val$eventName, this.val$animatedValueTag);
      }
    });
  }

  @ReactMethod
  public void setAnimatedNodeOffset(int paramInt, double paramDouble)
  {
    this.mOperations.add(new UIThreadOperation(paramInt, paramDouble)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.setAnimatedNodeOffset(this.val$tag, this.val$value);
      }
    });
  }

  @ReactMethod
  public void setAnimatedNodeValue(int paramInt, double paramDouble)
  {
    this.mOperations.add(new UIThreadOperation(paramInt, paramDouble)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.setAnimatedNodeValue(this.val$tag, this.val$value);
      }
    });
  }

  @ReactMethod
  public void startAnimatingNode(int paramInt1, int paramInt2, ReadableMap paramReadableMap, Callback paramCallback)
  {
    this.mOperations.add(new UIThreadOperation(paramInt1, paramInt2, paramReadableMap, paramCallback)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.startAnimatingNode(this.val$animationId, this.val$animatedNodeTag, this.val$animationConfig, this.val$endCallback);
      }
    });
  }

  @ReactMethod
  public void startListeningToAnimatedNodeValue(int paramInt)
  {
    3 local3 = new AnimatedNodeValueListener(paramInt)
    {
      public void onValueUpdate(double paramDouble)
      {
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putInt("tag", this.val$tag);
        localWritableMap.putDouble("value", paramDouble);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter)NativeAnimatedModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAnimatedValueUpdate", localWritableMap);
      }
    };
    this.mOperations.add(new UIThreadOperation(paramInt, local3)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.startListeningToAnimatedNodeValue(this.val$tag, this.val$listener);
      }
    });
  }

  @ReactMethod
  public void stopAnimation(int paramInt)
  {
    this.mOperations.add(new UIThreadOperation(paramInt)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.stopAnimation(this.val$animationId);
      }
    });
  }

  @ReactMethod
  public void stopListeningToAnimatedNodeValue(int paramInt)
  {
    this.mOperations.add(new UIThreadOperation(paramInt)
    {
      public void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
      {
        paramNativeAnimatedNodesManager.stopListeningToAnimatedNodeValue(this.val$tag);
      }
    });
  }

  private static abstract interface UIThreadOperation
  {
    public abstract void execute(NativeAnimatedNodesManager paramNativeAnimatedNodesManager);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.NativeAnimatedModule
 * JD-Core Version:    0.6.0
 */