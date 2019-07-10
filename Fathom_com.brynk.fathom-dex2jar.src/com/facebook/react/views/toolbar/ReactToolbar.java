package com.facebook.react.views.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.MeasureSpec;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import javax.annotation.Nullable;

public class ReactToolbar extends Toolbar
{
  private static final String PROP_ACTION_ICON = "icon";
  private static final String PROP_ACTION_SHOW = "show";
  private static final String PROP_ACTION_SHOW_WITH_TEXT = "showWithText";
  private static final String PROP_ACTION_TITLE = "title";
  private static final String PROP_ICON_HEIGHT = "height";
  private static final String PROP_ICON_URI = "uri";
  private static final String PROP_ICON_WIDTH = "width";
  private final MultiDraweeHolder<GenericDraweeHierarchy> mActionsHolder = new MultiDraweeHolder();
  private final Runnable mLayoutRunnable = new Runnable()
  {
    public void run()
    {
      ReactToolbar.this.measure(View.MeasureSpec.makeMeasureSpec(ReactToolbar.this.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ReactToolbar.this.getHeight(), 1073741824));
      ReactToolbar.this.layout(ReactToolbar.this.getLeft(), ReactToolbar.this.getTop(), ReactToolbar.this.getRight(), ReactToolbar.this.getBottom());
    }
  };
  private IconControllerListener mLogoControllerListener;
  private final DraweeHolder mLogoHolder;
  private IconControllerListener mNavIconControllerListener;
  private final DraweeHolder mNavIconHolder;
  private IconControllerListener mOverflowIconControllerListener;
  private final DraweeHolder mOverflowIconHolder;

  public ReactToolbar(Context paramContext)
  {
    super(paramContext);
    this.mLogoHolder = DraweeHolder.create(createDraweeHierarchy(), paramContext);
    this.mNavIconHolder = DraweeHolder.create(createDraweeHierarchy(), paramContext);
    this.mOverflowIconHolder = DraweeHolder.create(createDraweeHierarchy(), paramContext);
    this.mLogoControllerListener = new IconControllerListener(this.mLogoHolder)
    {
      protected void setDrawable(Drawable paramDrawable)
      {
        ReactToolbar.this.setLogo(paramDrawable);
      }
    };
    this.mNavIconControllerListener = new IconControllerListener(this.mNavIconHolder)
    {
      protected void setDrawable(Drawable paramDrawable)
      {
        ReactToolbar.this.setNavigationIcon(paramDrawable);
      }
    };
    this.mOverflowIconControllerListener = new IconControllerListener(this.mOverflowIconHolder)
    {
      protected void setDrawable(Drawable paramDrawable)
      {
        ReactToolbar.this.setOverflowIcon(paramDrawable);
      }
    };
  }

  private void attachDraweeHolders()
  {
    this.mLogoHolder.onAttach();
    this.mNavIconHolder.onAttach();
    this.mOverflowIconHolder.onAttach();
    this.mActionsHolder.onAttach();
  }

  private GenericDraweeHierarchy createDraweeHierarchy()
  {
    return new GenericDraweeHierarchyBuilder(getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFadeDuration(0).build();
  }

  private void detachDraweeHolders()
  {
    this.mLogoHolder.onDetach();
    this.mNavIconHolder.onDetach();
    this.mOverflowIconHolder.onDetach();
    this.mActionsHolder.onDetach();
  }

  private Drawable getDrawableByName(String paramString)
  {
    if (getDrawableResourceByName(paramString) != 0)
      return getResources().getDrawable(getDrawableResourceByName(paramString));
    return null;
  }

  private int getDrawableResourceByName(String paramString)
  {
    return getResources().getIdentifier(paramString, "drawable", getContext().getPackageName());
  }

  private IconImageInfo getIconImageInfo(ReadableMap paramReadableMap)
  {
    if ((paramReadableMap.hasKey("width")) && (paramReadableMap.hasKey("height")))
      return new IconImageInfo(Math.round(PixelUtil.toPixelFromDIP(paramReadableMap.getInt("width"))), Math.round(PixelUtil.toPixelFromDIP(paramReadableMap.getInt("height"))));
    return null;
  }

  private void setIconSource(ReadableMap paramReadableMap, IconControllerListener paramIconControllerListener, DraweeHolder paramDraweeHolder)
  {
    if (paramReadableMap != null);
    for (String str = paramReadableMap.getString("uri"); str == null; str = null)
    {
      paramIconControllerListener.setIconImageInfo(null);
      paramIconControllerListener.setDrawable(null);
      return;
    }
    if ((str.startsWith("http://")) || (str.startsWith("https://")) || (str.startsWith("file://")))
    {
      paramIconControllerListener.setIconImageInfo(getIconImageInfo(paramReadableMap));
      paramDraweeHolder.setController(((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setUri(Uri.parse(str)).setControllerListener(paramIconControllerListener)).setOldController(paramDraweeHolder.getController())).build());
      paramDraweeHolder.getTopLevelDrawable().setVisible(true, true);
      return;
    }
    paramIconControllerListener.setDrawable(getDrawableByName(str));
  }

  private void setMenuItemIcon(MenuItem paramMenuItem, ReadableMap paramReadableMap)
  {
    DraweeHolder localDraweeHolder = DraweeHolder.create(createDraweeHierarchy(), getContext());
    paramMenuItem = new ActionIconControllerListener(paramMenuItem, localDraweeHolder);
    paramMenuItem.setIconImageInfo(getIconImageInfo(paramReadableMap));
    setIconSource(paramReadableMap, paramMenuItem, localDraweeHolder);
    this.mActionsHolder.add(localDraweeHolder);
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    attachDraweeHolders();
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    detachDraweeHolders();
  }

  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    attachDraweeHolders();
  }

  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    detachDraweeHolders();
  }

  public void requestLayout()
  {
    super.requestLayout();
    post(this.mLayoutRunnable);
  }

  void setActions(@Nullable ReadableArray paramReadableArray)
  {
    Menu localMenu = getMenu();
    localMenu.clear();
    this.mActionsHolder.clear();
    if (paramReadableArray != null)
    {
      int j = 0;
      if (j < paramReadableArray.size())
      {
        ReadableMap localReadableMap = paramReadableArray.getMap(j);
        MenuItem localMenuItem = localMenu.add(0, 0, j, localReadableMap.getString("title"));
        if (localReadableMap.hasKey("icon"))
          setMenuItemIcon(localMenuItem, localReadableMap.getMap("icon"));
        if (localReadableMap.hasKey("show"));
        for (int i = localReadableMap.getInt("show"); ; i = 0)
        {
          int k = i;
          if (localReadableMap.hasKey("showWithText"))
          {
            k = i;
            if (localReadableMap.getBoolean("showWithText"))
              k = i | 0x4;
          }
          localMenuItem.setShowAsAction(k);
          j += 1;
          break;
        }
      }
    }
  }

  void setLogoSource(@Nullable ReadableMap paramReadableMap)
  {
    setIconSource(paramReadableMap, this.mLogoControllerListener, this.mLogoHolder);
  }

  void setNavIconSource(@Nullable ReadableMap paramReadableMap)
  {
    setIconSource(paramReadableMap, this.mNavIconControllerListener, this.mNavIconHolder);
  }

  void setOverflowIconSource(@Nullable ReadableMap paramReadableMap)
  {
    setIconSource(paramReadableMap, this.mOverflowIconControllerListener, this.mOverflowIconHolder);
  }

  private class ActionIconControllerListener extends ReactToolbar.IconControllerListener
  {
    private final MenuItem mItem;

    ActionIconControllerListener(MenuItem paramDraweeHolder, DraweeHolder arg3)
    {
      super(localDraweeHolder);
      this.mItem = paramDraweeHolder;
    }

    protected void setDrawable(Drawable paramDrawable)
    {
      this.mItem.setIcon(paramDrawable);
      ReactToolbar.this.requestLayout();
    }
  }

  private abstract class IconControllerListener extends BaseControllerListener<ImageInfo>
  {
    private final DraweeHolder mHolder;
    private ReactToolbar.IconImageInfo mIconImageInfo;

    public IconControllerListener(DraweeHolder arg2)
    {
      Object localObject;
      this.mHolder = localObject;
    }

    public void onFinalImageSet(String paramString, @Nullable ImageInfo paramImageInfo, @Nullable Animatable paramAnimatable)
    {
      super.onFinalImageSet(paramString, paramImageInfo, paramAnimatable);
      if (this.mIconImageInfo != null);
      for (paramString = this.mIconImageInfo; ; paramString = paramImageInfo)
      {
        setDrawable(new DrawableWithIntrinsicSize(this.mHolder.getTopLevelDrawable(), paramString));
        return;
      }
    }

    protected abstract void setDrawable(Drawable paramDrawable);

    public void setIconImageInfo(ReactToolbar.IconImageInfo paramIconImageInfo)
    {
      this.mIconImageInfo = paramIconImageInfo;
    }
  }

  private static class IconImageInfo
    implements ImageInfo
  {
    private int mHeight;
    private int mWidth;

    public IconImageInfo(int paramInt1, int paramInt2)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }

    public int getHeight()
    {
      return this.mHeight;
    }

    public QualityInfo getQualityInfo()
    {
      return null;
    }

    public int getWidth()
    {
      return this.mWidth;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.toolbar.ReactToolbar
 * JD-Core Version:    0.6.0
 */