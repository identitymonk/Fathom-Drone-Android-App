package android.support.v4.os;

import android.os.CancellationSignal;

class CancellationSignalCompatJellybean
{
  public static void cancel(Object paramObject)
  {
    ((CancellationSignal)paramObject).cancel();
  }

  public static Object create()
  {
    return new CancellationSignal();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.os.CancellationSignalCompatJellybean
 * JD-Core Version:    0.6.0
 */