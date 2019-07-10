package com.facebook.react.flat;

import android.util.SparseIntArray;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.NoSuchNativeViewException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.UIViewOperationQueue.UIOperation;
import java.util.ArrayList;
import javax.annotation.Nullable;

final class FlatUIViewOperationQueue extends UIViewOperationQueue
{
  private static final int[] MEASURE_BUFFER = new int[4];
  private final FlatNativeViewHierarchyManager mNativeViewHierarchyManager;
  private final ProcessLayoutRequests mProcessLayoutRequests = new ProcessLayoutRequests(null);

  public FlatUIViewOperationQueue(ReactApplicationContext paramReactApplicationContext, FlatNativeViewHierarchyManager paramFlatNativeViewHierarchyManager, int paramInt)
  {
    super(paramReactApplicationContext, paramFlatNativeViewHierarchyManager, paramInt);
    this.mNativeViewHierarchyManager = paramFlatNativeViewHierarchyManager;
  }

  public UpdateViewBounds createUpdateViewBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return new UpdateViewBounds(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null);
  }

  public ViewManagerCommand createViewManagerCommand(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray)
  {
    return new ViewManagerCommand(paramInt1, paramInt2, paramReadableArray);
  }

  public DetachAllChildrenFromViews enqueueDetachAllChildrenFromViews()
  {
    DetachAllChildrenFromViews localDetachAllChildrenFromViews = new DetachAllChildrenFromViews();
    enqueueUIOperation(localDetachAllChildrenFromViews);
    return localDetachAllChildrenFromViews;
  }

  public void enqueueDropViews(ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    enqueueUIOperation(new DropViews(paramArrayList1, paramArrayList2, null));
  }

  public void enqueueFindTargetForTouch(int paramInt, float paramFloat1, float paramFloat2, Callback paramCallback)
  {
    enqueueUIOperation(new FindTargetForTouchOperation(paramInt, paramFloat1, paramFloat2, paramCallback, null));
  }

  void enqueueFlatUIOperation(UIViewOperationQueue.UIOperation paramUIOperation)
  {
    enqueueUIOperation(paramUIOperation);
  }

  public void enqueueMeasureVirtualView(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, Callback paramCallback)
  {
    enqueueUIOperation(new MeasureVirtualView(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean, paramCallback, null));
  }

  public void enqueueProcessLayoutRequests()
  {
    enqueueUIOperation(this.mProcessLayoutRequests);
  }

  public void enqueueSetPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    enqueueUIOperation(new SetPadding(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null));
  }

  public void enqueueUpdateClippingMountState(int paramInt, @Nullable DrawCommand[] paramArrayOfDrawCommand, SparseIntArray paramSparseIntArray, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, @Nullable AttachDetachListener[] paramArrayOfAttachDetachListener, @Nullable NodeRegion[] paramArrayOfNodeRegion, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, boolean paramBoolean)
  {
    enqueueUIOperation(new UpdateClippingMountState(paramInt, paramArrayOfDrawCommand, paramSparseIntArray, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfAttachDetachListener, paramArrayOfNodeRegion, paramArrayOfFloat3, paramArrayOfFloat4, paramBoolean, null));
  }

  public void enqueueUpdateMountState(int paramInt, @Nullable DrawCommand[] paramArrayOfDrawCommand, @Nullable AttachDetachListener[] paramArrayOfAttachDetachListener, @Nullable NodeRegion[] paramArrayOfNodeRegion)
  {
    enqueueUIOperation(new UpdateMountState(paramInt, paramArrayOfDrawCommand, paramArrayOfAttachDetachListener, paramArrayOfNodeRegion, null));
  }

  public void enqueueUpdateViewGroup(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    enqueueUIOperation(new UpdateViewGroup(paramInt, paramArrayOfInt1, paramArrayOfInt2, null));
  }

  public final class DetachAllChildrenFromViews
    implements UIViewOperationQueue.UIOperation
  {

    @Nullable
    private int[] mViewsToDetachAllChildrenFrom;

    public DetachAllChildrenFromViews()
    {
    }

    public void execute()
    {
      FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.detachAllChildrenFromViews(this.mViewsToDetachAllChildrenFrom);
    }

    public void setViewsToDetachAllChildrenFrom(int[] paramArrayOfInt)
    {
      this.mViewsToDetachAllChildrenFrom = paramArrayOfInt;
    }
  }

  private final class DropViews
    implements UIViewOperationQueue.UIOperation
  {
    private final SparseIntArray mViewsToDrop;

    private DropViews(ArrayList<Integer> arg2)
    {
      this$1 = new SparseIntArray();
      int i = 0;
      Object localObject1;
      int j = localObject1.size();
      while (i < j)
      {
        Object localObject2;
        FlatUIViewOperationQueue.this.put(((Integer)localObject1.get(i)).intValue(), ((Integer)localObject2.get(i)).intValue());
        i += 1;
      }
      this.mViewsToDrop = FlatUIViewOperationQueue.this;
    }

    public void execute()
    {
      FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.dropViews(this.mViewsToDrop);
    }
  }

  private final class FindTargetForTouchOperation
    implements UIViewOperationQueue.UIOperation
  {
    private final int[] NATIVE_VIEW_BUFFER = new int[1];
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
      //   1: getfield 24	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/flat/FlatUIViewOperationQueue;
      //   4: invokestatic 48	com/facebook/react/flat/FlatUIViewOperationQueue:access$100	(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;
      //   7: aload_0
      //   8: getfield 31	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:mReactTag	I
      //   11: invokestatic 52	com/facebook/react/flat/FlatUIViewOperationQueue:access$200	()[I
      //   14: invokevirtual 58	com/facebook/react/flat/FlatNativeViewHierarchyManager:measure	(I[I)V
      //   17: invokestatic 52	com/facebook/react/flat/FlatUIViewOperationQueue:access$200	()[I
      //   20: iconst_0
      //   21: iaload
      //   22: i2f
      //   23: fstore_2
      //   24: invokestatic 52	com/facebook/react/flat/FlatUIViewOperationQueue:access$200	()[I
      //   27: iconst_1
      //   28: iaload
      //   29: i2f
      //   30: fstore_1
      //   31: aload_0
      //   32: getfield 24	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/flat/FlatUIViewOperationQueue;
      //   35: invokestatic 48	com/facebook/react/flat/FlatUIViewOperationQueue:access$100	(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;
      //   38: aload_0
      //   39: getfield 31	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:mReactTag	I
      //   42: invokevirtual 62	com/facebook/react/flat/FlatNativeViewHierarchyManager:getView	(I)Landroid/view/View;
      //   45: astore 7
      //   47: aload_0
      //   48: getfield 33	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:mTargetX	F
      //   51: aload_0
      //   52: getfield 35	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:mTargetY	F
      //   55: aload 7
      //   57: checkcast 64	android/view/ViewGroup
      //   60: aload_0
      //   61: getfield 29	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:NATIVE_VIEW_BUFFER	[I
      //   64: invokestatic 70	com/facebook/react/uimanager/TouchTargetHelper:findTargetTagForTouch	(FFLandroid/view/ViewGroup;[I)I
      //   67: istore 6
      //   69: aload_0
      //   70: getfield 24	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/flat/FlatUIViewOperationQueue;
      //   73: invokestatic 48	com/facebook/react/flat/FlatUIViewOperationQueue:access$100	(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;
      //   76: aload_0
      //   77: getfield 29	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:NATIVE_VIEW_BUFFER	[I
      //   80: iconst_0
      //   81: iaload
      //   82: invokestatic 52	com/facebook/react/flat/FlatUIViewOperationQueue:access$200	()[I
      //   85: invokevirtual 58	com/facebook/react/flat/FlatNativeViewHierarchyManager:measure	(I[I)V
      //   88: getstatic 76	com/facebook/react/flat/NodeRegion:EMPTY	Lcom/facebook/react/flat/NodeRegion;
      //   91: astore 8
      //   93: aload_0
      //   94: getfield 29	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:NATIVE_VIEW_BUFFER	[I
      //   97: iconst_0
      //   98: iaload
      //   99: iload 6
      //   101: if_icmpne +221 -> 322
      //   104: iconst_1
      //   105: istore 5
      //   107: aload 8
      //   109: astore 7
      //   111: iload 5
      //   113: ifne +47 -> 160
      //   116: aload_0
      //   117: getfield 24	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:this$0	Lcom/facebook/react/flat/FlatUIViewOperationQueue;
      //   120: invokestatic 48	com/facebook/react/flat/FlatUIViewOperationQueue:access$100	(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;
      //   123: aload_0
      //   124: getfield 29	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:NATIVE_VIEW_BUFFER	[I
      //   127: iconst_0
      //   128: iaload
      //   129: invokevirtual 62	com/facebook/react/flat/FlatNativeViewHierarchyManager:getView	(I)Landroid/view/View;
      //   132: astore 9
      //   134: aload 8
      //   136: astore 7
      //   138: aload 9
      //   140: instanceof 78
      //   143: ifeq +17 -> 160
      //   146: aload 9
      //   148: checkcast 78	com/facebook/react/flat/FlatViewGroup
      //   151: aload_0
      //   152: getfield 31	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:mReactTag	I
      //   155: invokevirtual 82	com/facebook/react/flat/FlatViewGroup:getNodeRegionForTag	(I)Lcom/facebook/react/flat/NodeRegion;
      //   158: astore 7
      //   160: aload 7
      //   162: getstatic 76	com/facebook/react/flat/NodeRegion:EMPTY	Lcom/facebook/react/flat/NodeRegion;
      //   165: if_acmpne +163 -> 328
      //   168: aload 7
      //   170: invokevirtual 86	com/facebook/react/flat/NodeRegion:getLeft	()F
      //   173: invokestatic 52	com/facebook/react/flat/FlatUIViewOperationQueue:access$200	()[I
      //   176: iconst_0
      //   177: iaload
      //   178: i2f
      //   179: fadd
      //   180: fload_2
      //   181: fsub
      //   182: invokestatic 92	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   185: fstore_2
      //   186: aload 7
      //   188: invokevirtual 95	com/facebook/react/flat/NodeRegion:getTop	()F
      //   191: invokestatic 52	com/facebook/react/flat/FlatUIViewOperationQueue:access$200	()[I
      //   194: iconst_1
      //   195: iaload
      //   196: i2f
      //   197: fadd
      //   198: fload_1
      //   199: fsub
      //   200: invokestatic 92	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   203: fstore_3
      //   204: iload 5
      //   206: ifeq +132 -> 338
      //   209: invokestatic 52	com/facebook/react/flat/FlatUIViewOperationQueue:access$200	()[I
      //   212: iconst_2
      //   213: iaload
      //   214: i2f
      //   215: fstore_1
      //   216: fload_1
      //   217: invokestatic 92	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   220: fstore 4
      //   222: iload 5
      //   224: ifeq +129 -> 353
      //   227: invokestatic 52	com/facebook/react/flat/FlatUIViewOperationQueue:access$200	()[I
      //   230: iconst_3
      //   231: iaload
      //   232: i2f
      //   233: fstore_1
      //   234: fload_1
      //   235: invokestatic 92	com/facebook/react/uimanager/PixelUtil:toDIPFromPixel	(F)F
      //   238: fstore_1
      //   239: aload_0
      //   240: getfield 37	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:mCallback	Lcom/facebook/react/bridge/Callback;
      //   243: iconst_5
      //   244: anewarray 4	java/lang/Object
      //   247: dup
      //   248: iconst_0
      //   249: iload 6
      //   251: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   254: aastore
      //   255: dup
      //   256: iconst_1
      //   257: fload_2
      //   258: invokestatic 106	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   261: aastore
      //   262: dup
      //   263: iconst_2
      //   264: fload_3
      //   265: invokestatic 106	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   268: aastore
      //   269: dup
      //   270: iconst_3
      //   271: fload 4
      //   273: invokestatic 106	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   276: aastore
      //   277: dup
      //   278: iconst_4
      //   279: fload_1
      //   280: invokestatic 106	java/lang/Float:valueOf	(F)Ljava/lang/Float;
      //   283: aastore
      //   284: invokeinterface 112 2 0
      //   289: return
      //   290: astore 7
      //   292: aload_0
      //   293: getfield 37	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:mCallback	Lcom/facebook/react/bridge/Callback;
      //   296: iconst_0
      //   297: anewarray 4	java/lang/Object
      //   300: invokeinterface 112 2 0
      //   305: return
      //   306: astore 7
      //   308: aload_0
      //   309: getfield 37	com/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation:mCallback	Lcom/facebook/react/bridge/Callback;
      //   312: iconst_0
      //   313: anewarray 4	java/lang/Object
      //   316: invokeinterface 112 2 0
      //   321: return
      //   322: iconst_0
      //   323: istore 5
      //   325: goto -218 -> 107
      //   328: aload 7
      //   330: getfield 115	com/facebook/react/flat/NodeRegion:mTag	I
      //   333: istore 6
      //   335: goto -167 -> 168
      //   338: aload 7
      //   340: invokevirtual 118	com/facebook/react/flat/NodeRegion:getRight	()F
      //   343: aload 7
      //   345: invokevirtual 86	com/facebook/react/flat/NodeRegion:getLeft	()F
      //   348: fsub
      //   349: fstore_1
      //   350: goto -134 -> 216
      //   353: aload 7
      //   355: invokevirtual 121	com/facebook/react/flat/NodeRegion:getBottom	()F
      //   358: aload 7
      //   360: invokevirtual 95	com/facebook/react/flat/NodeRegion:getTop	()F
      //   363: fsub
      //   364: fstore_1
      //   365: goto -131 -> 234
      //
      // Exception table:
      //   from	to	target	type
      //   0	17	290	com/facebook/react/uimanager/IllegalViewOperationException
      //   69	88	306	com/facebook/react/uimanager/IllegalViewOperationException
    }
  }

  private final class MeasureVirtualView
    implements UIViewOperationQueue.UIOperation
  {
    private final Callback mCallback;
    private final int mReactTag;
    private final boolean mRelativeToWindow;
    private final float mScaledHeight;
    private final float mScaledWidth;
    private final float mScaledX;
    private final float mScaledY;

    private MeasureVirtualView(int paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramBoolean, boolean paramCallback, Callback arg8)
    {
      this.mReactTag = paramFloat1;
      this.mScaledX = paramFloat2;
      this.mScaledY = paramFloat3;
      this.mScaledWidth = paramFloat4;
      this.mScaledHeight = paramBoolean;
      Object localObject;
      this.mCallback = localObject;
      this.mRelativeToWindow = paramCallback;
    }

    public void execute()
    {
      float f2;
      float f4;
      float f3;
      float f1;
      try
      {
        if (this.mRelativeToWindow)
          FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.measureInWindow(this.mReactTag, FlatUIViewOperationQueue.MEASURE_BUFFER);
        while (true)
        {
          f2 = FlatUIViewOperationQueue.MEASURE_BUFFER[0];
          f4 = FlatUIViewOperationQueue.MEASURE_BUFFER[1];
          f3 = FlatUIViewOperationQueue.MEASURE_BUFFER[2];
          f1 = FlatUIViewOperationQueue.MEASURE_BUFFER[3];
          f2 = PixelUtil.toDIPFromPixel(this.mScaledX * f3 + f2);
          f4 = PixelUtil.toDIPFromPixel(this.mScaledY * f1 + f4);
          f3 = PixelUtil.toDIPFromPixel(this.mScaledWidth * f3);
          f1 = PixelUtil.toDIPFromPixel(this.mScaledHeight * f1);
          if (!this.mRelativeToWindow)
            break;
          this.mCallback.invoke(new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
          return;
          FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, FlatUIViewOperationQueue.MEASURE_BUFFER);
        }
      }
      catch (NoSuchNativeViewException localNoSuchNativeViewException)
      {
        this.mCallback.invoke(new Object[0]);
        return;
      }
      this.mCallback.invoke(new Object[] { Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(f3), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f4) });
    }
  }

  private final class ProcessLayoutRequests
    implements UIViewOperationQueue.UIOperation
  {
    private ProcessLayoutRequests()
    {
    }

    public void execute()
    {
      FlatViewGroup.processLayoutRequests();
    }
  }

  private final class SetPadding
    implements UIViewOperationQueue.UIOperation
  {
    private final int mPaddingBottom;
    private final int mPaddingLeft;
    private final int mPaddingRight;
    private final int mPaddingTop;
    private final int mReactTag;

    private SetPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int arg6)
    {
      this.mReactTag = paramInt1;
      this.mPaddingLeft = paramInt2;
      this.mPaddingTop = paramInt3;
      this.mPaddingRight = paramInt4;
      int i;
      this.mPaddingBottom = i;
    }

    public void execute()
    {
      FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.setPadding(this.mReactTag, this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    }
  }

  private final class UpdateClippingMountState
    implements UIViewOperationQueue.UIOperation
  {

    @Nullable
    private final AttachDetachListener[] mAttachDetachListeners;
    private final float[] mCommandMaxBot;
    private final float[] mCommandMinTop;

    @Nullable
    private final DrawCommand[] mDrawCommands;
    private final SparseIntArray mDrawViewIndexMap;

    @Nullable
    private final NodeRegion[] mNodeRegions;
    private final int mReactTag;
    private final float[] mRegionMaxBot;
    private final float[] mRegionMinTop;
    private final boolean mWillMountViews;

    private UpdateClippingMountState(@Nullable int paramArrayOfDrawCommand, DrawCommand[] paramSparseIntArray, SparseIntArray paramArrayOfFloat1, float[] paramArrayOfFloat2, @Nullable float[] paramArrayOfAttachDetachListener, @Nullable AttachDetachListener[] paramArrayOfNodeRegion, NodeRegion[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramBoolean, boolean arg11)
    {
      this.mReactTag = paramArrayOfDrawCommand;
      this.mDrawCommands = paramSparseIntArray;
      this.mDrawViewIndexMap = paramArrayOfFloat1;
      this.mCommandMaxBot = paramArrayOfFloat2;
      this.mCommandMinTop = paramArrayOfAttachDetachListener;
      this.mAttachDetachListeners = paramArrayOfNodeRegion;
      this.mNodeRegions = paramArrayOfFloat3;
      this.mRegionMaxBot = paramArrayOfFloat4;
      this.mRegionMinTop = paramBoolean;
      boolean bool;
      this.mWillMountViews = bool;
    }

    public void execute()
    {
      FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.updateClippingMountState(this.mReactTag, this.mDrawCommands, this.mDrawViewIndexMap, this.mCommandMaxBot, this.mCommandMinTop, this.mAttachDetachListeners, this.mNodeRegions, this.mRegionMaxBot, this.mRegionMinTop, this.mWillMountViews);
    }
  }

  private final class UpdateMountState
    implements UIViewOperationQueue.UIOperation
  {

    @Nullable
    private final AttachDetachListener[] mAttachDetachListeners;

    @Nullable
    private final DrawCommand[] mDrawCommands;

    @Nullable
    private final NodeRegion[] mNodeRegions;
    private final int mReactTag;

    private UpdateMountState(@Nullable int paramArrayOfDrawCommand, @Nullable DrawCommand[] paramArrayOfAttachDetachListener, @Nullable AttachDetachListener[] paramArrayOfNodeRegion, NodeRegion[] arg5)
    {
      this.mReactTag = paramArrayOfDrawCommand;
      this.mDrawCommands = paramArrayOfAttachDetachListener;
      this.mAttachDetachListeners = paramArrayOfNodeRegion;
      Object localObject;
      this.mNodeRegions = localObject;
    }

    public void execute()
    {
      FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.updateMountState(this.mReactTag, this.mDrawCommands, this.mAttachDetachListeners, this.mNodeRegions);
    }
  }

  public final class UpdateViewBounds
    implements UIViewOperationQueue.UIOperation
  {
    private final int mBottom;
    private final int mLeft;
    private final int mReactTag;
    private final int mRight;
    private final int mTop;

    private UpdateViewBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int arg6)
    {
      this.mReactTag = paramInt1;
      this.mLeft = paramInt2;
      this.mTop = paramInt3;
      this.mRight = paramInt4;
      int i;
      this.mBottom = i;
    }

    public void execute()
    {
      FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.updateViewBounds(this.mReactTag, this.mLeft, this.mTop, this.mRight, this.mBottom);
    }
  }

  private final class UpdateViewGroup
    implements UIViewOperationQueue.UIOperation
  {
    private final int mReactTag;
    private final int[] mViewsToAdd;
    private final int[] mViewsToDetach;

    private UpdateViewGroup(int paramArrayOfInt1, int[] paramArrayOfInt2, int[] arg4)
    {
      this.mReactTag = paramArrayOfInt1;
      this.mViewsToAdd = paramArrayOfInt2;
      Object localObject;
      this.mViewsToDetach = localObject;
    }

    public void execute()
    {
      FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.updateViewGroup(this.mReactTag, this.mViewsToAdd, this.mViewsToDetach);
    }
  }

  public final class ViewManagerCommand
    implements UIViewOperationQueue.UIOperation
  {

    @Nullable
    private final ReadableArray mArgs;
    private final int mCommand;
    private final int mReactTag;

    public ViewManagerCommand(int paramInt1, @Nullable int paramReadableArray, ReadableArray arg4)
    {
      this.mReactTag = paramInt1;
      this.mCommand = paramReadableArray;
      Object localObject;
      this.mArgs = localObject;
    }

    public void execute()
    {
      FlatUIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mReactTag, this.mCommand, this.mArgs);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatUIViewOperationQueue
 * JD-Core Version:    0.6.0
 */