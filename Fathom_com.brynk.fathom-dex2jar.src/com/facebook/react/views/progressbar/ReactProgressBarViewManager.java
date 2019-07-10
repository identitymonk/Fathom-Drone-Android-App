package com.facebook.react.views.progressbar;

import android.content.Context;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

@ReactModule(name="AndroidProgressBar")
public class ReactProgressBarViewManager extends BaseViewManager<ProgressBarContainerView, ProgressBarShadowNode>
{
  static final String DEFAULT_STYLE = "Normal";
  static final String PROP_ANIMATING = "animating";
  static final String PROP_INDETERMINATE = "indeterminate";
  static final String PROP_PROGRESS = "progress";
  static final String PROP_STYLE = "styleAttr";
  protected static final String REACT_CLASS = "AndroidProgressBar";
  private static Object sProgressBarCtorLock = new Object();

  public static ProgressBar createProgressBar(Context paramContext, int paramInt)
  {
    synchronized (sProgressBarCtorLock)
    {
      paramContext = new ProgressBar(paramContext, null, paramInt);
      return paramContext;
    }
  }

  static int getStyleFromString(@Nullable String paramString)
  {
    if (paramString == null)
      throw new JSApplicationIllegalArgumentException("ProgressBar needs to have a style, null received");
    if (paramString.equals("Horizontal"))
      return 16842872;
    if (paramString.equals("Small"))
      return 16842873;
    if (paramString.equals("Large"))
      return 16842874;
    if (paramString.equals("Inverse"))
      return 16843399;
    if (paramString.equals("SmallInverse"))
      return 16843400;
    if (paramString.equals("LargeInverse"))
      return 16843401;
    if (paramString.equals("Normal"))
      return 16842871;
    throw new JSApplicationIllegalArgumentException("Unknown ProgressBar style: " + paramString);
  }

  public ProgressBarShadowNode createShadowNodeInstance()
  {
    return new ProgressBarShadowNode();
  }

  protected ProgressBarContainerView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ProgressBarContainerView(paramThemedReactContext);
  }

  public String getName()
  {
    return "AndroidProgressBar";
  }

  public Class<ProgressBarShadowNode> getShadowNodeClass()
  {
    return ProgressBarShadowNode.class;
  }

  protected void onAfterUpdateTransaction(ProgressBarContainerView paramProgressBarContainerView)
  {
    paramProgressBarContainerView.apply();
  }

  @ReactProp(name="animating")
  public void setAnimating(ProgressBarContainerView paramProgressBarContainerView, boolean paramBoolean)
  {
    paramProgressBarContainerView.setAnimating(paramBoolean);
  }

  @ReactProp(customType="Color", name="color")
  public void setColor(ProgressBarContainerView paramProgressBarContainerView, @Nullable Integer paramInteger)
  {
    paramProgressBarContainerView.setColor(paramInteger);
  }

  @ReactProp(name="indeterminate")
  public void setIndeterminate(ProgressBarContainerView paramProgressBarContainerView, boolean paramBoolean)
  {
    paramProgressBarContainerView.setIndeterminate(paramBoolean);
  }

  @ReactProp(name="progress")
  public void setProgress(ProgressBarContainerView paramProgressBarContainerView, double paramDouble)
  {
    paramProgressBarContainerView.setProgress(paramDouble);
  }

  @ReactProp(name="styleAttr")
  public void setStyle(ProgressBarContainerView paramProgressBarContainerView, @Nullable String paramString)
  {
    paramProgressBarContainerView.setStyle(paramString);
  }

  public void updateExtraData(ProgressBarContainerView paramProgressBarContainerView, Object paramObject)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.progressbar.ReactProgressBarViewManager
 * JD-Core Version:    0.6.0
 */