package com.facebook.react.views.switchview;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View.MeasureSpec;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.react.bridge.ReactContext;
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

public class ReactSwitchManager extends SimpleViewManager<ReactSwitch>
{
  private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      ((UIManagerModule)((ReactContext)paramCompoundButton.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSwitchEvent(paramCompoundButton.getId(), paramBoolean));
    }
  };
  private static final String REACT_CLASS = "AndroidSwitch";

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactSwitch paramReactSwitch)
  {
    paramReactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
  }

  public LayoutShadowNode createShadowNodeInstance()
  {
    return new ReactSwitchShadowNode(null);
  }

  protected ReactSwitch createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    paramThemedReactContext = new ReactSwitch(paramThemedReactContext);
    paramThemedReactContext.setShowText(false);
    return paramThemedReactContext;
  }

  public String getName()
  {
    return "AndroidSwitch";
  }

  public Class getShadowNodeClass()
  {
    return ReactSwitchShadowNode.class;
  }

  @ReactProp(defaultBoolean=true, name="enabled")
  public void setEnabled(ReactSwitch paramReactSwitch, boolean paramBoolean)
  {
    paramReactSwitch.setEnabled(paramBoolean);
  }

  @ReactProp(name="on")
  public void setOn(ReactSwitch paramReactSwitch, boolean paramBoolean)
  {
    paramReactSwitch.setOnCheckedChangeListener(null);
    paramReactSwitch.setOn(paramBoolean);
    paramReactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
  }

  @ReactProp(customType="Color", name="thumbTintColor")
  public void setThumbTintColor(ReactSwitch paramReactSwitch, Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactSwitch.getThumbDrawable().clearColorFilter();
      return;
    }
    paramReactSwitch.getThumbDrawable().setColorFilter(paramInteger.intValue(), PorterDuff.Mode.MULTIPLY);
  }

  @ReactProp(customType="Color", name="trackTintColor")
  public void setTrackTintColor(ReactSwitch paramReactSwitch, Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactSwitch.getTrackDrawable().clearColorFilter();
      return;
    }
    paramReactSwitch.getTrackDrawable().setColorFilter(paramInteger.intValue(), PorterDuff.Mode.MULTIPLY);
  }

  static class ReactSwitchShadowNode extends LayoutShadowNode
    implements YogaMeasureFunction
  {
    private int mHeight;
    private boolean mMeasured;
    private int mWidth;

    private ReactSwitchShadowNode()
    {
      setMeasureFunction(this);
    }

    public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
    {
      if (!this.mMeasured)
      {
        paramYogaNode = new ReactSwitch(getThemedContext());
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
 * Qualified Name:     com.facebook.react.views.switchview.ReactSwitchManager
 * JD-Core Version:    0.6.0
 */