package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public class ARTTextShadowNode extends ARTShapeShadowNode
{
  private static final int DEFAULT_FONT_SIZE = 12;
  private static final String PROP_FONT = "font";
  private static final String PROP_FONT_FAMILY = "fontFamily";
  private static final String PROP_FONT_SIZE = "fontSize";
  private static final String PROP_FONT_STYLE = "fontStyle";
  private static final String PROP_FONT_WEIGHT = "fontWeight";
  private static final String PROP_LINES = "lines";
  private static final int TEXT_ALIGNMENT_CENTER = 2;
  private static final int TEXT_ALIGNMENT_LEFT = 0;
  private static final int TEXT_ALIGNMENT_RIGHT = 1;

  @Nullable
  private ReadableMap mFrame;
  private int mTextAlignment = 0;

  private void applyTextPropertiesToPaint(Paint paramPaint)
  {
    ReadableMap localReadableMap;
    int i;
    label138: int j;
    switch (this.mTextAlignment)
    {
    default:
      if ((this.mFrame == null) || (!this.mFrame.hasKey("font")))
        break;
      localReadableMap = this.mFrame.getMap("font");
      if (localReadableMap == null)
        break;
      float f = 12.0F;
      if (localReadableMap.hasKey("fontSize"))
        f = (float)localReadableMap.getDouble("fontSize");
      paramPaint.setTextSize(this.mScale * f);
      if ((localReadableMap.hasKey("fontWeight")) && ("bold".equals(localReadableMap.getString("fontWeight"))))
      {
        i = 1;
        if ((!localReadableMap.hasKey("fontStyle")) || (!"italic".equals(localReadableMap.getString("fontStyle"))))
          break label235;
        j = 1;
        label170: if ((i == 0) || (j == 0))
          break label241;
        i = 3;
      }
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      paramPaint.setTypeface(Typeface.create(localReadableMap.getString("fontFamily"), i));
      return;
      paramPaint.setTextAlign(Paint.Align.LEFT);
      break;
      paramPaint.setTextAlign(Paint.Align.RIGHT);
      break;
      paramPaint.setTextAlign(Paint.Align.CENTER);
      break;
      i = 0;
      break label138;
      label235: j = 0;
      break label170;
      label241: if (i != 0)
      {
        i = 1;
        continue;
      }
      if (j != 0)
      {
        i = 2;
        continue;
      }
      i = 0;
    }
  }

  public void draw(Canvas paramCanvas, Paint paramPaint, float paramFloat)
  {
    if (this.mFrame == null);
    do
    {
      do
      {
        return;
        paramFloat *= this.mOpacity;
      }
      while ((paramFloat <= 0.01F) || (!this.mFrame.hasKey("lines")));
      localObject = this.mFrame.getArray("lines");
    }
    while ((localObject == null) || (((ReadableArray)localObject).size() == 0));
    saveAndSetupCanvas(paramCanvas);
    String[] arrayOfString = new String[((ReadableArray)localObject).size()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = ((ReadableArray)localObject).getString(i);
      i += 1;
    }
    Object localObject = TextUtils.join("\n", arrayOfString);
    if (setupStrokePaint(paramPaint, paramFloat))
    {
      applyTextPropertiesToPaint(paramPaint);
      if (this.mPath == null)
        paramCanvas.drawText((String)localObject, 0.0F, -paramPaint.ascent(), paramPaint);
    }
    else if (setupFillPaint(paramPaint, paramFloat))
    {
      applyTextPropertiesToPaint(paramPaint);
      if (this.mPath != null)
        break label218;
      paramCanvas.drawText((String)localObject, 0.0F, -paramPaint.ascent(), paramPaint);
    }
    while (true)
    {
      restoreCanvas(paramCanvas);
      markUpdateSeen();
      return;
      paramCanvas.drawTextOnPath((String)localObject, this.mPath, 0.0F, 0.0F, paramPaint);
      break;
      label218: paramCanvas.drawTextOnPath((String)localObject, this.mPath, 0.0F, 0.0F, paramPaint);
    }
  }

  @ReactProp(defaultInt=0, name="alignment")
  public void setAlignment(int paramInt)
  {
    this.mTextAlignment = paramInt;
  }

  @ReactProp(name="frame")
  public void setFrame(@Nullable ReadableMap paramReadableMap)
  {
    this.mFrame = paramReadableMap;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTTextShadowNode
 * JD-Core Version:    0.6.0
 */