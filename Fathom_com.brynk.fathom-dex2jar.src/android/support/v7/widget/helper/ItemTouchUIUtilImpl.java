package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R.id;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ItemTouchUIUtilImpl
{
  static class Gingerbread
    implements ItemTouchUIUtil
  {
    private void draw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2)
    {
      paramCanvas.save();
      paramCanvas.translate(paramFloat1, paramFloat2);
      paramRecyclerView.drawChild(paramCanvas, paramView, 0L);
      paramCanvas.restore();
    }

    public void clearView(View paramView)
    {
      paramView.setVisibility(0);
    }

    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      if (paramInt != 2)
        draw(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2);
    }

    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      if (paramInt == 2)
        draw(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2);
    }

    public void onSelected(View paramView)
    {
      paramView.setVisibility(4);
    }
  }

  static class Honeycomb
    implements ItemTouchUIUtil
  {
    public void clearView(View paramView)
    {
      ViewCompat.setTranslationX(paramView, 0.0F);
      ViewCompat.setTranslationY(paramView, 0.0F);
    }

    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ViewCompat.setTranslationX(paramView, paramFloat1);
      ViewCompat.setTranslationY(paramView, paramFloat2);
    }

    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
    }

    public void onSelected(View paramView)
    {
    }
  }

  static class Lollipop extends ItemTouchUIUtilImpl.Honeycomb
  {
    private float findMaxElevation(RecyclerView paramRecyclerView, View paramView)
    {
      int j = paramRecyclerView.getChildCount();
      float f1 = 0.0F;
      int i = 0;
      if (i < j)
      {
        View localView = paramRecyclerView.getChildAt(i);
        float f2;
        if (localView == paramView)
          f2 = f1;
        while (true)
        {
          i += 1;
          f1 = f2;
          break;
          float f3 = ViewCompat.getElevation(localView);
          f2 = f1;
          if (f3 <= f1)
            continue;
          f2 = f3;
        }
      }
      return f1;
    }

    public void clearView(View paramView)
    {
      Object localObject = paramView.getTag(R.id.item_touch_helper_previous_elevation);
      if ((localObject != null) && ((localObject instanceof Float)))
        ViewCompat.setElevation(paramView, ((Float)localObject).floatValue());
      paramView.setTag(R.id.item_touch_helper_previous_elevation, null);
      super.clearView(paramView);
    }

    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      if ((paramBoolean) && (paramView.getTag(R.id.item_touch_helper_previous_elevation) == null))
      {
        float f = ViewCompat.getElevation(paramView);
        ViewCompat.setElevation(paramView, 1.0F + findMaxElevation(paramRecyclerView, paramView));
        paramView.setTag(R.id.item_touch_helper_previous_elevation, Float.valueOf(f));
      }
      super.onDraw(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchUIUtilImpl
 * JD-Core Version:    0.6.0
 */