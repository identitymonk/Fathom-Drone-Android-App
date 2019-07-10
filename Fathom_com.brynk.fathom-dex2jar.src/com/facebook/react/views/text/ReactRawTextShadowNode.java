package com.facebook.react.views.text;

import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public class ReactRawTextShadowNode extends ReactShadowNodeImpl
{

  @VisibleForTesting
  public static final String PROP_TEXT = "text";

  @Nullable
  private String mText = null;

  @Nullable
  public String getText()
  {
    return this.mText;
  }

  public boolean isVirtual()
  {
    return true;
  }

  @ReactProp(name="text")
  public void setText(@Nullable String paramString)
  {
    this.mText = paramString;
    markUpdated();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactRawTextShadowNode
 * JD-Core Version:    0.6.0
 */