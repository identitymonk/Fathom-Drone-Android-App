package com.facebook.react.views.progressbar;

import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import android.widget.ProgressBar;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class ProgressBarShadowNode extends LayoutShadowNode
  implements YogaMeasureFunction
{
  private final SparseIntArray mHeight = new SparseIntArray();
  private final Set<Integer> mMeasured = new HashSet();
  private String mStyle = "Normal";
  private final SparseIntArray mWidth = new SparseIntArray();

  public ProgressBarShadowNode()
  {
    setMeasureFunction(this);
  }

  @Nullable
  public String getStyle()
  {
    return this.mStyle;
  }

  public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    int i = ReactProgressBarViewManager.getStyleFromString(getStyle());
    if (!this.mMeasured.contains(Integer.valueOf(i)))
    {
      paramYogaNode = ReactProgressBarViewManager.createProgressBar(getThemedContext(), i);
      int j = View.MeasureSpec.makeMeasureSpec(-2, 0);
      paramYogaNode.measure(j, j);
      this.mHeight.put(i, paramYogaNode.getMeasuredHeight());
      this.mWidth.put(i, paramYogaNode.getMeasuredWidth());
      this.mMeasured.add(Integer.valueOf(i));
    }
    return YogaMeasureOutput.make(this.mWidth.get(i), this.mHeight.get(i));
  }

  @ReactProp(name="styleAttr")
  public void setStyle(@Nullable String paramString)
  {
    String str = paramString;
    if (paramString == null)
      str = "Normal";
    this.mStyle = str;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.progressbar.ProgressBarShadowNode
 * JD-Core Version:    0.6.0
 */