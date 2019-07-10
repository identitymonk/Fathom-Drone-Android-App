package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class DraweeConfig
{

  @Nullable
  private final ImmutableList<DrawableFactory> mCustomDrawableFactories;
  private final Supplier<Boolean> mDebugOverlayEnabledSupplier;

  @Nullable
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

  private DraweeConfig(Builder paramBuilder)
  {
    if (paramBuilder.mCustomDrawableFactories != null)
    {
      localObject = ImmutableList.copyOf(paramBuilder.mCustomDrawableFactories);
      this.mCustomDrawableFactories = ((ImmutableList)localObject);
      if (paramBuilder.mDebugOverlayEnabledSupplier == null)
        break label55;
    }
    label55: for (Object localObject = paramBuilder.mDebugOverlayEnabledSupplier; ; localObject = Suppliers.of(Boolean.valueOf(false)))
    {
      this.mDebugOverlayEnabledSupplier = ((Supplier)localObject);
      this.mPipelineDraweeControllerFactory = paramBuilder.mPipelineDraweeControllerFactory;
      return;
      localObject = null;
      break;
    }
  }

  public static Builder newBuilder()
  {
    return new Builder();
  }

  @Nullable
  public ImmutableList<DrawableFactory> getCustomDrawableFactories()
  {
    return this.mCustomDrawableFactories;
  }

  public Supplier<Boolean> getDebugOverlayEnabledSupplier()
  {
    return this.mDebugOverlayEnabledSupplier;
  }

  @Nullable
  public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory()
  {
    return this.mPipelineDraweeControllerFactory;
  }

  public static class Builder
  {
    private List<DrawableFactory> mCustomDrawableFactories;
    private Supplier<Boolean> mDebugOverlayEnabledSupplier;
    private PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public Builder addCustomDrawableFactory(DrawableFactory paramDrawableFactory)
    {
      if (this.mCustomDrawableFactories == null)
        this.mCustomDrawableFactories = new ArrayList();
      this.mCustomDrawableFactories.add(paramDrawableFactory);
      return this;
    }

    public DraweeConfig build()
    {
      return new DraweeConfig(this, null);
    }

    public Builder setDebugOverlayEnabledSupplier(Supplier<Boolean> paramSupplier)
    {
      Preconditions.checkNotNull(paramSupplier);
      this.mDebugOverlayEnabledSupplier = paramSupplier;
      return this;
    }

    public Builder setDrawDebugOverlay(boolean paramBoolean)
    {
      return setDebugOverlayEnabledSupplier(Suppliers.of(Boolean.valueOf(paramBoolean)));
    }

    public Builder setPipelineDraweeControllerFactory(PipelineDraweeControllerFactory paramPipelineDraweeControllerFactory)
    {
      this.mPipelineDraweeControllerFactory = paramPipelineDraweeControllerFactory;
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.DraweeConfig
 * JD-Core Version:    0.6.0
 */