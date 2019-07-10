package com.facebook.react.uimanager;

import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.react.animation.Animation;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class UIViewOperationQueue
{
  public static final int DEFAULT_MIN_TIME_LEFT_IN_FRAME_FOR_NONBATCHED_OPERATION_MS = 8;
  private final AnimationRegistry mAnimationRegistry;
  private final Object mDispatchRunnablesLock = new Object();
  private final DispatchUIFrameCallback mDispatchUIFrameCallback;

  @GuardedBy("mDispatchRunnablesLock")
  private ArrayList<Runnable> mDispatchUIRunnables = new ArrayList();
  private boolean mIsDispatchUIFrameCallbackEnqueued = false;
  private boolean mIsInIllegalUIState = false;
  private boolean mIsProfilingNextBatch = false;
  private final int[] mMeasureBuffer = new int[4];
  private final NativeViewHierarchyManager mNativeViewHierarchyManager;
  private long mNonBatchedExecutionTotalTime;

  @GuardedBy("mNonBatchedOperationsLock")
  private ArrayDeque<UIOperation> mNonBatchedOperations = new ArrayDeque();
  private final Object mNonBatchedOperationsLock = new Object();
  private ArrayList<UIOperation> mOperations = new ArrayList();
  private long mProfiledBatchBatchedExecutionTime;
  private long mProfiledBatchCommitStartTime;
  private long mProfiledBatchDispatchViewUpdatesTime;
  private long mProfiledBatchLayoutTime;
  private long mProfiledBatchNonBatchedExecutionTime;
  private long mProfiledBatchRunStartTime;
  private final ReactApplicationContext mReactApplicationContext;

  @Nullable
  private NotThreadSafeViewHierarchyUpdateDebugListener mViewHierarchyUpdateDebugListener;

  public UIViewOperationQueue(ReactApplicationContext paramReactApplicationContext, NativeViewHierarchyManager paramNativeViewHierarchyManager, int paramInt)
  {
    this.mNativeViewHierarchyManager = paramNativeViewHierarchyManager;
    this.mAnimationRegistry = paramNativeViewHierarchyManager.getAnimationRegistry();
    int i = paramInt;
    if (paramInt == -1)
      i = 8;
    this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(paramReactApplicationContext, i, null);
    this.mReactApplicationContext = paramReactApplicationContext;
  }

  private void flushPendingBatches()
  {
    if (this.mIsInIllegalUIState)
    {
      FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
      return;
    }
    long l;
    synchronized (this.mDispatchRunnablesLock)
    {
      if (!this.mDispatchUIRunnables.isEmpty())
      {
        ArrayList localArrayList = this.mDispatchUIRunnables;
        this.mDispatchUIRunnables = new ArrayList();
        l = SystemClock.uptimeMillis();
        ??? = localArrayList.iterator();
        while (((Iterator)???).hasNext())
          ((Runnable)((Iterator)???).next()).run();
      }
      return;
    }
    if (this.mIsProfilingNextBatch)
    {
      this.mProfiledBatchBatchedExecutionTime = (SystemClock.uptimeMillis() - l);
      this.mProfiledBatchNonBatchedExecutionTime = this.mNonBatchedExecutionTotalTime;
      this.mIsProfilingNextBatch = false;
      Systrace.beginAsyncSection(0L, "batchedExecutionTime", 0, 1000000L * l);
      Systrace.endAsyncSection(0L, "batchedExecutionTime", 0);
    }
    this.mNonBatchedExecutionTotalTime = 0L;
  }

  public void addRootView(int paramInt, SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout, ThemedReactContext paramThemedReactContext)
  {
    this.mNativeViewHierarchyManager.addRootView(paramInt, paramSizeMonitoringFrameLayout, paramThemedReactContext);
  }

  // ERROR //
  void dispatchViewUpdates(int paramInt, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: lconst_0
    //   1: ldc_w 277
    //   4: invokestatic 283	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   7: ldc_w 285
    //   10: iload_1
    //   11: invokevirtual 291	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   14: invokevirtual 294	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   17: invokestatic 233	android/os/SystemClock:uptimeMillis	()J
    //   20: lstore 6
    //   22: aload_0
    //   23: getfield 137	com/facebook/react/uimanager/UIViewOperationQueue:mOperations	Ljava/util/ArrayList;
    //   26: invokevirtual 227	java/util/ArrayList:isEmpty	()Z
    //   29: ifne +165 -> 194
    //   32: aload_0
    //   33: getfield 137	com/facebook/react/uimanager/UIViewOperationQueue:mOperations	Ljava/util/ArrayList;
    //   36: astore 8
    //   38: aload_0
    //   39: new 134	java/util/ArrayList
    //   42: dup
    //   43: invokespecial 135	java/util/ArrayList:<init>	()V
    //   46: putfield 137	com/facebook/react/uimanager/UIViewOperationQueue:mOperations	Ljava/util/ArrayList;
    //   49: aload_0
    //   50: getfield 132	com/facebook/react/uimanager/UIViewOperationQueue:mNonBatchedOperationsLock	Ljava/lang/Object;
    //   53: astore 10
    //   55: aload 10
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 144	com/facebook/react/uimanager/UIViewOperationQueue:mNonBatchedOperations	Ljava/util/ArrayDeque;
    //   62: invokevirtual 295	java/util/ArrayDeque:isEmpty	()Z
    //   65: ifne +135 -> 200
    //   68: aload_0
    //   69: getfield 144	com/facebook/react/uimanager/UIViewOperationQueue:mNonBatchedOperations	Ljava/util/ArrayDeque;
    //   72: astore 9
    //   74: aload_0
    //   75: new 141	java/util/ArrayDeque
    //   78: dup
    //   79: invokespecial 142	java/util/ArrayDeque:<init>	()V
    //   82: putfield 144	com/facebook/react/uimanager/UIViewOperationQueue:mNonBatchedOperations	Ljava/util/ArrayDeque;
    //   85: aload 10
    //   87: monitorexit
    //   88: aload_0
    //   89: getfield 195	com/facebook/react/uimanager/UIViewOperationQueue:mViewHierarchyUpdateDebugListener	Lcom/facebook/react/uimanager/debug/NotThreadSafeViewHierarchyUpdateDebugListener;
    //   92: ifnull +12 -> 104
    //   95: aload_0
    //   96: getfield 195	com/facebook/react/uimanager/UIViewOperationQueue:mViewHierarchyUpdateDebugListener	Lcom/facebook/react/uimanager/debug/NotThreadSafeViewHierarchyUpdateDebugListener;
    //   99: invokeinterface 300 1 0
    //   104: new 6	com/facebook/react/uimanager/UIViewOperationQueue$1
    //   107: dup
    //   108: aload_0
    //   109: iload_1
    //   110: aload 9
    //   112: aload 8
    //   114: lload_2
    //   115: lload 4
    //   117: lload 6
    //   119: invokespecial 303	com/facebook/react/uimanager/UIViewOperationQueue$1:<init>	(Lcom/facebook/react/uimanager/UIViewOperationQueue;ILjava/util/ArrayDeque;Ljava/util/ArrayList;JJJ)V
    //   122: astore 9
    //   124: lconst_0
    //   125: ldc_w 305
    //   128: invokestatic 283	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   131: ldc_w 285
    //   134: iload_1
    //   135: invokevirtual 291	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   138: invokevirtual 294	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   141: aload_0
    //   142: getfield 130	com/facebook/react/uimanager/UIViewOperationQueue:mDispatchRunnablesLock	Ljava/lang/Object;
    //   145: astore 8
    //   147: aload 8
    //   149: monitorenter
    //   150: lconst_0
    //   151: invokestatic 309	com/facebook/systrace/Systrace:endSection	(J)V
    //   154: aload_0
    //   155: getfield 139	com/facebook/react/uimanager/UIViewOperationQueue:mDispatchUIRunnables	Ljava/util/ArrayList;
    //   158: aload 9
    //   160: invokevirtual 313	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   163: pop
    //   164: aload 8
    //   166: monitorexit
    //   167: aload_0
    //   168: getfield 146	com/facebook/react/uimanager/UIViewOperationQueue:mIsDispatchUIFrameCallbackEnqueued	Z
    //   171: ifne +18 -> 189
    //   174: new 8	com/facebook/react/uimanager/UIViewOperationQueue$2
    //   177: dup
    //   178: aload_0
    //   179: aload_0
    //   180: getfield 167	com/facebook/react/uimanager/UIViewOperationQueue:mReactApplicationContext	Lcom/facebook/react/bridge/ReactApplicationContext;
    //   183: invokespecial 316	com/facebook/react/uimanager/UIViewOperationQueue$2:<init>	(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/bridge/ReactContext;)V
    //   186: invokestatic 322	com/facebook/react/bridge/UiThreadUtil:runOnUiThread	(Ljava/lang/Runnable;)V
    //   189: lconst_0
    //   190: invokestatic 309	com/facebook/systrace/Systrace:endSection	(J)V
    //   193: return
    //   194: aconst_null
    //   195: astore 8
    //   197: goto -148 -> 49
    //   200: aconst_null
    //   201: astore 9
    //   203: goto -118 -> 85
    //   206: astore 8
    //   208: aload 10
    //   210: monitorexit
    //   211: aload 8
    //   213: athrow
    //   214: astore 8
    //   216: lconst_0
    //   217: invokestatic 309	com/facebook/systrace/Systrace:endSection	(J)V
    //   220: aload 8
    //   222: athrow
    //   223: astore 9
    //   225: aload 8
    //   227: monitorexit
    //   228: aload 9
    //   230: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   58	85	206	finally
    //   85	88	206	finally
    //   208	211	206	finally
    //   17	49	214	finally
    //   49	58	214	finally
    //   88	104	214	finally
    //   104	150	214	finally
    //   167	189	214	finally
    //   211	214	214	finally
    //   228	231	214	finally
    //   150	167	223	finally
    //   225	228	223	finally
  }

  public void enqueueAddAnimation(int paramInt1, int paramInt2, Callback paramCallback)
  {
    this.mOperations.add(new AddAnimationOperation(paramInt1, paramInt2, paramCallback, null));
  }

  public void enqueueClearJSResponder()
  {
    this.mOperations.add(new ChangeJSResponderOperation(0, 0, true, false));
  }

  public void enqueueConfigureLayoutAnimation(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    this.mOperations.add(new ConfigureLayoutAnimationOperation(paramReadableMap, null));
  }

  public void enqueueCreateView(ThemedReactContext paramThemedReactContext, int paramInt, String paramString, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    synchronized (this.mNonBatchedOperationsLock)
    {
      this.mNonBatchedOperations.addLast(new CreateViewOperation(paramThemedReactContext, paramInt, paramString, paramReactStylesDiffMap));
      return;
    }
  }

  public void enqueueDispatchCommand(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    this.mOperations.add(new DispatchCommandOperation(paramInt1, paramInt2, paramReadableArray));
  }

  public void enqueueFindTargetForTouch(int paramInt, float paramFloat1, float paramFloat2, Callback paramCallback)
  {
    this.mOperations.add(new FindTargetForTouchOperation(paramInt, paramFloat1, paramFloat2, paramCallback, null));
  }

  public void enqueueManageChildren(int paramInt, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, @Nullable int[] paramArrayOfInt2)
  {
    this.mOperations.add(new ManageChildrenOperation(paramInt, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
  }

  public void enqueueMeasure(int paramInt, Callback paramCallback)
  {
    this.mOperations.add(new MeasureOperation(paramInt, paramCallback, null));
  }

  public void enqueueMeasureInWindow(int paramInt, Callback paramCallback)
  {
    this.mOperations.add(new MeasureInWindowOperation(paramInt, paramCallback, null));
  }

  public void enqueueRegisterAnimation(Animation paramAnimation)
  {
    this.mOperations.add(new RegisterAnimationOperation(paramAnimation, null));
  }

  public void enqueueRemoveAnimation(int paramInt)
  {
    this.mOperations.add(new RemoveAnimationOperation(paramInt, null));
  }

  public void enqueueRemoveRootView(int paramInt)
  {
    this.mOperations.add(new RemoveRootViewOperation(paramInt));
  }

  public void enqueueSendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    this.mOperations.add(new SendAccessibilityEvent(paramInt1, paramInt2, null));
  }

  public void enqueueSetChildren(int paramInt, ReadableArray paramReadableArray)
  {
    this.mOperations.add(new SetChildrenOperation(paramInt, paramReadableArray));
  }

  public void enqueueSetJSResponder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mOperations.add(new ChangeJSResponderOperation(paramInt1, paramInt2, false, paramBoolean));
  }

  public void enqueueSetLayoutAnimationEnabled(boolean paramBoolean)
  {
    this.mOperations.add(new SetLayoutAnimationEnabledOperation(paramBoolean, null));
  }

  public void enqueueShowPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    this.mOperations.add(new ShowPopupMenuOperation(paramInt, paramReadableArray, paramCallback2));
  }

  public void enqueueUIBlock(UIBlock paramUIBlock)
  {
    this.mOperations.add(new UIBlockOperation(paramUIBlock));
  }

  protected void enqueueUIOperation(UIOperation paramUIOperation)
  {
    SoftAssertions.assertNotNull(paramUIOperation);
    this.mOperations.add(paramUIOperation);
  }

  public void enqueueUpdateExtraData(int paramInt, Object paramObject)
  {
    this.mOperations.add(new UpdateViewExtraData(paramInt, paramObject));
  }

  public void enqueueUpdateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mOperations.add(new UpdateLayoutOperation(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }

  public void enqueueUpdateProperties(int paramInt, String paramString, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    this.mOperations.add(new UpdatePropertiesOperation(paramInt, paramReactStylesDiffMap, null));
  }

  NativeViewHierarchyManager getNativeViewHierarchyManager()
  {
    return this.mNativeViewHierarchyManager;
  }

  public Map<String, Long> getProfiledBatchPerfCounters()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("CommitStartTime", Long.valueOf(this.mProfiledBatchCommitStartTime));
    localHashMap.put("LayoutTime", Long.valueOf(this.mProfiledBatchLayoutTime));
    localHashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mProfiledBatchDispatchViewUpdatesTime));
    localHashMap.put("RunStartTime", Long.valueOf(this.mProfiledBatchRunStartTime));
    localHashMap.put("BatchedExecutionTime", Long.valueOf(this.mProfiledBatchBatchedExecutionTime));
    localHashMap.put("NonBatchedExecutionTime", Long.valueOf(this.mProfiledBatchNonBatchedExecutionTime));
    return localHashMap;
  }

  public boolean isEmpty()
  {
    return this.mOperations.isEmpty();
  }

  void pauseFrameCallback()
  {
    this.mIsDispatchUIFrameCallbackEnqueued = false;
    ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    flushPendingBatches();
  }

  public void profileNextBatch()
  {
    this.mIsProfilingNextBatch = true;
    this.mProfiledBatchCommitStartTime = 0L;
  }

  void resumeFrameCallback()
  {
    this.mIsDispatchUIFrameCallbackEnqueued = true;
    ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
  }

  public void setViewHierarchyUpdateDebugListener(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener paramNotThreadSafeViewHierarchyUpdateDebugListener)
  {
    this.mViewHierarchyUpdateDebugListener = paramNotThreadSafeViewHierarchyUpdateDebugListener;
  }

  private class AddAnimationOperation extends UIViewOperationQueue.AnimationOperation
  {
    private final int mReactTag;
    private final Callback mSuccessCallback;

    private AddAnimationOperation(int paramInt1, int paramCallback, Callback arg4)
    {
      super();
      this.mReactTag = paramInt1;
      Object localObject;
      this.mSuccessCallback = localObject;
    }

    public void execute()
    {
      Animation localAnimation = UIViewOperationQueue.this.mAnimationRegistry.getAnimation(this.mAnimationID);
      if (localAnimation != null)
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.startAnimationForNativeView(this.mReactTag, localAnimation, this.mSuccessCallback);
        return;
      }
      throw new IllegalViewOperationException("Animation with id " + this.mAnimationID + " was not found");
    }
  }

  private static abstract class AnimationOperation
    implements UIViewOperationQueue.UIOperation
  {
    protected final int mAnimationID;

    public AnimationOperation(int paramInt)
    {
      this.mAnimationID = paramInt;
    }
  }

  private final class ChangeJSResponderOperation extends UIViewOperationQueue.ViewOperation
  {
    private final boolean mBlockNativeResponder;
    private final boolean mClearResponder;
    private final int mInitialTag;

    public ChangeJSResponderOperation(int paramInt1, int paramBoolean1, boolean paramBoolean2, boolean arg5)
    {
      super(paramInt1);
      this.mInitialTag = paramBoolean1;
      this.mClearResponder = paramBoolean2;
      boolean bool;
      this.mBlockNativeResponder = bool;
    }

    public void execute()
    {
      if (!this.mClearResponder)
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.setJSResponder(this.mTag, this.mInitialTag, this.mBlockNativeResponder);
        return;
      }
      UIViewOperationQueue.this.mNativeViewHierarchyManager.clearJSResponder();
    }
  }

  private class ConfigureLayoutAnimationOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final ReadableMap mConfig;

    private ConfigureLayoutAnimationOperation(ReadableMap arg2)
    {
      Object localObject;
      this.mConfig = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.configureLayoutAnimation(this.mConfig);
    }
  }

  private final class CreateViewOperation extends UIViewOperationQueue.ViewOperation
  {
    private final String mClassName;

    @Nullable
    private final ReactStylesDiffMap mInitialProps;
    private final ThemedReactContext mThemedContext;

    public CreateViewOperation(ThemedReactContext paramInt, int paramString, @Nullable String paramReactStylesDiffMap, ReactStylesDiffMap arg5)
    {
      super(paramString);
      this.mThemedContext = paramInt;
      this.mClassName = paramReactStylesDiffMap;
      Object localObject;
      this.mInitialProps = localObject;
      Systrace.startAsyncFlow(0L, "createView", this.mTag);
    }

    public void execute()
    {
      Systrace.endAsyncFlow(0L, "createView", this.mTag);
      UIViewOperationQueue.this.mNativeViewHierarchyManager.createView(this.mThemedContext, this.mTag, this.mClassName, this.mInitialProps);
    }
  }

  private final class DispatchCommandOperation extends UIViewOperationQueue.ViewOperation
  {

    @Nullable
    private final ReadableArray mArgs;
    private final int mCommand;

    public DispatchCommandOperation(int paramInt1, @Nullable int paramReadableArray, ReadableArray arg4)
    {
      super(paramInt1);
      this.mCommand = paramReadableArray;
      Object localObject;
      this.mArgs = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
    }
  }

  private class DispatchUIFrameCallback extends GuardedFrameCallback
  {
    private static final int FRAME_TIME_MS = 16;
    private final int mMinTimeLeftInFrameForNonBatchedOperationMs;

    private DispatchUIFrameCallback(ReactContext paramInt, int arg3)
    {
      super();
      int i;
      this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
    }

    private void dispatchPendingNonBatchedOperations(long paramLong)
    {
      while (true)
      {
        if (16L - (System.nanoTime() - paramLong) / 1000000L < this.mMinTimeLeftInFrameForNonBatchedOperationMs)
          return;
        synchronized (UIViewOperationQueue.this.mNonBatchedOperationsLock)
        {
          if (UIViewOperationQueue.this.mNonBatchedOperations.isEmpty())
            return;
        }
        UIViewOperationQueue.UIOperation localUIOperation = (UIViewOperationQueue.UIOperation)UIViewOperationQueue.this.mNonBatchedOperations.pollFirst();
        monitorexit;
        try
        {
          long l = SystemClock.uptimeMillis();
          localUIOperation.execute();
          UIViewOperationQueue.access$2402(UIViewOperationQueue.this, UIViewOperationQueue.this.mNonBatchedExecutionTotalTime + (SystemClock.uptimeMillis() - l));
        }
        catch (Exception localException)
        {
          UIViewOperationQueue.access$2002(UIViewOperationQueue.this, true);
        }
      }
      throw localException;
    }

    public void doFrameGuarded(long paramLong)
    {
      if (UIViewOperationQueue.this.mIsInIllegalUIState)
      {
        FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
        return;
      }
      Systrace.beginSection(0L, "dispatchNonBatchedUIOperations");
      try
      {
        dispatchPendingNonBatchedOperations(paramLong);
        Systrace.endSection(0L);
        UIViewOperationQueue.this.flushPendingBatches();
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this);
        return;
      }
      finally
      {
        Systrace.endSection(0L);
      }
      throw localObject;
    }
  }

  private final class FindTargetForTouchOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final Callback mCallback;
    private final int mReactTag;
    private final float mTargetX;
    private final float mTargetY;

    private FindTargetForTouchOperation(int paramFloat1, float paramFloat2, float paramCallback, Callback arg5)
    {
      this.mReactTag = paramFloat1;
      this.mTargetX = paramFloat2;
      this.mTargetY = paramCallback;
      Object localObject;
      this.mCallback = localObject;
    }

    // ERROR //
    public void execute()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   4: invokestatic 44	com/facebook/react/uimanager/UIViewOperationQueue:access$000	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;
      //   7: aload_0
      //   8: getfield 27	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mReactTag	I
      //   11: aload_0
      //   12: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   15: invokestatic 48	com/facebook/react/uimanager/UIViewOperationQueue:access$200	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   18: invokevirtual 54	com/facebook/react/uimanager/NativeViewHierarchyManager:measure	(I[I)V
      //   21: aload_0
      //   22: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   25: invokestatic 48	com/facebook/react/uimanager/UIViewOperationQueue:access$200	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   28: iconst_0
      //   29: iaload
      //   30: i2f
      //   31: fstore_1
      //   32: aload_0
      //   33: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   36: invokestatic 48	com/facebook/react/uimanager/UIViewOperationQueue:access$200	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   39: iconst_1
      //   40: iaload
      //   41: i2f
      //   42: fstore_2
      //   43: aload_0
      //   44: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   47: invokestatic 44	com/facebook/react/uimanager/UIViewOperationQueue:access$000	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;
      //   50: aload_0
      //   51: getfield 27	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mReactTag	I
      //   54: aload_0
      //   55: getfield 29	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mTargetX	F
      //   58: aload_0
      //   59: getfield 31	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mTargetY	F
      //   62: invokevirtual 58	com/facebook/react/uimanager/NativeViewHierarchyManager:findTargetTagForTouch	(IFF)I
      //   65: istore 5
      //   67: aload_0
      //   68: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   71: invokestatic 44	com/facebook/react/uimanager/UIViewOperationQueue:access$000	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;
      //   74: iload 5
      //   76: aload_0
      //   77: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   80: invokestatic 48	com/facebook/react/uimanager/UIViewOperationQueue:access$200	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   83: invokevirtual 54	com/facebook/react/uimanager/NativeViewHierarchyManager:measure	(I[I)V
      //   86: aload_0
      //   87: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   90: invokestatic 48	com/facebook/react/uimanager/UIViewOperationQueue:access$200	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   93: iconst_0
      //   94: iaload
      //   95: i2f
      //   96: fload_1
      //   97: fsub
      //   98: invokestatic 64	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   101: fstore_1
      //   102: aload_0
      //   103: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   106: invokestatic 48	com/facebook/react/uimanager/UIViewOperationQueue:access$200	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   109: iconst_1
      //   110: iaload
      //   111: i2f
      //   112: fload_2
      //   113: fsub
      //   114: invokestatic 64	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   117: fstore_2
      //   118: aload_0
      //   119: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   122: invokestatic 48	com/facebook/react/uimanager/UIViewOperationQueue:access$200	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   125: iconst_2
      //   126: iaload
      //   127: i2f
      //   128: invokestatic 64	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   131: fstore_3
      //   132: aload_0
      //   133: getfield 22	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/uimanager/UIViewOperationQueue;
      //   136: invokestatic 48	com/facebook/react/uimanager/UIViewOperationQueue:access$200	(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I
      //   139: iconst_3
      //   140: iaload
      //   141: i2f
      //   142: invokestatic 64	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   145: fstore 4
      //   147: aload_0
      //   148: getfield 33	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mCallback	Lcom/facebook/react/bridge/Callback;
      //   151: iconst_5
      //   152: anewarray 4	java/lang/Object
      //   155: dup
      //   156: iconst_0
      //   157: iload 5
      //   159: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   162: aastore
      //   163: dup
      //   164: iconst_1
      //   165: fload_1
      //   166: invokestatic 75	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   169: aastore
      //   170: dup
      //   171: iconst_2
      //   172: fload_2
      //   173: invokestatic 75	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   176: aastore
      //   177: dup
      //   178: iconst_3
      //   179: fload_3
      //   180: invokestatic 75	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   183: aastore
      //   184: dup
      //   185: iconst_4
      //   186: fload 4
      //   188: invokestatic 75	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   191: aastore
      //   192: invokeinterface 81 2 0
      //   197: return
      //   198: astore 6
      //   200: aload_0
      //   201: getfield 33	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mCallback	Lcom/facebook/react/bridge/Callback;
      //   204: iconst_0
      //   205: anewarray 4	java/lang/Object
      //   208: invokeinterface 81 2 0
      //   213: return
      //   214: astore 6
      //   216: aload_0
      //   217: getfield 33	com/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation:mCallback	Lcom/facebook/react/bridge/Callback;
      //   220: iconst_0
      //   221: anewarray 4	java/lang/Object
      //   224: invokeinterface 81 2 0
      //   229: return
      //
      // Exception table:
      //   from	to	target	type
      //   0	21	198	com/facebook/react/uimanager/IllegalViewOperationException
      //   67	86	214	com/facebook/react/uimanager/IllegalViewOperationException
    }
  }

  private final class ManageChildrenOperation extends UIViewOperationQueue.ViewOperation
  {

    @Nullable
    private final int[] mIndicesToRemove;

    @Nullable
    private final int[] mTagsToDelete;

    @Nullable
    private final ViewAtIndex[] mViewsToAdd;

    public ManageChildrenOperation(@Nullable int paramArrayOfInt1, @Nullable int[] paramArrayOfViewAtIndex, @Nullable ViewAtIndex[] paramArrayOfInt2, int[] arg5)
    {
      super(paramArrayOfInt1);
      this.mIndicesToRemove = paramArrayOfViewAtIndex;
      this.mViewsToAdd = paramArrayOfInt2;
      Object localObject;
      this.mTagsToDelete = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.manageChildren(this.mTag, this.mIndicesToRemove, this.mViewsToAdd, this.mTagsToDelete);
    }
  }

  private final class MeasureInWindowOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final Callback mCallback;
    private final int mReactTag;

    private MeasureInWindowOperation(int paramCallback, Callback arg3)
    {
      this.mReactTag = paramCallback;
      Object localObject;
      this.mCallback = localObject;
    }

    public void execute()
    {
      try
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.measureInWindow(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
        float f1 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[0]);
        float f2 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[1]);
        float f3 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[2]);
        float f4 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[3]);
        this.mCallback.invoke(new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
        return;
      }
      catch (NoSuchNativeViewException localNoSuchNativeViewException)
      {
        this.mCallback.invoke(new Object[0]);
      }
    }
  }

  private final class MeasureOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final Callback mCallback;
    private final int mReactTag;

    private MeasureOperation(int paramCallback, Callback arg3)
    {
      this.mReactTag = paramCallback;
      Object localObject;
      this.mCallback = localObject;
    }

    public void execute()
    {
      try
      {
        UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
        float f1 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[0]);
        float f2 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[1]);
        float f3 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[2]);
        float f4 = PixelUtil.toDIPFromPixel(UIViewOperationQueue.this.mMeasureBuffer[3]);
        this.mCallback.invoke(new Object[] { Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
        return;
      }
      catch (NoSuchNativeViewException localNoSuchNativeViewException)
      {
        this.mCallback.invoke(new Object[0]);
      }
    }
  }

  private class RegisterAnimationOperation extends UIViewOperationQueue.AnimationOperation
  {
    private final Animation mAnimation;

    private RegisterAnimationOperation(Animation arg2)
    {
      super();
      this.mAnimation = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mAnimationRegistry.registerAnimation(this.mAnimation);
    }
  }

  private final class RemoveAnimationOperation extends UIViewOperationQueue.AnimationOperation
  {
    private RemoveAnimationOperation(int arg2)
    {
      super();
    }

    public void execute()
    {
      Animation localAnimation = UIViewOperationQueue.this.mAnimationRegistry.getAnimation(this.mAnimationID);
      if (localAnimation != null)
        localAnimation.cancel();
    }
  }

  private final class RemoveRootViewOperation extends UIViewOperationQueue.ViewOperation
  {
    public RemoveRootViewOperation(int arg2)
    {
      super(i);
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.removeRootView(this.mTag);
    }
  }

  private final class SendAccessibilityEvent extends UIViewOperationQueue.ViewOperation
  {
    private final int mEventType;

    private SendAccessibilityEvent(int paramInt1, int arg3)
    {
      super(paramInt1);
      int i;
      this.mEventType = i;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.sendAccessibilityEvent(this.mTag, this.mEventType);
    }
  }

  private final class SetChildrenOperation extends UIViewOperationQueue.ViewOperation
  {
    private final ReadableArray mChildrenTags;

    public SetChildrenOperation(int paramReadableArray, ReadableArray arg3)
    {
      super(paramReadableArray);
      Object localObject;
      this.mChildrenTags = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.setChildren(this.mTag, this.mChildrenTags);
    }
  }

  private class SetLayoutAnimationEnabledOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final boolean mEnabled;

    private SetLayoutAnimationEnabledOperation(boolean arg2)
    {
      boolean bool;
      this.mEnabled = bool;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.setLayoutAnimationEnabled(this.mEnabled);
    }
  }

  private final class ShowPopupMenuOperation extends UIViewOperationQueue.ViewOperation
  {
    private final ReadableArray mItems;
    private final Callback mSuccess;

    public ShowPopupMenuOperation(int paramReadableArray, ReadableArray paramCallback, Callback arg4)
    {
      super(paramReadableArray);
      this.mItems = paramCallback;
      Object localObject;
      this.mSuccess = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.showPopupMenu(this.mTag, this.mItems, this.mSuccess);
    }
  }

  private class UIBlockOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final UIBlock mBlock;

    public UIBlockOperation(UIBlock arg2)
    {
      Object localObject;
      this.mBlock = localObject;
    }

    public void execute()
    {
      this.mBlock.execute(UIViewOperationQueue.this.mNativeViewHierarchyManager);
    }
  }

  public static abstract interface UIOperation
  {
    public abstract void execute();
  }

  private final class UpdateLayoutOperation extends UIViewOperationQueue.ViewOperation
  {
    private final int mHeight;
    private final int mParentTag;
    private final int mWidth;
    private final int mX;
    private final int mY;

    public UpdateLayoutOperation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int arg7)
    {
      super(paramInt2);
      this.mParentTag = paramInt1;
      this.mX = paramInt3;
      this.mY = paramInt4;
      this.mWidth = paramInt5;
      int i;
      this.mHeight = i;
      Systrace.startAsyncFlow(0L, "updateLayout", this.mTag);
    }

    public void execute()
    {
      Systrace.endAsyncFlow(0L, "updateLayout", this.mTag);
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateLayout(this.mParentTag, this.mTag, this.mX, this.mY, this.mWidth, this.mHeight);
    }
  }

  private final class UpdatePropertiesOperation extends UIViewOperationQueue.ViewOperation
  {
    private final ReactStylesDiffMap mProps;

    private UpdatePropertiesOperation(int paramReactStylesDiffMap, ReactStylesDiffMap arg3)
    {
      super(paramReactStylesDiffMap);
      Object localObject;
      this.mProps = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateProperties(this.mTag, this.mProps);
    }
  }

  private final class UpdateViewExtraData extends UIViewOperationQueue.ViewOperation
  {
    private final Object mExtraData;

    public UpdateViewExtraData(int paramObject, Object arg3)
    {
      super(paramObject);
      Object localObject;
      this.mExtraData = localObject;
    }

    public void execute()
    {
      UIViewOperationQueue.this.mNativeViewHierarchyManager.updateViewExtraData(this.mTag, this.mExtraData);
    }
  }

  private abstract class ViewOperation
    implements UIViewOperationQueue.UIOperation
  {
    public int mTag;

    public ViewOperation(int arg2)
    {
      int i;
      this.mTag = i;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIViewOperationQueue
 * JD-Core Version:    0.6.0
 */