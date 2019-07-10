package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.annotation.StyleRes;
import android.support.v7.appcompat.R.style;
import android.view.LayoutInflater;

public class ContextThemeWrapper extends ContextWrapper
{
  private LayoutInflater mInflater;
  private Resources.Theme mTheme;
  private int mThemeResource;

  public ContextThemeWrapper(Context paramContext, @StyleRes int paramInt)
  {
    super(paramContext);
    this.mThemeResource = paramInt;
  }

  public ContextThemeWrapper(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    this.mTheme = paramTheme;
  }

  private void initializeTheme()
  {
    if (this.mTheme == null);
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
      {
        this.mTheme = getResources().newTheme();
        Resources.Theme localTheme = getBaseContext().getTheme();
        if (localTheme != null)
          this.mTheme.setTo(localTheme);
      }
      onApplyThemeResource(this.mTheme, this.mThemeResource, bool);
      return;
    }
  }

  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.mInflater == null)
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      return this.mInflater;
    }
    return getBaseContext().getSystemService(paramString);
  }

  public Resources.Theme getTheme()
  {
    if (this.mTheme != null)
      return this.mTheme;
    if (this.mThemeResource == 0)
      this.mThemeResource = R.style.Theme_AppCompat_Light;
    initializeTheme();
    return this.mTheme;
  }

  public int getThemeResId()
  {
    return this.mThemeResource;
  }

  protected void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    paramTheme.applyStyle(paramInt, true);
  }

  public void setTheme(int paramInt)
  {
    if (this.mThemeResource != paramInt)
    {
      this.mThemeResource = paramInt;
      initializeTheme();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.view.ContextThemeWrapper
 * JD-Core Version:    0.6.0
 */