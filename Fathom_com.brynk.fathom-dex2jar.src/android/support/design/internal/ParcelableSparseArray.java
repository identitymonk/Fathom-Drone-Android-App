package android.support.design.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.util.SparseArray;

public class ParcelableSparseArray extends SparseArray<Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
  {
    public ParcelableSparseArray createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new ParcelableSparseArray(paramParcel, paramClassLoader);
    }

    public ParcelableSparseArray[] newArray(int paramInt)
    {
      return new ParcelableSparseArray[paramInt];
    }
  });

  public ParcelableSparseArray()
  {
  }

  public ParcelableSparseArray(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int j = paramParcel.readInt();
    int[] arrayOfInt = new int[j];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    int i = 0;
    while (i < j)
    {
      put(arrayOfInt[i], paramParcel[i]);
      i += 1;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = size();
    int[] arrayOfInt = new int[j];
    Parcelable[] arrayOfParcelable = new Parcelable[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = keyAt(i);
      arrayOfParcelable[i] = ((Parcelable)valueAt(i));
      i += 1;
    }
    paramParcel.writeInt(j);
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.internal.ParcelableSparseArray
 * JD-Core Version:    0.6.0
 */