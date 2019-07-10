package com.facebook.react.views.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import com.facebook.react.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

public class ReactPicker extends Spinner
{
  private int mMode = 0;

  @Nullable
  private OnSelectListener mOnSelectListener;

  @Nullable
  private Integer mPrimaryColor;

  @Nullable
  private Integer mStagedSelection;
  private boolean mSuppressNextEvent;
  private final Runnable measureAndLayout = new Runnable()
  {
    public void run()
    {
      ReactPicker.this.measure(View.MeasureSpec.makeMeasureSpec(ReactPicker.this.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ReactPicker.this.getHeight(), 1073741824));
      ReactPicker.this.layout(ReactPicker.this.getLeft(), ReactPicker.this.getTop(), ReactPicker.this.getRight(), ReactPicker.this.getBottom());
    }
  };

  public ReactPicker(Context paramContext)
  {
    super(paramContext);
  }

  public ReactPicker(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mMode = paramInt;
  }

  public ReactPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ReactPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public ReactPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.mMode = paramInt2;
  }

  private void setSelectionWithSuppressEvent(int paramInt)
  {
    if (paramInt != getSelectedItemPosition())
    {
      this.mSuppressNextEvent = true;
      setSelection(paramInt);
    }
  }

  @VisibleForTesting
  public int getMode()
  {
    return this.mMode;
  }

  @Nullable
  public OnSelectListener getOnSelectListener()
  {
    return this.mOnSelectListener;
  }

  @Nullable
  public Integer getPrimaryColor()
  {
    return this.mPrimaryColor;
  }

  public void requestLayout()
  {
    super.requestLayout();
    post(this.measureAndLayout);
  }

  public void setOnSelectListener(@Nullable OnSelectListener paramOnSelectListener)
  {
    if (getOnItemSelectedListener() == null)
    {
      this.mSuppressNextEvent = true;
      setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
        {
          if ((!ReactPicker.this.mSuppressNextEvent) && (ReactPicker.this.mOnSelectListener != null))
            ReactPicker.this.mOnSelectListener.onItemSelected(paramInt);
          ReactPicker.access$002(ReactPicker.this, false);
        }

        public void onNothingSelected(AdapterView<?> paramAdapterView)
        {
          if ((!ReactPicker.this.mSuppressNextEvent) && (ReactPicker.this.mOnSelectListener != null))
            ReactPicker.this.mOnSelectListener.onItemSelected(-1);
          ReactPicker.access$002(ReactPicker.this, false);
        }
      });
    }
    this.mOnSelectListener = paramOnSelectListener;
  }

  public void setPrimaryColor(@Nullable Integer paramInteger)
  {
    this.mPrimaryColor = paramInteger;
  }

  public void setStagedSelection(int paramInt)
  {
    this.mStagedSelection = Integer.valueOf(paramInt);
  }

  public void updateStagedSelection()
  {
    if (this.mStagedSelection != null)
    {
      setSelectionWithSuppressEvent(this.mStagedSelection.intValue());
      this.mStagedSelection = null;
    }
  }

  public static abstract interface OnSelectListener
  {
    public abstract void onItemSelected(int paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.picker.ReactPicker
 * JD-Core Version:    0.6.0
 */