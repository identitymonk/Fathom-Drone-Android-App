package com.google.android.gms.common.data;

import TT;;
import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T>
{
  private static final String[] BW = { "data" };
  private final Parcelable.Creator<T> BX;

  public zzd(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.BX = paramCreator;
  }

  public static <T extends SafeParcelable> void zza(DataHolder.zza paramzza, T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    paramT = new ContentValues();
    paramT.put("data", localParcel.marshall());
    paramzza.zza(paramT);
    localParcel.recycle();
  }

  public static DataHolder.zza zzaum()
  {
    return DataHolder.zzc(BW);
  }

  public T zzfz(int paramInt)
  {
    Object localObject = this.zy.zzg("data", paramInt, this.zy.zzga(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)this.BX.createFromParcel(localParcel);
    localParcel.recycle();
    return (TT)localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.zzd
 * JD-Core Version:    0.6.0
 */