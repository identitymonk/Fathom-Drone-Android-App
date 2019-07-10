package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompatKK
{
  public static void setUpdateListener(View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    1 local1 = null;
    if (paramViewPropertyAnimatorUpdateListener != null)
      local1 = new ValueAnimator.AnimatorUpdateListener(paramViewPropertyAnimatorUpdateListener, paramView)
      {
        public void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          this.val$listener.onAnimationUpdate(this.val$view);
        }
      };
    paramView.animate().setUpdateListener(local1);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatKK
 * JD-Core Version:    0.6.0
 */