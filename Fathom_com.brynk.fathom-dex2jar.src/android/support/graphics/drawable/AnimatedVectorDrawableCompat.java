package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
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
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon
  implements Animatable
{
  private static final String ANIMATED_VECTOR = "animated-vector";
  private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
  private static final String LOGTAG = "AnimatedVDCompat";
  private static final String TARGET = "target";
  private AnimatedVectorDrawableCompatState mAnimatedVectorState;
  private ArgbEvaluator mArgbEvaluator = null;
  AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
  private final Drawable.Callback mCallback = new Drawable.Callback()
  {
    public void invalidateDrawable(Drawable paramDrawable)
    {
      AnimatedVectorDrawableCompat.this.invalidateSelf();
    }

    public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      AnimatedVectorDrawableCompat.this.scheduleSelf(paramRunnable, paramLong);
    }

    public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      AnimatedVectorDrawableCompat.this.unscheduleSelf(paramRunnable);
    }
  };
  private Context mContext;

  private AnimatedVectorDrawableCompat()
  {
    this(null, null, null);
  }

  private AnimatedVectorDrawableCompat(@Nullable Context paramContext)
  {
    this(paramContext, null, null);
  }

  private AnimatedVectorDrawableCompat(@Nullable Context paramContext, @Nullable AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompatState, @Nullable Resources paramResources)
  {
    this.mContext = paramContext;
    if (paramAnimatedVectorDrawableCompatState != null)
    {
      this.mAnimatedVectorState = paramAnimatedVectorDrawableCompatState;
      return;
    }
    this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(paramContext, paramAnimatedVectorDrawableCompatState, this.mCallback, paramResources);
  }

  @Nullable
  public static AnimatedVectorDrawableCompat create(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = new AnimatedVectorDrawableCompat(paramContext);
      ((AnimatedVectorDrawableCompat)localObject).mDelegateDrawable = ResourcesCompat.getDrawable(paramContext.getResources(), paramInt, paramContext.getTheme());
      ((AnimatedVectorDrawableCompat)localObject).mDelegateDrawable.setCallback(((AnimatedVectorDrawableCompat)localObject).mCallback);
      ((AnimatedVectorDrawableCompat)localObject).mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(((AnimatedVectorDrawableCompat)localObject).mDelegateDrawable.getConstantState());
      return localObject;
    }
    Object localObject = paramContext.getResources();
    try
    {
      localObject = ((Resources)localObject).getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
        paramInt = ((XmlPullParser)localObject).next();
      while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2)
        throw new XmlPullParserException("No start tag found");
    }
    catch (XmlPullParserException paramContext)
    {
      AttributeSet localAttributeSet;
      Log.e("AnimatedVDCompat", "parser error", paramContext);
      return null;
      paramContext = createFromXmlInner(paramContext, paramContext.getResources(), (XmlPullParser)localObject, localAttributeSet, paramContext.getTheme());
      return paramContext;
    }
    catch (IOException paramContext)
    {
      while (true)
        Log.e("AnimatedVDCompat", "parser error", paramContext);
    }
  }

  public static AnimatedVectorDrawableCompat createFromXmlInner(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    paramContext = new AnimatedVectorDrawableCompat(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }

  private boolean isStarted()
  {
    ArrayList localArrayList = this.mAnimatedVectorState.mAnimators;
    if (localArrayList == null);
    while (true)
    {
      return false;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if (((Animator)localArrayList.get(i)).isRunning())
          return true;
        i += 1;
      }
    }
  }

  static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null)
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }

  private void setupAnimatorsForTarget(String paramString, Animator paramAnimator)
  {
    paramAnimator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(paramString));
    if (Build.VERSION.SDK_INT < 21)
      setupColorAnimator(paramAnimator);
    if (this.mAnimatedVectorState.mAnimators == null)
    {
      this.mAnimatedVectorState.mAnimators = new ArrayList();
      this.mAnimatedVectorState.mTargetNameMap = new ArrayMap();
    }
    this.mAnimatedVectorState.mAnimators.add(paramAnimator);
    this.mAnimatedVectorState.mTargetNameMap.put(paramAnimator, paramString);
  }

  private void setupColorAnimator(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          setupColorAnimator((Animator)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      localObject = paramAnimator.getPropertyName();
      if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
      {
        if (this.mArgbEvaluator == null)
          this.mArgbEvaluator = new ArgbEvaluator();
        paramAnimator.setEvaluator(this.mArgbEvaluator);
      }
    }
  }

  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.mDelegateDrawable != null)
      DrawableCompat.applyTheme(this.mDelegateDrawable, paramTheme);
  }

  public boolean canApplyTheme()
  {
    if (this.mDelegateDrawable != null)
      return DrawableCompat.canApplyTheme(this.mDelegateDrawable);
    return false;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.mDelegateDrawable != null)
      this.mDelegateDrawable.draw(paramCanvas);
    do
    {
      return;
      this.mAnimatedVectorState.mVectorDrawable.draw(paramCanvas);
    }
    while (!isStarted());
    invalidateSelf();
  }

  public int getAlpha()
  {
    if (this.mDelegateDrawable != null)
      return DrawableCompat.getAlpha(this.mDelegateDrawable);
    return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
  }

  public int getChangingConfigurations()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.getChangingConfigurations();
    return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
  }

  public Drawable.ConstantState getConstantState()
  {
    if (this.mDelegateDrawable != null)
      return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    return null;
  }

  public int getIntrinsicHeight()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.getIntrinsicHeight();
    return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
  }

  public int getIntrinsicWidth()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.getIntrinsicWidth();
    return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
  }

  public int getOpacity()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.getOpacity();
    return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
  }

  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
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
    int i = paramXmlPullParser.getEventType();
    label28: Object localObject1;
    Object localObject2;
    if (i != 1)
      if (i == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        if (!"animated-vector".equals(localObject1))
          break label155;
        localObject1 = obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.styleable_AnimatedVectorDrawable);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = VectorDrawableCompat.create(paramResources, i, paramTheme);
          ((VectorDrawableCompat)localObject2).setAllowCaching(false);
          ((VectorDrawableCompat)localObject2).setCallback(this.mCallback);
          if (this.mAnimatedVectorState.mVectorDrawable != null)
            this.mAnimatedVectorState.mVectorDrawable.setCallback(null);
          this.mAnimatedVectorState.mVectorDrawable = ((VectorDrawableCompat)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
    while (true)
    {
      i = paramXmlPullParser.next();
      break label28;
      break;
      label155: if (!"target".equals(localObject1))
        continue;
      localObject1 = paramResources.obtainAttributes(paramAttributeSet, AndroidResources.styleable_AnimatedVectorDrawableTarget);
      localObject2 = ((TypedArray)localObject1).getString(0);
      i = ((TypedArray)localObject1).getResourceId(1, 0);
      if (i != 0)
      {
        if (this.mContext == null)
          break label227;
        setupAnimatorsForTarget((String)localObject2, AnimatorInflater.loadAnimator(this.mContext, i));
      }
      ((TypedArray)localObject1).recycle();
    }
    label227: throw new IllegalStateException("Context can't be null when inflating animators");
  }

  public boolean isRunning()
  {
    if (this.mDelegateDrawable != null)
      return ((AnimatedVectorDrawable)this.mDelegateDrawable).isRunning();
    ArrayList localArrayList = this.mAnimatedVectorState.mAnimators;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((Animator)localArrayList.get(i)).isRunning())
        return true;
      i += 1;
    }
    return false;
  }

  public boolean isStateful()
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.isStateful();
    return this.mAnimatedVectorState.mVectorDrawable.isStateful();
  }

  public Drawable mutate()
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.mutate();
      return this;
    }
    throw new IllegalStateException("Mutate() is not supported for older platform");
  }

  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.setBounds(paramRect);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setBounds(paramRect);
  }

  protected boolean onLevelChange(int paramInt)
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.setLevel(paramInt);
    return this.mAnimatedVectorState.mVectorDrawable.setLevel(paramInt);
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.setState(paramArrayOfInt);
    return this.mAnimatedVectorState.mVectorDrawable.setState(paramArrayOfInt);
  }

  public void setAlpha(int paramInt)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.setAlpha(paramInt);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setColorFilter(paramColorFilter);
  }

  public void setTint(int paramInt)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setTint(this.mDelegateDrawable, paramInt);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setTint(paramInt);
  }

  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setTintList(this.mDelegateDrawable, paramColorStateList);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setTintList(paramColorStateList);
  }

  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setTintMode(this.mDelegateDrawable, paramMode);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setTintMode(paramMode);
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.setVisible(paramBoolean1, paramBoolean2);
    this.mAnimatedVectorState.mVectorDrawable.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }

  public void start()
  {
    if (this.mDelegateDrawable != null)
      ((AnimatedVectorDrawable)this.mDelegateDrawable).start();
    do
      return;
    while (isStarted());
    ArrayList localArrayList = this.mAnimatedVectorState.mAnimators;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((Animator)localArrayList.get(i)).start();
      i += 1;
    }
    invalidateSelf();
  }

  public void stop()
  {
    if (this.mDelegateDrawable != null)
      ((AnimatedVectorDrawable)this.mDelegateDrawable).stop();
    while (true)
    {
      return;
      ArrayList localArrayList = this.mAnimatedVectorState.mAnimators;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Animator)localArrayList.get(i)).end();
        i += 1;
      }
    }
  }

  private static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState
  {
    ArrayList<Animator> mAnimators;
    int mChangingConfigurations;
    ArrayMap<Animator, String> mTargetNameMap;
    VectorDrawableCompat mVectorDrawable;

    public AnimatedVectorDrawableCompatState(Context paramContext, AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompatState, Drawable.Callback paramCallback, Resources paramResources)
    {
      if (paramAnimatedVectorDrawableCompatState != null)
      {
        this.mChangingConfigurations = paramAnimatedVectorDrawableCompatState.mChangingConfigurations;
        if (paramAnimatedVectorDrawableCompatState.mVectorDrawable != null)
        {
          paramContext = paramAnimatedVectorDrawableCompatState.mVectorDrawable.getConstantState();
          if (paramResources == null)
            break label215;
        }
        label215: for (this.mVectorDrawable = ((VectorDrawableCompat)paramContext.newDrawable(paramResources)); ; this.mVectorDrawable = ((VectorDrawableCompat)paramContext.newDrawable()))
        {
          this.mVectorDrawable = ((VectorDrawableCompat)this.mVectorDrawable.mutate());
          this.mVectorDrawable.setCallback(paramCallback);
          this.mVectorDrawable.setBounds(paramAnimatedVectorDrawableCompatState.mVectorDrawable.getBounds());
          this.mVectorDrawable.setAllowCaching(false);
          if (paramAnimatedVectorDrawableCompatState.mAnimators == null)
            break;
          int j = paramAnimatedVectorDrawableCompatState.mAnimators.size();
          this.mAnimators = new ArrayList(j);
          this.mTargetNameMap = new ArrayMap(j);
          int i = 0;
          while (i < j)
          {
            paramCallback = (Animator)paramAnimatedVectorDrawableCompatState.mAnimators.get(i);
            paramContext = paramCallback.clone();
            paramCallback = (String)paramAnimatedVectorDrawableCompatState.mTargetNameMap.get(paramCallback);
            paramContext.setTarget(this.mVectorDrawable.getTargetByName(paramCallback));
            this.mAnimators.add(paramContext);
            this.mTargetNameMap.put(paramContext, paramCallback);
            i += 1;
          }
        }
      }
    }

    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }

    public Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 23.");
    }

    public Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 23.");
    }
  }

  private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState
  {
    private final Drawable.ConstantState mDelegateState;

    public AnimatedVectorDrawableDelegateState(Drawable.ConstantState paramConstantState)
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
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null);
      localAnimatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable();
      localAnimatedVectorDrawableCompat.mDelegateDrawable.setCallback(localAnimatedVectorDrawableCompat.mCallback);
      return localAnimatedVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources paramResources)
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null);
      localAnimatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(paramResources);
      localAnimatedVectorDrawableCompat.mDelegateDrawable.setCallback(localAnimatedVectorDrawableCompat.mCallback);
      return localAnimatedVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null);
      localAnimatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(paramResources, paramTheme);
      localAnimatedVectorDrawableCompat.mDelegateDrawable.setCallback(localAnimatedVectorDrawableCompat.mCallback);
      return localAnimatedVectorDrawableCompat;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.graphics.drawable.AnimatedVectorDrawableCompat
 * JD-Core Version:    0.6.0
 */