package android.support.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class VectorDrawableCompat extends VectorDrawableCommon
{
  private static final boolean DBG_VECTOR_DRAWABLE = false;
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  private static final int LINECAP_BUTT = 0;
  private static final int LINECAP_ROUND = 1;
  private static final int LINECAP_SQUARE = 2;
  private static final int LINEJOIN_BEVEL = 2;
  private static final int LINEJOIN_MITER = 0;
  private static final int LINEJOIN_ROUND = 1;
  static final String LOGTAG = "VectorDrawableCompat";
  private static final int MAX_CACHED_BITMAP_SIZE = 2048;
  private static final String SHAPE_CLIP_PATH = "clip-path";
  private static final String SHAPE_GROUP = "group";
  private static final String SHAPE_PATH = "path";
  private static final String SHAPE_VECTOR = "vector";
  private boolean mAllowCaching = true;
  private Drawable.ConstantState mCachedConstantStateDelegate;
  private ColorFilter mColorFilter;
  private boolean mMutated;
  private PorterDuffColorFilter mTintFilter;
  private final Rect mTmpBounds = new Rect();
  private final float[] mTmpFloats = new float[9];
  private final Matrix mTmpMatrix = new Matrix();
  private VectorDrawableCompatState mVectorState;

  private VectorDrawableCompat()
  {
    this.mVectorState = new VectorDrawableCompatState();
  }

  private VectorDrawableCompat(@NonNull VectorDrawableCompatState paramVectorDrawableCompatState)
  {
    this.mVectorState = paramVectorDrawableCompatState;
    this.mTintFilter = updateTintFilter(this.mTintFilter, paramVectorDrawableCompatState.mTint, paramVectorDrawableCompatState.mTintMode);
  }

  private static int applyAlpha(int paramInt, float paramFloat)
  {
    return paramInt & 0xFFFFFF | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }

  @Nullable
  public static VectorDrawableCompat create(@NonNull Resources paramResources, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = new VectorDrawableCompat();
      ((VectorDrawableCompat)localObject).mDelegateDrawable = ResourcesCompat.getDrawable(paramResources, paramInt, paramTheme);
      ((VectorDrawableCompat)localObject).mCachedConstantStateDelegate = new VectorDrawableDelegateState(((VectorDrawableCompat)localObject).mDelegateDrawable.getConstantState());
      return localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
        paramInt = ((XmlPullParser)localObject).next();
      while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2)
        throw new XmlPullParserException("No start tag found");
    }
    catch (XmlPullParserException paramResources)
    {
      AttributeSet localAttributeSet;
      Log.e("VectorDrawableCompat", "parser error", paramResources);
      return null;
      paramResources = createFromXmlInner(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      while (true)
        Log.e("VectorDrawableCompat", "parser error", paramResources);
    }
  }

  public static VectorDrawableCompat createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
    localVectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localVectorDrawableCompat;
  }

  private void inflateInternal(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    VectorDrawableCompatState localVectorDrawableCompatState = this.mVectorState;
    VPathRenderer localVPathRenderer = localVectorDrawableCompatState.mVPathRenderer;
    int i = 1;
    Stack localStack = new Stack();
    localStack.push(localVPathRenderer.mRootGroup);
    int k = paramXmlPullParser.getEventType();
    if (k != 1)
    {
      Object localObject;
      VGroup localVGroup;
      int j;
      if (k == 2)
      {
        localObject = paramXmlPullParser.getName();
        localVGroup = (VGroup)localStack.peek();
        if ("path".equals(localObject))
        {
          localObject = new VFullPath();
          ((VFullPath)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localVGroup.mChildren.add(localObject);
          if (((VFullPath)localObject).getPathName() != null)
            localVPathRenderer.mVGTargetsMap.put(((VFullPath)localObject).getPathName(), localObject);
          j = 0;
          localVectorDrawableCompatState.mChangingConfigurations |= ((VFullPath)localObject).mChangingConfigurations;
        }
      }
      while (true)
      {
        k = paramXmlPullParser.next();
        i = j;
        break;
        if ("clip-path".equals(localObject))
        {
          localObject = new VClipPath();
          ((VClipPath)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localVGroup.mChildren.add(localObject);
          if (((VClipPath)localObject).getPathName() != null)
            localVPathRenderer.mVGTargetsMap.put(((VClipPath)localObject).getPathName(), localObject);
          localVectorDrawableCompatState.mChangingConfigurations |= ((VClipPath)localObject).mChangingConfigurations;
          j = i;
          continue;
        }
        j = i;
        if (!"group".equals(localObject))
          continue;
        localObject = new VGroup();
        ((VGroup)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
        localVGroup.mChildren.add(localObject);
        localStack.push(localObject);
        if (((VGroup)localObject).getGroupName() != null)
          localVPathRenderer.mVGTargetsMap.put(((VGroup)localObject).getGroupName(), localObject);
        localVectorDrawableCompatState.mChangingConfigurations |= ((VGroup)localObject).mChangingConfigurations;
        j = i;
        continue;
        j = i;
        if (k != 3)
          continue;
        j = i;
        if (!"group".equals(paramXmlPullParser.getName()))
          continue;
        localStack.pop();
        j = i;
      }
    }
    if (i != 0)
    {
      paramResources = new StringBuffer();
      if (paramResources.length() > 0)
        paramResources.append(" or ");
      paramResources.append("path");
      throw new XmlPullParserException("no " + paramResources + " defined");
    }
  }

  private boolean needMirroring()
  {
    return false;
  }

  private static PorterDuff.Mode parseTintModeCompat(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4:
    case 6:
    case 7:
    case 8:
    case 10:
    case 11:
    case 12:
    case 13:
    default:
      return paramMode;
    case 3:
      return PorterDuff.Mode.SRC_OVER;
    case 5:
      return PorterDuff.Mode.SRC_IN;
    case 9:
      return PorterDuff.Mode.SRC_ATOP;
    case 14:
      return PorterDuff.Mode.MULTIPLY;
    case 15:
      return PorterDuff.Mode.SCREEN;
    case 16:
    }
    return PorterDuff.Mode.ADD;
  }

  private void printGroupTree(VGroup paramVGroup, int paramInt)
  {
    Object localObject = "";
    int i = 0;
    while (i < paramInt)
    {
      localObject = (String)localObject + "    ";
      i += 1;
    }
    Log.v("VectorDrawableCompat", (String)localObject + "current group is :" + paramVGroup.getGroupName() + " rotation is " + paramVGroup.mRotate);
    Log.v("VectorDrawableCompat", (String)localObject + "matrix is :" + paramVGroup.getLocalMatrix().toString());
    i = 0;
    if (i < paramVGroup.mChildren.size())
    {
      localObject = paramVGroup.mChildren.get(i);
      if ((localObject instanceof VGroup))
        printGroupTree((VGroup)localObject, paramInt + 1);
      while (true)
      {
        i += 1;
        break;
        ((VPath)localObject).printVPath(paramInt + 1);
      }
    }
  }

  private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException
  {
    VectorDrawableCompatState localVectorDrawableCompatState = this.mVectorState;
    VPathRenderer localVPathRenderer = localVectorDrawableCompatState.mVPathRenderer;
    localVectorDrawableCompatState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    ColorStateList localColorStateList = paramTypedArray.getColorStateList(1);
    if (localColorStateList != null)
      localVectorDrawableCompatState.mTint = localColorStateList;
    localVectorDrawableCompatState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, localVectorDrawableCompatState.mAutoMirrored);
    localVPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, localVPathRenderer.mViewportWidth);
    localVPathRenderer.mViewportHeight = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, localVPathRenderer.mViewportHeight);
    if (localVPathRenderer.mViewportWidth <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    if (localVPathRenderer.mViewportHeight <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    localVPathRenderer.mBaseWidth = paramTypedArray.getDimension(3, localVPathRenderer.mBaseWidth);
    localVPathRenderer.mBaseHeight = paramTypedArray.getDimension(2, localVPathRenderer.mBaseHeight);
    if (localVPathRenderer.mBaseWidth <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    if (localVPathRenderer.mBaseHeight <= 0.0F)
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    localVPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "alpha", 4, localVPathRenderer.getAlpha()));
    paramTypedArray = paramTypedArray.getString(0);
    if (paramTypedArray != null)
    {
      localVPathRenderer.mRootName = paramTypedArray;
      localVPathRenderer.mVGTargetsMap.put(paramTypedArray, localVPathRenderer);
    }
  }

  public boolean canApplyTheme()
  {
    if (this.mDelegateDrawable != null)
      DrawableCompat.canApplyTheme(this.mDelegateDrawable);
    return false;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.mDelegateDrawable != null)
      this.mDelegateDrawable.draw(paramCanvas);
    Object localObject;
    int i;
    int j;
    int k;
    while (true)
    {
      return;
      copyBounds(this.mTmpBounds);
      if ((this.mTmpBounds.width() <= 0) || (this.mTmpBounds.height() <= 0))
        continue;
      if (this.mColorFilter != null)
        break;
      localObject = this.mTintFilter;
      paramCanvas.getMatrix(this.mTmpMatrix);
      this.mTmpMatrix.getValues(this.mTmpFloats);
      float f1 = Math.abs(this.mTmpFloats[0]);
      float f2 = Math.abs(this.mTmpFloats[4]);
      float f4 = Math.abs(this.mTmpFloats[1]);
      float f3 = Math.abs(this.mTmpFloats[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      i = (int)(this.mTmpBounds.width() * f1);
      j = (int)(this.mTmpBounds.height() * f2);
      i = Math.min(2048, i);
      j = Math.min(2048, j);
      if ((i <= 0) || (j <= 0))
        continue;
      k = paramCanvas.save();
      paramCanvas.translate(this.mTmpBounds.left, this.mTmpBounds.top);
      if (needMirroring())
      {
        paramCanvas.translate(this.mTmpBounds.width(), 0.0F);
        paramCanvas.scale(-1.0F, 1.0F);
      }
      this.mTmpBounds.offsetTo(0, 0);
      this.mVectorState.createCachedBitmapIfNeeded(i, j);
      if (this.mAllowCaching)
        break label314;
      this.mVectorState.updateCachedBitmap(i, j);
    }
    while (true)
    {
      this.mVectorState.drawCachedBitmapWithRootAlpha(paramCanvas, (ColorFilter)localObject, this.mTmpBounds);
      paramCanvas.restoreToCount(k);
      return;
      localObject = this.mColorFilter;
      break;
      label314: if (this.mVectorState.canReuseCache())
        continue;
      this.mVectorState.updateCachedBitmap(i, j);
      this.mVectorState.updateCacheStates();
    }
  }

  public int getAlpha()
  {
    if (this.mDelegateDrawable != null)
      return DrawableCompat.getAlpha(this.mDelegateDrawable);
    return this.mVectorState.mVPathRenderer.getRootAlpha();
  }

  public int getChangingConfigurations()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.getChangingConfigurations();
    return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
  }

  public Drawable.ConstantState getConstantState()
  {
    if (this.mDelegateDrawable != null)
      return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    this.mVectorState.mChangingConfigurations = getChangingConfigurations();
    return this.mVectorState;
  }

  public int getIntrinsicHeight()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.getIntrinsicHeight();
    return (int)this.mVectorState.mVPathRenderer.mBaseHeight;
  }

  public int getIntrinsicWidth()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.getIntrinsicWidth();
    return (int)this.mVectorState.mVPathRenderer.mBaseWidth;
  }

  public int getOpacity()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.getOpacity();
    return -3;
  }

  public float getPixelSize()
  {
    if (((this.mVectorState == null) && (this.mVectorState.mVPathRenderer == null)) || (this.mVectorState.mVPathRenderer.mBaseWidth == 0.0F) || (this.mVectorState.mVPathRenderer.mBaseHeight == 0.0F) || (this.mVectorState.mVPathRenderer.mViewportHeight == 0.0F) || (this.mVectorState.mVPathRenderer.mViewportWidth == 0.0F))
      return 1.0F;
    float f1 = this.mVectorState.mVPathRenderer.mBaseWidth;
    float f2 = this.mVectorState.mVPathRenderer.mBaseHeight;
    float f3 = this.mVectorState.mVPathRenderer.mViewportWidth;
    float f4 = this.mVectorState.mVPathRenderer.mViewportHeight;
    return Math.min(f3 / f1, f4 / f2);
  }

  Object getTargetByName(String paramString)
  {
    return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(paramString);
  }

  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }

  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.inflate(this.mDelegateDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    VectorDrawableCompatState localVectorDrawableCompatState = this.mVectorState;
    localVectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
    TypedArray localTypedArray = obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_VectorDrawableTypeArray);
    updateStateFromTypedArray(localTypedArray, paramXmlPullParser);
    localTypedArray.recycle();
    localVectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
    localVectorDrawableCompatState.mCacheDirty = true;
    inflateInternal(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.mTintFilter = updateTintFilter(this.mTintFilter, localVectorDrawableCompatState.mTint, localVectorDrawableCompatState.mTintMode);
  }

  public void invalidateSelf()
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }

  public boolean isStateful()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.isStateful();
    return (super.isStateful()) || ((this.mVectorState != null) && (this.mVectorState.mTint != null) && (this.mVectorState.mTint.isStateful()));
  }

  public Drawable mutate()
  {
    if (this.mDelegateDrawable != null)
      this.mDelegateDrawable.mutate();
    do
      return this;
    while ((this.mMutated) || (super.mutate() != this));
    this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
    this.mMutated = true;
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mDelegateDrawable != null)
      this.mDelegateDrawable.setBounds(paramRect);
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.setState(paramArrayOfInt);
    paramArrayOfInt = this.mVectorState;
    if ((paramArrayOfInt.mTint != null) && (paramArrayOfInt.mTintMode != null))
    {
      this.mTintFilter = updateTintFilter(this.mTintFilter, paramArrayOfInt.mTint, paramArrayOfInt.mTintMode);
      invalidateSelf();
      return true;
    }
    return false;
  }

  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }

  void setAllowCaching(boolean paramBoolean)
  {
    this.mAllowCaching = paramBoolean;
  }

  public void setAlpha(int paramInt)
  {
    if (this.mDelegateDrawable != null)
      this.mDelegateDrawable.setAlpha(paramInt);
    do
      return;
    while (this.mVectorState.mVPathRenderer.getRootAlpha() == paramInt);
    this.mVectorState.mVPathRenderer.setRootAlpha(paramInt);
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.mColorFilter = paramColorFilter;
    invalidateSelf();
  }

  public void setTint(int paramInt)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setTint(this.mDelegateDrawable, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }

  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.mDelegateDrawable != null)
      DrawableCompat.setTintList(this.mDelegateDrawable, paramColorStateList);
    VectorDrawableCompatState localVectorDrawableCompatState;
    do
    {
      return;
      localVectorDrawableCompatState = this.mVectorState;
    }
    while (localVectorDrawableCompatState.mTint == paramColorStateList);
    localVectorDrawableCompatState.mTint = paramColorStateList;
    this.mTintFilter = updateTintFilter(this.mTintFilter, paramColorStateList, localVectorDrawableCompatState.mTintMode);
    invalidateSelf();
  }

  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mDelegateDrawable != null)
      DrawableCompat.setTintMode(this.mDelegateDrawable, paramMode);
    VectorDrawableCompatState localVectorDrawableCompatState;
    do
    {
      return;
      localVectorDrawableCompatState = this.mVectorState;
    }
    while (localVectorDrawableCompatState.mTintMode == paramMode);
    localVectorDrawableCompatState.mTintMode = paramMode;
    this.mTintFilter = updateTintFilter(this.mTintFilter, localVectorDrawableCompatState.mTint, paramMode);
    invalidateSelf();
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }

  public void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }

  PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null))
      return null;
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }

  private static class VClipPath extends VectorDrawableCompat.VPath
  {
    public VClipPath()
    {
    }

    public VClipPath(VClipPath paramVClipPath)
    {
      super();
    }

    private void updateStateFromTypedArray(TypedArray paramTypedArray)
    {
      String str = paramTypedArray.getString(0);
      if (str != null)
        this.mPathName = str;
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null)
        this.mNodes = PathParser.createNodesFromPathData(paramTypedArray);
    }

    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData"))
        return;
      paramResources = VectorDrawableCommon.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_VectorDrawableClipPath);
      updateStateFromTypedArray(paramResources);
      paramResources.recycle();
    }

    public boolean isClipPath()
    {
      return true;
    }
  }

  private static class VFullPath extends VectorDrawableCompat.VPath
  {
    float mFillAlpha = 1.0F;
    int mFillColor = 0;
    int mFillRule;
    float mStrokeAlpha = 1.0F;
    int mStrokeColor = 0;
    Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
    Paint.Join mStrokeLineJoin = Paint.Join.MITER;
    float mStrokeMiterlimit = 4.0F;
    float mStrokeWidth = 0.0F;
    private int[] mThemeAttrs;
    float mTrimPathEnd = 1.0F;
    float mTrimPathOffset = 0.0F;
    float mTrimPathStart = 0.0F;

    public VFullPath()
    {
    }

    public VFullPath(VFullPath paramVFullPath)
    {
      super();
      this.mThemeAttrs = paramVFullPath.mThemeAttrs;
      this.mStrokeColor = paramVFullPath.mStrokeColor;
      this.mStrokeWidth = paramVFullPath.mStrokeWidth;
      this.mStrokeAlpha = paramVFullPath.mStrokeAlpha;
      this.mFillColor = paramVFullPath.mFillColor;
      this.mFillRule = paramVFullPath.mFillRule;
      this.mFillAlpha = paramVFullPath.mFillAlpha;
      this.mTrimPathStart = paramVFullPath.mTrimPathStart;
      this.mTrimPathEnd = paramVFullPath.mTrimPathEnd;
      this.mTrimPathOffset = paramVFullPath.mTrimPathOffset;
      this.mStrokeLineCap = paramVFullPath.mStrokeLineCap;
      this.mStrokeLineJoin = paramVFullPath.mStrokeLineJoin;
      this.mStrokeMiterlimit = paramVFullPath.mStrokeMiterlimit;
    }

    private Paint.Cap getStrokeLineCap(int paramInt, Paint.Cap paramCap)
    {
      switch (paramInt)
      {
      default:
        return paramCap;
      case 0:
        return Paint.Cap.BUTT;
      case 1:
        return Paint.Cap.ROUND;
      case 2:
      }
      return Paint.Cap.SQUARE;
    }

    private Paint.Join getStrokeLineJoin(int paramInt, Paint.Join paramJoin)
    {
      switch (paramInt)
      {
      default:
        return paramJoin;
      case 0:
        return Paint.Join.MITER;
      case 1:
        return Paint.Join.ROUND;
      case 2:
      }
      return Paint.Join.BEVEL;
    }

    private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.mThemeAttrs = null;
      if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData"))
        return;
      String str = paramTypedArray.getString(0);
      if (str != null)
        this.mPathName = str;
      str = paramTypedArray.getString(2);
      if (str != null)
        this.mNodes = PathParser.createNodesFromPathData(str);
      this.mFillColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "fillColor", 1, this.mFillColor);
      this.mFillAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.mFillAlpha);
      this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
      this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
      this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
      this.mStrokeColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "strokeColor", 3, this.mStrokeColor);
      this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
      this.mStrokeWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
      this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
      this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
      this.mTrimPathStart = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
    }

    public void applyTheme(Resources.Theme paramTheme)
    {
      if (this.mThemeAttrs == null);
    }

    public boolean canApplyTheme()
    {
      return this.mThemeAttrs != null;
    }

    float getFillAlpha()
    {
      return this.mFillAlpha;
    }

    int getFillColor()
    {
      return this.mFillColor;
    }

    float getStrokeAlpha()
    {
      return this.mStrokeAlpha;
    }

    int getStrokeColor()
    {
      return this.mStrokeColor;
    }

    float getStrokeWidth()
    {
      return this.mStrokeWidth;
    }

    float getTrimPathEnd()
    {
      return this.mTrimPathEnd;
    }

    float getTrimPathOffset()
    {
      return this.mTrimPathOffset;
    }

    float getTrimPathStart()
    {
      return this.mTrimPathStart;
    }

    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = VectorDrawableCommon.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_VectorDrawablePath);
      updateStateFromTypedArray(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }

    void setFillAlpha(float paramFloat)
    {
      this.mFillAlpha = paramFloat;
    }

    void setFillColor(int paramInt)
    {
      this.mFillColor = paramInt;
    }

    void setStrokeAlpha(float paramFloat)
    {
      this.mStrokeAlpha = paramFloat;
    }

    void setStrokeColor(int paramInt)
    {
      this.mStrokeColor = paramInt;
    }

    void setStrokeWidth(float paramFloat)
    {
      this.mStrokeWidth = paramFloat;
    }

    void setTrimPathEnd(float paramFloat)
    {
      this.mTrimPathEnd = paramFloat;
    }

    void setTrimPathOffset(float paramFloat)
    {
      this.mTrimPathOffset = paramFloat;
    }

    void setTrimPathStart(float paramFloat)
    {
      this.mTrimPathStart = paramFloat;
    }
  }

  private static class VGroup
  {
    private int mChangingConfigurations;
    final ArrayList<Object> mChildren = new ArrayList();
    private String mGroupName = null;
    private final Matrix mLocalMatrix = new Matrix();
    private float mPivotX = 0.0F;
    private float mPivotY = 0.0F;
    private float mRotate = 0.0F;
    private float mScaleX = 1.0F;
    private float mScaleY = 1.0F;
    private final Matrix mStackedMatrix = new Matrix();
    private int[] mThemeAttrs;
    private float mTranslateX = 0.0F;
    private float mTranslateY = 0.0F;

    public VGroup()
    {
    }

    public VGroup(VGroup paramVGroup, ArrayMap<String, Object> paramArrayMap)
    {
      this.mRotate = paramVGroup.mRotate;
      this.mPivotX = paramVGroup.mPivotX;
      this.mPivotY = paramVGroup.mPivotY;
      this.mScaleX = paramVGroup.mScaleX;
      this.mScaleY = paramVGroup.mScaleY;
      this.mTranslateX = paramVGroup.mTranslateX;
      this.mTranslateY = paramVGroup.mTranslateY;
      this.mThemeAttrs = paramVGroup.mThemeAttrs;
      this.mGroupName = paramVGroup.mGroupName;
      this.mChangingConfigurations = paramVGroup.mChangingConfigurations;
      if (this.mGroupName != null)
        paramArrayMap.put(this.mGroupName, this);
      this.mLocalMatrix.set(paramVGroup.mLocalMatrix);
      ArrayList localArrayList = paramVGroup.mChildren;
      int i = 0;
      while (i < localArrayList.size())
      {
        paramVGroup = localArrayList.get(i);
        if ((paramVGroup instanceof VGroup))
        {
          paramVGroup = (VGroup)paramVGroup;
          this.mChildren.add(new VGroup(paramVGroup, paramArrayMap));
          i += 1;
          continue;
        }
        if ((paramVGroup instanceof VectorDrawableCompat.VFullPath));
        for (paramVGroup = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)paramVGroup); ; paramVGroup = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)paramVGroup))
        {
          this.mChildren.add(paramVGroup);
          if (paramVGroup.mPathName == null)
            break;
          paramArrayMap.put(paramVGroup.mPathName, paramVGroup);
          break;
          if (!(paramVGroup instanceof VectorDrawableCompat.VClipPath))
            break label315;
        }
        label315: throw new IllegalStateException("Unknown object in the tree!");
      }
    }

    private void updateLocalMatrix()
    {
      this.mLocalMatrix.reset();
      this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
      this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
      this.mLocalMatrix.postRotate(this.mRotate, 0.0F, 0.0F);
      this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
    }

    private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.mThemeAttrs = null;
      this.mRotate = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "rotation", 5, this.mRotate);
      this.mPivotX = paramTypedArray.getFloat(1, this.mPivotX);
      this.mPivotY = paramTypedArray.getFloat(2, this.mPivotY);
      this.mScaleX = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleX", 3, this.mScaleX);
      this.mScaleY = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleY", 4, this.mScaleY);
      this.mTranslateX = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateX", 6, this.mTranslateX);
      this.mTranslateY = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateY", 7, this.mTranslateY);
      paramTypedArray = paramTypedArray.getString(0);
      if (paramTypedArray != null)
        this.mGroupName = paramTypedArray;
      updateLocalMatrix();
    }

    public String getGroupName()
    {
      return this.mGroupName;
    }

    public Matrix getLocalMatrix()
    {
      return this.mLocalMatrix;
    }

    public float getPivotX()
    {
      return this.mPivotX;
    }

    public float getPivotY()
    {
      return this.mPivotY;
    }

    public float getRotation()
    {
      return this.mRotate;
    }

    public float getScaleX()
    {
      return this.mScaleX;
    }

    public float getScaleY()
    {
      return this.mScaleY;
    }

    public float getTranslateX()
    {
      return this.mTranslateX;
    }

    public float getTranslateY()
    {
      return this.mTranslateY;
    }

    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = VectorDrawableCommon.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_VectorDrawableGroup);
      updateStateFromTypedArray(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }

    public void setPivotX(float paramFloat)
    {
      if (paramFloat != this.mPivotX)
      {
        this.mPivotX = paramFloat;
        updateLocalMatrix();
      }
    }

    public void setPivotY(float paramFloat)
    {
      if (paramFloat != this.mPivotY)
      {
        this.mPivotY = paramFloat;
        updateLocalMatrix();
      }
    }

    public void setRotation(float paramFloat)
    {
      if (paramFloat != this.mRotate)
      {
        this.mRotate = paramFloat;
        updateLocalMatrix();
      }
    }

    public void setScaleX(float paramFloat)
    {
      if (paramFloat != this.mScaleX)
      {
        this.mScaleX = paramFloat;
        updateLocalMatrix();
      }
    }

    public void setScaleY(float paramFloat)
    {
      if (paramFloat != this.mScaleY)
      {
        this.mScaleY = paramFloat;
        updateLocalMatrix();
      }
    }

    public void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.mTranslateX)
      {
        this.mTranslateX = paramFloat;
        updateLocalMatrix();
      }
    }

    public void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.mTranslateY)
      {
        this.mTranslateY = paramFloat;
        updateLocalMatrix();
      }
    }
  }

  private static class VPath
  {
    int mChangingConfigurations;
    protected PathParser.PathDataNode[] mNodes = null;
    String mPathName;

    public VPath()
    {
    }

    public VPath(VPath paramVPath)
    {
      this.mPathName = paramVPath.mPathName;
      this.mChangingConfigurations = paramVPath.mChangingConfigurations;
      this.mNodes = PathParser.deepCopyNodes(paramVPath.mNodes);
    }

    public String NodesToString(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      String str = " ";
      int i = 0;
      while (i < paramArrayOfPathDataNode.length)
      {
        str = str + paramArrayOfPathDataNode[i].type + ":";
        float[] arrayOfFloat = paramArrayOfPathDataNode[i].params;
        int j = 0;
        while (j < arrayOfFloat.length)
        {
          str = str + arrayOfFloat[j] + ",";
          j += 1;
        }
        i += 1;
      }
      return str;
    }

    public void applyTheme(Resources.Theme paramTheme)
    {
    }

    public boolean canApplyTheme()
    {
      return false;
    }

    public PathParser.PathDataNode[] getPathData()
    {
      return this.mNodes;
    }

    public String getPathName()
    {
      return this.mPathName;
    }

    public boolean isClipPath()
    {
      return false;
    }

    public void printVPath(int paramInt)
    {
      String str = "";
      int i = 0;
      while (i < paramInt)
      {
        str = str + "    ";
        i += 1;
      }
      Log.v("VectorDrawableCompat", str + "current path is :" + this.mPathName + " pathData is " + NodesToString(this.mNodes));
    }

    public void setPathData(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      if (!PathParser.canMorph(this.mNodes, paramArrayOfPathDataNode))
      {
        this.mNodes = PathParser.deepCopyNodes(paramArrayOfPathDataNode);
        return;
      }
      PathParser.updateNodes(this.mNodes, paramArrayOfPathDataNode);
    }

    public void toPath(Path paramPath)
    {
      paramPath.reset();
      if (this.mNodes != null)
        PathParser.PathDataNode.nodesToPath(this.mNodes, paramPath);
    }
  }

  private static class VPathRenderer
  {
    private static final Matrix IDENTITY_MATRIX = new Matrix();
    float mBaseHeight = 0.0F;
    float mBaseWidth = 0.0F;
    private int mChangingConfigurations;
    private Paint mFillPaint;
    private final Matrix mFinalPathMatrix = new Matrix();
    private final Path mPath;
    private PathMeasure mPathMeasure;
    private final Path mRenderPath;
    int mRootAlpha = 255;
    private final VectorDrawableCompat.VGroup mRootGroup;
    String mRootName = null;
    private Paint mStrokePaint;
    final ArrayMap<String, Object> mVGTargetsMap = new ArrayMap();
    float mViewportHeight = 0.0F;
    float mViewportWidth = 0.0F;

    public VPathRenderer()
    {
      this.mRootGroup = new VectorDrawableCompat.VGroup();
      this.mPath = new Path();
      this.mRenderPath = new Path();
    }

    public VPathRenderer(VPathRenderer paramVPathRenderer)
    {
      this.mRootGroup = new VectorDrawableCompat.VGroup(paramVPathRenderer.mRootGroup, this.mVGTargetsMap);
      this.mPath = new Path(paramVPathRenderer.mPath);
      this.mRenderPath = new Path(paramVPathRenderer.mRenderPath);
      this.mBaseWidth = paramVPathRenderer.mBaseWidth;
      this.mBaseHeight = paramVPathRenderer.mBaseHeight;
      this.mViewportWidth = paramVPathRenderer.mViewportWidth;
      this.mViewportHeight = paramVPathRenderer.mViewportHeight;
      this.mChangingConfigurations = paramVPathRenderer.mChangingConfigurations;
      this.mRootAlpha = paramVPathRenderer.mRootAlpha;
      this.mRootName = paramVPathRenderer.mRootName;
      if (paramVPathRenderer.mRootName != null)
        this.mVGTargetsMap.put(paramVPathRenderer.mRootName, this);
    }

    private static float cross(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
    }

    private void drawGroupTree(VectorDrawableCompat.VGroup paramVGroup, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramVGroup.mStackedMatrix.set(paramMatrix);
      paramVGroup.mStackedMatrix.preConcat(paramVGroup.mLocalMatrix);
      int i = 0;
      if (i < paramVGroup.mChildren.size())
      {
        paramMatrix = paramVGroup.mChildren.get(i);
        if ((paramMatrix instanceof VectorDrawableCompat.VGroup))
          drawGroupTree((VectorDrawableCompat.VGroup)paramMatrix, paramVGroup.mStackedMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        while (true)
        {
          i += 1;
          break;
          if (!(paramMatrix instanceof VectorDrawableCompat.VPath))
            continue;
          drawPath(paramVGroup, (VectorDrawableCompat.VPath)paramMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
      }
    }

    private void drawPath(VectorDrawableCompat.VGroup paramVGroup, VectorDrawableCompat.VPath paramVPath, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      float f2 = paramInt1 / this.mViewportWidth;
      float f3 = paramInt2 / this.mViewportHeight;
      float f1 = Math.min(f2, f3);
      paramVGroup = paramVGroup.mStackedMatrix;
      this.mFinalPathMatrix.set(paramVGroup);
      this.mFinalPathMatrix.postScale(f2, f3);
      f2 = getMatrixScale(paramVGroup);
      if (f2 == 0.0F)
        return;
      paramVPath.toPath(this.mPath);
      Path localPath = this.mPath;
      this.mRenderPath.reset();
      if (paramVPath.isClipPath())
      {
        this.mRenderPath.addPath(localPath, this.mFinalPathMatrix);
        paramCanvas.clipPath(this.mRenderPath, Region.Op.REPLACE);
        return;
      }
      paramVGroup = (VectorDrawableCompat.VFullPath)paramVPath;
      float f6;
      float f4;
      if ((paramVGroup.mTrimPathStart != 0.0F) || (paramVGroup.mTrimPathEnd != 1.0F))
      {
        f6 = paramVGroup.mTrimPathStart;
        float f7 = paramVGroup.mTrimPathOffset;
        f4 = paramVGroup.mTrimPathEnd;
        float f5 = paramVGroup.mTrimPathOffset;
        if (this.mPathMeasure == null)
          this.mPathMeasure = new PathMeasure();
        this.mPathMeasure.setPath(this.mPath, false);
        f3 = this.mPathMeasure.getLength();
        f6 = (f6 + f7) % 1.0F * f3;
        f4 = (f4 + f5) % 1.0F * f3;
        localPath.reset();
        if (f6 <= f4)
          break label506;
        this.mPathMeasure.getSegment(f6, f3, localPath, true);
        this.mPathMeasure.getSegment(0.0F, f4, localPath, true);
      }
      while (true)
      {
        localPath.rLineTo(0.0F, 0.0F);
        this.mRenderPath.addPath(localPath, this.mFinalPathMatrix);
        if (paramVGroup.mFillColor != 0)
        {
          if (this.mFillPaint == null)
          {
            this.mFillPaint = new Paint();
            this.mFillPaint.setStyle(Paint.Style.FILL);
            this.mFillPaint.setAntiAlias(true);
          }
          paramVPath = this.mFillPaint;
          paramVPath.setColor(VectorDrawableCompat.access$900(paramVGroup.mFillColor, paramVGroup.mFillAlpha));
          paramVPath.setColorFilter(paramColorFilter);
          paramCanvas.drawPath(this.mRenderPath, paramVPath);
        }
        if (paramVGroup.mStrokeColor == 0)
          break;
        if (this.mStrokePaint == null)
        {
          this.mStrokePaint = new Paint();
          this.mStrokePaint.setStyle(Paint.Style.STROKE);
          this.mStrokePaint.setAntiAlias(true);
        }
        paramVPath = this.mStrokePaint;
        if (paramVGroup.mStrokeLineJoin != null)
          paramVPath.setStrokeJoin(paramVGroup.mStrokeLineJoin);
        if (paramVGroup.mStrokeLineCap != null)
          paramVPath.setStrokeCap(paramVGroup.mStrokeLineCap);
        paramVPath.setStrokeMiter(paramVGroup.mStrokeMiterlimit);
        paramVPath.setColor(VectorDrawableCompat.access$900(paramVGroup.mStrokeColor, paramVGroup.mStrokeAlpha));
        paramVPath.setColorFilter(paramColorFilter);
        paramVPath.setStrokeWidth(paramVGroup.mStrokeWidth * (f1 * f2));
        paramCanvas.drawPath(this.mRenderPath, paramVPath);
        return;
        label506: this.mPathMeasure.getSegment(f6, f4, localPath, true);
      }
    }

    private float getMatrixScale(Matrix paramMatrix)
    {
      float[] arrayOfFloat = new float[4];
      float[] tmp7_5 = arrayOfFloat;
      tmp7_5[0] = 0.0F;
      float[] tmp11_7 = tmp7_5;
      tmp11_7[1] = 1.0F;
      float[] tmp15_11 = tmp11_7;
      tmp15_11[2] = 1.0F;
      float[] tmp19_15 = tmp15_11;
      tmp19_15[3] = 0.0F;
      tmp19_15;
      paramMatrix.mapVectors(arrayOfFloat);
      float f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f3 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f2 = cross(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      f3 = Math.max(f1, f3);
      f1 = 0.0F;
      if (f3 > 0.0F)
        f1 = Math.abs(f2) / f3;
      return f1;
    }

    public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, paramCanvas, paramInt1, paramInt2, paramColorFilter);
    }

    public float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }

    public int getRootAlpha()
    {
      return this.mRootAlpha;
    }

    public void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(255.0F * paramFloat));
    }

    public void setRootAlpha(int paramInt)
    {
      this.mRootAlpha = paramInt;
    }
  }

  private static class VectorDrawableCompatState extends Drawable.ConstantState
  {
    boolean mAutoMirrored;
    boolean mCacheDirty;
    boolean mCachedAutoMirrored;
    Bitmap mCachedBitmap;
    int mCachedRootAlpha;
    int[] mCachedThemeAttrs;
    ColorStateList mCachedTint;
    PorterDuff.Mode mCachedTintMode;
    int mChangingConfigurations;
    Paint mTempPaint;
    ColorStateList mTint = null;
    PorterDuff.Mode mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
    VectorDrawableCompat.VPathRenderer mVPathRenderer;

    public VectorDrawableCompatState()
    {
      this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
    }

    public VectorDrawableCompatState(VectorDrawableCompatState paramVectorDrawableCompatState)
    {
      if (paramVectorDrawableCompatState != null)
      {
        this.mChangingConfigurations = paramVectorDrawableCompatState.mChangingConfigurations;
        this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer(paramVectorDrawableCompatState.mVPathRenderer);
        if (paramVectorDrawableCompatState.mVPathRenderer.mFillPaint != null)
          VectorDrawableCompat.VPathRenderer.access$402(this.mVPathRenderer, new Paint(paramVectorDrawableCompatState.mVPathRenderer.mFillPaint));
        if (paramVectorDrawableCompatState.mVPathRenderer.mStrokePaint != null)
          VectorDrawableCompat.VPathRenderer.access$502(this.mVPathRenderer, new Paint(paramVectorDrawableCompatState.mVPathRenderer.mStrokePaint));
        this.mTint = paramVectorDrawableCompatState.mTint;
        this.mTintMode = paramVectorDrawableCompatState.mTintMode;
        this.mAutoMirrored = paramVectorDrawableCompatState.mAutoMirrored;
      }
    }

    public boolean canReuseBitmap(int paramInt1, int paramInt2)
    {
      return (paramInt1 == this.mCachedBitmap.getWidth()) && (paramInt2 == this.mCachedBitmap.getHeight());
    }

    public boolean canReuseCache()
    {
      return (!this.mCacheDirty) && (this.mCachedTint == this.mTint) && (this.mCachedTintMode == this.mTintMode) && (this.mCachedAutoMirrored == this.mAutoMirrored) && (this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha());
    }

    public void createCachedBitmapIfNeeded(int paramInt1, int paramInt2)
    {
      if ((this.mCachedBitmap == null) || (!canReuseBitmap(paramInt1, paramInt2)))
      {
        this.mCachedBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        this.mCacheDirty = true;
      }
    }

    public void drawCachedBitmapWithRootAlpha(Canvas paramCanvas, ColorFilter paramColorFilter, Rect paramRect)
    {
      paramColorFilter = getPaint(paramColorFilter);
      paramCanvas.drawBitmap(this.mCachedBitmap, null, paramRect, paramColorFilter);
    }

    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }

    public Paint getPaint(ColorFilter paramColorFilter)
    {
      if ((!hasTranslucentRoot()) && (paramColorFilter == null))
        return null;
      if (this.mTempPaint == null)
      {
        this.mTempPaint = new Paint();
        this.mTempPaint.setFilterBitmap(true);
      }
      this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
      this.mTempPaint.setColorFilter(paramColorFilter);
      return this.mTempPaint;
    }

    public boolean hasTranslucentRoot()
    {
      return this.mVPathRenderer.getRootAlpha() < 255;
    }

    public Drawable newDrawable()
    {
      return new VectorDrawableCompat(this, null);
    }

    public Drawable newDrawable(Resources paramResources)
    {
      return new VectorDrawableCompat(this, null);
    }

    public void updateCacheStates()
    {
      this.mCachedTint = this.mTint;
      this.mCachedTintMode = this.mTintMode;
      this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
      this.mCachedAutoMirrored = this.mAutoMirrored;
      this.mCacheDirty = false;
    }

    public void updateCachedBitmap(int paramInt1, int paramInt2)
    {
      this.mCachedBitmap.eraseColor(0);
      Canvas localCanvas = new Canvas(this.mCachedBitmap);
      this.mVPathRenderer.draw(localCanvas, paramInt1, paramInt2, null);
    }
  }

  private static class VectorDrawableDelegateState extends Drawable.ConstantState
  {
    private final Drawable.ConstantState mDelegateState;

    public VectorDrawableDelegateState(Drawable.ConstantState paramConstantState)
    {
      this.mDelegateState = paramConstantState;
    }

    public boolean canApplyTheme()
    {
      return this.mDelegateState.canApplyTheme();
    }

    public int getChangingConfigurations()
    {
      return this.mDelegateState.getChangingConfigurations();
    }

    public Drawable newDrawable()
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat(null);
      localVectorDrawableCompat.mDelegateDrawable = ((VectorDrawable)this.mDelegateState.newDrawable());
      return localVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources paramResources)
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat(null);
      localVectorDrawableCompat.mDelegateDrawable = ((VectorDrawable)this.mDelegateState.newDrawable(paramResources));
      return localVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat(null);
      localVectorDrawableCompat.mDelegateDrawable = ((VectorDrawable)this.mDelegateState.newDrawable(paramResources, paramTheme));
      return localVectorDrawableCompat;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat
 * JD-Core Version:    0.6.0
 */