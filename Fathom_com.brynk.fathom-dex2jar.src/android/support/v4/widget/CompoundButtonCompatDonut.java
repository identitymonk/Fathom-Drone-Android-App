package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class CompoundButtonCompatDonut
{
  private static final String TAG = "CompoundButtonCompatDonut";
  private static Field sButtonDrawableField;
  private static boolean sButtonDrawableFieldFetched;

  static Drawable getButtonDrawable(CompoundButton paramCompoundButton)
  {
    if (!sButtonDrawableFieldFetched);
    try
    {
      sButtonDrawableField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      sButtonDrawableField.setAccessible(true);
      sButtonDrawableFieldFetched = true;
      if (sButtonDrawableField == null);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        paramCompoundButton = (Drawable)sButtonDrawableField.get(paramCompoundButton);
        return paramCompoundButton;
        localNoSuchFieldException = localNoSuchFieldException;
        Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", localNoSuchFieldException);
      }
      catch (java.lang.IllegalAccessException paramCompoundButton)
      {
        Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", paramCompoundButton);
        sButtonDrawableField = null;
      }
    }
    return null;
  }

  static ColorStateList getButtonTintList(CompoundButton paramCompoundButton)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton))
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintList();
    return null;
  }

  static PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton))
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintMode();
    return null;
  }

  static void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton))
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
  }

  static void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton))
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.CompoundButtonCompatDonut
 * JD-Core Version:    0.6.0
 */