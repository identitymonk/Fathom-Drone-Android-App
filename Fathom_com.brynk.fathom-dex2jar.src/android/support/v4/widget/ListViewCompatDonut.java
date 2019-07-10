package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

class ListViewCompatDonut
{
  static void scrollListBy(ListView paramListView, int paramInt)
  {
    int i = paramListView.getFirstVisiblePosition();
    if (i == -1);
    View localView;
    do
    {
      return;
      localView = paramListView.getChildAt(0);
    }
    while (localView == null);
    paramListView.setSelectionFromTop(i, localView.getTop() - paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ListViewCompatDonut
 * JD-Core Version:    0.6.0
 */