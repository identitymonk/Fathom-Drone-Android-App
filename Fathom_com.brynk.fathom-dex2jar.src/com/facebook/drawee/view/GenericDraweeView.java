package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import javax.annotation.Nullable;

public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy>
{
  public GenericDraweeView(Context paramContext)
  {
    super(paramContext);
    inflateHierarchy(paramContext, null);
  }

  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflateHierarchy(paramContext, paramAttributeSet);
  }

  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflateHierarchy(paramContext, paramAttributeSet);
  }

  @TargetApi(21)
  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    inflateHierarchy(paramContext, paramAttributeSet);
  }

  public GenericDraweeView(Context paramContext, GenericDraweeHierarchy paramGenericDraweeHierarchy)
  {
    super(paramContext);
    setHierarchy(paramGenericDraweeHierarchy);
  }

  protected void inflateHierarchy(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    paramContext = GenericDraweeHierarchyInflater.inflateBuilder(paramContext, paramAttributeSet);
    setAspectRatio(paramContext.getDesiredAspectRatio());
    setHierarchy(paramContext.build());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.view.GenericDraweeView
 * JD-Core Version:    0.6.0
 */