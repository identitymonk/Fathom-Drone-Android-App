package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper
{
  private static final ArrayList<WeakReference<TintContextWrapper>> sCache = new ArrayList();
  private Resources mResources;
  private final Resources.Theme mTheme;

  private TintContextWrapper(@NonNull Context paramContext)
  {
    super(paramContext);
    if (VectorEnabledTintResources.shouldBeUsed())
    {
      this.mTheme = getResources().newTheme();
      this.mTheme.setTo(paramContext.getTheme());
      return;
    }
    this.mTheme = null;
  }

  private static boolean shouldWrap(@NonNull Context paramContext)
  {
    if (((paramContext instanceof TintContextWrapper)) || ((paramContext.getResources() instanceof TintResources)) || ((paramContext.getResources() instanceof VectorEnabledTintResources)));
    do
      return false;
    while ((AppCompatDelegate.isCompatVectorFromResourcesEnabled()) && (Build.VERSION.SDK_INT > 20));
    return true;
  }

  public static Context wrap(@NonNull Context paramContext)
  {
    if (shouldWrap(paramContext))
    {
      int i = 0;
      int j = sCache.size();
      while (i < j)
      {
        Object localObject = (WeakReference)sCache.get(i);
        if (localObject != null);
        for (localObject = (TintContextWrapper)((WeakReference)localObject).get(); (localObject != null) && (((TintContextWrapper)localObject).getBaseContext() == paramContext); localObject = null)
          return localObject;
        i += 1;
      }
      paramContext = new TintContextWrapper(paramContext);
      sCache.add(new WeakReference(paramContext));
      return paramContext;
    }
    return (Context)paramContext;
  }

  public Resources getResources()
  {
    if (this.mResources == null)
      if (this.mTheme != null)
        break label37;
    label37: for (Object localObject = new TintResources(this, super.getResources()); ; localObject = new VectorEnabledTintResources(this, super.getResources()))
    {
      this.mResources = ((Resources)localObject);
      return this.mResources;
    }
  }

  public Resources.Theme getTheme()
  {
    if (this.mTheme == null)
      return super.getTheme();
    return this.mTheme;
  }

  public void setTheme(int paramInt)
  {
    if (this.mTheme == null)
    {
      super.setTheme(paramInt);
      return;
    }
    this.mTheme.applyStyle(paramInt, true);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.TintContextWrapper
 * JD-Core Version:    0.6.0
 */