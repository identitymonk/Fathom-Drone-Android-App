package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;

public final class ContentResolverCompat
{
  private static final ContentResolverCompatImpl IMPL;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new ContentResolverCompatImplJB();
      return;
    }
    IMPL = new ContentResolverCompatImplBase();
  }

  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal)
  {
    return IMPL.query(paramContentResolver, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramCancellationSignal);
  }

  static abstract interface ContentResolverCompatImpl
  {
    public abstract Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal);
  }

  static class ContentResolverCompatImplBase
    implements ContentResolverCompat.ContentResolverCompatImpl
  {
    public Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal)
    {
      if (paramCancellationSignal != null)
        paramCancellationSignal.throwIfCanceled();
      return paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
  }

  static class ContentResolverCompatImplJB extends ContentResolverCompat.ContentResolverCompatImplBase
  {
    public Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal)
    {
      if (paramCancellationSignal != null);
      try
      {
        for (paramCancellationSignal = paramCancellationSignal.getCancellationSignalObject(); ; paramCancellationSignal = null)
        {
          paramContentResolver = ContentResolverCompatJellybean.query(paramContentResolver, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramCancellationSignal);
          return paramContentResolver;
        }
      }
      catch (java.lang.Exception paramContentResolver)
      {
        if (ContentResolverCompatJellybean.isFrameworkOperationCanceledException(paramContentResolver))
          throw new OperationCanceledException();
      }
      throw paramContentResolver;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContentResolverCompat
 * JD-Core Version:    0.6.0
 */