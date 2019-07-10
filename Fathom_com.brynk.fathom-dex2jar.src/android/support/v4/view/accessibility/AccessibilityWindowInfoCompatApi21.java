package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityWindowInfo;

class AccessibilityWindowInfoCompatApi21
{
  public static void getBoundsInScreen(Object paramObject, Rect paramRect)
  {
    ((AccessibilityWindowInfo)paramObject).getBoundsInScreen(paramRect);
  }

  public static Object getChild(Object paramObject, int paramInt)
  {
    return ((AccessibilityWindowInfo)paramObject).getChild(paramInt);
  }

  public static int getChildCount(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).getChildCount();
  }

  public static int getId(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).getId();
  }

  public static int getLayer(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).getLayer();
  }

  public static Object getParent(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).getParent();
  }

  public static Object getRoot(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).getRoot();
  }

  public static int getType(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).getType();
  }

  public static boolean isAccessibilityFocused(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).isAccessibilityFocused();
  }

  public static boolean isActive(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).isActive();
  }

  public static boolean isFocused(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).isFocused();
  }

  public static Object obtain()
  {
    return AccessibilityWindowInfo.obtain();
  }

  public static Object obtain(Object paramObject)
  {
    return AccessibilityWindowInfo.obtain((AccessibilityWindowInfo)paramObject);
  }

  public static void recycle(Object paramObject)
  {
    ((AccessibilityWindowInfo)paramObject).recycle();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityWindowInfoCompatApi21
 * JD-Core Version:    0.6.0
 */