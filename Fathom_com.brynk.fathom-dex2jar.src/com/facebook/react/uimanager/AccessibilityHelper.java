package com.facebook.react.uimanager;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.RadioButton;

class AccessibilityHelper
{
  private static final String BUTTON = "button";
  private static final View.AccessibilityDelegate BUTTON_DELEGATE = new View.AccessibilityDelegate()
  {
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(Button.class.getName());
    }
  };
  private static final String RADIOBUTTON_CHECKED = "radiobutton_checked";
  private static final View.AccessibilityDelegate RADIOBUTTON_CHECKED_DELEGATE = new View.AccessibilityDelegate()
  {
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(RadioButton.class.getName());
      paramAccessibilityEvent.setChecked(true);
    }

    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(RadioButton.class.getName());
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(true);
    }
  };
  private static final String RADIOBUTTON_UNCHECKED = "radiobutton_unchecked";
  private static final View.AccessibilityDelegate RADIOBUTTON_UNCHECKED_DELEGATE = new View.AccessibilityDelegate()
  {
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(RadioButton.class.getName());
      paramAccessibilityEvent.setChecked(false);
    }

    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(RadioButton.class.getName());
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(false);
    }
  };

  public static void sendAccessibilityEvent(View paramView, int paramInt)
  {
    paramView.sendAccessibilityEvent(paramInt);
  }

  public static void updateAccessibilityComponentType(View paramView, String paramString)
  {
    if (paramString == null)
    {
      paramView.setAccessibilityDelegate(null);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1377687758:
    case -714126251:
    case -1320494052:
    }
    while (true)
      switch (i)
      {
      default:
        paramView.setAccessibilityDelegate(null);
        return;
        if (!paramString.equals("button"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("radiobutton_checked"))
          continue;
        i = 1;
        continue;
        if (!paramString.equals("radiobutton_unchecked"))
          continue;
        i = 2;
      case 0:
      case 1:
      case 2:
      }
    paramView.setAccessibilityDelegate(BUTTON_DELEGATE);
    return;
    paramView.setAccessibilityDelegate(RADIOBUTTON_CHECKED_DELEGATE);
    return;
    paramView.setAccessibilityDelegate(RADIOBUTTON_UNCHECKED_DELEGATE);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.AccessibilityHelper
 * JD-Core Version:    0.6.0
 */