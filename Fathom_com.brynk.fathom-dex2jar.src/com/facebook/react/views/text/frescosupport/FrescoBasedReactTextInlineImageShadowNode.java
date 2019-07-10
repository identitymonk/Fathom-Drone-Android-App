package com.facebook.react.views.text.frescosupport;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactTextInlineImageShadowNode;
import com.facebook.react.views.text.TextInlineImageSpan;
import java.util.Locale;
import javax.annotation.Nullable;

public class FrescoBasedReactTextInlineImageShadowNode extends ReactTextInlineImageShadowNode
{

  @Nullable
  private final Object mCallerContext;
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  private ReadableMap mHeaders;
  private float mHeight = (0.0F / 0.0F);

  @Nullable
  private Uri mUri;
  private float mWidth = (0.0F / 0.0F);

  public FrescoBasedReactTextInlineImageShadowNode(AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable Object paramObject)
  {
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mCallerContext = paramObject;
  }

  @Nullable
  private static Uri getResourceDrawableUri(Context paramContext, @Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return null;
    paramString = paramString.toLowerCase(Locale.getDefault()).replace("-", "_");
    int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
    return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
  }

  public TextInlineImageSpan buildInlineImageSpan()
  {
    Resources localResources = getThemedContext().getResources();
    int i = (int)Math.ceil(this.mWidth);
    return new FrescoBasedReactTextInlineImageSpan(localResources, (int)Math.ceil(this.mHeight), i, getUri(), getHeaders(), getDraweeControllerBuilder(), getCallerContext());
  }

  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  public AbstractDraweeControllerBuilder getDraweeControllerBuilder()
  {
    return this.mDraweeControllerBuilder;
  }

  public ReadableMap getHeaders()
  {
    return this.mHeaders;
  }

  @Nullable
  public Uri getUri()
  {
    return this.mUri;
  }

  public boolean isVirtual()
  {
    return true;
  }

  @ReactProp(name="headers")
  public void setHeaders(ReadableMap paramReadableMap)
  {
    this.mHeaders = paramReadableMap;
  }

  public void setHeight(Dynamic paramDynamic)
  {
    if (paramDynamic.getType() == ReadableType.Number)
    {
      this.mHeight = (float)paramDynamic.asDouble();
      return;
    }
    throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based height");
  }

  @ReactProp(name="src")
  public void setSource(@Nullable ReadableArray paramReadableArray)
  {
    String str1;
    if ((paramReadableArray == null) || (paramReadableArray.size() == 0))
      str1 = null;
    while (true)
    {
      paramReadableArray = null;
      Object localObject = null;
      if (str1 != null);
      try
      {
        localObject = Uri.parse(str1);
        paramReadableArray = (ReadableArray)localObject;
        String str2 = ((Uri)localObject).getScheme();
        paramReadableArray = (ReadableArray)localObject;
        if (str2 == null)
          paramReadableArray = null;
        label45: localObject = paramReadableArray;
        if (paramReadableArray == null)
          localObject = getResourceDrawableUri(getThemedContext(), str1);
        if (localObject != this.mUri)
          markUpdated();
        this.mUri = ((Uri)localObject);
        return;
        str1 = paramReadableArray.getMap(0).getString("uri");
      }
      catch (Exception localException)
      {
        break label45;
      }
    }
  }

  public void setWidth(Dynamic paramDynamic)
  {
    if (paramDynamic.getType() == ReadableType.Number)
    {
      this.mWidth = (float)paramDynamic.asDouble();
      return;
    }
    throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based width");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageShadowNode
 * JD-Core Version:    0.6.0
 */