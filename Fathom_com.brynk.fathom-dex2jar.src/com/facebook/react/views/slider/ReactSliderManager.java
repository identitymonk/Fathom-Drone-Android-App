package com.facebook.react.views.slider;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View.MeasureSpec;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.Map;

public class ReactSliderManager extends SimpleViewManager<ReactSlider>
{
  private static final SeekBar.OnSeekBarChangeListener ON_CHANGE_LISTENER = new SeekBar.OnSeekBarChangeListener()
  {
    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      ((UIManagerModule)((ReactContext)paramSeekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSliderEvent(paramSeekBar.getId(), ((ReactSlider)paramSeekBar).toRealProgress(paramInt), paramBoolean));
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      ((UIManagerModule)((ReactContext)paramSeekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSlidingCompleteEvent(paramSeekBar.getId(), ((ReactSlider)paramSeekBar).toRealProgress(paramSeekBar.getProgress())));
    }
  };
  private static final String REACT_CLASS = "RCTSlider";
  private static final int STYLE = 16842875;

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactSlider paramReactSlider)
  {
    paramReactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
  }

  public LayoutShadowNode createShadowNodeInstance()
  {
    return new ReactSliderShadowNode(null);
  }

  protected ReactSlider createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactSlider(paramThemedReactContext, null, 16842875);
  }

  public Map getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.of("topSlidingComplete", MapBuilder.of("registrationName", "onSlidingComplete"));
  }

  public String getName()
  {
    return "RCTSlider";
  }

  public Class getShadowNodeClass()
  {
    return ReactSliderShadowNode.class;
  }

  @ReactProp(defaultBoolean=true, name="enabled")
  public void setEnabled(ReactSlider paramReactSlider, boolean paramBoolean)
  {
    paramReactSlider.setEnabled(paramBoolean);
  }

  @ReactProp(customType="Color", name="maximumTrackTintColor")
  public void setMaximumTrackTintColor(ReactSlider paramReactSlider, Integer paramInteger)
  {
    paramReactSlider = ((LayerDrawable)paramReactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908288);
    if (paramInteger == null)
    {
      paramReactSlider.clearColorFilter();
      return;
    }
    paramReactSlider.setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
  }

  @ReactProp(defaultDouble=1.0D, name="maximumValue")
  public void setMaximumValue(ReactSlider paramReactSlider, double paramDouble)
  {
    paramReactSlider.setMaxValue(paramDouble);
  }

  @ReactProp(customType="Color", name="minimumTrackTintColor")
  public void setMinimumTrackTintColor(ReactSlider paramReactSlider, Integer paramInteger)
  {
    paramReactSlider = ((LayerDrawable)paramReactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908301);
    if (paramInteger == null)
    {
      paramReactSlider.clearColorFilter();
      return;
    }
    paramReactSlider.setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
  }

  @ReactProp(defaultDouble=0.0D, name="minimumValue")
  public void setMinimumValue(ReactSlider paramReactSlider, double paramDouble)
  {
    paramReactSlider.setMinValue(paramDouble);
  }

  @ReactProp(defaultDouble=0.0D, name="step")
  public void setStep(ReactSlider paramReactSlider, double paramDouble)
  {
    paramReactSlider.setStep(paramDouble);
  }

  @ReactProp(customType="Color", name="thumbTintColor")
  public void setThumbTintColor(ReactSlider paramReactSlider, Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactSlider.getThumb().clearColorFilter();
      return;
    }
    paramReactSlider.getThumb().setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
  }

  @ReactProp(defaultDouble=0.0D, name="value")
  public void setValue(ReactSlider paramReactSlider, double paramDouble)
  {
    paramReactSlider.setOnSeekBarChangeListener(null);
    paramReactSlider.setValue(paramDouble);
    paramReactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
  }

  static class ReactSliderShadowNode extends LayoutShadowNode
    implements YogaMeasureFunction
  {
    private int mHeight;
    private boolean mMeasured;
    private int mWidth;

    private ReactSliderShadowNode()
    {
      setMeasureFunction(this);
    }

    public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
    {
      if (!this.mMeasured)
      {
        paramYogaNode = new ReactSlider(getThemedContext(), null, 16842875);
        int i = View.MeasureSpec.makeMeasureSpec(-2, 0);
        paramYogaNode.measure(i, i);
        this.mWidth = paramYogaNode.getMeasuredWidth();
        this.mHeight = paramYogaNode.getMeasuredHeight();
        this.mMeasured = true;
      }
      return YogaMeasureOutput.make(this.mWidth, this.mHeight);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.slider.ReactSliderManager
 * JD-Core Version:    0.6.0
 */