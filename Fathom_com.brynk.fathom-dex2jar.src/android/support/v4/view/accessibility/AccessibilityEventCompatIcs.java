package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityEventCompatIcs
{
  public static void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject)
  {
    paramAccessibilityEvent.appendRecord((AccessibilityRecord)paramObject);
  }

  public static Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    return paramAccessibilityEvent.getRecord(paramInt);
  }

  public static int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
  {
    return paramAccessibilityEvent.getRecordCount();
  }

  public static void setScrollable(AccessibilityEvent paramAccessibilityEvent, boolean paramBoolean)
  {
    paramAccessibilityEvent.setScrollable(paramBoolean);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityEventCompatIcs
 * JD-Core Version:    0.6.0
 */