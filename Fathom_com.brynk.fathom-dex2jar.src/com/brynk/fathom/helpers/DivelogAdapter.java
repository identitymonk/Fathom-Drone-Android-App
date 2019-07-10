package com.brynk.fathom.helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DivelogAdapter extends BaseAdapter
{
  private String DRONE_IP;
  private Context mContext;
  private DivelogEntry[] mDataSource;
  private LayoutInflater mInflater;

  public DivelogAdapter(Context paramContext, DivelogEntry[] paramArrayOfDivelogEntry)
  {
    this.mContext = paramContext;
    this.mDataSource = paramArrayOfDivelogEntry;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    this.DRONE_IP = new Constants().getDroneIp(paramContext);
  }

  public int getCount()
  {
    return this.mDataSource.length;
  }

  public Object getItem(int paramInt)
  {
    return this.mDataSource[paramInt];
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.mInflater.inflate(2130968647, paramViewGroup, false);
    paramViewGroup = (TextView)paramView.findViewById(2131689735);
    TextView localTextView = (TextView)paramView.findViewById(2131689734);
    paramViewGroup.setText(this.mDataSource[paramInt].getWhere());
    localTextView.setText(this.mDataSource[paramInt].getWhen() + " " + this.mDataSource[paramInt].getStartTime());
    paramViewGroup = (TextView)paramView.findViewById(2131689736);
    paramViewGroup.setOnClickListener(new View.OnClickListener(paramInt)
    {
      public void onClick(View paramView)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse("http://" + DivelogAdapter.this.DRONE_IP + "/static/recordings/" + DivelogAdapter.this.mDataSource[this.val$position].getName()));
        paramView.addFlags(268435456);
        DivelogAdapter.this.mContext.startActivity(paramView);
      }
    });
    if (!this.mDataSource[paramInt].isConverted())
      paramViewGroup.setVisibility(4);
    ((TextView)paramView.findViewById(2131689737)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
      }
    });
    return paramView;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.helpers.DivelogAdapter
 * JD-Core Version:    0.6.0
 */