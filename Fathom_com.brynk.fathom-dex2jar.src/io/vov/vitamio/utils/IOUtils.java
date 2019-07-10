package io.vov.vitamio.utils;

import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.Closeable;

public class IOUtils
{
  private static final String TAG = "IOUtils";

  public static void closeSilently(Cursor paramCursor)
  {
    if (paramCursor != null);
    try
    {
      paramCursor.close();
      return;
    }
    catch (java.lang.Throwable paramCursor)
    {
      Log.w("IOUtils", "fail to close", paramCursor);
    }
  }

  public static void closeSilently(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null)
      return;
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (java.lang.Throwable paramParcelFileDescriptor)
    {
      Log.w("IOUtils", "fail to close", paramParcelFileDescriptor);
    }
  }

  public static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable == null)
      return;
    try
    {
      paramCloseable.close();
      return;
    }
    catch (java.lang.Throwable paramCloseable)
    {
      Log.w("IOUtils", "fail to close", paramCloseable);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.utils.IOUtils
 * JD-Core Version:    0.6.0
 */