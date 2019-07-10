package com.facebook.react.views.textinput;

import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.widget.EditText;

public final class ReactTextInputLocalData
{
  private final int mBreakStrategy;
  private final int mInputType;
  private final int mMaxLines;
  private final int mMinLines;
  private final SpannableStringBuilder mText;
  private final float mTextSize;

  public ReactTextInputLocalData(EditText paramEditText)
  {
    this.mText = new SpannableStringBuilder(paramEditText.getText());
    this.mTextSize = paramEditText.getTextSize();
    this.mMinLines = paramEditText.getMinLines();
    this.mMaxLines = paramEditText.getMaxLines();
    this.mInputType = paramEditText.getInputType();
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.mBreakStrategy = paramEditText.getBreakStrategy();
      return;
    }
    this.mBreakStrategy = 0;
  }

  public void apply(EditText paramEditText)
  {
    paramEditText.setText(this.mText);
    paramEditText.setTextSize(0, this.mTextSize);
    paramEditText.setMinLines(this.mMinLines);
    paramEditText.setMaxLines(this.mMaxLines);
    paramEditText.setInputType(this.mInputType);
    if (Build.VERSION.SDK_INT >= 23)
      paramEditText.setBreakStrategy(this.mBreakStrategy);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.textinput.ReactTextInputLocalData
 * JD-Core Version:    0.6.0
 */