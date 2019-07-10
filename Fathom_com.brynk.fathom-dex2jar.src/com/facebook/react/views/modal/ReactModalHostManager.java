package com.facebook.react.views.modal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Map;

@ReactModule(name="RCTModalHostView")
public class ReactModalHostManager extends ViewGroupManager<ReactModalHostView>
{
  protected static final String REACT_CLASS = "RCTModalHostView";

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactModalHostView paramReactModalHostView)
  {
    paramThemedReactContext = ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
    paramReactModalHostView.setOnRequestCloseListener(new ReactModalHostView.OnRequestCloseListener(paramThemedReactContext, paramReactModalHostView)
    {
      public void onRequestClose(DialogInterface paramDialogInterface)
      {
        this.val$dispatcher.dispatchEvent(new RequestCloseEvent(this.val$view.getId()));
      }
    });
    paramReactModalHostView.setOnShowListener(new DialogInterface.OnShowListener(paramThemedReactContext, paramReactModalHostView)
    {
      public void onShow(DialogInterface paramDialogInterface)
      {
        this.val$dispatcher.dispatchEvent(new ShowEvent(this.val$view.getId()));
      }
    });
  }

  public LayoutShadowNode createShadowNodeInstance()
  {
    return new ModalHostShadowNode();
  }

  protected ReactModalHostView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactModalHostView(paramThemedReactContext);
  }

  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.builder().put("topRequestClose", MapBuilder.of("registrationName", "onRequestClose")).put("topShow", MapBuilder.of("registrationName", "onShow")).build();
  }

  public String getName()
  {
    return "RCTModalHostView";
  }

  public Class<? extends LayoutShadowNode> getShadowNodeClass()
  {
    return ModalHostShadowNode.class;
  }

  protected void onAfterUpdateTransaction(ReactModalHostView paramReactModalHostView)
  {
    super.onAfterUpdateTransaction(paramReactModalHostView);
    paramReactModalHostView.showOrUpdate();
  }

  public void onDropViewInstance(ReactModalHostView paramReactModalHostView)
  {
    super.onDropViewInstance(paramReactModalHostView);
    paramReactModalHostView.onDropInstance();
  }

  @ReactProp(name="animationType")
  public void setAnimationType(ReactModalHostView paramReactModalHostView, String paramString)
  {
    paramReactModalHostView.setAnimationType(paramString);
  }

  @ReactProp(name="hardwareAccelerated")
  public void setHardwareAccelerated(ReactModalHostView paramReactModalHostView, boolean paramBoolean)
  {
    paramReactModalHostView.setHardwareAccelerated(paramBoolean);
  }

  @ReactProp(name="transparent")
  public void setTransparent(ReactModalHostView paramReactModalHostView, boolean paramBoolean)
  {
    paramReactModalHostView.setTransparent(paramBoolean);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.modal.ReactModalHostManager
 * JD-Core Version:    0.6.0
 */