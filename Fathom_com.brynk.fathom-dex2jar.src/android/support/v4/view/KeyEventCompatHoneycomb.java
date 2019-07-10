package android.support.v4.view;

import android.view.KeyEvent;

class KeyEventCompatHoneycomb
{
  public static boolean isCtrlPressed(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.isCtrlPressed();
  }

  public static boolean metaStateHasModifiers(int paramInt1, int paramInt2)
  {
    return KeyEvent.metaStateHasModifiers(paramInt1, paramInt2);
  }

  public static boolean metaStateHasNoModifiers(int paramInt)
  {
    return KeyEvent.metaStateHasNoModifiers(paramInt);
  }

  public static int normalizeMetaState(int paramInt)
  {
    return KeyEvent.normalizeMetaState(paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompatHoneycomb
 * JD-Core Version:    0.6.0
 */