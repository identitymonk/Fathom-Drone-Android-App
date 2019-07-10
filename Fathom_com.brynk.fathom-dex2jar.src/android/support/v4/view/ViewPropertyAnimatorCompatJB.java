package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompatJB
{
  public static void setListener(View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (paramViewPropertyAnimatorListener != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter(paramViewPropertyAnimatorListener, paramView)
      {
        public void onAnimationCancel(Animator paramAnimator)
        {
          this.val$listener.onAnimationCancel(this.val$view);
        }

        public void onAnimationEnd(Animator paramAnimator)
        {
          this.val$listener.onAnimationEnd(this.val$view);
        }

        public void onAnimationStart(Animator paramAnimator)
        {
          this.val$listener.onAnimationStart(this.val$view);
        }
      });
      return;
    }
    paramView.animate().setListener(null);
  }

  public static void withEndAction(View paramView, Runnable paramRunnable)
  {
    paramView.animate().withEndAction(paramRunnable);
  }

  public static void withLayer(View paramView)
  {
    paramView.animate().withLayer();
  }

  public static void withStartAction(View paramView, Runnable paramRunnable)
  {
    paramView.animate().withStartAction(paramRunnable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatJB
 * JD-Core Version:    0.6.0
 */