package com.facebook.react.uimanager.util;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R.id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class ReactFindViewUtil
{
  private static final List<OnViewFoundListener> mOnViewFoundListeners = new ArrayList();

  public static void addViewListener(OnViewFoundListener paramOnViewFoundListener)
  {
    mOnViewFoundListeners.add(paramOnViewFoundListener);
  }

  @Nullable
  public static View findView(View paramView, String paramString)
  {
    Object localObject = getNativeId(paramView);
    if ((localObject != null) && (((String)localObject).equals(paramString)))
      return paramView;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        localObject = findView(paramView.getChildAt(i), paramString);
        if (localObject != null)
          return localObject;
        i += 1;
      }
    }
    return (View)null;
  }

  public static void findView(View paramView, OnViewFoundListener paramOnViewFoundListener)
  {
    paramView = findView(paramView, paramOnViewFoundListener.getNativeId());
    if (paramView != null)
      paramOnViewFoundListener.onViewFound(paramView);
    addViewListener(paramOnViewFoundListener);
  }

  @Nullable
  private static String getNativeId(View paramView)
  {
    paramView = paramView.getTag(R.id.view_tag_native_id);
    if ((paramView instanceof String))
      return (String)paramView;
    return null;
  }

  public static void notifyViewRendered(View paramView)
  {
    String str = getNativeId(paramView);
    if (str == null);
    while (true)
    {
      return;
      Iterator localIterator = mOnViewFoundListeners.iterator();
      while (localIterator.hasNext())
      {
        OnViewFoundListener localOnViewFoundListener = (OnViewFoundListener)localIterator.next();
        if ((str == null) || (!str.equals(localOnViewFoundListener.getNativeId())))
          continue;
        localOnViewFoundListener.onViewFound(paramView);
        localIterator.remove();
      }
    }
  }

  public static void removeViewListener(OnViewFoundListener paramOnViewFoundListener)
  {
    mOnViewFoundListeners.remove(paramOnViewFoundListener);
  }

  public static abstract interface OnViewFoundListener
  {
    public abstract String getNativeId();

    public abstract void onViewFound(View paramView);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.util.ReactFindViewUtil
 * JD-Core Version:    0.6.0
 */