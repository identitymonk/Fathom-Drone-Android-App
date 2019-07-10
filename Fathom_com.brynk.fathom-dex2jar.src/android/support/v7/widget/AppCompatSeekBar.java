package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar
{
  private AppCompatSeekBarHelper mAppCompatSeekBarHelper = new AppCompatSeekBarHelper(this, this.mDrawableManager);
  private AppCompatDrawableManager mDrawableManager = AppCompatDrawableManager.get();

  public AppCompatSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.seekBarStyle);
  }

  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mAppCompatSeekBarHelper.loadFromAttributes(paramAttributeSet, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSeekBar
 * JD-Core Version:    0.6.0
 */