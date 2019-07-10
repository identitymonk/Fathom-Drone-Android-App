package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14
{
  private final UiModeManager mUiModeManager;

  AppCompatDelegateImplV23(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
    this.mUiModeManager = ((UiModeManager)paramContext.getSystemService("uimode"));
  }

  int mapNightMode(int paramInt)
  {
    if ((paramInt == 0) && (this.mUiModeManager.getNightMode() == 0))
      return -1;
    return super.mapNightMode(paramInt);
  }

  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatWindowCallbackV23(paramCallback);
  }

  class AppCompatWindowCallbackV23 extends AppCompatDelegateImplV14.AppCompatWindowCallbackV14
  {
    AppCompatWindowCallbackV23(Window.Callback arg2)
    {
      super(localCallback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (AppCompatDelegateImplV23.this.isHandleNativeActionModesEnabled());
      switch (paramInt)
      {
      default:
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      case 0:
      }
      return startAsSupportActionMode(paramCallback);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV23
 * JD-Core Version:    0.6.0
 */