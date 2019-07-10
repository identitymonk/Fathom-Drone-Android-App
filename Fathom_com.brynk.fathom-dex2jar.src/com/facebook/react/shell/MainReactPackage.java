package com.facebook.react.shell;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.react.LazyReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.flat.FlatARTSurfaceViewManager;
import com.facebook.react.flat.RCTImageViewManager;
import com.facebook.react.flat.RCTModalHostManager;
import com.facebook.react.flat.RCTRawTextManager;
import com.facebook.react.flat.RCTTextInlineImageManager;
import com.facebook.react.flat.RCTTextInputManager;
import com.facebook.react.flat.RCTTextManager;
import com.facebook.react.flat.RCTViewManager;
import com.facebook.react.flat.RCTViewPagerManager;
import com.facebook.react.flat.RCTVirtualTextManager;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.camera.CameraRollManager;
import com.facebook.react.modules.camera.ImageEditingManager;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.location.LocationModule;
import com.facebook.react.modules.netinfo.NetInfoModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.art.ARTRenderableViewManager;
import com.facebook.react.views.art.ARTSurfaceViewManager;
import com.facebook.react.views.checkbox.ReactCheckBoxManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.picker.ReactDialogPickerManager;
import com.facebook.react.views.picker.ReactDropdownPickerManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.toolbar.ReactToolbarManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;
import com.facebook.react.views.webview.ReactWebViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Provider;

public class MainReactPackage extends LazyReactPackage
{
  private MainPackageConfig mConfig;

  public MainReactPackage()
  {
  }

  public MainReactPackage(MainPackageConfig paramMainPackageConfig)
  {
    this.mConfig = paramMainPackageConfig;
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ARTRenderableViewManager.createARTGroupViewManager());
    localArrayList.add(ARTRenderableViewManager.createARTShapeViewManager());
    localArrayList.add(ARTRenderableViewManager.createARTTextViewManager());
    localArrayList.add(new ReactCheckBoxManager());
    localArrayList.add(new ReactDialogPickerManager());
    localArrayList.add(new ReactDrawerLayoutManager());
    localArrayList.add(new ReactDropdownPickerManager());
    localArrayList.add(new ReactHorizontalScrollViewManager());
    localArrayList.add(new ReactHorizontalScrollContainerViewManager());
    localArrayList.add(new ReactProgressBarViewManager());
    localArrayList.add(new ReactScrollViewManager());
    localArrayList.add(new ReactSliderManager());
    localArrayList.add(new ReactSwitchManager());
    localArrayList.add(new ReactToolbarManager());
    localArrayList.add(new ReactWebViewManager());
    localArrayList.add(new SwipeRefreshLayoutManager());
    if (PreferenceManager.getDefaultSharedPreferences(paramReactApplicationContext).getBoolean("flat_uiimplementation", false))
    {
      localArrayList.add(new FlatARTSurfaceViewManager());
      localArrayList.add(new RCTTextInlineImageManager());
      localArrayList.add(new RCTImageViewManager());
      localArrayList.add(new RCTModalHostManager());
      localArrayList.add(new RCTRawTextManager());
      localArrayList.add(new RCTTextInputManager());
      localArrayList.add(new RCTTextManager());
      localArrayList.add(new RCTViewManager());
      localArrayList.add(new RCTViewPagerManager());
      localArrayList.add(new RCTVirtualTextManager());
      return localArrayList;
    }
    localArrayList.add(new ARTSurfaceViewManager());
    localArrayList.add(new FrescoBasedReactTextInlineImageViewManager());
    localArrayList.add(new ReactImageManager());
    localArrayList.add(new ReactModalHostManager());
    localArrayList.add(new ReactRawTextManager());
    localArrayList.add(new ReactTextInputManager());
    localArrayList.add(new ReactTextViewManager());
    localArrayList.add(new ReactViewManager());
    localArrayList.add(new ReactViewPagerManager());
    localArrayList.add(new ReactVirtualTextViewManager());
    return localArrayList;
  }

  public List<ModuleSpec> getNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    return Arrays.asList(new ModuleSpec[] { new ModuleSpec(AccessibilityInfoModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new AccessibilityInfoModule(this.val$context);
      }
    }), new ModuleSpec(AppStateModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new AppStateModule(this.val$context);
      }
    }), new ModuleSpec(BlobModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new BlobModule(this.val$context);
      }
    }), new ModuleSpec(AsyncStorageModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new AsyncStorageModule(this.val$context);
      }
    }), new ModuleSpec(CameraRollManager.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new CameraRollManager(this.val$context);
      }
    }), new ModuleSpec(ClipboardModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new ClipboardModule(this.val$context);
      }
    }), new ModuleSpec(DatePickerDialogModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new DatePickerDialogModule(this.val$context);
      }
    }), new ModuleSpec(DialogModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new DialogModule(this.val$context);
      }
    }), new ModuleSpec(FrescoModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        ReactApplicationContext localReactApplicationContext = this.val$context;
        if (MainReactPackage.this.mConfig != null);
        for (ImagePipelineConfig localImagePipelineConfig = MainReactPackage.this.mConfig.getFrescoConfig(); ; localImagePipelineConfig = null)
          return new FrescoModule(localReactApplicationContext, true, localImagePipelineConfig);
      }
    }), new ModuleSpec(I18nManagerModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new I18nManagerModule(this.val$context);
      }
    }), new ModuleSpec(ImageEditingManager.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new ImageEditingManager(this.val$context);
      }
    }), new ModuleSpec(ImageLoaderModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new ImageLoaderModule(this.val$context);
      }
    }), new ModuleSpec(ImageStoreManager.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new ImageStoreManager(this.val$context);
      }
    }), new ModuleSpec(IntentModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new IntentModule(this.val$context);
      }
    }), new ModuleSpec(LocationModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new LocationModule(this.val$context);
      }
    }), new ModuleSpec(NativeAnimatedModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new NativeAnimatedModule(this.val$context);
      }
    }), new ModuleSpec(NetworkingModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new NetworkingModule(this.val$context);
      }
    }), new ModuleSpec(NetInfoModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new NetInfoModule(this.val$context);
      }
    }), new ModuleSpec(PermissionsModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new PermissionsModule(this.val$context);
      }
    }), new ModuleSpec(ShareModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new ShareModule(this.val$context);
      }
    }), new ModuleSpec(StatusBarModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new StatusBarModule(this.val$context);
      }
    }), new ModuleSpec(TimePickerDialogModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new TimePickerDialogModule(this.val$context);
      }
    }), new ModuleSpec(ToastModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new ToastModule(this.val$context);
      }
    }), new ModuleSpec(VibrationModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new VibrationModule(this.val$context);
      }
    }), new ModuleSpec(WebSocketModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new WebSocketModule(this.val$context);
      }
    }) });
  }

  public ReactModuleInfoProvider getReactModuleInfoProvider()
  {
    return LazyReactPackage.getReactModuleInfoProviderViaReflection(this);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.shell.MainReactPackage
 * JD-Core Version:    0.6.0
 */