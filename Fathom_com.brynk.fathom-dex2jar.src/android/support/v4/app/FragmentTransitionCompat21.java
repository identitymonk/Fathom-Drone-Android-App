package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class FragmentTransitionCompat21
{
  public static void addTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (Transition)paramObject;
    int j;
    int i;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.getTransitionCount();
      i = 0;
      while (i < j)
      {
        addTargets(paramObject.getTransitionAt(i), paramArrayList);
        i += 1;
      }
    }
    if ((!hasSimpleTarget(paramObject)) && (isNullOrEmpty(paramObject.getTargets())))
    {
      j = paramArrayList.size();
      i = 0;
      while (i < j)
      {
        paramObject.addTarget((View)paramArrayList.get(i));
        i += 1;
      }
    }
  }

  public static void addTransitionTargets(Object paramObject1, Object paramObject2, Object paramObject3, View paramView1, ViewRetriever paramViewRetriever, View paramView2, EpicenterView paramEpicenterView, Map<String, String> paramMap, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Map<String, View> paramMap1, Map<String, View> paramMap2, ArrayList<View> paramArrayList3)
  {
    Transition localTransition1 = (Transition)paramObject1;
    paramObject3 = (Transition)paramObject3;
    Transition localTransition2 = (Transition)paramObject2;
    excludeViews(localTransition1, paramObject3, paramArrayList2, true);
    if ((paramObject1 != null) || (paramObject2 != null))
    {
      if (localTransition1 != null)
        localTransition1.addTarget(paramView2);
      if (paramObject2 != null)
      {
        setSharedElementTargets(localTransition2, paramView2, paramMap1, paramArrayList3);
        excludeViews(localTransition1, localTransition2, paramArrayList3, true);
        excludeViews(paramObject3, localTransition2, paramArrayList3, true);
      }
      paramView1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(paramView1, localTransition1, paramView2, paramViewRetriever, paramMap, paramMap2, paramArrayList1, paramObject3)
      {
        public boolean onPreDraw()
        {
          this.val$container.getViewTreeObserver().removeOnPreDrawListener(this);
          if (this.val$enterTransition != null)
            this.val$enterTransition.removeTarget(this.val$nonExistentView);
          if (this.val$inFragment != null)
          {
            View localView = this.val$inFragment.getView();
            if (localView != null)
            {
              if (!this.val$nameOverrides.isEmpty())
              {
                FragmentTransitionCompat21.findNamedViews(this.val$renamedViews, localView);
                this.val$renamedViews.keySet().retainAll(this.val$nameOverrides.values());
                Iterator localIterator = this.val$nameOverrides.entrySet().iterator();
                while (localIterator.hasNext())
                {
                  Map.Entry localEntry = (Map.Entry)localIterator.next();
                  Object localObject = (String)localEntry.getValue();
                  localObject = (View)this.val$renamedViews.get(localObject);
                  if (localObject == null)
                    continue;
                  ((View)localObject).setTransitionName((String)localEntry.getKey());
                }
              }
              if (this.val$enterTransition != null)
              {
                FragmentTransitionCompat21.access$000(this.val$enteringViews, localView);
                this.val$enteringViews.removeAll(this.val$renamedViews.values());
                this.val$enteringViews.add(this.val$nonExistentView);
                FragmentTransitionCompat21.addTargets(this.val$enterTransition, this.val$enteringViews);
              }
            }
          }
          FragmentTransitionCompat21.access$100(this.val$exitTransition, this.val$enterTransition, this.val$enteringViews, true);
          return true;
        }
      });
      setSharedElementEpicenter(localTransition1, paramEpicenterView);
    }
  }

  public static void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }

  private static void bfsAddViewChildren(List<View> paramList, View paramView)
  {
    int k = paramList.size();
    if (containedBeforeIndex(paramList, paramView, k));
    while (true)
    {
      return;
      paramList.add(paramView);
      int i = k;
      while (i < paramList.size())
      {
        paramView = (View)paramList.get(i);
        if ((paramView instanceof ViewGroup))
        {
          paramView = (ViewGroup)paramView;
          int m = paramView.getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView = paramView.getChildAt(j);
            if (!containedBeforeIndex(paramList, localView, k))
              paramList.add(localView);
            j += 1;
          }
        }
        i += 1;
      }
    }
  }

  public static Object captureExitingViews(Object paramObject, View paramView1, ArrayList<View> paramArrayList, Map<String, View> paramMap, View paramView2)
  {
    Object localObject = paramObject;
    if (paramObject != null)
    {
      captureTransitioningViews(paramArrayList, paramView1);
      if (paramMap != null)
        paramArrayList.removeAll(paramMap.values());
      if (paramArrayList.isEmpty())
        localObject = null;
    }
    else
    {
      return localObject;
    }
    paramArrayList.add(paramView2);
    addTargets((Transition)paramObject, paramArrayList);
    return paramObject;
  }

  private static void captureTransitioningViews(ArrayList<View> paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup))
        break label61;
      paramView = (ViewGroup)paramView;
      if (!paramView.isTransitionGroup())
        break label33;
      paramArrayList.add(paramView);
    }
    while (true)
    {
      return;
      label33: int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        captureTransitioningViews(paramArrayList, paramView.getChildAt(i));
        i += 1;
      }
    }
    label61: paramArrayList.add(paramView);
  }

  public static void cleanupTransitions(View paramView1, View paramView2, Object paramObject1, ArrayList<View> paramArrayList1, Object paramObject2, ArrayList<View> paramArrayList2, Object paramObject3, ArrayList<View> paramArrayList3, Object paramObject4, ArrayList<View> paramArrayList4, Map<String, View> paramMap)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    paramObject4 = (Transition)paramObject4;
    if (paramObject4 != null)
      paramView1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(paramView1, paramObject1, paramArrayList1, paramObject2, paramArrayList2, paramObject3, paramArrayList3, paramMap, paramArrayList4, paramObject4, paramView2)
      {
        public boolean onPreDraw()
        {
          this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
          if (this.val$enterTransition != null)
          {
            FragmentTransitionCompat21.removeTargets(this.val$enterTransition, this.val$enteringViews);
            FragmentTransitionCompat21.access$100(this.val$enterTransition, this.val$exitTransition, this.val$exitingViews, false);
            FragmentTransitionCompat21.access$100(this.val$enterTransition, this.val$sharedElementTransition, this.val$sharedElementTargets, false);
          }
          if (this.val$exitTransition != null)
          {
            FragmentTransitionCompat21.removeTargets(this.val$exitTransition, this.val$exitingViews);
            FragmentTransitionCompat21.access$100(this.val$exitTransition, this.val$enterTransition, this.val$enteringViews, false);
            FragmentTransitionCompat21.access$100(this.val$exitTransition, this.val$sharedElementTransition, this.val$sharedElementTargets, false);
          }
          if (this.val$sharedElementTransition != null)
            FragmentTransitionCompat21.removeTargets(this.val$sharedElementTransition, this.val$sharedElementTargets);
          Iterator localIterator = this.val$renamedViews.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            ((View)localEntry.getValue()).setTransitionName((String)localEntry.getKey());
          }
          int j = this.val$hiddenViews.size();
          int i = 0;
          while (i < j)
          {
            this.val$overallTransition.excludeTarget((View)this.val$hiddenViews.get(i), false);
            i += 1;
          }
          this.val$overallTransition.excludeTarget(this.val$nonExistentView, false);
          return true;
        }
      });
  }

  public static Object cloneTransition(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject != null)
      localObject = ((Transition)paramObject).clone();
    return localObject;
  }

  private static boolean containedBeforeIndex(List<View> paramList, View paramView, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramList.get(i) == paramView)
        return true;
      i += 1;
    }
    return false;
  }

  public static void excludeSharedElementViews(Object paramObject1, Object paramObject2, Object paramObject3, ArrayList<View> paramArrayList, boolean paramBoolean)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    excludeViews(paramObject1, paramObject3, paramArrayList, paramBoolean);
    excludeViews(paramObject2, paramObject3, paramArrayList, paramBoolean);
  }

  public static void excludeTarget(Object paramObject, View paramView, boolean paramBoolean)
  {
    ((Transition)paramObject).excludeTarget(paramView, paramBoolean);
  }

  private static void excludeViews(Transition paramTransition1, Transition paramTransition2, ArrayList<View> paramArrayList, boolean paramBoolean)
  {
    if (paramTransition1 != null)
    {
      if (paramTransition2 == null);
      for (int i = 0; ; i = paramArrayList.size())
      {
        int j = 0;
        while (j < i)
        {
          paramTransition1.excludeTarget((View)paramArrayList.get(j), paramBoolean);
          j += 1;
        }
      }
    }
  }

  public static void findNamedViews(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = paramView.getTransitionName();
      if (str != null)
        paramMap.put(str, paramView);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          findNamedViews(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }

  private static Rect getBoundsOnScreen(View paramView)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    localRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    return localRect;
  }

  public static String getTransitionName(View paramView)
  {
    return paramView.getTransitionName();
  }

  private static boolean hasSimpleTarget(Transition paramTransition)
  {
    return (!isNullOrEmpty(paramTransition.getTargetIds())) || (!isNullOrEmpty(paramTransition.getTargetNames())) || (!isNullOrEmpty(paramTransition.getTargetTypes()));
  }

  private static boolean isNullOrEmpty(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }

  public static Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3, boolean paramBoolean)
  {
    boolean bool2 = true;
    Transition localTransition = (Transition)paramObject1;
    paramObject1 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    boolean bool1 = bool2;
    if (localTransition != null)
    {
      bool1 = bool2;
      if (paramObject1 != null)
        bool1 = paramBoolean;
    }
    if (bool1)
    {
      paramObject2 = new TransitionSet();
      if (localTransition != null)
        paramObject2.addTransition(localTransition);
      if (paramObject1 != null)
        paramObject2.addTransition(paramObject1);
      if (paramObject3 != null)
        paramObject2.addTransition(paramObject3);
      return paramObject2;
    }
    paramObject2 = null;
    if ((paramObject1 != null) && (localTransition != null))
      paramObject1 = new TransitionSet().addTransition(paramObject1).addTransition(localTransition).setOrdering(1);
    while (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null)
        paramObject2.addTransition(paramObject1);
      paramObject2.addTransition(paramObject3);
      return paramObject2;
      if (paramObject1 != null)
        continue;
      paramObject1 = paramObject2;
      if (localTransition == null)
        continue;
      paramObject1 = localTransition;
    }
    return paramObject1;
  }

  public static void removeTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (Transition)paramObject;
    int i;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      int j = paramObject.getTransitionCount();
      i = 0;
      while (i < j)
      {
        removeTargets(paramObject.getTransitionAt(i), paramArrayList);
        i += 1;
      }
    }
    if (!hasSimpleTarget(paramObject))
    {
      List localList = paramObject.getTargets();
      if ((localList != null) && (localList.size() == paramArrayList.size()) && (localList.containsAll(paramArrayList)))
      {
        i = paramArrayList.size() - 1;
        while (i >= 0)
        {
          paramObject.removeTarget((View)paramArrayList.get(i));
          i -= 1;
        }
      }
    }
  }

  public static void setEpicenter(Object paramObject, View paramView)
  {
    ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback(getBoundsOnScreen(paramView))
    {
      public Rect onGetEpicenter(Transition paramTransition)
      {
        return this.val$epicenter;
      }
    });
  }

  private static void setSharedElementEpicenter(Transition paramTransition, EpicenterView paramEpicenterView)
  {
    if (paramTransition != null)
      paramTransition.setEpicenterCallback(new Transition.EpicenterCallback(paramEpicenterView)
      {
        private Rect mEpicenter;

        public Rect onGetEpicenter(Transition paramTransition)
        {
          if ((this.mEpicenter == null) && (this.val$epicenterView.epicenter != null))
            this.mEpicenter = FragmentTransitionCompat21.access$200(this.val$epicenterView.epicenter);
          return this.mEpicenter;
        }
      });
  }

  public static void setSharedElementTargets(Object paramObject, View paramView, Map<String, View> paramMap, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    paramArrayList.clear();
    paramArrayList.addAll(paramMap.values());
    paramMap = paramObject.getTargets();
    paramMap.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      bfsAddViewChildren(paramMap, (View)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList.add(paramView);
    addTargets(paramObject, paramArrayList);
  }

  public static Object wrapSharedElementTransition(Object paramObject)
  {
    if (paramObject == null);
    do
    {
      return null;
      paramObject = (Transition)paramObject;
    }
    while (paramObject == null);
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition(paramObject);
    return localTransitionSet;
  }

  public static class EpicenterView
  {
    public View epicenter;
  }

  public static abstract interface ViewRetriever
  {
    public abstract View getView();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionCompat21
 * JD-Core Version:    0.6.0
 */