package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import java.util.Map;
import javax.annotation.Nullable;

@ReactPropertyHolder
public abstract class ViewManager<T extends View, C extends ReactShadowNode> extends BaseJavaModule
{
  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, T paramT)
  {
  }

  public C createShadowNodeInstance()
  {
    throw new RuntimeException("ViewManager subclasses must implement createShadowNodeInstance()");
  }

  public C createShadowNodeInstance(ReactApplicationContext paramReactApplicationContext)
  {
    return createShadowNodeInstance();
  }

  public final T createView(ThemedReactContext paramThemedReactContext, JSResponderHandler paramJSResponderHandler)
  {
    View localView = createViewInstance(paramThemedReactContext);
    addEventEmitters(paramThemedReactContext, localView);
    if ((localView instanceof ReactInterceptingViewGroup))
      ((ReactInterceptingViewGroup)localView).setOnInterceptTouchEventListener(paramJSResponderHandler);
    return localView;
  }

  protected abstract T createViewInstance(ThemedReactContext paramThemedReactContext);

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return null;
  }

  @Nullable
  public Map<String, Object> getExportedCustomBubblingEventTypeConstants()
  {
    return null;
  }

  @Nullable
  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return null;
  }

  @Nullable
  public Map<String, Object> getExportedViewConstants()
  {
    return null;
  }

  public abstract String getName();

  public Map<String, String> getNativeProps()
  {
    return ViewManagerPropertyUpdater.getNativeProps(getClass(), getShadowNodeClass());
  }

  public abstract Class<? extends C> getShadowNodeClass();

  protected void onAfterUpdateTransaction(T paramT)
  {
  }

  public void onDropViewInstance(T paramT)
  {
  }

  public void receiveCommand(T paramT, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
  }

  public abstract void updateExtraData(T paramT, Object paramObject);

  public final void updateProperties(T paramT, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    ViewManagerPropertyUpdater.updateProps(this, paramT, paramReactStylesDiffMap);
    onAfterUpdateTransaction(paramT);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewManager
 * JD-Core Version:    0.6.0
 */