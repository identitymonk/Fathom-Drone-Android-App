package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout
{
  private Drawable mInsetForeground;
  private Rect mInsets;
  private Rect mTempRect = new Rect();

  public ScrimInsetsFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScrimInsetsFrameLayout, paramInt, R.style.Widget_Design_ScrimInsetsFrameLayout);
    this.mInsetForeground = paramContext.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
    paramContext.recycle();
    setWillNotDraw(true);
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
      {
        if (ScrimInsetsFrameLayout.this.mInsets == null)
          ScrimInsetsFrameLayout.access$002(ScrimInsetsFrameLayout.this, new Rect());
        ScrimInsetsFrameLayout.this.mInsets.set(paramWindowInsetsCompat.getSystemWindowInsetLeft(), paramWindowInsetsCompat.getSystemWindowInsetTop(), paramWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.getSystemWindowInsetBottom());
        ScrimInsetsFrameLayout.this.onInsetsChanged(ScrimInsetsFrameLayout.this.mInsets);
        paramView = ScrimInsetsFrameLayout.this;
        if ((ScrimInsetsFrameLayout.this.mInsets.isEmpty()) || (ScrimInsetsFrameLayout.this.mInsetForeground == null));
        for (boolean bool = true; ; bool = false)
        {
          paramView.setWillNotDraw(bool);
          ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
          return paramWindowInsetsCompat.consumeSystemWindowInsets();
        }
      }
    });
  }

  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.mInsets != null) && (this.mInsetForeground != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.mTempRect.set(0, 0, i, this.mInsets.top);
      this.mInsetForeground.setBounds(this.mTempRect);
      this.mInsetForeground.draw(paramCanvas);
      this.mTempRect.set(0, j - this.mInsets.bottom, i, j);
      this.mInsetForeground.setBounds(this.mTempRect);
      this.mInsetForeground.draw(paramCanvas);
      this.mTempRect.set(0, this.mInsets.top, this.mInsets.left, j - this.mInsets.bottom);
      this.mInsetForeground.setBounds(this.mTempRect);
      this.mInsetForeground.draw(paramCanvas);
      this.mTempRect.set(i - this.mInsets.right, this.mInsets.top, i, j - this.mInsets.bottom);
      this.mInsetForeground.setBounds(this.mTempRect);
      this.mInsetForeground.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mInsetForeground != null)
      this.mInsetForeground.setCallback(this);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mInsetForeground != null)
      this.mInsetForeground.setCallback(null);
  }

  protected void onInsetsChanged(Rect paramRect)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.internal.ScrimInsetsFrameLayout
 * JD-Core Version:    0.6.0
 */