package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.R.styleable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import javax.annotation.Nullable;

public class SimpleDraweeView extends GenericDraweeView
{
  private static Supplier<? extends SimpleDraweeControllerBuilder> sDraweeControllerBuilderSupplier;
  private SimpleDraweeControllerBuilder mSimpleDraweeControllerBuilder;

  public SimpleDraweeView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }

  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }

  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }

  @TargetApi(21)
  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext, paramAttributeSet);
  }

  public SimpleDraweeView(Context paramContext, GenericDraweeHierarchy paramGenericDraweeHierarchy)
  {
    super(paramContext, paramGenericDraweeHierarchy);
    init(paramContext, null);
  }

  private void init(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    if (isInEditMode());
    do
    {
      return;
      Preconditions.checkNotNull(sDraweeControllerBuilderSupplier, "SimpleDraweeView was not initialized!");
      this.mSimpleDraweeControllerBuilder = ((SimpleDraweeControllerBuilder)sDraweeControllerBuilderSupplier.get());
    }
    while (paramAttributeSet == null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SimpleDraweeView);
    try
    {
      if (paramContext.hasValue(R.styleable.SimpleDraweeView_actualImageUri))
        setImageURI(Uri.parse(paramContext.getString(R.styleable.SimpleDraweeView_actualImageUri)), null);
      while (true)
      {
        return;
        if (!paramContext.hasValue(R.styleable.SimpleDraweeView_actualImageResource))
          continue;
        int i = paramContext.getResourceId(R.styleable.SimpleDraweeView_actualImageResource, -1);
        if (i == -1)
          continue;
        setActualImageResource(i);
      }
    }
    finally
    {
      paramContext.recycle();
    }
    throw paramAttributeSet;
  }

  public static void initialize(Supplier<? extends SimpleDraweeControllerBuilder> paramSupplier)
  {
    sDraweeControllerBuilderSupplier = paramSupplier;
  }

  public static void shutDown()
  {
    sDraweeControllerBuilderSupplier = null;
  }

  protected SimpleDraweeControllerBuilder getControllerBuilder()
  {
    return this.mSimpleDraweeControllerBuilder;
  }

  public void setActualImageResource(@DrawableRes int paramInt)
  {
    setActualImageResource(paramInt, null);
  }

  public void setActualImageResource(@DrawableRes int paramInt, @Nullable Object paramObject)
  {
    setImageURI(UriUtil.getUriForResourceId(paramInt), paramObject);
  }

  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
  }

  public void setImageURI(Uri paramUri)
  {
    setImageURI(paramUri, null);
  }

  public void setImageURI(Uri paramUri, @Nullable Object paramObject)
  {
    setController(this.mSimpleDraweeControllerBuilder.setCallerContext(paramObject).setUri(paramUri).setOldController(getController()).build());
  }

  public void setImageURI(@Nullable String paramString)
  {
    setImageURI(paramString, null);
  }

  public void setImageURI(@Nullable String paramString, @Nullable Object paramObject)
  {
    if (paramString != null);
    for (paramString = Uri.parse(paramString); ; paramString = null)
    {
      setImageURI(paramString, paramObject);
      return;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.view.SimpleDraweeView
 * JD-Core Version:    0.6.0
 */