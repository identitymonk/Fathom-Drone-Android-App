package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;

public class VectorEnabledTintResources extends Resources
{
  public static final int MAX_SDK_WHERE_REQUIRED = 20;
  private final WeakReference<Context> mContextRef;

  public VectorEnabledTintResources(@NonNull Context paramContext, @NonNull Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.mContextRef = new WeakReference(paramContext);
  }

  public static boolean shouldBeUsed()
  {
    return (AppCompatDelegate.isCompatVectorFromResourcesEnabled()) && (Build.VERSION.SDK_INT <= 20);
  }

  public Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Context localContext = (Context)this.mContextRef.get();
    if (localContext != null)
      return AppCompatDrawableManager.get().onDrawableLoadedFromResources(localContext, this, paramInt);
    return super.getDrawable(paramInt);
  }

  final Drawable superGetDrawable(int paramInt)
  {
    return super.getDrawable(paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.VectorEnabledTintResources
 * JD-Core Version:    0.6.0
 */