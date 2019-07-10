package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

public abstract class AbsSavedState
  implements Parcelable
{
  public static final Parcelable.Creator<AbsSavedState> CREATOR;
  public static final AbsSavedState EMPTY_STATE = new AbsSavedState()
  {
  };
  private final Parcelable mSuperState;

  static
  {
    CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
    {
      public AbsSavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        if (paramParcel.readParcelable(paramClassLoader) != null)
          throw new IllegalStateException("superState must be null");
        return AbsSavedState.EMPTY_STATE;
      }

      public AbsSavedState[] newArray(int paramInt)
      {
        return new AbsSavedState[paramInt];
      }
    });
  }

  private AbsSavedState()
  {
    this.mSuperState = null;
  }

  protected AbsSavedState(Parcel paramParcel)
  {
    this(paramParcel, null);
  }

  protected AbsSavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    paramParcel = paramParcel.readParcelable(paramClassLoader);
    if (paramParcel != null);
    while (true)
    {
      this.mSuperState = paramParcel;
      return;
      paramParcel = EMPTY_STATE;
    }
  }

  protected AbsSavedState(Parcelable paramParcelable)
  {
    if (paramParcelable == null)
      throw new IllegalArgumentException("superState must not be null");
    if (paramParcelable != EMPTY_STATE);
    while (true)
    {
      this.mSuperState = paramParcelable;
      return;
      paramParcelable = null;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public final Parcelable getSuperState()
  {
    return this.mSuperState;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mSuperState, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.AbsSavedState
 * JD-Core Version:    0.6.0
 */