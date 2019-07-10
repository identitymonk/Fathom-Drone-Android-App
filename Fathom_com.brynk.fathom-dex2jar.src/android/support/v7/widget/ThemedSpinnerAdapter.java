package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

public abstract interface ThemedSpinnerAdapter extends SpinnerAdapter
{
  @Nullable
  public abstract Resources.Theme getDropDownViewTheme();

  public abstract void setDropDownViewTheme(@Nullable Resources.Theme paramTheme);

  public static final class Helper
  {
    private final Context mContext;
    private LayoutInflater mDropDownInflater;
    private final LayoutInflater mInflater;

    public Helper(@NonNull Context paramContext)
    {
      this.mContext = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
    }

    @NonNull
    public LayoutInflater getDropDownViewInflater()
    {
      if (this.mDropDownInflater != null)
        return this.mDropDownInflater;
      return this.mInflater;
    }

    @Nullable
    public Resources.Theme getDropDownViewTheme()
    {
      if (this.mDropDownInflater == null)
        return null;
      return this.mDropDownInflater.getContext().getTheme();
    }

    public void setDropDownViewTheme(@Nullable Resources.Theme paramTheme)
    {
      if (paramTheme == null)
      {
        this.mDropDownInflater = null;
        return;
      }
      if (paramTheme == this.mContext.getTheme())
      {
        this.mDropDownInflater = this.mInflater;
        return;
      }
      this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, paramTheme));
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ThemedSpinnerAdapter
 * JD-Core Version:    0.6.0
 */